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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.im.c.ad;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public abstract class AbsMsgImageActivity extends BaseActivity<AbsMsgImageActivity> {
    private FrameLayout bqB;
    private String bqJ;
    private boolean bqO;
    private int wB;
    private LinkedHashMap<String, String> bqz = null;
    private int mIndex = 0;
    private a bqA = null;
    private View mBack = null;
    private TextView mTextView = null;
    private NavigationBar bqC = null;
    private MultiImageView bqD = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a bqE = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation bqF = null;
    private boolean bqG = true;
    private boolean bqH = false;
    private String bqI = "";
    private String id = "";
    private String bqK = "";
    private long bqL = 0;
    private HashMap<String, Boolean> bqM = null;
    private int bqN = 0;

    protected abstract void a(String str, ad adVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m411getInst().addRemoteActivity(this);
        setContentView(i.g.image_activity_2);
        initData(bundle);
        initUI();
        Rp();
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
        Rp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.bqD.setBackgroundColor(an.cu(i));
        } else {
            this.bqD.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        an.j(this.bqC, i.c.alpha80_black);
        getLayoutMode().k(this.mBack);
        getLayoutMode().k(this.mTextView);
        getLayoutMode().k(this.bqB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bqD.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bqD.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.bqD.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        ad(this.mIndex, this.mIndex);
        this.bqD.onDestroy();
        if (this.bqA != null) {
            this.bqA.cancel();
            this.bqA = null;
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
        this.bqE = new d(this);
        f fVar = new f(this, new e(this));
        this.bqC = (NavigationBar) findViewById(i.f.navigation_bar);
        this.bqB = (FrameLayout) this.bqC.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.image_activity_save_button, this.mOnClickListener);
        if (this.bqO) {
            this.bqB.setVisibility(8);
        }
        this.mBack = this.bqC.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.mTextView = this.bqC.setTitleText("");
        this.bqC.findViewById(i.f.navBottomLine).setVisibility(8);
        this.bqD = (MultiImageView) findViewById(i.f.viewpager);
        this.bqD.setPageMargin(com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), 8.0f));
        this.bqD.G(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.bqD.setOnPageChangeListener(this.mOnPageChangeListener);
        this.bqD.setItemOnclickListener(this.mOnClickListener);
        this.bqD.setCurrentItem(Ro(), false);
        this.bqD.setOnScrollOutListener(this.bqE);
        this.bqD.setItemOnLongClickListener(fVar);
        this.bqD.setHasNext(false);
        this.bqD.setNextTitle("mNextTitle");
        this.bqD.setIsFromCDN(true);
        this.bqD.setAllowLocalUrl(true);
        ad(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rn() {
        if (this.bqz != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.wB > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + this.wB;
            }
            if (this.bqD.getHasNext() && this.mIndex == this.bqD.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(i.h.image_recommend));
                this.bqB.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.bqB.setClickable(true);
        }
    }

    private int Ro() {
        if (this.bqz != null && this.bqz.size() > 0) {
            int size = this.bqz.size();
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
            this.bqI = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.bqJ = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.bqK = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.bqO = intent.getBooleanExtra("isSingle", false);
            if (this.bqK == null) {
                this.bqK = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.bqI == null) {
                this.bqI = "";
            }
            this.bqz = new LinkedHashMap<>();
            this.bqz.put(this.bqK, this.bqI);
            this.bqN = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.bqz = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.id = bundle.getString("id");
            this.bqK = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.bqN = bundle.getInt("chat_mode", 0);
            this.bqO = bundle.getBoolean("isSingle", false);
            if (this.bqK == null) {
                this.bqK = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.bqM = new HashMap<>();
    }

    private void Rp() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new g(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.bqz);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.bqK);
        bundle.putInt("chat_mode", this.bqN);
        bundle.putBoolean("isSingle", this.bqO);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.bqD.setCurrentItem(this.mIndex, true);
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
                    return com.baidu.tbadk.core.util.n.tB();
                case -1:
                default:
                    return AbsMsgImageActivity.this.getPageContext().getString(i.h.save_error);
                case 0:
                    return AbsMsgImageActivity.this.getPageContext().getString(i.h.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            AbsMsgImageActivity.this.bqA = null;
            AbsMsgImageActivity.this.bqB.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.bqA = null;
            AbsMsgImageActivity.this.bqB.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r7v0 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void ad(int i, int i2) {
        synchronized (this.bqM) {
            if (System.nanoTime() - this.bqL > 300000000 && this.bqz != null && i < this.bqz.size()) {
                this.bqM.put(this.bqz.get(new StringBuilder().append(i).toString()), true);
            }
            this.bqL = System.nanoTime();
        }
    }
}
