package com.baidu.tieba.home;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class ac implements am {
    final /* synthetic */ SignAllForumActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(SignAllForumActivity signAllForumActivity) {
        this.a = signAllForumActivity;
    }

    @Override // com.baidu.tieba.home.am
    public final void a(String str) {
        SignAllForumActivity.a(this.a, str);
    }

    @Override // com.baidu.tieba.home.am
    public final void a(aj ajVar) {
        as asVar;
        boolean z;
        as asVar2;
        as asVar3;
        as asVar4;
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        AlertDialog alertDialog3;
        boolean z2;
        q c = ajVar.c();
        if (c != null && c.a() == 0) {
            asVar = this.a.a;
            u g = asVar.g();
            g.a(ajVar);
            int size = g.j().size();
            int size2 = g.l().size();
            z = this.a.e;
            if (z) {
                Intent intent = new Intent(this.a, SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                this.a.a(this.a.getString(R.string.signallforum_back_finish, new Object[]{Integer.valueOf(size2), Integer.valueOf(size - size2)}), PendingIntent.getActivity(this.a, 0, intent, 134217728), 16);
                z2 = this.a.f;
                if (z2) {
                    return;
                }
            }
            asVar2 = this.a.a;
            asVar2.h().notifyDataSetChanged();
            asVar3 = this.a.a;
            asVar3.i().setText(this.a.getString(R.string.signallforum_res, new Object[]{Integer.valueOf(size2), Integer.valueOf(size - size2)}));
            asVar4 = this.a.a;
            ao e = asVar4.e();
            if (size != size2) {
                if (ajVar.a() != 0) {
                    alertDialog = this.a.c;
                    alertDialog.setMessage(ajVar.b());
                    alertDialog2 = this.a.c;
                    if (!alertDialog2.isShowing()) {
                        alertDialog3 = this.a.c;
                        alertDialog3.show();
                    }
                } else if (ajVar.e() != 0) {
                    BdUtilHelper.a((Context) this.a, ajVar.f());
                } else {
                    this.a.showToast(R.string.signallforum_error);
                }
            }
            e.a();
            return;
        }
        SignAllForumActivity.a(this.a, c.b());
    }
}
