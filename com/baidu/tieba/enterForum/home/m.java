package com.baidu.tieba.enterForum.home;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.view.aj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements aj {
    final /* synthetic */ a aFe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(a aVar) {
        this.aFe = aVar;
    }

    @Override // com.baidu.tbadk.core.view.aj
    public void onListPullRefresh(boolean z) {
        com.baidu.tieba.enterForum.c.c cVar;
        String str;
        cVar = this.aFe.aEN;
        str = this.aFe.aEP;
        cVar.bJ(!StringUtils.isNull(str));
    }
}
