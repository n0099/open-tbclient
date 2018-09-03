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
import com.baidu.tieba.f;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.j;
/* loaded from: classes2.dex */
public class e implements View.OnClickListener {
    private j dKU;
    private ForumData dKV;
    private ViewGroup dKW;
    private View dKX;
    private TextView dKY;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public e(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.dKW = null;
        this.dKX = null;
        this.dKY = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.dKX = view.findViewById(f.g.frs_header_divider_ticket);
        this.dKW = (ViewGroup) view.findViewById(f.g.frs_header_ticket);
        this.dKY = (TextView) view.findViewById(f.g.frs_header_ticket_text);
        this.dKW.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        am.i(this.dKW, f.C0146f.frs_top_item_bg);
    }

    public void a(j jVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.dKU = jVar;
        this.dKV = forumData;
        String string = this.mContext.getString(f.j.frs_star_ticket_name);
        if (jVar != null) {
            z = jVar.buS();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= jVar.buT()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = forumData.getName() + this.mContext.getString(f.j.forum) + this.mContext.getString(f.j.frs_star_ticket_name);
        }
        if (z) {
            this.dKX.setVisibility(0);
            this.dKW.setVisibility(0);
            gy(z2);
            this.dKY.setText(string);
            TiebaStatic.log("ticket_show");
        } else {
            this.dKX.setVisibility(8);
            this.dKW.setVisibility(8);
        }
        this.dKX.setVisibility(8);
        this.dKW.setVisibility(8);
    }

    private void gy(boolean z) {
        if (z) {
            this.dKY.setCompoundDrawablesWithIntrinsicBounds(0, 0, f.C0146f.icon_news_down_bar_one, 0);
        } else {
            this.dKY.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dKW) {
            if ((this.mTbPageContext == null || bb.aU(this.mTbPageContext.getPageActivity())) && this.dKU != null && this.dKV != null) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.dKV.getId() + TbadkCoreApplication.getCurrentAccount(), this.dKU.buT());
                gy(false);
                com.baidu.tbadk.browser.a.a(this.dKW.getContext(), k.a(this.dKY.getText(), this.mContext.getString(f.j.frs_star_ticket_name)), com.baidu.tbadk.browser.a.appendVersionCode(com.baidu.tbadk.browser.a.appendCuidParam(this.dKU.buU())), true, false, true);
            }
        }
    }
}
