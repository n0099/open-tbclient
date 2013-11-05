package com.baidu.tieba.im.chat;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.MultiImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class MsgImageActivity extends com.baidu.tieba.j {
    private int r;
    private String s;
    private String t;

    /* renamed from: a  reason: collision with root package name */
    private ProgressBar f1400a = null;
    private ArrayList<String> b = null;
    private int c = 0;
    private aj d = null;
    private Button e = null;
    private Button f = null;
    private TextView g = null;
    private LinearLayout j = null;
    private MultiImageView k = null;
    private View.OnClickListener l = null;
    private com.baidu.tieba.view.a m = null;
    private android.support.v4.view.bq n = null;
    private AlphaAnimation o = null;
    private boolean p = true;
    private boolean q = false;
    private long u = 0;
    private HashMap<String, Boolean> v = null;

    public static void a(Context context, String str, long j) {
        if (j != 0 && context != null) {
            Intent intent = new Intent(context, MsgImageActivity.class);
            intent.putExtra("curImgUrl", str);
            intent.putExtra("groupId", String.valueOf(j));
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TiebaApplication.g().a((com.baidu.tieba.j) this);
        setContentView(R.layout.image_activity);
        a(bundle);
        b();
        e();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        b();
        e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void a(int i) {
        super.a(i);
        if (i == 1) {
            this.k.setBackgroundColor(com.baidu.tieba.util.bb.d(i));
        } else {
            this.k.setBackgroundColor(-16777216);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        this.k.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        this.k.a();
    }

    @Override // com.baidu.tieba.j, com.baidu.adp.a.a
    public void a_() {
        this.k.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onStop() {
        super.onStop();
        b(this.c, this.c);
        this.k.c();
        if (this.d != null) {
            this.d.cancel();
            this.d = null;
        }
        if (this.f1400a != null) {
            this.f1400a.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        TiebaApplication.g().b((com.baidu.tieba.j) this);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
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

    private void b() {
        this.l = new ae(this);
        this.n = new ag(this);
        this.m = new ah(this);
        this.j = (LinearLayout) findViewById(R.id.title);
        this.f1400a = (ProgressBar) findViewById(R.id.progress);
        this.e = (Button) findViewById(R.id.save);
        this.e.setOnClickListener(this.l);
        this.f = (Button) findViewById(R.id.back);
        this.f.setOnClickListener(this.l);
        this.g = (TextView) findViewById(R.id.titel_text);
        this.k = (MultiImageView) findViewById(R.id.viewpager);
        this.k.setPageMargin(UtilHelper.a((Context) this, 8.0f));
        this.k.a(2, com.baidu.tieba.data.h.i() * com.baidu.tieba.data.h.i());
        this.k.setOnPageChangeListener(this.n);
        this.k.setItemOnclickListener(this.l);
        this.k.a(d(), false);
        this.k.setOnScrollOutListener(this.m);
        this.k.setHasNext(false);
        this.k.setNextTitle("mNextTitle");
        this.k.setLoadFromCDN(true);
        this.k.setAllowLocalUrl(true);
        b(this.c, this.c);
        this.g.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.b != null) {
            String valueOf = String.valueOf(this.c + 1);
            if (this.r > 0) {
                valueOf = (valueOf + "/") + this.r;
            }
            if (this.k.getHasNext() && this.c == this.k.getItemNum() - 1) {
                this.g.setText(getString(R.string.image_recommend));
                this.e.setVisibility(4);
                return;
            }
            this.g.setText(valueOf);
            this.e.setVisibility(0);
        }
    }

    private int d() {
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
            this.s = intent.getStringExtra("curImgUrl");
            this.t = intent.getStringExtra("groupId");
            this.b = new ArrayList<>();
            this.b.add(this.s);
            this.c = 0;
            com.baidu.adp.lib.h.d.d("curImgUrl:" + this.s + " groupId:" + this.t);
        } else if (bundle != null) {
            com.baidu.adp.lib.h.d.d(" have savedInstanceState");
            this.b = bundle.getStringArrayList(SocialConstants.PARAM_URL);
            this.c = bundle.getInt("index", -1);
            this.t = bundle.getString("groupId");
        } else {
            com.baidu.adp.lib.h.d.d(" not have savedInstanceState");
        }
        this.v = new HashMap<>();
    }

    private void e() {
        if (TextUtils.isEmpty(this.t)) {
            finish();
        }
        a.b().a(this.t, new ai(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList(SocialConstants.PARAM_URL, this.b);
        bundle.putInt("index", this.c);
        bundle.putString("groupId", this.t);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.k.a(this.c, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2) {
        synchronized (this.v) {
            if (System.nanoTime() - this.u > 300000000 && this.b != null && i < this.b.size()) {
                this.v.put(this.b.get(i), true);
            }
            this.u = System.nanoTime();
        }
    }
}
