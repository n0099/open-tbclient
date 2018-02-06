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
    private com.baidu.tbadk.core.util.b.a bQQ;
    private FrameLayout euI;
    private String euQ;
    private boolean euV;
    private int mCount;
    private LinkedHashMap<String, String> euG = null;
    private int mIndex = 0;
    private a euH = null;
    private View bgK = null;
    private TextView rz = null;
    private NavigationBar euJ = null;
    private MultiImageView euK = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a euL = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation euM = null;
    private boolean euN = true;
    private boolean euO = false;
    private String euP = "";
    private String id = "";
    private String euR = "";
    private long euS = 0;
    private HashMap<String, Boolean> euT = null;
    private int euU = 0;

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
        aFl();
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
        aFl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.t(this.euK, d.C0140d.black_alpha100);
        aj.t(this.euJ, d.C0140d.common_color_10222);
        getLayoutMode().aM(this.bgK);
        getLayoutMode().aM(this.rz);
        getLayoutMode().aM(this.euI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.euK.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.euK.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.euK.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        bZ(this.mIndex, this.mIndex);
        this.euK.onDestroy();
        if (this.euH != null) {
            this.euH.cancel();
            this.euH = null;
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
                if (view == AbsMsgImageActivity.this.bgK) {
                    if (AbsMsgImageActivity.this.euJ.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view == AbsMsgImageActivity.this.euI) {
                    if (AbsMsgImageActivity.this.euJ.getVisibility() != 8) {
                        Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                        if (AbsMsgImageActivity.this.bQQ == null) {
                            AbsMsgImageActivity.this.bQQ = new com.baidu.tbadk.core.util.b.a();
                        }
                        AbsMsgImageActivity.this.bQQ.DI();
                        AbsMsgImageActivity.this.bQQ.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!AbsMsgImageActivity.this.bQQ.v(pageActivity)) {
                            try {
                                byte[] currentImageData = AbsMsgImageActivity.this.euK.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.euK.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.euH = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.euH.execute(new String[0]);
                                    AbsMsgImageActivity.this.euI.setClickable(false);
                                } else {
                                    AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(d.j.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (AbsMsgImageActivity.this.euN) {
                    if (AbsMsgImageActivity.this.euJ.getVisibility() != 0) {
                        AbsMsgImageActivity.this.euJ.setVisibility(0);
                        AbsMsgImageActivity.this.euK.Jl();
                        AbsMsgImageActivity.this.euM = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.euM = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.euO = true;
                        AbsMsgImageActivity.this.euK.Jm();
                    }
                    AbsMsgImageActivity.this.euM.setDuration(300L);
                    AbsMsgImageActivity.this.euM.setFillAfter(true);
                    AbsMsgImageActivity.this.euM.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.euN = true;
                            if (AbsMsgImageActivity.this.euO) {
                                AbsMsgImageActivity.this.euO = false;
                                AbsMsgImageActivity.this.euJ.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.euN = false;
                    AbsMsgImageActivity.this.euJ.startAnimation(AbsMsgImageActivity.this.euM);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.bZ(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.ayu();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.euS > 300000000 && AbsMsgImageActivity.this.euG != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.euG.size()) {
                    AbsMsgImageActivity.this.euT.put(AbsMsgImageActivity.this.euG.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.euL = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void fZ(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0096b interfaceC0096b = new b.InterfaceC0096b() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0096b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar == AbsMsgImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            try {
                                Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                                if (AbsMsgImageActivity.this.bQQ == null) {
                                    AbsMsgImageActivity.this.bQQ = new com.baidu.tbadk.core.util.b.a();
                                }
                                AbsMsgImageActivity.this.bQQ.DI();
                                AbsMsgImageActivity.this.bQQ.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                                if (!AbsMsgImageActivity.this.bQQ.v(pageActivity)) {
                                    byte[] currentImageData = AbsMsgImageActivity.this.euK.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = AbsMsgImageActivity.this.euK.getCurrentImageUrl();
                                        AbsMsgImageActivity.this.euH = new a(currentImageUrl, currentImageData);
                                        AbsMsgImageActivity.this.euH.execute(new String[0]);
                                        AbsMsgImageActivity.this.euI.setClickable(false);
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
                AbsMsgImageActivity.this.createListMenu(new String[]{AbsMsgImageActivity.this.getPageContext().getString(d.j.save)}, interfaceC0096b);
                AbsMsgImageActivity.this.showListMenu();
                return false;
            }
        };
        this.euJ = (NavigationBar) findViewById(d.g.navigation_bar);
        this.euI = (FrameLayout) this.euJ.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.image_activity_save_button, this.mOnClickListener);
        if (this.euV) {
            this.euI.setVisibility(8);
        }
        this.bgK = this.euJ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.rz = this.euJ.setTitleText("");
        this.euK = (MultiImageView) findViewById(d.g.viewpager);
        this.euK.setPageMargin(l.dip2px(getPageContext().getContext(), 8.0f));
        this.euK.aF(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.euK.setOnPageChangeListener(this.mOnPageChangeListener);
        this.euK.setItemOnclickListener(this.mOnClickListener);
        this.euK.setCurrentItem(aFk(), false);
        this.euK.setOnScrollOutListener(this.euL);
        this.euK.setItemOnLongClickListener(onLongClickListener);
        this.euK.setHasNext(false);
        this.euK.setNextTitle("mNextTitle");
        this.euK.setIsFromCDN(true);
        this.euK.setAllowLocalUrl(true);
        bZ(this.mIndex, this.mIndex);
        this.rz.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayu() {
        if (this.euG != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.euK.getHasNext() && this.mIndex == this.euK.getItemNum() - 1) {
                this.rz.setText(getPageContext().getString(d.j.image_recommend));
                this.euI.setClickable(false);
                return;
            }
            this.rz.setText(valueOf);
            this.euI.setClickable(true);
        }
    }

    private int aFk() {
        if (this.euG != null && this.euG.size() > 0) {
            int size = this.euG.size();
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
            this.euP = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.euQ = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.euR = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.euV = intent.getBooleanExtra("isSingle", false);
            if (this.euR == null) {
                this.euR = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.euP == null) {
                this.euP = "";
            }
            this.euG = new LinkedHashMap<>();
            this.euG.put(this.euR, this.euP);
            this.euU = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.euG = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.euR = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.euU = bundle.getInt("chat_mode", 0);
            this.euV = bundle.getBoolean("isSingle", false);
            if (this.euR == null) {
                this.euR = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.euT = new HashMap<>();
    }

    private void aFl() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.euV) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.euP)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.euR, AbsMsgImageActivity.this.euP);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.euQ;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.euP, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = AbsMsgImageActivity.this.euR;
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
                    AbsMsgImageActivity.this.ayu();
                    AbsMsgImageActivity.this.euK.setIsFromCDN(true);
                    AbsMsgImageActivity.this.euK.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.euK.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.euK.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.euK.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.euG);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.euR);
        bundle.putInt("chat_mode", this.euU);
        bundle.putBoolean("isSingle", this.euV);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.euK.setCurrentItem(this.mIndex, true);
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
                    return k.BT();
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
            AbsMsgImageActivity.this.euH = null;
            AbsMsgImageActivity.this.euI.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.euH = null;
            AbsMsgImageActivity.this.euI.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZ(int i, int i2) {
        synchronized (this.euT) {
            if (System.nanoTime() - this.euS > 300000000 && this.euG != null && i < this.euG.size()) {
                this.euT.put(this.euG.get("" + i), true);
            }
            this.euS = System.nanoTime();
        }
    }
}
