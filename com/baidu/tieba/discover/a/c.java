package com.baidu.tieba.discover.a;

import android.view.View;
import com.baidu.tieba.discover.ae;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b avs;
    private final /* synthetic */ com.baidu.tieba.discover.data.c avt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.baidu.tieba.discover.data.c cVar) {
        this.avs = bVar;
        this.avt = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ae aeVar;
        ae aeVar2;
        aeVar = this.avs.avr;
        if (aeVar != null) {
            aeVar2 = this.avs.avr;
            aeVar2.g(this.avt);
        }
    }
}
