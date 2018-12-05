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
    private com.baidu.tbadk.core.util.b.a bzf;
    private FrameLayout eGH;
    private String eGO;
    private int mCount;
    private ArrayList<String> eSJ = null;
    private HashMap<String, ImageUrlData> eSK = null;
    private int mIndex = 0;
    private a eSL = null;
    private NavigationBar mNavigationBar = null;
    private TextView eSM = null;
    private View aMU = null;
    private TextView mTitle = null;
    private MultiImageView eGJ = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a eGK = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation eGL = null;
    private boolean eGM = true;
    private boolean eGN = false;
    private long eGR = 0;
    private HashMap<String, Boolean> eGS = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkApplication.getInst().addRemoteActivity(this);
        setContentView(e.h.image_activity_2);
        setSwipeBackEnabled(false);
        initData(bundle);
        initUI();
        int size = this.eSJ.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            String str = this.eSJ.get(i);
            if (TextUtils.isEmpty(str) || !str.equals(this.eGO)) {
                i++;
            } else {
                this.mIndex = i;
                break;
            }
        }
        this.mCount = size;
        this.mTitle.setVisibility(0);
        aFl();
        this.eGJ.setIsFromCDN(true);
        this.eGJ.setAllowLocalUrl(true);
        this.eGJ.setAssistUrls(this.eSK);
        this.eGJ.setUrlData(this.eSJ);
        this.eGJ.setCurrentItem(this.mIndex, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.eGJ.setBackgroundColor(al.dM(i));
        } else {
            this.eGJ.setBackgroundColor(-16777216);
        }
        al.j(this.mNavigationBar, e.d.common_color_10222);
        getLayoutMode().onModeChanged(this.aMU);
        getLayoutMode().onModeChanged(this.mTitle);
        getLayoutMode().onModeChanged(this.eGH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eGJ.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eGJ.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.eGJ.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkApplication.getInst().delRemoteActivity(this);
        bl(this.mIndex, this.mIndex);
        this.eGJ.onDestroy();
        if (this.eSL != null) {
            this.eSL.cancel();
            this.eSL = null;
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
                if (view == GroupImageActivity.this.aMU) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", GroupImageActivity.this.mIndex);
                        GroupImageActivity.this.setResult(-1, intent);
                        GroupImageActivity.this.finish();
                    }
                } else if (view == GroupImageActivity.this.eGH) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Activity pageActivity = GroupImageActivity.this.getPageContext().getPageActivity();
                        if (GroupImageActivity.this.bzf == null) {
                            GroupImageActivity.this.bzf = new com.baidu.tbadk.core.util.b.a();
                        }
                        GroupImageActivity.this.bzf.Et();
                        GroupImageActivity.this.bzf.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!GroupImageActivity.this.bzf.A(pageActivity)) {
                            try {
                                byte[] currentImageData = GroupImageActivity.this.eGJ.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = GroupImageActivity.this.eGJ.getCurrentImageUrl();
                                    GroupImageActivity.this.eSL = new a(currentImageUrl, currentImageData);
                                    GroupImageActivity.this.eSL.execute(new String[0]);
                                    GroupImageActivity.this.eSM.setVisibility(4);
                                    GroupImageActivity.this.showProgressBar();
                                } else {
                                    GroupImageActivity.this.showToast(GroupImageActivity.this.getPageContext().getString(e.j.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (GroupImageActivity.this.eGM) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 0) {
                        GroupImageActivity.this.mNavigationBar.setVisibility(0);
                        GroupImageActivity.this.eGJ.Kv();
                        GroupImageActivity.this.eGL = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        GroupImageActivity.this.eGL = new AlphaAnimation(1.0f, 0.0f);
                        GroupImageActivity.this.eGN = true;
                        GroupImageActivity.this.eGJ.Kw();
                    }
                    GroupImageActivity.this.eGL.setDuration(300L);
                    GroupImageActivity.this.eGL.setFillAfter(false);
                    GroupImageActivity.this.eGL.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            GroupImageActivity.this.eGM = true;
                            if (GroupImageActivity.this.eGN) {
                                GroupImageActivity.this.eGN = false;
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
                    GroupImageActivity.this.eGM = false;
                    GroupImageActivity.this.mNavigationBar.startAnimation(GroupImageActivity.this.eGL);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                GroupImageActivity.this.bl(GroupImageActivity.this.mIndex, i);
                GroupImageActivity.this.mIndex = i;
                GroupImageActivity.this.aFl();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - GroupImageActivity.this.eGR > 300000000 && GroupImageActivity.this.eSJ != null && GroupImageActivity.this.mIndex < GroupImageActivity.this.eSJ.size()) {
                    GroupImageActivity.this.eGS.put(GroupImageActivity.this.eSJ.get(GroupImageActivity.this.mIndex), true);
                }
            }
        };
        this.eGK = new BaseViewPager.a() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void eb(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0158b interfaceC0158b = new b.InterfaceC0158b() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar == GroupImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            Activity pageActivity = GroupImageActivity.this.getPageContext().getPageActivity();
                            if (GroupImageActivity.this.bzf == null) {
                                GroupImageActivity.this.bzf = new com.baidu.tbadk.core.util.b.a();
                            }
                            GroupImageActivity.this.bzf.Et();
                            GroupImageActivity.this.bzf.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!GroupImageActivity.this.bzf.A(pageActivity)) {
                                try {
                                    byte[] currentImageData = GroupImageActivity.this.eGJ.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = GroupImageActivity.this.eGJ.getCurrentImageUrl();
                                        GroupImageActivity.this.eSL = new a(currentImageUrl, currentImageData);
                                        GroupImageActivity.this.eSL.execute(new String[0]);
                                        GroupImageActivity.this.eSM.setVisibility(4);
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
                GroupImageActivity.this.createListMenu(new String[]{GroupImageActivity.this.getPageContext().getString(e.j.save)}, interfaceC0158b);
                GroupImageActivity.this.showListMenu();
                return false;
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(e.g.navigation_bar);
        this.eGH = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.image_activity_save_button, this.mOnClickListener);
        this.aMU = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.mNavigationBar.setTitleText("");
        this.eSM = (TextView) findViewById(e.g.save);
        this.eSM.setClickable(false);
        this.eGH.setOnClickListener(this.mOnClickListener);
        if (this.aMU != null) {
            this.aMU.setOnClickListener(this.mOnClickListener);
        }
        this.eGJ = (MultiImageView) findViewById(e.g.viewpager);
        this.eGJ.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.eGJ.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.eGJ.setOnPageChangeListener(this.mOnPageChangeListener);
        this.eGJ.setItemOnclickListener(this.mOnClickListener);
        this.eGJ.setItemOnLongClickListener(onLongClickListener);
        this.eGJ.setCurrentItem(aNE(), false);
        this.eGJ.setOnScrollOutListener(this.eGK);
        this.eGJ.setHasNext(false);
        this.eGJ.setNextTitle("mNextTitle");
        bl(this.mIndex, this.mIndex);
        this.mTitle.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFl() {
        if (this.eSJ != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.eGJ.getHasNext() && this.mIndex == this.eGJ.getItemNum() - 1) {
                this.mTitle.setText(getPageContext().getString(e.j.image_recommend));
                this.eSM.setVisibility(4);
                return;
            }
            this.mTitle.setText(valueOf);
            this.eSM.setVisibility(0);
        }
    }

    private int aNE() {
        if (this.eSJ != null && this.eSJ.size() > 0) {
            int size = this.eSJ.size();
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
            this.eSJ = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.eGO = bundle.getString("curImgUrl");
            this.eSK = (HashMap) bundle.getSerializable("assistUrls");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.eSJ = intent.getStringArrayListExtra("url");
                this.eGO = intent.getStringExtra("curImgUrl");
                this.eSK = (HashMap) intent.getSerializableExtra("assistUrls");
                this.mIndex = 0;
            }
        }
        this.eGS = new HashMap<>();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("url", this.eSJ);
        bundle.putInt("index", this.mIndex);
        bundle.putString("curImgUrl", this.eGO);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.eGJ.setCurrentItem(this.mIndex, true);
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
                    return com.baidu.tbadk.core.util.l.CH();
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
            GroupImageActivity.this.eSL = null;
            GroupImageActivity.this.eSM.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupImageActivity.this.eSL = null;
            GroupImageActivity.this.eSM.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bl(int i, int i2) {
        synchronized (this.eGS) {
            if (System.nanoTime() - this.eGR > 300000000 && this.eSJ != null && i < this.eSJ.size()) {
                this.eGS.put(this.eSJ.get(i), true);
            }
            this.eGR = System.nanoTime();
        }
    }
}
