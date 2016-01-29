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
import com.baidu.tieba.t;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public abstract class AbsMsgImageActivity extends BaseActivity<AbsMsgImageActivity> {
    private FrameLayout bNB;
    private String bNJ;
    private boolean bNO;
    private int wS;
    private LinkedHashMap<String, String> bNz = null;
    private int mIndex = 0;
    private a bNA = null;
    private View ajk = null;
    private TextView YG = null;
    private NavigationBar bNC = null;
    private MultiImageView bND = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a bNE = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation bNF = null;
    private boolean bNG = true;
    private boolean bNH = false;
    private String bNI = "";
    private String id = "";
    private String bNK = "";
    private long bNL = 0;
    private HashMap<String, Boolean> bNM = null;
    private int bNN = 0;

    protected abstract void a(String str, ad adVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m411getInst().addRemoteActivity(this);
        setContentView(t.h.image_activity_2);
        initData(bundle);
        qD();
        Yn();
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
        Yn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.bND.setBackgroundColor(com.baidu.tbadk.core.util.ar.cM(i));
        } else {
            this.bND.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        com.baidu.tbadk.core.util.ar.l(this.bNC, t.d.alpha80_black);
        getLayoutMode().x(this.ajk);
        getLayoutMode().x(this.YG);
        getLayoutMode().x(this.bNB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bND.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bND.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.bND.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        at(this.mIndex, this.mIndex);
        this.bND.onDestroy();
        if (this.bNA != null) {
            this.bNA.cancel();
            this.bNA = null;
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

    private void qD() {
        this.mOnClickListener = new com.baidu.tieba.im.chat.a(this);
        this.mOnPageChangeListener = new c(this);
        this.bNE = new d(this);
        f fVar = new f(this, new e(this));
        this.bNC = (NavigationBar) findViewById(t.g.navigation_bar);
        this.bNB = (FrameLayout) this.bNC.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.image_activity_save_button, this.mOnClickListener);
        if (this.bNO) {
            this.bNB.setVisibility(8);
        }
        this.ajk = this.bNC.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.YG = this.bNC.setTitleText("");
        this.bND = (MultiImageView) findViewById(t.g.viewpager);
        this.bND.setPageMargin(com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), 8.0f));
        this.bND.D(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.bND.setOnPageChangeListener(this.mOnPageChangeListener);
        this.bND.setItemOnclickListener(this.mOnClickListener);
        this.bND.setCurrentItem(Ym(), false);
        this.bND.setOnScrollOutListener(this.bNE);
        this.bND.setItemOnLongClickListener(fVar);
        this.bND.setHasNext(false);
        this.bND.setNextTitle("mNextTitle");
        this.bND.setIsFromCDN(true);
        this.bND.setAllowLocalUrl(true);
        at(this.mIndex, this.mIndex);
        this.YG.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yl() {
        if (this.bNz != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.wS > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + this.wS;
            }
            if (this.bND.getHasNext() && this.mIndex == this.bND.getItemNum() - 1) {
                this.YG.setText(getPageContext().getString(t.j.image_recommend));
                this.bNB.setClickable(false);
                return;
            }
            this.YG.setText(valueOf);
            this.bNB.setClickable(true);
        }
    }

    private int Ym() {
        if (this.bNz != null && this.bNz.size() > 0) {
            int size = this.bNz.size();
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
            this.bNI = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.bNJ = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.bNK = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.bNO = intent.getBooleanExtra("isSingle", false);
            if (this.bNK == null) {
                this.bNK = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.bNI == null) {
                this.bNI = "";
            }
            this.bNz = new LinkedHashMap<>();
            this.bNz.put(this.bNK, this.bNI);
            this.bNN = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.bNz = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.id = bundle.getString("id");
            this.bNK = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.bNN = bundle.getInt("chat_mode", 0);
            this.bNO = bundle.getBoolean("isSingle", false);
            if (this.bNK == null) {
                this.bNK = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.bNM = new HashMap<>();
    }

    private void Yn() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new g(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.bNz);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.bNK);
        bundle.putInt("chat_mode", this.bNN);
        bundle.putBoolean("isSingle", this.bNO);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.bND.setCurrentItem(this.mIndex, true);
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
        /* renamed from: h */
        public String doInBackground(String... strArr) {
            switch (com.baidu.tbadk.core.util.m.a(this.mUrl, this.mData, AbsMsgImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.m.uU();
                case -1:
                default:
                    return AbsMsgImageActivity.this.getPageContext().getString(t.j.save_error);
                case 0:
                    return AbsMsgImageActivity.this.getPageContext().getString(t.j.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: ek */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            AbsMsgImageActivity.this.bNA = null;
            AbsMsgImageActivity.this.bNB.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.bNA = null;
            AbsMsgImageActivity.this.bNB.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r7v0 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void at(int i, int i2) {
        synchronized (this.bNM) {
            if (System.nanoTime() - this.bNL > 300000000 && this.bNz != null && i < this.bNz.size()) {
                this.bNM.put(this.bNz.get(new StringBuilder().append(i).toString()), true);
            }
            this.bNL = System.nanoTime();
        }
    }
}
