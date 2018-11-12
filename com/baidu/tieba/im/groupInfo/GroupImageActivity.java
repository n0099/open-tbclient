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
    private com.baidu.tbadk.core.util.b.a bvI;
    private FrameLayout ezS;
    private String ezZ;
    private int mCount;
    private ArrayList<String> eLU = null;
    private HashMap<String, ImageUrlData> eLV = null;
    private int mIndex = 0;
    private a eLW = null;
    private NavigationBar mNavigationBar = null;
    private TextView eLX = null;
    private View aJu = null;
    private TextView mTitle = null;
    private MultiImageView ezU = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a ezV = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation ezW = null;
    private boolean ezX = true;
    private boolean ezY = false;
    private long eAc = 0;
    private HashMap<String, Boolean> eAd = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkApplication.getInst().addRemoteActivity(this);
        setContentView(e.h.image_activity_2);
        setSwipeBackEnabled(false);
        initData(bundle);
        initUI();
        int size = this.eLU.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            String str = this.eLU.get(i);
            if (TextUtils.isEmpty(str) || !str.equals(this.ezZ)) {
                i++;
            } else {
                this.mIndex = i;
                break;
            }
        }
        this.mCount = size;
        this.mTitle.setVisibility(0);
        aDz();
        this.ezU.setIsFromCDN(true);
        this.ezU.setAllowLocalUrl(true);
        this.ezU.setAssistUrls(this.eLV);
        this.ezU.setUrlData(this.eLU);
        this.ezU.setCurrentItem(this.mIndex, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.ezU.setBackgroundColor(al.dy(i));
        } else {
            this.ezU.setBackgroundColor(-16777216);
        }
        al.j(this.mNavigationBar, e.d.common_color_10222);
        getLayoutMode().onModeChanged(this.aJu);
        getLayoutMode().onModeChanged(this.mTitle);
        getLayoutMode().onModeChanged(this.ezS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.ezU.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.ezU.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.ezU.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkApplication.getInst().delRemoteActivity(this);
        bn(this.mIndex, this.mIndex);
        this.ezU.onDestroy();
        if (this.eLW != null) {
            this.eLW.cancel();
            this.eLW = null;
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
                if (view == GroupImageActivity.this.aJu) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", GroupImageActivity.this.mIndex);
                        GroupImageActivity.this.setResult(-1, intent);
                        GroupImageActivity.this.finish();
                    }
                } else if (view == GroupImageActivity.this.ezS) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Activity pageActivity = GroupImageActivity.this.getPageContext().getPageActivity();
                        if (GroupImageActivity.this.bvI == null) {
                            GroupImageActivity.this.bvI = new com.baidu.tbadk.core.util.b.a();
                        }
                        GroupImageActivity.this.bvI.Dp();
                        GroupImageActivity.this.bvI.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!GroupImageActivity.this.bvI.A(pageActivity)) {
                            try {
                                byte[] currentImageData = GroupImageActivity.this.ezU.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = GroupImageActivity.this.ezU.getCurrentImageUrl();
                                    GroupImageActivity.this.eLW = new a(currentImageUrl, currentImageData);
                                    GroupImageActivity.this.eLW.execute(new String[0]);
                                    GroupImageActivity.this.eLX.setVisibility(4);
                                    GroupImageActivity.this.showProgressBar();
                                } else {
                                    GroupImageActivity.this.showToast(GroupImageActivity.this.getPageContext().getString(e.j.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (GroupImageActivity.this.ezX) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 0) {
                        GroupImageActivity.this.mNavigationBar.setVisibility(0);
                        GroupImageActivity.this.ezU.Jr();
                        GroupImageActivity.this.ezW = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        GroupImageActivity.this.ezW = new AlphaAnimation(1.0f, 0.0f);
                        GroupImageActivity.this.ezY = true;
                        GroupImageActivity.this.ezU.Js();
                    }
                    GroupImageActivity.this.ezW.setDuration(300L);
                    GroupImageActivity.this.ezW.setFillAfter(false);
                    GroupImageActivity.this.ezW.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            GroupImageActivity.this.ezX = true;
                            if (GroupImageActivity.this.ezY) {
                                GroupImageActivity.this.ezY = false;
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
                    GroupImageActivity.this.ezX = false;
                    GroupImageActivity.this.mNavigationBar.startAnimation(GroupImageActivity.this.ezW);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                GroupImageActivity.this.bn(GroupImageActivity.this.mIndex, i);
                GroupImageActivity.this.mIndex = i;
                GroupImageActivity.this.aDz();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - GroupImageActivity.this.eAc > 300000000 && GroupImageActivity.this.eLU != null && GroupImageActivity.this.mIndex < GroupImageActivity.this.eLU.size()) {
                    GroupImageActivity.this.eAd.put(GroupImageActivity.this.eLU.get(GroupImageActivity.this.mIndex), true);
                }
            }
        };
        this.ezV = new BaseViewPager.a() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void dN(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0148b interfaceC0148b = new b.InterfaceC0148b() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0148b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar == GroupImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            Activity pageActivity = GroupImageActivity.this.getPageContext().getPageActivity();
                            if (GroupImageActivity.this.bvI == null) {
                                GroupImageActivity.this.bvI = new com.baidu.tbadk.core.util.b.a();
                            }
                            GroupImageActivity.this.bvI.Dp();
                            GroupImageActivity.this.bvI.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!GroupImageActivity.this.bvI.A(pageActivity)) {
                                try {
                                    byte[] currentImageData = GroupImageActivity.this.ezU.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = GroupImageActivity.this.ezU.getCurrentImageUrl();
                                        GroupImageActivity.this.eLW = new a(currentImageUrl, currentImageData);
                                        GroupImageActivity.this.eLW.execute(new String[0]);
                                        GroupImageActivity.this.eLX.setVisibility(4);
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
                GroupImageActivity.this.createListMenu(new String[]{GroupImageActivity.this.getPageContext().getString(e.j.save)}, interfaceC0148b);
                GroupImageActivity.this.showListMenu();
                return false;
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(e.g.navigation_bar);
        this.ezS = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.image_activity_save_button, this.mOnClickListener);
        this.aJu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.mNavigationBar.setTitleText("");
        this.eLX = (TextView) findViewById(e.g.save);
        this.eLX.setClickable(false);
        this.ezS.setOnClickListener(this.mOnClickListener);
        if (this.aJu != null) {
            this.aJu.setOnClickListener(this.mOnClickListener);
        }
        this.ezU = (MultiImageView) findViewById(e.g.viewpager);
        this.ezU.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.ezU.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.ezU.setOnPageChangeListener(this.mOnPageChangeListener);
        this.ezU.setItemOnclickListener(this.mOnClickListener);
        this.ezU.setItemOnLongClickListener(onLongClickListener);
        this.ezU.setCurrentItem(aLM(), false);
        this.ezU.setOnScrollOutListener(this.ezV);
        this.ezU.setHasNext(false);
        this.ezU.setNextTitle("mNextTitle");
        bn(this.mIndex, this.mIndex);
        this.mTitle.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDz() {
        if (this.eLU != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.ezU.getHasNext() && this.mIndex == this.ezU.getItemNum() - 1) {
                this.mTitle.setText(getPageContext().getString(e.j.image_recommend));
                this.eLX.setVisibility(4);
                return;
            }
            this.mTitle.setText(valueOf);
            this.eLX.setVisibility(0);
        }
    }

    private int aLM() {
        if (this.eLU != null && this.eLU.size() > 0) {
            int size = this.eLU.size();
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
            this.eLU = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.ezZ = bundle.getString("curImgUrl");
            this.eLV = (HashMap) bundle.getSerializable("assistUrls");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.eLU = intent.getStringArrayListExtra("url");
                this.ezZ = intent.getStringExtra("curImgUrl");
                this.eLV = (HashMap) intent.getSerializableExtra("assistUrls");
                this.mIndex = 0;
            }
        }
        this.eAd = new HashMap<>();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("url", this.eLU);
        bundle.putInt("index", this.mIndex);
        bundle.putString("curImgUrl", this.ezZ);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.ezU.setCurrentItem(this.mIndex, true);
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
                    return com.baidu.tbadk.core.util.l.BD();
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
            GroupImageActivity.this.eLW = null;
            GroupImageActivity.this.eLX.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupImageActivity.this.eLW = null;
            GroupImageActivity.this.eLX.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bn(int i, int i2) {
        synchronized (this.eAd) {
            if (System.nanoTime() - this.eAc > 300000000 && this.eLU != null && i < this.eLU.size()) {
                this.eAd.put(this.eLU.get(i), true);
            }
            this.eAc = System.nanoTime();
        }
    }
}
