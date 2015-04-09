package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    private com.baidu.tieba.tbadkCore.v aPr;
    private ForumData aPs;
    private ViewGroup aPt;
    private View aPu;
    private TextView aPv;
    private Context mContext;

    public w(View view) {
        this.aPt = null;
        this.aPu = null;
        this.aPv = null;
        this.mContext = view.getContext().getApplicationContext();
        this.aPu = view.findViewById(com.baidu.tieba.v.frs_header_divider_ticket);
        this.aPt = (ViewGroup) view.findViewById(com.baidu.tieba.v.frs_header_ticket);
        this.aPv = (TextView) view.findViewById(com.baidu.tieba.v.frs_header_ticket_text);
        this.aPt.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        ba.i(this.aPt, com.baidu.tieba.u.frs_top_item_bg);
    }

    public void a(com.baidu.tieba.tbadkCore.v vVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.aPr = vVar;
        this.aPs = forumData;
        String string = this.mContext.getString(y.frs_star_ticket_name);
        if (vVar != null) {
            z = vVar.akT();
            if (com.baidu.tbadk.core.sharedPref.b.rB().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= vVar.akU()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = String.valueOf(forumData.getName()) + this.mContext.getString(y.forum_name_suffix) + this.mContext.getString(y.frs_star_ticket_name);
        }
        if (z) {
            this.aPu.setVisibility(0);
            this.aPt.setVisibility(0);
            ca(z2);
            this.aPv.setText(string);
            com.baidu.tbadk.core.k.B(this.mContext, "ticket_show");
            return;
        }
        this.aPu.setVisibility(8);
        this.aPt.setVisibility(8);
    }

    private void ca(boolean z) {
        if (z) {
            this.aPv.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.u.icon_news_down_bar_one, 0);
        } else {
            this.aPv.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aPt && this.aPr != null && this.aPs != null) {
            com.baidu.tbadk.core.sharedPref.b.rB().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.aPs.getId() + TbadkCoreApplication.getCurrentAccount(), this.aPr.akU());
            ca(false);
            com.baidu.tbadk.browser.f.a(this.aPt.getContext(), com.baidu.adp.lib.util.m.a(this.aPv.getText(), this.mContext.getString(y.frs_star_ticket_name)), com.baidu.tbadk.browser.f.appendVersionCode(com.baidu.tbadk.browser.f.appendCuidParam(this.aPr.akV())), true, false, false);
        }
    }
}
