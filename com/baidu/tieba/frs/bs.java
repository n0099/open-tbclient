package com.baidu.tieba.frs;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.by;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements DialogInterface.OnClickListener {
    final /* synthetic */ bq a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(bq bqVar) {
        this.a = bqVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        boolean z;
        Context context;
        switch (i) {
            case 0:
                if (TiebaApplication.h().ak() != 1) {
                    this.a.q = true;
                }
                TiebaApplication.h().d(1);
                break;
            case 1:
                if (TiebaApplication.h().ak() != 0) {
                    this.a.q = true;
                }
                TiebaApplication.h().d(0);
                break;
            case 2:
                if (TiebaApplication.h().ak() != 2) {
                    this.a.q = true;
                }
                TiebaApplication.h().d(2);
                break;
        }
        z = this.a.q;
        if (z) {
            context = this.a.b;
            by.a(context, "frs_abstract", "frsclick", 1, new Object[0]);
        }
        this.a.h();
    }
}
