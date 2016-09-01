package com.baidu.tieba.homepage.framework.indicator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.util.g<String> {
    final /* synthetic */ a cCq;
    private final /* synthetic */ com.baidu.tieba.homepage.framework.x cCr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar, com.baidu.tieba.homepage.framework.x xVar) {
        this.cCq = aVar;
        this.cCr = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    /* renamed from: kN */
    public void onReturnDataInUI(String str) {
        if (this.cCr != null) {
            this.cCr.jO(com.baidu.adp.lib.h.b.g(str, 0));
        }
    }
}
