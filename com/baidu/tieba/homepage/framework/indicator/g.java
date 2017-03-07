package com.baidu.tieba.homepage.framework.indicator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.util.f<String> {
    final /* synthetic */ a cwe;
    private final /* synthetic */ com.baidu.tieba.homepage.framework.x cwf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar, com.baidu.tieba.homepage.framework.x xVar) {
        this.cwe = aVar;
        this.cwf = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    /* renamed from: jy */
    public void onReturnDataInUI(String str) {
        if (this.cwf != null) {
            this.cwf.jE(com.baidu.adp.lib.g.b.g(str, 0));
        }
    }
}
