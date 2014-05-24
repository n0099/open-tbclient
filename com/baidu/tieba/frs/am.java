package com.baidu.tieba.frs;

import android.content.DialogInterface;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsActivity a;
    private final /* synthetic */ com.baidu.tbadk.core.data.b b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(FrsActivity frsActivity, com.baidu.tbadk.core.data.b bVar, int i) {
        this.a = frsActivity;
        this.b = bVar;
        this.c = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.b.d() == 2) {
            String a = this.b.a();
            if (!TextUtils.isEmpty(a)) {
                com.baidu.tbadk.core.util.bi.a().a(this.a, new String[]{a});
                return;
            } else {
                this.a.b(this.b, this.c);
                return;
            }
        }
        this.a.b(this.b, this.c);
    }
}
