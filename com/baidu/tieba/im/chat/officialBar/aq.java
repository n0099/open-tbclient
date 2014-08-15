package com.baidu.tieba.im.chat.officialBar;
/* loaded from: classes.dex */
class aq implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ OfficialBarTipActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(OfficialBarTipActivity officialBarTipActivity) {
        this.a = officialBarTipActivity;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void a() {
        aw awVar;
        aw awVar2;
        com.baidu.tieba.im.model.ar arVar;
        com.baidu.tieba.im.model.ar arVar2;
        aw awVar3;
        com.baidu.tieba.im.model.ar arVar3;
        awVar = this.a.c;
        if (awVar != null) {
            awVar2 = this.a.c;
            if (awVar2.b() != null) {
                arVar = this.a.b;
                if (arVar != null) {
                    arVar2 = this.a.b;
                    if (arVar2.a().size() == 0) {
                        this.a.finish();
                    }
                    awVar3 = this.a.c;
                    au b = awVar3.b();
                    arVar3 = this.a.b;
                    b.a(arVar3.a());
                }
            }
        }
    }
}
