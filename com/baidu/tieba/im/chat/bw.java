package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements a.b {
    private final /* synthetic */ int acv;
    final /* synthetic */ TalkableActivity cQk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(TalkableActivity talkableActivity, int i) {
        this.cQk = talkableActivity;
        this.acv = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.cQk.reSendMsg(this.acv);
    }
}
