package com.baidu.tieba.homepage.framework.indicator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.util.f<String> {
    final /* synthetic */ a cIi;
    private final /* synthetic */ com.baidu.tieba.homepage.framework.x cIj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar, com.baidu.tieba.homepage.framework.x xVar) {
        this.cIi = aVar;
        this.cIj = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    /* renamed from: lf */
    public void onReturnDataInUI(String str) {
        if (this.cIj != null) {
            this.cIj.kb(com.baidu.adp.lib.h.b.g(str, 0));
        }
    }
}
