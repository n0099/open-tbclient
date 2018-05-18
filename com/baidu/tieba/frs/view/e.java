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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.j;
/* loaded from: classes2.dex */
public class e implements View.OnClickListener {
    private j dvB;
    private ForumData dvC;
    private ViewGroup dvD;
    private View dvE;
    private TextView dvF;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public e(TbPageContext<FrsActivity> tbPageContext, View view2) {
        this.dvD = null;
        this.dvE = null;
        this.dvF = null;
        this.mContext = view2.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.dvE = view2.findViewById(d.g.frs_header_divider_ticket);
        this.dvD = (ViewGroup) view2.findViewById(d.g.frs_header_ticket);
        this.dvF = (TextView) view2.findViewById(d.g.frs_header_ticket_text);
        this.dvD.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        ak.i(this.dvD, d.f.frs_top_item_bg);
    }

    public void a(j jVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.dvB = jVar;
        this.dvC = forumData;
        String string = this.mContext.getString(d.k.frs_star_ticket_name);
        if (jVar != null) {
            z = jVar.bqL();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= jVar.bqM()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = forumData.getName() + this.mContext.getString(d.k.forum) + this.mContext.getString(d.k.frs_star_ticket_name);
        }
        if (z) {
            this.dvE.setVisibility(0);
            this.dvD.setVisibility(0);
            gh(z2);
            this.dvF.setText(string);
            TiebaStatic.log("ticket_show");
        } else {
            this.dvE.setVisibility(8);
            this.dvD.setVisibility(8);
        }
        this.dvE.setVisibility(8);
        this.dvD.setVisibility(8);
    }

    private void gh(boolean z) {
        if (z) {
            this.dvF.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_news_down_bar_one, 0);
        } else {
            this.dvF.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.dvD) {
            if ((this.mTbPageContext == null || az.aK(this.mTbPageContext.getPageActivity())) && this.dvB != null && this.dvC != null) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.dvC.getId() + TbadkCoreApplication.getCurrentAccount(), this.dvB.bqM());
                gh(false);
                com.baidu.tbadk.browser.a.a(this.dvD.getContext(), k.a(this.dvF.getText(), this.mContext.getString(d.k.frs_star_ticket_name)), com.baidu.tbadk.browser.a.appendVersionCode(com.baidu.tbadk.browser.a.appendCuidParam(this.dvB.bqN())), true, false, true);
            }
        }
    }
}
