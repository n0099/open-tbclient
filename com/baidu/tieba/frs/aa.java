package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ForumData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.a.g {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        com.baidu.tieba.model.ax axVar;
        bo boVar;
        String str;
        String str2;
        bo boVar2;
        com.baidu.tieba.model.ak akVar;
        com.baidu.tieba.model.ak akVar2;
        bo boVar3;
        String str3;
        bo boVar4;
        com.baidu.tieba.model.ak akVar3;
        com.baidu.tieba.model.ak akVar4;
        String str4;
        com.baidu.tieba.model.ak akVar5;
        boolean z = false;
        if (obj != null && (obj instanceof com.baidu.tieba.data.ag)) {
            com.baidu.tieba.model.z a = com.baidu.tieba.model.z.a();
            str4 = this.a.f;
            a.b(str4);
            ((com.baidu.tieba.data.ag) obj).b(1);
            akVar5 = this.a.w;
            akVar5.a((com.baidu.tieba.data.ag) obj);
            z = true;
        }
        if (z) {
            str = this.a.C;
            if (str.equals("normal_page")) {
                boVar4 = this.a.n;
                akVar3 = this.a.w;
                ForumData a2 = akVar3.a();
                akVar4 = this.a.w;
                boVar4.b(1, a2, akVar4, true);
            } else {
                str2 = this.a.C;
                if (str2.equals("frs_page")) {
                    boVar2 = this.a.n;
                    akVar = this.a.w;
                    ForumData a3 = akVar.a();
                    akVar2 = this.a.w;
                    boVar2.a(1, a3, akVar2, true);
                }
            }
            boVar3 = this.a.n;
            boVar3.a(this.a.getString(R.string.like_success));
            TiebaApplication g = TiebaApplication.g();
            str3 = this.a.f;
            g.f(str3);
            return;
        }
        axVar = this.a.x;
        if (axVar.getErrorCode() == 22) {
        }
        boVar = this.a.n;
        boVar.a(this.a.getString(R.string.had_liked_forum));
        this.a.B();
    }
}
