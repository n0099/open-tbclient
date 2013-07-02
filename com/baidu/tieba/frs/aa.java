package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.chat.ChatListActivity;
import com.baidu.tieba.mention.MentionActivity;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        az azVar;
        boolean z;
        az azVar2;
        az azVar3;
        az azVar4;
        az azVar5;
        boolean z2;
        az azVar6;
        String str;
        String str2;
        az azVar7;
        az azVar8;
        az azVar9;
        az azVar10;
        az azVar11;
        switch (view.getId()) {
            case R.id.frs_bt_back /* 2131165558 */:
                this.a.f();
                return;
            case R.id.frs_top_title /* 2131165559 */:
                azVar11 = this.a.m;
                azVar11.d(0);
                return;
            case R.id.frs_top_edit /* 2131165560 */:
                if (TiebaApplication.f().s()) {
                    StatService.onEvent(this.a, "frs_post_thread", "frsclick", 1);
                }
                this.a.d(0);
                return;
            case R.id.frs_top_more /* 2131165562 */:
                if (TiebaApplication.f().s()) {
                    StatService.onEvent(this.a, "frs_more", "frsclick", 1);
                }
                azVar10 = this.a.m;
                azVar10.a(true);
                return;
            case R.id.frs_bt_create /* 2131165569 */:
                this.a.x();
                return;
            case R.id.refresh_layout /* 2131165570 */:
                if (TiebaApplication.f().s()) {
                    StatService.onEvent(this.a, "frs_refresh", "frsclick", 1);
                }
                this.a.y();
                return;
            case R.id.btn_love /* 2131165587 */:
                this.a.n();
                return;
            case R.id.btn_sign /* 2131165593 */:
                azVar9 = this.a.m;
                if (!azVar9.o()) {
                    this.a.o();
                    return;
                }
                return;
            case R.id.show_all /* 2131165616 */:
                this.a.E = false;
                azVar4 = this.a.m;
                if (azVar4.b().isMenuShowing()) {
                    azVar6 = this.a.m;
                    azVar6.b().toggle(true);
                }
                azVar5 = this.a.m;
                azVar5.a().a(R.id.show_all);
                z2 = this.a.u;
                if (z2) {
                    this.a.u = false;
                    this.a.y();
                    return;
                }
                return;
            case R.id.show_good /* 2131165618 */:
                this.a.E = false;
                if (TiebaApplication.f().s()) {
                    StatService.onEvent(this.a, "frs_good", "frsclick", 1);
                }
                azVar = this.a.m;
                if (azVar.b().isMenuShowing()) {
                    azVar3 = this.a.m;
                    azVar3.b().toggle(true);
                }
                z = this.a.u;
                if (!z) {
                    this.a.u = true;
                    azVar2 = this.a.m;
                    azVar2.a().a(R.id.show_good);
                    this.a.y();
                    return;
                }
                return;
            case R.id.show_image /* 2131165620 */:
                this.a.E = false;
                if (TiebaApplication.f().s()) {
                    StatService.onEvent(this.a, "frs_image", "frsclick", 1);
                }
                TiebaApplication.f().e(this.a.a.a().b());
                FrsImageActivity.a(this.a, this.a.a.a().b(), null, 0);
                this.a.d();
                return;
            case R.id.message_layout /* 2131165628 */:
                String D = TiebaApplication.D();
                if (D != null && D.length() > 0) {
                    if (TiebaApplication.f().s()) {
                        StatService.onEvent(this.a, "frs_message", "frsclick", 1);
                    }
                    MentionActivity.a(this.a, 1800002);
                    return;
                }
                return;
            case R.id.chat_layout /* 2131165632 */:
                if (TiebaApplication.f().s()) {
                    StatService.onEvent(this.a, "enter_chatlist", "frsclick", 1);
                }
                ChatListActivity.a(this.a);
                return;
            case R.id.add_to_window_layout /* 2131165641 */:
                FrsActivity frsActivity = this.a;
                str = this.a.d;
                frsActivity.d(str);
                return;
            case R.id.like_forum_name /* 2131165654 */:
                if (TiebaApplication.f().s()) {
                    StatService.onEvent(this.a, "frs_likeforum", "frsclick", 1);
                }
                String str3 = (String) view.getTag();
                str2 = this.a.d;
                if (str3.equals(str2)) {
                    this.a.E = false;
                    azVar7 = this.a.m;
                    if (azVar7.b().isMenuShowing()) {
                        azVar8 = this.a.m;
                        azVar8.b().toggle(true);
                        return;
                    }
                    return;
                }
                this.a.c(str3);
                return;
            default:
                return;
        }
    }
}
