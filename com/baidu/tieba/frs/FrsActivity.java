package com.baidu.tieba.frs;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
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
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.mobstat.StatService;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.home.CreateBarActivity;
import com.baidu.tieba.model.cc;
import com.baidu.tieba.model.ci;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.util.AntiHelper;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.UserIconBox;
import com.baidu.tieba.voice.VoiceManager;
import com.baidu.tieba.write.WriteActivity;
import com.baidu.tieba.write.WriteImageActivity;
import com.slidingmenu.lib.R;
import com.slidingmenu.lib.SlidingMenu;
import com.tencent.mm.sdk.conversation.RConversation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class FrsActivity extends com.baidu.tieba.j implements com.baidu.adp.widget.BdSwitchView.c, com.baidu.tbadk.widget.a, com.baidu.tieba.view.bu, com.baidu.tieba.voice.af {
    private com.baidu.tieba.model.ap E;
    private com.baidu.tieba.model.x F;
    private br I;
    VoiceManager c;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f1300a = false;
    private static volatile long q = 0;
    private static volatile long r = 0;
    private static volatile int s = 0;
    private static boolean R = false;
    private boolean d = true;
    private int e = 3;
    private String f = null;
    private String g = null;
    private int h = 0;
    private int i = 1;
    private boolean j = false;
    private boolean k = false;
    private String l = null;
    private boolean m = false;
    private bn n = null;
    private String o = null;
    private com.baidu.tieba.data.ba p = null;
    private long t = 0;
    private boolean u = false;
    private boolean v = true;
    private com.baidu.tieba.model.ak w = null;
    private com.baidu.tieba.model.ax x = null;
    private ci y = null;
    private cc z = null;
    private Handler A = null;
    private long B = 0;
    private String C = "normal_page";
    private BroadcastReceiver D = null;
    private boolean G = false;
    private com.baidu.tieba.data.ba H = null;
    private com.baidu.adp.lib.d.b<TbImageView> J = UserIconBox.a(this, 8);
    private boolean K = false;
    private ag L = new b(this);
    private af M = new n(this);
    private Handler N = null;
    private com.baidu.tieba.util.i O = null;
    private Runnable P = new y(this);
    com.baidu.tbadk.imageManager.c b = new z(this);
    private com.baidu.tbadk.imageManager.c Q = new aa(this);
    private com.baidu.adp.widget.ListView.r S = new e(this);
    private com.baidu.adp.widget.ListView.s T = new f(this);
    private AdapterView.OnItemClickListener U = new j(this);
    private AdapterView.OnItemLongClickListener V = new l(this);
    private com.baidu.adp.widget.ListView.b W = new m(this);
    private View.OnClickListener X = new o(this);
    private int Y = 0;
    private AbsListView.OnScrollListener Z = new p(this);
    private View.OnClickListener aa = new q(this);
    private SlidingMenu.OnClosedListener ab = new u(this);
    private SlidingMenu.OnOpenedListener ac = new v(this);
    private AdapterView.OnItemClickListener ad = new w(this);
    private com.baidu.tieba.view.az ae = new x(this);
    private List<com.baidu.tbadk.widget.b> af = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int i(FrsActivity frsActivity) {
        int i = frsActivity.i;
        frsActivity.i = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int x(FrsActivity frsActivity) {
        int i = frsActivity.i;
        frsActivity.i = i + 1;
        return i;
    }

    @Override // com.baidu.tieba.j
    public boolean getGpuSwitch() {
        return TiebaApplication.g().u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.an anVar) {
        if (this.d) {
            if (anVar != null) {
                if (anVar.f1894a && anVar.b) {
                    if (anVar.c == 3) {
                        this.j = false;
                        this.f = this.f.replace(" ", "");
                        String str = this.f;
                        if (str.length() > 31) {
                            str = str.substring(0, 31) + "...";
                        }
                        this.n.b(str);
                    } else if (UtilHelper.i(this) != UtilHelper.NetworkStateInfo.UNAVAIL) {
                        this.n.a(anVar.d);
                    }
                } else if (UtilHelper.i(this) != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    this.n.a(anVar.d);
                }
            }
        } else if (anVar != null) {
            this.n.a(anVar.d);
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
        com.baidu.tieba.data.ba b = this.n.m().b();
        if (b != null) {
            ArrayList<com.baidu.tieba.data.aj> p = b.p();
            int size = p.size();
            for (int i = 0; i < size; i++) {
                if (p.get(i).a() == 3) {
                    this.n.m().a().a(p.get(i).b(), this.Q);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        com.baidu.tieba.data.ba b = this.n.n().b();
        if (b != null) {
            ArrayList<com.baidu.tieba.data.aj> p = b.p();
            int size = p.size();
            for (int i = 0; i < size; i++) {
                if (p.get(i).a() == 3) {
                    this.n.n().a().a(p.get(i).b(), this.Q);
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

    private void m() {
        int i = BdWebErrorView.ERROR_CODE_400;
        this.O = new com.baidu.tieba.util.i(this);
        this.O.b(true);
        int a2 = UtilHelper.a((Context) this, 267.0f);
        if (a2 <= 400) {
            i = a2;
        }
        this.O.a(i, (int) (i * 1.62f));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (v()) {
            this.c = g();
            this.c.a((Activity) this);
            w();
            a(bundle);
            this.n.I();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.c = g();
        this.c.b((Activity) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.ak akVar) {
        if (akVar != null) {
            try {
                if (this.v) {
                    this.n.z();
                    this.v = false;
                }
                if (akVar.i() == 1) {
                    this.n.l().f(true);
                } else {
                    this.n.l().f(false);
                }
                if (akVar.f().a() == 1) {
                    this.C = "frs_page";
                    this.n.r();
                } else {
                    this.C = "normal_page";
                    this.n.q();
                }
                if (!com.baidu.tieba.model.z.a().c(TiebaApplication.A() + this.f)) {
                    akVar.a().getSignData().setIsSigned(0);
                }
                this.n.o();
                this.f = akVar.a().getName();
                this.n.c(this.f);
                C();
                com.baidu.tieba.data.bc top_notice_data = akVar.a().getTop_notice_data();
                if (top_notice_data != null && top_notice_data.a() != null) {
                    com.baidu.tieba.data.ba baVar = new com.baidu.tieba.data.ba();
                    baVar.c(top_notice_data.a());
                    baVar.a(2);
                    baVar.b(top_notice_data.b());
                    baVar.t();
                    akVar.b().add(0, baVar);
                }
                ArrayList<com.baidu.tieba.data.ba> b = akVar.b();
                if (b != null) {
                    this.n.a(b, this.i, this.w);
                    if (this.C.equals("frs_page")) {
                        this.n.a(akVar.a(), akVar);
                    } else if (this.C.equals("normal_page")) {
                        this.n.b(akVar.a(), akVar);
                    }
                    this.n.b(this.i);
                    this.n.c(akVar.e().f());
                    this.n.C();
                    this.n.d(0);
                }
                if (akVar.i() == 1) {
                    this.n.l().a().d(true);
                } else {
                    this.n.l().a().d(false);
                }
                this.N.removeCallbacks(this.P);
                this.N.postDelayed(this.P, 300L);
            } catch (Exception e) {
                com.baidu.tieba.util.bg.b("FrsActivity", "refreshWithCache", "FrsActivity.refreshWithFrs error = " + e.getMessage());
            }
        }
    }

    private void a(Bundle bundle) {
        this.N = new Handler();
        m();
        this.k = TiebaApplication.B();
        if (bundle != null) {
            this.f = bundle.getString(SocialConstants.PARAM_MEDIA_UNAME);
            this.g = bundle.getString("from");
            this.h = bundle.getInt(RConversation.COL_FLAG, 0);
        } else {
            Intent intent = getIntent();
            this.f = intent.getStringExtra(SocialConstants.PARAM_MEDIA_UNAME);
            this.g = intent.getStringExtra("from");
            this.h = intent.getIntExtra(RConversation.COL_FLAG, 0);
            this.u = intent.getBooleanExtra("good", false);
        }
        if (this.f != null && this.f.length() > 0) {
            if (this.g == null || this.g.length() <= 0) {
                this.g = "tb_forumlist";
            }
            this.o = this.g;
            this.G = false;
            r();
            n();
            o();
            p();
            q();
            this.E = new com.baidu.tieba.model.ap(this);
            if (this.k) {
                s();
                u();
                this.F.a(false, true, true);
            }
        }
    }

    private void n() {
        this.x = new com.baidu.tieba.model.ax();
        this.x.setLoadDataCallBack(new ab(this));
    }

    private void o() {
        this.y = new ci();
        this.y.a("from_frs");
        this.y.a(new ac(this));
    }

    private void p() {
        this.z = new cc();
        this.z.setLoadDataCallBack(new ad(this));
    }

    private void q() {
        this.F = new com.baidu.tieba.model.x();
        this.F.setLoadDataCallBack(new ae(this));
    }

    private void r() {
        this.A = new c(this);
    }

    private void s() {
        this.E.a(com.baidu.tieba.mention.t.a().n());
        this.E.c(com.baidu.tieba.mention.t.a().l());
        this.E.b(com.baidu.tieba.mention.t.a().m());
        this.E.d(com.baidu.tieba.mention.t.a().o());
        this.n.a(this.E);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        this.n.e().a(this.F.a());
    }

    private void u() {
        if (this.D == null) {
            this.D = new d(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.tieba.broadcast.notify");
            registerReceiver(this.D, intentFilter);
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
        if (this.N != null) {
            this.N.removeCallbacks(this.P);
        }
        if (this.A != null) {
            this.A.removeMessages(1);
        }
        super.onDestroy();
        try {
            if (this.w != null) {
                this.w.h();
            }
            if (this.x != null) {
                this.x.a();
            }
            if (this.z != null) {
                this.z.a();
            }
            if (this.F != null) {
                this.F.cancelLoadData();
            }
            this.n.E();
            System.gc();
        } catch (Exception e) {
            com.baidu.tieba.util.bg.b("FrsActivity", "onDestroy", e.getMessage());
        }
        this.c = g();
        this.c.g(this);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(SocialConstants.PARAM_MEDIA_UNAME, this.f);
        bundle.putString("from", this.g);
        this.c = g();
        if (this.c != null) {
            this.c.e(this);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        boolean z;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    b(0);
                    return;
                case 11002:
                    h();
                    return;
                case 11011:
                    break;
                case 11012:
                    d(this.H);
                    return;
                case 11013:
                    z();
                    return;
                case 11014:
                    j();
                    return;
                case 11016:
                    this.n.A();
                    return;
                case 11021:
                    if (this.w != null) {
                        f();
                        return;
                    }
                    return;
                case 11033:
                default:
                    return;
                case 11036:
                    i();
                    break;
                case 12001:
                    if (this.w != null && this.w.a() != null) {
                        WriteImageActivity.a(this, 12001, 12010, null, this.w.a().getId(), this.f, this.w.d());
                        return;
                    }
                    return;
                case 12002:
                    if (this.w != null && this.w.a() != null && intent != null && intent.getData() != null) {
                        WriteImageActivity.a(this, 12002, 12009, intent.getData(), this.w.a().getId(), this.f, this.w.d());
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    if (this.w != null && this.w.a() != null) {
                        if (intent == null || intent.getStringExtra("filename") == null) {
                            WriteActivity.a((Activity) this, this.w.a().getId(), this.f, (AntiData) null, true, (String) null);
                            return;
                        } else {
                            WriteActivity.a((Activity) this, this.w.a().getId(), this.f, (AntiData) null, true, intent.getStringExtra("filename"));
                            return;
                        }
                    }
                    return;
                case 13003:
                    A();
                    return;
                case 18003:
                    this.n.l().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null) {
                        int size = this.w.b().size();
                        int i3 = 0;
                        while (true) {
                            if (i3 >= size) {
                                z = false;
                            } else if (stringExtra.equals(this.w.b().get(i3).a())) {
                                z = true;
                            } else {
                                i3++;
                            }
                        }
                        if (z) {
                            int intExtra = intent.getIntExtra("type", 0);
                            if (intExtra == 2) {
                                this.w.b().get(i3).b(intent.getIntExtra("good_data", 0));
                                this.w.b().get(i3).a(intent.getIntExtra("top_data", 0));
                                this.w.b().get(i3).t();
                                A();
                                return;
                            } else if (intExtra == 0) {
                                this.w.b().remove(i3);
                                this.n.C();
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    return;
            }
            c(this.p);
        } else if (i2 == 0) {
            switch (i) {
                case 12009:
                    com.baidu.tieba.write.bc.c(this);
                    return;
                case 12010:
                    com.baidu.tieba.write.bc.a(this);
                    return;
                default:
                    return;
            }
        }
    }

    public static void a(boolean z) {
        R = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        NetworkInfo activeNetworkInfo;
        super.onResume();
        this.Y = 0;
        NoNetworkView i = this.n.i();
        if (i != null && i.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            i.setVisible(false);
        }
        if (R) {
            R = false;
            this.n.I();
        } else if (f1300a) {
            f1300a = false;
            this.n.I();
        } else {
            if (!this.k && TiebaApplication.B()) {
                this.k = true;
                if (this.w != null && this.w.d() != null) {
                    this.w.d().setIfpost(1);
                }
                this.F.a(false, true, true);
                A();
            }
            this.n.e().a(this.k);
            this.P.run();
            if (this.A != null) {
                this.A.removeMessages(1);
                this.A.sendMessageDelayed(this.A.obtainMessage(1), 1000L);
            }
            this.c = g();
            this.c.c(this);
        }
    }

    @Override // com.baidu.tieba.j
    public void closeActivity() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
            return;
        }
        String A = TiebaApplication.A();
        if (A != null && A.length() > 0) {
            MainTabActivity.a(this, 1);
        } else {
            MainTabActivity.a(this, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        this.n.E();
        finish();
        CompatibleUtile.setAnim(this, R.anim.frs_browser_enter, R.anim.no_effect);
    }

    private void w() {
        this.d = true;
        this.f = "";
        this.g = "";
        this.h = 0;
        this.i = 1;
        this.u = false;
        this.t = 0L;
        this.e = 3;
        this.n = new bn(this, this.X);
        this.n.e().e();
        this.n.a(this.S);
        this.n.a(this.T);
        this.n.a(this.U);
        this.n.a(this.V);
        this.n.a(this.Z);
        this.n.a(this.W);
        this.n.a(this.ab);
        this.n.a(this.ac);
        this.n.a(this.ae);
        if (com.baidu.tieba.sharedPref.b.a().a("frs_first_in", true)) {
            this.I = new br(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.n.j(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        this.n.F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.adp.widget.ImageView.e eVar, boolean z) {
        if (eVar != null) {
            this.n.a(eVar, z);
            this.n.G().setOnDismissListener(new g(this));
            this.n.G().setOnCancelListener(new h(this));
            a(0.3f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (this.O != null) {
            this.O.b();
        }
        a(1.0f);
        this.n.H();
    }

    private void a(float f) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = f;
        getWindow().setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        String A = TiebaApplication.A();
        if (A == null || A.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11013);
            return;
        }
        CreateBarActivity.a(this, this.f, true);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Intent a2;
        if (str != null && (a2 = a((Context) this, str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", str + getString(R.string.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", a2);
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this, R.drawable.icon));
            sendBroadcast(intent);
            new com.baidu.tieba.account.ag("add_to_launcher").start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        String A = TiebaApplication.A();
        if (A == null || A.length() <= 0) {
            if (this.w != null && this.w.d() != null) {
                this.w.d().setIfpost(1);
            }
            if (i == 0) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11001);
            } else {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11016);
            }
        } else if (this.w != null) {
            if (i == 0) {
                AntiData d = this.w.d();
                if (AntiHelper.a(d) || AntiHelper.b(d) || AntiHelper.c(d)) {
                    d.setBlock_forum_name(this.f);
                    d.setBlock_forum_id(this.w.a().getId());
                    d.setUser_name(this.w.c().getName());
                    d.setUser_id(this.w.c().getId());
                    if (AntiHelper.a(this, d, AntiHelper.OperationType.CREATE_THREAD, AntiHelper.PageType.FRS)) {
                        return;
                    }
                }
                WriteActivity.a((Activity) this, this.w.a().getId(), this.f, this.w.d(), false, (String) null);
                return;
            }
            this.n.A();
        }
    }

    private boolean a(com.baidu.tieba.data.ba baVar) {
        String id;
        return baVar == null || baVar.j() == null || (id = baVar.j().getId()) == null || id.equals(SocialConstants.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.data.ba baVar) {
        boolean a2 = a(baVar);
        this.n.a(new i(this, baVar));
        this.n.a(baVar, a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.data.ba baVar) {
        boolean a2 = a(baVar);
        if (this.l != null) {
            if (!a2) {
                NewPbActivity.a(this, baVar, this.f, null, 18003, true, true, this.m);
            } else {
                NewPbActivity.a(this, baVar, this.f, null, 18003, false, false, this.m);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.data.ba baVar) {
        if (this.l != null) {
            NewPbActivity.a(this, baVar, this.f, null, 18003, false, false, this.m);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        F();
        this.i = 1;
        this.e = 3;
        B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        BasicNameValuePair basicNameValuePair;
        boolean z = false;
        switch (this.e) {
            case 1:
                if (this.n.l().b()) {
                    return;
                }
                break;
            case 2:
                if (this.n.l().c()) {
                    return;
                }
                break;
            case 3:
                if (this.n.k()) {
                    return;
                }
                break;
        }
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append(com.baidu.tieba.data.h.f1196a);
        stringBuffer.append("c/f/frs/page");
        ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
        arrayList.add(new BasicNameValuePair("kw", this.f));
        arrayList.add(new BasicNameValuePair("pn", String.valueOf(this.i)));
        if (com.baidu.tieba.d.a.a().f()) {
            basicNameValuePair = new BasicNameValuePair("rn", String.valueOf(35));
        } else {
            basicNameValuePair = new BasicNameValuePair("rn", String.valueOf(50));
        }
        arrayList.add(basicNameValuePair);
        arrayList.add(new BasicNameValuePair("with_group", SocialConstants.TRUE));
        if (this.u) {
            arrayList.add(new BasicNameValuePair("is_good", SocialConstants.TRUE));
            arrayList.add(new BasicNameValuePair("cid", String.valueOf(this.t)));
        }
        int a2 = UtilHelper.a((Context) this);
        int b = UtilHelper.b((Context) this);
        float f = a2 / 320.0f;
        int i = com.baidu.tieba.util.bf.a().b() ? 2 : 1;
        arrayList.add(new BasicNameValuePair("scr_w", String.valueOf(a2)));
        arrayList.add(new BasicNameValuePair("scr_h", String.valueOf(b)));
        arrayList.add(new BasicNameValuePair("scr_dip", String.valueOf(f)));
        arrayList.add(new BasicNameValuePair("q_type", String.valueOf(i)));
        if (this.o != null) {
            arrayList.add(new BasicNameValuePair("st_type", this.o));
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
        this.n.b(true);
        this.n.l().b(false);
        this.n.l().c(false);
        this.n.l().notifyDataSetChanged();
        if (this.i == 1 && ((this.C.equals("normal_page") || this.C.equals("frs_page")) && !this.u)) {
            z = true;
        }
        if (this.w == null) {
            this.w = new com.baidu.tieba.model.ak();
        }
        this.w.a(this.L);
        this.w.a(stringBuffer.toString(), arrayList, this.e, z, this.f);
    }

    private void C() {
        switch (this.h) {
            case 1:
                DatabaseService.m(this.f);
                break;
        }
        this.h = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        F();
        try {
            if (this.w != null) {
                this.n.o();
                this.f = this.w.a().getName();
                this.n.c(this.f);
                this.n.e().c(this.w.a().isLike() != 0);
                C();
                this.d = false;
                ArrayList<com.baidu.tieba.data.ba> b = this.w.b();
                if (b != null) {
                    this.n.a(b, this.i, this.w);
                    if (this.C.equals("frs_page")) {
                        E();
                    } else if (this.C.equals("normal_page")) {
                        this.n.b(this.w.a(), this.w);
                    }
                    this.n.b(this.i);
                    this.n.c(this.w.e().f());
                    this.n.C();
                    if (this.w.i() == 1) {
                        this.n.l().f(true);
                    } else {
                        this.n.l().f(false);
                    }
                    if (this.e == 1) {
                        this.n.d(3);
                    } else if (this.e == 2) {
                        if (this.i == 1) {
                            this.n.d(0);
                        } else {
                            this.n.d(3);
                        }
                    } else {
                        this.n.d(0);
                    }
                    this.N.removeCallbacks(this.P);
                    this.N.postDelayed(this.P, 300L);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.bg.b("FrsActivity", "", "FrsActivity.refreshFrs error = " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        this.n.D();
        if (this.A != null) {
            this.A.removeMessages(1);
        }
        this.c = g();
        this.c.d(this);
        if (this.af != null) {
            this.af.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onStop() {
        super.onStop();
        this.c = g();
        if (this.c != null) {
            this.c.f(this);
        }
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.j) {
            if (i == 4) {
                if (this.n.f().isMenuShowing()) {
                    this.n.f().toggle(true);
                    if (this.n.e().g()) {
                        this.n.e().b(false);
                        A();
                        return true;
                    }
                    return true;
                }
                closeActivity();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    private void E() {
        this.n.a(this.w.a(), this.w);
        this.A.removeMessages(1);
        if (this.i == 1 && this.C.equals("frs_page") && this.w.f().f() == 0) {
            this.B = System.nanoTime() / 1000000000;
            if (this.w.f().g() > 0) {
                this.A.sendMessageDelayed(this.A.obtainMessage(1), 1000L);
            }
        }
    }

    public void f() {
        String A = TiebaApplication.A();
        if (A == null || A.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11021);
        } else if (!this.w.g()) {
            this.w.a(true);
            this.w.a(this.M);
            this.w.b(String.valueOf(this.w.a().isLike()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h() {
        String A = TiebaApplication.A();
        if (A == null || A.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11002);
            return;
        }
        this.x.a("from_frs");
        this.x.a(this.w.a().getName(), this.w.a().getId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.attention_cancel_info));
        builder.setTitle(getString(R.string.alerm_title));
        builder.setPositiveButton(getString(R.string.attention_cancel), new s(this));
        builder.setNegativeButton(getString(R.string.cancel), new t(this));
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        String A = TiebaApplication.A();
        if (A == null || A.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11014);
            return;
        }
        if (this.C.equals("normal_page")) {
            this.n.t();
        } else if (this.C.equals("frs_page")) {
            this.n.v();
        }
        this.z.a(this.w.a().getName(), this.w.a().getId());
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.n.e().f()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                if (TiebaApplication.g().ap() != 1) {
                    if (TiebaApplication.g().s()) {
                        StatService.onEvent(this, "frs_night_mode", "frsclick", 1);
                    }
                    TiebaApplication.g().f(1);
                    this.mSkinType = 1;
                    new com.baidu.tieba.account.ag("eyeshield").start();
                } else {
                    return;
                }
            } else if (TiebaApplication.g().ap() != 0) {
                TiebaApplication.g().f(0);
                this.mSkinType = 0;
            } else {
                return;
            }
            onChangeSkinType(this.mSkinType);
            com.baidu.tieba.util.m.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        this.G = false;
        if (str != null) {
            if (TiebaApplication.g().g(str)) {
                FrsImageActivity.a(this, str, null, 0);
                e();
                return;
            }
            if (this.n.f().isMenuShowing()) {
                this.n.f().toggle(true);
            }
            this.u = false;
            this.n.e().a(R.id.show_all);
            this.f = str;
            A();
        }
    }

    @Override // com.baidu.tieba.voice.af
    public VoiceManager g() {
        if (this.c == null) {
            this.c = VoiceManager.c();
        }
        return this.c;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.view.bu
    /* renamed from: k */
    public BdListView c() {
        if (this.n == null) {
            return null;
        }
        return this.n.B();
    }

    @Override // com.baidu.tieba.voice.af
    public com.baidu.tieba.voice.ad a(VoiceManager.VoiceModel voiceModel) {
        return null;
    }

    private void F() {
        this.c = g();
        this.c.g();
    }

    @Override // com.baidu.tieba.view.bu
    public int a() {
        if (this.n == null) {
            return 0;
        }
        return this.n.J();
    }

    @Override // com.baidu.tieba.view.bu
    public com.baidu.adp.lib.d.b<TbImageView> G() {
        return this.J;
    }

    @Override // com.baidu.tbadk.widget.a
    public boolean d_() {
        return this.Y == 2;
    }

    @Override // com.baidu.tbadk.widget.a
    public void a(com.baidu.tbadk.widget.b bVar) {
        if (bVar != null && !this.af.contains(bVar)) {
            this.af.add(bVar);
        }
    }

    @Override // com.baidu.tbadk.widget.a
    public void b(com.baidu.tbadk.widget.b bVar) {
        if (bVar != null) {
            this.af.remove(bVar);
        }
    }

    public void l() {
        while (this.af.size() > 0) {
            com.baidu.tbadk.widget.b remove = this.af.remove(0);
            if (remove != null) {
                remove.invalidate();
            }
        }
    }
}
