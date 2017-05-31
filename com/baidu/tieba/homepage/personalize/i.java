package com.baidu.tieba.homepage.personalize;

import com.baidu.tbadk.core.view.ae;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements ae.b {
    final /* synthetic */ b cAU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar) {
        this.cAU = bVar;
    }

    @Override // com.baidu.tbadk.core.view.ae.b
    public void onListPullRefresh(boolean z) {
        o oVar;
        this.cAU.cAP = true;
        oVar = this.cAU.cAM;
        oVar.update();
    }
}
