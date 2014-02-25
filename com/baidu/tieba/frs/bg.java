package com.baidu.tieba.frs;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.more.AccountActivity;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.cb;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class bg implements View.OnClickListener {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bp bpVar;
        bp bpVar2;
        bp bpVar3;
        bp bpVar4;
        bp bpVar5;
        bp bpVar6;
        bp bpVar7;
        bp bpVar8;
        boolean z;
        String str;
        String str2;
        String str3;
        String str4;
        com.baidu.tieba.model.al alVar;
        String str5;
        com.baidu.tieba.model.al alVar2;
        com.baidu.tieba.model.al alVar3;
        String str6;
        String str7;
        bp bpVar9;
        bp bpVar10;
        bpVar = this.a.l;
        if (view != bpVar.c()) {
            bpVar2 = this.a.l;
            if (view == bpVar2.a()) {
                bpVar6 = this.a.l;
                bpVar6.e().scrollTo(0, 0);
            } else {
                bpVar3 = this.a.l;
                if (view == bpVar3.b()) {
                    this.a.closeActivity();
                } else {
                    bpVar4 = this.a.l;
                    if (view == bpVar4.d()) {
                        cb.a(this.a, "frs_more", "frsclick", 1, new Object[0]);
                        bpVar5 = this.a.l;
                        bpVar5.b(true);
                    }
                }
            }
        } else {
            this.a.a(0);
        }
        int id = view.getId();
        if (id == R.id.message_layout) {
            String A = TiebaApplication.A();
            if (A != null && A.length() > 0) {
                cb.a(this.a, "frs_message", "frsclick", 1, new Object[0]);
                com.baidu.tieba.mention.c.a((Activity) this.a, 18002);
            }
        } else if (id == R.id.like_forum_name) {
            cb.a(this.a, "frs_likeforum", "frsclick", 1, new Object[0]);
            String str8 = (String) view.getTag();
            str7 = this.a.b;
            if (str8.equals(str7)) {
                this.a.o = false;
                bpVar9 = this.a.l;
                if (bpVar9.g().isMenuShowing()) {
                    bpVar10 = this.a.l;
                    bpVar10.g().toggle(true);
                    return;
                }
                return;
            }
            FrsActivity.a(this.a, str8, null);
            this.a.a();
        } else if (id == R.id.add_to_window_layout) {
            FrsImageActivity frsImageActivity = this.a;
            str6 = this.a.b;
            frsImageActivity.b(str6);
        } else if (id == R.id.manage_mode) {
            String str9 = "";
            alVar = this.a.q;
            if (alVar != null) {
                alVar2 = this.a.q;
                if (alVar2.b() != null) {
                    alVar3 = this.a.q;
                    str9 = alVar3.b().getId();
                }
            }
            StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/bawuindex?fn=");
            str5 = this.a.b;
            UtilHelper.c(this.a, sb.append(str5).append("&fid=").append(str9).toString());
        } else if (id == R.id.show_all) {
            this.a.o = false;
            TiebaApplication g = TiebaApplication.g();
            str3 = this.a.b;
            g.i(str3);
            FrsImageActivity frsImageActivity2 = this.a;
            str4 = this.a.b;
            FrsActivity.a(frsImageActivity2, str4, null, 0);
            this.a.a();
        } else if (id == R.id.show_good) {
            this.a.o = false;
            cb.a(this.a, "frs_good", "frsclick", 1, new Object[0]);
            TiebaApplication g2 = TiebaApplication.g();
            str = this.a.b;
            g2.i(str);
            FrsImageActivity frsImageActivity3 = this.a;
            str2 = this.a.b;
            FrsActivity.b(frsImageActivity3, str2, null);
            this.a.a();
        } else if (id == R.id.show_image) {
            this.a.o = false;
            cb.a(this.a, "frs_image", "frsclick", 1, new Object[0]);
            bpVar7 = this.a.l;
            if (bpVar7.g().isMenuShowing()) {
                bpVar8 = this.a.l;
                bpVar8.g().toggle(true);
                z = this.a.o;
                if (z) {
                    this.a.o = false;
                    this.a.c(1);
                }
            }
        } else if (id == R.id.account_manager_layout) {
            AccountActivity.a(this.a);
        }
    }
}
