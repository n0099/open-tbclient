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
class l implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1288a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsActivity frsActivity) {
        this.f1288a = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.model.ak akVar;
        com.baidu.tieba.model.ak akVar2;
        com.baidu.tieba.model.ak akVar3;
        String b;
        com.baidu.tieba.model.ak akVar4;
        com.baidu.tieba.data.am amVar;
        com.baidu.tieba.model.ak akVar5;
        com.baidu.tieba.data.am amVar2;
        com.baidu.tieba.model.ak akVar6;
        com.baidu.tieba.model.ak akVar7;
        int i;
        long a2;
        com.baidu.tieba.model.ak akVar8;
        com.baidu.tieba.model.ak akVar9;
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
        UtilHelper.NetworkStateInfo i2 = UtilHelper.i(this.f1288a);
        switch (view.getId()) {
            case R.id.show_image /* 2131099862 */:
                this.f1288a.G = false;
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1288a, "frs_image", "frsclick", 1);
                }
                TiebaApplication g = TiebaApplication.g();
                akVar8 = this.f1288a.x;
                g.h(akVar8.a().getName());
                FrsActivity frsActivity = this.f1288a;
                akVar9 = this.f1288a.x;
                FrsImageActivity.a(frsActivity, akVar9.a().getName(), null, 0);
                this.f1288a.e();
                return;
            case R.id.frs_bt_back /* 2131100145 */:
                this.f1288a.h();
                return;
            case R.id.frs_top_title /* 2131100146 */:
                baVar14 = this.f1288a.o;
                baVar14.d(0);
                return;
            case R.id.frs_top_edit /* 2131100147 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1288a, "frs_post_thread", "frsclick", 1);
                }
                this.f1288a.e(0);
                return;
            case R.id.frs_top_more /* 2131100149 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1288a, "frs_more", "frsclick", 1);
                }
                baVar13 = this.f1288a.o;
                baVar13.a(true);
                return;
            case R.id.frs_bt_create /* 2131100156 */:
                this.f1288a.B();
                return;
            case R.id.refresh_layout /* 2131100157 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1288a, "frs_refresh", "frsclick", 1);
                }
                this.f1288a.C();
                return;
            case R.id.btn_love /* 2131100179 */:
                baVar12 = this.f1288a.o;
                if (!baVar12.g() && i2 != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    this.f1288a.n();
                    return;
                }
                return;
            case R.id.btn_sign /* 2131100185 */:
                baVar10 = this.f1288a.o;
                if (!baVar10.g() && i2 != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    baVar11 = this.f1288a.o;
                    if (!baVar11.p()) {
                        this.f1288a.o();
                        return;
                    }
                    return;
                }
                return;
            case R.id.show_all /* 2131100218 */:
                this.f1288a.G = false;
                baVar4 = this.f1288a.o;
                if (baVar4.b().isMenuShowing()) {
                    baVar6 = this.f1288a.o;
                    baVar6.b().toggle(true);
                }
                baVar5 = this.f1288a.o;
                baVar5.a().a(R.id.show_all);
                z2 = this.f1288a.v;
                if (z2) {
                    this.f1288a.v = false;
                    this.f1288a.C();
                    return;
                }
                return;
            case R.id.show_good /* 2131100220 */:
                this.f1288a.G = false;
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1288a, "frs_good", "frsclick", 1);
                }
                baVar = this.f1288a.o;
                if (baVar.b().isMenuShowing()) {
                    baVar3 = this.f1288a.o;
                    baVar3.b().toggle(true);
                }
                z = this.f1288a.v;
                if (!z) {
                    this.f1288a.v = true;
                    baVar2 = this.f1288a.o;
                    baVar2.a().a(R.id.show_good);
                    this.f1288a.C();
                    return;
                }
                return;
            case R.id.abstract_selection /* 2131100224 */:
                baVar15 = this.f1288a.o;
                baVar15.a().g();
                return;
            case R.id.add_to_window_layout /* 2131100228 */:
                FrsActivity frsActivity2 = this.f1288a;
                str = this.f1288a.e;
                frsActivity2.c(str);
                return;
            case R.id.message_layout /* 2131100232 */:
                String C = TiebaApplication.C();
                if (C != null && C.length() > 0) {
                    if (TiebaApplication.g().s()) {
                        StatService.onEvent(this.f1288a, "frs_message", "frsclick", 1);
                    }
                    MentionActivity.a(this.f1288a, 18002);
                    return;
                }
                return;
            case R.id.like_forum_name /* 2131100238 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1288a, "frs_likeforum", "frsclick", 1);
                }
                String str4 = (String) view.getTag();
                str2 = this.f1288a.e;
                if (str4.equals(str2)) {
                    this.f1288a.G = false;
                    baVar7 = this.f1288a.o;
                    if (baVar7.b().isMenuShowing()) {
                        baVar8 = this.f1288a.o;
                        baVar8.b().toggle(true);
                        return;
                    }
                    return;
                }
                this.f1288a.d(str4);
                return;
            case R.id.add_fan /* 2131100249 */:
                baVar9 = this.f1288a.o;
                if (!baVar9.g() && i2 != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    com.baidu.tieba.model.z a3 = com.baidu.tieba.model.z.a();
                    str3 = this.f1288a.e;
                    a3.b(str3);
                    this.f1288a.f();
                    return;
                }
                return;
            case R.id.kn_title_layout /* 2131100258 */:
                String C2 = TiebaApplication.C();
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1288a, "frs_shake", "frsclick", 1);
                }
                if (C2 != null && C2.length() > 0) {
                    akVar6 = this.f1288a.x;
                    String a4 = akVar6.e().l().a();
                    akVar7 = this.f1288a.x;
                    String b2 = akVar7.e().l().b();
                    try {
                        i = Integer.parseInt(a4);
                    } catch (NumberFormatException e) {
                        i = 0;
                    }
                    if (System.currentTimeMillis() - com.baidu.tieba.kn.a.a().a(i) > 0) {
                        if (i2 == UtilHelper.NetworkStateInfo.UNAVAIL) {
                            this.f1288a.a(this.f1288a.getString(R.string.neterror));
                            return;
                        } else {
                            ShakeActivity.a(this.f1288a, a4, b2, "frs");
                            return;
                        }
                    }
                    this.f1288a.a(String.format(this.f1288a.getString(R.string.shake_left_time, new Object[]{new com.baidu.tieba.kn.b((long) ((a2 - System.currentTimeMillis()) / 1000.0d)).toString()}), new Object[0]));
                    return;
                }
                LoginActivity.a((Activity) this.f1288a, this.f1288a.getString(R.string.login_to_use), true, 11033);
                return;
            case R.id.kn_pk_1_layout /* 2131100266 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1288a, "frs_enter_pk", "frsclick", 1);
                }
                akVar5 = this.f1288a.x;
                ArrayList<com.baidu.tieba.data.am> e2 = akVar5.e().l().e();
                if (e2 != null && e2.size() != 0 && (amVar2 = e2.get(0)) != null) {
                    if (amVar2.e() == 0) {
                        KnTabActivity.a(this.f1288a);
                        return;
                    } else if (amVar2.e() == 1) {
                        PKingActivity.a(this.f1288a, amVar2.a(), amVar2.d());
                        return;
                    } else if (amVar2.e() == 2) {
                        KnTabActivity.a(this.f1288a);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            case R.id.kn_pk_2_layout /* 2131100275 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1288a, "frs_enter_pk", "frsclick", 1);
                }
                akVar4 = this.f1288a.x;
                ArrayList<com.baidu.tieba.data.am> e3 = akVar4.e().l().e();
                if (e3 != null && e3.size() >= 2 && (amVar = e3.get(1)) != null) {
                    if (amVar.e() == 0) {
                        KnTabActivity.a(this.f1288a);
                        return;
                    } else if (amVar.e() == 1) {
                        PKingActivity.a(this.f1288a, amVar.a(), amVar.d());
                        return;
                    } else if (amVar.e() == 2) {
                        KnTabActivity.a(this.f1288a);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            case R.id.kn_relative_video /* 2131100285 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1288a, "frs_enter_video", "frsclick", 1);
                }
                akVar2 = this.f1288a.x;
                String j = akVar2.e().l().j();
                akVar3 = this.f1288a.x;
                if (akVar3.e().l().b() != null) {
                    j = j + "&player_name=" + URLEncoder.encode(b);
                }
                CommonWebviewActivity.a(this.f1288a, "相关视频", j, true, "get");
                return;
            case R.id.kn_relative_music /* 2131100288 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1288a, "frs_enter_audio", "frsclick", 1);
                }
                akVar = this.f1288a.x;
                UtilHelper.d(this.f1288a, akVar.e().l().i() + "&_client_version=" + com.baidu.tieba.data.h.j());
                return;
            default:
                return;
        }
    }
}
