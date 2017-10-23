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
    private h cKa;
    private ForumData cKb;
    private ViewGroup cKc;
    private View cKd;
    private TextView cKe;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public e(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.cKc = null;
        this.cKd = null;
        this.cKe = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.cKd = view.findViewById(d.h.frs_header_divider_ticket);
        this.cKc = (ViewGroup) view.findViewById(d.h.frs_header_ticket);
        this.cKe = (TextView) view.findViewById(d.h.frs_header_ticket_text);
        this.cKc.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        aj.j(this.cKc, d.g.frs_top_item_bg);
    }

    public void a(h hVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.cKa = hVar;
        this.cKb = forumData;
        String string = this.mContext.getString(d.l.frs_star_ticket_name);
        if (hVar != null) {
            z = hVar.bqc();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= hVar.bqd()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = forumData.getName() + this.mContext.getString(d.l.forum) + this.mContext.getString(d.l.frs_star_ticket_name);
        }
        if (z) {
            this.cKd.setVisibility(0);
            this.cKc.setVisibility(0);
            fj(z2);
            this.cKe.setText(string);
            TiebaStatic.log("ticket_show");
        } else {
            this.cKd.setVisibility(8);
            this.cKc.setVisibility(8);
        }
        this.cKd.setVisibility(8);
        this.cKc.setVisibility(8);
    }

    private void fj(boolean z) {
        if (z) {
            this.cKe.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.g.icon_news_down_bar_one, 0);
        } else {
            this.cKe.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cKc) {
            if ((this.mTbPageContext == null || ax.aT(this.mTbPageContext.getPageActivity())) && this.cKa != null && this.cKb != null) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.cKb.getId() + TbadkCoreApplication.getCurrentAccount(), this.cKa.bqd());
                fj(false);
                com.baidu.tbadk.browser.a.a(this.cKc.getContext(), k.a(this.cKe.getText(), this.mContext.getString(d.l.frs_star_ticket_name)), com.baidu.tbadk.browser.a.appendVersionCode(com.baidu.tbadk.browser.a.appendCuidParam(this.cKa.bqe())), true, false, true);
            }
        }
    }
}
