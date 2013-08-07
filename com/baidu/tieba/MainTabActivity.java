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
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import com.baidu.browser.core.util.BdLog;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.chat.ChatListActivity;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.home.EnterForumActivity;
import com.baidu.tieba.kn.ladders.KnTabActivity;
import com.baidu.tieba.mention.MentionActivity;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.person.PersonListActivity;
import com.baidu.tieba.recommend.RecommendActivity;
import com.baidu.tieba.service.ClearTempService;
import com.baidu.tieba.service.TiebaActiveService;
import com.baidu.tieba.service.TiebaSyncService;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.view.GuidPageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class MainTabActivity extends TabActivity implements CompoundButton.OnCheckedChangeListener {
    private static boolean b = false;
    private static String c = null;
    private com.baidu.tieba.recommend.z F;
    private TabHost d;
    private Intent e;
    private Intent f;
    private Intent g;
    private Intent h;
    private Intent i;
    private String j = null;
    private long k = 0;
    private long l = 0;
    private long m = 0;
    private long n = 0;
    private TextView o = null;
    private ImageView p = null;
    private ImageView q = null;
    private CompoundButton r = null;
    private Handler s = new Handler();
    private ProgressDialog t = null;
    private FrameLayout u = null;
    private RadioButton v = null;
    private RadioButton w = null;
    private RadioButton x = null;
    private RadioButton y = null;
    private AlertDialog z = null;
    private com.baidu.tieba.view.af A = null;
    private GuidPageView B = null;
    private boolean C = false;
    private boolean D = true;

    /* renamed from: a */
    protected int f822a = -1;
    private al E = null;
    private Runnable G = new aj(this);

    public static void a(String str) {
        c = str;
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent(context, MainTabActivity.class);
        intent.setFlags(603979776);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (str != null) {
            intent.putExtra("goto_type", str);
        }
        intent.putExtra("close_dialog", true);
        context.startActivity(intent);
    }

    public static void a(Context context) {
        String E = TiebaApplication.E();
        if (E != null && E.length() > 0) {
            a(context, "goto_home");
        } else {
            a(context, "goto_recommend");
        }
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
        TiebaApplication.f().B();
        a(context, str, false);
    }

    public static void b(Context context, String str, boolean z) {
        TiebaApplication.f().B();
        a(context, str, z);
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (a()) {
            CompatibleUtile.getInstance().openGpu(this);
        }
        com.baidu.tieba.util.aj.a(getClass().toString(), "onCreate", "debug");
        setContentView(R.layout.maintabs_activity);
        this.d = getTabHost();
        this.e = new Intent(this, EnterForumActivity.class);
        this.f = new Intent(this, RecommendActivity.class);
        this.g = new Intent(this, PersonInfoActivity.class);
        this.g.putExtra("self", true);
        this.g.putExtra("tab_page", true);
        this.g.putExtra("un", TiebaApplication.E());
        this.h = new Intent(this, KnTabActivity.class);
        this.i = new Intent(this, CommonWebviewActivity.class);
        this.o = (TextView) findViewById(R.id.message_person);
        this.p = (ImageView) findViewById(R.id.new_version_logo);
        this.q = (ImageView) findViewById(R.id.new_recommends_logo);
        b();
        this.u = (FrameLayout) findViewById(R.id.bottom_container);
        CompatibleUtile.getInstance().closeViewGpu(this.d.getTabWidget());
        CompatibleUtile.getInstance().closeViewGpu(this.u);
        l();
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (bundle != null) {
            intent.putExtra("goto_type", bundle.getString("goto_type"));
        }
        a(intent);
        d();
        if (TiebaApplication.A() != null && TiebaApplication.A().equals("aishide")) {
            f();
        }
        h();
        c();
        TiebaApplication.f().ac();
        if (bundle == null) {
            o();
        }
        a(this, TiebaApplication.d());
        String M = TiebaApplication.f().M();
        if (M != null && M.length() > 0) {
            com.baidu.tieba.util.am.b(TiebaApplication.f(), M);
            TiebaApplication.f().i((String) null);
        }
        this.s.removeCallbacks(this.G);
        this.s.post(this.G);
    }

    public boolean a() {
        return TiebaApplication.f().w();
    }

    private void c() {
        try {
            startService(new Intent(this, ClearTempService.class));
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onDestroy() {
        com.baidu.tieba.util.aj.a(getClass().getName(), "onDestroy", "");
        e();
        g();
        i();
        TiebaApplication.f().aC();
        TiebaApplication.f().ad();
        TiebaApplication.f().ai();
        com.baidu.tbadk.a.e.a().c();
        if (this.t != null) {
            this.t.dismiss();
            this.t = null;
        }
        if (this.z != null) {
            this.z.dismiss();
            this.z = null;
        }
        if (this.s != null) {
            this.s.removeMessages(1);
        }
        if (this.B != null) {
            this.B.a();
        }
        if (this.s != null) {
            this.s.removeCallbacks(this.G);
        }
        if (this.F != null) {
            this.F.cancelLoadData();
            this.F = null;
        }
        com.baidu.tieba.util.ak.a();
        super.onDestroy();
        System.gc();
    }

    @Override // android.app.TabActivity, android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        try {
            super.onRestoreInstanceState(bundle);
        } catch (Throwable th) {
            com.baidu.adp.lib.e.d.a(getClass(), "onRestoreInstanceState", th);
        }
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

    private void a(Context context, Intent intent) {
        if (!com.baidu.tieba.util.am.a(context, intent) && intent != null) {
            switch (TiebaApplication.d().getExtras().getInt("class", -1)) {
                case 5:
                    long longExtra = TiebaApplication.d().getLongExtra("at_me", 0L);
                    long longExtra2 = TiebaApplication.d().getLongExtra("reply_me", 0L);
                    long longExtra3 = TiebaApplication.d().getLongExtra("fans", 0L);
                    long longExtra4 = TiebaApplication.d().getLongExtra("chat", 0L);
                    TiebaApplication.f().b(longExtra2, longExtra, longExtra3, longExtra4);
                    if ((longExtra2 > 0 || longExtra > 0) && longExtra3 == 0 && longExtra4 == 0) {
                        context.startActivity(new Intent(context, MentionActivity.class));
                        break;
                    } else if (longExtra3 > 0 && longExtra2 == 0 && longExtra == 0 && longExtra4 == 0) {
                        Intent intent2 = new Intent(context, PersonListActivity.class);
                        intent2.putExtra("follow", false);
                        intent2.putExtra("un", TiebaApplication.E());
                        context.startActivity(intent2);
                        break;
                    } else if (longExtra4 > 0 && longExtra3 == 0 && longExtra2 == 0 && longExtra == 0) {
                        context.startActivity(new Intent(context, ChatListActivity.class));
                        break;
                    } else {
                        Intent intent3 = new Intent();
                        intent3.putExtra("goto_type", "goto_person");
                        a(intent3);
                        break;
                    }
                    break;
            }
        }
        TiebaApplication.a((Intent) null);
    }

    private void h() {
        this.E = new al(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.notify");
        intentFilter.addAction("com.baidu.tieba.broadcast.newrecommends");
        registerReceiver(this.E, intentFilter);
    }

    private void i() {
        if (this.E != null) {
            unregisterReceiver(this.E);
        }
    }

    public void j() {
        long j = this.k + this.l + this.m + this.n;
        if (j > 0) {
            int a2 = (com.baidu.tieba.util.am.a((Context) this) * 7) / 8;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.o.getLayoutParams();
            layoutParams.leftMargin = a2;
            this.o.setLayoutParams(layoutParams);
            if (j > 99) {
                this.o.setText("99+");
            } else {
                this.o.setText(String.valueOf(j));
            }
            this.o.setVisibility(0);
            return;
        }
        this.o.setVisibility(8);
    }

    public void k() {
        if (TiebaApplication.aY()) {
            this.p.setVisibility(0);
        } else {
            this.p.setVisibility(8);
        }
    }

    private void l() {
        this.v = (RadioButton) findViewById(R.id.radio_home);
        this.w = (RadioButton) findViewById(R.id.radio_recommend);
        this.x = (RadioButton) findViewById(R.id.radio_person_info);
        this.y = (RadioButton) findViewById(R.id.radio_nearby);
        this.v.setOnCheckedChangeListener(this);
        this.w.setOnCheckedChangeListener(this);
        this.x.setOnCheckedChangeListener(this);
        this.y.setOnCheckedChangeListener(this);
    }

    public void b() {
        boolean ba = TiebaApplication.f().ba();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i = ((int) (displayMetrics.density * 15.0f)) + ((displayMetrics.widthPixels / 4) * 3);
        if (ba) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.q.getLayoutParams();
            layoutParams.rightMargin = i;
            this.q.setLayoutParams(layoutParams);
            this.q.setVisibility(0);
            return;
        }
        this.q.setVisibility(8);
    }

    public void a(int i) {
        if (i == 1) {
            this.u.setBackgroundResource(R.drawable.maintab_toolbar_bg_1);
            this.v.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_home_1), (Drawable) null, (Drawable) null);
            this.w.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_recommend_1), (Drawable) null, (Drawable) null);
            this.x.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_search_1), (Drawable) null, (Drawable) null);
            this.y.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_shake_1), (Drawable) null, (Drawable) null);
            com.baidu.tieba.util.ah.h((View) this.v, (int) R.drawable.tabs_btn_bg_1);
            com.baidu.tieba.util.ah.h((View) this.w, (int) R.drawable.tabs_btn_bg_1);
            com.baidu.tieba.util.ah.h((View) this.x, (int) R.drawable.tabs_btn_bg_1);
            com.baidu.tieba.util.ah.h((View) this.y, (int) R.drawable.tabs_btn_bg_1);
            return;
        }
        this.u.setBackgroundResource(R.drawable.maintab_toolbar_bg);
        this.v.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_home), (Drawable) null, (Drawable) null);
        this.w.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_recommend), (Drawable) null, (Drawable) null);
        this.x.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_search), (Drawable) null, (Drawable) null);
        this.y.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_shake), (Drawable) null, (Drawable) null);
        com.baidu.tieba.util.ah.h((View) this.v, (int) R.drawable.tabs_btn_bg);
        com.baidu.tieba.util.ah.h((View) this.w, (int) R.drawable.tabs_btn_bg);
        com.baidu.tieba.util.ah.h((View) this.x, (int) R.drawable.tabs_btn_bg);
        com.baidu.tieba.util.ah.h((View) this.y, (int) R.drawable.tabs_btn_bg);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            switch (compoundButton.getId()) {
                case R.id.radio_recommend /* 2131100324 */:
                    if (TiebaApplication.f().t()) {
                        StatService.onEvent(this, "maintab_enterforum", "maintabclick", 1);
                    }
                    this.d.setCurrentTabByTag("recommend_tab");
                    return;
                case R.id.radio_home /* 2131100325 */:
                    if (TiebaApplication.f().t()) {
                        StatService.onEvent(this, "maintab_home", "maintabclick", 1);
                    }
                    this.d.setCurrentTabByTag("home_tab");
                    return;
                case R.id.radio_nearby /* 2131100326 */:
                    if (TiebaApplication.f().t()) {
                        StatService.onEvent(this, "maintab_nearby", "maintabclick", 1);
                    }
                    if (TiebaApplication.f().bd() != this.D) {
                        this.D = TiebaApplication.f().bd();
                        a(this, "goto_KN", false);
                    }
                    this.d.setCurrentTabByTag("kb_tab");
                    return;
                case R.id.radio_person_info /* 2131100327 */:
                    if (TiebaApplication.f().t()) {
                        StatService.onEvent(this, "maintab_personal", "maintabclick", 1);
                    }
                    this.g.putExtra("un", TiebaApplication.E());
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
        TiebaApplication.f().aI();
        TiebaApplication.f().aJ();
        if (!TiebaApplication.n()) {
            if (c == null) {
                com.baidu.tieba.account.a.a().a(this, "goto_home");
            } else {
                com.baidu.tieba.account.a.a().a(this, c);
                c = null;
            }
        }
        if (TiebaApplication.f().au() != this.f822a) {
            this.f822a = TiebaApplication.f().au();
            a(this.f822a);
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
        TiebaApplication.f().aK();
        if (this.A != null) {
            this.A.dismiss();
        }
    }

    @Override // android.app.TabActivity, android.app.ActivityGroup, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("goto_type", this.j);
        bundle.putString("pb_id", "");
        bundle.putString("frs_name", "");
        bundle.putString("url", "");
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        com.baidu.tieba.util.aj.a(getClass().getName(), "onNewIntent", "");
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("close_dialog", false)) {
            m();
        }
        if (intent.getBooleanExtra("refresh_all", false)) {
            this.g.putExtra("un", TiebaApplication.E());
            this.d.setCurrentTab(0);
            this.d.clearAllTabs();
            getLocalActivityManager().removeAllActivities();
            a(intent);
        }
        String stringExtra = intent.getStringExtra("goto_type");
        this.j = stringExtra;
        if ("goto_recommend".equals(stringExtra)) {
            this.w.setChecked(true);
        } else if ("goto_nearby".equals(stringExtra)) {
            this.y.setChecked(true);
        } else if ("goto_person".equals(stringExtra)) {
            this.x.setChecked(true);
        } else if ("goto_home".equals(stringExtra)) {
            this.v.setChecked(true);
        } else if ("close".equals(stringExtra)) {
            finish();
        } else if ("goto_KN".equals(stringExtra)) {
            this.y.setChecked(true);
            Activity activity = getLocalActivityManager().getActivity("kb_tab");
            if (activity != null && (activity instanceof KnTabActivity)) {
                ((KnTabActivity) activity).b();
            }
        }
        a(this, TiebaApplication.d());
    }

    private void m() {
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
            com.baidu.tieba.util.aj.e(getClass().getName(), "dispatchKeyEvent", "KEYCODE_BACK");
            com.baidu.tieba.util.am.a((Activity) this);
            return false;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    private void a(Intent intent) {
        char c2;
        try {
            TabHost tabHost = this.d;
            String stringExtra = intent.getStringExtra("goto_type");
            if ("goto_recommend".equals(stringExtra)) {
                tabHost.addTab(a("recommend_tab", this.f));
                this.r = this.w;
                c2 = 1;
            } else if ("goto_person".equals(stringExtra)) {
                tabHost.addTab(a("person_info_tab", this.g));
                this.r = this.x;
                c2 = 2;
            } else if ("goto_KN".equals(stringExtra)) {
                c2 = 5;
                if (TiebaApplication.f().bd()) {
                    this.D = true;
                    n();
                    tabHost.addTab(a("kb_tab", this.i));
                } else {
                    this.D = false;
                    tabHost.addTab(a("kb_tab", this.h));
                }
                this.r = this.y;
            } else {
                tabHost.addTab(a("home_tab", this.e));
                this.r = this.v;
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
                if (TiebaApplication.f().bd()) {
                    this.D = true;
                    n();
                    tabHost.addTab(a("kb_tab", this.i));
                } else {
                    this.D = false;
                    tabHost.addTab(a("kb_tab", this.h));
                }
            }
            this.r.setChecked(true);
            TabWidget tabWidget = tabHost.getTabWidget();
            if (tabWidget != null) {
                int childCount = tabWidget.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    tabWidget.getChildAt(i).setFocusable(false);
                }
            }
        } catch (Throwable th) {
            finish();
        }
    }

    private void n() {
        this.i.putExtra("tag_title", TiebaApplication.f().be());
        this.i.putExtra("tag_url", TiebaApplication.f().bk());
        this.i.putExtra("tag_back", false);
        this.i.putExtra("tag_http_method", "get");
    }

    private TabHost.TabSpec a(String str, Intent intent) {
        TabHost.TabSpec newTabSpec = this.d.newTabSpec(str);
        newTabSpec.setContent(intent).setIndicator("", getResources().getDrawable(R.drawable.icon));
        return newTabSpec;
    }

    private void o() {
        NetWorkCore.NetworkState a2 = NetWorkCore.a(this);
        this.C = false;
        if (a2 != NetWorkCore.NetworkState.UNAVAIL) {
            if (a2 == NetWorkCore.NetworkState.WIFI) {
                this.C = true;
            }
            int aV = TiebaApplication.f().aV();
            if (aV == 0) {
                TiebaApplication.f().y(this.C);
            } else if (aV == 1) {
                TiebaApplication.f().y(true);
            } else if (aV == 2) {
                TiebaApplication.f().y(false);
            } else if (aV == -1) {
                if (this.z == null) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle(R.string.network_title);
                    builder.setMessage(R.string.flow_mode_set_tip);
                    ak akVar = new ak(this);
                    builder.setPositiveButton(getString(R.string.network_accept), akVar);
                    builder.setNegativeButton(getString(R.string.cancel), akVar);
                    this.z = builder.create();
                }
                this.z.setCancelable(false);
                this.z.setCanceledOnTouchOutside(false);
                this.z.show();
            }
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
