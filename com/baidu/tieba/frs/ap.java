package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.chat.ChatListActivity;
import com.baidu.tieba.mention.MentionActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ap implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1064a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(FrsImageActivity frsImageActivity) {
        this.f1064a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ax axVar;
        ax axVar2;
        boolean z;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        ax axVar3;
        ax axVar4;
        ax axVar5;
        ax axVar6;
        switch (view.getId()) {
            case R.id.frs_bt_back /* 2131100025 */:
                this.f1064a.finish();
                return;
            case R.id.frs_top_title /* 2131100026 */:
                axVar6 = this.f1064a.n;
                axVar6.a().scrollTo(0, 0);
                return;
            case R.id.frs_top_edit /* 2131100027 */:
                this.f1064a.b(0);
                return;
            case R.id.frs_top_more /* 2131100029 */:
                if (TiebaApplication.f().t()) {
                    StatService.onEvent(this.f1064a, "frs_more", "frsclick", 1);
                }
                axVar5 = this.f1064a.n;
                axVar5.b(true);
                return;
            case R.id.show_all /* 2131100086 */:
                this.f1064a.r = false;
                TiebaApplication f = TiebaApplication.f();
                str3 = this.f1064a.b;
                f.f(str3);
                FrsImageActivity frsImageActivity = this.f1064a;
                str4 = this.f1064a.b;
                FrsActivity.a(frsImageActivity, str4, null, 0);
                this.f1064a.b();
                return;
            case R.id.show_good /* 2131100088 */:
                this.f1064a.r = false;
                if (TiebaApplication.f().t()) {
                    StatService.onEvent(this.f1064a, "frs_good", "frsclick", 1);
                }
                TiebaApplication f2 = TiebaApplication.f();
                str = this.f1064a.b;
                f2.f(str);
                FrsImageActivity frsImageActivity2 = this.f1064a;
                str2 = this.f1064a.b;
                FrsActivity.b(frsImageActivity2, str2, null);
                this.f1064a.b();
                return;
            case R.id.show_image /* 2131100090 */:
                this.f1064a.r = false;
                if (TiebaApplication.f().t()) {
                    StatService.onEvent(this.f1064a, "frs_image", "frsclick", 1);
                }
                axVar = this.f1064a.n;
                if (axVar.c().isMenuShowing()) {
                    axVar2 = this.f1064a.n;
                    axVar2.c().toggle(true);
                    z = this.f1064a.r;
                    if (z) {
                        this.f1064a.r = false;
                        this.f1064a.f(1);
                        return;
                    }
                    return;
                }
                return;
            case R.id.add_to_window_layout /* 2131100098 */:
                FrsImageActivity frsImageActivity3 = this.f1064a;
                str5 = this.f1064a.b;
                frsImageActivity3.d(str5);
                return;
            case R.id.message_layout /* 2131100102 */:
                String E = TiebaApplication.E();
                if (E != null && E.length() > 0) {
                    if (TiebaApplication.f().t()) {
                        StatService.onEvent(this.f1064a, "frs_message", "frsclick", 1);
                    }
                    MentionActivity.a(this.f1064a, 18002);
                    return;
                }
                return;
            case R.id.chat_layout /* 2131100106 */:
                if (TiebaApplication.f().t()) {
                    StatService.onEvent(this.f1064a, "enter_chatlist", "frsclick", 1);
                }
                ChatListActivity.a(this.f1064a);
                return;
            case R.id.like_forum_name /* 2131100111 */:
                if (TiebaApplication.f().t()) {
                    StatService.onEvent(this.f1064a, "frs_likeforum", "frsclick", 1);
                }
                String str7 = (String) view.getTag();
                str6 = this.f1064a.b;
                if (str7.equals(str6)) {
                    this.f1064a.r = false;
                    axVar3 = this.f1064a.n;
                    if (axVar3.c().isMenuShowing()) {
                        axVar4 = this.f1064a.n;
                        axVar4.c().toggle(true);
                        return;
                    }
                    return;
                }
                FrsActivity.a(this.f1064a, str7, (String) null);
                this.f1064a.b();
                return;
            default:
                return;
        }
    }
}
