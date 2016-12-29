package com.baidu.tieba.homepage.recommendfrs;

import com.baidu.tieba.homepage.framework.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tbadk.util.f<String> {
    private final /* synthetic */ x cnE;
    final /* synthetic */ b csS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, x xVar) {
        this.csS = bVar;
        this.cnE = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    /* renamed from: jJ */
    public void onReturnDataInUI(String str) {
        if (str != null && this.cnE != null) {
            this.cnE.jm(com.baidu.adp.lib.h.b.g(str, 0));
        }
    }
}
