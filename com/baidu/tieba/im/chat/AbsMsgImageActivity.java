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
    private FrameLayout cOC;
    private String cOK;
    private boolean cOP;
    private int mCount;
    private LinkedHashMap<String, String> cOA = null;
    private int mIndex = 0;
    private a cOB = null;
    private View aom = null;
    private TextView mTextView = null;
    private NavigationBar cOD = null;
    private MultiImageView cOE = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a cOF = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation cOG = null;
    private boolean cOH = true;
    private boolean cOI = false;
    private String cOJ = "";
    private String id = "";
    private String cOL = "";
    private long cOM = 0;
    private HashMap<String, Boolean> cON = null;
    private int cOO = 0;

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
        anO();
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
        anO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.cOE.setBackgroundColor(com.baidu.tbadk.core.util.aq.cM(i));
        } else {
            this.cOE.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        com.baidu.tbadk.core.util.aq.k(this.cOD, w.e.common_color_10222);
        getLayoutMode().t(this.aom);
        getLayoutMode().t(this.mTextView);
        getLayoutMode().t(this.cOC);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.cOE.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cOE.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.cOE.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        aN(this.mIndex, this.mIndex);
        this.cOE.onDestroy();
        if (this.cOB != null) {
            this.cOB.cancel();
            this.cOB = null;
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
        this.cOF = new d(this);
        f fVar = new f(this, new e(this));
        this.cOD = (NavigationBar) findViewById(w.h.navigation_bar);
        this.cOC = (FrameLayout) this.cOD.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.image_activity_save_button, this.mOnClickListener);
        if (this.cOP) {
            this.cOC.setVisibility(8);
        }
        this.aom = this.cOD.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.mTextView = this.cOD.setTitleText("");
        this.cOE = (MultiImageView) findViewById(w.h.viewpager);
        this.cOE.setPageMargin(com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), 8.0f));
        this.cOE.J(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.cOE.setOnPageChangeListener(this.mOnPageChangeListener);
        this.cOE.setItemOnclickListener(this.mOnClickListener);
        this.cOE.setCurrentItem(anN(), false);
        this.cOE.setOnScrollOutListener(this.cOF);
        this.cOE.setItemOnLongClickListener(fVar);
        this.cOE.setHasNext(false);
        this.cOE.setNextTitle("mNextTitle");
        this.cOE.setIsFromCDN(true);
        this.cOE.setAllowLocalUrl(true);
        aN(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anM() {
        if (this.cOA != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + this.mCount;
            }
            if (this.cOE.getHasNext() && this.mIndex == this.cOE.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(w.l.image_recommend));
                this.cOC.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.cOC.setClickable(true);
        }
    }

    private int anN() {
        if (this.cOA != null && this.cOA.size() > 0) {
            int size = this.cOA.size();
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
            this.cOJ = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.cOK = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.cOL = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.cOP = intent.getBooleanExtra("isSingle", false);
            if (this.cOL == null) {
                this.cOL = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.cOJ == null) {
                this.cOJ = "";
            }
            this.cOA = new LinkedHashMap<>();
            this.cOA.put(this.cOL, this.cOJ);
            this.cOO = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.cOA = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.id = bundle.getString("id");
            this.cOL = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.cOO = bundle.getInt("chat_mode", 0);
            this.cOP = bundle.getBoolean("isSingle", false);
            if (this.cOL == null) {
                this.cOL = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.cON = new HashMap<>();
    }

    private void anO() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new g(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.cOA);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.cOL);
        bundle.putInt("chat_mode", this.cOO);
        bundle.putBoolean("isSingle", this.cOP);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.cOE.setCurrentItem(this.mIndex, true);
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
            switch (com.baidu.tbadk.core.util.l.a(this.mUrl, this.rK, AbsMsgImageActivity.this.getPageContext().getPageActivity())) {
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
            AbsMsgImageActivity.this.cOB = null;
            AbsMsgImageActivity.this.cOC.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.cOB = null;
            AbsMsgImageActivity.this.cOC.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r7v0 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void aN(int i, int i2) {
        synchronized (this.cON) {
            if (System.nanoTime() - this.cOM > 300000000 && this.cOA != null && i < this.cOA.size()) {
                this.cON.put(this.cOA.get(new StringBuilder().append(i).toString()), true);
            }
            this.cOM = System.nanoTime();
        }
    }
}
