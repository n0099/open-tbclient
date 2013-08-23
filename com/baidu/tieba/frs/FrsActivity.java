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
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.home.CreateBarActivity;
import com.baidu.tieba.model.bv;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.write.WriteActivity;
import com.baidu.tieba.write.WriteImageActivity;
import com.slidingmenu.lib.R;
import com.slidingmenu.lib.SlidingMenu;
import com.tencent.mm.sdk.conversation.RConversation;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class FrsActivity extends com.baidu.tieba.g implements com.baidu.adp.widget.BdSwitchView.c {
    private static volatile long p = 0;
    private static volatile long q = 0;
    private static volatile int r = 0;
    private com.baidu.tieba.model.af C;
    private com.baidu.tieba.model.n D;
    private be I;

    /* renamed from: a  reason: collision with root package name */
    private boolean f1061a = true;
    private int b = 3;
    private String c = null;
    private String d = null;
    private int e = 0;
    private int f = 1;
    private boolean g = false;
    private String j = null;
    private boolean k = false;
    private bb l = null;
    private String m = null;
    private String n = null;
    private com.baidu.tieba.data.bh o = null;
    private long s = 0;
    private boolean t = false;
    private boolean u = true;
    private com.baidu.tieba.model.aa v = null;
    private com.baidu.tieba.model.aq w = null;
    private bv x = null;
    private Handler y = null;
    private long z = 0;
    private String A = "normal_page";
    private BroadcastReceiver B = null;
    private boolean E = false;
    private com.baidu.tieba.data.bh F = null;
    private boolean G = false;
    private boolean H = false;
    private ae J = new a(this);
    private ad K = new m(this);
    private Handler L = null;
    private com.baidu.tieba.util.a M = null;
    private Runnable N = new u(this);
    private com.baidu.adp.widget.ListView.r O = new w(this);
    private com.baidu.adp.widget.ListView.s P = new x(this);
    private AdapterView.OnItemClickListener Q = new y(this);
    private AdapterView.OnItemLongClickListener R = new aa(this);
    private com.baidu.adp.widget.ListView.b S = new ab(this);
    private View.OnClickListener T = new ac(this);
    private AbsListView.OnScrollListener U = new b(this);
    private View.OnClickListener V = new c(this);
    private SlidingMenu.OnClosedListener W = new e(this);
    private SlidingMenu.OnOpenedListener X = new f(this);
    private AdapterView.OnItemClickListener Y = new g(this);
    private com.baidu.tieba.view.ax Z = new h(this);

    @Override // com.baidu.tieba.g
    public boolean e() {
        return TiebaApplication.g().w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.ad adVar) {
        if (this.f1061a) {
            if (adVar != null) {
                if (adVar.f1356a && adVar.b) {
                    if (adVar.c == 3) {
                        this.g = false;
                        this.c = this.c.replace(" ", "");
                        String str = this.c;
                        if (str.length() > 31) {
                            str = String.valueOf(str.substring(0, 31)) + "...";
                        }
                        this.l.b(str);
                    } else if (UtilHelper.i(this) != UtilHelper.NetworkStateInfo.UNAVAIL) {
                        this.l.a(adVar.d);
                    }
                } else if (UtilHelper.i(this) != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    this.l.a(adVar.d);
                }
            }
        } else if (adVar != null) {
            this.l.a(adVar.d);
        }
    }

    public static void a(Context context, String str, String str2) {
        if (TiebaApplication.g().g(str)) {
            FrsImageActivity.a(context, str, str2, 0);
        } else {
            a(context, str, str2, false, false);
        }
    }

    public static void b(Context context, String str, String str2) {
        if (TiebaApplication.g().g(str)) {
            FrsImageActivity.a(context, str, str2, 0);
        } else {
            a(context, str, str2, false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        com.baidu.tieba.data.bh b = this.l.j().b();
        if (b != null) {
            ArrayList m = b.m();
            int size = m.size();
            for (int i = 0; i < size; i++) {
                if (((com.baidu.tieba.data.ai) m.get(i)).a() == 3) {
                    this.l.j().a().a(((com.baidu.tieba.data.ai) m.get(i)).b(), new i(this));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        com.baidu.tieba.data.bh b = this.l.k().b();
        if (b != null) {
            ArrayList m = b.m();
            int size = m.size();
            for (int i = 0; i < size; i++) {
                if (((com.baidu.tieba.data.ai) m.get(i)).a() == 3) {
                    this.l.k().a().a(((com.baidu.tieba.data.ai) m.get(i)).b(), new j(this));
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
        if (TiebaApplication.g().g(str)) {
            FrsImageActivity.a(context, str, str2, i);
            return;
        }
        Intent intent = new Intent(context, FrsActivity.class);
        if (str != null && str.length() > 0) {
            intent.putExtra("name", str);
            intent.putExtra("from", str2);
            intent.putExtra(RConversation.COL_FLAG, i);
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

    private void n() {
        int i = BdWebErrorView.ERROR_CODE_400;
        this.M = new com.baidu.tieba.util.a(this);
        this.M.b(true);
        int a2 = UtilHelper.a((Context) this, 267.0f);
        if (a2 <= 400) {
            i = a2;
        }
        this.M.a(i, (int) (i * 1.62f));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (v()) {
            w();
            a(bundle);
            this.l.B();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.aa aaVar) {
        if (aaVar != null) {
            try {
                if (this.u) {
                    this.l.s();
                    this.u = false;
                }
                if (aaVar.e().a() == 1) {
                    this.A = "frs_page";
                    this.l.o();
                } else {
                    this.A = "normal_page";
                    this.l.n();
                }
                if (!com.baidu.tieba.model.p.a().c(String.valueOf(TiebaApplication.E()) + this.c)) {
                    aaVar.a().i().b(0);
                }
                this.l.l();
                this.c = aaVar.a().b();
                this.l.c(this.c);
                C();
                ArrayList b = aaVar.b();
                if (b != null) {
                    this.l.a(b, this.f);
                    if (this.A == "frs_page") {
                        this.l.a(aaVar.a(), aaVar.e());
                    } else if (this.A == "normal_page") {
                        this.l.a(aaVar.a());
                    }
                    this.l.b(this.f);
                    this.l.c(aaVar.d().f());
                    this.l.u();
                    this.l.d(0);
                }
                this.L.removeCallbacks(this.N);
                this.L.postDelayed(this.N, 300L);
            } catch (Exception e) {
                com.baidu.tieba.util.aq.b(getClass().getName(), "", "FrsActivity.refreshWithFrs error = " + e.getMessage());
            }
        }
    }

    private void a(Bundle bundle) {
        this.L = new Handler();
        n();
        this.n = TiebaApplication.E();
        if (bundle != null) {
            this.c = bundle.getString("name");
            this.d = bundle.getString("from");
            this.e = bundle.getInt(RConversation.COL_FLAG, 0);
        } else {
            Intent intent = getIntent();
            this.c = intent.getStringExtra("name");
            this.d = intent.getStringExtra("from");
            this.e = intent.getIntExtra(RConversation.COL_FLAG, 0);
            this.t = intent.getBooleanExtra("good", false);
        }
        if (this.c != null && this.c.length() > 0) {
            if (this.d == null || this.d.length() <= 0) {
                this.d = "tb_forumlist";
            }
            this.m = this.d;
            this.E = false;
            r();
            o();
            p();
            q();
            this.C = new com.baidu.tieba.model.af(this);
            if (this.n != null && this.n.length() > 0) {
                s();
                u();
                this.D.a(false, true, true);
            }
        }
    }

    private void o() {
        this.w = new com.baidu.tieba.model.aq();
        this.w.setLoadDataCallBack(new k(this));
    }

    private void p() {
        this.x = new bv();
        this.x.setLoadDataCallBack(new l(this));
    }

    private void q() {
        this.D = new com.baidu.tieba.model.n();
        this.D.setLoadDataCallBack(new n(this));
    }

    private void r() {
        this.y = new o(this);
    }

    private void s() {
        this.C.a(com.baidu.tieba.mention.r.a().i());
        this.C.c(com.baidu.tieba.mention.r.a().g());
        this.C.b(com.baidu.tieba.mention.r.a().h());
        this.C.d(com.baidu.tieba.mention.r.a().j());
        this.l.a(this.C);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        this.l.a().a(this.D.a());
    }

    private void u() {
        if (this.B == null) {
            this.B = new p(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.tieba.broadcast.notify");
            registerReceiver(this.B, intentFilter);
        }
    }

    private boolean v() {
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
        if (this.L != null) {
            this.L.removeCallbacks(this.N);
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
                this.w.a();
            }
            if (this.x != null) {
                this.x.a();
            }
            if (this.D != null) {
                this.D.cancelLoadData();
            }
            this.l.w();
            System.gc();
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "onDestroy", e.getMessage());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.c);
        bundle.putString("from", this.d);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        boolean z = true;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    e(0);
                    return;
                case 11002:
                    l();
                    return;
                case 11011:
                    c(this.o);
                    return;
                case 11012:
                    d(this.F);
                    return;
                case 11013:
                    z();
                    return;
                case 11014:
                    m();
                    return;
                case 11016:
                    this.l.t();
                    return;
                case 11021:
                    if (this.v != null) {
                        k();
                        return;
                    }
                    return;
                case 11033:
                default:
                    return;
                case 12001:
                    if (this.v != null && this.v.a() != null) {
                        WriteImageActivity.a(this, 12001, 12010, null, this.v.a().a(), this.c, this.v.c());
                        return;
                    }
                    return;
                case 12002:
                    if (this.v != null && this.v.a() != null && intent != null && intent.getData() != null) {
                        WriteImageActivity.a(this, 12002, 12009, intent.getData(), this.v.a().a(), this.c, this.v.c());
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    if (this.v != null && this.v.a() != null) {
                        if (intent == null || intent.getStringExtra("filename") == null) {
                            WriteActivity.a((Activity) this, this.v.a().a(), this.c, (AntiData) null, true, (String) null);
                            return;
                        } else {
                            WriteActivity.a((Activity) this, this.v.a().a(), this.c, (AntiData) null, true, intent.getStringExtra("filename"));
                            return;
                        }
                    }
                    return;
                case 13003:
                    A();
                    return;
                case 18003:
                    this.l.i().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null) {
                        int size = this.v.b().size();
                        int i3 = 0;
                        while (true) {
                            if (i3 >= size) {
                                z = false;
                            } else if (!stringExtra.equals(((com.baidu.tieba.data.bh) this.v.b().get(i3)).a())) {
                                i3++;
                            }
                        }
                        if (z) {
                            int intExtra = intent.getIntExtra("type", 0);
                            if (intExtra == 2) {
                                ((com.baidu.tieba.data.bh) this.v.b().get(i3)).b(intent.getIntExtra("good_data", 0));
                                ((com.baidu.tieba.data.bh) this.v.b().get(i3)).a(intent.getIntExtra("top_data", 0));
                                ((com.baidu.tieba.data.bh) this.v.b().get(i3)).o();
                            } else if (intExtra == 0) {
                                this.v.b().remove(i3);
                            }
                            this.l.u();
                            return;
                        }
                        return;
                    }
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12009:
                    com.baidu.tieba.write.ba.b(this);
                    return;
                case 12010:
                    com.baidu.tieba.write.ba.a(this);
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
        String E = TiebaApplication.E();
        if (this.n == null && E != null && E.length() > 0) {
            this.n = E;
            if (this.v != null && this.v.c() != null) {
                this.v.c().setIfpost(1);
            }
        }
        if (E != null && E.length() > 0) {
            this.l.a().a(true);
        } else {
            this.l.a().a(false);
        }
        this.l.A();
        this.N.run();
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
        String E = TiebaApplication.E();
        if (E != null && E.length() > 0) {
            MainTabActivity.a(this, 1);
        } else {
            MainTabActivity.a(this, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        this.l.w();
        finish();
        CompatibleUtile.setAnim(this, R.anim.frs_browser_enter, R.anim.no_effect);
    }

    private void w() {
        this.f1061a = true;
        this.c = "";
        this.d = "";
        this.e = 0;
        this.f = 1;
        this.t = false;
        this.s = 0L;
        this.b = 3;
        this.l = new bb(this, this.T);
        this.l.a().c();
        this.l.a(this.O);
        this.l.a(this.P);
        this.l.a(this.V);
        this.l.a(this.Q);
        this.l.a(this.R);
        this.l.a(this.U);
        this.l.a(this.S);
        this.l.a(this.W);
        this.l.a(this.X);
        this.l.a(this.Z);
        if (TiebaApplication.g().getSharedPreferences("settings", 0).getBoolean("frs_first_in", true)) {
            this.I = new be(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        this.l.j(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        this.l.x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.adp.widget.a.b bVar, boolean z) {
        if (bVar != null) {
            this.l.a(bVar, z);
            this.l.y().setOnDismissListener(new q(this));
            this.l.y().setOnCancelListener(new r(this));
            a(0.3f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (this.M != null) {
            this.M.b();
        }
        a(1.0f);
        this.l.z();
    }

    private void a(float f) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = f;
        getWindow().setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        String E = TiebaApplication.E();
        if (E == null || E.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11013);
            return;
        }
        CreateBarActivity.a(this, this.c, true);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        Intent a2;
        if (str != null && (a2 = a((Context) this, str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + getString(R.string.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", a2);
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this, R.drawable.icon));
            sendBroadcast(intent);
            new com.baidu.tieba.account.ag("add_to_launcher").start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i) {
        String E = TiebaApplication.E();
        if (E == null || E.length() <= 0) {
            if (this.v != null && this.v.c() != null) {
                this.v.c().setIfpost(1);
            }
            if (i == 0) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11001);
            } else {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11016);
            }
        } else if (this.v != null) {
            if (i == 0) {
                WriteActivity.a((Activity) this, this.v.a().a(), this.c, this.v.c(), false, (String) null);
            } else {
                this.l.t();
            }
        }
    }

    private boolean a(com.baidu.tieba.data.bh bhVar) {
        String id;
        return bhVar == null || bhVar.g() == null || (id = bhVar.g().getId()) == null || id.equals("0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.data.bh bhVar) {
        boolean a2 = a(bhVar);
        this.l.a(new s(this, bhVar));
        this.l.a(bhVar, a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.data.bh bhVar) {
        boolean a2 = a(bhVar);
        if (this.j != null) {
            if (!a2) {
                NewPbActivity.a(this, bhVar, null, 18003, true, true, this.k);
            } else {
                NewPbActivity.a(this, bhVar, null, 18003, false, false, this.k);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.data.bh bhVar) {
        if (this.j != null) {
            NewPbActivity.a(this, bhVar, null, 18003, false, false, this.k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        this.f = 1;
        this.b = 3;
        B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        BasicNameValuePair basicNameValuePair;
        boolean z = false;
        switch (this.b) {
            case 1:
                if (this.l.i().b()) {
                    return;
                }
                break;
            case 2:
                if (this.l.i().c()) {
                    return;
                }
                break;
            case 3:
                if (this.l.h()) {
                    return;
                }
                break;
        }
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append(com.baidu.tieba.data.g.f1014a);
        stringBuffer.append("c/f/frs/page");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("kw", this.c));
        arrayList.add(new BasicNameValuePair("pn", String.valueOf(this.f)));
        if (TiebaApplication.g().al()) {
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
        this.l.i().c(false);
        this.l.i().d(false);
        this.l.i().notifyDataSetChanged();
        if (this.f == 1 && ((this.A.equals("normal_page") || this.A.equals("frs_page")) && !this.t)) {
            z = true;
        }
        if (this.v == null) {
            this.v = new com.baidu.tieba.model.aa();
        }
        this.v.a(this.J);
        this.v.a(stringBuffer.toString(), arrayList, this.b, z, this.c);
    }

    private void C() {
        switch (this.e) {
            case 1:
                DatabaseService.l(this.c);
                break;
        }
        this.e = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        try {
            if (this.v != null) {
                this.l.l();
                this.c = this.v.a().b();
                this.l.c(this.c);
                C();
                this.f1061a = false;
                ArrayList b = this.v.b();
                if (b != null) {
                    this.l.a(b, this.f);
                    if (this.A == "frs_page") {
                        E();
                    } else if (this.A == "normal_page") {
                        this.l.a(this.v.a());
                    }
                    this.l.b(this.f);
                    this.l.c(this.v.d().f());
                    this.l.u();
                    if (this.b == 1) {
                        this.l.d(3);
                    } else if (this.b == 2) {
                        if (this.f == 1) {
                            this.l.d(0);
                        } else {
                            this.l.d(3);
                        }
                    } else {
                        this.l.d(0);
                    }
                    this.H = true;
                    if (this.I != null && TiebaApplication.g().an() != 1 && this.v.a().e() == 0) {
                        if (this.A.equals("normal_page") || this.A.equals("frs_page")) {
                            this.L.post(new t(this));
                        }
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "", "FrsActivity.refreshFrs error = " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onPause() {
        super.onPause();
        this.l.v();
        if (this.y != null) {
            this.y.removeMessages(1);
        }
    }

    @Override // com.baidu.tieba.g, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.g) {
            if (i == 4) {
                if (this.l.b().isMenuShowing()) {
                    this.l.b().toggle(true);
                    if (this.E) {
                        this.E = false;
                        A();
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

    private void E() {
        this.l.a(this.v.a(), this.v.e());
        this.y.removeMessages(1);
        if (this.f == 1 && this.A == "frs_page" && this.v.e().h() == 0) {
            this.z = System.nanoTime() / 1000000000;
            if (this.v.e().i() > 0) {
                this.y.sendMessageDelayed(this.y.obtainMessage(1), 1000L);
            }
        }
    }

    public void k() {
        String E = TiebaApplication.E();
        if (E == null || E.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11021);
        } else if (!this.v.f()) {
            this.v.a(true);
            this.v.a(this.K);
            this.v.b(String.valueOf(this.v.a().e()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        String E = TiebaApplication.E();
        if (E == null || E.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11002);
            return;
        }
        this.l.c(true);
        this.w.a("from_frs");
        this.w.a(this.v.a().b(), this.v.a().a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
        String E = TiebaApplication.E();
        if (E == null || E.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11014);
            return;
        }
        this.l.c(true);
        this.x.a(this.v.a().b(), this.v.a().a());
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.l.a().d()) {
            this.E = true;
            if (switchState == BdSwitchView.SwitchState.ON) {
                if (!TiebaApplication.g().al() && TiebaApplication.g().u()) {
                    StatService.onEvent(this, "frs_abstract", "frsclick", 1);
                }
                TiebaApplication.g().r(true);
                return;
            }
            if (TiebaApplication.g().al() && TiebaApplication.g().u()) {
                StatService.onEvent(this, "frs_abstract", "frsclick", 1);
            }
            TiebaApplication.g().r(false);
        } else if (view == this.l.a().e()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                if (TiebaApplication.g().an() != 1) {
                    if (TiebaApplication.g().u()) {
                        StatService.onEvent(this, "frs_night_mode", "frsclick", 1);
                    }
                    TiebaApplication.g().g(1);
                    this.i = 1;
                    new com.baidu.tieba.account.ag("eyeshield").start();
                } else {
                    return;
                }
            } else if (TiebaApplication.g().an() != 0) {
                TiebaApplication.g().g(0);
                this.i = 0;
            } else {
                return;
            }
            a(this.i);
            com.baidu.tieba.util.e.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        this.E = false;
        if (str != null) {
            if (TiebaApplication.g().g(str)) {
                FrsImageActivity.a(this, str, null, 0);
                d();
                return;
            }
            if (this.l.b().isMenuShowing()) {
                this.l.b().toggle(true);
            }
            this.t = false;
            this.l.a().a(R.id.show_all);
            this.c = str;
            A();
        }
    }
}
