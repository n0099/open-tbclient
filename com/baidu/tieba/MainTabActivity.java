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
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.c.ae;
import com.baidu.tieba.c.ag;
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
    private CompoundButton l = null;
    private CompoundButton m = null;
    private Handler n = null;
    private ProgressDialog o = null;
    private RadioButton p = null;
    private RadioButton q = null;
    private RadioButton r = null;
    private RadioButton s = null;
    private RadioButton t = null;
    private AlertDialog u = null;
    private AlertDialog v = null;
    private com.baidu.tieba.view.x w = null;
    private q x = null;

    private TabHost.TabSpec a(String str, Intent intent) {
        TabHost.TabSpec newTabSpec = this.a.newTabSpec(str);
        newTabSpec.setContent(intent).setIndicator("", getResources().getDrawable(R.drawable.icon));
        return newTabSpec;
    }

    private void a(float f) {
        if (TiebaApplication.a().ac() != 0.0f) {
            return;
        }
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

    public static void a(Context context, String str, int i, String str2, Intent intent) {
        Intent intent2 = new Intent(context, MainTabActivity.class);
        intent2.setFlags(603979776);
        if (str != null) {
            intent2.putExtra("goto_type", str);
        }
        if (i == 1) {
            intent2.putExtra("pb_id", str2);
            if (intent != null) {
                intent2.putExtra("is_message_pv", intent.getBooleanExtra("is_message_pv", false));
                intent2.putExtra("message_id", intent.getLongExtra("message_id", 0L));
            }
        } else if (i == 2) {
            intent2.putExtra("frs_name", str2);
        }
        intent2.putExtra("close_dialog", true);
        context.startActivity(intent2);
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

    private void a(Intent intent) {
        char c;
        TabHost tabHost = this.a;
        String stringExtra = intent.getStringExtra("goto_type");
        String u = TiebaApplication.u();
        if ((u == null || u.length() <= 0) && "goto_person".equals(stringExtra)) {
            stringExtra = "goto_recommend";
        }
        if ("goto_recommend".equals(stringExtra)) {
            if (intent.getBooleanExtra("is_message_pv", false)) {
                RecommendActivity.a(true);
                RecommendActivity.a(intent.getLongExtra("message_id", 0L));
            }
            tabHost.addTab(a("recommend_tab", this.c));
            this.m = this.q;
            c = 1;
        } else if ("goto_person".equals(stringExtra)) {
            tabHost.addTab(a("person_info_tab", this.d));
            this.m = this.r;
            c = 2;
        } else if ("goto_more".equals(stringExtra)) {
            tabHost.addTab(a("more_tab", this.e));
            this.m = this.t;
            c = 4;
        } else if ("goto_nearby".equals(stringExtra)) {
            c = 5;
            tabHost.addTab(a("nearby_tab", this.f));
            this.m = this.s;
        } else {
            tabHost.addTab(a("home_tab", this.b));
            this.m = this.p;
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
        this.m.setChecked(true);
        TabWidget tabWidget = tabHost.getTabWidget();
        if (tabWidget != null) {
            int childCount = tabWidget.getChildCount();
            for (int i = 0; i < childCount; i++) {
                tabWidget.getChildAt(i).setFocusable(false);
            }
        }
    }

    private void a(Bundle bundle) {
        String string = bundle != null ? bundle.getString("pb_id") : getIntent().getStringExtra("pb_id");
        if (string != null && string.length() > 0) {
            PbActivity.a((Context) this, string, true, getIntent().getLongExtra("message_id", 0L));
        }
        String string2 = bundle != null ? bundle.getString("frs_name") : getIntent().getStringExtra("frs_name");
        if (string2 == null || string2.length() <= 0) {
            return;
        }
        FrsActivity.a((Context) this, string2, (String) null, true);
    }

    public void a(boolean z) {
        if (z) {
            if (TiebaApplication.a().Z()) {
                TiebaApplication.a().f(1);
            }
            TiebaApplication.a().e(1);
            return;
        }
        if (TiebaApplication.a().Z()) {
            TiebaApplication.a().f(2);
        }
        if (TiebaApplication.a().X() == 1) {
            TiebaApplication.a().e(2);
        }
    }

    public void b() {
        a(1.0f);
        if (this.w != null) {
            this.w.a(null);
        }
    }

    public static void b(Context context, String str) {
        TiebaApplication.a().p();
        a(context, str, false);
    }

    public static void b(Context context, String str, boolean z) {
        TiebaApplication.a().p();
        a(context, str, z);
    }

    private void c() {
        startService(new Intent(this, ClearTempService.class));
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
        this.x = new q(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.notify");
        registerReceiver(this.x, intentFilter);
    }

    private void i() {
        if (this.x != null) {
            unregisterReceiver(this.x);
        }
    }

    public void j() {
        long j = this.h + this.i + this.j;
        if (j <= 0) {
            this.k.setVisibility(8);
            return;
        }
        int left = (this.s.getLeft() + this.r.getLeft()) / 2;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.k.getLayoutParams();
        layoutParams.leftMargin = left;
        this.k.setLayoutParams(layoutParams);
        this.k.setText(String.valueOf(j));
        this.k.setVisibility(0);
    }

    private void k() {
        this.p = (RadioButton) findViewById(R.id.radio_home);
        this.q = (RadioButton) findViewById(R.id.radio_recommend);
        this.r = (RadioButton) findViewById(R.id.radio_person_info);
        this.s = (RadioButton) findViewById(R.id.radio_nearby);
        this.t = (RadioButton) findViewById(R.id.radio_more);
        this.p.setOnCheckedChangeListener(this);
        this.q.setOnCheckedChangeListener(this);
        this.r.setOnCheckedChangeListener(this);
        this.s.setOnCheckedChangeListener(this);
        this.t.setOnCheckedChangeListener(this);
    }

    private void l() {
        NewHomeActivity newHomeActivity;
        LocalActivityManager localActivityManager = getLocalActivityManager();
        String currentId = localActivityManager.getCurrentId();
        if (!currentId.equals("home_tab")) {
            HomeActivity homeActivity = (HomeActivity) localActivityManager.getActivity("home_tab");
            if (homeActivity != null) {
                homeActivity.g();
            }
        } else if (!currentId.equals("recommend_tab") && (newHomeActivity = (NewHomeActivity) localActivityManager.getActivity("recommend_tab")) != null) {
            Activity currentActivity = newHomeActivity.getCurrentActivity();
            if (currentActivity instanceof GuessActivity) {
                ((GuessActivity) currentActivity).g();
            }
        }
        MoreActivity moreActivity = (MoreActivity) localActivityManager.getActivity("more_tab");
        if (moreActivity != null) {
            moreActivity.g();
        }
    }

    private void m() {
        com.baidu.tieba.c.y a = com.baidu.tieba.c.w.a(this);
        if (a == com.baidu.tieba.c.y.UNAVAIL) {
            return;
        }
        if (a == com.baidu.tieba.c.y.WIFI) {
            int p = TiebaApplication.a().p(true);
            if (p != 0) {
                if (p == 1) {
                    a(true);
                    return;
                } else if ((!TiebaApplication.a().Z() || TiebaApplication.a().Y() == 1) && TiebaApplication.a().X() == 1) {
                    return;
                } else {
                    if (this.u == null) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setTitle(R.string.network_title);
                        builder.setMessage(R.string.network_wifi);
                        o oVar = new o(this);
                        builder.setPositiveButton(getString(R.string.cancel), oVar);
                        builder.setNegativeButton(getString(R.string.network_accept), oVar);
                        this.u = builder.create();
                    }
                    this.u.setCancelable(false);
                    this.u.setCanceledOnTouchOutside(false);
                    this.u.show();
                    return;
                }
            }
            return;
        }
        int p2 = TiebaApplication.a().p(false);
        if (p2 != 0) {
            if (p2 == 1) {
                a(false);
            } else if ((!TiebaApplication.a().Z() || TiebaApplication.a().Y() == 2) && TiebaApplication.a().X() != 1) {
            } else {
                if (this.v == null) {
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                    builder2.setTitle(R.string.network_title);
                    builder2.setMessage(R.string.network_not_wifi);
                    p pVar = new p(this);
                    builder2.setPositiveButton(getString(R.string.cancel), pVar);
                    builder2.setNegativeButton(getString(R.string.network_accept), pVar);
                    this.v = builder2.create();
                }
                this.v.setCancelable(false);
                this.v.setCanceledOnTouchOutside(false);
                this.v.show();
            }
        }
    }

    public void a() {
        if (this.w == null) {
            return;
        }
        this.w.a();
    }

    public void a(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return;
        }
        if (this.w == null) {
            this.w = new com.baidu.tieba.view.x(this, ag.d(getCurrentActivity()).widthPixels, ag.d(getCurrentActivity()).heightPixels - ag.b(getCurrentActivity()));
            this.w.setOnDismissListener(new m(this));
            this.w.setOnCancelListener(new n(this));
        }
        if (this.w.isShowing()) {
            this.w.a(bitmap);
        } else {
            this.w.a(bitmap, z);
        }
        a(0.3f);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            ae.c(getClass().getName(), "dispatchKeyEvent", "KEYCODE_BACK");
            ag.a((Activity) this);
            return false;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.l = null;
            String u = TiebaApplication.u();
            CompoundButton compoundButton2 = this.m;
            this.m = compoundButton;
            if (u == null || u.length() <= 0) {
                switch (compoundButton.getId()) {
                    case R.id.radio_person_info /* 2131231054 */:
                        this.l = compoundButton2;
                        LoginActivity.a(this, "goto_person", getString(R.string.login_person_tab), 1100003);
                        return;
                }
            }
            switch (compoundButton.getId()) {
                case R.id.radio_recommend /* 2131231052 */:
                    this.a.setCurrentTabByTag("recommend_tab");
                    return;
                case R.id.radio_home /* 2131231053 */:
                    this.a.setCurrentTabByTag("home_tab");
                    return;
                case R.id.radio_person_info /* 2131231054 */:
                    this.d.putExtra("un", TiebaApplication.u());
                    this.a.setCurrentTabByTag("person_info_tab");
                    return;
                case R.id.radio_nearby /* 2131231055 */:
                    this.a.setCurrentTabByTag("nearby_tab");
                    return;
                case R.id.radio_more /* 2131231056 */:
                    this.a.setCurrentTabByTag("more_tab");
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(bundle);
        ae.a(getClass().toString(), "onCreate", "debug");
        setContentView(R.layout.maintabs_activity);
        this.a = getTabHost();
        this.b = new Intent(this, HomeActivity.class);
        this.c = new Intent(this, NewHomeActivity.class);
        this.d = new Intent(this, PersonInfoActivity.class);
        this.d.putExtra("self", true);
        this.d.putExtra("tab_page", true);
        this.d.putExtra("un", TiebaApplication.u());
        this.e = new Intent(this, MoreActivity.class);
        this.f = new Intent(this, NearbyActivity.class);
        this.k = (TextView) findViewById(R.id.message_person);
        k();
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (bundle != null) {
            intent.putExtra("goto_type", bundle.getString("goto_type"));
        }
        a(intent);
        d();
        if (TiebaApplication.o() != null && TiebaApplication.o().equals("aishide")) {
            f();
        }
        h();
        c();
        TiebaApplication.a().Q();
        if (bundle == null) {
            m();
        }
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onDestroy() {
        ae.a(getClass().getName(), "onDestroy", "");
        e();
        g();
        i();
        TiebaApplication.a().af();
        TiebaApplication.a().R();
        TiebaApplication.a().W();
        if (TiebaApplication.a().ah() != null) {
            TiebaApplication.a().ah().b();
        }
        if (this.o != null) {
            this.o.dismiss();
            this.o = null;
        }
        if (this.u != null) {
            this.u.dismiss();
            this.u = null;
        }
        if (this.n != null) {
            this.n.removeMessages(1);
        }
        super.onDestroy();
        System.gc();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        ae.a(getClass().getName(), "onNewIntent", "");
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("close_dialog", false)) {
            l();
        }
        if (intent.getBooleanExtra("refresh_all", false)) {
            this.d.putExtra("un", TiebaApplication.u());
            this.a.setCurrentTab(0);
            this.a.clearAllTabs();
            getLocalActivityManager().removeAllActivities();
            a(intent);
        }
        String stringExtra = intent.getStringExtra("goto_type");
        this.g = stringExtra;
        if ("goto_recommend".equals(stringExtra)) {
            this.q.setChecked(true);
        } else if ("goto_nearby".equals(stringExtra)) {
            this.s.setChecked(true);
        } else if ("goto_person".equals(stringExtra)) {
            this.r.setChecked(true);
        } else if ("goto_more".equals(stringExtra)) {
            this.t.setChecked(true);
        } else if ("goto_home".equals(stringExtra)) {
            this.p.setChecked(true);
        } else if ("close".equals(stringExtra)) {
            finish();
        }
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onPause() {
        super.onPause();
        TiebaApplication.a().am();
        if (this.w != null) {
            this.w.dismiss();
        }
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onResume() {
        super.onResume();
        TiebaApplication.a().al();
        String u = TiebaApplication.u();
        if (!TiebaApplication.f()) {
            if ((u == null || u.length() <= 0) && this.l != null) {
                if (this.l != this.r) {
                    this.l.setChecked(true);
                } else {
                    this.q.setChecked(true);
                }
            }
            com.baidu.tieba.account.a.a().a((Activity) this);
        } else if (u == null || u.length() <= 0) {
            if (this.m == null || !(this.m == this.q || this.m == this.t)) {
                this.q.setChecked(true);
            } else {
                this.m.setChecked(true);
            }
        }
        ag.e(this);
    }

    @Override // android.app.TabActivity, android.app.ActivityGroup, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("goto_type", this.g);
        bundle.putString("pb_id", "");
        bundle.putString("frs_name", "");
    }
}
