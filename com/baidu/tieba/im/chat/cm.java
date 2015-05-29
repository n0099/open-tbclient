package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cm implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ TalkableActivity bba;
    private final /* synthetic */ int bbb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(TalkableActivity talkableActivity, int i) {
        this.bba = talkableActivity;
        this.bbb = i;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.bba.deleteMsg(this.bbb);
    }
}
