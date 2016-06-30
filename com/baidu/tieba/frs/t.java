package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements com.baidu.tbadk.util.e<Boolean> {
    final /* synthetic */ s bDE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.bDE = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.e
    /* renamed from: d */
    public void C(Boolean bool) {
        FrsActivity frsActivity;
        bq bqVar;
        FrsActivity frsActivity2;
        bq bqVar2;
        if (bool != null) {
            frsActivity = this.bDE.bDB;
            bqVar = frsActivity.bCD;
            if (bqVar != null) {
                frsActivity2 = this.bDE.bDB;
                bqVar2 = frsActivity2.bCD;
                bqVar2.WH();
            }
        }
    }
}
