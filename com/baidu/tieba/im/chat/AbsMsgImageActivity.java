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
import com.baidu.tieba.im.sendmessage.ad;
import com.baidu.tieba.w;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public abstract class AbsMsgImageActivity extends BaseActivity<AbsMsgImageActivity> {
    private FrameLayout cOd;
    private String cOl;
    private boolean cOq;
    private int mCount;
    private LinkedHashMap<String, String> cOb = null;
    private int mIndex = 0;
    private a cOc = null;
    private View aob = null;
    private TextView mTextView = null;
    private NavigationBar cOe = null;
    private MultiImageView cOf = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a cOg = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation cOh = null;
    private boolean cOi = true;
    private boolean cOj = false;
    private String cOk = "";
    private String id = "";
    private String cOm = "";
    private long cOn = 0;
    private HashMap<String, Boolean> cOo = null;
    private int cOp = 0;

    protected abstract void a(String str, ad adVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m9getInst().addRemoteActivity(this);
        setContentView(w.j.image_activity_2);
        initData(bundle);
        initUI();
        alH();
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
        alH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.cOf.setBackgroundColor(com.baidu.tbadk.core.util.aq.cK(i));
        } else {
            this.cOf.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        com.baidu.tbadk.core.util.aq.k(this.cOe, w.e.common_color_10222);
        getLayoutMode().t(this.aob);
        getLayoutMode().t(this.mTextView);
        getLayoutMode().t(this.cOd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.cOf.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cOf.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.cOf.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        aI(this.mIndex, this.mIndex);
        this.cOf.onDestroy();
        if (this.cOc != null) {
            this.cOc.cancel();
            this.cOc = null;
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
        this.cOg = new d(this);
        f fVar = new f(this, new e(this));
        this.cOe = (NavigationBar) findViewById(w.h.navigation_bar);
        this.cOd = (FrameLayout) this.cOe.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.image_activity_save_button, this.mOnClickListener);
        if (this.cOq) {
            this.cOd.setVisibility(8);
        }
        this.aob = this.cOe.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.mTextView = this.cOe.setTitleText("");
        this.cOf = (MultiImageView) findViewById(w.h.viewpager);
        this.cOf.setPageMargin(com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), 8.0f));
        this.cOf.I(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.cOf.setOnPageChangeListener(this.mOnPageChangeListener);
        this.cOf.setItemOnclickListener(this.mOnClickListener);
        this.cOf.setCurrentItem(alG(), false);
        this.cOf.setOnScrollOutListener(this.cOg);
        this.cOf.setItemOnLongClickListener(fVar);
        this.cOf.setHasNext(false);
        this.cOf.setNextTitle("mNextTitle");
        this.cOf.setIsFromCDN(true);
        this.cOf.setAllowLocalUrl(true);
        aI(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alF() {
        if (this.cOb != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + this.mCount;
            }
            if (this.cOf.getHasNext() && this.mIndex == this.cOf.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(w.l.image_recommend));
                this.cOd.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.cOd.setClickable(true);
        }
    }

    private int alG() {
        if (this.cOb != null && this.cOb.size() > 0) {
            int size = this.cOb.size();
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
            this.cOk = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.cOl = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.cOm = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.cOq = intent.getBooleanExtra("isSingle", false);
            if (this.cOm == null) {
                this.cOm = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.cOk == null) {
                this.cOk = "";
            }
            this.cOb = new LinkedHashMap<>();
            this.cOb.put(this.cOm, this.cOk);
            this.cOp = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.cOb = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.id = bundle.getString("id");
            this.cOm = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.cOp = bundle.getInt("chat_mode", 0);
            this.cOq = bundle.getBoolean("isSingle", false);
            if (this.cOm == null) {
                this.cOm = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.cOo = new HashMap<>();
    }

    private void alH() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new g(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.cOb);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.cOm);
        bundle.putInt("chat_mode", this.cOp);
        bundle.putBoolean("isSingle", this.cOq);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.cOf.setCurrentItem(this.mIndex, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        String mUrl;
        byte[] rL;

        public a(String str, byte[] bArr) {
            this.mUrl = null;
            this.rL = null;
            this.mUrl = str;
            this.rL = bArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            switch (com.baidu.tbadk.core.util.l.a(this.mUrl, this.rL, AbsMsgImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.l.ua();
                case -1:
                default:
                    return AbsMsgImageActivity.this.getPageContext().getString(w.l.save_error);
                case 0:
                    return AbsMsgImageActivity.this.getPageContext().getString(w.l.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            AbsMsgImageActivity.this.cOc = null;
            AbsMsgImageActivity.this.cOd.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.cOc = null;
            AbsMsgImageActivity.this.cOd.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r7v0 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void aI(int i, int i2) {
        synchronized (this.cOo) {
            if (System.nanoTime() - this.cOn > 300000000 && this.cOb != null && i < this.cOb.size()) {
                this.cOo.put(this.cOb.get(new StringBuilder().append(i).toString()), true);
            }
            this.cOn = System.nanoTime();
        }
    }
}
