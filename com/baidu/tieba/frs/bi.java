package com.baidu.tieba.frs;

import android.app.Activity;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.mention.MentionActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class bi implements View.OnClickListener {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bm bmVar;
        bm bmVar2;
        bm bmVar3;
        bm bmVar4;
        bm bmVar5;
        bm bmVar6;
        bm bmVar7;
        bm bmVar8;
        boolean z;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        bm bmVar9;
        bm bmVar10;
        bmVar = this.a.l;
        if (view == bmVar.c()) {
            this.a.a(0);
        } else {
            bmVar2 = this.a.l;
            if (view == bmVar2.a()) {
                bmVar6 = this.a.l;
                bmVar6.e().scrollTo(0, 0);
            } else {
                bmVar3 = this.a.l;
                if (view == bmVar3.b()) {
                    this.a.closeActivity();
                } else {
                    bmVar4 = this.a.l;
                    if (view == bmVar4.d()) {
                        if (TiebaApplication.g().s()) {
                            StatService.onEvent(this.a, "frs_more", "frsclick", 1);
                        }
                        bmVar5 = this.a.l;
                        bmVar5.b(true);
                    }
                }
            }
        }
        switch (view.getId()) {
            case R.id.show_image /* 2131099898 */:
                this.a.o = false;
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.a, "frs_image", "frsclick", 1);
                }
                bmVar7 = this.a.l;
                if (bmVar7.g().isMenuShowing()) {
                    bmVar8 = this.a.l;
                    bmVar8.g().toggle(true);
                    z = this.a.o;
                    if (z) {
                        this.a.o = false;
                        this.a.c(1);
                        return;
                    }
                    return;
                }
                return;
            case R.id.show_all /* 2131100320 */:
                this.a.o = false;
                TiebaApplication g = TiebaApplication.g();
                str3 = this.a.b;
                g.j(str3);
                FrsImageActivity frsImageActivity = this.a;
                str4 = this.a.b;
                FrsActivity.a(frsImageActivity, str4, null, 0);
                this.a.a();
                return;
            case R.id.show_good /* 2131100322 */:
                this.a.o = false;
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.a, "frs_good", "frsclick", 1);
                }
                TiebaApplication g2 = TiebaApplication.g();
                str = this.a.b;
                g2.j(str);
                FrsImageActivity frsImageActivity2 = this.a;
                str2 = this.a.b;
                FrsActivity.b(frsImageActivity2, str2, null);
                this.a.a();
                return;
            case R.id.add_to_window_layout /* 2131100331 */:
                FrsImageActivity frsImageActivity3 = this.a;
                str5 = this.a.b;
                frsImageActivity3.b(str5);
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
                str6 = this.a.b;
                if (str7.equals(str6)) {
                    this.a.o = false;
                    bmVar9 = this.a.l;
                    if (bmVar9.g().isMenuShowing()) {
                        bmVar10 = this.a.l;
                        bmVar10.g().toggle(true);
                        return;
                    }
                    return;
                }
                FrsActivity.a(this.a, str7, (String) null);
                this.a.a();
                return;
            default:
                return;
        }
    }
}
