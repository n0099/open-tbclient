package com.baidu.tieba.homepage.recommendfrs;

import com.baidu.tieba.homepage.framework.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tbadk.util.f<String> {
    final /* synthetic */ b cBs;
    private final /* synthetic */ x cwf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, x xVar) {
        this.cBs = bVar;
        this.cwf = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    /* renamed from: jy */
    public void onReturnDataInUI(String str) {
        if (str != null && this.cwf != null) {
            this.cwf.jE(com.baidu.adp.lib.g.b.g(str, 0));
        }
    }
}
