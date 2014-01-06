package com.baidu.tieba.editortool;

import android.view.View;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ t a;
    final /* synthetic */ ImageUploadView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(ImageUploadView imageUploadView, t tVar) {
        this.b = imageUploadView;
        this.a = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
        Button button2;
        button = this.b.b;
        if (view != button) {
            button2 = this.b.c;
            if (view == button2) {
                this.a.a(23, null);
                return;
            }
            return;
        }
        this.a.a(22, null);
    }
}
