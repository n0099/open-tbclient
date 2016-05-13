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
    private String bYG;
    private boolean bYL;
    private FrameLayout bYy;
    private int ni;
    private LinkedHashMap<String, String> bYw = null;
    private int mIndex = 0;
    private a bYx = null;
    private View afm = null;
    private TextView Sm = null;
    private NavigationBar bYz = null;
    private MultiImageView bYA = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a bYB = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation bYC = null;
    private boolean bYD = true;
    private boolean bYE = false;
    private String bYF = "";
    private String id = "";
    private String bYH = "";
    private long bYI = 0;
    private HashMap<String, Boolean> bYJ = null;
    private int bYK = 0;

    protected abstract void a(String str, ad adVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m11getInst().addRemoteActivity(this);
        setContentView(t.h.image_activity_2);
        initData(bundle);
        nq();
        abH();
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
        abH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.bYA.setBackgroundColor(com.baidu.tbadk.core.util.at.cx(i));
        } else {
            this.bYA.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        com.baidu.tbadk.core.util.at.l(this.bYz, t.d.alpha80_black);
        getLayoutMode().x(this.afm);
        getLayoutMode().x(this.Sm);
        getLayoutMode().x(this.bYy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bYA.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bYA.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.bYA.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        ap(this.mIndex, this.mIndex);
        this.bYA.onDestroy();
        if (this.bYx != null) {
            this.bYx.cancel();
            this.bYx = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.m11getInst().delRemoteActivity(this);
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

    private void nq() {
        this.mOnClickListener = new com.baidu.tieba.im.chat.a(this);
        this.mOnPageChangeListener = new c(this);
        this.bYB = new d(this);
        f fVar = new f(this, new e(this));
        this.bYz = (NavigationBar) findViewById(t.g.navigation_bar);
        this.bYy = (FrameLayout) this.bYz.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.image_activity_save_button, this.mOnClickListener);
        if (this.bYL) {
            this.bYy.setVisibility(8);
        }
        this.afm = this.bYz.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.Sm = this.bYz.setTitleText("");
        this.bYA = (MultiImageView) findViewById(t.g.viewpager);
        this.bYA.setPageMargin(com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), 8.0f));
        this.bYA.A(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.bYA.setOnPageChangeListener(this.mOnPageChangeListener);
        this.bYA.setItemOnclickListener(this.mOnClickListener);
        this.bYA.setCurrentItem(abG(), false);
        this.bYA.setOnScrollOutListener(this.bYB);
        this.bYA.setItemOnLongClickListener(fVar);
        this.bYA.setHasNext(false);
        this.bYA.setNextTitle("mNextTitle");
        this.bYA.setIsFromCDN(true);
        this.bYA.setAllowLocalUrl(true);
        ap(this.mIndex, this.mIndex);
        this.Sm.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abF() {
        if (this.bYw != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.ni > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + this.ni;
            }
            if (this.bYA.getHasNext() && this.mIndex == this.bYA.getItemNum() - 1) {
                this.Sm.setText(getPageContext().getString(t.j.image_recommend));
                this.bYy.setClickable(false);
                return;
            }
            this.Sm.setText(valueOf);
            this.bYy.setClickable(true);
        }
    }

    private int abG() {
        if (this.bYw != null && this.bYw.size() > 0) {
            int size = this.bYw.size();
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
            this.bYF = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.bYG = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.bYH = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.bYL = intent.getBooleanExtra("isSingle", false);
            if (this.bYH == null) {
                this.bYH = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.bYF == null) {
                this.bYF = "";
            }
            this.bYw = new LinkedHashMap<>();
            this.bYw.put(this.bYH, this.bYF);
            this.bYK = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.bYw = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.id = bundle.getString("id");
            this.bYH = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.bYK = bundle.getInt("chat_mode", 0);
            this.bYL = bundle.getBoolean("isSingle", false);
            if (this.bYH == null) {
                this.bYH = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.bYJ = new HashMap<>();
    }

    private void abH() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new g(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.bYw);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.bYH);
        bundle.putInt("chat_mode", this.bYK);
        bundle.putBoolean("isSingle", this.bYL);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.bYA.setCurrentItem(this.mIndex, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        byte[] hx;
        String mUrl;

        public a(String str, byte[] bArr) {
            this.mUrl = null;
            this.hx = null;
            this.mUrl = str;
            this.hx = bArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            switch (com.baidu.tbadk.core.util.m.a(this.mUrl, this.hx, AbsMsgImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.m.sY();
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
        /* renamed from: eo */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            AbsMsgImageActivity.this.bYx = null;
            AbsMsgImageActivity.this.bYy.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.bYx = null;
            AbsMsgImageActivity.this.bYy.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r7v0 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void ap(int i, int i2) {
        synchronized (this.bYJ) {
            if (System.nanoTime() - this.bYI > 300000000 && this.bYw != null && i < this.bYw.size()) {
                this.bYJ.put(this.bYw.get(new StringBuilder().append(i).toString()), true);
            }
            this.bYI = System.nanoTime();
        }
    }
}
