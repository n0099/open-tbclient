package com.baidu.tieba.im.chat;

import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ bp a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bp bpVar) {
        this.a = bpVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        String a;
        if (dVar == null) {
            this.a.a(this.a.c.getString(R.string.save_error));
            return;
        }
        bp bpVar = this.a;
        a = this.a.a(str, dVar.k());
        bpVar.a(a);
    }
}
