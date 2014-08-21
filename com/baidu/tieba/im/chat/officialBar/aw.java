package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class aw extends com.baidu.adp.base.f {
    private BdListView a;
    private au b;
    private NavigationBar c;
    private com.baidu.tbadk.core.view.p d;
    private OfficialBarTipActivity e;
    private ViewGroup f;

    public aw(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity);
        officialBarTipActivity.setContentView(com.baidu.tieba.v.officialbar_msg_activity);
        this.e = officialBarTipActivity;
        a(officialBarTipActivity);
        b(officialBarTipActivity);
    }

    private void a(OfficialBarTipActivity officialBarTipActivity) {
        this.c = (NavigationBar) officialBarTipActivity.findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.c.a(officialBarTipActivity.getString(com.baidu.tieba.x.official_message_activity_title));
        this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new ax(this, officialBarTipActivity));
        this.f = (ViewGroup) officialBarTipActivity.findViewById(com.baidu.tieba.u.root_view);
    }

    public void a(int i) {
        this.e.getLayoutMode().a(i == 1);
        this.e.getLayoutMode().a((View) this.f);
        this.c.c(i);
        this.d.a(i);
    }

    private void b(OfficialBarTipActivity officialBarTipActivity) {
        this.a = (BdListView) officialBarTipActivity.findViewById(com.baidu.tieba.u.msg_list);
        this.b = new au(officialBarTipActivity);
        this.a.setAdapter((ListAdapter) this.b);
        this.d = new com.baidu.tbadk.core.view.p(officialBarTipActivity.findViewById(com.baidu.tieba.u.root_view), com.baidu.tieba.t.pic_emotion05, com.baidu.tieba.t.pic_emotion05_1, com.baidu.tieba.u.no_data_container, com.baidu.tieba.u.no_data_image, com.baidu.tieba.u.no_data_image_text);
    }

    public BdListView a() {
        return this.a;
    }

    public au b() {
        return this.b;
    }
}
