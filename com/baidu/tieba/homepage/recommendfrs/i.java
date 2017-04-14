package com.baidu.tieba.homepage.recommendfrs;

import com.baidu.tieba.homepage.framework.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tbadk.util.f<String> {
    private final /* synthetic */ x cuF;
    final /* synthetic */ b czR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, x xVar) {
        this.czR = bVar;
        this.cuF = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    /* renamed from: jD */
    public void onReturnDataInUI(String str) {
        if (str != null && this.cuF != null) {
            this.cuF.jF(com.baidu.adp.lib.g.b.g(str, 0));
        }
    }
}
