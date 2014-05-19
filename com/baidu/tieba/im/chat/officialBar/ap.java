package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tieba.im.model.bi;
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
        bi biVar;
        ax axVar2;
        bi biVar2;
        bi biVar3;
        this.a.closeLoadingDialog();
        axVar = this.a.b;
        if (axVar.b() != null) {
            biVar = this.a.a;
            if (biVar != null) {
                axVar2 = this.a.b;
                av b = axVar2.b();
                biVar2 = this.a.a;
                b.a(biVar2.a());
                this.a.d();
                biVar3 = this.a.a;
                if (biVar3.a().size() == 0) {
                    this.a.a(true);
                } else {
                    this.a.a(false);
                }
            }
        }
    }
}
