package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.mention.MentionActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.c.p pVar;
        com.baidu.tieba.c.p pVar2;
        ba baVar;
        boolean z;
        ba baVar2;
        ba baVar3;
        ba baVar4;
        ba baVar5;
        boolean z2;
        ba baVar6;
        String str;
        String str2;
        ba baVar7;
        ba baVar8;
        ba baVar9;
        ba baVar10;
        ba baVar11;
        switch (view.getId()) {
            case R.id.frs_bt_back /* 2131099938 */:
                this.a.f();
                return;
            case R.id.frs_top_title /* 2131099939 */:
                baVar11 = this.a.l;
                baVar11.d(0);
                return;
            case R.id.frs_top_edit /* 2131099940 */:
                if (TiebaApplication.d().n()) {
                    StatService.onEvent(this.a, "frs_post_thread", "frsclick", 1);
                }
                this.a.d(0);
                return;
            case R.id.frs_top_more /* 2131099942 */:
                if (TiebaApplication.d().n()) {
                    StatService.onEvent(this.a, "frs_more", "frsclick", 1);
                }
                baVar10 = this.a.l;
                baVar10.a(true);
                return;
            case R.id.frs_bt_create /* 2131099949 */:
                this.a.x();
                return;
            case R.id.refresh_layout /* 2131099950 */:
                if (TiebaApplication.d().n()) {
                    StatService.onEvent(this.a, "frs_refresh", "frsclick", 1);
                }
                this.a.y();
                return;
            case R.id.btn_love /* 2131099963 */:
                this.a.n();
                return;
            case R.id.btn_sign /* 2131099969 */:
                baVar9 = this.a.l;
                if (!baVar9.o()) {
                    this.a.o();
                    return;
                }
                return;
            case R.id.show_all /* 2131099992 */:
                this.a.E = false;
                baVar4 = this.a.l;
                if (baVar4.b().isMenuShowing()) {
                    baVar6 = this.a.l;
                    baVar6.b().toggle(true);
                }
                baVar5 = this.a.l;
                baVar5.a().a(R.id.show_all);
                z2 = this.a.t;
                if (z2) {
                    this.a.t = false;
                    this.a.y();
                    return;
                }
                return;
            case R.id.show_good /* 2131099994 */:
                this.a.E = false;
                if (TiebaApplication.d().n()) {
                    StatService.onEvent(this.a, "frs_good", "frsclick", 1);
                }
                baVar = this.a.l;
                if (baVar.b().isMenuShowing()) {
                    baVar3 = this.a.l;
                    baVar3.b().toggle(true);
                }
                z = this.a.t;
                if (!z) {
                    this.a.t = true;
                    baVar2 = this.a.l;
                    baVar2.a().a(R.id.show_good);
                    this.a.y();
                    return;
                }
                return;
            case R.id.show_image /* 2131099996 */:
                this.a.E = false;
                if (TiebaApplication.d().n()) {
                    StatService.onEvent(this.a, "frs_image", "frsclick", 1);
                }
                TiebaApplication d = TiebaApplication.d();
                pVar = this.a.v;
                d.c(pVar.a().b());
                FrsActivity frsActivity = this.a;
                pVar2 = this.a.v;
                FrsImageActivity.a(frsActivity, pVar2.a().b(), null, 0);
                this.a.d();
                return;
            case R.id.add_to_window_layout /* 2131100004 */:
                FrsActivity frsActivity2 = this.a;
                str = this.a.e;
                frsActivity2.c(str);
                return;
            case R.id.message_layout /* 2131100007 */:
                String z3 = TiebaApplication.z();
                if (z3 != null && z3.length() > 0) {
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
                String str3 = (String) view.getTag();
                str2 = this.a.e;
                if (str3.equals(str2)) {
                    this.a.E = false;
                    baVar7 = this.a.l;
                    if (baVar7.b().isMenuShowing()) {
                        baVar8 = this.a.l;
                        baVar8.b().toggle(true);
                        return;
                    }
                    return;
                }
                this.a.d(str3);
                return;
            default:
                return;
        }
    }
}
