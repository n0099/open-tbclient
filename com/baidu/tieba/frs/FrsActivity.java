package com.baidu.tieba.frs;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.av;
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
    private static volatile long O = 0;
    private static volatile long P = 0;
    private static volatile int Q = 0;
    private String d;
    private boolean e = true;
    private int f = 3;
    private String g = null;
    private String h = null;
    private int i = 0;
    private String j = null;
    private long k = 0;
    private int l = 0;
    private int m = 1;
    private boolean n = false;
    private String o = null;
    private boolean p = false;
    private Button q = null;
    private TextView r = null;
    private LinearLayout s = null;
    private Button t = null;
    private Button u = null;
    private Button v = null;
    private ListView w = null;
    private aa x = null;
    private z y = null;
    private com.baidu.tieba.b.c z = null;
    private ProgressBar A = null;
    private TextView B = null;
    private LinearLayout C = null;
    private TextView D = null;
    private ImageView E = null;
    private Button F = null;
    private Menu G = null;
    private AlertDialog H = null;
    private String I = null;
    private String J = null;
    private av K = null;
    private com.baidu.tieba.view.l L = null;
    private LinearLayout M = null;
    private RelativeLayout N = null;
    private y R = null;
    private Handler S = null;
    private long T = 0;
    private AlertDialog U = null;
    private View V = null;
    private a W = null;
    private LinearLayout X = null;
    AlertDialog c = null;
    private Handler Y = null;
    private com.baidu.tieba.c.a Z = null;
    private com.baidu.tieba.view.x aa = null;
    private Runnable ab = new c(this);
    private AdapterView.OnItemLongClickListener ac = new p(this);

    public static void a(Context context, String str, String str2) {
        if (TiebaApplication.b().b(str)) {
            FrsImageActivity.a(context, str, str2, 0);
        } else {
            a(context, str, str2, false);
        }
    }

    public static void a(Context context, String str, String str2, boolean z) {
        Intent intent = new Intent(context, FrsActivity.class);
        if (str != null && str.length() > 0) {
            intent.putExtra("name", str);
            intent.putExtra("from", str2);
            intent.putExtra("back_special", z);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    public static void a(Context context, String str, String str2, int i) {
        if (TiebaApplication.b().b(str)) {
            FrsImageActivity.a(context, str, str2, i);
            return;
        }
        Intent intent = new Intent(context, FrsActivity.class);
        if (str != null && str.length() > 0) {
            intent.putExtra("name", str);
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

    private void m() {
        this.Z = new com.baidu.tieba.c.a(this);
        this.Z.b(true);
        int a = com.baidu.tieba.c.ah.a(this, 234.0f);
        int i = a <= 350 ? a : 350;
        this.Z.a(i, (int) (i * 1.62f));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (n()) {
            setContentView(R.layout.frs_activity);
            this.Y = new Handler();
            m();
            o();
            this.J = TiebaApplication.w();
            if (bundle != null) {
                this.g = bundle.getString("name");
                this.h = bundle.getString("from");
                this.i = bundle.getInt("flag", 0);
            } else {
                Intent intent = getIntent();
                this.g = intent.getStringExtra("name");
                this.h = intent.getStringExtra("from");
                this.i = intent.getIntExtra("flag", 0);
            }
            if (this.g != null && this.g.length() > 0) {
                if (this.h == null || this.h.length() <= 0) {
                    this.h = "tb_forumlist";
                }
                this.I = this.h;
                this.S = new q(this);
                u();
            }
        }
    }

    private boolean n() {
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
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        if (this.Y != null) {
            this.Y.removeCallbacks(this.ab);
        }
        if (this.L != null) {
            this.L.e();
        }
        if (this.S != null) {
            this.S.removeMessages(1);
        }
        super.onDestroy();
        try {
            if (this.y != null) {
                this.y.a();
                this.y = null;
            }
            if (this.R != null) {
                this.R.a();
                this.R = null;
            }
            if (this.x != null) {
                this.x.f();
            }
            if (this.A != null) {
                this.A.setVisibility(8);
            }
            System.gc();
        } catch (Exception e) {
            com.baidu.tieba.c.af.b(getClass().getName(), "onDestroy", e.getMessage());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.g);
        bundle.putString("from", this.h);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1100001:
                    d(0);
                    return;
                case 1100002:
                    if (this.L != null) {
                        this.L.a();
                        return;
                    }
                    return;
                case 1100011:
                    c(this.K);
                    return;
                case 1100012:
                    s();
                    return;
                case 1100013:
                    r();
                    return;
                case 1100014:
                    if (this.L != null) {
                        this.L.b();
                        return;
                    }
                    return;
                case 1100016:
                    this.H.show();
                    return;
                case 1100021:
                    if (this.z != null) {
                        i();
                        return;
                    }
                    return;
                case 1200001:
                    if (this.z != null && this.z.a() != null) {
                        WriteImageActivity.a(this, 1200001, 12000010, null, this.z.a().b(), this.g, this.z.c());
                        return;
                    }
                    return;
                case 1200002:
                    if (this.z != null && this.z.a() != null) {
                        if (intent != null && intent.getData() != null) {
                            WriteImageActivity.a(this, 1200002, 1200008, intent.getData(), this.z.a().b(), this.g, this.z.c());
                            return;
                        } else {
                            ba.b(this);
                            return;
                        }
                    }
                    return;
                case 1200008:
                case 12000010:
                    if (this.z != null && this.z.a() != null) {
                        if (intent == null || intent.getStringExtra("filename") == null) {
                            WriteActivity.a(this, this.z.a().b(), this.g, null, true, null);
                            return;
                        } else {
                            WriteActivity.a(this, this.z.a().b(), this.g, null, true, intent.getStringExtra("filename"));
                            return;
                        }
                    }
                    return;
                case 1300003:
                case 1300004:
                    u();
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
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
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        String w = TiebaApplication.w();
        if (this.J == null && w != null && w.length() > 0) {
            this.J = w;
            if (this.z != null && this.z.c() != null) {
                this.z.c().a(1);
            }
        }
        this.ab.run();
        if (this.S != null) {
            this.S.removeMessages(1);
            this.S.sendMessageDelayed(this.S.obtainMessage(1), 1000L);
        }
    }

    @Override // com.baidu.tieba.e
    public void a() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
            return;
        }
        String w = TiebaApplication.w();
        if ((w != null && w.length() > 0) || TiebaApplication.b().ag() >= 3) {
            MainTabActivity.a(this, "goto_home");
        } else {
            MainTabActivity.a(this, "goto_recommend");
        }
    }

    private void o() {
        this.N = (RelativeLayout) findViewById(R.id.frs);
        this.d = getText(R.string.forum).toString();
        this.e = true;
        this.g = "";
        this.h = "";
        this.i = 0;
        this.l = 0;
        this.k = 0L;
        this.j = "";
        this.m = 1;
        this.f = 3;
        this.r = (TextView) findViewById(R.id.frs_tv_title);
        this.E = (ImageView) findViewById(R.id.frs_tv_title_good);
        this.q = (Button) findViewById(R.id.frs_bt_back);
        this.q.setOnClickListener(new r(this));
        this.t = (Button) findViewById(R.id.frs_bt_post);
        this.t.setOnClickListener(new s(this));
        this.u = (Button) findViewById(R.id.frs_bt_refresh);
        this.u.setOnClickListener(new t(this));
        this.v = (Button) findViewById(R.id.frs_bt_camera);
        this.v.setOnClickListener(new u(this));
        String[] strArr = {getString(R.string.take_photo), getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setItems(strArr, new v(this));
        if (this.H == null) {
            this.H = builder.create();
            this.H.setCanceledOnTouchOutside(true);
        }
        this.w = (ListView) findViewById(R.id.frs_lv_thread);
        this.L = new com.baidu.tieba.view.l(this, com.baidu.tieba.view.o.FRS_LIST, null, null);
        this.w.addHeaderView(this.L.c());
        this.x = new aa(this, null, com.baidu.tieba.c.ah.a((Context) this));
        this.x.a(new w(this));
        this.w.setAdapter((ListAdapter) this.x);
        this.w.setOnItemClickListener(new f(this));
        this.w.setOnItemLongClickListener(this.ac);
        this.A = (ProgressBar) findViewById(R.id.frs_progress);
        a(false);
        this.B = (TextView) findViewById(R.id.frs_noexist);
        this.B.setVisibility(8);
        this.D = (TextView) findViewById(R.id.frs_noexist_text);
        this.X = (LinearLayout) findViewById(R.id.frs_title);
        this.s = (LinearLayout) findViewById(R.id.frs_ll_bt_good);
        this.s.setOnClickListener(new h(this));
        this.C = (LinearLayout) findViewById(R.id.frs_noexist_layout);
        this.F = (Button) findViewById(R.id.frs_bt_create);
        this.F.setOnClickListener(new i(this));
        this.w.setOnScrollListener(new j(this));
        this.M = (LinearLayout) findViewById(R.id.frs_bottom);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        com.baidu.tieba.c.ad.a(this.N, i);
        com.baidu.tieba.c.ad.c(this.r, i);
        com.baidu.tieba.c.ad.c((TextView) this.q, i);
        com.baidu.tieba.c.ad.e((TextView) this.q, i);
        com.baidu.tieba.c.ad.c(this.X, i);
        com.baidu.tieba.c.ad.b(this.B, i);
        com.baidu.tieba.c.ad.b(this.w, i);
        this.L.a(i);
        if (i == 1) {
            this.M.setBackgroundResource(R.drawable.maintab_toolbar_bg_1);
            this.u.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.frs_pb_bottom_btn_refresh_1), (Drawable) null, (Drawable) null);
            this.v.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.frs_bottom_camera_1), (Drawable) null, (Drawable) null);
            this.t.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.frs_bottom_write_1), (Drawable) null, (Drawable) null);
            this.u.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color_1));
            this.v.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color_1));
            this.t.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color_1));
            return;
        }
        this.M.setBackgroundResource(R.drawable.maintab_toolbar_bg);
        this.u.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.frs_pb_bottom_btn_refresh), (Drawable) null, (Drawable) null);
        this.v.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.frs_bottom_camera), (Drawable) null, (Drawable) null);
        this.t.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.frs_bottom_write), (Drawable) null, (Drawable) null);
        this.u.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color));
        this.v.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color));
        this.t.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.aa != null) {
            this.aa.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, boolean z) {
        if (bitmap != null) {
            if (this.aa == null) {
                this.aa = new com.baidu.tieba.view.x(this, this.N.getWidth(), this.N.getHeight());
                this.aa.setOnDismissListener(new k(this));
                this.aa.setOnCancelListener(new l(this));
            }
            if (this.aa.isShowing()) {
                this.aa.a(bitmap);
            } else {
                this.aa.a(bitmap, z);
            }
            a(0.3f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.Z != null) {
            this.Z.b();
        }
        a(1.0f);
        if (this.aa != null) {
            this.aa.a(null);
        }
    }

    private void a(float f) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = f;
        getWindow().setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        String w = TiebaApplication.w();
        if (w == null || w.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100013);
            return;
        }
        CreateBarActivity.a(this, this.g, true);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        String w = TiebaApplication.w();
        if (w == null || w.length() <= 0) {
            if (this.z != null && this.z.c() != null) {
                this.z.c().a(1);
            }
            if (i == 0) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100001);
            } else {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100016);
            }
        } else if (this.z != null) {
            if (i == 0) {
                WriteActivity.a(this, this.z.a().b(), this.g, this.z.c(), false, null);
            } else {
                this.H.show();
            }
        }
    }

    private boolean a(av avVar) {
        String a;
        return avVar == null || avVar.h() == null || (a = avVar.h().a()) == null || a.equals("0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(av avVar) {
        boolean a = a(avVar);
        m mVar = new m(this, avVar);
        String string = getString(R.string.view);
        String string2 = getString(R.string.view_host);
        String string3 = getString(R.string.view_reverse);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.operation);
        if (a) {
            builder.setItems(new String[]{string, string3}, mVar);
        } else {
            builder.setItems(new String[]{string, string2, string3}, mVar);
        }
        this.c = builder.create();
        this.c.setCanceledOnTouchOutside(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(av avVar) {
        boolean a = a(avVar);
        if (this.o != null) {
            if (!a) {
                PbActivity.a(this, this.o, true, true, "tb_frslist", false);
            } else {
                PbActivity.a(this, this.o, false, false, "tb_frslist", false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.o != null) {
            PbActivity.a(this, this.o, false, false, "tb_frslist", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.U == null) {
            this.U = new AlertDialog.Builder(this).create();
            this.U.setCanceledOnTouchOutside(true);
            this.V = getLayoutInflater().inflate(R.layout.dialog_good, (ViewGroup) null);
            ListView listView = (ListView) this.V.findViewById(R.id.frs_dia_list);
            this.W = new a(this, null);
            this.W.a(this.b);
            TextView textView = new TextView(this);
            textView.setText(getString(R.string.add_to_screen));
            if (this.b == 1) {
                textView.setTextColor(getResources().getColor(R.color.skin_1_common_color));
            } else {
                textView.setTextColor(-1);
            }
            textView.setTextSize(2, 18.0f);
            textView.setGravity(17);
            textView.setOnClickListener(new n(this));
            listView.addHeaderView(textView);
            listView.setAdapter((ListAdapter) this.W);
            listView.setOnItemClickListener(new o(this));
        }
        if (this.W != null && this.z != null && this.z.a() != null) {
            this.W.a(this.z.a().g());
            this.W.notifyDataSetInvalidated();
            this.U.show();
            this.U.setContentView(this.V);
            WindowManager.LayoutParams attributes = this.U.getWindow().getAttributes();
            attributes.gravity = 49;
            attributes.y = (this.X.getTop() + this.X.getHeight()) - 5;
            attributes.alpha = 1.0f;
            attributes.width = com.baidu.tieba.c.ah.a(this, 160.0f);
            attributes.height = -2;
            this.U.getWindow().setAttributes(attributes);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        this.l = 0;
        this.k = 0L;
        this.j = "";
        this.m = 1;
        this.f = 3;
        w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.p = z;
        if (z) {
            this.A.setVisibility(0);
        } else {
            this.A.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        BasicNameValuePair basicNameValuePair;
        switch (this.f) {
            case 1:
                if (this.x.c()) {
                    return;
                }
                break;
            case 2:
                if (this.x.d()) {
                    return;
                }
                break;
            case 3:
                if (v()) {
                    return;
                }
                break;
        }
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append("http://c.tieba.baidu.com/");
        stringBuffer.append("c/f/frs/page");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("kw", this.g));
        arrayList.add(new BasicNameValuePair("pn", String.valueOf(this.m)));
        if (TiebaApplication.b().ae()) {
            basicNameValuePair = new BasicNameValuePair("rn", String.valueOf(35));
        } else {
            basicNameValuePair = new BasicNameValuePair("rn", String.valueOf(50));
        }
        arrayList.add(basicNameValuePair);
        if (this.l == 1) {
            arrayList.add(new BasicNameValuePair("is_good", "1"));
            arrayList.add(new BasicNameValuePair("cid", String.valueOf(this.k)));
        }
        if (this.I != null) {
            arrayList.add(new BasicNameValuePair("st_type", this.I));
        }
        C();
        this.y = new z(this, stringBuffer.toString(), arrayList, this.f);
        this.y.execute(stringBuffer.toString(), arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (this.e) {
            this.s.setVisibility(4);
        } else {
            this.s.setClickable(false);
        }
    }

    private void y() {
        if (this.l == 0) {
            this.r.setText(this.g.concat(this.d));
        } else {
            this.r.setText(this.j);
        }
        if (this.e) {
            this.s.setVisibility(0);
        } else {
            this.s.setClickable(true);
        }
    }

    private void z() {
        switch (this.i) {
            case 1:
                com.baidu.tieba.c.k.j(this.g);
                break;
        }
        this.i = 0;
    }

    private void A() {
        this.e = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        this.w.setVisibility(0);
        this.t.setVisibility(0);
        this.u.setVisibility(0);
        this.x.a(TiebaApplication.b().ae());
        try {
            if (this.z != null) {
                this.g = this.z.a().c();
                y();
                z();
                A();
                ArrayList b = this.z.b();
                if (b != null) {
                    this.x.a(b);
                    E();
                    if (this.L != null) {
                        this.L.a(this.g, this.z.a().b());
                        this.L.a(this.z.a().d(), this.z.a().h(), this.z.a().e());
                        this.L.b(this.z.a().f().b());
                        if (this.z.a().f().a() == -2) {
                            this.L.a(false);
                        }
                        if (this.z.a().a() == 0) {
                            this.L.d();
                        }
                    }
                    if (this.m > 1) {
                        this.x.d(true);
                    } else {
                        this.x.d(false);
                    }
                    if (this.z.d().c() == 1) {
                        this.x.e(true);
                    } else {
                        this.x.e(false);
                    }
                    this.x.b(false);
                    this.x.c(false);
                    this.x.notifyDataSetInvalidated();
                    if (this.f == 1) {
                        if (this.L != null) {
                            this.w.setSelection(2);
                        } else {
                            this.w.setSelection(1);
                        }
                    } else {
                        this.w.setSelection(0);
                    }
                    this.B.setVisibility(8);
                    a(false);
                    D();
                }
                if ((b == null || b.size() <= 0) && this.l != 1) {
                    this.B.setText(R.string.frs_nodata);
                    this.B.setVisibility(0);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.af.b(getClass().getName(), "", "HomeActivity.refreshFrs error = " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        super.onPause();
        this.x.a().b();
        this.x.b().b();
        if (this.aa != null) {
            this.aa.dismiss();
        }
        if (this.S != null) {
            this.S.removeMessages(1);
        }
    }

    private void C() {
        if (this.y != null) {
            this.y.a();
            this.y = null;
        }
        a(false);
        this.x.b(false);
        this.x.c(false);
        this.x.notifyDataSetChanged();
    }

    private void D() {
        if (this.G != null) {
            try {
                MenuItem findItem = this.G.findItem(0);
                MenuItem findItem2 = this.G.findItem(1);
                MenuItem findItem3 = this.G.findItem(2);
                MenuItem findItem4 = this.G.findItem(3);
                MenuItem findItem5 = this.G.findItem(4);
                if (findItem != null) {
                    findItem.setVisible(true);
                }
                if (findItem2 != null) {
                    findItem2.setVisible(true);
                }
                if (findItem3 != null) {
                    findItem3.setVisible(true);
                }
                if (this.z == null) {
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
                if (this.z != null && this.z.a().d() == 1) {
                    if (findItem5 != null) {
                        findItem5.setVisible(true);
                    }
                    if (findItem4 != null) {
                        findItem4.setVisible(false);
                        return;
                    }
                    return;
                }
                if (findItem5 != null) {
                    findItem5.setVisible(false);
                }
                if (findItem4 != null) {
                    findItem4.setVisible(true);
                }
            } catch (Exception e) {
                com.baidu.tieba.c.af.b("FrsActivity", "onPrepareOptionsMenu", "exp: " + e.toString());
            }
        }
    }

    @Override // android.app.Activity
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        D();
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        this.G = menu;
        menu.add(0, 0, 1, getString(R.string.write_msg)).setIcon(R.drawable.menu_post);
        menu.add(0, 1, 2, getString(R.string.refresh)).setIcon(R.drawable.menu_refresh);
        menu.add(0, 2, 3, getString(R.string.view_good)).setIcon(R.drawable.menu_view_good);
        menu.add(0, 3, 4, getString(R.string.like_forum_menu)).setIcon(R.drawable.menu_unlike);
        menu.add(0, 4, 4, getString(R.string.unlike)).setIcon(R.drawable.menu_unlike);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 0:
                d(0);
                break;
            case 1:
                if (this.g != null && this.g.length() > 0) {
                    u();
                    break;
                }
                break;
            case 2:
                if (!v()) {
                    t();
                    break;
                }
                break;
            case 4:
                showDialog(1);
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.n) {
            if (i == 4) {
                a();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        Intent a;
        if (str != null && (a = a((Context) this, str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + getString(R.string.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", a);
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this, R.drawable.icon));
            sendBroadcast(intent);
            new com.baidu.tieba.account.ak("add_to_launcher").start();
        }
    }

    private void E() {
        this.x.a(this.z.e(), this.z.a().c());
        this.S.removeMessages(1);
        if (this.m == 1 && this.z.e().a() == 1) {
            this.x.f(true);
            if (this.z.e().h() == 0) {
                this.T = System.nanoTime() / 1000000000;
                this.S.sendMessageDelayed(this.S.obtainMessage(1), 1000L);
                return;
            }
            return;
        }
        this.x.f(false);
    }

    public void i() {
        String w = TiebaApplication.w();
        if (w == null || w.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100021);
        } else if (!this.z.f()) {
            this.z.a(true);
            if (this.R != null) {
                this.R.a();
                this.R = null;
            }
            com.baidu.tieba.a.q a = this.z.a();
            this.R = new y(this, a.b(), a.c(), String.valueOf(a.d()));
            this.R.execute("http://c.tieba.baidu.com/c/c/user/fansno");
        }
    }
}
