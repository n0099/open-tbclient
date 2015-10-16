package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    private com.baidu.tieba.tbadkCore.n bdO;
    private ForumData bdP;
    private ViewGroup bdQ;
    private View bdR;
    private TextView bdS;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public w(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.bdQ = null;
        this.bdR = null;
        this.bdS = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.bdR = view.findViewById(i.f.frs_header_divider_ticket);
        this.bdQ = (ViewGroup) view.findViewById(i.f.frs_header_ticket);
        this.bdS = (TextView) view.findViewById(i.f.frs_header_ticket_text);
        this.bdQ.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        an.i(this.bdQ, i.e.frs_top_item_bg);
    }

    public void a(com.baidu.tieba.tbadkCore.n nVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.bdO = nVar;
        this.bdP = forumData;
        String string = this.mContext.getString(i.h.frs_star_ticket_name);
        if (nVar != null) {
            z = nVar.avN();
            if (com.baidu.tbadk.core.sharedPref.b.tu().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= nVar.avO()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = String.valueOf(forumData.getName()) + this.mContext.getString(i.h.forum_name_suffix) + this.mContext.getString(i.h.frs_star_ticket_name);
        }
        if (z) {
            this.bdR.setVisibility(0);
            this.bdQ.setVisibility(0);
            cn(z2);
            this.bdS.setText(string);
            TiebaStatic.log("ticket_show");
            return;
        }
        this.bdR.setVisibility(8);
        this.bdQ.setVisibility(8);
    }

    public ViewGroup Oe() {
        return this.bdQ;
    }

    public View Of() {
        return this.bdR;
    }

    private void cn(boolean z) {
        if (z) {
            this.bdS.setCompoundDrawablesWithIntrinsicBounds(0, 0, i.e.icon_news_down_bar_one, 0);
        } else {
            this.bdS.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bdQ) {
            if ((this.mTbPageContext == null || this.mTbPageContext.getOrignalPage() == null || this.mTbPageContext.getOrignalPage().checkUpIsLogin()) && this.bdO != null && this.bdP != null) {
                com.baidu.tbadk.core.sharedPref.b.tu().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.bdP.getId() + TbadkCoreApplication.getCurrentAccount(), this.bdO.avO());
                cn(false);
                com.baidu.tbadk.browser.g.a(this.bdQ.getContext(), com.baidu.adp.lib.util.j.a(this.bdS.getText(), this.mContext.getString(i.h.frs_star_ticket_name)), com.baidu.tbadk.browser.g.appendVersionCode(com.baidu.tbadk.browser.g.appendCuidParam(this.bdO.avP())), true, false, false);
            }
        }
    }
}
