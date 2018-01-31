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
    private j dVs;
    private ForumData dVt;
    private ViewGroup dVu;
    private View dVv;
    private TextView dVw;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public f(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.dVu = null;
        this.dVv = null;
        this.dVw = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.dVv = view.findViewById(d.g.frs_header_divider_ticket);
        this.dVu = (ViewGroup) view.findViewById(d.g.frs_header_ticket);
        this.dVw = (TextView) view.findViewById(d.g.frs_header_ticket_text);
        this.dVu.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        aj.s(this.dVu, d.f.frs_top_item_bg);
    }

    public void a(j jVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.dVs = jVar;
        this.dVt = forumData;
        String string = this.mContext.getString(d.j.frs_star_ticket_name);
        if (jVar != null) {
            z = jVar.bus();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= jVar.but()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = forumData.getName() + this.mContext.getString(d.j.forum) + this.mContext.getString(d.j.frs_star_ticket_name);
        }
        if (z) {
            this.dVv.setVisibility(0);
            this.dVu.setVisibility(0);
            gq(z2);
            this.dVw.setText(string);
            TiebaStatic.log("ticket_show");
        } else {
            this.dVv.setVisibility(8);
            this.dVu.setVisibility(8);
        }
        this.dVv.setVisibility(8);
        this.dVu.setVisibility(8);
    }

    private void gq(boolean z) {
        if (z) {
            this.dVw.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_news_down_bar_one, 0);
        } else {
            this.dVw.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dVu) {
            if ((this.mTbPageContext == null || ax.bb(this.mTbPageContext.getPageActivity())) && this.dVs != null && this.dVt != null) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.dVt.getId() + TbadkCoreApplication.getCurrentAccount(), this.dVs.but());
                gq(false);
                com.baidu.tbadk.browser.a.a(this.dVu.getContext(), k.a(this.dVw.getText(), this.mContext.getString(d.j.frs_star_ticket_name)), com.baidu.tbadk.browser.a.appendVersionCode(com.baidu.tbadk.browser.a.appendCuidParam(this.dVs.buu())), true, false, true);
            }
        }
    }
}
