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
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class GroupImageActivity extends BaseActivity<GroupImageActivity> {
    private FrameLayout icJ;
    private String icQ;
    private int mCount;
    private PermissionJudgePolicy mPermissionJudgement;
    private ArrayList<String> ioR = null;
    private HashMap<String, ImageUrlData> ioS = null;
    private int mIndex = 0;
    private a ioT = null;
    private NavigationBar mNavigationBar = null;
    private TextView ioU = null;
    private View mBack = null;
    private TextView mTitle = null;
    private MultiImageView icL = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a icM = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation icN = null;
    private boolean icO = true;
    private boolean icP = false;
    private long icS = 0;
    private HashMap<String, Boolean> icT = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkApplication.getInst().addRemoteActivity(this);
        setContentView(R.layout.image_activity_2);
        setSwipeBackEnabled(false);
        initData(bundle);
        initUI();
        int size = this.ioR.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            String str = this.ioR.get(i);
            if (TextUtils.isEmpty(str) || !str.equals(this.icQ)) {
                i++;
            } else {
                this.mIndex = i;
                break;
            }
        }
        this.mCount = size;
        this.mTitle.setVisibility(0);
        bSX();
        this.icL.setIsFromCDN(true);
        this.icL.setAllowLocalUrl(true);
        this.icL.setAssistUrls(this.ioS);
        this.icL.setUrlData(this.ioR);
        this.icL.setCurrentItem(this.mIndex, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1 || i == 4) {
            this.icL.setBackgroundColor(am.getBgColor(i));
        } else {
            this.icL.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        am.setBackgroundColor(this.mNavigationBar, R.color.common_color_10222);
        this.mNavigationBar.onBackBtnOnChangeSkin(i, R.color.cp_cont_a);
        getLayoutMode().onModeChanged(this.mTitle);
        getLayoutMode().onModeChanged(this.icJ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.icL.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.icL.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.icL.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkApplication.getInst().delRemoteActivity(this);
        cm(this.mIndex, this.mIndex);
        this.icL.onDestroy();
        if (this.ioT != null) {
            this.ioT.cancel();
            this.ioT = null;
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
                if (view == GroupImageActivity.this.mBack) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", GroupImageActivity.this.mIndex);
                        GroupImageActivity.this.setResult(-1, intent);
                        GroupImageActivity.this.finish();
                    }
                } else if (view == GroupImageActivity.this.icJ) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Activity pageActivity = GroupImageActivity.this.getPageContext().getPageActivity();
                        if (GroupImageActivity.this.mPermissionJudgement == null) {
                            GroupImageActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        GroupImageActivity.this.mPermissionJudgement.clearRequestPermissionList();
                        GroupImageActivity.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!GroupImageActivity.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                            try {
                                byte[] currentImageData = GroupImageActivity.this.icL.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = GroupImageActivity.this.icL.getCurrentImageUrl();
                                    GroupImageActivity.this.ioT = new a(currentImageUrl, currentImageData);
                                    GroupImageActivity.this.ioT.execute(new String[0]);
                                    GroupImageActivity.this.ioU.setVisibility(4);
                                    GroupImageActivity.this.showProgressBar();
                                } else {
                                    GroupImageActivity.this.showToast(GroupImageActivity.this.getPageContext().getString(R.string.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (GroupImageActivity.this.icO) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 0) {
                        GroupImageActivity.this.mNavigationBar.setVisibility(0);
                        GroupImageActivity.this.icL.aVo();
                        GroupImageActivity.this.icN = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        GroupImageActivity.this.icN = new AlphaAnimation(1.0f, 0.0f);
                        GroupImageActivity.this.icP = true;
                        GroupImageActivity.this.icL.aVq();
                    }
                    GroupImageActivity.this.icN.setDuration(300L);
                    GroupImageActivity.this.icN.setFillAfter(false);
                    GroupImageActivity.this.icN.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            GroupImageActivity.this.icO = true;
                            if (GroupImageActivity.this.icP) {
                                GroupImageActivity.this.icP = false;
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
                    GroupImageActivity.this.icO = false;
                    GroupImageActivity.this.mNavigationBar.startAnimation(GroupImageActivity.this.icN);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                GroupImageActivity.this.cm(GroupImageActivity.this.mIndex, i);
                GroupImageActivity.this.mIndex = i;
                GroupImageActivity.this.bSX();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - GroupImageActivity.this.icS > 300000000 && GroupImageActivity.this.ioR != null && GroupImageActivity.this.mIndex < GroupImageActivity.this.ioR.size()) {
                    GroupImageActivity.this.icT.put(GroupImageActivity.this.ioR.get(GroupImageActivity.this.mIndex), true);
                }
            }
        };
        this.icM = new BaseViewPager.a() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void onScrollOut(int i) {
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
                                GroupImageActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                            }
                            GroupImageActivity.this.mPermissionJudgement.clearRequestPermissionList();
                            GroupImageActivity.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!GroupImageActivity.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                                try {
                                    byte[] currentImageData = GroupImageActivity.this.icL.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = GroupImageActivity.this.icL.getCurrentImageUrl();
                                        GroupImageActivity.this.ioT = new a(currentImageUrl, currentImageData);
                                        GroupImageActivity.this.ioT.execute(new String[0]);
                                        GroupImageActivity.this.ioU.setVisibility(4);
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
        this.icJ = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, this.mOnClickListener);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.mNavigationBar.setTitleText("");
        this.ioU = (TextView) findViewById(R.id.save);
        this.ioU.setClickable(false);
        this.icJ.setOnClickListener(this.mOnClickListener);
        if (this.mBack != null) {
            this.mBack.setOnClickListener(this.mOnClickListener);
        }
        this.icL = (MultiImageView) findViewById(R.id.viewpager);
        this.icL.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.icL.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.icL.setOnPageChangeListener(this.mOnPageChangeListener);
        this.icL.setItemOnclickListener(this.mOnClickListener);
        this.icL.setItemOnLongClickListener(onLongClickListener);
        this.icL.setCurrentItem(ccs(), false);
        this.icL.setOnScrollOutListener(this.icM);
        this.icL.setHasNext(false);
        this.icL.setNextTitle("mNextTitle");
        cm(this.mIndex, this.mIndex);
        this.mTitle.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSX() {
        if (this.ioR != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.icL.getHasNext() && this.mIndex == this.icL.getItemNum() - 1) {
                this.mTitle.setText(getPageContext().getString(R.string.image_recommend));
                this.ioU.setVisibility(4);
                return;
            }
            this.mTitle.setText(valueOf);
            this.ioU.setVisibility(0);
        }
    }

    private int ccs() {
        if (this.ioR != null && this.ioR.size() > 0) {
            int size = this.ioR.size();
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
            this.ioR = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.icQ = bundle.getString("curImgUrl");
            this.ioS = (HashMap) bundle.getSerializable("assistUrls");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.ioR = intent.getStringArrayListExtra("url");
                this.icQ = intent.getStringExtra("curImgUrl");
                this.ioS = (HashMap) intent.getSerializableExtra("assistUrls");
                this.mIndex = 0;
            }
        }
        this.icT = new HashMap<>();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("url", this.ioR);
        bundle.putInt("index", this.mIndex);
        bundle.putString("curImgUrl", this.icQ);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.icL.setCurrentItem(this.mIndex, true);
    }

    /* loaded from: classes10.dex */
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
            switch (m.saveImageFileByUser(this.mUrl, this.mData, GroupImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return m.getSdErrorString();
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
            GroupImageActivity.this.ioT = null;
            GroupImageActivity.this.ioU.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupImageActivity.this.ioT = null;
            GroupImageActivity.this.ioU.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cm(int i, int i2) {
        synchronized (this.icT) {
            if (System.nanoTime() - this.icS > 300000000 && this.ioR != null && i < this.ioR.size()) {
                this.icT.put(this.ioR.get(i), true);
            }
            this.icS = System.nanoTime();
        }
    }
}
