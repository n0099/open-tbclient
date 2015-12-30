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
import com.baidu.tieba.n;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public abstract class AbsMsgImageActivity extends BaseActivity<AbsMsgImageActivity> {
    private FrameLayout bJS;
    private String bKa;
    private boolean bKf;
    private int wJ;
    private LinkedHashMap<String, String> bJQ = null;
    private int mIndex = 0;
    private a bJR = null;
    private View mBack = null;
    private TextView mTextView = null;
    private NavigationBar bJT = null;
    private MultiImageView bJU = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a bJV = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation bJW = null;
    private boolean bJX = true;
    private boolean bJY = false;
    private String bJZ = "";
    private String id = "";
    private String bKb = "";
    private long bKc = 0;
    private HashMap<String, Boolean> bKd = null;
    private int bKe = 0;

    protected abstract void a(String str, ad adVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m411getInst().addRemoteActivity(this);
        setContentView(n.h.image_activity_2);
        initData(bundle);
        initUI();
        VT();
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
        VT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.bJU.setBackgroundColor(com.baidu.tbadk.core.util.as.cv(i));
        } else {
            this.bJU.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        com.baidu.tbadk.core.util.as.j(this.bJT, n.d.alpha80_black);
        getLayoutMode().k(this.mBack);
        getLayoutMode().k(this.mTextView);
        getLayoutMode().k(this.bJS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bJU.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bJU.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.bJU.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        at(this.mIndex, this.mIndex);
        this.bJU.onDestroy();
        if (this.bJR != null) {
            this.bJR.cancel();
            this.bJR = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
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
        this.bJV = new d(this);
        f fVar = new f(this, new e(this));
        this.bJT = (NavigationBar) findViewById(n.g.navigation_bar);
        this.bJS = (FrameLayout) this.bJT.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.h.image_activity_save_button, this.mOnClickListener);
        if (this.bKf) {
            this.bJS.setVisibility(8);
        }
        this.mBack = this.bJT.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.mTextView = this.bJT.setTitleText("");
        this.bJU = (MultiImageView) findViewById(n.g.viewpager);
        this.bJU.setPageMargin(com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), 8.0f));
        this.bJU.H(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.bJU.setOnPageChangeListener(this.mOnPageChangeListener);
        this.bJU.setItemOnclickListener(this.mOnClickListener);
        this.bJU.setCurrentItem(VS(), false);
        this.bJU.setOnScrollOutListener(this.bJV);
        this.bJU.setItemOnLongClickListener(fVar);
        this.bJU.setHasNext(false);
        this.bJU.setNextTitle("mNextTitle");
        this.bJU.setIsFromCDN(true);
        this.bJU.setAllowLocalUrl(true);
        at(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VR() {
        if (this.bJQ != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.wJ > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + this.wJ;
            }
            if (this.bJU.getHasNext() && this.mIndex == this.bJU.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(n.j.image_recommend));
                this.bJS.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.bJS.setClickable(true);
        }
    }

    private int VS() {
        if (this.bJQ != null && this.bJQ.size() > 0) {
            int size = this.bJQ.size();
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
            this.bJZ = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.bKa = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.bKb = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.bKf = intent.getBooleanExtra("isSingle", false);
            if (this.bKb == null) {
                this.bKb = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.bJZ == null) {
                this.bJZ = "";
            }
            this.bJQ = new LinkedHashMap<>();
            this.bJQ.put(this.bKb, this.bJZ);
            this.bKe = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.bJQ = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.id = bundle.getString("id");
            this.bKb = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.bKe = bundle.getInt("chat_mode", 0);
            this.bKf = bundle.getBoolean("isSingle", false);
            if (this.bKb == null) {
                this.bKb = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.bKd = new HashMap<>();
    }

    private void VT() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new g(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.bJQ);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.bKb);
        bundle.putInt("chat_mode", this.bKe);
        bundle.putBoolean("isSingle", this.bKf);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.bJU.setCurrentItem(this.mIndex, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        byte[] mData;
        String mUrl;

        public a(String str, byte[] bArr) {
            this.mUrl = null;
            this.mData = null;
            this.mUrl = str;
            this.mData = bArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            switch (com.baidu.tbadk.core.util.n.a(this.mUrl, this.mData, AbsMsgImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.n.tQ();
                case -1:
                default:
                    return AbsMsgImageActivity.this.getPageContext().getString(n.j.save_error);
                case 0:
                    return AbsMsgImageActivity.this.getPageContext().getString(n.j.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            AbsMsgImageActivity.this.bJR = null;
            AbsMsgImageActivity.this.bJS.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.bJR = null;
            AbsMsgImageActivity.this.bJS.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r7v0 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void at(int i, int i2) {
        synchronized (this.bKd) {
            if (System.nanoTime() - this.bKc > 300000000 && this.bJQ != null && i < this.bJQ.size()) {
                this.bKd.put(this.bJQ.get(new StringBuilder().append(i).toString()), true);
            }
            this.bKc = System.nanoTime();
        }
    }
}
