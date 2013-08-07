package com.baidu.tieba.frs;

import android.app.Activity;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.CommonWebviewActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.chat.ChatListActivity;
import com.baidu.tieba.kn.pk.PKEndActivity;
import com.baidu.tieba.kn.pk.PKWaitingActivity;
import com.baidu.tieba.kn.pk.PKingActivity;
import com.baidu.tieba.kn.shake.ShakeActivity;
import com.baidu.tieba.mention.MentionActivity;
import com.baidu.tieba.util.NetWorkCore;
import com.slidingmenu.lib.R;
import java.net.URLEncoder;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1051a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(FrsActivity frsActivity) {
        this.f1051a = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.model.aa aaVar;
        com.baidu.tieba.model.aa aaVar2;
        com.baidu.tieba.model.aa aaVar3;
        String b;
        com.baidu.tieba.model.aa aaVar4;
        com.baidu.tieba.model.aa aaVar5;
        com.baidu.tieba.model.aa aaVar6;
        com.baidu.tieba.model.aa aaVar7;
        long a2;
        com.baidu.tieba.model.aa aaVar8;
        com.baidu.tieba.model.aa aaVar9;
        az azVar;
        boolean z;
        az azVar2;
        az azVar3;
        az azVar4;
        az azVar5;
        boolean z2;
        az azVar6;
        String str;
        String str2;
        az azVar7;
        az azVar8;
        az azVar9;
        az azVar10;
        az azVar11;
        switch (view.getId()) {
            case R.id.frs_bt_back /* 2131100025 */:
                this.f1051a.f();
                return;
            case R.id.frs_top_title /* 2131100026 */:
                azVar11 = this.f1051a.l;
                azVar11.d(0);
                return;
            case R.id.frs_top_edit /* 2131100027 */:
                if (TiebaApplication.f().t()) {
                    StatService.onEvent(this.f1051a, "frs_post_thread", "frsclick", 1);
                }
                this.f1051a.e(0);
                return;
            case R.id.frs_top_more /* 2131100029 */:
                if (TiebaApplication.f().t()) {
                    StatService.onEvent(this.f1051a, "frs_more", "frsclick", 1);
                }
                azVar10 = this.f1051a.l;
                azVar10.a(true);
                return;
            case R.id.frs_bt_create /* 2131100036 */:
                this.f1051a.v();
                return;
            case R.id.refresh_layout /* 2131100037 */:
                if (TiebaApplication.f().t()) {
                    StatService.onEvent(this.f1051a, "frs_refresh", "frsclick", 1);
                }
                this.f1051a.w();
                return;
            case R.id.btn_love /* 2131100056 */:
                this.f1051a.l();
                return;
            case R.id.btn_sign /* 2131100062 */:
                azVar9 = this.f1051a.l;
                if (!azVar9.o()) {
                    this.f1051a.m();
                    return;
                }
                return;
            case R.id.show_all /* 2131100086 */:
                this.f1051a.E = false;
                azVar4 = this.f1051a.l;
                if (azVar4.b().isMenuShowing()) {
                    azVar6 = this.f1051a.l;
                    azVar6.b().toggle(true);
                }
                azVar5 = this.f1051a.l;
                azVar5.a().a(R.id.show_all);
                z2 = this.f1051a.t;
                if (z2) {
                    this.f1051a.t = false;
                    this.f1051a.w();
                    return;
                }
                return;
            case R.id.show_good /* 2131100088 */:
                this.f1051a.E = false;
                if (TiebaApplication.f().t()) {
                    StatService.onEvent(this.f1051a, "frs_good", "frsclick", 1);
                }
                azVar = this.f1051a.l;
                if (azVar.b().isMenuShowing()) {
                    azVar3 = this.f1051a.l;
                    azVar3.b().toggle(true);
                }
                z = this.f1051a.t;
                if (!z) {
                    this.f1051a.t = true;
                    azVar2 = this.f1051a.l;
                    azVar2.a().a(R.id.show_good);
                    this.f1051a.w();
                    return;
                }
                return;
            case R.id.show_image /* 2131100090 */:
                this.f1051a.E = false;
                if (TiebaApplication.f().t()) {
                    StatService.onEvent(this.f1051a, "frs_image", "frsclick", 1);
                }
                TiebaApplication f = TiebaApplication.f();
                aaVar8 = this.f1051a.v;
                f.e(aaVar8.a().b());
                FrsActivity frsActivity = this.f1051a;
                aaVar9 = this.f1051a.v;
                FrsImageActivity.a(frsActivity, aaVar9.a().b(), null, 0);
                this.f1051a.d();
                return;
            case R.id.add_to_window_layout /* 2131100098 */:
                FrsActivity frsActivity2 = this.f1051a;
                str = this.f1051a.c;
                frsActivity2.c(str);
                return;
            case R.id.message_layout /* 2131100102 */:
                String E = TiebaApplication.E();
                if (E != null && E.length() > 0) {
                    if (TiebaApplication.f().t()) {
                        StatService.onEvent(this.f1051a, "frs_message", "frsclick", 1);
                    }
                    MentionActivity.a(this.f1051a, 18002);
                    return;
                }
                return;
            case R.id.chat_layout /* 2131100106 */:
                if (TiebaApplication.f().t()) {
                    StatService.onEvent(this.f1051a, "enter_chatlist", "frsclick", 1);
                }
                ChatListActivity.a(this.f1051a);
                return;
            case R.id.like_forum_name /* 2131100111 */:
                if (TiebaApplication.f().t()) {
                    StatService.onEvent(this.f1051a, "frs_likeforum", "frsclick", 1);
                }
                String str3 = (String) view.getTag();
                str2 = this.f1051a.c;
                if (str3.equals(str2)) {
                    this.f1051a.E = false;
                    azVar7 = this.f1051a.l;
                    if (azVar7.b().isMenuShowing()) {
                        azVar8 = this.f1051a.l;
                        azVar8.b().toggle(true);
                        return;
                    }
                    return;
                }
                this.f1051a.d(str3);
                return;
            case R.id.kn_title_layout /* 2131100131 */:
                String E2 = TiebaApplication.E();
                if (TiebaApplication.f().t()) {
                    StatService.onEvent(this.f1051a, "frs_shake", "frsclick", 1);
                }
                if (E2 != null && E2.length() > 0) {
                    aaVar6 = this.f1051a.v;
                    String a3 = aaVar6.e().l().a();
                    aaVar7 = this.f1051a.v;
                    String b2 = aaVar7.e().l().b();
                    if (System.currentTimeMillis() - com.baidu.tieba.kn.a.a().a(Integer.parseInt(a3)) > 0) {
                        if (NetWorkCore.c(this.f1051a) == NetWorkCore.NetworkStateInfo.UNAVAIL) {
                            this.f1051a.a(this.f1051a.getString(R.string.neterror));
                            return;
                        } else {
                            ShakeActivity.a(this.f1051a, a3, b2, "frs");
                            return;
                        }
                    }
                    com.baidu.tieba.util.i.a(this.f1051a, String.format(this.f1051a.getString(R.string.shake_left_time, new Object[]{new com.baidu.tieba.kn.b((long) ((a2 - System.currentTimeMillis()) / 1000.0d)).toString()}), new Object[0]), 2000);
                    return;
                }
                LoginActivity.a((Activity) this.f1051a, this.f1051a.getString(R.string.login_to_use), true, 11033);
                return;
            case R.id.kn_pk_1_layout /* 2131100139 */:
                if (TiebaApplication.f().t()) {
                    StatService.onEvent(this.f1051a, "frs_enter_pk", "frsclick", 1);
                }
                aaVar5 = this.f1051a.v;
                com.baidu.tieba.data.aq aqVar = (com.baidu.tieba.data.aq) aaVar5.e().l().e().get(0);
                if (aqVar != null) {
                    if (aqVar.e() == 0) {
                        PKWaitingActivity.a(this.f1051a, aqVar.a(), aqVar.d());
                        return;
                    } else if (aqVar.e() == 1) {
                        PKingActivity.a(this.f1051a, aqVar.a(), aqVar.d());
                        return;
                    } else if (aqVar.e() == 2) {
                        PKEndActivity.a(this.f1051a, aqVar.a(), aqVar.d());
                        return;
                    } else {
                        return;
                    }
                }
                return;
            case R.id.kn_pk_2_layout /* 2131100148 */:
                if (TiebaApplication.f().t()) {
                    StatService.onEvent(this.f1051a, "frs_enter_pk", "frsclick", 1);
                }
                aaVar4 = this.f1051a.v;
                com.baidu.tieba.data.aq aqVar2 = (com.baidu.tieba.data.aq) aaVar4.e().l().e().get(1);
                if (aqVar2 != null) {
                    if (aqVar2.e() == 0) {
                        PKWaitingActivity.a(this.f1051a, aqVar2.a(), aqVar2.d());
                        return;
                    } else if (aqVar2.e() == 1) {
                        PKingActivity.a(this.f1051a, aqVar2.a(), aqVar2.d());
                        return;
                    } else if (aqVar2.e() == 2) {
                        PKEndActivity.a(this.f1051a, aqVar2.a(), aqVar2.d());
                        return;
                    } else {
                        return;
                    }
                }
                return;
            case R.id.kn_relative_video /* 2131100158 */:
                if (TiebaApplication.f().t()) {
                    StatService.onEvent(this.f1051a, "frs_enter_video", "frsclick", 1);
                }
                aaVar2 = this.f1051a.v;
                String j = aaVar2.e().l().j();
                aaVar3 = this.f1051a.v;
                if (aaVar3.e().l().b() != null) {
                    j = String.valueOf(j) + "&player_name=" + URLEncoder.encode(b);
                }
                CommonWebviewActivity.a(this.f1051a, "相关视频", j, true, "get");
                return;
            case R.id.kn_relative_music /* 2131100161 */:
                if (TiebaApplication.f().t()) {
                    StatService.onEvent(this.f1051a, "frs_enter_audio", "frsclick", 1);
                }
                aaVar = this.f1051a.v;
                com.baidu.tieba.util.am.d(this.f1051a, String.valueOf(aaVar.e().l().i()) + "&_client_version=" + com.baidu.tieba.data.g.i());
                return;
            default:
                return;
        }
    }
}
