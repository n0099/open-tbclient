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
/* loaded from: classes2.dex */
public class e implements View.OnClickListener {
    private j dSe;
    private ForumData dSf;
    private ViewGroup dSg;
    private View dSh;
    private TextView dSi;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public e(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.dSg = null;
        this.dSh = null;
        this.dSi = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.dSh = view.findViewById(e.g.frs_header_divider_ticket);
        this.dSg = (ViewGroup) view.findViewById(e.g.frs_header_ticket);
        this.dSi = (TextView) view.findViewById(e.g.frs_header_ticket_text);
        this.dSg.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        al.i(this.dSg, e.f.frs_top_item_bg);
    }

    public void a(j jVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.dSe = jVar;
        this.dSf = forumData;
        String string = this.mContext.getString(e.j.frs_star_ticket_name);
        if (jVar != null) {
            z = jVar.bxy();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= jVar.bxz()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = forumData.getName() + this.mContext.getString(e.j.forum) + this.mContext.getString(e.j.frs_star_ticket_name);
        }
        if (z) {
            this.dSh.setVisibility(0);
            this.dSg.setVisibility(0);
            gW(z2);
            this.dSi.setText(string);
            TiebaStatic.log("ticket_show");
        } else {
            this.dSh.setVisibility(8);
            this.dSg.setVisibility(8);
        }
        this.dSh.setVisibility(8);
        this.dSg.setVisibility(8);
    }

    private void gW(boolean z) {
        if (z) {
            this.dSi.setCompoundDrawablesWithIntrinsicBounds(0, 0, e.f.icon_news_down_bar_one, 0);
        } else {
            this.dSi.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dSg) {
            if ((this.mTbPageContext == null || ba.bA(this.mTbPageContext.getPageActivity())) && this.dSe != null && this.dSf != null) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.dSf.getId() + TbadkCoreApplication.getCurrentAccount(), this.dSe.bxz());
                gW(false);
                com.baidu.tbadk.browser.a.a(this.dSg.getContext(), k.a(this.dSi.getText(), this.mContext.getString(e.j.frs_star_ticket_name)), com.baidu.tbadk.browser.a.appendVersionCode(com.baidu.tbadk.browser.a.appendCuidParam(this.dSe.bxA())), true, false, true);
            }
        }
    }
}
