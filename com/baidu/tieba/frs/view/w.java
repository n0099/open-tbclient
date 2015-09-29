package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    private com.baidu.tieba.tbadkCore.n bdD;
    private ForumData bdE;
    private ViewGroup bdF;
    private View bdG;
    private TextView bdH;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public w(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.bdF = null;
        this.bdG = null;
        this.bdH = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.bdG = view.findViewById(i.f.frs_header_divider_ticket);
        this.bdF = (ViewGroup) view.findViewById(i.f.frs_header_ticket);
        this.bdH = (TextView) view.findViewById(i.f.frs_header_ticket_text);
        this.bdF.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        am.i(this.bdF, i.e.frs_top_item_bg);
    }

    public void a(com.baidu.tieba.tbadkCore.n nVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.bdD = nVar;
        this.bdE = forumData;
        String string = this.mContext.getString(i.h.frs_star_ticket_name);
        if (nVar != null) {
            z = nVar.avH();
            if (com.baidu.tbadk.core.sharedPref.b.tu().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= nVar.avI()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = String.valueOf(forumData.getName()) + this.mContext.getString(i.h.forum_name_suffix) + this.mContext.getString(i.h.frs_star_ticket_name);
        }
        if (z) {
            this.bdG.setVisibility(0);
            this.bdF.setVisibility(0);
            cn(z2);
            this.bdH.setText(string);
            TiebaStatic.log("ticket_show");
            return;
        }
        this.bdG.setVisibility(8);
        this.bdF.setVisibility(8);
    }

    public ViewGroup Oe() {
        return this.bdF;
    }

    public View Of() {
        return this.bdG;
    }

    private void cn(boolean z) {
        if (z) {
            this.bdH.setCompoundDrawablesWithIntrinsicBounds(0, 0, i.e.icon_news_down_bar_one, 0);
        } else {
            this.bdH.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bdF) {
            if ((this.mTbPageContext == null || this.mTbPageContext.getOrignalPage() == null || this.mTbPageContext.getOrignalPage().checkUpIsLogin()) && this.bdD != null && this.bdE != null) {
                com.baidu.tbadk.core.sharedPref.b.tu().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.bdE.getId() + TbadkCoreApplication.getCurrentAccount(), this.bdD.avI());
                cn(false);
                com.baidu.tbadk.browser.g.a(this.bdF.getContext(), com.baidu.adp.lib.util.j.a(this.bdH.getText(), this.mContext.getString(i.h.frs_star_ticket_name)), com.baidu.tbadk.browser.g.appendVersionCode(com.baidu.tbadk.browser.g.appendCuidParam(this.bdD.avJ())), true, false, false);
            }
        }
    }
}
