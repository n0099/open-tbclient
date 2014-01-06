package com.baidu.tieba.frs;

import android.app.Activity;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.frsgroup.FrsGroupActivity;
import com.baidu.tieba.mention.MentionActivity;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bo boVar;
        bo boVar2;
        bo boVar3;
        bo boVar4;
        bo boVar5;
        bo boVar6;
        bo boVar7;
        boolean z;
        bo boVar8;
        String str;
        String str2;
        bo boVar9;
        bo boVar10;
        com.baidu.tieba.model.ak akVar;
        com.baidu.tieba.model.ak akVar2;
        com.baidu.tieba.model.ak akVar3;
        com.baidu.tieba.model.ak akVar4;
        com.baidu.tieba.model.ak akVar5;
        com.baidu.tieba.model.ak akVar6;
        com.baidu.tieba.model.ak akVar7;
        String str3;
        bo boVar11;
        boolean z2;
        bo boVar12;
        bo boVar13;
        bo boVar14;
        bo boVar15;
        boolean z3;
        bo boVar16;
        String str4;
        String str5;
        bo boVar17;
        bo boVar18;
        bo boVar19;
        bo boVar20;
        String str6;
        bo boVar21;
        bo boVar22;
        bo boVar23;
        UtilHelper.NetworkStateInfo g = UtilHelper.g(this.a);
        boVar = this.a.n;
        if (view != boVar.c()) {
            boVar2 = this.a.n;
            if (view == boVar2.a()) {
                boVar6 = this.a.n;
                boVar6.d(0);
            } else {
                boVar3 = this.a.n;
                if (view != boVar3.b()) {
                    boVar4 = this.a.n;
                    if (view == boVar4.d()) {
                        if (TiebaApplication.g().s()) {
                            StatService.onEvent(this.a, "frs_more", "frsclick", 1);
                        }
                        boVar5 = this.a.n;
                        boVar5.a(true);
                    }
                } else {
                    this.a.closeActivity();
                }
            }
        } else {
            if (TiebaApplication.g().s()) {
                StatService.onEvent(this.a, "frs_post_thread", "frsclick", 1);
            }
            this.a.b(0);
        }
        switch (view.getId()) {
            case R.id.show_image /* 2131099898 */:
                this.a.F = false;
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.a, "frs_image", "frsclick", 1);
                }
                TiebaApplication g2 = TiebaApplication.g();
                akVar7 = this.a.w;
                g2.i(akVar7.a().getName());
                FrsActivity frsActivity = this.a;
                str3 = this.a.f;
                FrsImageActivity.a(frsActivity, str3, null, 0);
                this.a.g();
                return;
            case R.id.frs_bt_create /* 2131100261 */:
                this.a.A();
                return;
            case R.id.refresh_layout /* 2131100262 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.a, "frs_refresh", "frsclick", 1);
                }
                boVar19 = this.a.n;
                boVar19.L();
                return;
            case R.id.btn_love /* 2131100276 */:
                boVar23 = this.a.n;
                if (!boVar23.m() && g != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    this.a.i();
                    return;
                }
                return;
            case R.id.btn_love_content /* 2131100278 */:
                boVar7 = this.a.n;
                if (!boVar7.m()) {
                    z = this.a.J;
                    if (!z) {
                        boVar8 = this.a.n;
                        if (boVar8 != null) {
                            str = this.a.C;
                            if (str.equals("normal_page")) {
                                boVar10 = this.a.n;
                                boVar10.a(view);
                                return;
                            }
                            str2 = this.a.C;
                            if (str2.equals("frs_page")) {
                                boVar9 = this.a.n;
                                boVar9.b(view);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case R.id.btn_sign /* 2131100284 */:
                boVar21 = this.a.n;
                if (!boVar21.m() && g != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    boVar22 = this.a.n;
                    if (!boVar22.z()) {
                        this.a.k();
                        return;
                    }
                    return;
                }
                return;
            case R.id.frs_header_groups /* 2131100293 */:
                akVar = this.a.w;
                if (akVar != null) {
                    akVar2 = this.a.w;
                    if (akVar2.a() != null) {
                        akVar3 = this.a.w;
                        if (!com.baidu.adp.lib.h.f.b(akVar3.a().getId())) {
                            akVar4 = this.a.w;
                            if (akVar4.j() != null) {
                                if (TiebaApplication.g().s()) {
                                    StatService.onEvent(this.a, "im_e_glist_from_frs", "click", 1);
                                }
                                FrsActivity frsActivity2 = this.a;
                                akVar5 = this.a.w;
                                String id = akVar5.a().getId();
                                akVar6 = this.a.w;
                                FrsGroupActivity.a(frsActivity2, id, akVar6.j().b() != 1);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case R.id.show_all /* 2131100320 */:
                this.a.F = false;
                boVar14 = this.a.n;
                if (boVar14.g().isMenuShowing()) {
                    boVar16 = this.a.n;
                    boVar16.g().toggle(true);
                }
                boVar15 = this.a.n;
                boVar15.f().a(R.id.show_all);
                z3 = this.a.u;
                if (z3) {
                    this.a.u = false;
                    this.a.B();
                    return;
                }
                return;
            case R.id.show_good /* 2131100322 */:
                this.a.F = false;
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.a, "frs_good", "frsclick", 1);
                }
                boVar11 = this.a.n;
                if (boVar11.g().isMenuShowing()) {
                    boVar13 = this.a.n;
                    boVar13.g().toggle(true);
                }
                z2 = this.a.u;
                if (!z2) {
                    this.a.u = true;
                    boVar12 = this.a.n;
                    boVar12.f().a(R.id.show_good);
                    this.a.B();
                    return;
                }
                return;
            case R.id.add_to_window_layout /* 2131100331 */:
                FrsActivity frsActivity3 = this.a;
                str4 = this.a.f;
                frsActivity3.a(str4);
                return;
            case R.id.message_layout /* 2131100335 */:
                String A = TiebaApplication.A();
                if (A != null && A.length() > 0) {
                    if (TiebaApplication.g().s()) {
                        StatService.onEvent(this.a, "frs_message", "frsclick", 1);
                    }
                    MentionActivity.a((Activity) this.a, 18002);
                    return;
                }
                return;
            case R.id.like_forum_name /* 2131100340 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.a, "frs_likeforum", "frsclick", 1);
                }
                String str7 = (String) view.getTag();
                str5 = this.a.f;
                if (str7.equals(str5)) {
                    this.a.F = false;
                    boVar17 = this.a.n;
                    if (boVar17.g().isMenuShowing()) {
                        boVar18 = this.a.n;
                        boVar18.g().toggle(true);
                        return;
                    }
                    return;
                }
                this.a.b(str7);
                return;
            case R.id.add_fan /* 2131100353 */:
                boVar20 = this.a.n;
                if (!boVar20.m() && g != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    com.baidu.tieba.model.z a = com.baidu.tieba.model.z.a();
                    str6 = this.a.f;
                    a.b(str6);
                    this.a.h();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
