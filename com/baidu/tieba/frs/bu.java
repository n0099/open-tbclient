package com.baidu.tieba.frs;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bs f1351a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(bs bsVar) {
        this.f1351a = bsVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        boolean z;
        Context context;
        switch (i) {
            case 0:
                if (TiebaApplication.g().an() != 1) {
                    this.f1351a.r = true;
                }
                TiebaApplication.g().e(1);
                break;
            case 1:
                if (TiebaApplication.g().an() != 0) {
                    this.f1351a.r = true;
                }
                TiebaApplication.g().e(0);
                break;
            case 2:
                if (TiebaApplication.g().an() != 2) {
                    this.f1351a.r = true;
                }
                TiebaApplication.g().e(2);
                break;
        }
        z = this.f1351a.r;
        if (z && TiebaApplication.g().s()) {
            context = this.f1351a.b;
            StatService.onEvent(context, "frs_abstract", "frsclick", 1);
        }
        this.f1351a.h();
    }
}
