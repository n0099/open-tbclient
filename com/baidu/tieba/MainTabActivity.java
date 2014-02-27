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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.account.NotLoginGuideActivity;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.more.AboutActivity;
import com.baidu.tieba.more.AccountActivity;
import com.baidu.tieba.more.MoreActivity;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.voice.VoiceManager;
import com.baidu.tieba.write.WriteActivity;
import com.compatible.smartbarutil.SmartBarUtils;
import com.slidingmenu.lib.R;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class MainTabActivity extends k implements com.baidu.tieba.voice.af {
    private static boolean d = false;
    private static int e = -1;
    private MenuItem C;
    private q k;
    private q l;
    private q m;
    private boolean r;
    private boolean s;
    private VoiceManager x;
    private FragmentTabHost y;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private int j = 0;
    private Handler n = new Handler();
    private ProgressDialog o = null;
    private AlertDialog p = null;
    private com.baidu.tieba.view.bb q = null;
    private long t = 0;
    private long u = 0;
    private final long v = 2000;
    private final long w = 7200000;
    private ag z = null;
    private com.baidu.tieba.mention.c A = null;
    private int B = 0;
    private ah D = null;

    private void a(Fragment fragment, int i, int i2, int i3, int i4, HashMap<String, q> hashMap) {
        p pVar = new p();
        pVar.c = fragment;
        pVar.a = 3;
        FragmentTabIndicatorContainer fragmentTabIndicatorContainer = (FragmentTabIndicatorContainer) getLayoutInflater().inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) fragmentTabIndicatorContainer.getChildAt(0);
        fragmentTabIndicator.setText(R.string.remind);
        fragmentTabIndicator.a = R.drawable.tabs_message;
        fragmentTabIndicator.b = R.drawable.tabs_message_1;
        fragmentTabIndicator.d = R.drawable.tabs_btn_bg_1;
        fragmentTabIndicator.c = R.drawable.tabs_btn_bg;
        fragmentTabIndicator.f = R.color.main_bottom_button_color_1;
        fragmentTabIndicator.e = R.color.main_bottom_button_color;
        if (hashMap != null) {
            for (Map.Entry<String, q> entry : hashMap.entrySet()) {
                fragmentTabIndicatorContainer.a(entry.getKey(), entry.getValue());
            }
        }
        fragmentTabIndicatorContainer.a(TiebaApplication.g().ae());
        pVar.b = fragmentTabIndicatorContainer;
        this.y.a(pVar);
    }

    private void a(com.baidu.tieba.mainentrance.b bVar, HashMap<String, q> hashMap) {
        if (bVar != null) {
            p pVar = new p();
            pVar.c = bVar.a;
            pVar.a = bVar.e;
            FragmentTabIndicatorContainer fragmentTabIndicatorContainer = (FragmentTabIndicatorContainer) getLayoutInflater().inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
            FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) fragmentTabIndicatorContainer.getChildAt(0);
            fragmentTabIndicator.setText(bVar.d);
            fragmentTabIndicator.a = bVar.b;
            fragmentTabIndicator.b = bVar.c;
            fragmentTabIndicator.d = R.drawable.tabs_btn_bg_1;
            fragmentTabIndicator.c = R.drawable.tabs_btn_bg;
            fragmentTabIndicator.f = R.color.main_bottom_button_color_1;
            fragmentTabIndicator.e = R.color.main_bottom_button_color;
            if (hashMap != null) {
                for (Map.Entry<String, q> entry : hashMap.entrySet()) {
                    fragmentTabIndicatorContainer.a(entry.getKey(), entry.getValue());
                }
            }
            fragmentTabIndicatorContainer.a(TiebaApplication.g().ae());
            pVar.b = fragmentTabIndicatorContainer;
            this.y.a(pVar);
        }
    }

    private void f() {
        FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(R.layout.maintabs_tips, (ViewGroup) null);
        frameLayout.removeAllViews();
        this.k = new q();
        this.k.a = BdUtilHelper.a((Context) this, 3.0f);
        this.k.c = (TextView) frameLayout.findViewById(R.id.message_message);
        this.l = new q();
        this.l.a = BdUtilHelper.a((Context) this, 6.0f);
        this.l.b = BdUtilHelper.a((Context) this, 3.0f);
        this.l.c = (ImageView) frameLayout.findViewById(R.id.new_version_logo);
        this.m = new q();
        this.m.a = BdUtilHelper.a((Context) this, 6.0f);
        this.m.b = BdUtilHelper.a((Context) this, 3.0f);
        this.m.c = (ImageView) frameLayout.findViewById(R.id.new_bookmark_fans_logo);
        com.baidu.tieba.mainentrance.b bVar = new com.baidu.tieba.mainentrance.b();
        bVar.a = new com.baidu.tieba.e.p();
        bVar.e = 0;
        bVar.b = R.drawable.tabs_recommend;
        bVar.c = R.drawable.tabs_recommend_1;
        bVar.d = R.string.homepage;
        a(bVar, (HashMap<String, q>) null);
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_new_user", getIntent().getBooleanExtra("is_new_user", false));
        com.baidu.tieba.mainentrance.b bVar2 = new com.baidu.tieba.mainentrance.b();
        bVar2.a = new com.baidu.tieba.home.f();
        bVar2.a.setArguments(bundle);
        bVar2.e = 1;
        bVar2.b = R.drawable.tabs_home;
        bVar2.c = R.drawable.tabs_home_1;
        bVar2.d = R.string.home;
        a(bVar2, (HashMap<String, q>) null);
        com.baidu.tieba.mainentrance.b bVar3 = new com.baidu.tieba.mainentrance.b();
        bVar3.a = new com.baidu.tieba.group.a();
        bVar3.e = 2;
        bVar3.b = R.drawable.tabs_groups;
        bVar3.c = R.drawable.tabs_groups_1;
        bVar3.d = R.string.groups;
        a(bVar3, (HashMap<String, q>) null);
        this.A = new com.baidu.tieba.mention.c();
        HashMap<String, q> hashMap = new HashMap<>();
        hashMap.put(PushConstants.EXTRA_PUSH_MESSAGE, this.k);
        com.baidu.tieba.mention.c.c = true;
        a(this.A, R.drawable.tabs_message, R.drawable.tabs_message_1, R.string.remind, 3, hashMap);
        HashMap<String, q> hashMap2 = new HashMap<>();
        hashMap2.put("newversion", this.l);
        hashMap2.put("newbookmarkfans", this.m);
        com.baidu.tieba.mainentrance.b bVar4 = new com.baidu.tieba.mainentrance.b();
        bVar4.a = new com.baidu.tieba.person.ai();
        bVar4.e = 4;
        bVar4.b = R.drawable.tabs_more;
        bVar4.c = R.drawable.tabs_more_1;
        bVar4.d = R.string.more;
        a(bVar4, hashMap2);
    }

    @Override // com.baidu.tieba.k, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.mainentrance.d.a(new com.baidu.tieba.mainentrance.e());
        this.r = false;
        this.s = false;
        if (TiebaApplication.g().p()) {
            CompatibleUtile.getInstance().openGpu(this);
        }
        com.baidu.adp.lib.util.e.a(getClass().toString(), "onCreate", "debug");
        setContentView(R.layout.maintabs_activity);
        com.baidu.tieba.account.a.a().a((Activity) this, false);
        this.y = (FragmentTabHost) findViewById(R.id.tab_host);
        this.y.setup(getSupportFragmentManager());
        this.y.setTabWidgetBackgroundColor(getResources().getColor(R.color.maintab_bg));
        this.y.setTabChangeListener(new af(this));
        f();
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (bundle != null) {
            intent.putExtra("locate_type", bundle.getInt("locate_type", 1));
        }
        a(intent);
        TiebaApplication.g();
        TiebaApplication.be();
        if (TiebaApplication.t() != null && TiebaApplication.t().equals("aishide")) {
            TiebaApplication.g();
            TiebaApplication.bg();
        }
        this.D = new ah(this, (byte) 0);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(com.baidu.tieba.data.i.i());
        registerReceiver(this.D, intentFilter);
        this.z = new ag(this, (byte) 0);
        com.baidu.tieba.im.messageCenter.d.a().a(-124, this.z);
        TiebaApplication.g();
        TiebaApplication.bd();
        com.baidu.tieba.mention.v.a().h();
        a(this, TiebaApplication.f());
        String B = TiebaApplication.g().B();
        if (B != null && B.length() > 0) {
            UtilHelper.a(TiebaApplication.g().b(), B);
            TiebaApplication.g().k((String) null);
        }
        this.x = c_();
        this.x.a((Activity) this);
        com.baidu.tieba.log.a.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.x != null) {
            VoiceManager voiceManager = this.x;
            VoiceManager.g();
        }
        com.baidu.tieba.mention.v.a().h();
    }

    public static void d(int i) {
        e = 2;
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

    public static void a(Context context, int i, boolean z) {
        Intent intent = new Intent(context, MainTabActivity.class);
        intent.setFlags(603979776);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("locate_type", 1);
        intent.putExtra("is_new_user", z);
        intent.putExtra("close_dialog", true);
        context.startActivity(intent);
    }

    public static void a(Context context) {
        String v = TiebaApplication.v();
        if (v != null && v.length() > 0) {
            a(context, 1);
        } else {
            a(context, 0);
        }
    }

    public static void b(Context context, int i, boolean z) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.k, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com.baidu.adp.lib.util.e.a(getClass().getName(), "onDestroy", "");
        TiebaApplication.g();
        TiebaApplication.bf();
        TiebaApplication.g();
        TiebaApplication.bh();
        if (this.D != null) {
            unregisterReceiver(this.D);
        }
        com.baidu.tieba.im.messageCenter.d.a().a(this.z);
        com.baidu.tieba.mention.v.a().f();
        com.baidu.tieba.mention.v.a().j();
        com.baidu.tieba.mention.v.a().a(false);
        com.baidu.tbadk.imageManager.e.a().c();
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
        if (this.q != null) {
            this.q.a();
        }
        if (this.x != null) {
            this.x.d(this);
        }
        super.onDestroy();
        System.gc();
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        try {
            super.onRestoreInstanceState(bundle);
        } catch (Throwable th) {
            com.baidu.adp.lib.util.e.a(getClass(), "onRestoreInstanceState", th);
        }
    }

    private static void a(Context context, Intent intent) {
        UtilHelper.a(context, intent);
        TiebaApplication.a((Intent) null);
    }

    private void g() {
        int i = this.f + this.g + this.i;
        this.B = i;
        int i2 = this.h;
        int i3 = this.j;
        if (i > 0) {
            TextView textView = (TextView) this.k.c;
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
            textView.setVisibility(0);
        } else {
            this.k.c.setVisibility(8);
        }
        if ((i3 > 0 || i2 > 0) && !this.r) {
            this.m.c.setVisibility(0);
        } else {
            this.m.c.setVisibility(8);
        }
        if (this.c) {
            SmartBarUtils.invalidateOptionsMenu(this);
        }
    }

    public static /* synthetic */ void a(MainTabActivity mainTabActivity) {
        if (TiebaApplication.aE()) {
            mainTabActivity.l.c.setVisibility(0);
        } else {
            mainTabActivity.l.c.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.k, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.util.e.e("MainTabActivity", "onResume", "onResume");
        TiebaApplication.g().ap();
        TiebaApplication.g().aq();
        if (e != 10) {
            if (e == -1) {
                com.baidu.tieba.account.a.a().a(this, 1);
            } else {
                com.baidu.tieba.account.a.a().a(this, e);
            }
        }
        e = this.y.getCurrentTabType();
        a(this.b);
        if (TiebaApplication.v() == null || TiebaApplication.v().length() <= 0) {
            this.f = 0;
            this.g = 0;
            this.h = 0;
            this.i = 0;
            this.j = 0;
        }
        g();
        com.baidu.tieba.im.c.a.d().b(false, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.k, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivity.a(false);
        if (d) {
            d = false;
            CompatibleUtile.setAnim(this, R.anim.down, R.anim.hold);
        }
        TiebaApplication.g().ar();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("locate_type", this.y.getCurrentTabType());
        bundle.putString("pb_id", "");
        bundle.putString("frs_name", "");
        bundle.putString(SocialConstants.PARAM_URL, "");
        bundle.putParcelable("android:support:fragments", null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.x != null) {
            this.x.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        p b;
        com.baidu.adp.lib.util.e.a(getClass().getName(), "onNewIntent", "");
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("close_dialog", false) && this.y.getCurrentTabType() != 1 && this.y.c(1) && (b = this.y.b(1)) != null) {
            com.baidu.tieba.mainentrance.a.a(b.c);
        }
        if (intent.getBooleanExtra("refresh_all", false)) {
            this.y.a();
            f();
            a(intent);
        }
        int intExtra = intent.getIntExtra("locate_type", 1);
        if (intExtra == 200) {
            finish();
        } else if (intExtra == 11) {
            NotLoginGuideActivity.a(this, NotLoginGuideActivity.a);
            finish();
        }
        a(this, TiebaApplication.f());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            com.baidu.adp.lib.util.e.e(getClass().getName(), "dispatchKeyEvent", "KEYCODE_BACK");
            if ((TiebaApplication.v() == null && this.y.getCurrentTabType() == 0) || (TiebaApplication.v() != null && this.y.getCurrentTabType() == 1)) {
                if (System.currentTimeMillis() - this.t > 2000) {
                    BdUtilHelper.a((Context) this, (int) R.string.double_back_quit);
                    this.t = System.currentTimeMillis();
                    return false;
                }
                com.baidu.tieba.mention.v.a().j();
                if (System.currentTimeMillis() - this.u >= 7200000) {
                    TiebaApplication.g();
                    TiebaApplication.bc();
                    TiebaApplication.g();
                    TiebaApplication.bd();
                    TiebaApplication.g();
                    TiebaApplication.be();
                    this.u = System.currentTimeMillis();
                }
                moveTaskToBack(true);
                TiebaApplication.g().at();
                com.baidu.tieba.log.a.b();
                return false;
            } else if (TiebaApplication.v() == null) {
                if (this.c) {
                    this.y.setCurrentTab(0);
                    return false;
                }
                p b = this.y.b(0);
                if (b != null) {
                    b.b.performClick();
                    return false;
                }
                return false;
            } else if (this.c) {
                this.y.setCurrentTab(1);
                return false;
            } else {
                p b2 = this.y.b(1);
                if (b2 != null) {
                    b2.b.performClick();
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
            this.y.setCurrentTabByType(intent.getIntExtra("locate_type", 1));
            int intExtra = intent.getIntExtra("NotifiIdKey", 16);
            if (this.A != null) {
                this.A.d(intExtra);
            }
        } catch (Throwable th) {
            finish();
        }
    }

    @Override // com.baidu.tieba.k, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        try {
            return super.onKeyDown(i, keyEvent);
        } catch (IllegalStateException e2) {
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
        } catch (IllegalStateException e2) {
            if (i == 4) {
                finish();
            }
            return true;
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (this.c) {
            for (int i = 0; i < menu.size(); i++) {
                MenuItem item = menu.getItem(i);
                int currentTabIndex = this.y.getCurrentTabIndex();
                switch (item.getItemId()) {
                    case 2:
                        item.setIcon(currentTabIndex == 1 ? R.drawable.icon_jinba_s : R.drawable.icon_jinba_n);
                        break;
                    case 3:
                        item.setIcon(currentTabIndex == 2 ? R.drawable.icon_group_s : R.drawable.icon_group_n);
                        break;
                    case 4:
                        if (this.B == 0) {
                            item.setIcon(currentTabIndex == 3 ? R.drawable.icon_news_s : R.drawable.icon_news_n);
                            break;
                        } else {
                            item.setIcon(currentTabIndex == 3 ? R.drawable.icon_news_dot_s : R.drawable.icon_news_dot_n);
                            break;
                        }
                }
            }
        }
        try {
            menu.findItem(6).setVisible(true);
            menu.findItem(7).setVisible(true);
            menu.findItem(8).setVisible(true);
            menu.findItem(9).setVisible(true);
            menu.findItem(10).setVisible(true);
            menu.findItem(11).setVisible(true);
        } catch (Exception e2) {
            com.baidu.adp.lib.util.e.b("HomeActivity", "onPrepareOptionsMenu", "exp: " + e2.toString());
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.c) {
            SmartBarUtils.fixMenuItem(menu.add(0, 1, 4, getString(R.string.homepage)).setIcon(R.drawable.tabs_recommend));
            SmartBarUtils.fixMenuItem(menu.add(0, 2, 1, getString(R.string.home)).setIcon(R.drawable.tabs_home));
            SmartBarUtils.fixMenuItem(menu.add(0, 3, 2, getString(R.string.groups)).setIcon(R.drawable.tabs_groups));
            SmartBarUtils.fixMenuItem(menu.add(0, 4, 3, getString(R.string.remind)).setIcon(R.drawable.tabs_message));
            SmartBarUtils.fixMenuItem(menu.add(0, 5, 5, getString(R.string.more)).setIcon(R.drawable.tabs_more));
            SmartBarUtils.fixMenuItem(menu.add(0, 6, 6, getString(R.string.setup)).setIcon(R.drawable.menu_setup));
            SmartBarUtils.fixMenuItem(a(menu, 7));
            SmartBarUtils.fixMenuItem(menu.add(0, 7, 8, getString(R.string.account)).setIcon(R.drawable.menu_account));
            SmartBarUtils.fixMenuItem(menu.add(0, 8, 9, getString(R.string.feedback)).setIcon(R.drawable.menu_feedback));
            SmartBarUtils.fixMenuItem(menu.add(0, 9, 10, getString(R.string.version_info)).setIcon(R.drawable.menu_about));
            SmartBarUtils.fixMenuItem(menu.add(0, 10, 11, getString(R.string.quit)).setIcon(R.drawable.menu_quit));
        } else {
            menu.add(0, 6, 1, getString(R.string.setup)).setIcon(R.drawable.icon_menu_set_n);
            a(menu, 2);
            menu.add(0, 7, 3, getString(R.string.account)).setIcon(R.drawable.icon_menu_account_n);
            menu.add(0, 8, 4, getString(R.string.feedback)).setIcon(R.drawable.icon_menu_feedback_n);
            menu.add(0, 9, 5, getString(R.string.version_info)).setIcon(R.drawable.icon_menu_information_n);
            menu.add(0, 10, 6, getString(R.string.quit)).setIcon(R.drawable.icon_menu_exit_n);
        }
        return true;
    }

    private MenuItem a(Menu menu, int i) {
        MenuItem icon;
        if (TiebaApplication.g().ae() != 1) {
            icon = menu.add(0, 11, i, getString(R.string.night_mode)).setIcon(R.drawable.icon_menu_night_n);
        } else {
            icon = menu.add(0, 11, i, getString(R.string.normal_mode)).setIcon(R.drawable.icon_menu_daytime_n);
        }
        this.C = icon;
        return icon;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
                this.y.setCurrentTab(0);
                break;
            case 2:
                this.y.setCurrentTab(1);
                break;
            case 3:
                this.y.setCurrentTab(2);
                break;
            case 4:
                this.y.setCurrentTab(3);
                break;
            case 5:
                this.y.setCurrentTab(4);
                break;
            case 6:
                MoreActivity.a(this);
                break;
            case 7:
                AccountActivity.a(this);
                break;
            case 8:
                if (!TiebaApplication.w()) {
                    LoginActivity.a((Activity) this, getString(R.string.login_feedback), true, 11001);
                    break;
                } else {
                    h();
                    break;
                }
            case 9:
                AboutActivity.a(this);
                break;
            case 10:
                UtilHelper.a((Activity) this);
                break;
            case 11:
                if (TiebaApplication.g().ae() == 1) {
                    TiebaApplication.g().e(0);
                } else {
                    TiebaApplication.g().e(1);
                }
                a(TiebaApplication.g().ae());
                ((j) this.y.getCurrentFragment()).b(TiebaApplication.g().ae());
                com.baidu.tieba.util.n.a();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private void h() {
        AntiData antiData = new AntiData();
        antiData.setIfpost(1);
        WriteActivity.a(this, com.baidu.tieba.data.i.s(), com.baidu.tieba.data.i.r(), antiData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 != -1) {
            if (i == 12007) {
                LoginActivity.a(this, 1, getString(R.string.login_home_tab), 11003);
            }
            if (this.y.getCurrentFragment() != null) {
                this.y.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 11001) {
            h();
        } else if (this.y.getCurrentFragment() != null) {
            this.y.getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tieba.k
    protected final void b(int i) {
        this.y.d(i);
        ImageView imageView = (ImageView) this.m.c;
        if (i == 1) {
            imageView.setImageResource(R.drawable.icon_news_down_bar_one_1);
        } else {
            imageView.setImageResource(R.drawable.icon_news_down_bar_one);
        }
        if (this.C != null) {
            if (i == 1) {
                this.C.setTitle(R.string.normal_mode);
                this.C.setIcon(R.drawable.icon_menu_daytime_n);
                return;
            }
            this.C.setTitle(R.string.night_mode);
            this.C.setIcon(R.drawable.icon_menu_night_n);
        }
    }

    @Override // com.baidu.tieba.voice.af
    public final VoiceManager c_() {
        if (this.x == null) {
            this.x = new VoiceManager();
        }
        return this.x;
    }

    @Override // com.baidu.tieba.voice.af
    public final com.baidu.tieba.voice.ad a(VoiceManager.VoiceModel voiceModel) {
        return null;
    }

    public static /* synthetic */ void a(MainTabActivity mainTabActivity, com.baidu.tieba.im.message.s sVar) {
        if (sVar != null) {
            if (!(sVar instanceof com.baidu.tieba.im.message.v)) {
                com.baidu.adp.lib.util.e.b("transform error");
                return;
            }
            com.baidu.tieba.im.message.v vVar = (com.baidu.tieba.im.message.v) sVar;
            int e2 = vVar.e();
            int c = vVar.c();
            mainTabActivity.f = vVar.a();
            mainTabActivity.g = vVar.b();
            mainTabActivity.i = vVar.d();
            if (mainTabActivity.s) {
                mainTabActivity.r = true;
            }
            if (mainTabActivity.h != c) {
                mainTabActivity.h = c;
                mainTabActivity.r = false;
            }
            if (mainTabActivity.j > e2) {
                mainTabActivity.r = false;
            }
            mainTabActivity.j = e2;
            mainTabActivity.g();
        }
    }
}
