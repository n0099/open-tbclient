package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.mention.MentionActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class bj implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1392a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(FrsImageActivity frsImageActivity) {
        this.f1392a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bl blVar;
        bl blVar2;
        bl blVar3;
        bl blVar4;
        bl blVar5;
        bl blVar6;
        com.baidu.tieba.model.ar arVar;
        bl blVar7;
        bl blVar8;
        boolean z;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        bl blVar9;
        bl blVar10;
        blVar = this.f1392a.l;
        if (view == blVar.c()) {
            this.f1392a.a(0);
        } else {
            blVar2 = this.f1392a.l;
            if (view == blVar2.a()) {
                blVar6 = this.f1392a.l;
                blVar6.e().scrollTo(0, 0);
            } else {
                blVar3 = this.f1392a.l;
                if (view == blVar3.b()) {
                    this.f1392a.closeActivity();
                } else {
                    blVar4 = this.f1392a.l;
                    if (view == blVar4.d()) {
                        if (TiebaApplication.h().t()) {
                            StatService.onEvent(this.f1392a, "frs_more", "frsclick", 1);
                        }
                        blVar5 = this.f1392a.l;
                        blVar5.b(true);
                    }
                }
            }
        }
        switch (view.getId()) {
            case R.id.show_image /* 2131099892 */:
                this.f1392a.p = false;
                if (TiebaApplication.h().t()) {
                    StatService.onEvent(this.f1392a, "frs_image", "frsclick", 1);
                }
                blVar7 = this.f1392a.l;
                if (blVar7.g().isMenuShowing()) {
                    blVar8 = this.f1392a.l;
                    blVar8.g().toggle(true);
                    z = this.f1392a.p;
                    if (z) {
                        this.f1392a.p = false;
                        this.f1392a.c(1);
                        return;
                    }
                    return;
                }
                return;
            case R.id.side_like /* 2131100244 */:
                arVar = this.f1392a.r;
                if (arVar.a().isLike() == 0) {
                    this.f1392a.b();
                    return;
                } else {
                    this.f1392a.c();
                    return;
                }
            case R.id.show_all /* 2131100247 */:
                this.f1392a.p = false;
                TiebaApplication h = TiebaApplication.h();
                str3 = this.f1392a.b;
                h.j(str3);
                FrsImageActivity frsImageActivity = this.f1392a;
                str4 = this.f1392a.b;
                FrsActivity.a(frsImageActivity, str4, null, 0);
                this.f1392a.a();
                return;
            case R.id.show_good /* 2131100249 */:
                this.f1392a.p = false;
                if (TiebaApplication.h().t()) {
                    StatService.onEvent(this.f1392a, "frs_good", "frsclick", 1);
                }
                TiebaApplication h2 = TiebaApplication.h();
                str = this.f1392a.b;
                h2.j(str);
                FrsImageActivity frsImageActivity2 = this.f1392a;
                str2 = this.f1392a.b;
                FrsActivity.b(frsImageActivity2, str2, null);
                this.f1392a.a();
                return;
            case R.id.add_to_window_layout /* 2131100258 */:
                FrsImageActivity frsImageActivity3 = this.f1392a;
                str5 = this.f1392a.b;
                frsImageActivity3.b(str5);
                return;
            case R.id.message_layout /* 2131100262 */:
                String B = TiebaApplication.B();
                if (B != null && B.length() > 0) {
                    if (TiebaApplication.h().t()) {
                        StatService.onEvent(this.f1392a, "frs_message", "frsclick", 1);
                    }
                    MentionActivity.a(this.f1392a, 18002);
                    return;
                }
                return;
            case R.id.like_forum_name /* 2131100267 */:
                if (TiebaApplication.h().t()) {
                    StatService.onEvent(this.f1392a, "frs_likeforum", "frsclick", 1);
                }
                String str7 = (String) view.getTag();
                str6 = this.f1392a.b;
                if (str7.equals(str6)) {
                    this.f1392a.p = false;
                    blVar9 = this.f1392a.l;
                    if (blVar9.g().isMenuShowing()) {
                        blVar10 = this.f1392a.l;
                        blVar10.g().toggle(true);
                        return;
                    }
                    return;
                }
                FrsActivity.a(this.f1392a, str7, (String) null);
                this.f1392a.a();
                return;
            default:
                return;
        }
    }
}
