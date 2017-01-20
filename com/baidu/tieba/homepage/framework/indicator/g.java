package com.baidu.tieba.homepage.framework.indicator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.util.f<String> {
    final /* synthetic */ a cuF;
    private final /* synthetic */ com.baidu.tieba.homepage.framework.x cuG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar, com.baidu.tieba.homepage.framework.x xVar) {
        this.cuF = aVar;
        this.cuG = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    /* renamed from: jX */
    public void onReturnDataInUI(String str) {
        if (this.cuG != null) {
            this.cuG.jZ(com.baidu.adp.lib.g.b.g(str, 0));
        }
    }
}
