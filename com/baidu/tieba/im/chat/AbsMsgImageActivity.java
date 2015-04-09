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
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public abstract class AbsMsgImageActivity extends BaseActivity<AbsMsgImageActivity> {
    private boolean aWE;
    private FrameLayout aWs;
    private String aWz;
    private int mCount;
    private LinkedHashMap<String, String> aWq = null;
    private int mIndex = 0;
    private h aWr = null;
    private View mBack = null;
    private TextView mTextView = null;
    private NavigationBar aWt = null;
    private MultiImageView aWu = null;
    private View.OnClickListener mOnClickListener = null;
    private com.baidu.tbadk.core.view.a aWv = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation atE = null;
    private boolean aWw = true;
    private boolean aWx = false;
    private String aWy = "";
    private String id = "";
    private String aWA = "";
    private long aWB = 0;
    private HashMap<String, Boolean> aWC = null;
    private int aWD = 0;

    protected abstract void a(String str, com.baidu.tieba.im.c.ad adVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m411getInst().addRemoteActivity(this);
        setContentView(com.baidu.tieba.w.image_activity_2);
        initData(bundle);
        initUI();
        NF();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        overridePendingTransition(com.baidu.tieba.p.big_imageview_in, com.baidu.tieba.p.fade_out);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        overridePendingTransition(com.baidu.tieba.p.fade_in, com.baidu.tieba.p.big_imageview_out);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        NF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.aWu.setBackgroundColor(com.baidu.tbadk.core.util.ba.ce(i));
        } else {
            this.aWu.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        com.baidu.tbadk.core.util.ba.j(this.aWt, com.baidu.tieba.s.alpha80_black);
        getLayoutMode().h(this.mBack);
        getLayoutMode().h(this.mTextView);
        getLayoutMode().h(this.aWs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aWu.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aWu.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.aWu.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        O(this.mIndex, this.mIndex);
        this.aWu.onDestroy();
        if (this.aWr != null) {
            this.aWr.cancel();
            this.aWr = null;
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
        this.aWv = new d(this);
        f fVar = new f(this, new e(this));
        this.aWt = (NavigationBar) findViewById(com.baidu.tieba.v.navigation_bar);
        this.aWs = (FrameLayout) this.aWt.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.image_activity_save_button, this.mOnClickListener);
        if (this.aWE) {
            this.aWs.setVisibility(8);
        }
        this.mBack = this.aWt.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.mTextView = this.aWt.setTitleText("");
        this.aWt.findViewById(com.baidu.tieba.v.navBottomLine).setVisibility(8);
        this.aWu = (MultiImageView) findViewById(com.baidu.tieba.v.viewpager);
        this.aWu.setPageMargin(com.baidu.adp.lib.util.n.dip2px(getPageContext().getContext(), 8.0f));
        this.aWu.v(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.aWu.setOnPageChangeListener(this.mOnPageChangeListener);
        this.aWu.setItemOnclickListener(this.mOnClickListener);
        this.aWu.setCurrentItem(NE(), false);
        this.aWu.setOnScrollOutListener(this.aWv);
        this.aWu.setItemOnLongClickListener(fVar);
        this.aWu.setHasNext(false);
        this.aWu.setNextTitle("mNextTitle");
        this.aWu.setIsFromCDN(true);
        this.aWu.setAllowLocalUrl(true);
        O(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ND() {
        if (this.aWq != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + this.mCount;
            }
            if (this.aWu.getHasNext() && this.mIndex == this.aWu.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(com.baidu.tieba.y.image_recommend));
                this.aWs.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.aWs.setClickable(true);
        }
    }

    private int NE() {
        if (this.aWq != null && this.aWq.size() > 0) {
            int size = this.aWq.size();
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
            this.aWy = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.aWz = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.aWA = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.aWE = intent.getBooleanExtra("isSingle", false);
            if (this.aWA == null) {
                this.aWA = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.aWy == null) {
                this.aWy = "";
            }
            this.aWq = new LinkedHashMap<>();
            this.aWq.put(this.aWA, this.aWy);
            this.aWD = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.aWq = (LinkedHashMap) bundle.getSerializable(ImageViewerConfig.URL);
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.id = bundle.getString("id");
            this.aWA = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.aWD = bundle.getInt("chat_mode", 0);
            this.aWE = bundle.getBoolean("isSingle", false);
            if (this.aWA == null) {
                this.aWA = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.aWC = new HashMap<>();
    }

    private void NF() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new g(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(ImageViewerConfig.URL, this.aWq);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.aWA);
        bundle.putInt("chat_mode", this.aWD);
        bundle.putBoolean("isSingle", this.aWE);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.aWu.setCurrentItem(this.mIndex, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(int i, int i2) {
        synchronized (this.aWC) {
            if (System.nanoTime() - this.aWB > 300000000 && this.aWq != null && i < this.aWq.size()) {
                this.aWC.put(this.aWq.get(Integer.valueOf(i)), true);
            }
            this.aWB = System.nanoTime();
        }
    }
}
