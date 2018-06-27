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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.j;
/* loaded from: classes2.dex */
public class e implements View.OnClickListener {
    private j dIj;
    private ForumData dIk;
    private ViewGroup dIl;
    private View dIm;
    private TextView dIn;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public e(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.dIl = null;
        this.dIm = null;
        this.dIn = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.dIm = view.findViewById(d.g.frs_header_divider_ticket);
        this.dIl = (ViewGroup) view.findViewById(d.g.frs_header_ticket);
        this.dIn = (TextView) view.findViewById(d.g.frs_header_ticket_text);
        this.dIl.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        am.i(this.dIl, d.f.frs_top_item_bg);
    }

    public void a(j jVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.dIj = jVar;
        this.dIk = forumData;
        String string = this.mContext.getString(d.k.frs_star_ticket_name);
        if (jVar != null) {
            z = jVar.bwn();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= jVar.bwo()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = forumData.getName() + this.mContext.getString(d.k.forum) + this.mContext.getString(d.k.frs_star_ticket_name);
        }
        if (z) {
            this.dIm.setVisibility(0);
            this.dIl.setVisibility(0);
            gw(z2);
            this.dIn.setText(string);
            TiebaStatic.log("ticket_show");
        } else {
            this.dIm.setVisibility(8);
            this.dIl.setVisibility(8);
        }
        this.dIm.setVisibility(8);
        this.dIl.setVisibility(8);
    }

    private void gw(boolean z) {
        if (z) {
            this.dIn.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_news_down_bar_one, 0);
        } else {
            this.dIn.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dIl) {
            if ((this.mTbPageContext == null || bb.aU(this.mTbPageContext.getPageActivity())) && this.dIj != null && this.dIk != null) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.dIk.getId() + TbadkCoreApplication.getCurrentAccount(), this.dIj.bwo());
                gw(false);
                com.baidu.tbadk.browser.a.a(this.dIl.getContext(), k.a(this.dIn.getText(), this.mContext.getString(d.k.frs_star_ticket_name)), com.baidu.tbadk.browser.a.appendVersionCode(com.baidu.tbadk.browser.a.appendCuidParam(this.dIj.bwp())), true, false, true);
            }
        }
    }
}
