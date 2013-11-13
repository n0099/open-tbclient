package com.baidu.tieba.home;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class bi implements bs {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SignAllForumActivity f1427a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(SignAllForumActivity signAllForumActivity) {
        this.f1427a = signAllForumActivity;
    }

    @Override // com.baidu.tieba.home.bs
    public void a(String str) {
        this.f1427a.a(str);
    }

    @Override // com.baidu.tieba.home.bs
    public void a(bp bpVar) {
        bx bxVar;
        boolean z;
        bx bxVar2;
        bx bxVar3;
        bx bxVar4;
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        AlertDialog alertDialog3;
        boolean z2;
        r c = bpVar.c();
        if (c == null || c.a() != 0) {
            this.f1427a.a(c.b());
            return;
        }
        bxVar = this.f1427a.f1394a;
        y h = bxVar.h();
        h.a(bpVar);
        int size = h.j().size();
        int size2 = h.l().size();
        z = this.f1427a.e;
        if (z) {
            Intent intent = new Intent(this.f1427a, SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            this.f1427a.a(String.format(this.f1427a.getString(R.string.signallforum_back_finish), Integer.valueOf(size2), Integer.valueOf(size - size2)), PendingIntent.getActivity(this.f1427a, 0, intent, 134217728), 16);
            z2 = this.f1427a.f;
            if (z2) {
                return;
            }
        }
        bxVar2 = this.f1427a.f1394a;
        bxVar2.i().notifyDataSetChanged();
        bxVar3 = this.f1427a.f1394a;
        bxVar3.j().setText(String.format(this.f1427a.getString(R.string.signallforum_res), Integer.valueOf(size2), Integer.valueOf(size - size2)));
        bxVar4 = this.f1427a.f1394a;
        bu f = bxVar4.f();
        if (size != size2) {
            if (bpVar.a() != 0) {
                alertDialog = this.f1427a.c;
                alertDialog.setMessage(bpVar.b());
                alertDialog2 = this.f1427a.c;
                if (!alertDialog2.isShowing()) {
                    alertDialog3 = this.f1427a.c;
                    alertDialog3.show();
                }
            } else if (bpVar.e() != 0) {
                UtilHelper.a((Context) this.f1427a, bpVar.f());
            } else {
                this.f1427a.showToast(R.string.signallforum_error);
            }
        }
        f.a();
    }
}
