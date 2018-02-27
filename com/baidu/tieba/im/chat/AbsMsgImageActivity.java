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
    private com.baidu.tbadk.core.util.b.a bQD;
    private String euE;
    private boolean euJ;
    private FrameLayout euw;
    private int mCount;
    private LinkedHashMap<String, String> euu = null;
    private int mIndex = 0;
    private a euv = null;
    private View bgy = null;
    private TextView ry = null;
    private NavigationBar eux = null;
    private MultiImageView euy = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a euz = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation euA = null;
    private boolean euB = true;
    private boolean euC = false;
    private String euD = "";
    private String id = "";
    private String euF = "";
    private long euG = 0;
    private HashMap<String, Boolean> euH = null;
    private int euI = 0;

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
        aFk();
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
        aFk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.t(this.euy, d.C0141d.black_alpha100);
        aj.t(this.eux, d.C0141d.common_color_10222);
        getLayoutMode().aM(this.bgy);
        getLayoutMode().aM(this.ry);
        getLayoutMode().aM(this.euw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.euy.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.euy.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.euy.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        bZ(this.mIndex, this.mIndex);
        this.euy.onDestroy();
        if (this.euv != null) {
            this.euv.cancel();
            this.euv = null;
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
                if (view == AbsMsgImageActivity.this.bgy) {
                    if (AbsMsgImageActivity.this.eux.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view == AbsMsgImageActivity.this.euw) {
                    if (AbsMsgImageActivity.this.eux.getVisibility() != 8) {
                        Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                        if (AbsMsgImageActivity.this.bQD == null) {
                            AbsMsgImageActivity.this.bQD = new com.baidu.tbadk.core.util.b.a();
                        }
                        AbsMsgImageActivity.this.bQD.DH();
                        AbsMsgImageActivity.this.bQD.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!AbsMsgImageActivity.this.bQD.v(pageActivity)) {
                            try {
                                byte[] currentImageData = AbsMsgImageActivity.this.euy.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.euy.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.euv = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.euv.execute(new String[0]);
                                    AbsMsgImageActivity.this.euw.setClickable(false);
                                } else {
                                    AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(d.j.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (AbsMsgImageActivity.this.euB) {
                    if (AbsMsgImageActivity.this.eux.getVisibility() != 0) {
                        AbsMsgImageActivity.this.eux.setVisibility(0);
                        AbsMsgImageActivity.this.euy.Jk();
                        AbsMsgImageActivity.this.euA = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.euA = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.euC = true;
                        AbsMsgImageActivity.this.euy.Jl();
                    }
                    AbsMsgImageActivity.this.euA.setDuration(300L);
                    AbsMsgImageActivity.this.euA.setFillAfter(true);
                    AbsMsgImageActivity.this.euA.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.euB = true;
                            if (AbsMsgImageActivity.this.euC) {
                                AbsMsgImageActivity.this.euC = false;
                                AbsMsgImageActivity.this.eux.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.euB = false;
                    AbsMsgImageActivity.this.eux.startAnimation(AbsMsgImageActivity.this.euA);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.bZ(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.ayt();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.euG > 300000000 && AbsMsgImageActivity.this.euu != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.euu.size()) {
                    AbsMsgImageActivity.this.euH.put(AbsMsgImageActivity.this.euu.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.euz = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void fZ(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0097b interfaceC0097b = new b.InterfaceC0097b() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar == AbsMsgImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            try {
                                Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                                if (AbsMsgImageActivity.this.bQD == null) {
                                    AbsMsgImageActivity.this.bQD = new com.baidu.tbadk.core.util.b.a();
                                }
                                AbsMsgImageActivity.this.bQD.DH();
                                AbsMsgImageActivity.this.bQD.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                                if (!AbsMsgImageActivity.this.bQD.v(pageActivity)) {
                                    byte[] currentImageData = AbsMsgImageActivity.this.euy.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = AbsMsgImageActivity.this.euy.getCurrentImageUrl();
                                        AbsMsgImageActivity.this.euv = new a(currentImageUrl, currentImageData);
                                        AbsMsgImageActivity.this.euv.execute(new String[0]);
                                        AbsMsgImageActivity.this.euw.setClickable(false);
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
                AbsMsgImageActivity.this.createListMenu(new String[]{AbsMsgImageActivity.this.getPageContext().getString(d.j.save)}, interfaceC0097b);
                AbsMsgImageActivity.this.showListMenu();
                return false;
            }
        };
        this.eux = (NavigationBar) findViewById(d.g.navigation_bar);
        this.euw = (FrameLayout) this.eux.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.image_activity_save_button, this.mOnClickListener);
        if (this.euJ) {
            this.euw.setVisibility(8);
        }
        this.bgy = this.eux.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.ry = this.eux.setTitleText("");
        this.euy = (MultiImageView) findViewById(d.g.viewpager);
        this.euy.setPageMargin(l.dip2px(getPageContext().getContext(), 8.0f));
        this.euy.aF(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.euy.setOnPageChangeListener(this.mOnPageChangeListener);
        this.euy.setItemOnclickListener(this.mOnClickListener);
        this.euy.setCurrentItem(aFj(), false);
        this.euy.setOnScrollOutListener(this.euz);
        this.euy.setItemOnLongClickListener(onLongClickListener);
        this.euy.setHasNext(false);
        this.euy.setNextTitle("mNextTitle");
        this.euy.setIsFromCDN(true);
        this.euy.setAllowLocalUrl(true);
        bZ(this.mIndex, this.mIndex);
        this.ry.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayt() {
        if (this.euu != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.euy.getHasNext() && this.mIndex == this.euy.getItemNum() - 1) {
                this.ry.setText(getPageContext().getString(d.j.image_recommend));
                this.euw.setClickable(false);
                return;
            }
            this.ry.setText(valueOf);
            this.euw.setClickable(true);
        }
    }

    private int aFj() {
        if (this.euu != null && this.euu.size() > 0) {
            int size = this.euu.size();
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
            this.euD = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.euE = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.euF = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.euJ = intent.getBooleanExtra("isSingle", false);
            if (this.euF == null) {
                this.euF = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.euD == null) {
                this.euD = "";
            }
            this.euu = new LinkedHashMap<>();
            this.euu.put(this.euF, this.euD);
            this.euI = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.euu = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.euF = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.euI = bundle.getInt("chat_mode", 0);
            this.euJ = bundle.getBoolean("isSingle", false);
            if (this.euF == null) {
                this.euF = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.euH = new HashMap<>();
    }

    private void aFk() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.euJ) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.euD)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.euF, AbsMsgImageActivity.this.euD);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.euE;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.euD, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = AbsMsgImageActivity.this.euF;
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
                    AbsMsgImageActivity.this.ry.setVisibility(0);
                    AbsMsgImageActivity.this.ayt();
                    AbsMsgImageActivity.this.euy.setIsFromCDN(true);
                    AbsMsgImageActivity.this.euy.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.euy.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.euy.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.euy.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.euu);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.euF);
        bundle.putInt("chat_mode", this.euI);
        bundle.putBoolean("isSingle", this.euJ);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.euy.setCurrentItem(this.mIndex, true);
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
                    return k.BS();
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
            AbsMsgImageActivity.this.euv = null;
            AbsMsgImageActivity.this.euw.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.euv = null;
            AbsMsgImageActivity.this.euw.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZ(int i, int i2) {
        synchronized (this.euH) {
            if (System.nanoTime() - this.euG > 300000000 && this.euu != null && i < this.euu.size()) {
                this.euH.put(this.euu.get("" + i), true);
            }
            this.euG = System.nanoTime();
        }
    }
}
