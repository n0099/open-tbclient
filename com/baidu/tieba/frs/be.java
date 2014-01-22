package com.baidu.tieba.frs;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.mention.MentionActivity;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.by;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class be implements View.OnClickListener {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bi biVar;
        bi biVar2;
        bi biVar3;
        bi biVar4;
        bi biVar5;
        bi biVar6;
        bi biVar7;
        bi biVar8;
        boolean z;
        String str;
        String str2;
        String str3;
        String str4;
        com.baidu.tieba.model.ar arVar;
        String str5;
        com.baidu.tieba.model.ar arVar2;
        com.baidu.tieba.model.ar arVar3;
        String str6;
        String str7;
        bi biVar9;
        bi biVar10;
        biVar = this.a.l;
        if (view == biVar.c()) {
            this.a.a(0);
        } else {
            biVar2 = this.a.l;
            if (view == biVar2.a()) {
                biVar6 = this.a.l;
                biVar6.e().scrollTo(0, 0);
            } else {
                biVar3 = this.a.l;
                if (view == biVar3.b()) {
                    this.a.closeActivity();
                } else {
                    biVar4 = this.a.l;
                    if (view == biVar4.d()) {
                        by.a(this.a, "frs_more", "frsclick", 1, new Object[0]);
                        biVar5 = this.a.l;
                        biVar5.b(true);
                    }
                }
            }
        }
        switch (view.getId()) {
            case R.id.show_image /* 2131099933 */:
                this.a.o = false;
                by.a(this.a, "frs_image", "frsclick", 1, new Object[0]);
                biVar7 = this.a.l;
                if (biVar7.g().isMenuShowing()) {
                    biVar8 = this.a.l;
                    biVar8.g().toggle(true);
                    z = this.a.o;
                    if (z) {
                        this.a.o = false;
                        this.a.c(1);
                        return;
                    }
                    return;
                }
                return;
            case R.id.show_all /* 2131100386 */:
                this.a.o = false;
                TiebaApplication h = TiebaApplication.h();
                str3 = this.a.b;
                h.i(str3);
                FrsImageActivity frsImageActivity = this.a;
                str4 = this.a.b;
                FrsActivity.a(frsImageActivity, str4, null, 0);
                this.a.a();
                return;
            case R.id.show_good /* 2131100388 */:
                this.a.o = false;
                by.a(this.a, "frs_good", "frsclick", 1, new Object[0]);
                TiebaApplication h2 = TiebaApplication.h();
                str = this.a.b;
                h2.i(str);
                FrsImageActivity frsImageActivity2 = this.a;
                str2 = this.a.b;
                FrsActivity.b(frsImageActivity2, str2, null);
                this.a.a();
                return;
            case R.id.manage_mode /* 2131100392 */:
                String str8 = "";
                arVar = this.a.q;
                if (arVar != null) {
                    arVar2 = this.a.q;
                    if (arVar2.b() != null) {
                        arVar3 = this.a.q;
                        str8 = arVar3.b().getId();
                    }
                }
                StringBuilder append = new StringBuilder().append("http://tieba.baidu.com/mo/q/bawuindex?fn=");
                str5 = this.a.b;
                UtilHelper.c(this.a, append.append(str5).append("&fid=").append(str8).toString());
                return;
            case R.id.add_to_window_layout /* 2131100399 */:
                FrsImageActivity frsImageActivity3 = this.a;
                str6 = this.a.b;
                frsImageActivity3.b(str6);
                return;
            case R.id.message_layout /* 2131100403 */:
                String A = TiebaApplication.A();
                if (A != null && A.length() > 0) {
                    by.a(this.a, "frs_message", "frsclick", 1, new Object[0]);
                    MentionActivity.a((Activity) this.a, 18002);
                    return;
                }
                return;
            case R.id.like_forum_name /* 2131100408 */:
                by.a(this.a, "frs_likeforum", "frsclick", 1, new Object[0]);
                String str9 = (String) view.getTag();
                str7 = this.a.b;
                if (str9.equals(str7)) {
                    this.a.o = false;
                    biVar9 = this.a.l;
                    if (biVar9.g().isMenuShowing()) {
                        biVar10 = this.a.l;
                        biVar10.g().toggle(true);
                        return;
                    }
                    return;
                }
                FrsActivity.a(this.a, str9, null);
                this.a.a();
                return;
            default:
                return;
        }
    }
}
