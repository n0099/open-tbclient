package com.baidu.tieba;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.browser.core.util.BdLog;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.forumfeed.HomeActivity;
import com.baidu.tieba.group.GroupActivity;
import com.baidu.tieba.home.EnterForumActivity;
import com.baidu.tieba.mention.MentionActivity;
import com.baidu.tieba.more.AboutActivity;
import com.baidu.tieba.more.AccountActivity;
import com.baidu.tieba.more.MoreActivity;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.service.ClearTempService;
import com.baidu.tieba.service.FatalErrorService;
import com.baidu.tieba.service.TiebaActiveService;
import com.baidu.tieba.service.TiebaSyncService;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.voice.VoiceManager;
import com.baidu.tieba.write.WriteActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class MainTabActivity extends BaseFragmentActivity implements com.baidu.tieba.voice.af {
    private static boolean c = false;
    private static int d = -1;
    private VoiceManager w;
    private FragmentTabHost x;
    private long e = 0;
    private long f = 0;
    private long g = 0;
    private long h = 0;
    private long i = 0;
    private TextView j = null;
    private TextView k = null;
    private ImageView l = null;
    private ImageView m = null;
    private Handler n = new Handler();
    private ProgressDialog o = null;
    private AlertDialog p = null;
    private com.baidu.tieba.view.an q = null;
    private com.baidu.tieba.view.ah r = null;
    private long s = 0;
    private long t = 0;
    private long u = 2000;
    private long v = 7200000;
    protected int b = -1;
    private ao y = null;

    private void a(Fragment fragment, int i, int i2, int i3) {
        x xVar = new x();
        xVar.b = fragment;
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) getLayoutInflater().inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i3);
        fragmentTabIndicator.f1008a = i;
        fragmentTabIndicator.b = i2;
        fragmentTabIndicator.d = R.drawable.tabs_btn_bg_1;
        fragmentTabIndicator.c = R.drawable.tabs_btn_bg;
        fragmentTabIndicator.f = R.color.main_bottom_button_color_1;
        fragmentTabIndicator.e = R.color.main_bottom_button_color;
        fragmentTabIndicator.a(TiebaApplication.h().an());
        xVar.f2828a = fragmentTabIndicator;
        this.x.a(xVar);
    }

    protected void c() {
        a(new HomeActivity(), R.drawable.tabs_recommend, R.drawable.tabs_recommend_1, R.string.homepage);
        a(new EnterForumActivity(), R.drawable.tabs_home, R.drawable.tabs_home_1, R.string.home);
        a(new GroupActivity(), R.drawable.tabs_groups, R.drawable.tabs_groups_1, R.string.groups);
        a(new MentionActivity(), R.drawable.tabs_message, R.drawable.tabs_message_1, R.string.remind);
        MentionActivity.b = true;
        PersonInfoActivity personInfoActivity = new PersonInfoActivity();
        Bundle bundle = new Bundle();
        bundle.putBoolean("self", true);
        bundle.putBoolean("tab_page", true);
        bundle.putString("un", TiebaApplication.B());
        personInfoActivity.g(bundle);
        a(personInfoActivity, R.drawable.tabs_search, R.drawable.tabs_search_1, R.string.person_info);
        g();
    }

    private void g() {
        FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(R.layout.maintabs_tips, (ViewGroup) null);
        this.k = (TextView) frameLayout.findViewById(R.id.message_message);
        this.j = (TextView) frameLayout.findViewById(R.id.message_person);
        this.l = (ImageView) frameLayout.findViewById(R.id.new_version_logo);
        this.m = (ImageView) frameLayout.findViewById(R.id.new_bookmark_logo);
        frameLayout.removeAllViews();
        this.x.a(this.k);
        this.x.a(this.j);
        this.x.a(this.l);
        this.x.a(this.m);
    }

    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (d()) {
            CompatibleUtile.getInstance().openGpu(this);
        }
        com.baidu.tieba.util.bd.a(getClass().toString(), "onCreate", "debug");
        setContentView(R.layout.maintabs_activity);
        this.x = (FragmentTabHost) findViewById(R.id.tab_host);
        this.x.setup(getSupportFragmentManager());
        this.x.setTabWidgetBackgroundColor(getResources().getColor(R.color.maintab_bg));
        c();
        TiebaApplication.h().a((Boolean) false);
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (bundle != null) {
            intent.putExtra("locate_type", bundle.getInt("locate_type", 1));
        }
        a(intent);
        j();
        if (TiebaApplication.z() != null && TiebaApplication.z().equals("aishide")) {
            l();
        }
        n();
        i();
        com.baidu.tieba.mention.t.a().i();
        a(this, TiebaApplication.e());
        String I = TiebaApplication.h().I();
        if (I != null && I.length() > 0) {
            UtilHelper.a(TiebaApplication.h(), I);
            TiebaApplication.h().m((String) null);
        }
        this.w = d_();
        this.w.a((Activity) this);
        com.baidu.tieba.log.a.c();
    }

    @Override // android.support.v4.app.n, android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.w != null) {
            this.w.b((Activity) this);
        }
        com.baidu.tieba.mention.t.a().i();
    }

    public static void c(int i) {
        d = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        a(1.0f);
        if (this.q != null) {
            this.q.a(null);
        }
    }

    private void a(float f) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = f;
        getWindow().setAttributes(attributes);
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
        String B = TiebaApplication.B();
        if (B != null && B.length() > 0) {
            a(context, 1);
        } else {
            a(context, 0);
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
        TiebaApplication.h().A();
        a(context, i, false);
    }

    public static void b(Context context, int i, boolean z) {
        TiebaApplication.h().A();
        a(context, i, z);
    }

    public boolean d() {
        return TiebaApplication.h().v();
    }

    private void i() {
        try {
            startService(new Intent(this, ClearTempService.class));
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity
    protected void onDestroy() {
        com.baidu.tieba.util.bd.a(getClass().getName(), "onDestroy", "");
        k();
        m();
        o();
        com.baidu.tieba.mention.t.a().g();
        com.baidu.tieba.mention.t.a().k();
        com.baidu.tieba.mention.t.a().a(false);
        com.baidu.tbadk.imageManager.d.a().c();
        if (this.o != null) {
            this.o.dismiss();
            this.o = null;
        }
        if (this.p != null) {
            this.p.dismiss();
            this.p = null;
        }
        if (this.n != null) {
            this.n.removeMessages(1);
        }
        if (this.r != null) {
            this.r.a();
        }
        com.baidu.tieba.util.be.a();
        if (this.w != null) {
            this.w.g(this);
        }
        super.onDestroy();
        System.gc();
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        try {
            super.onRestoreInstanceState(bundle);
        } catch (Throwable th) {
            com.baidu.adp.lib.h.e.a(getClass(), "onRestoreInstanceState", th);
        }
    }

    private void j() {
        startService(new Intent(this, TiebaSyncService.class));
    }

    private void k() {
        stopService(new Intent(this, TiebaSyncService.class));
    }

    private void l() {
        startService(new Intent(this, TiebaActiveService.class));
    }

    private void m() {
        stopService(new Intent(this, TiebaActiveService.class));
    }

    private void a(Context context, Intent intent) {
        UtilHelper.a(context, intent);
        TiebaApplication.a((Intent) null);
    }

    private void n() {
        this.y = new ao(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.notify");
        intentFilter.addAction("com.baidu.tieba.broadcast.newrecommends");
        registerReceiver(this.y, intentFilter);
    }

    private void o() {
        if (this.y != null) {
            unregisterReceiver(this.y);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        long j = this.e + this.f + this.h;
        long j2 = this.g;
        long j3 = this.i;
        if (j > 0) {
            a(((com.baidu.adp.lib.h.g.b(this) * 7) / 10) + com.baidu.adp.lib.h.g.a((Context) this, 3.0f), this.k, j);
        } else {
            this.k.setVisibility(8);
        }
        if (j2 > 0) {
            a(((com.baidu.adp.lib.h.g.b(this) * 9) / 10) + com.baidu.adp.lib.h.g.a((Context) this, 3.0f), this.j, j2);
            this.m.setVisibility(8);
        } else if (j3 > 0 && !TiebaApplication.h().d().booleanValue()) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams.leftMargin = ((com.baidu.adp.lib.h.g.b(this) * 9) / 10) + com.baidu.adp.lib.h.g.a((Context) this, 6.0f);
            this.m.setLayoutParams(layoutParams);
            this.m.setVisibility(0);
            this.j.setVisibility(8);
        } else {
            this.m.setVisibility(8);
            this.j.setVisibility(8);
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
        boolean z = this.b == 1;
        textView.setTextColor(getResources().getColor(z ? R.color.top_msg_num_night : R.color.top_msg_num_day));
        if (j < 10) {
            textView.setText(String.valueOf(j));
            textView.setBackgroundResource(z ? R.drawable.icon_news_head_prompt_one_1 : R.drawable.icon_news_head_prompt_one);
        } else if (j < 100) {
            textView.setText(String.valueOf(j));
            textView.setBackgroundResource(z ? R.drawable.icon_news_head_prompt_two_1 : R.drawable.icon_news_head_prompt_two);
        } else {
            textView.setText("   ");
            textView.setBackgroundResource(z ? R.drawable.icon_news_head_prompt_more_1 : R.drawable.icon_news_head_prompt_more);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (TiebaApplication.aS()) {
            this.l.setVisibility(0);
        } else {
            this.l.setVisibility(8);
        }
    }

    public void d(int i) {
        this.x.c(i);
        if (i == 1) {
            this.m.setImageResource(R.drawable.icon_news_down_bar_one_1);
        } else {
            this.m.setImageResource(R.drawable.icon_news_down_bar_one);
        }
    }

    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity
    protected void onResume() {
        super.onResume();
        com.baidu.tieba.util.bd.e("MainTabActivity", "onResume", "onResume");
        TiebaApplication.h().az();
        TiebaApplication.h().aA();
        if (!TiebaApplication.o() && d != 10) {
            if (d == -1) {
                com.baidu.tieba.account.a.a().a(this, 1);
            } else {
                com.baidu.tieba.account.a.a().a(this, d);
                d = -1;
            }
        }
        d = this.x.getCurrentTabIndex();
        if (TiebaApplication.h().an() != this.b) {
            this.b = TiebaApplication.h().an();
            d(this.b);
        }
        if (TiebaApplication.B() == null || TiebaApplication.B().length() <= 0) {
            s();
        }
        p();
        com.baidu.tieba.im.pushNotify.a.h().b(false, (com.baidu.tieba.im.a<Void>) null);
    }

    private void r() {
        try {
            startService(new Intent(this, FatalErrorService.class));
        } catch (Throwable th) {
            BdLog.e("failed to start FatalErrorService:" + th.getMessage());
        }
    }

    private void s() {
        this.e = 0L;
        this.f = 0L;
        this.g = 0L;
        this.h = 0L;
        this.i = 0L;
    }

    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity
    protected void onPause() {
        super.onPause();
        LogoActivity.a(false);
        if (c) {
            c = false;
            CompatibleUtile.setAnim(this, R.anim.down, R.anim.hold);
        }
        TiebaApplication.h().aB();
        if (this.q != null) {
            this.q.dismiss();
        }
    }

    @Override // android.support.v4.app.n, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("locate_type", this.x.getCurrentTabIndex());
        bundle.putString("pb_id", "");
        bundle.putString("frs_name", "");
        bundle.putString(SocialConstants.PARAM_URL, "");
        bundle.putParcelable("android:support:fragments", null);
    }

    @Override // android.support.v4.app.n, android.app.Activity
    protected void onStop() {
        super.onStop();
        if (this.w != null) {
            this.w.f(this);
        }
    }

    @Override // android.support.v4.app.n, android.app.Activity
    protected void onNewIntent(Intent intent) {
        com.baidu.tieba.util.bd.a(getClass().getName(), "onNewIntent", "");
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("close_dialog", false)) {
            t();
        }
        if (intent.getBooleanExtra("refresh_all", false)) {
            this.x.a();
            c();
            a(intent);
        }
        if (intent.getIntExtra("locate_type", 1) == 200) {
            finish();
        }
        a(this, TiebaApplication.e());
    }

    private void t() {
        x a2;
        EnterForumActivity enterForumActivity;
        if (this.x.getCurrentTabIndex() != 1 && this.x.b(1) && (a2 = this.x.a(1)) != null && (enterForumActivity = (EnterForumActivity) a2.b) != null) {
            enterForumActivity.a();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            com.baidu.tieba.util.bd.e(getClass().getName(), "dispatchKeyEvent", "KEYCODE_BACK");
            if ((TiebaApplication.B() == null && this.x.getCurrentTabIndex() == 0) || (TiebaApplication.B() != null && this.x.getCurrentTabIndex() == 1)) {
                if (System.currentTimeMillis() - this.s > this.u) {
                    b(R.string.double_back_quit);
                    this.s = System.currentTimeMillis();
                    return false;
                }
                com.baidu.tieba.mention.t.a().k();
                u();
                moveTaskToBack(true);
                TiebaApplication.h().aD();
                com.baidu.tieba.log.a.b();
                return false;
            } else if (TiebaApplication.B() == null) {
                x a2 = this.x.a(0);
                if (a2 != null) {
                    a2.f2828a.performClick();
                    return false;
                }
                return false;
            } else {
                x a3 = this.x.a(1);
                if (a3 != null) {
                    a3.f2828a.performClick();
                    return false;
                }
                return false;
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            openOptionsMenu();
            return true;
        } else {
            return super.dispatchKeyEvent(keyEvent);
        }
    }

    private void a(Intent intent) {
        try {
            this.x.setCurrentTab(intent.getIntExtra("locate_type", 1));
        } catch (Throwable th) {
            finish();
        }
    }

    @Override // android.support.v4.app.n, android.app.Activity, android.view.KeyEvent.Callback
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
            if (!TiebaApplication.o()) {
                menu.findItem(2).setVisible(true);
            }
            menu.findItem(3).setVisible(true);
            menu.findItem(4).setVisible(true);
            menu.findItem(5).setVisible(true);
        } catch (Exception e) {
            com.baidu.tieba.util.bd.b("HomeActivity", "onPrepareOptionsMenu", "exp: " + e.toString());
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 1, getString(R.string.setup)).setIcon(R.drawable.menu_setup);
        if (!TiebaApplication.o()) {
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
                if (!TiebaApplication.C()) {
                    LoginActivity.a((Activity) this, getString(R.string.login_feedback), true, 11001);
                    break;
                } else {
                    e();
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

    protected void e() {
        AntiData antiData = new AntiData();
        antiData.setIfpost(1);
        WriteActivity.a(this, com.baidu.tieba.data.h.h(), com.baidu.tieba.data.h.g(), antiData);
    }

    @Override // android.support.v4.app.n, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 != -1) {
            if (i == 12007) {
                LoginActivity.a(this, 1, getString(R.string.login_home_tab), 11003);
            }
            if (this.x.getCurrentFragment() != null) {
                this.x.getCurrentFragment().a(i, i2, intent);
            }
        } else if (i == 11001) {
            e();
        } else if (this.x.getCurrentFragment() != null) {
            this.x.getCurrentFragment().a(i, i2, intent);
        }
    }

    @Override // com.baidu.tieba.BaseFragmentActivity
    protected void a(int i) {
    }

    @Override // com.baidu.tieba.voice.af
    public VoiceManager d_() {
        if (this.w == null) {
            this.w = new VoiceManager();
        }
        return this.w;
    }

    @Override // com.baidu.tieba.voice.af
    public com.baidu.tieba.voice.ad a(VoiceManager.VoiceModel voiceModel) {
        return null;
    }

    private void u() {
        if (System.currentTimeMillis() - this.t >= this.v) {
            r();
            i();
            j();
            this.t = System.currentTimeMillis();
        }
    }
}
