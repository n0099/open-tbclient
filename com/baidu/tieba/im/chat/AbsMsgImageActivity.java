package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AbsMsgImageActivityConfig;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.im.c.ad;
import com.baidu.tieba.u;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public abstract class AbsMsgImageActivity extends BaseActivity<AbsMsgImageActivity> {
    private String cGF;
    private boolean cGK;
    private FrameLayout cGx;
    private int nL;
    private LinkedHashMap<String, String> cGv = null;
    private int mIndex = 0;
    private a cGw = null;
    private View agC = null;
    private TextView Tl = null;
    private NavigationBar cGy = null;
    private MultiImageView cGz = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a cGA = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation cGB = null;
    private boolean cGC = true;
    private boolean cGD = false;
    private String cGE = "";
    private String id = "";
    private String cGG = "";
    private long cGH = 0;
    private HashMap<String, Boolean> cGI = null;
    private int cGJ = 0;

    protected abstract void a(String str, ad adVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m10getInst().addRemoteActivity(this);
        setContentView(u.h.image_activity_2);
        initData(bundle);
        initUI();
        akD();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        akD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.cGz.setBackgroundColor(com.baidu.tbadk.core.util.av.cy(i));
        } else {
            this.cGz.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        com.baidu.tbadk.core.util.av.l(this.cGy, u.d.common_color_10222);
        getLayoutMode().w(this.agC);
        getLayoutMode().w(this.Tl);
        getLayoutMode().w(this.cGx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.cGz.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cGz.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.cGz.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        aJ(this.mIndex, this.mIndex);
        this.cGz.onDestroy();
        if (this.cGw != null) {
            this.cGw.cancel();
            this.cGw = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.m10getInst().delRemoteActivity(this);
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            Intent intent = new Intent();
            intent.putExtra("index", this.mIndex);
            setResult(-1, intent);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void initUI() {
        this.mOnClickListener = new com.baidu.tieba.im.chat.a(this);
        this.mOnPageChangeListener = new c(this);
        this.cGA = new d(this);
        f fVar = new f(this, new e(this));
        this.cGy = (NavigationBar) findViewById(u.g.navigation_bar);
        this.cGx = (FrameLayout) this.cGy.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.image_activity_save_button, this.mOnClickListener);
        if (this.cGK) {
            this.cGx.setVisibility(8);
        }
        this.agC = this.cGy.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.Tl = this.cGy.setTitleText("");
        this.cGz = (MultiImageView) findViewById(u.g.viewpager);
        this.cGz.setPageMargin(com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), 8.0f));
        this.cGz.A(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.cGz.setOnPageChangeListener(this.mOnPageChangeListener);
        this.cGz.setItemOnclickListener(this.mOnClickListener);
        this.cGz.setCurrentItem(akC(), false);
        this.cGz.setOnScrollOutListener(this.cGA);
        this.cGz.setItemOnLongClickListener(fVar);
        this.cGz.setHasNext(false);
        this.cGz.setNextTitle("mNextTitle");
        this.cGz.setIsFromCDN(true);
        this.cGz.setAllowLocalUrl(true);
        aJ(this.mIndex, this.mIndex);
        this.Tl.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akB() {
        if (this.cGv != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.nL > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + this.nL;
            }
            if (this.cGz.getHasNext() && this.mIndex == this.cGz.getItemNum() - 1) {
                this.Tl.setText(getPageContext().getString(u.j.image_recommend));
                this.cGx.setClickable(false);
                return;
            }
            this.Tl.setText(valueOf);
            this.cGx.setClickable(true);
        }
    }

    private int akC() {
        if (this.cGv != null && this.cGv.size() > 0) {
            int size = this.cGv.size();
            if (this.mIndex >= size) {
                this.mIndex = size - 1;
            }
            if (this.mIndex < 0) {
                this.mIndex = 0;
            }
        } else {
            this.mIndex = 0;
        }
        return this.mIndex;
    }

    private void initData(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.cGE = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.cGF = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.cGG = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.cGK = intent.getBooleanExtra("isSingle", false);
            if (this.cGG == null) {
                this.cGG = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.cGE == null) {
                this.cGE = "";
            }
            this.cGv = new LinkedHashMap<>();
            this.cGv.put(this.cGG, this.cGE);
            this.cGJ = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.cGv = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.cGG = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.cGJ = bundle.getInt("chat_mode", 0);
            this.cGK = bundle.getBoolean("isSingle", false);
            if (this.cGG == null) {
                this.cGG = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.cGI = new HashMap<>();
    }

    private void akD() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new g(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.cGv);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.cGG);
        bundle.putInt("chat_mode", this.cGJ);
        bundle.putBoolean("isSingle", this.cGK);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.cGz.setCurrentItem(this.mIndex, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        byte[] hY;
        String mUrl;

        public a(String str, byte[] bArr) {
            this.mUrl = null;
            this.hY = null;
            this.mUrl = str;
            this.hY = bArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            switch (com.baidu.tbadk.core.util.m.a(this.mUrl, this.hY, AbsMsgImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.m.sU();
                case -1:
                default:
                    return AbsMsgImageActivity.this.getPageContext().getString(u.j.save_error);
                case 0:
                    return AbsMsgImageActivity.this.getPageContext().getString(u.j.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: er */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            AbsMsgImageActivity.this.cGw = null;
            AbsMsgImageActivity.this.cGx.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.cGw = null;
            AbsMsgImageActivity.this.cGx.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r7v0 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(int i, int i2) {
        synchronized (this.cGI) {
            if (System.nanoTime() - this.cGH > 300000000 && this.cGv != null && i < this.cGv.size()) {
                this.cGI.put(this.cGv.get(new StringBuilder().append(i).toString()), true);
            }
            this.cGH = System.nanoTime();
        }
    }
}
