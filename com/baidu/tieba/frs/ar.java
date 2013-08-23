package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.mention.MentionActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ar implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1080a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(FrsImageActivity frsImageActivity) {
        this.f1080a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        az azVar;
        az azVar2;
        boolean z;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        az azVar3;
        az azVar4;
        az azVar5;
        az azVar6;
        switch (view.getId()) {
            case R.id.frs_bt_back /* 2131100065 */:
                this.f1080a.finish();
                return;
            case R.id.frs_top_title /* 2131100066 */:
                azVar6 = this.f1080a.n;
                azVar6.a().scrollTo(0, 0);
                return;
            case R.id.frs_top_edit /* 2131100067 */:
                this.f1080a.b(0);
                return;
            case R.id.frs_top_more /* 2131100069 */:
                if (TiebaApplication.g().u()) {
                    StatService.onEvent(this.f1080a, "frs_more", "frsclick", 1);
                }
                azVar5 = this.f1080a.n;
                azVar5.b(true);
                return;
            case R.id.show_all /* 2131100127 */:
                this.f1080a.r = false;
                TiebaApplication g = TiebaApplication.g();
                str3 = this.f1080a.b;
                g.i(str3);
                FrsImageActivity frsImageActivity = this.f1080a;
                str4 = this.f1080a.b;
                FrsActivity.a(frsImageActivity, str4, null, 0);
                this.f1080a.b();
                return;
            case R.id.show_good /* 2131100129 */:
                this.f1080a.r = false;
                if (TiebaApplication.g().u()) {
                    StatService.onEvent(this.f1080a, "frs_good", "frsclick", 1);
                }
                TiebaApplication g2 = TiebaApplication.g();
                str = this.f1080a.b;
                g2.i(str);
                FrsImageActivity frsImageActivity2 = this.f1080a;
                str2 = this.f1080a.b;
                FrsActivity.b(frsImageActivity2, str2, null);
                this.f1080a.b();
                return;
            case R.id.show_image /* 2131100131 */:
                this.f1080a.r = false;
                if (TiebaApplication.g().u()) {
                    StatService.onEvent(this.f1080a, "frs_image", "frsclick", 1);
                }
                azVar = this.f1080a.n;
                if (azVar.c().isMenuShowing()) {
                    azVar2 = this.f1080a.n;
                    azVar2.c().toggle(true);
                    z = this.f1080a.r;
                    if (z) {
                        this.f1080a.r = false;
                        this.f1080a.f(1);
                        return;
                    }
                    return;
                }
                return;
            case R.id.add_to_window_layout /* 2131100139 */:
                FrsImageActivity frsImageActivity3 = this.f1080a;
                str5 = this.f1080a.b;
                frsImageActivity3.d(str5);
                return;
            case R.id.message_layout /* 2131100143 */:
                String E = TiebaApplication.E();
                if (E != null && E.length() > 0) {
                    if (TiebaApplication.g().u()) {
                        StatService.onEvent(this.f1080a, "frs_message", "frsclick", 1);
                    }
                    MentionActivity.a(this.f1080a, 18002);
                    return;
                }
                return;
            case R.id.like_forum_name /* 2131100149 */:
                if (TiebaApplication.g().u()) {
                    StatService.onEvent(this.f1080a, "frs_likeforum", "frsclick", 1);
                }
                String str7 = (String) view.getTag();
                str6 = this.f1080a.b;
                if (str7.equals(str6)) {
                    this.f1080a.r = false;
                    azVar3 = this.f1080a.n;
                    if (azVar3.c().isMenuShowing()) {
                        azVar4 = this.f1080a.n;
                        azVar4.c().toggle(true);
                        return;
                    }
                    return;
                }
                FrsActivity.a(this.f1080a, str7, (String) null);
                this.f1080a.b();
                return;
            default:
                return;
        }
    }
}
