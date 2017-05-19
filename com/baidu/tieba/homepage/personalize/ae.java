package com.baidu.tieba.homepage.personalize;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.util.g<String> {
    private final /* synthetic */ n cvk;
    final /* synthetic */ o this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(o oVar, n nVar) {
        this.this$0 = oVar;
        this.cvk = nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    /* renamed from: jL */
    public void onReturnDataInUI(String str) {
        if (this.cvk != null) {
            this.cvk.jE(com.baidu.adp.lib.g.b.g(str, 0));
        }
    }
}
