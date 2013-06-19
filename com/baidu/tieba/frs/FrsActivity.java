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
import com.baidu.android.common.util.HanziToPinyin;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.c.bn;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.home.CreateBarActivity;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.write.WriteActivity;
import com.baidu.tieba.write.WriteImageActivity;
import com.slidingmenu.lib.R;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class FrsActivity extends com.baidu.tieba.e implements com.baidu.adp.widget.BdSwitchView.c {
    private static volatile long p = 0;
    private static volatile long q = 0;
    private static volatile int r = 0;
    private com.baidu.tieba.c.x C;
    private com.baidu.tieba.c.j D;
    private boolean c = true;
    private int d = 3;
    private String e = null;
    private String f = null;
    private int g = 0;
    private int h = 1;
    private boolean i = false;
    private String j = null;
    private boolean k = false;
    private ba l = null;
    private String m = null;
    private String n = null;
    private com.baidu.tieba.a.bc o = null;
    private long s = 0;
    private boolean t = false;
    private boolean u = true;
    private com.baidu.tieba.c.s v = null;
    private com.baidu.tieba.c.ag w = null;
    private bn x = null;
    private Handler y = null;
    private long z = 0;
    private String A = "normal_page";
    private BroadcastReceiver B = null;
    private boolean E = false;
    private com.baidu.tieba.a.bc F = null;
    private ac G = new a(this);
    private ab H = new m(this);
    private Handler I = null;
    private com.baidu.tieba.d.a J = null;
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

    @Override // com.baidu.tieba.e
    public boolean e() {
        return TiebaApplication.e().s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.c.v vVar) {
        if (this.c) {
            if (vVar != null) {
                if (vVar.a && vVar.b) {
                    if (vVar.c == 3) {
                        this.i = false;
                        this.e = this.e.replace(HanziToPinyin.Token.SEPARATOR, "");
                        String str = this.e;
                        if (str.length() > 31) {
                            str = String.valueOf(str.substring(0, 31)) + "...";
                        }
                        this.l.b(str);
                        return;
                    }
                    this.l.a(vVar.d);
                    return;
                }
                this.l.a(vVar.d);
            }
        } else if (vVar != null) {
            this.l.a(vVar.d);
        }
    }

    public static void a(Context context, String str, String str2) {
        if (TiebaApplication.e().b(str)) {
            FrsImageActivity.a(context, str, str2, 0);
        } else {
            a(context, str, str2, false, false);
        }
    }

    public static void b(Context context, String str, String str2) {
        if (TiebaApplication.e().b(str)) {
            FrsImageActivity.a(context, str, str2, 0);
        } else {
            a(context, str, str2, false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        com.baidu.tieba.a.bc b = this.l.h().b();
        if (b != null) {
            ArrayList m = b.m();
            int size = m.size();
            for (int i = 0; i < size; i++) {
                if (((com.baidu.tieba.a.ag) m.get(i)).a() == 3) {
                    this.l.h().a().a(((com.baidu.tieba.a.ag) m.get(i)).b(), new h(this));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        com.baidu.tieba.a.bc b = this.l.i().b();
        if (b != null) {
            ArrayList m = b.m();
            int size = m.size();
            for (int i = 0; i < size; i++) {
                if (((com.baidu.tieba.a.ag) m.get(i)).a() == 3) {
                    this.l.i().a().a(((com.baidu.tieba.a.ag) m.get(i)).b(), new i(this));
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
        if (TiebaApplication.e().b(str)) {
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
        this.J = new com.baidu.tieba.d.a(this);
        this.J.b(true);
        int a = com.baidu.tieba.d.ag.a(this, 267.0f);
        if (a <= 400) {
            i = a;
        }
        this.J.a(i, (int) (i * 1.62f));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, com.baidu.adp.a.a, android.app.Activity
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
        this.n = TiebaApplication.C();
        if (bundle != null) {
            this.e = bundle.getString("name");
            this.f = bundle.getString("from");
            this.g = bundle.getInt("flag", 0);
        } else {
            Intent intent = getIntent();
            this.e = intent.getStringExtra("name");
            this.f = intent.getStringExtra("from");
            this.g = intent.getIntExtra("flag", 0);
            this.t = intent.getBooleanExtra("good", false);
        }
        if (this.e != null && this.e.length() > 0) {
            if (this.f == null || this.f.length() <= 0) {
                this.f = "tb_forumlist";
            }
            this.m = this.f;
            this.E = false;
            this.y = new j(this);
            this.w = new com.baidu.tieba.c.ag();
            this.w.a(new k(this));
            this.x = new bn();
            this.x.a(new l(this));
            this.C = new com.baidu.tieba.c.x(this);
            this.D = new com.baidu.tieba.c.j();
            this.D.a(new n(this));
            String C = TiebaApplication.C();
            if (C != null && C.length() > 0) {
                q();
                s();
                this.D.a(false, true, true);
            }
        }
    }

    private void q() {
        this.C.a(TiebaApplication.e().ae());
        this.C.c(TiebaApplication.e().ac());
        this.C.b(TiebaApplication.e().ad());
        this.C.d(TiebaApplication.e().af());
        this.l.a(this.C);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        this.l.a().a(this.D.d());
    }

    private void s() {
        if (this.B == null) {
            this.B = new o(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.tieba.broadcast.notify");
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
    @Override // com.baidu.tieba.e, android.app.Activity
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
            if (this.v != null) {
                this.v.g();
            }
            if (this.w != null) {
                this.w.e();
            }
            if (this.x != null) {
                this.x.d();
            }
            if (this.D != null) {
                this.D.e();
            }
            this.l.u();
            System.gc();
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "onDestroy", e.getMessage());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.e);
        bundle.putString("from", this.f);
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
                    c(this.o);
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
                    this.l.r();
                    return;
                case 1100021:
                    if (this.v != null) {
                        m();
                        return;
                    }
                    return;
                case 1200001:
                    if (this.v != null && this.v.a() != null) {
                        WriteImageActivity.a(this, 1200001, 1200010, null, this.v.a().a(), this.e, this.v.c());
                        return;
                    }
                    return;
                case 1200002:
                    if (this.v != null && this.v.a() != null && intent != null && intent.getData() != null) {
                        WriteImageActivity.a(this, 1200002, 1200009, intent.getData(), this.v.a().a(), this.e, this.v.c());
                        return;
                    }
                    return;
                case 1200009:
                case 1200010:
                    if (this.v != null && this.v.a() != null) {
                        if (intent == null || intent.getStringExtra("filename") == null) {
                            WriteActivity.a((Activity) this, this.v.a().a(), this.e, (com.baidu.tieba.a.b) null, true, (String) null);
                            return;
                        } else {
                            WriteActivity.a((Activity) this, this.v.a().a(), this.e, (com.baidu.tieba.a.b) null, true, intent.getStringExtra("filename"));
                            return;
                        }
                    }
                    return;
                case 1300003:
                    y();
                    return;
                case 1800003:
                    this.l.g().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null) {
                        int size = this.v.b().size();
                        int i3 = 0;
                        while (true) {
                            if (i3 >= size) {
                                z = false;
                            } else if (!stringExtra.equals(((com.baidu.tieba.a.bc) this.v.b().get(i3)).a())) {
                                i3++;
                            }
                        }
                        if (z) {
                            int intExtra = intent.getIntExtra("type", 0);
                            if (intExtra == 2) {
                                ((com.baidu.tieba.a.bc) this.v.b().get(i3)).b(intent.getIntExtra("good_data", 0));
                                ((com.baidu.tieba.a.bc) this.v.b().get(i3)).a(intent.getIntExtra("top_data", 0));
                                ((com.baidu.tieba.a.bc) this.v.b().get(i3)).o();
                            } else if (intExtra == 0) {
                                this.v.b().remove(i3);
                            }
                            this.l.s();
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
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        String C = TiebaApplication.C();
        if (this.n == null && C != null && C.length() > 0) {
            this.n = C;
            if (this.v != null && this.v.c() != null) {
                this.v.c().a(1);
            }
        }
        if (C != null && C.length() > 0) {
            this.l.a().a(true);
        } else {
            this.l.a().a(false);
        }
        this.K.run();
        if (this.y != null) {
            this.y.removeMessages(1);
            this.y.sendMessageDelayed(this.y.obtainMessage(1), 1000L);
        }
    }

    @Override // com.baidu.tieba.e
    public void f() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
            return;
        }
        String C = TiebaApplication.C();
        if ((C != null && C.length() > 0) || TiebaApplication.e().at() >= 3) {
            MainTabActivity.a(this, "goto_home");
        } else {
            MainTabActivity.a(this, "goto_recommend");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        this.l.u();
        finish();
        CompatibleUtile.setAnim(this, R.anim.frs_browser_enter, R.anim.no_effect);
    }

    private void u() {
        this.c = true;
        this.e = "";
        this.f = "";
        this.g = 0;
        this.h = 1;
        this.t = false;
        this.s = 0L;
        this.d = 3;
        this.l = new ba(this, this.Q);
        this.l.a().b();
        this.l.a(this.L);
        this.l.a(this.M);
        this.l.a(this.S);
        this.l.a(this.N);
        this.l.a(this.O);
        this.l.a(this.R);
        this.l.a(this.P);
        this.l.a(this.T);
        this.l.a(this.U);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        this.l.j(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        this.l.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.adp.widget.a.b bVar, boolean z) {
        if (bVar != null) {
            this.l.a(bVar, z);
            this.l.w().setOnDismissListener(new p(this));
            this.l.w().setOnCancelListener(new q(this));
            a(0.3f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (this.J != null) {
            this.J.b();
        }
        a(1.0f);
        this.l.x();
    }

    private void a(float f) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = f;
        getWindow().setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        String C = TiebaApplication.C();
        if (C == null || C.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100013);
            return;
        }
        CreateBarActivity.a(this, this.e, true);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
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
        String C = TiebaApplication.C();
        if (C == null || C.length() <= 0) {
            if (this.v != null && this.v.c() != null) {
                this.v.c().a(1);
            }
            if (i == 0) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100001);
            } else {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100016);
            }
        } else if (this.v != null) {
            if (i == 0) {
                WriteActivity.a((Activity) this, this.v.a().a(), this.e, this.v.c(), false, (String) null);
            } else {
                this.l.r();
            }
        }
    }

    private boolean a(com.baidu.tieba.a.bc bcVar) {
        String a;
        return bcVar == null || bcVar.g() == null || (a = bcVar.g().a()) == null || a.equals("0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.a.bc bcVar) {
        boolean a = a(bcVar);
        this.l.a(new r(this, bcVar));
        this.l.a(bcVar, a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.a.bc bcVar) {
        boolean a = a(bcVar);
        if (this.j != null) {
            if (!a) {
                NewPbActivity.a(this, bcVar, null, 1800003, true, true, this.k);
            } else {
                NewPbActivity.a(this, bcVar, null, 1800003, false, false, this.k);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.a.bc bcVar) {
        if (this.j != null) {
            NewPbActivity.a(this, bcVar, null, 1800003, false, false, this.k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        this.h = 1;
        this.d = 3;
        z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        BasicNameValuePair basicNameValuePair;
        switch (this.d) {
            case 1:
                if (this.l.g().b()) {
                    return;
                }
                break;
            case 2:
                if (this.l.g().c()) {
                    return;
                }
                break;
            case 3:
                if (this.l.f()) {
                    return;
                }
                break;
        }
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append(com.baidu.tieba.a.i.e);
        stringBuffer.append("c/f/frs/page");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("kw", this.e));
        arrayList.add(new BasicNameValuePair("pn", String.valueOf(this.h)));
        if (TiebaApplication.e().aq()) {
            basicNameValuePair = new BasicNameValuePair("rn", String.valueOf(35));
        } else {
            basicNameValuePair = new BasicNameValuePair("rn", String.valueOf(50));
        }
        arrayList.add(basicNameValuePair);
        if (this.t) {
            arrayList.add(new BasicNameValuePair("is_good", "1"));
            arrayList.add(new BasicNameValuePair("cid", String.valueOf(this.s)));
        }
        if (this.m != null) {
            arrayList.add(new BasicNameValuePair("st_type", this.m));
        }
        if (p != 0) {
            arrayList.add(new BasicNameValuePair("ctime", String.valueOf(p)));
        }
        if (q != 0) {
            arrayList.add(new BasicNameValuePair("data_size", String.valueOf(q)));
        }
        if (r != 0) {
            arrayList.add(new BasicNameValuePair("net_error", String.valueOf(r)));
        }
        this.l.b(true);
        this.l.g().c(false);
        this.l.g().d(false);
        this.l.g().notifyDataSetChanged();
        this.v = new com.baidu.tieba.c.s();
        this.v.a(this.G);
        this.v.a(stringBuffer.toString(), arrayList, this.d);
    }

    private void A() {
        switch (this.g) {
            case 1:
                com.baidu.tieba.d.k.k(this.e);
                break;
        }
        this.g = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        try {
            if (this.v != null) {
                this.l.j();
                this.e = this.v.a().b();
                this.l.c(this.e);
                A();
                this.c = false;
                ArrayList b = this.v.b();
                if (b != null) {
                    this.l.a(b, this.h);
                    if (this.A == "frs_page") {
                        C();
                    } else if (this.A == "normal_page") {
                        this.l.a(this.v.a());
                    }
                    this.l.b(this.h);
                    this.l.c(this.v.d().f());
                    this.l.s();
                    if (this.d == 1) {
                        this.l.d(3);
                    } else if (this.d == 2) {
                        if (this.h == 1) {
                            this.l.d(0);
                        } else {
                            this.l.d(3);
                        }
                    } else {
                        this.l.d(0);
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "", "HomeActivity.refreshFrs error = " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        super.onPause();
        this.l.t();
        if (this.y != null) {
            this.y.removeMessages(1);
        }
    }

    @Override // com.baidu.tieba.e, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.i) {
            if (i == 4) {
                if (this.l.b().isMenuShowing()) {
                    this.l.b().toggle(true);
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
        this.l.a(this.v.a(), this.v.e());
        this.y.removeMessages(1);
        if (this.h == 1 && this.A == "frs_page" && this.v.e().h() == 0) {
            this.z = System.nanoTime() / 1000000000;
            if (this.v.e().i() > 0) {
                this.y.sendMessageDelayed(this.y.obtainMessage(1), 1000L);
            }
        }
    }

    public void m() {
        String C = TiebaApplication.C();
        if (C == null || C.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100021);
        } else if (!this.v.f()) {
            this.v.a(true);
            this.v.a(this.H);
            this.v.b(String.valueOf(this.v.a().e()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n() {
        String C = TiebaApplication.C();
        if (C == null || C.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100002);
        } else {
            this.w.a(this.v.a().b(), this.v.a().a());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o() {
        String C = TiebaApplication.C();
        if (C == null || C.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100014);
        } else {
            this.x.a(this.v.a().b(), this.v.a().a());
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, com.baidu.adp.widget.BdSwitchView.d dVar) {
        if (view == this.l.a().c()) {
            this.E = true;
            if (dVar == com.baidu.adp.widget.BdSwitchView.d.ON) {
                if (!TiebaApplication.e().aq() && TiebaApplication.e().p()) {
                    StatService.onEvent(this, "frs_abstract", "frsclick", 1);
                }
                TiebaApplication.e().r(true);
                return;
            }
            if (TiebaApplication.e().aq() && TiebaApplication.e().p()) {
                StatService.onEvent(this, "frs_abstract", "frsclick", 1);
            }
            TiebaApplication.e().r(false);
        } else if (view == this.l.a().d()) {
            if (dVar == com.baidu.adp.widget.BdSwitchView.d.ON) {
                if (TiebaApplication.e().as() != 1) {
                    if (TiebaApplication.e().p()) {
                        StatService.onEvent(this, "frs_night_mode", "frsclick", 1);
                    }
                    TiebaApplication.e().j(1);
                    this.b = 1;
                    new com.baidu.tieba.account.af("eyeshield").start();
                } else {
                    return;
                }
            } else if (TiebaApplication.e().as() != 0) {
                TiebaApplication.e().j(0);
                this.b = 0;
            } else {
                return;
            }
            b(this.b);
            com.baidu.tieba.d.d.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        this.E = false;
        if (str != null) {
            if (TiebaApplication.e().b(str)) {
                FrsImageActivity.a(this, str, null, 0);
                d();
                return;
            }
            if (this.l.b().isMenuShowing()) {
                this.l.b().toggle(true);
            }
            this.t = false;
            this.l.a().a(R.id.show_all);
            this.e = str;
            y();
        }
    }
}
