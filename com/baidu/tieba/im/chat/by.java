package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements a.b {
    private final /* synthetic */ int Vb;
    final /* synthetic */ TalkableActivity cIT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(TalkableActivity talkableActivity, int i) {
        this.cIT = talkableActivity;
        this.Vb = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.cIT.deleteMsg(this.Vb);
    }
}
