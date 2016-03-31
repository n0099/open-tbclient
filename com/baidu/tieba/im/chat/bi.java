package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bi implements View.OnClickListener {
    final /* synthetic */ MsgleftView bZO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(MsgleftView msgleftView) {
        this.bZO = msgleftView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bZO.bZa.a(view, 2, this.bZO.aom, 0L);
    }
}
