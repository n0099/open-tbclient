package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.model.MsglistModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ ba b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(ba baVar, String str) {
        this.b = baVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        MsglistModel msglistModel;
        msglistModel = this.b.h;
        msglistModel.c(this.a);
    }
}
