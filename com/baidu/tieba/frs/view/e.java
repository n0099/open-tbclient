package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.h;
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    private h cIC;
    private ForumData cID;
    private ViewGroup cIE;
    private View cIF;
    private TextView cIG;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public e(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.cIE = null;
        this.cIF = null;
        this.cIG = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.cIF = view.findViewById(d.h.frs_header_divider_ticket);
        this.cIE = (ViewGroup) view.findViewById(d.h.frs_header_ticket);
        this.cIG = (TextView) view.findViewById(d.h.frs_header_ticket_text);
        this.cIE.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        aj.j(this.cIE, d.g.frs_top_item_bg);
    }

    public void a(h hVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.cIC = hVar;
        this.cID = forumData;
        String string = this.mContext.getString(d.l.frs_star_ticket_name);
        if (hVar != null) {
            z = hVar.brc();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= hVar.brd()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = forumData.getName() + this.mContext.getString(d.l.forum) + this.mContext.getString(d.l.frs_star_ticket_name);
        }
        if (z) {
            this.cIF.setVisibility(0);
            this.cIE.setVisibility(0);
            fp(z2);
            this.cIG.setText(string);
            TiebaStatic.log("ticket_show");
        } else {
            this.cIF.setVisibility(8);
            this.cIE.setVisibility(8);
        }
        this.cIF.setVisibility(8);
        this.cIE.setVisibility(8);
    }

    private void fp(boolean z) {
        if (z) {
            this.cIG.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.g.icon_news_down_bar_one, 0);
        } else {
            this.cIG.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cIE) {
            if ((this.mTbPageContext == null || ax.aT(this.mTbPageContext.getPageActivity())) && this.cIC != null && this.cID != null) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.cID.getId() + TbadkCoreApplication.getCurrentAccount(), this.cIC.brd());
                fp(false);
                com.baidu.tbadk.browser.a.a(this.cIE.getContext(), j.a(this.cIG.getText(), this.mContext.getString(d.l.frs_star_ticket_name)), com.baidu.tbadk.browser.a.appendVersionCode(com.baidu.tbadk.browser.a.appendCuidParam(this.cIC.bre())), true, false, true);
            }
        }
    }
}
