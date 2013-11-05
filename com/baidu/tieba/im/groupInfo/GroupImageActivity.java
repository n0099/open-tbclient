package com.baidu.tieba.im.groupInfo;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.bq;
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
import com.baidu.tieba.util.bb;
import com.baidu.tieba.view.MultiImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class GroupImageActivity extends com.baidu.tieba.j {
    private int r;
    private String s;

    /* renamed from: a  reason: collision with root package name */
    private ProgressBar f1590a = null;
    private ArrayList<String> b = null;
    private int c = 0;
    private h d = null;
    private Button e = null;
    private Button f = null;
    private TextView g = null;
    private LinearLayout j = null;
    private MultiImageView k = null;
    private View.OnClickListener l = null;
    private com.baidu.tieba.view.a m = null;
    private bq n = null;
    private AlphaAnimation o = null;
    private boolean p = true;
    private boolean q = false;
    private long t = 0;
    private HashMap<String, Boolean> u = null;

    public static void a(Context context, String str, ArrayList<String> arrayList, long j) {
        if (j != 0 && context != null) {
            Intent intent = new Intent(context, GroupImageActivity.class);
            intent.putExtra("curImgUrl", str);
            intent.putExtra("groupId", String.valueOf(j));
            intent.putExtra(SocialConstants.PARAM_URL, arrayList);
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
        int size = this.b.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            String str = this.b.get(i);
            if (!TextUtils.isEmpty(str)) {
                com.baidu.adp.lib.h.d.d("get img url :" + str);
                if (str.equals(this.s)) {
                    com.baidu.adp.lib.h.d.d("get img idx:" + i);
                    this.c = i;
                    break;
                }
            }
            i++;
        }
        this.r = size;
        this.g.setVisibility(0);
        c();
        this.k.setLoadFromCDN(true);
        this.k.setAllowLocalUrl(true);
        this.k.setUrlData(this.b);
        this.k.a(this.c, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void a(int i) {
        super.a(i);
        if (i == 1) {
            this.k.setBackgroundColor(bb.d(i));
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
    public void onDestroy() {
        TiebaApplication.g().b((com.baidu.tieba.j) this);
        b(this.c, this.c);
        this.k.c();
        if (this.d != null) {
            this.d.cancel();
            this.d = null;
        }
        if (this.f1590a != null) {
            this.f1590a.setVisibility(8);
        }
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
        this.l = new d(this);
        this.n = new f(this);
        this.m = new g(this);
        this.j = (LinearLayout) findViewById(R.id.title);
        this.f1590a = (ProgressBar) findViewById(R.id.progress);
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
        if (bundle != null) {
            com.baidu.adp.lib.h.d.d(" have savedInstanceState");
            this.b = bundle.getStringArrayList(SocialConstants.PARAM_URL);
            this.c = bundle.getInt("index", -1);
            this.s = bundle.getString("curImgUrl");
        } else {
            com.baidu.adp.lib.h.d.d(" not have savedInstanceState");
            Intent intent = getIntent();
            if (intent != null) {
                this.b = intent.getStringArrayListExtra(SocialConstants.PARAM_URL);
                this.s = intent.getStringExtra("curImgUrl");
                this.c = 0;
            }
        }
        this.u = new HashMap<>();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList(SocialConstants.PARAM_URL, this.b);
        bundle.putInt("index", this.c);
        bundle.putString("curImgUrl", this.s);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.k.a(this.c, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2) {
        synchronized (this.u) {
            if (System.nanoTime() - this.t > 300000000 && this.b != null && i < this.b.size()) {
                this.u.put(this.b.get(i), true);
            }
            this.t = System.nanoTime();
        }
    }
}
