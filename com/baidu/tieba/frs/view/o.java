package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    private com.baidu.tieba.tbadkCore.o bUk;
    private ForumData bUl;
    private ViewGroup bUm;
    private View bUn;
    private TextView bUo;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public o(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.bUm = null;
        this.bUn = null;
        this.bUo = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.bUn = view.findViewById(u.g.frs_header_divider_ticket);
        this.bUm = (ViewGroup) view.findViewById(u.g.frs_header_ticket);
        this.bUo = (TextView) view.findViewById(u.g.frs_header_ticket_text);
        this.bUm.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        av.k(this.bUm, u.f.frs_top_item_bg);
    }

    public void a(com.baidu.tieba.tbadkCore.o oVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.bUk = oVar;
        this.bUl = forumData;
        String string = this.mContext.getString(u.j.frs_star_ticket_name);
        if (oVar != null) {
            z = oVar.baR();
            if (com.baidu.tbadk.core.sharedPref.b.sO().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= oVar.baS()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = String.valueOf(forumData.getName()) + this.mContext.getString(u.j.forum_name_suffix) + this.mContext.getString(u.j.frs_star_ticket_name);
        }
        if (z) {
            this.bUn.setVisibility(0);
            this.bUm.setVisibility(0);
            dQ(z2);
            this.bUo.setText(string);
            TiebaStatic.log("ticket_show");
            return;
        }
        this.bUn.setVisibility(8);
        this.bUm.setVisibility(8);
    }

    public ViewGroup aaC() {
        return this.bUm;
    }

    public View aaD() {
        return this.bUn;
    }

    private void dQ(boolean z) {
        if (z) {
            this.bUo.setCompoundDrawablesWithIntrinsicBounds(0, 0, u.f.icon_news_down_bar_one, 0);
        } else {
            this.bUo.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bUm) {
            if ((this.mTbPageContext == null || this.mTbPageContext.getOrignalPage() == null || this.mTbPageContext.getOrignalPage().checkUpIsLogin()) && this.bUk != null && this.bUl != null) {
                com.baidu.tbadk.core.sharedPref.b.sO().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.bUl.getId() + TbadkCoreApplication.getCurrentAccount(), this.bUk.baS());
                dQ(false);
                com.baidu.tbadk.browser.f.a(this.bUm.getContext(), com.baidu.adp.lib.util.j.a(this.bUo.getText(), this.mContext.getString(u.j.frs_star_ticket_name)), com.baidu.tbadk.browser.f.appendVersionCode(com.baidu.tbadk.browser.f.appendCuidParam(this.bUk.baT())), true, false, true);
            }
        }
    }
}
