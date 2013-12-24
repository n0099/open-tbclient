package com.baidu.tieba.frs;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu implements DialogInterface.OnClickListener {
    final /* synthetic */ bs a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(bs bsVar) {
        this.a = bsVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        boolean z;
        Context context;
        switch (i) {
            case 0:
                if (TiebaApplication.h().al() != 1) {
                    this.a.p = true;
                }
                TiebaApplication.h().d(1);
                break;
            case 1:
                if (TiebaApplication.h().al() != 0) {
                    this.a.p = true;
                }
                TiebaApplication.h().d(0);
                break;
            case 2:
                if (TiebaApplication.h().al() != 2) {
                    this.a.p = true;
                }
                TiebaApplication.h().d(2);
                break;
        }
        z = this.a.p;
        if (z && TiebaApplication.h().t()) {
            context = this.a.b;
            StatService.onEvent(context, "frs_abstract", "frsclick", 1);
        }
        this.a.h();
    }
}
