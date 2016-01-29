package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements a.b {
    final /* synthetic */ TalkableActivity bPX;
    private final /* synthetic */ int bPZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(TalkableActivity talkableActivity, int i) {
        this.bPX = talkableActivity;
        this.bPZ = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.bPX.reSendMsg(this.bPZ);
    }
}
