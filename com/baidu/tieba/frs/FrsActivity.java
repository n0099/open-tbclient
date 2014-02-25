package com.baidu.tieba.frs;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.home.CreateBarActivity;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.util.AntiHelper;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.cb;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.UserIconBox;
import com.baidu.tieba.view.df;
import com.baidu.tieba.voice.VoiceManager;
import com.baidu.tieba.write.WriteActivity;
import com.baidu.tieba.write.WriteImageActivity;
import com.slidingmenu.lib.R;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class FrsActivity extends com.baidu.tieba.f implements com.baidu.adp.widget.BdSwitchView.c, com.baidu.tbadk.widget.a, df, com.baidu.tieba.voice.af {
    private com.baidu.tieba.model.ae H;
    private com.baidu.tieba.model.k I;
    private bw L;
    VoiceManager d;
    public static String a = "has_shown_frs_guide";
    public static boolean b = false;
    private static volatile long s = 0;
    private static volatile long t = 0;
    private static volatile int u = 0;
    private static boolean Y = false;
    private boolean e = true;
    private int f = 3;
    private String g = null;
    private String h = null;
    private int i = 0;
    private int j = 1;
    private boolean k = false;
    private boolean l = false;
    private boolean m = false;
    private String n = null;
    private boolean o = false;
    private br p = null;
    private String q = null;
    private final com.baidu.tieba.data.az r = null;
    private long v = 0;
    private boolean w = false;
    private boolean x = true;
    private boolean y = true;
    private boolean z = true;
    private com.baidu.tieba.model.z A = null;
    private com.baidu.tieba.model.ar B = null;
    private com.baidu.tieba.model.bx C = null;
    private com.baidu.tieba.model.bt D = null;
    private Handler E = null;
    private long F = 0;
    private String G = "normal_page";
    private boolean J = false;
    private com.baidu.tieba.data.az K = null;
    private final com.baidu.adp.lib.d.b<TbImageView> M = UserIconBox.a(this, 8);
    private boolean N = false;
    private aj O = null;
    private long P = -1;
    private AlertDialog Q = null;
    private String R = "";
    private final by S = new i(this);
    private final bx T = new t(this);
    private Handler U = null;
    private com.baidu.tieba.util.i V = null;
    private final Runnable W = new ab(this);
    com.baidu.tbadk.imageManager.d c = new ac(this);
    private final com.baidu.tbadk.imageManager.d X = new ad(this);
    private final com.baidu.adp.widget.ListView.r Z = new ae(this);
    private final com.baidu.adp.widget.ListView.t aa = new af(this);
    private final AdapterView.OnItemClickListener ab = new ag(this);
    private final AdapterView.OnItemLongClickListener ac = new ai(this);
    private final com.baidu.adp.widget.ListView.b ad = new j(this);
    private final View.OnClickListener ae = new k(this);
    private int af = 0;
    private final AbsListView.OnScrollListener ag = new l(this);
    private final SlidingMenu.OnClosedListener ah = new m(this);
    private final SlidingMenu.OnOpenedListener ai = new n(this);
    private final AdapterView.OnItemClickListener aj = new o(this);
    private final com.baidu.tieba.view.by ak = new p(this);
    private final List<com.baidu.tbadk.widget.b> al = new ArrayList();

    @Override // com.baidu.tieba.f
    public boolean getGpuSwitch() {
        return TiebaApplication.g().u();
    }

    public void a(com.baidu.tieba.model.z zVar) {
        int i;
        com.baidu.tieba.data.az azVar;
        if (zVar != null && zVar.b() != null) {
            h bannerListData = zVar.b().getBannerListData();
            ArrayList<com.baidu.tieba.data.az> c = zVar.c();
            if (bannerListData != null && bannerListData.a() != null && c != null && c.size() > 0) {
                int i2 = 0;
                Iterator<com.baidu.tieba.data.az> it = c.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    com.baidu.tieba.data.az next = it.next();
                    if (next.f() != 1 && next.f() != 2) {
                        break;
                    }
                    i2 = i + 1;
                }
                Iterator<g> it2 = bannerListData.a().iterator();
                while (it2.hasNext()) {
                    g next2 = it2.next();
                    int u2 = (next2.u() + i) - 1;
                    if (this.p != null && this.p.n() != null && this.p.n().d().size() > 0 && (azVar = (com.baidu.tieba.data.az) this.p.n().getItem(u2)) != null && (azVar instanceof g)) {
                        next2.d(((g) azVar).A());
                    }
                    if (!UtilHelper.f(this, next2.y())) {
                        zVar.c().add(u2, next2);
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.model.ac acVar) {
        if (this.e) {
            if (acVar != null) {
                if (acVar.a && acVar.b) {
                    if (acVar.c == 3) {
                        this.k = false;
                        this.g = this.g.replace(" ", "");
                        String str = this.g;
                        if (str.length() > 31) {
                            str = String.valueOf(str.substring(0, 31)) + "...";
                        }
                        this.p.b(str);
                    } else if (UtilHelper.h(this) != UtilHelper.NetworkStateInfo.UNAVAIL) {
                        this.p.a(acVar.d);
                    }
                } else if (UtilHelper.h(this) != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    this.p.a(acVar.d);
                }
            }
        } else if (acVar != null) {
            this.p.a(acVar.d);
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

    public void b() {
        com.baidu.tieba.data.az b2 = this.p.o().b();
        if (b2 != null) {
            ArrayList<com.baidu.tieba.data.ah> p = b2.p();
            int size = p.size();
            for (int i = 0; i < size; i++) {
                if (p.get(i).a() == 3) {
                    this.p.o().a().b(p.get(i).b(), this.X);
                }
            }
        }
    }

    public void e() {
        com.baidu.tieba.data.az b2 = this.p.p().b();
        if (b2 != null) {
            ArrayList<com.baidu.tieba.data.ah> p = b2.p();
            int size = p.size();
            for (int i = 0; i < size; i++) {
                if (p.get(i).a() == 3) {
                    this.p.p().a().b(p.get(i).b(), this.X);
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
        if (TiebaApplication.g().g(str)) {
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

    private void o() {
        this.V = new com.baidu.tieba.util.i(this);
        this.V.b(true);
        int a2 = BdUtilHelper.a((Context) this, 427.0f);
        int i = a2 <= 640 ? a2 : 640;
        this.V.a(i, (int) (i * 1.6f));
    }

    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.P = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.P = System.currentTimeMillis();
        }
        if (y()) {
            this.d = h();
            this.d.a((Activity) this);
            A();
            a(bundle);
            this.p.J();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.d = h();
        this.d.b((Activity) this);
    }

    public void b(com.baidu.tieba.model.z zVar) {
        if (zVar != null) {
            try {
                if (this.x) {
                    this.p.B();
                    this.x = false;
                }
                if (zVar.j() == 1) {
                    this.p.n().f(true);
                } else {
                    this.p.n().f(false);
                }
                this.p.a(this.A.b());
                if (zVar.g().a() == 1) {
                    this.G = "frs_page";
                    this.p.t();
                } else {
                    this.G = "normal_page";
                    this.p.s();
                }
                this.p.q();
                this.g = zVar.b().getName();
                this.p.c(this.g);
                E();
                if (this.z && !TiebaApplication.g().br().contains(this.g)) {
                    a(zVar);
                    this.z = false;
                }
                com.baidu.tieba.data.bb top_notice_data = zVar.b().getTop_notice_data();
                if (top_notice_data != null && top_notice_data.a() != null) {
                    com.baidu.tieba.data.az azVar = new com.baidu.tieba.data.az();
                    azVar.c(top_notice_data.a());
                    azVar.a(2);
                    azVar.b(top_notice_data.b());
                    azVar.t();
                    zVar.c().add(0, azVar);
                }
                ArrayList<com.baidu.tieba.data.az> c = zVar.c();
                if (c != null) {
                    this.p.a(c, this.j, this.A);
                    J();
                    if (this.G.equals("frs_page")) {
                        this.p.a(zVar.b(), zVar);
                    } else if (this.G.equals("normal_page")) {
                        this.p.b(zVar.b(), zVar);
                    }
                    this.p.b(this.j);
                    this.p.c(zVar.f().f());
                    this.p.E();
                    this.p.d(0);
                }
                if (zVar.j() == 1) {
                    this.p.n().a().d(true);
                } else {
                    this.p.n().a().d(false);
                }
                if (zVar.a()) {
                    this.p.o().j();
                    this.p.p().i();
                } else {
                    this.p.o().i();
                    this.p.p().h();
                }
                this.U.removeCallbacks(this.W);
                this.U.postDelayed(this.W, 300L);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("FrsActivity", "refreshWithCache", "FrsActivity.refreshWithFrs error = " + e.getMessage());
            }
        }
    }

    private void a(Bundle bundle) {
        this.U = new Handler();
        o();
        this.O = new aj(this, null);
        v();
        this.m = TiebaApplication.B();
        if (bundle != null) {
            this.g = bundle.getString(SocialConstants.PARAM_MEDIA_UNAME);
            this.h = bundle.getString("from");
            this.i = bundle.getInt("flag", 0);
        } else {
            Intent intent = getIntent();
            this.g = intent.getStringExtra(SocialConstants.PARAM_MEDIA_UNAME);
            this.h = intent.getStringExtra("from");
            this.i = intent.getIntExtra("flag", 0);
            this.w = intent.getBooleanExtra("good", false);
        }
        if (this.g != null && this.g.length() > 0) {
            if (this.h == null || this.h.length() <= 0) {
                this.h = "tb_forumlist";
            }
            this.q = this.h;
            this.J = false;
            t();
            p();
            q();
            r();
            s();
            this.H = new com.baidu.tieba.model.ae(this);
            if (this.m) {
                f();
                w();
                this.I.b(true);
            }
        }
    }

    private void p() {
        this.B = new com.baidu.tieba.model.ar();
        this.B.setLoadDataCallBack(new q(this));
    }

    private void q() {
        this.C = new com.baidu.tieba.model.bx();
        this.C.a("from_frs");
        this.C.a(new r(this));
    }

    private void r() {
        this.D = new com.baidu.tieba.model.bt();
        this.D.setLoadDataCallBack(new s(this));
    }

    private void s() {
        this.I = new com.baidu.tieba.model.k();
        this.I.a(new u(this));
    }

    @SuppressLint({"HandlerLeak"})
    private void t() {
        this.E = new v(this);
    }

    public void f() {
        if (this.H != null && this.p != null) {
            this.H.a(com.baidu.tieba.mention.v.a().o());
            this.H.c(com.baidu.tieba.mention.v.a().m());
            this.H.b(com.baidu.tieba.mention.v.a().n());
            this.H.d(com.baidu.tieba.mention.v.a().p());
            this.p.a(this.H);
        }
    }

    public void u() {
        if (this.I != null && this.I.a() != null && this.I.a().e() != null) {
            this.p.f().a(this.I.a().e().a());
        }
    }

    private void v() {
        com.baidu.tieba.im.messageCenter.e.a().a(-122, this.O);
    }

    private void w() {
        com.baidu.tieba.im.messageCenter.e.a().a(-124, this.O);
    }

    private void x() {
        com.baidu.tieba.im.messageCenter.e.a().a(this.O);
    }

    private boolean y() {
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

    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        x();
        if (this.p != null) {
            this.p.l();
        }
        if (this.U != null) {
            this.U.removeCallbacks(this.W);
        }
        if (this.E != null) {
            this.E.removeMessages(1);
        }
        super.onDestroy();
        try {
            if (this.A != null) {
                this.A.i();
            }
            if (this.B != null) {
                this.B.a();
            }
            if (this.D != null) {
                this.D.a();
            }
            if (this.I != null) {
                this.I.cancelLoadData();
            }
            this.p.H();
            System.gc();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("FrsActivity", "onDestroy", e.getMessage());
        }
        this.d = h();
        this.d.g(this);
        TiebaApplication.g().bn();
        com.baidu.tbadk.imageManager.e.a().c();
        this.Q = null;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(SocialConstants.PARAM_MEDIA_UNAME, this.g);
        bundle.putString("from", this.h);
        this.d = h();
        if (this.d != null) {
            this.d.e(this);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        boolean z = true;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    b(0);
                    return;
                case 11002:
                    j();
                    return;
                case 11011:
                    c(this.r);
                    return;
                case 11012:
                    d(this.K);
                    return;
                case 11013:
                    B();
                    return;
                case 11014:
                    l();
                    return;
                case 11016:
                    this.p.C();
                    return;
                case 11021:
                    if (this.A != null) {
                        i();
                        return;
                    }
                    return;
                case 11033:
                default:
                    return;
                case 11036:
                    k();
                    return;
                case 12001:
                    if (this.A != null && this.A.b() != null) {
                        WriteImageActivity.a(this, 12001, 12010, null, this.A.b().getId(), this.g, this.A.e());
                        return;
                    }
                    return;
                case 12002:
                    if (this.A != null && this.A.b() != null && intent != null && intent.getData() != null) {
                        WriteImageActivity.a(this, 12002, 12009, intent.getData(), this.A.b().getId(), this.g, this.A.e());
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    if (this.A != null && this.A.b() != null) {
                        if (intent == null || intent.getStringExtra("filename") == null) {
                            WriteActivity.a((Activity) this, this.A.b().getId(), this.g, (AntiData) null, true, (String) null);
                            return;
                        } else {
                            WriteActivity.a((Activity) this, this.A.b().getId(), this.g, (AntiData) null, true, intent.getStringExtra("filename"));
                            return;
                        }
                    }
                    return;
                case 13003:
                    C();
                    return;
                case 18003:
                    this.p.n().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null) {
                        int size = this.A.c().size();
                        int i3 = 0;
                        while (true) {
                            if (i3 >= size) {
                                z = false;
                            } else if (!stringExtra.equals(this.A.c().get(i3).a())) {
                                i3++;
                            }
                        }
                        if (z) {
                            int intExtra = intent.getIntExtra("type", 0);
                            if (intExtra == 2) {
                                this.A.c().get(i3).b(intent.getIntExtra("good_data", 0));
                                this.A.c().get(i3).t();
                                C();
                                return;
                            } else if (intExtra == 0) {
                                this.A.c().remove(i3);
                                this.p.E();
                                if (com.baidu.tieba.model.o.a() != null) {
                                    com.baidu.tieba.model.o.a().b(this.g);
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
                case 18004:
                    H();
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12009:
                    com.baidu.tieba.write.bz.b(this);
                    return;
                case 12010:
                    com.baidu.tieba.write.bz.a(this);
                    return;
                default:
                    return;
            }
        }
    }

    public static void a(boolean z) {
        Y = z;
    }

    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        NetworkInfo activeNetworkInfo;
        super.onResume();
        this.af = 0;
        NoNetworkView j = this.p.j();
        if (j != null && j.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            j.setVisible(false);
        }
        if (Y) {
            Y = false;
            this.p.J();
        } else if (b) {
            b = false;
            this.p.J();
        } else {
            if (!this.m && TiebaApplication.B()) {
                this.m = true;
                if (this.A != null && this.A.e() != null) {
                    this.A.e().setIfpost(1);
                }
                this.I.b(true);
                C();
            }
            this.p.f().b(this.m);
            this.W.run();
            if (this.E != null) {
                this.E.removeMessages(1);
                this.E.sendMessageDelayed(this.E.obtainMessage(1), 1000L);
            }
            this.d = h();
            this.d.c(this);
            com.baidu.tieba.im.c.a.f().b(false, null);
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        this.l = intent.getBooleanExtra("refresh_all", false);
        if (this.l) {
            z();
        }
    }

    private void z() {
        this.p.J();
        this.p.g().toggle(false);
    }

    @Override // com.baidu.tieba.f
    public void closeActivity() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
            return;
        }
        String A = TiebaApplication.A();
        if (A != null && A.length() > 0) {
            com.baidu.tieba.mainentrance.f.a(this, 1);
        } else {
            com.baidu.tieba.mainentrance.f.a(this, 2);
        }
    }

    public void g() {
        this.p.H();
        finish();
        CompatibleUtile.setAnim(this, R.anim.frs_browser_enter, R.anim.no_effect);
    }

    private void A() {
        this.e = true;
        this.g = "";
        this.h = "";
        this.i = 0;
        this.j = 1;
        this.w = false;
        this.v = 0L;
        this.f = 3;
        this.p = new br(this, this.ae);
        this.p.f().e();
        this.p.a(this.Z);
        this.p.a(this.aa);
        this.p.a(this.ab);
        this.p.a(this.ac);
        this.p.a(this.ag);
        this.p.a(this.ad);
        this.p.a(this.ah);
        this.p.a(this.ai);
        this.p.a(this.ak);
        if (com.baidu.tieba.sharedPref.b.a().a("frs_first_in", true)) {
            this.L = new bw(this);
        }
    }

    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.p.j(i);
    }

    public void B() {
        String A = TiebaApplication.A();
        if (A == null || A.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11013);
            return;
        }
        CreateBarActivity.a(this, this.g, true);
        finish();
    }

    public void a(String str) {
        Intent a2;
        if (str != null && (a2 = a((Context) this, str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + getString(R.string.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", a2);
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this, R.drawable.icon));
            sendBroadcast(intent);
            new com.baidu.tieba.account.ax("add_to_launcher").start();
        }
    }

    public void b(int i) {
        String A = TiebaApplication.A();
        if (A == null || A.length() <= 0) {
            if (this.A != null && this.A.e() != null) {
                this.A.e().setIfpost(1);
            }
            if (i == 0) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11001);
            } else {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11016);
            }
        } else if (this.A != null) {
            if (i == 0) {
                AntiData e = this.A.e();
                if (AntiHelper.a(e) || AntiHelper.b(e) || AntiHelper.c(e)) {
                    e.setBlock_forum_name(this.g);
                    e.setBlock_forum_id(this.A.b().getId());
                    e.setUser_name(this.A.d().getUserName());
                    e.setUser_id(this.A.d().getUserId());
                    if (AntiHelper.a(this, e, AntiHelper.OperationType.CREATE_THREAD, AntiHelper.PageType.FRS)) {
                        return;
                    }
                }
                WriteActivity.a((Activity) this, this.A.b().getId(), this.g, this.A.e(), false, (String) null);
                return;
            }
            this.p.C();
        }
    }

    private boolean a(com.baidu.tieba.data.az azVar) {
        String userId;
        return azVar == null || azVar.j() == null || (userId = azVar.j().getUserId()) == null || userId.equals(SocialConstants.FALSE);
    }

    public void b(com.baidu.tieba.data.az azVar) {
        boolean a2 = a(azVar);
        this.p.a(new w(this, azVar));
        this.p.a(azVar, a2);
    }

    public void c(com.baidu.tieba.data.az azVar) {
        boolean a2 = a(azVar);
        if (this.n != null) {
            if (!a2) {
                NewPbActivity.a(this, azVar, this.g, null, 18003, true, true, this.o);
            } else {
                NewPbActivity.a(this, azVar, this.g, null, 18003, false, false, this.o);
            }
        }
    }

    public void d(com.baidu.tieba.data.az azVar) {
        if (this.n != null) {
            NewPbActivity.a(this, azVar, this.g, null, 18003, false, false, this.o);
        }
    }

    public void C() {
        I();
        this.j = 1;
        this.f = 3;
        D();
    }

    public void D() {
        BasicNameValuePair basicNameValuePair;
        boolean z = false;
        switch (this.f) {
            case 1:
                if (this.p.n().b()) {
                    return;
                }
                break;
            case 2:
                if (this.p.n().c()) {
                    return;
                }
                break;
            case 3:
                if (this.p.m()) {
                    return;
                }
                break;
        }
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append(com.baidu.tieba.data.i.a);
        stringBuffer.append("c/f/frs/page");
        ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
        arrayList.add(new BasicNameValuePair("kw", this.g));
        arrayList.add(new BasicNameValuePair("pn", String.valueOf(this.j)));
        if (com.baidu.tieba.h.a.a().f()) {
            basicNameValuePair = new BasicNameValuePair("rn", String.valueOf(35));
        } else {
            basicNameValuePair = new BasicNameValuePair("rn", String.valueOf(50));
        }
        arrayList.add(basicNameValuePair);
        arrayList.add(new BasicNameValuePair("with_group", SocialConstants.TRUE));
        if (this.w) {
            arrayList.add(new BasicNameValuePair("is_good", SocialConstants.TRUE));
            arrayList.add(new BasicNameValuePair("cid", String.valueOf(this.v)));
        }
        int b2 = BdUtilHelper.b(this);
        int c = BdUtilHelper.c(this);
        float f = b2 / 320.0f;
        int i = com.baidu.tieba.util.bv.a().b() ? 2 : 1;
        arrayList.add(new BasicNameValuePair("scr_w", String.valueOf(b2)));
        arrayList.add(new BasicNameValuePair("scr_h", String.valueOf(c)));
        arrayList.add(new BasicNameValuePair("scr_dip", String.valueOf(f)));
        arrayList.add(new BasicNameValuePair("q_type", String.valueOf(i)));
        if (this.q != null) {
            arrayList.add(new BasicNameValuePair("st_type", this.q));
        }
        if (s != 0) {
            arrayList.add(new BasicNameValuePair("ctime", String.valueOf(s)));
        }
        if (t != 0) {
            arrayList.add(new BasicNameValuePair("data_size", String.valueOf(t)));
        }
        if (u != 0) {
            arrayList.add(new BasicNameValuePair("net_error", String.valueOf(u)));
        }
        this.p.b(true);
        this.p.n().b(false);
        this.p.n().c(false);
        this.p.n().notifyDataSetChanged();
        if (this.j == 1 && ((this.G.equals("normal_page") || this.G.equals("frs_page")) && !this.w)) {
            z = true;
        }
        if (this.A == null) {
            this.A = new com.baidu.tieba.model.z();
        }
        this.A.a(this.S);
        this.A.a(stringBuffer.toString(), arrayList, this.f, z, this.g);
    }

    private void E() {
        switch (this.i) {
            case 1:
                DatabaseService.j(this.g);
                break;
        }
        this.i = 0;
    }

    public void F() {
        I();
        try {
            if (this.A != null) {
                this.p.q();
                this.g = this.A.b().getName();
                this.p.c(this.g);
                E();
                this.e = false;
                ArrayList<com.baidu.tieba.data.az> c = this.A.c();
                if (c != null) {
                    this.p.a(c, this.j, this.A);
                    J();
                    if (this.G.equals("frs_page")) {
                        G();
                    } else if (this.G.equals("normal_page")) {
                        this.p.b(this.A.b(), this.A);
                    }
                    this.p.b(this.j);
                    this.p.c(this.A.f().f());
                    this.p.E();
                    if (this.A.j() == 1) {
                        this.p.n().f(true);
                    } else {
                        this.p.n().f(false);
                    }
                    if (this.f == 1) {
                        this.p.d(3);
                    } else if (this.f == 2) {
                        if (this.j == 1) {
                            this.p.d(0);
                        } else {
                            this.p.d(3);
                        }
                    } else {
                        this.p.d(0);
                    }
                    if (this.U != null && this.W != null) {
                        this.U.removeCallbacks(this.W);
                        this.U.postDelayed(this.W, 300L);
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("FrsActivity", "", "FrsActivity.refreshFrs error = " + e.getMessage());
        }
    }

    @Override // com.baidu.tieba.f, android.app.Activity
    public void onPause() {
        super.onPause();
        this.p.G();
        if (this.E != null) {
            this.E.removeMessages(1);
        }
        this.d = h();
        this.d.d(this);
        if (this.al != null) {
            this.al.clear();
        }
    }

    @Override // com.baidu.tieba.f, android.app.Activity
    public void onStop() {
        super.onStop();
        this.d = h();
        if (this.d != null) {
            this.d.f(this);
        }
    }

    @Override // com.baidu.tieba.f, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.k) {
            if (i == 4) {
                if (this.p.g().isMenuShowing()) {
                    this.p.g().toggle(true);
                    if (this.p.f().g()) {
                        this.p.f().c(false);
                        C();
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

    public void a(g gVar, int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.anti_title);
        builder.setIcon((Drawable) null);
        builder.setCancelable(true);
        builder.setMessage(String.valueOf(getString(R.string.confirm_download_app)) + gVar.w() + getString(R.string.question_mark));
        builder.setPositiveButton(R.string.alert_yes_button, new x(this, gVar, i));
        builder.setNegativeButton(R.string.alert_no_button, new y(this));
        this.Q = builder.create();
        this.Q.show();
    }

    public void b(g gVar, int i) {
        if (UtilHelper.b()) {
            cb.a(this, "frs_dl_app", "frs_recommend_app", 1, "app_name", gVar.y());
            new com.baidu.tieba.account.ax("frs_recommend_app", "frs_dl", gVar.y()).start();
            b.a().a(gVar.y(), gVar.z(), gVar.w(), i);
            return;
        }
        showToast(R.string.neterror);
    }

    public void a(g gVar) {
        if (!com.baidu.tieba.util.bs.c(gVar.z())) {
            UtilHelper.a(this, b.a().a(gVar.z()));
        }
    }

    private void G() {
        this.p.a(this.A.b(), this.A);
        this.E.removeMessages(1);
        if (this.j == 1 && this.G.equals("frs_page") && this.A.g().f() == 0) {
            this.F = System.nanoTime() / 1000000000;
            if (this.A.g().g() > 0) {
                this.E.sendMessageDelayed(this.E.obtainMessage(1), 1000L);
            }
        }
    }

    public void i() {
        String A = TiebaApplication.A();
        if (A == null || A.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11021);
        } else if (!this.A.h()) {
            this.A.a(true);
            this.A.a(this.T);
            this.A.b(String.valueOf(this.A.b().isLike()));
        }
    }

    public void H() {
        UtilHelper.c(this, String.valueOf(com.baidu.tieba.data.i.a) + "mo/q/fudaiindex?fid=" + this.A.b().getId());
    }

    public void j() {
        String A = TiebaApplication.A();
        if (A == null || A.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11002);
            return;
        }
        this.B.a("from_frs");
        this.B.a(this.A.b().getName(), this.A.b().getId());
    }

    protected void k() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.attention_cancel_info));
        builder.setTitle(getString(R.string.alerm_title));
        builder.setPositiveButton(getString(R.string.attention_cancel), new z(this));
        builder.setNegativeButton(getString(R.string.cancel), new aa(this));
        builder.create().show();
    }

    public void l() {
        String A = TiebaApplication.A();
        if (A == null || A.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11014);
            return;
        }
        if (this.G.equals("normal_page")) {
            this.p.v();
        } else if (this.G.equals("frs_page")) {
            this.p.x();
        }
        this.D.a(this.A.b().getName(), this.A.b().getId());
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.p.f().f()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                if (TiebaApplication.g().al() != 1) {
                    cb.a(this, "frs_night_mode", "frsclick", 1, new Object[0]);
                    TiebaApplication.g().e(1);
                    this.mSkinType = 1;
                    new com.baidu.tieba.account.ax("eyeshield").start();
                } else {
                    return;
                }
            } else if (TiebaApplication.g().al() != 0) {
                TiebaApplication.g().e(0);
                this.mSkinType = 0;
            } else {
                return;
            }
            onChangeSkinType(this.mSkinType);
            com.baidu.tieba.util.n.a();
        }
    }

    public void b(String str) {
        this.J = false;
        if (str != null) {
            if (TiebaApplication.g().g(str)) {
                FrsImageActivity.a(this, str, null, 0);
                g();
                return;
            }
            if (this.p.g().isMenuShowing()) {
                this.p.g().toggle(true);
            }
            this.w = false;
            this.p.f().a(R.id.show_all);
            this.g = str;
            C();
        }
    }

    @Override // com.baidu.tieba.voice.af
    public VoiceManager h() {
        if (this.d == null) {
            this.d = VoiceManager.c();
        }
        return this.d;
    }

    @Override // com.baidu.tieba.view.df
    /* renamed from: m */
    public BdListView c() {
        if (this.p == null) {
            return null;
        }
        return this.p.D();
    }

    @Override // com.baidu.tieba.voice.af
    public com.baidu.tieba.voice.ad a(VoiceManager.VoiceModel voiceModel) {
        return null;
    }

    private void I() {
        this.d = h();
        this.d.g();
    }

    @Override // com.baidu.tieba.view.df
    public int a() {
        if (this.p == null) {
            return 0;
        }
        return this.p.K();
    }

    @Override // com.baidu.tieba.view.df
    public com.baidu.adp.lib.d.b<TbImageView> g_() {
        return this.M;
    }

    @Override // com.baidu.tbadk.widget.a
    public void a(com.baidu.tbadk.widget.b bVar) {
        if (bVar != null) {
            this.al.remove(bVar);
        }
    }

    public void n() {
        while (this.al.size() > 0) {
            com.baidu.tbadk.widget.b remove = this.al.remove(0);
            if (remove != null) {
                remove.invalidate();
            }
        }
    }

    public void a(com.baidu.tieba.im.message.s sVar) {
        if (sVar != null) {
            if (!(sVar instanceof com.baidu.tieba.im.message.v)) {
                com.baidu.adp.lib.util.f.b("transform error");
                return;
            }
            com.baidu.tieba.im.message.v vVar = (com.baidu.tieba.im.message.v) sVar;
            int c = vVar.c();
            int a2 = vVar.a();
            int b2 = vVar.b();
            int d = vVar.d();
            if (this.H != null) {
                this.H.a(c);
                this.H.c(a2);
                this.H.b(b2);
                this.H.d(d);
                this.p.a(this.H);
            }
        }
    }

    public void b(com.baidu.tieba.im.message.s sVar) {
        List<com.baidu.tieba.d.a> a2;
        ak n;
        HashMap<Integer, com.baidu.tieba.data.az> d;
        if (this.A != null && this.p != null && (sVar instanceof com.baidu.tieba.d.b) && (a2 = ((com.baidu.tieba.d.b) sVar).a()) != null && (n = this.p.n()) != null && (d = n.d()) != null && d.size() > 0) {
            for (com.baidu.tieba.d.a aVar : a2) {
                if (aVar != null) {
                    Iterator<Map.Entry<Integer, com.baidu.tieba.data.az>> it = d.entrySet().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Map.Entry<Integer, com.baidu.tieba.data.az> next = it.next();
                            int intValue = next.getKey().intValue();
                            com.baidu.tieba.data.az value = next.getValue();
                            if (value != null && (value instanceof g) && ((g) value).y().equals(aVar.a())) {
                                if (n.getItem(intValue) instanceof g) {
                                    g gVar = (g) n.getItem(intValue);
                                    int f = aVar.f();
                                    if (f == 3 || f == 0) {
                                        gVar.d(2);
                                    } else if (f == 2 || f == 4) {
                                        if (!com.baidu.tieba.util.bs.c(aVar.n())) {
                                            showToast(aVar.n());
                                        }
                                        gVar.d(0);
                                    } else if (f == 1) {
                                        gVar.d(1);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            this.p.r();
        }
    }

    private void J() {
        HashMap<Integer, com.baidu.tieba.data.az> d;
        if ((this.p != null || this.p.n() != null) && (d = this.p.n().d()) != null) {
            ArrayList<g> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, com.baidu.tieba.data.az> entry : d.entrySet()) {
                com.baidu.tieba.data.az value = entry.getValue();
                if (value != null && (value instanceof g)) {
                    arrayList.add((g) value);
                }
            }
            b.a().a(arrayList);
        }
    }
}
