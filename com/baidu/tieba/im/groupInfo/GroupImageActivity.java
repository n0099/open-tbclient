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
    private FrameLayout eKl;
    private String eKs;
    private int mCount;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private ArrayList<String> eWo = null;
    private HashMap<String, ImageUrlData> eWp = null;
    private int mIndex = 0;
    private a eWq = null;
    private NavigationBar mNavigationBar = null;
    private TextView eWr = null;
    private View aNz = null;
    private TextView mTitle = null;
    private MultiImageView eKn = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a eKo = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation eKp = null;
    private boolean eKq = true;
    private boolean eKr = false;
    private long eKv = 0;
    private HashMap<String, Boolean> eKw = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkApplication.getInst().addRemoteActivity(this);
        setContentView(e.h.image_activity_2);
        setSwipeBackEnabled(false);
        initData(bundle);
        initUI();
        int size = this.eWo.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            String str = this.eWo.get(i);
            if (TextUtils.isEmpty(str) || !str.equals(this.eKs)) {
                i++;
            } else {
                this.mIndex = i;
                break;
            }
        }
        this.mCount = size;
        this.mTitle.setVisibility(0);
        aGx();
        this.eKn.setIsFromCDN(true);
        this.eKn.setAllowLocalUrl(true);
        this.eKn.setAssistUrls(this.eWp);
        this.eKn.setUrlData(this.eWo);
        this.eKn.setCurrentItem(this.mIndex, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.eKn.setBackgroundColor(al.dM(i));
        } else {
            this.eKn.setBackgroundColor(-16777216);
        }
        al.j(this.mNavigationBar, e.d.common_color_10222);
        getLayoutMode().onModeChanged(this.aNz);
        getLayoutMode().onModeChanged(this.mTitle);
        getLayoutMode().onModeChanged(this.eKl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eKn.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eKn.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.eKn.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkApplication.getInst().delRemoteActivity(this);
        bm(this.mIndex, this.mIndex);
        this.eKn.onDestroy();
        if (this.eWq != null) {
            this.eWq.cancel();
            this.eWq = null;
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
                if (view == GroupImageActivity.this.aNz) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", GroupImageActivity.this.mIndex);
                        GroupImageActivity.this.setResult(-1, intent);
                        GroupImageActivity.this.finish();
                    }
                } else if (view == GroupImageActivity.this.eKl) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Activity pageActivity = GroupImageActivity.this.getPageContext().getPageActivity();
                        if (GroupImageActivity.this.mPermissionJudgement == null) {
                            GroupImageActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                        }
                        GroupImageActivity.this.mPermissionJudgement.EG();
                        GroupImageActivity.this.mPermissionJudgement.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!GroupImageActivity.this.mPermissionJudgement.B(pageActivity)) {
                            try {
                                byte[] currentImageData = GroupImageActivity.this.eKn.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = GroupImageActivity.this.eKn.getCurrentImageUrl();
                                    GroupImageActivity.this.eWq = new a(currentImageUrl, currentImageData);
                                    GroupImageActivity.this.eWq.execute(new String[0]);
                                    GroupImageActivity.this.eWr.setVisibility(4);
                                    GroupImageActivity.this.showProgressBar();
                                } else {
                                    GroupImageActivity.this.showToast(GroupImageActivity.this.getPageContext().getString(e.j.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (GroupImageActivity.this.eKq) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 0) {
                        GroupImageActivity.this.mNavigationBar.setVisibility(0);
                        GroupImageActivity.this.eKn.KL();
                        GroupImageActivity.this.eKp = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        GroupImageActivity.this.eKp = new AlphaAnimation(1.0f, 0.0f);
                        GroupImageActivity.this.eKr = true;
                        GroupImageActivity.this.eKn.KM();
                    }
                    GroupImageActivity.this.eKp.setDuration(300L);
                    GroupImageActivity.this.eKp.setFillAfter(false);
                    GroupImageActivity.this.eKp.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            GroupImageActivity.this.eKq = true;
                            if (GroupImageActivity.this.eKr) {
                                GroupImageActivity.this.eKr = false;
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
                    GroupImageActivity.this.eKq = false;
                    GroupImageActivity.this.mNavigationBar.startAnimation(GroupImageActivity.this.eKp);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                GroupImageActivity.this.bm(GroupImageActivity.this.mIndex, i);
                GroupImageActivity.this.mIndex = i;
                GroupImageActivity.this.aGx();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - GroupImageActivity.this.eKv > 300000000 && GroupImageActivity.this.eWo != null && GroupImageActivity.this.mIndex < GroupImageActivity.this.eWo.size()) {
                    GroupImageActivity.this.eKw.put(GroupImageActivity.this.eWo.get(GroupImageActivity.this.mIndex), true);
                }
            }
        };
        this.eKo = new BaseViewPager.a() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.3
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
                            if (GroupImageActivity.this.mPermissionJudgement == null) {
                                GroupImageActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                            }
                            GroupImageActivity.this.mPermissionJudgement.EG();
                            GroupImageActivity.this.mPermissionJudgement.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!GroupImageActivity.this.mPermissionJudgement.B(pageActivity)) {
                                try {
                                    byte[] currentImageData = GroupImageActivity.this.eKn.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = GroupImageActivity.this.eKn.getCurrentImageUrl();
                                        GroupImageActivity.this.eWq = new a(currentImageUrl, currentImageData);
                                        GroupImageActivity.this.eWq.execute(new String[0]);
                                        GroupImageActivity.this.eWr.setVisibility(4);
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
        this.eKl = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.image_activity_save_button, this.mOnClickListener);
        this.aNz = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.mNavigationBar.setTitleText("");
        this.eWr = (TextView) findViewById(e.g.save);
        this.eWr.setClickable(false);
        this.eKl.setOnClickListener(this.mOnClickListener);
        if (this.aNz != null) {
            this.aNz.setOnClickListener(this.mOnClickListener);
        }
        this.eKn = (MultiImageView) findViewById(e.g.viewpager);
        this.eKn.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.eKn.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.eKn.setOnPageChangeListener(this.mOnPageChangeListener);
        this.eKn.setItemOnclickListener(this.mOnClickListener);
        this.eKn.setItemOnLongClickListener(onLongClickListener);
        this.eKn.setCurrentItem(aOR(), false);
        this.eKn.setOnScrollOutListener(this.eKo);
        this.eKn.setHasNext(false);
        this.eKn.setNextTitle("mNextTitle");
        bm(this.mIndex, this.mIndex);
        this.mTitle.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGx() {
        if (this.eWo != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.eKn.getHasNext() && this.mIndex == this.eKn.getItemNum() - 1) {
                this.mTitle.setText(getPageContext().getString(e.j.image_recommend));
                this.eWr.setVisibility(4);
                return;
            }
            this.mTitle.setText(valueOf);
            this.eWr.setVisibility(0);
        }
    }

    private int aOR() {
        if (this.eWo != null && this.eWo.size() > 0) {
            int size = this.eWo.size();
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
            this.eWo = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.eKs = bundle.getString("curImgUrl");
            this.eWp = (HashMap) bundle.getSerializable("assistUrls");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.eWo = intent.getStringArrayListExtra("url");
                this.eKs = intent.getStringExtra("curImgUrl");
                this.eWp = (HashMap) intent.getSerializableExtra("assistUrls");
                this.mIndex = 0;
            }
        }
        this.eKw = new HashMap<>();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("url", this.eWo);
        bundle.putInt("index", this.mIndex);
        bundle.putString("curImgUrl", this.eKs);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.eKn.setCurrentItem(this.mIndex, true);
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
                    return com.baidu.tbadk.core.util.l.CU();
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
            GroupImageActivity.this.eWq = null;
            GroupImageActivity.this.eWr.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupImageActivity.this.eWq = null;
            GroupImageActivity.this.eWr.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bm(int i, int i2) {
        synchronized (this.eKw) {
            if (System.nanoTime() - this.eKv > 300000000 && this.eWo != null && i < this.eWo.size()) {
                this.eKw.put(this.eWo.get(i), true);
            }
            this.eKv = System.nanoTime();
        }
    }
}
