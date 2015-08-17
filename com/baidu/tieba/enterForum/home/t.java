package com.baidu.tieba.enterForum.home;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.view.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements x.a {
    final /* synthetic */ d aMD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(d dVar) {
        this.aMD = dVar;
    }

    @Override // com.baidu.tbadk.core.view.x.a
    public void onListPullRefresh(boolean z) {
        com.baidu.tieba.enterForum.c.c cVar;
        String str;
        cVar = this.aMD.aMn;
        str = this.aMD.aMp;
        cVar.bL(!StringUtils.isNull(str));
    }
}
