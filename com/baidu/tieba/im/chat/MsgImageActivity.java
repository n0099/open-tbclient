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
    private int p;
    private String q;
    private String r;

    /* renamed from: a  reason: collision with root package name */
    private ProgressBar f1492a = null;
    private ArrayList<String> b = null;
    private int c = 0;
    private ai d = null;
    private Button e = null;
    private Button f = null;
    private TextView g = null;
    private LinearLayout h = null;
    private MultiImageView i = null;
    private View.OnClickListener j = null;
    private com.baidu.tieba.view.a k = null;
    private android.support.v4.view.bq l = null;
    private AlphaAnimation m = null;
    private boolean n = true;
    private boolean o = false;
    private long s = 0;
    private HashMap<String, Boolean> t = null;

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
        a();
        d();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        a();
        d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.i.setBackgroundColor(com.baidu.tieba.util.bd.d(i));
        } else {
            this.i.setBackgroundColor(-16777216);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        this.i.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        this.i.a();
    }

    @Override // com.baidu.tieba.j, com.baidu.adp.a.a
    public void releaseResouce() {
        this.i.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onStop() {
        super.onStop();
        a(this.c, this.c);
        this.i.c();
        if (this.d != null) {
            this.d.cancel();
            this.d = null;
        }
        if (this.f1492a != null) {
            this.f1492a.setVisibility(8);
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

    private void a() {
        this.j = new ad(this);
        this.l = new af(this);
        this.k = new ag(this);
        this.h = (LinearLayout) findViewById(R.id.title);
        this.f1492a = (ProgressBar) findViewById(R.id.progress);
        this.e = (Button) findViewById(R.id.save);
        this.e.setOnClickListener(this.j);
        this.f = (Button) findViewById(R.id.back);
        this.f.setOnClickListener(this.j);
        this.g = (TextView) findViewById(R.id.titel_text);
        this.i = (MultiImageView) findViewById(R.id.viewpager);
        this.i.setPageMargin(UtilHelper.a((Context) this, 8.0f));
        this.i.a(2, com.baidu.tieba.data.h.i() * com.baidu.tieba.data.h.i());
        this.i.setOnPageChangeListener(this.l);
        this.i.setItemOnclickListener(this.j);
        this.i.a(c(), false);
        this.i.setOnScrollOutListener(this.k);
        this.i.setHasNext(false);
        this.i.setNextTitle("mNextTitle");
        this.i.setIsFromCDN(true);
        this.i.setAllowLocalUrl(true);
        a(this.c, this.c);
        this.g.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.b != null) {
            String valueOf = String.valueOf(this.c + 1);
            if (this.p > 0) {
                valueOf = (valueOf + "/") + this.p;
            }
            if (this.i.getHasNext() && this.c == this.i.getItemNum() - 1) {
                this.g.setText(getString(R.string.image_recommend));
                this.e.setVisibility(4);
                return;
            }
            this.g.setText(valueOf);
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
            this.q = intent.getStringExtra("curImgUrl");
            this.r = intent.getStringExtra("groupId");
            this.b = new ArrayList<>();
            this.b.add(this.q);
            this.c = 0;
            com.baidu.adp.lib.h.d.d("curImgUrl:" + this.q + " groupId:" + this.r);
        } else if (bundle != null) {
            com.baidu.adp.lib.h.d.d(" have savedInstanceState");
            this.b = bundle.getStringArrayList(SocialConstants.PARAM_URL);
            this.c = bundle.getInt("index", -1);
            this.r = bundle.getString("groupId");
        } else {
            com.baidu.adp.lib.h.d.d(" not have savedInstanceState");
        }
        this.t = new HashMap<>();
    }

    private void d() {
        if (TextUtils.isEmpty(this.r)) {
            finish();
        }
        a.b().a(this.r, new ah(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList(SocialConstants.PARAM_URL, this.b);
        bundle.putInt("index", this.c);
        bundle.putString("groupId", this.r);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.i.a(this.c, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        synchronized (this.t) {
            if (System.nanoTime() - this.s > 300000000 && this.b != null && i < this.b.size()) {
                this.t.put(this.b.get(i), true);
            }
            this.s = System.nanoTime();
        }
    }
}
