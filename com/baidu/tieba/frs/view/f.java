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
import com.baidu.tieba.tbadkCore.i;
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    private i ddV;
    private ForumData ddW;
    private ViewGroup ddX;
    private View ddY;
    private TextView ddZ;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public f(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.ddX = null;
        this.ddY = null;
        this.ddZ = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.ddY = view.findViewById(d.g.frs_header_divider_ticket);
        this.ddX = (ViewGroup) view.findViewById(d.g.frs_header_ticket);
        this.ddZ = (TextView) view.findViewById(d.g.frs_header_ticket_text);
        this.ddX.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        aj.j(this.ddX, d.f.frs_top_item_bg);
    }

    public void a(i iVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.ddV = iVar;
        this.ddW = forumData;
        String string = this.mContext.getString(d.j.frs_star_ticket_name);
        if (iVar != null) {
            z = iVar.bvH();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= iVar.bvI()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = forumData.getName() + this.mContext.getString(d.j.forum) + this.mContext.getString(d.j.frs_star_ticket_name);
        }
        if (z) {
            this.ddY.setVisibility(0);
            this.ddX.setVisibility(0);
            fH(z2);
            this.ddZ.setText(string);
            TiebaStatic.log("ticket_show");
        } else {
            this.ddY.setVisibility(8);
            this.ddX.setVisibility(8);
        }
        this.ddY.setVisibility(8);
        this.ddX.setVisibility(8);
    }

    private void fH(boolean z) {
        if (z) {
            this.ddZ.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_news_down_bar_one, 0);
        } else {
            this.ddZ.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ddX) {
            if ((this.mTbPageContext == null || ax.aS(this.mTbPageContext.getPageActivity())) && this.ddV != null && this.ddW != null) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.ddW.getId() + TbadkCoreApplication.getCurrentAccount(), this.ddV.bvI());
                fH(false);
                com.baidu.tbadk.browser.a.a(this.ddX.getContext(), k.a(this.ddZ.getText(), this.mContext.getString(d.j.frs_star_ticket_name)), com.baidu.tbadk.browser.a.appendVersionCode(com.baidu.tbadk.browser.a.appendCuidParam(this.ddV.bvJ())), true, false, true);
            }
        }
    }
}
