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
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.tbadk.a {
    private FrameLayout g;
    private int q;
    private String r;
    private String s;
    private boolean w;
    private ProgressBar a = null;
    private ArrayList<String> b = null;
    private int c = 0;
    private g d = null;
    private TextView e = null;
    private View f = null;
    private TextView h = null;
    private NavigationBar i = null;
    private MultiImageView j = null;
    private View.OnClickListener k = null;
    private com.baidu.tbadk.core.view.a l = null;
    private ViewPager.OnPageChangeListener m = null;
    private AlphaAnimation n = null;
    private boolean o = true;
    private boolean p = false;
    private long t = 0;
    private HashMap<String, Boolean> u = null;
    private int v = 0;

    protected abstract void a(String str, bz bzVar);

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0129, code lost:
        if (r6.c < 0) goto L19;
     */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkApplication.j().a(this);
        setContentView(com.baidu.tieba.im.i.image_activity_2);
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
            this.b = bundle.getStringArrayList("url");
            this.c = bundle.getInt("index", -1);
            this.s = bundle.getString("id");
            this.v = bundle.getInt("chat_mode", 0);
            this.w = bundle.getBoolean("isSingle", false);
        } else {
            com.baidu.adp.lib.util.f.e(" not have savedInstanceState");
        }
        this.u = new HashMap<>();
        this.k = new b(this);
        this.m = new d(this);
        this.l = new e(this);
        this.i = (NavigationBar) findViewById(com.baidu.tieba.im.h.navigation_bar);
        this.g = (FrameLayout) this.i.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.im.i.image_activity_save_button, this.k);
        if (this.w) {
            this.g.setVisibility(8);
        }
        this.a = (ProgressBar) findViewById(com.baidu.tieba.im.h.progress);
        this.e = (TextView) findViewById(com.baidu.tieba.im.h.save);
        this.f = this.i.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.k);
        this.h = this.i.a("");
        this.e.setClickable(false);
        this.j = (MultiImageView) findViewById(com.baidu.tieba.im.h.viewpager);
        this.j.setPageMargin(com.baidu.adp.lib.util.i.a((Context) this, 8.0f));
        this.j.a(2, com.baidu.tbadk.core.data.n.u() * com.baidu.tbadk.core.data.n.u());
        this.j.setOnPageChangeListener(this.m);
        this.j.setItemOnclickListener(this.k);
        MultiImageView multiImageView = this.j;
        if (this.b != null && this.b.size() > 0) {
            int size = this.b.size();
            if (this.c >= size) {
                this.c = size - 1;
            }
        }
        this.c = 0;
        multiImageView.a(this.c, false);
        this.j.setOnScrollOutListener(this.l);
        this.j.setHasNext(false);
        this.j.setNextTitle("mNextTitle");
        this.j.setIsFromCDN(true);
        this.j.setAllowLocalUrl(true);
        int i = this.c;
        int i2 = this.c;
        a(i);
        this.h.setVisibility(4);
        a();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.j.setBackgroundColor(com.baidu.tbadk.core.util.ba.d(i));
        } else {
            this.j.setBackgroundColor(-16777216);
        }
        this.i.b(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onPause() {
        super.onPause();
        this.j.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
        this.j.a();
    }

    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a
    public void releaseResouce() {
        this.j.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onStop() {
        super.onStop();
        int i = this.c;
        int i2 = this.c;
        a(i);
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
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        TbadkApplication.j().b(this);
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.a, android.app.Activity, android.view.KeyEvent.Callback
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void l(a aVar) {
        if (aVar.b != null) {
            String valueOf = String.valueOf(aVar.c + 1);
            if (aVar.q > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + aVar.q;
            }
            if (aVar.j.getHasNext() && aVar.c == aVar.j.getItemNum() - 1) {
                aVar.h.setText(aVar.getString(com.baidu.tieba.im.j.image_recommend));
                aVar.e.setVisibility(4);
                return;
            }
            aVar.h.setText(valueOf);
            aVar.e.setVisibility(0);
        }
    }

    private void a() {
        if (TextUtils.isEmpty(this.s)) {
            finish();
        }
        a(this.s, new f(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("url", this.b);
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
    public void a(int i) {
        synchronized (this.u) {
            if (System.nanoTime() - this.t > 300000000 && this.b != null && i < this.b.size()) {
                this.u.put(this.b.get(i), true);
            }
            this.t = System.nanoTime();
        }
    }
}
