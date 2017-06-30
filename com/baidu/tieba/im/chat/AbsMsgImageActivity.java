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
    private FrameLayout cVZ;
    private String cWh;
    private boolean cWm;
    private int mCount;
    private LinkedHashMap<String, String> cVX = null;
    private int mIndex = 0;
    private a cVY = null;
    private View apb = null;
    private TextView mTextView = null;
    private NavigationBar cWa = null;
    private MultiImageView cWb = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a cWc = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation cWd = null;
    private boolean cWe = true;
    private boolean cWf = false;
    private String cWg = "";
    private String id = "";
    private String cWi = "";
    private long cWj = 0;
    private HashMap<String, Boolean> cWk = null;
    private int cWl = 0;

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
        aps();
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
        aps();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.cWb.setBackgroundColor(com.baidu.tbadk.core.util.as.cM(i));
        } else {
            this.cWb.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        com.baidu.tbadk.core.util.as.k(this.cWa, w.e.common_color_10222);
        getLayoutMode().t(this.apb);
        getLayoutMode().t(this.mTextView);
        getLayoutMode().t(this.cVZ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.cWb.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cWb.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.cWb.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        aP(this.mIndex, this.mIndex);
        this.cWb.onDestroy();
        if (this.cVY != null) {
            this.cVY.cancel();
            this.cVY = null;
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
        this.cWc = new d(this);
        f fVar = new f(this, new e(this));
        this.cWa = (NavigationBar) findViewById(w.h.navigation_bar);
        this.cVZ = (FrameLayout) this.cWa.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.image_activity_save_button, this.mOnClickListener);
        if (this.cWm) {
            this.cVZ.setVisibility(8);
        }
        this.apb = this.cWa.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.mTextView = this.cWa.setTitleText("");
        this.cWb = (MultiImageView) findViewById(w.h.viewpager);
        this.cWb.setPageMargin(com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), 8.0f));
        this.cWb.I(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.cWb.setOnPageChangeListener(this.mOnPageChangeListener);
        this.cWb.setItemOnclickListener(this.mOnClickListener);
        this.cWb.setCurrentItem(apr(), false);
        this.cWb.setOnScrollOutListener(this.cWc);
        this.cWb.setItemOnLongClickListener(fVar);
        this.cWb.setHasNext(false);
        this.cWb.setNextTitle("mNextTitle");
        this.cWb.setIsFromCDN(true);
        this.cWb.setAllowLocalUrl(true);
        aP(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apq() {
        if (this.cVX != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + this.mCount;
            }
            if (this.cWb.getHasNext() && this.mIndex == this.cWb.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(w.l.image_recommend));
                this.cVZ.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.cVZ.setClickable(true);
        }
    }

    private int apr() {
        if (this.cVX != null && this.cVX.size() > 0) {
            int size = this.cVX.size();
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
            this.cWg = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.cWh = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.cWi = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.cWm = intent.getBooleanExtra("isSingle", false);
            if (this.cWi == null) {
                this.cWi = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.cWg == null) {
                this.cWg = "";
            }
            this.cVX = new LinkedHashMap<>();
            this.cVX.put(this.cWi, this.cWg);
            this.cWl = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.cVX = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.id = bundle.getString("id");
            this.cWi = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.cWl = bundle.getInt("chat_mode", 0);
            this.cWm = bundle.getBoolean("isSingle", false);
            if (this.cWi == null) {
                this.cWi = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.cWk = new HashMap<>();
    }

    private void aps() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new g(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.cVX);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.cWi);
        bundle.putInt("chat_mode", this.cWl);
        bundle.putBoolean("isSingle", this.cWm);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.cWb.setCurrentItem(this.mIndex, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        String mUrl;
        byte[] rK;

        public a(String str, byte[] bArr) {
            this.mUrl = null;
            this.rK = null;
            this.mUrl = str;
            this.rK = bArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            switch (com.baidu.tbadk.core.util.n.a(this.mUrl, this.rK, AbsMsgImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.n.us();
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
            AbsMsgImageActivity.this.cVY = null;
            AbsMsgImageActivity.this.cVZ.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.cVY = null;
            AbsMsgImageActivity.this.cVZ.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r7v0 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void aP(int i, int i2) {
        synchronized (this.cWk) {
            if (System.nanoTime() - this.cWj > 300000000 && this.cVX != null && i < this.cVX.size()) {
                this.cWk.put(this.cVX.get(new StringBuilder().append(i).toString()), true);
            }
            this.cWj = System.nanoTime();
        }
    }
}
