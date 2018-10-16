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
    private String eyF;
    private FrameLayout eyy;
    private int mCount;
    private ArrayList<String> eKB = null;
    private HashMap<String, ImageUrlData> eKC = null;
    private int mIndex = 0;
    private a eKD = null;
    private NavigationBar mNavigationBar = null;
    private TextView eKE = null;
    private View aIE = null;
    private TextView mTitle = null;
    private MultiImageView eyA = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a eyB = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation eyC = null;
    private boolean eyD = true;
    private boolean eyE = false;
    private long eyI = 0;
    private HashMap<String, Boolean> eyJ = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkApplication.getInst().addRemoteActivity(this);
        setContentView(e.h.image_activity_2);
        setSwipeBackEnabled(false);
        initData(bundle);
        initUI();
        int size = this.eKB.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            String str = this.eKB.get(i);
            if (TextUtils.isEmpty(str) || !str.equals(this.eyF)) {
                i++;
            } else {
                this.mIndex = i;
                break;
            }
        }
        this.mCount = size;
        this.mTitle.setVisibility(0);
        aEe();
        this.eyA.setIsFromCDN(true);
        this.eyA.setAllowLocalUrl(true);
        this.eyA.setAssistUrls(this.eKC);
        this.eyA.setUrlData(this.eKB);
        this.eyA.setCurrentItem(this.mIndex, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.eyA.setBackgroundColor(al.dk(i));
        } else {
            this.eyA.setBackgroundColor(-16777216);
        }
        al.j(this.mNavigationBar, e.d.common_color_10222);
        getLayoutMode().onModeChanged(this.aIE);
        getLayoutMode().onModeChanged(this.mTitle);
        getLayoutMode().onModeChanged(this.eyy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eyA.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eyA.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.eyA.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkApplication.getInst().delRemoteActivity(this);
        bl(this.mIndex, this.mIndex);
        this.eyA.onDestroy();
        if (this.eKD != null) {
            this.eKD.cancel();
            this.eKD = null;
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
                } else if (view == GroupImageActivity.this.eyy) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Activity pageActivity = GroupImageActivity.this.getPageContext().getPageActivity();
                        if (GroupImageActivity.this.buX == null) {
                            GroupImageActivity.this.buX = new com.baidu.tbadk.core.util.b.a();
                        }
                        GroupImageActivity.this.buX.Di();
                        GroupImageActivity.this.buX.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!GroupImageActivity.this.buX.z(pageActivity)) {
                            try {
                                byte[] currentImageData = GroupImageActivity.this.eyA.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = GroupImageActivity.this.eyA.getCurrentImageUrl();
                                    GroupImageActivity.this.eKD = new a(currentImageUrl, currentImageData);
                                    GroupImageActivity.this.eKD.execute(new String[0]);
                                    GroupImageActivity.this.eKE.setVisibility(4);
                                    GroupImageActivity.this.showProgressBar();
                                } else {
                                    GroupImageActivity.this.showToast(GroupImageActivity.this.getPageContext().getString(e.j.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (GroupImageActivity.this.eyD) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 0) {
                        GroupImageActivity.this.mNavigationBar.setVisibility(0);
                        GroupImageActivity.this.eyA.Jf();
                        GroupImageActivity.this.eyC = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        GroupImageActivity.this.eyC = new AlphaAnimation(1.0f, 0.0f);
                        GroupImageActivity.this.eyE = true;
                        GroupImageActivity.this.eyA.Jg();
                    }
                    GroupImageActivity.this.eyC.setDuration(300L);
                    GroupImageActivity.this.eyC.setFillAfter(false);
                    GroupImageActivity.this.eyC.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            GroupImageActivity.this.eyD = true;
                            if (GroupImageActivity.this.eyE) {
                                GroupImageActivity.this.eyE = false;
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
                    GroupImageActivity.this.eyD = false;
                    GroupImageActivity.this.mNavigationBar.startAnimation(GroupImageActivity.this.eyC);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                GroupImageActivity.this.bl(GroupImageActivity.this.mIndex, i);
                GroupImageActivity.this.mIndex = i;
                GroupImageActivity.this.aEe();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - GroupImageActivity.this.eyI > 300000000 && GroupImageActivity.this.eKB != null && GroupImageActivity.this.mIndex < GroupImageActivity.this.eKB.size()) {
                    GroupImageActivity.this.eyJ.put(GroupImageActivity.this.eKB.get(GroupImageActivity.this.mIndex), true);
                }
            }
        };
        this.eyB = new BaseViewPager.a() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.3
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
                                    byte[] currentImageData = GroupImageActivity.this.eyA.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = GroupImageActivity.this.eyA.getCurrentImageUrl();
                                        GroupImageActivity.this.eKD = new a(currentImageUrl, currentImageData);
                                        GroupImageActivity.this.eKD.execute(new String[0]);
                                        GroupImageActivity.this.eKE.setVisibility(4);
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
        this.eyy = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.image_activity_save_button, this.mOnClickListener);
        this.aIE = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.mNavigationBar.setTitleText("");
        this.eKE = (TextView) findViewById(e.g.save);
        this.eKE.setClickable(false);
        this.eyy.setOnClickListener(this.mOnClickListener);
        if (this.aIE != null) {
            this.aIE.setOnClickListener(this.mOnClickListener);
        }
        this.eyA = (MultiImageView) findViewById(e.g.viewpager);
        this.eyA.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.eyA.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.eyA.setOnPageChangeListener(this.mOnPageChangeListener);
        this.eyA.setItemOnclickListener(this.mOnClickListener);
        this.eyA.setItemOnLongClickListener(onLongClickListener);
        this.eyA.setCurrentItem(aMo(), false);
        this.eyA.setOnScrollOutListener(this.eyB);
        this.eyA.setHasNext(false);
        this.eyA.setNextTitle("mNextTitle");
        bl(this.mIndex, this.mIndex);
        this.mTitle.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEe() {
        if (this.eKB != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.eyA.getHasNext() && this.mIndex == this.eyA.getItemNum() - 1) {
                this.mTitle.setText(getPageContext().getString(e.j.image_recommend));
                this.eKE.setVisibility(4);
                return;
            }
            this.mTitle.setText(valueOf);
            this.eKE.setVisibility(0);
        }
    }

    private int aMo() {
        if (this.eKB != null && this.eKB.size() > 0) {
            int size = this.eKB.size();
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
            this.eKB = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.eyF = bundle.getString("curImgUrl");
            this.eKC = (HashMap) bundle.getSerializable("assistUrls");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.eKB = intent.getStringArrayListExtra("url");
                this.eyF = intent.getStringExtra("curImgUrl");
                this.eKC = (HashMap) intent.getSerializableExtra("assistUrls");
                this.mIndex = 0;
            }
        }
        this.eyJ = new HashMap<>();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("url", this.eKB);
        bundle.putInt("index", this.mIndex);
        bundle.putString("curImgUrl", this.eyF);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.eyA.setCurrentItem(this.mIndex, true);
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
            GroupImageActivity.this.eKD = null;
            GroupImageActivity.this.eKE.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupImageActivity.this.eKD = null;
            GroupImageActivity.this.eKE.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bl(int i, int i2) {
        synchronized (this.eyJ) {
            if (System.nanoTime() - this.eyI > 300000000 && this.eKB != null && i < this.eKB.size()) {
                this.eyJ.put(this.eKB.get(i), true);
            }
            this.eyI = System.nanoTime();
        }
    }
}
