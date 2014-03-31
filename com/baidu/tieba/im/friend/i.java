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
public final class i extends com.baidu.adp.a.f {
    private IMBlackListActivity a;
    private NavigationBar c;
    private View d;
    private BdListView e;
    private f f;
    private TextView g;
    private ProgressBar h;
    private com.baidu.tbadk.imageManager.d i;

    public i(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity);
        this.i = new j(this);
        this.a = iMBlackListActivity;
        this.a.setContentView(com.baidu.tieba.im.i.im_black_list);
        this.d = this.a.findViewById(com.baidu.tieba.im.h.root_view);
        this.c = (NavigationBar) this.d.findViewById(com.baidu.tieba.im.h.view_navigation_bar);
        this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.c.a(com.baidu.tieba.im.j.black_list_title);
        this.e = (BdListView) this.d.findViewById(com.baidu.tieba.im.h.black_list);
        this.g = (TextView) this.d.findViewById(com.baidu.tieba.im.h.no_data_container);
        this.h = (ProgressBar) this.d.findViewById(com.baidu.tieba.im.h.progress);
        this.f = new f(this.a);
        this.e.setAdapter((ListAdapter) this.f);
        this.e.setOnScrollListener(new k(this));
        int l = TbadkApplication.j().l();
        this.a.getLayoutMode().a(l == 1);
        this.a.getLayoutMode().a(this.d);
        this.c.b(l);
    }

    public final void a() {
        this.h.setVisibility(0);
    }

    public final void d() {
        this.h.setVisibility(8);
    }

    public final void a(com.baidu.tieba.im.data.a aVar) {
        this.f.a(aVar);
        if (this.f.getCount() <= 0) {
            this.e.setVisibility(8);
            this.g.setVisibility(0);
            return;
        }
        this.e.setVisibility(0);
        this.g.setVisibility(8);
        this.f.notifyDataSetChanged();
        e();
    }

    public final void a(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.e.setVisibility(8);
            this.g.setVisibility(0);
            return;
        }
        this.e.setVisibility(0);
        this.g.setVisibility(8);
        this.f.a(arrayList);
        this.f.notifyDataSetChanged();
        e();
    }

    public final void e() {
        com.baidu.tbadk.core.util.ac.a(this.e, this.f.a(), null, this.i, null, 0, 1);
    }
}
