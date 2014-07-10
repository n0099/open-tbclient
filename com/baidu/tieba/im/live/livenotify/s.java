package com.baidu.tieba.im.live.livenotify;

import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.List;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.base.f {
    private View a;
    private View b;
    private LiveNotifyActivity c;
    private BdListView d;
    private j e;
    private ProgressBar f;
    private Button g;
    private Button h;
    private Button i;
    private NavigationBar j;
    private View k;
    private View l;

    public s(LiveNotifyActivity liveNotifyActivity) {
        super(liveNotifyActivity);
        this.c = liveNotifyActivity;
        a();
        this.e = new j(this.c);
        this.d.setAdapter((ListAdapter) this.e);
        this.d.setOnScrollListener(this.c);
    }

    void a() {
        this.a = View.inflate(this.c, w.updates_activity, null);
        this.c.setContentView(this.a);
        this.j = (NavigationBar) this.c.findViewById(v.view_navigation_bar);
        this.b = this.j.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.j.a(this.c.getString(y.live_chat_room_more_livenotify));
        this.k = this.j.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.updates_activity_nav_left, (View.OnClickListener) null);
        this.l = this.j.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.updates_activity_nav_right, (View.OnClickListener) null);
        this.i = (Button) this.k.findViewById(v.btn_delete);
        this.i.setOnClickListener(this.c);
        this.b.setOnClickListener(this.c);
        this.d = (BdListView) this.a.findViewById(v.updates_list);
        this.f = (ProgressBar) this.a.findViewById(v.pro_load);
        this.g = (Button) this.l.findViewById(v.btn_edit);
        this.g.setOnClickListener(this.c);
        this.h = (Button) this.l.findViewById(v.btn_cancel);
        this.h.setOnClickListener(this.c);
        a(0);
        a(false);
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        super.destroy();
        if (this.e != null) {
            this.e.a();
            this.e = null;
        }
        this.c = null;
    }

    public void b() {
        this.g.setVisibility(8);
        this.b.setVisibility(8);
        this.h.setVisibility(0);
        this.k.setVisibility(0);
        d();
    }

    public void c() {
        this.g.setVisibility(0);
        this.b.setVisibility(0);
        this.h.setVisibility(8);
        this.k.setVisibility(8);
        a(0);
        d();
    }

    public void d() {
        if (this.e != null) {
            this.e.notifyDataSetChanged();
        }
    }

    public void a(List<UpdatesItemData> list) {
        if (this.e != null) {
            this.e.a(list);
        }
    }

    public void a(int i) {
        this.i.setText(String.format(this.c.getString(y.del_count), Integer.valueOf(i)));
        if (i == 0) {
            this.i.setEnabled(false);
        } else {
            this.i.setEnabled(true);
        }
    }

    public void a(boolean z) {
        this.f.setVisibility(z ? 0 : 8);
    }

    public void b(int i) {
        this.c.getLayoutMode().a(i == 1);
        this.c.getLayoutMode().a(this.a);
        this.j.c(i);
    }

    public View e() {
        return this.b;
    }

    public BdListView f() {
        return this.d;
    }

    public Button g() {
        return this.g;
    }

    public Button h() {
        return this.h;
    }

    public Button i() {
        return this.i;
    }
}
