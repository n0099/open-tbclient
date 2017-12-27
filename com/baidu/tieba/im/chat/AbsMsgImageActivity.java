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
    private FrameLayout eoF;
    private String eoN;
    private boolean eoS;
    private int mCount;
    private LinkedHashMap<String, String> eoD = null;
    private int mIndex = 0;
    private a eoE = null;
    private View beD = null;
    private TextView rz = null;
    private NavigationBar eoG = null;
    private MultiImageView eoH = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a eoI = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation eoJ = null;
    private boolean eoK = true;
    private boolean eoL = false;
    private String eoM = "";
    private String id = "";
    private String eoO = "";
    private long eoP = 0;
    private HashMap<String, Boolean> eoQ = null;
    private int eoR = 0;

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
        aDH();
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
        aDH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.t(this.eoH, d.C0108d.black_alpha100);
        aj.t(this.eoG, d.C0108d.common_color_10222);
        getLayoutMode().aM(this.beD);
        getLayoutMode().aM(this.rz);
        getLayoutMode().aM(this.eoF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eoH.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eoH.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.eoH.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        cb(this.mIndex, this.mIndex);
        this.eoH.onDestroy();
        if (this.eoE != null) {
            this.eoE.cancel();
            this.eoE = null;
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
                if (view == AbsMsgImageActivity.this.beD) {
                    if (AbsMsgImageActivity.this.eoG.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view == AbsMsgImageActivity.this.eoF) {
                    if (AbsMsgImageActivity.this.eoG.getVisibility() != 8) {
                        try {
                            byte[] currentImageData = AbsMsgImageActivity.this.eoH.getCurrentImageData();
                            if (currentImageData != null) {
                                String currentImageUrl = AbsMsgImageActivity.this.eoH.getCurrentImageUrl();
                                AbsMsgImageActivity.this.eoE = new a(currentImageUrl, currentImageData);
                                AbsMsgImageActivity.this.eoE.execute(new String[0]);
                                AbsMsgImageActivity.this.eoF.setClickable(false);
                            } else {
                                AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(d.j.no_data));
                            }
                        } catch (Exception e) {
                        }
                    }
                } else if (AbsMsgImageActivity.this.eoK) {
                    if (AbsMsgImageActivity.this.eoG.getVisibility() != 0) {
                        AbsMsgImageActivity.this.eoG.setVisibility(0);
                        AbsMsgImageActivity.this.eoH.IO();
                        AbsMsgImageActivity.this.eoJ = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.eoJ = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.eoL = true;
                        AbsMsgImageActivity.this.eoH.IP();
                    }
                    AbsMsgImageActivity.this.eoJ.setDuration(300L);
                    AbsMsgImageActivity.this.eoJ.setFillAfter(true);
                    AbsMsgImageActivity.this.eoJ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.eoK = true;
                            if (AbsMsgImageActivity.this.eoL) {
                                AbsMsgImageActivity.this.eoL = false;
                                AbsMsgImageActivity.this.eoG.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.eoK = false;
                    AbsMsgImageActivity.this.eoG.startAnimation(AbsMsgImageActivity.this.eoJ);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.cb(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.awo();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.eoP > 300000000 && AbsMsgImageActivity.this.eoD != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.eoD.size()) {
                    AbsMsgImageActivity.this.eoQ.put(AbsMsgImageActivity.this.eoD.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.eoI = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void fZ(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0074b interfaceC0074b = new b.InterfaceC0074b() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0074b
            public void a(b bVar, int i, View view) {
                if (bVar == AbsMsgImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            try {
                                byte[] currentImageData = AbsMsgImageActivity.this.eoH.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.eoH.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.eoE = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.eoE.execute(new String[0]);
                                    AbsMsgImageActivity.this.eoF.setClickable(false);
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
                AbsMsgImageActivity.this.createListMenu(new String[]{AbsMsgImageActivity.this.getPageContext().getString(d.j.save)}, interfaceC0074b);
                AbsMsgImageActivity.this.showListMenu();
                return false;
            }
        };
        this.eoG = (NavigationBar) findViewById(d.g.navigation_bar);
        this.eoF = (FrameLayout) this.eoG.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.image_activity_save_button, this.mOnClickListener);
        if (this.eoS) {
            this.eoF.setVisibility(8);
        }
        this.beD = this.eoG.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.rz = this.eoG.setTitleText("");
        this.eoH = (MultiImageView) findViewById(d.g.viewpager);
        this.eoH.setPageMargin(l.dip2px(getPageContext().getContext(), 8.0f));
        this.eoH.aF(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.eoH.setOnPageChangeListener(this.mOnPageChangeListener);
        this.eoH.setItemOnclickListener(this.mOnClickListener);
        this.eoH.setCurrentItem(aDG(), false);
        this.eoH.setOnScrollOutListener(this.eoI);
        this.eoH.setItemOnLongClickListener(onLongClickListener);
        this.eoH.setHasNext(false);
        this.eoH.setNextTitle("mNextTitle");
        this.eoH.setIsFromCDN(true);
        this.eoH.setAllowLocalUrl(true);
        cb(this.mIndex, this.mIndex);
        this.rz.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awo() {
        if (this.eoD != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.eoH.getHasNext() && this.mIndex == this.eoH.getItemNum() - 1) {
                this.rz.setText(getPageContext().getString(d.j.image_recommend));
                this.eoF.setClickable(false);
                return;
            }
            this.rz.setText(valueOf);
            this.eoF.setClickable(true);
        }
    }

    private int aDG() {
        if (this.eoD != null && this.eoD.size() > 0) {
            int size = this.eoD.size();
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
            this.eoM = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.eoN = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.eoO = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.eoS = intent.getBooleanExtra("isSingle", false);
            if (this.eoO == null) {
                this.eoO = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.eoM == null) {
                this.eoM = "";
            }
            this.eoD = new LinkedHashMap<>();
            this.eoD.put(this.eoO, this.eoM);
            this.eoR = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.eoD = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.eoO = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.eoR = bundle.getInt("chat_mode", 0);
            this.eoS = bundle.getBoolean("isSingle", false);
            if (this.eoO == null) {
                this.eoO = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.eoQ = new HashMap<>();
    }

    private void aDH() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.eoS) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.eoM)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.eoO, AbsMsgImageActivity.this.eoM);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.eoN;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.eoM, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = AbsMsgImageActivity.this.eoO;
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
                    AbsMsgImageActivity.this.awo();
                    AbsMsgImageActivity.this.eoH.setIsFromCDN(true);
                    AbsMsgImageActivity.this.eoH.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.eoH.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.eoH.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.eoH.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.eoD);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.eoO);
        bundle.putInt("chat_mode", this.eoR);
        bundle.putBoolean("isSingle", this.eoS);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.eoH.setCurrentItem(this.mIndex, true);
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
                    return k.BH();
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
            AbsMsgImageActivity.this.eoE = null;
            AbsMsgImageActivity.this.eoF.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.eoE = null;
            AbsMsgImageActivity.this.eoF.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb(int i, int i2) {
        synchronized (this.eoQ) {
            if (System.nanoTime() - this.eoP > 300000000 && this.eoD != null && i < this.eoD.size()) {
                this.eoQ.put(this.eoD.get("" + i), true);
            }
            this.eoP = System.nanoTime();
        }
    }
}
