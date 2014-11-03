package com.baidu.tieba.im.groupInfo;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements DialogInterface.OnClickListener {
    private final /* synthetic */ int BG;
    final /* synthetic */ t bbH;
    private final /* synthetic */ Object bbI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar, Object obj, int i) {
        this.bbH = tVar;
        this.bbI = obj;
        this.BG = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ae aeVar;
        aeVar = this.bbH.bbn;
        aeVar.a(dialogInterface, i, this.bbI, this.BG);
    }
}
