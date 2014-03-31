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
    private BdListView a;
    private q b;
    private HotGroupActivity c;
    private View d;
    private HotGroupAdapter e;
    private d f;
    private g g = new b(this, 0);
    private com.baidu.adp.framework.c.a h = new c(this, 2001116);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof HotGroupActivity) {
            this.c = (HotGroupActivity) activity;
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(i.hot_group_fragment, (ViewGroup) null);
        this.a = (BdListView) inflate.findViewById(h.hot_group_list);
        this.a.a(this, 300L);
        this.b = new q(this.c);
        this.b.a(this);
        this.e = new HotGroupAdapter(this.c);
        this.a.setAdapter((ListAdapter) this.e);
        this.a.setPullRefresh(this.b);
        this.a.setOnItemClickListener(this);
        this.a.setOnSrollToBottomListener(this);
        this.d = (FrameLayout) inflate.findViewById(h.fragment_parent);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        c();
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.e.getItem(i);
        if (item != null) {
            TiebaStatic.a(this.c, "hot_group_item", "click", 1, new Object[0]);
            this.c.a(new com.baidu.adp.framework.message.a(2008011, new o(this.c, item.getGroupId(), 0)));
        }
    }

    @Override // com.baidu.tbadk.core.d
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.c.b().a(this.d);
        this.b.a(i);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        com.baidu.adp.framework.c.a().a(103012, this.g);
        com.baidu.adp.framework.c.a().a(103105, this.g);
        com.baidu.adp.framework.c.a().a(this.h);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroyView() {
        com.baidu.adp.framework.c.a().b(this.g);
        com.baidu.adp.framework.c.a().b(this.h);
        super.onDestroyView();
    }

    @Override // com.baidu.adp.widget.ListView.t
    public final void b() {
        if (this.f.a()) {
            this.f.a(this.e.getCount());
            this.f.d(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f == null) {
            this.f = new d();
        }
        this.f.b(true);
        this.a.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.a != null && this.e != null) {
            ac.a(this.a, this.e.a(), 0, -1);
        }
    }

    @Override // com.baidu.adp.widget.ListView.s
    public final void a() {
        d();
    }

    @Override // com.baidu.adp.widget.ListView.d
    public final void a(boolean z) {
        this.f.a(0);
        if (this.f.b()) {
            this.f.d(true);
            this.f.b(false);
            return;
        }
        this.f.d(false);
    }
}
