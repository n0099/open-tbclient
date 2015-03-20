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
    private FrameLayout aWc;
    private String aWj;
    private boolean aWo;
    private int mCount;
    private LinkedHashMap<String, String> aWa = null;
    private int mIndex = 0;
    private h aWb = null;
    private View mBack = null;
    private TextView mTextView = null;
    private NavigationBar aWd = null;
    private MultiImageView aWe = null;
    private View.OnClickListener mOnClickListener = null;
    private com.baidu.tbadk.core.view.a aWf = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation atw = null;
    private boolean aWg = true;
    private boolean aWh = false;
    private String aWi = "";
    private String id = "";
    private String aWk = "";
    private long aWl = 0;
    private HashMap<String, Boolean> aWm = null;
    private int aWn = 0;

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
        Ns();
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
        Ns();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.aWe.setBackgroundColor(com.baidu.tbadk.core.util.ba.ce(i));
        } else {
            this.aWe.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        com.baidu.tbadk.core.util.ba.j(this.aWd, com.baidu.tieba.s.alpha80_black);
        getLayoutMode().h(this.mBack);
        getLayoutMode().h(this.mTextView);
        getLayoutMode().h(this.aWc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aWe.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aWe.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.aWe.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        O(this.mIndex, this.mIndex);
        this.aWe.onDestroy();
        if (this.aWb != null) {
            this.aWb.cancel();
            this.aWb = null;
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
        this.aWf = new d(this);
        f fVar = new f(this, new e(this));
        this.aWd = (NavigationBar) findViewById(com.baidu.tieba.v.navigation_bar);
        this.aWc = (FrameLayout) this.aWd.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.image_activity_save_button, this.mOnClickListener);
        if (this.aWo) {
            this.aWc.setVisibility(8);
        }
        this.mBack = this.aWd.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.mTextView = this.aWd.setTitleText("");
        this.aWd.findViewById(com.baidu.tieba.v.navBottomLine).setVisibility(8);
        this.aWe = (MultiImageView) findViewById(com.baidu.tieba.v.viewpager);
        this.aWe.setPageMargin(com.baidu.adp.lib.util.n.dip2px(getPageContext().getContext(), 8.0f));
        this.aWe.v(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.aWe.setOnPageChangeListener(this.mOnPageChangeListener);
        this.aWe.setItemOnclickListener(this.mOnClickListener);
        this.aWe.setCurrentItem(Nr(), false);
        this.aWe.setOnScrollOutListener(this.aWf);
        this.aWe.setItemOnLongClickListener(fVar);
        this.aWe.setHasNext(false);
        this.aWe.setNextTitle("mNextTitle");
        this.aWe.setIsFromCDN(true);
        this.aWe.setAllowLocalUrl(true);
        O(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nq() {
        if (this.aWa != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + this.mCount;
            }
            if (this.aWe.getHasNext() && this.mIndex == this.aWe.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(com.baidu.tieba.y.image_recommend));
                this.aWc.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.aWc.setClickable(true);
        }
    }

    private int Nr() {
        if (this.aWa != null && this.aWa.size() > 0) {
            int size = this.aWa.size();
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
            this.aWi = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.aWj = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.aWk = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.aWo = intent.getBooleanExtra("isSingle", false);
            if (this.aWk == null) {
                this.aWk = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.aWi == null) {
                this.aWi = "";
            }
            this.aWa = new LinkedHashMap<>();
            this.aWa.put(this.aWk, this.aWi);
            this.aWn = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.aWa = (LinkedHashMap) bundle.getSerializable(ImageViewerConfig.URL);
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.id = bundle.getString("id");
            this.aWk = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.aWn = bundle.getInt("chat_mode", 0);
            this.aWo = bundle.getBoolean("isSingle", false);
            if (this.aWk == null) {
                this.aWk = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.aWm = new HashMap<>();
    }

    private void Ns() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new g(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(ImageViewerConfig.URL, this.aWa);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.aWk);
        bundle.putInt("chat_mode", this.aWn);
        bundle.putBoolean("isSingle", this.aWo);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.aWe.setCurrentItem(this.mIndex, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(int i, int i2) {
        synchronized (this.aWm) {
            if (System.nanoTime() - this.aWl > 300000000 && this.aWa != null && i < this.aWa.size()) {
                this.aWm.put(this.aWa.get(Integer.valueOf(i)), true);
            }
            this.aWl = System.nanoTime();
        }
    }
}
