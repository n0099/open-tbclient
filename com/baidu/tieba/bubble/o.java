package com.baidu.tieba.bubble;

import com.baidu.tieba.data.BubbleListData;
/* loaded from: classes.dex */
class o implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ s ajk;
    private final /* synthetic */ BubbleListData.BubbleData ajl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(s sVar, BubbleListData.BubbleData bubbleData) {
        this.ajk = sVar;
        this.ajl = bubbleData;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (this.ajk != null) {
            this.ajk.dV(this.ajl.getBcode());
        }
    }
}
