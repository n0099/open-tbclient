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
    final /* synthetic */ FrsActivity f1359a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsActivity frsActivity) {
        this.f1359a = frsActivity;
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
        String str6;
        bn bnVar20;
        bn bnVar21;
        bn bnVar22;
        com.baidu.tieba.model.ak akVar8;
        bn bnVar23;
        UtilHelper.NetworkStateInfo i = UtilHelper.i(this.f1359a);
        bnVar = this.f1359a.n;
        if (view != bnVar.c()) {
            bnVar2 = this.f1359a.n;
            if (view == bnVar2.a()) {
                bnVar6 = this.f1359a.n;
                bnVar6.d(0);
            } else {
                bnVar3 = this.f1359a.n;
                if (view != bnVar3.b()) {
                    bnVar4 = this.f1359a.n;
                    if (view == bnVar4.d()) {
                        if (TiebaApplication.g().s()) {
                            StatService.onEvent(this.f1359a, "frs_more", "frsclick", 1);
                        }
                        bnVar5 = this.f1359a.n;
                        bnVar5.a(true);
                    }
                } else {
                    this.f1359a.closeActivity();
                }
            }
        } else {
            if (TiebaApplication.g().s()) {
                StatService.onEvent(this.f1359a, "frs_post_thread", "frsclick", 1);
            }
            this.f1359a.b(0);
        }
        switch (view.getId()) {
            case R.id.show_image /* 2131099882 */:
                this.f1359a.G = false;
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1359a, "frs_image", "frsclick", 1);
                }
                TiebaApplication g = TiebaApplication.g();
                akVar7 = this.f1359a.w;
                g.h(akVar7.a().getName());
                FrsActivity frsActivity = this.f1359a;
                str3 = this.f1359a.f;
                FrsImageActivity.a(frsActivity, str3, null, 0);
                this.f1359a.e();
                return;
            case R.id.frs_bt_create /* 2131100173 */:
                this.f1359a.z();
                return;
            case R.id.refresh_layout /* 2131100174 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1359a, "frs_refresh", "frsclick", 1);
                }
                this.f1359a.A();
                return;
            case R.id.btn_love /* 2131100188 */:
                bnVar23 = this.f1359a.n;
                if (!bnVar23.k() && i != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    this.f1359a.h();
                    return;
                }
                return;
            case R.id.btn_love_content /* 2131100190 */:
                bnVar7 = this.f1359a.n;
                if (!bnVar7.k()) {
                    z = this.f1359a.K;
                    if (!z) {
                        bnVar8 = this.f1359a.n;
                        if (bnVar8 != null) {
                            str = this.f1359a.C;
                            if (str.equals("normal_page")) {
                                bnVar10 = this.f1359a.n;
                                bnVar10.a(view);
                                return;
                            }
                            str2 = this.f1359a.C;
                            if (str2.equals("frs_page")) {
                                bnVar9 = this.f1359a.n;
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
            case R.id.btn_sign /* 2131100196 */:
                bnVar20 = this.f1359a.n;
                if (!bnVar20.k() && i != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    bnVar21 = this.f1359a.n;
                    if (!bnVar21.x()) {
                        this.f1359a.j();
                        return;
                    }
                    return;
                }
                return;
            case R.id.frs_header_groups /* 2131100205 */:
                akVar = this.f1359a.w;
                if (akVar != null) {
                    akVar2 = this.f1359a.w;
                    if (akVar2.a() != null) {
                        akVar3 = this.f1359a.w;
                        if (!com.baidu.adp.lib.h.e.b(akVar3.a().getId())) {
                            akVar4 = this.f1359a.w;
                            if (akVar4.j() != null) {
                                if (TiebaApplication.g().s()) {
                                    StatService.onEvent(this.f1359a, "im_e_glist_from_frs", "click", 1);
                                }
                                FrsActivity frsActivity2 = this.f1359a;
                                akVar5 = this.f1359a.w;
                                String id = akVar5.a().getId();
                                akVar6 = this.f1359a.w;
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
            case R.id.side_like /* 2131100231 */:
                bnVar22 = this.f1359a.n;
                if (!bnVar22.k() && i != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    akVar8 = this.f1359a.w;
                    if (akVar8.a().isLike() == 0) {
                        this.f1359a.h();
                        return;
                    } else {
                        this.f1359a.i();
                        return;
                    }
                }
                return;
            case R.id.show_all /* 2131100234 */:
                this.f1359a.G = false;
                bnVar14 = this.f1359a.n;
                if (bnVar14.f().isMenuShowing()) {
                    bnVar16 = this.f1359a.n;
                    bnVar16.f().toggle(true);
                }
                bnVar15 = this.f1359a.n;
                bnVar15.e().a(R.id.show_all);
                z3 = this.f1359a.u;
                if (z3) {
                    this.f1359a.u = false;
                    this.f1359a.A();
                    return;
                }
                return;
            case R.id.show_good /* 2131100236 */:
                this.f1359a.G = false;
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1359a, "frs_good", "frsclick", 1);
                }
                bnVar11 = this.f1359a.n;
                if (bnVar11.f().isMenuShowing()) {
                    bnVar13 = this.f1359a.n;
                    bnVar13.f().toggle(true);
                }
                z2 = this.f1359a.u;
                if (!z2) {
                    this.f1359a.u = true;
                    bnVar12 = this.f1359a.n;
                    bnVar12.e().a(R.id.show_good);
                    this.f1359a.A();
                    return;
                }
                return;
            case R.id.add_to_window_layout /* 2131100245 */:
                FrsActivity frsActivity3 = this.f1359a;
                str4 = this.f1359a.f;
                frsActivity3.a(str4);
                return;
            case R.id.message_layout /* 2131100249 */:
                String A = TiebaApplication.A();
                if (A != null && A.length() > 0) {
                    if (TiebaApplication.g().s()) {
                        StatService.onEvent(this.f1359a, "frs_message", "frsclick", 1);
                    }
                    MentionActivity.a(this.f1359a, 18002);
                    return;
                }
                return;
            case R.id.like_forum_name /* 2131100255 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1359a, "frs_likeforum", "frsclick", 1);
                }
                String str7 = (String) view.getTag();
                str5 = this.f1359a.f;
                if (str7.equals(str5)) {
                    this.f1359a.G = false;
                    bnVar17 = this.f1359a.n;
                    if (bnVar17.f().isMenuShowing()) {
                        bnVar18 = this.f1359a.n;
                        bnVar18.f().toggle(true);
                        return;
                    }
                    return;
                }
                this.f1359a.b(str7);
                return;
            case R.id.add_fan /* 2131100268 */:
                bnVar19 = this.f1359a.n;
                if (!bnVar19.k() && i != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    com.baidu.tieba.model.z a2 = com.baidu.tieba.model.z.a();
                    str6 = this.f1359a.f;
                    a2.b(str6);
                    this.f1359a.f();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
