package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bm f1578a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bm bmVar) {
        this.f1578a = bmVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
        this.f1578a.K();
        this.f1578a.M();
        button = this.f1578a.n;
        button.postDelayed(new bu(this), 100L);
    }
}
