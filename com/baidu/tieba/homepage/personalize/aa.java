package com.baidu.tieba.homepage.personalize;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements com.baidu.tbadk.util.f<String> {
    private final /* synthetic */ m czj;
    final /* synthetic */ n this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(n nVar, m mVar) {
        this.this$0 = nVar;
        this.czj = mVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    /* renamed from: jy */
    public void onReturnDataInUI(String str) {
        if (this.czj != null) {
            this.czj.jE(com.baidu.adp.lib.g.b.g(str, 0));
        }
    }
}
