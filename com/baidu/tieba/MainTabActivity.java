package com.baidu.tieba;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
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
import com.baidu.tieba.util.bd;
import com.baidu.tieba.util.bg;
import com.baidu.tieba.util.bh;
import com.baidu.tieba.voice.VoiceManager;
import com.baidu.tieba.write.WriteActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class MainTabActivity extends BaseFragmentActivity implements CompoundButton.OnCheckedChangeListener, com.baidu.tieba.voice.af {
    private static boolean c = false;
    private static int d = -1;
    private ag[] g;
    private BaseFragment y;
    private VoiceManager z;
    private final int e = 5;
    private int f = 1;
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
    private AlertDialog t = null;
    private com.baidu.tieba.view.am u = null;
    private com.baidu.tieba.view.ag v = null;
    private long w = 0;
    private long x = 2000;
    protected int b = -1;
    private ah A = null;

    protected void c() {
        this.g = new ag[5];
        ag agVar = new ag(null);
        agVar.b = new ForumFeedActivity();
        agVar.f = R.drawable.tabs_recommend;
        agVar.g = R.drawable.tabs_recommend_1;
        agVar.e = "maintab_home";
        agVar.f1100a = "view_1";
        agVar.d = (RadioButton) findViewById(R.id.radio_recommend);
        this.g[0] = agVar;
        ag agVar2 = new ag(null);
        agVar2.b = new EnterForumActivity();
        agVar2.f = R.drawable.tabs_home;
        agVar2.g = R.drawable.tabs_home_1;
        agVar2.e = "maintab_enterforum";
        agVar2.f1100a = "view_2";
        agVar2.d = (RadioButton) findViewById(R.id.radio_home);
        this.g[1] = agVar2;
        ag agVar3 = new ag(null);
        agVar3.b = new SquareActivity();
        agVar3.f = R.drawable.tabs_square;
        agVar3.g = R.drawable.tabs_square_1;
        agVar3.e = "maintab_square";
        agVar3.f1100a = "view_3";
        agVar3.d = (RadioButton) findViewById(R.id.radio_square);
        this.g[2] = agVar3;
        ag agVar4 = new ag(null);
        agVar4.b = new MentionActivity();
        agVar4.f = R.drawable.tabs_message;
        agVar4.g = R.drawable.tabs_message_1;
        agVar4.e = "maintab_message";
        agVar4.f1100a = "view_4";
        agVar4.d = (RadioButton) findViewById(R.id.radio_message);
        this.g[3] = agVar4;
        ag agVar5 = new ag(null);
        agVar5.b = new PersonInfoActivity();
        Bundle bundle = new Bundle();
        bundle.putBoolean("self", true);
        bundle.putBoolean("tab_page", true);
        bundle.putString("un", TiebaApplication.A());
        agVar5.b.g(bundle);
        agVar5.f = R.drawable.tabs_search;
        agVar5.g = R.drawable.tabs_search_1;
        agVar5.e = "maintab_personal";
        agVar5.f1100a = "view_5";
        agVar5.d = (RadioButton) findViewById(R.id.radio_person_info);
        this.g[4] = agVar5;
    }

    protected void a(ag agVar, int i) {
        if (this.y != agVar.b) {
            if (i == 4) {
                agVar.b.h().putString("un", TiebaApplication.A());
            } else if (i == 3) {
                MentionActivity.b = true;
                p();
            }
            android.support.v4.app.ae a2 = getSupportFragmentManager().a();
            if (this.y != null) {
                a2.b(this.y);
            }
            if (agVar.c) {
                a2.c(agVar.b);
            } else {
                a2.a(R.id.tabcontent, agVar.b);
                agVar.c = true;
            }
            a2.b();
            this.y = agVar.b;
        }
    }

    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (d()) {
            CompatibleUtile.getInstance().openGpu(this);
        }
        bg.a(getClass().toString(), "onCreate", "debug");
        setContentView(R.layout.maintabs_activity);
        c();
        TiebaApplication.g().a((Boolean) false);
        this.n = (TextView) findViewById(R.id.message_message);
        this.m = (TextView) findViewById(R.id.message_person);
        this.o = (ImageView) findViewById(R.id.new_version_logo);
        this.p = (ImageView) findViewById(R.id.new_recommends_logo);
        this.q = (ImageView) findViewById(R.id.new_bookmark_logo);
        e();
        r();
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (bundle != null) {
            intent.putExtra("locate_type", bundle.getInt("locate_type", this.f));
        }
        a(intent);
        j();
        if (TiebaApplication.y() != null && TiebaApplication.y().equals("aishide")) {
            l();
        }
        n();
        i();
        com.baidu.tieba.mention.t.a().i();
        a(this, TiebaApplication.e());
        String J = TiebaApplication.g().J();
        if (J != null && J.length() > 0) {
            UtilHelper.b(TiebaApplication.g(), J);
            TiebaApplication.g().l((String) null);
        }
        this.z = g();
        this.z.a((Activity) this);
    }

    @Override // android.support.v4.app.n, android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.z != null) {
            this.z.b((Activity) this);
        }
    }

    public static void c(int i) {
        d = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        a(1.0f);
        if (this.u != null) {
            this.u.a(null);
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
        String A = TiebaApplication.A();
        if (A != null && A.length() > 0) {
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

    public boolean d() {
        return TiebaApplication.g().u();
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
        bg.a(getClass().getName(), "onDestroy", "");
        k();
        m();
        o();
        com.baidu.tieba.mention.t.a().g();
        com.baidu.tieba.mention.t.a().k();
        com.baidu.tieba.mention.t.a().a(false);
        com.baidu.tbadk.imageManager.d.a().c();
        if (this.s != null) {
            this.s.dismiss();
            this.s = null;
        }
        if (this.t != null) {
            this.t.dismiss();
            this.t = null;
        }
        if (this.r != null) {
            this.r.removeMessages(1);
        }
        if (this.v != null) {
            this.v.a();
        }
        bh.a();
        if (this.z != null) {
            this.z.g(this);
        }
        super.onDestroy();
        System.gc();
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        try {
            super.onRestoreInstanceState(bundle);
        } catch (Throwable th) {
            com.baidu.adp.lib.h.d.a(getClass(), "onRestoreInstanceState", th);
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
        this.A = new ah(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.notify");
        intentFilter.addAction("com.baidu.tieba.broadcast.newrecommends");
        registerReceiver(this.A, intentFilter);
    }

    private void o() {
        if (this.A != null) {
            unregisterReceiver(this.A);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
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
        boolean z = this.b == 1;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (TiebaApplication.aP()) {
            this.o.setVisibility(0);
        } else {
            this.o.setVisibility(8);
        }
    }

    private void r() {
        for (ag agVar : this.g) {
            agVar.d.setOnCheckedChangeListener(this);
        }
    }

    public void e() {
        this.p.setVisibility(8);
    }

    public void d(int i) {
        int i2 = 0;
        if (i == 1) {
            this.q.setImageResource(R.drawable.icon_maintab_prompt_1);
            ag[] agVarArr = this.g;
            int length = agVarArr.length;
            while (i2 < length) {
                ag agVar = agVarArr[i2];
                bd.e((View) agVar.d, (int) R.drawable.tabs_btn_bg_1);
                agVar.d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(agVar.g), (Drawable) null, (Drawable) null);
                agVar.d.setTextColor(getResources().getColorStateList(R.color.main_bottom_button_color_1));
                i2++;
            }
            return;
        }
        this.q.setImageResource(R.drawable.icon_maintab_prompt);
        ag[] agVarArr2 = this.g;
        int length2 = agVarArr2.length;
        while (i2 < length2) {
            ag agVar2 = agVarArr2[i2];
            bd.e((View) agVar2.d, (int) R.drawable.tabs_btn_bg);
            agVar2.d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(agVar2.f), (Drawable) null, (Drawable) null);
            agVar2.d.setTextColor(getResources().getColorStateList(R.color.main_bottom_button_color));
            i2++;
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            for (int i = 0; i < this.g.length; i++) {
                ag agVar = this.g[i];
                if (agVar.d.getId() == compoundButton.getId()) {
                    if (TiebaApplication.g().s()) {
                        StatService.onEvent(this, agVar.e, "maintabclick", 1);
                    }
                    this.f = i;
                    a(agVar, i);
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity
    protected void onResume() {
        super.onResume();
        bg.e("MainTabActivity", "onResume", "onResume");
        TiebaApplication.g().az();
        TiebaApplication.g().aA();
        if (!TiebaApplication.n()) {
            if (d == -1) {
                com.baidu.tieba.account.a.a().a(this, 1);
            } else {
                com.baidu.tieba.account.a.a().a(this, d);
                d = -1;
            }
        }
        if (TiebaApplication.g().ap() != this.b) {
            this.b = TiebaApplication.g().ap();
            d(this.b);
        }
        if (TiebaApplication.A() == null || TiebaApplication.A().length() <= 0) {
            s();
        }
        p();
    }

    private void s() {
        this.h = 0L;
        this.i = 0L;
        this.j = 0L;
        this.k = 0L;
        this.l = 0L;
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
        if (this.u != null) {
            this.u.dismiss();
        }
    }

    @Override // android.support.v4.app.n, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("locate_type", this.f);
        bundle.putString("pb_id", "");
        bundle.putString("frs_name", "");
        bundle.putString(SocialConstants.PARAM_URL, "");
        bundle.putParcelable("android:support:fragments", null);
    }

    @Override // android.support.v4.app.n, android.app.Activity
    protected void onStop() {
        super.onStop();
        if (this.z != null) {
            this.z.f(this);
        }
    }

    @Override // android.support.v4.app.n, android.app.Activity
    protected void onNewIntent(Intent intent) {
        bg.a(getClass().getName(), "onNewIntent", "");
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("close_dialog", false)) {
            t();
        }
        if (intent.getBooleanExtra("refresh_all", false)) {
            android.support.v4.app.ae a2 = getSupportFragmentManager().a();
            int length = this.g.length;
            for (int i = 0; i < length; i++) {
                ag agVar = this.g[i];
                if (agVar.b != null && agVar.c) {
                    a2.a(agVar.b);
                    agVar.c = false;
                }
            }
            a2.b();
            this.y = null;
            c();
            a(intent);
        }
        int intExtra = intent.getIntExtra("locate_type", this.f);
        this.f = intExtra;
        if (intExtra == 1) {
            String stringExtra = intent.getStringExtra("locate_ext");
            if (!TextUtils.isEmpty(stringExtra)) {
                if (String.valueOf(1).equals(stringExtra)) {
                    EnterForumActivity.f1388a = 1;
                } else {
                    EnterForumActivity.f1388a = 0;
                }
            }
        }
        if (intExtra == 200) {
            finish();
        } else if (intExtra >= 0 && intExtra < this.g.length) {
            this.g[intExtra].d.setChecked(true);
        }
        a(this, TiebaApplication.e());
    }

    private void t() {
        EnterForumActivity enterForumActivity;
        if (this.f != 1 && this.g[1].b.n() && (enterForumActivity = (EnterForumActivity) this.g[1].b) != null) {
            enterForumActivity.G();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            bg.e(getClass().getName(), "dispatchKeyEvent", "KEYCODE_BACK");
            if ((TiebaApplication.A() == null && this.f == 2) || (TiebaApplication.A() != null && this.f == 1)) {
                if (System.currentTimeMillis() - this.w > this.x) {
                    b(R.string.double_back_quit);
                    this.w = System.currentTimeMillis();
                } else {
                    moveTaskToBack(true);
                }
            } else if (TiebaApplication.A() == null) {
                this.g[2].d.performClick();
            } else {
                this.g[1].d.performClick();
            }
            return false;
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            openOptionsMenu();
            return true;
        } else {
            return super.dispatchKeyEvent(keyEvent);
        }
    }

    private void a(Intent intent) {
        try {
            int intExtra = intent.getIntExtra("locate_type", this.f);
            if (intExtra >= 0 && intExtra < this.g.length) {
                this.f = intExtra;
                this.g[this.f].d.setChecked(true);
                a(this.g[this.f], this.f);
            }
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
            if (!TiebaApplication.n()) {
                menu.findItem(2).setVisible(true);
            }
            menu.findItem(3).setVisible(true);
            menu.findItem(4).setVisible(true);
            menu.findItem(5).setVisible(true);
        } catch (Exception e) {
            bg.b("HomeActivity", "onPrepareOptionsMenu", "exp: " + e.toString());
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
                    f();
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

    protected void f() {
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
        } else if (i == 11001) {
            f();
        } else if (this.y != null) {
            this.y.a(i, i2, intent);
        }
    }

    @Override // com.baidu.tieba.BaseFragmentActivity
    protected void a(int i) {
    }

    @Override // com.baidu.tieba.voice.af
    public VoiceManager g() {
        if (this.z == null) {
            this.z = new VoiceManager();
        }
        return this.z;
    }

    @Override // com.baidu.tieba.voice.af
    public com.baidu.tieba.voice.ad a(VoiceManager.VoiceModel voiceModel) {
        return null;
    }
}
