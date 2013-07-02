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
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.home.EnterForumActivity;
import com.baidu.tieba.hp.LayoutProxy;
import com.baidu.tieba.mention.MentionActivity;
import com.baidu.tieba.more.MoreActivity;
import com.baidu.tieba.nearby.NewNearbyActivity;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.person.PersonListActivity;
import com.baidu.tieba.recommend.NewHomeActivity;
import com.baidu.tieba.service.ClearTempService;
import com.baidu.tieba.service.TiebaActiveService;
import com.baidu.tieba.service.TiebaSyncService;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.view.GuidPageView;
import com.mofamulu.tieba.ch.bg;
import com.mofamulu.tieba.map.FreeNearbyActivity;
/* loaded from: classes.dex */
public class MainTabActivity extends TabActivity implements CompoundButton.OnCheckedChangeListener {
    private static boolean b = false;
    private static String c = null;
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
    private CompoundButton q = null;
    private Handler r = null;
    private ProgressDialog s = null;
    private FrameLayout t = null;
    private RadioButton u = null;
    private RadioButton v = null;
    private RadioButton w = null;
    private RadioButton x = null;
    private RadioButton y = null;
    private AlertDialog z = null;
    private AlertDialog A = null;
    private com.baidu.tieba.view.ab B = null;
    private GuidPageView C = null;
    protected int a = -1;
    private aj D = null;

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

    public static void a(Context context) {
        String D = TiebaApplication.D();
        if ((D != null && D.length() > 0) || TiebaApplication.f().at() >= 3) {
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
        TiebaApplication.f().y();
        a(context, str, false);
    }

    public static void b(Context context, String str, boolean z) {
        TiebaApplication.f().y();
        a(context, str, z);
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (b()) {
            CompatibleUtile.getInstance().openGpu(this);
        }
        com.baidu.tieba.util.z.a(getClass().toString(), "onCreate", "debug");
        setContentView(R.layout.maintabs_activity);
        this.d = getTabHost();
        this.e = new Intent(this, EnterForumActivity.class);
        this.f = new Intent(this, NewHomeActivity.class);
        this.g = new Intent(this, PersonInfoActivity.class);
        this.g.putExtra("self", true);
        this.g.putExtra("tab_page", true);
        this.g.putExtra("un", TiebaApplication.D());
        this.h = new Intent(this, MoreActivity.class);
        if (bg.c().S()) {
            this.i = new Intent(this, FreeNearbyActivity.class);
        } else {
            this.i = new Intent(this, NewNearbyActivity.class);
        }
        this.o = (TextView) findViewById(R.id.message_person);
        this.p = (ImageView) findViewById(R.id.new_version_logo);
        this.t = (FrameLayout) findViewById(R.id.bottom_container);
        CompatibleUtile.getInstance().closeViewGpu(this.d.getTabWidget());
        CompatibleUtile.getInstance().closeViewGpu(this.t);
        l();
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (bundle != null) {
            intent.putExtra("goto_type", bundle.getString("goto_type"));
        }
        a(intent);
        e();
        if (TiebaApplication.x() != null && TiebaApplication.x().equals("aishide")) {
            g();
        }
        i();
        d();
        TiebaApplication.f().aa();
        if (bundle == null) {
            o();
        }
        m();
        String K = TiebaApplication.f().K();
        if (K != null && K.length() > 0) {
            com.baidu.tieba.util.aa.b(TiebaApplication.f(), K);
            TiebaApplication.f().j((String) null);
        }
    }

    public boolean b() {
        return TiebaApplication.f().v();
    }

    private void d() {
        try {
            startService(new Intent(this, ClearTempService.class));
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onDestroy() {
        com.baidu.tieba.util.z.a(getClass().getName(), "onDestroy", "");
        f();
        h();
        j();
        TiebaApplication.f().aw();
        TiebaApplication.f().ab();
        TiebaApplication.f().ag();
        com.baidu.tbadk.a.e.a().c();
        if (this.s != null) {
            this.s.dismiss();
            this.s = null;
        }
        if (this.z != null) {
            this.z.dismiss();
            this.z = null;
        }
        if (this.r != null) {
            this.r.removeMessages(1);
        }
        if (this.C != null) {
            this.C.a();
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
        this.D = new aj(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(com.baidu.tieba.data.g.k);
        registerReceiver(this.D, intentFilter);
    }

    private void j() {
        if (this.D != null) {
            unregisterReceiver(this.D);
        }
    }

    public void c() {
        long a = this.k + this.l + this.m + this.n + LayoutProxy.a();
        if (a > 0) {
            int i = bg.c().H() ? 8 : 10;
            int a2 = (com.baidu.tieba.util.aa.a((Context) this) * (i - 3)) / i;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.o.getLayoutParams();
            layoutParams.leftMargin = a2;
            this.o.setLayoutParams(layoutParams);
            if (a > 99) {
                this.o.setText("99+");
            } else {
                this.o.setText(String.valueOf(a));
            }
            this.o.setVisibility(0);
            return;
        }
        this.o.setVisibility(8);
    }

    public void k() {
        if (TiebaApplication.aR()) {
            this.p.setVisibility(0);
        } else {
            this.p.setVisibility(8);
        }
    }

    private void l() {
        this.u = (RadioButton) findViewById(R.id.radio_home);
        this.v = (RadioButton) findViewById(R.id.radio_recommend);
        this.w = (RadioButton) findViewById(R.id.radio_person_info);
        this.x = (RadioButton) findViewById(R.id.radio_nearby);
        this.y = (RadioButton) findViewById(R.id.radio_more);
        this.u.setOnCheckedChangeListener(this);
        this.v.setOnCheckedChangeListener(this);
        this.w.setOnCheckedChangeListener(this);
        this.x.setOnCheckedChangeListener(this);
        this.y.setOnCheckedChangeListener(this);
        if (bg.c().H()) {
            this.v.setVisibility(8);
        }
    }

    public void a(int i) {
        if (i == 1) {
            this.t.setBackgroundResource(R.drawable.maintab_toolbar_bg_1);
            this.u.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_home_1), (Drawable) null, (Drawable) null);
            this.v.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_recommend_1), (Drawable) null, (Drawable) null);
            this.w.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_search_1), (Drawable) null, (Drawable) null);
            this.x.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_nearby_1), (Drawable) null, (Drawable) null);
            this.y.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_more_1), (Drawable) null, (Drawable) null);
            com.baidu.tieba.util.x.h((View) this.u, (int) R.drawable.tabs_btn_bg_1);
            com.baidu.tieba.util.x.h((View) this.v, (int) R.drawable.tabs_btn_bg_1);
            com.baidu.tieba.util.x.h((View) this.w, (int) R.drawable.tabs_btn_bg_1);
            com.baidu.tieba.util.x.h((View) this.x, (int) R.drawable.tabs_btn_bg_1);
            return;
        }
        this.t.setBackgroundResource(R.drawable.maintab_toolbar_bg);
        this.u.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_home), (Drawable) null, (Drawable) null);
        this.v.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_recommend), (Drawable) null, (Drawable) null);
        this.w.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_search), (Drawable) null, (Drawable) null);
        this.x.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_nearby), (Drawable) null, (Drawable) null);
        this.y.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.tabs_more), (Drawable) null, (Drawable) null);
        com.baidu.tieba.util.x.h((View) this.u, (int) R.drawable.tabs_btn_bg);
        com.baidu.tieba.util.x.h((View) this.v, (int) R.drawable.tabs_btn_bg);
        com.baidu.tieba.util.x.h((View) this.w, (int) R.drawable.tabs_btn_bg);
        com.baidu.tieba.util.x.h((View) this.x, (int) R.drawable.tabs_btn_bg);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            switch (compoundButton.getId()) {
                case R.id.radio_recommend /* 2131165759 */:
                    if (TiebaApplication.f().s()) {
                        StatService.onEvent(this, "maintab_enterforum", "maintabclick", 1);
                    }
                    this.d.setCurrentTabByTag("recommend_tab");
                    return;
                case R.id.radio_home /* 2131165760 */:
                    if (TiebaApplication.f().s()) {
                        StatService.onEvent(this, "maintab_home", "maintabclick", 1);
                    }
                    this.d.setCurrentTabByTag("home_tab");
                    return;
                case R.id.radio_nearby /* 2131165761 */:
                    if (TiebaApplication.f().s()) {
                        StatService.onEvent(this, "maintab_nearby", "maintabclick", 1);
                    }
                    this.d.setCurrentTabByTag("nearby_tab");
                    return;
                case R.id.radio_person_info /* 2131165762 */:
                    if (TiebaApplication.f().s()) {
                        StatService.onEvent(this, "maintab_personal", "maintabclick", 1);
                    }
                    this.g.putExtra("un", TiebaApplication.D());
                    this.d.setCurrentTabByTag("person_info_tab");
                    if (TiebaApplication.D() != null && TiebaApplication.D().length() > 0) {
                        a(R.drawable.tips_center_recentchat, 1);
                        return;
                    }
                    return;
                case R.id.radio_more /* 2131165763 */:
                    this.d.setCurrentTabByTag("more_tab");
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onResume() {
        super.onResume();
        TiebaApplication.f().aC();
        TiebaApplication.f().aD();
        if (!TiebaApplication.m()) {
            if (c == null) {
                com.baidu.tieba.account.a.a().a(this, "goto_home");
            } else {
                com.baidu.tieba.account.a.a().a(this, c);
                c = null;
            }
        }
        if (TiebaApplication.f().as() != this.a) {
            this.a = TiebaApplication.f().as();
            a(this.a);
        }
    }

    private void m() {
        if (TiebaApplication.d() != null) {
            switch (TiebaApplication.d().getExtras().getInt("class", -1)) {
                case 0:
                    com.baidu.tieba.util.aa.c(this, TiebaApplication.d().getExtras().getString("url"));
                    break;
                case 1:
                    if (TiebaApplication.d().getBooleanExtra("is_message_pv", false)) {
                        NewPbActivity.a(this, TiebaApplication.d().getStringExtra("id"), null, TiebaApplication.d().getStringExtra("from"), TiebaApplication.d().getLongExtra("message_id", 0L));
                        break;
                    } else {
                        NewPbActivity.a(this, TiebaApplication.d().getStringExtra("id"), null, TiebaApplication.d().getStringExtra("from"));
                        break;
                    }
                case 2:
                    FrsActivity.a(this, TiebaApplication.d().getStringExtra("fname"), TiebaApplication.d().getStringExtra("from"));
                    break;
                case 3:
                    TiebaApplication.d().setClass(this, MainTabActivity.class);
                    startActivity(TiebaApplication.d());
                    break;
                case 5:
                    long longExtra = TiebaApplication.d().getLongExtra("at_me", 0L);
                    long longExtra2 = TiebaApplication.d().getLongExtra("reply_me", 0L);
                    long longExtra3 = TiebaApplication.d().getLongExtra("fans", 0L);
                    long longExtra4 = TiebaApplication.d().getLongExtra("chat", 0L);
                    TiebaApplication.f().b(longExtra2, longExtra, longExtra3, longExtra4);
                    if ((longExtra2 > 0 || longExtra > 0) && longExtra3 == 0 && longExtra4 == 0) {
                        startActivity(new Intent(this, MentionActivity.class));
                        break;
                    } else if (longExtra3 > 0 && longExtra2 == 0 && longExtra == 0 && longExtra4 == 0) {
                        Intent intent = new Intent(this, PersonListActivity.class);
                        intent.putExtra("follow", false);
                        intent.putExtra("un", TiebaApplication.D());
                        startActivity(intent);
                        break;
                    } else if (longExtra4 > 0 && longExtra3 == 0 && longExtra2 == 0 && longExtra == 0) {
                        startActivity(new Intent(this, ChatListActivity.class));
                        break;
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("goto_type", "goto_person");
                        a(intent2);
                        break;
                    }
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
        TiebaApplication.f().aE();
        if (this.B != null) {
            this.B.dismiss();
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
        com.baidu.tieba.util.z.a(getClass().getName(), "onNewIntent", "");
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("close_dialog", false)) {
            n();
        }
        if (intent.getBooleanExtra("refresh_all", false)) {
            this.g.putExtra("un", TiebaApplication.D());
            this.d.setCurrentTab(0);
            this.d.clearAllTabs();
            getLocalActivityManager().removeAllActivities();
            a(intent);
        }
        String stringExtra = intent.getStringExtra("goto_type");
        this.j = stringExtra;
        if ("goto_recommend".equals(stringExtra)) {
            this.v.setChecked(true);
        } else if ("goto_nearby".equals(stringExtra)) {
            this.x.setChecked(true);
        } else if ("goto_person".equals(stringExtra)) {
            this.w.setChecked(true);
        } else if ("goto_more".equals(stringExtra)) {
            this.y.setChecked(true);
        } else if ("goto_home".equals(stringExtra)) {
            this.u.setChecked(true);
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
            com.baidu.tieba.util.z.e(getClass().getName(), "dispatchKeyEvent", "KEYCODE_BACK");
            com.baidu.tieba.util.aa.a((Activity) this);
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
                if (intent.getBooleanExtra("is_message_pv", false)) {
                    NewHomeActivity.a(true);
                    NewHomeActivity.a(intent.getLongExtra("message_id", 0L));
                }
                tabHost.addTab(a("recommend_tab", this.f));
                this.q = this.v;
                c2 = 1;
            } else if ("goto_person".equals(stringExtra)) {
                tabHost.addTab(a("person_info_tab", this.g));
                this.q = this.w;
                c2 = 2;
            } else if ("goto_more".equals(stringExtra)) {
                tabHost.addTab(a("more_tab", this.h));
                this.q = this.y;
                c2 = 4;
            } else if ("goto_nearby".equals(stringExtra)) {
                c2 = 5;
                tabHost.addTab(a("nearby_tab", this.i));
                this.q = this.x;
            } else {
                tabHost.addTab(a("home_tab", this.e));
                this.q = this.u;
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
                tabHost.addTab(a("nearby_tab", this.i));
            }
            if (c2 != 4) {
                tabHost.addTab(a("more_tab", this.h));
            }
            this.q.setChecked(true);
            TabWidget tabWidget = tabHost.getTabWidget();
            if (tabWidget != null) {
                int childCount = tabWidget.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    tabWidget.getChildAt(i).setFocusable(false);
                }
            }
        } catch (Exception e) {
            finish();
        }
    }

    private TabHost.TabSpec a(String str, Intent intent) {
        TabHost.TabSpec newTabSpec = this.d.newTabSpec(str);
        newTabSpec.setContent(intent).setIndicator("", getResources().getDrawable(R.drawable.icon));
        return newTabSpec;
    }

    private void o() {
        NetWorkCore.NetworkState a = NetWorkCore.a(this);
        if (a != NetWorkCore.NetworkState.UNAVAIL) {
            if (a == NetWorkCore.NetworkState.WIFI) {
                int t = TiebaApplication.f().t(true);
                if (t != 0) {
                    if (t == 1) {
                        a(true);
                        return;
                    } else if ((TiebaApplication.f().ao() && TiebaApplication.f().an() != 1) || TiebaApplication.f().am() != 1) {
                        if (this.z == null) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(this);
                            builder.setTitle(R.string.network_title);
                            builder.setMessage(R.string.network_wifi);
                            ah ahVar = new ah(this);
                            builder.setPositiveButton(getString(R.string.cancel), ahVar);
                            builder.setNegativeButton(getString(R.string.network_accept), ahVar);
                            this.z = builder.create();
                        }
                        this.z.setCancelable(false);
                        this.z.setCanceledOnTouchOutside(false);
                        this.z.show();
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            int t2 = TiebaApplication.f().t(false);
            if (t2 != 0) {
                if (t2 == 1) {
                    a(false);
                } else if ((TiebaApplication.f().ao() && TiebaApplication.f().an() != 2) || TiebaApplication.f().am() == 1) {
                    if (this.A == null) {
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                        builder2.setTitle(R.string.network_title);
                        builder2.setMessage(R.string.network_not_wifi);
                        ai aiVar = new ai(this);
                        builder2.setPositiveButton(getString(R.string.cancel), aiVar);
                        builder2.setNegativeButton(getString(R.string.network_accept), aiVar);
                        this.A = builder2.create();
                    }
                    this.A.setCancelable(false);
                    this.A.setCanceledOnTouchOutside(false);
                    this.A.show();
                }
            }
        }
    }

    public void a(boolean z) {
        if (z) {
            if (TiebaApplication.f().ao()) {
                TiebaApplication.f().h(1);
            }
            TiebaApplication.f().g(1);
            return;
        }
        if (TiebaApplication.f().ao()) {
            TiebaApplication.f().h(2);
        }
        if (TiebaApplication.f().am() == 1) {
            TiebaApplication.f().g(2);
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

    protected void a(int i, int i2) {
        Bitmap b2;
        if (!TiebaApplication.f().b(i2)) {
            this.C = (GuidPageView) getLayoutInflater().inflate(R.layout.guid_page, (ViewGroup) null);
            if (this.C != null && (b2 = com.baidu.tieba.util.d.b(this, i)) != null) {
                this.C.setBackgroundDrawable(new BitmapDrawable(b2));
                addContentView(this.C, new FrameLayout.LayoutParams(-1, -1));
                TiebaApplication.f().c(i2);
            }
        } else if (this.C != null) {
            this.C.setVisibility(8);
        }
    }
}
