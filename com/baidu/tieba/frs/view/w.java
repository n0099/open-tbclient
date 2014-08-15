package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    private Context a;
    private com.baidu.tieba.data.t b;
    private ForumData c;
    private ViewGroup d;
    private View e;
    private TextView f;

    public w(View view) {
        this.d = null;
        this.e = null;
        this.f = null;
        this.a = view.getContext().getApplicationContext();
        this.e = view.findViewById(com.baidu.tieba.u.frs_header_divider_ticket);
        this.d = (ViewGroup) view.findViewById(com.baidu.tieba.u.frs_header_ticket);
        this.f = (TextView) view.findViewById(com.baidu.tieba.u.frs_header_ticket_text);
        this.d.setOnClickListener(this);
    }

    public void a(int i) {
        if (i == 1) {
            this.d.setBackgroundResource(com.baidu.tieba.t.frs_top_item_bg_1);
        } else {
            this.d.setBackgroundResource(com.baidu.tieba.t.frs_top_item_bg);
        }
    }

    public void a(com.baidu.tieba.data.t tVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.b = tVar;
        this.c = forumData;
        String string = this.a.getString(com.baidu.tieba.x.frs_star_ticket_name);
        if (tVar != null) {
            z = tVar.j();
            if (com.baidu.tbadk.core.sharedPref.b.a().a("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkApplication.getCurrentAccount(), 0L) >= tVar.k()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = String.valueOf(forumData.getName()) + this.a.getString(com.baidu.tieba.x.forum_name_suffix) + this.a.getString(com.baidu.tieba.x.frs_star_ticket_name);
        }
        if (z) {
            this.e.setVisibility(0);
            this.d.setVisibility(0);
            a(z2);
            this.f.setText(string);
            com.baidu.tbadk.core.f.b(this.a, "ticket_show");
            return;
        }
        this.e.setVisibility(8);
        this.d.setVisibility(8);
    }

    private void a(boolean z) {
        if (z) {
            this.f.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.t.icon_news_down_bar_one, 0);
        } else {
            this.f.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.d && this.b != null && this.c != null) {
            com.baidu.tbadk.core.sharedPref.b.a().b("FRS_STARTICKET_LAST_CLICK_TIME" + this.c.getId() + TbadkApplication.getCurrentAccount(), this.b.k());
            a(false);
            TbWebViewActivity.startActivity(this.d.getContext(), com.baidu.adp.lib.util.i.a(this.f.getText(), this.a.getString(com.baidu.tieba.x.frs_star_ticket_name)), com.baidu.tbadk.browser.a.b(com.baidu.tbadk.browser.a.a(this.b.l())));
        }
    }
}
