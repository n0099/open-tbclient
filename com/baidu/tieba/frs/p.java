package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements com.baidu.tbadk.util.e<Boolean> {
    final /* synthetic */ o bho;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.bho = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.e
    /* renamed from: d */
    public void C(Boolean bool) {
        FrsActivity frsActivity;
        cn cnVar;
        FrsActivity frsActivity2;
        cn cnVar2;
        if (bool != null) {
            frsActivity = this.bho.bhl;
            cnVar = frsActivity.bgo;
            if (cnVar != null) {
                frsActivity2 = this.bho.bhl;
                cnVar2 = frsActivity2.bgo;
                cnVar2.Ro();
            }
        }
    }
}
