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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.pushservice.PushConstants;
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
import com.baidu.tieba.person.MoreDiscoveryActivity;
import com.baidu.tieba.service.ClearTempService;
import com.baidu.tieba.service.FatalErrorService;
import com.baidu.tieba.service.TiebaActiveService;
import com.baidu.tieba.service.TiebaSyncService;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.bp;
import com.baidu.tieba.voice.VoiceManager;
import com.baidu.tieba.write.WriteActivity;
import com.slidingmenu.lib.R;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class MainTabActivity extends BaseFragmentActivity implements com.baidu.tieba.voice.af {
    private static boolean c = false;
    private static int d = -1;
    private w j;
    private w k;
    private w l;
    private boolean r;
    private boolean s;
    private VoiceManager x;
    private FragmentTabHost y;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private Handler m = new Handler();
    private ProgressDialog n = null;
    private AlertDialog o = null;
    private com.baidu.tieba.view.as p = null;
    private com.baidu.tieba.view.am q = null;
    private long t = 0;
    private long u = 0;
    private long v = 2000;
    private long w = 7200000;
    protected int b = -1;
    private an z = null;
    private MentionActivity A = null;
    private ao B = null;

    private void a(Fragment fragment, int i, int i2, int i3, HashMap<String, w> hashMap) {
        v vVar = new v();
        vVar.b = fragment;
        FragmentTabIndicatorContainer fragmentTabIndicatorContainer = (FragmentTabIndicatorContainer) getLayoutInflater().inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) fragmentTabIndicatorContainer.getChildAt(0);
        fragmentTabIndicator.setText(i3);
        fragmentTabIndicator.a = i;
        fragmentTabIndicator.b = i2;
        fragmentTabIndicator.d = R.drawable.tabs_btn_bg_1;
        fragmentTabIndicator.c = R.drawable.tabs_btn_bg;
        fragmentTabIndicator.f = R.color.main_bottom_button_color_1;
        fragmentTabIndicator.e = R.color.main_bottom_button_color;
        if (hashMap != null) {
            for (Map.Entry<String, w> entry : hashMap.entrySet()) {
                fragmentTabIndicatorContainer.a(entry.getKey(), entry.getValue());
            }
        }
        fragmentTabIndicatorContainer.a(TiebaApplication.g().an());
        vVar.a = fragmentTabIndicatorContainer;
        this.y.a(vVar);
    }

    protected void b() {
        f();
        a(new HomeActivity(), R.drawable.tabs_recommend, R.drawable.tabs_recommend_1, R.string.homepage, null);
        a(new EnterForumActivity(), R.drawable.tabs_home, R.drawable.tabs_home_1, R.string.home, null);
        a(new GroupActivity(), R.drawable.tabs_groups, R.drawable.tabs_groups_1, R.string.groups, null);
        this.A = new MentionActivity();
        HashMap<String, w> hashMap = new HashMap<>();
        hashMap.put(PushConstants.EXTRA_PUSH_MESSAGE, this.j);
        MentionActivity.b = true;
        a(this.A, R.drawable.tabs_message, R.drawable.tabs_message_1, R.string.remind, hashMap);
        HashMap<String, w> hashMap2 = new HashMap<>();
        hashMap2.put("newversion", this.k);
        hashMap2.put("newbookmarkfans", this.l);
        a(new MoreDiscoveryActivity(), R.drawable.tabs_more, R.drawable.tabs_more_1, R.string.more, hashMap2);
    }

    private void f() {
        FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(R.layout.maintabs_tips, (ViewGroup) null);
        frameLayout.removeAllViews();
        this.j = new w();
        this.j.a = com.baidu.adp.lib.h.g.a((Context) this, 3.0f);
        this.j.c = (TextView) frameLayout.findViewById(R.id.message_message);
        this.k = new w();
        this.k.a = com.baidu.adp.lib.h.g.a((Context) this, 6.0f);
        this.k.b = com.baidu.adp.lib.h.g.a((Context) this, 3.0f);
        this.k.c = (ImageView) frameLayout.findViewById(R.id.new_version_logo);
        this.l = new w();
        this.l.a = com.baidu.adp.lib.h.g.a((Context) this, 6.0f);
        this.l.b = com.baidu.adp.lib.h.g.a((Context) this, 3.0f);
        this.l.c = (ImageView) frameLayout.findViewById(R.id.new_bookmark_fans_logo);
    }

    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.r = false;
        this.s = false;
        if (c()) {
            CompatibleUtile.getInstance().openGpu(this);
        }
        com.baidu.tieba.util.bo.a(getClass().toString(), "onCreate", "debug");
        setContentView(R.layout.maintabs_activity);
        if (!TiebaApplication.n()) {
            com.baidu.tieba.account.a.a().a((Activity) this, false);
        }
        this.y = (FragmentTabHost) findViewById(R.id.tab_host);
        this.y.setup(getSupportFragmentManager());
        this.y.setTabWidgetBackgroundColor(getResources().getColor(R.color.maintab_bg));
        this.y.setTabChangeListener(new am(this));
        b();
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (bundle != null) {
            intent.putExtra("locate_type", bundle.getInt("locate_type", 1));
        }
        a(intent);
        h();
        if (TiebaApplication.y() != null && TiebaApplication.y().equals("aishide")) {
            j();
        }
        l();
        g();
        com.baidu.tieba.mention.s.a().j();
        a(this, TiebaApplication.d());
        String I = TiebaApplication.g().I();
        if (I != null && I.length() > 0) {
            UtilHelper.a(TiebaApplication.g(), I);
            TiebaApplication.g().m((String) null);
        }
        this.x = d_();
        this.x.a((Activity) this);
        com.baidu.tieba.log.a.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.x != null) {
            this.x.b((Activity) this);
        }
        com.baidu.tieba.mention.s.a().j();
    }

    public static void c(int i) {
        d = i;
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
        String A = TiebaApplication.A();
        if (A != null && A.length() > 0) {
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
        Intent intent = new Intent(context, MainTabActivity.class);
        intent.setFlags(603979776);
        intent.putExtra("refresh_all", true);
        intent.putExtra("locate_type", 3);
        intent.putExtra("NotifiIdKey", i);
        intent.addFlags(268435456);
        intent.putExtra("close_dialog", true);
        context.startActivity(intent);
    }

    public static void c(Context context, int i) {
        TiebaApplication.g().z();
        com.baidu.tieba.mention.s.a().l();
        com.baidu.tieba.mention.s.a().j();
        a(context, i, false);
    }

    public static void b(Context context, int i, boolean z) {
        TiebaApplication.g().z();
        a(context, i, z);
    }

    public boolean c() {
        return TiebaApplication.g().u();
    }

    private void g() {
        try {
            startService(new Intent(this, ClearTempService.class));
        } catch (Throwable th) {
            com.baidu.adp.lib.h.e.a(th.getMessage());
        }
    }

    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity
    protected void onDestroy() {
        com.baidu.tieba.util.bo.a(getClass().getName(), "onDestroy", "");
        i();
        k();
        m();
        com.baidu.tieba.mention.s.a().h();
        com.baidu.tieba.mention.s.a().l();
        com.baidu.tieba.mention.s.a().a(false);
        com.baidu.tbadk.imageManager.d.a().c();
        if (this.n != null) {
            this.n.dismiss();
            this.n = null;
        }
        if (this.o != null) {
            this.o.dismiss();
            this.o = null;
        }
        if (this.m != null) {
            this.m.removeMessages(1);
        }
        if (this.q != null) {
            this.q.a();
        }
        bp.a();
        if (this.x != null) {
            this.x.g(this);
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

    private void h() {
        startService(new Intent(this, TiebaSyncService.class));
    }

    private void i() {
        stopService(new Intent(this, TiebaSyncService.class));
    }

    private void j() {
        startService(new Intent(this, TiebaActiveService.class));
    }

    private void k() {
        stopService(new Intent(this, TiebaActiveService.class));
    }

    private void a(Context context, Intent intent) {
        UtilHelper.a(context, intent);
        TiebaApplication.a((Intent) null);
    }

    private void l() {
        this.B = new ao(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.newrecommends");
        registerReceiver(this.B, intentFilter);
        this.z = new an(this, null);
        com.baidu.tieba.im.messageCenter.e.a().a(-124, this.z);
    }

    private void m() {
        if (this.B != null) {
            unregisterReceiver(this.B);
        }
        com.baidu.tieba.im.messageCenter.e.a().a(this.z);
    }

    private void n() {
        int i = this.e + this.f + this.h;
        int i2 = this.g;
        int i3 = this.i;
        if (i > 0) {
            a(this.j, i);
        } else {
            this.j.c.setVisibility(8);
        }
        if ((i3 > 0 || i2 > 0) && !this.r) {
            this.l.c.setVisibility(0);
        } else {
            this.l.c.setVisibility(8);
        }
    }

    private void a(w wVar, int i) {
        TextView textView = (TextView) wVar.c;
        a(textView, i);
        textView.setVisibility(0);
    }

    private void a(TextView textView, int i) {
        boolean z = this.b == 1;
        textView.setTextColor(getResources().getColor(z ? R.color.top_msg_num_night : R.color.top_msg_num_day));
        if (i < 10) {
            textView.setText(String.valueOf(i));
            textView.setBackgroundResource(z ? R.drawable.icon_news_head_prompt_one_1 : R.drawable.icon_news_head_prompt_one);
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            textView.setBackgroundResource(z ? R.drawable.icon_news_head_prompt_two_1 : R.drawable.icon_news_head_prompt_two);
        } else {
            textView.setText("   ");
            textView.setBackgroundResource(z ? R.drawable.icon_news_head_prompt_more_1 : R.drawable.icon_news_head_prompt_more);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (TiebaApplication.aS()) {
            this.k.c.setVisibility(0);
        } else {
            this.k.c.setVisibility(8);
        }
    }

    public void d(int i) {
        this.y.c(i);
        ImageView imageView = (ImageView) this.l.c;
        if (i == 1) {
            imageView.setImageResource(R.drawable.icon_news_down_bar_one_1);
        } else {
            imageView.setImageResource(R.drawable.icon_news_down_bar_one);
        }
    }

    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity
    protected void onResume() {
        super.onResume();
        com.baidu.tieba.util.bo.e("MainTabActivity", "onResume", "onResume");
        TiebaApplication.g().az();
        TiebaApplication.g().aA();
        if (!TiebaApplication.n() && d != 10) {
            if (d == -1) {
                com.baidu.tieba.account.a.a().a(this, 1);
            } else {
                com.baidu.tieba.account.a.a().a(this, d);
                d = -1;
            }
        }
        d = this.y.getCurrentTabIndex();
        d(this.b);
        if (TiebaApplication.A() == null || TiebaApplication.A().length() <= 0) {
            q();
        }
        n();
        com.baidu.tieba.im.c.a.h().b(false, (com.baidu.tieba.im.a<Void>) null);
    }

    private void p() {
        try {
            startService(new Intent(this, FatalErrorService.class));
        } catch (Throwable th) {
            com.baidu.adp.lib.h.e.a("failed to start FatalErrorService:" + th.getMessage());
        }
    }

    private void q() {
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
    }

    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity
    protected void onPause() {
        super.onPause();
        LogoActivity.a(false);
        if (c) {
            c = false;
            CompatibleUtile.setAnim(this, R.anim.down, R.anim.hold);
        }
        TiebaApplication.g().aB();
        if (this.p != null) {
            this.p.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("locate_type", this.y.getCurrentTabIndex());
        bundle.putString("pb_id", "");
        bundle.putString("frs_name", "");
        bundle.putString(SocialConstants.PARAM_URL, "");
        bundle.putParcelable("android:support:fragments", null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.x != null) {
            this.x.f(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onNewIntent(Intent intent) {
        com.baidu.tieba.util.bo.a(getClass().getName(), "onNewIntent", "");
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("close_dialog", false)) {
            r();
        }
        if (intent.getBooleanExtra("refresh_all", false)) {
            this.y.a();
            b();
            a(intent);
        }
        if (intent.getIntExtra("locate_type", 1) == 200) {
            finish();
        }
        a(this, TiebaApplication.d());
    }

    private void r() {
        v a;
        EnterForumActivity enterForumActivity;
        if (this.y.getCurrentTabIndex() != 1 && this.y.b(1) && (a = this.y.a(1)) != null && (enterForumActivity = (EnterForumActivity) a.b) != null) {
            enterForumActivity.a();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            com.baidu.tieba.util.bo.e(getClass().getName(), "dispatchKeyEvent", "KEYCODE_BACK");
            if ((TiebaApplication.A() == null && this.y.getCurrentTabIndex() == 0) || (TiebaApplication.A() != null && this.y.getCurrentTabIndex() == 1)) {
                if (System.currentTimeMillis() - this.t > this.v) {
                    b(R.string.double_back_quit);
                    this.t = System.currentTimeMillis();
                    return false;
                }
                com.baidu.tieba.mention.s.a().l();
                s();
                moveTaskToBack(true);
                TiebaApplication.g().aD();
                com.baidu.tieba.log.a.b();
                return false;
            } else if (TiebaApplication.A() == null) {
                v a = this.y.a(0);
                if (a != null) {
                    a.a.performClick();
                    return false;
                }
                return false;
            } else {
                v a2 = this.y.a(1);
                if (a2 != null) {
                    a2.a.performClick();
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
            this.y.setCurrentTab(intent.getIntExtra("locate_type", 1));
            int intExtra = intent.getIntExtra("NotifiIdKey", 16);
            if (this.A != null) {
                this.A.d(intExtra);
            }
        } catch (Throwable th) {
            finish();
        }
    }

    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity, android.view.KeyEvent.Callback
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
            com.baidu.tieba.util.bo.b("HomeActivity", "onPrepareOptionsMenu", "exp: " + e.toString());
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
                if (!TiebaApplication.B()) {
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
        WriteActivity.a(this, com.baidu.tieba.data.h.h(), com.baidu.tieba.data.h.g(), antiData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 != -1) {
            if (i == 12007) {
                LoginActivity.a(this, 1, getString(R.string.login_home_tab), 11003);
            }
            if (this.y.getCurrentFragment() != null) {
                this.y.getCurrentFragment().a(i, i2, intent);
            }
        } else if (i == 11001) {
            d();
        } else if (this.y.getCurrentFragment() != null) {
            this.y.getCurrentFragment().a(i, i2, intent);
        }
    }

    @Override // com.baidu.tieba.BaseFragmentActivity
    protected void a(int i) {
    }

    @Override // com.baidu.tieba.voice.af
    public VoiceManager d_() {
        if (this.x == null) {
            this.x = new VoiceManager();
        }
        return this.x;
    }

    @Override // com.baidu.tieba.voice.af
    public com.baidu.tieba.voice.ad a(VoiceManager.VoiceModel voiceModel) {
        return null;
    }

    private void s() {
        if (System.currentTimeMillis() - this.u >= this.w) {
            p();
            g();
            h();
            this.u = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.im.message.o oVar) {
        if (oVar != null) {
            if (!(oVar instanceof com.baidu.tieba.im.message.r)) {
                com.baidu.adp.lib.h.e.a("transform error");
                return;
            }
            com.baidu.tieba.im.message.r rVar = (com.baidu.tieba.im.message.r) oVar;
            int e = rVar.e();
            int c2 = rVar.c();
            this.e = rVar.a();
            this.f = rVar.b();
            this.h = rVar.d();
            if (this.s) {
                this.r = true;
            }
            if (this.g != c2) {
                this.g = c2;
                this.r = false;
            }
            if (this.i > e) {
                this.r = false;
            }
            this.i = e;
            n();
        }
    }
}
