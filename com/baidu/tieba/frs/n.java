package com.baidu.tieba.frs;

import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.as;
import com.baidu.tieba.pb.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsActivity a;
    private final /* synthetic */ as b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity, as asVar) {
        this.a = frsActivity;
        this.b = asVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        String str2;
        ab abVar;
        ab abVar2;
        switch (i) {
            case 0:
                str = this.a.n;
                if (str != null) {
                    FrsActivity frsActivity = this.a;
                    str2 = this.a.n;
                    PbActivity.a(frsActivity, str2, "tb_frslist");
                    break;
                }
                break;
            case 1:
                this.a.c(this.b);
                break;
            case 2:
                this.a.r();
                break;
        }
        com.baidu.tieba.c.aa ai = TiebaApplication.a().ai();
        if (ai != null && !ai.b(this.b.a())) {
            ai.a(this.b.a());
        }
        abVar = this.a.w;
        if (abVar != null) {
            abVar2 = this.a.w;
            abVar2.notifyDataSetChanged();
        }
    }
}
