package com.baidu.tieba.frs;

import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.NewPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1112a;
    private final /* synthetic */ com.baidu.tieba.data.bh b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FrsActivity frsActivity, com.baidu.tieba.data.bh bhVar) {
        this.f1112a = frsActivity;
        this.b = bhVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        boolean z;
        bb bbVar;
        switch (i) {
            case 0:
                str = this.f1112a.j;
                if (str != null) {
                    FrsActivity frsActivity = this.f1112a;
                    com.baidu.tieba.data.bh bhVar = this.b;
                    z = this.f1112a.k;
                    NewPbActivity.a(frsActivity, bhVar, null, 18003, true, false, z);
                    break;
                }
                break;
            case 1:
                this.f1112a.c(this.b);
                break;
            case 2:
                this.f1112a.d(this.b);
                break;
        }
        com.baidu.tieba.util.ag av = TiebaApplication.g().av();
        if (av != null && !av.b(this.b.a())) {
            av.a(this.b.a());
        }
        bbVar = this.f1112a.l;
        bbVar.m();
    }
}
