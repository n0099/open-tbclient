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
    private com.baidu.tbadk.core.util.b.a bvI;
    private String eAa;
    private boolean eAf;
    private FrameLayout ezS;
    private int mCount;
    private LinkedHashMap<String, String> ezQ = null;
    private int mIndex = 0;
    private a ezR = null;
    private View aJu = null;
    private TextView mTextView = null;
    private NavigationBar ezT = null;
    private MultiImageView ezU = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a ezV = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation ezW = null;
    private boolean ezX = true;
    private boolean ezY = false;
    private String ezZ = "";
    private String id = "";
    private String eAb = "";
    private long eAc = 0;
    private HashMap<String, Boolean> eAd = null;
    private int eAe = 0;

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
        aLN();
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
        aLN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.j(this.ezU, e.d.black_alpha100);
        al.j(this.ezT, e.d.common_color_10222);
        getLayoutMode().onModeChanged(this.aJu);
        getLayoutMode().onModeChanged(this.mTextView);
        getLayoutMode().onModeChanged(this.ezS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.ezU.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.ezU.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.ezU.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        bn(this.mIndex, this.mIndex);
        this.ezU.onDestroy();
        if (this.ezR != null) {
            this.ezR.cancel();
            this.ezR = null;
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
                if (view == AbsMsgImageActivity.this.aJu) {
                    if (AbsMsgImageActivity.this.ezT.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view == AbsMsgImageActivity.this.ezS) {
                    if (AbsMsgImageActivity.this.ezT.getVisibility() != 8) {
                        Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                        if (AbsMsgImageActivity.this.bvI == null) {
                            AbsMsgImageActivity.this.bvI = new com.baidu.tbadk.core.util.b.a();
                        }
                        AbsMsgImageActivity.this.bvI.Dp();
                        AbsMsgImageActivity.this.bvI.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!AbsMsgImageActivity.this.bvI.A(pageActivity)) {
                            try {
                                byte[] currentImageData = AbsMsgImageActivity.this.ezU.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.ezU.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.ezR = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.ezR.execute(new String[0]);
                                    AbsMsgImageActivity.this.ezS.setClickable(false);
                                } else {
                                    AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(e.j.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (AbsMsgImageActivity.this.ezX) {
                    if (AbsMsgImageActivity.this.ezT.getVisibility() != 0) {
                        AbsMsgImageActivity.this.ezT.setVisibility(0);
                        AbsMsgImageActivity.this.ezU.Jr();
                        AbsMsgImageActivity.this.ezW = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.ezW = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.ezY = true;
                        AbsMsgImageActivity.this.ezU.Js();
                    }
                    AbsMsgImageActivity.this.ezW.setDuration(300L);
                    AbsMsgImageActivity.this.ezW.setFillAfter(true);
                    AbsMsgImageActivity.this.ezW.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.ezX = true;
                            if (AbsMsgImageActivity.this.ezY) {
                                AbsMsgImageActivity.this.ezY = false;
                                AbsMsgImageActivity.this.ezT.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.ezX = false;
                    AbsMsgImageActivity.this.ezT.startAnimation(AbsMsgImageActivity.this.ezW);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.bn(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.aDz();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.eAc > 300000000 && AbsMsgImageActivity.this.ezQ != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.ezQ.size()) {
                    AbsMsgImageActivity.this.eAd.put(AbsMsgImageActivity.this.ezQ.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.ezV = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void dN(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0148b interfaceC0148b = new b.InterfaceC0148b() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0148b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar == AbsMsgImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            try {
                                Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                                if (AbsMsgImageActivity.this.bvI == null) {
                                    AbsMsgImageActivity.this.bvI = new com.baidu.tbadk.core.util.b.a();
                                }
                                AbsMsgImageActivity.this.bvI.Dp();
                                AbsMsgImageActivity.this.bvI.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                                if (!AbsMsgImageActivity.this.bvI.A(pageActivity)) {
                                    byte[] currentImageData = AbsMsgImageActivity.this.ezU.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = AbsMsgImageActivity.this.ezU.getCurrentImageUrl();
                                        AbsMsgImageActivity.this.ezR = new a(currentImageUrl, currentImageData);
                                        AbsMsgImageActivity.this.ezR.execute(new String[0]);
                                        AbsMsgImageActivity.this.ezS.setClickable(false);
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
                AbsMsgImageActivity.this.createListMenu(new String[]{AbsMsgImageActivity.this.getPageContext().getString(e.j.save)}, interfaceC0148b);
                AbsMsgImageActivity.this.showListMenu();
                return false;
            }
        };
        this.ezT = (NavigationBar) findViewById(e.g.navigation_bar);
        this.ezS = (FrameLayout) this.ezT.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.image_activity_save_button, this.mOnClickListener);
        if (this.eAf) {
            this.ezS.setVisibility(8);
        }
        this.aJu = this.ezT.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        al.c(this.ezT.getBackImageView(), e.f.icon_return_bg);
        this.mTextView = this.ezT.setTitleText("");
        this.ezU = (MultiImageView) findViewById(e.g.viewpager);
        this.ezU.setPageMargin(l.dip2px(getPageContext().getContext(), 8.0f));
        this.ezU.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.ezU.setOnPageChangeListener(this.mOnPageChangeListener);
        this.ezU.setItemOnclickListener(this.mOnClickListener);
        this.ezU.setCurrentItem(aLM(), false);
        this.ezU.setOnScrollOutListener(this.ezV);
        this.ezU.setItemOnLongClickListener(onLongClickListener);
        this.ezU.setHasNext(false);
        this.ezU.setNextTitle("mNextTitle");
        this.ezU.setIsFromCDN(true);
        this.ezU.setAllowLocalUrl(true);
        bn(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDz() {
        if (this.ezQ != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.ezU.getHasNext() && this.mIndex == this.ezU.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(e.j.image_recommend));
                this.ezS.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.ezS.setClickable(true);
        }
    }

    private int aLM() {
        if (this.ezQ != null && this.ezQ.size() > 0) {
            int size = this.ezQ.size();
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
            this.ezZ = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.eAa = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.eAb = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.eAf = intent.getBooleanExtra("isSingle", false);
            if (this.eAb == null) {
                this.eAb = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.ezZ == null) {
                this.ezZ = "";
            }
            this.ezQ = new LinkedHashMap<>();
            this.ezQ.put(this.eAb, this.ezZ);
            this.eAe = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.ezQ = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.eAb = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.eAe = bundle.getInt("chat_mode", 0);
            this.eAf = bundle.getBoolean("isSingle", false);
            if (this.eAb == null) {
                this.eAb = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.eAd = new HashMap<>();
    }

    private void aLN() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.eAf) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.ezZ)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.eAb, AbsMsgImageActivity.this.ezZ);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.eAa;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.ezZ, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = AbsMsgImageActivity.this.eAb;
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
                    AbsMsgImageActivity.this.aDz();
                    AbsMsgImageActivity.this.ezU.setIsFromCDN(true);
                    AbsMsgImageActivity.this.ezU.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.ezU.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.ezU.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.ezU.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.ezQ);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.eAb);
        bundle.putInt("chat_mode", this.eAe);
        bundle.putBoolean("isSingle", this.eAf);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.ezU.setCurrentItem(this.mIndex, true);
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
                    return com.baidu.tbadk.core.util.l.BD();
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
            AbsMsgImageActivity.this.ezR = null;
            AbsMsgImageActivity.this.ezS.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.ezR = null;
            AbsMsgImageActivity.this.ezS.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bn(int i, int i2) {
        synchronized (this.eAd) {
            if (System.nanoTime() - this.eAc > 300000000 && this.ezQ != null && i < this.ezQ.size()) {
                this.eAd.put(this.ezQ.get("" + i), true);
            }
            this.eAc = System.nanoTime();
        }
    }
}
