package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tieba.im.model.bi;
/* loaded from: classes.dex */
class at implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ OfficialBarTipActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(OfficialBarTipActivity officialBarTipActivity) {
        this.a = officialBarTipActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r3) {
        bb bbVar;
        bi biVar;
        bb bbVar2;
        bi biVar2;
        bi biVar3;
        this.a.closeLoadingDialog();
        bbVar = this.a.c;
        if (bbVar.b() != null) {
            biVar = this.a.b;
            if (biVar != null) {
                bbVar2 = this.a.c;
                az b = bbVar2.b();
                biVar2 = this.a.b;
                b.a(biVar2.a());
                this.a.d();
                biVar3 = this.a.b;
                if (biVar3.a().size() == 0) {
                    this.a.a(true);
                } else {
                    this.a.a(false);
                }
            }
        }
    }
}
