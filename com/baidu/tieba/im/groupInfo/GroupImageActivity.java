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
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class GroupImageActivity extends BaseActivity<GroupImageActivity> {
    private com.baidu.tbadk.core.util.b.a bkU;
    private FrameLayout ejs;
    private String ejz;
    private int mCount;
    private ArrayList<String> evD = null;
    private HashMap<String, ImageUrlData> evE = null;
    private int mIndex = 0;
    private a evF = null;
    private NavigationBar mNavigationBar = null;
    private TextView evG = null;
    private View aAZ = null;
    private TextView mTitle = null;
    private MultiImageView eju = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a ejv = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation ejw = null;
    private boolean ejx = true;
    private boolean ejy = false;
    private long ejC = 0;
    private HashMap<String, Boolean> ejD = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkApplication.getInst().addRemoteActivity(this);
        setContentView(d.h.image_activity_2);
        setSwipeBackEnabled(false);
        initData(bundle);
        initUI();
        int size = this.evD.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            String str = this.evD.get(i);
            if (TextUtils.isEmpty(str) || !str.equals(this.ejz)) {
                i++;
            } else {
                this.mIndex = i;
                break;
            }
        }
        this.mCount = size;
        this.mTitle.setVisibility(0);
        ayy();
        this.eju.setIsFromCDN(true);
        this.eju.setAllowLocalUrl(true);
        this.eju.setAssistUrls(this.evE);
        this.eju.setUrlData(this.evD);
        this.eju.setCurrentItem(this.mIndex, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.eju.setBackgroundColor(am.cR(i));
        } else {
            this.eju.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        am.j(this.mNavigationBar, d.C0140d.common_color_10222);
        getLayoutMode().onModeChanged(this.aAZ);
        getLayoutMode().onModeChanged(this.mTitle);
        getLayoutMode().onModeChanged(this.ejs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eju.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eju.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.eju.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkApplication.getInst().delRemoteActivity(this);
        be(this.mIndex, this.mIndex);
        this.eju.onDestroy();
        if (this.evF != null) {
            this.evF.cancel();
            this.evF = null;
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
                if (view == GroupImageActivity.this.aAZ) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", GroupImageActivity.this.mIndex);
                        GroupImageActivity.this.setResult(-1, intent);
                        GroupImageActivity.this.finish();
                    }
                } else if (view == GroupImageActivity.this.ejs) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Activity pageActivity = GroupImageActivity.this.getPageContext().getPageActivity();
                        if (GroupImageActivity.this.bkU == null) {
                            GroupImageActivity.this.bkU = new com.baidu.tbadk.core.util.b.a();
                        }
                        GroupImageActivity.this.bkU.zY();
                        GroupImageActivity.this.bkU.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!GroupImageActivity.this.bkU.u(pageActivity)) {
                            try {
                                byte[] currentImageData = GroupImageActivity.this.eju.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = GroupImageActivity.this.eju.getCurrentImageUrl();
                                    GroupImageActivity.this.evF = new a(currentImageUrl, currentImageData);
                                    GroupImageActivity.this.evF.execute(new String[0]);
                                    GroupImageActivity.this.evG.setVisibility(4);
                                    GroupImageActivity.this.showProgressBar();
                                } else {
                                    GroupImageActivity.this.showToast(GroupImageActivity.this.getPageContext().getString(d.j.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (GroupImageActivity.this.ejx) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 0) {
                        GroupImageActivity.this.mNavigationBar.setVisibility(0);
                        GroupImageActivity.this.eju.FO();
                        GroupImageActivity.this.ejw = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        GroupImageActivity.this.ejw = new AlphaAnimation(1.0f, 0.0f);
                        GroupImageActivity.this.ejy = true;
                        GroupImageActivity.this.eju.FP();
                    }
                    GroupImageActivity.this.ejw.setDuration(300L);
                    GroupImageActivity.this.ejw.setFillAfter(false);
                    GroupImageActivity.this.ejw.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            GroupImageActivity.this.ejx = true;
                            if (GroupImageActivity.this.ejy) {
                                GroupImageActivity.this.ejy = false;
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
                    GroupImageActivity.this.ejx = false;
                    GroupImageActivity.this.mNavigationBar.startAnimation(GroupImageActivity.this.ejw);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                GroupImageActivity.this.be(GroupImageActivity.this.mIndex, i);
                GroupImageActivity.this.mIndex = i;
                GroupImageActivity.this.ayy();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - GroupImageActivity.this.ejC > 300000000 && GroupImageActivity.this.evD != null && GroupImageActivity.this.mIndex < GroupImageActivity.this.evD.size()) {
                    GroupImageActivity.this.ejD.put(GroupImageActivity.this.evD.get(GroupImageActivity.this.mIndex), true);
                }
            }
        };
        this.ejv = new BaseViewPager.a() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.3
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
                            if (GroupImageActivity.this.bkU == null) {
                                GroupImageActivity.this.bkU = new com.baidu.tbadk.core.util.b.a();
                            }
                            GroupImageActivity.this.bkU.zY();
                            GroupImageActivity.this.bkU.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!GroupImageActivity.this.bkU.u(pageActivity)) {
                                try {
                                    byte[] currentImageData = GroupImageActivity.this.eju.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = GroupImageActivity.this.eju.getCurrentImageUrl();
                                        GroupImageActivity.this.evF = new a(currentImageUrl, currentImageData);
                                        GroupImageActivity.this.evF.execute(new String[0]);
                                        GroupImageActivity.this.evG.setVisibility(4);
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
                GroupImageActivity.this.createListMenu(new String[]{GroupImageActivity.this.getPageContext().getString(d.j.save)}, interfaceC0101b);
                GroupImageActivity.this.showListMenu();
                return false;
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.ejs = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.image_activity_save_button, this.mOnClickListener);
        this.aAZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.mNavigationBar.setTitleText("");
        this.evG = (TextView) findViewById(d.g.save);
        this.evG.setClickable(false);
        this.ejs.setOnClickListener(this.mOnClickListener);
        if (this.aAZ != null) {
            this.aAZ.setOnClickListener(this.mOnClickListener);
        }
        this.eju = (MultiImageView) findViewById(d.g.viewpager);
        this.eju.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.eju.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.eju.setOnPageChangeListener(this.mOnPageChangeListener);
        this.eju.setItemOnclickListener(this.mOnClickListener);
        this.eju.setItemOnLongClickListener(onLongClickListener);
        this.eju.setCurrentItem(aGL(), false);
        this.eju.setOnScrollOutListener(this.ejv);
        this.eju.setHasNext(false);
        this.eju.setNextTitle("mNextTitle");
        be(this.mIndex, this.mIndex);
        this.mTitle.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayy() {
        if (this.evD != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.eju.getHasNext() && this.mIndex == this.eju.getItemNum() - 1) {
                this.mTitle.setText(getPageContext().getString(d.j.image_recommend));
                this.evG.setVisibility(4);
                return;
            }
            this.mTitle.setText(valueOf);
            this.evG.setVisibility(0);
        }
    }

    private int aGL() {
        if (this.evD != null && this.evD.size() > 0) {
            int size = this.evD.size();
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
            this.evD = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.ejz = bundle.getString("curImgUrl");
            this.evE = (HashMap) bundle.getSerializable("assistUrls");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.evD = intent.getStringArrayListExtra("url");
                this.ejz = intent.getStringExtra("curImgUrl");
                this.evE = (HashMap) intent.getSerializableExtra("assistUrls");
                this.mIndex = 0;
            }
        }
        this.ejD = new HashMap<>();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("url", this.evD);
        bundle.putInt("index", this.mIndex);
        bundle.putString("curImgUrl", this.ejz);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.eju.setCurrentItem(this.mIndex, true);
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
            switch (com.baidu.tbadk.core.util.l.a(this.mUrl, this.mData, GroupImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.l.yi();
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
            GroupImageActivity.this.evF = null;
            GroupImageActivity.this.evG.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupImageActivity.this.evF = null;
            GroupImageActivity.this.evG.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(int i, int i2) {
        synchronized (this.ejD) {
            if (System.nanoTime() - this.ejC > 300000000 && this.evD != null && i < this.evD.size()) {
                this.ejD.put(this.evD.get(i), true);
            }
            this.ejC = System.nanoTime();
        }
    }
}
