package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements View.OnClickListener {
    final /* synthetic */ bu a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(bu buVar) {
        this.a = buVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
        this.a.L();
        this.a.N();
        button = this.a.n;
        button.postDelayed(new cd(this), 100L);
    }
}
