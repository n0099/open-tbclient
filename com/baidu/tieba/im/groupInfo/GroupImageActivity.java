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
    private TextView aNE;
    private String aNI;
    private View bav;
    private int mq;
    private ArrayList<String> bat = null;
    private int mIndex = 0;
    private k bau = null;
    private MultiImageView aNF = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener NY = null;
    private DialogInterface.OnClickListener aNG = null;
    private com.baidu.tbadk.core.view.a aNH = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private long aNK = 0;
    private HashMap<String, Boolean> aNL = null;

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
        int size = this.bat.size();
        int i = 0;
        while (true) {
            if (i < size) {
                String str = this.bat.get(i);
                if (TextUtils.isEmpty(str) || !str.equals(this.aNI)) {
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
        OD();
        this.aNF.setIsFromCDN(true);
        this.aNF.setAllowLocalUrl(true);
        this.aNF.setUrlData(this.bat);
        this.aNF.setCurrentItem(this.mIndex, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.aNF.setBackgroundColor(aw.by(i));
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
    public void onDestroy() {
        TbadkApplication.m251getInst().delRemoteActivity(this);
        M(this.mIndex, this.mIndex);
        this.aNF.onDestroy();
        if (this.bau != null) {
            this.bau.cancel();
            this.bau = null;
        }
        hideProgressBar();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bav != null && this.bav.getVisibility() == 0) {
                this.bav.setVisibility(8);
                return true;
            }
            Intent intent = new Intent();
            intent.putExtra(ImageViewerConfig.INDEX, this.mIndex);
            setResult(-1, intent);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void initUI() {
        long j;
        int i;
        this.mOnClickListener = new e(this);
        this.NY = new f(this);
        this.aNG = new g(this);
        this.mOnPageChangeListener = new h(this);
        this.aNH = new i(this);
        this.bav = findViewById(com.baidu.tieba.v.tip_mask);
        String string = com.baidu.tbadk.core.sharedPref.b.lk().getString("image_viewer_tip", "");
        if (string == null || string.indexOf(",") <= 0) {
            j = 0;
            i = 0;
        } else {
            String[] split = string.split(",");
            i = com.baidu.adp.lib.g.c.f(split[0], 0);
            j = com.baidu.adp.lib.g.c.a(split[1], 0L);
        }
        if (i < 5 && (j == 0 || System.currentTimeMillis() - j > 86400000)) {
            this.bav.setVisibility(0);
            this.bav.setOnClickListener(new j(this));
            com.baidu.tbadk.core.sharedPref.b.lk().putString("image_viewer_tip", String.valueOf(i + 1) + "," + System.currentTimeMillis());
        }
        this.aNE = (TextView) findViewById(com.baidu.tieba.v.page_num);
        this.aNF = (MultiImageView) findViewById(com.baidu.tieba.v.viewpager);
        this.aNF.setPageMargin(com.baidu.adp.lib.util.m.dip2px(this, 8.0f));
        this.aNF.u(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.aNF.setOnPageChangeListener(this.mOnPageChangeListener);
        this.aNF.setItemOnLongClickListener(this.NY);
        this.aNF.setItemOnclickListener(this.mOnClickListener);
        this.aNF.setCurrentItem(Jq(), false);
        this.aNF.setOnScrollOutListener(this.aNH);
        this.aNF.setHasNext(false);
        this.aNF.setNextTitle("mNextTitle");
        M(this.mIndex, this.mIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OD() {
        if (this.bat != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mq > 0) {
                valueOf = String.valueOf(String.valueOf(valueOf) + "/") + this.mq;
            }
            this.aNE.setText(valueOf);
        }
    }

    private int Jq() {
        if (this.bat != null && this.bat.size() > 0) {
            int size = this.bat.size();
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
            this.bat = bundle.getStringArrayList(ImageViewerConfig.URL);
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.aNI = bundle.getString("curImgUrl");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.bat = intent.getStringArrayListExtra(ImageViewerConfig.URL);
                this.aNI = intent.getStringExtra("curImgUrl");
                this.mIndex = 0;
            }
        }
        this.aNL = new HashMap<>();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList(ImageViewerConfig.URL, this.bat);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putString("curImgUrl", this.aNI);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.aNF.setCurrentItem(this.mIndex, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(int i, int i2) {
        synchronized (this.aNL) {
            if (System.nanoTime() - this.aNK > 300000000 && this.bat != null && i < this.bat.size()) {
                this.aNL.put(this.bat.get(i), true);
            }
            this.aNK = System.nanoTime();
        }
    }
}
