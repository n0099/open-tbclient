package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.k;
/* loaded from: classes2.dex */
public class g implements View.OnClickListener {
    private k dZL;
    private ForumData dZM;
    private ViewGroup dZN;
    private View dZO;
    private TextView dZP;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public g(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.dZN = null;
        this.dZO = null;
        this.dZP = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.dZO = view.findViewById(d.g.frs_header_divider_ticket);
        this.dZN = (ViewGroup) view.findViewById(d.g.frs_header_ticket);
        this.dZP = (TextView) view.findViewById(d.g.frs_header_ticket_text);
        this.dZN.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        aj.s(this.dZN, d.f.frs_top_item_bg);
    }

    public void a(k kVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.dZL = kVar;
        this.dZM = forumData;
        String string = this.mContext.getString(d.j.frs_star_ticket_name);
        if (kVar != null) {
            z = kVar.bvK();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= kVar.bvL()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = forumData.getName() + this.mContext.getString(d.j.forum) + this.mContext.getString(d.j.frs_star_ticket_name);
        }
        if (z) {
            this.dZO.setVisibility(0);
            this.dZN.setVisibility(0);
            gG(z2);
            this.dZP.setText(string);
            TiebaStatic.log("ticket_show");
        } else {
            this.dZO.setVisibility(8);
            this.dZN.setVisibility(8);
        }
        this.dZO.setVisibility(8);
        this.dZN.setVisibility(8);
    }

    private void gG(boolean z) {
        if (z) {
            this.dZP.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_news_down_bar_one, 0);
        } else {
            this.dZP.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dZN) {
            if ((this.mTbPageContext == null || ay.ba(this.mTbPageContext.getPageActivity())) && this.dZL != null && this.dZM != null) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.dZM.getId() + TbadkCoreApplication.getCurrentAccount(), this.dZL.bvL());
                gG(false);
                com.baidu.tbadk.browser.b.a(this.dZN.getContext(), com.baidu.adp.lib.util.k.a(this.dZP.getText(), this.mContext.getString(d.j.frs_star_ticket_name)), com.baidu.tbadk.browser.b.appendVersionCode(com.baidu.tbadk.browser.b.appendCuidParam(this.dZL.bvM())), true, false, true);
            }
        }
    }
}
