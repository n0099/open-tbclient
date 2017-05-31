package com.baidu.tieba.frs;

import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements bz {
    final /* synthetic */ r bVb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(r rVar) {
        this.bVb = rVar;
    }

    @Override // com.baidu.tieba.frs.bz
    public void a(int i, int i2, ch chVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        com.baidu.adp.lib.g.h.fS().post(new ai(this));
    }
}
