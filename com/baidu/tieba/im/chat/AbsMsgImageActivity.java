package com.baidu.tieba.im.chat;

import android.annotation.SuppressLint;
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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.k;
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
    private String dCG;
    private boolean dCL;
    private FrameLayout dCy;
    private int mCount;
    private LinkedHashMap<String, String> dCw = null;
    private int mIndex = 0;
    private a dCx = null;
    private View aqB = null;
    private TextView abT = null;
    private NavigationBar dCz = null;
    private MultiImageView dCA = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a dCB = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation dCC = null;
    private boolean dCD = true;
    private boolean dCE = false;
    private String dCF = "";
    private String id = "";
    private String dCH = "";
    private long dCI = 0;
    private HashMap<String, Boolean> dCJ = null;
    private int dCK = 0;

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
        awF();
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
        awF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.k(this.dCA, d.C0096d.black_alpha100);
        aj.k(this.dCz, d.C0096d.common_color_10222);
        getLayoutMode().t(this.aqB);
        getLayoutMode().t(this.abT);
        getLayoutMode().t(this.dCy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.dCA.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dCA.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.dCA.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        bd(this.mIndex, this.mIndex);
        this.dCA.onDestroy();
        if (this.dCx != null) {
            this.dCx.cancel();
            this.dCx = null;
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
                if (view == AbsMsgImageActivity.this.aqB) {
                    if (AbsMsgImageActivity.this.dCz.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view == AbsMsgImageActivity.this.dCy) {
                    if (AbsMsgImageActivity.this.dCz.getVisibility() != 8) {
                        try {
                            byte[] currentImageData = AbsMsgImageActivity.this.dCA.getCurrentImageData();
                            if (currentImageData != null) {
                                String currentImageUrl = AbsMsgImageActivity.this.dCA.getCurrentImageUrl();
                                AbsMsgImageActivity.this.dCx = new a(currentImageUrl, currentImageData);
                                AbsMsgImageActivity.this.dCx.execute(new String[0]);
                                AbsMsgImageActivity.this.dCy.setClickable(false);
                            } else {
                                AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(d.j.no_data));
                            }
                        } catch (Exception e) {
                        }
                    }
                } else if (AbsMsgImageActivity.this.dCD) {
                    if (AbsMsgImageActivity.this.dCz.getVisibility() != 0) {
                        AbsMsgImageActivity.this.dCz.setVisibility(0);
                        AbsMsgImageActivity.this.dCA.Bm();
                        AbsMsgImageActivity.this.dCC = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.dCC = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.dCE = true;
                        AbsMsgImageActivity.this.dCA.Bn();
                    }
                    AbsMsgImageActivity.this.dCC.setDuration(300L);
                    AbsMsgImageActivity.this.dCC.setFillAfter(true);
                    AbsMsgImageActivity.this.dCC.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.dCD = true;
                            if (AbsMsgImageActivity.this.dCE) {
                                AbsMsgImageActivity.this.dCE = false;
                                AbsMsgImageActivity.this.dCz.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.dCD = false;
                    AbsMsgImageActivity.this.dCz.startAnimation(AbsMsgImageActivity.this.dCC);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.bd(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.apn();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.dCI > 300000000 && AbsMsgImageActivity.this.dCw != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.dCw.size()) {
                    AbsMsgImageActivity.this.dCJ.put(AbsMsgImageActivity.this.dCw.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.dCB = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void da(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0061b interfaceC0061b = new b.InterfaceC0061b() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0061b
            public void a(b bVar, int i, View view) {
                if (bVar == AbsMsgImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            try {
                                byte[] currentImageData = AbsMsgImageActivity.this.dCA.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.dCA.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.dCx = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.dCx.execute(new String[0]);
                                    AbsMsgImageActivity.this.dCy.setClickable(false);
                                } else {
                                    AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(d.j.no_data));
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
                AbsMsgImageActivity.this.createListMenu(new String[]{AbsMsgImageActivity.this.getPageContext().getString(d.j.save)}, interfaceC0061b);
                AbsMsgImageActivity.this.showListMenu();
                return false;
            }
        };
        this.dCz = (NavigationBar) findViewById(d.g.navigation_bar);
        this.dCy = (FrameLayout) this.dCz.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.image_activity_save_button, this.mOnClickListener);
        if (this.dCL) {
            this.dCy.setVisibility(8);
        }
        this.aqB = this.dCz.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.abT = this.dCz.setTitleText("");
        this.dCA = (MultiImageView) findViewById(d.g.viewpager);
        this.dCA.setPageMargin(l.dip2px(getPageContext().getContext(), 8.0f));
        this.dCA.G(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.dCA.setOnPageChangeListener(this.mOnPageChangeListener);
        this.dCA.setItemOnclickListener(this.mOnClickListener);
        this.dCA.setCurrentItem(awE(), false);
        this.dCA.setOnScrollOutListener(this.dCB);
        this.dCA.setItemOnLongClickListener(onLongClickListener);
        this.dCA.setHasNext(false);
        this.dCA.setNextTitle("mNextTitle");
        this.dCA.setIsFromCDN(true);
        this.dCA.setAllowLocalUrl(true);
        bd(this.mIndex, this.mIndex);
        this.abT.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apn() {
        if (this.dCw != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.dCA.getHasNext() && this.mIndex == this.dCA.getItemNum() - 1) {
                this.abT.setText(getPageContext().getString(d.j.image_recommend));
                this.dCy.setClickable(false);
                return;
            }
            this.abT.setText(valueOf);
            this.dCy.setClickable(true);
        }
    }

    private int awE() {
        if (this.dCw != null && this.dCw.size() > 0) {
            int size = this.dCw.size();
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
            this.dCF = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.dCG = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.dCH = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.dCL = intent.getBooleanExtra("isSingle", false);
            if (this.dCH == null) {
                this.dCH = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.dCF == null) {
                this.dCF = "";
            }
            this.dCw = new LinkedHashMap<>();
            this.dCw.put(this.dCH, this.dCF);
            this.dCK = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.dCw = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.dCH = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.dCK = bundle.getInt("chat_mode", 0);
            this.dCL = bundle.getBoolean("isSingle", false);
            if (this.dCH == null) {
                this.dCH = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.dCJ = new HashMap<>();
    }

    private void awF() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.dCL) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.dCF)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.dCH, AbsMsgImageActivity.this.dCF);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.dCG;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.dCF, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = AbsMsgImageActivity.this.dCH;
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
                    AbsMsgImageActivity.this.abT.setVisibility(0);
                    AbsMsgImageActivity.this.apn();
                    AbsMsgImageActivity.this.dCA.setIsFromCDN(true);
                    AbsMsgImageActivity.this.dCA.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.dCA.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.dCA.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.dCA.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.dCw);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.dCH);
        bundle.putInt("chat_mode", this.dCK);
        bundle.putBoolean("isSingle", this.dCL);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.dCA.setCurrentItem(this.mIndex, true);
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
            switch (k.a(this.mUrl, this.mData, AbsMsgImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return k.uh();
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
            AbsMsgImageActivity.this.dCx = null;
            AbsMsgImageActivity.this.dCy.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.dCx = null;
            AbsMsgImageActivity.this.dCy.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bd(int i, int i2) {
        synchronized (this.dCJ) {
            if (System.nanoTime() - this.dCI > 300000000 && this.dCw != null && i < this.dCw.size()) {
                this.dCJ.put(this.dCw.get("" + i), true);
            }
            this.dCI = System.nanoTime();
        }
    }
}
