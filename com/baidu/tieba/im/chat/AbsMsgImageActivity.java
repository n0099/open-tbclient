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
    private FrameLayout dtH;
    private String dtP;
    private boolean dtU;
    private int mCount;
    private LinkedHashMap<String, String> dtF = null;
    private int mIndex = 0;
    private a dtG = null;
    private View aqg = null;
    private TextView abE = null;
    private NavigationBar dtI = null;
    private MultiImageView dtJ = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a dtK = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation dtL = null;
    private boolean dtM = true;
    private boolean dtN = false;
    private String dtO = "";
    private String id = "";
    private String dtQ = "";
    private long dtR = 0;
    private HashMap<String, Boolean> dtS = null;
    private int dtT = 0;

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
        auX();
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
        auX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.k(this.dtJ, d.C0080d.black_alpha100);
        aj.k(this.dtI, d.C0080d.common_color_10222);
        getLayoutMode().t(this.aqg);
        getLayoutMode().t(this.abE);
        getLayoutMode().t(this.dtH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.dtJ.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dtJ.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.dtJ.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        bh(this.mIndex, this.mIndex);
        this.dtJ.onDestroy();
        if (this.dtG != null) {
            this.dtG.cancel();
            this.dtG = null;
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
                if (view == AbsMsgImageActivity.this.aqg) {
                    if (AbsMsgImageActivity.this.dtI.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view == AbsMsgImageActivity.this.dtH) {
                    if (AbsMsgImageActivity.this.dtI.getVisibility() != 8) {
                        try {
                            byte[] currentImageData = AbsMsgImageActivity.this.dtJ.getCurrentImageData();
                            if (currentImageData != null) {
                                String currentImageUrl = AbsMsgImageActivity.this.dtJ.getCurrentImageUrl();
                                AbsMsgImageActivity.this.dtG = new a(currentImageUrl, currentImageData);
                                AbsMsgImageActivity.this.dtG.execute(new String[0]);
                                AbsMsgImageActivity.this.dtH.setClickable(false);
                            } else {
                                AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(d.j.no_data));
                            }
                        } catch (Exception e) {
                        }
                    }
                } else if (AbsMsgImageActivity.this.dtM) {
                    if (AbsMsgImageActivity.this.dtI.getVisibility() != 0) {
                        AbsMsgImageActivity.this.dtI.setVisibility(0);
                        AbsMsgImageActivity.this.dtJ.Bb();
                        AbsMsgImageActivity.this.dtL = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.dtL = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.dtN = true;
                        AbsMsgImageActivity.this.dtJ.Bc();
                    }
                    AbsMsgImageActivity.this.dtL.setDuration(300L);
                    AbsMsgImageActivity.this.dtL.setFillAfter(true);
                    AbsMsgImageActivity.this.dtL.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.dtM = true;
                            if (AbsMsgImageActivity.this.dtN) {
                                AbsMsgImageActivity.this.dtN = false;
                                AbsMsgImageActivity.this.dtI.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.dtM = false;
                    AbsMsgImageActivity.this.dtI.startAnimation(AbsMsgImageActivity.this.dtL);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.bh(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.anl();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.dtR > 300000000 && AbsMsgImageActivity.this.dtF != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.dtF.size()) {
                    AbsMsgImageActivity.this.dtS.put(AbsMsgImageActivity.this.dtF.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.dtK = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void cZ(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0047b interfaceC0047b = new b.InterfaceC0047b() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
            public void a(b bVar, int i, View view) {
                if (bVar == AbsMsgImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            try {
                                byte[] currentImageData = AbsMsgImageActivity.this.dtJ.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.dtJ.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.dtG = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.dtG.execute(new String[0]);
                                    AbsMsgImageActivity.this.dtH.setClickable(false);
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
                AbsMsgImageActivity.this.createListMenu(new String[]{AbsMsgImageActivity.this.getPageContext().getString(d.j.save)}, interfaceC0047b);
                AbsMsgImageActivity.this.showListMenu();
                return false;
            }
        };
        this.dtI = (NavigationBar) findViewById(d.g.navigation_bar);
        this.dtH = (FrameLayout) this.dtI.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.image_activity_save_button, this.mOnClickListener);
        if (this.dtU) {
            this.dtH.setVisibility(8);
        }
        this.aqg = this.dtI.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.abE = this.dtI.setTitleText("");
        this.dtJ = (MultiImageView) findViewById(d.g.viewpager);
        this.dtJ.setPageMargin(l.dip2px(getPageContext().getContext(), 8.0f));
        this.dtJ.H(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.dtJ.setOnPageChangeListener(this.mOnPageChangeListener);
        this.dtJ.setItemOnclickListener(this.mOnClickListener);
        this.dtJ.setCurrentItem(auW(), false);
        this.dtJ.setOnScrollOutListener(this.dtK);
        this.dtJ.setItemOnLongClickListener(onLongClickListener);
        this.dtJ.setHasNext(false);
        this.dtJ.setNextTitle("mNextTitle");
        this.dtJ.setIsFromCDN(true);
        this.dtJ.setAllowLocalUrl(true);
        bh(this.mIndex, this.mIndex);
        this.abE.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anl() {
        if (this.dtF != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.dtJ.getHasNext() && this.mIndex == this.dtJ.getItemNum() - 1) {
                this.abE.setText(getPageContext().getString(d.j.image_recommend));
                this.dtH.setClickable(false);
                return;
            }
            this.abE.setText(valueOf);
            this.dtH.setClickable(true);
        }
    }

    private int auW() {
        if (this.dtF != null && this.dtF.size() > 0) {
            int size = this.dtF.size();
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
            this.dtO = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.dtP = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.dtQ = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.dtU = intent.getBooleanExtra("isSingle", false);
            if (this.dtQ == null) {
                this.dtQ = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.dtO == null) {
                this.dtO = "";
            }
            this.dtF = new LinkedHashMap<>();
            this.dtF.put(this.dtQ, this.dtO);
            this.dtT = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.dtF = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.dtQ = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.dtT = bundle.getInt("chat_mode", 0);
            this.dtU = bundle.getBoolean("isSingle", false);
            if (this.dtQ == null) {
                this.dtQ = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.dtS = new HashMap<>();
    }

    private void auX() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.dtU) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.dtO)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.dtQ, AbsMsgImageActivity.this.dtO);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.dtP;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.dtO, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = AbsMsgImageActivity.this.dtQ;
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
                    AbsMsgImageActivity.this.abE.setVisibility(0);
                    AbsMsgImageActivity.this.anl();
                    AbsMsgImageActivity.this.dtJ.setIsFromCDN(true);
                    AbsMsgImageActivity.this.dtJ.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.dtJ.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.dtJ.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.dtJ.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.dtF);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.dtQ);
        bundle.putInt("chat_mode", this.dtT);
        bundle.putBoolean("isSingle", this.dtU);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.dtJ.setCurrentItem(this.mIndex, true);
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
            AbsMsgImageActivity.this.dtG = null;
            AbsMsgImageActivity.this.dtH.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.dtG = null;
            AbsMsgImageActivity.this.dtH.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bh(int i, int i2) {
        synchronized (this.dtS) {
            if (System.nanoTime() - this.dtR > 300000000 && this.dtF != null && i < this.dtF.size()) {
                this.dtS.put(this.dtF.get("" + i), true);
            }
            this.dtR = System.nanoTime();
        }
    }
}
