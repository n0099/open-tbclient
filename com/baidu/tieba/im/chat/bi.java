package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bi implements View.OnClickListener {
    final /* synthetic */ MsgleftView bsV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(MsgleftView msgleftView) {
        this.bsV = msgleftView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bsV.bsh.onItemViewClick(view, 2, this.bsV.anQ, 0L);
    }
}
