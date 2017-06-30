package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.g;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    private com.baidu.tieba.tbadkCore.m crL;
    private ForumData crM;
    private ViewGroup crN;
    private View crO;
    private TextView crP;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public j(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.crN = null;
        this.crO = null;
        this.crP = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.crO = view.findViewById(w.h.frs_header_divider_ticket);
        this.crN = (ViewGroup) view.findViewById(w.h.frs_header_ticket);
        this.crP = (TextView) view.findViewById(w.h.frs_header_ticket_text);
        this.crN.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        as.j(this.crN, w.g.frs_top_item_bg);
    }

    public void a(com.baidu.tieba.tbadkCore.m mVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.crL = mVar;
        this.crM = forumData;
        String string = this.mContext.getString(w.l.frs_star_ticket_name);
        if (mVar != null) {
            z = mVar.bli();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= mVar.blj()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = String.valueOf(forumData.getName()) + this.mContext.getString(w.l.forum) + this.mContext.getString(w.l.frs_star_ticket_name);
        }
        if (z) {
            this.crO.setVisibility(0);
            this.crN.setVisibility(0);
            eT(z2);
            this.crP.setText(string);
            TiebaStatic.log("ticket_show");
        } else {
            this.crO.setVisibility(8);
            this.crN.setVisibility(8);
        }
        this.crO.setVisibility(8);
        this.crN.setVisibility(8);
    }

    public ViewGroup aib() {
        return this.crN;
    }

    public View aic() {
        return this.crO;
    }

    private void eT(boolean z) {
        if (z) {
            this.crP.setCompoundDrawablesWithIntrinsicBounds(0, 0, w.g.icon_news_down_bar_one, 0);
        } else {
            this.crP.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.crN) {
            if ((this.mTbPageContext == null || bl.aN(this.mTbPageContext.getPageActivity())) && this.crL != null && this.crM != null) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.crM.getId() + TbadkCoreApplication.getCurrentAccount(), this.crL.blj());
                eT(false);
                g.a(this.crN.getContext(), com.baidu.adp.lib.util.j.a(this.crP.getText(), this.mContext.getString(w.l.frs_star_ticket_name)), g.appendVersionCode(g.appendCuidParam(this.crL.blk())), true, false, true);
            }
        }
    }
}
