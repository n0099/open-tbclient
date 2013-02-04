package com.baidu.tieba.frs;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.as;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.home.CreateBarActivity;
import com.baidu.tieba.pb.PbActivity;
import com.baidu.tieba.write.WriteActivity;
import com.baidu.tieba.write.WriteImageActivity;
import com.baidu.tieba.write.ba;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class FrsActivity extends com.baidu.tieba.e {
    private static volatile long N = 0;
    private static volatile long O = 0;
    private static volatile int P = 0;
    private String c;
    private boolean d = true;
    private int e = 3;
    private String f = null;
    private String g = null;
    private int h = 0;
    private String i = null;
    private long j = 0;
    private int k = 0;
    private int l = 1;
    private boolean m = false;
    private String n = null;
    private boolean o = false;
    private Button p = null;
    private TextView q = null;
    private LinearLayout r = null;
    private Button s = null;
    private Button t = null;
    private Button u = null;
    private ListView v = null;
    private ab w = null;
    private aa x = null;
    private com.baidu.tieba.b.c y = null;
    private ProgressBar z = null;
    private TextView A = null;
    private LinearLayout B = null;
    private TextView C = null;
    private ImageView D = null;
    private Button E = null;
    private Menu F = null;
    private AlertDialog G = null;
    private String H = null;
    private String I = null;
    private as J = null;
    private com.baidu.tieba.view.l K = null;
    private Button L = null;
    private LinearLayout M = null;
    private z Q = null;
    private Handler R = null;
    private long S = 0;
    private AlertDialog T = null;
    private View U = null;
    private a V = null;
    private LinearLayout W = null;
    AlertDialog b = null;
    private Handler X = null;
    private com.baidu.tieba.c.a Y = null;
    private com.baidu.tieba.view.x Z = null;
    private Runnable aa = new c(this);
    private AdapterView.OnItemLongClickListener ab = new q(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        this.v.setVisibility(0);
        this.s.setVisibility(0);
        this.t.setVisibility(0);
        this.w.a(TiebaApplication.a().ab());
        try {
            if (this.y == null) {
                return;
            }
            this.f = this.y.a().c();
            x();
            y();
            z();
            ArrayList b = this.y.b();
            if (b != null) {
                this.w.a(b);
                D();
                if (this.K != null) {
                    this.K.a(this.f, this.y.a().b());
                    this.K.a(this.y.a().d(), this.y.a().h(), this.y.a().e());
                    this.K.a(this.y.a().f().b());
                    if (this.y.a().f().a() == -2) {
                        this.K.a(false);
                    }
                    if (this.y.a().a() == 0) {
                        this.K.d();
                    }
                }
                if (this.l > 1) {
                    this.w.d(true);
                } else {
                    this.w.d(false);
                }
                if (this.y.d().c() == 1) {
                    this.w.e(true);
                } else {
                    this.w.e(false);
                }
                this.w.b(false);
                this.w.c(false);
                this.w.notifyDataSetInvalidated();
                if (this.e != 1) {
                    this.v.setSelection(0);
                } else if (this.K != null) {
                    this.v.setSelection(2);
                } else {
                    this.v.setSelection(1);
                }
                this.A.setVisibility(8);
                a(false);
                C();
            }
            if ((b == null || b.size() <= 0) && this.k != 1) {
                this.A.setText(R.string.frs_nodata);
                this.A.setVisibility(0);
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "", "HomeActivity.refreshFrs error = " + e.getMessage());
        }
    }

    private void B() {
        if (this.x != null) {
            this.x.a();
            this.x = null;
        }
        a(false);
        this.w.b(false);
        this.w.c(false);
        this.w.notifyDataSetChanged();
    }

    private void C() {
        if (this.F == null) {
            return;
        }
        try {
            MenuItem findItem = this.F.findItem(0);
            MenuItem findItem2 = this.F.findItem(1);
            MenuItem findItem3 = this.F.findItem(2);
            MenuItem findItem4 = this.F.findItem(3);
            MenuItem findItem5 = this.F.findItem(4);
            if (findItem != null) {
                findItem.setVisible(true);
            }
            if (findItem2 != null) {
                findItem2.setVisible(true);
            }
            if (findItem3 != null) {
                findItem3.setVisible(true);
            }
            if (this.y == null) {
                if (findItem != null) {
                    findItem.setEnabled(false);
                }
                if (findItem3 != null) {
                    findItem3.setEnabled(false);
                }
                if (findItem5 != null) {
                    findItem5.setEnabled(false);
                }
                if (findItem4 != null) {
                    findItem4.setEnabled(false);
                }
            } else {
                if (findItem != null) {
                    findItem.setEnabled(true);
                }
                if (findItem3 != null) {
                    findItem3.setEnabled(true);
                }
                if (findItem5 != null) {
                    findItem5.setEnabled(true);
                }
                if (findItem4 != null) {
                    findItem4.setEnabled(true);
                }
            }
            if (this.y == null || this.y.a().d() != 1) {
                if (findItem5 != null) {
                    findItem5.setVisible(false);
                }
                if (findItem4 != null) {
                    findItem4.setVisible(true);
                    return;
                }
                return;
            }
            if (findItem5 != null) {
                findItem5.setVisible(true);
            }
            if (findItem4 != null) {
                findItem4.setVisible(false);
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b("FrsActivity", "onPrepareOptionsMenu", "exp: " + e.toString());
        }
    }

    private void D() {
        this.w.a(this.y.e(), this.y.a().c());
        this.R.removeMessages(1);
        if (this.l != 1 || this.y.e().a() != 1) {
            this.w.f(false);
            return;
        }
        this.w.f(true);
        if (this.y.e().h() == 0) {
            this.S = System.nanoTime() / 1000000000;
            this.R.sendMessageDelayed(this.R.obtainMessage(1), 1000L);
        }
    }

    public static Intent a(Context context, String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        Intent intent = new Intent(context, FrsActivity.class);
        intent.putExtra("name", str);
        return intent;
    }

    private void a(float f) {
        if (TiebaApplication.a().ac() != 0.0f) {
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = f;
        getWindow().setAttributes(attributes);
    }

    public static void a(Context context, String str, String str2) {
        if (TiebaApplication.a().b(str)) {
            FrsImageActivity.a(context, str, str2, 0);
        } else {
            a(context, str, str2, false);
        }
    }

    public static void a(Context context, String str, String str2, int i) {
        if (TiebaApplication.a().b(str)) {
            FrsImageActivity.a(context, str, str2, i);
            return;
        }
        Intent intent = new Intent(context, FrsActivity.class);
        if (str == null || str.length() <= 0) {
            return;
        }
        intent.putExtra("name", str);
        intent.putExtra("from", str2);
        intent.putExtra("flag", i);
        context.startActivity(intent);
    }

    public static void a(Context context, String str, String str2, boolean z) {
        Intent intent = new Intent(context, FrsActivity.class);
        if (str == null || str.length() <= 0) {
            return;
        }
        intent.putExtra("name", str);
        intent.putExtra("from", str2);
        intent.putExtra("back_special", z);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return;
        }
        if (this.Z == null) {
            View findViewById = findViewById(R.id.frs);
            this.Z = new com.baidu.tieba.view.x(this, findViewById.getWidth(), findViewById.getHeight());
            this.Z.setOnDismissListener(new l(this));
            this.Z.setOnCancelListener(new m(this));
        }
        if (this.Z.isShowing()) {
            this.Z.a(bitmap);
        } else {
            this.Z.a(bitmap, z);
        }
        a(0.3f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.o = z;
        if (z) {
            this.z.setVisibility(0);
        } else {
            this.z.setVisibility(8);
        }
    }

    private boolean a(as asVar) {
        String a;
        return asVar == null || asVar.h() == null || (a = asVar.h().a()) == null || a.equals("0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        String u = TiebaApplication.u();
        if (u != null && u.length() > 0) {
            if (this.y != null) {
                if (i == 0) {
                    WriteActivity.a(this, this.y.a().b(), this.f, this.y.c(), false, null);
                    return;
                } else {
                    this.G.show();
                    return;
                }
            }
            return;
        }
        if (this.y != null && this.y.c() != null) {
            this.y.c().a(1);
        }
        if (i == 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100001);
        } else {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100016);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(as asVar) {
        boolean a = a(asVar);
        n nVar = new n(this, asVar);
        String string = getString(R.string.view);
        String string2 = getString(R.string.view_host);
        String string3 = getString(R.string.view_reverse);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.operation);
        if (a) {
            builder.setItems(new String[]{string, string3}, nVar);
        } else {
            builder.setItems(new String[]{string, string2, string3}, nVar);
        }
        this.b = builder.create();
        this.b.setCanceledOnTouchOutside(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(as asVar) {
        boolean a = a(asVar);
        if (this.n != null) {
            if (a) {
                PbActivity.a(this, this.n, false, false, "tb_frslist", false);
            } else {
                PbActivity.a(this, this.n, true, true, "tb_frslist", false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        Intent a;
        if (str == null || (a = a((Context) this, str)) == null) {
            return;
        }
        a.setAction("android.intent.action.MAIN");
        a.putExtra("from_short_cut", true);
        a.putExtra("back_special", true);
        Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent.putExtra("duplicate", false);
        intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + getString(R.string.bar));
        intent.putExtra("android.intent.extra.shortcut.INTENT", a);
        intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this, R.drawable.icon));
        sendBroadcast(intent);
        new com.baidu.tieba.account.ak("add_to_launcher").start();
    }

    private void l() {
        this.Y = new com.baidu.tieba.c.a(this);
        this.Y.b(true);
        int a = com.baidu.tieba.c.ag.a((Context) this, 234.0f);
        int i = a <= 350 ? a : 350;
        this.Y.a(i, (int) (i * 1.62f));
    }

    private boolean m() {
        if (getIntent().getBooleanExtra("from_short_cut", false)) {
            Iterator<ActivityManager.RunningTaskInfo> it = ((ActivityManager) getSystemService("activity")).getRunningTasks(10).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningTaskInfo next = it.next();
                if (next.topActivity.getClassName().equals(getClass().getName())) {
                    if (next.numActivities <= 1) {
                        MainTabActivity.a(this, "goto_more", 2, getIntent().getStringExtra("name"), null);
                        finish();
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void n() {
        this.c = getText(R.string.forum).toString();
        this.d = true;
        this.f = "";
        this.g = "";
        this.h = 0;
        this.k = 0;
        this.j = 0L;
        this.i = "";
        this.l = 1;
        this.e = 3;
        this.q = (TextView) findViewById(R.id.frs_tv_title);
        this.D = (ImageView) findViewById(R.id.frs_tv_title_good);
        this.p = (Button) findViewById(R.id.frs_bt_back);
        this.p.setOnClickListener(new s(this));
        this.s = (Button) findViewById(R.id.frs_bt_post);
        this.s.setOnClickListener(new t(this));
        this.t = (Button) findViewById(R.id.frs_bt_refresh);
        this.t.setOnClickListener(new u(this));
        this.u = (Button) findViewById(R.id.frs_bt_camera);
        this.u.setOnClickListener(new v(this));
        String[] strArr = {getString(R.string.take_photo), getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setItems(strArr, new w(this));
        if (this.G == null) {
            this.G = builder.create();
            this.G.setCanceledOnTouchOutside(true);
        }
        this.v = (ListView) findViewById(R.id.frs_lv_thread);
        this.K = new com.baidu.tieba.view.l(this, com.baidu.tieba.view.o.FRS_LIST, null, null);
        this.v.addHeaderView(this.K.c());
        this.w = new ab(this, null, com.baidu.tieba.c.ag.a((Context) this));
        this.w.a(new x(this));
        this.v.setAdapter((ListAdapter) this.w);
        this.v.setOnItemClickListener(new f(this));
        this.v.setOnItemLongClickListener(this.ab);
        this.z = (ProgressBar) findViewById(R.id.frs_progress);
        a(false);
        this.A = (TextView) findViewById(R.id.frs_noexist);
        this.A.setVisibility(8);
        this.C = (TextView) findViewById(R.id.frs_noexist_text);
        this.W = (LinearLayout) findViewById(R.id.frs_title);
        this.r = (LinearLayout) findViewById(R.id.frs_ll_bt_good);
        this.r.setOnClickListener(new h(this));
        this.B = (LinearLayout) findViewById(R.id.frs_noexist_layout);
        this.E = (Button) findViewById(R.id.frs_bt_create);
        this.E.setOnClickListener(new i(this));
        this.v.setOnScrollListener(new j(this));
        this.L = (Button) findViewById(R.id.go_home);
        this.L.setOnClickListener(new k(this));
        this.M = (LinearLayout) findViewById(R.id.frs_bottom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.Z == null) {
            return;
        }
        this.Z.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.Y != null) {
            this.Y.b();
        }
        a(1.0f);
        if (this.Z != null) {
            this.Z.a(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        String u = TiebaApplication.u();
        if (u == null || u.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100013);
            return;
        }
        CreateBarActivity.a(this, this.f, true);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.n != null) {
            PbActivity.a(this, this.n, false, false, "tb_frslist", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.T == null) {
            this.T = new AlertDialog.Builder(this).create();
            this.T.setCanceledOnTouchOutside(true);
            this.U = getLayoutInflater().inflate(R.layout.dialog_good, (ViewGroup) null);
            ListView listView = (ListView) this.U.findViewById(R.id.frs_dia_list);
            this.V = new a(this, null);
            TextView textView = new TextView(this);
            textView.setText(getString(R.string.add_to_screen));
            textView.setTextColor(-1);
            textView.setTextSize(2, 18.0f);
            textView.setGravity(17);
            textView.setOnClickListener(new o(this));
            listView.addHeaderView(textView);
            listView.setAdapter((ListAdapter) this.V);
            listView.setOnItemClickListener(new p(this));
        }
        if (this.V == null || this.y == null || this.y.a() == null) {
            return;
        }
        this.V.a(this.y.a().g());
        this.V.notifyDataSetInvalidated();
        this.T.show();
        this.T.setContentView(this.U);
        WindowManager.LayoutParams attributes = this.T.getWindow().getAttributes();
        attributes.gravity = 49;
        attributes.y = (this.W.getTop() + this.W.getHeight()) - 5;
        attributes.alpha = 1.0f;
        attributes.width = com.baidu.tieba.c.ag.a((Context) this, 160.0f);
        attributes.height = -2;
        this.T.getWindow().setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        this.k = 0;
        this.j = 0L;
        this.i = "";
        this.l = 1;
        this.e = 3;
        v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        switch (this.e) {
            case 1:
                if (this.w.c()) {
                    return;
                }
                break;
            case 2:
                if (this.w.d()) {
                    return;
                }
                break;
            case 3:
                if (u()) {
                    return;
                }
                break;
        }
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append("http://c.tieba.baidu.com/");
        stringBuffer.append("c/f/frs/page");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("kw", this.f));
        arrayList.add(new BasicNameValuePair("pn", String.valueOf(this.l)));
        arrayList.add(TiebaApplication.a().ab() ? new BasicNameValuePair("rn", String.valueOf(35)) : new BasicNameValuePair("rn", String.valueOf(50)));
        if (this.k == 1) {
            arrayList.add(new BasicNameValuePair("is_good", "1"));
            arrayList.add(new BasicNameValuePair("cid", String.valueOf(this.j)));
        }
        if (this.H != null) {
            arrayList.add(new BasicNameValuePair("st_type", this.H));
        }
        B();
        this.x = new aa(this, stringBuffer.toString(), arrayList, this.e);
        this.x.execute(stringBuffer.toString(), arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (this.d) {
            this.r.setVisibility(4);
        } else {
            this.r.setClickable(false);
        }
    }

    private void x() {
        if (this.k == 0) {
            this.q.setText(this.f.concat(this.c));
        } else {
            this.q.setText(this.i);
        }
        if (this.d) {
            this.r.setVisibility(0);
        } else {
            this.r.setClickable(true);
        }
    }

    private void y() {
        switch (this.h) {
            case 1:
                com.baidu.tieba.c.k.j(this.f);
                break;
        }
        this.h = 0;
    }

    private void z() {
        this.d = false;
    }

    public void g() {
        if (getIntent().getBooleanExtra("back_special", false)) {
            MainTabActivity.a(this, "goto_recommend");
        } else {
            finish();
        }
    }

    public void h() {
        String u = TiebaApplication.u();
        if (u == null || u.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100021);
        } else if (this.y.f()) {
        } else {
            this.y.a(true);
            if (this.Q != null) {
                this.Q.a();
                this.Q = null;
            }
            com.baidu.tieba.a.p a = this.y.a();
            this.Q = new z(this, a.b(), a.c(), String.valueOf(a.d()));
            this.Q.execute("http://c.tieba.baidu.com/c/c/user/fansno");
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            if (i2 == 0) {
                switch (i) {
                    case 1200008:
                        ba.b(this);
                        return;
                    case 12000010:
                        ba.a(this);
                        return;
                    default:
                        return;
                }
            }
            return;
        }
        switch (i) {
            case 1100001:
                b(0);
                return;
            case 1100002:
                if (this.K != null) {
                    this.K.a();
                    return;
                }
                return;
            case 1100011:
                c(this.J);
                return;
            case 1100012:
                r();
                return;
            case 1100013:
                q();
                return;
            case 1100014:
                if (this.K != null) {
                    this.K.b();
                    return;
                }
                return;
            case 1100016:
                this.G.show();
                return;
            case 1100021:
                if (this.y != null) {
                    h();
                    return;
                }
                return;
            case 1200001:
                if (this.y == null || this.y.a() == null) {
                    return;
                }
                WriteImageActivity.a(this, 1200001, 12000010, null, this.y.a().b(), this.f, this.y.c());
                return;
            case 1200002:
                if (this.y == null || this.y.a() == null) {
                    return;
                }
                if (intent == null || intent.getData() == null) {
                    ba.b(this);
                    return;
                } else {
                    WriteImageActivity.a(this, 1200002, 1200008, intent.getData(), this.y.a().b(), this.f, this.y.c());
                    return;
                }
            case 1300003:
            case 1300004:
                t();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (m()) {
            setContentView(R.layout.frs_activity);
            this.X = new Handler();
            l();
            n();
            this.I = TiebaApplication.u();
            if (bundle != null) {
                this.f = bundle.getString("name");
                this.g = bundle.getString("from");
                this.h = bundle.getInt("flag", 0);
            } else {
                Intent intent = getIntent();
                this.f = intent.getStringExtra("name");
                this.g = intent.getStringExtra("from");
                this.h = intent.getIntExtra("flag", 0);
            }
            if (this.f == null || this.f.length() <= 0) {
                return;
            }
            if (this.g == null || this.g.length() <= 0) {
                this.g = "tb_forumlist";
            }
            this.H = this.g;
            this.R = new r(this);
            t();
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        this.F = menu;
        menu.add(0, 0, 1, getString(R.string.write_msg)).setIcon(R.drawable.menu_post);
        menu.add(0, 1, 2, getString(R.string.refresh)).setIcon(R.drawable.menu_refresh);
        menu.add(0, 2, 3, getString(R.string.view_good)).setIcon(R.drawable.menu_view_good);
        menu.add(0, 3, 4, getString(R.string.like_forum_menu)).setIcon(R.drawable.menu_unlike);
        menu.add(0, 4, 4, getString(R.string.unlike)).setIcon(R.drawable.menu_unlike);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        if (this.X != null) {
            this.X.removeCallbacks(this.aa);
        }
        if (this.K != null) {
            this.K.e();
        }
        if (this.R != null) {
            this.R.removeMessages(1);
        }
        super.onDestroy();
        try {
            if (this.x != null) {
                this.x.a();
                this.x = null;
            }
            if (this.Q != null) {
                this.Q.a();
                this.Q = null;
            }
            if (this.w != null) {
                this.w.f();
            }
            if (this.z != null) {
                this.z.setVisibility(8);
            }
            System.gc();
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "onDestroy", e.getMessage());
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.m) {
            if (i == 4) {
                g();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 0:
                b(0);
                break;
            case 1:
                if (this.f != null && this.f.length() > 0) {
                    t();
                    break;
                }
                break;
            case 2:
                if (!u()) {
                    s();
                    break;
                }
                break;
            case 4:
                showDialog(1);
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        super.onPause();
        this.w.a().b();
        this.w.b().b();
        if (this.Z != null) {
            this.Z.dismiss();
        }
        if (this.R != null) {
            this.R.removeMessages(1);
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        C();
        return super.onPrepareOptionsMenu(menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        String u = TiebaApplication.u();
        if (this.I == null && u != null && u.length() > 0) {
            this.I = u;
            if (this.y != null && this.y.c() != null) {
                this.y.c().a(1);
            }
        }
        this.aa.run();
        if (this.R != null) {
            this.R.removeMessages(1);
            this.R.sendMessageDelayed(this.R.obtainMessage(1), 1000L);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.f);
        bundle.putString("from", this.g);
    }
}
