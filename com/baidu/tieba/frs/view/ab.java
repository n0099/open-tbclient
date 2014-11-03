package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.aw;
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    private com.baidu.tieba.data.t aGv;
    private ForumData aGw;
    private ViewGroup aGx;
    private View aGy;
    private TextView aGz;
    private Context mContext;

    public ab(View view) {
        this.aGx = null;
        this.aGy = null;
        this.aGz = null;
        this.mContext = view.getContext().getApplicationContext();
        this.aGy = view.findViewById(com.baidu.tieba.v.frs_header_divider_ticket);
        this.aGx = (ViewGroup) view.findViewById(com.baidu.tieba.v.frs_header_ticket);
        this.aGz = (TextView) view.findViewById(com.baidu.tieba.v.frs_header_ticket_text);
        this.aGx.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        aw.h(this.aGx, com.baidu.tieba.u.frs_top_item_bg);
    }

    public void a(com.baidu.tieba.data.t tVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.aGv = tVar;
        this.aGw = forumData;
        String string = this.mContext.getString(com.baidu.tieba.y.frs_star_ticket_name);
        if (tVar != null) {
            z = tVar.zn();
            if (com.baidu.tbadk.core.sharedPref.b.lk().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkApplication.getCurrentAccount(), 0L) >= tVar.zo()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = String.valueOf(forumData.getName()) + this.mContext.getString(com.baidu.tieba.y.forum_name_suffix) + this.mContext.getString(com.baidu.tieba.y.frs_star_ticket_name);
        }
        if (z) {
            this.aGy.setVisibility(0);
            this.aGx.setVisibility(0);
            cl(z2);
            this.aGz.setText(string);
            com.baidu.tbadk.core.j.m(this.mContext, "ticket_show");
            return;
        }
        this.aGy.setVisibility(8);
        this.aGx.setVisibility(8);
    }

    private void cl(boolean z) {
        if (z) {
            this.aGz.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.u.icon_news_down_bar_one, 0);
        } else {
            this.aGz.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aGx && this.aGv != null && this.aGw != null) {
            com.baidu.tbadk.core.sharedPref.b.lk().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.aGw.getId() + TbadkApplication.getCurrentAccount(), this.aGv.zo());
            cl(false);
            TbWebViewActivity.startActivity(this.aGx.getContext(), com.baidu.adp.lib.util.l.a(this.aGz.getText(), this.mContext.getString(com.baidu.tieba.y.frs_star_ticket_name)), com.baidu.tbadk.browser.a.aQ(com.baidu.tbadk.browser.a.aP(this.aGv.zp())));
        }
    }
}
