package com.baidu.tieba.frs;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
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
import com.baidu.adp.lib.util.BdNetUtil;
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
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes.dex */
public class FrsActivity extends BaseActivity implements com.baidu.adp.widget.BdSwitchView.c, com.baidu.tbadk.core.view.aa, com.baidu.tbadk.core.voice.aa, com.baidu.tieba.util.n, com.baidu.tieba.view.q {
    private static final CustomMessageListener ai;
    private static boolean ao;
    public static String b;
    public static final CustomMessageListener f;
    private di S;
    private bb Z;
    private String ad;
    private com.baidu.tbadk.core.data.n ae;
    private com.baidu.tieba.model.ar af;
    VoiceManager h;
    private com.baidu.tbadk.core.data.n j;
    private boolean k;
    public static String a = "has_shown_frs_guide";
    private static boolean l = true;
    private static boolean m = true;
    private static boolean n = true;
    public static int c = 0;
    public static int d = 1;
    public static boolean e = false;
    private static volatile long D = 0;
    private static volatile long E = 0;
    private static volatile int F = 0;
    private boolean i = false;
    private boolean o = true;
    private int p = 3;
    private String q = null;
    private String r = null;
    private int s = 0;
    private int t = 1;
    private boolean u = false;
    private boolean v = false;
    private boolean w = false;
    private String x = null;
    private boolean y = false;
    private cu z = null;
    private String A = null;
    private String B = null;
    private final com.baidu.tbadk.core.data.n C = null;
    private long G = 0;
    private boolean H = false;
    private boolean I = true;
    private boolean J = true;
    private com.baidu.tieba.b.a K = null;
    private g L = null;
    private com.baidu.tieba.model.af M = null;
    private com.baidu.tieba.model.bf N = null;
    private com.baidu.tieba.model.bb O = null;
    private Handler P = null;
    private long Q = 0;
    private String R = "normal_page";
    private com.baidu.tbadk.core.data.n T = null;
    private final com.baidu.adp.lib.d.b<TbImageView> U = UserIconBox.a(this, 8);
    private final com.baidu.adp.lib.d.b<TbImageView> V = FrsCommonImageLayout.a(this, 6);
    private boolean W = false;
    private long X = -1;
    private String Y = "";
    private WriteImagesInfo aa = new WriteImagesInfo();
    private WriteImagesInfo ab = new WriteImagesInfo();
    private WriteData ac = new WriteData();
    private boolean ag = true;
    private final com.baidu.tieba.model.as ah = new l(this);
    public final CustomMessageListener g = new at(this, 2012111);
    private final dl aj = new aw(this);
    private final dk ak = new ax(this);
    private Handler al = null;
    private final CustomMessageListener am = new ay(this, 2003003);
    private final CustomMessageListener an = new az(this, 2001200);
    private final com.baidu.adp.widget.ListView.x ap = new ba(this);
    private final com.baidu.adp.widget.ListView.z aq = new m(this);
    private final AdapterView.OnItemClickListener ar = new n(this);
    private final AdapterView.OnItemLongClickListener as = new p(this);
    private final com.baidu.adp.widget.ListView.d at = new q(this);
    private final View.OnClickListener au = new r(this);
    private final AbsListView.OnScrollListener av = new s(this);
    private final SlidingMenu.OnClosedListener aw = new t(this);
    private final bl ax = new u(this);
    private final dr ay = new dr(new v(this));
    private final SlidingMenu.OnOpenedListener az = new w(this);
    private final View.OnClickListener aA = new y(this);
    private final View.OnClickListener aB = new z(this);
    private final AdapterView.OnItemClickListener aC = new aa(this);
    private final com.baidu.tbadk.core.view.q aD = new ab(this);
    private final CustomMessageListener aE = new ac(this, 0);
    private AlertDialog aF = null;
    private final com.baidu.adp.framework.listener.d aG = new ad(this, 301001);
    private final HttpMessageListener aH = new ae(this, CmdConfigHttp.FRS_HTTP_CMD);

    static {
        o();
        p();
        q();
        f = new x(2012111);
        ai = new ai(2012112);
        MessageManager.getInstance().registerListener(f);
        MessageManager.getInstance().registerListener(ai);
        ao = false;
    }

    private static void o() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2003000, new af());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void p() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2003001, new ag());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void q() {
        com.baidu.tbadk.core.util.bg.a().a(new ah());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkApplication.m252getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar) {
        if (gVar != null && gVar.i() != null) {
            this.z.n().a(gVar.i().getRecommendForumData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(g gVar) {
        com.baidu.tbadk.core.data.l m2;
        int i;
        int i2;
        boolean z = true;
        if (gVar != null && gVar.i() != null && (m2 = gVar.m()) != null && m2.d() == 1) {
            boolean h = gVar.h();
            if (gVar.s() == null || !gVar.s().a()) {
                z = false;
            }
            if (h || z) {
                com.baidu.tieba.data.ag agVar = new com.baidu.tieba.data.ag();
                agVar.a(h);
                agVar.e(gVar.t());
                agVar.a(gVar.s());
                agVar.b(1003);
                ArrayList<com.baidu.tbadk.core.data.n> j = gVar.j();
                if (j != null && j.size() > 0) {
                    Iterator<com.baidu.tbadk.core.data.n> it = j.iterator();
                    while (true) {
                        i2 = i;
                        i = (it.hasNext() && it.next().m() != 0) ? i2 + 1 : 0;
                    }
                    gVar.j().add(i2, agVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(g gVar) {
        if (gVar != null && gVar.i() != null) {
            if (this.L != null) {
                this.L.a(gVar.i().getAnchorPower());
            }
            this.z.a(gVar);
            ArrayList<LiveCardData> c2 = gVar.c();
            ArrayList<com.baidu.tbadk.core.data.n> j = gVar.j();
            this.z.v().a(-1);
            if (c2 != null && c2.size() > 0 && j != null && j.size() > 0) {
                int d2 = d(gVar);
                com.baidu.tbadk.core.data.i iVar = new com.baidu.tbadk.core.data.i();
                iVar.a(c2);
                gVar.j().add(d2, iVar);
                this.z.v().a(d2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(g gVar) {
        int i = 0;
        ArrayList<com.baidu.tbadk.core.data.n> j = gVar.j();
        if (j == null || j.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.tbadk.core.data.n> it = j.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext() && it.next().m() != 0) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(g gVar) {
        if (gVar != null && gVar.i() != null) {
            com.baidu.tbadk.core.data.d bannerListData = gVar.i().getBannerListData();
            ArrayList<com.baidu.tbadk.core.data.n> j = gVar.j();
            int size = gVar.j().size();
            if (bannerListData != null && bannerListData.a() != null && j != null && j.size() > 0) {
                Iterator<com.baidu.tbadk.core.data.n> it = j.iterator();
                int i = 0;
                while (it.hasNext()) {
                    if (it.next().m() != 0) {
                        i++;
                    }
                }
                int size2 = bannerListData.a().size();
                if (size2 >= 1) {
                    HashSet hashSet = new HashSet();
                    for (int i2 = 0; i2 < size2; i2++) {
                        com.baidu.tbadk.core.data.a aVar = bannerListData.a().get(i2);
                        int i3 = (aVar.h + i) - 1;
                        if (!hashSet.contains(Integer.valueOf(i3)) && aVar.a() && i3 < size) {
                            if (aVar.b()) {
                                if (!com.baidu.tieba.d.b.a(this, aVar.g) && !TextUtils.isEmpty(aVar.g) && !TextUtils.isEmpty(aVar.c)) {
                                    boolean b2 = b.a().b(aVar.g);
                                    boolean c2 = b.a().c(aVar.g);
                                    if (b2) {
                                        aVar.a = 1;
                                    } else if (c2) {
                                        aVar.a = 2;
                                    } else {
                                        aVar.a = 0;
                                    }
                                    hashSet.add(Integer.valueOf(i3));
                                    gVar.j().add(i3, aVar);
                                }
                            } else if (aVar.c()) {
                                hashSet.add(Integer.valueOf(i3));
                                gVar.j().add(i3, aVar);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j jVar) {
        if (this.o) {
            if (jVar != null) {
                if (jVar.a && jVar.b) {
                    if (jVar.c == 3) {
                        this.u = false;
                        this.q = this.q.replace(" ", "");
                        String str = this.q;
                        if (str.length() > 31) {
                            str = String.valueOf(str.substring(0, 31)) + "...";
                        }
                        this.z.a(str);
                    } else if (UtilHelper.getNetStatusInfo(this) != UtilHelper.NetworkStateInfo.UNAVAIL) {
                        showToast(jVar.d);
                    }
                } else if (UtilHelper.getNetStatusInfo(this) != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    showToast(jVar.d);
                }
            }
        } else if (jVar != null) {
            showToast(jVar.d);
        }
    }

    public static Intent a(Context context, String str) {
        Class<?> intentClass;
        if (str == null || str.length() <= 0 || (intentClass = TbadkApplication.m252getInst().getIntentClass(com.baidu.tbadk.core.atomData.ar.class)) == null) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b = "speed_icon_show" + TbadkApplication.getCurrentAccount();
        Intent intent = getIntent();
        if (bundle != null) {
            this.q = bundle.getString("name");
            this.r = bundle.getString(com.baidu.tbadk.core.frameworkData.a.FROM);
            this.s = bundle.getInt("flag", 0);
        } else if (intent != null) {
            this.q = intent.getStringExtra("name");
            this.r = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.FROM);
            this.s = intent.getIntExtra("flag", 0);
        }
        if (intent != null) {
            this.X = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.X = System.currentTimeMillis();
        }
        if (y() && !x()) {
            registerListener(this.am);
            registerListener(this.an);
            registerListener(this.aG);
            registerListener(this.aH);
            registerListener(this.g);
            this.h = d();
            this.h.onCreate(this);
            B();
            a(bundle);
            this.z.S();
            this.ay.setUniqueId(getUniqueId());
            this.ay.a();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.h = d();
        this.h.onStart(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(g gVar) {
        ArrayList<LiveCardData> c2;
        if (gVar != null) {
            try {
                if (this.I) {
                    this.z.H();
                    this.z.v().a(this.aA);
                    this.z.v().b(this.aB);
                    this.I = false;
                }
                if (gVar.q() == 1) {
                    this.z.v().f(true);
                } else {
                    this.z.v().f(false);
                }
                this.z.a(gVar.i(), gVar.k());
                if (gVar.n().a() == 1) {
                    this.R = "frs_page";
                    this.z.b(gVar.k().getIsMem(), this.L.i().isLike());
                } else {
                    this.R = "normal_page";
                    this.z.a(gVar.k().getIsMem(), this.L.i().isLike());
                }
                this.z.y();
                this.q = gVar.i().getName();
                this.z.b(this.q);
                E();
                b(gVar);
                e(gVar);
                c(gVar);
                com.baidu.tbadk.core.data.o top_notice_data = gVar.i().getTop_notice_data();
                if (top_notice_data != null && top_notice_data.a() != null) {
                    com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
                    nVar.c(top_notice_data.a());
                    nVar.b(2);
                    nVar.b(top_notice_data.b());
                    nVar.D();
                    gVar.a(nVar);
                    if (this.z.v() != null && (c2 = gVar.c()) != null && c2.size() > 0) {
                        this.z.v().a(d(gVar));
                    }
                }
                ArrayList<com.baidu.tbadk.core.data.n> j = gVar.j();
                if (j != null) {
                    this.z.a(j, this.t, this.L);
                    K();
                    this.z.l(this.t);
                    if (this.R.equals("frs_page")) {
                        this.z.a(gVar.i(), gVar);
                    } else if (this.R.equals("normal_page")) {
                        this.z.b(gVar.i(), gVar);
                    }
                    this.z.b(this.t);
                    this.z.c(gVar.m().f());
                    this.z.K();
                    this.z.d(0);
                }
                if (gVar.h()) {
                    if (this.z.w() != null) {
                        this.z.w().k();
                    }
                    if (this.z.x() != null) {
                        this.z.x().l();
                        return;
                    }
                    return;
                }
                if (this.z.w() != null) {
                    this.z.w().j();
                }
                if (this.z.x() != null) {
                    this.z.x().k();
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    private void a(Bundle bundle) {
        this.al = new Handler();
        v();
        this.w = TbadkApplication.isLogin();
        if (bundle != null) {
            this.q = bundle.getString("name");
            this.r = bundle.getString(com.baidu.tbadk.core.frameworkData.a.FROM);
            this.s = bundle.getInt("flag", 0);
        } else {
            Intent intent = getIntent();
            this.q = intent.getStringExtra("name");
            this.r = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.FROM);
            this.s = intent.getIntExtra("flag", 0);
            this.H = intent.getBooleanExtra("good", false);
        }
        this.z.e(this.H);
        if (this.q != null && this.q.length() > 0) {
            if (this.r == null || this.r.length() <= 0) {
                this.r = "tb_forumlist";
            }
            this.A = this.r;
            u();
            r();
            s();
            t();
            this.S = new di(this);
            if (this.w) {
                f();
                w();
            }
            if (bundle != null) {
                this.aa = (WriteImagesInfo) bundle.getSerializable("write_images");
                this.ad = bundle.getString("photo_name");
            }
            this.aa.setMaxImagesAllowed(10);
            this.af = new com.baidu.tieba.model.ar();
            this.af.a(this.ah);
        }
    }

    private void r() {
        this.M = new com.baidu.tieba.model.af();
        this.M.setLoadDataCallBack(new aj(this));
    }

    private void s() {
        this.N = new com.baidu.tieba.model.bf();
        this.N.a("from_frs");
        this.N.a(new ak(this));
    }

    private void t() {
        this.O = new com.baidu.tieba.model.bb();
        this.O.setLoadDataCallBack(new al(this));
    }

    @SuppressLint({"HandlerLeak"})
    private void u() {
        this.P = new am(this);
    }

    public void f() {
        if (this.S != null && this.z != null) {
            if (l || m || n) {
                this.S.b(com.baidu.tbadk.coreExtra.messageCenter.a.a().m());
                this.S.a(com.baidu.tbadk.coreExtra.messageCenter.a.a().n());
                this.S.c(com.baidu.tbadk.coreExtra.messageCenter.a.a().o());
                this.z.a(this.S, l, m, n);
            }
        }
    }

    private void v() {
        registerListener(2001122, this.aE);
    }

    private void w() {
        registerListener(2001124, this.aE);
    }

    private boolean x() {
        if ("from_hao123".equals(getIntent().getStringExtra(com.baidu.tbadk.core.frameworkData.a.FROM)) && com.baidu.tieba.util.r.a((Activity) this)) {
            Intent intent = new Intent();
            intent.putExtra("class", 2);
            intent.putExtra("fname", getIntent().getStringExtra("name"));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.ar(this, intent)));
            finish();
            return true;
        }
        return false;
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
                        intent.putExtra("fname", getIntent().getStringExtra("name"));
                        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.FROM, "short_cut");
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.ar(this, intent)));
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
        if (this.z != null) {
            this.z.t();
        }
        if (this.P != null) {
            this.P.removeMessages(1);
        }
        super.onDestroy();
        try {
            if (this.L != null) {
                this.L.p();
            }
            if (this.M != null) {
                this.M.a();
            }
            if (this.O != null) {
                this.O.a();
            }
            if (this.af != null) {
                this.af.cancelLoadData();
            }
            this.z.P();
            System.gc();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        this.h = d();
        this.h.onDestory(this);
        com.baidu.tieba.ai.c().J();
        if (this.Z != null) {
            this.Z.cancel(true);
            this.Z = null;
        }
        if (this.K != null) {
            this.K.b();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.q);
        bundle.putString(com.baidu.tbadk.core.frameworkData.a.FROM, this.r);
        this.h = d();
        if (this.h != null) {
            this.h.onSaveInstanceState(this);
        }
        bundle.putSerializable("write_images", this.aa);
        bundle.putString("photo_name", this.ad);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        int size;
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
                    c(this.C);
                    return;
                case 11012:
                    d(this.T);
                    return;
                case 11013:
                    C();
                    return;
                case 11014:
                    k();
                    return;
                case 11016:
                    this.z.I();
                    return;
                case 11021:
                    if (this.L != null) {
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
                    if (this.aa != null) {
                        L();
                        int size2 = this.aa.size() - 1;
                        if (size2 > -1 && this.aa.getChosedFiles() != null && (size = this.aa.getChosedFiles().size()) >= 1 && size2 >= 0 && size2 < size) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.cg(this, 12012, this.aa, size2)));
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
                        this.z.a(a2);
                        return;
                    }
                    return;
                case 12006:
                    WriteData a3 = this.af.a();
                    if (a3 != null) {
                        a3.deleteUploadedTempImages();
                    }
                    this.ac.setIsBaobao(false);
                    this.ac.setBaobaoContent(null);
                    this.ab.clear();
                    this.af.a((WriteData) null);
                    this.af.a(false);
                    this.z.h(true);
                    com.baidu.tieba.util.m.b(this.ae.i(), (WriteData) null);
                    if (this.aa != null) {
                        this.z.a(this.aa, true);
                    }
                    this.ae.a(this.ae.k() + 1);
                    this.z.z();
                    this.z.U();
                    return;
                case 12012:
                    b(intent);
                    return;
                case 12013:
                    c(intent);
                    return;
                case 13003:
                    D();
                    return;
                case 18003:
                    this.z.v().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null) {
                        int size3 = this.L.j().size();
                        int i3 = 0;
                        while (true) {
                            if (i3 >= size3) {
                                z = false;
                            } else if (stringExtra.equals(this.L.j().get(i3).h())) {
                                z = true;
                            } else {
                                i3++;
                            }
                        }
                        if (z) {
                            int intExtra = intent.getIntExtra("type", 0);
                            if (intExtra == 2) {
                                this.L.j().get(i3).c(intent.getIntExtra("good_data", 0));
                                this.L.j().get(i3).D();
                                D();
                            } else if (intExtra == 0) {
                                this.L.j().remove(i3);
                                this.z.K();
                                if (f.a() != null) {
                                    f.a().a(this.q, false);
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
                    I();
                    return;
                case 23004:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12001:
                    M();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        String stringExtra2 = intent.getStringExtra("last_album_id");
                        if (this.aa != null) {
                            this.aa.setLastAlbumId(stringExtra2);
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
        this.k = true;
        this.ag = true;
        this.z.c.u();
        NoNetworkView r = this.z.r();
        if (r != null && r.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            r.a(false);
        }
        if (ao) {
            ao = false;
            this.z.S();
        } else if (e) {
            e = false;
            this.z.S();
        } else {
            if (!this.w && TbadkApplication.isLogin()) {
                this.w = true;
                if (this.L != null && this.L.l() != null) {
                    this.L.l().setIfpost(1);
                }
                D();
            }
            if (this.P != null) {
                this.P.removeMessages(1);
                this.P.sendMessageDelayed(this.P.obtainMessage(1), 1000L);
            }
            this.h = d();
            this.h.onResume(this);
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.q = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.FROM))) {
                this.r = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.FROM);
            }
            this.v = intent.getBooleanExtra("refresh_all", false);
            if (this.v) {
                if (intent.getBooleanExtra("content_show", false)) {
                    z();
                } else {
                    A();
                }
            }
        }
    }

    private void z() {
        this.z.S();
        this.z.o().showContent(false);
    }

    private void A() {
        this.z.S();
        this.z.o().toggle(false);
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
    public void g() {
        this.z.P();
        finish();
        CompatibleUtile.setAnim(this, com.baidu.tieba.o.frs_browser_enter, com.baidu.tieba.o.no_effect);
    }

    private void B() {
        this.o = true;
        this.t = 1;
        this.H = false;
        this.G = 0L;
        this.p = 3;
        if (TextUtils.isEmpty(this.q)) {
            this.q = "";
        }
        if (TextUtils.isEmpty(this.r)) {
            this.r = "";
        }
        setContentView(com.baidu.tieba.v.frs_activity);
        this.z = new cu(this, this.au);
        if (this.s == 0) {
            this.z.b(this.q);
        } else {
            this.z.b("");
            this.s = 1;
        }
        this.z.n().b();
        this.z.a(this.ap);
        this.z.a(this.aq);
        this.z.a(this.ar);
        this.z.a(this.as);
        this.z.a(this.av);
        this.z.a(this.at);
        this.z.a(this.aw);
        this.z.a(this.az);
        this.z.a(this.aD);
        this.z.a(new an(this));
        this.z.v().a(this.ax);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.z.k(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.x.login_to_use), true, 11013);
            return;
        }
        CreateBarActivity.a(this, this.q, true);
        finish();
    }

    @Override // com.baidu.tieba.view.q
    public com.baidu.adp.lib.d.b<TbImageView> e() {
        return this.V;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Intent a2;
        if (str != null && (a2 = a((Context) this, str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + getString(com.baidu.tieba.x.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", a2);
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this, com.baidu.tieba.t.icon));
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
        Cursor query = getContentResolver().query(Uri.parse(str2), null, "title=?", new String[]{String.valueOf(str) + getString(com.baidu.tieba.x.bar)}, null);
        return query != null && query.getCount() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            if (this.L != null && this.L.l() != null) {
                this.L.l().setIfpost(1);
            }
            if (i == 0) {
                LoginActivity.a((Activity) this, getString(com.baidu.tieba.x.login_to_use), true, 11001);
            } else {
                LoginActivity.a((Activity) this, getString(com.baidu.tieba.x.login_to_use), true, 11016);
            }
        } else if (this.L != null) {
            if (i == 0) {
                AntiData l2 = this.L.l();
                if (AntiHelper.a(l2) || AntiHelper.b(l2) || AntiHelper.c(l2)) {
                    l2.setBlock_forum_name(this.q);
                    l2.setBlock_forum_id(this.L.i().getId());
                    l2.setUser_name(this.L.k().getUserName());
                    l2.setUser_id(this.L.k().getUserId());
                    if (AntiHelper.a(this, l2, AntiHelper.OperationType.CREATE_THREAD, AntiHelper.PageType.FRS)) {
                        return;
                    }
                }
                if (this.L.l() != null && this.L.l().getIfpost() == 0) {
                    com.baidu.adp.lib.util.j.a((Context) this, l2.getForbid_info());
                    return;
                }
                int i2 = 0;
                if (this.L.k() != null) {
                    i2 = this.L.k().getIsMem();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.ce(this, 0, this.L.i().getId(), this.q, null, null, 0, this.L.l(), 13003, false, false, null, false, false, null, null, this.L.i().getPrefixData(), i2)));
                return;
            }
            this.z.I();
        }
    }

    private boolean a(com.baidu.tbadk.core.data.n nVar) {
        String userId;
        return nVar == null || nVar.q() == null || (userId = nVar.q().getUserId()) == null || userId.equals("0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.n nVar) {
        boolean a2 = a(nVar);
        this.z.a(new ao(this, nVar));
        this.z.a(nVar, a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.n nVar) {
        boolean a2 = a(nVar);
        if (this.x != null) {
            if (!a2) {
                sendMessage(new CustomMessage(2004001, new com.baidu.tbadk.core.atomData.bb(this).a(nVar, this.q, null, 18003, true, true, this.y)));
            } else {
                sendMessage(new CustomMessage(2004001, new com.baidu.tbadk.core.atomData.bb(this).a(nVar, this.q, null, 18003, false, false, this.y)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.core.data.n nVar) {
        if (this.x != null) {
            sendMessage(new CustomMessage(2004001, new com.baidu.tbadk.core.atomData.bb(this).a(nVar, this.q, null, 18003, false, false, this.y)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        J();
        this.t = 1;
        c(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        boolean z = false;
        this.p = i;
        switch (this.p) {
            case 1:
                if (this.z.v().a()) {
                    return;
                }
                break;
            case 2:
                if (this.z.v().b()) {
                    return;
                }
                break;
            case 3:
                if (this.z.u()) {
                    return;
                }
                break;
        }
        FRSPageRequestMessage fRSPageRequestMessage = new FRSPageRequestMessage();
        fRSPageRequestMessage.setKw(this.q);
        fRSPageRequestMessage.setPn(this.t);
        if (this.L == null) {
            this.L = new g();
        }
        fRSPageRequestMessage.setForumModel(this.L);
        if (com.baidu.tbadk.core.h.a().f()) {
            fRSPageRequestMessage.setRn(35);
        } else {
            fRSPageRequestMessage.setRn(50);
        }
        fRSPageRequestMessage.setWithGroup(1);
        if (this.H) {
            fRSPageRequestMessage.setIsGood(1);
            fRSPageRequestMessage.setCid((int) this.G);
        }
        int b2 = com.baidu.adp.lib.util.j.b(this);
        int c2 = com.baidu.adp.lib.util.j.c(this);
        float f2 = b2 / 320.0f;
        int i2 = com.baidu.tbadk.core.util.bb.a().b() ? 2 : 1;
        fRSPageRequestMessage.setScrW(b2);
        fRSPageRequestMessage.setScrH(c2);
        fRSPageRequestMessage.setScrDip(f2);
        fRSPageRequestMessage.setqType(i2);
        if (this.L != null && this.L.i() != null && this.L.i().getBannerListData() != null) {
            fRSPageRequestMessage.setLastId(this.L.i().getBannerListData().b());
        }
        if (this.A != null) {
            fRSPageRequestMessage.setStType(this.A);
            if (this.A.equalsIgnoreCase("sidebar")) {
                fRSPageRequestMessage.setStType(this.B);
            }
        }
        if (D != 0) {
            fRSPageRequestMessage.setCtime((int) D);
        }
        if (E != 0) {
            fRSPageRequestMessage.setDataSize((int) E);
        }
        if (F != 0) {
            fRSPageRequestMessage.setNetError(F);
        }
        this.z.b(true);
        this.z.v().b(false);
        this.z.v().c(false);
        this.z.v().notifyDataSetChanged();
        if (this.t == 1 && ((this.R.equals("normal_page") || this.R.equals("frs_page")) && !this.H)) {
            z = true;
        }
        if (this.L == null) {
            this.L = new g();
        }
        this.L.a(this.aj);
        this.L.a(this, fRSPageRequestMessage, this.p, z, this.q);
        if (this.K == null) {
            this.K = new com.baidu.tieba.b.a("frsStat");
            this.K.a();
        }
    }

    private void E() {
        switch (this.s) {
            case 1:
                com.baidu.tieba.util.k.e(this.q);
                break;
        }
        this.s = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        J();
        try {
            if (this.L != null) {
                this.z.y();
                this.q = this.L.i().getName();
                this.z.b(this.q);
                TbadkApplication.m252getInst().setDefaultBubble(this.L.k().getBimg_url());
                TbadkApplication.m252getInst().setDefaultBubbleEndTime(this.L.k().getBimg_end_time());
                this.z.c.u();
                E();
                this.o = false;
                ArrayList<com.baidu.tbadk.core.data.n> j = this.L.j();
                if (j != null) {
                    this.z.a(j, this.t, this.L);
                    K();
                    this.z.l(this.t);
                    if (this.R.equals("frs_page")) {
                        G();
                    } else if (this.R.equals("normal_page")) {
                        this.z.b(this.L.i(), this.L);
                    }
                    this.z.b(this.t);
                    this.z.c(this.L.m().f());
                    this.z.K();
                    if (this.L.q() == 1) {
                        this.z.v().f(true);
                    } else {
                        this.z.v().f(false);
                    }
                    if (this.p == 1) {
                        this.z.d(3);
                    } else if (this.p == 2) {
                        if (this.t == 1) {
                            this.z.d(0);
                        } else {
                            this.z.d(3);
                        }
                    } else {
                        this.z.d(0);
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
        this.k = false;
        this.ag = false;
        this.z.O();
        if (this.P != null) {
            this.P.removeMessages(1);
        }
        this.h = d();
        this.h.onPause(this);
        N();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.distribute.a.a().a(this, "frs", this.L.i().getId(), 0L);
        this.h = d();
        if (this.h != null) {
            this.h.onStop(this);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.u) {
            if (i == 4) {
                if (this.z.o().isMenuShowing()) {
                    this.z.o().toggle(true);
                    if (this.z.n().d()) {
                        this.z.n().b(false);
                        D();
                        return true;
                    }
                    return true;
                } else if (this.z.c.p()) {
                    this.z.U();
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

    public void a(com.baidu.tbadk.core.data.a aVar, int i) {
        String trim;
        if (aVar != null) {
            com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(this);
            aVar2.a(com.baidu.tieba.x.anti_title);
            if (aVar.c()) {
                com.baidu.tbadk.core.util.bg.a().a(this, new String[]{aVar.e});
            } else if (aVar.b()) {
                BdNetUtil.NetworkStateInfo statusInfo = BdNetUtil.getStatusInfo();
                if (BdNetUtil.NetworkStateInfo.UNAVAIL != statusInfo && BdNetUtil.NetworkStateInfo.WIFI != statusInfo) {
                    trim = getString(com.baidu.tieba.x.frs_network_tips);
                } else if (TextUtils.isEmpty(aVar.s.f.trim())) {
                    trim = getString(com.baidu.tieba.x.confirm_download_app);
                } else {
                    trim = aVar.s.f.trim();
                }
                aVar2.b(trim);
                aVar2.a(com.baidu.tieba.x.alert_yes_button, new ap(this, aVar, i));
                aVar2.b(com.baidu.tieba.x.alert_no_button, new aq(this));
                aVar2.a().b();
            }
        }
    }

    public void b(com.baidu.tbadk.core.data.a aVar, int i) {
        if (aVar != null) {
            if (!aVar.a()) {
                com.baidu.adp.lib.util.j.a((Context) this, com.baidu.tieba.x.pb_app_error);
            } else if (UtilHelper.isNetOk()) {
                TiebaStatic.eventStat(this, "frs_dl_app", null, 1, "app_name", aVar.g);
                b.a().a(aVar.g, aVar.f, aVar.c, i);
            } else {
                showToast(com.baidu.tieba.x.neterror);
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.a aVar) {
        String str = aVar.g;
        if (TextUtils.isEmpty(str)) {
            com.baidu.adp.lib.util.j.a((Context) this, com.baidu.tieba.x.pb_app_error);
            return;
        }
        File d2 = com.baidu.tbadk.core.util.s.d(String.valueOf(str.replace(".", "_")) + ".apk");
        if (d2 != null) {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(d2), "application/vnd.android.package-archive");
            startActivity(intent);
        }
    }

    private void G() {
        this.z.a(this.L.i(), this.L);
        this.P.removeMessages(1);
        if (this.t == 1 && this.R.equals("frs_page") && this.L.n().f() == 0) {
            this.Q = System.nanoTime() / 1000000000;
            if (this.L.n().g() > 0) {
                this.P.sendMessageDelayed(this.P.obtainMessage(1), 1000L);
            }
        }
    }

    public void h() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.x.login_to_use), true, 11021);
        } else if (!this.L.o()) {
            this.L.a(true);
            this.L.a(this.ak);
            this.L.a(String.valueOf(this.L.i().isLike()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        this.z.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        com.baidu.tbadk.browser.a.a(this, String.valueOf(TbConfig.SERVER_ADDRESS) + "mo/q/fudaiindex?fid=" + this.L.i().getId());
    }

    public void a(com.baidu.tbadk.core.data.a aVar, String str) {
        com.baidu.tbadk.distribute.a.a().a(this, aVar, str, "frs", this.L.i().getId(), 0L);
    }

    public void b(com.baidu.tbadk.core.data.a aVar, String str) {
        com.baidu.tbadk.distribute.a.a().a(aVar, this.L.i().getId(), 0L, "FRS", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.x.login_to_use), true, 11002);
            return;
        }
        this.M.a("from_frs");
        this.M.a(this.L.i().getName(), this.L.i().getId());
    }

    protected void j() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(com.baidu.tieba.x.attention_cancel_info));
        builder.setTitle(getString(com.baidu.tieba.x.alert_title));
        builder.setPositiveButton(getString(com.baidu.tieba.x.attention_cancel), new ar(this));
        builder.setNegativeButton(getString(com.baidu.tieba.x.cancel), new as(this));
        com.baidu.adp.lib.e.d.a(builder.create(), this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.x.login_to_use), true, 11014);
            return;
        }
        if (this.R.equals("normal_page")) {
            this.z.B();
        } else if (this.R.equals("frs_page")) {
            this.z.D();
        }
        this.O.a(this.L.i().getName(), this.L.i().getId());
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.z.n().c()) {
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
            com.baidu.tbadk.core.util.d.a();
            com.baidu.tieba.pb.main.bp.a().f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        ArrayList<com.baidu.tbadk.core.data.n> j = this.L.j();
        if (j != null) {
            Iterator<com.baidu.tbadk.core.data.n> it = j.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.core.data.n next = it.next();
                if (next == this.j) {
                    if (i == 1) {
                        PraiseData g = next.g();
                        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
                        if (currentAccountObj != null) {
                            MetaData metaData = new MetaData();
                            metaData.setName_show(currentAccountObj.getAccount());
                            metaData.setPortrait(currentAccountObj.getPortrait());
                            metaData.setUserId(currentAccountObj.getID());
                            if (g == null) {
                                PraiseData praiseData = new PraiseData();
                                praiseData.setIsLike(i);
                                praiseData.setNum(1L);
                                praiseData.getUser().add(0, metaData);
                                next.a(praiseData);
                            } else {
                                next.g().getUser().add(0, metaData);
                                next.g().setNum(next.g().getNum() + 1);
                                next.g().setIsLike(i);
                            }
                        }
                    } else if (next.g() != null) {
                        next.g().setIsLike(i);
                        next.g().setNum(next.g().getNum() - 1);
                        ArrayList<MetaData> user = next.g().getUser();
                        if (user != null) {
                            Iterator<MetaData> it2 = user.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                MetaData next2 = it2.next();
                                if (next2.getUserId().equals(TbadkApplication.getCurrentAccountObj().getID())) {
                                    next.g().getUser().remove(next2);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            this.z.v().a(j, this.L);
            this.z.v().notifyDataSetChanged();
        }
    }

    private void a(String str, int i) {
        ArrayList<com.baidu.tbadk.core.data.n> j;
        if (this.L != null && (j = this.L.j()) != null) {
            Iterator<com.baidu.tbadk.core.data.n> it = j.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.core.data.n next = it.next();
                if (next.i() != null && next.h() != null && next.h().equals(str)) {
                    if (i == 1) {
                        PraiseData g = next.g();
                        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
                        if (currentAccountObj != null) {
                            MetaData metaData = new MetaData();
                            metaData.setName_show(currentAccountObj.getAccount());
                            metaData.setPortrait(currentAccountObj.getPortrait());
                            metaData.setUserId(currentAccountObj.getID());
                            if (g == null) {
                                PraiseData praiseData = new PraiseData();
                                praiseData.setIsLike(i);
                                praiseData.setNum(1L);
                                praiseData.getUser().add(0, metaData);
                                next.a(praiseData);
                            } else {
                                next.g().getUser().add(0, metaData);
                                next.g().setNum(next.g().getNum() + 1);
                                next.g().setIsLike(i);
                            }
                        }
                    } else if (next.g() != null) {
                        next.g().setIsLike(i);
                        next.g().setNum(next.g().getNum() - 1);
                        ArrayList<MetaData> user = next.g().getUser();
                        if (user != null) {
                            Iterator<MetaData> it2 = user.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                MetaData next2 = it2.next();
                                if (next2.getUserId() != null && next2.getUserId().equals(TbadkApplication.getCurrentAccountObj().getID())) {
                                    next.g().getUser().remove(next2);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            this.z.v().a(j, this.L);
            this.z.v().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (str != null) {
            if (TbadkApplication.m252getInst().isFrsImageForum(str)) {
                sendMessage(new CustomMessage(2003002, new com.baidu.tbadk.core.atomData.s(this).b(str, null, 0)));
                g();
                return;
            }
            if (this.z.o().isMenuShowing()) {
                this.z.o().toggle(true);
            }
            this.H = false;
            this.q = str;
            D();
        }
    }

    @Override // com.baidu.tbadk.core.voice.aa
    public VoiceManager d() {
        if (this.h == null) {
            this.h = VoiceManager.instance();
        }
        return this.h;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.aa
    /* renamed from: l */
    public BdListView a() {
        if (this.z == null) {
            return null;
        }
        return this.z.J();
    }

    @Override // com.baidu.tbadk.core.voice.aa
    public com.baidu.tbadk.core.voice.y a(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        this.h = d();
        this.h.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.aa
    public int c_() {
        if (this.z == null) {
            return 0;
        }
        return this.z.T();
    }

    @Override // com.baidu.tbadk.core.view.aa
    public com.baidu.adp.lib.d.b<TbImageView> c() {
        return this.U;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgReplyme = newsNotifyMessage.getMsgReplyme();
            int msgAtme = newsNotifyMessage.getMsgAtme();
            int msgChat = newsNotifyMessage.getMsgChat();
            if (this.S != null) {
                this.S.b(msgReplyme);
                this.S.a(msgAtme);
                this.S.c(msgChat);
                this.z.a(this.S, l, m, n);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        bc v;
        HashMap<Integer, com.baidu.tbadk.core.data.n> c2;
        if (this.L != null && this.z != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null && (v = this.z.v()) != null && (c2 = v.c()) != null && c2.size() > 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null) {
                    for (Map.Entry<Integer, com.baidu.tbadk.core.data.n> entry : c2.entrySet()) {
                        int intValue = entry.getKey().intValue();
                        com.baidu.tbadk.core.data.n value = entry.getValue();
                        if (value != null && (value instanceof com.baidu.tbadk.core.data.a) && TextUtils.equals(((com.baidu.tbadk.core.data.a) value).g, downloadData.getId())) {
                            if (v.getItem(intValue) instanceof com.baidu.tbadk.core.data.a) {
                                com.baidu.tbadk.core.data.a aVar = (com.baidu.tbadk.core.data.a) v.getItem(intValue);
                                int status = downloadData.getStatus();
                                if (status == 3 || status == 0) {
                                    aVar.a = 2;
                                } else if (status == 2 || status == 4) {
                                    if (!com.baidu.tbadk.core.util.ba.c(downloadData.getStatusMsg())) {
                                        showToast(downloadData.getStatusMsg());
                                    }
                                    aVar.a = 0;
                                } else if (status == 1) {
                                    aVar.a = 1;
                                }
                            }
                        }
                    }
                }
            }
            this.z.z();
        }
    }

    private void K() {
        HashMap<Integer, com.baidu.tbadk.core.data.n> c2;
        if (this.z != null && this.z.v() != null && (c2 = this.z.v().c()) != null) {
            ArrayList<com.baidu.tbadk.core.data.a> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, com.baidu.tbadk.core.data.n> entry : c2.entrySet()) {
                com.baidu.tbadk.core.data.n value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.a)) {
                    arrayList.add((com.baidu.tbadk.core.data.a) value);
                }
            }
            b.a().a(arrayList);
        }
    }

    public void a(int i, com.baidu.tbadk.core.data.n nVar, int i2) {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.x.login_to_use), true, 0);
            return;
        }
        if (this.ae != nVar && nVar != null) {
            N();
            this.z.c((String) null);
            this.aa = new WriteImagesInfo();
            this.aa.setMaxImagesAllowed(10);
            this.z.a(this.aa, true);
            this.af.a((WriteData) null);
            this.af.a(false);
            this.z.X();
            com.baidu.tieba.util.m.a(nVar.i(), this);
        }
        this.ae = nVar;
        this.z.a(i, nVar, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Boolean bool) {
        if (com.baidu.tieba.e.b.a(this.L.i().getName(), bool)) {
            this.z.aa();
        } else {
            this.z.Z();
        }
    }

    private void a(Intent intent) {
        a(intent, true);
    }

    private void L() {
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.ad;
        try {
            int b2 = com.baidu.tbadk.core.util.d.b(str);
            if (b2 != 0) {
                Bitmap a2 = com.baidu.tbadk.core.util.d.a(str, com.baidu.adp.lib.util.j.a(this, com.baidu.adp.lib.util.j.b(this)), com.baidu.adp.lib.util.j.a(this, com.baidu.adp.lib.util.j.c(this)));
                Bitmap e2 = com.baidu.tbadk.core.util.d.e(a2, b2);
                if (a2 != e2) {
                    a2.recycle();
                }
                com.baidu.tbadk.core.util.s.a(TbConfig.LOCAL_CAMERA_DIR, this.ad, e2, 100);
                e2.recycle();
            }
        } catch (Exception e3) {
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.setTempFile(true);
        this.aa.addChooseFile(imageFileInfo);
        this.aa.updateQuality();
        this.z.a(this.aa, true);
        if (this.aa.getChosedFiles() != null && this.aa.getChosedFiles().size() > 0) {
            this.z.c.b(23);
        }
    }

    private void b(Intent intent) {
        a(intent, false);
    }

    private void a(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.aa.parseJson(stringExtra);
                this.aa.updateQuality();
                if (this.aa.getChosedFiles() != null) {
                    this.z.a(this.aa, z);
                }
            }
            if (this.aa.getChosedFiles() != null && this.aa.getChosedFiles().size() > 0) {
                this.z.c.b(23);
            }
        }
    }

    private void M() {
        new au(this).execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
        if (this.aF == null) {
            String[] strArr = {getString(com.baidu.tieba.x.take_photo), getString(com.baidu.tieba.x.album)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(com.baidu.tieba.x.operation));
            builder.setItems(strArr, new av(this));
            this.aF = builder.create();
            this.aF.setCanceledOnTouchOutside(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        if (this.af.a() == null) {
            WriteData n2 = n();
            n2.setWriteImagesInfo(this.aa);
            this.af.a(this.aa.size() > 0);
            this.af.a(n2);
        }
        if (this.af.a() != null) {
            if (this.ac.getIsBaobao()) {
                this.af.a().setIsBaobao(true);
                this.af.a().setBaobaoContent(this.ac.getBaobaoContent());
                this.af.a().setBaobaoImagesInfo(this.ab);
            } else {
                this.af.a().setIsBaobao(false);
                this.af.a().setBaobaoContent("");
                this.ab.clear();
            }
            this.af.a().setIsFrsReply(true);
            this.af.a().setContent(this.z.V());
            VoiceData.VoiceModel W = this.z.W();
            this.z.Y();
            if (W != null) {
                if (W.getId() != null) {
                    this.af.a().setVoice(W.getId());
                    this.af.a().setVoiceDuringTime(W.duration);
                } else {
                    this.af.a().setVoice(null);
                    this.af.a().setVoiceDuringTime(-1);
                }
            } else {
                this.af.a().setVoice(null);
                this.af.a().setVoiceDuringTime(-1);
            }
            if (!this.af.c()) {
                showToast(com.baidu.tieba.x.write_img_limit);
            } else if (this.af.b()) {
                showProgressBar();
            }
        }
    }

    public WriteData n() {
        WriteData writeData = new WriteData();
        writeData.setForumId(this.L.i().getId());
        writeData.setForumName(this.L.i().getName());
        writeData.setThreadId(this.ae.i());
        writeData.setIsAd(false);
        writeData.setType(1);
        return writeData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.a(antiData) || AntiHelper.b(antiData) || AntiHelper.c(antiData) || AntiHelper.d(antiData)) {
            antiData.setBlock_forum_name(this.ae.r());
            antiData.setBlock_forum_id(this.L.i().getId());
            antiData.setUser_name(this.ae.q().getUserName());
            antiData.setUser_id(this.ae.q().getUserId());
            AntiHelper.a(this, antiData, AntiHelper.OperationType.REPLY, AntiHelper.PageType.PB);
            return;
        }
        com.baidu.adp.lib.util.j.a((Context) this, str);
    }

    @Override // com.baidu.tieba.util.n
    public void a(WriteData writeData) {
        if (writeData != null && this.ae != null && writeData.getThreadId().equals(this.ae.i())) {
            if (!com.baidu.tbadk.core.util.ba.c(writeData.getContent()) && com.baidu.tbadk.core.util.ba.c(this.z.V())) {
                this.z.c(writeData.getContent());
            }
            if (writeData.getWriteImagesInfo() != null && this.aa.size() == 0) {
                this.aa.copyFrom(writeData.getWriteImagesInfo());
                this.z.a(this.aa, true);
            }
            if (TbadkApplication.m252getInst().isBaobaoShouldOpen() && writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                this.ab.copyFrom(writeData.getBaobaoImagesInfo());
                this.ac.setIsBaobao(writeData.getIsBaobao());
                this.ac.setBaobaoContent(writeData.getBaobaoContent());
                this.z.a(this.ab);
            }
        }
    }

    private void N() {
        if (this.ae != null) {
            WriteData a2 = this.af.a();
            if (a2 == null) {
                a2 = new WriteData(1);
                a2.setThreadId(this.ae.i());
                a2.setWriteImagesInfo(this.aa);
            }
            a2.setContent(this.z.V());
            if (this.ac != null && this.ac.getIsBaobao()) {
                a2.setBaobaoContent(this.ac.getBaobaoContent());
                a2.setBaobaoImagesInfo(this.ab);
                a2.setIsBaobao(true);
            }
            com.baidu.tieba.util.m.b(this.ae.i(), a2);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return a();
    }

    private void c(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(BaobaoSdkDelegate.KEY_BITMAPPATH);
            String stringExtra2 = intent.getStringExtra(BaobaoSdkDelegate.KEY_CONTENT);
            if (stringExtra != null && stringExtra2 != null) {
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(stringExtra);
                this.ab.clear();
                this.ab.addChooseFile(imageFileInfo);
                this.z.a(this.ab);
                if (this.ab.getChosedFiles() != null && this.ab.getChosedFiles().size() > 0) {
                    this.z.c.b(48);
                    this.ac.setIsBaobao(true);
                    this.ac.setBaobaoContent(stringExtra2);
                    this.ac.setBaobaoImagesInfo(this.ab);
                    return;
                }
                this.ac.setIsBaobao(false);
                this.ac.setBaobaoContent("");
                this.ac.setBaobaoImagesInfo(this.ab);
            }
        }
    }
}
