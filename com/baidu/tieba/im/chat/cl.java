package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cl implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ TalkableActivity aYt;
    private final /* synthetic */ int aYu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(TalkableActivity talkableActivity, int i) {
        this.aYt = talkableActivity;
        this.aYu = i;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.aYt.reSendMsg(this.aYu);
    }
}
