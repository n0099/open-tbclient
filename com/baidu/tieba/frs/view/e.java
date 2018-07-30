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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.j;
/* loaded from: classes2.dex */
public class e implements View.OnClickListener {
    private j dKY;
    private ForumData dKZ;
    private ViewGroup dLa;
    private View dLb;
    private TextView dLc;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public e(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.dLa = null;
        this.dLb = null;
        this.dLc = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.dLb = view.findViewById(d.g.frs_header_divider_ticket);
        this.dLa = (ViewGroup) view.findViewById(d.g.frs_header_ticket);
        this.dLc = (TextView) view.findViewById(d.g.frs_header_ticket_text);
        this.dLa.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        am.i(this.dLa, d.f.frs_top_item_bg);
    }

    public void a(j jVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.dKY = jVar;
        this.dKZ = forumData;
        String string = this.mContext.getString(d.j.frs_star_ticket_name);
        if (jVar != null) {
            z = jVar.buR();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= jVar.buS()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = forumData.getName() + this.mContext.getString(d.j.forum) + this.mContext.getString(d.j.frs_star_ticket_name);
        }
        if (z) {
            this.dLb.setVisibility(0);
            this.dLa.setVisibility(0);
            gy(z2);
            this.dLc.setText(string);
            TiebaStatic.log("ticket_show");
        } else {
            this.dLb.setVisibility(8);
            this.dLa.setVisibility(8);
        }
        this.dLb.setVisibility(8);
        this.dLa.setVisibility(8);
    }

    private void gy(boolean z) {
        if (z) {
            this.dLc.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_news_down_bar_one, 0);
        } else {
            this.dLc.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dLa) {
            if ((this.mTbPageContext == null || ba.aV(this.mTbPageContext.getPageActivity())) && this.dKY != null && this.dKZ != null) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.dKZ.getId() + TbadkCoreApplication.getCurrentAccount(), this.dKY.buS());
                gy(false);
                com.baidu.tbadk.browser.a.a(this.dLa.getContext(), k.a(this.dLc.getText(), this.mContext.getString(d.j.frs_star_ticket_name)), com.baidu.tbadk.browser.a.appendVersionCode(com.baidu.tbadk.browser.a.appendCuidParam(this.dKY.buT())), true, false, true);
            }
        }
    }
}
