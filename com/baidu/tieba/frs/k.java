package com.baidu.tieba.frs;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.frsgroup.FrsGroupActivity;
import com.baidu.tieba.mention.MentionActivity;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.by;
import com.baidu.tieba.view.FrsHeaderView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        bk bkVar4;
        bk bkVar5;
        bk bkVar6;
        com.baidu.tieba.model.ak akVar;
        bk bkVar7;
        bk bkVar8;
        bk bkVar9;
        boolean z;
        bk bkVar10;
        String str;
        String str2;
        bk bkVar11;
        bk bkVar12;
        com.baidu.tieba.model.ak akVar2;
        com.baidu.tieba.model.ak akVar3;
        com.baidu.tieba.model.ak akVar4;
        com.baidu.tieba.model.ak akVar5;
        com.baidu.tieba.model.ak akVar6;
        com.baidu.tieba.model.ak akVar7;
        com.baidu.tieba.model.ak akVar8;
        String str3;
        bk bkVar13;
        boolean z2;
        bk bkVar14;
        bk bkVar15;
        bk bkVar16;
        bk bkVar17;
        boolean z3;
        bk bkVar18;
        com.baidu.tieba.model.ak akVar9;
        String str4;
        com.baidu.tieba.model.ak akVar10;
        com.baidu.tieba.model.ak akVar11;
        String str5;
        String str6;
        bk bkVar19;
        bk bkVar20;
        bk bkVar21;
        bk bkVar22;
        String str7;
        bk bkVar23;
        bk bkVar24;
        bk bkVar25;
        UtilHelper.NetworkStateInfo g = UtilHelper.g(this.a);
        bkVar = this.a.n;
        if (view != bkVar.c()) {
            bkVar2 = this.a.n;
            if (view == bkVar2.a()) {
                bkVar8 = this.a.n;
                bkVar8.d(0);
            } else {
                bkVar3 = this.a.n;
                if (view != bkVar3.b()) {
                    bkVar4 = this.a.n;
                    if (view != bkVar4.d()) {
                        bkVar5 = this.a.n;
                        FrsHeaderView o = bkVar5.o();
                        bkVar6 = this.a.n;
                        com.baidu.tieba.view.ao p = bkVar6.p();
                        if ((o != null && o.b(view)) || (p != null && p.b(view))) {
                            com.baidu.tieba.as.a(this.a.getParent(), "forum_fortune_click");
                            FrsActivity frsActivity = this.a;
                            StringBuilder append = new StringBuilder().append(com.baidu.tieba.data.h.a).append("/mo/q/fudaiindex").append("?fid=");
                            akVar = this.a.w;
                            UtilHelper.c(frsActivity, append.append(akVar.b().getId()).toString());
                        }
                    } else {
                        by.a(this.a, "frs_more", "frsclick", 1, new Object[0]);
                        bkVar7 = this.a.n;
                        bkVar7.a(true);
                    }
                } else {
                    this.a.closeActivity();
                }
            }
        } else {
            by.a(this.a, "frs_post_thread", "frsclick", 1, new Object[0]);
            this.a.b(0);
        }
        switch (view.getId()) {
            case R.id.show_image /* 2131099933 */:
                this.a.F = false;
                by.a(this.a, "frs_image", "frsclick", 1, new Object[0]);
                TiebaApplication h = TiebaApplication.h();
                akVar8 = this.a.w;
                h.h(akVar8.b().getName());
                FrsActivity frsActivity2 = this.a;
                str3 = this.a.f;
                FrsImageActivity.a(frsActivity2, str3, null, 0);
                this.a.g();
                return;
            case R.id.frs_bt_create /* 2131100321 */:
                this.a.y();
                return;
            case R.id.refresh_layout /* 2131100322 */:
                by.a(this.a, "frs_refresh", "frsclick", 1, new Object[0]);
                bkVar21 = this.a.n;
                bkVar21.I();
                return;
            case R.id.btn_love /* 2131100338 */:
                bkVar25 = this.a.n;
                if (!bkVar25.m() && g != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    this.a.i();
                    return;
                }
                return;
            case R.id.btn_love_content /* 2131100340 */:
                bkVar9 = this.a.n;
                if (!bkVar9.m()) {
                    z = this.a.J;
                    if (!z) {
                        bkVar10 = this.a.n;
                        if (bkVar10 != null) {
                            str = this.a.C;
                            if (str.equals("normal_page")) {
                                bkVar12 = this.a.n;
                                bkVar12.a(view);
                                return;
                            }
                            str2 = this.a.C;
                            if (str2.equals("frs_page")) {
                                bkVar11 = this.a.n;
                                bkVar11.b(view);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case R.id.btn_sign /* 2131100346 */:
                bkVar23 = this.a.n;
                if (!bkVar23.m() && g != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    bkVar24 = this.a.n;
                    if (!bkVar24.z()) {
                        this.a.k();
                        return;
                    }
                    return;
                }
                return;
            case R.id.frs_header_groups /* 2131100355 */:
                akVar2 = this.a.w;
                if (akVar2 != null) {
                    akVar3 = this.a.w;
                    if (akVar3.b() != null) {
                        akVar4 = this.a.w;
                        if (!com.baidu.adp.lib.g.f.b(akVar4.b().getId())) {
                            akVar5 = this.a.w;
                            if (akVar5.k() != null) {
                                by.a(this.a, "im_e_glist_from_frs", "click", 1, new Object[0]);
                                FrsActivity frsActivity3 = this.a;
                                akVar6 = this.a.w;
                                String id = akVar6.b().getId();
                                akVar7 = this.a.w;
                                FrsGroupActivity.a(frsActivity3, id, akVar7.k().b() != 1);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case R.id.show_all /* 2131100386 */:
                this.a.F = false;
                bkVar16 = this.a.n;
                if (bkVar16.g().isMenuShowing()) {
                    bkVar18 = this.a.n;
                    bkVar18.g().toggle(true);
                }
                bkVar17 = this.a.n;
                bkVar17.f().a(R.id.show_all);
                z3 = this.a.u;
                if (z3) {
                    this.a.u = false;
                    this.a.z();
                    return;
                }
                return;
            case R.id.show_good /* 2131100388 */:
                this.a.F = false;
                by.a(this.a, "frs_good", "frsclick", 1, new Object[0]);
                bkVar13 = this.a.n;
                if (bkVar13.g().isMenuShowing()) {
                    bkVar15 = this.a.n;
                    bkVar15.g().toggle(true);
                }
                z2 = this.a.u;
                if (!z2) {
                    this.a.u = true;
                    bkVar14 = this.a.n;
                    bkVar14.f().a(R.id.show_good);
                    this.a.z();
                    return;
                }
                return;
            case R.id.manage_mode /* 2131100392 */:
                String str8 = "";
                akVar9 = this.a.w;
                if (akVar9 != null) {
                    akVar10 = this.a.w;
                    if (akVar10.b() != null) {
                        akVar11 = this.a.w;
                        str8 = akVar11.b().getId();
                    }
                }
                StringBuilder append2 = new StringBuilder().append("http://tieba.baidu.com/mo/q/bawuindex?fn=");
                str4 = this.a.f;
                String sb = append2.append(str4).append("&fid=").append(str8).toString();
                com.baidu.tieba.as.a(this.a.getParent(), "forum_management_click");
                UtilHelper.c(this.a, sb);
                return;
            case R.id.add_to_window_layout /* 2131100399 */:
                FrsActivity frsActivity4 = this.a;
                str5 = this.a.f;
                frsActivity4.a(str5);
                return;
            case R.id.message_layout /* 2131100403 */:
                String A = TiebaApplication.A();
                if (A != null && A.length() > 0) {
                    by.a(this.a, "frs_message", "frsclick", 1, new Object[0]);
                    MentionActivity.a((Activity) this.a, 18002);
                    return;
                }
                return;
            case R.id.like_forum_name /* 2131100408 */:
                by.a(this.a, "frs_likeforum", "frsclick", 1, new Object[0]);
                String str9 = (String) view.getTag();
                str6 = this.a.f;
                if (str9.equals(str6)) {
                    this.a.F = false;
                    bkVar19 = this.a.n;
                    if (bkVar19.g().isMenuShowing()) {
                        bkVar20 = this.a.n;
                        bkVar20.g().toggle(true);
                        return;
                    }
                    return;
                }
                this.a.b(str9);
                return;
            case R.id.add_fan /* 2131100421 */:
                bkVar22 = this.a.n;
                if (!bkVar22.m() && g != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    com.baidu.tieba.model.z a = com.baidu.tieba.model.z.a();
                    str7 = this.a.f;
                    a.b(str7);
                    this.a.h();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
