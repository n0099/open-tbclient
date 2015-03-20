package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cl implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ TalkableActivity aYd;
    private final /* synthetic */ int aYe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(TalkableActivity talkableActivity, int i) {
        this.aYd = talkableActivity;
        this.aYe = i;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.aYd.reSendMsg(this.aYe);
    }
}
