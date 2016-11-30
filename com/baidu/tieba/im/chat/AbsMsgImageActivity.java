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
    private FrameLayout cZf;
    private String cZn;
    private boolean cZs;
    private int qh;
    private LinkedHashMap<String, String> cZd = null;
    private int mIndex = 0;
    private a cZe = null;
    private View ajQ = null;
    private TextView WJ = null;
    private NavigationBar cZg = null;
    private MultiImageView cZh = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a cZi = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation cZj = null;
    private boolean cZk = true;
    private boolean cZl = false;
    private String cZm = "";
    private String id = "";
    private String cZo = "";
    private long cZp = 0;
    private HashMap<String, Boolean> cZq = null;
    private int cZr = 0;

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
        arO();
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
        arO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.cZh.setBackgroundColor(com.baidu.tbadk.core.util.at.cM(i));
        } else {
            this.cZh.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        com.baidu.tbadk.core.util.at.l(this.cZg, r.d.common_color_10222);
        getLayoutMode().x(this.ajQ);
        getLayoutMode().x(this.WJ);
        getLayoutMode().x(this.cZf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.cZh.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cZh.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.cZh.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        aQ(this.mIndex, this.mIndex);
        this.cZh.onDestroy();
        if (this.cZe != null) {
            this.cZe.cancel();
            this.cZe = null;
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
        this.cZi = new d(this);
        f fVar = new f(this, new e(this));
        this.cZg = (NavigationBar) findViewById(r.g.navigation_bar);
        this.cZf = (FrameLayout) this.cZg.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.image_activity_save_button, this.mOnClickListener);
        if (this.cZs) {
            this.cZf.setVisibility(8);
        }
        this.ajQ = this.cZg.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.WJ = this.cZg.setTitleText("");
        this.cZh = (MultiImageView) findViewById(r.g.viewpager);
        this.cZh.setPageMargin(com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), 8.0f));
        this.cZh.C(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.cZh.setOnPageChangeListener(this.mOnPageChangeListener);
        this.cZh.setItemOnclickListener(this.mOnClickListener);
        this.cZh.setCurrentItem(arN(), false);
        this.cZh.setOnScrollOutListener(this.cZi);
        this.cZh.setItemOnLongClickListener(fVar);
        this.cZh.setHasNext(false);
        this.cZh.setNextTitle("mNextTitle");
        this.cZh.setIsFromCDN(true);
        this.cZh.setAllowLocalUrl(true);
        aQ(this.mIndex, this.mIndex);
        this.WJ.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arM() {
        if (this.cZd != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.qh > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + this.qh;
            }
            if (this.cZh.getHasNext() && this.mIndex == this.cZh.getItemNum() - 1) {
                this.WJ.setText(getPageContext().getString(r.j.image_recommend));
                this.cZf.setClickable(false);
                return;
            }
            this.WJ.setText(valueOf);
            this.cZf.setClickable(true);
        }
    }

    private int arN() {
        if (this.cZd != null && this.cZd.size() > 0) {
            int size = this.cZd.size();
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
            this.cZm = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.cZn = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.cZo = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.cZs = intent.getBooleanExtra("isSingle", false);
            if (this.cZo == null) {
                this.cZo = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.cZm == null) {
                this.cZm = "";
            }
            this.cZd = new LinkedHashMap<>();
            this.cZd.put(this.cZo, this.cZm);
            this.cZr = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.cZd = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.id = bundle.getString("id");
            this.cZo = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.cZr = bundle.getInt("chat_mode", 0);
            this.cZs = bundle.getBoolean("isSingle", false);
            if (this.cZo == null) {
                this.cZo = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.cZq = new HashMap<>();
    }

    private void arO() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new g(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.cZd);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.cZo);
        bundle.putInt("chat_mode", this.cZr);
        bundle.putBoolean("isSingle", this.cZs);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.cZh.setCurrentItem(this.mIndex, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        byte[] ks;
        String mUrl;

        public a(String str, byte[] bArr) {
            this.mUrl = null;
            this.ks = null;
            this.mUrl = str;
            this.ks = bArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            switch (com.baidu.tbadk.core.util.m.a(this.mUrl, this.ks, AbsMsgImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.m.ut();
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
        /* renamed from: ez */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            AbsMsgImageActivity.this.cZe = null;
            AbsMsgImageActivity.this.cZf.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.cZe = null;
            AbsMsgImageActivity.this.cZf.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r7v0 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void aQ(int i, int i2) {
        synchronized (this.cZq) {
            if (System.nanoTime() - this.cZp > 300000000 && this.cZd != null && i < this.cZd.size()) {
                this.cZq.put(this.cZd.get(new StringBuilder().append(i).toString()), true);
            }
            this.cZp = System.nanoTime();
        }
    }
}
