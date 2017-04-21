package com.baidu.tieba.homepage.personalize;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements com.baidu.tbadk.util.f<String> {
    private final /* synthetic */ m cAa;
    final /* synthetic */ n this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(n nVar, m mVar) {
        this.this$0 = nVar;
        this.cAa = mVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    /* renamed from: jE */
    public void onReturnDataInUI(String str) {
        if (this.cAa != null) {
            this.cAa.jL(com.baidu.adp.lib.g.b.g(str, 0));
        }
    }
}
