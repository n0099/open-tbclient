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
    private h cKm;
    private ForumData cKn;
    private ViewGroup cKo;
    private View cKp;
    private TextView cKq;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public e(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.cKo = null;
        this.cKp = null;
        this.cKq = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.cKp = view.findViewById(d.h.frs_header_divider_ticket);
        this.cKo = (ViewGroup) view.findViewById(d.h.frs_header_ticket);
        this.cKq = (TextView) view.findViewById(d.h.frs_header_ticket_text);
        this.cKo.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        aj.j(this.cKo, d.g.frs_top_item_bg);
    }

    public void a(h hVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.cKm = hVar;
        this.cKn = forumData;
        String string = this.mContext.getString(d.l.frs_star_ticket_name);
        if (hVar != null) {
            z = hVar.bqj();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= hVar.bqk()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = forumData.getName() + this.mContext.getString(d.l.forum) + this.mContext.getString(d.l.frs_star_ticket_name);
        }
        if (z) {
            this.cKp.setVisibility(0);
            this.cKo.setVisibility(0);
            fk(z2);
            this.cKq.setText(string);
            TiebaStatic.log("ticket_show");
        } else {
            this.cKp.setVisibility(8);
            this.cKo.setVisibility(8);
        }
        this.cKp.setVisibility(8);
        this.cKo.setVisibility(8);
    }

    private void fk(boolean z) {
        if (z) {
            this.cKq.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.g.icon_news_down_bar_one, 0);
        } else {
            this.cKq.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cKo) {
            if ((this.mTbPageContext == null || ax.aU(this.mTbPageContext.getPageActivity())) && this.cKm != null && this.cKn != null) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.cKn.getId() + TbadkCoreApplication.getCurrentAccount(), this.cKm.bqk());
                fk(false);
                com.baidu.tbadk.browser.a.a(this.cKo.getContext(), k.a(this.cKq.getText(), this.mContext.getString(d.l.frs_star_ticket_name)), com.baidu.tbadk.browser.a.appendVersionCode(com.baidu.tbadk.browser.a.appendCuidParam(this.cKm.bql())), true, false, true);
            }
        }
    }
}
