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
    private com.baidu.tbadk.core.util.b.a bOI;
    private String eqF;
    private boolean eqK;
    private FrameLayout eqx;
    private int mCount;
    private LinkedHashMap<String, String> eqv = null;
    private int mIndex = 0;
    private a eqw = null;
    private View beR = null;
    private TextView rz = null;
    private NavigationBar eqy = null;
    private MultiImageView eqz = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a eqA = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation eqB = null;
    private boolean eqC = true;
    private boolean eqD = false;
    private String eqE = "";
    private String id = "";
    private String eqG = "";
    private long eqH = 0;
    private HashMap<String, Boolean> eqI = null;
    private int eqJ = 0;

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
        aDR();
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
        aDR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.t(this.eqz, d.C0108d.black_alpha100);
        aj.t(this.eqy, d.C0108d.common_color_10222);
        getLayoutMode().aM(this.beR);
        getLayoutMode().aM(this.rz);
        getLayoutMode().aM(this.eqx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eqz.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eqz.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.eqz.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        cb(this.mIndex, this.mIndex);
        this.eqz.onDestroy();
        if (this.eqw != null) {
            this.eqw.cancel();
            this.eqw = null;
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
                if (view == AbsMsgImageActivity.this.beR) {
                    if (AbsMsgImageActivity.this.eqy.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view == AbsMsgImageActivity.this.eqx) {
                    if (AbsMsgImageActivity.this.eqy.getVisibility() != 8) {
                        Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                        if (AbsMsgImageActivity.this.bOI == null) {
                            AbsMsgImageActivity.this.bOI = new com.baidu.tbadk.core.util.b.a();
                        }
                        AbsMsgImageActivity.this.bOI.Do();
                        AbsMsgImageActivity.this.bOI.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!AbsMsgImageActivity.this.bOI.u(pageActivity)) {
                            try {
                                byte[] currentImageData = AbsMsgImageActivity.this.eqz.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.eqz.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.eqw = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.eqw.execute(new String[0]);
                                    AbsMsgImageActivity.this.eqx.setClickable(false);
                                } else {
                                    AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(d.j.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (AbsMsgImageActivity.this.eqC) {
                    if (AbsMsgImageActivity.this.eqy.getVisibility() != 0) {
                        AbsMsgImageActivity.this.eqy.setVisibility(0);
                        AbsMsgImageActivity.this.eqz.IF();
                        AbsMsgImageActivity.this.eqB = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.eqB = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.eqD = true;
                        AbsMsgImageActivity.this.eqz.IG();
                    }
                    AbsMsgImageActivity.this.eqB.setDuration(300L);
                    AbsMsgImageActivity.this.eqB.setFillAfter(true);
                    AbsMsgImageActivity.this.eqB.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.eqC = true;
                            if (AbsMsgImageActivity.this.eqD) {
                                AbsMsgImageActivity.this.eqD = false;
                                AbsMsgImageActivity.this.eqy.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.eqC = false;
                    AbsMsgImageActivity.this.eqy.startAnimation(AbsMsgImageActivity.this.eqB);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.cb(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.axw();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.eqH > 300000000 && AbsMsgImageActivity.this.eqv != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.eqv.size()) {
                    AbsMsgImageActivity.this.eqI.put(AbsMsgImageActivity.this.eqv.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.eqA = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void fX(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0073b interfaceC0073b = new b.InterfaceC0073b() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0073b
            public void a(b bVar, int i, View view) {
                if (bVar == AbsMsgImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            try {
                                Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                                if (AbsMsgImageActivity.this.bOI == null) {
                                    AbsMsgImageActivity.this.bOI = new com.baidu.tbadk.core.util.b.a();
                                }
                                AbsMsgImageActivity.this.bOI.Do();
                                AbsMsgImageActivity.this.bOI.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                                if (!AbsMsgImageActivity.this.bOI.u(pageActivity)) {
                                    byte[] currentImageData = AbsMsgImageActivity.this.eqz.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = AbsMsgImageActivity.this.eqz.getCurrentImageUrl();
                                        AbsMsgImageActivity.this.eqw = new a(currentImageUrl, currentImageData);
                                        AbsMsgImageActivity.this.eqw.execute(new String[0]);
                                        AbsMsgImageActivity.this.eqx.setClickable(false);
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
                AbsMsgImageActivity.this.createListMenu(new String[]{AbsMsgImageActivity.this.getPageContext().getString(d.j.save)}, interfaceC0073b);
                AbsMsgImageActivity.this.showListMenu();
                return false;
            }
        };
        this.eqy = (NavigationBar) findViewById(d.g.navigation_bar);
        this.eqx = (FrameLayout) this.eqy.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.image_activity_save_button, this.mOnClickListener);
        if (this.eqK) {
            this.eqx.setVisibility(8);
        }
        this.beR = this.eqy.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.rz = this.eqy.setTitleText("");
        this.eqz = (MultiImageView) findViewById(d.g.viewpager);
        this.eqz.setPageMargin(l.dip2px(getPageContext().getContext(), 8.0f));
        this.eqz.aF(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.eqz.setOnPageChangeListener(this.mOnPageChangeListener);
        this.eqz.setItemOnclickListener(this.mOnClickListener);
        this.eqz.setCurrentItem(aDQ(), false);
        this.eqz.setOnScrollOutListener(this.eqA);
        this.eqz.setItemOnLongClickListener(onLongClickListener);
        this.eqz.setHasNext(false);
        this.eqz.setNextTitle("mNextTitle");
        this.eqz.setIsFromCDN(true);
        this.eqz.setAllowLocalUrl(true);
        cb(this.mIndex, this.mIndex);
        this.rz.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axw() {
        if (this.eqv != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.eqz.getHasNext() && this.mIndex == this.eqz.getItemNum() - 1) {
                this.rz.setText(getPageContext().getString(d.j.image_recommend));
                this.eqx.setClickable(false);
                return;
            }
            this.rz.setText(valueOf);
            this.eqx.setClickable(true);
        }
    }

    private int aDQ() {
        if (this.eqv != null && this.eqv.size() > 0) {
            int size = this.eqv.size();
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
            this.eqE = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.eqF = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.eqG = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.eqK = intent.getBooleanExtra("isSingle", false);
            if (this.eqG == null) {
                this.eqG = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.eqE == null) {
                this.eqE = "";
            }
            this.eqv = new LinkedHashMap<>();
            this.eqv.put(this.eqG, this.eqE);
            this.eqJ = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.eqv = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.eqG = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.eqJ = bundle.getInt("chat_mode", 0);
            this.eqK = bundle.getBoolean("isSingle", false);
            if (this.eqG == null) {
                this.eqG = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.eqI = new HashMap<>();
    }

    private void aDR() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.eqK) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.eqE)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.eqG, AbsMsgImageActivity.this.eqE);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.eqF;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.eqE, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = AbsMsgImageActivity.this.eqG;
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
                    AbsMsgImageActivity.this.rz.setVisibility(0);
                    AbsMsgImageActivity.this.axw();
                    AbsMsgImageActivity.this.eqz.setIsFromCDN(true);
                    AbsMsgImageActivity.this.eqz.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.eqz.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.eqz.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.eqz.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.eqv);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.eqG);
        bundle.putInt("chat_mode", this.eqJ);
        bundle.putBoolean("isSingle", this.eqK);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.eqz.setCurrentItem(this.mIndex, true);
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
                    return k.BA();
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
            AbsMsgImageActivity.this.eqw = null;
            AbsMsgImageActivity.this.eqx.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.eqw = null;
            AbsMsgImageActivity.this.eqx.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb(int i, int i2) {
        synchronized (this.eqI) {
            if (System.nanoTime() - this.eqH > 300000000 && this.eqv != null && i < this.eqv.size()) {
                this.eqI.put(this.eqv.get("" + i), true);
            }
            this.eqH = System.nanoTime();
        }
    }
}
