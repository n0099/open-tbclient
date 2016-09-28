package com.baidu.tieba.homepage.recommendfrs;

import com.baidu.tieba.homepage.framework.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tbadk.util.g<String> {
    private final /* synthetic */ x cCW;
    final /* synthetic */ b cIy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, x xVar) {
        this.cIy = bVar;
        this.cCW = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    /* renamed from: kU */
    public void onReturnDataInUI(String str) {
        if (str != null && this.cCW != null) {
            this.cCW.jU(com.baidu.adp.lib.h.b.g(str, 0));
        }
    }
}
