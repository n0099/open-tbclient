package com.baidu.tieba.homepage.framework.indicator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.util.g<String> {
    final /* synthetic */ a cri;
    private final /* synthetic */ com.baidu.tieba.homepage.framework.x crj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar, com.baidu.tieba.homepage.framework.x xVar) {
        this.cri = aVar;
        this.crj = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    /* renamed from: kf */
    public void onReturnDataInUI(String str) {
        if (this.crj != null) {
            this.crj.jm(com.baidu.adp.lib.h.b.g(str, 0));
        }
    }
}
