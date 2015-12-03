package com.baidu.tieba.enterForum.home;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.view.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements q.a {
    final /* synthetic */ h aQN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(h hVar) {
        this.aQN = hVar;
    }

    @Override // com.baidu.tbadk.core.view.q.a
    public void onListPullRefresh(boolean z) {
        com.baidu.tieba.enterForum.c.c cVar;
        String str;
        cVar = this.aQN.aQv;
        str = this.aQN.aQx;
        cVar.cc(!StringUtils.isNull(str));
    }
}
