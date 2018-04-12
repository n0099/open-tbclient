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
    private com.baidu.tbadk.core.util.b.a baD;
    private FrameLayout dPs;
    private String dPz;
    private int mCount;
    private ArrayList<String> eby = null;
    private HashMap<String, ImageUrlData> ebz = null;
    private int mIndex = 0;
    private a ebA = null;
    private NavigationBar mNavigationBar = null;
    private TextView ebB = null;
    private View asg = null;
    private TextView mTitle = null;
    private MultiImageView dPu = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a dPv = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation dPw = null;
    private boolean dPx = true;
    private boolean dPy = false;
    private long dPC = 0;
    private HashMap<String, Boolean> dPD = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkApplication.getInst().addRemoteActivity(this);
        setContentView(d.i.image_activity_2);
        setSwipeBackEnabled(false);
        initData(bundle);
        initUI();
        int size = this.eby.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            String str = this.eby.get(i);
            if (TextUtils.isEmpty(str) || !str.equals(this.dPz)) {
                i++;
            } else {
                this.mIndex = i;
                break;
            }
        }
        this.mCount = size;
        this.mTitle.setVisibility(0);
        atk();
        this.dPu.setIsFromCDN(true);
        this.dPu.setAllowLocalUrl(true);
        this.dPu.setAssistUrls(this.ebz);
        this.dPu.setUrlData(this.eby);
        this.dPu.setCurrentItem(this.mIndex, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.dPu.setBackgroundColor(ak.cM(i));
        } else {
            this.dPu.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        ak.j(this.mNavigationBar, d.C0126d.common_color_10222);
        getLayoutMode().u(this.asg);
        getLayoutMode().u(this.mTitle);
        getLayoutMode().u(this.dPs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.dPu.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dPu.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.dPu.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkApplication.getInst().delRemoteActivity(this);
        bb(this.mIndex, this.mIndex);
        this.dPu.onDestroy();
        if (this.ebA != null) {
            this.ebA.cancel();
            this.ebA = null;
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
                } else if (view2 == GroupImageActivity.this.dPs) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Activity pageActivity = GroupImageActivity.this.getPageContext().getPageActivity();
                        if (GroupImageActivity.this.baD == null) {
                            GroupImageActivity.this.baD = new com.baidu.tbadk.core.util.b.a();
                        }
                        GroupImageActivity.this.baD.wu();
                        GroupImageActivity.this.baD.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!GroupImageActivity.this.baD.v(pageActivity)) {
                            try {
                                byte[] currentImageData = GroupImageActivity.this.dPu.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = GroupImageActivity.this.dPu.getCurrentImageUrl();
                                    GroupImageActivity.this.ebA = new a(currentImageUrl, currentImageData);
                                    GroupImageActivity.this.ebA.execute(new String[0]);
                                    GroupImageActivity.this.ebB.setVisibility(4);
                                    GroupImageActivity.this.showProgressBar();
                                } else {
                                    GroupImageActivity.this.showToast(GroupImageActivity.this.getPageContext().getString(d.k.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (GroupImageActivity.this.dPx) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 0) {
                        GroupImageActivity.this.mNavigationBar.setVisibility(0);
                        GroupImageActivity.this.dPu.BZ();
                        GroupImageActivity.this.dPw = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        GroupImageActivity.this.dPw = new AlphaAnimation(1.0f, 0.0f);
                        GroupImageActivity.this.dPy = true;
                        GroupImageActivity.this.dPu.Ca();
                    }
                    GroupImageActivity.this.dPw.setDuration(300L);
                    GroupImageActivity.this.dPw.setFillAfter(false);
                    GroupImageActivity.this.dPw.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            GroupImageActivity.this.dPx = true;
                            if (GroupImageActivity.this.dPy) {
                                GroupImageActivity.this.dPy = false;
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
                    GroupImageActivity.this.dPx = false;
                    GroupImageActivity.this.mNavigationBar.startAnimation(GroupImageActivity.this.dPw);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                GroupImageActivity.this.bb(GroupImageActivity.this.mIndex, i);
                GroupImageActivity.this.mIndex = i;
                GroupImageActivity.this.atk();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - GroupImageActivity.this.dPC > 300000000 && GroupImageActivity.this.eby != null && GroupImageActivity.this.mIndex < GroupImageActivity.this.eby.size()) {
                    GroupImageActivity.this.dPD.put(GroupImageActivity.this.eby.get(GroupImageActivity.this.mIndex), true);
                }
            }
        };
        this.dPv = new BaseViewPager.a() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.3
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
                            if (GroupImageActivity.this.baD == null) {
                                GroupImageActivity.this.baD = new com.baidu.tbadk.core.util.b.a();
                            }
                            GroupImageActivity.this.baD.wu();
                            GroupImageActivity.this.baD.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!GroupImageActivity.this.baD.v(pageActivity)) {
                                try {
                                    byte[] currentImageData = GroupImageActivity.this.dPu.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = GroupImageActivity.this.dPu.getCurrentImageUrl();
                                        GroupImageActivity.this.ebA = new a(currentImageUrl, currentImageData);
                                        GroupImageActivity.this.ebA.execute(new String[0]);
                                        GroupImageActivity.this.ebB.setVisibility(4);
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
        this.dPs = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.image_activity_save_button, this.mOnClickListener);
        this.asg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.mNavigationBar.setTitleText("");
        this.ebB = (TextView) findViewById(d.g.save);
        this.ebB.setClickable(false);
        this.dPs.setOnClickListener(this.mOnClickListener);
        if (this.asg != null) {
            this.asg.setOnClickListener(this.mOnClickListener);
        }
        this.dPu = (MultiImageView) findViewById(d.g.viewpager);
        this.dPu.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.dPu.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.dPu.setOnPageChangeListener(this.mOnPageChangeListener);
        this.dPu.setItemOnclickListener(this.mOnClickListener);
        this.dPu.setItemOnLongClickListener(onLongClickListener);
        this.dPu.setCurrentItem(aAk(), false);
        this.dPu.setOnScrollOutListener(this.dPv);
        this.dPu.setHasNext(false);
        this.dPu.setNextTitle("mNextTitle");
        bb(this.mIndex, this.mIndex);
        this.mTitle.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atk() {
        if (this.eby != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.dPu.getHasNext() && this.mIndex == this.dPu.getItemNum() - 1) {
                this.mTitle.setText(getPageContext().getString(d.k.image_recommend));
                this.ebB.setVisibility(4);
                return;
            }
            this.mTitle.setText(valueOf);
            this.ebB.setVisibility(0);
        }
    }

    private int aAk() {
        if (this.eby != null && this.eby.size() > 0) {
            int size = this.eby.size();
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
            this.eby = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.dPz = bundle.getString("curImgUrl");
            this.ebz = (HashMap) bundle.getSerializable("assistUrls");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.eby = intent.getStringArrayListExtra("url");
                this.dPz = intent.getStringExtra("curImgUrl");
                this.ebz = (HashMap) intent.getSerializableExtra("assistUrls");
                this.mIndex = 0;
            }
        }
        this.dPD = new HashMap<>();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("url", this.eby);
        bundle.putInt("index", this.mIndex);
        bundle.putString("curImgUrl", this.dPz);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.dPu.setCurrentItem(this.mIndex, true);
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
                    return k.uD();
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
            GroupImageActivity.this.ebA = null;
            GroupImageActivity.this.ebB.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupImageActivity.this.ebA = null;
            GroupImageActivity.this.ebB.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb(int i, int i2) {
        synchronized (this.dPD) {
            if (System.nanoTime() - this.dPC > 300000000 && this.eby != null && i < this.eby.size()) {
                this.dPD.put(this.eby.get(i), true);
            }
            this.dPC = System.nanoTime();
        }
    }
}
