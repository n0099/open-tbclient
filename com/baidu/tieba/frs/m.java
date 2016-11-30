package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class m implements com.baidu.tbadk.util.e<Boolean> {
    final /* synthetic */ FrsActivity bTa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity) {
        this.bTa = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.e
    /* renamed from: e */
    public void F(Boolean bool) {
        if (bool != null && this.bTa.bRW != null) {
            this.bTa.bRW.adp();
        }
    }
}
