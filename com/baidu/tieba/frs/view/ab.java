package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    private com.baidu.tieba.tbadkCore.n bwU;
    private ForumData bwV;
    private ViewGroup bwW;
    private View bwX;
    private TextView bwY;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public ab(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.bwW = null;
        this.bwX = null;
        this.bwY = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.bwX = view.findViewById(t.g.frs_header_divider_ticket);
        this.bwW = (ViewGroup) view.findViewById(t.g.frs_header_ticket);
        this.bwY = (TextView) view.findViewById(t.g.frs_header_ticket_text);
        this.bwW.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        at.k(this.bwW, t.f.frs_top_item_bg);
    }

    public void a(com.baidu.tieba.tbadkCore.n nVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.bwU = nVar;
        this.bwV = forumData;
        String string = this.mContext.getString(t.j.frs_star_ticket_name);
        if (nVar != null) {
            z = nVar.aSd();
            if (com.baidu.tbadk.core.sharedPref.b.vk().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= nVar.aSe()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = String.valueOf(forumData.getName()) + this.mContext.getString(t.j.forum_name_suffix) + this.mContext.getString(t.j.frs_star_ticket_name);
        }
        if (z) {
            this.bwX.setVisibility(0);
            this.bwW.setVisibility(0);
            cQ(z2);
            this.bwY.setText(string);
            TiebaStatic.log("ticket_show");
            return;
        }
        this.bwX.setVisibility(8);
        this.bwW.setVisibility(8);
    }

    public ViewGroup Up() {
        return this.bwW;
    }

    public View Uq() {
        return this.bwX;
    }

    private void cQ(boolean z) {
        if (z) {
            this.bwY.setCompoundDrawablesWithIntrinsicBounds(0, 0, t.f.icon_news_down_bar_one, 0);
        } else {
            this.bwY.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bwW) {
            if ((this.mTbPageContext == null || this.mTbPageContext.getOrignalPage() == null || this.mTbPageContext.getOrignalPage().checkUpIsLogin()) && this.bwU != null && this.bwV != null) {
                com.baidu.tbadk.core.sharedPref.b.vk().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.bwV.getId() + TbadkCoreApplication.getCurrentAccount(), this.bwU.aSe());
                cQ(false);
                com.baidu.tbadk.browser.f.a(this.bwW.getContext(), com.baidu.adp.lib.util.j.a(this.bwY.getText(), this.mContext.getString(t.j.frs_star_ticket_name)), com.baidu.tbadk.browser.f.appendVersionCode(com.baidu.tbadk.browser.f.appendCuidParam(this.bwU.aSf())), true, false, false);
            }
        }
    }
}
