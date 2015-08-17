package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    private com.baidu.tieba.tbadkCore.m bcZ;
    private ForumData bda;
    private ViewGroup bdb;
    private View bdc;
    private TextView bdd;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public v(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.bdb = null;
        this.bdc = null;
        this.bdd = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.bdc = view.findViewById(i.f.frs_header_divider_ticket);
        this.bdb = (ViewGroup) view.findViewById(i.f.frs_header_ticket);
        this.bdd = (TextView) view.findViewById(i.f.frs_header_ticket_text);
        this.bdb.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        al.i(this.bdb, i.e.frs_top_item_bg);
    }

    public void a(com.baidu.tieba.tbadkCore.m mVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.bcZ = mVar;
        this.bda = forumData;
        String string = this.mContext.getString(i.C0057i.frs_star_ticket_name);
        if (mVar != null) {
            z = mVar.apg();
            if (com.baidu.tbadk.core.sharedPref.b.ts().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= mVar.aph()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = String.valueOf(forumData.getName()) + this.mContext.getString(i.C0057i.forum_name_suffix) + this.mContext.getString(i.C0057i.frs_star_ticket_name);
        }
        if (z) {
            this.bdc.setVisibility(0);
            this.bdb.setVisibility(0);
            cl(z2);
            this.bdd.setText(string);
            TiebaStatic.log("ticket_show");
            return;
        }
        this.bdc.setVisibility(8);
        this.bdb.setVisibility(8);
    }

    public ViewGroup Oc() {
        return this.bdb;
    }

    public View Od() {
        return this.bdc;
    }

    private void cl(boolean z) {
        if (z) {
            this.bdd.setCompoundDrawablesWithIntrinsicBounds(0, 0, i.e.icon_news_down_bar_one, 0);
        } else {
            this.bdd.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bdb) {
            if ((this.mTbPageContext == null || this.mTbPageContext.getOrignalPage() == null || this.mTbPageContext.getOrignalPage().checkUpIsLogin()) && this.bcZ != null && this.bda != null) {
                com.baidu.tbadk.core.sharedPref.b.ts().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.bda.getId() + TbadkCoreApplication.getCurrentAccount(), this.bcZ.aph());
                cl(false);
                com.baidu.tbadk.browser.f.a(this.bdb.getContext(), com.baidu.adp.lib.util.j.a(this.bdd.getText(), this.mContext.getString(i.C0057i.frs_star_ticket_name)), com.baidu.tbadk.browser.f.appendVersionCode(com.baidu.tbadk.browser.f.appendCuidParam(this.bcZ.api())), true, false, false);
            }
        }
    }
}
