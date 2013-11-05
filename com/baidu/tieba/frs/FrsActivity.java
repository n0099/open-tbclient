package com.baidu.tieba.frs;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.home.CreateBarActivity;
import com.baidu.tieba.model.cg;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.voice.VoiceManager;
import com.baidu.tieba.write.WriteActivity;
import com.baidu.tieba.write.WriteImageActivity;
import com.slidingmenu.lib.R;
import com.slidingmenu.lib.SlidingMenu;
import com.tencent.mm.sdk.conversation.RConversation;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class FrsActivity extends com.baidu.tieba.j implements com.baidu.adp.widget.BdSwitchView.c, com.baidu.tieba.voice.ag {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f1243a = false;
    private static volatile long r = 0;
    private static volatile long s = 0;
    private static volatile int t = 0;
    private com.baidu.tieba.model.ap E;
    private com.baidu.tieba.model.x F;
    VoiceManager b;
    private boolean c = true;
    private int d = 3;
    private String e = null;
    private String f = null;
    private int g = 0;
    private int j = 1;
    private boolean k = false;
    private boolean l = false;
    private String m = null;
    private boolean n = false;
    private ba o = null;
    private String p = null;
    private com.baidu.tieba.data.bf q = null;
    private long u = 0;
    private boolean v = false;
    private boolean w = true;
    private com.baidu.tieba.model.ak x = null;
    private com.baidu.tieba.model.ba y = null;
    private cg z = null;
    private Handler A = null;
    private long B = 0;
    private String C = "normal_page";
    private BroadcastReceiver D = null;
    private boolean G = false;
    private com.baidu.tieba.data.bf H = null;
    private ac I = new a(this);
    private ab J = new m(this);
    private Handler K = null;
    private com.baidu.tieba.util.a L = null;
    private Runnable M = new u(this);
    private com.baidu.adp.widget.ListView.r N = new c(this);
    private com.baidu.adp.widget.ListView.s O = new d(this);
    private AdapterView.OnItemClickListener P = new h(this);
    private AdapterView.OnItemLongClickListener Q = new j(this);
    private com.baidu.adp.widget.ListView.b R = new k(this);
    private View.OnClickListener S = new l(this);
    private AbsListView.OnScrollListener T = new n(this);
    private View.OnClickListener U = new o(this);
    private SlidingMenu.OnClosedListener V = new q(this);
    private SlidingMenu.OnOpenedListener W = new r(this);
    private AdapterView.OnItemClickListener X = new s(this);
    private com.baidu.tieba.view.az Y = new t(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int i(FrsActivity frsActivity) {
        int i = frsActivity.j;
        frsActivity.j = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int x(FrsActivity frsActivity) {
        int i = frsActivity.j;
        frsActivity.j = i + 1;
        return i;
    }

    @Override // com.baidu.tieba.j
    public boolean g() {
        return TiebaApplication.g().u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.an anVar) {
        if (this.c) {
            if (anVar != null) {
                if (anVar.f1898a && anVar.b) {
                    if (anVar.c == 3) {
                        this.k = false;
                        this.e = this.e.replace(" ", "");
                        String str = this.e;
                        if (str.length() > 31) {
                            str = str.substring(0, 31) + "...";
                        }
                        this.o.b(str);
                    } else if (UtilHelper.i(this) != UtilHelper.NetworkStateInfo.UNAVAIL) {
                        this.o.a(anVar.d);
                    }
                } else if (UtilHelper.i(this) != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    this.o.a(anVar.d);
                }
            }
        } else if (anVar != null) {
            this.o.a(anVar.d);
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
    public void c() {
        com.baidu.tieba.data.bf b = this.o.i().b();
        if (b != null) {
            ArrayList<com.baidu.tieba.data.ai> m = b.m();
            int size = m.size();
            for (int i = 0; i < size; i++) {
                if (m.get(i).a() == 3) {
                    this.o.i().a().a(m.get(i).b(), new v(this));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        com.baidu.tieba.data.bf b = this.o.j().b();
        if (b != null) {
            ArrayList<com.baidu.tieba.data.ai> m = b.m();
            int size = m.size();
            for (int i = 0; i < size; i++) {
                if (m.get(i).a() == 3) {
                    this.o.j().a().a(m.get(i).b(), new w(this));
                }
            }
        }
    }

    public static void a(Context context, String str, String str2, boolean z, boolean z2) {
        Intent intent = new Intent(context, FrsActivity.class);
        if (str != null && str.length() > 0) {
            intent.putExtra(SocialConstants.PARAM_MEDIA_UNAME, str);
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
            intent.putExtra(SocialConstants.PARAM_MEDIA_UNAME, str);
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

    private void p() {
        int i = BdWebErrorView.ERROR_CODE_400;
        this.L = new com.baidu.tieba.util.a(this);
        this.L.b(true);
        int a2 = UtilHelper.a((Context) this, 267.0f);
        if (a2 <= 400) {
            i = a2;
        }
        this.L.a(i, (int) (i * 1.62f));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (x()) {
            this.b = g_();
            this.b.a((Activity) this);
            y();
            a(bundle);
            this.o.A();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.b = g_();
        this.b.b((Activity) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.ak akVar) {
        if (akVar != null) {
            try {
                if (this.w) {
                    this.o.r();
                    this.w = false;
                }
                if (akVar.h() == 1) {
                    this.o.h().a().d(true);
                } else {
                    this.o.h().a().d(false);
                }
                if (akVar.e().a() == 1) {
                    this.C = "frs_page";
                    this.o.n();
                } else {
                    this.C = "normal_page";
                    this.o.m();
                }
                if (!com.baidu.tieba.model.z.a().c(TiebaApplication.C() + this.e)) {
                    akVar.a().getSignData().setIsSigned(0);
                }
                this.o.k();
                this.e = akVar.a().getName();
                this.o.c(this.e);
                E();
                ArrayList<com.baidu.tieba.data.bf> b = akVar.b();
                if (b != null) {
                    this.o.a(b, akVar, this.j);
                    if (this.C.equals("frs_page")) {
                        this.o.a(akVar.a(), akVar.e());
                    } else if (this.C.equals("normal_page")) {
                        this.o.a(akVar.a());
                    }
                    this.o.b(this.j);
                    this.o.c(akVar.d().f());
                    this.o.u();
                    this.o.d(0);
                }
                if (akVar.h() == 1) {
                    this.o.h().a().d(true);
                } else {
                    this.o.h().a().d(false);
                }
                this.K.removeCallbacks(this.M);
                this.K.postDelayed(this.M, 300L);
            } catch (Exception e) {
                com.baidu.tieba.util.be.b(getClass().getName(), "", "FrsActivity.refreshWithFrs error = " + e.getMessage());
            }
        }
    }

    private void a(Bundle bundle) {
        this.K = new Handler();
        p();
        this.l = TiebaApplication.D();
        if (bundle != null) {
            this.e = bundle.getString(SocialConstants.PARAM_MEDIA_UNAME);
            this.f = bundle.getString("from");
            this.g = bundle.getInt(RConversation.COL_FLAG, 0);
        } else {
            Intent intent = getIntent();
            this.e = intent.getStringExtra(SocialConstants.PARAM_MEDIA_UNAME);
            this.f = intent.getStringExtra("from");
            this.g = intent.getIntExtra(RConversation.COL_FLAG, 0);
            this.v = intent.getBooleanExtra("good", false);
        }
        if (this.e != null && this.e.length() > 0) {
            if (this.f == null || this.f.length() <= 0) {
                this.f = "tb_forumlist";
            }
            this.p = this.f;
            this.G = false;
            t();
            q();
            r();
            s();
            this.E = new com.baidu.tieba.model.ap(this);
            if (this.l) {
                u();
                w();
                this.F.a(false, true, true);
            }
        }
    }

    private void q() {
        this.y = new com.baidu.tieba.model.ba();
        this.y.setLoadDataCallBack(new x(this));
    }

    private void r() {
        this.z = new cg();
        this.z.setLoadDataCallBack(new y(this));
    }

    private void s() {
        this.F = new com.baidu.tieba.model.x();
        this.F.setLoadDataCallBack(new z(this));
    }

    private void t() {
        this.A = new aa(this);
    }

    private void u() {
        this.E.a(com.baidu.tieba.mention.t.a().n());
        this.E.c(com.baidu.tieba.mention.t.a().l());
        this.E.b(com.baidu.tieba.mention.t.a().m());
        this.E.d(com.baidu.tieba.mention.t.a().o());
        this.o.a(this.E);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        this.o.a().a(this.F.a());
    }

    private void w() {
        if (this.D == null) {
            this.D = new b(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.tieba.broadcast.notify");
            registerReceiver(this.D, intentFilter);
        }
    }

    private boolean x() {
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
                        intent.putExtra("fname", getIntent().getStringExtra(SocialConstants.PARAM_MEDIA_UNAME));
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
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        if (this.D != null) {
            unregisterReceiver(this.D);
        }
        if (this.K != null) {
            this.K.removeCallbacks(this.M);
        }
        if (this.A != null) {
            this.A.removeMessages(1);
        }
        super.onDestroy();
        try {
            if (this.x != null) {
                this.x.g();
            }
            if (this.y != null) {
                this.y.a();
            }
            if (this.z != null) {
                this.z.a();
            }
            if (this.F != null) {
                this.F.cancelLoadData();
            }
            this.o.w();
            System.gc();
        } catch (Exception e) {
            com.baidu.tieba.util.be.b(getClass().getName(), "onDestroy", e.getMessage());
        }
        this.b = g_();
        this.b.g(this);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(SocialConstants.PARAM_MEDIA_UNAME, this.e);
        bundle.putString("from", this.f);
        this.b = g_();
        if (this.b != null) {
            this.b.e(this);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        boolean z;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    e(0);
                    return;
                case 11002:
                    n();
                    return;
                case 11011:
                    c(this.q);
                    return;
                case 11012:
                    d(this.H);
                    return;
                case 11013:
                    B();
                    return;
                case 11014:
                    o();
                    return;
                case 11016:
                    this.o.s();
                    return;
                case 11021:
                    if (this.x != null) {
                        f();
                        return;
                    }
                    return;
                case 11033:
                default:
                    return;
                case 12001:
                    if (this.x != null && this.x.a() != null) {
                        WriteImageActivity.a(this, 12001, 12010, null, this.x.a().getId(), this.e, this.x.c());
                        return;
                    }
                    return;
                case 12002:
                    if (this.x != null && this.x.a() != null && intent != null && intent.getData() != null) {
                        WriteImageActivity.a(this, 12002, 12009, intent.getData(), this.x.a().getId(), this.e, this.x.c());
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    if (this.x != null && this.x.a() != null) {
                        if (intent == null || intent.getStringExtra("filename") == null) {
                            WriteActivity.a((Activity) this, this.x.a().getId(), this.e, (AntiData) null, true, (String) null);
                            return;
                        } else {
                            WriteActivity.a((Activity) this, this.x.a().getId(), this.e, (AntiData) null, true, intent.getStringExtra("filename"));
                            return;
                        }
                    }
                    return;
                case 13003:
                    C();
                    return;
                case 18003:
                    this.o.h().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null) {
                        int size = this.x.b().size();
                        int i3 = 0;
                        while (true) {
                            if (i3 >= size) {
                                z = false;
                            } else if (stringExtra.equals(this.x.b().get(i3).a())) {
                                z = true;
                            } else {
                                i3++;
                            }
                        }
                        if (z) {
                            int intExtra = intent.getIntExtra("type", 0);
                            if (intExtra == 2) {
                                this.x.b().get(i3).b(intent.getIntExtra("good_data", 0));
                                this.x.b().get(i3).a(intent.getIntExtra("top_data", 0));
                                this.x.b().get(i3).p();
                                C();
                                return;
                            } else if (intExtra == 0) {
                                this.x.b().remove(i3);
                                this.o.u();
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12009:
                    com.baidu.tieba.write.bg.b(this);
                    return;
                case 12010:
                    com.baidu.tieba.write.bg.a(this);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        NetworkInfo activeNetworkInfo;
        super.onResume();
        NoNetworkView e = this.o.e();
        if (e != null && e.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            e.setVisible(false);
        }
        if (f1243a) {
            f1243a = false;
            this.o.A();
            return;
        }
        if (!this.l && TiebaApplication.D()) {
            this.l = true;
            if (this.x != null && this.x.c() != null) {
                this.x.c().setIfpost(1);
            }
            this.F.a(false, true, true);
            C();
        }
        this.o.a().a(this.l);
        this.M.run();
        if (this.A != null) {
            this.A.removeMessages(1);
            this.A.sendMessageDelayed(this.A.obtainMessage(1), 1000L);
        }
        this.b = g_();
        this.b.c(this);
        com.baidu.tieba.im.pushNotify.a.g().b(false, (com.baidu.tieba.im.a<Void>) null);
    }

    @Override // com.baidu.tieba.j
    public void h() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
            return;
        }
        String C = TiebaApplication.C();
        if (C != null && C.length() > 0) {
            MainTabActivity.a(this, 1);
        } else {
            MainTabActivity.a(this, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        this.o.w();
        finish();
        CompatibleUtile.setAnim(this, R.anim.frs_browser_enter, R.anim.no_effect);
    }

    private void y() {
        this.c = true;
        this.e = "";
        this.f = "";
        this.g = 0;
        this.j = 1;
        this.v = false;
        this.u = 0L;
        this.d = 3;
        this.o = new ba(this, this.S);
        this.o.a().e();
        this.o.a(this.N);
        this.o.a(this.O);
        this.o.a(this.U);
        this.o.a(this.P);
        this.o.a(this.Q);
        this.o.a(this.T);
        this.o.a(this.R);
        this.o.a(this.V);
        this.o.a(this.W);
        this.o.a(this.Y);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void a(int i) {
        super.a(i);
        this.o.h(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        this.o.x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.adp.widget.ImageView.e eVar, boolean z) {
        if (eVar != null) {
            this.o.a(eVar, z);
            this.o.y().setOnDismissListener(new e(this));
            this.o.y().setOnCancelListener(new f(this));
            a(0.3f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        if (this.L != null) {
            this.L.b();
        }
        a(1.0f);
        this.o.z();
    }

    private void a(float f) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = f;
        getWindow().setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        String C = TiebaApplication.C();
        if (C == null || C.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11013);
            return;
        }
        CreateBarActivity.a(this, this.e, true);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        Intent a2;
        if (str != null && (a2 = a((Context) this, str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", str + getString(R.string.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", a2);
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this, R.drawable.icon));
            sendBroadcast(intent);
            new com.baidu.tieba.account.ah("add_to_launcher").start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i) {
        String C = TiebaApplication.C();
        if (C == null || C.length() <= 0) {
            if (this.x != null && this.x.c() != null) {
                this.x.c().setIfpost(1);
            }
            if (i == 0) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11001);
            } else {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11016);
            }
        } else if (this.x != null) {
            if (i == 0) {
                WriteActivity.a((Activity) this, this.x.a().getId(), this.e, this.x.c(), false, (String) null);
            } else {
                this.o.s();
            }
        }
    }

    private boolean a(com.baidu.tieba.data.bf bfVar) {
        String id;
        return bfVar == null || bfVar.g() == null || (id = bfVar.g().getId()) == null || id.equals(SocialConstants.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.data.bf bfVar) {
        boolean a2 = a(bfVar);
        this.o.a(new g(this, bfVar));
        this.o.a(bfVar, a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.data.bf bfVar) {
        boolean a2 = a(bfVar);
        if (this.m != null) {
            if (!a2) {
                NewPbActivity.a(this, bfVar, null, 18003, true, true, this.n);
            } else {
                NewPbActivity.a(this, bfVar, null, 18003, false, false, this.n);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.data.bf bfVar) {
        if (this.m != null) {
            NewPbActivity.a(this, bfVar, null, 18003, false, false, this.n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        H();
        this.j = 1;
        this.d = 3;
        D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        BasicNameValuePair basicNameValuePair;
        boolean z = true;
        switch (this.d) {
            case 1:
                if (this.o.h().b()) {
                    return;
                }
                break;
            case 2:
                if (this.o.h().c()) {
                    return;
                }
                break;
            case 3:
                if (this.o.g()) {
                    return;
                }
                break;
        }
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append(com.baidu.tieba.data.h.f1165a);
        stringBuffer.append("c/f/frs/page");
        ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
        arrayList.add(new BasicNameValuePair("kw", this.e));
        arrayList.add(new BasicNameValuePair("pn", String.valueOf(this.j)));
        if (TiebaApplication.g().ar()) {
            basicNameValuePair = new BasicNameValuePair("rn", String.valueOf(35));
        } else {
            basicNameValuePair = new BasicNameValuePair("rn", String.valueOf(50));
        }
        arrayList.add(basicNameValuePair);
        arrayList.add(new BasicNameValuePair("with_group", SocialConstants.TRUE));
        if (this.v) {
            arrayList.add(new BasicNameValuePair("is_good", SocialConstants.TRUE));
            arrayList.add(new BasicNameValuePair("cid", String.valueOf(this.u)));
        }
        int a2 = UtilHelper.a((Context) this);
        int b = UtilHelper.b((Context) this);
        float f = getResources().getDisplayMetrics().density;
        if (!com.baidu.tieba.util.bd.a().b()) {
            a2 = (int) (a2 * 0.4d);
            b = (int) (b * 0.4d);
        }
        int i = com.baidu.tieba.util.bd.a().d().equals("80") ? 2 : 1;
        arrayList.add(new BasicNameValuePair("scr_w", String.valueOf(a2)));
        arrayList.add(new BasicNameValuePair("scr_h", String.valueOf(b)));
        arrayList.add(new BasicNameValuePair("scr_dip", String.valueOf(f)));
        arrayList.add(new BasicNameValuePair("q_type", String.valueOf(i)));
        if (this.p != null) {
            arrayList.add(new BasicNameValuePair("st_type", this.p));
        }
        if (r != 0) {
            arrayList.add(new BasicNameValuePair("ctime", String.valueOf(r)));
        }
        if (s != 0) {
            arrayList.add(new BasicNameValuePair("data_size", String.valueOf(s)));
        }
        if (t != 0) {
            arrayList.add(new BasicNameValuePair("net_error", String.valueOf(t)));
        }
        this.o.b(true);
        this.o.h().c(false);
        this.o.h().d(false);
        this.o.h().notifyDataSetChanged();
        if (this.j != 1 || ((!this.C.equals("normal_page") && !this.C.equals("frs_page")) || this.v)) {
            z = false;
        }
        if (this.x == null) {
            this.x = new com.baidu.tieba.model.ak();
        }
        this.x.a(this.I);
        this.x.a(stringBuffer.toString(), arrayList, this.d, z, this.e);
    }

    private void E() {
        switch (this.g) {
            case 1:
                DatabaseService.l(this.e);
                break;
        }
        this.g = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        H();
        try {
            if (this.x != null) {
                this.o.k();
                this.e = this.x.a().getName();
                this.o.c(this.e);
                E();
                this.c = false;
                ArrayList<com.baidu.tieba.data.bf> b = this.x.b();
                if (b != null) {
                    this.o.a(b, this.x, this.j);
                    if (this.C.equals("frs_page")) {
                        G();
                    } else if (this.C.equals("normal_page")) {
                        this.o.a(this.x.a());
                    }
                    this.o.b(this.j);
                    this.o.c(this.x.d().f());
                    this.o.u();
                    if (this.x.h() == 1) {
                        this.o.h().a().d(true);
                    } else {
                        this.o.h().a().d(false);
                    }
                    if (this.d == 1) {
                        this.o.d(3);
                    } else if (this.d == 2) {
                        if (this.j == 1) {
                            this.o.d(0);
                        } else {
                            this.o.d(3);
                        }
                    } else {
                        this.o.d(0);
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.be.b(getClass().getName(), "", "FrsActivity.refreshFrs error = " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        this.o.v();
        if (this.A != null) {
            this.A.removeMessages(1);
        }
        this.b = g_();
        this.b.d(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onStop() {
        super.onStop();
        this.b = g_();
        if (this.b != null) {
            this.b.f(this);
        }
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.k) {
            if (i == 4) {
                if (this.o.b().isMenuShowing()) {
                    this.o.b().toggle(true);
                    if (this.o.a().h()) {
                        this.o.a().b(false);
                        C();
                        return true;
                    }
                    return true;
                }
                h();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    private void G() {
        this.o.a(this.x.a(), this.x.e());
        this.A.removeMessages(1);
        if (this.j == 1 && this.C.equals("frs_page") && this.x.e().h() == 0) {
            this.B = System.nanoTime() / 1000000000;
            if (this.x.e().i() > 0) {
                this.A.sendMessageDelayed(this.A.obtainMessage(1), 1000L);
            }
        }
    }

    public void f() {
        String C = TiebaApplication.C();
        if (C == null || C.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11021);
        } else if (!this.x.f()) {
            this.x.a(true);
            this.x.a(this.J);
            this.x.b(String.valueOf(this.x.a().isLike()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n() {
        String C = TiebaApplication.C();
        if (C == null || C.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11002);
            return;
        }
        this.o.c(true);
        this.y.a("from_frs");
        this.y.a(this.x.a().getName(), this.x.a().getId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o() {
        String C = TiebaApplication.C();
        if (C == null || C.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11014);
            return;
        }
        this.o.c(true);
        this.z.a(this.x.a().getName(), this.x.a().getId());
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.o.a().f()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                if (TiebaApplication.g().as() != 1) {
                    if (TiebaApplication.g().s()) {
                        StatService.onEvent(this, "frs_night_mode", "frsclick", 1);
                    }
                    TiebaApplication.g().i(1);
                    this.i = 1;
                    new com.baidu.tieba.account.ah("eyeshield").start();
                } else {
                    return;
                }
            } else if (TiebaApplication.g().as() != 0) {
                TiebaApplication.g().i(0);
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
        this.G = false;
        if (str != null) {
            if (TiebaApplication.g().g(str)) {
                FrsImageActivity.a(this, str, null, 0);
                e();
                return;
            }
            if (this.o.b().isMenuShowing()) {
                this.o.b().toggle(true);
            }
            this.v = false;
            this.o.a().a(R.id.show_all);
            this.e = str;
            C();
        }
    }

    @Override // com.baidu.tieba.voice.ag
    public VoiceManager g_() {
        if (this.b == null) {
            this.b = VoiceManager.c();
        }
        return this.b;
    }

    @Override // com.baidu.tieba.voice.ag
    public com.baidu.tieba.voice.ae a(VoiceManager.VoiceModel voiceModel) {
        return null;
    }

    private void H() {
        this.b = g_();
        this.b.g();
    }
}
