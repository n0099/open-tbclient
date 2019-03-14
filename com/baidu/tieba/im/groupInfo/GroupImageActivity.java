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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class GroupImageActivity extends BaseActivity<GroupImageActivity> {
    private FrameLayout gam;
    private String gat;
    private int mCount;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private ArrayList<String> gmu = null;
    private HashMap<String, ImageUrlData> gmv = null;
    private int mIndex = 0;
    private a gmw = null;
    private NavigationBar mNavigationBar = null;
    private TextView gmx = null;
    private View bVZ = null;
    private TextView mTitle = null;
    private MultiImageView gao = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a gap = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation gaq = null;
    private boolean gar = true;
    private boolean gas = false;
    private long gaw = 0;
    private HashMap<String, Boolean> gax = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkApplication.getInst().addRemoteActivity(this);
        setContentView(d.h.image_activity_2);
        setSwipeBackEnabled(false);
        initData(bundle);
        initUI();
        int size = this.gmu.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            String str = this.gmu.get(i);
            if (TextUtils.isEmpty(str) || !str.equals(this.gat)) {
                i++;
            } else {
                this.mIndex = i;
                break;
            }
        }
        this.mCount = size;
        this.mTitle.setVisibility(0);
        bgP();
        this.gao.setIsFromCDN(true);
        this.gao.setAllowLocalUrl(true);
        this.gao.setAssistUrls(this.gmv);
        this.gao.setUrlData(this.gmu);
        this.gao.setCurrentItem(this.mIndex, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.gao.setBackgroundColor(al.ho(i));
        } else {
            this.gao.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        al.l(this.mNavigationBar, d.C0277d.common_color_10222);
        getLayoutMode().onModeChanged(this.bVZ);
        getLayoutMode().onModeChanged(this.mTitle);
        getLayoutMode().onModeChanged(this.gam);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.gao.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gao.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.gao.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkApplication.getInst().delRemoteActivity(this);
        bI(this.mIndex, this.mIndex);
        this.gao.onDestroy();
        if (this.gmw != null) {
            this.gmw.cancel();
            this.gmw = null;
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
                if (view == GroupImageActivity.this.bVZ) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", GroupImageActivity.this.mIndex);
                        GroupImageActivity.this.setResult(-1, intent);
                        GroupImageActivity.this.finish();
                    }
                } else if (view == GroupImageActivity.this.gam) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Activity pageActivity = GroupImageActivity.this.getPageContext().getPageActivity();
                        if (GroupImageActivity.this.mPermissionJudgement == null) {
                            GroupImageActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                        }
                        GroupImageActivity.this.mPermissionJudgement.adQ();
                        GroupImageActivity.this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!GroupImageActivity.this.mPermissionJudgement.Y(pageActivity)) {
                            try {
                                byte[] currentImageData = GroupImageActivity.this.gao.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = GroupImageActivity.this.gao.getCurrentImageUrl();
                                    GroupImageActivity.this.gmw = new a(currentImageUrl, currentImageData);
                                    GroupImageActivity.this.gmw.execute(new String[0]);
                                    GroupImageActivity.this.gmx.setVisibility(4);
                                    GroupImageActivity.this.showProgressBar();
                                } else {
                                    GroupImageActivity.this.showToast(GroupImageActivity.this.getPageContext().getString(d.j.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (GroupImageActivity.this.gar) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 0) {
                        GroupImageActivity.this.mNavigationBar.setVisibility(0);
                        GroupImageActivity.this.gao.akn();
                        GroupImageActivity.this.gaq = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        GroupImageActivity.this.gaq = new AlphaAnimation(1.0f, 0.0f);
                        GroupImageActivity.this.gas = true;
                        GroupImageActivity.this.gao.akp();
                    }
                    GroupImageActivity.this.gaq.setDuration(300L);
                    GroupImageActivity.this.gaq.setFillAfter(false);
                    GroupImageActivity.this.gaq.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            GroupImageActivity.this.gar = true;
                            if (GroupImageActivity.this.gas) {
                                GroupImageActivity.this.gas = false;
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
                    GroupImageActivity.this.gar = false;
                    GroupImageActivity.this.mNavigationBar.startAnimation(GroupImageActivity.this.gaq);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                GroupImageActivity.this.bI(GroupImageActivity.this.mIndex, i);
                GroupImageActivity.this.mIndex = i;
                GroupImageActivity.this.bgP();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - GroupImageActivity.this.gaw > 300000000 && GroupImageActivity.this.gmu != null && GroupImageActivity.this.mIndex < GroupImageActivity.this.gmu.size()) {
                    GroupImageActivity.this.gax.put(GroupImageActivity.this.gmu.get(GroupImageActivity.this.mIndex), true);
                }
            }
        };
        this.gap = new BaseViewPager.a() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void hF(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0225b interfaceC0225b = new b.InterfaceC0225b() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar == GroupImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            Activity pageActivity = GroupImageActivity.this.getPageContext().getPageActivity();
                            if (GroupImageActivity.this.mPermissionJudgement == null) {
                                GroupImageActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                            }
                            GroupImageActivity.this.mPermissionJudgement.adQ();
                            GroupImageActivity.this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!GroupImageActivity.this.mPermissionJudgement.Y(pageActivity)) {
                                try {
                                    byte[] currentImageData = GroupImageActivity.this.gao.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = GroupImageActivity.this.gao.getCurrentImageUrl();
                                        GroupImageActivity.this.gmw = new a(currentImageUrl, currentImageData);
                                        GroupImageActivity.this.gmw.execute(new String[0]);
                                        GroupImageActivity.this.gmx.setVisibility(4);
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
                GroupImageActivity.this.createListMenu(new String[]{GroupImageActivity.this.getPageContext().getString(d.j.save)}, interfaceC0225b);
                GroupImageActivity.this.showListMenu();
                return false;
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.gam = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.image_activity_save_button, this.mOnClickListener);
        this.bVZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.mNavigationBar.setTitleText("");
        this.gmx = (TextView) findViewById(d.g.save);
        this.gmx.setClickable(false);
        this.gam.setOnClickListener(this.mOnClickListener);
        if (this.bVZ != null) {
            this.bVZ.setOnClickListener(this.mOnClickListener);
        }
        this.gao = (MultiImageView) findViewById(d.g.viewpager);
        this.gao.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.gao.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.gao.setOnPageChangeListener(this.mOnPageChangeListener);
        this.gao.setItemOnclickListener(this.mOnClickListener);
        this.gao.setItemOnLongClickListener(onLongClickListener);
        this.gao.setCurrentItem(bpw(), false);
        this.gao.setOnScrollOutListener(this.gap);
        this.gao.setHasNext(false);
        this.gao.setNextTitle("mNextTitle");
        bI(this.mIndex, this.mIndex);
        this.mTitle.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgP() {
        if (this.gmu != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.gao.getHasNext() && this.mIndex == this.gao.getItemNum() - 1) {
                this.mTitle.setText(getPageContext().getString(d.j.image_recommend));
                this.gmx.setVisibility(4);
                return;
            }
            this.mTitle.setText(valueOf);
            this.gmx.setVisibility(0);
        }
    }

    private int bpw() {
        if (this.gmu != null && this.gmu.size() > 0) {
            int size = this.gmu.size();
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
            this.gmu = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.gat = bundle.getString("curImgUrl");
            this.gmv = (HashMap) bundle.getSerializable("assistUrls");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.gmu = intent.getStringArrayListExtra("url");
                this.gat = intent.getStringExtra("curImgUrl");
                this.gmv = (HashMap) intent.getSerializableExtra("assistUrls");
                this.mIndex = 0;
            }
        }
        this.gax = new HashMap<>();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("url", this.gmu);
        bundle.putInt("index", this.mIndex);
        bundle.putString("curImgUrl", this.gat);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.gao.setCurrentItem(this.mIndex, true);
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
                    return m.ace();
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
            GroupImageActivity.this.gmw = null;
            GroupImageActivity.this.gmx.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupImageActivity.this.gmw = null;
            GroupImageActivity.this.gmx.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(int i, int i2) {
        synchronized (this.gax) {
            if (System.nanoTime() - this.gaw > 300000000 && this.gmu != null && i < this.gmu.size()) {
                this.gax.put(this.gmu.get(i), true);
            }
            this.gaw = System.nanoTime();
        }
    }
}
