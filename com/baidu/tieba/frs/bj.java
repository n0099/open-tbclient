package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.mention.MentionActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class bj implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1336a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(FrsImageActivity frsImageActivity) {
        this.f1336a = frsImageActivity;
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
        blVar = this.f1336a.l;
        if (view == blVar.c()) {
            this.f1336a.a(0);
        } else {
            blVar2 = this.f1336a.l;
            if (view == blVar2.a()) {
                blVar6 = this.f1336a.l;
                blVar6.e().scrollTo(0, 0);
            } else {
                blVar3 = this.f1336a.l;
                if (view == blVar3.b()) {
                    this.f1336a.closeActivity();
                } else {
                    blVar4 = this.f1336a.l;
                    if (view == blVar4.d()) {
                        if (TiebaApplication.g().s()) {
                            StatService.onEvent(this.f1336a, "frs_more", "frsclick", 1);
                        }
                        blVar5 = this.f1336a.l;
                        blVar5.b(true);
                    }
                }
            }
        }
        switch (view.getId()) {
            case R.id.show_image /* 2131099882 */:
                this.f1336a.p = false;
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1336a, "frs_image", "frsclick", 1);
                }
                blVar7 = this.f1336a.l;
                if (blVar7.g().isMenuShowing()) {
                    blVar8 = this.f1336a.l;
                    blVar8.g().toggle(true);
                    z = this.f1336a.p;
                    if (z) {
                        this.f1336a.p = false;
                        this.f1336a.c(1);
                        return;
                    }
                    return;
                }
                return;
            case R.id.side_like /* 2131100231 */:
                arVar = this.f1336a.r;
                if (arVar.a().isLike() == 0) {
                    this.f1336a.b();
                    return;
                } else {
                    this.f1336a.c();
                    return;
                }
            case R.id.show_all /* 2131100234 */:
                this.f1336a.p = false;
                TiebaApplication g = TiebaApplication.g();
                str3 = this.f1336a.b;
                g.i(str3);
                FrsImageActivity frsImageActivity = this.f1336a;
                str4 = this.f1336a.b;
                FrsActivity.a(frsImageActivity, str4, null, 0);
                this.f1336a.a();
                return;
            case R.id.show_good /* 2131100236 */:
                this.f1336a.p = false;
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1336a, "frs_good", "frsclick", 1);
                }
                TiebaApplication g2 = TiebaApplication.g();
                str = this.f1336a.b;
                g2.i(str);
                FrsImageActivity frsImageActivity2 = this.f1336a;
                str2 = this.f1336a.b;
                FrsActivity.b(frsImageActivity2, str2, null);
                this.f1336a.a();
                return;
            case R.id.add_to_window_layout /* 2131100245 */:
                FrsImageActivity frsImageActivity3 = this.f1336a;
                str5 = this.f1336a.b;
                frsImageActivity3.b(str5);
                return;
            case R.id.message_layout /* 2131100249 */:
                String A = TiebaApplication.A();
                if (A != null && A.length() > 0) {
                    if (TiebaApplication.g().s()) {
                        StatService.onEvent(this.f1336a, "frs_message", "frsclick", 1);
                    }
                    MentionActivity.a(this.f1336a, 18002);
                    return;
                }
                return;
            case R.id.like_forum_name /* 2131100255 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1336a, "frs_likeforum", "frsclick", 1);
                }
                String str7 = (String) view.getTag();
                str6 = this.f1336a.b;
                if (str7.equals(str6)) {
                    this.f1336a.p = false;
                    blVar9 = this.f1336a.l;
                    if (blVar9.g().isMenuShowing()) {
                        blVar10 = this.f1336a.l;
                        blVar10.g().toggle(true);
                        return;
                    }
                    return;
                }
                FrsActivity.a(this.f1336a, str7, (String) null);
                this.f1336a.a();
                return;
            default:
                return;
        }
    }
}
