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
    private FrameLayout cSd;
    private String cSl;
    private boolean cSq;
    private int qg;
    private LinkedHashMap<String, String> cSb = null;
    private int mIndex = 0;
    private a cSc = null;
    private View ajw = null;
    private TextView Wb = null;
    private NavigationBar cSe = null;
    private MultiImageView cSf = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a cSg = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation cSh = null;
    private boolean cSi = true;
    private boolean cSj = false;
    private String cSk = "";
    private String id = "";
    private String cSm = "";
    private long cSn = 0;
    private HashMap<String, Boolean> cSo = null;
    private int cSp = 0;

    protected abstract void a(String str, ad adVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m9getInst().addRemoteActivity(this);
        setContentView(t.h.image_activity_2);
        initData(bundle);
        initUI();
        aps();
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
        aps();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.cSf.setBackgroundColor(com.baidu.tbadk.core.util.av.cL(i));
        } else {
            this.cSf.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        com.baidu.tbadk.core.util.av.l(this.cSe, t.d.common_color_10222);
        getLayoutMode().x(this.ajw);
        getLayoutMode().x(this.Wb);
        getLayoutMode().x(this.cSd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.cSf.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cSf.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.cSf.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        aN(this.mIndex, this.mIndex);
        this.cSf.onDestroy();
        if (this.cSc != null) {
            this.cSc.cancel();
            this.cSc = null;
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
        this.cSg = new d(this);
        f fVar = new f(this, new e(this));
        this.cSe = (NavigationBar) findViewById(t.g.navigation_bar);
        this.cSd = (FrameLayout) this.cSe.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.image_activity_save_button, this.mOnClickListener);
        if (this.cSq) {
            this.cSd.setVisibility(8);
        }
        this.ajw = this.cSe.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.Wb = this.cSe.setTitleText("");
        this.cSf = (MultiImageView) findViewById(t.g.viewpager);
        this.cSf.setPageMargin(com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), 8.0f));
        this.cSf.C(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.cSf.setOnPageChangeListener(this.mOnPageChangeListener);
        this.cSf.setItemOnclickListener(this.mOnClickListener);
        this.cSf.setCurrentItem(apr(), false);
        this.cSf.setOnScrollOutListener(this.cSg);
        this.cSf.setItemOnLongClickListener(fVar);
        this.cSf.setHasNext(false);
        this.cSf.setNextTitle("mNextTitle");
        this.cSf.setIsFromCDN(true);
        this.cSf.setAllowLocalUrl(true);
        aN(this.mIndex, this.mIndex);
        this.Wb.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apq() {
        if (this.cSb != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.qg > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + this.qg;
            }
            if (this.cSf.getHasNext() && this.mIndex == this.cSf.getItemNum() - 1) {
                this.Wb.setText(getPageContext().getString(t.j.image_recommend));
                this.cSd.setClickable(false);
                return;
            }
            this.Wb.setText(valueOf);
            this.cSd.setClickable(true);
        }
    }

    private int apr() {
        if (this.cSb != null && this.cSb.size() > 0) {
            int size = this.cSb.size();
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
            this.cSk = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.cSl = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.cSm = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.cSq = intent.getBooleanExtra("isSingle", false);
            if (this.cSm == null) {
                this.cSm = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.cSk == null) {
                this.cSk = "";
            }
            this.cSb = new LinkedHashMap<>();
            this.cSb.put(this.cSm, this.cSk);
            this.cSp = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.cSb = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.id = bundle.getString("id");
            this.cSm = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.cSp = bundle.getInt("chat_mode", 0);
            this.cSq = bundle.getBoolean("isSingle", false);
            if (this.cSm == null) {
                this.cSm = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.cSo = new HashMap<>();
    }

    private void aps() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new g(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.cSb);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.cSm);
        bundle.putInt("chat_mode", this.cSp);
        bundle.putBoolean("isSingle", this.cSq);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.cSf.setCurrentItem(this.mIndex, true);
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
                    return com.baidu.tbadk.core.util.m.tZ();
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
        /* renamed from: eu */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            AbsMsgImageActivity.this.cSc = null;
            AbsMsgImageActivity.this.cSd.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.cSc = null;
            AbsMsgImageActivity.this.cSd.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r7v0 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void aN(int i, int i2) {
        synchronized (this.cSo) {
            if (System.nanoTime() - this.cSn > 300000000 && this.cSb != null && i < this.cSb.size()) {
                this.cSo.put(this.cSb.get(new StringBuilder().append(i).toString()), true);
            }
            this.cSn = System.nanoTime();
        }
    }
}
