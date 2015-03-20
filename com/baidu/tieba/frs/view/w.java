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
    private com.baidu.tieba.tbadkCore.v aPa;
    private ForumData aPb;
    private ViewGroup aPc;
    private View aPd;
    private TextView aPe;
    private Context mContext;

    public w(View view) {
        this.aPc = null;
        this.aPd = null;
        this.aPe = null;
        this.mContext = view.getContext().getApplicationContext();
        this.aPd = view.findViewById(com.baidu.tieba.v.frs_header_divider_ticket);
        this.aPc = (ViewGroup) view.findViewById(com.baidu.tieba.v.frs_header_ticket);
        this.aPe = (TextView) view.findViewById(com.baidu.tieba.v.frs_header_ticket_text);
        this.aPc.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        ba.i(this.aPc, com.baidu.tieba.u.frs_top_item_bg);
    }

    public void a(com.baidu.tieba.tbadkCore.v vVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.aPa = vVar;
        this.aPb = forumData;
        String string = this.mContext.getString(y.frs_star_ticket_name);
        if (vVar != null) {
            z = vVar.akE();
            if (com.baidu.tbadk.core.sharedPref.b.rB().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= vVar.akF()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = String.valueOf(forumData.getName()) + this.mContext.getString(y.forum_name_suffix) + this.mContext.getString(y.frs_star_ticket_name);
        }
        if (z) {
            this.aPd.setVisibility(0);
            this.aPc.setVisibility(0);
            cc(z2);
            this.aPe.setText(string);
            com.baidu.tbadk.core.k.B(this.mContext, "ticket_show");
            return;
        }
        this.aPd.setVisibility(8);
        this.aPc.setVisibility(8);
    }

    private void cc(boolean z) {
        if (z) {
            this.aPe.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.u.icon_news_down_bar_one, 0);
        } else {
            this.aPe.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aPc && this.aPa != null && this.aPb != null) {
            com.baidu.tbadk.core.sharedPref.b.rB().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.aPb.getId() + TbadkCoreApplication.getCurrentAccount(), this.aPa.akF());
            cc(false);
            com.baidu.tbadk.browser.f.a(this.aPc.getContext(), com.baidu.adp.lib.util.m.a(this.aPe.getText(), this.mContext.getString(y.frs_star_ticket_name)), com.baidu.tbadk.browser.f.appendVersionCode(com.baidu.tbadk.browser.f.appendCuidParam(this.aPa.akG())), true, false, false);
        }
    }
}
