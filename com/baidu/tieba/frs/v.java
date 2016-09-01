package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.util.e<Boolean> {
    final /* synthetic */ u bQs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.bQs = uVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.e
    /* renamed from: e */
    public void F(Boolean bool) {
        FrsActivity frsActivity;
        bm bmVar;
        FrsActivity frsActivity2;
        bm bmVar2;
        if (bool != null) {
            frsActivity = this.bQs.bQp;
            bmVar = frsActivity.bPo;
            if (bmVar != null) {
                frsActivity2 = this.bQs.bQp;
                bmVar2 = frsActivity2.bPo;
                bmVar2.abV();
            }
        }
    }
}
