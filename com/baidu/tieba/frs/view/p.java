package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    private ForumData cmA;
    private ViewGroup cmB;
    private View cmC;
    private TextView cmD;
    private com.baidu.tieba.tbadkCore.o cmz;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public p(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.cmB = null;
        this.cmC = null;
        this.cmD = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.cmC = view.findViewById(r.g.frs_header_divider_ticket);
        this.cmB = (ViewGroup) view.findViewById(r.g.frs_header_ticket);
        this.cmD = (TextView) view.findViewById(r.g.frs_header_ticket_text);
        this.cmB.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        at.k(this.cmB, r.f.frs_top_item_bg);
    }

    public void a(com.baidu.tieba.tbadkCore.o oVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.cmz = oVar;
        this.cmA = forumData;
        String string = this.mContext.getString(r.j.frs_star_ticket_name);
        if (oVar != null) {
            z = oVar.bkS();
            if (com.baidu.tbadk.core.sharedPref.b.um().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= oVar.bkT()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = String.valueOf(forumData.getName()) + this.mContext.getString(r.j.forum_name_suffix) + this.mContext.getString(r.j.frs_star_ticket_name);
        }
        if (z) {
            this.cmC.setVisibility(0);
            this.cmB.setVisibility(0);
            eC(z2);
            this.cmD.setText(string);
            TiebaStatic.log("ticket_show");
            return;
        }
        this.cmC.setVisibility(8);
        this.cmB.setVisibility(8);
    }

    public ViewGroup ahY() {
        return this.cmB;
    }

    public View ahZ() {
        return this.cmC;
    }

    private void eC(boolean z) {
        if (z) {
            this.cmD.setCompoundDrawablesWithIntrinsicBounds(0, 0, r.f.icon_news_down_bar_one, 0);
        } else {
            this.cmD.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cmB) {
            if ((this.mTbPageContext == null || this.mTbPageContext.getOrignalPage() == null || this.mTbPageContext.getOrignalPage().checkUpIsLogin()) && this.cmz != null && this.cmA != null) {
                com.baidu.tbadk.core.sharedPref.b.um().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.cmA.getId() + TbadkCoreApplication.getCurrentAccount(), this.cmz.bkT());
                eC(false);
                com.baidu.tbadk.browser.f.a(this.cmB.getContext(), com.baidu.adp.lib.util.j.a(this.cmD.getText(), this.mContext.getString(r.j.frs_star_ticket_name)), com.baidu.tbadk.browser.f.appendVersionCode(com.baidu.tbadk.browser.f.appendCuidParam(this.cmz.bkU())), true, false, true);
            }
        }
    }
}
