package com.baidu.tieba.im.friend;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.e {
    private IMBlackListActivity a;
    private NavigationBar b;
    private View c;
    private BdListView d;
    private f e;
    private TextView f;
    private ProgressBar g;
    private com.baidu.tbadk.imageManager.d h;

    public i(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity);
        this.h = new j(this);
        this.a = iMBlackListActivity;
        e();
    }

    public void a() {
        this.g.setVisibility(0);
    }

    public void b() {
        this.g.setVisibility(8);
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.e.a(aVar);
        if (this.e.getCount() <= 0) {
            this.d.setVisibility(8);
            this.f.setVisibility(0);
            return;
        }
        this.d.setVisibility(0);
        this.f.setVisibility(8);
        this.e.notifyDataSetChanged();
        c();
    }

    public void a(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.d.setVisibility(8);
            this.f.setVisibility(0);
            return;
        }
        this.d.setVisibility(0);
        this.f.setVisibility(8);
        this.e.a(arrayList);
        this.e.notifyDataSetChanged();
        c();
    }

    private void e() {
        this.a.setContentView(com.baidu.tieba.s.im_black_list);
        this.c = this.a.findViewById(com.baidu.tieba.r.root_view);
        this.b = (NavigationBar) this.c.findViewById(com.baidu.tieba.r.view_navigation_bar);
        this.b.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.b.a(com.baidu.tieba.u.black_list_title);
        this.d = (BdListView) this.c.findViewById(com.baidu.tieba.r.black_list);
        this.f = (TextView) this.c.findViewById(com.baidu.tieba.r.no_data_container);
        this.g = (ProgressBar) this.c.findViewById(com.baidu.tieba.r.progress);
        this.e = new f(this.a);
        this.d.setAdapter((ListAdapter) this.e);
        d();
        f();
    }

    private void f() {
        int skinType = TbadkApplication.m252getInst().getSkinType();
        this.a.getLayoutMode().a(skinType == 1);
        this.a.getLayoutMode().a(this.c);
        this.b.c(skinType);
    }

    public void c() {
        com.baidu.tbadk.core.util.ae.a(this.d, this.e.a(), null, this.h, null, 0, 1);
    }

    public void d() {
        this.d.setOnScrollListener(new k(this));
    }
}
