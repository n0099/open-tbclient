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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.j;
/* loaded from: classes2.dex */
public class e implements View.OnClickListener {
    private j dEO;
    private ForumData dEP;
    private ViewGroup dEQ;
    private View dER;
    private TextView dES;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public e(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.dEQ = null;
        this.dER = null;
        this.dES = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.dER = view.findViewById(d.g.frs_header_divider_ticket);
        this.dEQ = (ViewGroup) view.findViewById(d.g.frs_header_ticket);
        this.dES = (TextView) view.findViewById(d.g.frs_header_ticket_text);
        this.dEQ.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        al.i(this.dEQ, d.f.frs_top_item_bg);
    }

    public void a(j jVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.dEO = jVar;
        this.dEP = forumData;
        String string = this.mContext.getString(d.k.frs_star_ticket_name);
        if (jVar != null) {
            z = jVar.bvN();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= jVar.bvO()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = forumData.getName() + this.mContext.getString(d.k.forum) + this.mContext.getString(d.k.frs_star_ticket_name);
        }
        if (z) {
            this.dER.setVisibility(0);
            this.dEQ.setVisibility(0);
            gm(z2);
            this.dES.setText(string);
            TiebaStatic.log("ticket_show");
        } else {
            this.dER.setVisibility(8);
            this.dEQ.setVisibility(8);
        }
        this.dER.setVisibility(8);
        this.dEQ.setVisibility(8);
    }

    private void gm(boolean z) {
        if (z) {
            this.dES.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_news_down_bar_one, 0);
        } else {
            this.dES.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dEQ) {
            if ((this.mTbPageContext == null || ba.aU(this.mTbPageContext.getPageActivity())) && this.dEO != null && this.dEP != null) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.dEP.getId() + TbadkCoreApplication.getCurrentAccount(), this.dEO.bvO());
                gm(false);
                com.baidu.tbadk.browser.a.a(this.dEQ.getContext(), k.a(this.dES.getText(), this.mContext.getString(d.k.frs_star_ticket_name)), com.baidu.tbadk.browser.a.appendVersionCode(com.baidu.tbadk.browser.a.appendCuidParam(this.dEO.bvP())), true, false, true);
            }
        }
    }
}
