package com.baidu.tieba.im.chat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AbsMsgImageActivityConfig;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public abstract class AbsMsgImageActivity extends BaseActivity<AbsMsgImageActivity> {
    private String krC;
    private boolean krG;
    private FrameLayout kru;
    private int mCount;
    private PermissionJudgePolicy mPermissionJudgement;
    private LinkedHashMap<String, String> krs = null;
    private int mIndex = 0;
    private a krt = null;
    private View mBack = null;
    private TextView mTextView = null;
    private NavigationBar krv = null;
    private MultiImageView krw = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a krx = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation kry = null;
    private boolean krz = true;
    private boolean krA = false;
    private String krB = "";
    private String id = "";
    private String uniqueId = "";
    private long krD = 0;
    private HashMap<String, Boolean> krE = null;
    private int krF = 0;

    protected abstract void a(String str, com.baidu.tieba.im.sendmessage.c cVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(R.layout.image_activity_2);
        initData(bundle);
        initUI();
        cSr();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        cSr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ao.setBackgroundColor(this.krw, R.color.black_alpha100);
        ao.setBackgroundColor(this.krv, R.color.common_color_10222);
        getLayoutMode().onModeChanged(this.mBack);
        getLayoutMode().onModeChanged(this.mTextView);
        getLayoutMode().onModeChanged(this.kru);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.krw.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.krw.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.krw.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        cS(this.mIndex, this.mIndex);
        this.krw.onDestroy();
        if (this.krt != null) {
            this.krt.cancel();
            this.krt = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.getInst().delRemoteActivity(this);
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
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == AbsMsgImageActivity.this.mBack) {
                    if (AbsMsgImageActivity.this.krv.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view == AbsMsgImageActivity.this.kru) {
                    if (AbsMsgImageActivity.this.krv.getVisibility() != 8) {
                        Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                        if (AbsMsgImageActivity.this.mPermissionJudgement == null) {
                            AbsMsgImageActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        AbsMsgImageActivity.this.mPermissionJudgement.clearRequestPermissionList();
                        AbsMsgImageActivity.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!AbsMsgImageActivity.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                            try {
                                byte[] currentImageData = AbsMsgImageActivity.this.krw.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.krw.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.krt = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.krt.execute(new String[0]);
                                    AbsMsgImageActivity.this.kru.setClickable(false);
                                } else {
                                    AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(R.string.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (AbsMsgImageActivity.this.krz) {
                    if (AbsMsgImageActivity.this.krv.getVisibility() != 0) {
                        AbsMsgImageActivity.this.krv.setVisibility(0);
                        AbsMsgImageActivity.this.krw.bzj();
                        AbsMsgImageActivity.this.kry = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.kry = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.krA = true;
                        AbsMsgImageActivity.this.krw.bzl();
                    }
                    AbsMsgImageActivity.this.kry.setDuration(300L);
                    AbsMsgImageActivity.this.kry.setFillAfter(true);
                    AbsMsgImageActivity.this.kry.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.krz = true;
                            if (AbsMsgImageActivity.this.krA) {
                                AbsMsgImageActivity.this.krA = false;
                                AbsMsgImageActivity.this.krv.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.krz = false;
                    AbsMsgImageActivity.this.krv.startAnimation(AbsMsgImageActivity.this.kry);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.cS(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.cHj();
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.krD > 300000000 && AbsMsgImageActivity.this.krs != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.krs.size()) {
                    AbsMsgImageActivity.this.krE.put(AbsMsgImageActivity.this.krs.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.krx = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void onScrollOut(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0561b interfaceC0561b = new b.InterfaceC0561b() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0561b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar == AbsMsgImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            try {
                                Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                                if (AbsMsgImageActivity.this.mPermissionJudgement == null) {
                                    AbsMsgImageActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                                }
                                AbsMsgImageActivity.this.mPermissionJudgement.clearRequestPermissionList();
                                AbsMsgImageActivity.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                                if (!AbsMsgImageActivity.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                                    byte[] currentImageData = AbsMsgImageActivity.this.krw.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = AbsMsgImageActivity.this.krw.getCurrentImageUrl();
                                        AbsMsgImageActivity.this.krt = new a(currentImageUrl, currentImageData);
                                        AbsMsgImageActivity.this.krt.execute(new String[0]);
                                        AbsMsgImageActivity.this.kru.setClickable(false);
                                        break;
                                    } else {
                                        AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(R.string.no_data));
                                        break;
                                    }
                                } else {
                                    return;
                                }
                            } catch (Exception e) {
                                break;
                            }
                    }
                    bVar.dismiss();
                }
            }
        };
        View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                AbsMsgImageActivity.this.createListMenu(new String[]{AbsMsgImageActivity.this.getPageContext().getString(R.string.save)}, interfaceC0561b);
                AbsMsgImageActivity.this.showListMenu();
                return false;
            }
        };
        this.krv = (NavigationBar) findViewById(R.id.navigation_bar);
        this.kru = (FrameLayout) this.krv.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, this.mOnClickListener);
        if (this.krG) {
            this.kru.setVisibility(8);
        }
        this.mBack = this.krv.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        ao.setImageResource(this.krv.getBackImageView(), R.drawable.icon_return_bg);
        this.mTextView = this.krv.setTitleText("");
        this.krw = (MultiImageView) findViewById(R.id.viewpager);
        this.krw.setPageMargin(l.dip2px(getPageContext().getContext(), 8.0f));
        this.krw.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.krw.setOnPageChangeListener(this.mOnPageChangeListener);
        this.krw.setItemOnclickListener(this.mOnClickListener);
        this.krw.setCurrentItem(cSq(), false);
        this.krw.setOnScrollOutListener(this.krx);
        this.krw.setItemOnLongClickListener(onLongClickListener);
        this.krw.setHasNext(false);
        this.krw.setNextTitle("mNextTitle");
        this.krw.setIsFromCDN(true);
        this.krw.setAllowLocalUrl(true);
        cS(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHj() {
        if (this.krs != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.krw.getHasNext() && this.mIndex == this.krw.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(R.string.image_recommend));
                this.kru.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.kru.setClickable(true);
        }
    }

    private int cSq() {
        if (this.krs != null && this.krs.size() > 0) {
            int size = this.krs.size();
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
        Intent intent = getIntent();
        if (intent != null) {
            this.krB = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.krC = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.uniqueId = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.krG = intent.getBooleanExtra("isSingle", false);
            if (this.uniqueId == null) {
                this.uniqueId = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.krB == null) {
                this.krB = "";
            }
            this.krs = new LinkedHashMap<>();
            this.krs.put(this.uniqueId, this.krB);
            this.krF = intent.getIntExtra(TbEnum.ParamKey.CHAT_MODE, 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.krs = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.uniqueId = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.krF = bundle.getInt(TbEnum.ParamKey.CHAT_MODE, 0);
            this.krG = bundle.getBoolean("isSingle", false);
            if (this.uniqueId == null) {
                this.uniqueId = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.krE = new HashMap<>();
    }

    private void cSr() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.krG) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.krB)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.uniqueId, AbsMsgImageActivity.this.krB);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.krC;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.krB, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = AbsMsgImageActivity.this.uniqueId;
                    Iterator<String> it = linkedHashMap.keySet().iterator();
                    int i = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        String next = it.next();
                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(next) && next.equals(str)) {
                            AbsMsgImageActivity.this.mIndex = i;
                            z = true;
                            break;
                        }
                        i++;
                    }
                    AbsMsgImageActivity.this.mCount = linkedHashMap.size();
                    if (!z) {
                        AbsMsgImageActivity.this.mIndex = AbsMsgImageActivity.this.mCount - 1;
                    }
                    AbsMsgImageActivity.this.mTextView.setVisibility(0);
                    AbsMsgImageActivity.this.cHj();
                    AbsMsgImageActivity.this.krw.setIsFromCDN(true);
                    AbsMsgImageActivity.this.krw.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.krw.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.krw.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.krw.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.krs);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.uniqueId);
        bundle.putInt(TbEnum.ParamKey.CHAT_MODE, this.krF);
        bundle.putBoolean("isSingle", this.krG);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.krw.setCurrentItem(this.mIndex, true);
    }

    /* loaded from: classes.dex */
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
            switch (n.saveImageFileByUser(this.mUrl, this.mData, AbsMsgImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return n.getSdErrorString();
                case -1:
                default:
                    return AbsMsgImageActivity.this.getPageContext().getString(R.string.save_fail);
                case 0:
                    return AbsMsgImageActivity.this.getPageContext().getString(R.string.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            AbsMsgImageActivity.this.krt = null;
            AbsMsgImageActivity.this.kru.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.krt = null;
            AbsMsgImageActivity.this.kru.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cS(int i, int i2) {
        synchronized (this.krE) {
            if (System.nanoTime() - this.krD > 300000000 && this.krs != null && i < this.krs.size()) {
                this.krE.put(this.krs.get("" + i), true);
            }
            this.krD = System.nanoTime();
        }
    }
}
