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
    private com.baidu.tieba.tbadkCore.o boP;
    private ForumData boQ;
    private ViewGroup boR;
    private View boS;
    private TextView boT;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public w(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.boR = null;
        this.boS = null;
        this.boT = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.boS = view.findViewById(n.g.frs_header_divider_ticket);
        this.boR = (ViewGroup) view.findViewById(n.g.frs_header_ticket);
        this.boT = (TextView) view.findViewById(n.g.frs_header_ticket_text);
        this.boR.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        as.i(this.boR, n.f.frs_top_item_bg);
    }

    public void a(com.baidu.tieba.tbadkCore.o oVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.boP = oVar;
        this.boQ = forumData;
        String string = this.mContext.getString(n.j.frs_star_ticket_name);
        if (oVar != null) {
            z = oVar.aEh();
            if (com.baidu.tbadk.core.sharedPref.b.tJ().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= oVar.aEi()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = String.valueOf(forumData.getName()) + this.mContext.getString(n.j.forum_name_suffix) + this.mContext.getString(n.j.frs_star_ticket_name);
        }
        if (z) {
            this.boS.setVisibility(0);
            this.boR.setVisibility(0);
            cD(z2);
            this.boT.setText(string);
            TiebaStatic.log("ticket_show");
            return;
        }
        this.boS.setVisibility(8);
        this.boR.setVisibility(8);
    }

    public ViewGroup Qu() {
        return this.boR;
    }

    public View Qv() {
        return this.boS;
    }

    private void cD(boolean z) {
        if (z) {
            this.boT.setCompoundDrawablesWithIntrinsicBounds(0, 0, n.f.icon_news_down_bar_one, 0);
        } else {
            this.boT.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.boR) {
            if ((this.mTbPageContext == null || this.mTbPageContext.getOrignalPage() == null || this.mTbPageContext.getOrignalPage().checkUpIsLogin()) && this.boP != null && this.boQ != null) {
                com.baidu.tbadk.core.sharedPref.b.tJ().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.boQ.getId() + TbadkCoreApplication.getCurrentAccount(), this.boP.aEi());
                cD(false);
                com.baidu.tbadk.browser.f.a(this.boR.getContext(), com.baidu.adp.lib.util.j.a(this.boT.getText(), this.mContext.getString(n.j.frs_star_ticket_name)), com.baidu.tbadk.browser.f.appendVersionCode(com.baidu.tbadk.browser.f.appendCuidParam(this.boP.aEj())), true, false, false);
            }
        }
    }
}
