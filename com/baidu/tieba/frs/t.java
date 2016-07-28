package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements com.baidu.tbadk.util.e<Boolean> {
    final /* synthetic */ s bEO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.bEO = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.e
    /* renamed from: e */
    public void F(Boolean bool) {
        FrsActivity frsActivity;
        bq bqVar;
        FrsActivity frsActivity2;
        bq bqVar2;
        if (bool != null) {
            frsActivity = this.bEO.bEL;
            bqVar = frsActivity.bDK;
            if (bqVar != null) {
                frsActivity2 = this.bEO.bEL;
                bqVar2 = frsActivity2.bDK;
                bqVar2.WZ();
            }
        }
    }
}
