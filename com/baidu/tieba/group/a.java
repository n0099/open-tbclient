package com.baidu.tieba.group;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.ai;
import com.baidu.tieba.barcode.CaptureActivity;
import com.baidu.tieba.im.chat.be;
import com.baidu.tieba.im.creategroup.CreateGroupStepActivity;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.hotGroup.HotGroupActivity;
import com.baidu.tieba.im.message.bl;
import com.baidu.tieba.im.message.bw;
import com.baidu.tieba.im.message.cz;
import com.baidu.tieba.im.message.s;
import com.baidu.tieba.im.mygroup.MyGroupActivity;
import com.baidu.tieba.im.nearbygroups.NearbyGroupsActivity;
import com.baidu.tieba.im.randchat.WaittingActivity;
import com.baidu.tieba.im.searchGroup.AddGroupActivity;
import com.baidu.tieba.j;
import com.baidu.tieba.k;
import com.baidu.tieba.util.cb;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class a extends j implements com.baidu.tieba.im.a.d, com.baidu.tieba.im.messageCenter.g {
    private g b;
    private com.baidu.tieba.im.a.a c;
    private com.baidu.tieba.im.model.c d;
    private k e;

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        e();
        d();
    }

    private void d() {
        this.c = new com.baidu.tieba.im.a.a();
        this.c.c();
        this.c.a(this);
        this.b.a(new b(this));
        this.d = new com.baidu.tieba.im.model.c();
    }

    private void e() {
        this.e = (k) getActivity();
        this.b = new g(this.e, this);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.group_activity, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.j
    public void c(int i) {
        super.c(i);
        ((k) getActivity()).a().a(i == 1);
        this.b.a(i);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        com.baidu.tieba.im.messageCenter.e.a().a(this);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.c != null) {
            this.c.d();
        }
        com.baidu.tieba.im.a.a.a = true;
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (com.baidu.tieba.im.a.a.a) {
            this.b.b();
        }
        com.baidu.tieba.im.messageCenter.e.a().a(this);
        com.baidu.tieba.im.messageCenter.e.a().a(103008, this);
        this.d.a(this);
    }

    private void f() {
        this.d.a(this.d.a());
    }

    @Override // com.baidu.tieba.j, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.b.a) {
            if (!TiebaApplication.B()) {
                LoginActivity.a((Activity) getActivity(), "", true, 1);
                return;
            }
            bl blVar = new bl();
            blVar.a(0L);
            com.baidu.tieba.im.messageCenter.e.a().a(blVar);
        } else if (view.getTag() != null) {
            switch (((Integer) view.getTag()).intValue()) {
                case 1:
                    cb.a(getActivity(), "group_tab_nearby", "onclick", 1, new Object[0]);
                    com.baidu.tieba.im.a.a.a = true;
                    NearbyGroupsActivity.a(getActivity());
                    return;
                case 2:
                    cb.a(getActivity(), "group_tab_hotgroup", "onclick", 1, new Object[0]);
                    HotGroupActivity.a(getActivity());
                    return;
                case 3:
                    if (TextUtils.isEmpty(TiebaApplication.A())) {
                        LoginActivity.a((Activity) getActivity(), "", true, 1);
                        return;
                    }
                    cb.a(getActivity(), "group_tab_mygroup", "onclick", 1, new Object[0]);
                    MyGroupActivity.a(getActivity());
                    return;
                case 4:
                    cb.a(getActivity(), "group_tab_addgroup", "onclick", 1, new Object[0]);
                    AddGroupActivity.a(getActivity());
                    return;
                case 5:
                    cb.a(getActivity(), "group_tab_quickresopnse", "onclick", 1, new Object[0]);
                    CaptureActivity.a(getActivity(), 16003);
                    return;
                case 6:
                    ai.a(this.e, "rand_chat_enter_button");
                    if (!TiebaApplication.B()) {
                        LoginActivity.a((Activity) getActivity(), "", true, 2);
                        return;
                    } else if (g() > 0) {
                        a(getString(R.string.group_tab_enterchatroom_freeze, new StringBuilder(String.valueOf(g())).toString()));
                        return;
                    } else {
                        this.e.a(this.e.getString(R.string.group_tab_enterchatroom_loading), new c(this));
                        f();
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
    public void c() {
        if (this.b != null) {
            this.b.a();
        }
    }

    @Override // com.baidu.tieba.im.a.d
    public void a(int i, int i2, String str, String str2) {
        if (this.b != null) {
            this.b.b(i2);
            this.b.a(str, str2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (this.c != null) {
                    this.c.a();
                    return;
                }
                return;
            case 2:
                if (i2 == -1) {
                    if (g() > 0) {
                        a(getString(R.string.group_tab_enterchatroom_freeze, new StringBuilder(String.valueOf(g())).toString()));
                        return;
                    }
                    this.e.a(this.e.getString(R.string.group_tab_enterchatroom_loading), new d(this));
                    f();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private int g() {
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
    public void a(s sVar) {
        if (sVar.w() == 103008) {
            if (sVar instanceof cz) {
                try {
                    cz czVar = (cz) sVar;
                    if (czVar.l() && czVar.m() > 0) {
                        a(czVar.n());
                    } else {
                        GroupPermData a = czVar.a();
                        if (a != null) {
                            if (a.isCreatePersonal()) {
                                CreateGroupStepActivity.a(getActivity(), 2, 0, 1011, a.getCanCreateNormalNum(), a.getCanCreateOfficialNum(), a.getCanCreatePersonalNum());
                            } else if (!TextUtils.isEmpty(a.getCreatePersonalTip())) {
                                a(a.getCreatePersonalTip());
                            }
                        }
                    }
                } catch (Exception e) {
                }
            }
        } else if (sVar.w() == 106101) {
            this.e.b();
            if (!(sVar instanceof bw)) {
                a(R.string.neterror);
                return;
            }
            bw bwVar = (bw) sVar;
            if (bwVar.l()) {
                if (bwVar.m() > 0) {
                    if (!TextUtils.isEmpty(bwVar.n())) {
                        a(bwVar.n());
                        return;
                    }
                    return;
                }
                a(R.string.neterror);
                return;
            }
            RandChatRoomData a2 = bwVar.a();
            if (a2 != null && a2.e() > 0) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setGid(String.valueOf(a2.d()));
                imMessageCenterPojo.setPulled_msgId(be.b(a2.k()));
                imMessageCenterPojo.setGroup_type(7);
                imMessageCenterPojo.setGroup_name("聊天室");
                imMessageCenterPojo.setIs_delete(0);
                imMessageCenterPojo.setIs_hidden(1);
                com.baidu.tieba.im.util.d.a(imMessageCenterPojo);
                WaittingActivity.a(this.e, a2, 0);
            }
        }
    }
}
