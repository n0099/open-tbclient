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
    private m cfK;
    private ForumData cfL;
    private ViewGroup cfM;
    private View cfN;
    private TextView cfO;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public p(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.cfM = null;
        this.cfN = null;
        this.cfO = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.cfN = view.findViewById(w.h.frs_header_divider_ticket);
        this.cfM = (ViewGroup) view.findViewById(w.h.frs_header_ticket);
        this.cfO = (TextView) view.findViewById(w.h.frs_header_ticket_text);
        this.cfM.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        aq.j(this.cfM, w.g.frs_top_item_bg);
    }

    public void a(m mVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.cfK = mVar;
        this.cfL = forumData;
        String string = this.mContext.getString(w.l.frs_star_ticket_name);
        if (mVar != null) {
            z = mVar.bgk();
            if (com.baidu.tbadk.core.sharedPref.b.uo().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= mVar.bgl()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = String.valueOf(forumData.getName()) + this.mContext.getString(w.l.forum_name_suffix) + this.mContext.getString(w.l.frs_star_ticket_name);
        }
        if (z) {
            this.cfN.setVisibility(0);
            this.cfM.setVisibility(0);
            eq(z2);
            this.cfO.setText(string);
            TiebaStatic.log("ticket_show");
            return;
        }
        this.cfN.setVisibility(8);
        this.cfM.setVisibility(8);
    }

    public ViewGroup aeG() {
        return this.cfM;
    }

    public View aeH() {
        return this.cfN;
    }

    private void eq(boolean z) {
        if (z) {
            this.cfO.setCompoundDrawablesWithIntrinsicBounds(0, 0, w.g.icon_news_down_bar_one, 0);
        } else {
            this.cfO.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cfM) {
            if ((this.mTbPageContext == null || this.mTbPageContext.getOrignalPage() == null || this.mTbPageContext.getOrignalPage().checkUpIsLogin()) && this.cfK != null && this.cfL != null) {
                com.baidu.tbadk.core.sharedPref.b.uo().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.cfL.getId() + TbadkCoreApplication.getCurrentAccount(), this.cfK.bgl());
                eq(false);
                com.baidu.tbadk.browser.f.a(this.cfM.getContext(), com.baidu.adp.lib.util.j.a(this.cfO.getText(), this.mContext.getString(w.l.frs_star_ticket_name)), com.baidu.tbadk.browser.f.appendVersionCode(com.baidu.tbadk.browser.f.appendCuidParam(this.cfK.bgm())), true, false, true);
            }
        }
    }
}
