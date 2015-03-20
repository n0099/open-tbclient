package com.baidu.tieba.enterForum.home;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.view.ae;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements ae {
    final /* synthetic */ a aCT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(a aVar) {
        this.aCT = aVar;
    }

    @Override // com.baidu.tbadk.core.view.ae
    public void onListPullRefresh(boolean z) {
        com.baidu.tieba.enterForum.c.c cVar;
        String str;
        cVar = this.aCT.aCC;
        str = this.aCT.aCE;
        cVar.bz(!StringUtils.isNull(str));
    }
}
