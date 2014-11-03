package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public abstract class AbsMsgImageActivity extends BaseActivity {
    private TextView aNE;
    private boolean aNN;
    private int mq;
    private LinkedHashMap<String, String> aNC = null;
    private int mIndex = 0;
    private g aND = null;
    private MultiImageView aNF = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener NY = null;
    private DialogInterface.OnClickListener aNG = null;
    private com.baidu.tbadk.core.view.a aNH = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private String aNI = "";
    private String id = "";
    private String aNJ = "";
    private long aNK = 0;
    private HashMap<String, Boolean> aNL = null;
    private int aNM = 0;

    protected abstract void a(String str, bs bsVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkApplication.m251getInst().addRemoteActivity(this);
        setContentView(com.baidu.tieba.w.image_activity_2);
        d(bundle);
        initUI();
        Jr();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        Jr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.aNF.setBackgroundColor(com.baidu.tbadk.core.util.aw.by(i));
        } else {
            this.aNF.setBackgroundColor(-16777216);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aNF.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aNF.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.aNF.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        M(this.mIndex, this.mIndex);
        this.aNF.onDestroy();
        if (this.aND != null) {
            this.aND.cancel();
            this.aND = null;
        }
        hideProgressBar();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkApplication.m251getInst().delRemoteActivity(this);
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
        this.NY = new b(this);
        this.aNG = new c(this);
        this.mOnPageChangeListener = new d(this);
        this.aNH = new e(this);
        this.aNE = (TextView) findViewById(com.baidu.tieba.v.page_num);
        this.aNF = (MultiImageView) findViewById(com.baidu.tieba.v.viewpager);
        this.aNF.setPageMargin(com.baidu.adp.lib.util.m.dip2px(this, 8.0f));
        this.aNF.u(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.aNF.setOnPageChangeListener(this.mOnPageChangeListener);
        this.aNF.setItemOnclickListener(this.mOnClickListener);
        this.aNF.setItemOnLongClickListener(this.NY);
        this.aNF.setCurrentItem(Jq(), false);
        this.aNF.setOnScrollOutListener(this.aNH);
        this.aNF.setHasNext(false);
        this.aNF.setNextTitle("mNextTitle");
        this.aNF.setIsFromCDN(true);
        this.aNF.setAllowLocalUrl(true);
        M(this.mIndex, this.mIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jp() {
        if (this.aNC != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mq > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + this.mq;
            }
            this.aNE.setText(valueOf);
        }
    }

    private int Jq() {
        if (this.aNC != null && this.aNC.size() > 0) {
            int size = this.aNC.size();
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

    private void d(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.aNI = intent.getStringExtra("current_url");
            this.id = intent.getStringExtra("id");
            this.aNJ = intent.getStringExtra("uniqueid");
            this.aNN = intent.getBooleanExtra("isSingle", false);
            if (this.aNJ == null) {
                this.aNJ = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.aNI == null) {
                this.aNI = "";
            }
            this.aNC = new LinkedHashMap<>();
            this.aNC.put(this.aNJ, this.aNI);
            this.aNM = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.aNC = (LinkedHashMap) bundle.getSerializable(ImageViewerConfig.URL);
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.id = bundle.getString("id");
            this.aNJ = bundle.getString("uniqueid");
            this.aNM = bundle.getInt("chat_mode", 0);
            this.aNN = bundle.getBoolean("isSingle", false);
            if (this.aNJ == null) {
                this.aNJ = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.aNL = new HashMap<>();
    }

    private void Jr() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new f(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(ImageViewerConfig.URL, this.aNC);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString("uniqueid", this.aNJ);
        bundle.putInt("chat_mode", this.aNM);
        bundle.putBoolean("isSingle", this.aNN);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.aNF.setCurrentItem(this.mIndex, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(int i, int i2) {
        synchronized (this.aNL) {
            if (System.nanoTime() - this.aNK > 300000000 && this.aNC != null && i < this.aNC.size()) {
                this.aNL.put(this.aNC.get(Integer.valueOf(i)), true);
            }
            this.aNK = System.nanoTime();
        }
    }
}
