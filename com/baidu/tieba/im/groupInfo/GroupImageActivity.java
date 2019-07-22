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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class GroupImageActivity extends BaseActivity<GroupImageActivity> {
    private FrameLayout gxF;
    private String gxM;
    private int mCount;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private ArrayList<String> gJI = null;
    private HashMap<String, ImageUrlData> gJJ = null;
    private int mIndex = 0;
    private a gJK = null;
    private NavigationBar mNavigationBar = null;
    private TextView gJL = null;
    private View cfb = null;
    private TextView mTitle = null;
    private MultiImageView gxH = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a gxI = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation gxJ = null;
    private boolean gxK = true;
    private boolean gxL = false;
    private long gxO = 0;
    private HashMap<String, Boolean> gxP = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkApplication.getInst().addRemoteActivity(this);
        setContentView(R.layout.image_activity_2);
        setSwipeBackEnabled(false);
        initData(bundle);
        initUI();
        int size = this.gJI.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            String str = this.gJI.get(i);
            if (TextUtils.isEmpty(str) || !str.equals(this.gxM)) {
                i++;
            } else {
                this.mIndex = i;
                break;
            }
        }
        this.mCount = size;
        this.mTitle.setVisibility(0);
        bqi();
        this.gxH.setIsFromCDN(true);
        this.gxH.setAllowLocalUrl(true);
        this.gxH.setAssistUrls(this.gJJ);
        this.gxH.setUrlData(this.gJI);
        this.gxH.setCurrentItem(this.mIndex, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.gxH.setBackgroundColor(am.ih(i));
        } else {
            this.gxH.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        am.l(this.mNavigationBar, R.color.common_color_10222);
        getLayoutMode().onModeChanged(this.cfb);
        getLayoutMode().onModeChanged(this.mTitle);
        getLayoutMode().onModeChanged(this.gxF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.gxH.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gxH.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.gxH.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkApplication.getInst().delRemoteActivity(this);
        bV(this.mIndex, this.mIndex);
        this.gxH.onDestroy();
        if (this.gJK != null) {
            this.gJK.cancel();
            this.gJK = null;
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
                if (view == GroupImageActivity.this.cfb) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", GroupImageActivity.this.mIndex);
                        GroupImageActivity.this.setResult(-1, intent);
                        GroupImageActivity.this.finish();
                    }
                } else if (view == GroupImageActivity.this.gxF) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Activity pageActivity = GroupImageActivity.this.getPageContext().getPageActivity();
                        if (GroupImageActivity.this.mPermissionJudgement == null) {
                            GroupImageActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                        }
                        GroupImageActivity.this.mPermissionJudgement.ajQ();
                        GroupImageActivity.this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!GroupImageActivity.this.mPermissionJudgement.ad(pageActivity)) {
                            try {
                                byte[] currentImageData = GroupImageActivity.this.gxH.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = GroupImageActivity.this.gxH.getCurrentImageUrl();
                                    GroupImageActivity.this.gJK = new a(currentImageUrl, currentImageData);
                                    GroupImageActivity.this.gJK.execute(new String[0]);
                                    GroupImageActivity.this.gJL.setVisibility(4);
                                    GroupImageActivity.this.showProgressBar();
                                } else {
                                    GroupImageActivity.this.showToast(GroupImageActivity.this.getPageContext().getString(R.string.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (GroupImageActivity.this.gxK) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 0) {
                        GroupImageActivity.this.mNavigationBar.setVisibility(0);
                        GroupImageActivity.this.gxH.aqs();
                        GroupImageActivity.this.gxJ = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        GroupImageActivity.this.gxJ = new AlphaAnimation(1.0f, 0.0f);
                        GroupImageActivity.this.gxL = true;
                        GroupImageActivity.this.gxH.aqu();
                    }
                    GroupImageActivity.this.gxJ.setDuration(300L);
                    GroupImageActivity.this.gxJ.setFillAfter(false);
                    GroupImageActivity.this.gxJ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            GroupImageActivity.this.gxK = true;
                            if (GroupImageActivity.this.gxL) {
                                GroupImageActivity.this.gxL = false;
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
                    GroupImageActivity.this.gxK = false;
                    GroupImageActivity.this.mNavigationBar.startAnimation(GroupImageActivity.this.gxJ);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                GroupImageActivity.this.bV(GroupImageActivity.this.mIndex, i);
                GroupImageActivity.this.mIndex = i;
                GroupImageActivity.this.bqi();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - GroupImageActivity.this.gxO > 300000000 && GroupImageActivity.this.gJI != null && GroupImageActivity.this.mIndex < GroupImageActivity.this.gJI.size()) {
                    GroupImageActivity.this.gxP.put(GroupImageActivity.this.gJI.get(GroupImageActivity.this.mIndex), true);
                }
            }
        };
        this.gxI = new BaseViewPager.a() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void iy(int i) {
                if (i == 0) {
                }
            }
        };
        final b.a aVar = new b.a() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.a
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar == GroupImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            Activity pageActivity = GroupImageActivity.this.getPageContext().getPageActivity();
                            if (GroupImageActivity.this.mPermissionJudgement == null) {
                                GroupImageActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                            }
                            GroupImageActivity.this.mPermissionJudgement.ajQ();
                            GroupImageActivity.this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!GroupImageActivity.this.mPermissionJudgement.ad(pageActivity)) {
                                try {
                                    byte[] currentImageData = GroupImageActivity.this.gxH.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = GroupImageActivity.this.gxH.getCurrentImageUrl();
                                        GroupImageActivity.this.gJK = new a(currentImageUrl, currentImageData);
                                        GroupImageActivity.this.gJK.execute(new String[0]);
                                        GroupImageActivity.this.gJL.setVisibility(4);
                                        GroupImageActivity.this.showProgressBar();
                                    } else {
                                        GroupImageActivity.this.showToast(GroupImageActivity.this.getPageContext().getString(R.string.no_data));
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
                GroupImageActivity.this.createListMenu(new String[]{GroupImageActivity.this.getPageContext().getString(R.string.save)}, aVar);
                GroupImageActivity.this.showListMenu();
                return false;
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.gxF = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, this.mOnClickListener);
        this.cfb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.mNavigationBar.setTitleText("");
        this.gJL = (TextView) findViewById(R.id.save);
        this.gJL.setClickable(false);
        this.gxF.setOnClickListener(this.mOnClickListener);
        if (this.cfb != null) {
            this.cfb.setOnClickListener(this.mOnClickListener);
        }
        this.gxH = (MultiImageView) findViewById(R.id.viewpager);
        this.gxH.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.gxH.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.gxH.setOnPageChangeListener(this.mOnPageChangeListener);
        this.gxH.setItemOnclickListener(this.mOnClickListener);
        this.gxH.setItemOnLongClickListener(onLongClickListener);
        this.gxH.setCurrentItem(bzN(), false);
        this.gxH.setOnScrollOutListener(this.gxI);
        this.gxH.setHasNext(false);
        this.gxH.setNextTitle("mNextTitle");
        bV(this.mIndex, this.mIndex);
        this.mTitle.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqi() {
        if (this.gJI != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.gxH.getHasNext() && this.mIndex == this.gxH.getItemNum() - 1) {
                this.mTitle.setText(getPageContext().getString(R.string.image_recommend));
                this.gJL.setVisibility(4);
                return;
            }
            this.mTitle.setText(valueOf);
            this.gJL.setVisibility(0);
        }
    }

    private int bzN() {
        if (this.gJI != null && this.gJI.size() > 0) {
            int size = this.gJI.size();
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
            this.gJI = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.gxM = bundle.getString("curImgUrl");
            this.gJJ = (HashMap) bundle.getSerializable("assistUrls");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.gJI = intent.getStringArrayListExtra("url");
                this.gxM = intent.getStringExtra("curImgUrl");
                this.gJJ = (HashMap) intent.getSerializableExtra("assistUrls");
                this.mIndex = 0;
            }
        }
        this.gxP = new HashMap<>();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("url", this.gJI);
        bundle.putInt("index", this.mIndex);
        bundle.putString("curImgUrl", this.gxM);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.gxH.setCurrentItem(this.mIndex, true);
    }

    /* loaded from: classes5.dex */
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
            switch (m.a(this.mUrl, this.mData, GroupImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return m.aib();
                case -1:
                default:
                    return GroupImageActivity.this.getPageContext().getString(R.string.save_fail);
                case 0:
                    return GroupImageActivity.this.getPageContext().getString(R.string.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            GroupImageActivity.this.showToast(str);
            GroupImageActivity.this.gJK = null;
            GroupImageActivity.this.gJL.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupImageActivity.this.gJK = null;
            GroupImageActivity.this.gJL.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bV(int i, int i2) {
        synchronized (this.gxP) {
            if (System.nanoTime() - this.gxO > 300000000 && this.gJI != null && i < this.gJI.size()) {
                this.gxP.put(this.gJI.get(i), true);
            }
            this.gxO = System.nanoTime();
        }
    }
}
