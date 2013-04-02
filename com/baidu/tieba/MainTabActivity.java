package com.baidu.tieba;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.LocalActivityManager;
import android.app.ProgressDialog;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.home.HomeActivity;
import com.baidu.tieba.more.MoreActivity;
import com.baidu.tieba.nearby.NewNearbyActivity;
import com.baidu.tieba.pb.PbActivity;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.recommend.NewHomeActivity;
import com.baidu.tieba.service.ClearTempService;
import com.baidu.tieba.service.TiebaActiveService;
import com.baidu.tieba.service.TiebaSyncService;
/* loaded from: classes.dex */
public class MainTabActivity extends TabActivity implements CompoundButton.OnCheckedChangeListener {
    private static boolean a = false;
    private static String b = null;
    private TabHost c;
    private Intent d;
    private Intent e;
    private Intent f;
    private Intent g;
    private Intent h;
    private String i = null;
    private long j = 0;
    private long k = 0;
    private long l = 0;
    private TextView m = null;
    private ImageView n = null;
    private CompoundButton o = null;
    private CompoundButton p = null;
    private Handler q = null;
    private ProgressDialog r = null;
    private FrameLayout s = null;
    private RadioButton t = null;
    private RadioButton u = null;
    private RadioButton v = null;
    private RadioButton w = null;
    private RadioButton x = null;
    private AlertDialog y = null;
    private AlertDialog z = null;
    private com.baidu.tieba.view.x A = null;
    private ah B = null;

    public static void a() {
        a = true;
    }

    public static void a(String str) {
        b = str;
    }

    public void a(Bitmap bitmap, boolean z) {
        if (bitmap != null) {
            if (this.A == null) {
                this.A = new com.baidu.tieba.view.x(this, com.baidu.tieba.c.ai.d(getCurrentActivity()).widthPixels, com.baidu.tieba.c.ai.d(getCurrentActivity()).heightPixels - com.baidu.tieba.c.ai.b(getCurrentActivity()));
                this.A.setOnDismissListener(new ad(this));
                this.A.setOnCancelListener(new ae(this));
            }
            if (this.A.isShowing()) {
                this.A.a(bitmap);
            } else {
                this.A.a(bitmap, z);
            }
            a(0.3f);
        }
    }

    public void b() {
        if (this.A != null) {
            this.A.a();
        }
    }

    public void c() {
        a(1.0f);
        if (this.A != null) {
            this.A.a(null);
        }
    }

    private void a(float f) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = f;
        getWindow().setAttributes(attributes);
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent(context, MainTabActivity.class);
        intent.setFlags(603979776);
        if (str != null) {
            intent.putExtra("goto_type", str);
        }
        intent.putExtra("close_dialog", true);
        context.startActivity(intent);
    }

    public static void a(Context context, String str, boolean z) {
        Intent intent = new Intent(context, MainTabActivity.class);
        intent.setFlags(603979776);
        intent.putExtra("refresh_all", true);
        if (str != null) {
            intent.putExtra("goto_type", str);
        }
        if (z) {
            intent.addFlags(268435456);
        }
        intent.putExtra("close_dialog", true);
        context.startActivity(intent);
    }

    public static void b(Context context, String str) {
        TiebaApplication.b().s();
        a(context, str, false);
    }

    public static void b(Context context, String str, boolean z) {
        TiebaApplication.b().s();
        a(context, str, z);
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.c.ag.a(getClass().toString(), "onCreate", "debug");
        setContentView(R.layout.maintabs_activity);
        this.c = getTabHost();
        this.d = new Intent(this, HomeActivity.class);
        this.e = new Intent(this, NewHomeActivity.class);
        this.f = new Intent(this, PersonInfoActivity.class);
        this.f.putExtra("self", true);
        this.f.putExtra("tab_page", true);
        this.f.putExtra("un", TiebaApplication.y());
        this.g = new Intent(this, MoreActivity.class);
        this.h = new Intent(this, NewNearbyActivity.class);
        this.m = (TextView) findViewById(R.id.message_person);
        this.n = (ImageView) findViewById(R.id.new_version_logo);
        this.s = (FrameLayout) findViewById(R.id.bottom_container);
        m();
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (bundle != null) {
            intent.putExtra("goto_type", bundle.getString("goto_type"));
        }
        a(intent);
        e();
        if (TiebaApplication.r() != null && TiebaApplication.r().equals("aishide")) {
            g();
        }
        i();
        d();
        TiebaApplication.b().W();
        if (bundle == null) {
            p();
        }
        n();
    }

    private void d() {
        startService(new Intent(this, ClearTempService.class));
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onDestroy() {
        com.baidu.tieba.c.ag.a(getClass().getName(), "onDestroy", "");
        f();
        h();
        j();
        TiebaApplication.b().al();
        TiebaApplication.b().X();
        TiebaApplication.b().ab();
        if (TiebaApplication.b().an() != null) {
            TiebaApplication.b().an().b();
        }
        if (this.r != null) {
            this.r.dismiss();
            this.r = null;
        }
        if (this.y != null) {
            this.y.dismiss();
            this.y = null;
        }
        if (this.q != null) {
            this.q.removeMessages(1);
        }
        super.onDestroy();
        System.gc();
    }

    private void e() {
        startService(new Intent(this, TiebaSyncService.class));
    }

    private void f() {
        stopService(new Intent(this, TiebaSyncService.class));
    }

    private void g() {
        startService(new Intent(this, TiebaActiveService.class));
    }

    private void h() {
        stopService(new Intent(this, TiebaActiveService.class));
    }

    private void i() {
        this.B = new ah(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.notify");
        intentFilter.addAction("com.baidu.tieba.broadcast.newversion");
        registerReceiver(this.B, intentFilter);
    }

    private void j() {
        if (this.B != null) {
            unregisterReceiver(this.B);
        }
    }

    public void k() {
        long j = this.j + this.k + this.l;
        if (j > 0) {
            int left = (this.w.getLeft() + this.v.getLeft()) / 2;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams.leftMargin = left;
            this.m.setLayoutParams(layoutParams);
            this.m.setText(String.valueOf(j));
            this.m.setVisibility(0);
            return;
        }
        this.m.setVisibility(8);
    }

    public void l() {
        if (TiebaApplication.aH()) {
            this.n.setVisibility(0);
        } else {
            this.n.setVisibility(8);
        }
    }

    private void m() {
        this.t = (RadioButton) findViewById(R.id.radio_home);
        this.u = (RadioButton) findViewById(R.id.radio_recommend);
        this.v = (RadioButton) findViewById(R.id.radio_person_info);
        this.w = (RadioButton) findViewById(R.id.radio_nearby);
        this.x = (RadioButton) findViewById(R.id.radio_more);
        this.t.setOnCheckedChangeListener(this);
        this.u.setOnCheckedChangeListener(this);
        this.v.setOnCheckedChangeListener(this);
        this.w.setOnCheckedChangeListener(this);
        this.x.setOnCheckedChangeListener(this);
        if (TiebaApplication.b().ah() != 0) {
            a(1);
        }
    }

    public void a(int i) {
        if (i == 1) {
            this.s.setBackgroundResource(R.drawable.maintab_toolbar_bg_1);
            this.t.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_home_1), (Drawable) null, (Drawable) null);
            this.u.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_recommend_1), (Drawable) null, (Drawable) null);
            this.v.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_search_1), (Drawable) null, (Drawable) null);
            this.w.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_nearby_1), (Drawable) null, (Drawable) null);
            this.x.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_more_1), (Drawable) null, (Drawable) null);
            return;
        }
        this.s.setBackgroundResource(R.drawable.maintab_toolbar_bg);
        this.t.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_home), (Drawable) null, (Drawable) null);
        this.u.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_recommend), (Drawable) null, (Drawable) null);
        this.v.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_search), (Drawable) null, (Drawable) null);
        this.w.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_nearby), (Drawable) null, (Drawable) null);
        this.x.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_more), (Drawable) null, (Drawable) null);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.o = null;
            String y = TiebaApplication.y();
            CompoundButton compoundButton2 = this.p;
            this.p = compoundButton;
            if (y == null || y.length() <= 0) {
                switch (compoundButton.getId()) {
                    case R.id.radio_person_info /* 2131231139 */:
                        this.o = compoundButton2;
                        LoginActivity.a(this, "goto_person", getString(R.string.login_person_tab), 1100003);
                        return;
                }
            }
            switch (compoundButton.getId()) {
                case R.id.radio_recommend /* 2131231137 */:
                    if (TiebaApplication.b().l()) {
                        StatService.onEvent(this, "maintab_enterforum", "maintabclick", 1);
                    }
                    this.c.setCurrentTabByTag("recommend_tab");
                    return;
                case R.id.radio_home /* 2131231138 */:
                    if (TiebaApplication.b().l()) {
                        StatService.onEvent(this, "maintab_home", "maintabclick", 1);
                    }
                    this.c.setCurrentTabByTag("home_tab");
                    return;
                case R.id.radio_person_info /* 2131231139 */:
                    if (TiebaApplication.b().l()) {
                        StatService.onEvent(this, "maintab_personal", "maintabclick", 1);
                    }
                    this.f.putExtra("un", TiebaApplication.y());
                    this.c.setCurrentTabByTag("person_info_tab");
                    return;
                case R.id.radio_nearby /* 2131231140 */:
                    if (TiebaApplication.b().l()) {
                        StatService.onEvent(this, "maintab_nearby", "maintabclick", 1);
                    }
                    this.c.setCurrentTabByTag("nearby_tab");
                    return;
                case R.id.radio_more /* 2131231141 */:
                    if (TiebaApplication.b().l()) {
                        StatService.onEvent(this, "maintab_setting", "maintabclick", 1);
                    }
                    this.c.setCurrentTabByTag("more_tab");
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onResume() {
        super.onResume();
        TiebaApplication.b().at();
        TiebaApplication.b().au();
        String y = TiebaApplication.y();
        if ((y == null || y.length() <= 0) && this.o != null) {
            if (this.o != this.v) {
                this.o.setChecked(true);
            } else {
                this.u.setChecked(true);
            }
        }
        if (!TiebaApplication.g()) {
            if (b == null) {
                com.baidu.tieba.account.a.a().a(this, "goto_home");
                return;
            }
            com.baidu.tieba.account.a.a().a(this, b);
            b = null;
        }
    }

    private void n() {
        if (TiebaApplication.a() != null) {
            switch (TiebaApplication.a().getExtras().getInt("class", -1)) {
                case 0:
                    com.baidu.tieba.c.ai.c(this, TiebaApplication.a().getExtras().getString("url"));
                    break;
                case 1:
                    if (TiebaApplication.a().getBooleanExtra("is_message_pv", false)) {
                        PbActivity.a((Context) this, TiebaApplication.a().getStringExtra("id"), true, TiebaApplication.a().getLongExtra("message_id", 0L));
                        break;
                    } else {
                        PbActivity.a(this, TiebaApplication.a().getStringExtra("id"), TiebaApplication.a().getStringExtra("from"));
                        break;
                    }
                case 2:
                    FrsActivity.a(this, TiebaApplication.a().getStringExtra("fname"), TiebaApplication.a().getStringExtra("from"));
                    break;
                case 3:
                    TiebaApplication.a().setClass(this, MainTabActivity.class);
                    startActivity(TiebaApplication.a());
                    break;
            }
            TiebaApplication.a((Intent) null);
        }
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onPause() {
        super.onPause();
        LogoActivity.a(false);
        if (a) {
            a = false;
            CompatibleUtile.setAnim(this, R.anim.down, R.anim.hold);
        }
        TiebaApplication.b().av();
        if (this.A != null) {
            this.A.dismiss();
        }
    }

    @Override // android.app.TabActivity, android.app.ActivityGroup, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("goto_type", this.i);
        bundle.putString("pb_id", "");
        bundle.putString("frs_name", "");
        bundle.putString("url", "");
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        com.baidu.tieba.c.ag.a(getClass().getName(), "onNewIntent", "");
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("close_dialog", false)) {
            o();
        }
        if (intent.getBooleanExtra("refresh_all", false)) {
            this.f.putExtra("un", TiebaApplication.y());
            this.c.setCurrentTab(0);
            this.c.clearAllTabs();
            getLocalActivityManager().removeAllActivities();
            a(intent);
        }
        String stringExtra = intent.getStringExtra("goto_type");
        this.i = stringExtra;
        if ("goto_recommend".equals(stringExtra)) {
            this.u.setChecked(true);
        } else if ("goto_nearby".equals(stringExtra)) {
            this.w.setChecked(true);
        } else if ("goto_person".equals(stringExtra)) {
            this.v.setChecked(true);
        } else if ("goto_more".equals(stringExtra)) {
            this.x.setChecked(true);
        } else if ("goto_home".equals(stringExtra)) {
            this.t.setChecked(true);
        } else if ("close".equals(stringExtra)) {
            finish();
        }
        n();
    }

    private void o() {
        LocalActivityManager localActivityManager = getLocalActivityManager();
        String currentId = localActivityManager.getCurrentId();
        if (!currentId.equals("home_tab")) {
            HomeActivity homeActivity = (HomeActivity) localActivityManager.getActivity("home_tab");
            if (homeActivity != null) {
                homeActivity.i();
            }
        } else {
            currentId.equals("recommend_tab");
        }
        MoreActivity moreActivity = (MoreActivity) localActivityManager.getActivity("more_tab");
        if (moreActivity != null) {
            moreActivity.i();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            com.baidu.tieba.c.ag.e(getClass().getName(), "dispatchKeyEvent", "KEYCODE_BACK");
            com.baidu.tieba.c.ai.a((Activity) this);
            return false;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    private void a(Intent intent) {
        char c;
        TabHost tabHost = this.c;
        String stringExtra = intent.getStringExtra("goto_type");
        String y = TiebaApplication.y();
        if ((y == null || y.length() <= 0) && "goto_person".equals(stringExtra)) {
            stringExtra = "goto_recommend";
        }
        if ("goto_recommend".equals(stringExtra)) {
            if (intent.getBooleanExtra("is_message_pv", false)) {
                NewHomeActivity.a(true);
                NewHomeActivity.a(intent.getLongExtra("message_id", 0L));
            }
            tabHost.addTab(a("recommend_tab", this.e));
            this.p = this.u;
            c = 1;
        } else if ("goto_person".equals(stringExtra)) {
            tabHost.addTab(a("person_info_tab", this.f));
            this.p = this.v;
            c = 2;
        } else if ("goto_more".equals(stringExtra)) {
            tabHost.addTab(a("more_tab", this.g));
            this.p = this.x;
            c = 4;
        } else if ("goto_nearby".equals(stringExtra)) {
            c = 5;
            tabHost.addTab(a("nearby_tab", this.h));
            this.p = this.w;
        } else {
            tabHost.addTab(a("home_tab", this.d));
            this.p = this.t;
            c = 0;
        }
        if (c != 0) {
            tabHost.addTab(a("home_tab", this.d));
        }
        if (c != 1) {
            tabHost.addTab(a("recommend_tab", this.e));
        }
        if (c != 2) {
            tabHost.addTab(a("person_info_tab", this.f));
        }
        if (c != 3) {
            tabHost.addTab(a("nearby_tab", this.h));
        }
        if (c != 4) {
            tabHost.addTab(a("more_tab", this.g));
        }
        this.p.setChecked(true);
        TabWidget tabWidget = tabHost.getTabWidget();
        if (tabWidget != null) {
            int childCount = tabWidget.getChildCount();
            for (int i = 0; i < childCount; i++) {
                tabWidget.getChildAt(i).setFocusable(false);
            }
        }
    }

    private TabHost.TabSpec a(String str, Intent intent) {
        TabHost.TabSpec newTabSpec = this.c.newTabSpec(str);
        newTabSpec.setContent(intent).setIndicator("", getResources().getDrawable(R.drawable.icon));
        return newTabSpec;
    }

    private void p() {
        com.baidu.tieba.c.y a2 = com.baidu.tieba.c.w.a(this);
        if (a2 != com.baidu.tieba.c.y.UNAVAIL) {
            if (a2 == com.baidu.tieba.c.y.WIFI) {
                int q = TiebaApplication.b().q(true);
                if (q != 0) {
                    if (q == 1) {
                        a(true);
                        return;
                    } else if ((TiebaApplication.b().ae() && TiebaApplication.b().ad() != 1) || TiebaApplication.b().ac() != 1) {
                        if (this.y == null) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(this);
                            builder.setTitle(R.string.network_title);
                            builder.setMessage(R.string.network_wifi);
                            af afVar = new af(this);
                            builder.setPositiveButton(getString(R.string.cancel), afVar);
                            builder.setNegativeButton(getString(R.string.network_accept), afVar);
                            this.y = builder.create();
                        }
                        this.y.setCancelable(false);
                        this.y.setCanceledOnTouchOutside(false);
                        this.y.show();
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            int q2 = TiebaApplication.b().q(false);
            if (q2 != 0) {
                if (q2 == 1) {
                    a(false);
                } else if ((TiebaApplication.b().ae() && TiebaApplication.b().ad() != 2) || TiebaApplication.b().ac() == 1) {
                    if (this.z == null) {
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                        builder2.setTitle(R.string.network_title);
                        builder2.setMessage(R.string.network_not_wifi);
                        ag agVar = new ag(this);
                        builder2.setPositiveButton(getString(R.string.cancel), agVar);
                        builder2.setNegativeButton(getString(R.string.network_accept), agVar);
                        this.z = builder2.create();
                    }
                    this.z.setCancelable(false);
                    this.z.setCanceledOnTouchOutside(false);
                    this.z.show();
                }
            }
        }
    }

    public void a(boolean z) {
        if (z) {
            if (TiebaApplication.b().ae()) {
                TiebaApplication.b().f(1);
            }
            TiebaApplication.b().e(1);
            return;
        }
        if (TiebaApplication.b().ae()) {
            TiebaApplication.b().f(2);
        }
        if (TiebaApplication.b().ac() == 1) {
            TiebaApplication.b().e(2);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        try {
            return super.onKeyDown(i, keyEvent);
        } catch (IllegalStateException e) {
            if (i == 4) {
                finish();
            }
            return true;
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        try {
            return super.onKeyUp(i, keyEvent);
        } catch (IllegalStateException e) {
            if (i == 4) {
                finish();
            }
            return true;
        }
    }
}
