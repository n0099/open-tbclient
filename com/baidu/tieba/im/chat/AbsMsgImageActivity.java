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
    private com.baidu.tbadk.core.util.b.a buX;
    private String eyH;
    private boolean eyM;
    private FrameLayout eyz;
    private int mCount;
    private LinkedHashMap<String, String> eyx = null;
    private int mIndex = 0;
    private a eyy = null;
    private View aIE = null;
    private TextView mTextView = null;
    private NavigationBar eyA = null;
    private MultiImageView eyB = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a eyC = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation eyD = null;
    private boolean eyE = true;
    private boolean eyF = false;
    private String eyG = "";
    private String id = "";
    private String eyI = "";
    private long eyJ = 0;
    private HashMap<String, Boolean> eyK = null;
    private int eyL = 0;

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
        aMp();
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
        aMp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.j(this.eyB, e.d.black_alpha100);
        al.j(this.eyA, e.d.common_color_10222);
        getLayoutMode().onModeChanged(this.aIE);
        getLayoutMode().onModeChanged(this.mTextView);
        getLayoutMode().onModeChanged(this.eyz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eyB.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eyB.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.eyB.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        bl(this.mIndex, this.mIndex);
        this.eyB.onDestroy();
        if (this.eyy != null) {
            this.eyy.cancel();
            this.eyy = null;
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
                if (view == AbsMsgImageActivity.this.aIE) {
                    if (AbsMsgImageActivity.this.eyA.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view == AbsMsgImageActivity.this.eyz) {
                    if (AbsMsgImageActivity.this.eyA.getVisibility() != 8) {
                        Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                        if (AbsMsgImageActivity.this.buX == null) {
                            AbsMsgImageActivity.this.buX = new com.baidu.tbadk.core.util.b.a();
                        }
                        AbsMsgImageActivity.this.buX.Di();
                        AbsMsgImageActivity.this.buX.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!AbsMsgImageActivity.this.buX.z(pageActivity)) {
                            try {
                                byte[] currentImageData = AbsMsgImageActivity.this.eyB.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.eyB.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.eyy = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.eyy.execute(new String[0]);
                                    AbsMsgImageActivity.this.eyz.setClickable(false);
                                } else {
                                    AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(e.j.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (AbsMsgImageActivity.this.eyE) {
                    if (AbsMsgImageActivity.this.eyA.getVisibility() != 0) {
                        AbsMsgImageActivity.this.eyA.setVisibility(0);
                        AbsMsgImageActivity.this.eyB.Jf();
                        AbsMsgImageActivity.this.eyD = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.eyD = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.eyF = true;
                        AbsMsgImageActivity.this.eyB.Jg();
                    }
                    AbsMsgImageActivity.this.eyD.setDuration(300L);
                    AbsMsgImageActivity.this.eyD.setFillAfter(true);
                    AbsMsgImageActivity.this.eyD.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.eyE = true;
                            if (AbsMsgImageActivity.this.eyF) {
                                AbsMsgImageActivity.this.eyF = false;
                                AbsMsgImageActivity.this.eyA.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.eyE = false;
                    AbsMsgImageActivity.this.eyA.startAnimation(AbsMsgImageActivity.this.eyD);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.bl(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.aEf();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.eyJ > 300000000 && AbsMsgImageActivity.this.eyx != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.eyx.size()) {
                    AbsMsgImageActivity.this.eyK.put(AbsMsgImageActivity.this.eyx.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.eyC = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void dz(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0124b interfaceC0124b = new b.InterfaceC0124b() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar == AbsMsgImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            try {
                                Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                                if (AbsMsgImageActivity.this.buX == null) {
                                    AbsMsgImageActivity.this.buX = new com.baidu.tbadk.core.util.b.a();
                                }
                                AbsMsgImageActivity.this.buX.Di();
                                AbsMsgImageActivity.this.buX.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                                if (!AbsMsgImageActivity.this.buX.z(pageActivity)) {
                                    byte[] currentImageData = AbsMsgImageActivity.this.eyB.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = AbsMsgImageActivity.this.eyB.getCurrentImageUrl();
                                        AbsMsgImageActivity.this.eyy = new a(currentImageUrl, currentImageData);
                                        AbsMsgImageActivity.this.eyy.execute(new String[0]);
                                        AbsMsgImageActivity.this.eyz.setClickable(false);
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
                AbsMsgImageActivity.this.createListMenu(new String[]{AbsMsgImageActivity.this.getPageContext().getString(e.j.save)}, interfaceC0124b);
                AbsMsgImageActivity.this.showListMenu();
                return false;
            }
        };
        this.eyA = (NavigationBar) findViewById(e.g.navigation_bar);
        this.eyz = (FrameLayout) this.eyA.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.image_activity_save_button, this.mOnClickListener);
        if (this.eyM) {
            this.eyz.setVisibility(8);
        }
        this.aIE = this.eyA.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        al.c(this.eyA.getBackImageView(), e.f.icon_return_bg);
        this.mTextView = this.eyA.setTitleText("");
        this.eyB = (MultiImageView) findViewById(e.g.viewpager);
        this.eyB.setPageMargin(l.dip2px(getPageContext().getContext(), 8.0f));
        this.eyB.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.eyB.setOnPageChangeListener(this.mOnPageChangeListener);
        this.eyB.setItemOnclickListener(this.mOnClickListener);
        this.eyB.setCurrentItem(aMo(), false);
        this.eyB.setOnScrollOutListener(this.eyC);
        this.eyB.setItemOnLongClickListener(onLongClickListener);
        this.eyB.setHasNext(false);
        this.eyB.setNextTitle("mNextTitle");
        this.eyB.setIsFromCDN(true);
        this.eyB.setAllowLocalUrl(true);
        bl(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEf() {
        if (this.eyx != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.eyB.getHasNext() && this.mIndex == this.eyB.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(e.j.image_recommend));
                this.eyz.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.eyz.setClickable(true);
        }
    }

    private int aMo() {
        if (this.eyx != null && this.eyx.size() > 0) {
            int size = this.eyx.size();
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
            this.eyG = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.eyH = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.eyI = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.eyM = intent.getBooleanExtra("isSingle", false);
            if (this.eyI == null) {
                this.eyI = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.eyG == null) {
                this.eyG = "";
            }
            this.eyx = new LinkedHashMap<>();
            this.eyx.put(this.eyI, this.eyG);
            this.eyL = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.eyx = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.eyI = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.eyL = bundle.getInt("chat_mode", 0);
            this.eyM = bundle.getBoolean("isSingle", false);
            if (this.eyI == null) {
                this.eyI = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.eyK = new HashMap<>();
    }

    private void aMp() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.eyM) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.eyG)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.eyI, AbsMsgImageActivity.this.eyG);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.eyH;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.eyG, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = AbsMsgImageActivity.this.eyI;
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
                    AbsMsgImageActivity.this.aEf();
                    AbsMsgImageActivity.this.eyB.setIsFromCDN(true);
                    AbsMsgImageActivity.this.eyB.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.eyB.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.eyB.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.eyB.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.eyx);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.eyI);
        bundle.putInt("chat_mode", this.eyL);
        bundle.putBoolean("isSingle", this.eyM);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.eyB.setCurrentItem(this.mIndex, true);
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
                    return com.baidu.tbadk.core.util.l.Bw();
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
            AbsMsgImageActivity.this.eyy = null;
            AbsMsgImageActivity.this.eyz.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.eyy = null;
            AbsMsgImageActivity.this.eyz.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bl(int i, int i2) {
        synchronized (this.eyK) {
            if (System.nanoTime() - this.eyJ > 300000000 && this.eyx != null && i < this.eyx.size()) {
                this.eyK.put(this.eyx.get("" + i), true);
            }
            this.eyJ = System.nanoTime();
        }
    }
}
