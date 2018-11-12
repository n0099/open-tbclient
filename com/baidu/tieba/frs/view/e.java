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
    private j ebs;
    private ForumData ebt;
    private ViewGroup ebu;
    private View ebv;
    private TextView ebw;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public e(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.ebu = null;
        this.ebv = null;
        this.ebw = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.ebv = view.findViewById(e.g.frs_header_divider_ticket);
        this.ebu = (ViewGroup) view.findViewById(e.g.frs_header_ticket);
        this.ebw = (TextView) view.findViewById(e.g.frs_header_ticket_text);
        this.ebu.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        al.i(this.ebu, e.f.frs_top_item_bg);
    }

    public void a(j jVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.ebs = jVar;
        this.ebt = forumData;
        String string = this.mContext.getString(e.j.frs_star_ticket_name);
        if (jVar != null) {
            z = jVar.bAj();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= jVar.bAk()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = forumData.getName() + this.mContext.getString(e.j.forum) + this.mContext.getString(e.j.frs_star_ticket_name);
        }
        if (z) {
            this.ebv.setVisibility(0);
            this.ebu.setVisibility(0);
            hy(z2);
            this.ebw.setText(string);
            TiebaStatic.log("ticket_show");
        } else {
            this.ebv.setVisibility(8);
            this.ebu.setVisibility(8);
        }
        this.ebv.setVisibility(8);
        this.ebu.setVisibility(8);
    }

    private void hy(boolean z) {
        if (z) {
            this.ebw.setCompoundDrawablesWithIntrinsicBounds(0, 0, e.f.icon_news_down_bar_one, 0);
        } else {
            this.ebw.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ebu) {
            if ((this.mTbPageContext == null || ba.bG(this.mTbPageContext.getPageActivity())) && this.ebs != null && this.ebt != null) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.ebt.getId() + TbadkCoreApplication.getCurrentAccount(), this.ebs.bAk());
                hy(false);
                com.baidu.tbadk.browser.a.a(this.ebu.getContext(), k.a(this.ebw.getText(), this.mContext.getString(e.j.frs_star_ticket_name)), com.baidu.tbadk.browser.a.appendVersionCode(com.baidu.tbadk.browser.a.appendCuidParam(this.ebs.bAl())), true, false, true);
            }
        }
    }
}
