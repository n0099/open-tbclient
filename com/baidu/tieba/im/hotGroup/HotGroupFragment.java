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
import com.baidu.mobstat.StatService;
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.groupInfo.GroupInfoActivity;
import com.baidu.tieba.im.messageCenter.e;
import com.baidu.tieba.im.messageCenter.g;
import com.baidu.tieba.util.ah;
import com.baidu.tieba.view.bk;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class HotGroupFragment extends BaseFragment implements com.baidu.adp.widget.ListView.b, q, r {

    /* renamed from: a  reason: collision with root package name */
    private BdListView f1780a;
    private bk b;
    private HotGroupActivity c;
    private View d;
    private HotGroupAdapter e;
    private c f;
    private g g = new b(this);

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void a(Activity activity) {
        super.a(activity);
        if (activity instanceof HotGroupActivity) {
            this.c = (HotGroupActivity) activity;
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.hot_group_fragment, (ViewGroup) null);
        this.f1780a = (BdListView) inflate.findViewById(R.id.hot_group_list);
        this.f1780a.a(this, 300L);
        this.b = new bk(this.c);
        this.b.a(this);
        this.e = new HotGroupAdapter(this.c);
        this.f1780a.setAdapter((ListAdapter) this.e);
        this.f1780a.setPullRefresh(this.b);
        this.f1780a.setOnItemClickListener(this);
        this.f1780a.setOnSrollToBottomListener(this);
        this.d = (FrameLayout) inflate.findViewById(R.id.fragment_parent);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void a(View view, Bundle bundle) {
        super.a(view, bundle);
        H();
    }

    @Override // com.baidu.tieba.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.e.getItem(i);
        if (item != null) {
            if (TiebaApplication.h().t()) {
                StatService.onEvent(this.c, "hot_group_item", "click", 1);
            }
            GroupInfoActivity.a(this.c, item.getGroupId(), 0);
        }
    }

    @Override // com.baidu.tieba.BaseFragment
    public void c(int i) {
        super.c(i);
        this.c.a().a(this.d);
        this.b.a(i);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        e.a().a(103012, this.g);
        e.a().a(-116, this.g);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void e() {
        e.a().a(this.g);
        super.e();
    }

    @Override // com.baidu.adp.widget.ListView.r
    public void a() {
        G();
    }

    private void G() {
        if (this.f.a()) {
            this.f.a(this.e.getCount());
            this.f.d(false);
        }
    }

    private void H() {
        if (this.f == null) {
            this.f = new c();
        }
        this.f.b(true);
        this.f1780a.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        if (this.f1780a != null && this.e != null) {
            ah.a(this.f1780a, this.e.a(), 0, -1);
        }
    }

    @Override // com.baidu.adp.widget.ListView.q
    public void a(int i, int i2) {
        I();
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        this.f.a(0);
        if (this.f.b()) {
            this.f.d(true);
            this.f.b(false);
            return;
        }
        this.f.d(false);
    }
}
