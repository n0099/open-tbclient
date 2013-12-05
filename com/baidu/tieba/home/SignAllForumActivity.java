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
public class SignAllForumActivity extends com.baidu.tieba.j implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    private bs f1439a;
    private v b;
    private AlertDialog c;
    private bm d;
    private boolean e;
    private boolean f;
    private x g = new bc(this);
    private bn h = new bd(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.e) {
            t h = this.f1439a.h();
            Intent intent = new Intent(this, SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 134217728);
            str = String.format(getString(R.string.signallforum_back_finish), 0, Integer.valueOf(h.m().size()));
            a(str, activity, 16);
            if (this.f) {
                return;
            }
        }
        showToast(str);
        this.f1439a.f().a();
        t h2 = this.f1439a.h();
        ArrayList<u> m = h2.m();
        int size = m.size();
        for (int i = 0; i < size; i++) {
            u uVar = m.get(i);
            uVar.b(true);
            uVar.c(false);
            uVar.a(false);
        }
        int size2 = h2.j().size();
        int size3 = h2.l().size();
        this.f1439a.j().setText(String.format(getString(R.string.signallforum_res), Integer.valueOf(size3), Integer.valueOf(size2 - size3)));
        this.f1439a.i().notifyDataSetChanged();
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

    private void a() {
        ((NotificationManager) getSystemService("notification")).cancel(R.drawable.singnallforum_progress);
    }

    public static void a(Context context) {
        Intent intent = new Intent(context, SignAllForumActivity.class);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
        c();
        a();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            com.baidu.tieba.ap.a(this, "signall_noyify_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TiebaApplication.h().k() > 0 && this.f1439a != null && this.f1439a.h() != null && this.f1439a.h().j() != null) {
            t h = this.f1439a.h();
            TiebaApplication h2 = TiebaApplication.h();
            ArrayList<u> m = h.m();
            ArrayList<u> l = h.l();
            Iterator<u> it = m.iterator();
            while (it.hasNext()) {
                u next = it.next();
                String b = next.b();
                if (h2.b(b)) {
                    int c = h2.c(b);
                    next.a(1);
                    next.a(true);
                    next.d(c);
                    next.b(false);
                    next.c(false);
                    it.remove();
                    l.add(next);
                }
            }
        }
        this.f1439a.i().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f1439a.i().b();
    }

    private void b() {
        this.f1439a = new bs(this);
        this.f1439a.a((com.baidu.adp.widget.ListView.b) this);
        this.f1439a.a((AdapterView.OnItemClickListener) this);
        e();
    }

    private void c() {
        this.b = new v();
        this.b.a(this.g);
        this.d = bm.a();
        this.d.a(this.h);
        if (this.d.f1477a) {
            this.g.a(this.d.b());
            this.f1439a.f().setSigning(90);
            return;
        }
        this.f1439a.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.f1439a.a(i);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            showToast(R.string.neterror);
            this.f1439a.e();
            return;
        }
        this.b.LoadData();
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        t h = this.f1439a.h();
        if (view == this.f1439a.g()) {
            if (this.f1439a.f().getCurrentStatus() == 2) {
                showToast(R.string.signallforum_finished);
                return;
            }
            if (h.g() != 0) {
                this.c.setMessage(h.h());
                if (!this.c.isShowing()) {
                    this.c.show();
                }
            } else {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    d();
                } else {
                    showToast(R.string.neterror);
                }
            }
            com.baidu.tieba.ap.a(this, "signall_click");
        }
    }

    private void d() {
        t h = this.f1439a.h();
        this.f1439a.f().setDuration(Math.max(h.m().size() * 50, 2000));
        this.f1439a.f().setSigning(0);
        this.d.a(h);
        this.d.LoadData();
        this.f1439a.i().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.a.a, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        u uVar;
        if (this.f1439a.i().getItemViewType(i) == 0 && (uVar = this.f1439a.h().j().get(i / 2)) != null) {
            FrsActivity.a(this, uVar.b(), "signallforum");
            com.baidu.tieba.ap.a(this, "signall_frs_click");
        }
    }

    private void e() {
        this.c = new AlertDialog.Builder(this).setPositiveButton(R.string.signallforum_signnow, new be(this)).create();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.d != null && this.d.f1477a) {
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f = true;
        if (this.b != null) {
            this.b.cancelLoadData();
            this.b = null;
        }
        if (this.f1439a != null && this.f1439a.i() != null) {
            this.f1439a.i().a();
        }
        if (this.d != null && this.d.f1477a) {
            f();
        } else if (this.b != null) {
            this.b.cancelLoadData();
            this.b = null;
        }
    }

    private void f() {
        this.e = true;
        Intent intent = new Intent(this, SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getString(R.string.signallforum_back_signing), PendingIntent.getActivity(this, 0, intent, 134217728), 2);
    }
}
