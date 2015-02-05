package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnClickListener {
    final /* synthetic */ MsgActivityView aRT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(MsgActivityView msgActivityView) {
        this.aRT = msgActivityView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.c.a aVar;
        com.baidu.adp.lib.c.a aVar2;
        int i;
        aVar = this.aRT.mItemViewClickListener;
        if (aVar != null) {
            aVar2 = this.aRT.mItemViewClickListener;
            i = this.aRT.mPosition;
            aVar2.onItemViewClick(view, 8, i, 0L);
        }
    }
}
