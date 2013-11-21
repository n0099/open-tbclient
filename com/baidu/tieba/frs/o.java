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
    final /* synthetic */ FrsActivity f1364a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsActivity frsActivity) {
        this.f1364a = frsActivity;
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
        UtilHelper.NetworkStateInfo i = UtilHelper.i(this.f1364a);
        bnVar = this.f1364a.n;
        if (view != bnVar.c()) {
            bnVar2 = this.f1364a.n;
            if (view == bnVar2.a()) {
                bnVar6 = this.f1364a.n;
                bnVar6.d(0);
            } else {
                bnVar3 = this.f1364a.n;
                if (view != bnVar3.b()) {
                    bnVar4 = this.f1364a.n;
                    if (view == bnVar4.d()) {
                        if (TiebaApplication.g().s()) {
                            StatService.onEvent(this.f1364a, "frs_more", "frsclick", 1);
                        }
                        bnVar5 = this.f1364a.n;
                        bnVar5.a(true);
                    }
                } else {
                    this.f1364a.closeActivity();
                }
            }
        } else {
            if (TiebaApplication.g().s()) {
                StatService.onEvent(this.f1364a, "frs_post_thread", "frsclick", 1);
            }
            this.f1364a.b(0);
        }
        switch (view.getId()) {
            case R.id.show_image /* 2131099883 */:
                this.f1364a.G = false;
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1364a, "frs_image", "frsclick", 1);
                }
                TiebaApplication g = TiebaApplication.g();
                akVar7 = this.f1364a.w;
                g.h(akVar7.a().getName());
                FrsActivity frsActivity = this.f1364a;
                str3 = this.f1364a.f;
                FrsImageActivity.a(frsActivity, str3, null, 0);
                this.f1364a.f();
                return;
            case R.id.frs_bt_create /* 2131100167 */:
                this.f1364a.z();
                return;
            case R.id.refresh_layout /* 2131100168 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1364a, "frs_refresh", "frsclick", 1);
                }
                bnVar19 = this.f1364a.n;
                bnVar19.I();
                return;
            case R.id.btn_love /* 2131100182 */:
                bnVar24 = this.f1364a.n;
                if (!bnVar24.k() && i != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    this.f1364a.i();
                    return;
                }
                return;
            case R.id.btn_love_content /* 2131100184 */:
                bnVar7 = this.f1364a.n;
                if (!bnVar7.k()) {
                    z = this.f1364a.K;
                    if (!z) {
                        bnVar8 = this.f1364a.n;
                        if (bnVar8 != null) {
                            str = this.f1364a.C;
                            if (str.equals("normal_page")) {
                                bnVar10 = this.f1364a.n;
                                bnVar10.a(view);
                                return;
                            }
                            str2 = this.f1364a.C;
                            if (str2.equals("frs_page")) {
                                bnVar9 = this.f1364a.n;
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
            case R.id.btn_sign /* 2131100190 */:
                bnVar21 = this.f1364a.n;
                if (!bnVar21.k() && i != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    bnVar22 = this.f1364a.n;
                    if (!bnVar22.x()) {
                        this.f1364a.k();
                        return;
                    }
                    return;
                }
                return;
            case R.id.frs_header_groups /* 2131100199 */:
                akVar = this.f1364a.w;
                if (akVar != null) {
                    akVar2 = this.f1364a.w;
                    if (akVar2.a() != null) {
                        akVar3 = this.f1364a.w;
                        if (!com.baidu.adp.lib.h.e.b(akVar3.a().getId())) {
                            akVar4 = this.f1364a.w;
                            if (akVar4.j() != null) {
                                if (TiebaApplication.g().s()) {
                                    StatService.onEvent(this.f1364a, "im_e_glist_from_frs", "click", 1);
                                }
                                FrsActivity frsActivity2 = this.f1364a;
                                akVar5 = this.f1364a.w;
                                String id = akVar5.a().getId();
                                akVar6 = this.f1364a.w;
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
            case R.id.side_like /* 2131100225 */:
                bnVar23 = this.f1364a.n;
                if (!bnVar23.k() && i != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    akVar8 = this.f1364a.w;
                    if (akVar8.a().isLike() == 0) {
                        this.f1364a.i();
                        return;
                    } else {
                        this.f1364a.j();
                        return;
                    }
                }
                return;
            case R.id.show_all /* 2131100228 */:
                this.f1364a.G = false;
                bnVar14 = this.f1364a.n;
                if (bnVar14.f().isMenuShowing()) {
                    bnVar16 = this.f1364a.n;
                    bnVar16.f().toggle(true);
                }
                bnVar15 = this.f1364a.n;
                bnVar15.e().a(R.id.show_all);
                z3 = this.f1364a.u;
                if (z3) {
                    this.f1364a.u = false;
                    this.f1364a.A();
                    return;
                }
                return;
            case R.id.show_good /* 2131100230 */:
                this.f1364a.G = false;
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1364a, "frs_good", "frsclick", 1);
                }
                bnVar11 = this.f1364a.n;
                if (bnVar11.f().isMenuShowing()) {
                    bnVar13 = this.f1364a.n;
                    bnVar13.f().toggle(true);
                }
                z2 = this.f1364a.u;
                if (!z2) {
                    this.f1364a.u = true;
                    bnVar12 = this.f1364a.n;
                    bnVar12.e().a(R.id.show_good);
                    this.f1364a.A();
                    return;
                }
                return;
            case R.id.add_to_window_layout /* 2131100239 */:
                FrsActivity frsActivity3 = this.f1364a;
                str4 = this.f1364a.f;
                frsActivity3.a(str4);
                return;
            case R.id.message_layout /* 2131100243 */:
                String A = TiebaApplication.A();
                if (A != null && A.length() > 0) {
                    if (TiebaApplication.g().s()) {
                        StatService.onEvent(this.f1364a, "frs_message", "frsclick", 1);
                    }
                    MentionActivity.a(this.f1364a, 18002);
                    return;
                }
                return;
            case R.id.like_forum_name /* 2131100248 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1364a, "frs_likeforum", "frsclick", 1);
                }
                String str7 = (String) view.getTag();
                str5 = this.f1364a.f;
                if (str7.equals(str5)) {
                    this.f1364a.G = false;
                    bnVar17 = this.f1364a.n;
                    if (bnVar17.f().isMenuShowing()) {
                        bnVar18 = this.f1364a.n;
                        bnVar18.f().toggle(true);
                        return;
                    }
                    return;
                }
                this.f1364a.b(str7);
                return;
            case R.id.add_fan /* 2131100261 */:
                bnVar20 = this.f1364a.n;
                if (!bnVar20.k() && i != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    com.baidu.tieba.model.z a2 = com.baidu.tieba.model.z.a();
                    str6 = this.f1364a.f;
                    a2.b(str6);
                    this.f1364a.h();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
