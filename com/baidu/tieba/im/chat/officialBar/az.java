package com.baidu.tieba.im.chat.officialBar;

import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public final class az extends com.baidu.adp.a.f {
    private BdListView a;
    private ax c;
    private NavigationBar d;
    private com.baidu.tbadk.core.view.k e;
    private OfficialBarTipActivity f;
    private ViewGroup g;

    public az(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity);
        officialBarTipActivity.setContentView(com.baidu.tieba.im.i.officialbar_msg_activity);
        this.f = officialBarTipActivity;
        this.d = (NavigationBar) officialBarTipActivity.findViewById(com.baidu.tieba.im.h.view_navigation_bar);
        this.d.a(officialBarTipActivity.getString(com.baidu.tieba.im.j.official_message_activity_title));
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new ba(this, officialBarTipActivity));
        this.g = (ViewGroup) officialBarTipActivity.findViewById(com.baidu.tieba.im.h.root_view);
        this.a = (BdListView) officialBarTipActivity.findViewById(com.baidu.tieba.im.h.msg_list);
        this.c = new ax(officialBarTipActivity);
        this.a.setAdapter((ListAdapter) this.c);
        this.e = new com.baidu.tbadk.core.view.k(officialBarTipActivity.findViewById(com.baidu.tieba.im.h.root_view), com.baidu.tieba.im.g.individual_center_news, com.baidu.tieba.im.g.individual_center_news_1, com.baidu.tieba.im.h.no_data_container, com.baidu.tieba.im.h.no_data_image, com.baidu.tieba.im.h.no_data_image_text);
    }

    public final void a(int i) {
        this.f.getLayoutMode().a(i == 1);
        this.f.getLayoutMode().a(this.g);
        this.d.b(i);
        this.e.a(i);
    }

    public final BdListView a() {
        return this.a;
    }

    public final ax d() {
        return this.c;
    }

    public final com.baidu.tbadk.core.view.k e() {
        return this.e;
    }
}
