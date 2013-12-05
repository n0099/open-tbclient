package com.baidu.tieba.home;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class bd implements bn {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SignAllForumActivity f1468a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(SignAllForumActivity signAllForumActivity) {
        this.f1468a = signAllForumActivity;
    }

    @Override // com.baidu.tieba.home.bn
    public void a(String str) {
        this.f1468a.a(str);
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
            this.f1468a.a(c.b());
            return;
        }
        bsVar = this.f1468a.f1439a;
        t h = bsVar.h();
        h.a(bkVar);
        int size = h.j().size();
        int size2 = h.l().size();
        z = this.f1468a.e;
        if (z) {
            Intent intent = new Intent(this.f1468a, SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            this.f1468a.a(String.format(this.f1468a.getString(R.string.signallforum_back_finish), Integer.valueOf(size2), Integer.valueOf(size - size2)), PendingIntent.getActivity(this.f1468a, 0, intent, 134217728), 16);
            z2 = this.f1468a.f;
            if (z2) {
                return;
            }
        }
        bsVar2 = this.f1468a.f1439a;
        bsVar2.i().notifyDataSetChanged();
        bsVar3 = this.f1468a.f1439a;
        bsVar3.j().setText(String.format(this.f1468a.getString(R.string.signallforum_res), Integer.valueOf(size2), Integer.valueOf(size - size2)));
        bsVar4 = this.f1468a.f1439a;
        bp f = bsVar4.f();
        if (size != size2) {
            if (bkVar.a() != 0) {
                alertDialog = this.f1468a.c;
                alertDialog.setMessage(bkVar.b());
                alertDialog2 = this.f1468a.c;
                if (!alertDialog2.isShowing()) {
                    alertDialog3 = this.f1468a.c;
                    alertDialog3.show();
                }
            } else if (bkVar.e() != 0) {
                com.baidu.adp.lib.h.g.a((Context) this.f1468a, bkVar.f());
            } else {
                this.f1468a.showToast(R.string.signallforum_error);
            }
        }
        f.a();
    }
}
