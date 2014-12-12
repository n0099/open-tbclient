package com.baidu.tieba.im.chat.stranger;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ MsgReplyCardView aUn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(MsgReplyCardView msgReplyCardView) {
        this.aUn = msgReplyCardView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.c.a aVar;
        int i;
        aVar = this.aUn.mItemViewClickListener;
        i = this.aUn.mPosition;
        aVar.onItemViewClick(view, 14, i, 0L);
    }
}
