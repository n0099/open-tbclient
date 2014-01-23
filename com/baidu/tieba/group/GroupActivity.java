package com.baidu.tieba.group;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.ao;
import com.baidu.tieba.barcode.CaptureActivity;
import com.baidu.tieba.im.creategroup.CreateGroupStepActivity;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.hotGroup.HotGroupActivity;
import com.baidu.tieba.im.message.bf;
import com.baidu.tieba.im.message.bo;
import com.baidu.tieba.im.message.cq;
import com.baidu.tieba.im.message.q;
import com.baidu.tieba.im.messageCenter.g;
import com.baidu.tieba.im.mygroup.MyGroupActivity;
import com.baidu.tieba.im.nearbygroups.NearbyGroupsActivity;
import com.baidu.tieba.im.randchat.WaittingActivity;
import com.baidu.tieba.im.searchGroup.AddGroupActivity;
import com.baidu.tieba.util.by;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class GroupActivity extends BaseFragment implements com.baidu.tieba.im.a.d, g {
    private f a;
    private com.baidu.tieba.im.a.a b;
    private com.baidu.tieba.im.model.c c;
    private BaseFragmentActivity d;

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
        this.c = new com.baidu.tieba.im.model.c();
    }

    private void I() {
        this.d = (BaseFragmentActivity) i();
        this.a = new f(this.d, this);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.group_activity, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.BaseFragment
    public void d(int i) {
        super.d(i);
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
            this.b.d();
        }
        com.baidu.tieba.im.a.a.a = true;
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void r() {
        super.r();
        if (com.baidu.tieba.im.a.a.a) {
            this.a.b();
        }
        com.baidu.tieba.im.messageCenter.e.a().a(this);
        com.baidu.tieba.im.messageCenter.e.a().a(103008, this);
        this.c.a(this);
    }

    private void J() {
        this.c.a(this.c.a());
    }

    @Override // com.baidu.tieba.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.a.a) {
            if (!TiebaApplication.B()) {
                LoginActivity.a((Activity) i(), "", true, 1);
                return;
            }
            bf bfVar = new bf();
            bfVar.a(0L);
            com.baidu.tieba.im.messageCenter.e.a().a(bfVar);
        } else if (view.getTag() != null) {
            switch (((Integer) view.getTag()).intValue()) {
                case 1:
                    by.a(i(), "group_tab_nearby", "onclick", 1, new Object[0]);
                    com.baidu.tieba.im.a.a.a = true;
                    NearbyGroupsActivity.a(i());
                    return;
                case 2:
                    by.a(i(), "group_tab_hotgroup", "onclick", 1, new Object[0]);
                    HotGroupActivity.a(i());
                    return;
                case 3:
                    if (TextUtils.isEmpty(TiebaApplication.A())) {
                        LoginActivity.a((Activity) i(), "", true, 1);
                        return;
                    }
                    by.a(i(), "group_tab_mygroup", "onclick", 1, new Object[0]);
                    MyGroupActivity.a(i());
                    return;
                case 4:
                    by.a(i(), "group_tab_addgroup", "onclick", 1, new Object[0]);
                    AddGroupActivity.a(i());
                    return;
                case 5:
                    by.a(i(), "group_tab_quickresopnse", "onclick", 1, new Object[0]);
                    CaptureActivity.a(i(), 16003);
                    return;
                case 6:
                    ao.a(this.d, "rand_chat_enter_button");
                    if (!TiebaApplication.B()) {
                        LoginActivity.a((Activity) i(), "", true, 2);
                        return;
                    } else if (K() > 0) {
                        a(a(R.string.group_tab_enterchatroom_freeze, K() + ""));
                        return;
                    } else {
                        this.d.a(this.d.getString(R.string.group_tab_enterchatroom_loading), new b(this));
                        J();
                        return;
                    }
                default:
                    return;
            }
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
    public void a(int i, int i2, String str, String str2) {
        if (this.a != null) {
            this.a.b(i2);
        }
        this.a.a(str, str2);
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
            case 2:
                if (i2 == -1) {
                    if (K() > 0) {
                        a(a(R.string.group_tab_enterchatroom_freeze, K() + ""));
                        return;
                    }
                    this.d.a(this.d.getString(R.string.group_tab_enterchatroom_loading), new c(this));
                    J();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private int K() {
        String[] split;
        String a = com.baidu.tieba.sharedPref.b.a().a("chat_room_cool_down", "");
        if (TextUtils.isEmpty(a) || (split = a.split("_")) == null || split.length != 2) {
            return 0;
        }
        String str = split[0];
        String str2 = split[1];
        String A = TiebaApplication.A();
        if (TextUtils.isEmpty(A) || !A.equals(str)) {
            return 0;
        }
        long a2 = com.baidu.adp.lib.f.b.a(str2, 0L) - System.currentTimeMillis();
        if (a2 > 0) {
            int i = (int) ((a2 / 1000) / 60);
            if (i > 0) {
                return i;
            }
            return 1;
        }
        return 0;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(q qVar) {
        if (qVar.w() == 103008) {
            if (qVar instanceof cq) {
                try {
                    cq cqVar = (cq) qVar;
                    if (cqVar.k() && cqVar.l() > 0) {
                        a(cqVar.m());
                    } else {
                        GroupPermData a = cqVar.a();
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
        } else if (qVar.w() == 106101) {
            this.d.b();
            if (!(qVar instanceof bo)) {
                c(R.string.neterror);
                return;
            }
            bo boVar = (bo) qVar;
            if (boVar.k()) {
                if (boVar.l() > 0) {
                    if (!TextUtils.isEmpty(boVar.m())) {
                        a(boVar.m());
                        return;
                    }
                    return;
                }
                c(R.string.neterror);
                return;
            }
            RandChatRoomData a2 = boVar.a();
            if (a2 != null && a2.e() > 0) {
                com.baidu.tieba.im.d.c.a(a2);
                WaittingActivity.a(this.d, a2, 0);
            }
        }
    }
}
