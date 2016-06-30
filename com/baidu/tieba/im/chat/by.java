package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements a.b {
    private final /* synthetic */ int Ur;
    final /* synthetic */ TalkableActivity cGe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(TalkableActivity talkableActivity, int i) {
        this.cGe = talkableActivity;
        this.Ur = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.cGe.deleteMsg(this.Ur);
    }
}
