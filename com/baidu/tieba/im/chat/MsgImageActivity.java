package com.baidu.tieba.im.chat;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.MultiImageView;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class MsgImageActivity extends com.baidu.tieba.f {
    private FrameLayout g;
    private int q;
    private String r;
    private String s;
    private boolean w;
    private ProgressBar a = null;
    private ArrayList<String> b = null;
    private int c = 0;
    private bp d = null;
    private TextView e = null;
    private ImageView f = null;
    private TextView h = null;
    private NavigationBar i = null;
    private MultiImageView j = null;
    private View.OnClickListener k = null;
    private com.baidu.tieba.view.a l = null;
    private ViewPager.OnPageChangeListener m = null;
    private AlphaAnimation n = null;
    private boolean o = true;
    private boolean p = false;
    private long t = 0;
    private HashMap<String, Boolean> u = null;
    private int v = 0;

    public static void a(Context context, String str, long j, boolean z) {
        if (j != 0 && context != null) {
            Intent intent = new Intent(context, MsgImageActivity.class);
            intent.putExtra("current_url", str);
            intent.putExtra("id", String.valueOf(j));
            intent.putExtra("chat_mode", 0);
            intent.putExtra("isSingle", z);
            context.startActivity(intent);
        }
    }

    public static void a(Context context, String str, long j) {
        if (j != 0 && context != null) {
            Intent intent = new Intent(context, MsgImageActivity.class);
            intent.putExtra("current_url", str);
            intent.putExtra("id", String.valueOf(j));
            intent.putExtra("chat_mode", 1);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TiebaApplication.g().a((com.baidu.tieba.f) this);
        setContentView(R.layout.image_activity_2);
        a(bundle);
        a();
        d();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.j.setBackgroundColor(com.baidu.tieba.util.bq.d(i));
        } else {
            this.j.setBackgroundColor(-16777216);
        }
        this.i.c(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onPause() {
        super.onPause();
        this.j.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        super.onResume();
        this.j.a();
    }

    @Override // com.baidu.tieba.f, com.baidu.adp.a.a
    public void releaseResouce() {
        this.j.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onStop() {
        super.onStop();
        a(this.c, this.c);
        this.j.c();
        if (this.d != null) {
            this.d.cancel();
            this.d = null;
        }
        if (this.a != null) {
            this.a.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        TiebaApplication.g().b((com.baidu.tieba.f) this);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.f, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            Intent intent = new Intent();
            intent.putExtra("index", this.c);
            setResult(-1, intent);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void a() {
        this.k = new bk(this);
        this.m = new bm(this);
        this.l = new bn(this);
        this.i = (NavigationBar) findViewById(R.id.navigation_bar);
        this.g = (FrameLayout) this.i.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, this.k);
        if (this.w) {
            this.g.setVisibility(8);
        }
        this.a = (ProgressBar) findViewById(R.id.progress);
        this.e = (TextView) findViewById(R.id.save);
        this.f = this.i.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.k);
        this.h = this.i.a("");
        this.e.setClickable(false);
        this.j = (MultiImageView) findViewById(R.id.viewpager);
        this.j.setPageMargin(BdUtilHelper.a((Context) this, 8.0f));
        this.j.a(2, com.baidu.tieba.data.i.t() * com.baidu.tieba.data.i.t());
        this.j.setOnPageChangeListener(this.m);
        this.j.setItemOnclickListener(this.k);
        this.j.a(c(), false);
        this.j.setOnScrollOutListener(this.l);
        this.j.setHasNext(false);
        this.j.setNextTitle("mNextTitle");
        this.j.setIsFromCDN(true);
        this.j.setAllowLocalUrl(true);
        a(this.c, this.c);
        this.h.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.b != null) {
            String valueOf = String.valueOf(this.c + 1);
            if (this.q > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + this.q;
            }
            if (this.j.getHasNext() && this.c == this.j.getItemNum() - 1) {
                this.h.setText(getString(R.string.image_recommend));
                this.e.setVisibility(4);
                return;
            }
            this.h.setText(valueOf);
            this.e.setVisibility(0);
        }
    }

    private int c() {
        if (this.b != null && this.b.size() > 0) {
            int size = this.b.size();
            if (this.c >= size) {
                this.c = size - 1;
            }
            if (this.c < 0) {
                this.c = 0;
            }
        } else {
            this.c = 0;
        }
        return this.c;
    }

    private void a(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.r = intent.getStringExtra("current_url");
            this.s = intent.getStringExtra("id");
            this.w = intent.getBooleanExtra("isSingle", false);
            this.b = new ArrayList<>();
            this.b.add(this.r);
            this.v = intent.getIntExtra("chat_mode", 0);
            this.c = 0;
            com.baidu.adp.lib.util.f.e("curImgUrl:" + this.r + " groupId:" + this.s);
        } else if (bundle != null) {
            com.baidu.adp.lib.util.f.e(" have savedInstanceState");
            this.b = bundle.getStringArrayList(SocialConstants.PARAM_URL);
            this.c = bundle.getInt("index", -1);
            this.s = bundle.getString("id");
            this.v = bundle.getInt("chat_mode", 0);
            this.w = bundle.getBoolean("isSingle", false);
        } else {
            com.baidu.adp.lib.util.f.e(" not have savedInstanceState");
        }
        this.u = new HashMap<>();
    }

    private void d() {
        if (TextUtils.isEmpty(this.s)) {
            finish();
        }
        bo boVar = new bo(this);
        if (this.v == 0 || this.v == 2) {
            q.b().a(this.s, boVar);
        } else {
            q.b().b(this.s, boVar);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList(SocialConstants.PARAM_URL, this.b);
        bundle.putInt("index", this.c);
        bundle.putString("id", this.s);
        bundle.putInt("chat_mode", this.v);
        bundle.putBoolean("isSingle", this.w);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.j.a(this.c, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        synchronized (this.u) {
            if (System.nanoTime() - this.t > 300000000 && this.b != null && i < this.b.size()) {
                this.u.put(this.b.get(i), true);
            }
            this.t = System.nanoTime();
        }
    }
}
