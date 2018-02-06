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
    private j dZH;
    private ForumData dZI;
    private ViewGroup dZJ;
    private View dZK;
    private TextView dZL;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public g(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.dZJ = null;
        this.dZK = null;
        this.dZL = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.dZK = view.findViewById(d.g.frs_header_divider_ticket);
        this.dZJ = (ViewGroup) view.findViewById(d.g.frs_header_ticket);
        this.dZL = (TextView) view.findViewById(d.g.frs_header_ticket_text);
        this.dZJ.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        aj.s(this.dZJ, d.f.frs_top_item_bg);
    }

    public void a(j jVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.dZH = jVar;
        this.dZI = forumData;
        String string = this.mContext.getString(d.j.frs_star_ticket_name);
        if (jVar != null) {
            z = jVar.bvH();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= jVar.bvI()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = forumData.getName() + this.mContext.getString(d.j.forum) + this.mContext.getString(d.j.frs_star_ticket_name);
        }
        if (z) {
            this.dZK.setVisibility(0);
            this.dZJ.setVisibility(0);
            gB(z2);
            this.dZL.setText(string);
            TiebaStatic.log("ticket_show");
        } else {
            this.dZK.setVisibility(8);
            this.dZJ.setVisibility(8);
        }
        this.dZK.setVisibility(8);
        this.dZJ.setVisibility(8);
    }

    private void gB(boolean z) {
        if (z) {
            this.dZL.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_news_down_bar_one, 0);
        } else {
            this.dZL.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dZJ) {
            if ((this.mTbPageContext == null || ay.ba(this.mTbPageContext.getPageActivity())) && this.dZH != null && this.dZI != null) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.dZI.getId() + TbadkCoreApplication.getCurrentAccount(), this.dZH.bvI());
                gB(false);
                com.baidu.tbadk.browser.b.a(this.dZJ.getContext(), k.a(this.dZL.getText(), this.mContext.getString(d.j.frs_star_ticket_name)), com.baidu.tbadk.browser.b.appendVersionCode(com.baidu.tbadk.browser.b.appendCuidParam(this.dZH.bvJ())), true, false, true);
            }
        }
    }
}
