package com.baidu.tieba.applist;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.util.m;
/* loaded from: classes.dex */
class d extends m<Object> {
    final /* synthetic */ b aKs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.aKs = bVar;
    }

    @Override // com.baidu.tbadk.util.m
    public Object doInBackground() {
        MessageManager.getInstance().sendMessageFromBackground(new ApplistRequest());
        return null;
    }
}
