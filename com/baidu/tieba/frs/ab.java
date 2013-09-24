package com.baidu.tieba.frs;

import android.app.Activity;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.CommonWebviewActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.kn.ladders.KnTabActivity;
import com.baidu.tieba.kn.pk.PKingActivity;
import com.baidu.tieba.kn.shake.ShakeActivity;
import com.baidu.tieba.mention.MentionActivity;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.net.URLEncoder;
import java.util.ArrayList;
/* loaded from: classes.dex */
class ab implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1114a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(FrsActivity frsActivity) {
        this.f1114a = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.model.ac acVar;
        com.baidu.tieba.model.ac acVar2;
        com.baidu.tieba.model.ac acVar3;
        String b;
        com.baidu.tieba.model.ac acVar4;
        com.baidu.tieba.data.am amVar;
        com.baidu.tieba.model.ac acVar5;
        com.baidu.tieba.data.am amVar2;
        com.baidu.tieba.model.ac acVar6;
        com.baidu.tieba.model.ac acVar7;
        int i;
        long a2;
        com.baidu.tieba.model.ac acVar8;
        com.baidu.tieba.model.ac acVar9;
        ba baVar;
        boolean z;
        ba baVar2;
        ba baVar3;
        ba baVar4;
        ba baVar5;
        boolean z2;
        ba baVar6;
        String str;
        String str2;
        ba baVar7;
        ba baVar8;
        ba baVar9;
        String str3;
        ba baVar10;
        ba baVar11;
        ba baVar12;
        ba baVar13;
        ba baVar14;
        ba baVar15;
        UtilHelper.NetworkStateInfo i2 = UtilHelper.i(this.f1114a);
        switch (view.getId()) {
            case R.id.show_image /* 2131099859 */:
                this.f1114a.G = false;
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1114a, "frs_image", "frsclick", 1);
                }
                TiebaApplication g = TiebaApplication.g();
                acVar8 = this.f1114a.x;
                g.h(acVar8.a().b());
                FrsActivity frsActivity = this.f1114a;
                acVar9 = this.f1114a.x;
                FrsImageActivity.a(frsActivity, acVar9.a().b(), null, 0);
                this.f1114a.e();
                return;
            case R.id.frs_bt_back /* 2131100106 */:
                this.f1114a.g();
                return;
            case R.id.frs_top_title /* 2131100107 */:
                baVar14 = this.f1114a.o;
                baVar14.d(0);
                return;
            case R.id.frs_top_edit /* 2131100108 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1114a, "frs_post_thread", "frsclick", 1);
                }
                this.f1114a.e(0);
                return;
            case R.id.frs_top_more /* 2131100110 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1114a, "frs_more", "frsclick", 1);
                }
                baVar13 = this.f1114a.o;
                baVar13.a(true);
                return;
            case R.id.frs_bt_create /* 2131100117 */:
                this.f1114a.C();
                return;
            case R.id.refresh_layout /* 2131100118 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1114a, "frs_refresh", "frsclick", 1);
                }
                this.f1114a.D();
                return;
            case R.id.btn_love /* 2131100133 */:
                baVar12 = this.f1114a.o;
                if (!baVar12.f() && i2 != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    this.f1114a.n();
                    return;
                }
                return;
            case R.id.btn_sign /* 2131100139 */:
                baVar10 = this.f1114a.o;
                if (!baVar10.f() && i2 != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    baVar11 = this.f1114a.o;
                    if (!baVar11.o()) {
                        this.f1114a.o();
                        return;
                    }
                    return;
                }
                return;
            case R.id.show_all /* 2131100171 */:
                this.f1114a.G = false;
                baVar4 = this.f1114a.o;
                if (baVar4.b().isMenuShowing()) {
                    baVar6 = this.f1114a.o;
                    baVar6.b().toggle(true);
                }
                baVar5 = this.f1114a.o;
                baVar5.a().a(R.id.show_all);
                z2 = this.f1114a.v;
                if (z2) {
                    this.f1114a.v = false;
                    this.f1114a.D();
                    return;
                }
                return;
            case R.id.show_good /* 2131100173 */:
                this.f1114a.G = false;
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1114a, "frs_good", "frsclick", 1);
                }
                baVar = this.f1114a.o;
                if (baVar.b().isMenuShowing()) {
                    baVar3 = this.f1114a.o;
                    baVar3.b().toggle(true);
                }
                z = this.f1114a.v;
                if (!z) {
                    this.f1114a.v = true;
                    baVar2 = this.f1114a.o;
                    baVar2.a().a(R.id.show_good);
                    this.f1114a.D();
                    return;
                }
                return;
            case R.id.abstract_selection /* 2131100177 */:
                baVar15 = this.f1114a.o;
                baVar15.a().e();
                return;
            case R.id.add_to_window_layout /* 2131100181 */:
                FrsActivity frsActivity2 = this.f1114a;
                str = this.f1114a.e;
                frsActivity2.c(str);
                return;
            case R.id.message_layout /* 2131100185 */:
                String C = TiebaApplication.C();
                if (C != null && C.length() > 0) {
                    if (TiebaApplication.g().s()) {
                        StatService.onEvent(this.f1114a, "frs_message", "frsclick", 1);
                    }
                    MentionActivity.a(this.f1114a, 18002);
                    return;
                }
                return;
            case R.id.like_forum_name /* 2131100191 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1114a, "frs_likeforum", "frsclick", 1);
                }
                String str4 = (String) view.getTag();
                str2 = this.f1114a.e;
                if (str4.equals(str2)) {
                    this.f1114a.G = false;
                    baVar7 = this.f1114a.o;
                    if (baVar7.b().isMenuShowing()) {
                        baVar8 = this.f1114a.o;
                        baVar8.b().toggle(true);
                        return;
                    }
                    return;
                }
                this.f1114a.d(str4);
                return;
            case R.id.add_fan /* 2131100202 */:
                baVar9 = this.f1114a.o;
                if (!baVar9.f() && i2 != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    com.baidu.tieba.model.r a3 = com.baidu.tieba.model.r.a();
                    str3 = this.f1114a.e;
                    a3.b(str3);
                    this.f1114a.m();
                    return;
                }
                return;
            case R.id.kn_title_layout /* 2131100211 */:
                String C2 = TiebaApplication.C();
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1114a, "frs_shake", "frsclick", 1);
                }
                if (C2 != null && C2.length() > 0) {
                    acVar6 = this.f1114a.x;
                    String a4 = acVar6.e().l().a();
                    acVar7 = this.f1114a.x;
                    String b2 = acVar7.e().l().b();
                    try {
                        i = Integer.parseInt(a4);
                    } catch (NumberFormatException e) {
                        i = 0;
                    }
                    if (System.currentTimeMillis() - com.baidu.tieba.kn.a.a().a(i) > 0) {
                        if (i2 == UtilHelper.NetworkStateInfo.UNAVAIL) {
                            this.f1114a.a(this.f1114a.getString(R.string.neterror));
                            return;
                        } else {
                            ShakeActivity.a(this.f1114a, a4, b2, "frs");
                            return;
                        }
                    }
                    com.baidu.tieba.util.i.a(this.f1114a, String.format(this.f1114a.getString(R.string.shake_left_time, new Object[]{new com.baidu.tieba.kn.b((long) ((a2 - System.currentTimeMillis()) / 1000.0d)).toString()}), new Object[0]), 2000);
                    return;
                }
                LoginActivity.a((Activity) this.f1114a, this.f1114a.getString(R.string.login_to_use), true, 11033);
                return;
            case R.id.kn_pk_1_layout /* 2131100219 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1114a, "frs_enter_pk", "frsclick", 1);
                }
                acVar5 = this.f1114a.x;
                ArrayList<com.baidu.tieba.data.am> e2 = acVar5.e().l().e();
                if (e2 != null && e2.size() != 0 && (amVar2 = e2.get(0)) != null) {
                    if (amVar2.e() == 0) {
                        KnTabActivity.a(this.f1114a);
                        return;
                    } else if (amVar2.e() == 1) {
                        PKingActivity.a(this.f1114a, amVar2.a(), amVar2.d());
                        return;
                    } else if (amVar2.e() == 2) {
                        KnTabActivity.a(this.f1114a);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            case R.id.kn_pk_2_layout /* 2131100228 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1114a, "frs_enter_pk", "frsclick", 1);
                }
                acVar4 = this.f1114a.x;
                ArrayList<com.baidu.tieba.data.am> e3 = acVar4.e().l().e();
                if (e3 != null && e3.size() >= 2 && (amVar = e3.get(1)) != null) {
                    if (amVar.e() == 0) {
                        KnTabActivity.a(this.f1114a);
                        return;
                    } else if (amVar.e() == 1) {
                        PKingActivity.a(this.f1114a, amVar.a(), amVar.d());
                        return;
                    } else if (amVar.e() == 2) {
                        KnTabActivity.a(this.f1114a);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            case R.id.kn_relative_video /* 2131100238 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1114a, "frs_enter_video", "frsclick", 1);
                }
                acVar2 = this.f1114a.x;
                String j = acVar2.e().l().j();
                acVar3 = this.f1114a.x;
                if (acVar3.e().l().b() != null) {
                    j = String.valueOf(j) + "&player_name=" + URLEncoder.encode(b);
                }
                CommonWebviewActivity.a(this.f1114a, "相关视频", j, true, "get");
                return;
            case R.id.kn_relative_music /* 2131100241 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1114a, "frs_enter_audio", "frsclick", 1);
                }
                acVar = this.f1114a.x;
                UtilHelper.d(this.f1114a, String.valueOf(acVar.e().l().i()) + "&_client_version=" + com.baidu.tieba.data.g.j());
                return;
            default:
                return;
        }
    }
}
