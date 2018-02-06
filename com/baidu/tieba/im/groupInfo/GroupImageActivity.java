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
import com.baidu.tbadk.core.util.aj;
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
    private com.baidu.tbadk.core.util.b.a bQQ;
    private FrameLayout euI;
    private String euP;
    private int mCount;
    private ArrayList<String> eGO = null;
    private HashMap<String, ImageUrlData> eGP = null;
    private int mIndex = 0;
    private a eGQ = null;
    private NavigationBar mNavigationBar = null;
    private TextView eGR = null;
    private View bgK = null;
    private TextView mTitle = null;
    private MultiImageView euK = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a euL = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation euM = null;
    private boolean euN = true;
    private boolean euO = false;
    private long euS = 0;
    private HashMap<String, Boolean> euT = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkApplication.getInst().addRemoteActivity(this);
        setContentView(d.h.image_activity_2);
        setSwipeBackEnabled(false);
        initData(bundle);
        initUI();
        int size = this.eGO.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            String str = this.eGO.get(i);
            if (TextUtils.isEmpty(str) || !str.equals(this.euP)) {
                i++;
            } else {
                this.mIndex = i;
                break;
            }
        }
        this.mCount = size;
        this.mTitle.setVisibility(0);
        ayu();
        this.euK.setIsFromCDN(true);
        this.euK.setAllowLocalUrl(true);
        this.euK.setAssistUrls(this.eGP);
        this.euK.setUrlData(this.eGO);
        this.euK.setCurrentItem(this.mIndex, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.euK.setBackgroundColor(aj.fM(i));
        } else {
            this.euK.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        aj.t(this.mNavigationBar, d.C0140d.common_color_10222);
        getLayoutMode().aM(this.bgK);
        getLayoutMode().aM(this.mTitle);
        getLayoutMode().aM(this.euI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.euK.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.euK.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.euK.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkApplication.getInst().delRemoteActivity(this);
        bZ(this.mIndex, this.mIndex);
        this.euK.onDestroy();
        if (this.eGQ != null) {
            this.eGQ.cancel();
            this.eGQ = null;
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
                if (view == GroupImageActivity.this.bgK) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", GroupImageActivity.this.mIndex);
                        GroupImageActivity.this.setResult(-1, intent);
                        GroupImageActivity.this.finish();
                    }
                } else if (view == GroupImageActivity.this.euI) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Activity pageActivity = GroupImageActivity.this.getPageContext().getPageActivity();
                        if (GroupImageActivity.this.bQQ == null) {
                            GroupImageActivity.this.bQQ = new com.baidu.tbadk.core.util.b.a();
                        }
                        GroupImageActivity.this.bQQ.DI();
                        GroupImageActivity.this.bQQ.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!GroupImageActivity.this.bQQ.v(pageActivity)) {
                            try {
                                byte[] currentImageData = GroupImageActivity.this.euK.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = GroupImageActivity.this.euK.getCurrentImageUrl();
                                    GroupImageActivity.this.eGQ = new a(currentImageUrl, currentImageData);
                                    GroupImageActivity.this.eGQ.execute(new String[0]);
                                    GroupImageActivity.this.eGR.setVisibility(4);
                                    GroupImageActivity.this.showProgressBar();
                                } else {
                                    GroupImageActivity.this.showToast(GroupImageActivity.this.getPageContext().getString(d.j.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (GroupImageActivity.this.euN) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 0) {
                        GroupImageActivity.this.mNavigationBar.setVisibility(0);
                        GroupImageActivity.this.euK.Jl();
                        GroupImageActivity.this.euM = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        GroupImageActivity.this.euM = new AlphaAnimation(1.0f, 0.0f);
                        GroupImageActivity.this.euO = true;
                        GroupImageActivity.this.euK.Jm();
                    }
                    GroupImageActivity.this.euM.setDuration(300L);
                    GroupImageActivity.this.euM.setFillAfter(false);
                    GroupImageActivity.this.euM.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            GroupImageActivity.this.euN = true;
                            if (GroupImageActivity.this.euO) {
                                GroupImageActivity.this.euO = false;
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
                    GroupImageActivity.this.euN = false;
                    GroupImageActivity.this.mNavigationBar.startAnimation(GroupImageActivity.this.euM);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                GroupImageActivity.this.bZ(GroupImageActivity.this.mIndex, i);
                GroupImageActivity.this.mIndex = i;
                GroupImageActivity.this.ayu();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - GroupImageActivity.this.euS > 300000000 && GroupImageActivity.this.eGO != null && GroupImageActivity.this.mIndex < GroupImageActivity.this.eGO.size()) {
                    GroupImageActivity.this.euT.put(GroupImageActivity.this.eGO.get(GroupImageActivity.this.mIndex), true);
                }
            }
        };
        this.euL = new BaseViewPager.a() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void fZ(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0096b interfaceC0096b = new b.InterfaceC0096b() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0096b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar == GroupImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            Activity pageActivity = GroupImageActivity.this.getPageContext().getPageActivity();
                            if (GroupImageActivity.this.bQQ == null) {
                                GroupImageActivity.this.bQQ = new com.baidu.tbadk.core.util.b.a();
                            }
                            GroupImageActivity.this.bQQ.DI();
                            GroupImageActivity.this.bQQ.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!GroupImageActivity.this.bQQ.v(pageActivity)) {
                                try {
                                    byte[] currentImageData = GroupImageActivity.this.euK.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = GroupImageActivity.this.euK.getCurrentImageUrl();
                                        GroupImageActivity.this.eGQ = new a(currentImageUrl, currentImageData);
                                        GroupImageActivity.this.eGQ.execute(new String[0]);
                                        GroupImageActivity.this.eGR.setVisibility(4);
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
                GroupImageActivity.this.createListMenu(new String[]{GroupImageActivity.this.getPageContext().getString(d.j.save)}, interfaceC0096b);
                GroupImageActivity.this.showListMenu();
                return false;
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.euI = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.image_activity_save_button, this.mOnClickListener);
        this.bgK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.mNavigationBar.setTitleText("");
        this.eGR = (TextView) findViewById(d.g.save);
        this.eGR.setClickable(false);
        this.euI.setOnClickListener(this.mOnClickListener);
        if (this.bgK != null) {
            this.bgK.setOnClickListener(this.mOnClickListener);
        }
        this.euK = (MultiImageView) findViewById(d.g.viewpager);
        this.euK.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.euK.aF(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.euK.setOnPageChangeListener(this.mOnPageChangeListener);
        this.euK.setItemOnclickListener(this.mOnClickListener);
        this.euK.setItemOnLongClickListener(onLongClickListener);
        this.euK.setCurrentItem(aFk(), false);
        this.euK.setOnScrollOutListener(this.euL);
        this.euK.setHasNext(false);
        this.euK.setNextTitle("mNextTitle");
        bZ(this.mIndex, this.mIndex);
        this.mTitle.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayu() {
        if (this.eGO != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.euK.getHasNext() && this.mIndex == this.euK.getItemNum() - 1) {
                this.mTitle.setText(getPageContext().getString(d.j.image_recommend));
                this.eGR.setVisibility(4);
                return;
            }
            this.mTitle.setText(valueOf);
            this.eGR.setVisibility(0);
        }
    }

    private int aFk() {
        if (this.eGO != null && this.eGO.size() > 0) {
            int size = this.eGO.size();
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
            this.eGO = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.euP = bundle.getString("curImgUrl");
            this.eGP = (HashMap) bundle.getSerializable("assistUrls");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.eGO = intent.getStringArrayListExtra("url");
                this.euP = intent.getStringExtra("curImgUrl");
                this.eGP = (HashMap) intent.getSerializableExtra("assistUrls");
                this.mIndex = 0;
            }
        }
        this.euT = new HashMap<>();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("url", this.eGO);
        bundle.putInt("index", this.mIndex);
        bundle.putString("curImgUrl", this.euP);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.euK.setCurrentItem(this.mIndex, true);
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
                    return k.BT();
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
            GroupImageActivity.this.eGQ = null;
            GroupImageActivity.this.eGR.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupImageActivity.this.eGQ = null;
            GroupImageActivity.this.eGR.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZ(int i, int i2) {
        synchronized (this.euT) {
            if (System.nanoTime() - this.euS > 300000000 && this.eGO != null && i < this.eGO.size()) {
                this.euT.put(this.eGO.get(i), true);
            }
            this.euS = System.nanoTime();
        }
    }
}
