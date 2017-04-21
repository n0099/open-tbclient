package com.baidu.tieba.homepage.recommendfrs;

import com.baidu.tieba.homepage.framework.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tbadk.util.f<String> {
    final /* synthetic */ b cCi;
    private final /* synthetic */ x cwW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, x xVar) {
        this.cCi = bVar;
        this.cwW = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    /* renamed from: jE */
    public void onReturnDataInUI(String str) {
        if (str != null && this.cwW != null) {
            this.cwW.jL(com.baidu.adp.lib.g.b.g(str, 0));
        }
    }
}
