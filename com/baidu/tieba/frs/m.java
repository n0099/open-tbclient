package com.baidu.tieba.frs;

import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.at;
import com.baidu.tieba.pb.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsActivity a;
    private final /* synthetic */ at b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity, at atVar) {
        this.a = frsActivity;
        this.b = atVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        String str2;
        boolean z;
        aa aaVar;
        aa aaVar2;
        switch (i) {
            case 0:
                str = this.a.o;
                if (str != null) {
                    FrsActivity frsActivity = this.a;
                    str2 = this.a.o;
                    z = this.a.p;
                    PbActivity.a(frsActivity, str2, "tb_frslist", z);
                    break;
                }
                break;
            case 1:
                this.a.c(this.b);
                break;
            case 2:
                this.a.s();
                break;
        }
        com.baidu.tieba.c.ab am = TiebaApplication.b().am();
        if (am != null && !am.b(this.b.a())) {
            am.a(this.b.a());
        }
        aaVar = this.a.y;
        if (aaVar != null) {
            aaVar2 = this.a.y;
            aaVar2.notifyDataSetChanged();
        }
    }
}
