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
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public abstract class AbsMsgImageActivity extends BaseActivity<AbsMsgImageActivity> {
    private com.baidu.tbadk.core.util.b.a bzf;
    private FrameLayout eGH;
    private String eGP;
    private boolean eGU;
    private int mCount;
    private LinkedHashMap<String, String> eGF = null;
    private int mIndex = 0;
    private a eGG = null;
    private View aMU = null;
    private TextView mTextView = null;
    private NavigationBar eGI = null;
    private MultiImageView eGJ = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a eGK = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation eGL = null;
    private boolean eGM = true;
    private boolean eGN = false;
    private String eGO = "";
    private String id = "";
    private String eGQ = "";
    private long eGR = 0;
    private HashMap<String, Boolean> eGS = null;
    private int eGT = 0;

    protected abstract void a(String str, com.baidu.tieba.im.sendmessage.c cVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(e.h.image_activity_2);
        initData(bundle);
        initUI();
        aNF();
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
        aNF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.j(this.eGJ, e.d.black_alpha100);
        al.j(this.eGI, e.d.common_color_10222);
        getLayoutMode().onModeChanged(this.aMU);
        getLayoutMode().onModeChanged(this.mTextView);
        getLayoutMode().onModeChanged(this.eGH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eGJ.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eGJ.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.eGJ.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        bl(this.mIndex, this.mIndex);
        this.eGJ.onDestroy();
        if (this.eGG != null) {
            this.eGG.cancel();
            this.eGG = null;
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
                if (view == AbsMsgImageActivity.this.aMU) {
                    if (AbsMsgImageActivity.this.eGI.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view == AbsMsgImageActivity.this.eGH) {
                    if (AbsMsgImageActivity.this.eGI.getVisibility() != 8) {
                        Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                        if (AbsMsgImageActivity.this.bzf == null) {
                            AbsMsgImageActivity.this.bzf = new com.baidu.tbadk.core.util.b.a();
                        }
                        AbsMsgImageActivity.this.bzf.Et();
                        AbsMsgImageActivity.this.bzf.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!AbsMsgImageActivity.this.bzf.A(pageActivity)) {
                            try {
                                byte[] currentImageData = AbsMsgImageActivity.this.eGJ.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.eGJ.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.eGG = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.eGG.execute(new String[0]);
                                    AbsMsgImageActivity.this.eGH.setClickable(false);
                                } else {
                                    AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(e.j.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (AbsMsgImageActivity.this.eGM) {
                    if (AbsMsgImageActivity.this.eGI.getVisibility() != 0) {
                        AbsMsgImageActivity.this.eGI.setVisibility(0);
                        AbsMsgImageActivity.this.eGJ.Kv();
                        AbsMsgImageActivity.this.eGL = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.eGL = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.eGN = true;
                        AbsMsgImageActivity.this.eGJ.Kw();
                    }
                    AbsMsgImageActivity.this.eGL.setDuration(300L);
                    AbsMsgImageActivity.this.eGL.setFillAfter(true);
                    AbsMsgImageActivity.this.eGL.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.eGM = true;
                            if (AbsMsgImageActivity.this.eGN) {
                                AbsMsgImageActivity.this.eGN = false;
                                AbsMsgImageActivity.this.eGI.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.eGM = false;
                    AbsMsgImageActivity.this.eGI.startAnimation(AbsMsgImageActivity.this.eGL);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.bl(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.aFl();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.eGR > 300000000 && AbsMsgImageActivity.this.eGF != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.eGF.size()) {
                    AbsMsgImageActivity.this.eGS.put(AbsMsgImageActivity.this.eGF.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.eGK = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void eb(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0158b interfaceC0158b = new b.InterfaceC0158b() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar == AbsMsgImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            try {
                                Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                                if (AbsMsgImageActivity.this.bzf == null) {
                                    AbsMsgImageActivity.this.bzf = new com.baidu.tbadk.core.util.b.a();
                                }
                                AbsMsgImageActivity.this.bzf.Et();
                                AbsMsgImageActivity.this.bzf.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                                if (!AbsMsgImageActivity.this.bzf.A(pageActivity)) {
                                    byte[] currentImageData = AbsMsgImageActivity.this.eGJ.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = AbsMsgImageActivity.this.eGJ.getCurrentImageUrl();
                                        AbsMsgImageActivity.this.eGG = new a(currentImageUrl, currentImageData);
                                        AbsMsgImageActivity.this.eGG.execute(new String[0]);
                                        AbsMsgImageActivity.this.eGH.setClickable(false);
                                        break;
                                    } else {
                                        AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(e.j.no_data));
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
                AbsMsgImageActivity.this.createListMenu(new String[]{AbsMsgImageActivity.this.getPageContext().getString(e.j.save)}, interfaceC0158b);
                AbsMsgImageActivity.this.showListMenu();
                return false;
            }
        };
        this.eGI = (NavigationBar) findViewById(e.g.navigation_bar);
        this.eGH = (FrameLayout) this.eGI.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.image_activity_save_button, this.mOnClickListener);
        if (this.eGU) {
            this.eGH.setVisibility(8);
        }
        this.aMU = this.eGI.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        al.c(this.eGI.getBackImageView(), e.f.icon_return_bg);
        this.mTextView = this.eGI.setTitleText("");
        this.eGJ = (MultiImageView) findViewById(e.g.viewpager);
        this.eGJ.setPageMargin(l.dip2px(getPageContext().getContext(), 8.0f));
        this.eGJ.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.eGJ.setOnPageChangeListener(this.mOnPageChangeListener);
        this.eGJ.setItemOnclickListener(this.mOnClickListener);
        this.eGJ.setCurrentItem(aNE(), false);
        this.eGJ.setOnScrollOutListener(this.eGK);
        this.eGJ.setItemOnLongClickListener(onLongClickListener);
        this.eGJ.setHasNext(false);
        this.eGJ.setNextTitle("mNextTitle");
        this.eGJ.setIsFromCDN(true);
        this.eGJ.setAllowLocalUrl(true);
        bl(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFl() {
        if (this.eGF != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.eGJ.getHasNext() && this.mIndex == this.eGJ.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(e.j.image_recommend));
                this.eGH.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.eGH.setClickable(true);
        }
    }

    private int aNE() {
        if (this.eGF != null && this.eGF.size() > 0) {
            int size = this.eGF.size();
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
            this.eGO = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.eGP = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.eGQ = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.eGU = intent.getBooleanExtra("isSingle", false);
            if (this.eGQ == null) {
                this.eGQ = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.eGO == null) {
                this.eGO = "";
            }
            this.eGF = new LinkedHashMap<>();
            this.eGF.put(this.eGQ, this.eGO);
            this.eGT = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.eGF = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.eGQ = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.eGT = bundle.getInt("chat_mode", 0);
            this.eGU = bundle.getBoolean("isSingle", false);
            if (this.eGQ == null) {
                this.eGQ = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.eGS = new HashMap<>();
    }

    private void aNF() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.eGU) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.eGO)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.eGQ, AbsMsgImageActivity.this.eGO);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.eGP;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.eGO, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = AbsMsgImageActivity.this.eGQ;
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
                    AbsMsgImageActivity.this.aFl();
                    AbsMsgImageActivity.this.eGJ.setIsFromCDN(true);
                    AbsMsgImageActivity.this.eGJ.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.eGJ.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.eGJ.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.eGJ.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.eGF);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.eGQ);
        bundle.putInt("chat_mode", this.eGT);
        bundle.putBoolean("isSingle", this.eGU);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.eGJ.setCurrentItem(this.mIndex, true);
    }

    /* loaded from: classes6.dex */
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
            switch (com.baidu.tbadk.core.util.l.a(this.mUrl, this.mData, AbsMsgImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.l.CH();
                case -1:
                default:
                    return AbsMsgImageActivity.this.getPageContext().getString(e.j.save_fail);
                case 0:
                    return AbsMsgImageActivity.this.getPageContext().getString(e.j.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            AbsMsgImageActivity.this.eGG = null;
            AbsMsgImageActivity.this.eGH.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.eGG = null;
            AbsMsgImageActivity.this.eGH.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bl(int i, int i2) {
        synchronized (this.eGS) {
            if (System.nanoTime() - this.eGR > 300000000 && this.eGF != null && i < this.eGF.size()) {
                this.eGS.put(this.eGF.get("" + i), true);
            }
            this.eGR = System.nanoTime();
        }
    }
}
