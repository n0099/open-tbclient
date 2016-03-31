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
    private FrameLayout bXT;
    private String bYb;
    private boolean bYg;
    private int xj;
    private LinkedHashMap<String, String> bXR = null;
    private int mIndex = 0;
    private a bXS = null;
    private View ajA = null;
    private TextView WY = null;
    private NavigationBar bXU = null;
    private MultiImageView bXV = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a bXW = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation bXX = null;
    private boolean bXY = true;
    private boolean bXZ = false;
    private String bYa = "";
    private String id = "";
    private String bYc = "";
    private long bYd = 0;
    private HashMap<String, Boolean> bYe = null;
    private int bYf = 0;

    protected abstract void a(String str, ad adVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m411getInst().addRemoteActivity(this);
        setContentView(t.h.image_activity_2);
        initData(bundle);
        pU();
        abG();
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
        abG();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.bXV.setBackgroundColor(com.baidu.tbadk.core.util.at.cP(i));
        } else {
            this.bXV.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        com.baidu.tbadk.core.util.at.l(this.bXU, t.d.alpha80_black);
        getLayoutMode().x(this.ajA);
        getLayoutMode().x(this.WY);
        getLayoutMode().x(this.bXT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bXV.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bXV.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.bXV.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        aq(this.mIndex, this.mIndex);
        this.bXV.onDestroy();
        if (this.bXS != null) {
            this.bXS.cancel();
            this.bXS = null;
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

    private void pU() {
        this.mOnClickListener = new com.baidu.tieba.im.chat.a(this);
        this.mOnPageChangeListener = new c(this);
        this.bXW = new d(this);
        f fVar = new f(this, new e(this));
        this.bXU = (NavigationBar) findViewById(t.g.navigation_bar);
        this.bXT = (FrameLayout) this.bXU.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.image_activity_save_button, this.mOnClickListener);
        if (this.bYg) {
            this.bXT.setVisibility(8);
        }
        this.ajA = this.bXU.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.WY = this.bXU.setTitleText("");
        this.bXV = (MultiImageView) findViewById(t.g.viewpager);
        this.bXV.setPageMargin(com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), 8.0f));
        this.bXV.A(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.bXV.setOnPageChangeListener(this.mOnPageChangeListener);
        this.bXV.setItemOnclickListener(this.mOnClickListener);
        this.bXV.setCurrentItem(abF(), false);
        this.bXV.setOnScrollOutListener(this.bXW);
        this.bXV.setItemOnLongClickListener(fVar);
        this.bXV.setHasNext(false);
        this.bXV.setNextTitle("mNextTitle");
        this.bXV.setIsFromCDN(true);
        this.bXV.setAllowLocalUrl(true);
        aq(this.mIndex, this.mIndex);
        this.WY.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abE() {
        if (this.bXR != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.xj > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + this.xj;
            }
            if (this.bXV.getHasNext() && this.mIndex == this.bXV.getItemNum() - 1) {
                this.WY.setText(getPageContext().getString(t.j.image_recommend));
                this.bXT.setClickable(false);
                return;
            }
            this.WY.setText(valueOf);
            this.bXT.setClickable(true);
        }
    }

    private int abF() {
        if (this.bXR != null && this.bXR.size() > 0) {
            int size = this.bXR.size();
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
            this.bYa = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.bYb = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.bYc = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.bYg = intent.getBooleanExtra("isSingle", false);
            if (this.bYc == null) {
                this.bYc = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.bYa == null) {
                this.bYa = "";
            }
            this.bXR = new LinkedHashMap<>();
            this.bXR.put(this.bYc, this.bYa);
            this.bYf = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.bXR = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.id = bundle.getString("id");
            this.bYc = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.bYf = bundle.getInt("chat_mode", 0);
            this.bYg = bundle.getBoolean("isSingle", false);
            if (this.bYc == null) {
                this.bYc = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.bYe = new HashMap<>();
    }

    private void abG() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new g(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.bXR);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.bYc);
        bundle.putInt("chat_mode", this.bYf);
        bundle.putBoolean("isSingle", this.bYg);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.bXV.setCurrentItem(this.mIndex, true);
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
        /* renamed from: h */
        public String doInBackground(String... strArr) {
            switch (com.baidu.tbadk.core.util.m.a(this.mUrl, this.rK, AbsMsgImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.m.vq();
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
        /* renamed from: er */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            AbsMsgImageActivity.this.bXS = null;
            AbsMsgImageActivity.this.bXT.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.bXS = null;
            AbsMsgImageActivity.this.bXT.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r7v0 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void aq(int i, int i2) {
        synchronized (this.bYe) {
            if (System.nanoTime() - this.bYd > 300000000 && this.bXR != null && i < this.bXR.size()) {
                this.bYe.put(this.bXR.get(new StringBuilder().append(i).toString()), true);
            }
            this.bYd = System.nanoTime();
        }
    }
}
