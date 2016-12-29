package com.baidu.tieba.homepage.personalize;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements com.baidu.tbadk.util.f<String> {
    private final /* synthetic */ m cqM;
    final /* synthetic */ n this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(n nVar, m mVar) {
        this.this$0 = nVar;
        this.cqM = mVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    /* renamed from: jJ */
    public void onReturnDataInUI(String str) {
        if (this.cqM != null) {
            this.cqM.jm(com.baidu.adp.lib.h.b.g(str, 0));
        }
    }
}
