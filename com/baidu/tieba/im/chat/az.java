package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.model.MsglistModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1510a;
    final /* synthetic */ MsglistActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(MsglistActivity msglistActivity, String str) {
        this.b = msglistActivity;
        this.f1510a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        MsglistModel msglistModel;
        msglistModel = this.b.g;
        msglistModel.c(this.f1510a);
    }
}
