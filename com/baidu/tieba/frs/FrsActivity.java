package com.baidu.tieba.frs;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
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
import com.baidu.tieba.view.cj;
import com.baidu.tieba.voice.VoiceManager;
import com.baidu.tieba.write.WriteActivity;
import com.baidu.tieba.write.WriteImageActivity;
import com.slidingmenu.lib.R;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class FrsActivity extends com.baidu.tieba.j implements com.baidu.adp.widget.BdSwitchView.c, com.baidu.tbadk.widget.a, cj, com.baidu.tieba.voice.af {
    private com.baidu.tieba.model.ap D;
    private com.baidu.tieba.model.x E;
    private bt H;
    VoiceManager c;
    public static boolean a = false;
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
    private bo n = null;
    private String o = null;
    private com.baidu.tieba.data.bb p = null;
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
    private boolean F = false;
    private com.baidu.tieba.data.bb G = null;
    private com.baidu.adp.lib.d.b<TbImageView> I = UserIconBox.a(this, 8);
    private boolean J = false;
    private ag K = null;
    private af L = new b(this);
    private ae M = new n(this);
    private Handler N = null;
    private com.baidu.tieba.util.i O = null;
    private Runnable P = new x(this);
    com.baidu.tbadk.imageManager.c b = new y(this);
    private com.baidu.tbadk.imageManager.c Q = new z(this);
    private com.baidu.adp.widget.ListView.r S = new d(this);
    private com.baidu.adp.widget.ListView.t T = new e(this);
    private AdapterView.OnItemClickListener U = new i(this);
    private AdapterView.OnItemLongClickListener V = new k(this);
    private com.baidu.adp.widget.ListView.b W = new l(this);
    private View.OnClickListener X = new m(this);
    private int Y = 0;
    private AbsListView.OnScrollListener Z = new o(this);
    private View.OnClickListener aa = new p(this);
    private SlidingMenu.OnClosedListener ab = new t(this);
    private SlidingMenu.OnOpenedListener ac = new u(this);
    private AdapterView.OnItemClickListener ad = new v(this);
    private com.baidu.tieba.view.bf ae = new w(this);
    private List<com.baidu.tbadk.widget.b> af = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int i(FrsActivity frsActivity) {
        int i = frsActivity.i;
        frsActivity.i = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int w(FrsActivity frsActivity) {
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
                if (anVar.a && anVar.b) {
                    if (anVar.c == 3) {
                        this.j = false;
                        this.f = this.f.replace(" ", "");
                        String str = this.f;
                        if (str.length() > 31) {
                            str = str.substring(0, 31) + "...";
                        }
                        this.n.b(str);
                    } else if (UtilHelper.g(this) != UtilHelper.NetworkStateInfo.UNAVAIL) {
                        this.n.a(anVar.d);
                    }
                } else if (UtilHelper.g(this) != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    this.n.a(anVar.d);
                }
            }
        } else if (anVar != null) {
            this.n.a(anVar.d);
        }
    }

    public static void a(Context context, String str, String str2) {
        if (TiebaApplication.g().h(str)) {
            FrsImageActivity.a(context, str, str2, 0);
        } else {
            a(context, str, str2, false, false);
        }
    }

    public static void b(Context context, String str, String str2) {
        if (TiebaApplication.g().h(str)) {
            FrsImageActivity.a(context, str, str2, 0);
        } else {
            a(context, str, str2, false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        com.baidu.tieba.data.bb b = this.n.o().b();
        if (b != null) {
            ArrayList<com.baidu.tieba.data.aj> p = b.p();
            int size = p.size();
            for (int i = 0; i < size; i++) {
                if (p.get(i).a() == 3) {
                    this.n.o().a().a(p.get(i).b(), this.Q);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        com.baidu.tieba.data.bb b = this.n.p().b();
        if (b != null) {
            ArrayList<com.baidu.tieba.data.aj> p = b.p();
            int size = p.size();
            for (int i = 0; i < size; i++) {
                if (p.get(i).a() == 3) {
                    this.n.p().a().a(p.get(i).b(), this.Q);
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
        if (TiebaApplication.g().h(str)) {
            FrsImageActivity.a(context, str, str2, i);
            return;
        }
        Intent intent = new Intent(context, FrsActivity.class);
        if (str != null && str.length() > 0) {
            intent.putExtra(SocialConstants.PARAM_MEDIA_UNAME, str);
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

    private void n() {
        this.O = new com.baidu.tieba.util.i(this);
        this.O.b(true);
        int a2 = com.baidu.adp.lib.h.g.a((Context) this, 427.0f);
        int i = a2 <= 640 ? a2 : 640;
        this.O.a(i, (int) (i * 1.6f));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (w()) {
            this.c = d_();
            this.c.a((Activity) this);
            x();
            a(bundle);
            this.n.L();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.c = d_();
        this.c.b((Activity) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.ak akVar) {
        if (akVar != null) {
            try {
                if (this.v) {
                    this.n.B();
                    this.v = false;
                }
                if (akVar.i() == 1) {
                    this.n.n().f(true);
                } else {
                    this.n.n().f(false);
                }
                this.n.a(akVar.a());
                if (akVar.f().a() == 1) {
                    this.C = "frs_page";
                    this.n.t();
                } else {
                    this.C = "normal_page";
                    this.n.s();
                }
                this.n.q();
                this.f = akVar.a().getName();
                this.n.c(this.f);
                D();
                com.baidu.tieba.data.bd top_notice_data = akVar.a().getTop_notice_data();
                if (top_notice_data != null && top_notice_data.a() != null) {
                    com.baidu.tieba.data.bb bbVar = new com.baidu.tieba.data.bb();
                    bbVar.c(top_notice_data.a());
                    bbVar.a(2);
                    bbVar.b(top_notice_data.b());
                    bbVar.t();
                    akVar.b().add(0, bbVar);
                }
                ArrayList<com.baidu.tieba.data.bb> b = akVar.b();
                if (b != null) {
                    this.n.a(b, this.i, this.w);
                    if (this.C.equals("frs_page")) {
                        this.n.a(akVar.a(), akVar);
                    } else if (this.C.equals("normal_page")) {
                        this.n.b(akVar.a(), akVar);
                    }
                    this.n.b(this.i);
                    this.n.c(akVar.e().f());
                    this.n.E();
                    this.n.d(0);
                }
                if (akVar.i() == 1) {
                    this.n.n().a().d(true);
                } else {
                    this.n.n().a().d(false);
                }
                this.N.removeCallbacks(this.P);
                this.N.postDelayed(this.P, 300L);
            } catch (Exception e) {
                com.baidu.tieba.util.bo.b("FrsActivity", "refreshWithCache", "FrsActivity.refreshWithFrs error = " + e.getMessage());
            }
        }
    }

    private void a(Bundle bundle) {
        this.N = new Handler();
        n();
        this.k = TiebaApplication.B();
        if (bundle != null) {
            this.f = bundle.getString(SocialConstants.PARAM_MEDIA_UNAME);
            this.g = bundle.getString("from");
            this.h = bundle.getInt("flag", 0);
        } else {
            Intent intent = getIntent();
            this.f = intent.getStringExtra(SocialConstants.PARAM_MEDIA_UNAME);
            this.g = intent.getStringExtra("from");
            this.h = intent.getIntExtra("flag", 0);
            this.u = intent.getBooleanExtra("good", false);
        }
        if (this.f != null && this.f.length() > 0) {
            if (this.g == null || this.g.length() <= 0) {
                this.g = "tb_forumlist";
            }
            this.o = this.g;
            this.F = false;
            s();
            o();
            p();
            q();
            r();
            this.D = new com.baidu.tieba.model.ap(this);
            if (this.k) {
                f();
                u();
                this.E.a(false, true, true, this.f);
            }
        }
    }

    private void o() {
        this.x = new com.baidu.tieba.model.ax();
        this.x.setLoadDataCallBack(new aa(this));
    }

    private void p() {
        this.y = new ci();
        this.y.a("from_frs");
        this.y.a(new ab(this));
    }

    private void q() {
        this.z = new cc();
        this.z.setLoadDataCallBack(new ac(this));
    }

    private void r() {
        this.E = new com.baidu.tieba.model.x();
        this.E.setLoadDataCallBack(new ad(this));
    }

    private void s() {
        this.A = new c(this);
    }

    public void f() {
        if (this.D != null && this.n != null) {
            this.D.a(com.baidu.tieba.mention.s.a().o());
            this.D.c(com.baidu.tieba.mention.s.a().m());
            this.D.b(com.baidu.tieba.mention.s.a().n());
            this.D.d(com.baidu.tieba.mention.s.a().p());
            this.n.a(this.D);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        this.n.f().a(this.E.a());
    }

    private void u() {
        this.K = new ag(this, null);
        com.baidu.tieba.im.messageCenter.e.a().a(-124, this.K);
    }

    private void v() {
        com.baidu.tieba.im.messageCenter.e.a().a(this.K);
    }

    private boolean w() {
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
        v();
        if (this.n != null) {
            this.n.l();
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
            if (this.E != null) {
                this.E.cancelLoadData();
            }
            this.n.H();
            System.gc();
        } catch (Exception e) {
            com.baidu.tieba.util.bo.b("FrsActivity", "onDestroy", e.getMessage());
        }
        this.c = d_();
        this.c.g(this);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(SocialConstants.PARAM_MEDIA_UNAME, this.f);
        bundle.putString("from", this.g);
        this.c = d_();
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
                    i();
                    return;
                case 11011:
                    break;
                case 11012:
                    d(this.G);
                    return;
                case 11013:
                    A();
                    return;
                case 11014:
                    k();
                    return;
                case 11016:
                    this.n.C();
                    return;
                case 11021:
                    if (this.w != null) {
                        h();
                        return;
                    }
                    return;
                case 11033:
                default:
                    return;
                case 11036:
                    j();
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
                    B();
                    return;
                case 18003:
                    this.n.n().notifyDataSetChanged();
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
                                this.w.b().get(i3).t();
                                B();
                                return;
                            } else if (intExtra == 0) {
                                this.w.b().remove(i3);
                                this.n.E();
                                if (com.baidu.tieba.model.z.a() != null) {
                                    com.baidu.tieba.model.z.a().b(this.f);
                                    return;
                                }
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
                    com.baidu.tieba.write.bb.c(this);
                    return;
                case 12010:
                    com.baidu.tieba.write.bb.a(this);
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
        NoNetworkView j = this.n.j();
        if (j != null && j.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            j.setVisible(false);
        }
        if (R) {
            R = false;
            this.n.L();
        } else if (a) {
            a = false;
            this.n.L();
        } else {
            if (!this.k && TiebaApplication.B()) {
                this.k = true;
                if (this.w != null && this.w.d() != null) {
                    this.w.d().setIfpost(1);
                }
                this.E.a(false, true, true, this.f);
                B();
            }
            this.n.f().a(this.k);
            this.P.run();
            if (this.A != null) {
                this.A.removeMessages(1);
                this.A.sendMessageDelayed(this.A.obtainMessage(1), 1000L);
            }
            this.c = d_();
            this.c.c(this);
            com.baidu.tieba.im.c.a.h().b(false, (com.baidu.tieba.im.a<Void>) null);
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
    public void g() {
        this.n.H();
        finish();
        CompatibleUtile.setAnim(this, R.anim.frs_browser_enter, R.anim.no_effect);
    }

    private void x() {
        this.d = true;
        this.f = "";
        this.g = "";
        this.h = 0;
        this.i = 1;
        this.u = false;
        this.t = 0L;
        this.e = 3;
        this.n = new bo(this, this.X);
        this.n.f().e();
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
            this.H = new bt(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.n.j(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        this.n.I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.adp.widget.ImageView.d dVar, boolean z) {
        if (dVar != null) {
            this.n.a(dVar, z);
            this.n.J().setOnDismissListener(new f(this));
            this.n.J().setOnCancelListener(new g(this));
            a(0.3f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (this.O != null) {
            this.O.d();
        }
        a(1.0f);
        this.n.K();
    }

    private void a(float f) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = f;
        getWindow().setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
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
            new com.baidu.tieba.account.av("add_to_launcher").start();
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
            this.n.C();
        }
    }

    private boolean a(com.baidu.tieba.data.bb bbVar) {
        String id;
        return bbVar == null || bbVar.j() == null || (id = bbVar.j().getId()) == null || id.equals(SocialConstants.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.data.bb bbVar) {
        boolean a2 = a(bbVar);
        this.n.a(new h(this, bbVar));
        this.n.a(bbVar, a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.data.bb bbVar) {
        boolean a2 = a(bbVar);
        if (this.l != null) {
            if (!a2) {
                NewPbActivity.a(this, bbVar, this.f, null, 18003, true, true, this.m);
            } else {
                NewPbActivity.a(this, bbVar, this.f, null, 18003, false, false, this.m);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.data.bb bbVar) {
        if (this.l != null) {
            NewPbActivity.a(this, bbVar, this.f, null, 18003, false, false, this.m);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        H();
        this.i = 1;
        this.e = 3;
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        BasicNameValuePair basicNameValuePair;
        boolean z = false;
        switch (this.e) {
            case 1:
                if (this.n.n().b()) {
                    return;
                }
                break;
            case 2:
                if (this.n.n().c()) {
                    return;
                }
                break;
            case 3:
                if (this.n.m()) {
                    return;
                }
                break;
        }
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append(com.baidu.tieba.data.h.a);
        stringBuffer.append("c/f/frs/page");
        ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
        arrayList.add(new BasicNameValuePair("kw", this.f));
        arrayList.add(new BasicNameValuePair("pn", String.valueOf(this.i)));
        if (com.baidu.tieba.e.a.a().f()) {
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
        int b = com.baidu.adp.lib.h.g.b(this);
        int c = com.baidu.adp.lib.h.g.c(this);
        float f = b / 320.0f;
        int i = com.baidu.tieba.util.bn.a().b() ? 2 : 1;
        arrayList.add(new BasicNameValuePair("scr_w", String.valueOf(b)));
        arrayList.add(new BasicNameValuePair("scr_h", String.valueOf(c)));
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
        this.n.n().b(false);
        this.n.n().c(false);
        this.n.n().notifyDataSetChanged();
        if (this.i == 1 && ((this.C.equals("normal_page") || this.C.equals("frs_page")) && !this.u)) {
            z = true;
        }
        if (this.w == null) {
            this.w = new com.baidu.tieba.model.ak();
        }
        this.w.a(this.L);
        this.w.a(stringBuffer.toString(), arrayList, this.e, z, this.f);
    }

    private void D() {
        switch (this.h) {
            case 1:
                DatabaseService.m(this.f);
                break;
        }
        this.h = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        H();
        try {
            if (this.w != null) {
                this.n.q();
                this.f = this.w.a().getName();
                this.n.c(this.f);
                D();
                this.d = false;
                ArrayList<com.baidu.tieba.data.bb> b = this.w.b();
                if (b != null) {
                    this.n.a(b, this.i, this.w);
                    if (this.C.equals("frs_page")) {
                        F();
                    } else if (this.C.equals("normal_page")) {
                        this.n.b(this.w.a(), this.w);
                    }
                    this.n.b(this.i);
                    this.n.c(this.w.e().f());
                    this.n.E();
                    if (this.w.i() == 1) {
                        this.n.n().f(true);
                    } else {
                        this.n.n().f(false);
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
                    if (this.N != null && this.P != null) {
                        this.N.removeCallbacks(this.P);
                        this.N.postDelayed(this.P, 300L);
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.bo.b("FrsActivity", "", "FrsActivity.refreshFrs error = " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        this.n.G();
        if (this.A != null) {
            this.A.removeMessages(1);
        }
        this.c = d_();
        this.c.d(this);
        if (this.af != null) {
            this.af.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onStop() {
        super.onStop();
        this.c = d_();
        if (this.c != null) {
            this.c.f(this);
        }
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.j) {
            if (i == 4) {
                if (this.n.g().isMenuShowing()) {
                    this.n.g().toggle(true);
                    if (this.n.f().g()) {
                        this.n.f().b(false);
                        B();
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

    private void F() {
        this.n.a(this.w.a(), this.w);
        this.A.removeMessages(1);
        if (this.i == 1 && this.C.equals("frs_page") && this.w.f().f() == 0) {
            this.B = System.nanoTime() / 1000000000;
            if (this.w.f().g() > 0) {
                this.A.sendMessageDelayed(this.A.obtainMessage(1), 1000L);
            }
        }
    }

    public void h() {
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
    public void i() {
        String A = TiebaApplication.A();
        if (A == null || A.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11002);
            return;
        }
        this.x.a("from_frs");
        this.x.a(this.w.a().getName(), this.w.a().getId());
    }

    protected void j() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.attention_cancel_info));
        builder.setTitle(getString(R.string.alerm_title));
        builder.setPositiveButton(getString(R.string.attention_cancel), new r(this));
        builder.setNegativeButton(getString(R.string.cancel), new s(this));
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
        String A = TiebaApplication.A();
        if (A == null || A.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11014);
            return;
        }
        if (this.C.equals("normal_page")) {
            this.n.v();
        } else if (this.C.equals("frs_page")) {
            this.n.x();
        }
        this.z.a(this.w.a().getName(), this.w.a().getId());
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.n.f().f()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                if (TiebaApplication.g().an() != 1) {
                    if (TiebaApplication.g().s()) {
                        StatService.onEvent(this, "frs_night_mode", "frsclick", 1);
                    }
                    TiebaApplication.g().e(1);
                    this.mSkinType = 1;
                    new com.baidu.tieba.account.av("eyeshield").start();
                } else {
                    return;
                }
            } else if (TiebaApplication.g().an() != 0) {
                TiebaApplication.g().e(0);
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
        this.F = false;
        if (str != null) {
            if (TiebaApplication.g().h(str)) {
                FrsImageActivity.a(this, str, null, 0);
                g();
                return;
            }
            if (this.n.g().isMenuShowing()) {
                this.n.g().toggle(true);
            }
            this.u = false;
            this.n.f().a(R.id.show_all);
            this.f = str;
            B();
        }
    }

    @Override // com.baidu.tieba.voice.af
    public VoiceManager d_() {
        if (this.c == null) {
            this.c = VoiceManager.c();
        }
        return this.c;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.view.cj
    /* renamed from: l */
    public BdListView c() {
        if (this.n == null) {
            return null;
        }
        return this.n.D();
    }

    @Override // com.baidu.tieba.voice.af
    public com.baidu.tieba.voice.ad a(VoiceManager.VoiceModel voiceModel) {
        return null;
    }

    private void H() {
        this.c = d_();
        this.c.g();
    }

    @Override // com.baidu.tieba.view.cj
    public int a() {
        if (this.n == null) {
            return 0;
        }
        return this.n.M();
    }

    @Override // com.baidu.tieba.view.cj
    public com.baidu.adp.lib.d.b<TbImageView> G() {
        return this.I;
    }

    @Override // com.baidu.tbadk.widget.a
    public void a(com.baidu.tbadk.widget.b bVar) {
        if (bVar != null) {
            this.af.remove(bVar);
        }
    }

    public void m() {
        while (this.af.size() > 0) {
            com.baidu.tbadk.widget.b remove = this.af.remove(0);
            if (remove != null) {
                remove.invalidate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.im.message.o oVar) {
        if (oVar != null) {
            if (!(oVar instanceof com.baidu.tieba.im.message.r)) {
                com.baidu.adp.lib.h.e.a("transform error");
                return;
            }
            com.baidu.tieba.im.message.r rVar = (com.baidu.tieba.im.message.r) oVar;
            int c = rVar.c();
            int a2 = rVar.a();
            int b = rVar.b();
            int d = rVar.d();
            if (this.D != null) {
                this.D.a(c);
                this.D.c(a2);
                this.D.b(b);
                this.D.d(d);
                this.n.a(this.D);
            }
        }
    }
}
