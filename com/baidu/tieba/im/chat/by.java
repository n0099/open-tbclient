package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements a.b {
    private final /* synthetic */ int Yz;
    final /* synthetic */ TalkableActivity dbD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(TalkableActivity talkableActivity, int i) {
        this.dbD = talkableActivity;
        this.Yz = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.dbD.deleteMsg(this.Yz);
    }
}
