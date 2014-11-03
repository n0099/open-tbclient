package com.baidu.tieba.im.groupUpdates;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ UpdatesActivity bci;
    private final /* synthetic */ com.baidu.tieba.im.a bcj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(UpdatesActivity updatesActivity, com.baidu.tieba.im.a aVar) {
        this.bci = updatesActivity;
        this.bcj = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void onReturnDataInUI(Boolean bool) {
        p pVar;
        t tVar;
        pVar = this.bci.bch;
        pVar.Pj();
        tVar = this.bci.bca;
        tVar.Po();
        this.bci.df(false);
        p.c(this.bcj);
    }
}
