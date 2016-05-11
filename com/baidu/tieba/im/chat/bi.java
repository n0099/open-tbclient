package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bi implements View.OnClickListener {
    final /* synthetic */ MsgleftView cat;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(MsgleftView msgleftView) {
        this.cat = msgleftView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cat.bZF.a(view, 2, this.cat.aka, 0L);
    }
}
