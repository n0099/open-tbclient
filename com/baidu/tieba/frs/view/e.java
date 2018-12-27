package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.j;
/* loaded from: classes6.dex */
public class e implements View.OnClickListener {
    private j ekL;
    private ForumData ekM;
    private ViewGroup ekN;
    private View ekO;
    private TextView ekP;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public e(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.ekN = null;
        this.ekO = null;
        this.ekP = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.ekO = view.findViewById(e.g.frs_header_divider_ticket);
        this.ekN = (ViewGroup) view.findViewById(e.g.frs_header_ticket);
        this.ekP = (TextView) view.findViewById(e.g.frs_header_ticket_text);
        this.ekN.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        al.i(this.ekN, e.f.frs_top_item_bg);
    }

    public void a(j jVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.ekL = jVar;
        this.ekM = forumData;
        String string = this.mContext.getString(e.j.frs_star_ticket_name);
        if (jVar != null) {
            z = jVar.bCU();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= jVar.bCV()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = forumData.getName() + this.mContext.getString(e.j.forum) + this.mContext.getString(e.j.frs_star_ticket_name);
        }
        if (z) {
            this.ekO.setVisibility(0);
            this.ekN.setVisibility(0);
            hD(z2);
            this.ekP.setText(string);
            TiebaStatic.log("ticket_show");
        } else {
            this.ekO.setVisibility(8);
            this.ekN.setVisibility(8);
        }
        this.ekO.setVisibility(8);
        this.ekN.setVisibility(8);
    }

    private void hD(boolean z) {
        if (z) {
            this.ekP.setCompoundDrawablesWithIntrinsicBounds(0, 0, e.f.icon_news_down_bar_one, 0);
        } else {
            this.ekP.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ekN) {
            if ((this.mTbPageContext == null || ba.bJ(this.mTbPageContext.getPageActivity())) && this.ekL != null && this.ekM != null) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.ekM.getId() + TbadkCoreApplication.getCurrentAccount(), this.ekL.bCV());
                hD(false);
                com.baidu.tbadk.browser.a.a(this.ekN.getContext(), k.a(this.ekP.getText(), this.mContext.getString(e.j.frs_star_ticket_name)), com.baidu.tbadk.browser.a.appendVersionCode(com.baidu.tbadk.browser.a.appendCuidParam(this.ekL.bCW())), true, false, true);
            }
        }
    }
}
