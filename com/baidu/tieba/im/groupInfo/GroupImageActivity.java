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
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class GroupImageActivity extends BaseActivity<GroupImageActivity> {
    private com.baidu.tbadk.core.util.b.a bqO;
    private FrameLayout eqH;
    private String eqO;
    private int mCount;
    private ArrayList<String> eCS = null;
    private HashMap<String, ImageUrlData> eCT = null;
    private int mIndex = 0;
    private a eCU = null;
    private NavigationBar mNavigationBar = null;
    private TextView eCV = null;
    private View aEa = null;
    private TextView mTitle = null;
    private MultiImageView eqJ = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a eqK = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation eqL = null;
    private boolean eqM = true;
    private boolean eqN = false;
    private long eqR = 0;
    private HashMap<String, Boolean> eqS = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkApplication.getInst().addRemoteActivity(this);
        setContentView(e.h.image_activity_2);
        setSwipeBackEnabled(false);
        initData(bundle);
        initUI();
        int size = this.eCS.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            String str = this.eCS.get(i);
            if (TextUtils.isEmpty(str) || !str.equals(this.eqO)) {
                i++;
            } else {
                this.mIndex = i;
                break;
            }
        }
        this.mCount = size;
        this.mTitle.setVisibility(0);
        aAL();
        this.eqJ.setIsFromCDN(true);
        this.eqJ.setAllowLocalUrl(true);
        this.eqJ.setAssistUrls(this.eCT);
        this.eqJ.setUrlData(this.eCS);
        this.eqJ.setCurrentItem(this.mIndex, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.eqJ.setBackgroundColor(al.da(i));
        } else {
            this.eqJ.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        al.j(this.mNavigationBar, e.d.common_color_10222);
        getLayoutMode().onModeChanged(this.aEa);
        getLayoutMode().onModeChanged(this.mTitle);
        getLayoutMode().onModeChanged(this.eqH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eqJ.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eqJ.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.eqJ.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkApplication.getInst().delRemoteActivity(this);
        bi(this.mIndex, this.mIndex);
        this.eqJ.onDestroy();
        if (this.eCU != null) {
            this.eCU.cancel();
            this.eCU = null;
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
                if (view == GroupImageActivity.this.aEa) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", GroupImageActivity.this.mIndex);
                        GroupImageActivity.this.setResult(-1, intent);
                        GroupImageActivity.this.finish();
                    }
                } else if (view == GroupImageActivity.this.eqH) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 8) {
                        Activity pageActivity = GroupImageActivity.this.getPageContext().getPageActivity();
                        if (GroupImageActivity.this.bqO == null) {
                            GroupImageActivity.this.bqO = new com.baidu.tbadk.core.util.b.a();
                        }
                        GroupImageActivity.this.bqO.Bb();
                        GroupImageActivity.this.bqO.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!GroupImageActivity.this.bqO.x(pageActivity)) {
                            try {
                                byte[] currentImageData = GroupImageActivity.this.eqJ.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = GroupImageActivity.this.eqJ.getCurrentImageUrl();
                                    GroupImageActivity.this.eCU = new a(currentImageUrl, currentImageData);
                                    GroupImageActivity.this.eCU.execute(new String[0]);
                                    GroupImageActivity.this.eCV.setVisibility(4);
                                    GroupImageActivity.this.showProgressBar();
                                } else {
                                    GroupImageActivity.this.showToast(GroupImageActivity.this.getPageContext().getString(e.j.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (GroupImageActivity.this.eqM) {
                    if (GroupImageActivity.this.mNavigationBar.getVisibility() != 0) {
                        GroupImageActivity.this.mNavigationBar.setVisibility(0);
                        GroupImageActivity.this.eqJ.He();
                        GroupImageActivity.this.eqL = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        GroupImageActivity.this.eqL = new AlphaAnimation(1.0f, 0.0f);
                        GroupImageActivity.this.eqN = true;
                        GroupImageActivity.this.eqJ.Hf();
                    }
                    GroupImageActivity.this.eqL.setDuration(300L);
                    GroupImageActivity.this.eqL.setFillAfter(false);
                    GroupImageActivity.this.eqL.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            GroupImageActivity.this.eqM = true;
                            if (GroupImageActivity.this.eqN) {
                                GroupImageActivity.this.eqN = false;
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
                    GroupImageActivity.this.eqM = false;
                    GroupImageActivity.this.mNavigationBar.startAnimation(GroupImageActivity.this.eqL);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                GroupImageActivity.this.bi(GroupImageActivity.this.mIndex, i);
                GroupImageActivity.this.mIndex = i;
                GroupImageActivity.this.aAL();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - GroupImageActivity.this.eqR > 300000000 && GroupImageActivity.this.eCS != null && GroupImageActivity.this.mIndex < GroupImageActivity.this.eCS.size()) {
                    GroupImageActivity.this.eqS.put(GroupImageActivity.this.eCS.get(GroupImageActivity.this.mIndex), true);
                }
            }
        };
        this.eqK = new BaseViewPager.a() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void dp(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0100b interfaceC0100b = new b.InterfaceC0100b() { // from class: com.baidu.tieba.im.groupInfo.GroupImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0100b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar == GroupImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            Activity pageActivity = GroupImageActivity.this.getPageContext().getPageActivity();
                            if (GroupImageActivity.this.bqO == null) {
                                GroupImageActivity.this.bqO = new com.baidu.tbadk.core.util.b.a();
                            }
                            GroupImageActivity.this.bqO.Bb();
                            GroupImageActivity.this.bqO.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!GroupImageActivity.this.bqO.x(pageActivity)) {
                                try {
                                    byte[] currentImageData = GroupImageActivity.this.eqJ.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = GroupImageActivity.this.eqJ.getCurrentImageUrl();
                                        GroupImageActivity.this.eCU = new a(currentImageUrl, currentImageData);
                                        GroupImageActivity.this.eCU.execute(new String[0]);
                                        GroupImageActivity.this.eCV.setVisibility(4);
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
                GroupImageActivity.this.createListMenu(new String[]{GroupImageActivity.this.getPageContext().getString(e.j.save)}, interfaceC0100b);
                GroupImageActivity.this.showListMenu();
                return false;
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(e.g.navigation_bar);
        this.eqH = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.image_activity_save_button, this.mOnClickListener);
        this.aEa = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.mNavigationBar.setTitleText("");
        this.eCV = (TextView) findViewById(e.g.save);
        this.eCV.setClickable(false);
        this.eqH.setOnClickListener(this.mOnClickListener);
        if (this.aEa != null) {
            this.aEa.setOnClickListener(this.mOnClickListener);
        }
        this.eqJ = (MultiImageView) findViewById(e.g.viewpager);
        this.eqJ.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.eqJ.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.eqJ.setOnPageChangeListener(this.mOnPageChangeListener);
        this.eqJ.setItemOnclickListener(this.mOnClickListener);
        this.eqJ.setItemOnLongClickListener(onLongClickListener);
        this.eqJ.setCurrentItem(aIX(), false);
        this.eqJ.setOnScrollOutListener(this.eqK);
        this.eqJ.setHasNext(false);
        this.eqJ.setNextTitle("mNextTitle");
        bi(this.mIndex, this.mIndex);
        this.mTitle.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAL() {
        if (this.eCS != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.eqJ.getHasNext() && this.mIndex == this.eqJ.getItemNum() - 1) {
                this.mTitle.setText(getPageContext().getString(e.j.image_recommend));
                this.eCV.setVisibility(4);
                return;
            }
            this.mTitle.setText(valueOf);
            this.eCV.setVisibility(0);
        }
    }

    private int aIX() {
        if (this.eCS != null && this.eCS.size() > 0) {
            int size = this.eCS.size();
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
            this.eCS = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.eqO = bundle.getString("curImgUrl");
            this.eCT = (HashMap) bundle.getSerializable("assistUrls");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.eCS = intent.getStringArrayListExtra("url");
                this.eqO = intent.getStringExtra("curImgUrl");
                this.eCT = (HashMap) intent.getSerializableExtra("assistUrls");
                this.mIndex = 0;
            }
        }
        this.eqS = new HashMap<>();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("url", this.eCS);
        bundle.putInt("index", this.mIndex);
        bundle.putString("curImgUrl", this.eqO);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.eqJ.setCurrentItem(this.mIndex, true);
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
                    return com.baidu.tbadk.core.util.l.zo();
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
            GroupImageActivity.this.eCU = null;
            GroupImageActivity.this.eCV.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupImageActivity.this.eCU = null;
            GroupImageActivity.this.eCV.setVisibility(0);
            GroupImageActivity.this.hideProgressBar();
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bi(int i, int i2) {
        synchronized (this.eqS) {
            if (System.nanoTime() - this.eqR > 300000000 && this.eCS != null && i < this.eCS.size()) {
                this.eqS.put(this.eCS.get(i), true);
            }
            this.eqR = System.nanoTime();
        }
    }
}
