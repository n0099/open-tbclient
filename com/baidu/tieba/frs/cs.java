package com.baidu.tieba.frs;

import android.content.DialogInterface;
import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cs implements DialogInterface.OnClickListener {
    final /* synthetic */ cq a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(cq cqVar) {
        this.a = cqVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        if (i == 0) {
            baseActivity2 = this.a.b;
            com.baidu.tbadk.core.util.bj.a(baseActivity2);
        } else if (i == 1) {
            baseActivity = this.a.b;
            com.baidu.tbadk.core.util.bj.b(baseActivity);
        }
    }
}
