package com.baidu.tieba.frs;

import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.NewPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f870a;
    private final /* synthetic */ com.baidu.tieba.data.ba b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsActivity frsActivity, com.baidu.tieba.data.ba baVar) {
        this.f870a = frsActivity;
        this.b = baVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        boolean z;
        az azVar;
        switch (i) {
            case 0:
                str = this.f870a.j;
                if (str != null) {
                    FrsActivity frsActivity = this.f870a;
                    com.baidu.tieba.data.ba baVar = this.b;
                    z = this.f870a.k;
                    NewPbActivity.a(frsActivity, baVar, null, 1800003, true, false, z);
                    break;
                }
                break;
            case 1:
                this.f870a.c(this.b);
                break;
            case 2:
                this.f870a.d(this.b);
                break;
        }
        com.baidu.tieba.util.w aA = TiebaApplication.f().aA();
        if (aA != null && !aA.b(this.b.a())) {
            aA.a(this.b.a());
        }
        azVar = this.f870a.l;
        azVar.k();
    }
}
