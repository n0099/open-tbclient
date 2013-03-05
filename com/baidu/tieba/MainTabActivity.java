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
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.c.ag;
import com.baidu.tieba.c.ai;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.home.HomeActivity;
import com.baidu.tieba.more.MoreActivity;
import com.baidu.tieba.nearby.NewNearbyActivity;
import com.baidu.tieba.pb.PbActivity;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.recommend.GuessActivity;
import com.baidu.tieba.recommend.NewHomeActivity;
import com.baidu.tieba.recommend.RecommendActivity;
import com.baidu.tieba.service.ClearTempService;
import com.baidu.tieba.service.TiebaActiveService;
import com.baidu.tieba.service.TiebaSyncService;
/* loaded from: classes.dex */
public class MainTabActivity extends TabActivity implements CompoundButton.OnCheckedChangeListener {
    private static boolean a = false;
    private TabHost b;
    private Intent c;
    private Intent d;
    private Intent e;
    private Intent f;
    private Intent g;
    private String h = null;
    private long i = 0;
    private long j = 0;
    private long k = 0;
    private TextView l = null;
    private ImageView m = null;
    private CompoundButton n = null;
    private CompoundButton o = null;
    private Handler p = null;
    private ProgressDialog q = null;
    private FrameLayout r = null;
    private RadioButton s = null;
    private RadioButton t = null;
    private RadioButton u = null;
    private RadioButton v = null;
    private RadioButton w = null;
    private AlertDialog x = null;
    private AlertDialog y = null;
    private com.baidu.tieba.view.x z = null;
    private u A = null;

    public static void a() {
        a = true;
    }

    public void a(Bitmap bitmap, boolean z) {
        if (bitmap != null) {
            if (this.z == null) {
                this.z = new com.baidu.tieba.view.x(this, ai.d(getCurrentActivity()).widthPixels, ai.d(getCurrentActivity()).heightPixels - ai.b(getCurrentActivity()));
                this.z.setOnDismissListener(new q(this));
                this.z.setOnCancelListener(new r(this));
            }
            if (this.z.isShowing()) {
                this.z.a(bitmap);
            } else {
                this.z.a(bitmap, z);
            }
            a(0.3f);
        }
    }

    public void b() {
        if (this.z != null) {
            this.z.a();
        }
    }

    public void c() {
        a(1.0f);
        if (this.z != null) {
            this.z.a(null);
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
        TiebaApplication.b().r();
        a(context, str, false);
    }

    public static void b(Context context, String str, boolean z) {
        TiebaApplication.b().r();
        a(context, str, z);
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ag.a(getClass().toString(), "onCreate", "debug");
        setContentView(R.layout.maintabs_activity);
        this.b = getTabHost();
        this.c = new Intent(this, HomeActivity.class);
        this.d = new Intent(this, NewHomeActivity.class);
        this.e = new Intent(this, PersonInfoActivity.class);
        this.e.putExtra("self", true);
        this.e.putExtra("tab_page", true);
        this.e.putExtra("un", TiebaApplication.x());
        this.f = new Intent(this, MoreActivity.class);
        this.g = new Intent(this, NewNearbyActivity.class);
        this.l = (TextView) findViewById(R.id.message_person);
        this.m = (ImageView) findViewById(R.id.new_version_logo);
        this.r = (FrameLayout) findViewById(R.id.bottom_container);
        m();
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (bundle != null) {
            intent.putExtra("goto_type", bundle.getString("goto_type"));
        }
        a(intent);
        e();
        if (TiebaApplication.q() != null && TiebaApplication.q().equals("aishide")) {
            g();
        }
        i();
        d();
        TiebaApplication.b().V();
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
        ag.a(getClass().getName(), "onDestroy", "");
        f();
        h();
        j();
        TiebaApplication.b().aj();
        TiebaApplication.b().W();
        TiebaApplication.b().aa();
        if (TiebaApplication.b().al() != null) {
            TiebaApplication.b().al().b();
        }
        if (this.q != null) {
            this.q.dismiss();
            this.q = null;
        }
        if (this.x != null) {
            this.x.dismiss();
            this.x = null;
        }
        if (this.p != null) {
            this.p.removeMessages(1);
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
        this.A = new u(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.notify");
        intentFilter.addAction("com.baidu.tieba.broadcast.newversion");
        registerReceiver(this.A, intentFilter);
    }

    private void j() {
        if (this.A != null) {
            unregisterReceiver(this.A);
        }
    }

    public void k() {
        long j = this.i + this.j + this.k;
        if (j > 0) {
            int left = (this.v.getLeft() + this.u.getLeft()) / 2;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.l.getLayoutParams();
            layoutParams.leftMargin = left;
            this.l.setLayoutParams(layoutParams);
            this.l.setText(String.valueOf(j));
            this.l.setVisibility(0);
            return;
        }
        this.l.setVisibility(8);
    }

    public void l() {
        if (TiebaApplication.aC()) {
            this.m.setVisibility(0);
        } else {
            this.m.setVisibility(8);
        }
    }

    private void m() {
        this.s = (RadioButton) findViewById(R.id.radio_home);
        this.t = (RadioButton) findViewById(R.id.radio_recommend);
        this.u = (RadioButton) findViewById(R.id.radio_person_info);
        this.v = (RadioButton) findViewById(R.id.radio_nearby);
        this.w = (RadioButton) findViewById(R.id.radio_more);
        this.s.setOnCheckedChangeListener(this);
        this.t.setOnCheckedChangeListener(this);
        this.u.setOnCheckedChangeListener(this);
        this.v.setOnCheckedChangeListener(this);
        this.w.setOnCheckedChangeListener(this);
        if (TiebaApplication.b().ag() != 0) {
            a(1);
        }
    }

    public void a(int i) {
        if (i == 1) {
            this.r.setBackgroundResource(R.drawable.maintab_toolbar_bg_1);
            this.s.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_home_1), (Drawable) null, (Drawable) null);
            this.t.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_recommend_1), (Drawable) null, (Drawable) null);
            this.u.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_search_1), (Drawable) null, (Drawable) null);
            this.v.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_nearby_1), (Drawable) null, (Drawable) null);
            this.w.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_more_1), (Drawable) null, (Drawable) null);
            return;
        }
        this.r.setBackgroundResource(R.drawable.maintab_toolbar_bg);
        this.s.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_home), (Drawable) null, (Drawable) null);
        this.t.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_recommend), (Drawable) null, (Drawable) null);
        this.u.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_search), (Drawable) null, (Drawable) null);
        this.v.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_nearby), (Drawable) null, (Drawable) null);
        this.w.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_more), (Drawable) null, (Drawable) null);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.n = null;
            String x = TiebaApplication.x();
            CompoundButton compoundButton2 = this.o;
            this.o = compoundButton;
            if (x == null || x.length() <= 0) {
                switch (compoundButton.getId()) {
                    case R.id.radio_person_info /* 2131231121 */:
                        this.n = compoundButton2;
                        LoginActivity.a(this, "goto_person", getString(R.string.login_person_tab), 1100003);
                        return;
                }
            }
            switch (compoundButton.getId()) {
                case R.id.radio_recommend /* 2131231119 */:
                    this.b.setCurrentTabByTag("recommend_tab");
                    return;
                case R.id.radio_home /* 2131231120 */:
                    this.b.setCurrentTabByTag("home_tab");
                    return;
                case R.id.radio_person_info /* 2131231121 */:
                    this.e.putExtra("un", TiebaApplication.x());
                    this.b.setCurrentTabByTag("person_info_tab");
                    return;
                case R.id.radio_nearby /* 2131231122 */:
                    this.b.setCurrentTabByTag("nearby_tab");
                    return;
                case R.id.radio_more /* 2131231123 */:
                    this.b.setCurrentTabByTag("more_tab");
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onResume() {
        super.onResume();
        TiebaApplication.b().ap();
        String x = TiebaApplication.x();
        if ((x == null || x.length() <= 0) && this.n != null) {
            if (this.n != this.u) {
                this.n.setChecked(true);
            } else {
                this.t.setChecked(true);
            }
        }
        if (!TiebaApplication.g()) {
            com.baidu.tieba.account.a.a().a((Activity) this);
        }
    }

    private void n() {
        if (TiebaApplication.a() != null) {
            switch (TiebaApplication.a().getExtras().getInt("class", -1)) {
                case 0:
                    ai.c(this, TiebaApplication.a().getExtras().getString("url"));
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
        TiebaApplication.b().aq();
        if (this.z != null) {
            this.z.dismiss();
        }
    }

    @Override // android.app.TabActivity, android.app.ActivityGroup, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("goto_type", this.h);
        bundle.putString("pb_id", "");
        bundle.putString("frs_name", "");
        bundle.putString("url", "");
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        ag.a(getClass().getName(), "onNewIntent", "");
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("close_dialog", false)) {
            o();
        }
        if (intent.getBooleanExtra("refresh_all", false)) {
            this.e.putExtra("un", TiebaApplication.x());
            this.b.setCurrentTab(0);
            this.b.clearAllTabs();
            getLocalActivityManager().removeAllActivities();
            a(intent);
        }
        String stringExtra = intent.getStringExtra("goto_type");
        this.h = stringExtra;
        if ("goto_recommend".equals(stringExtra)) {
            this.t.setChecked(true);
        } else if ("goto_nearby".equals(stringExtra)) {
            this.v.setChecked(true);
        } else if ("goto_person".equals(stringExtra)) {
            this.u.setChecked(true);
        } else if ("goto_more".equals(stringExtra)) {
            this.w.setChecked(true);
        } else if ("goto_home".equals(stringExtra)) {
            this.s.setChecked(true);
        } else if ("close".equals(stringExtra)) {
            finish();
        }
        n();
    }

    private void o() {
        NewHomeActivity newHomeActivity;
        LocalActivityManager localActivityManager = getLocalActivityManager();
        String currentId = localActivityManager.getCurrentId();
        if (!currentId.equals("home_tab")) {
            HomeActivity homeActivity = (HomeActivity) localActivityManager.getActivity("home_tab");
            if (homeActivity != null) {
                homeActivity.i();
            }
        } else if (!currentId.equals("recommend_tab") && (newHomeActivity = (NewHomeActivity) localActivityManager.getActivity("recommend_tab")) != null) {
            Activity currentActivity = newHomeActivity.getCurrentActivity();
            if (currentActivity instanceof GuessActivity) {
                ((GuessActivity) currentActivity).i();
            }
        }
        MoreActivity moreActivity = (MoreActivity) localActivityManager.getActivity("more_tab");
        if (moreActivity != null) {
            moreActivity.i();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            ag.e(getClass().getName(), "dispatchKeyEvent", "KEYCODE_BACK");
            ai.a((Activity) this);
            return false;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    private void a(Intent intent) {
        char c;
        TabHost tabHost = this.b;
        String stringExtra = intent.getStringExtra("goto_type");
        String x = TiebaApplication.x();
        if ((x == null || x.length() <= 0) && "goto_person".equals(stringExtra)) {
            stringExtra = "goto_recommend";
        }
        if ("goto_recommend".equals(stringExtra)) {
            if (intent.getBooleanExtra("is_message_pv", false)) {
                RecommendActivity.a(true);
                RecommendActivity.a(intent.getLongExtra("message_id", 0L));
            }
            tabHost.addTab(a("recommend_tab", this.d));
            this.o = this.t;
            c = 1;
        } else if ("goto_person".equals(stringExtra)) {
            tabHost.addTab(a("person_info_tab", this.e));
            this.o = this.u;
            c = 2;
        } else if ("goto_more".equals(stringExtra)) {
            tabHost.addTab(a("more_tab", this.f));
            this.o = this.w;
            c = 4;
        } else if ("goto_nearby".equals(stringExtra)) {
            c = 5;
            tabHost.addTab(a("nearby_tab", this.g));
            this.o = this.v;
        } else {
            tabHost.addTab(a("home_tab", this.c));
            this.o = this.s;
            c = 0;
        }
        if (c != 0) {
            tabHost.addTab(a("home_tab", this.c));
        }
        if (c != 1) {
            tabHost.addTab(a("recommend_tab", this.d));
        }
        if (c != 2) {
            tabHost.addTab(a("person_info_tab", this.e));
        }
        if (c != 3) {
            tabHost.addTab(a("nearby_tab", this.g));
        }
        if (c != 4) {
            tabHost.addTab(a("more_tab", this.f));
        }
        this.o.setChecked(true);
        TabWidget tabWidget = tabHost.getTabWidget();
        if (tabWidget != null) {
            int childCount = tabWidget.getChildCount();
            for (int i = 0; i < childCount; i++) {
                tabWidget.getChildAt(i).setFocusable(false);
            }
        }
    }

    private TabHost.TabSpec a(String str, Intent intent) {
        TabHost.TabSpec newTabSpec = this.b.newTabSpec(str);
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
                    } else if ((TiebaApplication.b().ad() && TiebaApplication.b().ac() != 1) || TiebaApplication.b().ab() != 1) {
                        if (this.x == null) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(this);
                            builder.setTitle(R.string.network_title);
                            builder.setMessage(R.string.network_wifi);
                            s sVar = new s(this);
                            builder.setPositiveButton(getString(R.string.cancel), sVar);
                            builder.setNegativeButton(getString(R.string.network_accept), sVar);
                            this.x = builder.create();
                        }
                        this.x.setCancelable(false);
                        this.x.setCanceledOnTouchOutside(false);
                        this.x.show();
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
                } else if ((TiebaApplication.b().ad() && TiebaApplication.b().ac() != 2) || TiebaApplication.b().ab() == 1) {
                    if (this.y == null) {
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                        builder2.setTitle(R.string.network_title);
                        builder2.setMessage(R.string.network_not_wifi);
                        t tVar = new t(this);
                        builder2.setPositiveButton(getString(R.string.cancel), tVar);
                        builder2.setNegativeButton(getString(R.string.network_accept), tVar);
                        this.y = builder2.create();
                    }
                    this.y.setCancelable(false);
                    this.y.setCanceledOnTouchOutside(false);
                    this.y.show();
                }
            }
        }
    }

    public void a(boolean z) {
        if (z) {
            if (TiebaApplication.b().ad()) {
                TiebaApplication.b().f(1);
            }
            TiebaApplication.b().e(1);
            return;
        }
        if (TiebaApplication.b().ad()) {
            TiebaApplication.b().f(2);
        }
        if (TiebaApplication.b().ab() == 1) {
            TiebaApplication.b().e(2);
        }
    }
}
