package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.util.e<Boolean> {
    final /* synthetic */ u bQl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.bQl = uVar;
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
            frsActivity = this.bQl.bQi;
            bmVar = frsActivity.bPi;
            if (bmVar != null) {
                frsActivity2 = this.bQl.bQi;
                bmVar2 = frsActivity2.bPi;
                bmVar2.aci();
            }
        }
    }
}
