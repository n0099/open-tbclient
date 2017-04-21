package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.m;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    private m cgB;
    private ForumData cgC;
    private ViewGroup cgD;
    private View cgE;
    private TextView cgF;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public p(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.cgD = null;
        this.cgE = null;
        this.cgF = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.cgE = view.findViewById(w.h.frs_header_divider_ticket);
        this.cgD = (ViewGroup) view.findViewById(w.h.frs_header_ticket);
        this.cgF = (TextView) view.findViewById(w.h.frs_header_ticket_text);
        this.cgD.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        aq.j(this.cgD, w.g.frs_top_item_bg);
    }

    public void a(m mVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.cgB = mVar;
        this.cgC = forumData;
        String string = this.mContext.getString(w.l.frs_star_ticket_name);
        if (mVar != null) {
            z = mVar.bhY();
            if (com.baidu.tbadk.core.sharedPref.b.uL().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= mVar.bhZ()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = String.valueOf(forumData.getName()) + this.mContext.getString(w.l.forum) + this.mContext.getString(w.l.frs_star_ticket_name);
        }
        if (z) {
            this.cgE.setVisibility(0);
            this.cgD.setVisibility(0);
            eA(z2);
            this.cgF.setText(string);
            TiebaStatic.log("ticket_show");
            return;
        }
        this.cgE.setVisibility(8);
        this.cgD.setVisibility(8);
    }

    public ViewGroup afB() {
        return this.cgD;
    }

    public View afC() {
        return this.cgE;
    }

    private void eA(boolean z) {
        if (z) {
            this.cgF.setCompoundDrawablesWithIntrinsicBounds(0, 0, w.g.icon_news_down_bar_one, 0);
        } else {
            this.cgF.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cgD) {
            if ((this.mTbPageContext == null || this.mTbPageContext.getOrignalPage() == null || this.mTbPageContext.getOrignalPage().checkUpIsLogin()) && this.cgB != null && this.cgC != null) {
                com.baidu.tbadk.core.sharedPref.b.uL().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.cgC.getId() + TbadkCoreApplication.getCurrentAccount(), this.cgB.bhZ());
                eA(false);
                com.baidu.tbadk.browser.f.a(this.cgD.getContext(), com.baidu.adp.lib.util.j.a(this.cgF.getText(), this.mContext.getString(w.l.frs_star_ticket_name)), com.baidu.tbadk.browser.f.appendVersionCode(com.baidu.tbadk.browser.f.appendCuidParam(this.cgB.bia())), true, false, true);
            }
        }
    }
}
