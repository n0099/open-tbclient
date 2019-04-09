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
    private FrameLayout gaa;
    private String gah;
    private int mCount;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private ArrayList<String> gmi = null;
    private HashMap<String, ImageUrlData> gmj = null;
    private int mIndex = 0;
    private a gmk = null;
    private NavigationBar mNavigationBar = null;
    private TextView gml = null;
    private View bWc = null;
    private TextView mTitle = null;
    private MultiImageView gac = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a gad = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation gae = null;
    private boolean gaf = true;
    private boolean gag = false;
    private long gak = 0;
    private HashMap<String, Boolean> gal = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkApplication.getInst().addRemoteActivity(this);
        setContentView(d.h.image_activity_2);
        setSwipeBackEnabled(false);
        initData(bundle);
        initUI();
        int size = this.gmi.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            String str = this.gmi.get(i);
            if (TextUtils.isEmpty(str) || !str.equals(this.gah)) {
                i++;
            } else {
                this.mIndex = i;
                break;
            }
        }
        this.mCount = size;
        this.mTitle.setVisibility(0);
        bgN();
        this.gac.setIsFromCDN(true);
        this.gac.setAllowLocalUrl(true);
        this.gac.setAssistUrls(this.gmj);
        this.gac.setUrlData(this.gmi);
        this.gac.setCurrentItem(this.mIndex, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.gac.setBackgroundColor(al.hn(i));
        } else {
            this.gac.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        al.l(this.mNavigationBar, d.C0277d.common_color_10222);
        getLayoutMode().onModeChanged(this.bWc);
        getLayoutMode().onModeChanged(this.mTitle);
        getLayoutMode().onModeChanged(this.gaa);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.gac.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gac.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.gac.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkApplication.getInst().delRemoteActivity(this);
        bI(this.mIndex, this.mIndex);
        this.gac.onDestroy();
        if (this.gmk != null) {
            this.gmk.cancel();
            this.gmk = null;
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
                if (view == GroupImageActivity.this.bWc) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", GroupImageActivity.this.mIndex);
                        GroupImageActivity.this.setResult(-1, intent);
                        GroupImageActivity.this.finish();
                    }
                } else if (view == GroupImageActivity.this.gaa) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Activity pageActivity = GroupImageActivity.this.getPageContext().getPageActivity();
                        if (GroupImageActivity.this.mPermissionJudgement == null) {
                            GroupImageActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                        }
                        GroupImageActivity.this.mPermissionJudgement.adN();
                        GroupImageActivity.this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!GroupImageActivity.this.mPermissionJudgement.Y(pageActivity)) {
                            try {
                                byte[] currentImageData = GroupImageActivity.this.gac.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = GroupImageActivity.this.gac.getCurrentImageUrl();
                                    GroupImageActivity.this.gmk = new a(currentImageUrl, currentImageData);
                                    GroupImageActivity.this.gmk.execute(new String[0]);
                                    GroupImageActivity.this.gml.setVisibility(4);
                                    GroupImageActivity.this.showProgressBar();
                                } else {
                                    GroupImageActivity.this.showToast(GroupImageActivity.this.getPageContext().getString(d.j.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (GroupImageActivity.this.gaf) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 0) {
                        GroupImageActivity.this.mNavigationBar.setVisibility(0);
                        GroupImageActivity.this.gac.akk();
                        GroupImageActivity.this.gae = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        GroupImageActivity.this.gae = new AlphaAnimation(1.0f, 0.0f);
                        GroupImageActivity.this.gag = true;
                        GroupImageActivity.this.gac.akm();
                    }
                    GroupImageActivity.this.gae.setDuration(300L);
                    GroupImageActivity.this.gae.setFillAfter(false);
                    GroupImageActivity.this.gae.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            GroupImageActivity.this.gaf = true;
                            if (GroupImageActivity.this.gag) {
                                GroupImageActivity.this.gag = false;
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
                    GroupImageActivity.this.gaf = false;
                    GroupImageActivity.this.mNavigationBar.startAnimation(GroupImageActivity.this.gae);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                GroupImageActivity.this.bI(GroupImageActivity.this.mIndex, i);
                GroupImageActivity.this.mIndex = i;
                GroupImageActivity.this.bgN();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - GroupImageActivity.this.gak > 300000000 && GroupImageActivity.this.gmi != null && GroupImageActivity.this.mIndex < GroupImageActivity.this.gmi.size()) {
                    GroupImageActivity.this.gal.put(GroupImageActivity.this.gmi.get(GroupImageActivity.this.mIndex), true);
                }
            }
        };
        this.gad = new BaseViewPager.a() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void hE(int i) {
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
                            GroupImageActivity.this.mPermissionJudgement.adN();
                            GroupImageActivity.this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!GroupImageActivity.this.mPermissionJudgement.Y(pageActivity)) {
                                try {
                                    byte[] currentImageData = GroupImageActivity.this.gac.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = GroupImageActivity.this.gac.getCurrentImageUrl();
                                        GroupImageActivity.this.gmk = new a(currentImageUrl, currentImageData);
                                        GroupImageActivity.this.gmk.execute(new String[0]);
                                        GroupImageActivity.this.gml.setVisibility(4);
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
        this.gaa = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.image_activity_save_button, this.mOnClickListener);
        this.bWc = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.mNavigationBar.setTitleText("");
        this.gml = (TextView) findViewById(d.g.save);
        this.gml.setClickable(false);
        this.gaa.setOnClickListener(this.mOnClickListener);
        if (this.bWc != null) {
            this.bWc.setOnClickListener(this.mOnClickListener);
        }
        this.gac = (MultiImageView) findViewById(d.g.viewpager);
        this.gac.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.gac.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.gac.setOnPageChangeListener(this.mOnPageChangeListener);
        this.gac.setItemOnclickListener(this.mOnClickListener);
        this.gac.setItemOnLongClickListener(onLongClickListener);
        this.gac.setCurrentItem(bpt(), false);
        this.gac.setOnScrollOutListener(this.gad);
        this.gac.setHasNext(false);
        this.gac.setNextTitle("mNextTitle");
        bI(this.mIndex, this.mIndex);
        this.mTitle.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgN() {
        if (this.gmi != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.gac.getHasNext() && this.mIndex == this.gac.getItemNum() - 1) {
                this.mTitle.setText(getPageContext().getString(d.j.image_recommend));
                this.gml.setVisibility(4);
                return;
            }
            this.mTitle.setText(valueOf);
            this.gml.setVisibility(0);
        }
    }

    private int bpt() {
        if (this.gmi != null && this.gmi.size() > 0) {
            int size = this.gmi.size();
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
            this.gmi = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.gah = bundle.getString("curImgUrl");
            this.gmj = (HashMap) bundle.getSerializable("assistUrls");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.gmi = intent.getStringArrayListExtra("url");
                this.gah = intent.getStringExtra("curImgUrl");
                this.gmj = (HashMap) intent.getSerializableExtra("assistUrls");
                this.mIndex = 0;
            }
        }
        this.gal = new HashMap<>();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("url", this.gmi);
        bundle.putInt("index", this.mIndex);
        bundle.putString("curImgUrl", this.gah);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.gac.setCurrentItem(this.mIndex, true);
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
                    return m.acb();
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
            GroupImageActivity.this.gmk = null;
            GroupImageActivity.this.gml.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupImageActivity.this.gmk = null;
            GroupImageActivity.this.gml.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(int i, int i2) {
        synchronized (this.gal) {
            if (System.nanoTime() - this.gak > 300000000 && this.gmi != null && i < this.gmi.size()) {
                this.gal.put(this.gmi.get(i), true);
            }
            this.gak = System.nanoTime();
        }
    }
}
