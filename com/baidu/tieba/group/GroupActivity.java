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
import com.baidu.tieba.im.a.e;
import com.baidu.tieba.im.creategroup.CreateGroupStepActivity;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.hotGroup.HotGroupActivity;
import com.baidu.tieba.im.message.au;
import com.baidu.tieba.im.message.by;
import com.baidu.tieba.im.message.n;
import com.baidu.tieba.im.messageCenter.g;
import com.baidu.tieba.im.mygroup.MyGroupActivity;
import com.baidu.tieba.im.nearbygroups.NearbyGroupsActivity;
import com.baidu.tieba.im.searchGroup.AddGroupActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class GroupActivity extends BaseFragment implements e, g {
    private a a;
    private com.baidu.tieba.im.a.a b;

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        G();
        a();
    }

    private void a() {
        this.b = new com.baidu.tieba.im.a.a();
        this.b.b();
        this.b.a(this);
    }

    private void G() {
        this.a = new a((BaseFragmentActivity) i(), this);
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
        com.baidu.tieba.im.messageCenter.e.a().a(this);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void t() {
        super.t();
        if (this.b != null) {
            this.b.c();
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void r() {
        super.r();
        if (com.baidu.tieba.im.a.a.a) {
            this.b.a();
        }
        com.baidu.tieba.im.messageCenter.e.a().a(this);
        com.baidu.tieba.im.messageCenter.e.a().a(103008, this);
    }

    @Override // com.baidu.tieba.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.a.a) {
            if (!TiebaApplication.C()) {
                LoginActivity.a((Activity) i(), "", true, 1);
                return;
            }
            au auVar = new au();
            auVar.a(0L);
            com.baidu.tieba.im.messageCenter.e.a().a(auVar);
            return;
        }
        switch (view.getId()) {
            case R.id.nearby_widget /* 2131100284 */:
                if (TiebaApplication.h().t()) {
                    StatService.onEvent(i(), "group_tab_nearby", "onclick");
                }
                com.baidu.tieba.im.a.a.a = true;
                NearbyGroupsActivity.a(i());
                return;
            case R.id.diver_2 /* 2131100285 */:
            case R.id.diver_3 /* 2131100287 */:
            case R.id.diver_4 /* 2131100288 */:
            case R.id.diver_5 /* 2131100290 */:
            case R.id.diver_6 /* 2131100292 */:
            case R.id.diver_7 /* 2131100293 */:
            default:
                return;
            case R.id.hot_widget /* 2131100286 */:
                if (TiebaApplication.h().t()) {
                    StatService.onEvent(i(), "group_tab_hotgroup", "onclick");
                }
                HotGroupActivity.a(i());
                return;
            case R.id.my_widget /* 2131100289 */:
                if (TextUtils.isEmpty(TiebaApplication.B())) {
                    LoginActivity.a((Activity) i(), "", true, 1);
                    return;
                }
                if (TiebaApplication.h().t()) {
                    StatService.onEvent(i(), "group_tab_mygroup", "onclick");
                }
                MyGroupActivity.a(i());
                return;
            case R.id.addgroup_widget /* 2131100291 */:
                if (TiebaApplication.h().t()) {
                    StatService.onEvent(i(), "group_tab_addgroup", "onclick");
                }
                AddGroupActivity.a(i());
                return;
            case R.id.quick_response_widget /* 2131100294 */:
                if (TiebaApplication.h().t()) {
                    StatService.onEvent(i(), "group_tab_quickresopnse", "onclick");
                }
                CaptureActivity.a(i(), 16003);
                return;
        }
    }

    @Override // com.baidu.tieba.im.a.e
    public void a(int i, int i2) {
        this.a.b(i2);
    }

    @Override // android.support.v4.app.Fragment
    public void a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        switch (i) {
            case 1:
                if (this.b != null) {
                    this.b.a();
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(n nVar) {
        if (nVar.t() == 103008 && (nVar instanceof by)) {
            try {
                by byVar = (by) nVar;
                if (byVar.i() && byVar.j() > 0) {
                    a(byVar.k());
                } else {
                    GroupPermData a = byVar.a();
                    if (a != null) {
                        if (a.isCreatePersonal()) {
                            CreateGroupStepActivity.a(i(), 2, 0, 1011);
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
