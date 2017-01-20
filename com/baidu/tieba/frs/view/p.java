package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.m;
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    private m bYo;
    private ForumData bYp;
    private ViewGroup bYq;
    private View bYr;
    private TextView bYs;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public p(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.bYq = null;
        this.bYr = null;
        this.bYs = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.bYr = view.findViewById(r.h.frs_header_divider_ticket);
        this.bYq = (ViewGroup) view.findViewById(r.h.frs_header_ticket);
        this.bYs = (TextView) view.findViewById(r.h.frs_header_ticket_text);
        this.bYq.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        ap.j(this.bYq, r.g.frs_top_item_bg);
    }

    public void a(m mVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.bYo = mVar;
        this.bYp = forumData;
        String string = this.mContext.getString(r.l.frs_star_ticket_name);
        if (mVar != null) {
            z = mVar.bgx();
            if (com.baidu.tbadk.core.sharedPref.b.tQ().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= mVar.bgy()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = String.valueOf(forumData.getName()) + this.mContext.getString(r.l.forum_name_suffix) + this.mContext.getString(r.l.frs_star_ticket_name);
        }
        if (z) {
            this.bYr.setVisibility(0);
            this.bYq.setVisibility(0);
            eq(z2);
            this.bYs.setText(string);
            TiebaStatic.log("ticket_show");
            return;
        }
        this.bYr.setVisibility(8);
        this.bYq.setVisibility(8);
    }

    public ViewGroup adG() {
        return this.bYq;
    }

    public View adH() {
        return this.bYr;
    }

    private void eq(boolean z) {
        if (z) {
            this.bYs.setCompoundDrawablesWithIntrinsicBounds(0, 0, r.g.icon_news_down_bar_one, 0);
        } else {
            this.bYs.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bYq) {
            if ((this.mTbPageContext == null || this.mTbPageContext.getOrignalPage() == null || this.mTbPageContext.getOrignalPage().checkUpIsLogin()) && this.bYo != null && this.bYp != null) {
                com.baidu.tbadk.core.sharedPref.b.tQ().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.bYp.getId() + TbadkCoreApplication.getCurrentAccount(), this.bYo.bgy());
                eq(false);
                com.baidu.tbadk.browser.f.a(this.bYq.getContext(), com.baidu.adp.lib.util.j.a(this.bYs.getText(), this.mContext.getString(r.l.frs_star_ticket_name)), com.baidu.tbadk.browser.f.appendVersionCode(com.baidu.tbadk.browser.f.appendCuidParam(this.bYo.bgz())), true, false, true);
            }
        }
    }
}
