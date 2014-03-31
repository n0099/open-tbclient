package com.baidu.tieba.im.chat.officialBar;
/* loaded from: classes.dex */
final class ar implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ OfficialBarTipActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(OfficialBarTipActivity officialBarTipActivity) {
        this.a = officialBarTipActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Void r3) {
        az azVar;
        com.baidu.tieba.im.model.bc bcVar;
        az azVar2;
        com.baidu.tieba.im.model.bc bcVar2;
        com.baidu.tieba.im.model.bc bcVar3;
        this.a.closeLoadingDialog();
        azVar = this.a.b;
        if (azVar.d() != null) {
            bcVar = this.a.a;
            if (bcVar == null) {
                return;
            }
            azVar2 = this.a.b;
            ax d = azVar2.d();
            bcVar2 = this.a.a;
            d.a(bcVar2.a());
            OfficialBarTipActivity.c(this.a);
            bcVar3 = this.a.a;
            if (bcVar3.a().size() == 0) {
                this.a.b.e().b(r3 ? 0 : 8);
            } else {
                this.a.b.e().b(r3 ? 0 : 8);
            }
        }
    }
}
