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
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class GroupImageActivity extends BaseActivity<GroupImageActivity> {
    private FrameLayout grr;
    private String gry;
    private int mCount;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private ArrayList<String> gDw = null;
    private HashMap<String, ImageUrlData> gDx = null;
    private int mIndex = 0;
    private a gDy = null;
    private NavigationBar mNavigationBar = null;
    private TextView gDz = null;
    private View cdX = null;
    private TextView mTitle = null;
    private MultiImageView grt = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a gru = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation grv = null;
    private boolean grw = true;
    private boolean grx = false;
    private long grB = 0;
    private HashMap<String, Boolean> grC = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkApplication.getInst().addRemoteActivity(this);
        setContentView(R.layout.image_activity_2);
        setSwipeBackEnabled(false);
        initData(bundle);
        initUI();
        int size = this.gDw.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            String str = this.gDw.get(i);
            if (TextUtils.isEmpty(str) || !str.equals(this.gry)) {
                i++;
            } else {
                this.mIndex = i;
                break;
            }
        }
        this.mCount = size;
        this.mTitle.setVisibility(0);
        boh();
        this.grt.setIsFromCDN(true);
        this.grt.setAllowLocalUrl(true);
        this.grt.setAssistUrls(this.gDx);
        this.grt.setUrlData(this.gDw);
        this.grt.setCurrentItem(this.mIndex, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.grt.setBackgroundColor(al.ib(i));
        } else {
            this.grt.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        al.l(this.mNavigationBar, R.color.common_color_10222);
        getLayoutMode().onModeChanged(this.cdX);
        getLayoutMode().onModeChanged(this.mTitle);
        getLayoutMode().onModeChanged(this.grr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.grt.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.grt.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.grt.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkApplication.getInst().delRemoteActivity(this);
        bP(this.mIndex, this.mIndex);
        this.grt.onDestroy();
        if (this.gDy != null) {
            this.gDy.cancel();
            this.gDy = null;
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
                if (view == GroupImageActivity.this.cdX) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", GroupImageActivity.this.mIndex);
                        GroupImageActivity.this.setResult(-1, intent);
                        GroupImageActivity.this.finish();
                    }
                } else if (view == GroupImageActivity.this.grr) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Activity pageActivity = GroupImageActivity.this.getPageContext().getPageActivity();
                        if (GroupImageActivity.this.mPermissionJudgement == null) {
                            GroupImageActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                        }
                        GroupImageActivity.this.mPermissionJudgement.aiM();
                        GroupImageActivity.this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!GroupImageActivity.this.mPermissionJudgement.aa(pageActivity)) {
                            try {
                                byte[] currentImageData = GroupImageActivity.this.grt.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = GroupImageActivity.this.grt.getCurrentImageUrl();
                                    GroupImageActivity.this.gDy = new a(currentImageUrl, currentImageData);
                                    GroupImageActivity.this.gDy.execute(new String[0]);
                                    GroupImageActivity.this.gDz.setVisibility(4);
                                    GroupImageActivity.this.showProgressBar();
                                } else {
                                    GroupImageActivity.this.showToast(GroupImageActivity.this.getPageContext().getString(R.string.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (GroupImageActivity.this.grw) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 0) {
                        GroupImageActivity.this.mNavigationBar.setVisibility(0);
                        GroupImageActivity.this.grt.apn();
                        GroupImageActivity.this.grv = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        GroupImageActivity.this.grv = new AlphaAnimation(1.0f, 0.0f);
                        GroupImageActivity.this.grx = true;
                        GroupImageActivity.this.grt.app();
                    }
                    GroupImageActivity.this.grv.setDuration(300L);
                    GroupImageActivity.this.grv.setFillAfter(false);
                    GroupImageActivity.this.grv.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            GroupImageActivity.this.grw = true;
                            if (GroupImageActivity.this.grx) {
                                GroupImageActivity.this.grx = false;
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
                    GroupImageActivity.this.grw = false;
                    GroupImageActivity.this.mNavigationBar.startAnimation(GroupImageActivity.this.grv);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                GroupImageActivity.this.bP(GroupImageActivity.this.mIndex, i);
                GroupImageActivity.this.mIndex = i;
                GroupImageActivity.this.boh();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - GroupImageActivity.this.grB > 300000000 && GroupImageActivity.this.gDw != null && GroupImageActivity.this.mIndex < GroupImageActivity.this.gDw.size()) {
                    GroupImageActivity.this.grC.put(GroupImageActivity.this.gDw.get(GroupImageActivity.this.mIndex), true);
                }
            }
        };
        this.gru = new BaseViewPager.a() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void is(int i) {
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
                            GroupImageActivity.this.mPermissionJudgement.aiM();
                            GroupImageActivity.this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!GroupImageActivity.this.mPermissionJudgement.aa(pageActivity)) {
                                try {
                                    byte[] currentImageData = GroupImageActivity.this.grt.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = GroupImageActivity.this.grt.getCurrentImageUrl();
                                        GroupImageActivity.this.gDy = new a(currentImageUrl, currentImageData);
                                        GroupImageActivity.this.gDy.execute(new String[0]);
                                        GroupImageActivity.this.gDz.setVisibility(4);
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
        this.grr = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, this.mOnClickListener);
        this.cdX = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.mNavigationBar.setTitleText("");
        this.gDz = (TextView) findViewById(R.id.save);
        this.gDz.setClickable(false);
        this.grr.setOnClickListener(this.mOnClickListener);
        if (this.cdX != null) {
            this.cdX.setOnClickListener(this.mOnClickListener);
        }
        this.grt = (MultiImageView) findViewById(R.id.viewpager);
        this.grt.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.grt.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.grt.setOnPageChangeListener(this.mOnPageChangeListener);
        this.grt.setItemOnclickListener(this.mOnClickListener);
        this.grt.setItemOnLongClickListener(onLongClickListener);
        this.grt.setCurrentItem(bxi(), false);
        this.grt.setOnScrollOutListener(this.gru);
        this.grt.setHasNext(false);
        this.grt.setNextTitle("mNextTitle");
        bP(this.mIndex, this.mIndex);
        this.mTitle.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boh() {
        if (this.gDw != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.grt.getHasNext() && this.mIndex == this.grt.getItemNum() - 1) {
                this.mTitle.setText(getPageContext().getString(R.string.image_recommend));
                this.gDz.setVisibility(4);
                return;
            }
            this.mTitle.setText(valueOf);
            this.gDz.setVisibility(0);
        }
    }

    private int bxi() {
        if (this.gDw != null && this.gDw.size() > 0) {
            int size = this.gDw.size();
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
            this.gDw = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.gry = bundle.getString("curImgUrl");
            this.gDx = (HashMap) bundle.getSerializable("assistUrls");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.gDw = intent.getStringArrayListExtra("url");
                this.gry = intent.getStringExtra("curImgUrl");
                this.gDx = (HashMap) intent.getSerializableExtra("assistUrls");
                this.mIndex = 0;
            }
        }
        this.grC = new HashMap<>();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("url", this.gDw);
        bundle.putInt("index", this.mIndex);
        bundle.putString("curImgUrl", this.gry);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.grt.setCurrentItem(this.mIndex, true);
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
                    return m.agZ();
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
            GroupImageActivity.this.gDy = null;
            GroupImageActivity.this.gDz.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupImageActivity.this.gDy = null;
            GroupImageActivity.this.gDz.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bP(int i, int i2) {
        synchronized (this.grC) {
            if (System.nanoTime() - this.grB > 300000000 && this.gDw != null && i < this.gDw.size()) {
                this.grC.put(this.gDw.get(i), true);
            }
            this.grB = System.nanoTime();
        }
    }
}
