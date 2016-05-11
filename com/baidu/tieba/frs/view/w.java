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
public class w implements View.OnClickListener {
    private com.baidu.tieba.tbadkCore.n bwE;
    private ForumData bwF;
    private ViewGroup bwG;
    private View bwH;
    private TextView bwI;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public w(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.bwG = null;
        this.bwH = null;
        this.bwI = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.bwH = view.findViewById(t.g.frs_header_divider_ticket);
        this.bwG = (ViewGroup) view.findViewById(t.g.frs_header_ticket);
        this.bwI = (TextView) view.findViewById(t.g.frs_header_ticket_text);
        this.bwG.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        at.k(this.bwG, t.f.frs_top_item_bg);
    }

    public void a(com.baidu.tieba.tbadkCore.n nVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.bwE = nVar;
        this.bwF = forumData;
        String string = this.mContext.getString(t.j.frs_star_ticket_name);
        if (nVar != null) {
            z = nVar.aSC();
            if (com.baidu.tbadk.core.sharedPref.b.sQ().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= nVar.aSD()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = String.valueOf(forumData.getName()) + this.mContext.getString(t.j.forum_name_suffix) + this.mContext.getString(t.j.frs_star_ticket_name);
        }
        if (z) {
            this.bwH.setVisibility(0);
            this.bwG.setVisibility(0);
            dq(z2);
            this.bwI.setText(string);
            TiebaStatic.log("ticket_show");
            return;
        }
        this.bwH.setVisibility(8);
        this.bwG.setVisibility(8);
    }

    public ViewGroup Un() {
        return this.bwG;
    }

    public View Uo() {
        return this.bwH;
    }

    private void dq(boolean z) {
        if (z) {
            this.bwI.setCompoundDrawablesWithIntrinsicBounds(0, 0, t.f.icon_news_down_bar_one, 0);
        } else {
            this.bwI.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bwG) {
            if ((this.mTbPageContext == null || this.mTbPageContext.getOrignalPage() == null || this.mTbPageContext.getOrignalPage().checkUpIsLogin()) && this.bwE != null && this.bwF != null) {
                com.baidu.tbadk.core.sharedPref.b.sQ().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.bwF.getId() + TbadkCoreApplication.getCurrentAccount(), this.bwE.aSD());
                dq(false);
                com.baidu.tbadk.browser.f.a(this.bwG.getContext(), com.baidu.adp.lib.util.j.a(this.bwI.getText(), this.mContext.getString(t.j.frs_star_ticket_name)), com.baidu.tbadk.browser.f.appendVersionCode(com.baidu.tbadk.browser.f.appendCuidParam(this.bwE.aSE())), true, false, false);
            }
        }
    }
}
