package com.baidu.tieba.im.live.livelist;

import android.view.View;
import android.widget.Button;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.a = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a.a != null) {
            this.a.a.a((Button) view);
        }
    }
}
