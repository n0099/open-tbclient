package com.baidu.tieba.frs;

import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.NewPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1160a;
    private final /* synthetic */ com.baidu.tieba.data.bh b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FrsActivity frsActivity, com.baidu.tieba.data.bh bhVar) {
        this.f1160a = frsActivity;
        this.b = bhVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        boolean z;
        ba baVar;
        switch (i) {
            case 0:
                str = this.f1160a.m;
                if (str != null) {
                    FrsActivity frsActivity = this.f1160a;
                    com.baidu.tieba.data.bh bhVar = this.b;
                    z = this.f1160a.n;
                    NewPbActivity.a(frsActivity, bhVar, null, 18003, true, false, z);
                    break;
                }
                break;
            case 1:
                this.f1160a.c(this.b);
                break;
            case 2:
                this.f1160a.d(this.b);
                break;
        }
        com.baidu.tieba.util.ak aw = TiebaApplication.g().aw();
        if (aw != null && !aw.b(this.b.a())) {
            aw.a(this.b.a());
        }
        baVar = this.f1160a.o;
        baVar.k();
    }
}
