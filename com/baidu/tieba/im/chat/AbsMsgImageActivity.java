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
import com.baidu.tieba.w;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public abstract class AbsMsgImageActivity extends BaseActivity<AbsMsgImageActivity> {
    private FrameLayout cMl;
    private String cMt;
    private boolean cMy;
    private int mCount;
    private LinkedHashMap<String, String> cMj = null;
    private int mIndex = 0;
    private a cMk = null;
    private View aom = null;
    private TextView mTextView = null;
    private NavigationBar cMm = null;
    private MultiImageView cMn = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a cMo = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation cMp = null;
    private boolean cMq = true;
    private boolean cMr = false;
    private String cMs = "";
    private String id = "";
    private String cMu = "";
    private long cMv = 0;
    private HashMap<String, Boolean> cMw = null;
    private int cMx = 0;

    protected abstract void a(String str, ad adVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m9getInst().addRemoteActivity(this);
        setContentView(w.j.image_activity_2);
        initData(bundle);
        initUI();
        amN();
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
        amN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.cMn.setBackgroundColor(com.baidu.tbadk.core.util.aq.cM(i));
        } else {
            this.cMn.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        com.baidu.tbadk.core.util.aq.k(this.cMm, w.e.common_color_10222);
        getLayoutMode().t(this.aom);
        getLayoutMode().t(this.mTextView);
        getLayoutMode().t(this.cMl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.cMn.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cMn.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.cMn.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        aN(this.mIndex, this.mIndex);
        this.cMn.onDestroy();
        if (this.cMk != null) {
            this.cMk.cancel();
            this.cMk = null;
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
        this.cMo = new d(this);
        f fVar = new f(this, new e(this));
        this.cMm = (NavigationBar) findViewById(w.h.navigation_bar);
        this.cMl = (FrameLayout) this.cMm.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.image_activity_save_button, this.mOnClickListener);
        if (this.cMy) {
            this.cMl.setVisibility(8);
        }
        this.aom = this.cMm.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.mTextView = this.cMm.setTitleText("");
        this.cMn = (MultiImageView) findViewById(w.h.viewpager);
        this.cMn.setPageMargin(com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), 8.0f));
        this.cMn.J(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.cMn.setOnPageChangeListener(this.mOnPageChangeListener);
        this.cMn.setItemOnclickListener(this.mOnClickListener);
        this.cMn.setCurrentItem(amM(), false);
        this.cMn.setOnScrollOutListener(this.cMo);
        this.cMn.setItemOnLongClickListener(fVar);
        this.cMn.setHasNext(false);
        this.cMn.setNextTitle("mNextTitle");
        this.cMn.setIsFromCDN(true);
        this.cMn.setAllowLocalUrl(true);
        aN(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amL() {
        if (this.cMj != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + this.mCount;
            }
            if (this.cMn.getHasNext() && this.mIndex == this.cMn.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(w.l.image_recommend));
                this.cMl.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.cMl.setClickable(true);
        }
    }

    private int amM() {
        if (this.cMj != null && this.cMj.size() > 0) {
            int size = this.cMj.size();
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
            this.cMs = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.cMt = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.cMu = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.cMy = intent.getBooleanExtra("isSingle", false);
            if (this.cMu == null) {
                this.cMu = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.cMs == null) {
                this.cMs = "";
            }
            this.cMj = new LinkedHashMap<>();
            this.cMj.put(this.cMu, this.cMs);
            this.cMx = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.cMj = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.id = bundle.getString("id");
            this.cMu = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.cMx = bundle.getInt("chat_mode", 0);
            this.cMy = bundle.getBoolean("isSingle", false);
            if (this.cMu == null) {
                this.cMu = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.cMw = new HashMap<>();
    }

    private void amN() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new g(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.cMj);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.cMu);
        bundle.putInt("chat_mode", this.cMx);
        bundle.putBoolean("isSingle", this.cMy);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.cMn.setCurrentItem(this.mIndex, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        String mUrl;
        byte[] rF;

        public a(String str, byte[] bArr) {
            this.mUrl = null;
            this.rF = null;
            this.mUrl = str;
            this.rF = bArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            switch (com.baidu.tbadk.core.util.l.a(this.mUrl, this.rF, AbsMsgImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.l.uS();
                case -1:
                default:
                    return AbsMsgImageActivity.this.getPageContext().getString(w.l.save_error);
                case 0:
                    return AbsMsgImageActivity.this.getPageContext().getString(w.l.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            AbsMsgImageActivity.this.cMk = null;
            AbsMsgImageActivity.this.cMl.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.cMk = null;
            AbsMsgImageActivity.this.cMl.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r7v0 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void aN(int i, int i2) {
        synchronized (this.cMw) {
            if (System.nanoTime() - this.cMv > 300000000 && this.cMj != null && i < this.cMj.size()) {
                this.cMw.put(this.cMj.get(new StringBuilder().append(i).toString()), true);
            }
            this.cMv = System.nanoTime();
        }
    }
}
