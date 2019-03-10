package com.baidu.tieba.im.chat;

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
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AbsMsgImageActivityConfig;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public abstract class AbsMsgImageActivity extends BaseActivity<AbsMsgImageActivity> {
    private boolean gaA;
    private FrameLayout gan;
    private String gav;
    private int mCount;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private LinkedHashMap<String, String> gal = null;
    private int mIndex = 0;
    private a gam = null;
    private View bVY = null;
    private TextView mTextView = null;
    private NavigationBar gao = null;
    private MultiImageView gap = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a gaq = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation gar = null;
    private boolean gas = true;
    private boolean gat = false;
    private String gau = "";
    private String id = "";
    private String gaw = "";
    private long gax = 0;
    private HashMap<String, Boolean> gay = null;
    private int gaz = 0;

    protected abstract void a(String str, com.baidu.tieba.im.sendmessage.c cVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(d.h.image_activity_2);
        initData(bundle);
        initUI();
        bpy();
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
        bpy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.l(this.gap, d.C0236d.black_alpha100);
        al.l(this.gao, d.C0236d.common_color_10222);
        getLayoutMode().onModeChanged(this.bVY);
        getLayoutMode().onModeChanged(this.mTextView);
        getLayoutMode().onModeChanged(this.gan);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.gap.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gap.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.gap.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        bI(this.mIndex, this.mIndex);
        this.gap.onDestroy();
        if (this.gam != null) {
            this.gam.cancel();
            this.gam = null;
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
                if (view == AbsMsgImageActivity.this.bVY) {
                    if (AbsMsgImageActivity.this.gao.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view == AbsMsgImageActivity.this.gan) {
                    if (AbsMsgImageActivity.this.gao.getVisibility() != 8) {
                        Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                        if (AbsMsgImageActivity.this.mPermissionJudgement == null) {
                            AbsMsgImageActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                        }
                        AbsMsgImageActivity.this.mPermissionJudgement.adQ();
                        AbsMsgImageActivity.this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!AbsMsgImageActivity.this.mPermissionJudgement.Y(pageActivity)) {
                            try {
                                byte[] currentImageData = AbsMsgImageActivity.this.gap.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.gap.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.gam = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.gam.execute(new String[0]);
                                    AbsMsgImageActivity.this.gan.setClickable(false);
                                } else {
                                    AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(d.j.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (AbsMsgImageActivity.this.gas) {
                    if (AbsMsgImageActivity.this.gao.getVisibility() != 0) {
                        AbsMsgImageActivity.this.gao.setVisibility(0);
                        AbsMsgImageActivity.this.gap.ako();
                        AbsMsgImageActivity.this.gar = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.gar = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.gat = true;
                        AbsMsgImageActivity.this.gap.akq();
                    }
                    AbsMsgImageActivity.this.gar.setDuration(300L);
                    AbsMsgImageActivity.this.gar.setFillAfter(true);
                    AbsMsgImageActivity.this.gar.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.gas = true;
                            if (AbsMsgImageActivity.this.gat) {
                                AbsMsgImageActivity.this.gat = false;
                                AbsMsgImageActivity.this.gao.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.gas = false;
                    AbsMsgImageActivity.this.gao.startAnimation(AbsMsgImageActivity.this.gar);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.bI(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.bgQ();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.gax > 300000000 && AbsMsgImageActivity.this.gal != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.gal.size()) {
                    AbsMsgImageActivity.this.gay.put(AbsMsgImageActivity.this.gal.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.gaq = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void hF(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0191b interfaceC0191b = new b.InterfaceC0191b() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0191b
            public void a(b bVar, int i, View view) {
                if (bVar == AbsMsgImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            try {
                                Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                                if (AbsMsgImageActivity.this.mPermissionJudgement == null) {
                                    AbsMsgImageActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                                }
                                AbsMsgImageActivity.this.mPermissionJudgement.adQ();
                                AbsMsgImageActivity.this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                                if (!AbsMsgImageActivity.this.mPermissionJudgement.Y(pageActivity)) {
                                    byte[] currentImageData = AbsMsgImageActivity.this.gap.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = AbsMsgImageActivity.this.gap.getCurrentImageUrl();
                                        AbsMsgImageActivity.this.gam = new a(currentImageUrl, currentImageData);
                                        AbsMsgImageActivity.this.gam.execute(new String[0]);
                                        AbsMsgImageActivity.this.gan.setClickable(false);
                                        break;
                                    } else {
                                        AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(d.j.no_data));
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
                AbsMsgImageActivity.this.createListMenu(new String[]{AbsMsgImageActivity.this.getPageContext().getString(d.j.save)}, interfaceC0191b);
                AbsMsgImageActivity.this.showListMenu();
                return false;
            }
        };
        this.gao = (NavigationBar) findViewById(d.g.navigation_bar);
        this.gan = (FrameLayout) this.gao.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.image_activity_save_button, this.mOnClickListener);
        if (this.gaA) {
            this.gan.setVisibility(8);
        }
        this.bVY = this.gao.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        al.c(this.gao.getBackImageView(), d.f.icon_return_bg);
        this.mTextView = this.gao.setTitleText("");
        this.gap = (MultiImageView) findViewById(d.g.viewpager);
        this.gap.setPageMargin(l.dip2px(getPageContext().getContext(), 8.0f));
        this.gap.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.gap.setOnPageChangeListener(this.mOnPageChangeListener);
        this.gap.setItemOnclickListener(this.mOnClickListener);
        this.gap.setCurrentItem(bpx(), false);
        this.gap.setOnScrollOutListener(this.gaq);
        this.gap.setItemOnLongClickListener(onLongClickListener);
        this.gap.setHasNext(false);
        this.gap.setNextTitle("mNextTitle");
        this.gap.setIsFromCDN(true);
        this.gap.setAllowLocalUrl(true);
        bI(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgQ() {
        if (this.gal != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.gap.getHasNext() && this.mIndex == this.gap.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(d.j.image_recommend));
                this.gan.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.gan.setClickable(true);
        }
    }

    private int bpx() {
        if (this.gal != null && this.gal.size() > 0) {
            int size = this.gal.size();
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
            this.gau = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.gav = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.gaw = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.gaA = intent.getBooleanExtra("isSingle", false);
            if (this.gaw == null) {
                this.gaw = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.gau == null) {
                this.gau = "";
            }
            this.gal = new LinkedHashMap<>();
            this.gal.put(this.gaw, this.gau);
            this.gaz = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.gal = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.gaw = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.gaz = bundle.getInt("chat_mode", 0);
            this.gaA = bundle.getBoolean("isSingle", false);
            if (this.gaw == null) {
                this.gaw = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.gay = new HashMap<>();
    }

    private void bpy() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.gaA) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.gau)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.gaw, AbsMsgImageActivity.this.gau);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.gav;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.gau, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = AbsMsgImageActivity.this.gaw;
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
                    AbsMsgImageActivity.this.bgQ();
                    AbsMsgImageActivity.this.gap.setIsFromCDN(true);
                    AbsMsgImageActivity.this.gap.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.gap.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.gap.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.gap.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.gal);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.gaw);
        bundle.putInt("chat_mode", this.gaz);
        bundle.putBoolean("isSingle", this.gaA);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.gap.setCurrentItem(this.mIndex, true);
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
            switch (m.a(this.mUrl, this.mData, AbsMsgImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return m.ace();
                case -1:
                default:
                    return AbsMsgImageActivity.this.getPageContext().getString(d.j.save_fail);
                case 0:
                    return AbsMsgImageActivity.this.getPageContext().getString(d.j.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            AbsMsgImageActivity.this.gam = null;
            AbsMsgImageActivity.this.gan.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.gam = null;
            AbsMsgImageActivity.this.gan.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(int i, int i2) {
        synchronized (this.gay) {
            if (System.nanoTime() - this.gax > 300000000 && this.gal != null && i < this.gal.size()) {
                this.gay.put(this.gal.get("" + i), true);
            }
            this.gax = System.nanoTime();
        }
    }
}
