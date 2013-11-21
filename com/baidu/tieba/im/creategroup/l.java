package com.baidu.tieba.im.creategroup;

import android.content.DialogInterface;
import com.baidu.tieba.write.bd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f1582a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.f1582a = jVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            bd.a(this.f1582a.f1580a);
        } else if (i == 1) {
            bd.b(this.f1582a.f1580a);
        }
    }
}
