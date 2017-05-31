package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx implements a.b {
    private final /* synthetic */ int acg;
    final /* synthetic */ TalkableActivity cQy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(TalkableActivity talkableActivity, int i) {
        this.cQy = talkableActivity;
        this.acg = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.cQy.deleteMsg(this.acg);
    }
}
