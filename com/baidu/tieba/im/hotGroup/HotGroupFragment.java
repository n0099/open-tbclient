package com.baidu.tieba.im.hotGroup;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.groupInfo.GroupInfoActivity;
import com.baidu.tieba.im.messageCenter.e;
import com.baidu.tieba.im.messageCenter.g;
import com.baidu.tieba.j;
import com.baidu.tieba.util.ap;
import com.baidu.tieba.util.cb;
import com.baidu.tieba.view.ct;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class HotGroupFragment extends j implements com.baidu.adp.widget.ListView.b, q, r {
    private BdListView b;
    private ct c;
    private HotGroupActivity d;
    private View e;
    private HotGroupAdapter f;
    private c g;
    private g h = new b(this);

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof HotGroupActivity) {
            this.d = (HotGroupActivity) activity;
        }
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.hot_group_fragment, (ViewGroup) null);
        this.b = (BdListView) inflate.findViewById(R.id.hot_group_list);
        this.b.a(this, 300L);
        this.c = new ct(this.d);
        this.c.a(this);
        this.f = new HotGroupAdapter(this.d);
        this.b.setAdapter((ListAdapter) this.f);
        this.b.setPullRefresh(this.c);
        this.b.setOnItemClickListener(this);
        this.b.setOnSrollToBottomListener(this);
        this.e = (FrameLayout) inflate.findViewById(R.id.fragment_parent);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        d();
    }

    @Override // com.baidu.tieba.j, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.f.getItem(i);
        if (item != null) {
            cb.a(this.d, "hot_group_item", "click", 1, new Object[0]);
            GroupInfoActivity.a(this.d, item.getGroupId(), 0);
        }
    }

    @Override // com.baidu.tieba.j
    public void c(int i) {
        super.c(i);
        this.d.a().a(this.e);
        this.c.a(i);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        e.a().a(103012, this.h);
        e.a().a(-116, this.h);
        e.a().a(103105, this.h);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onDestroyView() {
        e.a().a(this.h);
        super.onDestroyView();
    }

    @Override // com.baidu.adp.widget.ListView.r
    public void a() {
        c();
    }

    private void c() {
        if (this.g.a()) {
            this.g.a(this.f.getCount());
            this.g.d(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.g == null) {
            this.g = new c();
        }
        this.g.b(true);
        this.b.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.b != null && this.f != null) {
            ap.a(this.b, this.f.a(), 0, -1);
        }
    }

    @Override // com.baidu.adp.widget.ListView.q
    public void a(int i, int i2) {
        e();
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        this.g.a(0);
        if (this.g.b()) {
            this.g.d(true);
            this.g.b(false);
            return;
        }
        this.g.d(false);
    }
}
