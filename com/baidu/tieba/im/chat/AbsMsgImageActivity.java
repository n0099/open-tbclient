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
    private FrameLayout aQX;
    private boolean aRi;
    private int mCount;
    private LinkedHashMap<String, String> aQV = null;
    private int mIndex = 0;
    private h aQW = null;
    private View mBack = null;
    private TextView mTextView = null;
    private NavigationBar aQY = null;
    private MultiImageView aQZ = null;
    private View.OnClickListener mOnClickListener = null;
    private com.baidu.tbadk.core.view.a aRa = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation akZ = null;
    private boolean aRb = true;
    private boolean aRc = false;
    private String aRd = "";
    private String id = "";
    private String aRe = "";
    private long aRf = 0;
    private HashMap<String, Boolean> aRg = null;
    private int aRh = 0;

    protected abstract void a(String str, ad adVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkCoreApplication.m255getInst().addRemoteActivity(this);
        setContentView(com.baidu.tieba.x.image_activity_2);
        initData(bundle);
        initUI();
        Kh();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        Kh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.aQZ.setBackgroundColor(com.baidu.tbadk.core.util.bc.cc(i));
        } else {
            this.aQZ.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        com.baidu.tbadk.core.util.bc.j(this.aQY, com.baidu.tieba.t.alpha80_black);
        getLayoutMode().h(this.mBack);
        getLayoutMode().h(this.mTextView);
        getLayoutMode().h(this.aQX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aQZ.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aQZ.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.aQZ.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        O(this.mIndex, this.mIndex);
        this.aQZ.onDestroy();
        if (this.aQW != null) {
            this.aQW.cancel();
            this.aQW = null;
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
        this.aRa = new d(this);
        f fVar = new f(this, new e(this));
        this.aQY = (NavigationBar) findViewById(com.baidu.tieba.w.navigation_bar);
        this.aQX = (FrameLayout) this.aQY.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.image_activity_save_button, this.mOnClickListener);
        if (this.aRi) {
            this.aQX.setVisibility(8);
        }
        this.mBack = this.aQY.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.mTextView = this.aQY.setTitleText("");
        this.aQY.findViewById(com.baidu.tieba.w.navBottomLine).setVisibility(8);
        this.aQZ = (MultiImageView) findViewById(com.baidu.tieba.w.viewpager);
        this.aQZ.setPageMargin(com.baidu.adp.lib.util.l.dip2px(getPageContext().getContext(), 8.0f));
        this.aQZ.x(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.aQZ.setOnPageChangeListener(this.mOnPageChangeListener);
        this.aQZ.setItemOnclickListener(this.mOnClickListener);
        this.aQZ.setCurrentItem(Kg(), false);
        this.aQZ.setOnScrollOutListener(this.aRa);
        this.aQZ.setItemOnLongClickListener(fVar);
        this.aQZ.setHasNext(false);
        this.aQZ.setNextTitle("mNextTitle");
        this.aQZ.setIsFromCDN(true);
        this.aQZ.setAllowLocalUrl(true);
        O(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kf() {
        if (this.aQV != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + this.mCount;
            }
            if (this.aQZ.getHasNext() && this.mIndex == this.aQZ.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(com.baidu.tieba.z.image_recommend));
                this.aQX.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.aQX.setClickable(true);
        }
    }

    private int Kg() {
        if (this.aQV != null && this.aQV.size() > 0) {
            int size = this.aQV.size();
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
            this.aRd = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.id = intent.getStringExtra("id");
            this.aRe = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.aRi = intent.getBooleanExtra("isSingle", false);
            if (this.aRe == null) {
                this.aRe = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.aRd == null) {
                this.aRd = "";
            }
            this.aQV = new LinkedHashMap<>();
            this.aQV.put(this.aRe, this.aRd);
            this.aRh = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.aQV = (LinkedHashMap) bundle.getSerializable(ImageViewerConfig.URL);
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.id = bundle.getString("id");
            this.aRe = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.aRh = bundle.getInt("chat_mode", 0);
            this.aRi = bundle.getBoolean("isSingle", false);
            if (this.aRe == null) {
                this.aRe = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.aRg = new HashMap<>();
    }

    private void Kh() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new g(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(ImageViewerConfig.URL, this.aQV);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.aRe);
        bundle.putInt("chat_mode", this.aRh);
        bundle.putBoolean("isSingle", this.aRi);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.aQZ.setCurrentItem(this.mIndex, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(int i, int i2) {
        synchronized (this.aRg) {
            if (System.nanoTime() - this.aRf > 300000000 && this.aQV != null && i < this.aQV.size()) {
                this.aRg.put(this.aQV.get(Integer.valueOf(i)), true);
            }
            this.aRf = System.nanoTime();
        }
    }
}
