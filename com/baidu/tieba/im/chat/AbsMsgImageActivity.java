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
    private TextView aNq;
    private boolean aNz;
    private int mq;
    private LinkedHashMap<String, String> aNo = null;
    private int mIndex = 0;
    private g aNp = null;
    private MultiImageView aNr = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener NU = null;
    private DialogInterface.OnClickListener aNs = null;
    private com.baidu.tbadk.core.view.a aNt = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private String aNu = "";
    private String id = "";
    private String aNv = "";
    private long aNw = 0;
    private HashMap<String, Boolean> aNx = null;
    private int aNy = 0;

    protected abstract void a(String str, bs bsVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkApplication.m251getInst().addRemoteActivity(this);
        setContentView(com.baidu.tieba.w.image_activity_2);
        d(bundle);
        initUI();
        Jn();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        Jn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.aNr.setBackgroundColor(com.baidu.tbadk.core.util.aw.by(i));
        } else {
            this.aNr.setBackgroundColor(-16777216);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aNr.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aNr.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.aNr.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        M(this.mIndex, this.mIndex);
        this.aNr.onDestroy();
        if (this.aNp != null) {
            this.aNp.cancel();
            this.aNp = null;
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
        this.NU = new b(this);
        this.aNs = new c(this);
        this.mOnPageChangeListener = new d(this);
        this.aNt = new e(this);
        this.aNq = (TextView) findViewById(com.baidu.tieba.v.page_num);
        this.aNr = (MultiImageView) findViewById(com.baidu.tieba.v.viewpager);
        this.aNr.setPageMargin(com.baidu.adp.lib.util.m.dip2px(this, 8.0f));
        this.aNr.u(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.aNr.setOnPageChangeListener(this.mOnPageChangeListener);
        this.aNr.setItemOnclickListener(this.mOnClickListener);
        this.aNr.setItemOnLongClickListener(this.NU);
        this.aNr.setCurrentItem(Jm(), false);
        this.aNr.setOnScrollOutListener(this.aNt);
        this.aNr.setHasNext(false);
        this.aNr.setNextTitle("mNextTitle");
        this.aNr.setIsFromCDN(true);
        this.aNr.setAllowLocalUrl(true);
        M(this.mIndex, this.mIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jl() {
        if (this.aNo != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mq > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + this.mq;
            }
            this.aNq.setText(valueOf);
        }
    }

    private int Jm() {
        if (this.aNo != null && this.aNo.size() > 0) {
            int size = this.aNo.size();
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
            this.aNu = intent.getStringExtra("current_url");
            this.id = intent.getStringExtra("id");
            this.aNv = intent.getStringExtra("uniqueid");
            this.aNz = intent.getBooleanExtra("isSingle", false);
            if (this.aNv == null) {
                this.aNv = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.aNu == null) {
                this.aNu = "";
            }
            this.aNo = new LinkedHashMap<>();
            this.aNo.put(this.aNv, this.aNu);
            this.aNy = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.aNo = (LinkedHashMap) bundle.getSerializable(ImageViewerConfig.URL);
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.id = bundle.getString("id");
            this.aNv = bundle.getString("uniqueid");
            this.aNy = bundle.getInt("chat_mode", 0);
            this.aNz = bundle.getBoolean("isSingle", false);
            if (this.aNv == null) {
                this.aNv = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.aNx = new HashMap<>();
    }

    private void Jn() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new f(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(ImageViewerConfig.URL, this.aNo);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString("uniqueid", this.aNv);
        bundle.putInt("chat_mode", this.aNy);
        bundle.putBoolean("isSingle", this.aNz);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.aNr.setCurrentItem(this.mIndex, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(int i, int i2) {
        synchronized (this.aNx) {
            if (System.nanoTime() - this.aNw > 300000000 && this.aNo != null && i < this.aNo.size()) {
                this.aNx.put(this.aNo.get(Integer.valueOf(i)), true);
            }
            this.aNw = System.nanoTime();
        }
    }
}
