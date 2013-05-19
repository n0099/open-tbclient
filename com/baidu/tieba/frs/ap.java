package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.mention.MentionActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ap implements View.OnClickListener {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ay ayVar;
        ay ayVar2;
        boolean z;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        ay ayVar3;
        ay ayVar4;
        ay ayVar5;
        ay ayVar6;
        switch (view.getId()) {
            case R.id.refresh_btn /* 2131099851 */:
                this.a.e(1);
                return;
            case R.id.frs_bt_back /* 2131099938 */:
                this.a.finish();
                return;
            case R.id.frs_top_title /* 2131099939 */:
                ayVar6 = this.a.n;
                ayVar6.a().scrollTo(0, 0);
                return;
            case R.id.frs_top_edit /* 2131099940 */:
                this.a.c(0);
                return;
            case R.id.frs_top_more /* 2131099942 */:
                if (TiebaApplication.d().n()) {
                    StatService.onEvent(this.a, "frs_more", "frsclick", 1);
                }
                ayVar5 = this.a.n;
                ayVar5.b(true);
                return;
            case R.id.show_all /* 2131099992 */:
                this.a.r = false;
                TiebaApplication d = TiebaApplication.d();
                str3 = this.a.d;
                d.d(str3);
                FrsImageActivity frsImageActivity = this.a;
                str4 = this.a.d;
                FrsActivity.a(frsImageActivity, str4, null, 0);
                this.a.b();
                return;
            case R.id.show_good /* 2131099994 */:
                this.a.r = false;
                if (TiebaApplication.d().n()) {
                    StatService.onEvent(this.a, "frs_good", "frsclick", 1);
                }
                TiebaApplication d2 = TiebaApplication.d();
                str = this.a.d;
                d2.d(str);
                FrsImageActivity frsImageActivity2 = this.a;
                str2 = this.a.d;
                FrsActivity.b(frsImageActivity2, str2, null);
                this.a.b();
                return;
            case R.id.show_image /* 2131099996 */:
                this.a.r = false;
                if (TiebaApplication.d().n()) {
                    StatService.onEvent(this.a, "frs_image", "frsclick", 1);
                }
                ayVar = this.a.n;
                if (ayVar.c().isMenuShowing()) {
                    ayVar2 = this.a.n;
                    ayVar2.c().toggle(true);
                    z = this.a.r;
                    if (z) {
                        this.a.r = false;
                        this.a.e(1);
                        return;
                    }
                    return;
                }
                return;
            case R.id.add_to_window_layout /* 2131100004 */:
                FrsImageActivity frsImageActivity3 = this.a;
                str5 = this.a.d;
                frsImageActivity3.d(str5);
                return;
            case R.id.message_layout /* 2131100007 */:
                String z2 = TiebaApplication.z();
                if (z2 != null && z2.length() > 0) {
                    if (TiebaApplication.d().n()) {
                        StatService.onEvent(this.a, "frs_message", "frsclick", 1);
                    }
                    MentionActivity.a(this.a, 1800002);
                    return;
                }
                return;
            case R.id.like_forum_name /* 2131100013 */:
                if (TiebaApplication.d().n()) {
                    StatService.onEvent(this.a, "frs_likeforum", "frsclick", 1);
                }
                String str7 = (String) view.getTag();
                str6 = this.a.d;
                if (str7.equals(str6)) {
                    this.a.r = false;
                    ayVar3 = this.a.n;
                    if (ayVar3.c().isMenuShowing()) {
                        ayVar4 = this.a.n;
                        ayVar4.c().toggle(true);
                        return;
                    }
                    return;
                }
                FrsActivity.a(this.a, str7, (String) null);
                this.a.b();
                return;
            default:
                return;
        }
    }
}
