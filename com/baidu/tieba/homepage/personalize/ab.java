package com.baidu.tieba.homepage.personalize;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements com.baidu.tbadk.util.f<String> {
    private final /* synthetic */ m cxJ;
    final /* synthetic */ n this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(n nVar, m mVar) {
        this.this$0 = nVar;
        this.cxJ = mVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    /* renamed from: jD */
    public void onReturnDataInUI(String str) {
        if (this.cxJ != null) {
            this.cxJ.jF(com.baidu.adp.lib.g.b.g(str, 0));
        }
    }
}
