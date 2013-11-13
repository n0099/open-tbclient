package com.baidu.tieba.home;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.groupInfo.GroupInfoActivity;
import com.baidu.tieba.im.searchGroup.SearchGroupActivity;
import com.baidu.tieba.more.AboutActivity;
import com.baidu.tieba.more.AccountActivity;
import com.baidu.tieba.square.SquareSearchActivity;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.write.WriteActivity;
import com.slidingmenu.lib.R;
import java.util.Iterator;
/* loaded from: classes.dex */
public class EnterForumActivity extends BaseFragment implements AbsListView.OnScrollListener, com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    public static int f1388a = 0;
    public static boolean b = false;
    private BaseFragmentActivity i;
    private o c = null;
    private m d = null;
    private com.baidu.tieba.model.t e = null;
    private com.baidu.tieba.data.ae f = null;
    private boolean g = true;
    private Boolean h = false;
    private com.baidu.tieba.im.messageCenter.h Y = new f(this);
    private com.baidu.tieba.im.pushNotify.m Z = new g(this);
    private View.OnClickListener aa = new h(this);
    private com.baidu.tieba.model.w ab = new j(this);
    private View.OnKeyListener ac = new k(this);
    private com.baidu.adp.widget.ListView.b ad = new l(this);

    @Override // com.baidu.tieba.BaseFragment, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface == this.c.u() || dialogInterface == this.c.v()) {
            switch (i) {
                case 0:
                    if (this.f != null) {
                        String b2 = this.f.b();
                        if (com.baidu.tieba.util.be.b(b2)) {
                            FrsActivity.a(this.i, b2, "tb_forumlist");
                            return;
                        }
                        return;
                    }
                    return;
                case 1:
                    I();
                    return;
                default:
                    return;
            }
        }
    }

    private void I() {
        if (this.f != null) {
            if (this.f.e() == 1) {
                this.c.t();
            } else if (this.d == null) {
                this.d = new m(this, this.f);
                this.d.execute(new com.baidu.tieba.data.ae[0]);
            }
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void a(Activity activity) {
        super.a(activity);
        this.i = (BaseFragmentActivity) activity;
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return a(layoutInflater);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        J();
        K();
        if (bundle != null) {
            f1388a = bundle.getInt("curent_tab");
        } else {
            String stringExtra = this.i.getIntent().getStringExtra("curent_tab");
            if (stringExtra != null && TextUtils.isDigitsOnly(stringExtra)) {
                try {
                    f1388a = Integer.valueOf(stringExtra).intValue();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            this.c.a();
        }
        com.baidu.tieba.im.messageCenter.f.a().a(103101, this.Y);
        com.baidu.tieba.im.messageCenter.f.a().a(103112, this.Y);
        com.baidu.tieba.im.messageCenter.f.a().a(103102, this.Y);
        com.baidu.tieba.im.messageCenter.f.a().a(-109, this.Y);
        com.baidu.tieba.im.pushNotify.n.a().a("apply_join_success", this.Z);
        com.baidu.tieba.im.pushNotify.n.a().a("kick_out", this.Z);
        com.baidu.tieba.im.pushNotify.n.a().a("group_intro_change", this.Z);
        com.baidu.tieba.im.pushNotify.n.a().a("group_name_change", this.Z);
        com.baidu.tieba.im.pushNotify.n.a().a("group_level_up", this.Z);
    }

    private View a(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.enter_forum_view, (ViewGroup) null);
    }

    public boolean a() {
        for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) this.i.getSystemService("activity")).getRunningTasks(10)) {
            if (runningTaskInfo.topActivity.getClassName().equals(MainTabActivity.class.getName())) {
                return true;
            }
        }
        return false;
    }

    private void J() {
        this.c = new o(this.i, this, this.ac);
        this.c.a(this.ad);
        this.c.h().setClickStatKey("ef_tb_search");
        this.c.a(this.aa);
    }

    private void K() {
        this.g = true;
        this.h = false;
        this.e = new com.baidu.tieba.model.t();
        this.e.a(this.ab);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void c_() {
        super.c_();
        this.c.j();
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void d() {
        super.d();
        this.c.k();
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void r() {
        super.r();
        if (F()) {
            this.c.l();
            a(false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void a(Menu menu) {
        try {
            menu.findItem(1).setVisible(true);
            if (!TiebaApplication.n()) {
                menu.findItem(2).setVisible(true);
            }
            menu.findItem(3).setVisible(true);
            menu.findItem(4).setVisible(true);
            menu.findItem(5).setVisible(true);
        } catch (Exception e) {
            com.baidu.tieba.util.bg.b("HomeActivity", "onPrepareOptionsMenu", "exp: " + e.toString());
        }
        super.a(menu);
    }

    @Override // android.support.v4.app.Fragment
    public boolean a(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
                MainTabActivity.a(this.i, 4);
                break;
            case 2:
                AccountActivity.a(this.i);
                break;
            case 3:
                AntiData antiData = new AntiData();
                antiData.setIfpost(1);
                WriteActivity.a(this.i, com.baidu.tieba.data.h.h(), com.baidu.tieba.data.h.g(), antiData);
                break;
            case 4:
                AboutActivity.a((Context) this.i);
                break;
            case 5:
                UtilHelper.a((Activity) this.i);
                break;
        }
        return super.a(menuItem);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void s() {
        super.s();
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void t() {
        this.c.m();
        H();
        com.baidu.tieba.im.messageCenter.f.a().a(this.Y);
        com.baidu.tieba.im.pushNotify.n.a().a(this.Z);
        super.t();
    }

    public void G() {
        this.c.n();
    }

    @Override // com.baidu.tieba.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.search_bg_layout) {
            if (f1388a == 0) {
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.i, "ef_tb_search", "click", 1);
                }
                SquareSearchActivity.a(this.i, a(R.string.home));
                return;
            }
            if (TiebaApplication.g().s()) {
                StatService.onEvent(this.i, "cl_search_group", "click", 1);
            }
            SearchGroupActivity.a(this.i);
        } else if (view.getId() == this.c.p() || view.getId() == this.c.q()) {
            com.baidu.tieba.data.ae aeVar = view.getTag() instanceof com.baidu.tieba.data.ae ? (com.baidu.tieba.data.ae) view.getTag() : null;
            if (aeVar != null) {
                String b2 = aeVar.b();
                if (com.baidu.tieba.util.be.b(b2)) {
                    if (TiebaApplication.g().s()) {
                        StatService.onEvent(this.i, "ef_recent", "click", 1);
                    }
                    FrsActivity.a(this.i, b2, "tb_forumlist");
                }
            }
        } else if (view.getId() == R.id.click_head) {
            GroupInfoData groupInfoData = view.getTag() instanceof GroupInfoData ? (GroupInfoData) view.getTag() : null;
            if (groupInfoData != null) {
                GroupInfoActivity.a(this.i, groupInfoData.getGroupId(), 1);
            }
        } else if (view.getId() == R.id.enter_group) {
            f1388a = 1;
            if (this.c != null) {
                this.c.a();
            }
        } else if (view.getId() == R.id.enter_forum) {
            f1388a = 0;
            if (this.c != null) {
                this.c.a();
            }
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view.getId() == this.c.p() || view.getId() == this.c.q()) {
            this.f = null;
            com.baidu.tieba.data.ae aeVar = view.getTag() instanceof com.baidu.tieba.data.ae ? (com.baidu.tieba.data.ae) view.getTag() : null;
            if (aeVar != null) {
                this.f = aeVar;
                String b2 = aeVar.b();
                int e = aeVar.e();
                if (com.baidu.tieba.util.be.b(b2)) {
                    if (e == 1) {
                        this.c.r();
                    } else {
                        this.c.s();
                    }
                }
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
    }

    @Override // com.baidu.tieba.BaseFragment
    public void c(int i) {
        super.c(i);
        this.c.b(i);
    }

    public void H() {
        if (this.d != null) {
            this.d.cancel();
            this.d = null;
        }
        this.e.cancelLoadData();
    }

    public void a(boolean z) {
        boolean z2;
        boolean z3;
        if (this.e != null) {
            boolean booleanValue = this.h.booleanValue();
            this.h = Boolean.valueOf((TiebaApplication.A() == null || TiebaApplication.F() == null) ? false : true);
            if (this.g) {
                this.g = false;
                z2 = true;
                z3 = false;
            } else if (booleanValue != this.h.booleanValue()) {
                z2 = false;
                z3 = true;
            } else {
                z2 = false;
                z3 = false;
            }
            if (TiebaApplication.g().O()) {
                TiebaApplication.g().h(false);
                z3 = true;
            }
            boolean z4 = z ? true : z3;
            if (TiebaApplication.g().j() > 0) {
                if (this.e != null && this.e.a() != null && this.e.a().d() != null) {
                    Iterator<com.baidu.tieba.data.ae> it = this.e.a().d().a().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.data.ae next = it.next();
                        if (TiebaApplication.g().b(next.b())) {
                            next.a(1);
                        }
                    }
                }
                TiebaApplication.g().i();
                String A = TiebaApplication.A();
                if (A != null && A.length() > 0) {
                    DatabaseService.h(A);
                }
                this.c.i();
            }
            if (z2 || z4) {
                H();
                if (z4) {
                    this.c.e();
                } else {
                    if (this.e.b(this.h.booleanValue())) {
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (eVar == null) {
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tieba.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // com.baidu.tieba.BaseFragment, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        return false;
    }
}
