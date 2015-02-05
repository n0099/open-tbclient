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
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.im.c.ad;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public abstract class AbsMsgImageActivity extends BaseActivity<AbsMsgImageActivity> {
    private FrameLayout aQW;
    private boolean aRh;
    private int mCount;
    private LinkedHashMap<String, String> aQU = null;
    private int mIndex = 0;
    private h aQV = null;
    private View mBack = null;
    private TextView mTextView = null;
    private NavigationBar aQX = null;
    private MultiImageView aQY = null;
    private View.OnClickListener mOnClickListener = null;
    private com.baidu.tbadk.core.view.a aQZ = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation akW = null;
    private boolean aRa = true;
    private boolean aRb = false;
    private String aRc = "";
    private String id = "";
    private String aRd = "";
    private long aRe = 0;
    private HashMap<String, Boolean> aRf = null;
    private int aRg = 0;

    protected abstract void a(String str, ad adVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkCoreApplication.m255getInst().addRemoteActivity(this);
        setContentView(com.baidu.tieba.x.image_activity_2);
        initData(bundle);
        initUI();
        Kc();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        Kc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.aQY.setBackgroundColor(com.baidu.tbadk.core.util.bc.cc(i));
        } else {
            this.aQY.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        com.baidu.tbadk.core.util.bc.j(this.aQX, com.baidu.tieba.t.alpha80_black);
        getLayoutMode().h(this.mBack);
        getLayoutMode().h(this.mTextView);
        getLayoutMode().h(this.aQW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aQY.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aQY.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.aQY.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        P(this.mIndex, this.mIndex);
        this.aQY.onDestroy();
        if (this.aQV != null) {
            this.aQV.cancel();
            this.aQV = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.m255getInst().delRemoteActivity(this);
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
        this.aQZ = new d(this);
        f fVar = new f(this, new e(this));
        this.aQX = (NavigationBar) findViewById(com.baidu.tieba.w.navigation_bar);
        this.aQW = (FrameLayout) this.aQX.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.image_activity_save_button, this.mOnClickListener);
        if (this.aRh) {
            this.aQW.setVisibility(8);
        }
        this.mBack = this.aQX.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.mTextView = this.aQX.setTitleText("");
        this.aQX.findViewById(com.baidu.tieba.w.navBottomLine).setVisibility(8);
        this.aQY = (MultiImageView) findViewById(com.baidu.tieba.w.viewpager);
        this.aQY.setPageMargin(com.baidu.adp.lib.util.l.dip2px(getPageContext().getContext(), 8.0f));
        this.aQY.x(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.aQY.setOnPageChangeListener(this.mOnPageChangeListener);
        this.aQY.setItemOnclickListener(this.mOnClickListener);
        this.aQY.setCurrentItem(Kb(), false);
        this.aQY.setOnScrollOutListener(this.aQZ);
        this.aQY.setItemOnLongClickListener(fVar);
        this.aQY.setHasNext(false);
        this.aQY.setNextTitle("mNextTitle");
        this.aQY.setIsFromCDN(true);
        this.aQY.setAllowLocalUrl(true);
        P(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ka() {
        if (this.aQU != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + this.mCount;
            }
            if (this.aQY.getHasNext() && this.mIndex == this.aQY.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(com.baidu.tieba.z.image_recommend));
                this.aQW.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.aQW.setClickable(true);
        }
    }

    private int Kb() {
        if (this.aQU != null && this.aQU.size() > 0) {
            int size = this.aQU.size();
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
            this.aRc = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.id = intent.getStringExtra("id");
            this.aRd = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.aRh = intent.getBooleanExtra("isSingle", false);
            if (this.aRd == null) {
                this.aRd = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.aRc == null) {
                this.aRc = "";
            }
            this.aQU = new LinkedHashMap<>();
            this.aQU.put(this.aRd, this.aRc);
            this.aRg = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.aQU = (LinkedHashMap) bundle.getSerializable(ImageViewerConfig.URL);
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.id = bundle.getString("id");
            this.aRd = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.aRg = bundle.getInt("chat_mode", 0);
            this.aRh = bundle.getBoolean("isSingle", false);
            if (this.aRd == null) {
                this.aRd = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.aRf = new HashMap<>();
    }

    private void Kc() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new g(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(ImageViewerConfig.URL, this.aQU);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.aRd);
        bundle.putInt("chat_mode", this.aRg);
        bundle.putBoolean("isSingle", this.aRh);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.aQY.setCurrentItem(this.mIndex, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(int i, int i2) {
        synchronized (this.aRf) {
            if (System.nanoTime() - this.aRe > 300000000 && this.aQU != null && i < this.aQU.size()) {
                this.aRf.put(this.aQU.get(Integer.valueOf(i)), true);
            }
            this.aRe = System.nanoTime();
        }
    }
}
