package com.baidu.tieba.im.hotGroup;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.w;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.view.q;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
public class HotGroupFragment extends com.baidu.tbadk.core.d implements com.baidu.adp.widget.ListView.d, w, x {
    private BdListView b;
    private q c;
    private HotGroupActivity d;
    private View e;
    private HotGroupAdapter f;
    private d g;
    private com.baidu.adp.framework.listener.b h = new b(this, 0);
    private CustomMessageListener i = new c(this, MessageTypes.CMD_HOT_GROUPS_LOCAL);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof HotGroupActivity) {
            this.d = (HotGroupActivity) activity;
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(com.baidu.tieba.w.hot_group_fragment, (ViewGroup) null);
        this.b = (BdListView) inflate.findViewById(v.hot_group_list);
        this.b.a(this, 300L);
        this.c = new q(this.d);
        this.c.a(this);
        this.f = new HotGroupAdapter(this.d);
        this.b.setAdapter((ListAdapter) this.f);
        this.b.setPullRefresh(this.c);
        this.b.setOnItemClickListener(this);
        this.b.setOnSrollToBottomListener(this);
        this.e = (FrameLayout) inflate.findViewById(v.fragment_parent);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        g();
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.f.getItem(i);
        if (item != null) {
            TiebaStatic.eventStat(this.d, "hot_group_item", "click", 1, new Object[0]);
            this.d.a(new CustomMessage(2010011, new com.baidu.tbadk.core.atomData.q(this.d, item.getGroupId(), 0)));
        }
    }

    @Override // com.baidu.tbadk.core.d
    public void c(int i) {
        super.c(i);
        this.d.a().a(this.e);
        this.c.a(i);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_HOT_GROUPS, this.h);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_UPGRADE_MEMBER_GROUP, this.h);
        MessageManager.getInstance().registerListener(this.i);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroyView() {
        MessageManager.getInstance().unRegisterListener(this.h);
        MessageManager.getInstance().unRegisterListener(this.i);
        super.onDestroyView();
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void f_() {
        f();
    }

    private void f() {
        if (this.g.a()) {
            this.g.a(this.f.getCount());
            this.g.d(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.g == null) {
            this.g = new d();
        }
        this.g.b(true);
        this.b.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.b != null && this.f != null) {
            ae.a(this.b, this.f.a(), 0, -1);
        }
    }

    @Override // com.baidu.adp.widget.ListView.w
    public void a(int i, int i2) {
        h();
    }

    @Override // com.baidu.adp.widget.ListView.d
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
