package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx implements a.b {
    final /* synthetic */ TalkableActivity bti;
    private final /* synthetic */ int btk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(TalkableActivity talkableActivity, int i) {
        this.bti = talkableActivity;
        this.btk = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.bti.deleteMsg(this.btk);
    }
}
