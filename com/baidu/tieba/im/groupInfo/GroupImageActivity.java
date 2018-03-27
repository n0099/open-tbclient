package com.baidu.tieba.im.groupInfo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class GroupImageActivity extends BaseActivity<GroupImageActivity> {
    private com.baidu.tbadk.core.util.b.a bQG;
    private FrameLayout euM;
    private String euT;
    private int mCount;
    private ArrayList<String> eGS = null;
    private HashMap<String, ImageUrlData> eGT = null;
    private int mIndex = 0;
    private a eGU = null;
    private NavigationBar mNavigationBar = null;
    private TextView eGV = null;
    private View bgB = null;
    private TextView mTitle = null;
    private MultiImageView euO = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a euP = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation euQ = null;
    private boolean euR = true;
    private boolean euS = false;
    private long euW = 0;
    private HashMap<String, Boolean> euX = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkApplication.getInst().addRemoteActivity(this);
        setContentView(d.h.image_activity_2);
        setSwipeBackEnabled(false);
        initData(bundle);
        initUI();
        int size = this.eGS.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            String str = this.eGS.get(i);
            if (TextUtils.isEmpty(str) || !str.equals(this.euT)) {
                i++;
            } else {
                this.mIndex = i;
                break;
            }
        }
        this.mCount = size;
        this.mTitle.setVisibility(0);
        ayv();
        this.euO.setIsFromCDN(true);
        this.euO.setAllowLocalUrl(true);
        this.euO.setAssistUrls(this.eGT);
        this.euO.setUrlData(this.eGS);
        this.euO.setCurrentItem(this.mIndex, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.euO.setBackgroundColor(aj.fM(i));
        } else {
            this.euO.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        aj.t(this.mNavigationBar, d.C0141d.common_color_10222);
        getLayoutMode().aM(this.bgB);
        getLayoutMode().aM(this.mTitle);
        getLayoutMode().aM(this.euM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.euO.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.euO.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.euO.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkApplication.getInst().delRemoteActivity(this);
        bZ(this.mIndex, this.mIndex);
        this.euO.onDestroy();
        if (this.eGU != null) {
            this.eGU.cancel();
            this.eGU = null;
        }
        hideProgressBar();
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

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == GroupImageActivity.this.bgB) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", GroupImageActivity.this.mIndex);
                        GroupImageActivity.this.setResult(-1, intent);
                        GroupImageActivity.this.finish();
                    }
                } else if (view == GroupImageActivity.this.euM) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Activity pageActivity = GroupImageActivity.this.getPageContext().getPageActivity();
                        if (GroupImageActivity.this.bQG == null) {
                            GroupImageActivity.this.bQG = new com.baidu.tbadk.core.util.b.a();
                        }
                        GroupImageActivity.this.bQG.DI();
                        GroupImageActivity.this.bQG.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!GroupImageActivity.this.bQG.v(pageActivity)) {
                            try {
                                byte[] currentImageData = GroupImageActivity.this.euO.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = GroupImageActivity.this.euO.getCurrentImageUrl();
                                    GroupImageActivity.this.eGU = new a(currentImageUrl, currentImageData);
                                    GroupImageActivity.this.eGU.execute(new String[0]);
                                    GroupImageActivity.this.eGV.setVisibility(4);
                                    GroupImageActivity.this.showProgressBar();
                                } else {
                                    GroupImageActivity.this.showToast(GroupImageActivity.this.getPageContext().getString(d.j.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (GroupImageActivity.this.euR) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 0) {
                        GroupImageActivity.this.mNavigationBar.setVisibility(0);
                        GroupImageActivity.this.euO.Jl();
                        GroupImageActivity.this.euQ = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        GroupImageActivity.this.euQ = new AlphaAnimation(1.0f, 0.0f);
                        GroupImageActivity.this.euS = true;
                        GroupImageActivity.this.euO.Jm();
                    }
                    GroupImageActivity.this.euQ.setDuration(300L);
                    GroupImageActivity.this.euQ.setFillAfter(false);
                    GroupImageActivity.this.euQ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            GroupImageActivity.this.euR = true;
                            if (GroupImageActivity.this.euS) {
                                GroupImageActivity.this.euS = false;
                                GroupImageActivity.this.mNavigationBar.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    GroupImageActivity.this.euR = false;
                    GroupImageActivity.this.mNavigationBar.startAnimation(GroupImageActivity.this.euQ);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                GroupImageActivity.this.bZ(GroupImageActivity.this.mIndex, i);
                GroupImageActivity.this.mIndex = i;
                GroupImageActivity.this.ayv();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - GroupImageActivity.this.euW > 300000000 && GroupImageActivity.this.eGS != null && GroupImageActivity.this.mIndex < GroupImageActivity.this.eGS.size()) {
                    GroupImageActivity.this.euX.put(GroupImageActivity.this.eGS.get(GroupImageActivity.this.mIndex), true);
                }
            }
        };
        this.euP = new BaseViewPager.a() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void fZ(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0097b interfaceC0097b = new b.InterfaceC0097b() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar == GroupImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            Activity pageActivity = GroupImageActivity.this.getPageContext().getPageActivity();
                            if (GroupImageActivity.this.bQG == null) {
                                GroupImageActivity.this.bQG = new com.baidu.tbadk.core.util.b.a();
                            }
                            GroupImageActivity.this.bQG.DI();
                            GroupImageActivity.this.bQG.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!GroupImageActivity.this.bQG.v(pageActivity)) {
                                try {
                                    byte[] currentImageData = GroupImageActivity.this.euO.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = GroupImageActivity.this.euO.getCurrentImageUrl();
                                        GroupImageActivity.this.eGU = new a(currentImageUrl, currentImageData);
                                        GroupImageActivity.this.eGU.execute(new String[0]);
                                        GroupImageActivity.this.eGV.setVisibility(4);
                                        GroupImageActivity.this.showProgressBar();
                                    } else {
                                        GroupImageActivity.this.showToast(GroupImageActivity.this.getPageContext().getString(d.j.no_data));
                                    }
                                    break;
                                } catch (Exception e) {
                                    break;
                                }
                            } else {
                                return;
                            }
                    }
                    bVar.dismiss();
                }
            }
        };
        View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                GroupImageActivity.this.createListMenu(new String[]{GroupImageActivity.this.getPageContext().getString(d.j.save)}, interfaceC0097b);
                GroupImageActivity.this.showListMenu();
                return false;
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.euM = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.image_activity_save_button, this.mOnClickListener);
        this.bgB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.mNavigationBar.setTitleText("");
        this.eGV = (TextView) findViewById(d.g.save);
        this.eGV.setClickable(false);
        this.euM.setOnClickListener(this.mOnClickListener);
        if (this.bgB != null) {
            this.bgB.setOnClickListener(this.mOnClickListener);
        }
        this.euO = (MultiImageView) findViewById(d.g.viewpager);
        this.euO.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.euO.aF(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.euO.setOnPageChangeListener(this.mOnPageChangeListener);
        this.euO.setItemOnclickListener(this.mOnClickListener);
        this.euO.setItemOnLongClickListener(onLongClickListener);
        this.euO.setCurrentItem(aFk(), false);
        this.euO.setOnScrollOutListener(this.euP);
        this.euO.setHasNext(false);
        this.euO.setNextTitle("mNextTitle");
        bZ(this.mIndex, this.mIndex);
        this.mTitle.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayv() {
        if (this.eGS != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.euO.getHasNext() && this.mIndex == this.euO.getItemNum() - 1) {
                this.mTitle.setText(getPageContext().getString(d.j.image_recommend));
                this.eGV.setVisibility(4);
                return;
            }
            this.mTitle.setText(valueOf);
            this.eGV.setVisibility(0);
        }
    }

    private int aFk() {
        if (this.eGS != null && this.eGS.size() > 0) {
            int size = this.eGS.size();
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
        if (bundle != null) {
            this.eGS = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.euT = bundle.getString("curImgUrl");
            this.eGT = (HashMap) bundle.getSerializable("assistUrls");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.eGS = intent.getStringArrayListExtra("url");
                this.euT = intent.getStringExtra("curImgUrl");
                this.eGT = (HashMap) intent.getSerializableExtra("assistUrls");
                this.mIndex = 0;
            }
        }
        this.euX = new HashMap<>();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("url", this.eGS);
        bundle.putInt("index", this.mIndex);
        bundle.putString("curImgUrl", this.euT);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.euO.setCurrentItem(this.mIndex, true);
    }

    /* loaded from: classes3.dex */
    private class a extends BdAsyncTask<String, Integer, String> {
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
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            switch (k.a(this.mUrl, this.mData, GroupImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return k.BT();
                case -1:
                default:
                    return GroupImageActivity.this.getPageContext().getString(d.j.save_fail);
                case 0:
                    return GroupImageActivity.this.getPageContext().getString(d.j.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            GroupImageActivity.this.showToast(str);
            GroupImageActivity.this.eGU = null;
            GroupImageActivity.this.eGV.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupImageActivity.this.eGU = null;
            GroupImageActivity.this.eGV.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZ(int i, int i2) {
        synchronized (this.euX) {
            if (System.nanoTime() - this.euW > 300000000 && this.eGS != null && i < this.eGS.size()) {
                this.euX.put(this.eGS.get(i), true);
            }
            this.euW = System.nanoTime();
        }
    }
}
