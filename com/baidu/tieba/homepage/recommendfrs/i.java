package com.baidu.tieba.homepage.recommendfrs;

import com.baidu.tieba.homepage.framework.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tbadk.util.f<String> {
    private final /* synthetic */ x cuG;
    final /* synthetic */ b czW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, x xVar) {
        this.czW = bVar;
        this.cuG = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    /* renamed from: jX */
    public void onReturnDataInUI(String str) {
        if (str != null && this.cuG != null) {
            this.cuG.jZ(com.baidu.adp.lib.g.b.g(str, 0));
        }
    }
}
