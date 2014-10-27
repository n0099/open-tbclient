package com.baidu.tieba.im.groupInfo;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements DialogInterface.OnClickListener {
    private final /* synthetic */ int BF;
    final /* synthetic */ s bbt;
    private final /* synthetic */ Object bbu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(s sVar, Object obj, int i) {
        this.bbt = sVar;
        this.bbu = obj;
        this.BF = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ad adVar;
        adVar = this.bbt.baZ;
        adVar.a(dialogInterface, i, this.bbu, this.BF);
    }
}
