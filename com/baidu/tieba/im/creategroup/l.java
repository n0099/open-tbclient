package com.baidu.tieba.im.creategroup;

import android.content.DialogInterface;
import com.baidu.tieba.write.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f1500a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.f1500a = jVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            bg.a(this.f1500a.f1498a);
        } else if (i == 1) {
            bg.b(this.f1500a.f1498a);
        }
    }
}
