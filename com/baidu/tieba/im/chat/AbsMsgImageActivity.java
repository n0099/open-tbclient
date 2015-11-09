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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.im.c.ad;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public abstract class AbsMsgImageActivity extends BaseActivity<AbsMsgImageActivity> {
    private FrameLayout brf;
    private String brn;
    private boolean brs;
    private int wB;
    private LinkedHashMap<String, String> brd = null;
    private int mIndex = 0;
    private a bre = null;
    private View mBack = null;
    private TextView mTextView = null;
    private NavigationBar brg = null;
    private MultiImageView brh = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a bri = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation brj = null;
    private boolean brk = true;
    private boolean brl = false;
    private String brm = "";
    private String id = "";
    private String bro = "";
    private long brp = 0;
    private HashMap<String, Boolean> brq = null;
    private int brr = 0;

    protected abstract void a(String str, ad adVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m411getInst().addRemoteActivity(this);
        setContentView(i.g.image_activity_2);
        initData(bundle);
        initUI();
        RH();
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
        RH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.brh.setBackgroundColor(an.cu(i));
        } else {
            this.brh.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        an.j(this.brg, i.c.alpha80_black);
        getLayoutMode().k(this.mBack);
        getLayoutMode().k(this.mTextView);
        getLayoutMode().k(this.brf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.brh.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.brh.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.brh.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        af(this.mIndex, this.mIndex);
        this.brh.onDestroy();
        if (this.bre != null) {
            this.bre.cancel();
            this.bre = null;
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
        this.mOnClickListener = new com.baidu.tieba.im.chat.a(this);
        this.mOnPageChangeListener = new c(this);
        this.bri = new d(this);
        f fVar = new f(this, new e(this));
        this.brg = (NavigationBar) findViewById(i.f.navigation_bar);
        this.brf = (FrameLayout) this.brg.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.image_activity_save_button, this.mOnClickListener);
        if (this.brs) {
            this.brf.setVisibility(8);
        }
        this.mBack = this.brg.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.mTextView = this.brg.setTitleText("");
        this.brg.findViewById(i.f.navBottomLine).setVisibility(8);
        this.brh = (MultiImageView) findViewById(i.f.viewpager);
        this.brh.setPageMargin(com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), 8.0f));
        this.brh.G(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.brh.setOnPageChangeListener(this.mOnPageChangeListener);
        this.brh.setItemOnclickListener(this.mOnClickListener);
        this.brh.setCurrentItem(RG(), false);
        this.brh.setOnScrollOutListener(this.bri);
        this.brh.setItemOnLongClickListener(fVar);
        this.brh.setHasNext(false);
        this.brh.setNextTitle("mNextTitle");
        this.brh.setIsFromCDN(true);
        this.brh.setAllowLocalUrl(true);
        af(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RF() {
        if (this.brd != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.wB > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + this.wB;
            }
            if (this.brh.getHasNext() && this.mIndex == this.brh.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(i.h.image_recommend));
                this.brf.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.brf.setClickable(true);
        }
    }

    private int RG() {
        if (this.brd != null && this.brd.size() > 0) {
            int size = this.brd.size();
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
            this.brm = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.brn = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.bro = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.brs = intent.getBooleanExtra("isSingle", false);
            if (this.bro == null) {
                this.bro = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.brm == null) {
                this.brm = "";
            }
            this.brd = new LinkedHashMap<>();
            this.brd.put(this.bro, this.brm);
            this.brr = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.brd = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.id = bundle.getString("id");
            this.bro = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.brr = bundle.getInt("chat_mode", 0);
            this.brs = bundle.getBoolean("isSingle", false);
            if (this.bro == null) {
                this.bro = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.brq = new HashMap<>();
    }

    private void RH() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new g(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.brd);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.bro);
        bundle.putInt("chat_mode", this.brr);
        bundle.putBoolean("isSingle", this.brs);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.brh.setCurrentItem(this.mIndex, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        byte[] mData;
        String mUrl;

        public a(String str, byte[] bArr) {
            this.mUrl = null;
            this.mData = null;
            this.mUrl = str;
            this.mData = bArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            switch (com.baidu.tbadk.core.util.n.a(this.mUrl, this.mData, AbsMsgImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.n.tB();
                case -1:
                default:
                    return AbsMsgImageActivity.this.getPageContext().getString(i.h.save_error);
                case 0:
                    return AbsMsgImageActivity.this.getPageContext().getString(i.h.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            AbsMsgImageActivity.this.bre = null;
            AbsMsgImageActivity.this.brf.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.bre = null;
            AbsMsgImageActivity.this.brf.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r7v0 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void af(int i, int i2) {
        synchronized (this.brq) {
            if (System.nanoTime() - this.brp > 300000000 && this.brd != null && i < this.brd.size()) {
                this.brq.put(this.brd.get(new StringBuilder().append(i).toString()), true);
            }
            this.brp = System.nanoTime();
        }
    }
}
