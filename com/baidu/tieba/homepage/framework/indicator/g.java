package com.baidu.tieba.homepage.framework.indicator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.util.f<String> {
    final /* synthetic */ a cwV;
    private final /* synthetic */ com.baidu.tieba.homepage.framework.x cwW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar, com.baidu.tieba.homepage.framework.x xVar) {
        this.cwV = aVar;
        this.cwW = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    /* renamed from: jE */
    public void onReturnDataInUI(String str) {
        if (this.cwW != null) {
            this.cwW.jL(com.baidu.adp.lib.g.b.g(str, 0));
        }
    }
}
