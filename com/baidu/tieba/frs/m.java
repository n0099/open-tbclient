package com.baidu.tieba.frs;

import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class m implements ab {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.ab
    public void a(com.baidu.tieba.model.x xVar, com.baidu.tieba.model.y yVar) {
        az azVar;
        az azVar2;
        az azVar3;
        az azVar4;
        if (xVar.a) {
            azVar3 = this.a.m;
            azVar3.a(this.a.getString(R.string.add_fan_sucess));
            this.a.a.e().b(1);
            this.a.a.e().c(xVar.c);
            azVar4 = this.a.m;
            azVar4.a(1, this.a.a.a(), this.a.a.e());
            TiebaApplication.f().h(true);
            return;
        }
        if (yVar.d == null || yVar.d.length() <= 0) {
            azVar = this.a.m;
            azVar.a(this.a.getString(R.string.add_fan_error));
        } else {
            azVar2 = this.a.m;
            azVar2.a(yVar.d);
        }
        if (yVar.c != 120002) {
            return;
        }
        this.a.y();
    }
}
