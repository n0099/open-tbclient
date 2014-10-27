package com.baidu.tieba.im.groupUpdates;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ UpdatesActivity bbU;
    private final /* synthetic */ com.baidu.tieba.im.a bbV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(UpdatesActivity updatesActivity, com.baidu.tieba.im.a aVar) {
        this.bbU = updatesActivity;
        this.bbV = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void onReturnDataInUI(Boolean bool) {
        p pVar;
        t tVar;
        pVar = this.bbU.bbT;
        pVar.Pg();
        tVar = this.bbU.bbM;
        tVar.Pl();
        this.bbU.df(false);
        p.c(this.bbV);
    }
}
