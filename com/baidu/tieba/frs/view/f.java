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
    private j dQj;
    private ForumData dQk;
    private ViewGroup dQl;
    private View dQm;
    private TextView dQn;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public f(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.dQl = null;
        this.dQm = null;
        this.dQn = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.dQm = view.findViewById(d.g.frs_header_divider_ticket);
        this.dQl = (ViewGroup) view.findViewById(d.g.frs_header_ticket);
        this.dQn = (TextView) view.findViewById(d.g.frs_header_ticket_text);
        this.dQl.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        aj.s(this.dQl, d.f.frs_top_item_bg);
    }

    public void a(j jVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.dQj = jVar;
        this.dQk = forumData;
        String string = this.mContext.getString(d.j.frs_star_ticket_name);
        if (jVar != null) {
            z = jVar.bAU();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= jVar.bAV()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = forumData.getName() + this.mContext.getString(d.j.forum) + this.mContext.getString(d.j.frs_star_ticket_name);
        }
        if (z) {
            this.dQm.setVisibility(0);
            this.dQl.setVisibility(0);
            gg(z2);
            this.dQn.setText(string);
            TiebaStatic.log("ticket_show");
        } else {
            this.dQm.setVisibility(8);
            this.dQl.setVisibility(8);
        }
        this.dQm.setVisibility(8);
        this.dQl.setVisibility(8);
    }

    private void gg(boolean z) {
        if (z) {
            this.dQn.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_news_down_bar_one, 0);
        } else {
            this.dQn.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dQl) {
            if ((this.mTbPageContext == null || ax.be(this.mTbPageContext.getPageActivity())) && this.dQj != null && this.dQk != null) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.dQk.getId() + TbadkCoreApplication.getCurrentAccount(), this.dQj.bAV());
                gg(false);
                com.baidu.tbadk.browser.a.a(this.dQl.getContext(), k.a(this.dQn.getText(), this.mContext.getString(d.j.frs_star_ticket_name)), com.baidu.tbadk.browser.a.appendVersionCode(com.baidu.tbadk.browser.a.appendCuidParam(this.dQj.bAW())), true, false, true);
            }
        }
    }
}
