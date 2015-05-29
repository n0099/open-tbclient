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
    private FrameLayout aYX;
    private String aZf;
    private boolean aZk;
    private int mCount;
    private LinkedHashMap<String, String> aYV = null;
    private int mIndex = 0;
    private h aYW = null;
    private View mBack = null;
    private TextView mTextView = null;
    private NavigationBar aYY = null;
    private MultiImageView aYZ = null;
    private View.OnClickListener mOnClickListener = null;
    private com.baidu.tbadk.core.view.a aZa = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation aZb = null;
    private boolean aZc = true;
    private boolean aZd = false;
    private String aZe = "";
    private String id = "";
    private String aZg = "";
    private long aZh = 0;
    private HashMap<String, Boolean> aZi = null;
    private int aZj = 0;

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
        OU();
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
        OU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.aYZ.setBackgroundColor(ay.ci(i));
        } else {
            this.aYZ.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        ay.j(this.aYY, com.baidu.tieba.n.alpha80_black);
        getLayoutMode().j(this.mBack);
        getLayoutMode().j(this.mTextView);
        getLayoutMode().j(this.aYX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aYZ.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aYZ.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.aYZ.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        R(this.mIndex, this.mIndex);
        this.aYZ.onDestroy();
        if (this.aYW != null) {
            this.aYW.cancel();
            this.aYW = null;
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
        this.aZa = new d(this);
        f fVar = new f(this, new e(this));
        this.aYY = (NavigationBar) findViewById(com.baidu.tieba.q.navigation_bar);
        this.aYX = (FrameLayout) this.aYY.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.image_activity_save_button, this.mOnClickListener);
        if (this.aZk) {
            this.aYX.setVisibility(8);
        }
        this.mBack = this.aYY.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.mTextView = this.aYY.setTitleText("");
        this.aYY.findViewById(com.baidu.tieba.q.navBottomLine).setVisibility(8);
        this.aYZ = (MultiImageView) findViewById(com.baidu.tieba.q.viewpager);
        this.aYZ.setPageMargin(com.baidu.adp.lib.util.n.dip2px(getPageContext().getContext(), 8.0f));
        this.aYZ.w(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.aYZ.setOnPageChangeListener(this.mOnPageChangeListener);
        this.aYZ.setItemOnclickListener(this.mOnClickListener);
        this.aYZ.setCurrentItem(OT(), false);
        this.aYZ.setOnScrollOutListener(this.aZa);
        this.aYZ.setItemOnLongClickListener(fVar);
        this.aYZ.setHasNext(false);
        this.aYZ.setNextTitle("mNextTitle");
        this.aYZ.setIsFromCDN(true);
        this.aYZ.setAllowLocalUrl(true);
        R(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OS() {
        if (this.aYV != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + this.mCount;
            }
            if (this.aYZ.getHasNext() && this.mIndex == this.aYZ.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(com.baidu.tieba.t.image_recommend));
                this.aYX.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.aYX.setClickable(true);
        }
    }

    private int OT() {
        if (this.aYV != null && this.aYV.size() > 0) {
            int size = this.aYV.size();
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
            this.aZe = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.aZf = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.aZg = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.aZk = intent.getBooleanExtra("isSingle", false);
            if (this.aZg == null) {
                this.aZg = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.aZe == null) {
                this.aZe = "";
            }
            this.aYV = new LinkedHashMap<>();
            this.aYV.put(this.aZg, this.aZe);
            this.aZj = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.aYV = (LinkedHashMap) bundle.getSerializable(ImageViewerConfig.URL);
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.id = bundle.getString("id");
            this.aZg = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.aZj = bundle.getInt("chat_mode", 0);
            this.aZk = bundle.getBoolean("isSingle", false);
            if (this.aZg == null) {
                this.aZg = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.aZi = new HashMap<>();
    }

    private void OU() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new g(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(ImageViewerConfig.URL, this.aYV);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.aZg);
        bundle.putInt("chat_mode", this.aZj);
        bundle.putBoolean("isSingle", this.aZk);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.aYZ.setCurrentItem(this.mIndex, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(int i, int i2) {
        synchronized (this.aZi) {
            if (System.nanoTime() - this.aZh > 300000000 && this.aYV != null && i < this.aYV.size()) {
                this.aZi.put(this.aYV.get(Integer.valueOf(i)), true);
            }
            this.aZh = System.nanoTime();
        }
    }
}
