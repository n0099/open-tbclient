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
    private com.baidu.tieba.tbadkCore.o bWk;
    private ForumData bWl;
    private ViewGroup bWm;
    private View bWn;
    private TextView bWo;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public o(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.bWm = null;
        this.bWn = null;
        this.bWo = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.bWn = view.findViewById(u.g.frs_header_divider_ticket);
        this.bWm = (ViewGroup) view.findViewById(u.g.frs_header_ticket);
        this.bWo = (TextView) view.findViewById(u.g.frs_header_ticket_text);
        this.bWm.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        av.k(this.bWm, u.f.frs_top_item_bg);
    }

    public void a(com.baidu.tieba.tbadkCore.o oVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.bWk = oVar;
        this.bWl = forumData;
        String string = this.mContext.getString(u.j.frs_star_ticket_name);
        if (oVar != null) {
            z = oVar.bef();
            if (com.baidu.tbadk.core.sharedPref.b.sN().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= oVar.beg()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = String.valueOf(forumData.getName()) + this.mContext.getString(u.j.forum_name_suffix) + this.mContext.getString(u.j.frs_star_ticket_name);
        }
        if (z) {
            this.bWn.setVisibility(0);
            this.bWm.setVisibility(0);
            dQ(z2);
            this.bWo.setText(string);
            TiebaStatic.log("ticket_show");
            return;
        }
        this.bWn.setVisibility(8);
        this.bWm.setVisibility(8);
    }

    public ViewGroup abe() {
        return this.bWm;
    }

    public View abf() {
        return this.bWn;
    }

    private void dQ(boolean z) {
        if (z) {
            this.bWo.setCompoundDrawablesWithIntrinsicBounds(0, 0, u.f.icon_news_down_bar_one, 0);
        } else {
            this.bWo.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bWm) {
            if ((this.mTbPageContext == null || this.mTbPageContext.getOrignalPage() == null || this.mTbPageContext.getOrignalPage().checkUpIsLogin()) && this.bWk != null && this.bWl != null) {
                com.baidu.tbadk.core.sharedPref.b.sN().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.bWl.getId() + TbadkCoreApplication.getCurrentAccount(), this.bWk.beg());
                dQ(false);
                com.baidu.tbadk.browser.f.a(this.bWm.getContext(), com.baidu.adp.lib.util.j.a(this.bWo.getText(), this.mContext.getString(u.j.frs_star_ticket_name)), com.baidu.tbadk.browser.f.appendVersionCode(com.baidu.tbadk.browser.f.appendCuidParam(this.bWk.beh())), true, false, true);
            }
        }
    }
}
