package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class q implements com.baidu.tbadk.util.e<Boolean> {
    final /* synthetic */ FrsActivity bQa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FrsActivity frsActivity) {
        this.bQa = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.e
    /* renamed from: d */
    public void F(Boolean bool) {
        if (bool != null && this.bQa.bOU != null) {
            this.bQa.bOU.abm();
        }
    }
}
