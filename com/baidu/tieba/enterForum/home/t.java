package com.baidu.tieba.enterForum.home;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.view.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements p.a {
    final /* synthetic */ d aMe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(d dVar) {
        this.aMe = dVar;
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void onListPullRefresh(boolean z) {
        com.baidu.tieba.enterForum.c.c cVar;
        String str;
        cVar = this.aMe.aLO;
        str = this.aMe.aLQ;
        cVar.bP(!StringUtils.isNull(str));
    }
}
