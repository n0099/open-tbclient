package com.baidu.tieba.im.groupInfo;

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
import com.baidu.tieba.util.bq;
import com.baidu.tieba.view.MultiImageView;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class GroupImageActivity extends com.baidu.tieba.f {
    private FrameLayout g;
    private int q;
    private String r;
    private ProgressBar a = null;
    private ArrayList<String> b = null;
    private int c = 0;
    private h d = null;
    private NavigationBar e = null;
    private TextView f = null;
    private ImageView h = null;
    private TextView i = null;
    private MultiImageView j = null;
    private View.OnClickListener k = null;
    private com.baidu.tieba.view.a l = null;
    private ViewPager.OnPageChangeListener m = null;
    private AlphaAnimation n = null;
    private boolean o = true;
    private boolean p = false;
    private long s = 0;
    private HashMap<String, Boolean> t = null;

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
    /* JADX WARN: Code restructure failed: missing block: B:13:0x00fa, code lost:
        if (r7.c < 0) goto L28;
     */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TiebaApplication.g().a(this);
        setContentView(R.layout.image_activity_2);
        if (bundle != null) {
            com.baidu.adp.lib.util.e.e(" have savedInstanceState");
            this.b = bundle.getStringArrayList(SocialConstants.PARAM_URL);
            this.c = bundle.getInt("index", -1);
            this.r = bundle.getString("curImgUrl");
        } else {
            com.baidu.adp.lib.util.e.e(" not have savedInstanceState");
            Intent intent = getIntent();
            if (intent != null) {
                this.b = intent.getStringArrayListExtra(SocialConstants.PARAM_URL);
                this.r = intent.getStringExtra("curImgUrl");
                this.c = 0;
            }
        }
        this.t = new HashMap<>();
        this.k = new d(this);
        this.m = new f(this);
        this.l = new g(this);
        this.e = (NavigationBar) findViewById(R.id.navigation_bar);
        this.g = (FrameLayout) this.e.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, this.k);
        this.h = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.i = this.e.a("");
        this.a = (ProgressBar) findViewById(R.id.progress);
        this.f = (TextView) findViewById(R.id.save);
        this.f.setClickable(false);
        this.g.setOnClickListener(this.k);
        this.h.setOnClickListener(this.k);
        this.j = (MultiImageView) findViewById(R.id.viewpager);
        this.j.setPageMargin(BdUtilHelper.a((Context) this, 8.0f));
        this.j.a(2, com.baidu.tieba.data.i.t() * com.baidu.tieba.data.i.t());
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
        int i = this.c;
        int i2 = this.c;
        a(i);
        this.i.setVisibility(4);
        int size2 = this.b.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size2) {
                break;
            }
            String str = this.b.get(i3);
            if (!TextUtils.isEmpty(str)) {
                com.baidu.adp.lib.util.e.e("get img url :" + str);
                if (str.equals(this.r)) {
                    com.baidu.adp.lib.util.e.e("get img idx:" + i3);
                    this.c = i3;
                    break;
                }
            }
            i3++;
        }
        this.q = size2;
        this.i.setVisibility(0);
        a();
        this.j.setIsFromCDN(true);
        this.j.setAllowLocalUrl(true);
        this.j.setUrlData(this.b);
        this.j.a(this.c, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.j.setBackgroundColor(bq.d(i));
        } else {
            this.j.setBackgroundColor(-16777216);
        }
        this.e.b(i);
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
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        TiebaApplication.g().b(this);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.b != null) {
            String valueOf = String.valueOf(this.c + 1);
            if (this.q > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + this.q;
            }
            if (this.j.getHasNext() && this.c == this.j.getItemNum() - 1) {
                this.i.setText(getString(R.string.image_recommend));
                this.f.setVisibility(4);
                return;
            }
            this.i.setText(valueOf);
            this.f.setVisibility(0);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList(SocialConstants.PARAM_URL, this.b);
        bundle.putInt("index", this.c);
        bundle.putString("curImgUrl", this.r);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.j.a(this.c, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        synchronized (this.t) {
            if (System.nanoTime() - this.s > 300000000 && this.b != null && i < this.b.size()) {
                this.t.put(this.b.get(i), true);
            }
            this.s = System.nanoTime();
        }
    }
}
