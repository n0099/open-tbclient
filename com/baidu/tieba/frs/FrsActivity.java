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
import android.widget.ListView;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
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
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.download.DownloadMessage;
import com.baidu.tieba.home.CreateBarActivity;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.util.AntiHelper;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes.dex */
public class FrsActivity extends com.baidu.tbadk.a implements com.baidu.adp.widget.BdSwitchView.c, com.baidu.tbadk.core.view.w, com.baidu.tbadk.core.voice.z, com.baidu.tbadk.widget.j, com.baidu.tieba.util.n {
    private static boolean af;
    private cu K;
    private ax R;
    private String T;
    private com.baidu.tbadk.core.data.o U;
    private com.baidu.tieba.model.ar V;
    private AlertDialog aw;
    VoiceManager d;
    private com.baidu.tbadk.core.data.o f;
    public static String a = "has_shown_frs_guide";
    public static boolean b = false;
    private static volatile long v = 0;
    private static volatile long w = 0;
    private static volatile int x = 0;
    private boolean e = false;
    private boolean g = true;
    private int h = 3;
    private String i = null;
    private String j = null;
    private int k = 0;
    private int l = 1;
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;
    private String p = null;
    private boolean q = false;
    private cm r = null;
    private String s = null;
    private String t = null;
    private final com.baidu.tbadk.core.data.o u = null;
    private long y = 0;
    private boolean z = false;
    private boolean A = true;
    private boolean B = true;
    private boolean C = true;
    private g D = null;
    private com.baidu.tieba.model.af E = null;
    private com.baidu.tieba.model.bc F = null;
    private com.baidu.tieba.model.az G = null;
    private Handler H = null;
    private long I = 0;
    private String J = "normal_page";
    private com.baidu.tbadk.core.data.o L = null;
    private final com.baidu.adp.lib.d.b<TbImageView> M = UserIconBox.a(this, 8);
    private boolean N = false;
    private long O = -1;
    private AlertDialog P = null;
    private String Q = "";
    private WriteImagesInfo S = new WriteImagesInfo();
    private final com.baidu.tieba.model.as W = new l(this);
    private final cx X = new x(this);
    private final cw Y = new ai(this);
    private Handler Z = null;
    private com.baidu.tbadk.core.util.b aa = null;
    private final Runnable ab = new ar(this);
    com.baidu.tbadk.imageManager.d c = new as(this);
    private final com.baidu.tbadk.imageManager.d ac = new at(this);
    private final com.baidu.tbadk.imageManager.d ad = new au(this);
    private final com.baidu.adp.framework.c.a ae = new av(this, 2003003);
    private final com.baidu.adp.widget.ListView.t ag = new aw(this);
    private final com.baidu.adp.widget.ListView.v ah = new m(this);
    private final AdapterView.OnItemClickListener ai = new n(this);
    private final AdapterView.OnItemLongClickListener aj = new p(this);
    private final com.baidu.adp.widget.ListView.d ak = new q(this);
    private final View.OnClickListener al = new r(this);
    private int am = 0;
    private final AbsListView.OnScrollListener an = new s(this);
    private final SlidingMenu.OnClosedListener ao = new t(this);
    private final bf ap = new u(this);
    private dc aq = new dc(new v(this));
    private final SlidingMenu.OnOpenedListener ar = new w(this);
    private final AdapterView.OnItemClickListener as = new y(this);
    private final com.baidu.tbadk.core.view.m at = new z(this);
    private final List<com.baidu.tbadk.widget.k> au = new ArrayList();
    private final com.baidu.adp.framework.c.a av = new aa(this, 0);

    @Override // com.baidu.tbadk.core.view.w
    public final /* synthetic */ ListView a() {
        if (this.r == null) {
            return null;
        }
        return this.r.I();
    }

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2003000, new ab());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2003001, new ac());
        customMessageTask2.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask2);
        com.baidu.tbadk.core.util.bg.a().a(new ad());
        af = false;
    }

    @Override // com.baidu.tbadk.a
    public boolean getGpuSwitch() {
        return TbadkApplication.j().ax();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(FrsActivity frsActivity, g gVar) {
        if (gVar == null || gVar.f() == null) {
            return;
        }
        frsActivity.r.m().a(gVar.f().getRecommendForumData());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar) {
        int i;
        com.baidu.tbadk.core.data.o oVar;
        if (gVar != null && gVar.f() != null) {
            com.baidu.tbadk.core.data.c bannerListData = gVar.f().getBannerListData();
            ArrayList<com.baidu.tbadk.core.data.o> g = gVar.g();
            if (bannerListData != null && bannerListData.a() != null && g != null && g.size() > 0) {
                int i2 = 0;
                Iterator<com.baidu.tbadk.core.data.o> it = g.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    com.baidu.tbadk.core.data.o next = it.next();
                    if (next.q() != 1 && next.q() != 2) {
                        break;
                    }
                    i2 = i + 1;
                }
                Iterator<com.baidu.tbadk.core.data.b> it2 = bannerListData.a().iterator();
                while (it2.hasNext()) {
                    com.baidu.tbadk.core.data.b next2 = it2.next();
                    int a2 = (next2.a() + i) - 1;
                    if (this.r != null && this.r.t() != null && this.r.t().d().size() > 0 && (oVar = (com.baidu.tbadk.core.data.o) this.r.t().getItem(a2)) != null && (oVar instanceof com.baidu.tbadk.core.data.b)) {
                        next2.a(((com.baidu.tbadk.core.data.b) oVar).g());
                    }
                    if (!UtilHelper.isInstalledPackage(this, next2.e())) {
                        gVar.g().add(a2, next2);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(FrsActivity frsActivity, j jVar) {
        if (!frsActivity.g) {
            if (jVar != null) {
                frsActivity.r.a(jVar.d);
            }
        } else if (jVar != null) {
            if (!jVar.a || !jVar.b) {
                if (com.baidu.tbadk.core.util.UtilHelper.d(frsActivity) != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    frsActivity.r.a(jVar.d);
                }
            } else if (jVar.c != 3) {
                if (com.baidu.tbadk.core.util.UtilHelper.d(frsActivity) != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    frsActivity.r.a(jVar.d);
                }
            } else {
                frsActivity.m = false;
                frsActivity.i = frsActivity.i.replace(" ", "");
                String str = frsActivity.i;
                if (str.length() > 31) {
                    str = String.valueOf(str.substring(0, 31)) + "...";
                }
                frsActivity.r.b(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e() {
        com.baidu.tbadk.core.data.o b2 = this.r.u().b();
        if (b2 != null) {
            ArrayList<com.baidu.tbadk.core.data.j> z = b2.z();
            int size = z.size();
            for (int i = 0; i < size; i++) {
                if (z.get(i).b() == 3) {
                    this.r.u().a().b(z.get(i).c(), this.ad);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void f() {
        com.baidu.tbadk.core.data.o b2 = this.r.v().b();
        if (b2 != null) {
            ArrayList<com.baidu.tbadk.core.data.j> z = b2.z();
            int size = z.size();
            for (int i = 0; i < size; i++) {
                if (z.get(i).b() == 3) {
                    this.r.v().a().b(z.get(i).c(), this.ad);
                }
            }
        }
    }

    public static Intent a(Context context, String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        Class<?> a2 = TbadkApplication.j().a(com.baidu.tbadk.core.b.z.class);
        if (a2 != null) {
            Intent intent = new Intent(context, a2);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setAction("android.intent.action.MAIN");
            intent.setFlags(603979776);
            intent.putExtra("fname", str);
            intent.putExtra("from_short_cut", true);
            intent.putExtra("back_special", true);
            intent.putExtra("from", "short_cut");
            return intent;
        }
        com.baidu.adp.lib.util.f.b("没有注册LogoActivity？ 导致获取class失败");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.O = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.O = System.currentTimeMillis();
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
                        intent2.putExtra("fname", getIntent().getStringExtra(PersonInfoActivity.TAG_NAME));
                        intent2.putExtra("from", "short_cut");
                        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.z(this, intent2)));
                        finish();
                        z = false;
                    }
                }
            }
        }
        z = true;
        if (z) {
            registerListener(this.ae);
            this.d = d();
            this.d.a((Activity) this);
            this.g = true;
            this.i = "";
            this.j = "";
            this.k = 0;
            this.l = 1;
            this.z = false;
            this.y = 0L;
            this.h = 3;
            this.r = new cm(this, this.al);
            this.r.m().d();
            this.r.a(this.ag);
            this.r.a(this.ah);
            this.r.a(this.ai);
            this.r.a(this.aj);
            this.r.a(this.an);
            this.r.a(this.ak);
            this.r.a(this.ao);
            this.r.a(this.ar);
            this.r.a(this.at);
            cm cmVar = this.r;
            aj ajVar = new aj(this);
            if (ajVar != null) {
                cmVar.c.setOnActionListener(new ct(cmVar, ajVar));
            }
            this.r.t().a(this.ap);
            String[] strArr = {getString(com.baidu.tieba.a.k.take_photo), getString(com.baidu.tieba.a.k.album)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(com.baidu.tieba.a.k.operation));
            builder.setItems(strArr, new aq(this));
            if (this.aw == null) {
                this.aw = builder.create();
                this.aw.setCanceledOnTouchOutside(true);
            }
            this.Z = new Handler();
            this.aa = new com.baidu.tbadk.core.util.b(this);
            this.aa.e = true;
            int a2 = com.baidu.adp.lib.util.i.a((Context) this, 427.0f);
            if (a2 > 640) {
                a2 = 640;
            }
            this.aa.a(a2, (int) (a2 * 1.6f));
            registerListener(2001122, this.av);
            this.o = TbadkApplication.F();
            if (bundle != null) {
                this.i = bundle.getString(PersonInfoActivity.TAG_NAME);
                this.j = bundle.getString("from");
                this.k = bundle.getInt("flag", 0);
            } else {
                Intent intent3 = getIntent();
                this.i = intent3.getStringExtra(PersonInfoActivity.TAG_NAME);
                this.j = intent3.getStringExtra("from");
                this.k = intent3.getIntExtra("flag", 0);
                this.z = intent3.getBooleanExtra("good", false);
            }
            if (this.z) {
                this.r.R().setVisibility(4);
                this.r.S().setVisibility(0);
                this.r.T().setVisibility(4);
            } else {
                this.r.R().setVisibility(0);
                this.r.S().setVisibility(4);
                this.r.T().setVisibility(4);
            }
            if (this.i != null && this.i.length() > 0) {
                if (this.j == null || this.j.length() <= 0) {
                    this.j = "tb_forumlist";
                }
                this.s = this.j;
                this.H = new ah(this);
                this.E = new com.baidu.tieba.model.af();
                this.E.setLoadDataCallBack(new ae(this));
                this.F = new com.baidu.tieba.model.bc();
                this.F.a("from_frs");
                this.F.a(new af(this));
                this.G = new com.baidu.tieba.model.az();
                this.G.setLoadDataCallBack(new ag(this));
                this.K = new cu();
                if (this.o) {
                    g();
                    registerListener(2001124, this.av);
                }
                if (bundle != null) {
                    this.S = (WriteImagesInfo) bundle.getSerializable("write_images");
                    this.T = bundle.getString("photo_name");
                }
                this.S.setMaxImagesAllowed(10);
                this.V = new com.baidu.tieba.model.ar();
                this.V.a(this.W);
            }
            this.r.O();
            this.aq.setUniqueId(getUniqueId());
            this.aq.a();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.d = d();
        VoiceManager voiceManager = this.d;
        VoiceManager.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(FrsActivity frsActivity, g gVar) {
        if (gVar == null) {
            return;
        }
        try {
            if (frsActivity.A) {
                frsActivity.r.G();
                frsActivity.A = false;
            }
            if (gVar.n() == 1) {
                frsActivity.r.t().f(true);
            } else {
                frsActivity.r.t().f(false);
            }
            frsActivity.r.a(frsActivity.D.f());
            if (gVar.k().a() == 1) {
                frsActivity.J = "frs_page";
                frsActivity.r.z();
            } else {
                frsActivity.J = "normal_page";
                frsActivity.r.y();
            }
            frsActivity.r.w();
            frsActivity.i = gVar.f().getName();
            frsActivity.r.c(frsActivity.i);
            frsActivity.p();
            if (frsActivity.C && !TbadkApplication.j().v().contains(frsActivity.i)) {
                frsActivity.a(gVar);
                frsActivity.C = false;
            }
            com.baidu.tbadk.core.data.p top_notice_data = gVar.f().getTop_notice_data();
            if (top_notice_data != null && top_notice_data.a() != null) {
                com.baidu.tbadk.core.data.o oVar = new com.baidu.tbadk.core.data.o();
                oVar.c(top_notice_data.a());
                oVar.c(2);
                oVar.b(top_notice_data.b());
                oVar.E();
                gVar.g().add(0, oVar);
            }
            ArrayList<com.baidu.tbadk.core.data.o> g = gVar.g();
            if (g != null) {
                cm cmVar = frsActivity.r;
                int i = frsActivity.l;
                cmVar.a(g, frsActivity.D);
                frsActivity.s();
                if (frsActivity.J.equals("frs_page")) {
                    frsActivity.r.a(gVar.f(), gVar);
                } else if (frsActivity.J.equals("normal_page")) {
                    frsActivity.r.b(gVar.f(), gVar);
                }
                frsActivity.r.b(frsActivity.l);
                frsActivity.r.c(gVar.j().f());
                frsActivity.r.J();
                frsActivity.r.d(0);
            }
            if (gVar.n() == 1) {
                frsActivity.r.t().a().a(true);
            } else {
                frsActivity.r.t().a().a(false);
            }
            if (gVar.e()) {
                frsActivity.r.u().j();
                frsActivity.r.v().i();
            } else {
                frsActivity.r.u().i();
                frsActivity.r.v().h();
            }
            frsActivity.Z.removeCallbacks(frsActivity.ab);
            frsActivity.Z.postDelayed(frsActivity.ab, 300L);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("FrsActivity", "refreshWithCache", "FrsActivity.refreshWithFrs error = " + e.getMessage());
        }
    }

    public final void g() {
        if (this.K != null && this.r != null) {
            this.K.a(com.baidu.tbadk.coreExtra.messageCenter.a.a().k());
            this.K.c(com.baidu.tbadk.coreExtra.messageCenter.a.a().i());
            this.K.b(com.baidu.tbadk.coreExtra.messageCenter.a.a().j());
            this.K.d(com.baidu.tbadk.coreExtra.messageCenter.a.a().l());
            this.r.a(this.K);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        if (this.r != null) {
            this.r.r();
        }
        if (this.Z != null) {
            this.Z.removeCallbacks(this.ab);
        }
        if (this.H != null) {
            this.H.removeMessages(1);
        }
        super.onDestroy();
        try {
            if (this.D != null) {
                this.D.m();
            }
            if (this.E != null) {
                this.E.a();
            }
            if (this.G != null) {
                this.G.a();
            }
            if (this.V != null) {
                this.V.cancelLoadData();
            }
            this.r.M();
            System.gc();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("FrsActivity", "onDestroy", e.getMessage());
        }
        this.d = d();
        this.d.d(this);
        com.baidu.tieba.r.c();
        com.baidu.tieba.r.N();
        com.baidu.tbadk.imageManager.e.a().c();
        this.P = null;
        if (this.R != null) {
            this.R.cancel(true);
            this.R = null;
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(PersonInfoActivity.TAG_NAME, this.i);
        bundle.putString("from", this.j);
        this.d = d();
        if (this.d != null) {
            VoiceManager voiceManager = this.d;
            VoiceManager.i();
        }
        bundle.putSerializable("write_images", this.S);
        bundle.putString("photo_name", this.T);
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
                    b(this.u);
                    return;
                case 11012:
                    c(this.L);
                    return;
                case 11013:
                    m();
                    return;
                case 11014:
                    k();
                    return;
                case 11016:
                    this.r.H();
                    return;
                case 11021:
                    if (this.D != null) {
                        i();
                        return;
                    }
                    return;
                case 11033:
                default:
                    return;
                case 11036:
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(getString(com.baidu.tieba.a.k.attention_cancel_info));
                    builder.setTitle(getString(com.baidu.tieba.a.k.alerm_title));
                    builder.setPositiveButton(getString(com.baidu.tieba.a.k.attention_cancel), new an(this));
                    builder.setNegativeButton(getString(com.baidu.tieba.a.k.cancel), new ao(this));
                    builder.create().show();
                    return;
                case 12001:
                    String str = Environment.getExternalStorageDirectory() + "/" + com.baidu.tbadk.core.data.n.f() + "/cameras/" + this.T;
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            int b2 = com.baidu.tbadk.core.util.g.b(str);
                            if (b2 != 0) {
                                Bitmap a2 = com.baidu.tbadk.core.util.g.a(str, com.baidu.adp.lib.util.i.a(this, com.baidu.adp.lib.util.i.b(this)), com.baidu.adp.lib.util.i.a(this, com.baidu.adp.lib.util.i.c(this)));
                                Bitmap e = com.baidu.tbadk.core.util.g.e(a2, b2);
                                if (a2 != e) {
                                    a2.recycle();
                                }
                                com.baidu.tbadk.core.util.w.a("cameras", this.T, e, 100);
                                e.recycle();
                            }
                        } catch (Exception e2) {
                        }
                        ImageFileInfo imageFileInfo = new ImageFileInfo();
                        imageFileInfo.setFilePath(str);
                        imageFileInfo.setTempFile(true);
                        this.S.addChooseFile(imageFileInfo);
                        this.S.updateQuality();
                        this.r.a(this.S, true);
                    }
                    if (this.S.getChosedFiles() != null && this.S.getChosedFiles().size() > 0) {
                        this.r.c.b(23);
                    }
                    int size2 = this.S.size() - 1;
                    if (size2 >= 0 && this.S != null && this.S.getChosedFiles() != null && (size = this.S.getChosedFiles().size()) > 0 && size2 >= 0 && size2 < size) {
                        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.ax(this, 12012, this.S, size2)));
                        return;
                    }
                    return;
                case 12002:
                    a(intent, true);
                    return;
                case 12004:
                    ArrayList<String> a3 = com.baidu.tieba.util.i.a(intent);
                    if (a3 != null) {
                        this.r.c.a(a3);
                        return;
                    }
                    return;
                case 12006:
                    WriteData a4 = this.V.a();
                    if (a4 != null) {
                        a4.deleteUploadedTempImages();
                    }
                    this.V.a((WriteData) null);
                    this.V.a(false);
                    this.r.h(true);
                    com.baidu.tieba.util.m.b(this.U.m(), (WriteData) null);
                    this.r.a(this.S, true);
                    this.U.b(this.U.o() + 1);
                    this.r.x();
                    this.r.P();
                    return;
                case 12012:
                    a(intent, false);
                    return;
                case 13003:
                    n();
                    return;
                case 18003:
                    this.r.t().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null) {
                        int size3 = this.D.g().size();
                        int i3 = 0;
                        while (true) {
                            if (i3 >= size3) {
                                z = false;
                            } else if (stringExtra.equals(this.D.g().get(i3).l())) {
                                z = true;
                            } else {
                                i3++;
                            }
                        }
                        if (z) {
                            int intExtra = intent.getIntExtra("type", 0);
                            if (intExtra == 2) {
                                this.D.g().get(i3).d(intent.getIntExtra("good_data", 0));
                                this.D.g().get(i3).E();
                                n();
                                return;
                            } else if (intExtra == 0) {
                                this.D.g().remove(i3);
                                this.r.J();
                                if (f.a() != null) {
                                    f.a().b(this.i);
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
                case 12001:
                    new ap(this).execute(new Void[0]);
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.S.setLastAlbumId(intent.getStringExtra("last_album_id"));
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
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        NetworkInfo activeNetworkInfo;
        super.onResume();
        this.r.c.s();
        this.am = 0;
        NoNetworkView q = this.r.q();
        if (q != null && q.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            q.setVisible(false);
        }
        if (af) {
            af = false;
            this.r.O();
        } else if (b) {
            b = false;
            this.r.O();
        } else {
            if (!this.o && TbadkApplication.F()) {
                this.o = true;
                if (this.D != null && this.D.i() != null) {
                    this.D.i().setIfpost(1);
                }
                n();
            }
            this.ab.run();
            if (this.H != null) {
                this.H.removeMessages(1);
                this.H.sendMessageDelayed(this.H.obtainMessage(1), 1000L);
            }
            this.d = d();
            this.d.b(this);
            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2007001, new com.baidu.tbadk.core.b.w(this, false)));
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        this.n = intent.getBooleanExtra("refresh_all", false);
        if (this.n) {
            this.r.O();
            this.r.n().toggle(false);
        }
    }

    @Override // com.baidu.tbadk.a
    public void closeActivity() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
            return;
        }
        String E = TbadkApplication.E();
        if (E != null && E.length() > 0) {
            com.baidu.tbadk.core.d.b.a(this, 1);
        } else {
            com.baidu.tbadk.core.d.b.a(this, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h() {
        this.r.M();
        finish();
        CompatibleUtile.setAnim(this, com.baidu.tieba.a.b.frs_browser_enter, com.baidu.tieba.a.b.no_effect);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.r.j(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        String E = TbadkApplication.E();
        if (E == null || E.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.a.k.login_to_use), true, 11013);
            return;
        }
        CreateBarActivity.a(this, this.i, true);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void i(FrsActivity frsActivity, String str) {
        Intent a2;
        if (str == null || (a2 = a((Context) frsActivity, str)) == null) {
            return;
        }
        Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent.putExtra("duplicate", false);
        intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + frsActivity.getString(com.baidu.tieba.a.k.bar));
        intent.putExtra("android.intent.extra.shortcut.INTENT", a2);
        intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(frsActivity, com.baidu.tieba.a.g.icon));
        frsActivity.sendBroadcast(intent);
        new com.baidu.tbadk.core.util.ax("add_to_launcher").start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean h(FrsActivity frsActivity, String str) {
        String str2 = Build.MODEL;
        Cursor query = frsActivity.getContentResolver().query(Uri.parse((TextUtils.isEmpty(str2) || !str2.startsWith("MI")) ? Build.VERSION.SDK_INT < 8 ? "content://com.android.launcher.settings/favorites?notify=true" : "content://com.android.launcher2.settings/favorites?notify=true" : "content://com.miui.home.launcher.settings/favorites?notify=true"), null, "title=?", new String[]{String.valueOf(str) + frsActivity.getString(com.baidu.tieba.a.k.bar)}, null);
        return query != null && query.getCount() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        String E = TbadkApplication.E();
        if (E == null || E.length() <= 0) {
            if (this.D != null && this.D.i() != null) {
                this.D.i().setIfpost(1);
            }
            if (i == 0) {
                LoginActivity.a((Activity) this, getString(com.baidu.tieba.a.k.login_to_use), true, 11001);
            } else {
                LoginActivity.a((Activity) this, getString(com.baidu.tieba.a.k.login_to_use), true, 11016);
            }
        } else if (this.D != null) {
            if (i == 0) {
                AntiData i2 = this.D.i();
                if (AntiHelper.a(i2) || AntiHelper.b(i2) || AntiHelper.c(i2)) {
                    i2.setBlock_forum_name(this.i);
                    i2.setBlock_forum_id(this.D.f().getId());
                    i2.setUser_name(this.D.h().getUserName());
                    i2.setUser_id(this.D.h().getUserId());
                    if (AntiHelper.a(this, i2, AntiHelper.OperationType.CREATE_THREAD, AntiHelper.PageType.FRS)) {
                        return;
                    }
                }
                if (this.D.i() != null && this.D.i().getIfpost() == 0) {
                    com.baidu.adp.lib.util.i.a((Context) this, i2.getForbid_info());
                    return;
                }
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.av(this, 0, this.D.f().getId(), this.i, null, null, 0, this.D.i(), 13003, false, false, null, false, false, null, null, this.D.f().getPrefixData())));
                return;
            }
            this.r.H();
        }
    }

    private static boolean a(com.baidu.tbadk.core.data.o oVar) {
        String userId;
        return oVar == null || oVar.t() == null || (userId = oVar.t().getUserId()) == null || userId.equals("0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(FrsActivity frsActivity, com.baidu.tbadk.core.data.o oVar) {
        boolean a2 = a(oVar);
        frsActivity.r.a(new ak(frsActivity, oVar));
        frsActivity.r.b(a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.o oVar) {
        boolean a2 = a(oVar);
        if (this.p != null) {
            if (!a2) {
                sendMessage(new com.baidu.adp.framework.message.a(2004001, new com.baidu.tbadk.core.b.af(this).a(oVar, this.i, null, 18003, true, true, this.q)));
            } else {
                sendMessage(new com.baidu.adp.framework.message.a(2004001, new com.baidu.tbadk.core.b.af(this).a(oVar, this.i, null, 18003, false, false, this.q)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.o oVar) {
        if (this.p != null) {
            sendMessage(new com.baidu.adp.framework.message.a(2004001, new com.baidu.tbadk.core.b.af(this).a(oVar, this.i, null, 18003, false, false, this.q)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        r();
        this.l = 1;
        this.h = 3;
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        BasicNameValuePair basicNameValuePair;
        boolean z = false;
        switch (this.h) {
            case 1:
                if (this.r.t().b()) {
                    return;
                }
                break;
            case 2:
                if (this.r.t().c()) {
                    return;
                }
                break;
            case 3:
                if (this.r.s()) {
                    return;
                }
                break;
        }
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append(com.baidu.tbadk.core.data.n.a);
        stringBuffer.append("c/f/frs/page");
        ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
        arrayList.add(new BasicNameValuePair("kw", this.i));
        arrayList.add(new BasicNameValuePair("pn", String.valueOf(this.l)));
        if (com.baidu.tbadk.core.h.a().f()) {
            basicNameValuePair = new BasicNameValuePair("rn", String.valueOf(35));
        } else {
            basicNameValuePair = new BasicNameValuePair("rn", String.valueOf(50));
        }
        arrayList.add(basicNameValuePair);
        arrayList.add(new BasicNameValuePair("with_group", "1"));
        if (this.z) {
            arrayList.add(new BasicNameValuePair("is_good", "1"));
            arrayList.add(new BasicNameValuePair("cid", String.valueOf(this.y)));
        }
        int b2 = com.baidu.adp.lib.util.i.b(this);
        int c = com.baidu.adp.lib.util.i.c(this);
        float f = b2 / 320.0f;
        int i = com.baidu.tbadk.core.util.bd.a().b() ? 2 : 1;
        arrayList.add(new BasicNameValuePair("scr_w", String.valueOf(b2)));
        arrayList.add(new BasicNameValuePair("scr_h", String.valueOf(c)));
        arrayList.add(new BasicNameValuePair("scr_dip", String.valueOf(f)));
        arrayList.add(new BasicNameValuePair("q_type", String.valueOf(i)));
        if (this.s != null) {
            arrayList.add(new BasicNameValuePair("st_type", this.s));
            if (this.s.equalsIgnoreCase("sidebar")) {
                arrayList.add(new BasicNameValuePair("st_param", this.t));
            }
        }
        if (v != 0) {
            arrayList.add(new BasicNameValuePair("ctime", String.valueOf(v)));
        }
        if (w != 0) {
            arrayList.add(new BasicNameValuePair("data_size", String.valueOf(w)));
        }
        if (x != 0) {
            arrayList.add(new BasicNameValuePair("net_error", String.valueOf(x)));
        }
        this.r.c(true);
        this.r.t().b(false);
        this.r.t().c(false);
        this.r.t().notifyDataSetChanged();
        if (this.l == 1 && ((this.J.equals("normal_page") || this.J.equals("frs_page")) && !this.z)) {
            z = true;
        }
        if (this.D == null) {
            this.D = new g();
        }
        this.D.a(this.X);
        this.D.a(stringBuffer.toString(), arrayList, this.h, z, this.i);
    }

    private void p() {
        switch (this.k) {
            case 1:
                com.baidu.tieba.util.k.f(this.i);
                break;
        }
        this.k = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void q(FrsActivity frsActivity) {
        frsActivity.r();
        try {
            if (frsActivity.D == null) {
                return;
            }
            frsActivity.r.w();
            frsActivity.i = frsActivity.D.f().getName();
            frsActivity.r.c(frsActivity.i);
            TbadkApplication.j().q(frsActivity.D.h().getBimg_url());
            frsActivity.r.c.s();
            frsActivity.p();
            frsActivity.g = false;
            ArrayList<com.baidu.tbadk.core.data.o> g = frsActivity.D.g();
            if (g != null) {
                cm cmVar = frsActivity.r;
                int i = frsActivity.l;
                cmVar.a(g, frsActivity.D);
                frsActivity.s();
                if (frsActivity.J.equals("frs_page")) {
                    frsActivity.r.a(frsActivity.D.f(), frsActivity.D);
                    frsActivity.H.removeMessages(1);
                    if (frsActivity.l == 1 && frsActivity.J.equals("frs_page") && frsActivity.D.k().f() == 0) {
                        frsActivity.I = System.nanoTime() / 1000000000;
                        if (frsActivity.D.k().g() > 0) {
                            frsActivity.H.sendMessageDelayed(frsActivity.H.obtainMessage(1), 1000L);
                        }
                    }
                } else if (frsActivity.J.equals("normal_page")) {
                    frsActivity.r.b(frsActivity.D.f(), frsActivity.D);
                }
                frsActivity.r.b(frsActivity.l);
                frsActivity.r.c(frsActivity.D.j().f());
                frsActivity.r.J();
                if (frsActivity.D.n() == 1) {
                    frsActivity.r.t().f(true);
                } else {
                    frsActivity.r.t().f(false);
                }
                if (frsActivity.h == 1) {
                    frsActivity.r.d(3);
                } else if (frsActivity.h != 2 || frsActivity.l == 1) {
                    frsActivity.r.d(0);
                } else {
                    frsActivity.r.d(3);
                }
                if (frsActivity.Z == null || frsActivity.ab == null) {
                    return;
                }
                frsActivity.Z.removeCallbacks(frsActivity.ab);
                frsActivity.Z.postDelayed(frsActivity.ab, 300L);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("FrsActivity", "", "FrsActivity.refreshFrs error = " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onPause() {
        super.onPause();
        this.r.L();
        if (this.H != null) {
            this.H.removeMessages(1);
        }
        this.d = d();
        this.d.c(this);
        if (this.au != null) {
            this.au.clear();
        }
        t();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onStop() {
        super.onStop();
        this.d = d();
        if (this.d != null) {
            this.d.j();
        }
    }

    @Override // com.baidu.tbadk.a, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.m) {
            if (i == 4) {
                if (this.r.n().isMenuShowing()) {
                    this.r.n().toggle(true);
                    if (this.r.m().f()) {
                        this.r.m().b(false);
                        n();
                        return true;
                    }
                    return true;
                } else if (this.r.c.n()) {
                    this.r.P();
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

    public final void a(com.baidu.tbadk.core.data.b bVar, int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(com.baidu.tieba.a.k.anti_title);
        builder.setIcon((Drawable) null);
        builder.setCancelable(true);
        builder.setMessage(String.valueOf(getString(com.baidu.tieba.a.k.confirm_download_app)) + bVar.c() + getString(com.baidu.tieba.a.k.question_mark));
        builder.setPositiveButton(com.baidu.tieba.a.k.alert_yes_button, new al(this, bVar, i));
        builder.setNegativeButton(com.baidu.tieba.a.k.alert_no_button, new am(this));
        this.P = builder.create();
        this.P.show();
    }

    public final void b(com.baidu.tbadk.core.data.b bVar, int i) {
        if (com.baidu.tbadk.core.util.UtilHelper.a()) {
            TiebaStatic.a(this, "frs_dl_app", "frs_recommend_app", 1, "app_name", bVar.e());
            new com.baidu.tbadk.core.util.ax("frs_recommend_app", "frs_dl", bVar.e()).start();
            b.a().a(bVar.e(), bVar.f(), bVar.c(), i);
            return;
        }
        showToast(com.baidu.tieba.a.k.neterror);
    }

    public final void a(com.baidu.tbadk.core.data.b bVar) {
        if (!com.baidu.tbadk.core.util.bc.c(bVar.f())) {
            b.a();
            com.baidu.tbadk.core.util.UtilHelper.b(this, b.a(bVar.f()));
        }
    }

    public final void i() {
        String E = TbadkApplication.E();
        if (E == null || E.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.a.k.login_to_use), true, 11021);
        } else if (!this.D.l()) {
            this.D.a(true);
            this.D.a(this.Y);
            this.D.b(String.valueOf(this.D.f().isLike()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        com.baidu.tbadk.browser.a.a(this, String.valueOf(com.baidu.tbadk.core.data.n.a) + "mo/q/fudaiindex?fid=" + this.D.f().getId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void j() {
        String E = TbadkApplication.E();
        if (E == null || E.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.a.k.login_to_use), true, 11002);
            return;
        }
        this.E.a("from_frs");
        this.E.a(this.D.f().getName(), this.D.f().getId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void k() {
        String E = TbadkApplication.E();
        if (E == null || E.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.a.k.login_to_use), true, 11014);
            return;
        }
        if (this.J.equals("normal_page")) {
            this.r.A();
        } else if (this.J.equals("frs_page")) {
            this.r.C();
        }
        this.G.a(this.D.f().getName(), this.D.f().getId());
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public final void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.r.m().e()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                if (TbadkApplication.j().l() != 1) {
                    TiebaStatic.a(this, "frs_night_mode", "frsclick", 1, new Object[0]);
                    com.baidu.tieba.r.c().c(1);
                    this.mSkinType = 1;
                    new com.baidu.tbadk.core.util.ax("eyeshield").start();
                } else {
                    return;
                }
            } else if (TbadkApplication.j().l() != 0) {
                com.baidu.tieba.r.c().c(0);
                this.mSkinType = 0;
            } else {
                return;
            }
            onChangeSkinType(this.mSkinType);
            com.baidu.tbadk.core.util.g.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e(FrsActivity frsActivity, int i) {
        ArrayList<com.baidu.tbadk.core.data.o> g = frsActivity.D.g();
        if (g != null) {
            Iterator<com.baidu.tbadk.core.data.o> it = g.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.core.data.o next = it.next();
                if (next == frsActivity.f) {
                    if (i == 1) {
                        PraiseData k = next.k();
                        AccountData N = TbadkApplication.N();
                        if (N != null) {
                            MetaData metaData = new MetaData();
                            metaData.setName_show(N.getAccount());
                            metaData.setPortrait(N.getPortrait());
                            metaData.setUserId(N.getID());
                            if (k == null) {
                                PraiseData praiseData = new PraiseData();
                                praiseData.setIsLike(i);
                                praiseData.setNum(1L);
                                praiseData.getUser().add(0, metaData);
                                next.a(praiseData);
                            } else {
                                next.k().getUser().add(0, metaData);
                                next.k().setNum(next.k().getNum() + 1);
                                next.k().setIsLike(i);
                            }
                        }
                    } else {
                        next.k().setIsLike(i);
                        next.k().setNum(next.k().getNum() - 1);
                        ArrayList<MetaData> user = next.k().getUser();
                        if (user != null) {
                            Iterator<MetaData> it2 = user.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                MetaData next2 = it2.next();
                                if (next2.getUserId().equals(TbadkApplication.N().getID())) {
                                    next.k().getUser().remove(next2);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            frsActivity.r.t().a(g, frsActivity.D);
            frsActivity.r.t().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void g(FrsActivity frsActivity, String str) {
        if (str != null) {
            if (TbadkApplication.j().m(str)) {
                frsActivity.sendMessage(new com.baidu.adp.framework.message.a(2003002, new com.baidu.tbadk.core.b.l(frsActivity).b(str, null, 0)));
                frsActivity.h();
                return;
            }
            if (frsActivity.r.n().isMenuShowing()) {
                frsActivity.r.n().toggle(true);
            }
            frsActivity.z = false;
            frsActivity.i = str;
            frsActivity.n();
        }
    }

    @Override // com.baidu.tbadk.core.voice.z
    public final VoiceManager d() {
        if (this.d == null) {
            this.d = VoiceManager.b();
        }
        return this.d;
    }

    @Override // com.baidu.tbadk.core.voice.z
    public final com.baidu.tbadk.core.voice.x a(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        this.d = d();
        this.d.f();
    }

    @Override // com.baidu.tbadk.core.view.w
    public final int b() {
        if (this.r == null) {
            return 0;
        }
        cm cmVar = this.r;
        return com.baidu.tieba.a.h.user_icon_box;
    }

    @Override // com.baidu.tbadk.core.view.w
    public final com.baidu.adp.lib.d.b<TbImageView> c() {
        return this.M;
    }

    @Override // com.baidu.tbadk.widget.j
    public final void a(com.baidu.tbadk.widget.k kVar) {
        if (kVar != null) {
            this.au.remove(kVar);
        }
    }

    public final void l() {
        while (this.au.size() > 0) {
            com.baidu.tbadk.widget.k remove = this.au.remove(0);
            if (remove != null) {
                remove.invalidate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(FrsActivity frsActivity, com.baidu.adp.framework.message.f fVar) {
        if (fVar != null) {
            if (!(fVar instanceof NewsNotifyMessage)) {
                com.baidu.adp.lib.util.f.b("transform error");
                return;
            }
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) fVar;
            int d = newsNotifyMessage.d();
            int b2 = newsNotifyMessage.b();
            int c = newsNotifyMessage.c();
            int i = newsNotifyMessage.i();
            if (frsActivity.K != null) {
                frsActivity.K.a(d);
                frsActivity.K.c(b2);
                frsActivity.K.b(c);
                frsActivity.K.d(i);
                frsActivity.r.a(frsActivity.K);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(FrsActivity frsActivity, com.baidu.adp.framework.message.f fVar) {
        List<com.baidu.tieba.download.a> a2;
        ay t;
        HashMap<Integer, com.baidu.tbadk.core.data.o> d;
        if (frsActivity.D == null || frsActivity.r == null || !(fVar instanceof DownloadMessage) || (a2 = ((DownloadMessage) fVar).a()) == null || (t = frsActivity.r.t()) == null || (d = t.d()) == null || d.size() <= 0) {
            return;
        }
        for (com.baidu.tieba.download.a aVar : a2) {
            if (aVar != null) {
                Iterator<Map.Entry<Integer, com.baidu.tbadk.core.data.o>> it = d.entrySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        Map.Entry<Integer, com.baidu.tbadk.core.data.o> next = it.next();
                        int intValue = next.getKey().intValue();
                        com.baidu.tbadk.core.data.o value = next.getValue();
                        if (value != null && (value instanceof com.baidu.tbadk.core.data.b) && ((com.baidu.tbadk.core.data.b) value).e().equals(aVar.a())) {
                            if (t.getItem(intValue) instanceof com.baidu.tbadk.core.data.b) {
                                com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) t.getItem(intValue);
                                int f = aVar.f();
                                if (f == 3 || f == 0) {
                                    bVar.a(2);
                                } else if (f == 2 || f == 4) {
                                    if (!com.baidu.tbadk.core.util.bc.c(aVar.n())) {
                                        frsActivity.showToast(aVar.n());
                                    }
                                    bVar.a(0);
                                } else if (f == 1) {
                                    bVar.a(1);
                                }
                            }
                        }
                    }
                }
            }
        }
        frsActivity.r.x();
    }

    private void s() {
        HashMap<Integer, com.baidu.tbadk.core.data.o> d;
        if ((this.r != null || this.r.t() != null) && (d = this.r.t().d()) != null) {
            ArrayList<com.baidu.tbadk.core.data.b> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, com.baidu.tbadk.core.data.o> entry : d.entrySet()) {
                com.baidu.tbadk.core.data.o value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.b)) {
                    arrayList.add((com.baidu.tbadk.core.data.b) value);
                }
            }
            b.a().a(arrayList);
        }
    }

    public final void a(int i, com.baidu.tbadk.core.data.o oVar, int i2) {
        String E = TbadkApplication.E();
        if (E == null || E.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.a.k.login_to_use), true, 0);
            return;
        }
        if (this.U != oVar && this.U != null) {
            t();
            this.r.e((String) null);
            this.S = new WriteImagesInfo();
            this.S.setMaxImagesAllowed(10);
            this.r.a(this.S, true);
            this.V.a((WriteData) null);
            this.V.a(false);
            this.r.c.r();
            com.baidu.tieba.util.m.a(oVar.m(), this);
        }
        this.U = oVar;
        this.r.a(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(FrsActivity frsActivity, Boolean bool) {
        if (com.baidu.tieba.d.a.a(frsActivity.D.f().getName(), bool)) {
            frsActivity.r.c.p();
        } else {
            frsActivity.r.c.o();
        }
    }

    private void a(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.S.parseJson(stringExtra);
                this.S.updateQuality();
                if (this.S.getChosedFiles() != null) {
                    this.r.a(this.S, z);
                }
            }
            if (this.S.getChosedFiles() != null && this.S.getChosedFiles().size() > 0) {
                this.r.c.b(23);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void j(FrsActivity frsActivity, String str) {
        com.baidu.tbadk.core.g.b(frsActivity, "frs_reply");
        if (frsActivity.V.a() == null) {
            WriteData writeData = new WriteData();
            writeData.setForumId(frsActivity.D.f().getId());
            writeData.setForumName(frsActivity.D.f().getName());
            writeData.setThreadId(frsActivity.U.m());
            writeData.setIsAd(false);
            writeData.setType(1);
            writeData.setWriteImagesInfo(frsActivity.S);
            frsActivity.V.a(frsActivity.S.size() > 0);
            frsActivity.V.a(writeData);
        }
        if (frsActivity.V.a() != null) {
            frsActivity.V.a().setContent(frsActivity.r.c.getContent());
            VoiceData.VoiceModel audioData = frsActivity.r.c.getAudioData();
            frsActivity.r.c.q();
            if (audioData == null) {
                frsActivity.V.a().setVoice(null);
                frsActivity.V.a().setVoiceDuringTime(-1);
            } else if (audioData.getId() != null) {
                frsActivity.V.a().setVoice(audioData.getId());
                frsActivity.V.a().setVoiceDuringTime(audioData.duration);
            } else {
                frsActivity.V.a().setVoice(null);
                frsActivity.V.a().setVoiceDuringTime(-1);
            }
            if (frsActivity.V.b()) {
                frsActivity.r.Q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(FrsActivity frsActivity, AntiData antiData, String str) {
        if (!AntiHelper.a(antiData) && !AntiHelper.b(antiData) && !AntiHelper.c(antiData) && !AntiHelper.d(antiData)) {
            com.baidu.adp.lib.util.i.a((Context) frsActivity, str);
            return;
        }
        antiData.setBlock_forum_name(frsActivity.U.u());
        antiData.setBlock_forum_id(frsActivity.D.f().getId());
        antiData.setUser_name(frsActivity.U.t().getUserName());
        antiData.setUser_id(frsActivity.U.t().getUserId());
        AntiHelper.a(frsActivity, antiData, AntiHelper.OperationType.REPLY, AntiHelper.PageType.PB);
    }

    @Override // com.baidu.tieba.util.n
    public final void a(WriteData writeData) {
        if (writeData != null && this.U != null && writeData.getThreadId().equals(this.U.m())) {
            if (!com.baidu.tbadk.core.util.bc.c(writeData.getContent()) && com.baidu.tbadk.core.util.bc.c(this.r.c.getContent())) {
                this.r.e(writeData.getContent());
            }
            if (writeData.getWriteImagesInfo() != null && this.S.size() == 0) {
                this.S.copyFrom(writeData.getWriteImagesInfo());
                this.r.a(this.S, true);
            }
        }
    }

    private void t() {
        if (this.U != null) {
            WriteData a2 = this.V.a();
            if (a2 == null) {
                a2 = new WriteData(1);
                a2.setThreadId(this.U.m());
                a2.setWriteImagesInfo(this.S);
            }
            a2.setContent(this.r.c.getContent());
            com.baidu.tieba.util.m.b(this.U.m(), a2);
        }
    }
}
