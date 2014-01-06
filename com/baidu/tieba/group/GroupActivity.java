package com.baidu.tieba.group;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.barcode.CaptureActivity;
import com.baidu.tieba.im.a.d;
import com.baidu.tieba.im.creategroup.CreateGroupStepActivity;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.hotGroup.HotGroupActivity;
import com.baidu.tieba.im.message.ax;
import com.baidu.tieba.im.message.cb;
import com.baidu.tieba.im.message.o;
import com.baidu.tieba.im.messageCenter.e;
import com.baidu.tieba.im.messageCenter.g;
import com.baidu.tieba.im.mygroup.MyGroupActivity;
import com.baidu.tieba.im.nearbygroups.NearbyGroupsActivity;
import com.baidu.tieba.im.searchGroup.AddGroupActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class GroupActivity extends BaseFragment implements d, g {
    private b a;
    private com.baidu.tieba.im.a.a b;

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        I();
        H();
    }

    private void H() {
        this.b = new com.baidu.tieba.im.a.a();
        this.b.c();
        this.b.a(this);
        this.a.a(new a(this));
    }

    private void I() {
        this.a = new b((BaseFragmentActivity) i(), this);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.group_activity, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.BaseFragment
    public void c(int i) {
        super.c(i);
        ((BaseFragmentActivity) i()).a().a(i == 1);
        this.a.a(i);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void s() {
        super.s();
        e.a().a(this);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void t() {
        super.t();
        if (this.b != null) {
            this.b.d();
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void r() {
        super.r();
        if (com.baidu.tieba.im.a.a.a) {
            this.a.b();
        }
        e.a().a(this);
        e.a().a(103008, this);
    }

    @Override // com.baidu.tieba.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.a.a) {
            if (!TiebaApplication.B()) {
                LoginActivity.a((Activity) i(), "", true, 1);
                return;
            }
            ax axVar = new ax();
            axVar.a(0L);
            e.a().a(axVar);
            return;
        }
        switch (view.getId()) {
            case R.id.nearby_widget /* 2131100363 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(i(), "group_tab_nearby", "onclick");
                }
                com.baidu.tieba.im.a.a.a = true;
                NearbyGroupsActivity.a(i());
                return;
            case R.id.diver_2 /* 2131100364 */:
            case R.id.diver_3 /* 2131100366 */:
            case R.id.diver_4 /* 2131100367 */:
            case R.id.diver_5 /* 2131100369 */:
            case R.id.diver_6 /* 2131100371 */:
            case R.id.diver_7 /* 2131100372 */:
            default:
                return;
            case R.id.hot_widget /* 2131100365 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(i(), "group_tab_hotgroup", "onclick");
                }
                HotGroupActivity.a(i());
                return;
            case R.id.my_widget /* 2131100368 */:
                if (TextUtils.isEmpty(TiebaApplication.A())) {
                    LoginActivity.a((Activity) i(), "", true, 1);
                    return;
                }
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(i(), "group_tab_mygroup", "onclick");
                }
                MyGroupActivity.a(i());
                return;
            case R.id.addgroup_widget /* 2131100370 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(i(), "group_tab_addgroup", "onclick");
                }
                AddGroupActivity.a(i());
                return;
            case R.id.quick_response_widget /* 2131100373 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(i(), "group_tab_quickresopnse", "onclick");
                }
                CaptureActivity.a(i(), 16003);
                return;
        }
    }

    @Override // com.baidu.tieba.im.a.d
    public void a() {
    }

    @Override // com.baidu.tieba.im.a.d
    public void b(String str) {
        a(str);
    }

    @Override // com.baidu.tieba.im.a.d
    public void G() {
        if (this.a != null) {
            this.a.a();
        }
    }

    @Override // com.baidu.tieba.im.a.d
    public void a(int i, int i2) {
        if (this.a != null) {
            this.a.b(i2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(o oVar) {
        if (oVar.u() == 103008 && (oVar instanceof cb)) {
            try {
                cb cbVar = (cb) oVar;
                if (cbVar.i() && cbVar.j() > 0) {
                    a(cbVar.k());
                } else {
                    GroupPermData a = cbVar.a();
                    if (a != null) {
                        if (a.isCreatePersonal()) {
                            CreateGroupStepActivity.a(i(), 2, 0, 1011, a.getCanCreateNormalNum(), a.getCanCreateOfficialNum(), a.getCanCreatePersonalNum());
                        } else if (!TextUtils.isEmpty(a.getCreatePersonalTip())) {
                            a(a.getCreatePersonalTip());
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
    }
}
