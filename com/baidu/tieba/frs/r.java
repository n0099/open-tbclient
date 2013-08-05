package com.baidu.tieba.frs;

import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.bm;
import com.baidu.tieba.pb.NewPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1094a;
    private final /* synthetic */ bm b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsActivity frsActivity, bm bmVar) {
        this.f1094a = frsActivity;
        this.b = bmVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        boolean z;
        az azVar;
        switch (i) {
            case 0:
                str = this.f1094a.j;
                if (str != null) {
                    FrsActivity frsActivity = this.f1094a;
                    bm bmVar = this.b;
                    z = this.f1094a.k;
                    NewPbActivity.a(frsActivity, bmVar, null, 18003, true, false, z);
                    break;
                }
                break;
            case 1:
                this.f1094a.c(this.b);
                break;
            case 2:
                this.f1094a.d(this.b);
                break;
        }
        com.baidu.tieba.util.z aE = TiebaApplication.f().aE();
        if (aE != null && !aE.b(this.b.a())) {
            aE.a(this.b.a());
        }
        azVar = this.f1094a.l;
        azVar.k();
    }
}
