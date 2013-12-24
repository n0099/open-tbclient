package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cg implements View.OnClickListener {
    final /* synthetic */ bu a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(bu buVar) {
        this.a = buVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
        this.a.K();
        button = this.a.x;
        button.postDelayed(new ch(this), 100L);
    }
}
