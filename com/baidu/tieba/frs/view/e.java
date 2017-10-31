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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.h;
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    private h cTm;
    private ForumData cTn;
    private ViewGroup cTo;
    private View cTp;
    private TextView cTq;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public e(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.cTo = null;
        this.cTp = null;
        this.cTq = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.cTp = view.findViewById(d.g.frs_header_divider_ticket);
        this.cTo = (ViewGroup) view.findViewById(d.g.frs_header_ticket);
        this.cTq = (TextView) view.findViewById(d.g.frs_header_ticket_text);
        this.cTo.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        aj.j(this.cTo, d.f.frs_top_item_bg);
    }

    public void a(h hVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.cTm = hVar;
        this.cTn = forumData;
        String string = this.mContext.getString(d.j.frs_star_ticket_name);
        if (hVar != null) {
            z = hVar.bth();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= hVar.bti()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = forumData.getName() + this.mContext.getString(d.j.forum) + this.mContext.getString(d.j.frs_star_ticket_name);
        }
        if (z) {
            this.cTp.setVisibility(0);
            this.cTo.setVisibility(0);
            fi(z2);
            this.cTq.setText(string);
            TiebaStatic.log("ticket_show");
        } else {
            this.cTp.setVisibility(8);
            this.cTo.setVisibility(8);
        }
        this.cTp.setVisibility(8);
        this.cTo.setVisibility(8);
    }

    private void fi(boolean z) {
        if (z) {
            this.cTq.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_news_down_bar_one, 0);
        } else {
            this.cTq.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cTo) {
            if ((this.mTbPageContext == null || ax.aT(this.mTbPageContext.getPageActivity())) && this.cTm != null && this.cTn != null) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.cTn.getId() + TbadkCoreApplication.getCurrentAccount(), this.cTm.bti());
                fi(false);
                com.baidu.tbadk.browser.a.a(this.cTo.getContext(), k.a(this.cTq.getText(), this.mContext.getString(d.j.frs_star_ticket_name)), com.baidu.tbadk.browser.a.appendVersionCode(com.baidu.tbadk.browser.a.appendCuidParam(this.cTm.btj())), true, false, true);
            }
        }
    }
}
