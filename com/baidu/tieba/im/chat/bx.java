package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx implements a.b {
    private final /* synthetic */ int acK;
    final /* synthetic */ TalkableActivity cOH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(TalkableActivity talkableActivity, int i) {
        this.cOH = talkableActivity;
        this.acK = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.cOH.deleteMsg(this.acK);
    }
}
