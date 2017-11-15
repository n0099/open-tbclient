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
import com.baidu.tieba.tbadkCore.h;
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    private h cTG;
    private ForumData cTH;
    private ViewGroup cTI;
    private View cTJ;
    private TextView cTK;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public e(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.cTI = null;
        this.cTJ = null;
        this.cTK = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.cTJ = view.findViewById(d.g.frs_header_divider_ticket);
        this.cTI = (ViewGroup) view.findViewById(d.g.frs_header_ticket);
        this.cTK = (TextView) view.findViewById(d.g.frs_header_ticket_text);
        this.cTI.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        aj.j(this.cTI, d.f.frs_top_item_bg);
    }

    public void a(h hVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.cTG = hVar;
        this.cTH = forumData;
        String string = this.mContext.getString(d.j.frs_star_ticket_name);
        if (hVar != null) {
            z = hVar.btt();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= hVar.btu()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = forumData.getName() + this.mContext.getString(d.j.forum) + this.mContext.getString(d.j.frs_star_ticket_name);
        }
        if (z) {
            this.cTJ.setVisibility(0);
            this.cTI.setVisibility(0);
            fo(z2);
            this.cTK.setText(string);
            TiebaStatic.log("ticket_show");
        } else {
            this.cTJ.setVisibility(8);
            this.cTI.setVisibility(8);
        }
        this.cTJ.setVisibility(8);
        this.cTI.setVisibility(8);
    }

    private void fo(boolean z) {
        if (z) {
            this.cTK.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_news_down_bar_one, 0);
        } else {
            this.cTK.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cTI) {
            if ((this.mTbPageContext == null || ax.aT(this.mTbPageContext.getPageActivity())) && this.cTG != null && this.cTH != null) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.cTH.getId() + TbadkCoreApplication.getCurrentAccount(), this.cTG.btu());
                fo(false);
                com.baidu.tbadk.browser.a.a(this.cTI.getContext(), k.a(this.cTK.getText(), this.mContext.getString(d.j.frs_star_ticket_name)), com.baidu.tbadk.browser.a.appendVersionCode(com.baidu.tbadk.browser.a.appendCuidParam(this.cTG.btv())), true, false, true);
            }
        }
    }
}
