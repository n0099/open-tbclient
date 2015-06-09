package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cm implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ TalkableActivity bbb;
    private final /* synthetic */ int bbc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(TalkableActivity talkableActivity, int i) {
        this.bbb = talkableActivity;
        this.bbc = i;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.bbb.deleteMsg(this.bbc);
    }
}
