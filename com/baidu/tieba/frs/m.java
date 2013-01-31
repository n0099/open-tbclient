package com.baidu.tieba.frs;

import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.av;
import com.baidu.tieba.pb.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsActivity a;
    private final /* synthetic */ av b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity, av avVar) {
        this.a = frsActivity;
        this.b = avVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        String str2;
        aa aaVar;
        aa aaVar2;
        switch (i) {
            case 0:
                str = this.a.o;
                if (str != null) {
                    FrsActivity frsActivity = this.a;
                    str2 = this.a.o;
                    PbActivity.a(frsActivity, str2, "tb_frslist");
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
        com.baidu.tieba.c.aa al = TiebaApplication.b().al();
        if (al != null && !al.b(this.b.a())) {
            al.a(this.b.a());
        }
        aaVar = this.a.x;
        if (aaVar != null) {
            aaVar2 = this.a.x;
            aaVar2.notifyDataSetChanged();
        }
    }
}
