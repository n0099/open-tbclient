package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ForumData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1300a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FrsActivity frsActivity) {
        this.f1300a = frsActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        ba baVar;
        com.baidu.tieba.model.ba baVar2;
        ba baVar3;
        String str;
        String str2;
        ba baVar4;
        com.baidu.tieba.model.ak akVar;
        com.baidu.tieba.model.ak akVar2;
        ba baVar5;
        String str3;
        ba baVar6;
        com.baidu.tieba.model.ak akVar3;
        com.baidu.tieba.model.ak akVar4;
        boolean z = false;
        baVar = this.f1300a.o;
        baVar.c(false);
        if (obj != null && (obj instanceof com.baidu.tieba.data.ag)) {
            akVar4 = this.f1300a.x;
            akVar4.a((com.baidu.tieba.data.ag) obj);
            z = true;
        }
        if (z) {
            str = this.f1300a.C;
            if (str.equals("normal_page")) {
                baVar6 = this.f1300a.o;
                akVar3 = this.f1300a.x;
                baVar6.a(1, akVar3.a());
            } else {
                str2 = this.f1300a.C;
                if (str2.equals("frs_page")) {
                    baVar4 = this.f1300a.o;
                    akVar = this.f1300a.x;
                    ForumData a2 = akVar.a();
                    akVar2 = this.f1300a.x;
                    baVar4.a(1, a2, akVar2.e());
                }
            }
            baVar5 = this.f1300a.o;
            baVar5.a(this.f1300a.getString(R.string.like_success));
            TiebaApplication g = TiebaApplication.g();
            str3 = this.f1300a.e;
            g.e(str3);
            return;
        }
        baVar2 = this.f1300a.y;
        if (baVar2.getErrorCode() == 22) {
        }
        baVar3 = this.f1300a.o;
        baVar3.a(this.f1300a.getString(R.string.had_liked_forum));
        this.f1300a.C();
    }
}
