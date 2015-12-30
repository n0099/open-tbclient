package com.baidu.tieba.enterForum.home;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.view.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements r.a {
    final /* synthetic */ i aUE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(i iVar) {
        this.aUE = iVar;
    }

    @Override // com.baidu.tbadk.core.view.r.a
    public void onListPullRefresh(boolean z) {
        com.baidu.tieba.enterForum.c.c cVar;
        String str;
        cVar = this.aUE.aUm;
        str = this.aUE.aUo;
        cVar.cd(!StringUtils.isNull(str));
    }
}
