package com.baidu.tieba.enterForum.home;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.view.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements r.a {
    final /* synthetic */ i aWN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.aWN = iVar;
    }

    @Override // com.baidu.tbadk.core.view.r.a
    public void az(boolean z) {
        com.baidu.tieba.enterForum.c.c cVar;
        String str;
        cVar = this.aWN.aWt;
        str = this.aWN.aWv;
        cVar.cb(!StringUtils.isNull(str));
    }
}
