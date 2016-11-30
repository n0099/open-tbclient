package com.baidu.tieba.homepage.personalize;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements com.baidu.tbadk.util.f<String> {
    private final /* synthetic */ m cLr;
    final /* synthetic */ n this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(n nVar, m mVar) {
        this.this$0 = nVar;
        this.cLr = mVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    /* renamed from: lf */
    public void onReturnDataInUI(String str) {
        if (this.cLr != null) {
            this.cLr.kb(com.baidu.adp.lib.h.b.g(str, 0));
        }
    }
}
