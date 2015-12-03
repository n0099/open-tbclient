package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    private com.baidu.tieba.tbadkCore.o bkY;
    private ForumData bkZ;
    private ViewGroup bla;
    private View blb;
    private TextView blc;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public w(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.bla = null;
        this.blb = null;
        this.blc = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.blb = view.findViewById(n.f.frs_header_divider_ticket);
        this.bla = (ViewGroup) view.findViewById(n.f.frs_header_ticket);
        this.blc = (TextView) view.findViewById(n.f.frs_header_ticket_text);
        this.bla.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        as.i(this.bla, n.e.frs_top_item_bg);
    }

    public void a(com.baidu.tieba.tbadkCore.o oVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.bkY = oVar;
        this.bkZ = forumData;
        String string = this.mContext.getString(n.i.frs_star_ticket_name);
        if (oVar != null) {
            z = oVar.aBZ();
            if (com.baidu.tbadk.core.sharedPref.b.tZ().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= oVar.aCa()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = String.valueOf(forumData.getName()) + this.mContext.getString(n.i.forum_name_suffix) + this.mContext.getString(n.i.frs_star_ticket_name);
        }
        if (z) {
            this.blb.setVisibility(0);
            this.bla.setVisibility(0);
            cC(z2);
            this.blc.setText(string);
            TiebaStatic.log("ticket_show");
            return;
        }
        this.blb.setVisibility(8);
        this.bla.setVisibility(8);
    }

    public ViewGroup Qc() {
        return this.bla;
    }

    public View Qd() {
        return this.blb;
    }

    private void cC(boolean z) {
        if (z) {
            this.blc.setCompoundDrawablesWithIntrinsicBounds(0, 0, n.e.icon_news_down_bar_one, 0);
        } else {
            this.blc.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bla) {
            if ((this.mTbPageContext == null || this.mTbPageContext.getOrignalPage() == null || this.mTbPageContext.getOrignalPage().checkUpIsLogin()) && this.bkY != null && this.bkZ != null) {
                com.baidu.tbadk.core.sharedPref.b.tZ().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.bkZ.getId() + TbadkCoreApplication.getCurrentAccount(), this.bkY.aCa());
                cC(false);
                com.baidu.tbadk.browser.f.a(this.bla.getContext(), com.baidu.adp.lib.util.j.a(this.blc.getText(), this.mContext.getString(n.i.frs_star_ticket_name)), com.baidu.tbadk.browser.f.appendVersionCode(com.baidu.tbadk.browser.f.appendCuidParam(this.bkY.aCb())), true, false, false);
            }
        }
    }
}
