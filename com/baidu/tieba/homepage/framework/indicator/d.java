package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tbadk.util.g<String> {
    final /* synthetic */ a ctJ;
    private final /* synthetic */ u ctK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, u uVar) {
        this.ctJ = aVar;
        this.ctK = uVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    /* renamed from: jL */
    public void onReturnDataInUI(String str) {
        if (this.ctK != null) {
            this.ctK.jE(com.baidu.adp.lib.g.b.g(str, 0));
        }
    }
}
