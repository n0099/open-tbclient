package com.baidu.tieba.frs;

import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements ca {
    final /* synthetic */ r cdl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(r rVar) {
        this.cdl = rVar;
    }

    @Override // com.baidu.tieba.frs.ca
    public void a(int i, int i2, ci ciVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        com.baidu.adp.lib.g.h.fR().post(new ai(this));
    }
}
