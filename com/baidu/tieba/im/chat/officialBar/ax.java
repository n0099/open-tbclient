package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class ax extends com.baidu.adp.base.e {
    private BdListView a;
    private av b;
    private NavigationBar c;
    private com.baidu.tbadk.core.view.k d;
    private OfficialBarTipActivity e;
    private ViewGroup f;

    public ax(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity);
        officialBarTipActivity.setContentView(com.baidu.tieba.s.officialbar_msg_activity);
        this.e = officialBarTipActivity;
        a(officialBarTipActivity);
        b(officialBarTipActivity);
    }

    private void a(OfficialBarTipActivity officialBarTipActivity) {
        this.c = (NavigationBar) officialBarTipActivity.findViewById(com.baidu.tieba.r.view_navigation_bar);
        this.c.a(officialBarTipActivity.getString(com.baidu.tieba.u.official_message_activity_title));
        this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new ay(this, officialBarTipActivity));
        this.f = (ViewGroup) officialBarTipActivity.findViewById(com.baidu.tieba.r.root_view);
    }

    public void a(int i) {
        this.e.getLayoutMode().a(i == 1);
        this.e.getLayoutMode().a((View) this.f);
        this.c.c(i);
        this.d.a(i);
    }

    private void b(OfficialBarTipActivity officialBarTipActivity) {
        this.a = (BdListView) officialBarTipActivity.findViewById(com.baidu.tieba.r.msg_list);
        this.b = new av(officialBarTipActivity);
        this.a.setAdapter((ListAdapter) this.b);
        this.d = new com.baidu.tbadk.core.view.k(officialBarTipActivity.findViewById(com.baidu.tieba.r.root_view), com.baidu.tieba.q.individual_center_news, com.baidu.tieba.q.individual_center_news_1, com.baidu.tieba.r.no_data_container, com.baidu.tieba.r.no_data_image, com.baidu.tieba.r.no_data_image_text);
    }

    public BdListView a() {
        return this.a;
    }

    public av b() {
        return this.b;
    }

    public com.baidu.tbadk.core.view.k c() {
        return this.d;
    }
}
