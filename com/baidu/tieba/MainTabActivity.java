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
import android.view.Menu;
import android.view.MenuItem;
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
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.forumfeed.ForumFeedActivity;
import com.baidu.tieba.home.EnterForumActivity;
import com.baidu.tieba.mention.MentionActivity;
import com.baidu.tieba.more.AboutActivity;
import com.baidu.tieba.more.AccountActivity;
import com.baidu.tieba.more.MoreActivity;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.service.ClearTempService;
import com.baidu.tieba.service.TiebaActiveService;
import com.baidu.tieba.service.TiebaSyncService;
import com.baidu.tieba.square.SquareActivity;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.GuidPageView;
import com.baidu.tieba.write.WriteActivity;
import com.slidingmenu.lib.R;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class MainTabActivity extends TabActivity implements CompoundButton.OnCheckedChangeListener {
    private static boolean b = false;
    private static int c = -1;
    private ab[] f;
    private TabHost g;
    private final int d = 5;
    private int e = 1;
    private long h = 0;
    private long i = 0;
    private long j = 0;
    private long k = 0;
    private long l = 0;
    private TextView m = null;
    private TextView n = null;
    private ImageView o = null;
    private ImageView p = null;
    private ImageView q = null;
    private Handler r = new Handler();
    private ProgressDialog s = null;
    private FrameLayout t = null;
    private AlertDialog u = null;
    private com.baidu.tieba.view.am v = null;
    private GuidPageView w = null;
    private boolean x = false;

    /* renamed from: a */
    protected int f856a = -1;
    private ac y = null;

    protected void a() {
        this.f = new ab[5];
        ab abVar = new ab(null);
        abVar.b = new Intent(this, ForumFeedActivity.class);
        abVar.e = R.drawable.tabs_recommend;
        abVar.f = R.drawable.tabs_recommend_1;
        abVar.d = "maintab_home";
        abVar.f875a = "view_1";
        abVar.c = (RadioButton) findViewById(R.id.radio_recommend);
        this.f[0] = abVar;
        ab abVar2 = new ab(null);
        abVar2.b = new Intent(this, EnterForumActivity.class);
        abVar2.e = R.drawable.tabs_home;
        abVar2.f = R.drawable.tabs_home_1;
        abVar2.d = "maintab_enterforum";
        abVar2.f875a = "view_2";
        abVar2.c = (RadioButton) findViewById(R.id.radio_home);
        this.f[1] = abVar2;
        ab abVar3 = new ab(null);
        abVar3.b = new Intent(this, SquareActivity.class);
        abVar3.e = R.drawable.tabs_square;
        abVar3.f = R.drawable.tabs_square_1;
        abVar3.d = "maintab_square";
        abVar3.f875a = "view_3";
        abVar3.c = (RadioButton) findViewById(R.id.radio_square);
        this.f[2] = abVar3;
        ab abVar4 = new ab(null);
        abVar4.b = new Intent(this, MentionActivity.class);
        abVar4.e = R.drawable.tabs_message;
        abVar4.f = R.drawable.tabs_message_1;
        abVar4.d = "maintab_message";
        abVar4.f875a = "view_4";
        abVar4.c = (RadioButton) findViewById(R.id.radio_message);
        this.f[3] = abVar4;
        ab abVar5 = new ab(null);
        abVar5.b = new Intent(this, PersonInfoActivity.class);
        abVar5.b.putExtra("self", true);
        abVar5.b.putExtra("tab_page", true);
        abVar5.b.putExtra("un", TiebaApplication.C());
        abVar5.e = R.drawable.tabs_search;
        abVar5.f = R.drawable.tabs_search_1;
        abVar5.d = "maintab_personal";
        abVar5.f875a = "view_5";
        abVar5.c = (RadioButton) findViewById(R.id.radio_person_info);
        this.f[4] = abVar5;
    }

    protected void a(ab abVar, int i) {
        if (i == 4) {
            abVar.b.putExtra("un", TiebaApplication.C());
        } else if (i == 3) {
            MentionActivity.e = true;
            l();
        }
        this.g.setCurrentTabByTag(abVar.f875a);
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (b()) {
            CompatibleUtile.getInstance().openGpu(this);
        }
        com.baidu.tieba.util.av.a(getClass().toString(), "onCreate", "debug");
        setContentView(R.layout.maintabs_activity);
        this.g = getTabHost();
        a();
        TiebaApplication.g().a((Boolean) false);
        this.n = (TextView) findViewById(R.id.message_message);
        this.m = (TextView) findViewById(R.id.message_person);
        this.o = (ImageView) findViewById(R.id.new_version_logo);
        this.p = (ImageView) findViewById(R.id.new_recommends_logo);
        this.q = (ImageView) findViewById(R.id.new_bookmark_logo);
        c();
        this.t = (FrameLayout) findViewById(R.id.bottom_container);
        n();
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (bundle != null) {
            intent.putExtra("locate_type", bundle.getInt("locate_type", this.e));
        }
        a(intent);
        f();
        if (TiebaApplication.y() != null && TiebaApplication.y().equals("aishide")) {
            h();
        }
        j();
        e();
        com.baidu.tieba.mention.s.a().f();
        a(this, TiebaApplication.e());
        String K = TiebaApplication.g().K();
        if (K != null && K.length() > 0) {
            UtilHelper.b(TiebaApplication.g(), K);
            TiebaApplication.g().l((String) null);
        }
    }

    public static void a(int i) {
        c = i;
    }

    public static void a(Context context, int i) {
        Intent intent = new Intent(context, MainTabActivity.class);
        intent.setFlags(603979776);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (i >= 0) {
            intent.putExtra("locate_type", i);
        }
        intent.putExtra("close_dialog", true);
        context.startActivity(intent);
    }

    public static void a(Context context) {
        String C = TiebaApplication.C();
        if (C != null && C.length() > 0) {
            a(context, 1);
        } else {
            a(context, 2);
        }
    }

    public static void a(Context context, int i, boolean z) {
        Intent intent = new Intent(context, MainTabActivity.class);
        intent.setFlags(603979776);
        intent.putExtra("refresh_all", true);
        if (i >= 0) {
            intent.putExtra("locate_type", i);
        }
        if (z) {
            intent.addFlags(268435456);
        }
        intent.putExtra("close_dialog", true);
        context.startActivity(intent);
    }

    public static void b(Context context, int i) {
        TiebaApplication.g().z();
        a(context, i, false);
    }

    public static void b(Context context, int i, boolean z) {
        TiebaApplication.g().z();
        a(context, i, z);
    }

    public boolean b() {
        return TiebaApplication.g().u();
    }

    private void e() {
        try {
            startService(new Intent(this, ClearTempService.class));
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onDestroy() {
        com.baidu.tieba.util.av.a(getClass().getName(), "onDestroy", "");
        g();
        i();
        k();
        com.baidu.tieba.mention.s.a().e();
        com.baidu.tieba.mention.s.a().h();
        com.baidu.tieba.mention.s.a().a(false);
        com.baidu.tbadk.a.e.a().c();
        if (this.s != null) {
            this.s.dismiss();
            this.s = null;
        }
        if (this.u != null) {
            this.u.dismiss();
            this.u = null;
        }
        if (this.r != null) {
            this.r.removeMessages(1);
        }
        if (this.w != null) {
            this.w.a();
        }
        com.baidu.tieba.util.aw.a();
        super.onDestroy();
        System.gc();
    }

    @Override // android.app.TabActivity, android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        try {
            super.onRestoreInstanceState(bundle);
        } catch (Throwable th) {
            com.baidu.adp.lib.f.d.a(getClass(), "onRestoreInstanceState", th);
        }
    }

    private void f() {
        startService(new Intent(this, TiebaSyncService.class));
    }

    private void g() {
        stopService(new Intent(this, TiebaSyncService.class));
    }

    private void h() {
        startService(new Intent(this, TiebaActiveService.class));
    }

    private void i() {
        stopService(new Intent(this, TiebaActiveService.class));
    }

    private void a(Context context, Intent intent) {
        UtilHelper.a(context, intent);
        TiebaApplication.a((Intent) null);
    }

    private void j() {
        this.y = new ac(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.notify");
        intentFilter.addAction("com.baidu.tieba.broadcast.newrecommends");
        registerReceiver(this.y, intentFilter);
    }

    private void k() {
        if (this.y != null) {
            unregisterReceiver(this.y);
        }
    }

    public void l() {
        long j = this.h + this.i + this.k;
        long j2 = this.j;
        long j3 = this.l;
        if (j > 0) {
            a(((UtilHelper.a((Context) this) * 7) / 10) + 5, this.n, j);
        } else {
            this.n.setVisibility(8);
        }
        if (j2 > 0) {
            a(((UtilHelper.a((Context) this) * 9) / 10) + 5, this.m, j2);
            this.q.setVisibility(8);
        } else if (j3 > 0 && !TiebaApplication.g().d().booleanValue()) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.q.getLayoutParams();
            layoutParams.leftMargin = ((UtilHelper.a((Context) this) * 9) / 10) + 9;
            this.q.setLayoutParams(layoutParams);
            this.q.setVisibility(0);
            this.m.setVisibility(8);
        } else {
            this.q.setVisibility(8);
            this.m.setVisibility(8);
        }
    }

    private void a(int i, TextView textView, long j) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.leftMargin = i;
        textView.setLayoutParams(layoutParams);
        a(textView, j);
        textView.setVisibility(0);
    }

    private void a(TextView textView, long j) {
        boolean z = this.f856a == 1;
        textView.setTextColor(getResources().getColor(z ? R.color.top_msg_num_night : R.color.top_msg_num_day));
        if (j < 10) {
            textView.setText(String.valueOf(j));
            textView.setBackgroundResource(z ? R.drawable.icon_news_prompt_1 : R.drawable.icon_news_prompt);
        } else if (j < 100) {
            textView.setText(String.valueOf(j));
            textView.setBackgroundResource(z ? R.drawable.icon_news_head_prompt_1 : R.drawable.icon_news_head_prompt);
        } else {
            textView.setText("   ");
            textView.setBackgroundResource(z ? R.drawable.icon_news_head_prompt_more_1 : R.drawable.icon_news_head_prompt_more);
        }
    }

    public void m() {
        if (TiebaApplication.aM()) {
            this.o.setVisibility(0);
        } else {
            this.o.setVisibility(8);
        }
    }

    private void n() {
        for (ab abVar : this.f) {
            abVar.c.setOnCheckedChangeListener(this);
        }
    }

    public void c() {
        this.p.setVisibility(8);
    }

    public void b(int i) {
        int i2 = 0;
        if (i == 1) {
            this.t.setBackgroundResource(R.drawable.maintab_toolbar_bg_1);
            this.q.setImageResource(R.drawable.icon_maintab_prompt_1);
            ab[] abVarArr = this.f;
            int length = abVarArr.length;
            while (i2 < length) {
                ab abVar = abVarArr[i2];
                com.baidu.tieba.util.as.e((View) abVar.c, (int) R.drawable.tabs_btn_bg_1);
                abVar.c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(abVar.f), (Drawable) null, (Drawable) null);
                abVar.c.setTextColor(getResources().getColor(R.color.main_tab_text_1));
                i2++;
            }
            return;
        }
        this.t.setBackgroundResource(R.drawable.maintab_toolbar_bg);
        this.q.setImageResource(R.drawable.icon_maintab_prompt);
        ab[] abVarArr2 = this.f;
        int length2 = abVarArr2.length;
        while (i2 < length2) {
            ab abVar2 = abVarArr2[i2];
            com.baidu.tieba.util.as.e((View) abVar2.c, (int) R.drawable.tabs_btn_bg);
            abVar2.c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(abVar2.e), (Drawable) null, (Drawable) null);
            abVar2.c.setTextColor(getResources().getColor(R.color.white));
            i2++;
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            for (int i = 0; i < this.f.length; i++) {
                ab abVar = this.f[i];
                if (abVar.c.getId() == compoundButton.getId()) {
                    if (TiebaApplication.g().s()) {
                        StatService.onEvent(this, abVar.d, "maintabclick", 1);
                    }
                    a(abVar, i);
                    return;
                }
            }
        }
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onResume() {
        super.onResume();
        com.baidu.tieba.util.av.e("MainTabActivity", "onResume", "onResume");
        TiebaApplication.g().az();
        TiebaApplication.g().aA();
        com.baidu.tbadk.a.e.a().c();
        if (!TiebaApplication.n()) {
            if (c == -1) {
                com.baidu.tieba.account.a.a().a(this, 1);
            } else {
                com.baidu.tieba.account.a.a().a(this, c);
                c = -1;
            }
        }
        if (TiebaApplication.g().ap() != this.f856a) {
            this.f856a = TiebaApplication.g().ap();
            b(this.f856a);
        }
        if (TiebaApplication.C() == null || TiebaApplication.C().length() <= 0) {
            o();
        }
        l();
    }

    private void o() {
        this.h = 0L;
        this.i = 0L;
        this.j = 0L;
        this.k = 0L;
        this.l = 0L;
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onPause() {
        super.onPause();
        LogoActivity.a(false);
        if (b) {
            b = false;
            CompatibleUtile.setAnim(this, R.anim.down, R.anim.hold);
        }
        TiebaApplication.g().aB();
        if (this.v != null) {
            this.v.dismiss();
        }
    }

    @Override // android.app.TabActivity, android.app.ActivityGroup, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("locate_type", this.e);
        bundle.putString("pb_id", "");
        bundle.putString("frs_name", "");
        bundle.putString("url", "");
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        com.baidu.tieba.util.av.a(getClass().getName(), "onNewIntent", "");
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("close_dialog", false)) {
            p();
        }
        if (intent.getBooleanExtra("refresh_all", false)) {
            this.f[4].b.putExtra("un", TiebaApplication.C());
            this.g.clearAllTabs();
            getLocalActivityManager().removeAllActivities();
            a(intent);
        }
        int intExtra = intent.getIntExtra("locate_type", this.e);
        this.e = intExtra;
        if (intExtra == 200) {
            finish();
        } else if (intExtra >= 0 && intExtra < this.f.length) {
            this.f[intExtra].c.setChecked(true);
        }
        a(this, TiebaApplication.e());
    }

    private void p() {
        EnterForumActivity enterForumActivity;
        LocalActivityManager localActivityManager = getLocalActivityManager();
        if (!localActivityManager.getCurrentId().equals(this.f[1].f875a) && (enterForumActivity = (EnterForumActivity) localActivityManager.getActivity(this.f[1].f875a)) != null) {
            enterForumActivity.b();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            com.baidu.tieba.util.av.e(getClass().getName(), "dispatchKeyEvent", "KEYCODE_BACK");
            UtilHelper.a((Activity) this);
            return false;
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            openOptionsMenu();
            return true;
        } else {
            return super.dispatchKeyEvent(keyEvent);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0034 A[Catch: Throwable -> 0x0071, TryCatch #0 {Throwable -> 0x0071, blocks: (B:56:0x0001, B:58:0x000b, B:61:0x0011, B:63:0x0016, B:65:0x0023, B:67:0x002d, B:70:0x0034, B:72:0x0038, B:88:0x009f, B:73:0x003e, B:75:0x0057, B:77:0x005e, B:84:0x0076, B:86:0x007e, B:87:0x0082, B:80:0x006d), top: B:92:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0057 A[Catch: Throwable -> 0x0071, TryCatch #0 {Throwable -> 0x0071, blocks: (B:56:0x0001, B:58:0x000b, B:61:0x0011, B:63:0x0016, B:65:0x0023, B:67:0x002d, B:70:0x0034, B:72:0x0038, B:88:0x009f, B:73:0x003e, B:75:0x0057, B:77:0x005e, B:84:0x0076, B:86:0x007e, B:87:0x0082, B:80:0x006d), top: B:92:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0076 A[Catch: Throwable -> 0x0071, TRY_ENTER, TryCatch #0 {Throwable -> 0x0071, blocks: (B:56:0x0001, B:58:0x000b, B:61:0x0011, B:63:0x0016, B:65:0x0023, B:67:0x002d, B:70:0x0034, B:72:0x0038, B:88:0x009f, B:73:0x003e, B:75:0x0057, B:77:0x005e, B:84:0x0076, B:86:0x007e, B:87:0x0082, B:80:0x006d), top: B:92:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Intent intent) {
        Field field;
        Exception e;
        int i;
        TabWidget tabWidget;
        try {
            int intExtra = intent.getIntExtra("locate_type", this.e);
            if (intExtra >= 0 && intExtra < this.f.length) {
                this.e = intExtra;
                TabHost tabHost = this.g;
                try {
                    field = this.g.getClass().getDeclaredField("mCurrentTab");
                } catch (Exception e2) {
                    field = null;
                    e = e2;
                }
                try {
                    field.setAccessible(true);
                    field.setInt(this.g, -2);
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    while (i < this.f.length) {
                    }
                    if (field != null) {
                    }
                    this.f[this.e].c.setChecked(true);
                    this.g.setCurrentTab(this.e);
                    tabWidget = tabHost.getTabWidget();
                    if (tabWidget == null) {
                    }
                }
                for (i = 0; i < this.f.length; i++) {
                    Intent intent2 = this.f[i].b;
                    if (intent2 == null) {
                        intent2 = c(i);
                    }
                    this.f[i].b = intent2;
                    tabHost.addTab(a(this.f[i].f875a, this.f[i].b));
                }
                if (field != null) {
                    if (this.e == 0) {
                        field.setInt(this.g, 1);
                    } else {
                        field.setInt(this.g, 0);
                    }
                }
                this.f[this.e].c.setChecked(true);
                this.g.setCurrentTab(this.e);
                tabWidget = tabHost.getTabWidget();
                if (tabWidget == null) {
                    int childCount = tabWidget.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        tabWidget.getChildAt(i2).setFocusable(false);
                    }
                }
            }
        } catch (Throwable th) {
            finish();
        }
    }

    private Intent c(int i) {
        switch (i) {
            case 0:
                return new Intent(this, ForumFeedActivity.class);
            case 1:
                return new Intent(this, EnterForumActivity.class);
            case 2:
                return new Intent(this, SquareActivity.class);
            case 3:
                return new Intent(this, MentionActivity.class);
            case 4:
                return new Intent(this, PersonInfoActivity.class);
            default:
                return null;
        }
    }

    private TabHost.TabSpec a(String str, Intent intent) {
        TabHost.TabSpec newTabSpec = this.g.newTabSpec(str);
        newTabSpec.setContent(intent).setIndicator("", getResources().getDrawable(R.drawable.icon));
        return newTabSpec;
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

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        try {
            menu.findItem(1).setVisible(true);
            if (!TiebaApplication.n()) {
                menu.findItem(2).setVisible(true);
            }
            menu.findItem(3).setVisible(true);
            menu.findItem(4).setVisible(true);
            menu.findItem(5).setVisible(true);
        } catch (Exception e) {
            com.baidu.tieba.util.av.b("HomeActivity", "onPrepareOptionsMenu", "exp: " + e.toString());
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 1, getString(R.string.setup)).setIcon(R.drawable.menu_setup);
        if (!TiebaApplication.n()) {
            menu.add(0, 2, 2, getString(R.string.account)).setIcon(R.drawable.menu_account);
        }
        menu.add(0, 3, 3, getString(R.string.feedback)).setIcon(R.drawable.menu_feedback);
        menu.add(0, 4, 4, getString(R.string.version_info)).setIcon(R.drawable.menu_about);
        menu.add(0, 5, 5, getString(R.string.quit)).setIcon(R.drawable.menu_quit);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
                MoreActivity.a(this);
                break;
            case 2:
                AccountActivity.a(this);
                break;
            case 3:
                if (!TiebaApplication.D()) {
                    LoginActivity.a((Activity) this, getString(R.string.login_feedback), true, 11001);
                    break;
                } else {
                    d();
                    break;
                }
            case 4:
                AboutActivity.a((Context) this);
                break;
            case 5:
                UtilHelper.a((Activity) this);
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    protected void d() {
        AntiData antiData = new AntiData();
        antiData.setIfpost(1);
        WriteActivity.a(this, com.baidu.tieba.data.g.h(), com.baidu.tieba.data.g.g(), antiData);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 11001) {
                d();
            } else {
                super.onActivityResult(i, i2, intent);
            }
        }
    }
}
