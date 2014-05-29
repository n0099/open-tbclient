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
import com.baidu.tbadk.core.frameworkData.CmdConfig;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
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
public class FrsActivity extends BaseActivity implements com.baidu.adp.widget.BdSwitchView.c, com.baidu.tbadk.core.view.w, com.baidu.tbadk.core.voice.z, com.baidu.tieba.util.n, com.baidu.tieba.view.r {
    private static boolean ai;
    public static final CustomMessageListener e;
    private de P;
    private ay X;
    private String Z;
    private com.baidu.tbadk.core.data.n aa;
    private com.baidu.tieba.model.ar ab;
    private AlertDialog ax;
    VoiceManager h;
    private com.baidu.tbadk.core.data.n j;
    private boolean k;
    public static String a = "has_shown_frs_guide";
    public static boolean b = true;
    public static boolean c = true;
    public static boolean d = false;
    private static volatile long A = 0;
    private static volatile long B = 0;
    private static volatile int C = 0;
    private boolean i = false;
    private boolean l = true;
    private int m = 3;
    private String n = null;
    private String o = null;
    private int p = 0;
    private int q = 1;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private String u = null;
    private boolean v = false;
    private ct w = null;
    private String x = null;
    private String y = null;
    private final com.baidu.tbadk.core.data.n z = null;
    private long D = 0;
    private boolean E = false;
    private boolean F = true;
    private boolean G = true;
    private boolean H = true;
    private g I = null;
    private com.baidu.tieba.model.af J = null;
    private com.baidu.tieba.model.bd K = null;
    private com.baidu.tieba.model.az L = null;
    private Handler M = null;
    private long N = 0;
    private String O = "normal_page";
    private com.baidu.tbadk.core.data.n Q = null;
    private final com.baidu.adp.lib.d.b<TbImageView> R = UserIconBox.a(this, 8);
    private final com.baidu.adp.lib.d.b<TbImageView> S = FrsCommonImageLayout.a(this, 6);
    private boolean T = false;
    private long U = -1;
    private AlertDialog V = null;
    private String W = "";
    private WriteImagesInfo Y = new WriteImagesInfo();
    private final com.baidu.tieba.model.as ac = new l(this);
    public final CustomMessageListener f = new ai(this, CmdConfig.MSG_NEW);
    private final dh ad = new as(this);
    private final dg ae = new at(this);
    private Handler af = null;
    private com.baidu.tbadk.core.util.b ag = null;
    com.baidu.tbadk.imageManager.d g = new au(this);
    private final CustomMessageListener ah = new av(this, 2005003);
    private final com.baidu.adp.widget.ListView.x aj = new aw(this);
    private final com.baidu.adp.widget.ListView.z ak = new ax(this);
    private final AdapterView.OnItemClickListener al = new m(this);
    private final AdapterView.OnItemLongClickListener am = new o(this);
    private final com.baidu.adp.widget.ListView.d an = new p(this);
    private final View.OnClickListener ao = new q(this);
    private final AbsListView.OnScrollListener ap = new r(this);
    private final SlidingMenu.OnClosedListener aq = new s(this);
    private final bk ar = new t(this);
    private final dn as = new dn(new u(this));
    private final SlidingMenu.OnOpenedListener at = new v(this);
    private final AdapterView.OnItemClickListener au = new w(this);
    private final com.baidu.tbadk.core.view.m av = new y(this);
    private final CustomMessageListener aw = new z(this, 0);
    private final com.baidu.adp.framework.listener.b ay = new aa(this, MessageTypes.CMD_FRS_PAGE);
    private final HttpMessageListener az = new ab(this, CmdConfig.FRS_HTTP_CMD);

    static {
        p();
        q();
        e();
        e = new x(CmdConfig.MSG_NEW);
        MessageManager.getInstance().registerListener(e);
        ai = false;
    }

    private static void p() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2005000, new ac());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void q() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2005001, new ad());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void e() {
        com.baidu.tbadk.core.util.bi.a().a(new ae());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkApplication.m252getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar) {
        if (gVar != null && gVar.g() != null) {
            this.w.n().a(gVar.g().getRecommendForumData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(g gVar) {
        int i;
        if (gVar != null && gVar.g() != null) {
            if (this.I != null) {
                this.I.a(gVar.g().getAnchorPower());
            }
            this.w.a(gVar);
            ArrayList<LiveCardData> a2 = gVar.a();
            ArrayList<com.baidu.tbadk.core.data.n> h = gVar.h();
            this.w.v().a(-1);
            if (a2 != null && a2.size() > 0 && h != null && h.size() > 0) {
                int i2 = 0;
                Iterator<com.baidu.tbadk.core.data.n> it = h.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    com.baidu.tbadk.core.data.n next = it.next();
                    if (next.u() != 1 && next.u() != 2) {
                        break;
                    }
                    i2 = i + 1;
                }
                com.baidu.tbadk.core.data.h hVar = new com.baidu.tbadk.core.data.h();
                hVar.a(a2);
                gVar.h().add(i, hVar);
                this.w.v().a(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(g gVar) {
        if (gVar != null && gVar.g() != null) {
            com.baidu.tbadk.core.data.c bannerListData = gVar.g().getBannerListData();
            ArrayList<com.baidu.tbadk.core.data.n> h = gVar.h();
            int size = gVar.h().size();
            if (bannerListData != null && bannerListData.a() != null && h != null && h.size() > 0) {
                Iterator<com.baidu.tbadk.core.data.n> it = h.iterator();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.tbadk.core.data.n next = it.next();
                    if (next.u() != 1 && next.u() != 2) {
                        break;
                    }
                    i++;
                }
                int size2 = bannerListData.a().size();
                if (size2 >= 1) {
                    for (int i2 = 0; i2 < 3; i2++) {
                        com.baidu.tbadk.core.data.b bVar = bannerListData.a().get(new Random().nextInt(size2));
                        long a2 = com.baidu.tbadk.f.a().a(bVar.i(), 0L);
                        if (!com.baidu.tieba.util.r.a(this, bVar.i()) && ((bVar.d() != 1 || !TbadkApplication.m252getInst().getHasShowAppForums().contains(this.n)) && (bVar.d() != 2 || System.currentTimeMillis() - a2 > 86400000))) {
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
        if (this.l) {
            if (jVar != null) {
                if (jVar.a && jVar.b) {
                    if (jVar.c == 3) {
                        this.r = false;
                        this.n = this.n.replace(" ", "");
                        String str = this.n;
                        if (str.length() > 31) {
                            str = String.valueOf(str.substring(0, 31)) + "...";
                        }
                        this.w.b(str);
                    } else if (UtilHelper.getNetStatusInfo(this) != UtilHelper.NetworkStateInfo.UNAVAIL) {
                        this.w.a(jVar.d);
                    }
                } else if (UtilHelper.getNetStatusInfo(this) != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    this.w.a(jVar.d);
                }
            }
        } else if (jVar != null) {
            this.w.a(jVar.d);
        }
    }

    public static Intent a(Context context, String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        Class<?> intentClass = TbadkApplication.m252getInst().getIntentClass(com.baidu.tbadk.core.atomData.ak.class);
        if (intentClass != null) {
            Intent intent = new Intent(context, intentClass);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setAction("android.intent.action.MAIN");
            intent.setFlags(603979776);
            intent.putExtra("fname", str);
            intent.putExtra("from_short_cut", true);
            intent.putExtra("back_special", true);
            intent.putExtra("from", "short_cut");
            return intent;
        }
        BdLog.e("没有注册LogoActivity？ 导致获取class失败");
        return null;
    }

    private void r() {
        int i = TbConfig.PB_IMAGE_NEW_MAX_WIDTH;
        this.ag = new com.baidu.tbadk.core.util.b(this);
        this.ag.b(true);
        int a2 = com.baidu.adp.lib.util.k.a((Context) this, 427.0f);
        if (a2 <= 640) {
            i = a2;
        }
        this.ag.a(i, (int) (i * 1.6f));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.U = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.U = System.currentTimeMillis();
        }
        if (z() && !y()) {
            registerListener(this.ah);
            registerListener(this.ay);
            registerListener(this.az);
            registerListener(this.f);
            this.h = d();
            this.h.onCreate(this);
            C();
            a(bundle);
            this.w.S();
            this.as.setUniqueId(getUniqueId());
            this.as.a();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.h = d();
        this.h.onStart(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(g gVar) {
        if (gVar != null) {
            try {
                if (this.F) {
                    this.w.J();
                    this.F = false;
                }
                if (gVar.o() == 1) {
                    this.w.v().f(true);
                } else {
                    this.w.v().f(false);
                }
                this.w.a(this.I.g());
                if (gVar.l().a() == 1) {
                    this.O = "frs_page";
                    this.w.B();
                } else {
                    this.O = "normal_page";
                    this.w.A();
                }
                this.w.y();
                this.n = gVar.g().getName();
                this.w.c(this.n);
                G();
                c(gVar);
                b(gVar);
                com.baidu.tbadk.core.data.o top_notice_data = gVar.g().getTop_notice_data();
                if (top_notice_data != null && top_notice_data.a() != null) {
                    com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
                    nVar.c(top_notice_data.a());
                    nVar.c(2);
                    nVar.b(top_notice_data.b());
                    nVar.L();
                    gVar.a(nVar);
                }
                ArrayList<com.baidu.tbadk.core.data.n> h = gVar.h();
                if (h != null) {
                    this.w.a(h, this.q, this.I);
                    M();
                    this.w.k(this.q);
                    if (this.O.equals("frs_page")) {
                        this.w.a(gVar.g(), gVar);
                    } else if (this.O.equals("normal_page")) {
                        this.w.b(gVar.g(), gVar);
                    }
                    this.w.b(this.q);
                    this.w.c(gVar.k().f());
                    this.w.M();
                    this.w.d(0);
                }
                if (gVar.f()) {
                    this.w.w().h();
                    this.w.x().g();
                    return;
                }
                this.w.w().g();
                this.w.x().f();
            } catch (Exception e2) {
                BdLog.e("FrsActivity", "refreshWithCache", "FrsActivity.refreshWithFrs error = " + e2.getMessage());
            }
        }
    }

    private void a(Bundle bundle) {
        this.af = new Handler();
        r();
        w();
        this.t = TbadkApplication.isLogin();
        if (bundle != null) {
            this.n = bundle.getString("name");
            this.o = bundle.getString("from");
            this.p = bundle.getInt("flag", 0);
        } else {
            Intent intent = getIntent();
            this.n = intent.getStringExtra("name");
            this.o = intent.getStringExtra("from");
            this.p = intent.getIntExtra("flag", 0);
            this.E = intent.getBooleanExtra("good", false);
        }
        if (this.E) {
            this.w.ac().setVisibility(4);
            this.w.ad().setVisibility(0);
            this.w.ae().setVisibility(4);
        } else {
            this.w.ac().setVisibility(0);
            this.w.ad().setVisibility(4);
            this.w.ae().setVisibility(4);
        }
        if (this.n != null && this.n.length() > 0) {
            if (this.o == null || this.o.length() <= 0) {
                this.o = "tb_forumlist";
            }
            this.x = this.o;
            v();
            s();
            t();
            u();
            this.P = new de(this);
            if (this.t) {
                f();
                x();
            }
            if (bundle != null) {
                this.Y = (WriteImagesInfo) bundle.getSerializable("write_images");
                this.Z = bundle.getString("photo_name");
            }
            this.Y.setMaxImagesAllowed(10);
            this.ab = new com.baidu.tieba.model.ar();
            this.ab.a(this.ac);
        }
    }

    private void s() {
        this.J = new com.baidu.tieba.model.af();
        this.J.setLoadDataCallBack(new af(this));
    }

    private void t() {
        this.K = new com.baidu.tieba.model.bd();
        this.K.a("from_frs");
        this.K.a(new ag(this));
    }

    private void u() {
        this.L = new com.baidu.tieba.model.az();
        this.L.setLoadDataCallBack(new ah(this));
    }

    @SuppressLint({"HandlerLeak"})
    private void v() {
        this.M = new aj(this);
    }

    public void f() {
        if (this.P != null && this.w != null && b) {
            this.P.a(com.baidu.tbadk.coreExtra.messageCenter.a.a().m());
            this.P.c(com.baidu.tbadk.coreExtra.messageCenter.a.a().k());
            this.P.b(com.baidu.tbadk.coreExtra.messageCenter.a.a().l());
            this.P.d(com.baidu.tbadk.coreExtra.messageCenter.a.a().n());
            this.w.a(this.P, b, c);
        }
    }

    private void w() {
        registerListener(MessageTypes.CMD_FILE_DOWNLOAD, this.aw);
    }

    private void x() {
        registerListener(MessageTypes.CMD_MESSAGE_NOTIFY_LOCAL, this.aw);
    }

    private boolean y() {
        if ("from_hao123".equals(getIntent().getStringExtra("from")) && com.baidu.tieba.util.r.a((Activity) this)) {
            Intent intent = new Intent();
            intent.putExtra("class", 2);
            intent.putExtra("fname", getIntent().getStringExtra("name"));
            MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.ak(this, intent)));
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
                        intent.putExtra("from", "short_cut");
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.ak(this, intent)));
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
        if (this.w != null) {
            this.w.t();
        }
        if (this.M != null) {
            this.M.removeMessages(1);
        }
        super.onDestroy();
        try {
            if (this.I != null) {
                this.I.n();
            }
            if (this.J != null) {
                this.J.a();
            }
            if (this.L != null) {
                this.L.a();
            }
            if (this.ab != null) {
                this.ab.cancelLoadData();
            }
            this.w.P();
            System.gc();
        } catch (Exception e2) {
            BdLog.e("FrsActivity", "onDestroy", e2.getMessage());
        }
        this.h = d();
        this.h.onDestory(this);
        com.baidu.tieba.ai.c().N();
        this.V = null;
        if (this.X != null) {
            this.X.cancel(true);
            this.X = null;
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.n);
        bundle.putString("from", this.o);
        this.h = d();
        if (this.h != null) {
            this.h.onSaveInstanceState(this);
        }
        bundle.putSerializable("write_images", this.Y);
        bundle.putString("photo_name", this.Z);
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
                    j();
                    return;
                case 11011:
                    c(this.z);
                    return;
                case 11012:
                    d(this.Q);
                    return;
                case 11013:
                    D();
                    return;
                case 11014:
                    l();
                    return;
                case 11016:
                    this.w.K();
                    return;
                case 11021:
                    if (this.I != null) {
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
                    b(intent);
                    int size2 = this.Y.size() - 1;
                    if (size2 > -1 && this.Y != null && this.Y.getChosedFiles() != null && (size = this.Y.getChosedFiles().size()) >= 1 && size2 >= 0 && size2 < size) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.bk(this, 12012, this.Y, size2)));
                        return;
                    }
                    return;
                case 12002:
                    a(intent);
                    return;
                case 12004:
                    ArrayList<String> a2 = com.baidu.tieba.util.i.a(intent);
                    if (a2 != null) {
                        this.w.a(a2);
                        return;
                    }
                    return;
                case 12006:
                    WriteData a3 = this.ab.a();
                    if (a3 != null) {
                        a3.deleteUploadedTempImages();
                    }
                    this.ab.a((WriteData) null);
                    this.ab.a(false);
                    this.w.g(true);
                    com.baidu.tieba.util.m.b(this.aa.q(), (WriteData) null);
                    this.w.a(this.Y, true);
                    this.aa.b(this.aa.s() + 1);
                    this.w.z();
                    this.w.U();
                    return;
                case 12012:
                    c(intent);
                    return;
                case 13003:
                    E();
                    return;
                case 18003:
                    this.w.v().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null) {
                        int size3 = this.I.h().size();
                        int i3 = 0;
                        while (true) {
                            if (i3 >= size3) {
                                z = false;
                            } else if (stringExtra.equals(this.I.h().get(i3).p())) {
                                z = true;
                            } else {
                                i3++;
                            }
                        }
                        if (z) {
                            int intExtra = intent.getIntExtra("type", 0);
                            if (intExtra == 2) {
                                this.I.h().get(i3).d(intent.getIntExtra("good_data", 0));
                                this.I.h().get(i3).L();
                                E();
                            } else if (intExtra == 0) {
                                this.I.h().remove(i3);
                                this.w.M();
                                if (f.a() != null) {
                                    f.a().b(this.n);
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
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12001:
                    N();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.Y.setLastAlbumId(intent.getStringExtra("last_album_id"));
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
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onResume() {
        NetworkInfo activeNetworkInfo;
        super.onResume();
        this.k = true;
        this.w.c.u();
        NoNetworkView r = this.w.r();
        if (r != null && r.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            r.setVisible(false);
        }
        if (ai) {
            ai = false;
            this.w.S();
        } else if (d) {
            d = false;
            this.w.S();
        } else {
            if (!this.t && TbadkApplication.isLogin()) {
                this.t = true;
                if (this.I != null && this.I.j() != null) {
                    this.I.j().setIfpost(1);
                }
                E();
            }
            onPreLoad(a());
            if (this.M != null) {
                this.M.removeMessages(1);
                this.M.sendMessageDelayed(this.M.obtainMessage(1), 1000L);
            }
            this.h = d();
            this.h.onResume(this);
            MessageManager.getInstance().sendMessage(new CustomMessage(2009001, new com.baidu.tbadk.core.atomData.z(this, false)));
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.n = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.o = intent.getStringExtra("from");
            }
            this.s = intent.getBooleanExtra("refresh_all", false);
            if (this.s) {
                if (intent.getBooleanExtra("content_show", false)) {
                    A();
                } else {
                    B();
                }
            }
        }
    }

    private void A() {
        this.w.S();
        this.w.o().showContent(false);
    }

    private void B() {
        this.w.S();
        this.w.o().toggle(false);
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
        this.w.P();
        finish();
        CompatibleUtile.setAnim(this, com.baidu.tieba.p.frs_browser_enter, com.baidu.tieba.p.no_effect);
    }

    private void C() {
        this.l = true;
        this.n = "";
        this.o = "";
        this.p = 0;
        this.q = 1;
        this.E = false;
        this.D = 0L;
        this.m = 3;
        this.w = new ct(this, this.ao);
        this.w.n().b();
        this.w.a(this.aj);
        this.w.a(this.ak);
        this.w.a(this.al);
        this.w.a(this.am);
        this.w.a(this.ap);
        this.w.a(this.an);
        this.w.a(this.aq);
        this.w.a(this.at);
        this.w.a(this.av);
        this.w.a(new ak(this));
        this.w.v().a(this.ar);
        n();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.w.j(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.y.login_to_use), true, 11013);
            return;
        }
        CreateBarActivity.a(this, this.n, true);
        finish();
    }

    @Override // com.baidu.tieba.view.r
    public com.baidu.adp.lib.d.b<TbImageView> h() {
        return this.S;
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
            new com.baidu.tbadk.core.util.az(TbConfig.ST_TYPE_ADD_TO_LAUNCHER).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        String str2;
        String str3 = Build.MODEL;
        if (!TextUtils.isEmpty(str3) && str3.startsWith("MI")) {
            str2 = "content://com.miui.home.launcher.settings/favorites?notify=true";
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
            if (this.I != null && this.I.j() != null) {
                this.I.j().setIfpost(1);
            }
            if (i == 0) {
                LoginActivity.a((Activity) this, getString(com.baidu.tieba.y.login_to_use), true, 11001);
            } else {
                LoginActivity.a((Activity) this, getString(com.baidu.tieba.y.login_to_use), true, 11016);
            }
        } else if (this.I != null) {
            if (i == 0) {
                AntiData j = this.I.j();
                if (AntiHelper.a(j) || AntiHelper.b(j) || AntiHelper.c(j)) {
                    j.setBlock_forum_name(this.n);
                    j.setBlock_forum_id(this.I.g().getId());
                    j.setUser_name(this.I.i().getUserName());
                    j.setUser_id(this.I.i().getUserId());
                    if (AntiHelper.a(this, j, AntiHelper.OperationType.CREATE_THREAD, AntiHelper.PageType.FRS)) {
                        return;
                    }
                }
                if (this.I.j() != null && this.I.j().getIfpost() == 0) {
                    com.baidu.adp.lib.util.k.a((Context) this, j.getForbid_info());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.bi(this, 0, this.I.g().getId(), this.n, null, null, 0, this.I.j(), 13003, false, false, null, false, false, null, null, this.I.g().getPrefixData())));
                return;
            }
            this.w.K();
        }
    }

    private boolean a(com.baidu.tbadk.core.data.n nVar) {
        String userId;
        return nVar == null || nVar.y() == null || (userId = nVar.y().getUserId()) == null || userId.equals("0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.n nVar) {
        boolean a2 = a(nVar);
        this.w.a(new al(this, nVar));
        this.w.a(nVar, a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.n nVar) {
        boolean a2 = a(nVar);
        if (this.u != null) {
            if (!a2) {
                sendMessage(new CustomMessage(2006001, new com.baidu.tbadk.core.atomData.as(this).a(nVar, this.n, null, 18003, true, true, this.v)));
            } else {
                sendMessage(new CustomMessage(2006001, new com.baidu.tbadk.core.atomData.as(this).a(nVar, this.n, null, 18003, false, false, this.v)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.core.data.n nVar) {
        if (this.u != null) {
            sendMessage(new CustomMessage(2006001, new com.baidu.tbadk.core.atomData.as(this).a(nVar, this.n, null, 18003, false, false, this.v)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        L();
        this.q = 1;
        this.m = 3;
        F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        boolean z = false;
        switch (this.m) {
            case 1:
                if (this.w.v().a()) {
                    return;
                }
                break;
            case 2:
                if (this.w.v().b()) {
                    return;
                }
                break;
            case 3:
                if (this.w.u()) {
                    return;
                }
                break;
        }
        FRSPageRequestMessage fRSPageRequestMessage = new FRSPageRequestMessage();
        fRSPageRequestMessage.setKw(this.n);
        fRSPageRequestMessage.setPn(this.q);
        if (this.I == null) {
            this.I = new g();
        }
        fRSPageRequestMessage.setForumModel(this.I);
        if (com.baidu.tbadk.core.g.a().f()) {
            fRSPageRequestMessage.setRn(35);
        } else {
            fRSPageRequestMessage.setRn(50);
        }
        fRSPageRequestMessage.setWithGroup(1);
        if (this.E) {
            fRSPageRequestMessage.setIsGood(1);
            fRSPageRequestMessage.setCid((int) this.D);
        }
        int b2 = com.baidu.adp.lib.util.k.b(this);
        int c2 = com.baidu.adp.lib.util.k.c(this);
        float f = b2 / 320.0f;
        int i = com.baidu.tbadk.core.util.bf.a().b() ? 2 : 1;
        fRSPageRequestMessage.setScrW(b2);
        fRSPageRequestMessage.setScrH(c2);
        fRSPageRequestMessage.setScrDip(f);
        fRSPageRequestMessage.setqType(i);
        if (this.x != null) {
            fRSPageRequestMessage.setStType(this.x);
            if (this.x.equalsIgnoreCase("sidebar")) {
                fRSPageRequestMessage.setStType(this.y);
            }
        }
        if (A != 0) {
            fRSPageRequestMessage.setCtime((int) A);
        }
        if (B != 0) {
            fRSPageRequestMessage.setDataSize((int) B);
        }
        if (C != 0) {
            fRSPageRequestMessage.setNetError(C);
        }
        this.w.b(true);
        this.w.v().b(false);
        this.w.v().c(false);
        this.w.v().notifyDataSetChanged();
        if (this.q == 1 && ((this.O.equals("normal_page") || this.O.equals("frs_page")) && !this.E)) {
            z = true;
        }
        if (this.I == null) {
            this.I = new g();
        }
        this.I.a(this.ad);
        this.I.a(this, fRSPageRequestMessage, this.m, z, this.n);
    }

    private void G() {
        switch (this.p) {
            case 1:
                com.baidu.tieba.util.k.f(this.n);
                break;
        }
        this.p = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        L();
        try {
            if (this.I != null) {
                this.w.y();
                this.n = this.I.g().getName();
                this.w.c(this.n);
                TbadkApplication.m252getInst().setDefaultBubble(this.I.i().getBimg_url());
                this.w.c.u();
                G();
                this.l = false;
                ArrayList<com.baidu.tbadk.core.data.n> h = this.I.h();
                if (h != null) {
                    this.w.a(h, this.q, this.I);
                    M();
                    this.w.k(this.q);
                    if (this.O.equals("frs_page")) {
                        I();
                    } else if (this.O.equals("normal_page")) {
                        this.w.b(this.I.g(), this.I);
                    }
                    this.w.b(this.q);
                    this.w.c(this.I.k().f());
                    this.w.M();
                    if (this.I.o() == 1) {
                        this.w.v().f(true);
                    } else {
                        this.w.v().f(false);
                    }
                    if (this.m == 1) {
                        this.w.d(3);
                    } else if (this.m == 2) {
                        if (this.q == 1) {
                            this.w.d(0);
                        } else {
                            this.w.d(3);
                        }
                    } else {
                        this.w.d(0);
                    }
                }
            }
        } catch (Exception e2) {
            BdLog.e("FrsActivity", "", "FrsActivity.refreshFrs error = " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.k = false;
        this.w.O();
        if (this.M != null) {
            this.M.removeMessages(1);
        }
        this.h = d();
        this.h.onPause(this);
        O();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.h = d();
        if (this.h != null) {
            this.h.onStop(this);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.r) {
            if (i == 4) {
                if (this.w.o().isMenuShowing()) {
                    this.w.o().toggle(true);
                    if (this.w.n().d()) {
                        this.w.n().b(false);
                        E();
                        return true;
                    }
                    return true;
                } else if (this.w.c.p()) {
                    this.w.U();
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
                str = String.valueOf(getString(com.baidu.tieba.y.confirm_download_app)) + bVar.g() + getString(com.baidu.tieba.y.question_mark);
            } else {
                str = getString(com.baidu.tieba.y.confirm_download_app_web_url);
            }
        } else {
            str = String.valueOf(getString(com.baidu.tieba.y.confirm_download_app)) + bVar.g() + getString(com.baidu.tieba.y.question_mark);
        }
        builder.setMessage(str);
        builder.setPositiveButton(com.baidu.tieba.y.alert_yes_button, new am(this, bVar, i));
        builder.setNegativeButton(com.baidu.tieba.y.alert_no_button, new an(this));
        this.V = builder.create();
        this.V.show();
    }

    public void b(com.baidu.tbadk.core.data.b bVar, int i) {
        if (!((TextUtils.isEmpty(bVar.i()) || TextUtils.isEmpty(bVar.g())) ? false : true)) {
            com.baidu.adp.lib.util.k.a((Context) this, com.baidu.tieba.y.pb_app_error);
        } else if (UtilHelper.isNetOk()) {
            com.baidu.tbadk.f.a().b(bVar.i(), System.currentTimeMillis());
            TiebaStatic.eventStat(this, "frs_dl_app", "frs_recommend_app", 1, "app_name", bVar.i());
            new com.baidu.tbadk.core.util.az("frs_recommend_app", "frs_dl", bVar.i()).start();
            b.a().a(bVar.i(), bVar.j(), bVar.g(), i);
        } else {
            showToast(com.baidu.tieba.y.neterror);
        }
    }

    public void a(com.baidu.tbadk.core.data.b bVar) {
        String i = bVar.i();
        if (TextUtils.isEmpty(i)) {
            com.baidu.adp.lib.util.k.a((Context) this, com.baidu.tieba.y.pb_app_error);
            return;
        }
        File d2 = com.baidu.tbadk.core.util.x.d(String.valueOf(i.replace(".", "_")) + ".apk");
        if (d2 != null) {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(d2), "application/vnd.android.package-archive");
            startActivity(intent);
        }
    }

    private void I() {
        this.w.a(this.I.g(), this.I);
        this.M.removeMessages(1);
        if (this.q == 1 && this.O.equals("frs_page") && this.I.l().f() == 0) {
            this.N = System.nanoTime() / 1000000000;
            if (this.I.l().g() > 0) {
                this.M.sendMessageDelayed(this.M.obtainMessage(1), 1000L);
            }
        }
    }

    public void i() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.y.login_to_use), true, 11021);
        } else if (!this.I.m()) {
            this.I.a(true);
            this.I.a(this.ae);
            this.I.a(String.valueOf(this.I.g().isLike()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        this.w.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        com.baidu.tbadk.browser.a.a(this, String.valueOf(TbConfig.SERVER_ADDRESS) + "mo/q/fudaiindex?fid=" + this.I.g().getId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.y.login_to_use), true, 11002);
            return;
        }
        this.J.a("from_frs");
        this.J.a(this.I.g().getName(), this.I.g().getId());
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
        if (this.O.equals("normal_page")) {
            this.w.D();
        } else if (this.O.equals("frs_page")) {
            this.w.F();
        }
        this.L.a(this.I.g().getName(), this.I.g().getId());
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.w.n().c()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                if (TbadkApplication.m252getInst().getSkinType() != 1) {
                    TiebaStatic.eventStat(this, "frs_night_mode", "frsclick", 1, new Object[0]);
                    com.baidu.tieba.ai.c().c(1);
                    this.mSkinType = 1;
                    new com.baidu.tbadk.core.util.az(TbConfig.ST_TYPE_EYESHIELD_MODE).start();
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
            com.baidu.tbadk.core.util.g.a();
            com.baidu.tieba.pb.main.bn.a().f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        ArrayList<com.baidu.tbadk.core.data.n> h = this.I.h();
        if (h != null) {
            Iterator<com.baidu.tbadk.core.data.n> it = h.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.core.data.n next = it.next();
                if (next == this.j) {
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
            this.w.v().a(h, this.I);
            this.w.v().notifyDataSetChanged();
        }
    }

    private void a(String str, int i) {
        ArrayList<com.baidu.tbadk.core.data.n> h = this.I.h();
        if (this.I != null && h != null) {
            Iterator<com.baidu.tbadk.core.data.n> it = h.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.core.data.n next = it.next();
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
            this.w.v().a(h, this.I);
            this.w.v().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (str != null) {
            if (TbadkApplication.m252getInst().isFrsImageForum(str)) {
                sendMessage(new CustomMessage(2005002, new com.baidu.tbadk.core.atomData.m(this).b(str, null, 0)));
                g();
                return;
            }
            if (this.w.o().isMenuShowing()) {
                this.w.o().toggle(true);
            }
            this.E = false;
            this.n = str;
            E();
        }
    }

    @Override // com.baidu.tbadk.core.voice.z
    public VoiceManager d() {
        if (this.h == null) {
            this.h = VoiceManager.instance();
        }
        return this.h;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.w
    /* renamed from: m */
    public BdListView a() {
        if (this.w == null) {
            return null;
        }
        return this.w.L();
    }

    @Override // com.baidu.tbadk.core.voice.z
    public com.baidu.tbadk.core.voice.x a(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        this.h = d();
        this.h.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.w
    public int c_() {
        if (this.w == null) {
            return 0;
        }
        return this.w.T();
    }

    @Override // com.baidu.tbadk.core.view.w
    public com.baidu.adp.lib.d.b<TbImageView> c() {
        return this.R;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
                return;
            }
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgFans = newsNotifyMessage.getMsgFans();
            int msgReplyme = newsNotifyMessage.getMsgReplyme();
            int msgAtme = newsNotifyMessage.getMsgAtme();
            int msgChat = newsNotifyMessage.getMsgChat();
            if (this.P != null) {
                this.P.a(msgFans);
                this.P.c(msgReplyme);
                this.P.b(msgAtme);
                this.P.d(msgChat);
                this.w.a(this.P, b, c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        az v;
        HashMap<Integer, com.baidu.tbadk.core.data.n> c2;
        if (this.I != null && this.w != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null && (v = this.w.v()) != null && (c2 = v.c()) != null && c2.size() > 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null) {
                    Iterator<Map.Entry<Integer, com.baidu.tbadk.core.data.n>> it = c2.entrySet().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Map.Entry<Integer, com.baidu.tbadk.core.data.n> next = it.next();
                            int intValue = next.getKey().intValue();
                            com.baidu.tbadk.core.data.n value = next.getValue();
                            if (value != null && (value instanceof com.baidu.tbadk.core.data.b) && ((com.baidu.tbadk.core.data.b) value).i().equals(downloadData.getId())) {
                                if (v.getItem(intValue) instanceof com.baidu.tbadk.core.data.b) {
                                    com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) v.getItem(intValue);
                                    int status = downloadData.getStatus();
                                    if (status == 3 || status == 0) {
                                        bVar.a(2);
                                    } else if (status == 2 || status == 4) {
                                        if (!com.baidu.tbadk.core.util.be.c(downloadData.getStatusMsg())) {
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
            this.w.z();
        }
    }

    private void M() {
        HashMap<Integer, com.baidu.tbadk.core.data.n> c2;
        if ((this.w != null || this.w.v() != null) && (c2 = this.w.v().c()) != null) {
            ArrayList<com.baidu.tbadk.core.data.b> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, com.baidu.tbadk.core.data.n> entry : c2.entrySet()) {
                com.baidu.tbadk.core.data.n value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.b)) {
                    arrayList.add((com.baidu.tbadk.core.data.b) value);
                }
            }
            b.a().a(arrayList);
        }
    }

    public void a(int i, com.baidu.tbadk.core.data.n nVar, int i2) {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.y.login_to_use), true, 0);
            return;
        }
        if (this.aa != nVar && this.aa != null) {
            O();
            this.w.d((String) null);
            this.Y = new WriteImagesInfo();
            this.Y.setMaxImagesAllowed(10);
            this.w.a(this.Y, true);
            this.ab.a((WriteData) null);
            this.ab.a(false);
            this.w.X();
            com.baidu.tieba.util.m.a(nVar.q(), this);
        }
        this.aa = nVar;
        this.w.a(i, nVar, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Boolean bool) {
        if (com.baidu.tieba.c.a.a(this.I.g().getName(), bool)) {
            this.w.ab();
        } else {
            this.w.aa();
        }
    }

    private void a(Intent intent) {
        a(intent, true);
    }

    private void b(Intent intent) {
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.Z;
        if (!TextUtils.isEmpty(str)) {
            try {
                int b2 = com.baidu.tbadk.core.util.g.b(str);
                if (b2 != 0) {
                    Bitmap a2 = com.baidu.tbadk.core.util.g.a(str, com.baidu.adp.lib.util.k.a(this, com.baidu.adp.lib.util.k.b(this)), com.baidu.adp.lib.util.k.a(this, com.baidu.adp.lib.util.k.c(this)));
                    Bitmap e2 = com.baidu.tbadk.core.util.g.e(a2, b2);
                    if (a2 != e2) {
                        a2.recycle();
                    }
                    com.baidu.tbadk.core.util.x.a(TbConfig.LOCAL_CAMERA_DIR, this.Z, e2, 100);
                    e2.recycle();
                }
            } catch (Exception e3) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.Y.addChooseFile(imageFileInfo);
            this.Y.updateQuality();
            this.w.a(this.Y, true);
        }
        if (this.Y.getChosedFiles() != null && this.Y.getChosedFiles().size() > 0) {
            this.w.c.b(23);
        }
    }

    private void c(Intent intent) {
        a(intent, false);
    }

    private void a(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.Y.parseJson(stringExtra);
                this.Y.updateQuality();
                if (this.Y.getChosedFiles() != null) {
                    this.w.a(this.Y, z);
                }
            }
            if (this.Y.getChosedFiles() != null && this.Y.getChosedFiles().size() > 0) {
                this.w.c.b(23);
            }
        }
    }

    private void N() {
        new aq(this).execute(new Void[0]);
    }

    protected void n() {
        String[] strArr = {getString(com.baidu.tieba.y.take_photo), getString(com.baidu.tieba.y.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(com.baidu.tieba.y.operation));
        builder.setItems(strArr, new ar(this));
        if (this.ax == null) {
            this.ax = builder.create();
            this.ax.setCanceledOnTouchOutside(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        if (this.ab.a() == null) {
            WriteData o = o();
            o.setWriteImagesInfo(this.Y);
            this.ab.a(this.Y.size() > 0);
            this.ab.a(o);
        }
        if (this.ab.a() != null) {
            this.ab.a().setIsFrsReply(true);
            this.ab.a().setContent(this.w.V());
            VoiceData.VoiceModel W = this.w.W();
            this.w.Y();
            if (W != null) {
                if (W.getId() != null) {
                    this.ab.a().setVoice(W.getId());
                    this.ab.a().setVoiceDuringTime(W.duration);
                } else {
                    this.ab.a().setVoice(null);
                    this.ab.a().setVoiceDuringTime(-1);
                }
            } else {
                this.ab.a().setVoice(null);
                this.ab.a().setVoiceDuringTime(-1);
            }
            if (this.ab.b()) {
                this.w.Z();
            }
        }
    }

    public WriteData o() {
        WriteData writeData = new WriteData();
        writeData.setForumId(this.I.g().getId());
        writeData.setForumName(this.I.g().getName());
        writeData.setThreadId(this.aa.q());
        writeData.setIsAd(false);
        writeData.setType(1);
        return writeData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.a(antiData) || AntiHelper.b(antiData) || AntiHelper.c(antiData) || AntiHelper.d(antiData)) {
            antiData.setBlock_forum_name(this.aa.z());
            antiData.setBlock_forum_id(this.I.g().getId());
            antiData.setUser_name(this.aa.y().getUserName());
            antiData.setUser_id(this.aa.y().getUserId());
            AntiHelper.a(this, antiData, AntiHelper.OperationType.REPLY, AntiHelper.PageType.PB);
            return;
        }
        com.baidu.adp.lib.util.k.a((Context) this, str);
    }

    @Override // com.baidu.tieba.util.n
    public void a(WriteData writeData) {
        if (writeData != null && this.aa != null && writeData.getThreadId().equals(this.aa.q())) {
            if (!com.baidu.tbadk.core.util.be.c(writeData.getContent()) && com.baidu.tbadk.core.util.be.c(this.w.V())) {
                this.w.d(writeData.getContent());
            }
            if (writeData.getWriteImagesInfo() != null && this.Y.size() == 0) {
                this.Y.copyFrom(writeData.getWriteImagesInfo());
                this.w.a(this.Y, true);
            }
        }
    }

    private void O() {
        if (this.aa != null) {
            WriteData a2 = this.ab.a();
            if (a2 == null) {
                a2 = new WriteData(1);
                a2.setThreadId(this.aa.q());
                a2.setWriteImagesInfo(this.Y);
            }
            a2.setContent(this.w.V());
            com.baidu.tieba.util.m.b(this.aa.q(), a2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.g
    public void onPreLoad(BdListView bdListView) {
        if (bdListView != null && this.I != null) {
            com.baidu.tbadk.core.util.ay.a(bdListView, getUniqueId(), this.I.o() == 1 ? 13 : 14);
        }
    }
}
