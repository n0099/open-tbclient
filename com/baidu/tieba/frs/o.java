package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.frsgroup.FrsGroupActivity;
import com.baidu.tieba.mention.MentionActivity;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class o implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1415a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsActivity frsActivity) {
        this.f1415a = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bn bnVar;
        bn bnVar2;
        bn bnVar3;
        bn bnVar4;
        bn bnVar5;
        bn bnVar6;
        bn bnVar7;
        boolean z;
        bn bnVar8;
        String str;
        String str2;
        bn bnVar9;
        bn bnVar10;
        com.baidu.tieba.model.ak akVar;
        com.baidu.tieba.model.ak akVar2;
        com.baidu.tieba.model.ak akVar3;
        com.baidu.tieba.model.ak akVar4;
        com.baidu.tieba.model.ak akVar5;
        com.baidu.tieba.model.ak akVar6;
        com.baidu.tieba.model.ak akVar7;
        String str3;
        bn bnVar11;
        boolean z2;
        bn bnVar12;
        bn bnVar13;
        bn bnVar14;
        bn bnVar15;
        boolean z3;
        bn bnVar16;
        String str4;
        String str5;
        bn bnVar17;
        bn bnVar18;
        bn bnVar19;
        bn bnVar20;
        String str6;
        bn bnVar21;
        bn bnVar22;
        bn bnVar23;
        com.baidu.tieba.model.ak akVar8;
        bn bnVar24;
        UtilHelper.NetworkStateInfo g = UtilHelper.g(this.f1415a);
        bnVar = this.f1415a.n;
        if (view != bnVar.c()) {
            bnVar2 = this.f1415a.n;
            if (view == bnVar2.a()) {
                bnVar6 = this.f1415a.n;
                bnVar6.d(0);
            } else {
                bnVar3 = this.f1415a.n;
                if (view != bnVar3.b()) {
                    bnVar4 = this.f1415a.n;
                    if (view == bnVar4.d()) {
                        if (TiebaApplication.h().t()) {
                            StatService.onEvent(this.f1415a, "frs_more", "frsclick", 1);
                        }
                        bnVar5 = this.f1415a.n;
                        bnVar5.a(true);
                    }
                } else {
                    this.f1415a.closeActivity();
                }
            }
        } else {
            if (TiebaApplication.h().t()) {
                StatService.onEvent(this.f1415a, "frs_post_thread", "frsclick", 1);
            }
            this.f1415a.b(0);
        }
        switch (view.getId()) {
            case R.id.show_image /* 2131099892 */:
                this.f1415a.G = false;
                if (TiebaApplication.h().t()) {
                    StatService.onEvent(this.f1415a, "frs_image", "frsclick", 1);
                }
                TiebaApplication h = TiebaApplication.h();
                akVar7 = this.f1415a.w;
                h.i(akVar7.a().getName());
                FrsActivity frsActivity = this.f1415a;
                str3 = this.f1415a.f;
                FrsImageActivity.a(frsActivity, str3, null, 0);
                this.f1415a.g();
                return;
            case R.id.frs_bt_create /* 2131100186 */:
                this.f1415a.z();
                return;
            case R.id.refresh_layout /* 2131100187 */:
                if (TiebaApplication.h().t()) {
                    StatService.onEvent(this.f1415a, "frs_refresh", "frsclick", 1);
                }
                bnVar19 = this.f1415a.n;
                bnVar19.J();
                return;
            case R.id.btn_love /* 2131100201 */:
                bnVar24 = this.f1415a.n;
                if (!bnVar24.l() && g != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    this.f1415a.i();
                    return;
                }
                return;
            case R.id.btn_love_content /* 2131100203 */:
                bnVar7 = this.f1415a.n;
                if (!bnVar7.l()) {
                    z = this.f1415a.K;
                    if (!z) {
                        bnVar8 = this.f1415a.n;
                        if (bnVar8 != null) {
                            str = this.f1415a.C;
                            if (str.equals("normal_page")) {
                                bnVar10 = this.f1415a.n;
                                bnVar10.a(view);
                                return;
                            }
                            str2 = this.f1415a.C;
                            if (str2.equals("frs_page")) {
                                bnVar9 = this.f1415a.n;
                                bnVar9.b(view);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case R.id.btn_sign /* 2131100209 */:
                bnVar21 = this.f1415a.n;
                if (!bnVar21.l() && g != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    bnVar22 = this.f1415a.n;
                    if (!bnVar22.y()) {
                        this.f1415a.k();
                        return;
                    }
                    return;
                }
                return;
            case R.id.frs_header_groups /* 2131100218 */:
                akVar = this.f1415a.w;
                if (akVar != null) {
                    akVar2 = this.f1415a.w;
                    if (akVar2.a() != null) {
                        akVar3 = this.f1415a.w;
                        if (!com.baidu.adp.lib.h.f.b(akVar3.a().getId())) {
                            akVar4 = this.f1415a.w;
                            if (akVar4.j() != null) {
                                if (TiebaApplication.h().t()) {
                                    StatService.onEvent(this.f1415a, "im_e_glist_from_frs", "click", 1);
                                }
                                FrsActivity frsActivity2 = this.f1415a;
                                akVar5 = this.f1415a.w;
                                String id = akVar5.a().getId();
                                akVar6 = this.f1415a.w;
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
            case R.id.side_like /* 2131100244 */:
                bnVar23 = this.f1415a.n;
                if (!bnVar23.l() && g != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    akVar8 = this.f1415a.w;
                    if (akVar8.a().isLike() == 0) {
                        this.f1415a.i();
                        return;
                    } else {
                        this.f1415a.j();
                        return;
                    }
                }
                return;
            case R.id.show_all /* 2131100247 */:
                this.f1415a.G = false;
                bnVar14 = this.f1415a.n;
                if (bnVar14.g().isMenuShowing()) {
                    bnVar16 = this.f1415a.n;
                    bnVar16.g().toggle(true);
                }
                bnVar15 = this.f1415a.n;
                bnVar15.f().a(R.id.show_all);
                z3 = this.f1415a.u;
                if (z3) {
                    this.f1415a.u = false;
                    this.f1415a.A();
                    return;
                }
                return;
            case R.id.show_good /* 2131100249 */:
                this.f1415a.G = false;
                if (TiebaApplication.h().t()) {
                    StatService.onEvent(this.f1415a, "frs_good", "frsclick", 1);
                }
                bnVar11 = this.f1415a.n;
                if (bnVar11.g().isMenuShowing()) {
                    bnVar13 = this.f1415a.n;
                    bnVar13.g().toggle(true);
                }
                z2 = this.f1415a.u;
                if (!z2) {
                    this.f1415a.u = true;
                    bnVar12 = this.f1415a.n;
                    bnVar12.f().a(R.id.show_good);
                    this.f1415a.A();
                    return;
                }
                return;
            case R.id.add_to_window_layout /* 2131100258 */:
                FrsActivity frsActivity3 = this.f1415a;
                str4 = this.f1415a.f;
                frsActivity3.a(str4);
                return;
            case R.id.message_layout /* 2131100262 */:
                String B = TiebaApplication.B();
                if (B != null && B.length() > 0) {
                    if (TiebaApplication.h().t()) {
                        StatService.onEvent(this.f1415a, "frs_message", "frsclick", 1);
                    }
                    MentionActivity.a(this.f1415a, 18002);
                    return;
                }
                return;
            case R.id.like_forum_name /* 2131100267 */:
                if (TiebaApplication.h().t()) {
                    StatService.onEvent(this.f1415a, "frs_likeforum", "frsclick", 1);
                }
                String str7 = (String) view.getTag();
                str5 = this.f1415a.f;
                if (str7.equals(str5)) {
                    this.f1415a.G = false;
                    bnVar17 = this.f1415a.n;
                    if (bnVar17.g().isMenuShowing()) {
                        bnVar18 = this.f1415a.n;
                        bnVar18.g().toggle(true);
                        return;
                    }
                    return;
                }
                this.f1415a.b(str7);
                return;
            case R.id.add_fan /* 2131100280 */:
                bnVar20 = this.f1415a.n;
                if (!bnVar20.l() && g != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    com.baidu.tieba.model.z a2 = com.baidu.tieba.model.z.a();
                    str6 = this.f1415a.f;
                    a2.b(str6);
                    this.f1415a.h();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
