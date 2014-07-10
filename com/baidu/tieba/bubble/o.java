package com.baidu.tieba.bubble;

import com.baidu.tieba.data.BubbleListData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ s a;
    private final /* synthetic */ BubbleListData.BubbleData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(s sVar, BubbleListData.BubbleData bubbleData) {
        this.a = sVar;
        this.b = bubbleData;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.c();
        if (this.a != null) {
            this.a.a(this.b.getBcode());
        }
    }
}
