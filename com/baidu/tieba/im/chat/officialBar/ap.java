package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tieba.im.model.bj;
/* loaded from: classes.dex */
class ap implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ OfficialBarTipActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(OfficialBarTipActivity officialBarTipActivity) {
        this.a = officialBarTipActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r3) {
        ax axVar;
        bj bjVar;
        ax axVar2;
        bj bjVar2;
        bj bjVar3;
        this.a.closeLoadingDialog();
        axVar = this.a.b;
        if (axVar.b() != null) {
            bjVar = this.a.a;
            if (bjVar != null) {
                axVar2 = this.a.b;
                av b = axVar2.b();
                bjVar2 = this.a.a;
                b.a(bjVar2.a());
                this.a.d();
                bjVar3 = this.a.a;
                if (bjVar3.a().size() == 0) {
                    this.a.a(true);
                } else {
                    this.a.a(false);
                }
            }
        }
    }
}
