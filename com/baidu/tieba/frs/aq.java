package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.mention.MentionActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class aq implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1127a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(FrsImageActivity frsImageActivity) {
        this.f1127a = frsImageActivity;
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
            case R.id.show_image /* 2131099859 */:
                this.f1127a.q = false;
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1127a, "frs_image", "frsclick", 1);
                }
                ayVar = this.f1127a.m;
                if (ayVar.c().isMenuShowing()) {
                    ayVar2 = this.f1127a.m;
                    ayVar2.c().toggle(true);
                    z = this.f1127a.q;
                    if (z) {
                        this.f1127a.q = false;
                        this.f1127a.f(1);
                        return;
                    }
                    return;
                }
                return;
            case R.id.frs_bt_back /* 2131100106 */:
                this.f1127a.finish();
                return;
            case R.id.frs_top_title /* 2131100107 */:
                ayVar6 = this.f1127a.m;
                ayVar6.a().scrollTo(0, 0);
                return;
            case R.id.frs_top_edit /* 2131100108 */:
                this.f1127a.b(0);
                return;
            case R.id.frs_top_more /* 2131100110 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1127a, "frs_more", "frsclick", 1);
                }
                ayVar5 = this.f1127a.m;
                ayVar5.b(true);
                return;
            case R.id.show_all /* 2131100171 */:
                this.f1127a.q = false;
                TiebaApplication g = TiebaApplication.g();
                str3 = this.f1127a.b;
                g.i(str3);
                FrsImageActivity frsImageActivity = this.f1127a;
                str4 = this.f1127a.b;
                FrsActivity.a(frsImageActivity, str4, null, 0);
                this.f1127a.b();
                return;
            case R.id.show_good /* 2131100173 */:
                this.f1127a.q = false;
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1127a, "frs_good", "frsclick", 1);
                }
                TiebaApplication g2 = TiebaApplication.g();
                str = this.f1127a.b;
                g2.i(str);
                FrsImageActivity frsImageActivity2 = this.f1127a;
                str2 = this.f1127a.b;
                FrsActivity.b(frsImageActivity2, str2, null);
                this.f1127a.b();
                return;
            case R.id.abstract_selection /* 2131100177 */:
                ayVar7 = this.f1127a.m;
                ayVar7.b().e();
                return;
            case R.id.add_to_window_layout /* 2131100181 */:
                FrsImageActivity frsImageActivity3 = this.f1127a;
                str5 = this.f1127a.b;
                frsImageActivity3.d(str5);
                return;
            case R.id.message_layout /* 2131100185 */:
                String C = TiebaApplication.C();
                if (C != null && C.length() > 0) {
                    if (TiebaApplication.g().s()) {
                        StatService.onEvent(this.f1127a, "frs_message", "frsclick", 1);
                    }
                    MentionActivity.a(this.f1127a, 18002);
                    return;
                }
                return;
            case R.id.like_forum_name /* 2131100191 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1127a, "frs_likeforum", "frsclick", 1);
                }
                String str7 = (String) view.getTag();
                str6 = this.f1127a.b;
                if (str7.equals(str6)) {
                    this.f1127a.q = false;
                    ayVar3 = this.f1127a.m;
                    if (ayVar3.c().isMenuShowing()) {
                        ayVar4 = this.f1127a.m;
                        ayVar4.c().toggle(true);
                        return;
                    }
                    return;
                }
                FrsActivity.a(this.f1127a, str7, (String) null);
                this.f1127a.b();
                return;
            default:
                return;
        }
    }
}
