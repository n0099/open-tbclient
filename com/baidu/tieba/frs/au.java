package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.mention.MentionActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class au implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1264a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(FrsImageActivity frsImageActivity) {
        this.f1264a = frsImageActivity;
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
        ay ayVar7;
        switch (view.getId()) {
            case R.id.show_image /* 2131099862 */:
                this.f1264a.q = false;
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1264a, "frs_image", "frsclick", 1);
                }
                ayVar = this.f1264a.m;
                if (ayVar.c().isMenuShowing()) {
                    ayVar2 = this.f1264a.m;
                    ayVar2.c().toggle(true);
                    z = this.f1264a.q;
                    if (z) {
                        this.f1264a.q = false;
                        this.f1264a.f(1);
                        return;
                    }
                    return;
                }
                return;
            case R.id.frs_bt_back /* 2131100145 */:
                this.f1264a.finish();
                return;
            case R.id.frs_top_title /* 2131100146 */:
                ayVar6 = this.f1264a.m;
                ayVar6.a().scrollTo(0, 0);
                return;
            case R.id.frs_top_edit /* 2131100147 */:
                this.f1264a.d(0);
                return;
            case R.id.frs_top_more /* 2131100149 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1264a, "frs_more", "frsclick", 1);
                }
                ayVar5 = this.f1264a.m;
                ayVar5.b(true);
                return;
            case R.id.show_all /* 2131100218 */:
                this.f1264a.q = false;
                TiebaApplication g = TiebaApplication.g();
                str3 = this.f1264a.b;
                g.i(str3);
                FrsImageActivity frsImageActivity = this.f1264a;
                str4 = this.f1264a.b;
                FrsActivity.a(frsImageActivity, str4, null, 0);
                this.f1264a.b();
                return;
            case R.id.show_good /* 2131100220 */:
                this.f1264a.q = false;
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1264a, "frs_good", "frsclick", 1);
                }
                TiebaApplication g2 = TiebaApplication.g();
                str = this.f1264a.b;
                g2.i(str);
                FrsImageActivity frsImageActivity2 = this.f1264a;
                str2 = this.f1264a.b;
                FrsActivity.b(frsImageActivity2, str2, null);
                this.f1264a.b();
                return;
            case R.id.abstract_selection /* 2131100224 */:
                ayVar7 = this.f1264a.m;
                ayVar7.b().g();
                return;
            case R.id.add_to_window_layout /* 2131100228 */:
                FrsImageActivity frsImageActivity3 = this.f1264a;
                str5 = this.f1264a.b;
                frsImageActivity3.d(str5);
                return;
            case R.id.message_layout /* 2131100232 */:
                String C = TiebaApplication.C();
                if (C != null && C.length() > 0) {
                    if (TiebaApplication.g().s()) {
                        StatService.onEvent(this.f1264a, "frs_message", "frsclick", 1);
                    }
                    MentionActivity.a(this.f1264a, 18002);
                    return;
                }
                return;
            case R.id.like_forum_name /* 2131100238 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1264a, "frs_likeforum", "frsclick", 1);
                }
                String str7 = (String) view.getTag();
                str6 = this.f1264a.b;
                if (str7.equals(str6)) {
                    this.f1264a.q = false;
                    ayVar3 = this.f1264a.m;
                    if (ayVar3.c().isMenuShowing()) {
                        ayVar4 = this.f1264a.m;
                        ayVar4.c().toggle(true);
                        return;
                    }
                    return;
                }
                FrsActivity.a(this.f1264a, str7, (String) null);
                this.f1264a.b();
                return;
            default:
                return;
        }
    }
}
