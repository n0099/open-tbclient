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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes17.dex */
public class GroupImageActivity extends BaseActivity<GroupImageActivity> {
    private String jeA;
    private FrameLayout jet;
    private int mCount;
    private PermissionJudgePolicy mPermissionJudgement;
    private ArrayList<String> jsA = null;
    private HashMap<String, ImageUrlData> jsB = null;
    private int mIndex = 0;
    private a jsC = null;
    private NavigationBar mNavigationBar = null;
    private TextView jsD = null;
    private View mBack = null;
    private TextView mTitle = null;
    private MultiImageView jev = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a jew = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation jex = null;
    private boolean jey = true;
    private boolean jez = false;
    private long jeC = 0;
    private HashMap<String, Boolean> jeD = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkApplication.getInst().addRemoteActivity(this);
        setContentView(R.layout.image_activity_2);
        setSwipeBackEnabled(false);
        initData(bundle);
        initUI();
        int size = this.jsA.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            String str = this.jsA.get(i);
            if (TextUtils.isEmpty(str) || !str.equals(this.jeA)) {
                i++;
            } else {
                this.mIndex = i;
                break;
            }
        }
        this.mCount = size;
        this.mTitle.setVisibility(0);
        cqR();
        this.jev.setIsFromCDN(true);
        this.jev.setAllowLocalUrl(true);
        this.jev.setAssistUrls(this.jsB);
        this.jev.setUrlData(this.jsA);
        this.jev.setCurrentItem(this.mIndex, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1 || i == 4) {
            this.jev.setBackgroundColor(ap.getBgColor(i));
        } else {
            this.jev.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        ap.setBackgroundColor(this.mNavigationBar, R.color.common_color_10222);
        this.mNavigationBar.onBackBtnOnChangeSkin(i, R.color.cp_cont_a);
        getLayoutMode().onModeChanged(this.mTitle);
        getLayoutMode().onModeChanged(this.jet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.jev.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.jev.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.jev.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkApplication.getInst().delRemoteActivity(this);
        cI(this.mIndex, this.mIndex);
        this.jev.onDestroy();
        if (this.jsC != null) {
            this.jsC.cancel();
            this.jsC = null;
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
                } else if (view == GroupImageActivity.this.jet) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Activity pageActivity = GroupImageActivity.this.getPageContext().getPageActivity();
                        if (GroupImageActivity.this.mPermissionJudgement == null) {
                            GroupImageActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        GroupImageActivity.this.mPermissionJudgement.clearRequestPermissionList();
                        GroupImageActivity.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!GroupImageActivity.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                            try {
                                byte[] currentImageData = GroupImageActivity.this.jev.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = GroupImageActivity.this.jev.getCurrentImageUrl();
                                    GroupImageActivity.this.jsC = new a(currentImageUrl, currentImageData);
                                    GroupImageActivity.this.jsC.execute(new String[0]);
                                    GroupImageActivity.this.jsD.setVisibility(4);
                                    GroupImageActivity.this.showProgressBar();
                                } else {
                                    GroupImageActivity.this.showToast(GroupImageActivity.this.getPageContext().getString(R.string.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (GroupImageActivity.this.jey) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 0) {
                        GroupImageActivity.this.mNavigationBar.setVisibility(0);
                        GroupImageActivity.this.jev.bpV();
                        GroupImageActivity.this.jex = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        GroupImageActivity.this.jex = new AlphaAnimation(1.0f, 0.0f);
                        GroupImageActivity.this.jez = true;
                        GroupImageActivity.this.jev.bpX();
                    }
                    GroupImageActivity.this.jex.setDuration(300L);
                    GroupImageActivity.this.jex.setFillAfter(false);
                    GroupImageActivity.this.jex.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            GroupImageActivity.this.jey = true;
                            if (GroupImageActivity.this.jez) {
                                GroupImageActivity.this.jez = false;
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
                    GroupImageActivity.this.jey = false;
                    GroupImageActivity.this.mNavigationBar.startAnimation(GroupImageActivity.this.jex);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                GroupImageActivity.this.cI(GroupImageActivity.this.mIndex, i);
                GroupImageActivity.this.mIndex = i;
                GroupImageActivity.this.cqR();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - GroupImageActivity.this.jeC > 300000000 && GroupImageActivity.this.jsA != null && GroupImageActivity.this.mIndex < GroupImageActivity.this.jsA.size()) {
                    GroupImageActivity.this.jeD.put(GroupImageActivity.this.jsA.get(GroupImageActivity.this.mIndex), true);
                }
            }
        };
        this.jew = new BaseViewPager.a() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void onScrollOut(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0538b interfaceC0538b = new b.InterfaceC0538b() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0538b
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
                                    byte[] currentImageData = GroupImageActivity.this.jev.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = GroupImageActivity.this.jev.getCurrentImageUrl();
                                        GroupImageActivity.this.jsC = new a(currentImageUrl, currentImageData);
                                        GroupImageActivity.this.jsC.execute(new String[0]);
                                        GroupImageActivity.this.jsD.setVisibility(4);
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
                GroupImageActivity.this.createListMenu(new String[]{GroupImageActivity.this.getPageContext().getString(R.string.save)}, interfaceC0538b);
                GroupImageActivity.this.showListMenu();
                return false;
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.jet = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, this.mOnClickListener);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.mNavigationBar.setTitleText("");
        this.jsD = (TextView) findViewById(R.id.save);
        this.jsD.setClickable(false);
        this.jet.setOnClickListener(this.mOnClickListener);
        if (this.mBack != null) {
            this.mBack.setOnClickListener(this.mOnClickListener);
        }
        this.jev = (MultiImageView) findViewById(R.id.viewpager);
        this.jev.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.jev.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.jev.setOnPageChangeListener(this.mOnPageChangeListener);
        this.jev.setItemOnclickListener(this.mOnClickListener);
        this.jev.setItemOnLongClickListener(onLongClickListener);
        this.jev.setCurrentItem(cBh(), false);
        this.jev.setOnScrollOutListener(this.jew);
        this.jev.setHasNext(false);
        this.jev.setNextTitle("mNextTitle");
        cI(this.mIndex, this.mIndex);
        this.mTitle.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqR() {
        if (this.jsA != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.jev.getHasNext() && this.mIndex == this.jev.getItemNum() - 1) {
                this.mTitle.setText(getPageContext().getString(R.string.image_recommend));
                this.jsD.setVisibility(4);
                return;
            }
            this.mTitle.setText(valueOf);
            this.jsD.setVisibility(0);
        }
    }

    private int cBh() {
        if (this.jsA != null && this.jsA.size() > 0) {
            int size = this.jsA.size();
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
            this.jsA = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.jeA = bundle.getString("curImgUrl");
            this.jsB = (HashMap) bundle.getSerializable("assistUrls");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.jsA = intent.getStringArrayListExtra("url");
                this.jeA = intent.getStringExtra("curImgUrl");
                this.jsB = (HashMap) intent.getSerializableExtra("assistUrls");
                this.mIndex = 0;
            }
        }
        this.jeD = new HashMap<>();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("url", this.jsA);
        bundle.putInt("index", this.mIndex);
        bundle.putString("curImgUrl", this.jeA);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.jev.setCurrentItem(this.mIndex, true);
    }

    /* loaded from: classes17.dex */
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
            switch (n.saveImageFileByUser(this.mUrl, this.mData, GroupImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return n.getSdErrorString();
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
            GroupImageActivity.this.jsC = null;
            GroupImageActivity.this.jsD.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupImageActivity.this.jsC = null;
            GroupImageActivity.this.jsD.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cI(int i, int i2) {
        synchronized (this.jeD) {
            if (System.nanoTime() - this.jeC > 300000000 && this.jsA != null && i < this.jsA.size()) {
                this.jeD.put(this.jsA.get(i), true);
            }
            this.jeC = System.nanoTime();
        }
    }
}
