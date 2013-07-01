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
    final /* synthetic */ FrsImageActivity f842a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(FrsImageActivity frsImageActivity) {
        this.f842a = frsImageActivity;
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
            case R.id.refresh_btn /* 2131099859 */:
                this.f842a.e(1);
                return;
            case R.id.frs_bt_back /* 2131100004 */:
                this.f842a.finish();
                return;
            case R.id.frs_top_title /* 2131100005 */:
                axVar6 = this.f842a.n;
                axVar6.a().scrollTo(0, 0);
                return;
            case R.id.frs_top_edit /* 2131100006 */:
                this.f842a.b(0);
                return;
            case R.id.frs_top_more /* 2131100008 */:
                if (TiebaApplication.f().t()) {
                    StatService.onEvent(this.f842a, "frs_more", "frsclick", 1);
                }
                axVar5 = this.f842a.n;
                axVar5.b(true);
                return;
            case R.id.show_all /* 2131100060 */:
                this.f842a.r = false;
                TiebaApplication f = TiebaApplication.f();
                str3 = this.f842a.b;
                f.f(str3);
                FrsImageActivity frsImageActivity = this.f842a;
                str4 = this.f842a.b;
                FrsActivity.a(frsImageActivity, str4, null, 0);
                this.f842a.b();
                return;
            case R.id.show_good /* 2131100062 */:
                this.f842a.r = false;
                if (TiebaApplication.f().t()) {
                    StatService.onEvent(this.f842a, "frs_good", "frsclick", 1);
                }
                TiebaApplication f2 = TiebaApplication.f();
                str = this.f842a.b;
                f2.f(str);
                FrsImageActivity frsImageActivity2 = this.f842a;
                str2 = this.f842a.b;
                FrsActivity.b(frsImageActivity2, str2, null);
                this.f842a.b();
                return;
            case R.id.show_image /* 2131100064 */:
                this.f842a.r = false;
                if (TiebaApplication.f().t()) {
                    StatService.onEvent(this.f842a, "frs_image", "frsclick", 1);
                }
                axVar = this.f842a.n;
                if (axVar.c().isMenuShowing()) {
                    axVar2 = this.f842a.n;
                    axVar2.c().toggle(true);
                    z = this.f842a.r;
                    if (z) {
                        this.f842a.r = false;
                        this.f842a.e(1);
                        return;
                    }
                    return;
                }
                return;
            case R.id.add_to_window_layout /* 2131100072 */:
                FrsImageActivity frsImageActivity3 = this.f842a;
                str5 = this.f842a.b;
                frsImageActivity3.d(str5);
                return;
            case R.id.message_layout /* 2131100076 */:
                String E = TiebaApplication.E();
                if (E != null && E.length() > 0) {
                    if (TiebaApplication.f().t()) {
                        StatService.onEvent(this.f842a, "frs_message", "frsclick", 1);
                    }
                    MentionActivity.a(this.f842a, 1800002);
                    return;
                }
                return;
            case R.id.chat_layout /* 2131100080 */:
                if (TiebaApplication.f().t()) {
                    StatService.onEvent(this.f842a, "enter_chatlist", "frsclick", 1);
                }
                ChatListActivity.a(this.f842a);
                return;
            case R.id.like_forum_name /* 2131100085 */:
                if (TiebaApplication.f().t()) {
                    StatService.onEvent(this.f842a, "frs_likeforum", "frsclick", 1);
                }
                String str7 = (String) view.getTag();
                str6 = this.f842a.b;
                if (str7.equals(str6)) {
                    this.f842a.r = false;
                    axVar3 = this.f842a.n;
                    if (axVar3.c().isMenuShowing()) {
                        axVar4 = this.f842a.n;
                        axVar4.c().toggle(true);
                        return;
                    }
                    return;
                }
                FrsActivity.a(this.f842a, str7, (String) null);
                this.f842a.b();
                return;
            default:
                return;
        }
    }
}
