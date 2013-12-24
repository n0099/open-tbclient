package com.baidu.tieba.home;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class bd implements bn {
    final /* synthetic */ SignAllForumActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(SignAllForumActivity signAllForumActivity) {
        this.a = signAllForumActivity;
    }

    @Override // com.baidu.tieba.home.bn
    public void a(String str) {
        this.a.a(str);
    }

    @Override // com.baidu.tieba.home.bn
    public void a(bk bkVar) {
        bs bsVar;
        boolean z;
        bs bsVar2;
        bs bsVar3;
        bs bsVar4;
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        AlertDialog alertDialog3;
        boolean z2;
        m c = bkVar.c();
        if (c == null || c.a() != 0) {
            this.a.a(c.b());
            return;
        }
        bsVar = this.a.a;
        t h = bsVar.h();
        h.a(bkVar);
        int size = h.j().size();
        int size2 = h.l().size();
        z = this.a.e;
        if (z) {
            Intent intent = new Intent(this.a, SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            this.a.a(String.format(this.a.getString(R.string.signallforum_back_finish), Integer.valueOf(size2), Integer.valueOf(size - size2)), PendingIntent.getActivity(this.a, 0, intent, 134217728), 16);
            z2 = this.a.f;
            if (z2) {
                return;
            }
        }
        bsVar2 = this.a.a;
        bsVar2.i().notifyDataSetChanged();
        bsVar3 = this.a.a;
        bsVar3.j().setText(String.format(this.a.getString(R.string.signallforum_res), Integer.valueOf(size2), Integer.valueOf(size - size2)));
        bsVar4 = this.a.a;
        bp f = bsVar4.f();
        if (size != size2) {
            if (bkVar.a() != 0) {
                alertDialog = this.a.c;
                alertDialog.setMessage(bkVar.b());
                alertDialog2 = this.a.c;
                if (!alertDialog2.isShowing()) {
                    alertDialog3 = this.a.c;
                    alertDialog3.show();
                }
            } else if (bkVar.e() != 0) {
                com.baidu.adp.lib.h.g.a((Context) this.a, bkVar.f());
            } else {
                this.a.showToast(R.string.signallforum_error);
            }
        }
        f.a();
    }
}
