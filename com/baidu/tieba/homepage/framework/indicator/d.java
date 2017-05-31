package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tbadk.util.g<String> {
    final /* synthetic */ a cAb;
    private final /* synthetic */ u cAc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, u uVar) {
        this.cAb = aVar;
        this.cAc = uVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    /* renamed from: jV */
    public void onReturnDataInUI(String str) {
        if (this.cAc != null) {
            this.cAc.kd(com.baidu.adp.lib.g.b.g(str, 0));
        }
    }
}
