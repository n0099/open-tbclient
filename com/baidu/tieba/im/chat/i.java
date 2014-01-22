package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
        this.a.Q();
        this.a.S();
        button = this.a.s;
        button.postDelayed(new j(this), 100L);
    }
}
