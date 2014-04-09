package com.baidu.tieba.im.hotGroup;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.baidu.adp.framework.c.g;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.s;
import com.baidu.adp.widget.ListView.t;
import com.baidu.tbadk.core.b.o;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.view.q;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.h;
import com.baidu.tieba.im.i;
/* loaded from: classes.dex */
public class HotGroupFragment extends com.baidu.tbadk.core.d implements com.baidu.adp.widget.ListView.d, s, t {
    private BdListView b;
    private q c;
    private HotGroupActivity d;
    private View e;
    private HotGroupAdapter f;
    private d g;
    private g h = new b(this, 0);
    private com.baidu.adp.framework.c.a i = new c(this, 2001116);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof HotGroupActivity) {
            this.d = (HotGroupActivity) activity;
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(i.hot_group_fragment, (ViewGroup) null);
        this.b = (BdListView) inflate.findViewById(h.hot_group_list);
        this.b.a(this, 300L);
        this.c = new q(this.d);
        this.c.a(this);
        this.f = new HotGroupAdapter(this.d);
        this.b.setAdapter((ListAdapter) this.f);
        this.b.setPullRefresh(this.c);
        this.b.setOnItemClickListener(this);
        this.b.setOnSrollToBottomListener(this);
        this.e = (FrameLayout) inflate.findViewById(h.fragment_parent);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        e();
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.f.getItem(i);
        if (item != null) {
            TiebaStatic.a(this.d, "hot_group_item", "click", 1, new Object[0]);
            this.d.a(new com.baidu.adp.framework.message.a(2008011, new o(this.d, item.getGroupId(), 0)));
        }
    }

    @Override // com.baidu.tbadk.core.d
    public final void c(int i) {
        super.c(i);
        this.d.b().a(this.e);
        this.c.a(i);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        com.baidu.adp.framework.c.a().a(103012, this.h);
        com.baidu.adp.framework.c.a().a(103105, this.h);
        com.baidu.adp.framework.c.a().a(this.i);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroyView() {
        com.baidu.adp.framework.c.a().b(this.h);
        com.baidu.adp.framework.c.a().b(this.i);
        super.onDestroyView();
    }

    @Override // com.baidu.adp.widget.ListView.t
    public final void b() {
        if (this.g.a()) {
            this.g.a(this.f.getCount());
            this.g.d(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.g == null) {
            this.g = new d();
        }
        this.g.b(true);
        this.b.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.b != null && this.f != null) {
            ac.a(this.b, this.f.a(), 0, -1);
        }
    }

    @Override // com.baidu.adp.widget.ListView.s
    public final void a() {
        f();
    }

    @Override // com.baidu.adp.widget.ListView.d
    public final void a(boolean z) {
        this.g.a(0);
        if (this.g.b()) {
            this.g.d(true);
            this.g.b(false);
            return;
        }
        this.g.d(false);
    }
}
