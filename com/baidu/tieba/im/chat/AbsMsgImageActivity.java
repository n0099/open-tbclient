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
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.im.c.ad;
import com.baidu.tieba.u;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public abstract class AbsMsgImageActivity extends BaseActivity<AbsMsgImageActivity> {
    private FrameLayout cDI;
    private String cDQ;
    private boolean cDV;
    private int ni;
    private LinkedHashMap<String, String> cDG = null;
    private int mIndex = 0;
    private a cDH = null;
    private View afN = null;
    private TextView SD = null;
    private NavigationBar cDJ = null;
    private MultiImageView cDK = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a cDL = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation cDM = null;
    private boolean cDN = true;
    private boolean cDO = false;
    private String cDP = "";
    private String id = "";
    private String cDR = "";
    private long cDS = 0;
    private HashMap<String, Boolean> cDT = null;
    private int cDU = 0;

    protected abstract void a(String str, ad adVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m9getInst().addRemoteActivity(this);
        setContentView(u.h.image_activity_2);
        initData(bundle);
        nl();
        ajT();
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
        ajT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.cDK.setBackgroundColor(com.baidu.tbadk.core.util.av.cy(i));
        } else {
            this.cDK.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        com.baidu.tbadk.core.util.av.l(this.cDJ, u.d.common_color_10222);
        getLayoutMode().w(this.afN);
        getLayoutMode().w(this.SD);
        getLayoutMode().w(this.cDI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.cDK.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cDK.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.cDK.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        aG(this.mIndex, this.mIndex);
        this.cDK.onDestroy();
        if (this.cDH != null) {
            this.cDH.cancel();
            this.cDH = null;
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
            intent.putExtra("index", this.mIndex);
            setResult(-1, intent);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void nl() {
        this.mOnClickListener = new com.baidu.tieba.im.chat.a(this);
        this.mOnPageChangeListener = new c(this);
        this.cDL = new d(this);
        f fVar = new f(this, new e(this));
        this.cDJ = (NavigationBar) findViewById(u.g.navigation_bar);
        this.cDI = (FrameLayout) this.cDJ.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.image_activity_save_button, this.mOnClickListener);
        if (this.cDV) {
            this.cDI.setVisibility(8);
        }
        this.afN = this.cDJ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.SD = this.cDJ.setTitleText("");
        this.cDK = (MultiImageView) findViewById(u.g.viewpager);
        this.cDK.setPageMargin(com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), 8.0f));
        this.cDK.A(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.cDK.setOnPageChangeListener(this.mOnPageChangeListener);
        this.cDK.setItemOnclickListener(this.mOnClickListener);
        this.cDK.setCurrentItem(ajS(), false);
        this.cDK.setOnScrollOutListener(this.cDL);
        this.cDK.setItemOnLongClickListener(fVar);
        this.cDK.setHasNext(false);
        this.cDK.setNextTitle("mNextTitle");
        this.cDK.setIsFromCDN(true);
        this.cDK.setAllowLocalUrl(true);
        aG(this.mIndex, this.mIndex);
        this.SD.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajR() {
        if (this.cDG != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.ni > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + this.ni;
            }
            if (this.cDK.getHasNext() && this.mIndex == this.cDK.getItemNum() - 1) {
                this.SD.setText(getPageContext().getString(u.j.image_recommend));
                this.cDI.setClickable(false);
                return;
            }
            this.SD.setText(valueOf);
            this.cDI.setClickable(true);
        }
    }

    private int ajS() {
        if (this.cDG != null && this.cDG.size() > 0) {
            int size = this.cDG.size();
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
            this.cDP = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.cDQ = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.cDR = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.cDV = intent.getBooleanExtra("isSingle", false);
            if (this.cDR == null) {
                this.cDR = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.cDP == null) {
                this.cDP = "";
            }
            this.cDG = new LinkedHashMap<>();
            this.cDG.put(this.cDR, this.cDP);
            this.cDU = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.cDG = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.cDR = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.cDU = bundle.getInt("chat_mode", 0);
            this.cDV = bundle.getBoolean("isSingle", false);
            if (this.cDR == null) {
                this.cDR = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.cDT = new HashMap<>();
    }

    private void ajT() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new g(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.cDG);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.cDR);
        bundle.putInt("chat_mode", this.cDU);
        bundle.putBoolean("isSingle", this.cDV);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.cDK.setCurrentItem(this.mIndex, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        byte[] hw;
        String mUrl;

        public a(String str, byte[] bArr) {
            this.mUrl = null;
            this.hw = null;
            this.mUrl = str;
            this.hw = bArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            switch (com.baidu.tbadk.core.util.m.a(this.mUrl, this.hw, AbsMsgImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.m.sV();
                case -1:
                default:
                    return AbsMsgImageActivity.this.getPageContext().getString(u.j.save_error);
                case 0:
                    return AbsMsgImageActivity.this.getPageContext().getString(u.j.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: es */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            AbsMsgImageActivity.this.cDH = null;
            AbsMsgImageActivity.this.cDI.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.cDH = null;
            AbsMsgImageActivity.this.cDI.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r7v0 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void aG(int i, int i2) {
        synchronized (this.cDT) {
            if (System.nanoTime() - this.cDS > 300000000 && this.cDG != null && i < this.cDG.size()) {
                this.cDT.put(this.cDG.get(new StringBuilder().append(i).toString()), true);
            }
            this.cDS = System.nanoTime();
        }
    }
}
