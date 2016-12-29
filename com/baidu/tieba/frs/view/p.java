package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.n;
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    private n bRJ;
    private ForumData bRK;
    private ViewGroup bRL;
    private View bRM;
    private TextView bRN;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public p(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.bRL = null;
        this.bRM = null;
        this.bRN = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.bRM = view.findViewById(r.g.frs_header_divider_ticket);
        this.bRL = (ViewGroup) view.findViewById(r.g.frs_header_ticket);
        this.bRN = (TextView) view.findViewById(r.g.frs_header_ticket_text);
        this.bRL.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        ar.k(this.bRL, r.f.frs_top_item_bg);
    }

    public void a(n nVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.bRJ = nVar;
        this.bRK = forumData;
        String string = this.mContext.getString(r.j.frs_star_ticket_name);
        if (nVar != null) {
            z = nVar.beJ();
            if (com.baidu.tbadk.core.sharedPref.b.tW().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= nVar.beK()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = String.valueOf(forumData.getName()) + this.mContext.getString(r.j.forum_name_suffix) + this.mContext.getString(r.j.frs_star_ticket_name);
        }
        if (z) {
            this.bRM.setVisibility(0);
            this.bRL.setVisibility(0);
            em(z2);
            this.bRN.setText(string);
            TiebaStatic.log("ticket_show");
            return;
        }
        this.bRM.setVisibility(8);
        this.bRL.setVisibility(8);
    }

    public ViewGroup acw() {
        return this.bRL;
    }

    public View acx() {
        return this.bRM;
    }

    private void em(boolean z) {
        if (z) {
            this.bRN.setCompoundDrawablesWithIntrinsicBounds(0, 0, r.f.icon_news_down_bar_one, 0);
        } else {
            this.bRN.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bRL) {
            if ((this.mTbPageContext == null || this.mTbPageContext.getOrignalPage() == null || this.mTbPageContext.getOrignalPage().checkUpIsLogin()) && this.bRJ != null && this.bRK != null) {
                com.baidu.tbadk.core.sharedPref.b.tW().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.bRK.getId() + TbadkCoreApplication.getCurrentAccount(), this.bRJ.beK());
                em(false);
                com.baidu.tbadk.browser.f.a(this.bRL.getContext(), com.baidu.adp.lib.util.j.a(this.bRN.getText(), this.mContext.getString(r.j.frs_star_ticket_name)), com.baidu.tbadk.browser.f.appendVersionCode(com.baidu.tbadk.browser.f.appendCuidParam(this.bRJ.beL())), true, false, true);
            }
        }
    }
}
