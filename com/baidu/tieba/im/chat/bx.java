package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx implements a.b {
    private final /* synthetic */ int Ua;
    final /* synthetic */ TalkableActivity caU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(TalkableActivity talkableActivity, int i) {
        this.caU = talkableActivity;
        this.Ua = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.caU.deleteMsg(this.Ua);
    }
}
