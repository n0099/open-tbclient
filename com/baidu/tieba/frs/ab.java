package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ForumData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1305a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(FrsActivity frsActivity) {
        this.f1305a = frsActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        com.baidu.tieba.model.ax axVar;
        bn bnVar;
        String str;
        String str2;
        bn bnVar2;
        com.baidu.tieba.model.ak akVar;
        com.baidu.tieba.model.ak akVar2;
        bn bnVar3;
        bn bnVar4;
        String str3;
        bn bnVar5;
        com.baidu.tieba.model.ak akVar3;
        com.baidu.tieba.model.ak akVar4;
        String str4;
        com.baidu.tieba.model.ak akVar5;
        boolean z = false;
        if (obj != null && (obj instanceof com.baidu.tieba.data.ag)) {
            com.baidu.tieba.model.z a2 = com.baidu.tieba.model.z.a();
            str4 = this.f1305a.f;
            a2.b(str4);
            ((com.baidu.tieba.data.ag) obj).b(1);
            akVar5 = this.f1305a.w;
            akVar5.a((com.baidu.tieba.data.ag) obj);
            z = true;
        }
        if (z) {
            str = this.f1305a.C;
            if (str.equals("normal_page")) {
                bnVar5 = this.f1305a.n;
                akVar3 = this.f1305a.w;
                ForumData a3 = akVar3.a();
                akVar4 = this.f1305a.w;
                bnVar5.b(1, a3, akVar4, true);
            } else {
                str2 = this.f1305a.C;
                if (str2.equals("frs_page")) {
                    bnVar2 = this.f1305a.n;
                    akVar = this.f1305a.w;
                    ForumData a4 = akVar.a();
                    akVar2 = this.f1305a.w;
                    bnVar2.a(1, a4, akVar2, true);
                }
            }
            bnVar3 = this.f1305a.n;
            bnVar3.e().c(true);
            bnVar4 = this.f1305a.n;
            bnVar4.a(this.f1305a.getString(R.string.like_success));
            TiebaApplication g = TiebaApplication.g();
            str3 = this.f1305a.f;
            g.e(str3);
            return;
        }
        axVar = this.f1305a.x;
        if (axVar.getErrorCode() == 22) {
        }
        bnVar = this.f1305a.n;
        bnVar.a(this.f1305a.getString(R.string.had_liked_forum));
        this.f1305a.A();
    }
}
