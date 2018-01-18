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
import com.baidu.tieba.tbadkCore.j;
/* loaded from: classes2.dex */
public class f implements View.OnClickListener {
    private j dUX;
    private ForumData dUY;
    private ViewGroup dUZ;
    private View dVa;
    private TextView dVb;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public f(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.dUZ = null;
        this.dVa = null;
        this.dVb = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.dVa = view.findViewById(d.g.frs_header_divider_ticket);
        this.dUZ = (ViewGroup) view.findViewById(d.g.frs_header_ticket);
        this.dVb = (TextView) view.findViewById(d.g.frs_header_ticket_text);
        this.dUZ.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        aj.s(this.dUZ, d.f.frs_top_item_bg);
    }

    public void a(j jVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.dUX = jVar;
        this.dUY = forumData;
        String string = this.mContext.getString(d.j.frs_star_ticket_name);
        if (jVar != null) {
            z = jVar.buq();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= jVar.bur()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = forumData.getName() + this.mContext.getString(d.j.forum) + this.mContext.getString(d.j.frs_star_ticket_name);
        }
        if (z) {
            this.dVa.setVisibility(0);
            this.dUZ.setVisibility(0);
            go(z2);
            this.dVb.setText(string);
            TiebaStatic.log("ticket_show");
        } else {
            this.dVa.setVisibility(8);
            this.dUZ.setVisibility(8);
        }
        this.dVa.setVisibility(8);
        this.dUZ.setVisibility(8);
    }

    private void go(boolean z) {
        if (z) {
            this.dVb.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_news_down_bar_one, 0);
        } else {
            this.dVb.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dUZ) {
            if ((this.mTbPageContext == null || ax.be(this.mTbPageContext.getPageActivity())) && this.dUX != null && this.dUY != null) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.dUY.getId() + TbadkCoreApplication.getCurrentAccount(), this.dUX.bur());
                go(false);
                com.baidu.tbadk.browser.a.a(this.dUZ.getContext(), k.a(this.dVb.getText(), this.mContext.getString(d.j.frs_star_ticket_name)), com.baidu.tbadk.browser.a.appendVersionCode(com.baidu.tbadk.browser.a.appendCuidParam(this.dUX.bus())), true, false, true);
            }
        }
    }
}
