package com.baidu.tieba.frs;

import android.content.DialogInterface;
import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cw implements DialogInterface.OnClickListener {
    final /* synthetic */ cs a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(cs csVar) {
        this.a = csVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        if (i == 0) {
            baseActivity2 = this.a.g;
            com.baidu.tbadk.core.util.bb.a(baseActivity2);
        } else if (i == 1) {
            baseActivity = this.a.g;
            com.baidu.tbadk.core.util.bb.b(baseActivity);
        }
    }
}
