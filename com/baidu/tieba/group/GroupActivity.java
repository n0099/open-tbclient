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
import com.baidu.tieba.im.c.e;
import com.baidu.tieba.im.hotGroup.HotGroupActivity;
import com.baidu.tieba.im.mygroup.MyGroupActivity;
import com.baidu.tieba.im.nearbygroups.NearbyGroupsActivity;
import com.baidu.tieba.im.searchGroup.AddGroupActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class GroupActivity extends BaseFragment implements e {

    /* renamed from: a  reason: collision with root package name */
    private a f1427a;
    private com.baidu.tieba.im.c.a b;

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        G();
        a();
    }

    private void a() {
        this.b = new com.baidu.tieba.im.c.a();
        this.b.b();
        this.b.a(this);
    }

    private void G() {
        this.f1427a = new a((BaseFragmentActivity) i(), this);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.group_activity, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.BaseFragment
    public void c(int i) {
        super.c(i);
        ((BaseFragmentActivity) i()).a().a(i == 1);
        this.f1427a.a(i);
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
        if (TiebaApplication.C() && com.baidu.tieba.im.c.a.f1527a) {
            this.b.a();
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.nearby_widget /* 2131100288 */:
                if (TiebaApplication.h().t()) {
                    StatService.onEvent(i(), "group_tab_nearby", "onclick");
                }
                com.baidu.tieba.im.c.a.f1527a = true;
                NearbyGroupsActivity.a(i());
                return;
            case R.id.diver_2 /* 2131100289 */:
            case R.id.diver_3 /* 2131100291 */:
            case R.id.diver_4 /* 2131100292 */:
            case R.id.diver_5 /* 2131100294 */:
            case R.id.diver_6 /* 2131100296 */:
            case R.id.diver_7 /* 2131100297 */:
            default:
                return;
            case R.id.hot_widget /* 2131100290 */:
                if (TiebaApplication.h().t()) {
                    StatService.onEvent(i(), "group_tab_hotgroup", "onclick");
                }
                HotGroupActivity.a(i());
                return;
            case R.id.my_widget /* 2131100293 */:
                if (TextUtils.isEmpty(TiebaApplication.B())) {
                    LoginActivity.a((Activity) i(), "", true, 1);
                    return;
                }
                if (TiebaApplication.h().t()) {
                    StatService.onEvent(i(), "group_tab_mygroup", "onclick");
                }
                MyGroupActivity.a(i());
                return;
            case R.id.addgroup_widget /* 2131100295 */:
                if (TiebaApplication.h().t()) {
                    StatService.onEvent(i(), "group_tab_addgroup", "onclick");
                }
                AddGroupActivity.a(i());
                return;
            case R.id.quick_response_widget /* 2131100298 */:
                if (TiebaApplication.h().t()) {
                    StatService.onEvent(i(), "group_tab_quickresopnse", "onclick");
                }
                CaptureActivity.a(i(), 16003);
                return;
        }
    }

    @Override // com.baidu.tieba.im.c.e
    public void a(int i, int i2) {
        this.f1427a.b(i2);
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
}
