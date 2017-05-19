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
    private FrameLayout cIF;
    private String cIN;
    private boolean cIS;
    private int mCount;
    private LinkedHashMap<String, String> cID = null;
    private int mIndex = 0;
    private a cIE = null;
    private View aor = null;
    private TextView mTextView = null;
    private NavigationBar cIG = null;
    private MultiImageView cIH = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a cII = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation cIJ = null;
    private boolean cIK = true;
    private boolean cIL = false;
    private String cIM = "";
    private String id = "";
    private String cIO = "";
    private long cIP = 0;
    private HashMap<String, Boolean> cIQ = null;
    private int cIR = 0;

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
        akH();
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
        akH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.cIH.setBackgroundColor(com.baidu.tbadk.core.util.aq.cJ(i));
        } else {
            this.cIH.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        com.baidu.tbadk.core.util.aq.k(this.cIG, w.e.common_color_10222);
        getLayoutMode().t(this.aor);
        getLayoutMode().t(this.mTextView);
        getLayoutMode().t(this.cIF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.cIH.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cIH.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.cIH.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        aK(this.mIndex, this.mIndex);
        this.cIH.onDestroy();
        if (this.cIE != null) {
            this.cIE.cancel();
            this.cIE = null;
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
        this.cII = new d(this);
        f fVar = new f(this, new e(this));
        this.cIG = (NavigationBar) findViewById(w.h.navigation_bar);
        this.cIF = (FrameLayout) this.cIG.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.image_activity_save_button, this.mOnClickListener);
        if (this.cIS) {
            this.cIF.setVisibility(8);
        }
        this.aor = this.cIG.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.mTextView = this.cIG.setTitleText("");
        this.cIH = (MultiImageView) findViewById(w.h.viewpager);
        this.cIH.setPageMargin(com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), 8.0f));
        this.cIH.J(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.cIH.setOnPageChangeListener(this.mOnPageChangeListener);
        this.cIH.setItemOnclickListener(this.mOnClickListener);
        this.cIH.setCurrentItem(akG(), false);
        this.cIH.setOnScrollOutListener(this.cII);
        this.cIH.setItemOnLongClickListener(fVar);
        this.cIH.setHasNext(false);
        this.cIH.setNextTitle("mNextTitle");
        this.cIH.setIsFromCDN(true);
        this.cIH.setAllowLocalUrl(true);
        aK(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akF() {
        if (this.cID != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + this.mCount;
            }
            if (this.cIH.getHasNext() && this.mIndex == this.cIH.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(w.l.image_recommend));
                this.cIF.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.cIF.setClickable(true);
        }
    }

    private int akG() {
        if (this.cID != null && this.cID.size() > 0) {
            int size = this.cID.size();
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
            this.cIM = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.cIN = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.cIO = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.cIS = intent.getBooleanExtra("isSingle", false);
            if (this.cIO == null) {
                this.cIO = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.cIM == null) {
                this.cIM = "";
            }
            this.cID = new LinkedHashMap<>();
            this.cID.put(this.cIO, this.cIM);
            this.cIR = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.cID = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.id = bundle.getString("id");
            this.cIO = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.cIR = bundle.getInt("chat_mode", 0);
            this.cIS = bundle.getBoolean("isSingle", false);
            if (this.cIO == null) {
                this.cIO = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.cIQ = new HashMap<>();
    }

    private void akH() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new g(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.cID);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.cIO);
        bundle.putInt("chat_mode", this.cIR);
        bundle.putBoolean("isSingle", this.cIS);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.cIH.setCurrentItem(this.mIndex, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        String mUrl;
        byte[] rL;

        public a(String str, byte[] bArr) {
            this.mUrl = null;
            this.rL = null;
            this.mUrl = str;
            this.rL = bArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            switch (com.baidu.tbadk.core.util.l.a(this.mUrl, this.rL, AbsMsgImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.l.ue();
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
            AbsMsgImageActivity.this.cIE = null;
            AbsMsgImageActivity.this.cIF.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.cIE = null;
            AbsMsgImageActivity.this.cIF.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r7v0 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void aK(int i, int i2) {
        synchronized (this.cIQ) {
            if (System.nanoTime() - this.cIP > 300000000 && this.cID != null && i < this.cID.size()) {
                this.cIQ.put(this.cID.get(new StringBuilder().append(i).toString()), true);
            }
            this.cIP = System.nanoTime();
        }
    }
}
