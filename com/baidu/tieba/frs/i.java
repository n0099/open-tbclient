package com.baidu.tieba.frs;

import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.NewPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.data.az f1409a;
    final /* synthetic */ FrsActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsActivity frsActivity, com.baidu.tieba.data.az azVar) {
        this.b = frsActivity;
        this.f1409a = azVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        String str2;
        boolean z;
        bn bnVar;
        switch (i) {
            case 0:
                str = this.b.l;
                if (str != null) {
                    FrsActivity frsActivity = this.b;
                    com.baidu.tieba.data.az azVar = this.f1409a;
                    str2 = this.b.f;
                    z = this.b.m;
                    NewPbActivity.a(frsActivity, azVar, str2, null, 18003, true, false, z);
                    break;
                }
                break;
            case 1:
                this.b.c(this.f1409a);
                break;
            case 2:
                this.b.d(this.f1409a);
                break;
        }
        com.baidu.tieba.util.az aw = TiebaApplication.h().aw();
        if (aw != null && !aw.b(this.f1409a.a())) {
            aw.a(this.f1409a.a());
        }
        bnVar = this.b.n;
        bnVar.q();
    }
}
