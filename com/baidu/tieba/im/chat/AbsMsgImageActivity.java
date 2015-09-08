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
import com.baidu.tieba.i;
import com.baidu.tieba.im.c.ad;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public abstract class AbsMsgImageActivity extends BaseActivity<AbsMsgImageActivity> {
    private boolean bnE;
    private FrameLayout bnr;
    private String bnz;
    private int wA;
    private LinkedHashMap<String, String> bnp = null;
    private int mIndex = 0;
    private a bnq = null;
    private View mBack = null;
    private TextView mTextView = null;
    private NavigationBar bns = null;
    private MultiImageView bnt = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a bnu = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation bnv = null;
    private boolean bnw = true;
    private boolean bnx = false;
    private String bny = "";
    private String id = "";
    private String bnA = "";
    private long bnB = 0;
    private HashMap<String, Boolean> bnC = null;
    private int bnD = 0;

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
        QI();
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
        QI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.bnt.setBackgroundColor(com.baidu.tbadk.core.util.al.cs(i));
        } else {
            this.bnt.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        com.baidu.tbadk.core.util.al.i(this.bns, i.c.alpha80_black);
        getLayoutMode().k(this.mBack);
        getLayoutMode().k(this.mTextView);
        getLayoutMode().k(this.bnr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bnt.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bnt.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.bnt.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        ac(this.mIndex, this.mIndex);
        this.bnt.onDestroy();
        if (this.bnq != null) {
            this.bnq.cancel();
            this.bnq = null;
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
        this.bnu = new d(this);
        f fVar = new f(this, new e(this));
        this.bns = (NavigationBar) findViewById(i.f.navigation_bar);
        this.bnr = (FrameLayout) this.bns.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.image_activity_save_button, this.mOnClickListener);
        if (this.bnE) {
            this.bnr.setVisibility(8);
        }
        this.mBack = this.bns.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.mTextView = this.bns.setTitleText("");
        this.bns.findViewById(i.f.navBottomLine).setVisibility(8);
        this.bnt = (MultiImageView) findViewById(i.f.viewpager);
        this.bnt.setPageMargin(com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), 8.0f));
        this.bnt.G(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.bnt.setOnPageChangeListener(this.mOnPageChangeListener);
        this.bnt.setItemOnclickListener(this.mOnClickListener);
        this.bnt.setCurrentItem(QH(), false);
        this.bnt.setOnScrollOutListener(this.bnu);
        this.bnt.setItemOnLongClickListener(fVar);
        this.bnt.setHasNext(false);
        this.bnt.setNextTitle("mNextTitle");
        this.bnt.setIsFromCDN(true);
        this.bnt.setAllowLocalUrl(true);
        ac(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QG() {
        if (this.bnp != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.wA > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + this.wA;
            }
            if (this.bnt.getHasNext() && this.mIndex == this.bnt.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(i.h.image_recommend));
                this.bnr.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.bnr.setClickable(true);
        }
    }

    private int QH() {
        if (this.bnp != null && this.bnp.size() > 0) {
            int size = this.bnp.size();
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
            this.bny = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.bnz = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.bnA = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.bnE = intent.getBooleanExtra("isSingle", false);
            if (this.bnA == null) {
                this.bnA = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.bny == null) {
                this.bny = "";
            }
            this.bnp = new LinkedHashMap<>();
            this.bnp.put(this.bnA, this.bny);
            this.bnD = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.bnp = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.id = bundle.getString("id");
            this.bnA = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.bnD = bundle.getInt("chat_mode", 0);
            this.bnE = bundle.getBoolean("isSingle", false);
            if (this.bnA == null) {
                this.bnA = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.bnC = new HashMap<>();
    }

    private void QI() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new g(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.bnp);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.bnA);
        bundle.putInt("chat_mode", this.bnD);
        bundle.putBoolean("isSingle", this.bnE);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.bnt.setCurrentItem(this.mIndex, true);
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
                    return com.baidu.tbadk.core.util.n.tD();
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
            AbsMsgImageActivity.this.bnq = null;
            AbsMsgImageActivity.this.bnr.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.bnq = null;
            AbsMsgImageActivity.this.bnr.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r7v0 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void ac(int i, int i2) {
        synchronized (this.bnC) {
            if (System.nanoTime() - this.bnB > 300000000 && this.bnp != null && i < this.bnp.size()) {
                this.bnC.put(this.bnp.get(new StringBuilder().append(i).toString()), true);
            }
            this.bnB = System.nanoTime();
        }
    }
}
