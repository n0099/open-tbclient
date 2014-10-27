package com.baidu.tieba.im.groupInfo;

import android.content.Context;
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
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class GroupImageActivity extends BaseActivity {
    private TextView aNq;
    private String aNu;
    private int mq;
    private ArrayList<String> baf = null;
    private int mIndex = 0;
    private j bag = null;
    private MultiImageView aNr = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener NU = null;
    private DialogInterface.OnClickListener aNs = null;
    private com.baidu.tbadk.core.view.a aNt = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private long aNw = 0;
    private HashMap<String, Boolean> aNx = null;

    public static void a(Context context, String str, ArrayList<String> arrayList, long j) {
        if (j != 0 && context != null) {
            Intent intent = new Intent(context, GroupImageActivity.class);
            intent.putExtra("curImgUrl", str);
            intent.putExtra("groupId", String.valueOf(j));
            intent.putExtra(ImageViewerConfig.URL, arrayList);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkApplication.m251getInst().addRemoteActivity(this);
        setContentView(com.baidu.tieba.w.image_activity_2);
        d(bundle);
        initUI();
        int size = this.baf.size();
        int i = 0;
        while (true) {
            if (i < size) {
                String str = this.baf.get(i);
                if (TextUtils.isEmpty(str) || !str.equals(this.aNu)) {
                    i++;
                } else {
                    this.mIndex = i;
                    break;
                }
            } else {
                break;
            }
        }
        this.mq = size;
        OA();
        this.aNr.setIsFromCDN(true);
        this.aNr.setAllowLocalUrl(true);
        this.aNr.setUrlData(this.baf);
        this.aNr.setCurrentItem(this.mIndex, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.aNr.setBackgroundColor(aw.by(i));
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
    public void onDestroy() {
        TbadkApplication.m251getInst().delRemoteActivity(this);
        M(this.mIndex, this.mIndex);
        this.aNr.onDestroy();
        if (this.bag != null) {
            this.bag.cancel();
            this.bag = null;
        }
        hideProgressBar();
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
        this.mOnClickListener = new e(this);
        this.NU = new f(this);
        this.aNs = new g(this);
        this.mOnPageChangeListener = new h(this);
        this.aNt = new i(this);
        this.aNq = (TextView) findViewById(com.baidu.tieba.v.page_num);
        this.aNr = (MultiImageView) findViewById(com.baidu.tieba.v.viewpager);
        this.aNr.setPageMargin(com.baidu.adp.lib.util.m.dip2px(this, 8.0f));
        this.aNr.u(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.aNr.setOnPageChangeListener(this.mOnPageChangeListener);
        this.aNr.setItemOnLongClickListener(this.NU);
        this.aNr.setItemOnclickListener(this.mOnClickListener);
        this.aNr.setCurrentItem(Jm(), false);
        this.aNr.setOnScrollOutListener(this.aNt);
        this.aNr.setHasNext(false);
        this.aNr.setNextTitle("mNextTitle");
        M(this.mIndex, this.mIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OA() {
        if (this.baf != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mq > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + this.mq;
            }
            this.aNq.setText(valueOf);
        }
    }

    private int Jm() {
        if (this.baf != null && this.baf.size() > 0) {
            int size = this.baf.size();
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
        if (bundle != null) {
            this.baf = bundle.getStringArrayList(ImageViewerConfig.URL);
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.aNu = bundle.getString("curImgUrl");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.baf = intent.getStringArrayListExtra(ImageViewerConfig.URL);
                this.aNu = intent.getStringExtra("curImgUrl");
                this.mIndex = 0;
            }
        }
        this.aNx = new HashMap<>();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList(ImageViewerConfig.URL, this.baf);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putString("curImgUrl", this.aNu);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.aNr.setCurrentItem(this.mIndex, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(int i, int i2) {
        synchronized (this.aNx) {
            if (System.nanoTime() - this.aNw > 300000000 && this.baf != null && i < this.baf.size()) {
                this.aNx.put(this.baf.get(i), true);
            }
            this.aNw = System.nanoTime();
        }
    }
}
