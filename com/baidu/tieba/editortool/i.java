package com.baidu.tieba.editortool;

import android.view.View;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f1232a;
    final /* synthetic */ ImageUploadView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ImageUploadView imageUploadView, h hVar) {
        this.b = imageUploadView;
        this.f1232a = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
        Button button2;
        button = this.b.b;
        if (view != button) {
            button2 = this.b.c;
            if (view == button2) {
                this.f1232a.a(23, null);
                return;
            }
            return;
        }
        this.f1232a.a(22, null);
    }
}
