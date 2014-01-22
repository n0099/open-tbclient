package com.baidu.tieba.im.model;

import com.baidu.tieba.im.chat.MsglistActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements Runnable {
    final /* synthetic */ MsglistModel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(MsglistModel msglistModel) {
        this.a = msglistModel;
    }

    @Override // java.lang.Runnable
    public void run() {
        MsglistActivity msglistActivity;
        msglistActivity = this.a.p;
        msglistActivity.finish();
    }
}
