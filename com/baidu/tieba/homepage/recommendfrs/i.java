package com.baidu.tieba.homepage.recommendfrs;

import com.baidu.tieba.homepage.framework.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tbadk.util.g<String> {
    private final /* synthetic */ x cCr;
    final /* synthetic */ b cHG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, x xVar) {
        this.cHG = bVar;
        this.cCr = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    /* renamed from: kN */
    public void onReturnDataInUI(String str) {
        if (str != null && this.cCr != null) {
            this.cCr.jO(com.baidu.adp.lib.h.b.g(str, 0));
        }
    }
}
