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
    private com.baidu.tbadk.core.util.b.a bkp;
    private FrameLayout efC;
    private String efJ;
    private int mCount;
    private ArrayList<String> erL = null;
    private HashMap<String, ImageUrlData> erM = null;
    private int mIndex = 0;
    private a erN = null;
    private NavigationBar mNavigationBar = null;
    private TextView erO = null;
    private View aBf = null;
    private TextView mTitle = null;
    private MultiImageView efE = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a efF = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation efG = null;
    private boolean efH = true;
    private boolean efI = false;
    private long efM = 0;
    private HashMap<String, Boolean> efN = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkApplication.getInst().addRemoteActivity(this);
        setContentView(d.i.image_activity_2);
        setSwipeBackEnabled(false);
        initData(bundle);
        initUI();
        int size = this.erL.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            String str = this.erL.get(i);
            if (TextUtils.isEmpty(str) || !str.equals(this.efJ)) {
                i++;
            } else {
                this.mIndex = i;
                break;
            }
        }
        this.mCount = size;
        this.mTitle.setVisibility(0);
        axT();
        this.efE.setIsFromCDN(true);
        this.efE.setAllowLocalUrl(true);
        this.efE.setAssistUrls(this.erM);
        this.efE.setUrlData(this.erL);
        this.efE.setCurrentItem(this.mIndex, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.efE.setBackgroundColor(am.cP(i));
        } else {
            this.efE.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        am.j(this.mNavigationBar, d.C0142d.common_color_10222);
        getLayoutMode().onModeChanged(this.aBf);
        getLayoutMode().onModeChanged(this.mTitle);
        getLayoutMode().onModeChanged(this.efC);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.efE.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.efE.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.efE.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkApplication.getInst().delRemoteActivity(this);
        bb(this.mIndex, this.mIndex);
        this.efE.onDestroy();
        if (this.erN != null) {
            this.erN.cancel();
            this.erN = null;
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
                if (view == GroupImageActivity.this.aBf) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", GroupImageActivity.this.mIndex);
                        GroupImageActivity.this.setResult(-1, intent);
                        GroupImageActivity.this.finish();
                    }
                } else if (view == GroupImageActivity.this.efC) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Activity pageActivity = GroupImageActivity.this.getPageContext().getPageActivity();
                        if (GroupImageActivity.this.bkp == null) {
                            GroupImageActivity.this.bkp = new com.baidu.tbadk.core.util.b.a();
                        }
                        GroupImageActivity.this.bkp.Aj();
                        GroupImageActivity.this.bkp.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!GroupImageActivity.this.bkp.u(pageActivity)) {
                            try {
                                byte[] currentImageData = GroupImageActivity.this.efE.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = GroupImageActivity.this.efE.getCurrentImageUrl();
                                    GroupImageActivity.this.erN = new a(currentImageUrl, currentImageData);
                                    GroupImageActivity.this.erN.execute(new String[0]);
                                    GroupImageActivity.this.erO.setVisibility(4);
                                    GroupImageActivity.this.showProgressBar();
                                } else {
                                    GroupImageActivity.this.showToast(GroupImageActivity.this.getPageContext().getString(d.k.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (GroupImageActivity.this.efH) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 0) {
                        GroupImageActivity.this.mNavigationBar.setVisibility(0);
                        GroupImageActivity.this.efE.FS();
                        GroupImageActivity.this.efG = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        GroupImageActivity.this.efG = new AlphaAnimation(1.0f, 0.0f);
                        GroupImageActivity.this.efI = true;
                        GroupImageActivity.this.efE.FT();
                    }
                    GroupImageActivity.this.efG.setDuration(300L);
                    GroupImageActivity.this.efG.setFillAfter(false);
                    GroupImageActivity.this.efG.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            GroupImageActivity.this.efH = true;
                            if (GroupImageActivity.this.efI) {
                                GroupImageActivity.this.efI = false;
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
                    GroupImageActivity.this.efH = false;
                    GroupImageActivity.this.mNavigationBar.startAnimation(GroupImageActivity.this.efG);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                GroupImageActivity.this.bb(GroupImageActivity.this.mIndex, i);
                GroupImageActivity.this.mIndex = i;
                GroupImageActivity.this.axT();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - GroupImageActivity.this.efM > 300000000 && GroupImageActivity.this.erL != null && GroupImageActivity.this.mIndex < GroupImageActivity.this.erL.size()) {
                    GroupImageActivity.this.efN.put(GroupImageActivity.this.erL.get(GroupImageActivity.this.mIndex), true);
                }
            }
        };
        this.efF = new BaseViewPager.a() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void dc(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0104b interfaceC0104b = new b.InterfaceC0104b() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0104b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar == GroupImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            Activity pageActivity = GroupImageActivity.this.getPageContext().getPageActivity();
                            if (GroupImageActivity.this.bkp == null) {
                                GroupImageActivity.this.bkp = new com.baidu.tbadk.core.util.b.a();
                            }
                            GroupImageActivity.this.bkp.Aj();
                            GroupImageActivity.this.bkp.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!GroupImageActivity.this.bkp.u(pageActivity)) {
                                try {
                                    byte[] currentImageData = GroupImageActivity.this.efE.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = GroupImageActivity.this.efE.getCurrentImageUrl();
                                        GroupImageActivity.this.erN = new a(currentImageUrl, currentImageData);
                                        GroupImageActivity.this.erN.execute(new String[0]);
                                        GroupImageActivity.this.erO.setVisibility(4);
                                        GroupImageActivity.this.showProgressBar();
                                    } else {
                                        GroupImageActivity.this.showToast(GroupImageActivity.this.getPageContext().getString(d.k.no_data));
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
                GroupImageActivity.this.createListMenu(new String[]{GroupImageActivity.this.getPageContext().getString(d.k.save)}, interfaceC0104b);
                GroupImageActivity.this.showListMenu();
                return false;
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.efC = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.image_activity_save_button, this.mOnClickListener);
        this.aBf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.mNavigationBar.setTitleText("");
        this.erO = (TextView) findViewById(d.g.save);
        this.erO.setClickable(false);
        this.efC.setOnClickListener(this.mOnClickListener);
        if (this.aBf != null) {
            this.aBf.setOnClickListener(this.mOnClickListener);
        }
        this.efE = (MultiImageView) findViewById(d.g.viewpager);
        this.efE.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.efE.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.efE.setOnPageChangeListener(this.mOnPageChangeListener);
        this.efE.setItemOnclickListener(this.mOnClickListener);
        this.efE.setItemOnLongClickListener(onLongClickListener);
        this.efE.setCurrentItem(aFL(), false);
        this.efE.setOnScrollOutListener(this.efF);
        this.efE.setHasNext(false);
        this.efE.setNextTitle("mNextTitle");
        bb(this.mIndex, this.mIndex);
        this.mTitle.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axT() {
        if (this.erL != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.efE.getHasNext() && this.mIndex == this.efE.getItemNum() - 1) {
                this.mTitle.setText(getPageContext().getString(d.k.image_recommend));
                this.erO.setVisibility(4);
                return;
            }
            this.mTitle.setText(valueOf);
            this.erO.setVisibility(0);
        }
    }

    private int aFL() {
        if (this.erL != null && this.erL.size() > 0) {
            int size = this.erL.size();
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
            this.erL = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.efJ = bundle.getString("curImgUrl");
            this.erM = (HashMap) bundle.getSerializable("assistUrls");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.erL = intent.getStringArrayListExtra("url");
                this.efJ = intent.getStringExtra("curImgUrl");
                this.erM = (HashMap) intent.getSerializableExtra("assistUrls");
                this.mIndex = 0;
            }
        }
        this.efN = new HashMap<>();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("url", this.erL);
        bundle.putInt("index", this.mIndex);
        bundle.putString("curImgUrl", this.efJ);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.efE.setCurrentItem(this.mIndex, true);
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
                    return com.baidu.tbadk.core.util.l.yq();
                case -1:
                default:
                    return GroupImageActivity.this.getPageContext().getString(d.k.save_fail);
                case 0:
                    return GroupImageActivity.this.getPageContext().getString(d.k.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            GroupImageActivity.this.showToast(str);
            GroupImageActivity.this.erN = null;
            GroupImageActivity.this.erO.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupImageActivity.this.erN = null;
            GroupImageActivity.this.erO.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb(int i, int i2) {
        synchronized (this.efN) {
            if (System.nanoTime() - this.efM > 300000000 && this.erL != null && i < this.erL.size()) {
                this.efN.put(this.erL.get(i), true);
            }
            this.efM = System.nanoTime();
        }
    }
}
