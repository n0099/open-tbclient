package com.baidu.tieba;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.LocalActivityManager;
import android.app.ProgressDialog;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.home.EnterForumActivity;
import com.baidu.tieba.nearby.NewNearbyActivity;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.recommend.NewHomeActivity;
import com.baidu.tieba.service.ClearTempService;
import com.baidu.tieba.service.TiebaActiveService;
import com.baidu.tieba.service.TiebaSyncService;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class MainTabActivity extends TabActivity implements CompoundButton.OnCheckedChangeListener {
    private static boolean b = false;
    private static String c = null;
    private TabHost d;
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
    private Handler p = null;
    private ProgressDialog q = null;
    private FrameLayout r = null;
    private RadioButton s = null;
    private RadioButton t = null;
    private RadioButton u = null;
    private RadioButton v = null;
    private AlertDialog w = null;
    private AlertDialog x = null;
    private com.baidu.tieba.view.aa y = null;
    protected int a = -1;
    private ag z = null;

    public static void a() {
        b = true;
    }

    public static void a(String str) {
        c = str;
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
        TiebaApplication.d().v();
        a(context, str, false);
    }

    public static void b(Context context, String str, boolean z) {
        TiebaApplication.d().v();
        a(context, str, z);
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (b()) {
            CompatibleUtile.getInstance().openGpu(this);
        }
        com.baidu.tieba.d.ae.a(getClass().toString(), "onCreate", "debug");
        setContentView(R.layout.maintabs_activity);
        this.d = getTabHost();
        this.e = new Intent(this, EnterForumActivity.class);
        this.f = new Intent(this, NewHomeActivity.class);
        this.g = new Intent(this, PersonInfoActivity.class);
        this.g.putExtra("self", true);
        this.g.putExtra("tab_page", true);
        this.g.putExtra("un", TiebaApplication.z());
        this.h = new Intent(this, NewNearbyActivity.class);
        this.m = (TextView) findViewById(R.id.message_person);
        this.n = (ImageView) findViewById(R.id.new_version_logo);
        this.r = (FrameLayout) findViewById(R.id.bottom_container);
        CompatibleUtile.getInstance().closeViewGpu(this.d.getTabWidget());
        CompatibleUtile.getInstance().closeViewGpu(this.r);
        l();
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (bundle != null) {
            intent.putExtra("goto_type", bundle.getString("goto_type"));
        }
        a(intent);
        d();
        if (TiebaApplication.u() != null && TiebaApplication.u().equals("aishide")) {
            f();
        }
        h();
        c();
        TiebaApplication.d().X();
        if (bundle == null) {
            o();
        }
        m();
    }

    public boolean b() {
        return TiebaApplication.d().q();
    }

    private void c() {
        startService(new Intent(this, ClearTempService.class));
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onDestroy() {
        com.baidu.tieba.d.ae.a(getClass().getName(), "onDestroy", "");
        e();
        g();
        i();
        TiebaApplication.d().an();
        TiebaApplication.d().Y();
        TiebaApplication.d().ac();
        com.baidu.tbadk.a.d.a().b();
        if (this.q != null) {
            this.q.dismiss();
            this.q = null;
        }
        if (this.w != null) {
            this.w.dismiss();
            this.w = null;
        }
        if (this.p != null) {
            this.p.removeMessages(1);
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
        this.z = new ag(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.notify");
        registerReceiver(this.z, intentFilter);
    }

    private void i() {
        if (this.z != null) {
            unregisterReceiver(this.z);
        }
    }

    public void j() {
        long j = this.j + this.k + this.l;
        if (j > 0) {
            int left = (this.u.getLeft() + this.u.getRight()) / 2;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams.leftMargin = left;
            this.m.setLayoutParams(layoutParams);
            if (j > 99) {
                this.m.setText("99+");
            } else {
                this.m.setText(String.valueOf(j));
            }
            this.m.setVisibility(0);
            return;
        }
        this.m.setVisibility(8);
    }

    public void k() {
        if (TiebaApplication.aH()) {
            this.n.setVisibility(0);
        } else {
            this.n.setVisibility(8);
        }
    }

    private void l() {
        this.s = (RadioButton) findViewById(R.id.radio_home);
        this.t = (RadioButton) findViewById(R.id.radio_recommend);
        this.u = (RadioButton) findViewById(R.id.radio_person_info);
        this.v = (RadioButton) findViewById(R.id.radio_nearby);
        this.s.setOnCheckedChangeListener(this);
        this.t.setOnCheckedChangeListener(this);
        this.u.setOnCheckedChangeListener(this);
        this.v.setOnCheckedChangeListener(this);
    }

    public void a(int i) {
        if (i == 1) {
            this.r.setBackgroundResource(R.drawable.maintab_toolbar_bg_1);
            this.s.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_home_1), (Drawable) null, (Drawable) null);
            this.t.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_recommend_1), (Drawable) null, (Drawable) null);
            this.u.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_search_1), (Drawable) null, (Drawable) null);
            this.v.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_nearby_1), (Drawable) null, (Drawable) null);
            com.baidu.tieba.d.ac.h((View) this.s, (int) R.drawable.tabs_btn_bg_1);
            com.baidu.tieba.d.ac.h((View) this.t, (int) R.drawable.tabs_btn_bg_1);
            com.baidu.tieba.d.ac.h((View) this.u, (int) R.drawable.tabs_btn_bg_1);
            com.baidu.tieba.d.ac.h((View) this.v, (int) R.drawable.tabs_btn_bg_1);
            return;
        }
        this.r.setBackgroundResource(R.drawable.maintab_toolbar_bg);
        this.s.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_home), (Drawable) null, (Drawable) null);
        this.t.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_recommend), (Drawable) null, (Drawable) null);
        this.u.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_search), (Drawable) null, (Drawable) null);
        this.v.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_nearby), (Drawable) null, (Drawable) null);
        com.baidu.tieba.d.ac.h((View) this.s, (int) R.drawable.tabs_btn_bg);
        com.baidu.tieba.d.ac.h((View) this.t, (int) R.drawable.tabs_btn_bg);
        com.baidu.tieba.d.ac.h((View) this.u, (int) R.drawable.tabs_btn_bg);
        com.baidu.tieba.d.ac.h((View) this.v, (int) R.drawable.tabs_btn_bg);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            switch (compoundButton.getId()) {
                case R.id.radio_recommend /* 2131100112 */:
                    if (TiebaApplication.d().n()) {
                        StatService.onEvent(this, "maintab_enterforum", "maintabclick", 1);
                    }
                    this.d.setCurrentTabByTag("recommend_tab");
                    return;
                case R.id.radio_home /* 2131100113 */:
                    if (TiebaApplication.d().n()) {
                        StatService.onEvent(this, "maintab_home", "maintabclick", 1);
                    }
                    this.d.setCurrentTabByTag("home_tab");
                    return;
                case R.id.radio_nearby /* 2131100114 */:
                    if (TiebaApplication.d().n()) {
                        StatService.onEvent(this, "maintab_nearby", "maintabclick", 1);
                    }
                    this.d.setCurrentTabByTag("nearby_tab");
                    return;
                case R.id.radio_person_info /* 2131100115 */:
                    if (TiebaApplication.d().n()) {
                        StatService.onEvent(this, "maintab_personal", "maintabclick", 1);
                    }
                    this.g.putExtra("un", TiebaApplication.z());
                    this.d.setCurrentTabByTag("person_info_tab");
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onResume() {
        super.onResume();
        TiebaApplication.d().at();
        TiebaApplication.d().au();
        if (!TiebaApplication.i()) {
            if (c == null) {
                com.baidu.tieba.account.a.a().a(this, "goto_home");
            } else {
                com.baidu.tieba.account.a.a().a(this, c);
                c = null;
            }
        }
        if (TiebaApplication.d().ai() != this.a) {
            this.a = TiebaApplication.d().ai();
            a(this.a);
        }
    }

    private void m() {
        if (TiebaApplication.c() != null) {
            switch (TiebaApplication.c().getExtras().getInt("class", -1)) {
                case 0:
                    com.baidu.tieba.d.ag.c(this, TiebaApplication.c().getExtras().getString("url"));
                    break;
                case 1:
                    if (TiebaApplication.c().getBooleanExtra("is_message_pv", false)) {
                        NewPbActivity.a(this, TiebaApplication.c().getStringExtra("id"), null, TiebaApplication.c().getStringExtra("from"), TiebaApplication.c().getLongExtra("message_id", 0L));
                        break;
                    } else {
                        NewPbActivity.a(this, TiebaApplication.c().getStringExtra("id"), null, TiebaApplication.c().getStringExtra("from"));
                        break;
                    }
                case 2:
                    FrsActivity.a(this, TiebaApplication.c().getStringExtra("fname"), TiebaApplication.c().getStringExtra("from"));
                    break;
                case 3:
                    TiebaApplication.c().setClass(this, MainTabActivity.class);
                    startActivity(TiebaApplication.c());
                    break;
            }
            TiebaApplication.a((Intent) null);
        }
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onPause() {
        super.onPause();
        LogoActivity.a(false);
        if (b) {
            b = false;
            CompatibleUtile.setAnim(this, R.anim.down, R.anim.hold);
        }
        TiebaApplication.d().av();
        if (this.y != null) {
            this.y.dismiss();
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
        com.baidu.tieba.d.ae.a(getClass().getName(), "onNewIntent", "");
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("close_dialog", false)) {
            n();
        }
        if (intent.getBooleanExtra("refresh_all", false)) {
            this.g.putExtra("un", TiebaApplication.z());
            this.d.setCurrentTab(0);
            this.d.clearAllTabs();
            getLocalActivityManager().removeAllActivities();
            a(intent);
        }
        String stringExtra = intent.getStringExtra("goto_type");
        this.i = stringExtra;
        if ("goto_recommend".equals(stringExtra)) {
            this.t.setChecked(true);
        } else if ("goto_nearby".equals(stringExtra)) {
            this.v.setChecked(true);
        } else if ("goto_person".equals(stringExtra)) {
            this.u.setChecked(true);
        } else if ("goto_home".equals(stringExtra)) {
            this.s.setChecked(true);
        } else if ("close".equals(stringExtra)) {
            finish();
        }
        m();
    }

    private void n() {
        LocalActivityManager localActivityManager = getLocalActivityManager();
        String currentId = localActivityManager.getCurrentId();
        if (!currentId.equals("home_tab")) {
            EnterForumActivity enterForumActivity = (EnterForumActivity) localActivityManager.getActivity("home_tab");
            if (enterForumActivity != null) {
                enterForumActivity.c();
                return;
            }
            return;
        }
        currentId.equals("recommend_tab");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            com.baidu.tieba.d.ae.e(getClass().getName(), "dispatchKeyEvent", "KEYCODE_BACK");
            com.baidu.tieba.d.ag.a((Activity) this);
            return false;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    private void a(Intent intent) {
        char c2;
        TabHost tabHost = this.d;
        String stringExtra = intent.getStringExtra("goto_type");
        if ("goto_recommend".equals(stringExtra)) {
            if (intent.getBooleanExtra("is_message_pv", false)) {
                NewHomeActivity.a(true);
                NewHomeActivity.a(intent.getLongExtra("message_id", 0L));
            }
            tabHost.addTab(a("recommend_tab", this.f));
            this.o = this.t;
            c2 = 1;
        } else if ("goto_person".equals(stringExtra)) {
            tabHost.addTab(a("person_info_tab", this.g));
            this.o = this.u;
            c2 = 2;
        } else if ("goto_nearby".equals(stringExtra)) {
            c2 = 5;
            tabHost.addTab(a("nearby_tab", this.h));
            this.o = this.v;
        } else {
            tabHost.addTab(a("home_tab", this.e));
            this.o = this.s;
            c2 = 0;
        }
        if (c2 != 0) {
            tabHost.addTab(a("home_tab", this.e));
        }
        if (c2 != 1) {
            tabHost.addTab(a("recommend_tab", this.f));
        }
        if (c2 != 2) {
            tabHost.addTab(a("person_info_tab", this.g));
        }
        if (c2 != 3) {
            tabHost.addTab(a("nearby_tab", this.h));
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
        TabHost.TabSpec newTabSpec = this.d.newTabSpec(str);
        newTabSpec.setContent(intent).setIndicator("", getResources().getDrawable(R.drawable.icon));
        return newTabSpec;
    }

    private void o() {
        com.baidu.tieba.d.y a = com.baidu.tieba.d.w.a(this);
        if (a != com.baidu.tieba.d.y.UNAVAIL) {
            if (a == com.baidu.tieba.d.y.WIFI) {
                int r = TiebaApplication.d().r(true);
                if (r != 0) {
                    if (r == 1) {
                        a(true);
                        return;
                    } else if ((TiebaApplication.d().af() && TiebaApplication.d().ae() != 1) || TiebaApplication.d().ad() != 1) {
                        if (this.w == null) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(this);
                            builder.setTitle(R.string.network_title);
                            builder.setMessage(R.string.network_wifi);
                            ae aeVar = new ae(this);
                            builder.setPositiveButton(getString(R.string.cancel), aeVar);
                            builder.setNegativeButton(getString(R.string.network_accept), aeVar);
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
            int r2 = TiebaApplication.d().r(false);
            if (r2 != 0) {
                if (r2 == 1) {
                    a(false);
                } else if ((TiebaApplication.d().af() && TiebaApplication.d().ae() != 2) || TiebaApplication.d().ad() == 1) {
                    if (this.x == null) {
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                        builder2.setTitle(R.string.network_title);
                        builder2.setMessage(R.string.network_not_wifi);
                        af afVar = new af(this);
                        builder2.setPositiveButton(getString(R.string.cancel), afVar);
                        builder2.setNegativeButton(getString(R.string.network_accept), afVar);
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
            if (TiebaApplication.d().af()) {
                TiebaApplication.d().f(1);
            }
            TiebaApplication.d().e(1);
            return;
        }
        if (TiebaApplication.d().af()) {
            TiebaApplication.d().f(2);
        }
        if (TiebaApplication.d().ad() == 1) {
            TiebaApplication.d().e(2);
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
