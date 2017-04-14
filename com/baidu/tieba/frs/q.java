package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class q implements com.baidu.tbadk.util.e<Boolean> {
    final /* synthetic */ FrsActivity bNJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FrsActivity frsActivity) {
        this.bNJ = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.e
    /* renamed from: d */
    public void F(Boolean bool) {
        if (bool != null && this.bNJ.bMD != null) {
            this.bNJ.bMD.aal();
        }
    }
}
