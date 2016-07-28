package com.baidu.tieba.homepage.recommendfrs;

import com.baidu.tieba.homepage.framework.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.util.g<String> {
    private final /* synthetic */ x crj;
    final /* synthetic */ b cwb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(b bVar, x xVar) {
        this.cwb = bVar;
        this.crj = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    /* renamed from: kf */
    public void onReturnDataInUI(String str) {
        if (str != null && this.crj != null) {
            this.crj.jm(com.baidu.adp.lib.h.b.g(str, 0));
        }
    }
}
