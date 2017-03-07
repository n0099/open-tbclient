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
    private FrameLayout cNO;
    private String cNW;
    private boolean cOb;
    private int mCount;
    private LinkedHashMap<String, String> cNM = null;
    private int mIndex = 0;
    private a cNN = null;
    private View anY = null;
    private TextView aaE = null;
    private NavigationBar cNP = null;
    private MultiImageView cNQ = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a cNR = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation cNS = null;
    private boolean cNT = true;
    private boolean cNU = false;
    private String cNV = "";
    private String id = "";
    private String cNX = "";
    private long cNY = 0;
    private HashMap<String, Boolean> cNZ = null;
    private int cOa = 0;

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
        amT();
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
        amT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.cNQ.setBackgroundColor(com.baidu.tbadk.core.util.aq.cJ(i));
        } else {
            this.cNQ.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        com.baidu.tbadk.core.util.aq.k(this.cNP, w.e.common_color_10222);
        getLayoutMode().t(this.anY);
        getLayoutMode().t(this.aaE);
        getLayoutMode().t(this.cNO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.cNQ.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cNQ.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.cNQ.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        aP(this.mIndex, this.mIndex);
        this.cNQ.onDestroy();
        if (this.cNN != null) {
            this.cNN.cancel();
            this.cNN = null;
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
        this.cNR = new d(this);
        f fVar = new f(this, new e(this));
        this.cNP = (NavigationBar) findViewById(w.h.navigation_bar);
        this.cNO = (FrameLayout) this.cNP.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.image_activity_save_button, this.mOnClickListener);
        if (this.cOb) {
            this.cNO.setVisibility(8);
        }
        this.anY = this.cNP.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.aaE = this.cNP.setTitleText("");
        this.cNQ = (MultiImageView) findViewById(w.h.viewpager);
        this.cNQ.setPageMargin(com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), 8.0f));
        this.cNQ.J(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.cNQ.setOnPageChangeListener(this.mOnPageChangeListener);
        this.cNQ.setItemOnclickListener(this.mOnClickListener);
        this.cNQ.setCurrentItem(amS(), false);
        this.cNQ.setOnScrollOutListener(this.cNR);
        this.cNQ.setItemOnLongClickListener(fVar);
        this.cNQ.setHasNext(false);
        this.cNQ.setNextTitle("mNextTitle");
        this.cNQ.setIsFromCDN(true);
        this.cNQ.setAllowLocalUrl(true);
        aP(this.mIndex, this.mIndex);
        this.aaE.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amR() {
        if (this.cNM != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + this.mCount;
            }
            if (this.cNQ.getHasNext() && this.mIndex == this.cNQ.getItemNum() - 1) {
                this.aaE.setText(getPageContext().getString(w.l.image_recommend));
                this.cNO.setClickable(false);
                return;
            }
            this.aaE.setText(valueOf);
            this.cNO.setClickable(true);
        }
    }

    private int amS() {
        if (this.cNM != null && this.cNM.size() > 0) {
            int size = this.cNM.size();
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
            this.cNV = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.cNW = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.cNX = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.cOb = intent.getBooleanExtra("isSingle", false);
            if (this.cNX == null) {
                this.cNX = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.cNV == null) {
                this.cNV = "";
            }
            this.cNM = new LinkedHashMap<>();
            this.cNM.put(this.cNX, this.cNV);
            this.cOa = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.cNM = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.id = bundle.getString("id");
            this.cNX = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.cOa = bundle.getInt("chat_mode", 0);
            this.cOb = bundle.getBoolean("isSingle", false);
            if (this.cNX == null) {
                this.cNX = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.cNZ = new HashMap<>();
    }

    private void amT() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new g(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.cNM);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.cNX);
        bundle.putInt("chat_mode", this.cOa);
        bundle.putBoolean("isSingle", this.cOb);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.cNQ.setCurrentItem(this.mIndex, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        String mUrl;
        byte[] sg;

        public a(String str, byte[] bArr) {
            this.mUrl = null;
            this.sg = null;
            this.mUrl = str;
            this.sg = bArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            switch (com.baidu.tbadk.core.util.l.a(this.mUrl, this.sg, AbsMsgImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.l.uv();
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
            AbsMsgImageActivity.this.cNN = null;
            AbsMsgImageActivity.this.cNO.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.cNN = null;
            AbsMsgImageActivity.this.cNO.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r7v0 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void aP(int i, int i2) {
        synchronized (this.cNZ) {
            if (System.nanoTime() - this.cNY > 300000000 && this.cNM != null && i < this.cNM.size()) {
                this.cNZ.put(this.cNM.get(new StringBuilder().append(i).toString()), true);
            }
            this.cNY = System.nanoTime();
        }
    }
}
