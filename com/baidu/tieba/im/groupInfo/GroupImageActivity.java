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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class GroupImageActivity extends BaseActivity<GroupImageActivity> {
    private com.baidu.tbadk.core.util.b.a baE;
    private String dQD;
    private FrameLayout dQw;
    private int mCount;
    private ArrayList<String> ecC = null;
    private HashMap<String, ImageUrlData> ecD = null;
    private int mIndex = 0;
    private a ecE = null;
    private NavigationBar mNavigationBar = null;
    private TextView ecF = null;
    private View asg = null;
    private TextView mTitle = null;
    private MultiImageView dQy = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a dQz = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation dQA = null;
    private boolean dQB = true;
    private boolean dQC = false;
    private long dQG = 0;
    private HashMap<String, Boolean> dQH = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkApplication.getInst().addRemoteActivity(this);
        setContentView(d.i.image_activity_2);
        setSwipeBackEnabled(false);
        initData(bundle);
        initUI();
        int size = this.ecC.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            String str = this.ecC.get(i);
            if (TextUtils.isEmpty(str) || !str.equals(this.dQD)) {
                i++;
            } else {
                this.mIndex = i;
                break;
            }
        }
        this.mCount = size;
        this.mTitle.setVisibility(0);
        atj();
        this.dQy.setIsFromCDN(true);
        this.dQy.setAllowLocalUrl(true);
        this.dQy.setAssistUrls(this.ecD);
        this.dQy.setUrlData(this.ecC);
        this.dQy.setCurrentItem(this.mIndex, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.dQy.setBackgroundColor(ak.cM(i));
        } else {
            this.dQy.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        ak.j(this.mNavigationBar, d.C0126d.common_color_10222);
        getLayoutMode().u(this.asg);
        getLayoutMode().u(this.mTitle);
        getLayoutMode().u(this.dQw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.dQy.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dQy.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.dQy.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkApplication.getInst().delRemoteActivity(this);
        ba(this.mIndex, this.mIndex);
        this.dQy.onDestroy();
        if (this.ecE != null) {
            this.ecE.cancel();
            this.ecE = null;
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
            public void onClick(View view2) {
                if (view2 == GroupImageActivity.this.asg) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", GroupImageActivity.this.mIndex);
                        GroupImageActivity.this.setResult(-1, intent);
                        GroupImageActivity.this.finish();
                    }
                } else if (view2 == GroupImageActivity.this.dQw) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Activity pageActivity = GroupImageActivity.this.getPageContext().getPageActivity();
                        if (GroupImageActivity.this.baE == null) {
                            GroupImageActivity.this.baE = new com.baidu.tbadk.core.util.b.a();
                        }
                        GroupImageActivity.this.baE.wt();
                        GroupImageActivity.this.baE.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!GroupImageActivity.this.baE.v(pageActivity)) {
                            try {
                                byte[] currentImageData = GroupImageActivity.this.dQy.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = GroupImageActivity.this.dQy.getCurrentImageUrl();
                                    GroupImageActivity.this.ecE = new a(currentImageUrl, currentImageData);
                                    GroupImageActivity.this.ecE.execute(new String[0]);
                                    GroupImageActivity.this.ecF.setVisibility(4);
                                    GroupImageActivity.this.showProgressBar();
                                } else {
                                    GroupImageActivity.this.showToast(GroupImageActivity.this.getPageContext().getString(d.k.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (GroupImageActivity.this.dQB) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 0) {
                        GroupImageActivity.this.mNavigationBar.setVisibility(0);
                        GroupImageActivity.this.dQy.BX();
                        GroupImageActivity.this.dQA = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        GroupImageActivity.this.dQA = new AlphaAnimation(1.0f, 0.0f);
                        GroupImageActivity.this.dQC = true;
                        GroupImageActivity.this.dQy.BY();
                    }
                    GroupImageActivity.this.dQA.setDuration(300L);
                    GroupImageActivity.this.dQA.setFillAfter(false);
                    GroupImageActivity.this.dQA.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            GroupImageActivity.this.dQB = true;
                            if (GroupImageActivity.this.dQC) {
                                GroupImageActivity.this.dQC = false;
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
                    GroupImageActivity.this.dQB = false;
                    GroupImageActivity.this.mNavigationBar.startAnimation(GroupImageActivity.this.dQA);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                GroupImageActivity.this.ba(GroupImageActivity.this.mIndex, i);
                GroupImageActivity.this.mIndex = i;
                GroupImageActivity.this.atj();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - GroupImageActivity.this.dQG > 300000000 && GroupImageActivity.this.ecC != null && GroupImageActivity.this.mIndex < GroupImageActivity.this.ecC.size()) {
                    GroupImageActivity.this.dQH.put(GroupImageActivity.this.ecC.get(GroupImageActivity.this.mIndex), true);
                }
            }
        };
        this.dQz = new BaseViewPager.a() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void cZ(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0086b interfaceC0086b = new b.InterfaceC0086b() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                if (bVar == GroupImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            Activity pageActivity = GroupImageActivity.this.getPageContext().getPageActivity();
                            if (GroupImageActivity.this.baE == null) {
                                GroupImageActivity.this.baE = new com.baidu.tbadk.core.util.b.a();
                            }
                            GroupImageActivity.this.baE.wt();
                            GroupImageActivity.this.baE.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!GroupImageActivity.this.baE.v(pageActivity)) {
                                try {
                                    byte[] currentImageData = GroupImageActivity.this.dQy.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = GroupImageActivity.this.dQy.getCurrentImageUrl();
                                        GroupImageActivity.this.ecE = new a(currentImageUrl, currentImageData);
                                        GroupImageActivity.this.ecE.execute(new String[0]);
                                        GroupImageActivity.this.ecF.setVisibility(4);
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
            public boolean onLongClick(View view2) {
                GroupImageActivity.this.createListMenu(new String[]{GroupImageActivity.this.getPageContext().getString(d.k.save)}, interfaceC0086b);
                GroupImageActivity.this.showListMenu();
                return false;
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.dQw = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.image_activity_save_button, this.mOnClickListener);
        this.asg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.mNavigationBar.setTitleText("");
        this.ecF = (TextView) findViewById(d.g.save);
        this.ecF.setClickable(false);
        this.dQw.setOnClickListener(this.mOnClickListener);
        if (this.asg != null) {
            this.asg.setOnClickListener(this.mOnClickListener);
        }
        this.dQy = (MultiImageView) findViewById(d.g.viewpager);
        this.dQy.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.dQy.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.dQy.setOnPageChangeListener(this.mOnPageChangeListener);
        this.dQy.setItemOnclickListener(this.mOnClickListener);
        this.dQy.setItemOnLongClickListener(onLongClickListener);
        this.dQy.setCurrentItem(aAi(), false);
        this.dQy.setOnScrollOutListener(this.dQz);
        this.dQy.setHasNext(false);
        this.dQy.setNextTitle("mNextTitle");
        ba(this.mIndex, this.mIndex);
        this.mTitle.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atj() {
        if (this.ecC != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.dQy.getHasNext() && this.mIndex == this.dQy.getItemNum() - 1) {
                this.mTitle.setText(getPageContext().getString(d.k.image_recommend));
                this.ecF.setVisibility(4);
                return;
            }
            this.mTitle.setText(valueOf);
            this.ecF.setVisibility(0);
        }
    }

    private int aAi() {
        if (this.ecC != null && this.ecC.size() > 0) {
            int size = this.ecC.size();
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
            this.ecC = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.dQD = bundle.getString("curImgUrl");
            this.ecD = (HashMap) bundle.getSerializable("assistUrls");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.ecC = intent.getStringArrayListExtra("url");
                this.dQD = intent.getStringExtra("curImgUrl");
                this.ecD = (HashMap) intent.getSerializableExtra("assistUrls");
                this.mIndex = 0;
            }
        }
        this.dQH = new HashMap<>();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("url", this.ecC);
        bundle.putInt("index", this.mIndex);
        bundle.putString("curImgUrl", this.dQD);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.dQy.setCurrentItem(this.mIndex, true);
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
            switch (k.a(this.mUrl, this.mData, GroupImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return k.uC();
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
            GroupImageActivity.this.ecE = null;
            GroupImageActivity.this.ecF.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupImageActivity.this.ecE = null;
            GroupImageActivity.this.ecF.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba(int i, int i2) {
        synchronized (this.dQH) {
            if (System.nanoTime() - this.dQG > 300000000 && this.ecC != null && i < this.ecC.size()) {
                this.dQH.put(this.ecC.get(i), true);
            }
            this.dQG = System.nanoTime();
        }
    }
}
