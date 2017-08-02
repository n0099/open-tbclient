package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.h;
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    private h cyU;
    private ForumData cyV;
    private ViewGroup cyW;
    private View cyX;
    private TextView cyY;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public e(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.cyW = null;
        this.cyX = null;
        this.cyY = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.cyX = view.findViewById(d.h.frs_header_divider_ticket);
        this.cyW = (ViewGroup) view.findViewById(d.h.frs_header_ticket);
        this.cyY = (TextView) view.findViewById(d.h.frs_header_ticket_text);
        this.cyW.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        ai.j(this.cyW, d.g.frs_top_item_bg);
    }

    public void a(h hVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.cyU = hVar;
        this.cyV = forumData;
        String string = this.mContext.getString(d.l.frs_star_ticket_name);
        if (hVar != null) {
            z = hVar.brf();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= hVar.brg()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = forumData.getName() + this.mContext.getString(d.l.forum) + this.mContext.getString(d.l.frs_star_ticket_name);
        }
        if (z) {
            this.cyX.setVisibility(0);
            this.cyW.setVisibility(0);
            fe(z2);
            this.cyY.setText(string);
            TiebaStatic.log("ticket_show");
        } else {
            this.cyX.setVisibility(8);
            this.cyW.setVisibility(8);
        }
        this.cyX.setVisibility(8);
        this.cyW.setVisibility(8);
    }

    private void fe(boolean z) {
        if (z) {
            this.cyY.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.g.icon_news_down_bar_one, 0);
        } else {
            this.cyY.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cyW) {
            if ((this.mTbPageContext == null || aw.aN(this.mTbPageContext.getPageActivity())) && this.cyU != null && this.cyV != null) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.cyV.getId() + TbadkCoreApplication.getCurrentAccount(), this.cyU.brg());
                fe(false);
                com.baidu.tbadk.browser.a.a(this.cyW.getContext(), j.a(this.cyY.getText(), this.mContext.getString(d.l.frs_star_ticket_name)), com.baidu.tbadk.browser.a.appendVersionCode(com.baidu.tbadk.browser.a.appendCuidParam(this.cyU.brh())), true, false, true);
            }
        }
    }
}
