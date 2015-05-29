package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    TbPageContext<FrsActivity> aRB;
    private com.baidu.tieba.tbadkCore.v aRC;
    private ForumData aRD;
    private ViewGroup aRE;
    private View aRF;
    private TextView aRG;
    private Context mContext;

    public w(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.aRE = null;
        this.aRF = null;
        this.aRG = null;
        this.mContext = view.getContext().getApplicationContext();
        this.aRB = tbPageContext;
        this.aRF = view.findViewById(com.baidu.tieba.q.frs_header_divider_ticket);
        this.aRE = (ViewGroup) view.findViewById(com.baidu.tieba.q.frs_header_ticket);
        this.aRG = (TextView) view.findViewById(com.baidu.tieba.q.frs_header_ticket_text);
        this.aRE.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        ay.i(this.aRE, com.baidu.tieba.p.frs_top_item_bg);
    }

    public void a(com.baidu.tieba.tbadkCore.v vVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.aRC = vVar;
        this.aRD = forumData;
        String string = this.mContext.getString(com.baidu.tieba.t.frs_star_ticket_name);
        if (vVar != null) {
            z = vVar.amE();
            if (com.baidu.tbadk.core.sharedPref.b.sl().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= vVar.amF()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = String.valueOf(forumData.getName()) + this.mContext.getString(com.baidu.tieba.t.forum_name_suffix) + this.mContext.getString(com.baidu.tieba.t.frs_star_ticket_name);
        }
        if (z) {
            this.aRF.setVisibility(0);
            this.aRE.setVisibility(0);
            ci(z2);
            this.aRG.setText(string);
            com.baidu.tbadk.core.k.B(this.mContext, "ticket_show");
            return;
        }
        this.aRF.setVisibility(8);
        this.aRE.setVisibility(8);
    }

    private void ci(boolean z) {
        if (z) {
            this.aRG.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.p.icon_news_down_bar_one, 0);
        } else {
            this.aRG.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aRE) {
            if ((this.aRB == null || this.aRB.getOrignalPage() == null || this.aRB.getOrignalPage().checkUpIsLogin()) && this.aRC != null && this.aRD != null) {
                com.baidu.tbadk.core.sharedPref.b.sl().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.aRD.getId() + TbadkCoreApplication.getCurrentAccount(), this.aRC.amF());
                ci(false);
                com.baidu.tbadk.browser.f.a(this.aRE.getContext(), com.baidu.adp.lib.util.m.a(this.aRG.getText(), this.mContext.getString(com.baidu.tieba.t.frs_star_ticket_name)), com.baidu.tbadk.browser.f.appendVersionCode(com.baidu.tbadk.browser.f.appendCuidParam(this.aRC.amG())), true, false, false);
            }
        }
    }
}
