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
    private m cek;
    private ForumData cel;
    private ViewGroup cem;
    private View cen;
    private TextView ceo;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public p(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.cem = null;
        this.cen = null;
        this.ceo = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.cen = view.findViewById(w.h.frs_header_divider_ticket);
        this.cem = (ViewGroup) view.findViewById(w.h.frs_header_ticket);
        this.ceo = (TextView) view.findViewById(w.h.frs_header_ticket_text);
        this.cem.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        aq.j(this.cem, w.g.frs_top_item_bg);
    }

    public void a(m mVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.cek = mVar;
        this.cel = forumData;
        String string = this.mContext.getString(w.l.frs_star_ticket_name);
        if (mVar != null) {
            z = mVar.bgX();
            if (com.baidu.tbadk.core.sharedPref.b.uL().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= mVar.bgY()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = String.valueOf(forumData.getName()) + this.mContext.getString(w.l.forum) + this.mContext.getString(w.l.frs_star_ticket_name);
        }
        if (z) {
            this.cen.setVisibility(0);
            this.cem.setVisibility(0);
            eq(z2);
            this.ceo.setText(string);
            TiebaStatic.log("ticket_show");
            return;
        }
        this.cen.setVisibility(8);
        this.cem.setVisibility(8);
    }

    public ViewGroup aeA() {
        return this.cem;
    }

    public View aeB() {
        return this.cen;
    }

    private void eq(boolean z) {
        if (z) {
            this.ceo.setCompoundDrawablesWithIntrinsicBounds(0, 0, w.g.icon_news_down_bar_one, 0);
        } else {
            this.ceo.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cem) {
            if ((this.mTbPageContext == null || this.mTbPageContext.getOrignalPage() == null || this.mTbPageContext.getOrignalPage().checkUpIsLogin()) && this.cek != null && this.cel != null) {
                com.baidu.tbadk.core.sharedPref.b.uL().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.cel.getId() + TbadkCoreApplication.getCurrentAccount(), this.cek.bgY());
                eq(false);
                com.baidu.tbadk.browser.f.a(this.cem.getContext(), com.baidu.adp.lib.util.j.a(this.ceo.getText(), this.mContext.getString(w.l.frs_star_ticket_name)), com.baidu.tbadk.browser.f.appendVersionCode(com.baidu.tbadk.browser.f.appendCuidParam(this.cek.bgZ())), true, false, true);
            }
        }
    }
}
