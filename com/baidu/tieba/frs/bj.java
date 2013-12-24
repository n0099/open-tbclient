package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.mention.MentionActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class bj implements View.OnClickListener {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bl blVar;
        bl blVar2;
        bl blVar3;
        bl blVar4;
        bl blVar5;
        bl blVar6;
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
        blVar = this.a.l;
        if (view == blVar.c()) {
            this.a.a(0);
        } else {
            blVar2 = this.a.l;
            if (view == blVar2.a()) {
                blVar6 = this.a.l;
                blVar6.e().scrollTo(0, 0);
            } else {
                blVar3 = this.a.l;
                if (view == blVar3.b()) {
                    this.a.closeActivity();
                } else {
                    blVar4 = this.a.l;
                    if (view == blVar4.d()) {
                        if (TiebaApplication.h().t()) {
                            StatService.onEvent(this.a, "frs_more", "frsclick", 1);
                        }
                        blVar5 = this.a.l;
                        blVar5.b(true);
                    }
                }
            }
        }
        switch (view.getId()) {
            case R.id.show_image /* 2131099892 */:
                this.a.p = false;
                if (TiebaApplication.h().t()) {
                    StatService.onEvent(this.a, "frs_image", "frsclick", 1);
                }
                blVar7 = this.a.l;
                if (blVar7.g().isMenuShowing()) {
                    blVar8 = this.a.l;
                    blVar8.g().toggle(true);
                    z = this.a.p;
                    if (z) {
                        this.a.p = false;
                        this.a.c(1);
                        return;
                    }
                    return;
                }
                return;
            case R.id.show_all /* 2131100241 */:
                this.a.p = false;
                TiebaApplication h = TiebaApplication.h();
                str3 = this.a.b;
                h.j(str3);
                FrsImageActivity frsImageActivity = this.a;
                str4 = this.a.b;
                FrsActivity.a(frsImageActivity, str4, null, 0);
                this.a.a();
                return;
            case R.id.show_good /* 2131100243 */:
                this.a.p = false;
                if (TiebaApplication.h().t()) {
                    StatService.onEvent(this.a, "frs_good", "frsclick", 1);
                }
                TiebaApplication h2 = TiebaApplication.h();
                str = this.a.b;
                h2.j(str);
                FrsImageActivity frsImageActivity2 = this.a;
                str2 = this.a.b;
                FrsActivity.b(frsImageActivity2, str2, null);
                this.a.a();
                return;
            case R.id.add_to_window_layout /* 2131100252 */:
                FrsImageActivity frsImageActivity3 = this.a;
                str5 = this.a.b;
                frsImageActivity3.b(str5);
                return;
            case R.id.message_layout /* 2131100256 */:
                String B = TiebaApplication.B();
                if (B != null && B.length() > 0) {
                    if (TiebaApplication.h().t()) {
                        StatService.onEvent(this.a, "frs_message", "frsclick", 1);
                    }
                    MentionActivity.a(this.a, 18002);
                    return;
                }
                return;
            case R.id.like_forum_name /* 2131100261 */:
                if (TiebaApplication.h().t()) {
                    StatService.onEvent(this.a, "frs_likeforum", "frsclick", 1);
                }
                String str7 = (String) view.getTag();
                str6 = this.a.b;
                if (str7.equals(str6)) {
                    this.a.p = false;
                    blVar9 = this.a.l;
                    if (blVar9.g().isMenuShowing()) {
                        blVar10 = this.a.l;
                        blVar10.g().toggle(true);
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
