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
    private com.baidu.tieba.tbadkCore.n bdu;
    private ForumData bdv;
    private ViewGroup bdw;
    private View bdx;
    private TextView bdy;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public v(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.bdw = null;
        this.bdx = null;
        this.bdy = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.bdx = view.findViewById(i.f.frs_header_divider_ticket);
        this.bdw = (ViewGroup) view.findViewById(i.f.frs_header_ticket);
        this.bdy = (TextView) view.findViewById(i.f.frs_header_ticket_text);
        this.bdw.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        al.h(this.bdw, i.e.frs_top_item_bg);
    }

    public void a(com.baidu.tieba.tbadkCore.n nVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.bdu = nVar;
        this.bdv = forumData;
        String string = this.mContext.getString(i.h.frs_star_ticket_name);
        if (nVar != null) {
            z = nVar.atr();
            if (com.baidu.tbadk.core.sharedPref.b.tx().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= nVar.ats()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = String.valueOf(forumData.getName()) + this.mContext.getString(i.h.forum_name_suffix) + this.mContext.getString(i.h.frs_star_ticket_name);
        }
        if (z) {
            this.bdx.setVisibility(0);
            this.bdw.setVisibility(0);
            cq(z2);
            this.bdy.setText(string);
            TiebaStatic.log("ticket_show");
            return;
        }
        this.bdx.setVisibility(8);
        this.bdw.setVisibility(8);
    }

    public ViewGroup Od() {
        return this.bdw;
    }

    public View Oe() {
        return this.bdx;
    }

    private void cq(boolean z) {
        if (z) {
            this.bdy.setCompoundDrawablesWithIntrinsicBounds(0, 0, i.e.icon_news_down_bar_one, 0);
        } else {
            this.bdy.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bdw) {
            if ((this.mTbPageContext == null || this.mTbPageContext.getOrignalPage() == null || this.mTbPageContext.getOrignalPage().checkUpIsLogin()) && this.bdu != null && this.bdv != null) {
                com.baidu.tbadk.core.sharedPref.b.tx().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.bdv.getId() + TbadkCoreApplication.getCurrentAccount(), this.bdu.ats());
                cq(false);
                com.baidu.tbadk.browser.g.a(this.bdw.getContext(), com.baidu.adp.lib.util.j.a(this.bdy.getText(), this.mContext.getString(i.h.frs_star_ticket_name)), com.baidu.tbadk.browser.g.appendVersionCode(com.baidu.tbadk.browser.g.appendCuidParam(this.bdu.att())), true, false, false);
            }
        }
    }
}
