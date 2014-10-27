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
    private com.baidu.tieba.data.t aGl;
    private ForumData aGm;
    private ViewGroup aGn;
    private View aGo;
    private TextView aGp;
    private Context mContext;

    public ab(View view) {
        this.aGn = null;
        this.aGo = null;
        this.aGp = null;
        this.mContext = view.getContext().getApplicationContext();
        this.aGo = view.findViewById(com.baidu.tieba.v.frs_header_divider_ticket);
        this.aGn = (ViewGroup) view.findViewById(com.baidu.tieba.v.frs_header_ticket);
        this.aGp = (TextView) view.findViewById(com.baidu.tieba.v.frs_header_ticket_text);
        this.aGn.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        aw.h(this.aGn, com.baidu.tieba.u.frs_top_item_bg);
    }

    public void a(com.baidu.tieba.data.t tVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.aGl = tVar;
        this.aGm = forumData;
        String string = this.mContext.getString(com.baidu.tieba.y.frs_star_ticket_name);
        if (tVar != null) {
            z = tVar.zl();
            if (com.baidu.tbadk.core.sharedPref.b.lk().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkApplication.getCurrentAccount(), 0L) >= tVar.zm()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = String.valueOf(forumData.getName()) + this.mContext.getString(com.baidu.tieba.y.forum_name_suffix) + this.mContext.getString(com.baidu.tieba.y.frs_star_ticket_name);
        }
        if (z) {
            this.aGo.setVisibility(0);
            this.aGn.setVisibility(0);
            cl(z2);
            this.aGp.setText(string);
            com.baidu.tbadk.core.i.m(this.mContext, "ticket_show");
            return;
        }
        this.aGo.setVisibility(8);
        this.aGn.setVisibility(8);
    }

    private void cl(boolean z) {
        if (z) {
            this.aGp.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.u.icon_news_down_bar_one, 0);
        } else {
            this.aGp.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aGn && this.aGl != null && this.aGm != null) {
            com.baidu.tbadk.core.sharedPref.b.lk().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.aGm.getId() + TbadkApplication.getCurrentAccount(), this.aGl.zm());
            cl(false);
            TbWebViewActivity.startActivity(this.aGn.getContext(), com.baidu.adp.lib.util.l.a(this.aGp.getText(), this.mContext.getString(com.baidu.tieba.y.frs_star_ticket_name)), com.baidu.tbadk.browser.a.aQ(com.baidu.tbadk.browser.a.aP(this.aGl.zn())));
        }
    }
}
