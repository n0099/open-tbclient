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
import com.baidu.tieba.c.af;
import com.baidu.tieba.c.ah;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.home.HomeActivity;
import com.baidu.tieba.more.MoreActivity;
import com.baidu.tieba.nearby.NearbyActivity;
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
    private TabHost a;
    private Intent b;
    private Intent c;
    private Intent d;
    private Intent e;
    private Intent f;
    private String g = null;
    private long h = 0;
    private long i = 0;
    private long j = 0;
    private TextView k = null;
    private ImageView l = null;
    private CompoundButton m = null;
    private CompoundButton n = null;
    private Handler o = null;
    private ProgressDialog p = null;
    private FrameLayout q = null;
    private RadioButton r = null;
    private RadioButton s = null;
    private RadioButton t = null;
    private RadioButton u = null;
    private RadioButton v = null;
    private AlertDialog w = null;
    private AlertDialog x = null;
    private com.baidu.tieba.view.x y = null;
    private t z = null;

    public void a(Bitmap bitmap, boolean z) {
        if (bitmap != null) {
            if (this.y == null) {
                this.y = new com.baidu.tieba.view.x(this, ah.d(getCurrentActivity()).widthPixels, ah.d(getCurrentActivity()).heightPixels - ah.b(getCurrentActivity()));
                this.y.setOnDismissListener(new p(this));
                this.y.setOnCancelListener(new q(this));
            }
            if (this.y.isShowing()) {
                this.y.a(bitmap);
            } else {
                this.y.a(bitmap, z);
            }
            a(0.3f);
        }
    }

    public void a() {
        if (this.y != null) {
            this.y.a();
        }
    }

    public void b() {
        a(1.0f);
        if (this.y != null) {
            this.y.a(null);
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
        af.a(getClass().toString(), "onCreate", "debug");
        setContentView(R.layout.maintabs_activity);
        this.a = getTabHost();
        this.b = new Intent(this, HomeActivity.class);
        this.c = new Intent(this, NewHomeActivity.class);
        this.d = new Intent(this, PersonInfoActivity.class);
        this.d.putExtra("self", true);
        this.d.putExtra("tab_page", true);
        this.d.putExtra("un", TiebaApplication.w());
        this.e = new Intent(this, MoreActivity.class);
        this.f = new Intent(this, NearbyActivity.class);
        this.k = (TextView) findViewById(R.id.message_person);
        this.l = (ImageView) findViewById(R.id.new_version_logo);
        this.q = (FrameLayout) findViewById(R.id.bottom_container);
        l();
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (bundle != null) {
            intent.putExtra("goto_type", bundle.getString("goto_type"));
        }
        a(intent);
        d();
        if (TiebaApplication.q() != null && TiebaApplication.q().equals("aishide")) {
            f();
        }
        h();
        c();
        TiebaApplication.b().U();
        if (bundle == null) {
            o();
        }
        m();
    }

    private void c() {
        startService(new Intent(this, ClearTempService.class));
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onDestroy() {
        af.a(getClass().getName(), "onDestroy", "");
        e();
        g();
        i();
        TiebaApplication.b().ai();
        TiebaApplication.b().V();
        TiebaApplication.b().Z();
        if (TiebaApplication.b().ak() != null) {
            TiebaApplication.b().ak().b();
        }
        if (this.p != null) {
            this.p.dismiss();
            this.p = null;
        }
        if (this.w != null) {
            this.w.dismiss();
            this.w = null;
        }
        if (this.o != null) {
            this.o.removeMessages(1);
        }
        super.onDestroy();
        System.gc();
    }

    private void d() {
        startService(new Intent(this, TiebaSyncService.class));
    }

    private void e() {
        stopService(new Intent(this, TiebaSyncService.class));
    }

    private void f() {
        startService(new Intent(this, TiebaActiveService.class));
    }

    private void g() {
        stopService(new Intent(this, TiebaActiveService.class));
    }

    private void h() {
        this.z = new t(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.notify");
        intentFilter.addAction("com.baidu.tieba.broadcast.newversion");
        registerReceiver(this.z, intentFilter);
    }

    private void i() {
        if (this.z != null) {
            unregisterReceiver(this.z);
        }
    }

    public void j() {
        long j = this.h + this.i + this.j;
        if (j > 0) {
            int left = (this.u.getLeft() + this.t.getLeft()) / 2;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams.leftMargin = left;
            this.k.setLayoutParams(layoutParams);
            this.k.setText(String.valueOf(j));
            this.k.setVisibility(0);
            return;
        }
        this.k.setVisibility(8);
    }

    public void k() {
        if (TiebaApplication.aB()) {
            this.l.setVisibility(0);
        } else {
            this.l.setVisibility(8);
        }
    }

    private void l() {
        this.r = (RadioButton) findViewById(R.id.radio_home);
        this.s = (RadioButton) findViewById(R.id.radio_recommend);
        this.t = (RadioButton) findViewById(R.id.radio_person_info);
        this.u = (RadioButton) findViewById(R.id.radio_nearby);
        this.v = (RadioButton) findViewById(R.id.radio_more);
        this.r.setOnCheckedChangeListener(this);
        this.s.setOnCheckedChangeListener(this);
        this.t.setOnCheckedChangeListener(this);
        this.u.setOnCheckedChangeListener(this);
        this.v.setOnCheckedChangeListener(this);
        if (TiebaApplication.b().af() != 0) {
            a(1);
        }
    }

    public void a(int i) {
        if (i == 1) {
            this.q.setBackgroundResource(R.drawable.maintab_toolbar_bg_1);
            this.r.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_home_1), (Drawable) null, (Drawable) null);
            this.s.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_recommend_1), (Drawable) null, (Drawable) null);
            this.t.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_search_1), (Drawable) null, (Drawable) null);
            this.u.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_nearby_1), (Drawable) null, (Drawable) null);
            this.v.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_more_1), (Drawable) null, (Drawable) null);
            return;
        }
        this.q.setBackgroundResource(R.drawable.maintab_toolbar_bg);
        this.r.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_home), (Drawable) null, (Drawable) null);
        this.s.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_recommend), (Drawable) null, (Drawable) null);
        this.t.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_search), (Drawable) null, (Drawable) null);
        this.u.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_nearby), (Drawable) null, (Drawable) null);
        this.v.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_more), (Drawable) null, (Drawable) null);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.m = null;
            String w = TiebaApplication.w();
            CompoundButton compoundButton2 = this.n;
            this.n = compoundButton;
            if (w == null || w.length() <= 0) {
                switch (compoundButton.getId()) {
                    case R.id.radio_person_info /* 2131231121 */:
                        this.m = compoundButton2;
                        LoginActivity.a(this, "goto_person", getString(R.string.login_person_tab), 1100003);
                        return;
                }
            }
            switch (compoundButton.getId()) {
                case R.id.radio_recommend /* 2131231119 */:
                    this.a.setCurrentTabByTag("recommend_tab");
                    return;
                case R.id.radio_home /* 2131231120 */:
                    this.a.setCurrentTabByTag("home_tab");
                    return;
                case R.id.radio_person_info /* 2131231121 */:
                    this.d.putExtra("un", TiebaApplication.w());
                    this.a.setCurrentTabByTag("person_info_tab");
                    return;
                case R.id.radio_nearby /* 2131231122 */:
                    this.a.setCurrentTabByTag("nearby_tab");
                    return;
                case R.id.radio_more /* 2131231123 */:
                    this.a.setCurrentTabByTag("more_tab");
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onResume() {
        super.onResume();
        TiebaApplication.b().ao();
        String w = TiebaApplication.w();
        if ((w == null || w.length() <= 0) && this.m != null) {
            if (this.m != this.t) {
                this.m.setChecked(true);
            } else {
                this.s.setChecked(true);
            }
        }
        if (!TiebaApplication.g()) {
            com.baidu.tieba.account.a.a().a((Activity) this);
        }
    }

    private void m() {
        if (TiebaApplication.a() != null) {
            switch (TiebaApplication.a().getExtras().getInt("class", -1)) {
                case 0:
                    ah.c(this, TiebaApplication.a().getExtras().getString("url"));
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
        TiebaApplication.b().ap();
        if (this.y != null) {
            this.y.dismiss();
        }
    }

    @Override // android.app.TabActivity, android.app.ActivityGroup, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("goto_type", this.g);
        bundle.putString("pb_id", "");
        bundle.putString("frs_name", "");
        bundle.putString("url", "");
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        af.a(getClass().getName(), "onNewIntent", "");
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("close_dialog", false)) {
            n();
        }
        if (intent.getBooleanExtra("refresh_all", false)) {
            this.d.putExtra("un", TiebaApplication.w());
            this.a.setCurrentTab(0);
            this.a.clearAllTabs();
            getLocalActivityManager().removeAllActivities();
            a(intent);
        }
        String stringExtra = intent.getStringExtra("goto_type");
        this.g = stringExtra;
        if ("goto_recommend".equals(stringExtra)) {
            this.s.setChecked(true);
        } else if ("goto_nearby".equals(stringExtra)) {
            this.u.setChecked(true);
        } else if ("goto_person".equals(stringExtra)) {
            this.t.setChecked(true);
        } else if ("goto_more".equals(stringExtra)) {
            this.v.setChecked(true);
        } else if ("goto_home".equals(stringExtra)) {
            this.r.setChecked(true);
        } else if ("close".equals(stringExtra)) {
            finish();
        }
        m();
    }

    private void n() {
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
            af.e(getClass().getName(), "dispatchKeyEvent", "KEYCODE_BACK");
            ah.a((Activity) this);
            return false;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    private void a(Intent intent) {
        char c;
        TabHost tabHost = this.a;
        String stringExtra = intent.getStringExtra("goto_type");
        String w = TiebaApplication.w();
        if ((w == null || w.length() <= 0) && "goto_person".equals(stringExtra)) {
            stringExtra = "goto_recommend";
        }
        if ("goto_recommend".equals(stringExtra)) {
            if (intent.getBooleanExtra("is_message_pv", false)) {
                RecommendActivity.a(true);
                RecommendActivity.a(intent.getLongExtra("message_id", 0L));
            }
            tabHost.addTab(a("recommend_tab", this.c));
            this.n = this.s;
            c = 1;
        } else if ("goto_person".equals(stringExtra)) {
            tabHost.addTab(a("person_info_tab", this.d));
            this.n = this.t;
            c = 2;
        } else if ("goto_more".equals(stringExtra)) {
            tabHost.addTab(a("more_tab", this.e));
            this.n = this.v;
            c = 4;
        } else if ("goto_nearby".equals(stringExtra)) {
            c = 5;
            tabHost.addTab(a("nearby_tab", this.f));
            this.n = this.u;
        } else {
            tabHost.addTab(a("home_tab", this.b));
            this.n = this.r;
            c = 0;
        }
        if (c != 0) {
            tabHost.addTab(a("home_tab", this.b));
        }
        if (c != 1) {
            tabHost.addTab(a("recommend_tab", this.c));
        }
        if (c != 2) {
            tabHost.addTab(a("person_info_tab", this.d));
        }
        if (c != 3) {
            tabHost.addTab(a("nearby_tab", this.f));
        }
        if (c != 4) {
            tabHost.addTab(a("more_tab", this.e));
        }
        this.n.setChecked(true);
        TabWidget tabWidget = tabHost.getTabWidget();
        if (tabWidget != null) {
            int childCount = tabWidget.getChildCount();
            for (int i = 0; i < childCount; i++) {
                tabWidget.getChildAt(i).setFocusable(false);
            }
        }
    }

    private TabHost.TabSpec a(String str, Intent intent) {
        TabHost.TabSpec newTabSpec = this.a.newTabSpec(str);
        newTabSpec.setContent(intent).setIndicator("", getResources().getDrawable(R.drawable.icon));
        return newTabSpec;
    }

    private void o() {
        com.baidu.tieba.c.y a = com.baidu.tieba.c.w.a(this);
        if (a != com.baidu.tieba.c.y.UNAVAIL) {
            if (a == com.baidu.tieba.c.y.WIFI) {
                int q = TiebaApplication.b().q(true);
                if (q != 0) {
                    if (q == 1) {
                        a(true);
                        return;
                    } else if ((TiebaApplication.b().ac() && TiebaApplication.b().ab() != 1) || TiebaApplication.b().aa() != 1) {
                        if (this.w == null) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(this);
                            builder.setTitle(R.string.network_title);
                            builder.setMessage(R.string.network_wifi);
                            r rVar = new r(this);
                            builder.setPositiveButton(getString(R.string.cancel), rVar);
                            builder.setNegativeButton(getString(R.string.network_accept), rVar);
                            this.w = builder.create();
                        }
                        this.w.setCancelable(false);
                        this.w.setCanceledOnTouchOutside(false);
                        this.w.show();
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
                } else if ((TiebaApplication.b().ac() && TiebaApplication.b().ab() != 2) || TiebaApplication.b().aa() == 1) {
                    if (this.x == null) {
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                        builder2.setTitle(R.string.network_title);
                        builder2.setMessage(R.string.network_not_wifi);
                        s sVar = new s(this);
                        builder2.setPositiveButton(getString(R.string.cancel), sVar);
                        builder2.setNegativeButton(getString(R.string.network_accept), sVar);
                        this.x = builder2.create();
                    }
                    this.x.setCancelable(false);
                    this.x.setCanceledOnTouchOutside(false);
                    this.x.show();
                }
            }
        }
    }

    public void a(boolean z) {
        if (z) {
            if (TiebaApplication.b().ac()) {
                TiebaApplication.b().f(1);
            }
            TiebaApplication.b().e(1);
            return;
        }
        if (TiebaApplication.b().ac()) {
            TiebaApplication.b().f(2);
        }
        if (TiebaApplication.b().aa() == 1) {
            TiebaApplication.b().e(2);
        }
    }
}
