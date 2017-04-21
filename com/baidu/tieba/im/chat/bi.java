package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bi implements View.OnClickListener {
    final /* synthetic */ MsgleftView cQx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(MsgleftView msgleftView) {
        this.cQx = msgleftView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cQx.cPJ.a(view, 2, this.cQx.atz, 0L);
    }
}
