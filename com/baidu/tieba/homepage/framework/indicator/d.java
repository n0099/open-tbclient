package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tbadk.util.h<String> {
    final /* synthetic */ a cHN;
    private final /* synthetic */ u cHO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, u uVar) {
        this.cHN = aVar;
        this.cHO = uVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.h
    /* renamed from: kT */
    public void onReturnDataInUI(String str) {
        if (this.cHO != null) {
            this.cHO.ko(com.baidu.adp.lib.g.b.g(str, 0));
        }
    }
}
