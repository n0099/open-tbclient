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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.j;
/* loaded from: classes2.dex */
public class g implements View.OnClickListener {
    private j dZv;
    private ForumData dZw;
    private ViewGroup dZx;
    private View dZy;
    private TextView dZz;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public g(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.dZx = null;
        this.dZy = null;
        this.dZz = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.dZy = view.findViewById(d.g.frs_header_divider_ticket);
        this.dZx = (ViewGroup) view.findViewById(d.g.frs_header_ticket);
        this.dZz = (TextView) view.findViewById(d.g.frs_header_ticket_text);
        this.dZx.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        aj.s(this.dZx, d.f.frs_top_item_bg);
    }

    public void a(j jVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.dZv = jVar;
        this.dZw = forumData;
        String string = this.mContext.getString(d.j.frs_star_ticket_name);
        if (jVar != null) {
            z = jVar.bvG();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= jVar.bvH()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = forumData.getName() + this.mContext.getString(d.j.forum) + this.mContext.getString(d.j.frs_star_ticket_name);
        }
        if (z) {
            this.dZy.setVisibility(0);
            this.dZx.setVisibility(0);
            gB(z2);
            this.dZz.setText(string);
            TiebaStatic.log("ticket_show");
        } else {
            this.dZy.setVisibility(8);
            this.dZx.setVisibility(8);
        }
        this.dZy.setVisibility(8);
        this.dZx.setVisibility(8);
    }

    private void gB(boolean z) {
        if (z) {
            this.dZz.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_news_down_bar_one, 0);
        } else {
            this.dZz.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dZx) {
            if ((this.mTbPageContext == null || ay.ba(this.mTbPageContext.getPageActivity())) && this.dZv != null && this.dZw != null) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.dZw.getId() + TbadkCoreApplication.getCurrentAccount(), this.dZv.bvH());
                gB(false);
                com.baidu.tbadk.browser.b.a(this.dZx.getContext(), k.a(this.dZz.getText(), this.mContext.getString(d.j.frs_star_ticket_name)), com.baidu.tbadk.browser.b.appendVersionCode(com.baidu.tbadk.browser.b.appendCuidParam(this.dZv.bvI())), true, false, true);
            }
        }
    }
}
