package com.baidu.tieba.frs;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
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
    private bx L;
    private aj T;
    VoiceManager d;
    public static String a = "has_shown_frs_guide";
    public static boolean b = false;
    private static volatile long s = 0;
    private static volatile long t = 0;
    private static volatile int u = 0;
    private static boolean aa = false;
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
    private bs p = null;
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
    private ak O = null;
    private long P = -1;
    private long Q = -1;
    private AlertDialog R = null;
    private String S = "";
    private final bz U = new i(this);
    private final by V = new t(this);
    private Handler W = null;
    private com.baidu.tieba.util.i X = null;
    private final Runnable Y = new ab(this);
    com.baidu.tbadk.imageManager.d c = new ac(this);
    private final com.baidu.tbadk.imageManager.d Z = new ad(this);
    private final com.baidu.adp.widget.ListView.r ab = new ae(this);
    private final com.baidu.adp.widget.ListView.t ac = new af(this);
    private final AdapterView.OnItemClickListener ad = new ag(this);
    private final AdapterView.OnItemLongClickListener ae = new ai(this);
    private final com.baidu.adp.widget.ListView.b af = new j(this);
    private final View.OnClickListener ag = new k(this);
    private int ah = 0;
    private final AbsListView.OnScrollListener ai = new l(this);
    private final SlidingMenu.OnClosedListener aj = new m(this);
    private final SlidingMenu.OnOpenedListener ak = new n(this);
    private final AdapterView.OnItemClickListener al = new o(this);
    private final com.baidu.tieba.view.by am = new p(this);
    private final List<com.baidu.tbadk.widget.b> an = new ArrayList();

    @Override // com.baidu.tieba.view.df
    public final /* synthetic */ ListView c() {
        if (this.p == null) {
            return null;
        }
        return this.p.B();
    }

    @Override // com.baidu.tieba.f
    public boolean getGpuSwitch() {
        return TiebaApplication.g().p();
    }

    public void a(com.baidu.tieba.model.z zVar) {
        int i;
        com.baidu.tieba.data.az azVar;
        if (zVar != null && zVar.f() != null) {
            h bannerListData = zVar.f().getBannerListData();
            ArrayList<com.baidu.tieba.data.az> g = zVar.g();
            if (bannerListData != null && bannerListData.a() != null && g != null && g.size() > 0) {
                int i2 = 0;
                Iterator<com.baidu.tieba.data.az> it = g.iterator();
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
                    int r = (next2.r() + i) - 1;
                    if (this.p != null && this.p.m() != null && this.p.m().d().size() > 0 && (azVar = (com.baidu.tieba.data.az) this.p.m().getItem(r)) != null && (azVar instanceof g)) {
                        next2.d(((g) azVar).x());
                    }
                    if (!UtilHelper.f(this, next2.v())) {
                        zVar.g().add(r, next2);
                    }
                }
            }
        }
    }

    public static /* synthetic */ void a(FrsActivity frsActivity, com.baidu.tieba.model.ac acVar) {
        if (!frsActivity.e) {
            if (acVar != null) {
                frsActivity.p.a(acVar.d);
            }
        } else if (acVar != null) {
            if (!acVar.a || !acVar.b) {
                if (UtilHelper.h(frsActivity) != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    frsActivity.p.a(acVar.d);
                }
            } else if (acVar.c != 3) {
                if (UtilHelper.h(frsActivity) != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    frsActivity.p.a(acVar.d);
                }
            } else {
                frsActivity.k = false;
                frsActivity.g = frsActivity.g.replace(" ", "");
                String str = frsActivity.g;
                if (str.length() > 31) {
                    str = String.valueOf(str.substring(0, 31)) + "...";
                }
                frsActivity.p.b(str);
            }
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
            FrsImageActivity.a(context, str, null, 0);
        } else {
            a(context, str, null, false, true);
        }
    }

    public final void d() {
        com.baidu.tieba.data.az b2 = this.p.n().b();
        if (b2 != null) {
            ArrayList<com.baidu.tieba.data.ah> n = b2.n();
            int size = n.size();
            for (int i = 0; i < size; i++) {
                if (n.get(i).a() == 3) {
                    this.p.n().a().b(n.get(i).b(), this.Z);
                }
            }
        }
    }

    public final void f() {
        com.baidu.tieba.data.az b2 = this.p.o().b();
        if (b2 != null) {
            ArrayList<com.baidu.tieba.data.ah> n = b2.n();
            int size = n.size();
            for (int i = 0; i < size; i++) {
                if (n.get(i).a() == 3) {
                    this.p.o().a().b(n.get(i).b(), this.Z);
                }
            }
        }
    }

    private static void a(Context context, String str, String str2, boolean z, boolean z2) {
        Intent intent = new Intent(context, FrsActivity.class);
        if (str != null && str.length() > 0) {
            intent.putExtra(SocialConstants.PARAM_MEDIA_UNAME, str);
            intent.putExtra("from", str2);
            intent.putExtra("back_special", false);
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

    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.P = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.P = System.currentTimeMillis();
        }
        if (getIntent().getBooleanExtra("from_short_cut", false)) {
            Iterator<ActivityManager.RunningTaskInfo> it = ((ActivityManager) getSystemService("activity")).getRunningTasks(10).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningTaskInfo next = it.next();
                if (next.topActivity.getClassName().equals(getClass().getName())) {
                    if (next.numActivities <= 1) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("class", 2);
                        intent2.putExtra("fname", getIntent().getStringExtra(SocialConstants.PARAM_MEDIA_UNAME));
                        intent2.putExtra("from", "short_cut");
                        LogoActivity.a(this, intent2);
                        finish();
                        z = false;
                    }
                }
            }
        }
        z = true;
        if (z) {
            this.d = c_();
            this.d.a((Activity) this);
            this.e = true;
            this.g = "";
            this.h = "";
            this.i = 0;
            this.j = 1;
            this.w = false;
            this.v = 0L;
            this.f = 3;
            this.p = new bs(this, this.ag);
            this.p.f().d();
            this.p.a(this.ab);
            this.p.a(this.ac);
            this.p.a(this.ad);
            this.p.a(this.ae);
            this.p.a(this.ai);
            this.p.a(this.af);
            this.p.a(this.aj);
            this.p.a(this.ak);
            this.p.a(this.am);
            if (com.baidu.tieba.sharedPref.b.a().a("frs_first_in", true)) {
                this.L = new bx(this);
            }
            this.W = new Handler();
            this.X = new com.baidu.tieba.util.i(this);
            this.X.e = true;
            int a2 = BdUtilHelper.a((Context) this, 427.0f);
            if (a2 > 640) {
                a2 = 640;
            }
            this.X.a(a2, (int) (a2 * 1.6f));
            this.O = new ak(this, (byte) 0);
            com.baidu.tieba.im.messageCenter.d.a().a(-122, this.O);
            this.m = TiebaApplication.w();
            if (bundle != null) {
                this.g = bundle.getString(SocialConstants.PARAM_MEDIA_UNAME);
                this.h = bundle.getString("from");
                this.i = bundle.getInt("flag", 0);
            } else {
                Intent intent3 = getIntent();
                this.g = intent3.getStringExtra(SocialConstants.PARAM_MEDIA_UNAME);
                this.h = intent3.getStringExtra("from");
                this.i = intent3.getIntExtra("flag", 0);
                this.w = intent3.getBooleanExtra("good", false);
            }
            if (this.g != null && this.g.length() > 0) {
                if (this.h == null || this.h.length() <= 0) {
                    this.h = "tb_forumlist";
                }
                this.q = this.h;
                this.J = false;
                this.E = new v(this);
                this.B = new com.baidu.tieba.model.ar();
                this.B.setLoadDataCallBack(new q(this));
                this.C = new com.baidu.tieba.model.bx();
                this.C.a("from_frs");
                this.C.a(new r(this));
                this.D = new com.baidu.tieba.model.bt();
                this.D.setLoadDataCallBack(new s(this));
                this.I = new com.baidu.tieba.model.k();
                this.I.a(new u(this));
                this.H = new com.baidu.tieba.model.ae();
                if (this.m) {
                    g();
                    com.baidu.tieba.im.messageCenter.d.a().a(-124, this.O);
                    this.I.b(true);
                }
            }
            this.p.H();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.d = c_();
        VoiceManager voiceManager = this.d;
        VoiceManager.g();
    }

    public static /* synthetic */ void b(FrsActivity frsActivity, com.baidu.tieba.model.z zVar) {
        if (zVar == null) {
            return;
        }
        try {
            if (frsActivity.x) {
                frsActivity.p.z();
                frsActivity.x = false;
            }
            if (zVar.n() == 1) {
                frsActivity.p.m().f(true);
            } else {
                frsActivity.p.m().f(false);
            }
            frsActivity.p.a(frsActivity.A.f());
            if (zVar.k().a() == 1) {
                frsActivity.G = "frs_page";
                frsActivity.p.s();
            } else {
                frsActivity.G = "normal_page";
                frsActivity.p.r();
            }
            frsActivity.p.p();
            frsActivity.g = zVar.f().getName();
            frsActivity.p.c(frsActivity.g);
            frsActivity.p();
            if (frsActivity.z && !TiebaApplication.g().bj().contains(frsActivity.g)) {
                frsActivity.a(zVar);
                frsActivity.z = false;
            }
            com.baidu.tieba.data.bb top_notice_data = zVar.f().getTop_notice_data();
            if (top_notice_data != null && top_notice_data.a() != null) {
                com.baidu.tieba.data.az azVar = new com.baidu.tieba.data.az();
                azVar.c(top_notice_data.a());
                azVar.a(2);
                azVar.b(top_notice_data.b());
                azVar.q();
                zVar.g().add(0, azVar);
            }
            ArrayList<com.baidu.tieba.data.az> g = zVar.g();
            if (g != null) {
                bs bsVar = frsActivity.p;
                int i = frsActivity.j;
                com.baidu.tieba.model.z zVar2 = frsActivity.A;
                bsVar.a(g);
                frsActivity.s();
                if (frsActivity.G.equals("frs_page")) {
                    frsActivity.p.a(zVar.f(), zVar);
                } else if (frsActivity.G.equals("normal_page")) {
                    frsActivity.p.b(zVar.f(), zVar);
                }
                frsActivity.p.b(frsActivity.j);
                frsActivity.p.c(zVar.j().f());
                frsActivity.p.C();
                frsActivity.p.d(0);
            }
            if (zVar.n() == 1) {
                frsActivity.p.m().a().a(true);
            } else {
                frsActivity.p.m().a().a(false);
            }
            if (zVar.e()) {
                frsActivity.p.n().j();
                frsActivity.p.o().i();
            } else {
                frsActivity.p.n().i();
                frsActivity.p.o().h();
            }
            frsActivity.W.removeCallbacks(frsActivity.Y);
            frsActivity.W.postDelayed(frsActivity.Y, 300L);
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b("FrsActivity", "refreshWithCache", "FrsActivity.refreshWithFrs error = " + e.getMessage());
        }
    }

    public final void g() {
        if (this.H != null && this.p != null) {
            this.H.a(com.baidu.tieba.mention.v.a().m());
            this.H.c(com.baidu.tieba.mention.v.a().k());
            this.H.b(com.baidu.tieba.mention.v.a().l());
            this.H.d(com.baidu.tieba.mention.v.a().n());
            this.p.a(this.H);
        }
    }

    public static /* synthetic */ void z(FrsActivity frsActivity) {
        if (frsActivity.I == null || frsActivity.I.e() == null || frsActivity.I.e().e() == null) {
            return;
        }
        frsActivity.p.f().a(frsActivity.I.e().e().a());
    }

    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        com.baidu.tieba.im.messageCenter.d.a().a(this.O);
        if (this.p != null) {
            this.p.k();
        }
        if (this.W != null) {
            this.W.removeCallbacks(this.Y);
        }
        if (this.E != null) {
            this.E.removeMessages(1);
        }
        super.onDestroy();
        try {
            if (this.A != null) {
                this.A.m();
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
            this.p.F();
            System.gc();
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b("FrsActivity", "onDestroy", e.getMessage());
        }
        this.d = c_();
        this.d.d(this);
        TiebaApplication.g();
        TiebaApplication.bf();
        com.baidu.tbadk.imageManager.e.a().c();
        this.R = null;
        if (this.T != null) {
            this.T.cancel(true);
            this.T = null;
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(SocialConstants.PARAM_MEDIA_UNAME, this.g);
        bundle.putString("from", this.h);
        this.d = c_();
        if (this.d != null) {
            VoiceManager voiceManager = this.d;
            VoiceManager.i();
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
                    b(this.r);
                    return;
                case 11012:
                    c(this.K);
                    return;
                case 11013:
                    m();
                    return;
                case 11014:
                    k();
                    return;
                case 11016:
                    this.p.A();
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
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(getString(R.string.attention_cancel_info));
                    builder.setTitle(getString(R.string.alerm_title));
                    builder.setPositiveButton(getString(R.string.attention_cancel), new z(this));
                    builder.setNegativeButton(getString(R.string.cancel), new aa(this));
                    builder.create().show();
                    return;
                case 12001:
                    if (this.A != null && this.A.f() != null) {
                        WriteImageActivity.a(this, 12001, 12010, null, this.A.f().getId(), this.g, this.A.i());
                        return;
                    }
                    return;
                case 12002:
                    if (this.A != null && this.A.f() != null && intent != null && intent.getData() != null) {
                        WriteImageActivity.a(this, 12002, 12009, intent.getData(), this.A.f().getId(), this.g, this.A.i());
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    if (this.A != null && this.A.f() != null) {
                        if (intent == null || intent.getStringExtra("filename") == null) {
                            WriteActivity.a((Activity) this, this.A.f().getId(), this.g, (AntiData) null, true, (String) null);
                            return;
                        } else {
                            WriteActivity.a((Activity) this, this.A.f().getId(), this.g, (AntiData) null, true, intent.getStringExtra("filename"));
                            return;
                        }
                    }
                    return;
                case 13003:
                    n();
                    return;
                case 18003:
                    this.p.m().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null) {
                        int size = this.A.g().size();
                        int i3 = 0;
                        while (true) {
                            if (i3 >= size) {
                                z = false;
                            } else if (!stringExtra.equals(this.A.g().get(i3).a())) {
                                i3++;
                            }
                        }
                        if (z) {
                            int intExtra = intent.getIntExtra("type", 0);
                            if (intExtra == 2) {
                                this.A.g().get(i3).b(intent.getIntExtra("good_data", 0));
                                this.A.g().get(i3).q();
                                n();
                                return;
                            } else if (intExtra == 0) {
                                this.A.g().remove(i3);
                                this.p.C();
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
                    q();
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12009:
                    com.baidu.tieba.write.by.b(this);
                    return;
                case 12010:
                    com.baidu.tieba.write.by.a(this);
                    return;
                default:
                    return;
            }
        }
    }

    public static void a(boolean z) {
        aa = true;
    }

    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        NetworkInfo activeNetworkInfo;
        super.onResume();
        this.ah = 0;
        NoNetworkView j = this.p.j();
        if (j != null && j.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            j.setVisible(false);
        }
        if (aa) {
            aa = false;
            this.p.H();
        } else if (b) {
            b = false;
            this.p.H();
        } else {
            if (!this.m && TiebaApplication.w()) {
                this.m = true;
                if (this.A != null && this.A.i() != null) {
                    this.A.i().setIfpost(1);
                }
                this.I.b(true);
                n();
            }
            this.p.f().b(this.m);
            this.Y.run();
            if (this.E != null) {
                this.E.removeMessages(1);
                this.E.sendMessageDelayed(this.E.obtainMessage(1), 1000L);
            }
            this.d = c_();
            this.d.b(this);
            com.baidu.tieba.im.c.a.d().b(false, null);
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        this.l = intent.getBooleanExtra("refresh_all", false);
        if (this.l) {
            this.p.H();
            this.p.g().toggle(false);
        }
    }

    @Override // com.baidu.tieba.f
    public void closeActivity() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
            return;
        }
        String v = TiebaApplication.v();
        if (v != null && v.length() > 0) {
            com.baidu.tieba.mainentrance.d.a(this, 1);
        } else {
            com.baidu.tieba.mainentrance.d.a(this, 2);
        }
    }

    public final void h() {
        this.p.F();
        finish();
        CompatibleUtile.setAnim(this, R.anim.frs_browser_enter, R.anim.no_effect);
    }

    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.p.j(i);
    }

    public void m() {
        String v = TiebaApplication.v();
        if (v == null || v.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11013);
            return;
        }
        CreateBarActivity.a(this, this.g, true);
        finish();
    }

    public static /* synthetic */ void h(FrsActivity frsActivity, String str) {
        Intent a2;
        if (str == null || (a2 = a((Context) frsActivity, str)) == null) {
            return;
        }
        Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent.putExtra("duplicate", false);
        intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + frsActivity.getString(R.string.bar));
        intent.putExtra("android.intent.extra.shortcut.INTENT", a2);
        intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(frsActivity, R.drawable.icon));
        frsActivity.sendBroadcast(intent);
        new com.baidu.tieba.account.ax("add_to_launcher").start();
    }

    public static /* synthetic */ boolean g(FrsActivity frsActivity, String str) {
        String str2 = Build.MODEL;
        Cursor query = frsActivity.getContentResolver().query(Uri.parse((TextUtils.isEmpty(str2) || !str2.startsWith("MI")) ? Build.VERSION.SDK_INT < 8 ? "content://com.android.launcher.settings/favorites?notify=true" : "content://com.android.launcher2.settings/favorites?notify=true" : "content://com.miui.home.launcher.settings/favorites?notify=true"), null, "title=?", new String[]{String.valueOf(str) + frsActivity.getString(R.string.bar)}, null);
        return query != null && query.getCount() > 0;
    }

    public void b(int i) {
        String v = TiebaApplication.v();
        if (v == null || v.length() <= 0) {
            if (this.A != null && this.A.i() != null) {
                this.A.i().setIfpost(1);
            }
            if (i == 0) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11001);
            } else {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11016);
            }
        } else if (this.A != null) {
            if (i == 0) {
                AntiData i2 = this.A.i();
                if (AntiHelper.a(i2) || AntiHelper.b(i2) || AntiHelper.c(i2)) {
                    i2.setBlock_forum_name(this.g);
                    i2.setBlock_forum_id(this.A.f().getId());
                    i2.setUser_name(this.A.h().getUserName());
                    i2.setUser_id(this.A.h().getUserId());
                    if (AntiHelper.a(this, i2, AntiHelper.OperationType.CREATE_THREAD, AntiHelper.PageType.FRS)) {
                        return;
                    }
                }
                WriteActivity.a((Activity) this, this.A.f().getId(), this.g, this.A.i(), false, (String) null);
                return;
            }
            this.p.A();
        }
    }

    private static boolean a(com.baidu.tieba.data.az azVar) {
        String userId;
        return azVar == null || azVar.i() == null || (userId = azVar.i().getUserId()) == null || userId.equals(SocialConstants.FALSE);
    }

    public static /* synthetic */ void b(FrsActivity frsActivity, com.baidu.tieba.data.az azVar) {
        boolean a2 = a(azVar);
        frsActivity.p.a(new w(frsActivity, azVar));
        frsActivity.p.b(a2);
    }

    public void b(com.baidu.tieba.data.az azVar) {
        boolean a2 = a(azVar);
        if (this.n != null) {
            if (!a2) {
                NewPbActivity.a(this, azVar, this.g, null, 18003, true, true, this.o);
            } else {
                NewPbActivity.a(this, azVar, this.g, null, 18003, false, false, this.o);
            }
        }
    }

    public void c(com.baidu.tieba.data.az azVar) {
        if (this.n != null) {
            NewPbActivity.a(this, azVar, this.g, null, 18003, false, false, this.o);
        }
    }

    public void n() {
        r();
        this.j = 1;
        this.f = 3;
        o();
    }

    public void o() {
        BasicNameValuePair basicNameValuePair;
        boolean z = false;
        switch (this.f) {
            case 1:
                if (this.p.m().b()) {
                    return;
                }
                break;
            case 2:
                if (this.p.m().c()) {
                    return;
                }
                break;
            case 3:
                if (this.p.l()) {
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
        this.p.c(true);
        this.p.m().b(false);
        this.p.m().c(false);
        this.p.m().notifyDataSetChanged();
        if (this.j == 1 && ((this.G.equals("normal_page") || this.G.equals("frs_page")) && !this.w)) {
            z = true;
        }
        if (this.A == null) {
            this.A = new com.baidu.tieba.model.z();
        }
        this.A.a(this.U);
        this.A.a(stringBuffer.toString(), arrayList, this.f, z, this.g);
    }

    private void p() {
        switch (this.i) {
            case 1:
                DatabaseService.h(this.g);
                break;
        }
        this.i = 0;
    }

    public static /* synthetic */ void m(FrsActivity frsActivity) {
        frsActivity.r();
        try {
            if (frsActivity.A == null) {
                return;
            }
            frsActivity.p.p();
            frsActivity.g = frsActivity.A.f().getName();
            frsActivity.p.c(frsActivity.g);
            frsActivity.p();
            frsActivity.e = false;
            ArrayList<com.baidu.tieba.data.az> g = frsActivity.A.g();
            if (g != null) {
                bs bsVar = frsActivity.p;
                int i = frsActivity.j;
                com.baidu.tieba.model.z zVar = frsActivity.A;
                bsVar.a(g);
                frsActivity.s();
                if (frsActivity.G.equals("frs_page")) {
                    frsActivity.p.a(frsActivity.A.f(), frsActivity.A);
                    frsActivity.E.removeMessages(1);
                    if (frsActivity.j == 1 && frsActivity.G.equals("frs_page") && frsActivity.A.k().f() == 0) {
                        frsActivity.F = System.nanoTime() / 1000000000;
                        if (frsActivity.A.k().g() > 0) {
                            frsActivity.E.sendMessageDelayed(frsActivity.E.obtainMessage(1), 1000L);
                        }
                    }
                } else if (frsActivity.G.equals("normal_page")) {
                    frsActivity.p.b(frsActivity.A.f(), frsActivity.A);
                }
                frsActivity.p.b(frsActivity.j);
                frsActivity.p.c(frsActivity.A.j().f());
                frsActivity.p.C();
                if (frsActivity.A.n() == 1) {
                    frsActivity.p.m().f(true);
                } else {
                    frsActivity.p.m().f(false);
                }
                if (frsActivity.f == 1) {
                    frsActivity.p.d(3);
                } else if (frsActivity.f != 2 || frsActivity.j == 1) {
                    frsActivity.p.d(0);
                } else {
                    frsActivity.p.d(3);
                }
                if (frsActivity.W == null || frsActivity.Y == null) {
                    return;
                }
                frsActivity.W.removeCallbacks(frsActivity.Y);
                frsActivity.W.postDelayed(frsActivity.Y, 300L);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b("FrsActivity", "", "FrsActivity.refreshFrs error = " + e.getMessage());
        }
    }

    @Override // com.baidu.tieba.f, android.app.Activity
    public void onPause() {
        super.onPause();
        this.p.E();
        if (this.E != null) {
            this.E.removeMessages(1);
        }
        this.d = c_();
        this.d.c(this);
        if (this.an != null) {
            this.an.clear();
        }
    }

    @Override // com.baidu.tieba.f, android.app.Activity
    public void onStop() {
        super.onStop();
        this.d = c_();
        if (this.d != null) {
            this.d.j();
        }
    }

    @Override // com.baidu.tieba.f, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.k) {
            if (i == 4) {
                if (this.p.g().isMenuShowing()) {
                    this.p.g().toggle(true);
                    if (this.p.f().f()) {
                        this.p.f().c(false);
                        n();
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

    public final void a(g gVar, int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.anti_title);
        builder.setIcon((Drawable) null);
        builder.setCancelable(true);
        builder.setMessage(String.valueOf(getString(R.string.confirm_download_app)) + gVar.t() + getString(R.string.question_mark));
        builder.setPositiveButton(R.string.alert_yes_button, new x(this, gVar, i));
        builder.setNegativeButton(R.string.alert_no_button, new y(this));
        this.R = builder.create();
        this.R.show();
    }

    public final void b(g gVar, int i) {
        if (UtilHelper.b()) {
            com.baidu.tieba.util.cb.a(this, "frs_dl_app", "frs_recommend_app", 1, "app_name", gVar.v());
            new com.baidu.tieba.account.ax("frs_recommend_app", "frs_dl", gVar.v()).start();
            b.a().a(gVar.v(), gVar.w(), gVar.t(), i);
            return;
        }
        showToast(R.string.neterror);
    }

    public final void a(g gVar) {
        if (!com.baidu.tieba.util.bs.c(gVar.w())) {
            b.a();
            UtilHelper.a(this, b.a(gVar.w()));
        }
    }

    public final void i() {
        String v = TiebaApplication.v();
        if (v == null || v.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11021);
        } else if (!this.A.l()) {
            this.A.a(true);
            this.A.a(this.V);
            this.A.b(String.valueOf(this.A.f().isLike()));
        }
    }

    public void q() {
        UtilHelper.c(this, String.valueOf(com.baidu.tieba.data.i.a) + "mo/q/fudaiindex?fid=" + this.A.f().getId());
    }

    public final void j() {
        String v = TiebaApplication.v();
        if (v == null || v.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11002);
            return;
        }
        this.B.a("from_frs");
        this.B.a(this.A.f().getName(), this.A.f().getId());
    }

    public final void k() {
        String v = TiebaApplication.v();
        if (v == null || v.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11014);
            return;
        }
        if (this.G.equals("normal_page")) {
            this.p.t();
        } else if (this.G.equals("frs_page")) {
            this.p.v();
        }
        this.D.a(this.A.f().getName(), this.A.f().getId());
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public final void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.p.f().e()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                if (TiebaApplication.g().ae() != 1) {
                    com.baidu.tieba.util.cb.a(this, "frs_night_mode", "frsclick", 1, new Object[0]);
                    TiebaApplication.g().e(1);
                    this.mSkinType = 1;
                    new com.baidu.tieba.account.ax("eyeshield").start();
                } else {
                    return;
                }
            } else if (TiebaApplication.g().ae() != 0) {
                TiebaApplication.g().e(0);
                this.mSkinType = 0;
            } else {
                return;
            }
            onChangeSkinType(this.mSkinType);
            com.baidu.tieba.util.n.a();
        }
    }

    public static /* synthetic */ void f(FrsActivity frsActivity, String str) {
        frsActivity.J = false;
        if (str != null) {
            if (TiebaApplication.g().g(str)) {
                FrsImageActivity.a(frsActivity, str, null, 0);
                frsActivity.h();
                return;
            }
            if (frsActivity.p.g().isMenuShowing()) {
                frsActivity.p.g().toggle(true);
            }
            frsActivity.w = false;
            frsActivity.p.f().a(R.id.show_all);
            frsActivity.g = str;
            frsActivity.n();
        }
    }

    @Override // com.baidu.tieba.voice.af
    public final VoiceManager c_() {
        if (this.d == null) {
            this.d = VoiceManager.b();
        }
        return this.d;
    }

    @Override // com.baidu.tieba.voice.af
    public final com.baidu.tieba.voice.ad a(VoiceManager.VoiceModel voiceModel) {
        return null;
    }

    private void r() {
        this.d = c_();
        this.d.f();
    }

    @Override // com.baidu.tieba.view.df
    public final int a() {
        if (this.p == null) {
            return 0;
        }
        bs bsVar = this.p;
        return R.id.user_icon_box;
    }

    @Override // com.baidu.tieba.view.df
    public final com.baidu.adp.lib.d.b<TbImageView> b() {
        return this.M;
    }

    @Override // com.baidu.tbadk.widget.a
    public final void a(com.baidu.tbadk.widget.b bVar) {
        if (bVar != null) {
            this.an.remove(bVar);
        }
    }

    public final void l() {
        while (this.an.size() > 0) {
            com.baidu.tbadk.widget.b remove = this.an.remove(0);
            if (remove != null) {
                remove.invalidate();
            }
        }
    }

    public static /* synthetic */ void a(FrsActivity frsActivity, com.baidu.tieba.im.message.s sVar) {
        if (sVar != null) {
            if (!(sVar instanceof com.baidu.tieba.im.message.v)) {
                com.baidu.adp.lib.util.e.b("transform error");
                return;
            }
            com.baidu.tieba.im.message.v vVar = (com.baidu.tieba.im.message.v) sVar;
            int c = vVar.c();
            int a2 = vVar.a();
            int b2 = vVar.b();
            int d = vVar.d();
            if (frsActivity.H != null) {
                frsActivity.H.a(c);
                frsActivity.H.c(a2);
                frsActivity.H.b(b2);
                frsActivity.H.d(d);
                frsActivity.p.a(frsActivity.H);
            }
        }
    }

    public static /* synthetic */ void b(FrsActivity frsActivity, com.baidu.tieba.im.message.s sVar) {
        List<com.baidu.tieba.d.a> a2;
        al m;
        HashMap<Integer, com.baidu.tieba.data.az> d;
        if (frsActivity.A == null || frsActivity.p == null || !(sVar instanceof com.baidu.tieba.d.b) || (a2 = ((com.baidu.tieba.d.b) sVar).a()) == null || (m = frsActivity.p.m()) == null || (d = m.d()) == null || d.size() <= 0) {
            return;
        }
        for (com.baidu.tieba.d.a aVar : a2) {
            if (aVar != null) {
                Iterator<Map.Entry<Integer, com.baidu.tieba.data.az>> it = d.entrySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        Map.Entry<Integer, com.baidu.tieba.data.az> next = it.next();
                        int intValue = next.getKey().intValue();
                        com.baidu.tieba.data.az value = next.getValue();
                        if (value != null && (value instanceof g) && ((g) value).v().equals(aVar.a())) {
                            if (m.getItem(intValue) instanceof g) {
                                g gVar = (g) m.getItem(intValue);
                                int f = aVar.f();
                                if (f == 3 || f == 0) {
                                    gVar.d(2);
                                } else if (f == 2 || f == 4) {
                                    if (!com.baidu.tieba.util.bs.c(aVar.n())) {
                                        frsActivity.showToast(aVar.n());
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
        frsActivity.p.q();
    }

    private void s() {
        HashMap<Integer, com.baidu.tieba.data.az> d;
        if ((this.p != null || this.p.m() != null) && (d = this.p.m().d()) != null) {
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
