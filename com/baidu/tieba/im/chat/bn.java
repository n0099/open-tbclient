package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bg f1534a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bg bgVar) {
        this.f1534a = bgVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
        this.f1534a.M();
        this.f1534a.O();
        button = this.f1534a.n;
        button.postDelayed(new bo(this), 100L);
    }
}
