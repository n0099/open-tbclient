package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.model.MsglistModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ bc b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bc bcVar, String str) {
        this.b = bcVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        MsglistModel msglistModel;
        msglistModel = this.b.h;
        msglistModel.c(this.a);
    }
}
