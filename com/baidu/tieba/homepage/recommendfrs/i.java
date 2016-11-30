package com.baidu.tieba.homepage.recommendfrs;

import com.baidu.tieba.homepage.framework.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tbadk.util.f<String> {
    private final /* synthetic */ x cIj;
    final /* synthetic */ b cNN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, x xVar) {
        this.cNN = bVar;
        this.cIj = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    /* renamed from: lf */
    public void onReturnDataInUI(String str) {
        if (str != null && this.cIj != null) {
            this.cIj.kb(com.baidu.adp.lib.h.b.g(str, 0));
        }
    }
}
