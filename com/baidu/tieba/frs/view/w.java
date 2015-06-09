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
    TbPageContext<FrsActivity> aRC;
    private com.baidu.tieba.tbadkCore.v aRD;
    private ForumData aRE;
    private ViewGroup aRF;
    private View aRG;
    private TextView aRH;
    private Context mContext;

    public w(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.aRF = null;
        this.aRG = null;
        this.aRH = null;
        this.mContext = view.getContext().getApplicationContext();
        this.aRC = tbPageContext;
        this.aRG = view.findViewById(com.baidu.tieba.q.frs_header_divider_ticket);
        this.aRF = (ViewGroup) view.findViewById(com.baidu.tieba.q.frs_header_ticket);
        this.aRH = (TextView) view.findViewById(com.baidu.tieba.q.frs_header_ticket_text);
        this.aRF.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        ay.i(this.aRF, com.baidu.tieba.p.frs_top_item_bg);
    }

    public void a(com.baidu.tieba.tbadkCore.v vVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.aRD = vVar;
        this.aRE = forumData;
        String string = this.mContext.getString(com.baidu.tieba.t.frs_star_ticket_name);
        if (vVar != null) {
            z = vVar.amF();
            if (com.baidu.tbadk.core.sharedPref.b.sl().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= vVar.amG()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = String.valueOf(forumData.getName()) + this.mContext.getString(com.baidu.tieba.t.forum_name_suffix) + this.mContext.getString(com.baidu.tieba.t.frs_star_ticket_name);
        }
        if (z) {
            this.aRG.setVisibility(0);
            this.aRF.setVisibility(0);
            ci(z2);
            this.aRH.setText(string);
            com.baidu.tbadk.core.k.B(this.mContext, "ticket_show");
            return;
        }
        this.aRG.setVisibility(8);
        this.aRF.setVisibility(8);
    }

    private void ci(boolean z) {
        if (z) {
            this.aRH.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.p.icon_news_down_bar_one, 0);
        } else {
            this.aRH.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aRF) {
            if ((this.aRC == null || this.aRC.getOrignalPage() == null || this.aRC.getOrignalPage().checkUpIsLogin()) && this.aRD != null && this.aRE != null) {
                com.baidu.tbadk.core.sharedPref.b.sl().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.aRE.getId() + TbadkCoreApplication.getCurrentAccount(), this.aRD.amG());
                ci(false);
                com.baidu.tbadk.browser.f.a(this.aRF.getContext(), com.baidu.adp.lib.util.m.a(this.aRH.getText(), this.mContext.getString(com.baidu.tieba.t.frs_star_ticket_name)), com.baidu.tbadk.browser.f.appendVersionCode(com.baidu.tbadk.browser.f.appendCuidParam(this.aRD.amH())), true, false, false);
            }
        }
    }
}
