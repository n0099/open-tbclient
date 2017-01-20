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
import com.baidu.tieba.im.sendmessage.ad;
import com.baidu.tieba.r;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public abstract class AbsMsgImageActivity extends BaseActivity<AbsMsgImageActivity> {
    private FrameLayout cLA;
    private String cLI;
    private boolean cLN;
    private int mCount;
    private LinkedHashMap<String, String> cLy = null;
    private int mIndex = 0;
    private a cLz = null;
    private View aiC = null;
    private TextView Vt = null;
    private NavigationBar cLB = null;
    private MultiImageView cLC = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a cLD = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation cLE = null;
    private boolean cLF = true;
    private boolean cLG = false;
    private String cLH = "";
    private String id = "";
    private String cLJ = "";
    private long cLK = 0;
    private HashMap<String, Boolean> cLL = null;
    private int cLM = 0;

    protected abstract void a(String str, ad adVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m9getInst().addRemoteActivity(this);
        setContentView(r.j.image_activity_2);
        initData(bundle);
        initUI();
        anz();
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
        anz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.cLC.setBackgroundColor(com.baidu.tbadk.core.util.ap.cN(i));
        } else {
            this.cLC.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        com.baidu.tbadk.core.util.ap.k(this.cLB, r.e.common_color_10222);
        getLayoutMode().v(this.aiC);
        getLayoutMode().v(this.Vt);
        getLayoutMode().v(this.cLA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.cLC.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cLC.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.cLC.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        aL(this.mIndex, this.mIndex);
        this.cLC.onDestroy();
        if (this.cLz != null) {
            this.cLz.cancel();
            this.cLz = null;
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
        this.cLD = new d(this);
        f fVar = new f(this, new e(this));
        this.cLB = (NavigationBar) findViewById(r.h.navigation_bar);
        this.cLA = (FrameLayout) this.cLB.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.j.image_activity_save_button, this.mOnClickListener);
        if (this.cLN) {
            this.cLA.setVisibility(8);
        }
        this.aiC = this.cLB.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.Vt = this.cLB.setTitleText("");
        this.cLC = (MultiImageView) findViewById(r.h.viewpager);
        this.cLC.setPageMargin(com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), 8.0f));
        this.cLC.D(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.cLC.setOnPageChangeListener(this.mOnPageChangeListener);
        this.cLC.setItemOnclickListener(this.mOnClickListener);
        this.cLC.setCurrentItem(any(), false);
        this.cLC.setOnScrollOutListener(this.cLD);
        this.cLC.setItemOnLongClickListener(fVar);
        this.cLC.setHasNext(false);
        this.cLC.setNextTitle("mNextTitle");
        this.cLC.setIsFromCDN(true);
        this.cLC.setAllowLocalUrl(true);
        aL(this.mIndex, this.mIndex);
        this.Vt.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anx() {
        if (this.cLy != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + this.mCount;
            }
            if (this.cLC.getHasNext() && this.mIndex == this.cLC.getItemNum() - 1) {
                this.Vt.setText(getPageContext().getString(r.l.image_recommend));
                this.cLA.setClickable(false);
                return;
            }
            this.Vt.setText(valueOf);
            this.cLA.setClickable(true);
        }
    }

    private int any() {
        if (this.cLy != null && this.cLy.size() > 0) {
            int size = this.cLy.size();
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
            this.cLH = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.cLI = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.cLJ = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.cLN = intent.getBooleanExtra("isSingle", false);
            if (this.cLJ == null) {
                this.cLJ = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.cLH == null) {
                this.cLH = "";
            }
            this.cLy = new LinkedHashMap<>();
            this.cLy.put(this.cLJ, this.cLH);
            this.cLM = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.cLy = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.id = bundle.getString("id");
            this.cLJ = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.cLM = bundle.getInt("chat_mode", 0);
            this.cLN = bundle.getBoolean("isSingle", false);
            if (this.cLJ == null) {
                this.cLJ = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.cLL = new HashMap<>();
    }

    private void anz() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new g(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.cLy);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.cLJ);
        bundle.putInt("chat_mode", this.cLM);
        bundle.putBoolean("isSingle", this.cLN);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.cLC.setCurrentItem(this.mIndex, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        byte[] kl;
        String mUrl;

        public a(String str, byte[] bArr) {
            this.mUrl = null;
            this.kl = null;
            this.mUrl = str;
            this.kl = bArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            switch (com.baidu.tbadk.core.util.l.a(this.mUrl, this.kl, AbsMsgImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.l.tX();
                case -1:
                default:
                    return AbsMsgImageActivity.this.getPageContext().getString(r.l.save_error);
                case 0:
                    return AbsMsgImageActivity.this.getPageContext().getString(r.l.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            AbsMsgImageActivity.this.cLz = null;
            AbsMsgImageActivity.this.cLA.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.cLz = null;
            AbsMsgImageActivity.this.cLA.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r7v0 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void aL(int i, int i2) {
        synchronized (this.cLL) {
            if (System.nanoTime() - this.cLK > 300000000 && this.cLy != null && i < this.cLy.size()) {
                this.cLL.put(this.cLy.get(new StringBuilder().append(i).toString()), true);
            }
            this.cLK = System.nanoTime();
        }
    }
}
