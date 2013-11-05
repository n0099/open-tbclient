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
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import com.baidu.browser.core.util.BdLog;
import com.baidu.cloudsdk.social.core.SocialConstants;
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
import com.baidu.tieba.util.be;
import com.baidu.tieba.util.bf;
import com.baidu.tieba.view.GuidPageView;
import com.baidu.tieba.write.WriteActivity;
import com.slidingmenu.lib.R;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class MainTabActivity extends TabActivity implements CompoundButton.OnCheckedChangeListener {
    private static boolean b = false;
    private static int c = -1;
    private ae[] f;
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

    /* renamed from: a */
    protected int f985a = -1;
    private af x = null;

    protected void a() {
        this.f = new ae[5];
        ae aeVar = new ae(null);
        aeVar.b = new Intent(this, ForumFeedActivity.class);
        aeVar.e = R.drawable.tabs_recommend;
        aeVar.f = R.drawable.tabs_recommend_1;
        aeVar.d = "maintab_home";
        aeVar.f1064a = "view_1";
        aeVar.c = (RadioButton) findViewById(R.id.radio_recommend);
        this.f[0] = aeVar;
        ae aeVar2 = new ae(null);
        aeVar2.b = new Intent(this, EnterForumActivity.class);
        aeVar2.e = R.drawable.tabs_home;
        aeVar2.f = R.drawable.tabs_home_1;
        aeVar2.d = "maintab_enterforum";
        aeVar2.f1064a = "view_2";
        aeVar2.c = (RadioButton) findViewById(R.id.radio_home);
        this.f[1] = aeVar2;
        ae aeVar3 = new ae(null);
        aeVar3.b = new Intent(this, SquareActivity.class);
        aeVar3.e = R.drawable.tabs_square;
        aeVar3.f = R.drawable.tabs_square_1;
        aeVar3.d = "maintab_square";
        aeVar3.f1064a = "view_3";
        aeVar3.c = (RadioButton) findViewById(R.id.radio_square);
        this.f[2] = aeVar3;
        ae aeVar4 = new ae(null);
        aeVar4.b = new Intent(this, MentionActivity.class);
        aeVar4.e = R.drawable.tabs_message;
        aeVar4.f = R.drawable.tabs_message_1;
        aeVar4.d = "maintab_message";
        aeVar4.f1064a = "view_4";
        aeVar4.c = (RadioButton) findViewById(R.id.radio_message);
        this.f[3] = aeVar4;
        ae aeVar5 = new ae(null);
        aeVar5.b = new Intent(this, PersonInfoActivity.class);
        aeVar5.b.putExtra("self", true);
        aeVar5.b.putExtra("tab_page", true);
        aeVar5.b.putExtra("un", TiebaApplication.C());
        aeVar5.e = R.drawable.tabs_search;
        aeVar5.f = R.drawable.tabs_search_1;
        aeVar5.d = "maintab_personal";
        aeVar5.f1064a = "view_5";
        aeVar5.c = (RadioButton) findViewById(R.id.radio_person_info);
        this.f[4] = aeVar5;
    }

    protected void a(ae aeVar, int i) {
        if (i == 4) {
            aeVar.b.putExtra("un", TiebaApplication.C());
        } else if (i == 3) {
            MentionActivity.e = true;
            m();
        }
        this.g.setCurrentTabByTag(aeVar.f1064a);
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (b()) {
            CompatibleUtile.getInstance().openGpu(this);
        }
        be.a(getClass().toString(), "onCreate", "debug");
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
        o();
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (bundle != null) {
            intent.putExtra("locate_type", bundle.getInt("locate_type", this.e));
        }
        a(intent);
        g();
        if (TiebaApplication.y() != null && TiebaApplication.y().equals("aishide")) {
            i();
        }
        k();
        f();
        com.baidu.tieba.mention.t.a().i();
        a(this, TiebaApplication.e());
        String L = TiebaApplication.g().L();
        if (L != null && L.length() > 0) {
            UtilHelper.b(TiebaApplication.g(), L);
            TiebaApplication.g().l((String) null);
        }
    }

    public static void a(int i) {
        c = i;
    }

    public void e() {
        a(1.0f);
        if (this.v != null) {
            this.v.a(null);
        }
    }

    private void a(float f) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = f;
        getWindow().setAttributes(attributes);
    }

    public static void a(Context context, int i, String str) {
        Intent intent = new Intent(context, MainTabActivity.class);
        intent.setFlags(603979776);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (i >= 0) {
            intent.putExtra("locate_type", i);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("locate_ext", str);
        }
        intent.putExtra("close_dialog", true);
        context.startActivity(intent);
    }

    public static void a(Context context, int i) {
        a(context, i, (String) null);
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

    private void f() {
        try {
            startService(new Intent(this, ClearTempService.class));
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onDestroy() {
        be.a(getClass().getName(), "onDestroy", "");
        h();
        j();
        l();
        com.baidu.tieba.mention.t.a().g();
        com.baidu.tieba.mention.t.a().k();
        com.baidu.tieba.mention.t.a().a(false);
        com.baidu.tbadk.imageManager.d.a().c();
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
        bf.a();
        super.onDestroy();
        System.gc();
    }

    @Override // android.app.TabActivity, android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        try {
            super.onRestoreInstanceState(bundle);
        } catch (Throwable th) {
            com.baidu.adp.lib.h.d.a(getClass(), "onRestoreInstanceState", th);
        }
    }

    private void g() {
        startService(new Intent(this, TiebaSyncService.class));
    }

    private void h() {
        stopService(new Intent(this, TiebaSyncService.class));
    }

    private void i() {
        startService(new Intent(this, TiebaActiveService.class));
    }

    private void j() {
        stopService(new Intent(this, TiebaActiveService.class));
    }

    private void a(Context context, Intent intent) {
        UtilHelper.a(context, intent);
        TiebaApplication.a((Intent) null);
    }

    private void k() {
        this.x = new af(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.notify");
        intentFilter.addAction("com.baidu.tieba.broadcast.newrecommends");
        registerReceiver(this.x, intentFilter);
    }

    private void l() {
        if (this.x != null) {
            unregisterReceiver(this.x);
        }
    }

    public void m() {
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
        boolean z = this.f985a == 1;
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

    public void n() {
        if (TiebaApplication.aR()) {
            this.o.setVisibility(0);
        } else {
            this.o.setVisibility(8);
        }
    }

    private void o() {
        for (ae aeVar : this.f) {
            aeVar.c.setOnCheckedChangeListener(this);
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
            ae[] aeVarArr = this.f;
            int length = aeVarArr.length;
            while (i2 < length) {
                ae aeVar = aeVarArr[i2];
                com.baidu.tieba.util.bb.e((View) aeVar.c, (int) R.drawable.tabs_btn_bg_1);
                aeVar.c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(aeVar.f), (Drawable) null, (Drawable) null);
                aeVar.c.setTextColor(getResources().getColor(R.color.main_tab_text_1));
                i2++;
            }
            return;
        }
        this.t.setBackgroundResource(R.drawable.maintab_toolbar_bg);
        this.q.setImageResource(R.drawable.icon_maintab_prompt);
        ae[] aeVarArr2 = this.f;
        int length2 = aeVarArr2.length;
        while (i2 < length2) {
            ae aeVar2 = aeVarArr2[i2];
            com.baidu.tieba.util.bb.e((View) aeVar2.c, (int) R.drawable.tabs_btn_bg);
            aeVar2.c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(aeVar2.e), (Drawable) null, (Drawable) null);
            aeVar2.c.setTextColor(getResources().getColor(R.color.white));
            i2++;
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            for (int i = 0; i < this.f.length; i++) {
                ae aeVar = this.f[i];
                if (aeVar.c.getId() == compoundButton.getId()) {
                    if (TiebaApplication.g().s()) {
                        StatService.onEvent(this, aeVar.d, "maintabclick", 1);
                    }
                    this.e = i;
                    a(aeVar, i);
                    return;
                }
            }
        }
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onResume() {
        super.onResume();
        be.e("MainTabActivity", "onResume", "onResume");
        TiebaApplication.g().aC();
        TiebaApplication.g().aD();
        if (!TiebaApplication.n()) {
            if (c == -1) {
                com.baidu.tieba.account.a.a().a(this, 1);
            } else {
                com.baidu.tieba.account.a.a().a(this, c);
                c = -1;
            }
        }
        if (TiebaApplication.g().as() != this.f985a) {
            this.f985a = TiebaApplication.g().as();
            b(this.f985a);
        }
        if (TiebaApplication.C() == null || TiebaApplication.C().length() <= 0) {
            p();
        }
        m();
    }

    private void p() {
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
        TiebaApplication.g().aE();
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
        bundle.putString(SocialConstants.PARAM_URL, "");
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        be.a(getClass().getName(), "onNewIntent", "");
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("close_dialog", false)) {
            q();
        }
        if (intent.getBooleanExtra("refresh_all", false)) {
            this.f[4].b.putExtra("un", TiebaApplication.C());
            this.g.clearAllTabs();
            getLocalActivityManager().removeAllActivities();
            a(intent);
        }
        int intExtra = intent.getIntExtra("locate_type", this.e);
        if (intExtra == 3) {
            MentionActivity.e = true;
        }
        boolean z = this.e != intExtra;
        this.e = intExtra;
        if (intExtra == 1) {
            String stringExtra = intent.getStringExtra("locate_ext");
            if (!TextUtils.isEmpty(stringExtra)) {
                if (String.valueOf(1).equals(stringExtra)) {
                    EnterForumActivity.f1320a = 1;
                } else {
                    EnterForumActivity.f1320a = 0;
                }
            }
        }
        if (intExtra == 200) {
            finish();
        } else if (intExtra >= 0 && intExtra < this.f.length && z) {
            this.f[intExtra].c.setChecked(true);
        }
        a(this, TiebaApplication.e());
    }

    private void q() {
        EnterForumActivity enterForumActivity;
        LocalActivityManager localActivityManager = getLocalActivityManager();
        if (!localActivityManager.getCurrentId().equals(this.f[1].f1064a) && (enterForumActivity = (EnterForumActivity) localActivityManager.getActivity(this.f[1].f1064a)) != null) {
            enterForumActivity.c();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            be.e(getClass().getName(), "dispatchKeyEvent", "KEYCODE_BACK");
            UtilHelper.a((Activity) this);
            return false;
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            openOptionsMenu();
            return true;
        } else {
            return super.dispatchKeyEvent(keyEvent);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0032 A[Catch: Throwable -> 0x0063, TryCatch #1 {Throwable -> 0x0063, blocks: (B:56:0x0001, B:58:0x000b, B:61:0x0011, B:63:0x0016, B:65:0x0023, B:67:0x002d, B:69:0x0032, B:71:0x003a, B:72:0x003e, B:80:0x006a, B:82:0x006e, B:88:0x009f, B:83:0x0074, B:85:0x008d, B:87:0x0094, B:75:0x005f), top: B:94:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x006a A[Catch: Throwable -> 0x0063, TRY_ENTER, TryCatch #1 {Throwable -> 0x0063, blocks: (B:56:0x0001, B:58:0x000b, B:61:0x0011, B:63:0x0016, B:65:0x0023, B:67:0x002d, B:69:0x0032, B:71:0x003a, B:72:0x003e, B:80:0x006a, B:82:0x006e, B:88:0x009f, B:83:0x0074, B:85:0x008d, B:87:0x0094, B:75:0x005f), top: B:94:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x008d A[Catch: Throwable -> 0x0063, TryCatch #1 {Throwable -> 0x0063, blocks: (B:56:0x0001, B:58:0x000b, B:61:0x0011, B:63:0x0016, B:65:0x0023, B:67:0x002d, B:69:0x0032, B:71:0x003a, B:72:0x003e, B:80:0x006a, B:82:0x006e, B:88:0x009f, B:83:0x0074, B:85:0x008d, B:87:0x0094, B:75:0x005f), top: B:94:0x0001 }] */
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
                        intent2 = a(i, intent);
                    }
                    this.f[i].b = intent2;
                    tabHost.addTab(a(this.f[i].f1064a, this.f[i].b));
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

    private Intent a(int i, Intent intent) {
        switch (i) {
            case 0:
                return new Intent(this, ForumFeedActivity.class);
            case 1:
                Intent intent2 = new Intent(this, EnterForumActivity.class);
                intent2.putExtra("curent_tab", intent.getStringExtra("locate_ext"));
                return intent2;
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
            be.b("HomeActivity", "onPrepareOptionsMenu", "exp: " + e.toString());
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
        WriteActivity.a(this, com.baidu.tieba.data.h.h(), com.baidu.tieba.data.h.g(), antiData);
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
