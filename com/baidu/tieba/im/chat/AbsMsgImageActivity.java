package com.baidu.tieba.im.chat;

import android.annotation.SuppressLint;
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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AbsMsgImageActivityConfig;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.aj;
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
/* loaded from: classes.dex */
public abstract class AbsMsgImageActivity extends BaseActivity<AbsMsgImageActivity> {
    private String dpD;
    private boolean dpI;
    private FrameLayout dpv;
    private int mCount;
    private LinkedHashMap<String, String> dpt = null;
    private int mIndex = 0;
    private a dpu = null;
    private View aqQ = null;
    private TextView abu = null;
    private NavigationBar dpw = null;
    private MultiImageView dpx = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a dpy = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation dpz = null;
    private boolean dpA = true;
    private boolean dpB = false;
    private String dpC = "";
    private String id = "";
    private String dpE = "";
    private long dpF = 0;
    private HashMap<String, Boolean> dpG = null;
    private int dpH = 0;

    protected abstract void a(String str, com.baidu.tieba.im.sendmessage.c cVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(d.j.image_activity_2);
        initData(bundle);
        initUI();
        atF();
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
        atF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.dpx.setBackgroundColor(aj.cR(i));
        } else {
            this.dpx.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        aj.k(this.dpw, d.e.common_color_10222);
        getLayoutMode().t(this.aqQ);
        getLayoutMode().t(this.abu);
        getLayoutMode().t(this.dpv);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.dpx.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dpx.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.dpx.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        ba(this.mIndex, this.mIndex);
        this.dpx.onDestroy();
        if (this.dpu != null) {
            this.dpu.cancel();
            this.dpu = null;
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
                if (view == AbsMsgImageActivity.this.aqQ) {
                    if (AbsMsgImageActivity.this.dpw.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view == AbsMsgImageActivity.this.dpv) {
                    if (AbsMsgImageActivity.this.dpw.getVisibility() != 8) {
                        try {
                            byte[] currentImageData = AbsMsgImageActivity.this.dpx.getCurrentImageData();
                            if (currentImageData != null) {
                                String currentImageUrl = AbsMsgImageActivity.this.dpx.getCurrentImageUrl();
                                AbsMsgImageActivity.this.dpu = new a(currentImageUrl, currentImageData);
                                AbsMsgImageActivity.this.dpu.execute(new String[0]);
                                AbsMsgImageActivity.this.dpv.setClickable(false);
                            } else {
                                AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(d.l.no_data));
                            }
                        } catch (Exception e) {
                        }
                    }
                } else if (AbsMsgImageActivity.this.dpA) {
                    if (AbsMsgImageActivity.this.dpw.getVisibility() != 0) {
                        AbsMsgImageActivity.this.dpw.setVisibility(0);
                        AbsMsgImageActivity.this.dpx.Bo();
                        AbsMsgImageActivity.this.dpz = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.dpz = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.dpB = true;
                        AbsMsgImageActivity.this.dpx.Bp();
                    }
                    AbsMsgImageActivity.this.dpz.setDuration(300L);
                    AbsMsgImageActivity.this.dpz.setFillAfter(true);
                    AbsMsgImageActivity.this.dpz.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.dpA = true;
                            if (AbsMsgImageActivity.this.dpB) {
                                AbsMsgImageActivity.this.dpB = false;
                                AbsMsgImageActivity.this.dpw.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.dpA = false;
                    AbsMsgImageActivity.this.dpw.startAnimation(AbsMsgImageActivity.this.dpz);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.ba(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.atD();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.dpF > 300000000 && AbsMsgImageActivity.this.dpt != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.dpt.size()) {
                    AbsMsgImageActivity.this.dpG.put(AbsMsgImageActivity.this.dpt.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.dpy = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void dc(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0046b interfaceC0046b = new b.InterfaceC0046b() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0046b
            public void a(b bVar, int i, View view) {
                if (bVar == AbsMsgImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            try {
                                byte[] currentImageData = AbsMsgImageActivity.this.dpx.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.dpx.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.dpu = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.dpu.execute(new String[0]);
                                    AbsMsgImageActivity.this.dpv.setClickable(false);
                                } else {
                                    AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(d.l.no_data));
                                }
                                break;
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
                AbsMsgImageActivity.this.createListMenu(new String[]{AbsMsgImageActivity.this.getPageContext().getString(d.l.save)}, interfaceC0046b);
                AbsMsgImageActivity.this.showListMenu();
                return false;
            }
        };
        this.dpw = (NavigationBar) findViewById(d.h.navigation_bar);
        this.dpv = (FrameLayout) this.dpw.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.image_activity_save_button, this.mOnClickListener);
        if (this.dpI) {
            this.dpv.setVisibility(8);
        }
        this.aqQ = this.dpw.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.abu = this.dpw.setTitleText("");
        this.dpx = (MultiImageView) findViewById(d.h.viewpager);
        this.dpx.setPageMargin(k.dip2px(getPageContext().getContext(), 8.0f));
        this.dpx.G(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.dpx.setOnPageChangeListener(this.mOnPageChangeListener);
        this.dpx.setItemOnclickListener(this.mOnClickListener);
        this.dpx.setCurrentItem(atE(), false);
        this.dpx.setOnScrollOutListener(this.dpy);
        this.dpx.setItemOnLongClickListener(onLongClickListener);
        this.dpx.setHasNext(false);
        this.dpx.setNextTitle("mNextTitle");
        this.dpx.setIsFromCDN(true);
        this.dpx.setAllowLocalUrl(true);
        ba(this.mIndex, this.mIndex);
        this.abu.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atD() {
        if (this.dpt != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.dpx.getHasNext() && this.mIndex == this.dpx.getItemNum() - 1) {
                this.abu.setText(getPageContext().getString(d.l.image_recommend));
                this.dpv.setClickable(false);
                return;
            }
            this.abu.setText(valueOf);
            this.dpv.setClickable(true);
        }
    }

    private int atE() {
        if (this.dpt != null && this.dpt.size() > 0) {
            int size = this.dpt.size();
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
            this.dpC = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.dpD = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.dpE = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.dpI = intent.getBooleanExtra("isSingle", false);
            if (this.dpE == null) {
                this.dpE = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.dpC == null) {
                this.dpC = "";
            }
            this.dpt = new LinkedHashMap<>();
            this.dpt.put(this.dpE, this.dpC);
            this.dpH = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.dpt = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.dpE = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.dpH = bundle.getInt("chat_mode", 0);
            this.dpI = bundle.getBoolean("isSingle", false);
            if (this.dpE == null) {
                this.dpE = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.dpG = new HashMap<>();
    }

    private void atF() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.dpI) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.dpC)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.dpE, AbsMsgImageActivity.this.dpC);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.dpD;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.dpC, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = AbsMsgImageActivity.this.dpE;
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
                    AbsMsgImageActivity.this.abu.setVisibility(0);
                    AbsMsgImageActivity.this.atD();
                    AbsMsgImageActivity.this.dpx.setIsFromCDN(true);
                    AbsMsgImageActivity.this.dpx.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.dpx.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.dpx.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.dpx.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.dpt);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.dpE);
        bundle.putInt("chat_mode", this.dpH);
        bundle.putBoolean("isSingle", this.dpI);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.dpx.setCurrentItem(this.mIndex, true);
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
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            switch (com.baidu.tbadk.core.util.k.a(this.mUrl, this.mData, AbsMsgImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.k.uE();
                case -1:
                default:
                    return AbsMsgImageActivity.this.getPageContext().getString(d.l.save_fail);
                case 0:
                    return AbsMsgImageActivity.this.getPageContext().getString(d.l.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            AbsMsgImageActivity.this.dpu = null;
            AbsMsgImageActivity.this.dpv.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.dpu = null;
            AbsMsgImageActivity.this.dpv.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba(int i, int i2) {
        synchronized (this.dpG) {
            if (System.nanoTime() - this.dpF > 300000000 && this.dpt != null && i < this.dpt.size()) {
                this.dpG.put(this.dpt.get("" + i), true);
            }
            this.dpF = System.nanoTime();
        }
    }
}
