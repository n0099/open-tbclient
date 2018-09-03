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
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class GroupImageActivity extends BaseActivity<GroupImageActivity> {
    private com.baidu.tbadk.core.util.b.a bkZ;
    private FrameLayout ejo;
    private String ejv;
    private int mCount;
    private ArrayList<String> evz = null;
    private HashMap<String, ImageUrlData> evA = null;
    private int mIndex = 0;
    private a evB = null;
    private NavigationBar mNavigationBar = null;
    private TextView evC = null;
    private View aAW = null;
    private TextView mTitle = null;
    private MultiImageView ejq = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a ejr = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation ejs = null;
    private boolean ejt = true;
    private boolean eju = false;
    private long ejy = 0;
    private HashMap<String, Boolean> ejz = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkApplication.getInst().addRemoteActivity(this);
        setContentView(f.h.image_activity_2);
        setSwipeBackEnabled(false);
        initData(bundle);
        initUI();
        int size = this.evz.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            String str = this.evz.get(i);
            if (TextUtils.isEmpty(str) || !str.equals(this.ejv)) {
                i++;
            } else {
                this.mIndex = i;
                break;
            }
        }
        this.mCount = size;
        this.mTitle.setVisibility(0);
        ayw();
        this.ejq.setIsFromCDN(true);
        this.ejq.setAllowLocalUrl(true);
        this.ejq.setAssistUrls(this.evA);
        this.ejq.setUrlData(this.evz);
        this.ejq.setCurrentItem(this.mIndex, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.ejq.setBackgroundColor(am.cR(i));
        } else {
            this.ejq.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        am.j(this.mNavigationBar, f.d.common_color_10222);
        getLayoutMode().onModeChanged(this.aAW);
        getLayoutMode().onModeChanged(this.mTitle);
        getLayoutMode().onModeChanged(this.ejo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.ejq.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.ejq.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.ejq.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkApplication.getInst().delRemoteActivity(this);
        be(this.mIndex, this.mIndex);
        this.ejq.onDestroy();
        if (this.evB != null) {
            this.evB.cancel();
            this.evB = null;
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
                if (view == GroupImageActivity.this.aAW) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", GroupImageActivity.this.mIndex);
                        GroupImageActivity.this.setResult(-1, intent);
                        GroupImageActivity.this.finish();
                    }
                } else if (view == GroupImageActivity.this.ejo) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Activity pageActivity = GroupImageActivity.this.getPageContext().getPageActivity();
                        if (GroupImageActivity.this.bkZ == null) {
                            GroupImageActivity.this.bkZ = new com.baidu.tbadk.core.util.b.a();
                        }
                        GroupImageActivity.this.bkZ.zW();
                        GroupImageActivity.this.bkZ.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!GroupImageActivity.this.bkZ.u(pageActivity)) {
                            try {
                                byte[] currentImageData = GroupImageActivity.this.ejq.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = GroupImageActivity.this.ejq.getCurrentImageUrl();
                                    GroupImageActivity.this.evB = new a(currentImageUrl, currentImageData);
                                    GroupImageActivity.this.evB.execute(new String[0]);
                                    GroupImageActivity.this.evC.setVisibility(4);
                                    GroupImageActivity.this.showProgressBar();
                                } else {
                                    GroupImageActivity.this.showToast(GroupImageActivity.this.getPageContext().getString(f.j.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (GroupImageActivity.this.ejt) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 0) {
                        GroupImageActivity.this.mNavigationBar.setVisibility(0);
                        GroupImageActivity.this.ejq.FO();
                        GroupImageActivity.this.ejs = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        GroupImageActivity.this.ejs = new AlphaAnimation(1.0f, 0.0f);
                        GroupImageActivity.this.eju = true;
                        GroupImageActivity.this.ejq.FP();
                    }
                    GroupImageActivity.this.ejs.setDuration(300L);
                    GroupImageActivity.this.ejs.setFillAfter(false);
                    GroupImageActivity.this.ejs.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            GroupImageActivity.this.ejt = true;
                            if (GroupImageActivity.this.eju) {
                                GroupImageActivity.this.eju = false;
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
                    GroupImageActivity.this.ejt = false;
                    GroupImageActivity.this.mNavigationBar.startAnimation(GroupImageActivity.this.ejs);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                GroupImageActivity.this.be(GroupImageActivity.this.mIndex, i);
                GroupImageActivity.this.mIndex = i;
                GroupImageActivity.this.ayw();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - GroupImageActivity.this.ejy > 300000000 && GroupImageActivity.this.evz != null && GroupImageActivity.this.mIndex < GroupImageActivity.this.evz.size()) {
                    GroupImageActivity.this.ejz.put(GroupImageActivity.this.evz.get(GroupImageActivity.this.mIndex), true);
                }
            }
        };
        this.ejr = new BaseViewPager.a() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void de(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0101b interfaceC0101b = new b.InterfaceC0101b() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar == GroupImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            Activity pageActivity = GroupImageActivity.this.getPageContext().getPageActivity();
                            if (GroupImageActivity.this.bkZ == null) {
                                GroupImageActivity.this.bkZ = new com.baidu.tbadk.core.util.b.a();
                            }
                            GroupImageActivity.this.bkZ.zW();
                            GroupImageActivity.this.bkZ.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!GroupImageActivity.this.bkZ.u(pageActivity)) {
                                try {
                                    byte[] currentImageData = GroupImageActivity.this.ejq.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = GroupImageActivity.this.ejq.getCurrentImageUrl();
                                        GroupImageActivity.this.evB = new a(currentImageUrl, currentImageData);
                                        GroupImageActivity.this.evB.execute(new String[0]);
                                        GroupImageActivity.this.evC.setVisibility(4);
                                        GroupImageActivity.this.showProgressBar();
                                    } else {
                                        GroupImageActivity.this.showToast(GroupImageActivity.this.getPageContext().getString(f.j.no_data));
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
                GroupImageActivity.this.createListMenu(new String[]{GroupImageActivity.this.getPageContext().getString(f.j.save)}, interfaceC0101b);
                GroupImageActivity.this.showListMenu();
                return false;
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(f.g.navigation_bar);
        this.ejo = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, f.h.image_activity_save_button, this.mOnClickListener);
        this.aAW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.mNavigationBar.setTitleText("");
        this.evC = (TextView) findViewById(f.g.save);
        this.evC.setClickable(false);
        this.ejo.setOnClickListener(this.mOnClickListener);
        if (this.aAW != null) {
            this.aAW.setOnClickListener(this.mOnClickListener);
        }
        this.ejq = (MultiImageView) findViewById(f.g.viewpager);
        this.ejq.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.ejq.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.ejq.setOnPageChangeListener(this.mOnPageChangeListener);
        this.ejq.setItemOnclickListener(this.mOnClickListener);
        this.ejq.setItemOnLongClickListener(onLongClickListener);
        this.ejq.setCurrentItem(aGI(), false);
        this.ejq.setOnScrollOutListener(this.ejr);
        this.ejq.setHasNext(false);
        this.ejq.setNextTitle("mNextTitle");
        be(this.mIndex, this.mIndex);
        this.mTitle.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayw() {
        if (this.evz != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.ejq.getHasNext() && this.mIndex == this.ejq.getItemNum() - 1) {
                this.mTitle.setText(getPageContext().getString(f.j.image_recommend));
                this.evC.setVisibility(4);
                return;
            }
            this.mTitle.setText(valueOf);
            this.evC.setVisibility(0);
        }
    }

    private int aGI() {
        if (this.evz != null && this.evz.size() > 0) {
            int size = this.evz.size();
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
            this.evz = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.ejv = bundle.getString("curImgUrl");
            this.evA = (HashMap) bundle.getSerializable("assistUrls");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.evz = intent.getStringArrayListExtra("url");
                this.ejv = intent.getStringExtra("curImgUrl");
                this.evA = (HashMap) intent.getSerializableExtra("assistUrls");
                this.mIndex = 0;
            }
        }
        this.ejz = new HashMap<>();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("url", this.evz);
        bundle.putInt("index", this.mIndex);
        bundle.putString("curImgUrl", this.ejv);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.ejq.setCurrentItem(this.mIndex, true);
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
                    return com.baidu.tbadk.core.util.l.yh();
                case -1:
                default:
                    return GroupImageActivity.this.getPageContext().getString(f.j.save_fail);
                case 0:
                    return GroupImageActivity.this.getPageContext().getString(f.j.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            GroupImageActivity.this.showToast(str);
            GroupImageActivity.this.evB = null;
            GroupImageActivity.this.evC.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupImageActivity.this.evB = null;
            GroupImageActivity.this.evC.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(int i, int i2) {
        synchronized (this.ejz) {
            if (System.nanoTime() - this.ejy > 300000000 && this.evz != null && i < this.evz.size()) {
                this.ejz.put(this.evz.get(i), true);
            }
            this.ejy = System.nanoTime();
        }
    }
}
