package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.chat.ChatListActivity;
import com.baidu.tieba.mention.MentionActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f829a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(FrsActivity frsActivity) {
        this.f829a = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.model.v vVar;
        com.baidu.tieba.model.v vVar2;
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
            case R.id.frs_bt_back /* 2131100004 */:
                this.f829a.f();
                return;
            case R.id.frs_top_title /* 2131100005 */:
                azVar11 = this.f829a.l;
                azVar11.d(0);
                return;
            case R.id.frs_top_edit /* 2131100006 */:
                if (TiebaApplication.f().t()) {
                    StatService.onEvent(this.f829a, "frs_post_thread", "frsclick", 1);
                }
                this.f829a.d(0);
                return;
            case R.id.frs_top_more /* 2131100008 */:
                if (TiebaApplication.f().t()) {
                    StatService.onEvent(this.f829a, "frs_more", "frsclick", 1);
                }
                azVar10 = this.f829a.l;
                azVar10.a(true);
                return;
            case R.id.frs_bt_create /* 2131100015 */:
                this.f829a.x();
                return;
            case R.id.refresh_layout /* 2131100016 */:
                if (TiebaApplication.f().t()) {
                    StatService.onEvent(this.f829a, "frs_refresh", "frsclick", 1);
                }
                this.f829a.y();
                return;
            case R.id.btn_love /* 2131100031 */:
                this.f829a.n();
                return;
            case R.id.btn_sign /* 2131100037 */:
                azVar9 = this.f829a.l;
                if (!azVar9.o()) {
                    this.f829a.o();
                    return;
                }
                return;
            case R.id.show_all /* 2131100060 */:
                this.f829a.E = false;
                azVar4 = this.f829a.l;
                if (azVar4.b().isMenuShowing()) {
                    azVar6 = this.f829a.l;
                    azVar6.b().toggle(true);
                }
                azVar5 = this.f829a.l;
                azVar5.a().a(R.id.show_all);
                z2 = this.f829a.t;
                if (z2) {
                    this.f829a.t = false;
                    this.f829a.y();
                    return;
                }
                return;
            case R.id.show_good /* 2131100062 */:
                this.f829a.E = false;
                if (TiebaApplication.f().t()) {
                    StatService.onEvent(this.f829a, "frs_good", "frsclick", 1);
                }
                azVar = this.f829a.l;
                if (azVar.b().isMenuShowing()) {
                    azVar3 = this.f829a.l;
                    azVar3.b().toggle(true);
                }
                z = this.f829a.t;
                if (!z) {
                    this.f829a.t = true;
                    azVar2 = this.f829a.l;
                    azVar2.a().a(R.id.show_good);
                    this.f829a.y();
                    return;
                }
                return;
            case R.id.show_image /* 2131100064 */:
                this.f829a.E = false;
                if (TiebaApplication.f().t()) {
                    StatService.onEvent(this.f829a, "frs_image", "frsclick", 1);
                }
                TiebaApplication f = TiebaApplication.f();
                vVar = this.f829a.v;
                f.e(vVar.a().b());
                FrsActivity frsActivity = this.f829a;
                vVar2 = this.f829a.v;
                FrsImageActivity.a(frsActivity, vVar2.a().b(), null, 0);
                this.f829a.d();
                return;
            case R.id.add_to_window_layout /* 2131100072 */:
                FrsActivity frsActivity2 = this.f829a;
                str = this.f829a.c;
                frsActivity2.c(str);
                return;
            case R.id.message_layout /* 2131100076 */:
                String E = TiebaApplication.E();
                if (E != null && E.length() > 0) {
                    if (TiebaApplication.f().t()) {
                        StatService.onEvent(this.f829a, "frs_message", "frsclick", 1);
                    }
                    MentionActivity.a(this.f829a, 1800002);
                    return;
                }
                return;
            case R.id.chat_layout /* 2131100080 */:
                if (TiebaApplication.f().t()) {
                    StatService.onEvent(this.f829a, "enter_chatlist", "frsclick", 1);
                }
                ChatListActivity.a(this.f829a);
                return;
            case R.id.like_forum_name /* 2131100085 */:
                if (TiebaApplication.f().t()) {
                    StatService.onEvent(this.f829a, "frs_likeforum", "frsclick", 1);
                }
                String str3 = (String) view.getTag();
                str2 = this.f829a.c;
                if (str3.equals(str2)) {
                    this.f829a.E = false;
                    azVar7 = this.f829a.l;
                    if (azVar7.b().isMenuShowing()) {
                        azVar8 = this.f829a.l;
                        azVar8.b().toggle(true);
                        return;
                    }
                    return;
                }
                this.f829a.d(str3);
                return;
            default:
                return;
        }
    }
}
