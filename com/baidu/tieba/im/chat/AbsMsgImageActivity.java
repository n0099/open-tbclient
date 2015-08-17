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
    private FrameLayout bmT;
    private String bnb;
    private boolean bng;
    private int wC;
    private LinkedHashMap<String, String> bmR = null;
    private int mIndex = 0;
    private a bmS = null;
    private View mBack = null;
    private TextView mTextView = null;
    private NavigationBar bmU = null;
    private MultiImageView bmV = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a bmW = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation bmX = null;
    private boolean bmY = true;
    private boolean bmZ = false;
    private String bna = "";
    private String id = "";
    private String bnc = "";
    private long bnd = 0;
    private HashMap<String, Boolean> bne = null;
    private int bnf = 0;

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
        QG();
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
        QG();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.bmV.setBackgroundColor(com.baidu.tbadk.core.util.al.co(i));
        } else {
            this.bmV.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        com.baidu.tbadk.core.util.al.j(this.bmU, i.c.alpha80_black);
        getLayoutMode().k(this.mBack);
        getLayoutMode().k(this.mTextView);
        getLayoutMode().k(this.bmT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bmV.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bmV.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.bmV.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        ac(this.mIndex, this.mIndex);
        this.bmV.onDestroy();
        if (this.bmS != null) {
            this.bmS.cancel();
            this.bmS = null;
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
        this.bmW = new d(this);
        f fVar = new f(this, new e(this));
        this.bmU = (NavigationBar) findViewById(i.f.navigation_bar);
        this.bmT = (FrameLayout) this.bmU.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.image_activity_save_button, this.mOnClickListener);
        if (this.bng) {
            this.bmT.setVisibility(8);
        }
        this.mBack = this.bmU.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.mTextView = this.bmU.setTitleText("");
        this.bmU.findViewById(i.f.navBottomLine).setVisibility(8);
        this.bmV = (MultiImageView) findViewById(i.f.viewpager);
        this.bmV.setPageMargin(com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), 8.0f));
        this.bmV.G(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.bmV.setOnPageChangeListener(this.mOnPageChangeListener);
        this.bmV.setItemOnclickListener(this.mOnClickListener);
        this.bmV.setCurrentItem(QF(), false);
        this.bmV.setOnScrollOutListener(this.bmW);
        this.bmV.setItemOnLongClickListener(fVar);
        this.bmV.setHasNext(false);
        this.bmV.setNextTitle("mNextTitle");
        this.bmV.setIsFromCDN(true);
        this.bmV.setAllowLocalUrl(true);
        ac(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QE() {
        if (this.bmR != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.wC > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + this.wC;
            }
            if (this.bmV.getHasNext() && this.mIndex == this.bmV.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(i.C0057i.image_recommend));
                this.bmT.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.bmT.setClickable(true);
        }
    }

    private int QF() {
        if (this.bmR != null && this.bmR.size() > 0) {
            int size = this.bmR.size();
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
            this.bna = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.bnb = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.bnc = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.bng = intent.getBooleanExtra("isSingle", false);
            if (this.bnc == null) {
                this.bnc = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.bna == null) {
                this.bna = "";
            }
            this.bmR = new LinkedHashMap<>();
            this.bmR.put(this.bnc, this.bna);
            this.bnf = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.bmR = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.id = bundle.getString("id");
            this.bnc = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.bnf = bundle.getInt("chat_mode", 0);
            this.bng = bundle.getBoolean("isSingle", false);
            if (this.bnc == null) {
                this.bnc = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.bne = new HashMap<>();
    }

    private void QG() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new g(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.bmR);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.bnc);
        bundle.putInt("chat_mode", this.bnf);
        bundle.putBoolean("isSingle", this.bng);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.bmV.setCurrentItem(this.mIndex, true);
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
                    return com.baidu.tbadk.core.util.n.ty();
                case -1:
                default:
                    return AbsMsgImageActivity.this.getPageContext().getString(i.C0057i.save_error);
                case 0:
                    return AbsMsgImageActivity.this.getPageContext().getString(i.C0057i.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            AbsMsgImageActivity.this.bmS = null;
            AbsMsgImageActivity.this.bmT.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.bmS = null;
            AbsMsgImageActivity.this.bmT.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r7v0 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void ac(int i, int i2) {
        synchronized (this.bne) {
            if (System.nanoTime() - this.bnd > 300000000 && this.bmR != null && i < this.bmR.size()) {
                this.bne.put(this.bmR.get(new StringBuilder().append(i).toString()), true);
            }
            this.bnd = System.nanoTime();
        }
    }
}
