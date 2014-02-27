package com.baidu.tieba.home;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsActivity;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class SignAllForumActivity extends com.baidu.tieba.f implements com.baidu.adp.widget.ListView.b {
    private as a;
    private w b;
    private AlertDialog c;
    private al d;
    private boolean e;
    private boolean f;
    private y g = new ab(this);
    private am h = new ac(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(SignAllForumActivity signAllForumActivity, String str) {
        if (signAllForumActivity.e) {
            u g = signAllForumActivity.a.g();
            Intent intent = new Intent(signAllForumActivity, SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(signAllForumActivity, 0, intent, 134217728);
            str = signAllForumActivity.getString(R.string.signallforum_back_finish, new Object[]{0, Integer.valueOf(g.m().size())});
            signAllForumActivity.a(str, activity, 16);
            if (signAllForumActivity.f) {
                return;
            }
        }
        signAllForumActivity.showToast(str);
        signAllForumActivity.a.e().a();
        u g2 = signAllForumActivity.a.g();
        ArrayList<v> m = g2.m();
        int size = m.size();
        for (int i = 0; i < size; i++) {
            v vVar = m.get(i);
            vVar.b(true);
            vVar.c(false);
            vVar.a(false);
        }
        int size2 = g2.j().size();
        int size3 = g2.l().size();
        signAllForumActivity.a.i().setText(signAllForumActivity.getString(R.string.signallforum_res, new Object[]{Integer.valueOf(size3), Integer.valueOf(size2 - size3)}));
        signAllForumActivity.a.h().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, int i) {
        Notification notification = new Notification(R.drawable.icon, str, System.currentTimeMillis());
        String string = getString(R.string.app_name);
        notification.icon = R.drawable.icon;
        notification.setLatestEventInfo(this, string, str, pendingIntent);
        notification.flags = i;
        ((NotificationManager) getSystemService("notification")).notify(R.drawable.singnallforum_progress, notification);
    }

    public static void a(Context context) {
        Intent intent = new Intent(context, SignAllForumActivity.class);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new as(this);
        this.a.a((com.baidu.adp.widget.ListView.b) this);
        this.a.a((AdapterView.OnItemClickListener) this);
        this.c = new AlertDialog.Builder(this).setPositiveButton(R.string.signallforum_signnow, new ad(this)).create();
        this.b = new w();
        this.b.a(this.g);
        this.d = al.a();
        this.d.a(this.h);
        if (this.d.a) {
            this.g.a(this.d.b());
            this.a.e().setSigning(90);
        } else {
            this.a.a();
        }
        ((NotificationManager) getSystemService("notification")).cancel(R.drawable.singnallforum_progress);
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            com.baidu.tieba.ai.a(this, "signall_noyify_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TiebaApplication.g().i() > 0 && this.a != null && this.a.g() != null && this.a.g().j() != null) {
            u g = this.a.g();
            TiebaApplication g2 = TiebaApplication.g();
            ArrayList<v> m = g.m();
            ArrayList<v> l = g.l();
            Iterator<v> it = m.iterator();
            while (it.hasNext()) {
                v next = it.next();
                String b = next.b();
                if (g2.a(b)) {
                    int b2 = g2.b(b);
                    next.a(1);
                    next.a(true);
                    next.d(b2);
                    next.b(false);
                    next.c(false);
                    it.remove();
                    l.add(next);
                }
            }
        }
        this.a.h().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onPause() {
        super.onPause();
        this.a.h().b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.a.a(i);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public final void a(boolean z) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            showToast(R.string.neterror);
            this.a.d();
            return;
        }
        this.b.LoadData();
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        u g = this.a.g();
        if (view == this.a.f()) {
            if (this.a.e().getCurrentStatus() == 2) {
                showToast(R.string.signallforum_finished);
                return;
            }
            if (g.g() != 0) {
                this.c.setMessage(g.h());
                if (!this.c.isShowing()) {
                    this.c.show();
                }
            } else {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    u g2 = this.a.g();
                    this.a.e().setDuration(Math.max(g2.m().size() * 50, 2000));
                    this.a.e().setSigning(0);
                    this.d.a(g2);
                    this.d.LoadData();
                    this.a.h().notifyDataSetChanged();
                } else {
                    showToast(R.string.neterror);
                }
            }
            com.baidu.tieba.ai.a(this, "signall_click");
        }
    }

    @Override // com.baidu.adp.a.a, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        v vVar;
        if (this.a.h().getItemViewType(i) == 0 && (vVar = this.a.g().j().get(i / 2)) != null) {
            FrsActivity.a(this, vVar.b(), "signallforum");
            com.baidu.tieba.ai.a(this, "signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.d != null && this.d.a) {
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f = true;
        if (this.b != null) {
            this.b.cancelLoadData();
            this.b = null;
        }
        if (this.a != null && this.a.h() != null) {
            this.a.h().a();
        }
        if (this.d != null && this.d.a) {
            a();
        } else if (this.b != null) {
            this.b.cancelLoadData();
            this.b = null;
        }
    }

    private void a() {
        this.e = true;
        Intent intent = new Intent(this, SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getString(R.string.signallforum_back_signing), PendingIntent.getActivity(this, 0, intent, 134217728), 2);
    }
}
