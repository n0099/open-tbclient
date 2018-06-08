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
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class GroupImageActivity extends BaseActivity<GroupImageActivity> {
    private com.baidu.tbadk.core.util.b.a biP;
    private FrameLayout ebI;
    private String ebP;
    private int mCount;
    private ArrayList<String> enQ = null;
    private HashMap<String, ImageUrlData> enR = null;
    private int mIndex = 0;
    private a enS = null;
    private NavigationBar mNavigationBar = null;
    private TextView enT = null;
    private View aAn = null;
    private TextView mTitle = null;
    private MultiImageView ebK = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a ebL = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation ebM = null;
    private boolean ebN = true;
    private boolean ebO = false;
    private long ebS = 0;
    private HashMap<String, Boolean> ebT = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkApplication.getInst().addRemoteActivity(this);
        setContentView(d.i.image_activity_2);
        setSwipeBackEnabled(false);
        initData(bundle);
        initUI();
        int size = this.enQ.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            String str = this.enQ.get(i);
            if (TextUtils.isEmpty(str) || !str.equals(this.ebP)) {
                i++;
            } else {
                this.mIndex = i;
                break;
            }
        }
        this.mCount = size;
        this.mTitle.setVisibility(0);
        axp();
        this.ebK.setIsFromCDN(true);
        this.ebK.setAllowLocalUrl(true);
        this.ebK.setAssistUrls(this.enR);
        this.ebK.setUrlData(this.enQ);
        this.ebK.setCurrentItem(this.mIndex, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.ebK.setBackgroundColor(al.cO(i));
        } else {
            this.ebK.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        al.j(this.mNavigationBar, d.C0141d.common_color_10222);
        getLayoutMode().onModeChanged(this.aAn);
        getLayoutMode().onModeChanged(this.mTitle);
        getLayoutMode().onModeChanged(this.ebI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.ebK.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.ebK.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.ebK.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkApplication.getInst().delRemoteActivity(this);
        bc(this.mIndex, this.mIndex);
        this.ebK.onDestroy();
        if (this.enS != null) {
            this.enS.cancel();
            this.enS = null;
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
                if (view == GroupImageActivity.this.aAn) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", GroupImageActivity.this.mIndex);
                        GroupImageActivity.this.setResult(-1, intent);
                        GroupImageActivity.this.finish();
                    }
                } else if (view == GroupImageActivity.this.ebI) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Activity pageActivity = GroupImageActivity.this.getPageContext().getPageActivity();
                        if (GroupImageActivity.this.biP == null) {
                            GroupImageActivity.this.biP = new com.baidu.tbadk.core.util.b.a();
                        }
                        GroupImageActivity.this.biP.zU();
                        GroupImageActivity.this.biP.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!GroupImageActivity.this.biP.u(pageActivity)) {
                            try {
                                byte[] currentImageData = GroupImageActivity.this.ebK.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = GroupImageActivity.this.ebK.getCurrentImageUrl();
                                    GroupImageActivity.this.enS = new a(currentImageUrl, currentImageData);
                                    GroupImageActivity.this.enS.execute(new String[0]);
                                    GroupImageActivity.this.enT.setVisibility(4);
                                    GroupImageActivity.this.showProgressBar();
                                } else {
                                    GroupImageActivity.this.showToast(GroupImageActivity.this.getPageContext().getString(d.k.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (GroupImageActivity.this.ebN) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 0) {
                        GroupImageActivity.this.mNavigationBar.setVisibility(0);
                        GroupImageActivity.this.ebK.FA();
                        GroupImageActivity.this.ebM = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        GroupImageActivity.this.ebM = new AlphaAnimation(1.0f, 0.0f);
                        GroupImageActivity.this.ebO = true;
                        GroupImageActivity.this.ebK.FB();
                    }
                    GroupImageActivity.this.ebM.setDuration(300L);
                    GroupImageActivity.this.ebM.setFillAfter(false);
                    GroupImageActivity.this.ebM.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            GroupImageActivity.this.ebN = true;
                            if (GroupImageActivity.this.ebO) {
                                GroupImageActivity.this.ebO = false;
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
                    GroupImageActivity.this.ebN = false;
                    GroupImageActivity.this.mNavigationBar.startAnimation(GroupImageActivity.this.ebM);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                GroupImageActivity.this.bc(GroupImageActivity.this.mIndex, i);
                GroupImageActivity.this.mIndex = i;
                GroupImageActivity.this.axp();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - GroupImageActivity.this.ebS > 300000000 && GroupImageActivity.this.enQ != null && GroupImageActivity.this.mIndex < GroupImageActivity.this.enQ.size()) {
                    GroupImageActivity.this.ebT.put(GroupImageActivity.this.enQ.get(GroupImageActivity.this.mIndex), true);
                }
            }
        };
        this.ebL = new BaseViewPager.a() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void db(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0103b interfaceC0103b = new b.InterfaceC0103b() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0103b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar == GroupImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            Activity pageActivity = GroupImageActivity.this.getPageContext().getPageActivity();
                            if (GroupImageActivity.this.biP == null) {
                                GroupImageActivity.this.biP = new com.baidu.tbadk.core.util.b.a();
                            }
                            GroupImageActivity.this.biP.zU();
                            GroupImageActivity.this.biP.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!GroupImageActivity.this.biP.u(pageActivity)) {
                                try {
                                    byte[] currentImageData = GroupImageActivity.this.ebK.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = GroupImageActivity.this.ebK.getCurrentImageUrl();
                                        GroupImageActivity.this.enS = new a(currentImageUrl, currentImageData);
                                        GroupImageActivity.this.enS.execute(new String[0]);
                                        GroupImageActivity.this.enT.setVisibility(4);
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
                GroupImageActivity.this.createListMenu(new String[]{GroupImageActivity.this.getPageContext().getString(d.k.save)}, interfaceC0103b);
                GroupImageActivity.this.showListMenu();
                return false;
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.ebI = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.image_activity_save_button, this.mOnClickListener);
        this.aAn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.mNavigationBar.setTitleText("");
        this.enT = (TextView) findViewById(d.g.save);
        this.enT.setClickable(false);
        this.ebI.setOnClickListener(this.mOnClickListener);
        if (this.aAn != null) {
            this.aAn.setOnClickListener(this.mOnClickListener);
        }
        this.ebK = (MultiImageView) findViewById(d.g.viewpager);
        this.ebK.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.ebK.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.ebK.setOnPageChangeListener(this.mOnPageChangeListener);
        this.ebK.setItemOnclickListener(this.mOnClickListener);
        this.ebK.setItemOnLongClickListener(onLongClickListener);
        this.ebK.setCurrentItem(aFd(), false);
        this.ebK.setOnScrollOutListener(this.ebL);
        this.ebK.setHasNext(false);
        this.ebK.setNextTitle("mNextTitle");
        bc(this.mIndex, this.mIndex);
        this.mTitle.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axp() {
        if (this.enQ != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.ebK.getHasNext() && this.mIndex == this.ebK.getItemNum() - 1) {
                this.mTitle.setText(getPageContext().getString(d.k.image_recommend));
                this.enT.setVisibility(4);
                return;
            }
            this.mTitle.setText(valueOf);
            this.enT.setVisibility(0);
        }
    }

    private int aFd() {
        if (this.enQ != null && this.enQ.size() > 0) {
            int size = this.enQ.size();
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
            this.enQ = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.ebP = bundle.getString("curImgUrl");
            this.enR = (HashMap) bundle.getSerializable("assistUrls");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.enQ = intent.getStringArrayListExtra("url");
                this.ebP = intent.getStringExtra("curImgUrl");
                this.enR = (HashMap) intent.getSerializableExtra("assistUrls");
                this.mIndex = 0;
            }
        }
        this.ebT = new HashMap<>();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("url", this.enQ);
        bundle.putInt("index", this.mIndex);
        bundle.putString("curImgUrl", this.ebP);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.ebK.setCurrentItem(this.mIndex, true);
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
                    return com.baidu.tbadk.core.util.l.yc();
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
            GroupImageActivity.this.enS = null;
            GroupImageActivity.this.enT.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupImageActivity.this.enS = null;
            GroupImageActivity.this.enT.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bc(int i, int i2) {
        synchronized (this.ebT) {
            if (System.nanoTime() - this.ebS > 300000000 && this.enQ != null && i < this.enQ.size()) {
                this.ebT.put(this.enQ.get(i), true);
            }
            this.ebS = System.nanoTime();
        }
    }
}
