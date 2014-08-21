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
public class FrsActivity extends BaseActivity implements com.baidu.adp.widget.BdSwitchView.c, com.baidu.tbadk.core.view.ab, com.baidu.tbadk.core.voice.aa, com.baidu.tieba.util.n, com.baidu.tieba.view.q {
    private static final CustomMessageListener ak;
    private static boolean aq;
    public static String b;
    public static final CustomMessageListener f;
    private dk U;
    private bc ab;
    private String af;
    private com.baidu.tbadk.core.data.n ag;
    private com.baidu.tieba.model.ar ah;
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
    private static volatile long F = 0;
    private static volatile long G = 0;
    private static volatile int H = 0;
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
    private String y = null;
    private String z = null;
    private boolean A = false;
    private cv B = null;
    private String C = null;
    private String D = null;
    private final com.baidu.tbadk.core.data.n E = null;
    private long I = 0;
    private boolean J = false;
    private boolean K = true;
    private boolean L = true;
    private com.baidu.tieba.b.a M = null;
    private g N = null;
    private com.baidu.tieba.model.af O = null;
    private com.baidu.tieba.model.bf P = null;
    private com.baidu.tieba.model.bb Q = null;
    private Handler R = null;
    private long S = 0;
    private String T = "normal_page";
    private com.baidu.tbadk.core.data.n V = null;
    private final com.baidu.adp.lib.d.b<TbImageView> W = UserIconBox.a(this, 8);
    private final com.baidu.adp.lib.d.b<TbImageView> X = FrsCommonImageLayout.a(this, 6);
    private boolean Y = false;
    private long Z = -1;
    private String aa = "";
    private WriteImagesInfo ac = new WriteImagesInfo();
    private WriteImagesInfo ad = new WriteImagesInfo();
    private WriteData ae = new WriteData();
    private boolean ai = true;
    private final com.baidu.tieba.model.as aj = new l(this);
    public final CustomMessageListener g = new at(this, 2012111);
    private final dn al = new ax(this);
    private final dm am = new ay(this);
    private Handler an = null;
    private final CustomMessageListener ao = new az(this, 2003003);
    private final CustomMessageListener ap = new ba(this, 2001200);
    private final com.baidu.adp.widget.ListView.x ar = new bb(this);
    private final com.baidu.adp.widget.ListView.z as = new m(this);
    private final AdapterView.OnItemClickListener at = new n(this);
    private final AdapterView.OnItemLongClickListener au = new p(this);
    private final com.baidu.adp.widget.ListView.d av = new q(this);
    private final View.OnClickListener aw = new r(this);
    private final AbsListView.OnScrollListener ax = new s(this);
    private final SlidingMenu.OnClosedListener ay = new t(this);
    private final bm az = new u(this);
    private final dt aA = new dt(new v(this));
    private final SlidingMenu.OnOpenedListener aB = new w(this);
    private final View.OnClickListener aC = new y(this);
    private final View.OnClickListener aD = new z(this);
    private final AdapterView.OnItemClickListener aE = new aa(this);
    private final com.baidu.tbadk.core.view.r aF = new ab(this);
    private final CustomMessageListener aG = new ac(this, 0);
    private AlertDialog aH = null;
    private final com.baidu.adp.framework.listener.d aI = new ad(this, 301001);
    private final HttpMessageListener aJ = new ae(this, CmdConfigHttp.FRS_HTTP_CMD);

    static {
        p();
        q();
        r();
        f = new x(2012111);
        ak = new ai(2012112);
        MessageManager.getInstance().registerListener(f);
        MessageManager.getInstance().registerListener(ak);
        aq = false;
    }

    private static void p() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2003000, new af());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void q() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2003001, new ag());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void r() {
        com.baidu.tbadk.core.util.bg.a().a(new ah());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkApplication.m252getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar) {
        if (gVar != null && gVar.i() != null) {
            this.B.n().a(gVar.i().getRecommendForumData());
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
            if (this.N != null) {
                this.N.a(gVar.i().getAnchorPower());
            }
            this.B.a(gVar);
            ArrayList<LiveCardData> c2 = gVar.c();
            ArrayList<com.baidu.tbadk.core.data.n> j = gVar.j();
            this.B.v().a(-1);
            if (c2 != null && c2.size() > 0 && j != null && j.size() > 0) {
                int d2 = d(gVar);
                com.baidu.tbadk.core.data.i iVar = new com.baidu.tbadk.core.data.i();
                iVar.a(c2);
                gVar.j().add(d2, iVar);
                this.B.v().a(d2);
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
                        this.B.a(str);
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
        if (str == null || str.length() <= 0 || (intentClass = TbadkApplication.m252getInst().getIntentClass(com.baidu.tbadk.core.atomData.as.class)) == null) {
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
            this.Z = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.Z = System.currentTimeMillis();
        }
        if (z() && !y()) {
            registerListener(this.ao);
            registerListener(this.ap);
            registerListener(this.aI);
            registerListener(this.aJ);
            registerListener(this.g);
            this.h = d();
            this.h.onCreate(this);
            C();
            a(bundle);
            this.B.S();
            this.aA.setUniqueId(getUniqueId());
            this.aA.a();
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
                if (this.K) {
                    this.B.H();
                    this.B.v().a(this.aC);
                    this.B.v().b(this.aD);
                    this.K = false;
                }
                if (gVar.q() == 1) {
                    this.B.v().f(true);
                } else {
                    this.B.v().f(false);
                }
                this.B.a(gVar.i(), gVar.k());
                if (gVar.n().a() == 1) {
                    this.T = "frs_page";
                    this.B.b(gVar.k().getIsMem(), this.N.i().isLike());
                } else {
                    this.T = "normal_page";
                    this.B.a(gVar.k().getIsMem(), this.N.i().isLike());
                }
                this.B.y();
                this.q = gVar.i().getName();
                this.z = gVar.i().getId();
                this.B.b(this.q);
                F();
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
                    if (this.B.v() != null && (c2 = gVar.c()) != null && c2.size() > 0) {
                        this.B.v().a(d(gVar));
                    }
                }
                ArrayList<com.baidu.tbadk.core.data.n> j = gVar.j();
                if (j != null) {
                    this.B.a(j, this.t, this.N);
                    L();
                    this.B.l(this.t);
                    if (this.T.equals("frs_page")) {
                        this.B.a(gVar.i(), gVar);
                    } else if (this.T.equals("normal_page")) {
                        this.B.b(gVar.i(), gVar);
                    }
                    this.B.b(this.t);
                    this.B.c(gVar.m().f());
                    this.B.K();
                    this.B.d(0);
                }
                if (gVar.h()) {
                    if (this.B.w() != null) {
                        this.B.w().k();
                    }
                    if (this.B.x() != null) {
                        this.B.x().l();
                        return;
                    }
                    return;
                }
                if (this.B.w() != null) {
                    this.B.w().j();
                }
                if (this.B.x() != null) {
                    this.B.x().k();
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    private void a(Bundle bundle) {
        this.an = new Handler();
        w();
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
            this.J = intent.getBooleanExtra("good", false);
        }
        this.B.e(this.J);
        if (this.q != null && this.q.length() > 0) {
            if (this.r == null || this.r.length() <= 0) {
                this.r = "tb_forumlist";
            }
            this.C = this.r;
            v();
            s();
            t();
            u();
            this.U = new dk(this);
            if (this.w) {
                f();
                x();
            }
            if (bundle != null) {
                this.ac = (WriteImagesInfo) bundle.getSerializable("write_images");
                this.af = bundle.getString("photo_name");
            }
            this.ac.setMaxImagesAllowed(10);
            this.ah = new com.baidu.tieba.model.ar();
            this.ah.a(this.aj);
        }
    }

    private void s() {
        this.O = new com.baidu.tieba.model.af();
        this.O.setLoadDataCallBack(new aj(this));
    }

    private void t() {
        this.P = new com.baidu.tieba.model.bf();
        this.P.a("from_frs");
        this.P.a(new ak(this));
    }

    private void u() {
        this.Q = new com.baidu.tieba.model.bb();
        this.Q.setLoadDataCallBack(new al(this));
    }

    @SuppressLint({"HandlerLeak"})
    private void v() {
        this.R = new am(this);
    }

    public void f() {
        if (this.U != null && this.B != null) {
            if (l || m || n) {
                this.U.b(com.baidu.tbadk.coreExtra.messageCenter.a.a().m());
                this.U.a(com.baidu.tbadk.coreExtra.messageCenter.a.a().n());
                this.U.c(com.baidu.tbadk.coreExtra.messageCenter.a.a().o());
                this.B.a(this.U, l, m, n);
            }
        }
    }

    private void w() {
        registerListener(2001122, this.aG);
    }

    private void x() {
        registerListener(2001124, this.aG);
    }

    private boolean y() {
        if ("from_hao123".equals(getIntent().getStringExtra(com.baidu.tbadk.core.frameworkData.a.FROM)) && com.baidu.tieba.util.r.a((Activity) this)) {
            Intent intent = new Intent();
            intent.putExtra("class", 2);
            intent.putExtra("fname", getIntent().getStringExtra("name"));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.as(this, intent)));
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
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.as(this, intent)));
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
        if (this.B != null) {
            this.B.t();
        }
        if (this.R != null) {
            this.R.removeMessages(1);
        }
        super.onDestroy();
        try {
            if (this.N != null) {
                this.N.p();
            }
            if (this.O != null) {
                this.O.a();
            }
            if (this.Q != null) {
                this.Q.a();
            }
            if (this.ah != null) {
                this.ah.cancelLoadData();
            }
            this.B.P();
            System.gc();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        this.h = d();
        this.h.onDestory(this);
        com.baidu.tieba.ai.c().J();
        if (this.ab != null) {
            this.ab.cancel(true);
            this.ab = null;
        }
        if (this.M != null) {
            this.M.b();
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
        bundle.putSerializable("write_images", this.ac);
        bundle.putString("photo_name", this.af);
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
                    c(this.E);
                    return;
                case 11012:
                    d(this.V);
                    return;
                case 11013:
                    D();
                    return;
                case 11014:
                    k();
                    return;
                case 11016:
                    this.B.I();
                    return;
                case 11021:
                    if (this.N != null) {
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
                    if (this.ac != null) {
                        M();
                        int size2 = this.ac.size() - 1;
                        if (size2 > -1 && this.ac.getChosedFiles() != null && (size = this.ac.getChosedFiles().size()) >= 1 && size2 >= 0 && size2 < size) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.ch(this, 12012, this.ac, size2)));
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
                        this.B.a(a2);
                        return;
                    }
                    return;
                case 12006:
                    WriteData a3 = this.ah.a();
                    if (a3 != null) {
                        a3.deleteUploadedTempImages();
                    }
                    this.ae.setIsBaobao(false);
                    this.ae.setBaobaoContent(null);
                    this.ad.clear();
                    this.ah.a((WriteData) null);
                    this.ah.a(false);
                    this.B.h(true);
                    com.baidu.tieba.util.m.b(this.ag.i(), (WriteData) null);
                    if (this.ac != null) {
                        this.B.a(this.ac, true);
                    }
                    this.ag.a(this.ag.k() + 1);
                    this.B.z();
                    this.B.U();
                    return;
                case 12012:
                    b(intent);
                    return;
                case 12013:
                    c(intent);
                    return;
                case 13003:
                    E();
                    return;
                case 18003:
                    this.B.v().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null) {
                        int size3 = this.N.j().size();
                        int i3 = 0;
                        while (true) {
                            if (i3 >= size3) {
                                z = false;
                            } else if (stringExtra.equals(this.N.j().get(i3).h())) {
                                z = true;
                            } else {
                                i3++;
                            }
                        }
                        if (z) {
                            int intExtra = intent.getIntExtra("type", 0);
                            if (intExtra == 2) {
                                this.N.j().get(i3).c(intent.getIntExtra("good_data", 0));
                                this.N.j().get(i3).D();
                                E();
                            } else if (intExtra == 0) {
                                this.N.j().remove(i3);
                                this.B.K();
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
                    J();
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
                        if (this.ac != null) {
                            this.ac.setLastAlbumId(stringExtra2);
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
        this.ai = true;
        this.B.c.u();
        NoNetworkView r = this.B.r();
        if (r != null && r.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            r.a(false);
        }
        if (aq) {
            aq = false;
            this.B.S();
        } else if (e) {
            e = false;
            this.B.S();
        } else {
            if (!this.w && TbadkApplication.isLogin()) {
                this.w = true;
                if (this.N != null && this.N.l() != null) {
                    this.N.l().setIfpost(1);
                }
                E();
            }
            if (this.R != null) {
                this.R.removeMessages(1);
                this.R.sendMessageDelayed(this.R.obtainMessage(1), 1000L);
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
                    A();
                } else {
                    B();
                }
            }
        }
    }

    private void A() {
        this.B.S();
        this.B.o().showContent(false);
    }

    private void B() {
        this.B.S();
        this.B.o().toggle(false);
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
        this.B.P();
        finish();
        CompatibleUtile.setAnim(this, com.baidu.tieba.o.frs_browser_enter, com.baidu.tieba.o.no_effect);
    }

    private void C() {
        this.o = true;
        this.t = 1;
        this.J = false;
        this.I = 0L;
        this.p = 3;
        if (TextUtils.isEmpty(this.q)) {
            this.q = "";
        }
        if (TextUtils.isEmpty(this.r)) {
            this.r = "";
        }
        setContentView(com.baidu.tieba.v.frs_activity);
        this.B = new cv(this, this.aw);
        if (this.s == 0) {
            this.B.b(this.q);
        } else {
            this.B.b("");
            this.s = 1;
        }
        this.B.n().b();
        this.B.a(this.ar);
        this.B.a(this.as);
        this.B.a(this.at);
        this.B.a(this.au);
        this.B.a(this.ax);
        this.B.a(this.av);
        this.B.a(this.ay);
        this.B.a(this.aB);
        this.B.a(this.aF);
        this.B.a(new an(this));
        this.B.v().a(this.az);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.B.k(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
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
        return this.X;
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
            if (this.N != null && this.N.l() != null) {
                this.N.l().setIfpost(1);
            }
            if (i == 0) {
                LoginActivity.a((Activity) this, getString(com.baidu.tieba.x.login_to_use), true, 11001);
            } else {
                LoginActivity.a((Activity) this, getString(com.baidu.tieba.x.login_to_use), true, 11016);
            }
        } else if (this.N != null) {
            if (i == 0) {
                AntiData l2 = this.N.l();
                if (AntiHelper.a(l2) || AntiHelper.b(l2) || AntiHelper.c(l2)) {
                    l2.setBlock_forum_name(this.q);
                    l2.setBlock_forum_id(this.N.i().getId());
                    l2.setUser_name(this.N.k().getUserName());
                    l2.setUser_id(this.N.k().getUserId());
                    if (AntiHelper.a(this, l2, AntiHelper.OperationType.CREATE_THREAD, AntiHelper.PageType.FRS)) {
                        return;
                    }
                }
                if (this.N.l() != null && this.N.l().getIfpost() == 0) {
                    com.baidu.adp.lib.util.j.a((Context) this, l2.getForbid_info());
                    return;
                }
                int i2 = 0;
                if (this.N.k() != null) {
                    i2 = this.N.k().getIsMem();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.cf(this, 0, this.N.i().getId(), this.q, null, null, 0, this.N.l(), 13003, false, false, null, false, false, null, null, this.N.i().getPrefixData(), i2)));
                return;
            }
            this.B.I();
        }
    }

    private boolean a(com.baidu.tbadk.core.data.n nVar) {
        String userId;
        return nVar == null || nVar.q() == null || (userId = nVar.q().getUserId()) == null || userId.equals("0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.n nVar) {
        boolean a2 = a(nVar);
        this.B.a(new ao(this, nVar));
        this.B.a(nVar, a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.n nVar) {
        boolean a2 = a(nVar);
        if (this.y != null) {
            if (!a2) {
                sendMessage(new CustomMessage(2004001, new com.baidu.tbadk.core.atomData.bc(this).a(nVar, this.q, null, 18003, true, true, this.A)));
            } else {
                sendMessage(new CustomMessage(2004001, new com.baidu.tbadk.core.atomData.bc(this).a(nVar, this.q, null, 18003, false, false, this.A)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.core.data.n nVar) {
        if (this.y != null) {
            sendMessage(new CustomMessage(2004001, new com.baidu.tbadk.core.atomData.bc(this).a(nVar, this.q, null, 18003, false, false, this.A)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        K();
        this.t = 1;
        c(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        boolean z = false;
        this.p = i;
        switch (this.p) {
            case 1:
                if (this.B.v().a()) {
                    return;
                }
                break;
            case 2:
                if (this.B.v().b()) {
                    return;
                }
                break;
            case 3:
                if (this.B.u()) {
                    return;
                }
                break;
        }
        FRSPageRequestMessage fRSPageRequestMessage = new FRSPageRequestMessage();
        fRSPageRequestMessage.setKw(this.q);
        fRSPageRequestMessage.setPn(this.t);
        if (this.N == null) {
            this.N = new g();
        }
        fRSPageRequestMessage.setForumModel(this.N);
        if (com.baidu.tbadk.core.h.a().f()) {
            fRSPageRequestMessage.setRn(35);
        } else {
            fRSPageRequestMessage.setRn(50);
        }
        fRSPageRequestMessage.setWithGroup(1);
        if (this.J) {
            fRSPageRequestMessage.setIsGood(1);
            fRSPageRequestMessage.setCid((int) this.I);
        }
        int b2 = com.baidu.adp.lib.util.j.b(this);
        int c2 = com.baidu.adp.lib.util.j.c(this);
        float f2 = b2 / 320.0f;
        int i2 = com.baidu.tbadk.core.util.bb.a().b() ? 2 : 1;
        fRSPageRequestMessage.setScrW(b2);
        fRSPageRequestMessage.setScrH(c2);
        fRSPageRequestMessage.setScrDip(f2);
        fRSPageRequestMessage.setqType(i2);
        fRSPageRequestMessage.setLastId(this.x);
        if (this.C != null) {
            fRSPageRequestMessage.setStType(this.C);
            if (this.C.equalsIgnoreCase("sidebar")) {
                fRSPageRequestMessage.setStType(this.D);
            }
        }
        if (F != 0) {
            fRSPageRequestMessage.setCtime((int) F);
        }
        if (G != 0) {
            fRSPageRequestMessage.setDataSize((int) G);
        }
        if (H != 0) {
            fRSPageRequestMessage.setNetError(H);
        }
        this.B.b(true);
        this.B.v().b(false);
        this.B.v().c(false);
        this.B.v().notifyDataSetChanged();
        if (this.t == 1 && ((this.T.equals("normal_page") || this.T.equals("frs_page")) && !this.J)) {
            z = true;
        }
        if (this.N == null) {
            this.N = new g();
        }
        this.N.a(this.al);
        this.N.a(this, fRSPageRequestMessage, this.p, z, this.q);
        if (this.M == null) {
            this.M = new com.baidu.tieba.b.a("frsStat");
            this.M.a();
        }
    }

    private void F() {
        switch (this.s) {
            case 1:
                com.baidu.adp.lib.e.f.a().a(new ap(this));
                break;
        }
        this.s = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        K();
        try {
            if (this.N != null) {
                this.B.y();
                this.q = this.N.i().getName();
                this.z = this.N.i().getId();
                this.B.b(this.q);
                TbadkApplication.m252getInst().setDefaultBubble(this.N.k().getBimg_url());
                TbadkApplication.m252getInst().setDefaultBubbleEndTime(this.N.k().getBimg_end_time());
                this.B.c.u();
                F();
                this.o = false;
                ArrayList<com.baidu.tbadk.core.data.n> j = this.N.j();
                if (j != null) {
                    this.B.a(j, this.t, this.N);
                    L();
                    this.B.l(this.t);
                    if (this.T.equals("frs_page")) {
                        H();
                    } else if (this.T.equals("normal_page")) {
                        this.B.b(this.N.i(), this.N);
                    }
                    this.B.b(this.t);
                    this.B.c(this.N.m().f());
                    this.B.K();
                    if (this.N.q() == 1) {
                        this.B.v().f(true);
                    } else {
                        this.B.v().f(false);
                    }
                    if (this.p == 1) {
                        this.B.d(3);
                    } else if (this.p == 2) {
                        if (this.t == 1) {
                            this.B.d(0);
                        } else {
                            this.B.d(3);
                        }
                    } else {
                        this.B.d(0);
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
        this.ai = false;
        this.B.O();
        if (this.R != null) {
            this.R.removeMessages(1);
        }
        this.h = d();
        this.h.onPause(this);
        O();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.distribute.a.a().a(this, "frs", this.N.i().getId(), 0L);
        this.h = d();
        if (this.h != null) {
            this.h.onStop(this);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.u) {
            if (i == 4) {
                if (this.B.o().isMenuShowing()) {
                    this.B.o().toggle(true);
                    if (this.B.n().d()) {
                        this.B.n().b(false);
                        E();
                        return true;
                    }
                    return true;
                } else if (this.B.c.p()) {
                    this.B.U();
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
                aVar2.a(com.baidu.tieba.x.alert_yes_button, new aq(this, aVar, i));
                aVar2.b(com.baidu.tieba.x.alert_no_button, new ar(this));
                aVar2.a().c();
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

    private void H() {
        this.B.a(this.N.i(), this.N);
        this.R.removeMessages(1);
        if (this.t == 1 && this.T.equals("frs_page") && this.N.n().f() == 0) {
            this.S = System.nanoTime() / 1000000000;
            if (this.N.n().g() > 0) {
                this.R.sendMessageDelayed(this.R.obtainMessage(1), 1000L);
            }
        }
    }

    public void h() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.x.login_to_use), true, 11021);
        } else if (!this.N.o()) {
            this.N.a(true);
            this.N.a(this.am);
            this.N.a(String.valueOf(this.N.i().isLike()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        this.B.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        com.baidu.tbadk.browser.a.a(this, String.valueOf(TbConfig.SERVER_ADDRESS) + "mo/q/fudaiindex?fid=" + this.N.i().getId());
    }

    public void a(com.baidu.tbadk.core.data.a aVar, String str) {
        com.baidu.tbadk.distribute.a.a().a(this, aVar, str, "frs", this.N.i().getId(), 0L);
    }

    public void b(com.baidu.tbadk.core.data.a aVar, String str) {
        com.baidu.tbadk.distribute.a.a().a(aVar, this.z, 0L, "FRS", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.x.login_to_use), true, 11002);
            return;
        }
        this.O.a("from_frs");
        this.O.a(this.N.i().getName(), this.N.i().getId());
    }

    protected void j() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(com.baidu.tieba.x.attention_cancel_info));
        builder.setTitle(getString(com.baidu.tieba.x.alert_title));
        builder.setPositiveButton(getString(com.baidu.tieba.x.attention_cancel), new as(this));
        builder.setNegativeButton(getString(com.baidu.tieba.x.cancel), new au(this));
        com.baidu.adp.lib.e.e.a(builder.create(), this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.x.login_to_use), true, 11014);
            return;
        }
        if (this.T.equals("normal_page")) {
            this.B.B();
        } else if (this.T.equals("frs_page")) {
            this.B.D();
        }
        this.Q.a(this.N.i().getName(), this.N.i().getId());
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.B.n().c()) {
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
        ArrayList<com.baidu.tbadk.core.data.n> j = this.N.j();
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
            this.B.v().a(j, this.N);
            this.B.v().notifyDataSetChanged();
        }
    }

    public void l() {
        if (this.N != null && this.N.i() != null && this.N.i().getBannerListData() != null) {
            String b2 = this.N.i().getBannerListData().b();
            if (!TextUtils.isEmpty(b2)) {
                this.x = b2;
            }
        }
    }

    private void a(String str, int i) {
        ArrayList<com.baidu.tbadk.core.data.n> j;
        if (this.N != null && (j = this.N.j()) != null) {
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
            this.B.v().a(j, this.N);
            this.B.v().notifyDataSetChanged();
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
            if (this.B.o().isMenuShowing()) {
                this.B.o().toggle(true);
            }
            this.J = false;
            this.q = str;
            E();
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
    @Override // com.baidu.tbadk.core.view.ab
    /* renamed from: m */
    public BdListView a() {
        if (this.B == null) {
            return null;
        }
        return this.B.J();
    }

    @Override // com.baidu.tbadk.core.voice.aa
    public com.baidu.tbadk.core.voice.y a(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        this.h = d();
        this.h.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.ab
    public int c_() {
        if (this.B == null) {
            return 0;
        }
        return this.B.T();
    }

    @Override // com.baidu.tbadk.core.view.ab
    public com.baidu.adp.lib.d.b<TbImageView> c() {
        return this.W;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgReplyme = newsNotifyMessage.getMsgReplyme();
            int msgAtme = newsNotifyMessage.getMsgAtme();
            int msgChat = newsNotifyMessage.getMsgChat();
            if (this.U != null) {
                this.U.b(msgReplyme);
                this.U.a(msgAtme);
                this.U.c(msgChat);
                this.B.a(this.U, l, m, n);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        bd v;
        HashMap<Integer, com.baidu.tbadk.core.data.n> c2;
        if (this.N != null && this.B != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null && (v = this.B.v()) != null && (c2 = v.c()) != null && c2.size() > 0) {
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
            this.B.z();
        }
    }

    private void L() {
        HashMap<Integer, com.baidu.tbadk.core.data.n> c2;
        if (this.B != null && this.B.v() != null && (c2 = this.B.v().c()) != null) {
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
        if (this.ag != nVar && nVar != null) {
            O();
            this.B.c((String) null);
            this.ac = new WriteImagesInfo();
            this.ac.setMaxImagesAllowed(10);
            this.B.a(this.ac, true);
            this.ah.a((WriteData) null);
            this.ah.a(false);
            this.B.X();
            com.baidu.tieba.util.m.a(nVar.i(), this);
        }
        this.ag = nVar;
        this.B.a(i, nVar, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Boolean bool) {
        if (com.baidu.tieba.e.b.a(this.N.i().getName(), bool)) {
            this.B.aa();
        } else {
            this.B.Z();
        }
    }

    private void a(Intent intent) {
        a(intent, true);
    }

    private void M() {
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.af;
        try {
            int b2 = com.baidu.tbadk.core.util.d.b(str);
            if (b2 != 0) {
                Bitmap a2 = com.baidu.tbadk.core.util.d.a(str, com.baidu.adp.lib.util.j.a(this, com.baidu.adp.lib.util.j.b(this)), com.baidu.adp.lib.util.j.a(this, com.baidu.adp.lib.util.j.c(this)));
                Bitmap e2 = com.baidu.tbadk.core.util.d.e(a2, b2);
                if (a2 != e2) {
                    a2.recycle();
                }
                com.baidu.tbadk.core.util.s.a(TbConfig.LOCAL_CAMERA_DIR, this.af, e2, 100);
                e2.recycle();
            }
        } catch (Exception e3) {
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.setTempFile(true);
        this.ac.addChooseFile(imageFileInfo);
        this.ac.updateQuality();
        this.B.a(this.ac, true);
        if (this.ac.getChosedFiles() != null && this.ac.getChosedFiles().size() > 0) {
            this.B.c.b(23);
        }
    }

    private void b(Intent intent) {
        a(intent, false);
    }

    private void a(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.ac.parseJson(stringExtra);
                this.ac.updateQuality();
                if (this.ac.getChosedFiles() != null) {
                    this.B.a(this.ac, z);
                }
            }
            if (this.ac.getChosedFiles() != null && this.ac.getChosedFiles().size() > 0) {
                this.B.c.b(23);
            }
        }
    }

    private void N() {
        new av(this).execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n() {
        if (this.aH == null) {
            String[] strArr = {getString(com.baidu.tieba.x.take_photo), getString(com.baidu.tieba.x.album)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(com.baidu.tieba.x.operation));
            builder.setItems(strArr, new aw(this));
            this.aH = builder.create();
            this.aH.setCanceledOnTouchOutside(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        if (this.ah.a() == null) {
            WriteData o = o();
            o.setWriteImagesInfo(this.ac);
            this.ah.a(this.ac.size() > 0);
            this.ah.a(o);
        }
        if (this.ah.a() != null) {
            if (this.ae.getIsBaobao()) {
                this.ah.a().setIsBaobao(true);
                this.ah.a().setBaobaoContent(this.ae.getBaobaoContent());
                this.ah.a().setBaobaoImagesInfo(this.ad);
            } else {
                this.ah.a().setIsBaobao(false);
                this.ah.a().setBaobaoContent("");
                this.ad.clear();
            }
            this.ah.a().setIsFrsReply(true);
            this.ah.a().setContent(this.B.V());
            VoiceData.VoiceModel W = this.B.W();
            this.B.Y();
            if (W != null) {
                if (W.getId() != null) {
                    this.ah.a().setVoice(W.getId());
                    this.ah.a().setVoiceDuringTime(W.duration);
                } else {
                    this.ah.a().setVoice(null);
                    this.ah.a().setVoiceDuringTime(-1);
                }
            } else {
                this.ah.a().setVoice(null);
                this.ah.a().setVoiceDuringTime(-1);
            }
            if (!this.ah.c()) {
                showToast(com.baidu.tieba.x.write_img_limit);
            } else if (this.ah.b()) {
                showProgressBar();
            }
        }
    }

    public WriteData o() {
        WriteData writeData = new WriteData();
        writeData.setForumId(this.N.i().getId());
        writeData.setForumName(this.N.i().getName());
        writeData.setThreadId(this.ag.i());
        writeData.setIsAd(false);
        writeData.setType(1);
        return writeData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.a(antiData) || AntiHelper.b(antiData) || AntiHelper.c(antiData) || AntiHelper.d(antiData)) {
            antiData.setBlock_forum_name(this.ag.r());
            antiData.setBlock_forum_id(this.N.i().getId());
            antiData.setUser_name(this.ag.q().getUserName());
            antiData.setUser_id(this.ag.q().getUserId());
            AntiHelper.a(this, antiData, AntiHelper.OperationType.REPLY, AntiHelper.PageType.PB);
            return;
        }
        com.baidu.adp.lib.util.j.a((Context) this, str);
    }

    @Override // com.baidu.tieba.util.n
    public void a(WriteData writeData) {
        if (writeData != null && this.ag != null && writeData.getThreadId().equals(this.ag.i())) {
            if (!com.baidu.tbadk.core.util.ba.c(writeData.getContent()) && com.baidu.tbadk.core.util.ba.c(this.B.V())) {
                this.B.c(writeData.getContent());
            }
            if (writeData.getWriteImagesInfo() != null && this.ac.size() == 0) {
                this.ac.copyFrom(writeData.getWriteImagesInfo());
                this.B.a(this.ac, true);
            }
            if (TbadkApplication.m252getInst().isBaobaoShouldOpen() && writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                this.ad.copyFrom(writeData.getBaobaoImagesInfo());
                this.ae.setIsBaobao(writeData.getIsBaobao());
                this.ae.setBaobaoContent(writeData.getBaobaoContent());
                this.B.a(this.ad);
            }
        }
    }

    private void O() {
        if (this.ag != null) {
            WriteData a2 = this.ah.a();
            if (a2 == null) {
                a2 = new WriteData(1);
                a2.setThreadId(this.ag.i());
                a2.setWriteImagesInfo(this.ac);
            }
            a2.setContent(this.B.V());
            if (this.ae != null && this.ae.getIsBaobao()) {
                a2.setBaobaoContent(this.ae.getBaobaoContent());
                a2.setBaobaoImagesInfo(this.ad);
                a2.setIsBaobao(true);
            }
            com.baidu.tieba.util.m.b(this.ag.i(), a2);
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
                this.ad.clear();
                this.ad.addChooseFile(imageFileInfo);
                this.B.a(this.ad);
                if (this.ad.getChosedFiles() != null && this.ad.getChosedFiles().size() > 0) {
                    this.B.c.b(48);
                    this.ae.setIsBaobao(true);
                    this.ae.setBaobaoContent(stringExtra2);
                    this.ae.setBaobaoImagesInfo(this.ad);
                    return;
                }
                this.ae.setIsBaobao(false);
                this.ae.setBaobaoContent("");
                this.ae.setBaobaoImagesInfo(this.ad);
            }
        }
    }
}
