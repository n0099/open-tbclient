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
import com.baidu.tieba.r;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public abstract class AbsMsgImageActivity extends BaseActivity<AbsMsgImageActivity> {
    private String cTF;
    private boolean cTK;
    private FrameLayout cTx;
    private int qg;
    private LinkedHashMap<String, String> cTv = null;
    private int mIndex = 0;
    private a cTw = null;
    private View aiY = null;
    private TextView Wl = null;
    private NavigationBar cTy = null;
    private MultiImageView cTz = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a cTA = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation cTB = null;
    private boolean cTC = true;
    private boolean cTD = false;
    private String cTE = "";
    private String id = "";
    private String cTG = "";
    private long cTH = 0;
    private HashMap<String, Boolean> cTI = null;
    private int cTJ = 0;

    protected abstract void a(String str, ad adVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m9getInst().addRemoteActivity(this);
        setContentView(r.h.image_activity_2);
        initData(bundle);
        initUI();
        apR();
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
        apR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.cTz.setBackgroundColor(com.baidu.tbadk.core.util.av.cL(i));
        } else {
            this.cTz.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        com.baidu.tbadk.core.util.av.l(this.cTy, r.d.common_color_10222);
        getLayoutMode().x(this.aiY);
        getLayoutMode().x(this.Wl);
        getLayoutMode().x(this.cTx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.cTz.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cTz.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.cTz.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        aP(this.mIndex, this.mIndex);
        this.cTz.onDestroy();
        if (this.cTw != null) {
            this.cTw.cancel();
            this.cTw = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.m9getInst().delRemoteActivity(this);
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
        this.cTA = new d(this);
        f fVar = new f(this, new e(this));
        this.cTy = (NavigationBar) findViewById(r.g.navigation_bar);
        this.cTx = (FrameLayout) this.cTy.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.image_activity_save_button, this.mOnClickListener);
        if (this.cTK) {
            this.cTx.setVisibility(8);
        }
        this.aiY = this.cTy.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.Wl = this.cTy.setTitleText("");
        this.cTz = (MultiImageView) findViewById(r.g.viewpager);
        this.cTz.setPageMargin(com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), 8.0f));
        this.cTz.C(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.cTz.setOnPageChangeListener(this.mOnPageChangeListener);
        this.cTz.setItemOnclickListener(this.mOnClickListener);
        this.cTz.setCurrentItem(apQ(), false);
        this.cTz.setOnScrollOutListener(this.cTA);
        this.cTz.setItemOnLongClickListener(fVar);
        this.cTz.setHasNext(false);
        this.cTz.setNextTitle("mNextTitle");
        this.cTz.setIsFromCDN(true);
        this.cTz.setAllowLocalUrl(true);
        aP(this.mIndex, this.mIndex);
        this.Wl.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apP() {
        if (this.cTv != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.qg > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + this.qg;
            }
            if (this.cTz.getHasNext() && this.mIndex == this.cTz.getItemNum() - 1) {
                this.Wl.setText(getPageContext().getString(r.j.image_recommend));
                this.cTx.setClickable(false);
                return;
            }
            this.Wl.setText(valueOf);
            this.cTx.setClickable(true);
        }
    }

    private int apQ() {
        if (this.cTv != null && this.cTv.size() > 0) {
            int size = this.cTv.size();
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
            this.cTE = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.cTF = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.cTG = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.cTK = intent.getBooleanExtra("isSingle", false);
            if (this.cTG == null) {
                this.cTG = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.cTE == null) {
                this.cTE = "";
            }
            this.cTv = new LinkedHashMap<>();
            this.cTv.put(this.cTG, this.cTE);
            this.cTJ = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.cTv = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.id = bundle.getString("id");
            this.cTG = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.cTJ = bundle.getInt("chat_mode", 0);
            this.cTK = bundle.getBoolean("isSingle", false);
            if (this.cTG == null) {
                this.cTG = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.cTI = new HashMap<>();
    }

    private void apR() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new g(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.cTv);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.cTG);
        bundle.putInt("chat_mode", this.cTJ);
        bundle.putBoolean("isSingle", this.cTK);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.cTz.setCurrentItem(this.mIndex, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        byte[] kr;
        String mUrl;

        public a(String str, byte[] bArr) {
            this.mUrl = null;
            this.kr = null;
            this.mUrl = str;
            this.kr = bArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            switch (com.baidu.tbadk.core.util.m.a(this.mUrl, this.kr, AbsMsgImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.m.up();
                case -1:
                default:
                    return AbsMsgImageActivity.this.getPageContext().getString(r.j.save_error);
                case 0:
                    return AbsMsgImageActivity.this.getPageContext().getString(r.j.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: ex */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            AbsMsgImageActivity.this.cTw = null;
            AbsMsgImageActivity.this.cTx.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.cTw = null;
            AbsMsgImageActivity.this.cTx.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r7v0 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void aP(int i, int i2) {
        synchronized (this.cTI) {
            if (System.nanoTime() - this.cTH > 300000000 && this.cTv != null && i < this.cTv.size()) {
                this.cTI.put(this.cTv.get(new StringBuilder().append(i).toString()), true);
            }
            this.cTH = System.nanoTime();
        }
    }
}
