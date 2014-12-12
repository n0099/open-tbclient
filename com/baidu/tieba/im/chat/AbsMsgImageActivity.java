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
    private FrameLayout aPS;
    private boolean aQd;
    private int mCount;
    private LinkedHashMap<String, String> aPQ = null;
    private int mIndex = 0;
    private h aPR = null;
    private View mBack = null;
    private TextView mTextView = null;
    private NavigationBar aPT = null;
    private MultiImageView aPU = null;
    private View.OnClickListener mOnClickListener = null;
    private com.baidu.tbadk.core.view.a aPV = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation akw = null;
    private boolean aPW = true;
    private boolean aPX = false;
    private String aPY = "";
    private String id = "";
    private String aPZ = "";
    private long aQa = 0;
    private HashMap<String, Boolean> aQb = null;
    private int aQc = 0;

    protected abstract void a(String str, ad adVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkCoreApplication.m255getInst().addRemoteActivity(this);
        setContentView(com.baidu.tieba.x.image_activity_2);
        initData(bundle);
        initUI();
        JM();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        JM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.aPU.setBackgroundColor(com.baidu.tbadk.core.util.ax.bV(i));
        } else {
            this.aPU.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        com.baidu.tbadk.core.util.ax.j(this.aPT, com.baidu.tieba.t.alpha80_black);
        getLayoutMode().h(this.mBack);
        getLayoutMode().h(this.mTextView);
        getLayoutMode().h(this.aPS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aPU.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aPU.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.aPU.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        N(this.mIndex, this.mIndex);
        this.aPU.onDestroy();
        if (this.aPR != null) {
            this.aPR.cancel();
            this.aPR = null;
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
        this.aPV = new d(this);
        f fVar = new f(this, new e(this));
        this.aPT = (NavigationBar) findViewById(com.baidu.tieba.w.navigation_bar);
        this.aPS = (FrameLayout) this.aPT.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.image_activity_save_button, this.mOnClickListener);
        if (this.aQd) {
            this.aPS.setVisibility(8);
        }
        this.mBack = this.aPT.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.mTextView = this.aPT.setTitleText("");
        this.aPT.findViewById(com.baidu.tieba.w.navBottomLine).setVisibility(8);
        this.aPU = (MultiImageView) findViewById(com.baidu.tieba.w.viewpager);
        this.aPU.setPageMargin(com.baidu.adp.lib.util.l.dip2px(getPageContext().getContext(), 8.0f));
        this.aPU.x(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.aPU.setOnPageChangeListener(this.mOnPageChangeListener);
        this.aPU.setItemOnclickListener(this.mOnClickListener);
        this.aPU.setCurrentItem(JL(), false);
        this.aPU.setOnScrollOutListener(this.aPV);
        this.aPU.setItemOnLongClickListener(fVar);
        this.aPU.setHasNext(false);
        this.aPU.setNextTitle("mNextTitle");
        this.aPU.setIsFromCDN(true);
        this.aPU.setAllowLocalUrl(true);
        N(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JK() {
        if (this.aPQ != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + this.mCount;
            }
            if (this.aPU.getHasNext() && this.mIndex == this.aPU.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(com.baidu.tieba.z.image_recommend));
                this.aPS.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.aPS.setClickable(true);
        }
    }

    private int JL() {
        if (this.aPQ != null && this.aPQ.size() > 0) {
            int size = this.aPQ.size();
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
            this.aPY = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.id = intent.getStringExtra("id");
            this.aPZ = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.aQd = intent.getBooleanExtra("isSingle", false);
            if (this.aPZ == null) {
                this.aPZ = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.aPY == null) {
                this.aPY = "";
            }
            this.aPQ = new LinkedHashMap<>();
            this.aPQ.put(this.aPZ, this.aPY);
            this.aQc = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.aPQ = (LinkedHashMap) bundle.getSerializable(ImageViewerConfig.URL);
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.id = bundle.getString("id");
            this.aPZ = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.aQc = bundle.getInt("chat_mode", 0);
            this.aQd = bundle.getBoolean("isSingle", false);
            if (this.aPZ == null) {
                this.aPZ = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.aQb = new HashMap<>();
    }

    private void JM() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new g(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(ImageViewerConfig.URL, this.aPQ);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.aPZ);
        bundle.putInt("chat_mode", this.aQc);
        bundle.putBoolean("isSingle", this.aQd);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.aPU.setCurrentItem(this.mIndex, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(int i, int i2) {
        synchronized (this.aQb) {
            if (System.nanoTime() - this.aQa > 300000000 && this.aPQ != null && i < this.aPQ.size()) {
                this.aQb.put(this.aPQ.get(Integer.valueOf(i)), true);
            }
            this.aQa = System.nanoTime();
        }
    }
}
