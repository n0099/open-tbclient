package com.baidu.tieba.im.creategroup;

import android.content.DialogInterface;
import com.baidu.tieba.write.bc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f1591a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.f1591a = jVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            bc.a(this.f1591a.f1589a);
        } else if (i == 1) {
            bc.b(this.f1591a.f1589a);
        }
    }
}
