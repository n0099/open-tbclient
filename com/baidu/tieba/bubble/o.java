package com.baidu.tieba.bubble;

import com.baidu.tieba.data.BubbleListData;
/* loaded from: classes.dex */
class o implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ s ajt;
    private final /* synthetic */ BubbleListData.BubbleData aju;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(s sVar, BubbleListData.BubbleData bubbleData) {
        this.ajt = sVar;
        this.aju = bubbleData;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (this.ajt != null) {
            this.ajt.dV(this.aju.getBcode());
        }
    }
}
