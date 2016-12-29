package com.baidu.tieba.homepage.framework.indicator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.util.f<String> {
    final /* synthetic */ a cnD;
    private final /* synthetic */ com.baidu.tieba.homepage.framework.x cnE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar, com.baidu.tieba.homepage.framework.x xVar) {
        this.cnD = aVar;
        this.cnE = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    /* renamed from: jJ */
    public void onReturnDataInUI(String str) {
        if (this.cnE != null) {
            this.cnE.jm(com.baidu.adp.lib.h.b.g(str, 0));
        }
    }
}
