package com.baidu.tieba.im.frsgroup;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseDismissGroupMessage;
import com.baidu.tieba.view.bk;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsGroupListFragment extends BaseFragment implements AbsListView.OnScrollListener, com.baidu.adp.widget.ListView.r, com.baidu.tieba.im.messageCenter.g, com.baidu.tieba.im.pushNotify.k {
    private int Y;
    private boolean Z;

    /* renamed from: a  reason: collision with root package name */
    private FrsGroupActivity f1695a;
    private Runnable aa = new e(this);
    private com.baidu.tieba.im.messageCenter.g ab = new f(this);
    private com.baidu.tieba.im.model.b b;
    private g c;
    private BdListView d;
    private Button e;
    private bk f;
    private InitGuideView g;
    private GroupListAdapter h;
    private Handler i;

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.f1695a = (FrsGroupActivity) i();
        this.b = this.f1695a.c();
        this.c = this.f1695a.d();
        this.i = new Handler();
        this.b.a(this.ab);
        com.baidu.tieba.im.messageCenter.e.a().a(103104, this);
        com.baidu.tieba.im.pushNotify.l.a().a("dismiss_group", this);
    }

    private void G() {
        this.b.a(this.ab);
        if (!this.b.b(g()) || this.Z) {
            J();
        }
    }

    private void H() {
        this.b.b(this.ab);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void b(boolean z) {
        if (z) {
            H();
        } else {
            G();
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.im_frsgroup_list, (ViewGroup) null);
        this.g = (InitGuideView) inflate.findViewById(R.id.group_guide);
        this.e = (Button) inflate.findViewById(R.id.guide_create);
        this.d = (BdListView) inflate.findViewById(R.id.group_list);
        this.f = new bk(this.f1695a);
        this.d.setPullRefresh(this.f);
        this.h = new GroupListAdapter(this.f1695a);
        this.d.setAdapter((ListAdapter) this.h);
        this.d.setOnScrollListener(this);
        this.d.setOnSrollToBottomListener(this);
        this.f.a(new b(this));
        this.d.setOnItemClickListener(new c(this));
        this.e.setOnClickListener(new d(this));
        this.g.setCreateButton(this.e);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void a(View view, Bundle bundle) {
        super.a(view, bundle);
        K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int I() {
        switch (this.b.g()) {
            case 1:
            default:
                return 4;
            case 2:
                return 5;
            case 3:
                return 6;
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void c_() {
        super.c_();
        if (this.g.b()) {
            this.g.f();
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void d() {
        super.d();
        this.g.g();
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void t() {
        super.t();
        this.b.b(this.ab);
        com.baidu.tieba.im.messageCenter.e.a().a(this);
        com.baidu.tieba.im.pushNotify.l.a().a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            this.b.a(this.b.m(), this.b.j(), this.b.k(), this.b.l(), this.b.b(), this.b.c());
        } else {
            this.b.b(this.b.m(), this.b.j(), this.b.k(), this.b.l(), this.b.b(), this.b.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        this.b.f();
        this.b.a(true);
        this.h.a(false);
        this.Y = 0;
        this.b.b(0);
        this.b.d(50);
        this.d.b();
    }

    private void K() {
        this.b.f();
        this.b.a(false);
        this.Y = 0;
        this.g.a();
        this.h.a(true);
        this.b.b(0);
        this.b.d(50);
        this.d.b();
    }

    @Override // com.baidu.adp.widget.ListView.r
    public void a() {
        L();
    }

    private void L() {
        if (this.h.c()) {
            a(true);
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            if (this.i != null) {
                this.i.removeCallbacks(this.aa);
                this.i.postDelayed(this.aa, 300L);
            }
        } else if (this.i != null) {
            this.i.removeCallbacks(this.aa);
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        if (this.b.h()) {
            this.d.a();
        }
    }

    @Override // com.baidu.tieba.BaseFragment
    public void c(int i) {
        super.c(i);
        if (i == 1) {
            this.d.setDivider(j().getDrawable(R.drawable.list_divider_1));
        } else {
            this.d.setDivider(j().getDrawable(R.drawable.list_divider));
        }
        this.f.a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        if (this.g.b()) {
            this.g.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        if (this.i != null) {
            this.i.removeCallbacks(this.aa);
            this.i.postDelayed(this.aa, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z) {
        int an = TiebaApplication.h().an();
        if (!z) {
            this.d.setDivider(j().getDrawable(17170445));
        } else if (an == 1) {
            this.d.setDivider(j().getDrawable(R.drawable.list_divider_1));
        } else {
            this.d.setDivider(j().getDrawable(R.drawable.list_divider));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        e(false);
        this.g.f();
        switch (this.b.g()) {
            case 1:
                this.g.c();
                return;
            case 2:
                this.g.a(this.b.d());
                return;
            case 3:
                this.g.b(this.b.d());
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(Message message) {
        if (message instanceof ResponseDismissGroupMessage) {
            ResponseDismissGroupMessage responseDismissGroupMessage = (ResponseDismissGroupMessage) message;
            if (!responseDismissGroupMessage.hasError()) {
                a(responseDismissGroupMessage.getGroupId());
            }
        }
    }

    @Override // com.baidu.tieba.im.pushNotify.k
    public void a(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            String cmd = groupNewsPojo.getCmd();
            if (!TextUtils.isEmpty(cmd) && cmd.equals("dismiss_group")) {
                a(Long.parseLong(groupNewsPojo.getGid()));
            }
        }
    }

    private void a(long j) {
        ArrayList<GroupInfoData> a2 = this.h.a();
        if (a2 != null) {
            int size = a2.size();
            for (int i = 0; i < size; i++) {
                if (a2.get(i).getGroupId() == j) {
                    if (F()) {
                        J();
                        return;
                    } else {
                        this.Z = true;
                        return;
                    }
                }
            }
        }
    }
}
