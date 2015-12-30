package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements a.b {
    final /* synthetic */ TalkableActivity bLV;
    private final /* synthetic */ int bLX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(TalkableActivity talkableActivity, int i) {
        this.bLV = talkableActivity;
        this.bLX = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.bLV.reSendMsg(this.bLX);
    }
}
