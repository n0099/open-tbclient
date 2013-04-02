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
import com.baidu.tieba.a.ax;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.home.CreateBarActivity;
import com.baidu.tieba.pb.PbActivity;
import com.baidu.tieba.write.WriteActivity;
import com.baidu.tieba.write.WriteImageActivity;
import com.baidu.tieba.write.bb;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class FrsActivity extends com.baidu.tieba.e {
    private static volatile long P = 0;
    private static volatile long Q = 0;
    private static volatile int R = 0;
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
    private boolean q = false;
    private Button r = null;
    private TextView s = null;
    private LinearLayout t = null;
    private Button u = null;
    private Button v = null;
    private Button w = null;
    private ListView x = null;
    private aa y = null;
    private z z = null;
    private com.baidu.tieba.b.c A = null;
    private ProgressBar B = null;
    private TextView C = null;
    private LinearLayout D = null;
    private TextView E = null;
    private ImageView F = null;
    private Button G = null;
    private Menu H = null;
    private AlertDialog I = null;
    private String J = null;
    private String K = null;
    private ax L = null;
    private com.baidu.tieba.view.l M = null;
    private LinearLayout N = null;
    private RelativeLayout O = null;
    private y S = null;
    private Handler T = null;
    private long U = 0;
    private AlertDialog V = null;
    private View W = null;
    private a X = null;
    private LinearLayout Y = null;
    AlertDialog c = null;
    private Handler Z = null;
    private com.baidu.tieba.c.a aa = null;
    private com.baidu.tieba.view.x ab = null;
    private Runnable ac = new c(this);
    private AdapterView.OnItemLongClickListener ad = new p(this);

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
        this.aa = new com.baidu.tieba.c.a(this);
        this.aa.b(true);
        int a = com.baidu.tieba.c.ai.a(this, 234.0f);
        int i = a <= 350 ? a : 350;
        this.aa.a(i, (int) (i * 1.62f));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (n()) {
            setContentView(R.layout.frs_activity);
            this.Z = new Handler();
            m();
            o();
            this.K = TiebaApplication.y();
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
                this.J = this.h;
                this.T = new q(this);
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
        if (this.Z != null) {
            this.Z.removeCallbacks(this.ac);
        }
        if (this.M != null) {
            this.M.e();
        }
        if (this.T != null) {
            this.T.removeMessages(1);
        }
        super.onDestroy();
        try {
            if (this.z != null) {
                this.z.a();
                this.z = null;
            }
            if (this.S != null) {
                this.S.a();
                this.S = null;
            }
            if (this.y != null) {
                this.y.f();
            }
            if (this.B != null) {
                this.B.setVisibility(8);
            }
            System.gc();
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "onDestroy", e.getMessage());
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
                    if (this.M != null) {
                        this.M.a();
                        return;
                    }
                    return;
                case 1100011:
                    c(this.L);
                    return;
                case 1100012:
                    s();
                    return;
                case 1100013:
                    r();
                    return;
                case 1100014:
                    if (this.M != null) {
                        this.M.b();
                        return;
                    }
                    return;
                case 1100016:
                    this.I.show();
                    return;
                case 1100021:
                    if (this.A != null) {
                        i();
                        return;
                    }
                    return;
                case 1200001:
                    if (this.A != null && this.A.a() != null) {
                        WriteImageActivity.a(this, 1200001, 12000010, null, this.A.a().b(), this.g, this.A.c());
                        return;
                    }
                    return;
                case 1200002:
                    if (this.A != null && this.A.a() != null && intent != null && intent.getData() != null) {
                        WriteImageActivity.a(this, 1200002, 1200008, intent.getData(), this.A.a().b(), this.g, this.A.c());
                        return;
                    }
                    return;
                case 1200008:
                case 12000010:
                    if (this.A != null && this.A.a() != null) {
                        if (intent == null || intent.getStringExtra("filename") == null) {
                            WriteActivity.a((Activity) this, this.A.a().b(), this.g, (com.baidu.tieba.a.b) null, true, (String) null);
                            return;
                        } else {
                            WriteActivity.a((Activity) this, this.A.a().b(), this.g, (com.baidu.tieba.a.b) null, true, intent.getStringExtra("filename"));
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
                    bb.b(this);
                    return;
                case 12000010:
                    bb.a(this);
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
        String y = TiebaApplication.y();
        if (this.K == null && y != null && y.length() > 0) {
            this.K = y;
            if (this.A != null && this.A.c() != null) {
                this.A.c().a(1);
            }
        }
        this.ac.run();
        if (this.T != null) {
            this.T.removeMessages(1);
            this.T.sendMessageDelayed(this.T.obtainMessage(1), 1000L);
        }
    }

    @Override // com.baidu.tieba.e
    public void a() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
            return;
        }
        String y = TiebaApplication.y();
        if ((y != null && y.length() > 0) || TiebaApplication.b().ai() >= 3) {
            MainTabActivity.a(this, "goto_home");
        } else {
            MainTabActivity.a(this, "goto_recommend");
        }
    }

    private void o() {
        this.O = (RelativeLayout) findViewById(R.id.frs);
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
        this.s = (TextView) findViewById(R.id.frs_tv_title);
        this.F = (ImageView) findViewById(R.id.frs_tv_title_good);
        this.r = (Button) findViewById(R.id.frs_bt_back);
        this.r.setOnClickListener(new r(this));
        this.u = (Button) findViewById(R.id.frs_bt_post);
        this.u.setOnClickListener(new s(this));
        this.v = (Button) findViewById(R.id.frs_bt_refresh);
        this.v.setOnClickListener(new t(this));
        this.w = (Button) findViewById(R.id.frs_bt_camera);
        this.w.setOnClickListener(new u(this));
        String[] strArr = {getString(R.string.take_photo), getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setItems(strArr, new v(this));
        if (this.I == null) {
            this.I = builder.create();
            this.I.setCanceledOnTouchOutside(true);
        }
        this.x = (ListView) findViewById(R.id.frs_lv_thread);
        this.M = new com.baidu.tieba.view.l(this, com.baidu.tieba.view.o.FRS_LIST, null, null);
        this.x.addHeaderView(this.M.c());
        this.y = new aa(this, null, com.baidu.tieba.c.ai.a((Context) this));
        this.y.a(new w(this));
        this.x.setAdapter((ListAdapter) this.y);
        this.x.setOnItemClickListener(new f(this));
        this.x.setOnItemLongClickListener(this.ad);
        this.B = (ProgressBar) findViewById(R.id.frs_progress);
        a(false);
        this.C = (TextView) findViewById(R.id.frs_noexist);
        this.C.setVisibility(8);
        this.E = (TextView) findViewById(R.id.frs_noexist_text);
        this.Y = (LinearLayout) findViewById(R.id.frs_title);
        this.t = (LinearLayout) findViewById(R.id.frs_ll_bt_good);
        this.t.setOnClickListener(new h(this));
        this.D = (LinearLayout) findViewById(R.id.frs_noexist_layout);
        this.G = (Button) findViewById(R.id.frs_bt_create);
        this.G.setOnClickListener(new i(this));
        this.x.setOnScrollListener(new j(this));
        this.N = (LinearLayout) findViewById(R.id.frs_bottom);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        com.baidu.tieba.c.ae.a(this.O, i);
        com.baidu.tieba.c.ae.c(this.s, i);
        com.baidu.tieba.c.ae.c((TextView) this.r, i);
        com.baidu.tieba.c.ae.e((TextView) this.r, i);
        com.baidu.tieba.c.ae.c(this.Y, i);
        com.baidu.tieba.c.ae.b(this.C, i);
        com.baidu.tieba.c.ae.b(this.x, i);
        this.M.a(i);
        if (i == 1) {
            this.N.setBackgroundResource(R.drawable.maintab_toolbar_bg_1);
            this.v.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.frs_pb_bottom_btn_refresh_1), (Drawable) null, (Drawable) null);
            this.w.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.frs_bottom_camera_1), (Drawable) null, (Drawable) null);
            this.u.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.frs_bottom_write_1), (Drawable) null, (Drawable) null);
            this.v.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color_1));
            this.w.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color_1));
            this.u.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color_1));
            return;
        }
        this.N.setBackgroundResource(R.drawable.maintab_toolbar_bg);
        this.v.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.frs_pb_bottom_btn_refresh), (Drawable) null, (Drawable) null);
        this.w.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.frs_bottom_camera), (Drawable) null, (Drawable) null);
        this.u.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.frs_bottom_write), (Drawable) null, (Drawable) null);
        this.v.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color));
        this.w.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color));
        this.u.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.ab != null) {
            this.ab.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, boolean z) {
        if (bitmap != null) {
            if (this.ab == null) {
                this.ab = new com.baidu.tieba.view.x(this, this.O.getWidth(), this.O.getHeight());
                this.ab.setOnDismissListener(new k(this));
                this.ab.setOnCancelListener(new l(this));
            }
            if (this.ab.isShowing()) {
                this.ab.a(bitmap);
            } else {
                this.ab.a(bitmap, z);
            }
            a(0.3f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.aa != null) {
            this.aa.b();
        }
        a(1.0f);
        if (this.ab != null) {
            this.ab.a(null);
        }
    }

    private void a(float f) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = f;
        getWindow().setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        String y = TiebaApplication.y();
        if (y == null || y.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100013);
            return;
        }
        CreateBarActivity.a(this, this.g, true);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        String y = TiebaApplication.y();
        if (y == null || y.length() <= 0) {
            if (this.A != null && this.A.c() != null) {
                this.A.c().a(1);
            }
            if (i == 0) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100001);
            } else {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100016);
            }
        } else if (this.A != null) {
            if (i == 0) {
                WriteActivity.a((Activity) this, this.A.a().b(), this.g, this.A.c(), false, (String) null);
            } else {
                this.I.show();
            }
        }
    }

    private boolean a(ax axVar) {
        String a;
        return axVar == null || axVar.h() == null || (a = axVar.h().a()) == null || a.equals("0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ax axVar) {
        boolean a = a(axVar);
        m mVar = new m(this, axVar);
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
    public void c(ax axVar) {
        boolean a = a(axVar);
        if (this.o != null) {
            if (!a) {
                PbActivity.a(this, this.o, true, true, "tb_frslist", this.p);
            } else {
                PbActivity.a(this, this.o, false, false, "tb_frslist", this.p);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.o != null) {
            PbActivity.a(this, this.o, false, false, "tb_frslist", this.p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.V == null) {
            this.V = new AlertDialog.Builder(this).create();
            this.V.setCanceledOnTouchOutside(true);
            this.W = getLayoutInflater().inflate(R.layout.dialog_good, (ViewGroup) null);
            ListView listView = (ListView) this.W.findViewById(R.id.frs_dia_list);
            this.X = new a(this, null);
            this.X.a(this.b);
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
            listView.setAdapter((ListAdapter) this.X);
            listView.setOnItemClickListener(new o(this));
        }
        if (this.X != null && this.A != null && this.A.a() != null) {
            this.X.a(this.A.a().g());
            this.X.notifyDataSetInvalidated();
            this.V.show();
            this.V.setContentView(this.W);
            WindowManager.LayoutParams attributes = this.V.getWindow().getAttributes();
            attributes.gravity = 49;
            attributes.y = (this.Y.getTop() + this.Y.getHeight()) - 5;
            attributes.alpha = 1.0f;
            attributes.width = com.baidu.tieba.c.ai.a(this, 160.0f);
            attributes.height = -2;
            this.V.getWindow().setAttributes(attributes);
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
        this.q = z;
        if (z) {
            this.B.setVisibility(0);
        } else {
            this.B.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        BasicNameValuePair basicNameValuePair;
        switch (this.f) {
            case 1:
                if (this.y.c()) {
                    return;
                }
                break;
            case 2:
                if (this.y.d()) {
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
        if (TiebaApplication.b().ag()) {
            basicNameValuePair = new BasicNameValuePair("rn", String.valueOf(35));
        } else {
            basicNameValuePair = new BasicNameValuePair("rn", String.valueOf(50));
        }
        arrayList.add(basicNameValuePair);
        if (this.l == 1) {
            arrayList.add(new BasicNameValuePair("is_good", "1"));
            arrayList.add(new BasicNameValuePair("cid", String.valueOf(this.k)));
        }
        if (this.J != null) {
            arrayList.add(new BasicNameValuePair("st_type", this.J));
        }
        C();
        this.z = new z(this, stringBuffer.toString(), arrayList, this.f);
        this.z.execute(stringBuffer.toString(), arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (this.e) {
            this.t.setVisibility(4);
        } else {
            this.t.setClickable(false);
        }
    }

    private void y() {
        if (this.l == 0) {
            this.s.setText(this.g.concat(this.d));
        } else {
            this.s.setText(this.j);
        }
        if (this.e) {
            this.t.setVisibility(0);
        } else {
            this.t.setClickable(true);
        }
    }

    private void z() {
        switch (this.i) {
            case 1:
                com.baidu.tieba.c.k.k(this.g);
                break;
        }
        this.i = 0;
    }

    private void A() {
        this.e = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        this.x.setVisibility(0);
        this.u.setVisibility(0);
        this.v.setVisibility(0);
        this.y.a(TiebaApplication.b().ag());
        try {
            if (this.A != null) {
                this.g = this.A.a().c();
                y();
                z();
                A();
                ArrayList b = this.A.b();
                if (b != null) {
                    this.y.a(b);
                    E();
                    if (this.M != null) {
                        this.M.a(this.g, this.A.a().b());
                        this.M.a(this.A.a().d(), this.A.a().h(), this.A.a().e());
                        this.M.b(this.A.a().f().b());
                        if (this.A.a().f().a() == -2) {
                            this.M.a(false);
                        }
                        if (this.A.a().a() == 0) {
                            this.M.d();
                        }
                    }
                    if (this.m > 1) {
                        this.y.d(true);
                    } else {
                        this.y.d(false);
                    }
                    if (this.A.d().c() == 1) {
                        this.y.e(true);
                    } else {
                        this.y.e(false);
                    }
                    this.y.b(false);
                    this.y.c(false);
                    this.y.notifyDataSetInvalidated();
                    if (this.f == 1) {
                        if (this.M != null) {
                            this.x.setSelection(2);
                        } else {
                            this.x.setSelection(1);
                        }
                    } else {
                        this.x.setSelection(0);
                    }
                    this.C.setVisibility(8);
                    a(false);
                    D();
                }
                if ((b == null || b.size() <= 0) && this.l != 1) {
                    this.C.setText(R.string.frs_nodata);
                    this.C.setVisibility(0);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "", "HomeActivity.refreshFrs error = " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        super.onPause();
        this.y.a().b();
        this.y.b().b();
        if (this.ab != null) {
            this.ab.dismiss();
        }
        if (this.T != null) {
            this.T.removeMessages(1);
        }
    }

    private void C() {
        if (this.z != null) {
            this.z.a();
            this.z = null;
        }
        a(false);
        this.y.b(false);
        this.y.c(false);
        this.y.notifyDataSetChanged();
    }

    private void D() {
        if (this.H != null) {
            try {
                MenuItem findItem = this.H.findItem(0);
                MenuItem findItem2 = this.H.findItem(1);
                MenuItem findItem3 = this.H.findItem(2);
                MenuItem findItem4 = this.H.findItem(3);
                MenuItem findItem5 = this.H.findItem(4);
                if (findItem != null) {
                    findItem.setVisible(true);
                }
                if (findItem2 != null) {
                    findItem2.setVisible(true);
                }
                if (findItem3 != null) {
                    findItem3.setVisible(true);
                }
                if (this.A == null) {
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
                if (this.A != null && this.A.a().d() == 1) {
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
                com.baidu.tieba.c.ag.b("FrsActivity", "onPrepareOptionsMenu", "exp: " + e.toString());
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
        this.H = menu;
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

    @Override // com.baidu.tieba.e, android.app.Activity, android.view.KeyEvent.Callback
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
        this.y.a(this.A.e(), this.A.a().c());
        this.T.removeMessages(1);
        if (this.m == 1 && this.A.e().a() == 1) {
            this.y.f(true);
            if (this.A.e().h() == 0) {
                this.U = System.nanoTime() / 1000000000;
                this.T.sendMessageDelayed(this.T.obtainMessage(1), 1000L);
                return;
            }
            return;
        }
        this.y.f(false);
    }

    public void i() {
        String y = TiebaApplication.y();
        if (y == null || y.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100021);
        } else if (!this.A.f()) {
            this.A.a(true);
            if (this.S != null) {
                this.S.a();
                this.S = null;
            }
            com.baidu.tieba.a.q a = this.A.a();
            this.S = new y(this, a.b(), a.c(), String.valueOf(a.d()));
            this.S.execute("http://c.tieba.baidu.com/c/c/user/fansno");
        }
    }
}
