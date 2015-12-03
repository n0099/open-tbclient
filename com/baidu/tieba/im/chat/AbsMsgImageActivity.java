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
    private FrameLayout bGl;
    private String bGt;
    private boolean bGy;
    private int wH;
    private LinkedHashMap<String, String> bGj = null;
    private int mIndex = 0;
    private a bGk = null;
    private View mBack = null;
    private TextView mTextView = null;
    private NavigationBar bGm = null;
    private MultiImageView bGn = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a bGo = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation bGp = null;
    private boolean bGq = true;
    private boolean bGr = false;
    private String bGs = "";
    private String id = "";
    private String bGu = "";
    private long bGv = 0;
    private HashMap<String, Boolean> bGw = null;
    private int bGx = 0;

    protected abstract void a(String str, ad adVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m411getInst().addRemoteActivity(this);
        setContentView(n.g.image_activity_2);
        initData(bundle);
        initUI();
        UN();
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
        UN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.bGn.setBackgroundColor(com.baidu.tbadk.core.util.as.cC(i));
        } else {
            this.bGn.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        com.baidu.tbadk.core.util.as.j(this.bGm, n.c.alpha80_black);
        getLayoutMode().k(this.mBack);
        getLayoutMode().k(this.mTextView);
        getLayoutMode().k(this.bGl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bGn.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bGn.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.bGn.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        ah(this.mIndex, this.mIndex);
        this.bGn.onDestroy();
        if (this.bGk != null) {
            this.bGk.cancel();
            this.bGk = null;
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
        this.bGo = new d(this);
        f fVar = new f(this, new e(this));
        this.bGm = (NavigationBar) findViewById(n.f.navigation_bar);
        this.bGl = (FrameLayout) this.bGm.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.g.image_activity_save_button, this.mOnClickListener);
        if (this.bGy) {
            this.bGl.setVisibility(8);
        }
        this.mBack = this.bGm.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.mTextView = this.bGm.setTitleText("");
        this.bGm.findViewById(n.f.navBottomLine).setVisibility(8);
        this.bGn = (MultiImageView) findViewById(n.f.viewpager);
        this.bGn.setPageMargin(com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), 8.0f));
        this.bGn.H(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.bGn.setOnPageChangeListener(this.mOnPageChangeListener);
        this.bGn.setItemOnclickListener(this.mOnClickListener);
        this.bGn.setCurrentItem(UM(), false);
        this.bGn.setOnScrollOutListener(this.bGo);
        this.bGn.setItemOnLongClickListener(fVar);
        this.bGn.setHasNext(false);
        this.bGn.setNextTitle("mNextTitle");
        this.bGn.setIsFromCDN(true);
        this.bGn.setAllowLocalUrl(true);
        ah(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UL() {
        if (this.bGj != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.wH > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + this.wH;
            }
            if (this.bGn.getHasNext() && this.mIndex == this.bGn.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(n.i.image_recommend));
                this.bGl.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.bGl.setClickable(true);
        }
    }

    private int UM() {
        if (this.bGj != null && this.bGj.size() > 0) {
            int size = this.bGj.size();
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
            this.bGs = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.bGt = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.bGu = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.bGy = intent.getBooleanExtra("isSingle", false);
            if (this.bGu == null) {
                this.bGu = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.bGs == null) {
                this.bGs = "";
            }
            this.bGj = new LinkedHashMap<>();
            this.bGj.put(this.bGu, this.bGs);
            this.bGx = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.bGj = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.id = bundle.getString("id");
            this.bGu = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.bGx = bundle.getInt("chat_mode", 0);
            this.bGy = bundle.getBoolean("isSingle", false);
            if (this.bGu == null) {
                this.bGu = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.bGw = new HashMap<>();
    }

    private void UN() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new g(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.bGj);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.bGu);
        bundle.putInt("chat_mode", this.bGx);
        bundle.putBoolean("isSingle", this.bGy);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.bGn.setCurrentItem(this.mIndex, true);
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
                    return com.baidu.tbadk.core.util.n.ug();
                case -1:
                default:
                    return AbsMsgImageActivity.this.getPageContext().getString(n.i.save_error);
                case 0:
                    return AbsMsgImageActivity.this.getPageContext().getString(n.i.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            AbsMsgImageActivity.this.bGk = null;
            AbsMsgImageActivity.this.bGl.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.bGk = null;
            AbsMsgImageActivity.this.bGl.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r7v0 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void ah(int i, int i2) {
        synchronized (this.bGw) {
            if (System.nanoTime() - this.bGv > 300000000 && this.bGj != null && i < this.bGj.size()) {
                this.bGw.put(this.bGj.get(new StringBuilder().append(i).toString()), true);
            }
            this.bGv = System.nanoTime();
        }
    }
}
