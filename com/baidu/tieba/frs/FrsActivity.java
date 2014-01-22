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
import android.widget.AbsListView;
import android.widget.AdapterView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.cloudsdk.social.core.SocialConstants;
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
import com.baidu.tieba.util.bx;
import com.baidu.tieba.util.by;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.UserIconBox;
import com.baidu.tieba.view.cz;
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
public class FrsActivity extends com.baidu.tieba.j implements com.baidu.adp.widget.BdSwitchView.c, com.baidu.tbadk.widget.a, cz, com.baidu.tieba.voice.af {
    private com.baidu.tieba.model.ap D;
    private com.baidu.tieba.model.x E;
    private bp H;
    VoiceManager c;
    public static boolean a = false;
    private static volatile long q = 0;
    private static volatile long r = 0;
    private static volatile int s = 0;
    private static boolean S = false;
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
    private bk n = null;
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
    private ac K = null;
    private long L = -1;
    private ab M = new b(this);
    private aa N = new l(this);
    private Handler O = null;
    private com.baidu.tieba.util.i P = null;
    private Runnable Q = new t(this);
    com.baidu.tbadk.imageManager.c b = new u(this);
    private com.baidu.tbadk.imageManager.c R = new v(this);
    private com.baidu.adp.widget.ListView.r T = new d(this);
    private com.baidu.adp.widget.ListView.t U = new e(this);
    private AdapterView.OnItemClickListener V = new g(this);
    private AdapterView.OnItemLongClickListener W = new i(this);
    private com.baidu.adp.widget.ListView.b X = new j(this);
    private View.OnClickListener Y = new k(this);
    private int Z = 0;
    private AbsListView.OnScrollListener aa = new m(this);
    private SlidingMenu.OnClosedListener ab = new p(this);
    private SlidingMenu.OnOpenedListener ac = new q(this);
    private AdapterView.OnItemClickListener ad = new r(this);
    private com.baidu.tieba.view.br ae = new s(this);
    private List<com.baidu.tbadk.widget.b> af = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int j(FrsActivity frsActivity) {
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
        return TiebaApplication.h().u();
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
        if (TiebaApplication.h().g(str)) {
            FrsImageActivity.a(context, str, str2, 0);
        } else {
            a(context, str, str2, false, false);
        }
    }

    public static void b(Context context, String str, String str2) {
        if (TiebaApplication.h().g(str)) {
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
                    this.n.o().a().b(p.get(i).b(), this.R);
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
                    this.n.p().a().b(p.get(i).b(), this.R);
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
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            context.startActivity(intent);
        }
    }

    public static void a(Context context, String str, String str2, int i) {
        if (TiebaApplication.h().g(str)) {
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
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
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
        this.P = new com.baidu.tieba.util.i(this);
        this.P.b(true);
        int a2 = com.baidu.adp.lib.g.g.a((Context) this, 427.0f);
        int i = a2 <= 640 ? a2 : 640;
        this.P.a(i, (int) (i * 1.6f));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.L = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.L = System.currentTimeMillis();
        }
        if (w()) {
            this.c = d_();
            this.c.a((Activity) this);
            x();
            a(bundle);
            this.n.I();
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
                if (akVar.j() == 1) {
                    this.n.n().f(true);
                } else {
                    this.n.n().f(false);
                }
                this.n.a(akVar.b());
                if (akVar.g().a() == 1) {
                    this.C = "frs_page";
                    this.n.t();
                } else {
                    this.C = "normal_page";
                    this.n.s();
                }
                this.n.q();
                this.f = akVar.b().getName();
                this.n.c(this.f);
                B();
                com.baidu.tieba.data.bd top_notice_data = akVar.b().getTop_notice_data();
                if (top_notice_data != null && top_notice_data.a() != null) {
                    com.baidu.tieba.data.bb bbVar = new com.baidu.tieba.data.bb();
                    bbVar.c(top_notice_data.a());
                    bbVar.a(2);
                    bbVar.b(top_notice_data.b());
                    bbVar.t();
                    akVar.c().add(0, bbVar);
                }
                ArrayList<com.baidu.tieba.data.bb> c = akVar.c();
                if (c != null) {
                    this.n.a(c, this.i, this.w);
                    if (this.C.equals("frs_page")) {
                        this.n.a(akVar.b(), akVar);
                    } else if (this.C.equals("normal_page")) {
                        this.n.b(akVar.b(), akVar);
                    }
                    this.n.b(this.i);
                    this.n.c(akVar.f().f());
                    this.n.E();
                    this.n.d(0);
                }
                if (akVar.j() == 1) {
                    this.n.n().a().d(true);
                } else {
                    this.n.n().a().d(false);
                }
                this.O.removeCallbacks(this.Q);
                this.O.postDelayed(this.Q, 300L);
            } catch (Exception e) {
                com.baidu.adp.lib.g.e.b("FrsActivity", "refreshWithCache", "FrsActivity.refreshWithFrs error = " + e.getMessage());
            }
        }
    }

    private void a(Bundle bundle) {
        this.O = new Handler();
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
                e();
                u();
                this.E.a(false, true, true, this.f);
            }
        }
    }

    private void o() {
        this.x = new com.baidu.tieba.model.ax();
        this.x.setLoadDataCallBack(new w(this));
    }

    private void p() {
        this.y = new ci();
        this.y.a("from_frs");
        this.y.a(new x(this));
    }

    private void q() {
        this.z = new cc();
        this.z.setLoadDataCallBack(new y(this));
    }

    private void r() {
        this.E = new com.baidu.tieba.model.x();
        this.E.setLoadDataCallBack(new z(this));
    }

    private void s() {
        this.A = new c(this);
    }

    public void e() {
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
        this.K = new ac(this, null);
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
        if (this.O != null) {
            this.O.removeCallbacks(this.Q);
        }
        if (this.A != null) {
            this.A.removeMessages(1);
        }
        super.onDestroy();
        try {
            if (this.w != null) {
                this.w.i();
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
            com.baidu.adp.lib.g.e.b("FrsActivity", "onDestroy", e.getMessage());
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
                    c(this.p);
                    return;
                case 11012:
                    d(this.G);
                    return;
                case 11013:
                    y();
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
                    return;
                case 12001:
                    if (this.w != null && this.w.b() != null) {
                        WriteImageActivity.a(this, 12001, 12010, null, this.w.b().getId(), this.f, this.w.e());
                        return;
                    }
                    return;
                case 12002:
                    if (this.w != null && this.w.b() != null && intent != null && intent.getData() != null) {
                        WriteImageActivity.a(this, 12002, 12009, intent.getData(), this.w.b().getId(), this.f, this.w.e());
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    if (this.w != null && this.w.b() != null) {
                        if (intent == null || intent.getStringExtra("filename") == null) {
                            WriteActivity.a((Activity) this, this.w.b().getId(), this.f, (AntiData) null, true, (String) null);
                            return;
                        } else {
                            WriteActivity.a((Activity) this, this.w.b().getId(), this.f, (AntiData) null, true, intent.getStringExtra("filename"));
                            return;
                        }
                    }
                    return;
                case 13003:
                    z();
                    return;
                case 18003:
                    this.n.n().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null) {
                        int size = this.w.c().size();
                        int i3 = 0;
                        while (true) {
                            if (i3 >= size) {
                                z = false;
                            } else if (stringExtra.equals(this.w.c().get(i3).a())) {
                                z = true;
                            } else {
                                i3++;
                            }
                        }
                        if (z) {
                            int intExtra = intent.getIntExtra("type", 0);
                            if (intExtra == 2) {
                                this.w.c().get(i3).b(intent.getIntExtra("good_data", 0));
                                this.w.c().get(i3).t();
                                z();
                                return;
                            } else if (intExtra == 0) {
                                this.w.c().remove(i3);
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
        S = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        NetworkInfo activeNetworkInfo;
        super.onResume();
        this.Z = 0;
        NoNetworkView j = this.n.j();
        if (j != null && j.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            j.setVisible(false);
        }
        if (S) {
            S = false;
            this.n.I();
        } else if (a) {
            a = false;
            this.n.I();
        } else {
            if (!this.k && TiebaApplication.B()) {
                this.k = true;
                if (this.w != null && this.w.e() != null) {
                    this.w.e().setIfpost(1);
                }
                this.E.a(false, true, true, this.f);
                z();
            }
            this.n.f().b(this.k);
            this.Q.run();
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
        this.n = new bk(this, this.Y);
        this.n.f().e();
        this.n.a(this.T);
        this.n.a(this.U);
        this.n.a(this.V);
        this.n.a(this.W);
        this.n.a(this.aa);
        this.n.a(this.X);
        this.n.a(this.ab);
        this.n.a(this.ac);
        this.n.a(this.ae);
        if (com.baidu.tieba.sharedPref.b.a().a("frs_first_in", true)) {
            this.H = new bp(this);
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
            if (this.w != null && this.w.e() != null) {
                this.w.e().setIfpost(1);
            }
            if (i == 0) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11001);
            } else {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11016);
            }
        } else if (this.w != null) {
            if (i == 0) {
                AntiData e = this.w.e();
                if (AntiHelper.a(e) || AntiHelper.b(e) || AntiHelper.c(e)) {
                    e.setBlock_forum_name(this.f);
                    e.setBlock_forum_id(this.w.b().getId());
                    e.setUser_name(this.w.d().getName());
                    e.setUser_id(this.w.d().getId());
                    if (AntiHelper.a(this, e, AntiHelper.OperationType.CREATE_THREAD, AntiHelper.PageType.FRS)) {
                        return;
                    }
                }
                WriteActivity.a((Activity) this, this.w.b().getId(), this.f, this.w.e(), false, (String) null);
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
        this.n.a(new f(this, bbVar));
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
    public void z() {
        E();
        this.i = 1;
        this.e = 3;
        A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
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
        int b = com.baidu.adp.lib.g.g.b(this);
        int c = com.baidu.adp.lib.g.g.c(this);
        float f = b / 320.0f;
        int i = bx.a().b() ? 2 : 1;
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
        this.w.a(this.M);
        this.w.a(stringBuffer.toString(), arrayList, this.e, z, this.f);
    }

    private void B() {
        switch (this.h) {
            case 1:
                DatabaseService.m(this.f);
                break;
        }
        this.h = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        E();
        try {
            if (this.w != null) {
                this.n.q();
                this.f = this.w.b().getName();
                this.n.c(this.f);
                B();
                this.d = false;
                ArrayList<com.baidu.tieba.data.bb> c = this.w.c();
                if (c != null) {
                    this.n.a(c, this.i, this.w);
                    if (this.C.equals("frs_page")) {
                        D();
                    } else if (this.C.equals("normal_page")) {
                        this.n.b(this.w.b(), this.w);
                    }
                    this.n.b(this.i);
                    this.n.c(this.w.f().f());
                    this.n.E();
                    if (this.w.j() == 1) {
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
                    if (this.O != null && this.Q != null) {
                        this.O.removeCallbacks(this.Q);
                        this.O.postDelayed(this.Q, 300L);
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b("FrsActivity", "", "FrsActivity.refreshFrs error = " + e.getMessage());
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
                        this.n.f().c(false);
                        z();
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

    private void D() {
        this.n.a(this.w.b(), this.w);
        this.A.removeMessages(1);
        if (this.i == 1 && this.C.equals("frs_page") && this.w.g().f() == 0) {
            this.B = System.nanoTime() / 1000000000;
            if (this.w.g().g() > 0) {
                this.A.sendMessageDelayed(this.A.obtainMessage(1), 1000L);
            }
        }
    }

    public void h() {
        String A = TiebaApplication.A();
        if (A == null || A.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11021);
        } else if (!this.w.h()) {
            this.w.a(true);
            this.w.a(this.N);
            this.w.b(String.valueOf(this.w.b().isLike()));
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
        this.x.a(this.w.b().getName(), this.w.b().getId());
    }

    protected void j() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.attention_cancel_info));
        builder.setTitle(getString(R.string.alerm_title));
        builder.setPositiveButton(getString(R.string.attention_cancel), new n(this));
        builder.setNegativeButton(getString(R.string.cancel), new o(this));
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
        this.z.a(this.w.b().getName(), this.w.b().getId());
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.n.f().f()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                if (TiebaApplication.h().al() != 1) {
                    by.a(this, "frs_night_mode", "frsclick", 1, new Object[0]);
                    TiebaApplication.h().e(1);
                    this.mSkinType = 1;
                    new com.baidu.tieba.account.av("eyeshield").start();
                } else {
                    return;
                }
            } else if (TiebaApplication.h().al() != 0) {
                TiebaApplication.h().e(0);
                this.mSkinType = 0;
            } else {
                return;
            }
            onChangeSkinType(this.mSkinType);
            com.baidu.tieba.util.n.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        this.F = false;
        if (str != null) {
            if (TiebaApplication.h().g(str)) {
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
            z();
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
    @Override // com.baidu.tieba.view.cz
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

    private void E() {
        this.c = d_();
        this.c.g();
    }

    @Override // com.baidu.tieba.view.cz
    public int a() {
        if (this.n == null) {
            return 0;
        }
        return this.n.J();
    }

    @Override // com.baidu.tieba.view.cz
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
    public void a(com.baidu.tieba.im.message.q qVar) {
        if (qVar != null) {
            if (!(qVar instanceof com.baidu.tieba.im.message.t)) {
                com.baidu.adp.lib.g.e.a("transform error");
                return;
            }
            com.baidu.tieba.im.message.t tVar = (com.baidu.tieba.im.message.t) qVar;
            int c = tVar.c();
            int a2 = tVar.a();
            int b = tVar.b();
            int d = tVar.d();
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
