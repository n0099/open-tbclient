package com.baidu.tieba.frs;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.home.CreateBarActivity;
import com.baidu.tieba.model.bn;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.write.WriteActivity;
import com.baidu.tieba.write.WriteImageActivity;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class FrsActivity extends com.baidu.tieba.g implements com.baidu.adp.widget.BdSwitchView.c {
    private static volatile long q = 0;
    private static volatile long r = 0;
    private static volatile int s = 0;
    private com.baidu.tieba.model.aa C;
    private com.baidu.tieba.model.m D;
    private boolean b = true;
    private int c = 3;
    private String d = null;
    private String e = null;
    private int f = 0;
    private int g = 1;
    private boolean j = false;
    private String k = null;
    private boolean l = false;
    private az m = null;
    private String n = null;
    private String o = null;
    private com.baidu.tieba.data.ba p = null;
    private long t = 0;
    private boolean u = false;
    private boolean v = true;
    public com.baidu.tieba.model.v a = null;
    private com.baidu.tieba.model.aj w = null;
    private bn x = null;
    private Handler y = null;
    private long z = 0;
    private String A = "normal_page";
    private BroadcastReceiver B = null;
    private boolean E = false;
    private com.baidu.tieba.data.ba F = null;
    private ac G = new a(this);
    private ab H = new m(this);
    private Handler I = null;
    private com.baidu.tieba.util.a J = null;
    private Runnable K = new s(this);
    private com.baidu.adp.widget.ListView.r L = new u(this);
    private com.baidu.adp.widget.ListView.s M = new v(this);
    private AdapterView.OnItemClickListener N = new w(this);
    private AdapterView.OnItemLongClickListener O = new y(this);
    private com.baidu.adp.widget.ListView.b P = new z(this);
    private View.OnClickListener Q = new aa(this);
    private AbsListView.OnScrollListener R = new b(this);
    private View.OnClickListener S = new c(this);
    private SlidingMenu.OnClosedListener T = new e(this);
    private SlidingMenu.OnOpenedListener U = new f(this);
    private AdapterView.OnItemClickListener V = new g(this);

    @Override // com.baidu.tieba.g
    public boolean e() {
        return TiebaApplication.f().v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.y yVar) {
        if (this.b) {
            if (yVar != null) {
                if (yVar.a && yVar.b) {
                    if (yVar.c == 3) {
                        this.j = false;
                        this.d = this.d.replace(" ", "");
                        String str = this.d;
                        if (str.length() > 31) {
                            str = String.valueOf(str.substring(0, 31)) + "...";
                        }
                        this.m.b(str);
                        return;
                    }
                    this.m.a(yVar.d);
                    return;
                }
                this.m.a(yVar.d);
            }
        } else if (yVar != null) {
            this.m.a(yVar.d);
        }
    }

    public static void a(Context context, String str, String str2) {
        if (TiebaApplication.f().d(str)) {
            FrsImageActivity.a(context, str, str2, 0);
        } else {
            a(context, str, str2, false, false);
        }
    }

    public static void b(Context context, String str, String str2) {
        if (TiebaApplication.f().d(str)) {
            FrsImageActivity.a(context, str, str2, 0);
        } else {
            a(context, str, str2, false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        com.baidu.tieba.data.ba b = this.m.h().b();
        if (b != null) {
            ArrayList m = b.m();
            int size = m.size();
            for (int i = 0; i < size; i++) {
                if (((com.baidu.tieba.data.ae) m.get(i)).a() == 3) {
                    this.m.h().a().a(((com.baidu.tieba.data.ae) m.get(i)).b(), new h(this));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        com.baidu.tieba.data.ba b = this.m.i().b();
        if (b != null) {
            ArrayList m = b.m();
            int size = m.size();
            for (int i = 0; i < size; i++) {
                if (((com.baidu.tieba.data.ae) m.get(i)).a() == 3) {
                    this.m.i().a().a(((com.baidu.tieba.data.ae) m.get(i)).b(), new i(this));
                }
            }
        }
    }

    public static void a(Context context, String str, String str2, boolean z, boolean z2) {
        Intent intent = new Intent(context, FrsActivity.class);
        if (str != null && str.length() > 0) {
            intent.putExtra("name", str);
            intent.putExtra("from", str2);
            intent.putExtra("back_special", z);
            intent.putExtra("good", z2);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    public static void a(Context context, String str, String str2, int i) {
        if (TiebaApplication.f().d(str)) {
            FrsImageActivity.a(context, str, str2, i);
            return;
        }
        Intent intent = new Intent(context, FrsActivity.class);
        if (str != null && str.length() > 0) {
            intent.putExtra("name", str);
            intent.putExtra("from", str2);
            intent.putExtra("flag", i);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    public static Intent a(Context context, String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        Intent intent = new Intent(context, LogoActivity.class);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        intent.setFlags(603979776);
        intent.putExtra("fname", str);
        intent.putExtra("from_short_cut", true);
        intent.putExtra("back_special", true);
        intent.putExtra("from", "short_cut");
        return intent;
    }

    private void p() {
        int i = BdWebErrorView.ERROR_CODE_400;
        this.J = new com.baidu.tieba.util.a(this);
        this.J.b(true);
        int a = com.baidu.tieba.util.aa.a(this, 267.0f);
        if (a <= 400) {
            i = a;
        }
        this.J.a(i, (int) (i * 1.62f));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (t()) {
            u();
            a(bundle);
            y();
        }
    }

    private void a(Bundle bundle) {
        this.I = new Handler();
        p();
        this.o = TiebaApplication.D();
        if (bundle != null) {
            this.d = bundle.getString("name");
            this.e = bundle.getString("from");
            this.f = bundle.getInt("flag", 0);
        } else {
            Intent intent = getIntent();
            this.d = intent.getStringExtra("name");
            this.e = intent.getStringExtra("from");
            this.f = intent.getIntExtra("flag", 0);
            this.u = intent.getBooleanExtra("good", false);
        }
        if (this.d != null && this.d.length() > 0) {
            if (this.e == null || this.e.length() <= 0) {
                this.e = "tb_forumlist";
            }
            this.n = this.e;
            this.E = false;
            this.y = new j(this);
            this.w = new com.baidu.tieba.model.aj();
            this.w.setLoadDataCallBack(new k(this));
            this.x = new bn();
            this.x.setLoadDataCallBack(new l(this));
            this.C = new com.baidu.tieba.model.aa(this);
            this.D = new com.baidu.tieba.model.m();
            this.D.setLoadDataCallBack(new n(this));
            String D = TiebaApplication.D();
            if (D != null && D.length() > 0) {
                q();
                s();
                this.D.a(false, true, true);
            }
        }
    }

    private void q() {
        this.C.a(TiebaApplication.f().ae());
        this.C.c(TiebaApplication.f().ac());
        this.C.b(TiebaApplication.f().ad());
        this.C.d(TiebaApplication.f().af());
        this.m.a(this.C);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        this.m.a().a(this.D.a());
    }

    private void s() {
        if (this.B == null) {
            this.B = new o(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(com.baidu.tieba.data.g.k);
            registerReceiver(this.B, intentFilter);
        }
    }

    private boolean t() {
        if (getIntent().getBooleanExtra("from_short_cut", false)) {
            Iterator<ActivityManager.RunningTaskInfo> it = ((ActivityManager) getSystemService("activity")).getRunningTasks(10).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningTaskInfo next = it.next();
                if (next.topActivity.getClassName().equals(getClass().getName())) {
                    if (next.numActivities <= 1) {
                        Intent intent = new Intent();
                        intent.putExtra("class", 2);
                        intent.putExtra("fname", getIntent().getStringExtra("name"));
                        intent.putExtra("from", "short_cut");
                        LogoActivity.a(this, intent);
                        finish();
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        if (this.B != null) {
            unregisterReceiver(this.B);
        }
        if (this.I != null) {
            this.I.removeCallbacks(this.K);
        }
        if (this.y != null) {
            this.y.removeMessages(1);
        }
        super.onDestroy();
        try {
            if (this.a != null) {
                this.a.g();
            }
            if (this.w != null) {
                this.w.a();
            }
            if (this.x != null) {
                this.x.a();
            }
            if (this.D != null) {
                this.D.cancelLoadData();
            }
            this.m.u();
            System.gc();
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "onDestroy", e.getMessage());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.d);
        bundle.putString("from", this.e);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        boolean z = true;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1100001:
                    d(0);
                    return;
                case 1100002:
                    n();
                    return;
                case 1100011:
                    c(this.p);
                    return;
                case 1100012:
                    d(this.F);
                    return;
                case 1100013:
                    x();
                    return;
                case 1100014:
                    o();
                    return;
                case 1100016:
                    this.m.r();
                    return;
                case 1100021:
                    if (this.a != null) {
                        m();
                        return;
                    }
                    return;
                case 1200001:
                    if (this.a != null && this.a.a() != null) {
                        WriteImageActivity.a(this, 1200001, 1200010, null, this.a.a().a(), this.d, this.a.c());
                        return;
                    }
                    return;
                case 1200002:
                    if (this.a != null && this.a.a() != null && intent != null && intent.getData() != null) {
                        WriteImageActivity.a(this, 1200002, 1200009, intent.getData(), this.a.a().a(), this.d, this.a.c());
                        return;
                    }
                    return;
                case 1200009:
                case 1200010:
                    if (this.a != null && this.a.a() != null) {
                        if (intent == null || intent.getStringExtra("filename") == null) {
                            WriteActivity.a((Activity) this, this.a.a().a(), this.d, (AntiData) null, true, (String) null);
                            return;
                        } else {
                            WriteActivity.a((Activity) this, this.a.a().a(), this.d, (AntiData) null, true, intent.getStringExtra("filename"));
                            return;
                        }
                    }
                    return;
                case 1300003:
                    y();
                    return;
                case 1800003:
                    this.m.g().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null) {
                        int size = this.a.b().size();
                        int i3 = 0;
                        while (true) {
                            if (i3 >= size) {
                                z = false;
                            } else if (!stringExtra.equals(((com.baidu.tieba.data.ba) this.a.b().get(i3)).a())) {
                                i3++;
                            }
                        }
                        if (z) {
                            int intExtra = intent.getIntExtra("type", 0);
                            if (intExtra == 2) {
                                ((com.baidu.tieba.data.ba) this.a.b().get(i3)).b(intent.getIntExtra("good_data", 0));
                                ((com.baidu.tieba.data.ba) this.a.b().get(i3)).a(intent.getIntExtra("top_data", 0));
                                ((com.baidu.tieba.data.ba) this.a.b().get(i3)).o();
                            } else if (intExtra == 0) {
                                this.a.b().remove(i3);
                            }
                            this.m.s();
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 1200009:
                    com.baidu.tieba.write.bb.b(this);
                    return;
                case 1200010:
                    com.baidu.tieba.write.bb.a(this);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        super.onResume();
        String D = TiebaApplication.D();
        if (this.o == null && D != null && D.length() > 0) {
            this.o = D;
            if (this.a != null && this.a.c() != null) {
                this.a.c().setIfpost(1);
            }
        }
        if (D != null && D.length() > 0) {
            this.m.a().a(true);
        } else {
            this.m.a().a(false);
        }
        this.K.run();
        if (this.y != null) {
            this.y.removeMessages(1);
            this.y.sendMessageDelayed(this.y.obtainMessage(1), 1000L);
        }
    }

    @Override // com.baidu.tieba.g
    public void f() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
            return;
        }
        String D = TiebaApplication.D();
        if ((D != null && D.length() > 0) || TiebaApplication.f().at() >= 3) {
            MainTabActivity.a(this, "goto_home");
        } else {
            MainTabActivity.a(this, "goto_recommend");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        this.m.u();
        finish();
        CompatibleUtile.setAnim(this, R.anim.frs_browser_enter, R.anim.no_effect);
    }

    private void u() {
        this.b = true;
        this.d = "";
        this.e = "";
        this.f = 0;
        this.g = 1;
        this.u = false;
        this.t = 0L;
        this.c = 3;
        this.m = new az(this, this.Q);
        this.m.a().b();
        this.m.a(this.L);
        this.m.a(this.M);
        this.m.a(this.S);
        this.m.a(this.N);
        this.m.a(this.O);
        this.m.a(this.R);
        this.m.a(this.P);
        this.m.a(this.T);
        this.m.a(this.U);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        this.m.j(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        this.m.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.adp.widget.a.b bVar, boolean z) {
        if (bVar != null) {
            this.m.a(bVar, z);
            this.m.w().setOnDismissListener(new p(this));
            this.m.w().setOnCancelListener(new q(this));
            a(0.3f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (this.J != null) {
            this.J.b();
        }
        a(1.0f);
        this.m.x();
    }

    private void a(float f) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = f;
        getWindow().setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        String D = TiebaApplication.D();
        if (D == null || D.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100013);
            return;
        }
        CreateBarActivity.a(this, this.d, true);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        Intent a;
        if (str != null && (a = a((Context) this, str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + getString(R.string.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", a);
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this, R.drawable.icon));
            sendBroadcast(intent);
            new com.baidu.tieba.account.af("add_to_launcher").start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        String D = TiebaApplication.D();
        if (D == null || D.length() <= 0) {
            if (this.a != null && this.a.c() != null) {
                this.a.c().setIfpost(1);
            }
            if (i == 0) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100001);
            } else {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100016);
            }
        } else if (this.a != null) {
            if (i == 0) {
                WriteActivity.a((Activity) this, this.a.a().a(), this.d, this.a.c(), false, (String) null);
            } else {
                this.m.r();
            }
        }
    }

    private boolean a(com.baidu.tieba.data.ba baVar) {
        String id;
        return baVar == null || baVar.g() == null || (id = baVar.g().getId()) == null || id.equals("0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.data.ba baVar) {
        boolean a = a(baVar);
        this.m.a(new r(this, baVar));
        this.m.a(baVar, a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.data.ba baVar) {
        boolean a = a(baVar);
        if (this.k != null) {
            if (!a) {
                NewPbActivity.a(this, baVar, null, 1800003, true, true, this.l);
            } else {
                NewPbActivity.a(this, baVar, null, 1800003, false, false, this.l);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.data.ba baVar) {
        if (this.k != null) {
            NewPbActivity.a(this, baVar, null, 1800003, false, false, this.l);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        this.g = 1;
        this.c = 3;
        z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        BasicNameValuePair basicNameValuePair;
        switch (this.c) {
            case 1:
                if (this.m.g().b()) {
                    return;
                }
                break;
            case 2:
                if (this.m.g().c()) {
                    return;
                }
                break;
            case 3:
                if (this.m.f()) {
                    return;
                }
                break;
        }
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append(com.baidu.tieba.data.g.a);
        stringBuffer.append("c/f/frs/page");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("kw", this.d));
        arrayList.add(new BasicNameValuePair("pn", String.valueOf(this.g)));
        if (TiebaApplication.f().aq()) {
            basicNameValuePair = new BasicNameValuePair("rn", String.valueOf(35));
        } else {
            basicNameValuePair = new BasicNameValuePair("rn", String.valueOf(50));
        }
        arrayList.add(basicNameValuePair);
        if (this.u) {
            arrayList.add(new BasicNameValuePair("is_good", "1"));
            arrayList.add(new BasicNameValuePair("cid", String.valueOf(this.t)));
        }
        if (this.n != null) {
            arrayList.add(new BasicNameValuePair("st_type", this.n));
        }
        if (q != 0) {
            arrayList.add(new BasicNameValuePair("ctime", String.valueOf(q)));
        }
        if (r != 0) {
            arrayList.add(new BasicNameValuePair("data_size", String.valueOf(r)));
        }
        if (s != 0) {
            arrayList.add(new BasicNameValuePair("net_error", String.valueOf(s)));
        }
        this.m.b(true);
        this.m.g().c(false);
        this.m.g().d(false);
        this.m.g().notifyDataSetChanged();
        this.a = new com.baidu.tieba.model.v();
        this.a.a(this.G);
        this.a.a(stringBuffer.toString(), arrayList, this.c);
    }

    private void A() {
        switch (this.f) {
            case 1:
                DatabaseService.o(this.d);
                break;
        }
        this.f = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        try {
            if (this.a != null) {
                this.m.j();
                this.d = this.a.a().b();
                this.m.c(this.d);
                A();
                this.b = false;
                ArrayList b = this.a.b();
                if (b != null) {
                    this.m.a(b, this.g);
                    if (this.A == "frs_page") {
                        C();
                    } else if (this.A == "normal_page") {
                        this.m.a(this.a.a());
                    }
                    this.m.b(this.g);
                    this.m.c(this.a.d().f());
                    this.m.s();
                    if (this.c == 1) {
                        this.m.d(3);
                    } else if (this.c == 2) {
                        if (this.g == 1) {
                            this.m.d(0);
                        } else {
                            this.m.d(3);
                        }
                    } else {
                        this.m.d(0);
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "", "HomeActivity.refreshFrs error = " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onPause() {
        super.onPause();
        this.m.t();
        if (this.y != null) {
            this.y.removeMessages(1);
        }
    }

    @Override // com.baidu.tieba.g, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.j) {
            if (i == 4) {
                if (this.m.b().isMenuShowing()) {
                    this.m.b().toggle(true);
                    if (this.E) {
                        this.E = false;
                        y();
                        return true;
                    }
                    return true;
                }
                f();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    private void C() {
        this.m.a(this.a.a(), this.a.e());
        this.y.removeMessages(1);
        if (this.g == 1 && this.A == "frs_page" && this.a.e().h() == 0) {
            this.z = System.nanoTime() / 1000000000;
            if (this.a.e().i() > 0) {
                this.y.sendMessageDelayed(this.y.obtainMessage(1), 1000L);
            }
        }
    }

    public void m() {
        String D = TiebaApplication.D();
        if (D == null || D.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100021);
        } else if (!this.a.f()) {
            this.a.a(true);
            this.a.a(this.H);
            this.a.b(String.valueOf(this.a.a().e()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n() {
        String D = TiebaApplication.D();
        if (D == null || D.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100002);
        } else {
            this.w.a(this.a.a().b(), this.a.a().a());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o() {
        String D = TiebaApplication.D();
        if (D == null || D.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100014);
        } else {
            this.x.a(this.a.a().b(), this.a.a().a());
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.m.a().c()) {
            this.E = true;
            if (switchState == BdSwitchView.SwitchState.ON) {
                if (!TiebaApplication.f().aq() && TiebaApplication.f().s()) {
                    StatService.onEvent(this, "frs_abstract", "frsclick", 1);
                }
                TiebaApplication.f().q(true);
                return;
            }
            if (TiebaApplication.f().aq() && TiebaApplication.f().s()) {
                StatService.onEvent(this, "frs_abstract", "frsclick", 1);
            }
            TiebaApplication.f().q(false);
        } else if (view == this.m.a().d()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                if (TiebaApplication.f().as() != 1) {
                    if (TiebaApplication.f().s()) {
                        StatService.onEvent(this, "frs_night_mode", "frsclick", 1);
                    }
                    TiebaApplication.f().j(1);
                    this.i = 1;
                    new com.baidu.tieba.account.af("eyeshield").start();
                } else {
                    return;
                }
            } else if (TiebaApplication.f().as() != 0) {
                TiebaApplication.f().j(0);
                this.i = 0;
            } else {
                return;
            }
            a(this.i);
            com.baidu.tieba.util.d.a();
        }
    }

    public void c(String str) {
        this.E = false;
        if (str != null) {
            if (TiebaApplication.f().d(str)) {
                FrsImageActivity.a(this, str, null, 0);
                d();
                return;
            }
            if (this.m.b().isMenuShowing()) {
                this.m.b().toggle(true);
            }
            this.u = false;
            this.m.a().a(R.id.show_all);
            this.d = str;
            y();
        }
    }
}
