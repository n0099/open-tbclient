package com.baidu.tieba.im.model;

import com.baidu.tieba.im.chat.bc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements Runnable {
    final /* synthetic */ MsglistModel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(MsglistModel msglistModel) {
        this.a = msglistModel;
    }

    @Override // java.lang.Runnable
    public void run() {
        bc bcVar;
        bcVar = this.a.p;
        bcVar.finish();
    }
}
