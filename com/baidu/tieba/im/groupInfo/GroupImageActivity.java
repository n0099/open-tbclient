package com.baidu.tieba.im.groupInfo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class GroupImageActivity extends BaseActivity<GroupImageActivity> {
    private com.baidu.tbadk.core.util.b.a buX;
    private String eyG;
    private FrameLayout eyz;
    private int mCount;
    private ArrayList<String> eKC = null;
    private HashMap<String, ImageUrlData> eKD = null;
    private int mIndex = 0;
    private a eKE = null;
    private NavigationBar mNavigationBar = null;
    private TextView eKF = null;
    private View aIE = null;
    private TextView mTitle = null;
    private MultiImageView eyB = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a eyC = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation eyD = null;
    private boolean eyE = true;
    private boolean eyF = false;
    private long eyJ = 0;
    private HashMap<String, Boolean> eyK = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkApplication.getInst().addRemoteActivity(this);
        setContentView(e.h.image_activity_2);
        setSwipeBackEnabled(false);
        initData(bundle);
        initUI();
        int size = this.eKC.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            String str = this.eKC.get(i);
            if (TextUtils.isEmpty(str) || !str.equals(this.eyG)) {
                i++;
            } else {
                this.mIndex = i;
                break;
            }
        }
        this.mCount = size;
        this.mTitle.setVisibility(0);
        aEf();
        this.eyB.setIsFromCDN(true);
        this.eyB.setAllowLocalUrl(true);
        this.eyB.setAssistUrls(this.eKD);
        this.eyB.setUrlData(this.eKC);
        this.eyB.setCurrentItem(this.mIndex, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.eyB.setBackgroundColor(al.dk(i));
        } else {
            this.eyB.setBackgroundColor(-16777216);
        }
        al.j(this.mNavigationBar, e.d.common_color_10222);
        getLayoutMode().onModeChanged(this.aIE);
        getLayoutMode().onModeChanged(this.mTitle);
        getLayoutMode().onModeChanged(this.eyz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eyB.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eyB.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.eyB.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkApplication.getInst().delRemoteActivity(this);
        bl(this.mIndex, this.mIndex);
        this.eyB.onDestroy();
        if (this.eKE != null) {
            this.eKE.cancel();
            this.eKE = null;
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
                if (view == GroupImageActivity.this.aIE) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", GroupImageActivity.this.mIndex);
                        GroupImageActivity.this.setResult(-1, intent);
                        GroupImageActivity.this.finish();
                    }
                } else if (view == GroupImageActivity.this.eyz) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Activity pageActivity = GroupImageActivity.this.getPageContext().getPageActivity();
                        if (GroupImageActivity.this.buX == null) {
                            GroupImageActivity.this.buX = new com.baidu.tbadk.core.util.b.a();
                        }
                        GroupImageActivity.this.buX.Di();
                        GroupImageActivity.this.buX.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!GroupImageActivity.this.buX.z(pageActivity)) {
                            try {
                                byte[] currentImageData = GroupImageActivity.this.eyB.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = GroupImageActivity.this.eyB.getCurrentImageUrl();
                                    GroupImageActivity.this.eKE = new a(currentImageUrl, currentImageData);
                                    GroupImageActivity.this.eKE.execute(new String[0]);
                                    GroupImageActivity.this.eKF.setVisibility(4);
                                    GroupImageActivity.this.showProgressBar();
                                } else {
                                    GroupImageActivity.this.showToast(GroupImageActivity.this.getPageContext().getString(e.j.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (GroupImageActivity.this.eyE) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 0) {
                        GroupImageActivity.this.mNavigationBar.setVisibility(0);
                        GroupImageActivity.this.eyB.Jf();
                        GroupImageActivity.this.eyD = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        GroupImageActivity.this.eyD = new AlphaAnimation(1.0f, 0.0f);
                        GroupImageActivity.this.eyF = true;
                        GroupImageActivity.this.eyB.Jg();
                    }
                    GroupImageActivity.this.eyD.setDuration(300L);
                    GroupImageActivity.this.eyD.setFillAfter(false);
                    GroupImageActivity.this.eyD.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            GroupImageActivity.this.eyE = true;
                            if (GroupImageActivity.this.eyF) {
                                GroupImageActivity.this.eyF = false;
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
                    GroupImageActivity.this.eyE = false;
                    GroupImageActivity.this.mNavigationBar.startAnimation(GroupImageActivity.this.eyD);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                GroupImageActivity.this.bl(GroupImageActivity.this.mIndex, i);
                GroupImageActivity.this.mIndex = i;
                GroupImageActivity.this.aEf();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - GroupImageActivity.this.eyJ > 300000000 && GroupImageActivity.this.eKC != null && GroupImageActivity.this.mIndex < GroupImageActivity.this.eKC.size()) {
                    GroupImageActivity.this.eyK.put(GroupImageActivity.this.eKC.get(GroupImageActivity.this.mIndex), true);
                }
            }
        };
        this.eyC = new BaseViewPager.a() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void dz(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0124b interfaceC0124b = new b.InterfaceC0124b() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar == GroupImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            Activity pageActivity = GroupImageActivity.this.getPageContext().getPageActivity();
                            if (GroupImageActivity.this.buX == null) {
                                GroupImageActivity.this.buX = new com.baidu.tbadk.core.util.b.a();
                            }
                            GroupImageActivity.this.buX.Di();
                            GroupImageActivity.this.buX.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!GroupImageActivity.this.buX.z(pageActivity)) {
                                try {
                                    byte[] currentImageData = GroupImageActivity.this.eyB.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = GroupImageActivity.this.eyB.getCurrentImageUrl();
                                        GroupImageActivity.this.eKE = new a(currentImageUrl, currentImageData);
                                        GroupImageActivity.this.eKE.execute(new String[0]);
                                        GroupImageActivity.this.eKF.setVisibility(4);
                                        GroupImageActivity.this.showProgressBar();
                                    } else {
                                        GroupImageActivity.this.showToast(GroupImageActivity.this.getPageContext().getString(e.j.no_data));
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
                GroupImageActivity.this.createListMenu(new String[]{GroupImageActivity.this.getPageContext().getString(e.j.save)}, interfaceC0124b);
                GroupImageActivity.this.showListMenu();
                return false;
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(e.g.navigation_bar);
        this.eyz = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.image_activity_save_button, this.mOnClickListener);
        this.aIE = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.mNavigationBar.setTitleText("");
        this.eKF = (TextView) findViewById(e.g.save);
        this.eKF.setClickable(false);
        this.eyz.setOnClickListener(this.mOnClickListener);
        if (this.aIE != null) {
            this.aIE.setOnClickListener(this.mOnClickListener);
        }
        this.eyB = (MultiImageView) findViewById(e.g.viewpager);
        this.eyB.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.eyB.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.eyB.setOnPageChangeListener(this.mOnPageChangeListener);
        this.eyB.setItemOnclickListener(this.mOnClickListener);
        this.eyB.setItemOnLongClickListener(onLongClickListener);
        this.eyB.setCurrentItem(aMo(), false);
        this.eyB.setOnScrollOutListener(this.eyC);
        this.eyB.setHasNext(false);
        this.eyB.setNextTitle("mNextTitle");
        bl(this.mIndex, this.mIndex);
        this.mTitle.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEf() {
        if (this.eKC != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.eyB.getHasNext() && this.mIndex == this.eyB.getItemNum() - 1) {
                this.mTitle.setText(getPageContext().getString(e.j.image_recommend));
                this.eKF.setVisibility(4);
                return;
            }
            this.mTitle.setText(valueOf);
            this.eKF.setVisibility(0);
        }
    }

    private int aMo() {
        if (this.eKC != null && this.eKC.size() > 0) {
            int size = this.eKC.size();
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
            this.eKC = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.eyG = bundle.getString("curImgUrl");
            this.eKD = (HashMap) bundle.getSerializable("assistUrls");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.eKC = intent.getStringArrayListExtra("url");
                this.eyG = intent.getStringExtra("curImgUrl");
                this.eKD = (HashMap) intent.getSerializableExtra("assistUrls");
                this.mIndex = 0;
            }
        }
        this.eyK = new HashMap<>();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("url", this.eKC);
        bundle.putInt("index", this.mIndex);
        bundle.putString("curImgUrl", this.eyG);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.eyB.setCurrentItem(this.mIndex, true);
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
        public String doInBackground(String... strArr) {
            switch (com.baidu.tbadk.core.util.l.a(this.mUrl, this.mData, GroupImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.l.Bw();
                case -1:
                default:
                    return GroupImageActivity.this.getPageContext().getString(e.j.save_fail);
                case 0:
                    return GroupImageActivity.this.getPageContext().getString(e.j.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            GroupImageActivity.this.showToast(str);
            GroupImageActivity.this.eKE = null;
            GroupImageActivity.this.eKF.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupImageActivity.this.eKE = null;
            GroupImageActivity.this.eKF.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bl(int i, int i2) {
        synchronized (this.eyK) {
            if (System.nanoTime() - this.eyJ > 300000000 && this.eKC != null && i < this.eKC.size()) {
                this.eyK.put(this.eKC.get(i), true);
            }
            this.eyJ = System.nanoTime();
        }
    }
}
