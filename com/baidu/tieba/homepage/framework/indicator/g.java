package com.baidu.tieba.homepage.framework.indicator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.util.g<String> {
    final /* synthetic */ a cCV;
    private final /* synthetic */ com.baidu.tieba.homepage.framework.x cCW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar, com.baidu.tieba.homepage.framework.x xVar) {
        this.cCV = aVar;
        this.cCW = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    /* renamed from: kU */
    public void onReturnDataInUI(String str) {
        if (this.cCW != null) {
            this.cCW.jU(com.baidu.adp.lib.h.b.g(str, 0));
        }
    }
}
