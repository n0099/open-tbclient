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
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class GroupImageActivity extends BaseActivity {
    private FrameLayout g;
    private int q;
    private String r;
    private ProgressBar a = null;
    private ArrayList<String> b = null;
    private int c = 0;
    private i d = null;
    private NavigationBar e = null;
    private TextView f = null;
    private View h = null;
    private TextView i = null;
    private MultiImageView j = null;
    private View.OnClickListener k = null;
    private com.baidu.tbadk.core.view.a l = null;
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
            intent.putExtra("url", arrayList);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkApplication.m252getInst().addRemoteActivity(this);
        setContentView(com.baidu.tieba.s.image_activity_2);
        a(bundle);
        a();
        int size = this.b.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            String str = this.b.get(i);
            if (!TextUtils.isEmpty(str)) {
                BdLog.d("get img url :" + str);
                if (str.equals(this.r)) {
                    BdLog.d("get img idx:" + i);
                    this.c = i;
                    break;
                }
            }
            i++;
        }
        this.q = size;
        this.i.setVisibility(0);
        b();
        this.j.setIsFromCDN(true);
        this.j.setAllowLocalUrl(true);
        this.j.setUrlData(this.b);
        this.j.a(this.c, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.j.setBackgroundColor(bc.d(i));
        } else {
            this.j.setBackgroundColor(-16777216);
        }
        this.e.c(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.j.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.j.a();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.j.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkApplication.m252getInst().delRemoteActivity(this);
        a(this.c, this.c);
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

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
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
        this.k = new e(this);
        this.m = new g(this);
        this.l = new h(this);
        this.e = (NavigationBar) findViewById(com.baidu.tieba.r.navigation_bar);
        this.g = (FrameLayout) this.e.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.s.image_activity_save_button, this.k);
        this.h = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.i = this.e.a("");
        this.a = (ProgressBar) findViewById(com.baidu.tieba.r.progress);
        this.f = (TextView) findViewById(com.baidu.tieba.r.save);
        this.f.setClickable(false);
        this.g.setOnClickListener(this.k);
        this.h.setOnClickListener(this.k);
        this.j = (MultiImageView) findViewById(com.baidu.tieba.r.viewpager);
        this.j.setPageMargin(com.baidu.adp.lib.util.h.a((Context) this, 8.0f));
        this.j.a(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.j.setOnPageChangeListener(this.m);
        this.j.setItemOnclickListener(this.k);
        this.j.a(c(), false);
        this.j.setOnScrollOutListener(this.l);
        this.j.setHasNext(false);
        this.j.setNextTitle("mNextTitle");
        a(this.c, this.c);
        this.i.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.b != null) {
            String valueOf = String.valueOf(this.c + 1);
            if (this.q > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + this.q;
            }
            if (this.j.getHasNext() && this.c == this.j.getItemNum() - 1) {
                this.i.setText(getString(com.baidu.tieba.u.image_recommend));
                this.f.setVisibility(4);
                return;
            }
            this.i.setText(valueOf);
            this.f.setVisibility(0);
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
        if (bundle != null) {
            BdLog.d(" have savedInstanceState");
            this.b = bundle.getStringArrayList("url");
            this.c = bundle.getInt("index", -1);
            this.r = bundle.getString("curImgUrl");
        } else {
            BdLog.d(" not have savedInstanceState");
            Intent intent = getIntent();
            if (intent != null) {
                this.b = intent.getStringArrayListExtra("url");
                this.r = intent.getStringExtra("curImgUrl");
                this.c = 0;
            }
        }
        this.t = new HashMap<>();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("url", this.b);
        bundle.putInt("index", this.c);
        bundle.putString("curImgUrl", this.r);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.j.a(this.c, true);
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
