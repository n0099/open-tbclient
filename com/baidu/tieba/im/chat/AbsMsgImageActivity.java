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
    private FrameLayout gam;
    private String gau;
    private boolean gaz;
    private int mCount;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private LinkedHashMap<String, String> gak = null;
    private int mIndex = 0;
    private a gal = null;
    private View bVY = null;
    private TextView mTextView = null;
    private NavigationBar gan = null;
    private MultiImageView gao = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a gap = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation gaq = null;
    private boolean gar = true;
    private boolean gas = false;
    private String gat = "";
    private String id = "";
    private String gav = "";
    private long gaw = 0;
    private HashMap<String, Boolean> gax = null;
    private int gay = 0;

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
        bpx();
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
        bpx();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.l(this.gao, d.C0236d.black_alpha100);
        al.l(this.gan, d.C0236d.common_color_10222);
        getLayoutMode().onModeChanged(this.bVY);
        getLayoutMode().onModeChanged(this.mTextView);
        getLayoutMode().onModeChanged(this.gam);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.gao.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gao.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.gao.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        bI(this.mIndex, this.mIndex);
        this.gao.onDestroy();
        if (this.gal != null) {
            this.gal.cancel();
            this.gal = null;
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
                    if (AbsMsgImageActivity.this.gan.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view == AbsMsgImageActivity.this.gam) {
                    if (AbsMsgImageActivity.this.gan.getVisibility() != 8) {
                        Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                        if (AbsMsgImageActivity.this.mPermissionJudgement == null) {
                            AbsMsgImageActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                        }
                        AbsMsgImageActivity.this.mPermissionJudgement.adQ();
                        AbsMsgImageActivity.this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!AbsMsgImageActivity.this.mPermissionJudgement.Y(pageActivity)) {
                            try {
                                byte[] currentImageData = AbsMsgImageActivity.this.gao.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.gao.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.gal = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.gal.execute(new String[0]);
                                    AbsMsgImageActivity.this.gam.setClickable(false);
                                } else {
                                    AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(d.j.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (AbsMsgImageActivity.this.gar) {
                    if (AbsMsgImageActivity.this.gan.getVisibility() != 0) {
                        AbsMsgImageActivity.this.gan.setVisibility(0);
                        AbsMsgImageActivity.this.gao.ako();
                        AbsMsgImageActivity.this.gaq = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.gaq = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.gas = true;
                        AbsMsgImageActivity.this.gao.akq();
                    }
                    AbsMsgImageActivity.this.gaq.setDuration(300L);
                    AbsMsgImageActivity.this.gaq.setFillAfter(true);
                    AbsMsgImageActivity.this.gaq.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.gar = true;
                            if (AbsMsgImageActivity.this.gas) {
                                AbsMsgImageActivity.this.gas = false;
                                AbsMsgImageActivity.this.gan.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.gar = false;
                    AbsMsgImageActivity.this.gan.startAnimation(AbsMsgImageActivity.this.gaq);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.bI(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.bgP();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.gaw > 300000000 && AbsMsgImageActivity.this.gak != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.gak.size()) {
                    AbsMsgImageActivity.this.gax.put(AbsMsgImageActivity.this.gak.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.gap = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
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
                                    byte[] currentImageData = AbsMsgImageActivity.this.gao.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = AbsMsgImageActivity.this.gao.getCurrentImageUrl();
                                        AbsMsgImageActivity.this.gal = new a(currentImageUrl, currentImageData);
                                        AbsMsgImageActivity.this.gal.execute(new String[0]);
                                        AbsMsgImageActivity.this.gam.setClickable(false);
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
        this.gan = (NavigationBar) findViewById(d.g.navigation_bar);
        this.gam = (FrameLayout) this.gan.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.image_activity_save_button, this.mOnClickListener);
        if (this.gaz) {
            this.gam.setVisibility(8);
        }
        this.bVY = this.gan.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        al.c(this.gan.getBackImageView(), d.f.icon_return_bg);
        this.mTextView = this.gan.setTitleText("");
        this.gao = (MultiImageView) findViewById(d.g.viewpager);
        this.gao.setPageMargin(l.dip2px(getPageContext().getContext(), 8.0f));
        this.gao.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.gao.setOnPageChangeListener(this.mOnPageChangeListener);
        this.gao.setItemOnclickListener(this.mOnClickListener);
        this.gao.setCurrentItem(bpw(), false);
        this.gao.setOnScrollOutListener(this.gap);
        this.gao.setItemOnLongClickListener(onLongClickListener);
        this.gao.setHasNext(false);
        this.gao.setNextTitle("mNextTitle");
        this.gao.setIsFromCDN(true);
        this.gao.setAllowLocalUrl(true);
        bI(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgP() {
        if (this.gak != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.gao.getHasNext() && this.mIndex == this.gao.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(d.j.image_recommend));
                this.gam.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.gam.setClickable(true);
        }
    }

    private int bpw() {
        if (this.gak != null && this.gak.size() > 0) {
            int size = this.gak.size();
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
            this.gat = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.gau = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.gav = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.gaz = intent.getBooleanExtra("isSingle", false);
            if (this.gav == null) {
                this.gav = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.gat == null) {
                this.gat = "";
            }
            this.gak = new LinkedHashMap<>();
            this.gak.put(this.gav, this.gat);
            this.gay = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.gak = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.gav = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.gay = bundle.getInt("chat_mode", 0);
            this.gaz = bundle.getBoolean("isSingle", false);
            if (this.gav == null) {
                this.gav = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.gax = new HashMap<>();
    }

    private void bpx() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.gaz) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.gat)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.gav, AbsMsgImageActivity.this.gat);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.gau;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.gat, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = AbsMsgImageActivity.this.gav;
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
                    AbsMsgImageActivity.this.bgP();
                    AbsMsgImageActivity.this.gao.setIsFromCDN(true);
                    AbsMsgImageActivity.this.gao.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.gao.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.gao.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.gao.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.gak);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.gav);
        bundle.putInt("chat_mode", this.gay);
        bundle.putBoolean("isSingle", this.gaz);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.gao.setCurrentItem(this.mIndex, true);
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
            AbsMsgImageActivity.this.gal = null;
            AbsMsgImageActivity.this.gam.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.gal = null;
            AbsMsgImageActivity.this.gam.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(int i, int i2) {
        synchronized (this.gax) {
            if (System.nanoTime() - this.gaw > 300000000 && this.gak != null && i < this.gak.size()) {
                this.gax.put(this.gak.get("" + i), true);
            }
            this.gaw = System.nanoTime();
        }
    }
}
