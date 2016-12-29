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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.im.c.ad;
import com.baidu.tieba.r;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public abstract class AbsMsgImageActivity extends BaseActivity<AbsMsgImageActivity> {
    private boolean cEE;
    private FrameLayout cEr;
    private String cEz;
    private int qh;
    private LinkedHashMap<String, String> cEp = null;
    private int mIndex = 0;
    private a cEq = null;
    private View ajr = null;
    private TextView Wd = null;
    private NavigationBar cEs = null;
    private MultiImageView cEt = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a cEu = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation cEv = null;
    private boolean cEw = true;
    private boolean cEx = false;
    private String cEy = "";
    private String id = "";
    private String cEA = "";
    private long cEB = 0;
    private HashMap<String, Boolean> cEC = null;
    private int cED = 0;

    protected abstract void a(String str, ad adVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m9getInst().addRemoteActivity(this);
        setContentView(r.h.image_activity_2);
        initData(bundle);
        initUI();
        amq();
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
        amq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.cEt.setBackgroundColor(com.baidu.tbadk.core.util.ar.cO(i));
        } else {
            this.cEt.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        com.baidu.tbadk.core.util.ar.l(this.cEs, r.d.common_color_10222);
        getLayoutMode().x(this.ajr);
        getLayoutMode().x(this.Wd);
        getLayoutMode().x(this.cEr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.cEt.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cEt.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.cEt.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        aL(this.mIndex, this.mIndex);
        this.cEt.onDestroy();
        if (this.cEq != null) {
            this.cEq.cancel();
            this.cEq = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.m9getInst().delRemoteActivity(this);
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            Intent intent = new Intent();
            intent.putExtra(ImageViewerConfig.INDEX, this.mIndex);
            setResult(-1, intent);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void initUI() {
        this.mOnClickListener = new com.baidu.tieba.im.chat.a(this);
        this.mOnPageChangeListener = new c(this);
        this.cEu = new d(this);
        f fVar = new f(this, new e(this));
        this.cEs = (NavigationBar) findViewById(r.g.navigation_bar);
        this.cEr = (FrameLayout) this.cEs.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.image_activity_save_button, this.mOnClickListener);
        if (this.cEE) {
            this.cEr.setVisibility(8);
        }
        this.ajr = this.cEs.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.Wd = this.cEs.setTitleText("");
        this.cEt = (MultiImageView) findViewById(r.g.viewpager);
        this.cEt.setPageMargin(com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), 8.0f));
        this.cEt.C(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.cEt.setOnPageChangeListener(this.mOnPageChangeListener);
        this.cEt.setItemOnclickListener(this.mOnClickListener);
        this.cEt.setCurrentItem(amp(), false);
        this.cEt.setOnScrollOutListener(this.cEu);
        this.cEt.setItemOnLongClickListener(fVar);
        this.cEt.setHasNext(false);
        this.cEt.setNextTitle("mNextTitle");
        this.cEt.setIsFromCDN(true);
        this.cEt.setAllowLocalUrl(true);
        aL(this.mIndex, this.mIndex);
        this.Wd.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amo() {
        if (this.cEp != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.qh > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + this.qh;
            }
            if (this.cEt.getHasNext() && this.mIndex == this.cEt.getItemNum() - 1) {
                this.Wd.setText(getPageContext().getString(r.j.image_recommend));
                this.cEr.setClickable(false);
                return;
            }
            this.Wd.setText(valueOf);
            this.cEr.setClickable(true);
        }
    }

    private int amp() {
        if (this.cEp != null && this.cEp.size() > 0) {
            int size = this.cEp.size();
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
            this.cEy = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.cEz = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.cEA = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.cEE = intent.getBooleanExtra("isSingle", false);
            if (this.cEA == null) {
                this.cEA = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.cEy == null) {
                this.cEy = "";
            }
            this.cEp = new LinkedHashMap<>();
            this.cEp.put(this.cEA, this.cEy);
            this.cED = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.cEp = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.id = bundle.getString("id");
            this.cEA = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.cED = bundle.getInt("chat_mode", 0);
            this.cEE = bundle.getBoolean("isSingle", false);
            if (this.cEA == null) {
                this.cEA = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.cEC = new HashMap<>();
    }

    private void amq() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new g(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.cEp);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.cEA);
        bundle.putInt("chat_mode", this.cED);
        bundle.putBoolean("isSingle", this.cEE);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.cEt.setCurrentItem(this.mIndex, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        byte[] kr;
        String mUrl;

        public a(String str, byte[] bArr) {
            this.mUrl = null;
            this.kr = null;
            this.mUrl = str;
            this.kr = bArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            switch (com.baidu.tbadk.core.util.m.a(this.mUrl, this.kr, AbsMsgImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.m.ud();
                case -1:
                default:
                    return AbsMsgImageActivity.this.getPageContext().getString(r.j.save_error);
                case 0:
                    return AbsMsgImageActivity.this.getPageContext().getString(r.j.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: ew */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            AbsMsgImageActivity.this.cEq = null;
            AbsMsgImageActivity.this.cEr.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.cEq = null;
            AbsMsgImageActivity.this.cEr.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r7v0 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void aL(int i, int i2) {
        synchronized (this.cEC) {
            if (System.nanoTime() - this.cEB > 300000000 && this.cEp != null && i < this.cEp.size()) {
                this.cEC.put(this.cEp.get(new StringBuilder().append(i).toString()), true);
            }
            this.cEB = System.nanoTime();
        }
    }
}
