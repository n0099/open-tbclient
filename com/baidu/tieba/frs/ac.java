package com.baidu.tieba.frs;

import android.app.Activity;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.CommonWebviewActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.kn.pk.PKEndActivity;
import com.baidu.tieba.kn.pk.PKWaitingActivity;
import com.baidu.tieba.kn.pk.PKingActivity;
import com.baidu.tieba.kn.shake.ShakeActivity;
import com.baidu.tieba.mention.MentionActivity;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.net.URLEncoder;
import java.util.ArrayList;
/* loaded from: classes.dex */
class ac implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1067a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(FrsActivity frsActivity) {
        this.f1067a = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.model.aa aaVar;
        com.baidu.tieba.model.aa aaVar2;
        com.baidu.tieba.model.aa aaVar3;
        String b;
        com.baidu.tieba.model.aa aaVar4;
        com.baidu.tieba.data.am amVar;
        com.baidu.tieba.model.aa aaVar5;
        com.baidu.tieba.data.am amVar2;
        com.baidu.tieba.model.aa aaVar6;
        com.baidu.tieba.model.aa aaVar7;
        long a2;
        com.baidu.tieba.model.aa aaVar8;
        com.baidu.tieba.model.aa aaVar9;
        bb bbVar;
        boolean z;
        bb bbVar2;
        bb bbVar3;
        bb bbVar4;
        bb bbVar5;
        boolean z2;
        bb bbVar6;
        String str;
        String str2;
        bb bbVar7;
        bb bbVar8;
        bb bbVar9;
        String str3;
        bb bbVar10;
        bb bbVar11;
        bb bbVar12;
        bb bbVar13;
        bb bbVar14;
        UtilHelper.NetworkStateInfo i = UtilHelper.i(this.f1067a);
        switch (view.getId()) {
            case R.id.frs_bt_back /* 2131100065 */:
                this.f1067a.f();
                return;
            case R.id.frs_top_title /* 2131100066 */:
                bbVar14 = this.f1067a.l;
                bbVar14.d(0);
                return;
            case R.id.frs_top_edit /* 2131100067 */:
                if (TiebaApplication.g().u()) {
                    StatService.onEvent(this.f1067a, "frs_post_thread", "frsclick", 1);
                }
                this.f1067a.e(0);
                return;
            case R.id.frs_top_more /* 2131100069 */:
                if (TiebaApplication.g().u()) {
                    StatService.onEvent(this.f1067a, "frs_more", "frsclick", 1);
                }
                bbVar13 = this.f1067a.l;
                bbVar13.a(true);
                return;
            case R.id.frs_bt_create /* 2131100076 */:
                this.f1067a.z();
                return;
            case R.id.refresh_layout /* 2131100077 */:
                if (TiebaApplication.g().u()) {
                    StatService.onEvent(this.f1067a, "frs_refresh", "frsclick", 1);
                }
                this.f1067a.A();
                return;
            case R.id.btn_love /* 2131100096 */:
                bbVar12 = this.f1067a.l;
                if (!bbVar12.h() && i != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    this.f1067a.l();
                    return;
                }
                return;
            case R.id.btn_sign /* 2131100102 */:
                bbVar10 = this.f1067a.l;
                if (!bbVar10.h() && i != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    bbVar11 = this.f1067a.l;
                    if (!bbVar11.q()) {
                        this.f1067a.m();
                        return;
                    }
                    return;
                }
                return;
            case R.id.show_all /* 2131100127 */:
                this.f1067a.E = false;
                bbVar4 = this.f1067a.l;
                if (bbVar4.b().isMenuShowing()) {
                    bbVar6 = this.f1067a.l;
                    bbVar6.b().toggle(true);
                }
                bbVar5 = this.f1067a.l;
                bbVar5.a().a(R.id.show_all);
                z2 = this.f1067a.t;
                if (z2) {
                    this.f1067a.t = false;
                    this.f1067a.A();
                    return;
                }
                return;
            case R.id.show_good /* 2131100129 */:
                this.f1067a.E = false;
                if (TiebaApplication.g().u()) {
                    StatService.onEvent(this.f1067a, "frs_good", "frsclick", 1);
                }
                bbVar = this.f1067a.l;
                if (bbVar.b().isMenuShowing()) {
                    bbVar3 = this.f1067a.l;
                    bbVar3.b().toggle(true);
                }
                z = this.f1067a.t;
                if (!z) {
                    this.f1067a.t = true;
                    bbVar2 = this.f1067a.l;
                    bbVar2.a().a(R.id.show_good);
                    this.f1067a.A();
                    return;
                }
                return;
            case R.id.show_image /* 2131100131 */:
                this.f1067a.E = false;
                if (TiebaApplication.g().u()) {
                    StatService.onEvent(this.f1067a, "frs_image", "frsclick", 1);
                }
                TiebaApplication g = TiebaApplication.g();
                aaVar8 = this.f1067a.v;
                g.h(aaVar8.a().b());
                FrsActivity frsActivity = this.f1067a;
                aaVar9 = this.f1067a.v;
                FrsImageActivity.a(frsActivity, aaVar9.a().b(), null, 0);
                this.f1067a.d();
                return;
            case R.id.add_to_window_layout /* 2131100139 */:
                FrsActivity frsActivity2 = this.f1067a;
                str = this.f1067a.c;
                frsActivity2.c(str);
                return;
            case R.id.message_layout /* 2131100143 */:
                String E = TiebaApplication.E();
                if (E != null && E.length() > 0) {
                    if (TiebaApplication.g().u()) {
                        StatService.onEvent(this.f1067a, "frs_message", "frsclick", 1);
                    }
                    MentionActivity.a(this.f1067a, 18002);
                    return;
                }
                return;
            case R.id.like_forum_name /* 2131100149 */:
                if (TiebaApplication.g().u()) {
                    StatService.onEvent(this.f1067a, "frs_likeforum", "frsclick", 1);
                }
                String str4 = (String) view.getTag();
                str2 = this.f1067a.c;
                if (str4.equals(str2)) {
                    this.f1067a.E = false;
                    bbVar7 = this.f1067a.l;
                    if (bbVar7.b().isMenuShowing()) {
                        bbVar8 = this.f1067a.l;
                        bbVar8.b().toggle(true);
                        return;
                    }
                    return;
                }
                this.f1067a.d(str4);
                return;
            case R.id.add_fan /* 2131100160 */:
                bbVar9 = this.f1067a.l;
                if (!bbVar9.h() && i != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    com.baidu.tieba.model.p a3 = com.baidu.tieba.model.p.a();
                    str3 = this.f1067a.c;
                    a3.b(str3);
                    this.f1067a.k();
                    return;
                }
                return;
            case R.id.kn_title_layout /* 2131100169 */:
                String E2 = TiebaApplication.E();
                if (TiebaApplication.g().u()) {
                    StatService.onEvent(this.f1067a, "frs_shake", "frsclick", 1);
                }
                if (E2 != null && E2.length() > 0) {
                    aaVar6 = this.f1067a.v;
                    String a4 = aaVar6.e().l().a();
                    aaVar7 = this.f1067a.v;
                    String b2 = aaVar7.e().l().b();
                    if (System.currentTimeMillis() - com.baidu.tieba.kn.a.a().a(Integer.parseInt(a4)) > 0) {
                        if (i == UtilHelper.NetworkStateInfo.UNAVAIL) {
                            this.f1067a.a(this.f1067a.getString(R.string.neterror));
                            return;
                        } else {
                            ShakeActivity.a(this.f1067a, a4, b2, "frs");
                            return;
                        }
                    }
                    com.baidu.tieba.util.i.a(this.f1067a, String.format(this.f1067a.getString(R.string.shake_left_time, new Object[]{new com.baidu.tieba.kn.b((long) ((a2 - System.currentTimeMillis()) / 1000.0d)).toString()}), new Object[0]), 2000);
                    return;
                }
                LoginActivity.a((Activity) this.f1067a, this.f1067a.getString(R.string.login_to_use), true, 11033);
                return;
            case R.id.kn_pk_1_layout /* 2131100177 */:
                if (TiebaApplication.g().u()) {
                    StatService.onEvent(this.f1067a, "frs_enter_pk", "frsclick", 1);
                }
                aaVar5 = this.f1067a.v;
                ArrayList e = aaVar5.e().l().e();
                if (e != null && e.size() != 0 && (amVar2 = (com.baidu.tieba.data.am) e.get(0)) != null) {
                    if (amVar2.e() == 0) {
                        PKWaitingActivity.a(this.f1067a, amVar2.a(), amVar2.d());
                        return;
                    } else if (amVar2.e() == 1) {
                        PKingActivity.a(this.f1067a, amVar2.a(), amVar2.d());
                        return;
                    } else if (amVar2.e() == 2) {
                        PKEndActivity.a(this.f1067a, amVar2.a(), amVar2.d());
                        return;
                    } else {
                        return;
                    }
                }
                return;
            case R.id.kn_pk_2_layout /* 2131100186 */:
                if (TiebaApplication.g().u()) {
                    StatService.onEvent(this.f1067a, "frs_enter_pk", "frsclick", 1);
                }
                aaVar4 = this.f1067a.v;
                ArrayList e2 = aaVar4.e().l().e();
                if (e2 != null && e2.size() >= 2 && (amVar = (com.baidu.tieba.data.am) e2.get(1)) != null) {
                    if (amVar.e() == 0) {
                        PKWaitingActivity.a(this.f1067a, amVar.a(), amVar.d());
                        return;
                    } else if (amVar.e() == 1) {
                        PKingActivity.a(this.f1067a, amVar.a(), amVar.d());
                        return;
                    } else if (amVar.e() == 2) {
                        PKEndActivity.a(this.f1067a, amVar.a(), amVar.d());
                        return;
                    } else {
                        return;
                    }
                }
                return;
            case R.id.kn_relative_video /* 2131100196 */:
                if (TiebaApplication.g().u()) {
                    StatService.onEvent(this.f1067a, "frs_enter_video", "frsclick", 1);
                }
                aaVar2 = this.f1067a.v;
                String j = aaVar2.e().l().j();
                aaVar3 = this.f1067a.v;
                if (aaVar3.e().l().b() != null) {
                    j = String.valueOf(j) + "&player_name=" + URLEncoder.encode(b);
                }
                CommonWebviewActivity.a(this.f1067a, "相关视频", j, true, "get");
                return;
            case R.id.kn_relative_music /* 2131100199 */:
                if (TiebaApplication.g().u()) {
                    StatService.onEvent(this.f1067a, "frs_enter_audio", "frsclick", 1);
                }
                aaVar = this.f1067a.v;
                UtilHelper.d(this.f1067a, String.valueOf(aaVar.e().l().i()) + "&_client_version=" + com.baidu.tieba.data.g.j());
                return;
            default:
                return;
        }
    }
}
