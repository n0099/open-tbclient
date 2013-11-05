package com.baidu.tieba.frs;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bh f1278a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(bh bhVar) {
        this.f1278a = bhVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        boolean z;
        Context context;
        switch (i) {
            case 0:
                if (TiebaApplication.g().aq() != 1) {
                    this.f1278a.q = true;
                }
                TiebaApplication.g().h(1);
                break;
            case 1:
                if (TiebaApplication.g().aq() != 0) {
                    this.f1278a.q = true;
                }
                TiebaApplication.g().h(0);
                break;
            case 2:
                if (TiebaApplication.g().aq() != 2) {
                    this.f1278a.q = true;
                }
                TiebaApplication.g().h(2);
                break;
        }
        z = this.f1278a.q;
        if (z && TiebaApplication.g().s()) {
            context = this.f1278a.b;
            StatService.onEvent(context, "frs_abstract", "frsclick", 1);
        }
        this.f1278a.i();
    }
}
