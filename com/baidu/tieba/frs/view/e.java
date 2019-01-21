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
    private j els;
    private ForumData elt;
    private ViewGroup elu;
    private View elv;
    private TextView elw;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public e(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.elu = null;
        this.elv = null;
        this.elw = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.elv = view.findViewById(e.g.frs_header_divider_ticket);
        this.elu = (ViewGroup) view.findViewById(e.g.frs_header_ticket);
        this.elw = (TextView) view.findViewById(e.g.frs_header_ticket_text);
        this.elu.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        al.i(this.elu, e.f.frs_top_item_bg);
    }

    public void a(j jVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.els = jVar;
        this.elt = forumData;
        String string = this.mContext.getString(e.j.frs_star_ticket_name);
        if (jVar != null) {
            z = jVar.bDD();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= jVar.bDE()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = forumData.getName() + this.mContext.getString(e.j.forum) + this.mContext.getString(e.j.frs_star_ticket_name);
        }
        if (z) {
            this.elv.setVisibility(0);
            this.elu.setVisibility(0);
            hD(z2);
            this.elw.setText(string);
            TiebaStatic.log("ticket_show");
        } else {
            this.elv.setVisibility(8);
            this.elu.setVisibility(8);
        }
        this.elv.setVisibility(8);
        this.elu.setVisibility(8);
    }

    private void hD(boolean z) {
        if (z) {
            this.elw.setCompoundDrawablesWithIntrinsicBounds(0, 0, e.f.icon_news_down_bar_one, 0);
        } else {
            this.elw.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.elu) {
            if ((this.mTbPageContext == null || ba.bJ(this.mTbPageContext.getPageActivity())) && this.els != null && this.elt != null) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.elt.getId() + TbadkCoreApplication.getCurrentAccount(), this.els.bDE());
                hD(false);
                com.baidu.tbadk.browser.a.a(this.elu.getContext(), k.a(this.elw.getText(), this.mContext.getString(e.j.frs_star_ticket_name)), com.baidu.tbadk.browser.a.appendVersionCode(com.baidu.tbadk.browser.a.appendCuidParam(this.els.bDF())), true, false, true);
            }
        }
    }
}
