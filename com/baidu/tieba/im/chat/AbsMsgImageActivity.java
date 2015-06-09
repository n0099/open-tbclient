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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AbsMsgImageActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.im.c.ad;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public abstract class AbsMsgImageActivity extends BaseActivity<AbsMsgImageActivity> {
    private FrameLayout aYY;
    private String aZg;
    private boolean aZl;
    private int mCount;
    private LinkedHashMap<String, String> aYW = null;
    private int mIndex = 0;
    private h aYX = null;
    private View mBack = null;
    private TextView mTextView = null;
    private NavigationBar aYZ = null;
    private MultiImageView aZa = null;
    private View.OnClickListener mOnClickListener = null;
    private com.baidu.tbadk.core.view.a aZb = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation aZc = null;
    private boolean aZd = true;
    private boolean aZe = false;
    private String aZf = "";
    private String id = "";
    private String aZh = "";
    private long aZi = 0;
    private HashMap<String, Boolean> aZj = null;
    private int aZk = 0;

    protected abstract void a(String str, ad adVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m411getInst().addRemoteActivity(this);
        setContentView(com.baidu.tieba.r.image_activity_2);
        initData(bundle);
        initUI();
        OV();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        overridePendingTransition(com.baidu.tieba.k.big_imageview_in, com.baidu.tieba.k.fade_out);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        overridePendingTransition(com.baidu.tieba.k.fade_in, com.baidu.tieba.k.big_imageview_out);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        OV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.aZa.setBackgroundColor(ay.ci(i));
        } else {
            this.aZa.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        ay.j(this.aYZ, com.baidu.tieba.n.alpha80_black);
        getLayoutMode().j(this.mBack);
        getLayoutMode().j(this.mTextView);
        getLayoutMode().j(this.aYY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aZa.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aZa.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.aZa.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        R(this.mIndex, this.mIndex);
        this.aZa.onDestroy();
        if (this.aYX != null) {
            this.aYX.cancel();
            this.aYX = null;
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
        this.mOnClickListener = new a(this);
        this.mOnPageChangeListener = new c(this);
        this.aZb = new d(this);
        f fVar = new f(this, new e(this));
        this.aYZ = (NavigationBar) findViewById(com.baidu.tieba.q.navigation_bar);
        this.aYY = (FrameLayout) this.aYZ.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.image_activity_save_button, this.mOnClickListener);
        if (this.aZl) {
            this.aYY.setVisibility(8);
        }
        this.mBack = this.aYZ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.mTextView = this.aYZ.setTitleText("");
        this.aYZ.findViewById(com.baidu.tieba.q.navBottomLine).setVisibility(8);
        this.aZa = (MultiImageView) findViewById(com.baidu.tieba.q.viewpager);
        this.aZa.setPageMargin(com.baidu.adp.lib.util.n.dip2px(getPageContext().getContext(), 8.0f));
        this.aZa.w(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.aZa.setOnPageChangeListener(this.mOnPageChangeListener);
        this.aZa.setItemOnclickListener(this.mOnClickListener);
        this.aZa.setCurrentItem(OU(), false);
        this.aZa.setOnScrollOutListener(this.aZb);
        this.aZa.setItemOnLongClickListener(fVar);
        this.aZa.setHasNext(false);
        this.aZa.setNextTitle("mNextTitle");
        this.aZa.setIsFromCDN(true);
        this.aZa.setAllowLocalUrl(true);
        R(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OT() {
        if (this.aYW != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + this.mCount;
            }
            if (this.aZa.getHasNext() && this.mIndex == this.aZa.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(com.baidu.tieba.t.image_recommend));
                this.aYY.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.aYY.setClickable(true);
        }
    }

    private int OU() {
        if (this.aYW != null && this.aYW.size() > 0) {
            int size = this.aYW.size();
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
            this.aZf = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.aZg = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.aZh = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.aZl = intent.getBooleanExtra("isSingle", false);
            if (this.aZh == null) {
                this.aZh = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.aZf == null) {
                this.aZf = "";
            }
            this.aYW = new LinkedHashMap<>();
            this.aYW.put(this.aZh, this.aZf);
            this.aZk = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.aYW = (LinkedHashMap) bundle.getSerializable(ImageViewerConfig.URL);
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.id = bundle.getString("id");
            this.aZh = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.aZk = bundle.getInt("chat_mode", 0);
            this.aZl = bundle.getBoolean("isSingle", false);
            if (this.aZh == null) {
                this.aZh = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.aZj = new HashMap<>();
    }

    private void OV() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new g(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(ImageViewerConfig.URL, this.aYW);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.aZh);
        bundle.putInt("chat_mode", this.aZk);
        bundle.putBoolean("isSingle", this.aZl);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.aZa.setCurrentItem(this.mIndex, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(int i, int i2) {
        synchronized (this.aZj) {
            if (System.nanoTime() - this.aZi > 300000000 && this.aYW != null && i < this.aYW.size()) {
                this.aZj.put(this.aYW.get(Integer.valueOf(i)), true);
            }
            this.aZi = System.nanoTime();
        }
    }
}
