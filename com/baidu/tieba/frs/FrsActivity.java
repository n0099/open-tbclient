package com.baidu.tieba.frs;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.BaobaoSdkDelegate;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.home.CreateBarActivity;
import com.baidu.tieba.util.AntiHelper;
import com.baidu.tieba.view.FrsCommonImageLayout;
import com.slidingmenu.lib.SlidingMenu;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes.dex */
public class FrsActivity extends BaseActivity implements com.baidu.adp.widget.BdSwitchView.c, com.baidu.tbadk.core.view.w, com.baidu.tbadk.core.voice.aa, com.baidu.tieba.util.n, com.baidu.tieba.view.s {
    private static final CustomMessageListener ag;
    private static boolean am;
    public static final CustomMessageListener e;
    private df O;
    private ay W;
    private String aa;
    private com.baidu.tbadk.core.data.m ab;
    private com.baidu.tieba.model.aq ac;
    private Context ad;
    VoiceManager g;
    private com.baidu.tbadk.core.data.m i;
    private boolean j;
    public static String a = "has_shown_frs_guide";
    public static boolean b = true;
    public static boolean c = true;
    public static boolean d = false;
    private static volatile long z = 0;
    private static volatile long A = 0;
    private static volatile int B = 0;
    private boolean h = false;
    private boolean k = true;
    private int l = 3;
    private String m = null;
    private String n = null;
    private int o = 0;
    private int p = 1;
    private boolean q = false;
    private boolean r = false;
    private boolean s = false;
    private String t = null;
    private boolean u = false;
    private ct v = null;
    private String w = null;
    private String x = null;
    private final com.baidu.tbadk.core.data.m y = null;
    private long C = 0;
    private boolean D = false;
    private boolean E = true;
    private boolean F = true;
    private com.baidu.tieba.b.a G = null;
    private g H = null;
    private com.baidu.tieba.model.ae I = null;
    private com.baidu.tieba.model.be J = null;
    private com.baidu.tieba.model.ba K = null;
    private Handler L = null;
    private long M = 0;
    private String N = "normal_page";
    private com.baidu.tbadk.core.data.m P = null;
    private final com.baidu.adp.lib.d.b<TbImageView> Q = UserIconBox.a(this, 8);
    private final com.baidu.adp.lib.d.b<TbImageView> R = FrsCommonImageLayout.a(this, 6);
    private boolean S = false;
    private long T = -1;
    private AlertDialog U = null;
    private String V = "";
    private WriteImagesInfo X = new WriteImagesInfo();
    private WriteImagesInfo Y = new WriteImagesInfo();
    private WriteData Z = new WriteData();
    private boolean ae = true;
    private final com.baidu.tieba.model.ar af = new l(this);
    public final CustomMessageListener f = new as(this, 2012111);
    private final di ah = new at(this);
    private final dh ai = new au(this);
    private Handler aj = null;
    private com.baidu.tbadk.core.util.b ak = null;
    private final CustomMessageListener al = new av(this, 2003003);
    private final com.baidu.adp.widget.ListView.x an = new aw(this);
    private final com.baidu.adp.widget.ListView.z ao = new ax(this);
    private final AdapterView.OnItemClickListener ap = new m(this);
    private final AdapterView.OnItemLongClickListener aq = new o(this);
    private final com.baidu.adp.widget.ListView.d ar = new p(this);
    private final View.OnClickListener as = new q(this);
    private final AbsListView.OnScrollListener at = new r(this);
    private final SlidingMenu.OnClosedListener au = new s(this);
    private final bk av = new t(this);
    private final Cdo aw = new Cdo(new u(this));
    private final SlidingMenu.OnOpenedListener ax = new v(this);
    private final AdapterView.OnItemClickListener ay = new w(this);
    private final com.baidu.tbadk.core.view.m az = new y(this);
    private final CustomMessageListener aA = new z(this, 0);
    private AlertDialog aB = null;
    private final com.baidu.adp.framework.listener.b aC = new aa(this, 301001);
    private final HttpMessageListener aD = new ab(this, 1001703);

    static {
        p();
        q();
        f();
        e = new x(2012111);
        ag = new ai(2012112);
        MessageManager.getInstance().registerListener(e);
        MessageManager.getInstance().registerListener(ag);
        am = false;
    }

    private static void p() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2003000, new ac());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void q() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2003001, new ad());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void f() {
        com.baidu.tbadk.core.util.bq.a().a(new ae());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkApplication.m252getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar) {
        if (gVar != null && gVar.g() != null) {
            this.v.m().a(gVar.g().getRecommendForumData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(g gVar) {
        com.baidu.tbadk.core.data.k k;
        int i;
        int i2;
        boolean z2 = true;
        if (gVar != null && gVar.g() != null && (k = gVar.k()) != null && k.c() == 1) {
            boolean f = gVar.f();
            if (gVar.q() == null || !gVar.q().a()) {
                z2 = false;
            }
            if (f || z2) {
                com.baidu.tieba.data.af afVar = new com.baidu.tieba.data.af();
                afVar.a(f);
                afVar.e(gVar.r());
                afVar.a(gVar.q());
                afVar.c(1003);
                ArrayList<com.baidu.tbadk.core.data.m> h = gVar.h();
                if (h != null && h.size() > 0) {
                    Iterator<com.baidu.tbadk.core.data.m> it = h.iterator();
                    while (true) {
                        i2 = i;
                        i = (it.hasNext() && it.next().u() != 0) ? i2 + 1 : 0;
                    }
                    gVar.h().add(i2, afVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(g gVar) {
        int i;
        if (gVar != null && gVar.g() != null) {
            if (this.H != null) {
                this.H.a(gVar.g().getAnchorPower());
            }
            this.v.a(gVar);
            ArrayList<LiveCardData> a2 = gVar.a();
            ArrayList<com.baidu.tbadk.core.data.m> h = gVar.h();
            this.v.u().a(-1);
            if (a2 != null && a2.size() > 0 && h != null && h.size() > 0) {
                int i2 = 0;
                Iterator<com.baidu.tbadk.core.data.m> it = h.iterator();
                while (true) {
                    i = i2;
                    if (it.hasNext() && it.next().u() != 0) {
                        i2 = i + 1;
                    }
                }
                com.baidu.tbadk.core.data.h hVar = new com.baidu.tbadk.core.data.h();
                hVar.a(a2);
                gVar.h().add(i, hVar);
                this.v.u().a(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(g gVar) {
        if (gVar != null && gVar.g() != null) {
            com.baidu.tbadk.core.data.c bannerListData = gVar.g().getBannerListData();
            ArrayList<com.baidu.tbadk.core.data.m> h = gVar.h();
            int size = gVar.h().size();
            if (bannerListData != null && bannerListData.a() != null && h != null && h.size() > 0) {
                Iterator<com.baidu.tbadk.core.data.m> it = h.iterator();
                int i = 0;
                while (it.hasNext() && it.next().u() != 0) {
                    i++;
                }
                int size2 = bannerListData.a().size();
                if (size2 >= 1) {
                    for (int i2 = 0; i2 < 3; i2++) {
                        com.baidu.tbadk.core.data.b bVar = bannerListData.a().get(new Random().nextInt(size2));
                        long a2 = com.baidu.tbadk.i.a().a(bVar.i(), 0L);
                        if (!com.baidu.tieba.util.r.a(this, bVar.i()) && ((bVar.d() != 1 || !TbadkApplication.m252getInst().getHasShowAppForums().contains(this.m)) && (bVar.d() != 2 || System.currentTimeMillis() - a2 > 86400000))) {
                            int e2 = (i + bVar.e()) - 1;
                            if (e2 < size && !TextUtils.isEmpty(bVar.i()) && !TextUtils.isEmpty(bVar.g())) {
                                boolean b2 = b.a().b(bVar.i());
                                boolean c2 = b.a().c(bVar.i());
                                if (b2) {
                                    bVar.a(1);
                                } else if (c2) {
                                    bVar.a(2);
                                } else {
                                    bVar.a(0);
                                }
                                gVar.h().add(e2, bVar);
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j jVar) {
        if (this.k) {
            if (jVar != null) {
                if (jVar.a && jVar.b) {
                    if (jVar.c == 3) {
                        this.q = false;
                        this.m = this.m.replace(" ", "");
                        String str = this.m;
                        if (str.length() > 31) {
                            str = String.valueOf(str.substring(0, 31)) + "...";
                        }
                        this.v.b(str);
                    } else if (UtilHelper.getNetStatusInfo(this) != UtilHelper.NetworkStateInfo.UNAVAIL) {
                        this.v.a(jVar.d);
                    }
                } else if (UtilHelper.getNetStatusInfo(this) != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    this.v.a(jVar.d);
                }
            }
        } else if (jVar != null) {
            this.v.a(jVar.d);
        }
    }

    public static Intent a(Context context, String str) {
        Class<?> intentClass;
        if (str == null || str.length() <= 0 || (intentClass = TbadkApplication.m252getInst().getIntentClass(com.baidu.tbadk.core.atomData.ao.class)) == null) {
            return null;
        }
        Intent intent = new Intent(context, intentClass);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        intent.setFlags(603979776);
        intent.putExtra("fname", str);
        intent.putExtra("from_short_cut", true);
        intent.putExtra("back_special", true);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.FROM, "short_cut");
        return intent;
    }

    private void r() {
        int i = TbConfig.PB_IMAGE_NEW_MAX_WIDTH;
        this.ak = new com.baidu.tbadk.core.util.b(this);
        this.ak.a(true);
        int a2 = com.baidu.adp.lib.util.j.a((Context) this, 427.0f);
        if (a2 <= 640) {
            i = a2;
        }
        this.ak.a(i, (int) (i * 1.6f));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ad = this;
        Intent intent = getIntent();
        if (intent != null) {
            this.T = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.T = System.currentTimeMillis();
        }
        if (z() && !y()) {
            registerListener(this.al);
            registerListener(this.aC);
            registerListener(this.aD);
            registerListener(this.f);
            this.g = d();
            this.g.onCreate(this);
            C();
            a(bundle);
            this.v.R();
            this.aw.setUniqueId(getUniqueId());
            this.aw.a();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.g = d();
        this.g.onStart(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(g gVar) {
        if (gVar != null) {
            try {
                if (this.E) {
                    this.v.I();
                    this.E = false;
                }
                if (gVar.o() == 1) {
                    this.v.u().f(true);
                } else {
                    this.v.u().f(false);
                }
                this.v.a(gVar.g());
                if (gVar.l().a() == 1) {
                    this.N = "frs_page";
                    this.v.A();
                } else {
                    this.N = "normal_page";
                    this.v.z();
                }
                this.v.x();
                this.m = gVar.g().getName();
                this.v.c(this.m);
                G();
                b(gVar);
                d(gVar);
                c(gVar);
                com.baidu.tbadk.core.data.n top_notice_data = gVar.g().getTop_notice_data();
                if (top_notice_data != null && top_notice_data.a() != null) {
                    com.baidu.tbadk.core.data.m mVar = new com.baidu.tbadk.core.data.m();
                    mVar.c(top_notice_data.a());
                    mVar.c(2);
                    mVar.b(top_notice_data.b());
                    mVar.L();
                    gVar.a(mVar);
                }
                ArrayList<com.baidu.tbadk.core.data.m> h = gVar.h();
                if (h != null) {
                    this.v.a(h, this.p, this.H);
                    M();
                    this.v.k(this.p);
                    if (this.N.equals("frs_page")) {
                        this.v.a(gVar.g(), gVar);
                    } else if (this.N.equals("normal_page")) {
                        this.v.b(gVar.g(), gVar);
                    }
                    this.v.b(this.p);
                    this.v.c(gVar.k().e());
                    this.v.L();
                    this.v.d(0);
                }
                if (gVar.f()) {
                    if (this.v.v() != null) {
                        this.v.v().h();
                    }
                    if (this.v.w() != null) {
                        this.v.w().g();
                        return;
                    }
                    return;
                }
                if (this.v.v() != null) {
                    this.v.v().g();
                }
                if (this.v.w() != null) {
                    this.v.w().f();
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    private void a(Bundle bundle) {
        this.aj = new Handler();
        r();
        w();
        this.s = TbadkApplication.isLogin();
        if (bundle != null) {
            this.m = bundle.getString("name");
            this.n = bundle.getString(com.baidu.tbadk.core.frameworkData.a.FROM);
            this.o = bundle.getInt("flag", 0);
        } else {
            Intent intent = getIntent();
            this.m = intent.getStringExtra("name");
            this.n = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.FROM);
            this.o = intent.getIntExtra("flag", 0);
            this.D = intent.getBooleanExtra("good", false);
        }
        if (this.D) {
            this.v.ab().setVisibility(4);
            this.v.ac().setVisibility(0);
            this.v.ad().setVisibility(4);
        } else {
            this.v.ab().setVisibility(0);
            this.v.ac().setVisibility(4);
            this.v.ad().setVisibility(4);
        }
        if (this.m != null && this.m.length() > 0) {
            if (this.n == null || this.n.length() <= 0) {
                this.n = "tb_forumlist";
            }
            this.w = this.n;
            v();
            s();
            t();
            u();
            this.O = new df(this);
            if (this.s) {
                g();
                x();
            }
            if (bundle != null) {
                this.X = (WriteImagesInfo) bundle.getSerializable("write_images");
                this.aa = bundle.getString("photo_name");
            }
            this.X.setMaxImagesAllowed(10);
            this.ac = new com.baidu.tieba.model.aq();
            this.ac.a(this.af);
        }
    }

    private void s() {
        this.I = new com.baidu.tieba.model.ae();
        this.I.setLoadDataCallBack(new af(this));
    }

    private void t() {
        this.J = new com.baidu.tieba.model.be();
        this.J.a("from_frs");
        this.J.a(new ag(this));
    }

    private void u() {
        this.K = new com.baidu.tieba.model.ba();
        this.K.setLoadDataCallBack(new ah(this));
    }

    @SuppressLint({"HandlerLeak"})
    private void v() {
        this.L = new aj(this);
    }

    public void g() {
        if (this.O != null && this.v != null && b) {
            this.O.b(com.baidu.tbadk.coreExtra.messageCenter.a.a().k());
            this.O.a(com.baidu.tbadk.coreExtra.messageCenter.a.a().l());
            this.O.c(com.baidu.tbadk.coreExtra.messageCenter.a.a().m());
            this.v.a(this.O, b, c);
        }
    }

    private void w() {
        registerListener(2001122, this.aA);
    }

    private void x() {
        registerListener(2001124, this.aA);
    }

    private boolean y() {
        if ("from_hao123".equals(getIntent().getStringExtra(com.baidu.tbadk.core.frameworkData.a.FROM)) && com.baidu.tieba.util.r.a((Activity) this)) {
            Intent intent = new Intent();
            intent.putExtra("class", 2);
            intent.putExtra("fname", getIntent().getStringExtra("name"));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.ao(this, intent)));
            finish();
            return true;
        }
        return false;
    }

    private boolean z() {
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
                        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.FROM, "short_cut");
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.ao(this, intent)));
                        finish();
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.v != null) {
            this.v.s();
        }
        if (this.L != null) {
            this.L.removeMessages(1);
        }
        super.onDestroy();
        try {
            if (this.H != null) {
                this.H.n();
            }
            if (this.I != null) {
                this.I.a();
            }
            if (this.K != null) {
                this.K.a();
            }
            if (this.ac != null) {
                this.ac.cancelLoadData();
            }
            this.v.O();
            System.gc();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        this.g = d();
        this.g.onDestory(this);
        com.baidu.tieba.ai.c().K();
        this.U = null;
        if (this.W != null) {
            this.W.cancel(true);
            this.W = null;
        }
        if (this.G != null) {
            this.G.b();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.m);
        bundle.putString(com.baidu.tbadk.core.frameworkData.a.FROM, this.n);
        this.g = d();
        if (this.g != null) {
            this.g.onSaveInstanceState(this);
        }
        bundle.putSerializable("write_images", this.X);
        bundle.putString("photo_name", this.aa);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        int size;
        boolean z2;
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
                    c(this.y);
                    return;
                case 11012:
                    d(this.P);
                    return;
                case 11013:
                    D();
                    return;
                case 11014:
                    l();
                    return;
                case 11016:
                    this.v.J();
                    return;
                case 11021:
                    if (this.H != null) {
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
                    if (this.X != null) {
                        b(intent);
                        int size2 = this.X.size() - 1;
                        if (size2 > -1 && this.X.getChosedFiles() != null && (size = this.X.getChosedFiles().size()) >= 1 && size2 >= 0 && size2 < size) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.bx(this, 12012, this.X, size2)));
                            return;
                        }
                        return;
                    }
                    return;
                case 12002:
                    a(intent);
                    return;
                case 12004:
                    ArrayList<String> a2 = com.baidu.tieba.util.i.a(intent);
                    if (a2 != null) {
                        this.v.a(a2);
                        return;
                    }
                    return;
                case 12006:
                    WriteData a3 = this.ac.a();
                    if (a3 != null) {
                        a3.deleteUploadedTempImages();
                    }
                    this.Z.setIsBaobao(false);
                    this.Z.setBaobaoContent(null);
                    this.Y.clear();
                    this.ac.a((WriteData) null);
                    this.ac.a(false);
                    this.v.g(true);
                    com.baidu.tieba.util.m.b(this.ab.q(), (WriteData) null);
                    if (this.X != null) {
                        this.v.a(this.X, true);
                    }
                    this.ab.b(this.ab.s() + 1);
                    this.v.y();
                    this.v.T();
                    return;
                case 12012:
                    c(intent);
                    return;
                case 12013:
                    d(intent);
                    return;
                case 13003:
                    E();
                    return;
                case 18003:
                    this.v.u().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null) {
                        int size3 = this.H.h().size();
                        int i3 = 0;
                        while (true) {
                            if (i3 >= size3) {
                                z2 = false;
                            } else if (stringExtra.equals(this.H.h().get(i3).p())) {
                                z2 = true;
                            } else {
                                i3++;
                            }
                        }
                        if (z2) {
                            int intExtra = intent.getIntExtra("type", 0);
                            if (intExtra == 2) {
                                this.H.h().get(i3).d(intent.getIntExtra("good_data", 0));
                                this.H.h().get(i3).L();
                                E();
                            } else if (intExtra == 0) {
                                this.H.h().remove(i3);
                                this.v.L();
                                if (f.a() != null) {
                                    f.a().b(this.m);
                                }
                            }
                        }
                    }
                    if (intent.getBooleanExtra("praise_changed", false)) {
                        a(intent.getStringExtra("praise_changed_tid"), intent.getIntExtra("praise_like_num", 0));
                        return;
                    }
                    return;
                case 18004:
                    K();
                    return;
                case 23004:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12001:
                    N();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        String stringExtra2 = intent.getStringExtra("last_album_id");
                        if (this.X != null) {
                            this.X.setLastAlbumId(stringExtra2);
                            return;
                        }
                        return;
                    }
                    return;
                case 12003:
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        NetworkInfo activeNetworkInfo;
        super.onResume();
        this.j = true;
        this.ae = true;
        this.v.c.u();
        NoNetworkView q = this.v.q();
        if (q != null && q.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            q.a(false);
        }
        if (am) {
            am = false;
            this.v.R();
        } else if (d) {
            d = false;
            this.v.R();
        } else {
            if (!this.s && TbadkApplication.isLogin()) {
                this.s = true;
                if (this.H != null && this.H.j() != null) {
                    this.H.j().setIfpost(1);
                }
                E();
            }
            if (this.L != null) {
                this.L.removeMessages(1);
                this.L.sendMessageDelayed(this.L.obtainMessage(1), 1000L);
            }
            this.g = d();
            this.g.onResume(this);
            MessageManager.getInstance().sendMessage(new CustomMessage(2007001, new com.baidu.tbadk.core.atomData.ae(this, false)));
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.m = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.FROM))) {
                this.n = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.FROM);
            }
            this.r = intent.getBooleanExtra("refresh_all", false);
            if (this.r) {
                if (intent.getBooleanExtra("content_show", false)) {
                    A();
                } else {
                    B();
                }
            }
        }
    }

    private void A() {
        this.v.R();
        this.v.n().showContent(false);
    }

    private void B() {
        this.v.R();
        this.v.n().toggle(false);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
            return;
        }
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            com.baidu.tbadk.core.b.b.a(this, 1);
        } else {
            com.baidu.tbadk.core.b.b.a(this, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h() {
        this.v.O();
        finish();
        CompatibleUtile.setAnim(this, com.baidu.tieba.p.frs_browser_enter, com.baidu.tieba.p.no_effect);
    }

    private void C() {
        this.k = true;
        this.m = "";
        this.n = "";
        this.o = 0;
        this.p = 1;
        this.D = false;
        this.C = 0L;
        this.l = 3;
        this.v = new ct(this, this.as);
        this.v.m().b();
        this.v.a(this.an);
        this.v.a(this.ao);
        this.v.a(this.ap);
        this.v.a(this.aq);
        this.v.a(this.at);
        this.v.a(this.ar);
        this.v.a(this.au);
        this.v.a(this.ax);
        this.v.a(this.az);
        this.v.a(new ak(this));
        this.v.u().a(this.av);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.v.j(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.y.login_to_use), true, 11013);
            return;
        }
        CreateBarActivity.a(this, this.m, true);
        finish();
    }

    @Override // com.baidu.tieba.view.s
    public com.baidu.adp.lib.d.b<TbImageView> e() {
        return this.R;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Intent a2;
        if (str != null && (a2 = a((Context) this, str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + getString(com.baidu.tieba.y.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", a2);
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this, com.baidu.tieba.u.icon));
            sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        String str2;
        String str3 = Build.MODEL;
        if (!TextUtils.isEmpty(str3) && str3.startsWith("MI")) {
            str2 = "content://com.miui.home.launcher.settings/favorites?notify=true";
        } else if (!TextUtils.isEmpty(str3) && str3.equals("MT788")) {
            str2 = "content://com.motorola.mmsp.motohomex.settings/favorites?notify=true";
        } else if (Build.VERSION.SDK_INT < 8) {
            str2 = "content://com.android.launcher.settings/favorites?notify=true";
        } else {
            str2 = "content://com.android.launcher2.settings/favorites?notify=true";
        }
        Cursor query = getContentResolver().query(Uri.parse(str2), null, "title=?", new String[]{String.valueOf(str) + getString(com.baidu.tieba.y.bar)}, null);
        return query != null && query.getCount() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            if (this.H != null && this.H.j() != null) {
                this.H.j().setIfpost(1);
            }
            if (i == 0) {
                LoginActivity.a((Activity) this, getString(com.baidu.tieba.y.login_to_use), true, 11001);
            } else {
                LoginActivity.a((Activity) this, getString(com.baidu.tieba.y.login_to_use), true, 11016);
            }
        } else if (this.H != null) {
            if (i == 0) {
                AntiData j = this.H.j();
                if (AntiHelper.a(j) || AntiHelper.b(j) || AntiHelper.c(j)) {
                    j.setBlock_forum_name(this.m);
                    j.setBlock_forum_id(this.H.g().getId());
                    j.setUser_name(this.H.i().getUserName());
                    j.setUser_id(this.H.i().getUserId());
                    if (AntiHelper.a(this, j, AntiHelper.OperationType.CREATE_THREAD, AntiHelper.PageType.FRS)) {
                        return;
                    }
                }
                if (this.H.j() != null && this.H.j().getIfpost() == 0) {
                    com.baidu.adp.lib.util.j.a((Context) this, j.getForbid_info());
                    return;
                }
                int i2 = 0;
                if (this.H.i() != null) {
                    i2 = this.H.i().getIsMem();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.bv(this, 0, this.H.g().getId(), this.m, null, null, 0, this.H.j(), 13003, false, false, null, false, false, null, null, this.H.g().getPrefixData(), i2)));
                return;
            }
            this.v.J();
        }
    }

    private boolean a(com.baidu.tbadk.core.data.m mVar) {
        String userId;
        return mVar == null || mVar.y() == null || (userId = mVar.y().getUserId()) == null || userId.equals("0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.m mVar) {
        boolean a2 = a(mVar);
        this.v.a(new al(this, mVar));
        this.v.a(mVar, a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.m mVar) {
        boolean a2 = a(mVar);
        if (this.t != null) {
            if (!a2) {
                sendMessage(new CustomMessage(2004001, new com.baidu.tbadk.core.atomData.aw(this).a(mVar, this.m, null, 18003, true, true, this.u)));
            } else {
                sendMessage(new CustomMessage(2004001, new com.baidu.tbadk.core.atomData.aw(this).a(mVar, this.m, null, 18003, false, false, this.u)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.core.data.m mVar) {
        if (this.t != null) {
            sendMessage(new CustomMessage(2004001, new com.baidu.tbadk.core.atomData.aw(this).a(mVar, this.m, null, 18003, false, false, this.u)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        L();
        this.p = 1;
        this.l = 3;
        F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        boolean z2 = false;
        switch (this.l) {
            case 1:
                if (this.v.u().a()) {
                    return;
                }
                break;
            case 2:
                if (this.v.u().b()) {
                    return;
                }
                break;
            case 3:
                if (this.v.t()) {
                    return;
                }
                break;
        }
        FRSPageRequestMessage fRSPageRequestMessage = new FRSPageRequestMessage();
        fRSPageRequestMessage.setKw(this.m);
        fRSPageRequestMessage.setPn(this.p);
        if (this.H == null) {
            this.H = new g();
        }
        fRSPageRequestMessage.setForumModel(this.H);
        if (com.baidu.tbadk.core.h.a().f()) {
            fRSPageRequestMessage.setRn(35);
        } else {
            fRSPageRequestMessage.setRn(50);
        }
        fRSPageRequestMessage.setWithGroup(1);
        if (this.D) {
            fRSPageRequestMessage.setIsGood(1);
            fRSPageRequestMessage.setCid((int) this.C);
        }
        int b2 = com.baidu.adp.lib.util.j.b(this);
        int c2 = com.baidu.adp.lib.util.j.c(this);
        float f = b2 / 320.0f;
        int i = com.baidu.tbadk.core.util.bn.a().b() ? 2 : 1;
        fRSPageRequestMessage.setScrW(b2);
        fRSPageRequestMessage.setScrH(c2);
        fRSPageRequestMessage.setScrDip(f);
        fRSPageRequestMessage.setqType(i);
        if (this.w != null) {
            fRSPageRequestMessage.setStType(this.w);
            if (this.w.equalsIgnoreCase("sidebar")) {
                fRSPageRequestMessage.setStType(this.x);
            }
        }
        if (z != 0) {
            fRSPageRequestMessage.setCtime((int) z);
        }
        if (A != 0) {
            fRSPageRequestMessage.setDataSize((int) A);
        }
        if (B != 0) {
            fRSPageRequestMessage.setNetError(B);
        }
        this.v.b(true);
        this.v.u().b(false);
        this.v.u().c(false);
        this.v.u().notifyDataSetChanged();
        if (this.p == 1 && ((this.N.equals("normal_page") || this.N.equals("frs_page")) && !this.D)) {
            z2 = true;
        }
        if (this.H == null) {
            this.H = new g();
        }
        this.H.a(this.ah);
        this.H.a(this, fRSPageRequestMessage, this.l, z2, this.m);
        if (this.G == null) {
            this.G = new com.baidu.tieba.b.a("frsStat");
            this.G.a();
        }
    }

    private void G() {
        switch (this.o) {
            case 1:
                com.baidu.tieba.util.k.f(this.m);
                break;
        }
        this.o = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        L();
        try {
            if (this.H != null) {
                this.v.x();
                this.m = this.H.g().getName();
                this.v.c(this.m);
                TbadkApplication.m252getInst().setDefaultBubble(this.H.i().getBimg_url());
                TbadkApplication.m252getInst().setDefaultBubbleEndTime(this.H.i().getBimg_end_time());
                this.v.c.u();
                G();
                this.k = false;
                ArrayList<com.baidu.tbadk.core.data.m> h = this.H.h();
                if (h != null) {
                    this.v.a(h, this.p, this.H);
                    M();
                    this.v.k(this.p);
                    if (this.N.equals("frs_page")) {
                        I();
                    } else if (this.N.equals("normal_page")) {
                        this.v.b(this.H.g(), this.H);
                    }
                    this.v.b(this.p);
                    this.v.c(this.H.k().e());
                    this.v.L();
                    if (this.H.o() == 1) {
                        this.v.u().f(true);
                    } else {
                        this.v.u().f(false);
                    }
                    if (this.l == 1) {
                        this.v.d(3);
                    } else if (this.l == 2) {
                        if (this.p == 1) {
                            this.v.d(0);
                        } else {
                            this.v.d(3);
                        }
                    } else {
                        this.v.d(0);
                    }
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.j = false;
        this.ae = false;
        this.v.N();
        if (this.L != null) {
            this.L.removeMessages(1);
        }
        this.g = d();
        this.g.onPause(this);
        O();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.g = d();
        if (this.g != null) {
            this.g.onStop(this);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.q) {
            if (i == 4) {
                if (this.v.n().isMenuShowing()) {
                    this.v.n().toggle(true);
                    if (this.v.m().d()) {
                        this.v.m().b(false);
                        E();
                        return true;
                    }
                    return true;
                } else if (this.v.c.p()) {
                    this.v.T();
                    return true;
                } else {
                    closeActivity();
                    return true;
                }
            }
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    public void a(com.baidu.tbadk.core.data.b bVar, int i) {
        String str;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(com.baidu.tieba.y.anti_title);
        builder.setIcon((Drawable) null);
        builder.setCancelable(true);
        if (bVar.d() == 2) {
            if (!TextUtils.isEmpty(bVar.j())) {
                str = getString(com.baidu.tieba.y.pb_app_download_ask);
            } else {
                str = getString(com.baidu.tieba.y.confirm_download_app_web_url);
            }
        } else {
            str = String.valueOf(getString(com.baidu.tieba.y.confirm_download_app)) + bVar.g() + getString(com.baidu.tieba.y.question_mark);
        }
        builder.setMessage(str);
        builder.setPositiveButton(com.baidu.tieba.y.alert_yes_button, new am(this, bVar, i));
        builder.setNegativeButton(com.baidu.tieba.y.alert_no_button, new an(this));
        this.U = builder.create();
        this.U.show();
    }

    public void b(com.baidu.tbadk.core.data.b bVar, int i) {
        if (!((TextUtils.isEmpty(bVar.i()) || TextUtils.isEmpty(bVar.g())) ? false : true)) {
            com.baidu.adp.lib.util.j.a((Context) this, com.baidu.tieba.y.pb_app_error);
        } else if (UtilHelper.isNetOk()) {
            TiebaStatic.eventStat(this, "frs_dl_app", null, 1, "app_name", bVar.i());
            b.a().a(bVar.i(), bVar.j(), bVar.g(), i);
        } else {
            showToast(com.baidu.tieba.y.neterror);
        }
    }

    public void a(com.baidu.tbadk.core.data.b bVar) {
        String i = bVar.i();
        if (TextUtils.isEmpty(i)) {
            com.baidu.adp.lib.util.j.a((Context) this, com.baidu.tieba.y.pb_app_error);
            return;
        }
        File d2 = com.baidu.tbadk.core.util.z.d(String.valueOf(i.replace(".", "_")) + ".apk");
        if (d2 != null) {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(d2), "application/vnd.android.package-archive");
            startActivity(intent);
        }
    }

    private void I() {
        this.v.a(this.H.g(), this.H);
        this.L.removeMessages(1);
        if (this.p == 1 && this.N.equals("frs_page") && this.H.l().f() == 0) {
            this.M = System.nanoTime() / 1000000000;
            if (this.H.l().g() > 0) {
                this.L.sendMessageDelayed(this.L.obtainMessage(1), 1000L);
            }
        }
    }

    public void i() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.y.login_to_use), true, 11021);
        } else if (!this.H.m()) {
            this.H.a(true);
            this.H.a(this.ai);
            this.H.a(String.valueOf(this.H.g().isLike()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        this.v.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        com.baidu.tbadk.browser.a.a(this, String.valueOf(TbConfig.SERVER_ADDRESS) + "mo/q/fudaiindex?fid=" + this.H.g().getId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.y.login_to_use), true, 11002);
            return;
        }
        this.I.a("from_frs");
        this.I.a(this.H.g().getName(), this.H.g().getId());
    }

    protected void k() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(com.baidu.tieba.y.attention_cancel_info));
        builder.setTitle(getString(com.baidu.tieba.y.alerm_title));
        builder.setPositiveButton(getString(com.baidu.tieba.y.attention_cancel), new ao(this));
        builder.setNegativeButton(getString(com.baidu.tieba.y.cancel), new ap(this));
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.y.login_to_use), true, 11014);
            return;
        }
        if (this.N.equals("normal_page")) {
            this.v.C();
        } else if (this.N.equals("frs_page")) {
            this.v.E();
        }
        this.K.a(this.H.g().getName(), this.H.g().getId());
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.v.m().c()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                if (TbadkApplication.m252getInst().getSkinType() != 1) {
                    TiebaStatic.eventStat(this, "frs_night_mode", "frsclick", 1, new Object[0]);
                    com.baidu.tieba.ai.c().c(1);
                    this.mSkinType = 1;
                    TiebaStatic.eventStat(TbadkApplication.m252getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                } else {
                    return;
                }
            } else if (TbadkApplication.m252getInst().getSkinType() != 0) {
                com.baidu.tieba.ai.c().c(0);
                this.mSkinType = 0;
            } else {
                return;
            }
            onChangeSkinType(this.mSkinType);
            com.baidu.tbadk.core.util.h.a();
            com.baidu.tieba.pb.main.bq.a().f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        ArrayList<com.baidu.tbadk.core.data.m> h = this.H.h();
        if (h != null) {
            Iterator<com.baidu.tbadk.core.data.m> it = h.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.core.data.m next = it.next();
                if (next == this.i) {
                    if (i == 1) {
                        PraiseData o = next.o();
                        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
                        if (currentAccountObj != null) {
                            MetaData metaData = new MetaData();
                            metaData.setName_show(currentAccountObj.getAccount());
                            metaData.setPortrait(currentAccountObj.getPortrait());
                            metaData.setUserId(currentAccountObj.getID());
                            if (o == null) {
                                PraiseData praiseData = new PraiseData();
                                praiseData.setIsLike(i);
                                praiseData.setNum(1L);
                                praiseData.getUser().add(0, metaData);
                                next.a(praiseData);
                            } else {
                                next.o().getUser().add(0, metaData);
                                next.o().setNum(next.o().getNum() + 1);
                                next.o().setIsLike(i);
                            }
                        }
                    } else if (next.o() != null) {
                        next.o().setIsLike(i);
                        next.o().setNum(next.o().getNum() - 1);
                        ArrayList<MetaData> user = next.o().getUser();
                        if (user != null) {
                            Iterator<MetaData> it2 = user.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                MetaData next2 = it2.next();
                                if (next2.getUserId().equals(TbadkApplication.getCurrentAccountObj().getID())) {
                                    next.o().getUser().remove(next2);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            this.v.u().a(h, this.H);
            this.v.u().notifyDataSetChanged();
        }
    }

    private void a(String str, int i) {
        ArrayList<com.baidu.tbadk.core.data.m> h;
        if (this.H != null && (h = this.H.h()) != null) {
            Iterator<com.baidu.tbadk.core.data.m> it = h.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.core.data.m next = it.next();
                if (next.q() != null && next.p().equals(str)) {
                    if (i == 1) {
                        PraiseData o = next.o();
                        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
                        if (currentAccountObj != null) {
                            MetaData metaData = new MetaData();
                            metaData.setName_show(currentAccountObj.getAccount());
                            metaData.setPortrait(currentAccountObj.getPortrait());
                            metaData.setUserId(currentAccountObj.getID());
                            if (o == null) {
                                PraiseData praiseData = new PraiseData();
                                praiseData.setIsLike(i);
                                praiseData.setNum(1L);
                                praiseData.getUser().add(0, metaData);
                                next.a(praiseData);
                            } else {
                                next.o().getUser().add(0, metaData);
                                next.o().setNum(next.o().getNum() + 1);
                                next.o().setIsLike(i);
                            }
                        }
                    } else if (next.o() != null) {
                        next.o().setIsLike(i);
                        next.o().setNum(next.o().getNum() - 1);
                        ArrayList<MetaData> user = next.o().getUser();
                        if (user != null) {
                            Iterator<MetaData> it2 = user.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                MetaData next2 = it2.next();
                                if (next2.getUserId().equals(TbadkApplication.getCurrentAccountObj().getID())) {
                                    next.o().getUser().remove(next2);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            this.v.u().a(h, this.H);
            this.v.u().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (str != null) {
            if (TbadkApplication.m252getInst().isFrsImageForum(str)) {
                sendMessage(new CustomMessage(2003002, new com.baidu.tbadk.core.atomData.r(this).b(str, null, 0)));
                h();
                return;
            }
            if (this.v.n().isMenuShowing()) {
                this.v.n().toggle(true);
            }
            this.D = false;
            this.m = str;
            E();
        }
    }

    @Override // com.baidu.tbadk.core.voice.aa
    public VoiceManager d() {
        if (this.g == null) {
            this.g = VoiceManager.instance();
        }
        return this.g;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.w
    /* renamed from: m */
    public BdListView a() {
        if (this.v == null) {
            return null;
        }
        return this.v.K();
    }

    @Override // com.baidu.tbadk.core.voice.aa
    public com.baidu.tbadk.core.voice.y a(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        this.g = d();
        this.g.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.w
    public int c_() {
        if (this.v == null) {
            return 0;
        }
        return this.v.S();
    }

    @Override // com.baidu.tbadk.core.view.w
    public com.baidu.adp.lib.d.b<TbImageView> c() {
        return this.Q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgReplyme = newsNotifyMessage.getMsgReplyme();
            int msgAtme = newsNotifyMessage.getMsgAtme();
            int msgChat = newsNotifyMessage.getMsgChat();
            if (this.O != null) {
                this.O.b(msgReplyme);
                this.O.a(msgAtme);
                this.O.c(msgChat);
                this.v.a(this.O, b, c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        az u;
        HashMap<Integer, com.baidu.tbadk.core.data.m> c2;
        if (this.H != null && this.v != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null && (u = this.v.u()) != null && (c2 = u.c()) != null && c2.size() > 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null) {
                    Iterator<Map.Entry<Integer, com.baidu.tbadk.core.data.m>> it = c2.entrySet().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Map.Entry<Integer, com.baidu.tbadk.core.data.m> next = it.next();
                            int intValue = next.getKey().intValue();
                            com.baidu.tbadk.core.data.m value = next.getValue();
                            if (value != null && (value instanceof com.baidu.tbadk.core.data.b) && ((com.baidu.tbadk.core.data.b) value).i().equals(downloadData.getId())) {
                                if (u.getItem(intValue) instanceof com.baidu.tbadk.core.data.b) {
                                    com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) u.getItem(intValue);
                                    int status = downloadData.getStatus();
                                    if (status == 3 || status == 0) {
                                        bVar.a(2);
                                    } else if (status == 2 || status == 4) {
                                        if (!com.baidu.tbadk.core.util.bm.c(downloadData.getStatusMsg())) {
                                            showToast(downloadData.getStatusMsg());
                                        }
                                        bVar.a(0);
                                    } else if (status == 1) {
                                        bVar.a(1);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            this.v.y();
        }
    }

    private void M() {
        HashMap<Integer, com.baidu.tbadk.core.data.m> c2;
        if (this.v != null && this.v.u() != null && (c2 = this.v.u().c()) != null) {
            ArrayList<com.baidu.tbadk.core.data.b> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, com.baidu.tbadk.core.data.m> entry : c2.entrySet()) {
                com.baidu.tbadk.core.data.m value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.b)) {
                    arrayList.add((com.baidu.tbadk.core.data.b) value);
                }
            }
            b.a().a(arrayList);
        }
    }

    public void a(int i, com.baidu.tbadk.core.data.m mVar, int i2) {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.y.login_to_use), true, 0);
            return;
        }
        if (this.ab != mVar && this.ab != null) {
            O();
            this.v.d((String) null);
            this.X = new WriteImagesInfo();
            this.X.setMaxImagesAllowed(10);
            this.v.a(this.X, true);
            this.ac.a((WriteData) null);
            this.ac.a(false);
            this.v.W();
            com.baidu.tieba.util.m.a(mVar.q(), this);
        }
        this.ab = mVar;
        this.v.a(i, mVar, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Boolean bool) {
        if (com.baidu.tieba.d.b.a(this.H.g().getName(), bool)) {
            this.v.aa();
        } else {
            this.v.Z();
        }
    }

    private void a(Intent intent) {
        a(intent, true);
    }

    private void b(Intent intent) {
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aa;
        if (!TextUtils.isEmpty(str)) {
            try {
                int b2 = com.baidu.tbadk.core.util.h.b(str);
                if (b2 != 0) {
                    Bitmap a2 = com.baidu.tbadk.core.util.h.a(str, com.baidu.adp.lib.util.j.a(this, com.baidu.adp.lib.util.j.b(this)), com.baidu.adp.lib.util.j.a(this, com.baidu.adp.lib.util.j.c(this)));
                    Bitmap e2 = com.baidu.tbadk.core.util.h.e(a2, b2);
                    if (a2 != e2) {
                        a2.recycle();
                    }
                    com.baidu.tbadk.core.util.z.a(TbConfig.LOCAL_CAMERA_DIR, this.aa, e2, 100);
                    e2.recycle();
                }
            } catch (Exception e3) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.X.addChooseFile(imageFileInfo);
            this.X.updateQuality();
            this.v.a(this.X, true);
        }
        if (this.X.getChosedFiles() != null && this.X.getChosedFiles().size() > 0) {
            this.v.c.b(23);
        }
    }

    private void c(Intent intent) {
        a(intent, false);
    }

    private void a(Intent intent, boolean z2) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.X.parseJson(stringExtra);
                this.X.updateQuality();
                if (this.X.getChosedFiles() != null) {
                    this.v.a(this.X, z2);
                }
            }
            if (this.X.getChosedFiles() != null && this.X.getChosedFiles().size() > 0) {
                this.v.c.b(23);
            }
        }
    }

    private void N() {
        new aq(this).execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n() {
        if (this.aB == null) {
            String[] strArr = {getString(com.baidu.tieba.y.take_photo), getString(com.baidu.tieba.y.album)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(com.baidu.tieba.y.operation));
            builder.setItems(strArr, new ar(this));
            this.aB = builder.create();
            this.aB.setCanceledOnTouchOutside(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        if (this.ac.a() == null) {
            WriteData o = o();
            o.setWriteImagesInfo(this.X);
            this.ac.a(this.X.size() > 0);
            this.ac.a(o);
        }
        if (this.ac.a() != null) {
            if (this.Z.getIsBaobao()) {
                this.ac.a().setIsBaobao(true);
                this.ac.a().setBaobaoContent(this.Z.getBaobaoContent());
                this.ac.a().setBaobaoImagesInfo(this.Y);
            } else {
                this.ac.a().setIsBaobao(false);
                this.ac.a().setBaobaoContent("");
                this.Y.clear();
            }
            this.ac.a().setIsFrsReply(true);
            this.ac.a().setContent(this.v.U());
            VoiceData.VoiceModel V = this.v.V();
            this.v.X();
            if (V != null) {
                if (V.getId() != null) {
                    this.ac.a().setVoice(V.getId());
                    this.ac.a().setVoiceDuringTime(V.duration);
                } else {
                    this.ac.a().setVoice(null);
                    this.ac.a().setVoiceDuringTime(-1);
                }
            } else {
                this.ac.a().setVoice(null);
                this.ac.a().setVoiceDuringTime(-1);
            }
            if (!this.ac.c()) {
                showToast(com.baidu.tieba.y.write_img_limit);
            } else if (this.ac.b()) {
                this.v.Y();
            }
        }
    }

    public WriteData o() {
        WriteData writeData = new WriteData();
        writeData.setForumId(this.H.g().getId());
        writeData.setForumName(this.H.g().getName());
        writeData.setThreadId(this.ab.q());
        writeData.setIsAd(false);
        writeData.setType(1);
        return writeData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.a(antiData) || AntiHelper.b(antiData) || AntiHelper.c(antiData) || AntiHelper.d(antiData)) {
            antiData.setBlock_forum_name(this.ab.z());
            antiData.setBlock_forum_id(this.H.g().getId());
            antiData.setUser_name(this.ab.y().getUserName());
            antiData.setUser_id(this.ab.y().getUserId());
            AntiHelper.a(this, antiData, AntiHelper.OperationType.REPLY, AntiHelper.PageType.PB);
            return;
        }
        com.baidu.adp.lib.util.j.a((Context) this, str);
    }

    @Override // com.baidu.tieba.util.n
    public void a(WriteData writeData) {
        if (writeData != null && this.ab != null && writeData.getThreadId().equals(this.ab.q())) {
            if (!com.baidu.tbadk.core.util.bm.c(writeData.getContent()) && com.baidu.tbadk.core.util.bm.c(this.v.U())) {
                this.v.d(writeData.getContent());
            }
            if (writeData.getWriteImagesInfo() != null && this.X.size() == 0) {
                this.X.copyFrom(writeData.getWriteImagesInfo());
                this.v.a(this.X, true);
            }
            if (TbadkApplication.m252getInst().isBaobaoShouldOpen() && writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                this.Y.copyFrom(writeData.getBaobaoImagesInfo());
                this.Z.setIsBaobao(writeData.getIsBaobao());
                this.Z.setBaobaoContent(writeData.getBaobaoContent());
                this.v.a(this.Y);
            }
        }
    }

    private void O() {
        if (this.ab != null) {
            WriteData a2 = this.ac.a();
            if (a2 == null) {
                a2 = new WriteData(1);
                a2.setThreadId(this.ab.q());
                a2.setWriteImagesInfo(this.X);
            }
            a2.setContent(this.v.U());
            if (this.Z != null && this.Z.getIsBaobao()) {
                a2.setBaobaoContent(this.Z.getBaobaoContent());
                a2.setBaobaoImagesInfo(this.Y);
                a2.setIsBaobao(true);
            }
            com.baidu.tieba.util.m.b(this.ab.q(), a2);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return a();
    }

    private void d(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(BaobaoSdkDelegate.KEY_BITMAPPATH);
            String stringExtra2 = intent.getStringExtra(BaobaoSdkDelegate.KEY_CONTENT);
            if (stringExtra != null && stringExtra2 != null) {
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(stringExtra);
                this.Y.clear();
                this.Y.addChooseFile(imageFileInfo);
                this.v.a(this.Y);
                if (this.Y.getChosedFiles() != null && this.Y.getChosedFiles().size() > 0) {
                    this.v.c.b(48);
                    this.Z.setIsBaobao(true);
                    this.Z.setBaobaoContent(stringExtra2);
                    this.Z.setBaobaoImagesInfo(this.Y);
                    return;
                }
                this.Z.setIsBaobao(false);
                this.Z.setBaobaoContent("");
                this.Z.setBaobaoImagesInfo(this.Y);
            }
        }
    }
}
