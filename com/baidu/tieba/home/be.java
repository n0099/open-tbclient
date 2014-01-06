package com.baidu.tieba.home;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class be implements bo {
    final /* synthetic */ SignAllForumActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(SignAllForumActivity signAllForumActivity) {
        this.a = signAllForumActivity;
    }

    @Override // com.baidu.tieba.home.bo
    public void a(String str) {
        this.a.a(str);
    }

    @Override // com.baidu.tieba.home.bo
    public void a(bl blVar) {
        bu buVar;
        boolean z;
        bu buVar2;
        bu buVar3;
        bu buVar4;
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        AlertDialog alertDialog3;
        boolean z2;
        n c = blVar.c();
        if (c == null || c.a() != 0) {
            this.a.a(c.b());
            return;
        }
        buVar = this.a.a;
        u h = buVar.h();
        h.a(blVar);
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
        buVar2 = this.a.a;
        buVar2.i().notifyDataSetChanged();
        buVar3 = this.a.a;
        buVar3.j().setText(String.format(this.a.getString(R.string.signallforum_res), Integer.valueOf(size2), Integer.valueOf(size - size2)));
        buVar4 = this.a.a;
        bq f = buVar4.f();
        if (size != size2) {
            if (blVar.a() != 0) {
                alertDialog = this.a.c;
                alertDialog.setMessage(blVar.b());
                alertDialog2 = this.a.c;
                if (!alertDialog2.isShowing()) {
                    alertDialog3 = this.a.c;
                    alertDialog3.show();
                }
            } else if (blVar.e() != 0) {
                com.baidu.adp.lib.h.g.a((Context) this.a, blVar.f());
            } else {
                this.a.showToast(R.string.signallforum_error);
            }
        }
        f.a();
    }
}
