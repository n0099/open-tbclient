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
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public abstract class AbsMsgImageActivity extends BaseActivity<AbsMsgImageActivity> {
    private com.baidu.tbadk.core.util.b.a biP;
    private FrameLayout ebI;
    private String ebQ;
    private boolean ebV;
    private int mCount;
    private LinkedHashMap<String, String> ebG = null;
    private int mIndex = 0;
    private a ebH = null;
    private View aAn = null;
    private TextView mTextView = null;
    private NavigationBar ebJ = null;
    private MultiImageView ebK = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a ebL = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation ebM = null;
    private boolean ebN = true;
    private boolean ebO = false;
    private String ebP = "";
    private String id = "";
    private String ebR = "";
    private long ebS = 0;
    private HashMap<String, Boolean> ebT = null;
    private int ebU = 0;

    protected abstract void a(String str, com.baidu.tieba.im.sendmessage.c cVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(d.i.image_activity_2);
        initData(bundle);
        initUI();
        aFe();
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
        aFe();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.j(this.ebK, d.C0141d.black_alpha100);
        al.j(this.ebJ, d.C0141d.common_color_10222);
        getLayoutMode().onModeChanged(this.aAn);
        getLayoutMode().onModeChanged(this.mTextView);
        getLayoutMode().onModeChanged(this.ebI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.ebK.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.ebK.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.ebK.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        bc(this.mIndex, this.mIndex);
        this.ebK.onDestroy();
        if (this.ebH != null) {
            this.ebH.cancel();
            this.ebH = null;
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
                if (view == AbsMsgImageActivity.this.aAn) {
                    if (AbsMsgImageActivity.this.ebJ.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view == AbsMsgImageActivity.this.ebI) {
                    if (AbsMsgImageActivity.this.ebJ.getVisibility() != 8) {
                        Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                        if (AbsMsgImageActivity.this.biP == null) {
                            AbsMsgImageActivity.this.biP = new com.baidu.tbadk.core.util.b.a();
                        }
                        AbsMsgImageActivity.this.biP.zU();
                        AbsMsgImageActivity.this.biP.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!AbsMsgImageActivity.this.biP.u(pageActivity)) {
                            try {
                                byte[] currentImageData = AbsMsgImageActivity.this.ebK.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.ebK.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.ebH = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.ebH.execute(new String[0]);
                                    AbsMsgImageActivity.this.ebI.setClickable(false);
                                } else {
                                    AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(d.k.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (AbsMsgImageActivity.this.ebN) {
                    if (AbsMsgImageActivity.this.ebJ.getVisibility() != 0) {
                        AbsMsgImageActivity.this.ebJ.setVisibility(0);
                        AbsMsgImageActivity.this.ebK.FA();
                        AbsMsgImageActivity.this.ebM = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.ebM = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.ebO = true;
                        AbsMsgImageActivity.this.ebK.FB();
                    }
                    AbsMsgImageActivity.this.ebM.setDuration(300L);
                    AbsMsgImageActivity.this.ebM.setFillAfter(true);
                    AbsMsgImageActivity.this.ebM.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.ebN = true;
                            if (AbsMsgImageActivity.this.ebO) {
                                AbsMsgImageActivity.this.ebO = false;
                                AbsMsgImageActivity.this.ebJ.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.ebN = false;
                    AbsMsgImageActivity.this.ebJ.startAnimation(AbsMsgImageActivity.this.ebM);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.bc(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.axp();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.ebS > 300000000 && AbsMsgImageActivity.this.ebG != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.ebG.size()) {
                    AbsMsgImageActivity.this.ebT.put(AbsMsgImageActivity.this.ebG.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.ebL = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void db(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0103b interfaceC0103b = new b.InterfaceC0103b() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0103b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar == AbsMsgImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            try {
                                Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                                if (AbsMsgImageActivity.this.biP == null) {
                                    AbsMsgImageActivity.this.biP = new com.baidu.tbadk.core.util.b.a();
                                }
                                AbsMsgImageActivity.this.biP.zU();
                                AbsMsgImageActivity.this.biP.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                                if (!AbsMsgImageActivity.this.biP.u(pageActivity)) {
                                    byte[] currentImageData = AbsMsgImageActivity.this.ebK.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = AbsMsgImageActivity.this.ebK.getCurrentImageUrl();
                                        AbsMsgImageActivity.this.ebH = new a(currentImageUrl, currentImageData);
                                        AbsMsgImageActivity.this.ebH.execute(new String[0]);
                                        AbsMsgImageActivity.this.ebI.setClickable(false);
                                        break;
                                    } else {
                                        AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(d.k.no_data));
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
                AbsMsgImageActivity.this.createListMenu(new String[]{AbsMsgImageActivity.this.getPageContext().getString(d.k.save)}, interfaceC0103b);
                AbsMsgImageActivity.this.showListMenu();
                return false;
            }
        };
        this.ebJ = (NavigationBar) findViewById(d.g.navigation_bar);
        this.ebI = (FrameLayout) this.ebJ.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.image_activity_save_button, this.mOnClickListener);
        if (this.ebV) {
            this.ebI.setVisibility(8);
        }
        this.aAn = this.ebJ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        al.c(this.ebJ.getBackImageView(), d.f.icon_return_bg);
        this.mTextView = this.ebJ.setTitleText("");
        this.ebK = (MultiImageView) findViewById(d.g.viewpager);
        this.ebK.setPageMargin(l.dip2px(getPageContext().getContext(), 8.0f));
        this.ebK.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.ebK.setOnPageChangeListener(this.mOnPageChangeListener);
        this.ebK.setItemOnclickListener(this.mOnClickListener);
        this.ebK.setCurrentItem(aFd(), false);
        this.ebK.setOnScrollOutListener(this.ebL);
        this.ebK.setItemOnLongClickListener(onLongClickListener);
        this.ebK.setHasNext(false);
        this.ebK.setNextTitle("mNextTitle");
        this.ebK.setIsFromCDN(true);
        this.ebK.setAllowLocalUrl(true);
        bc(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axp() {
        if (this.ebG != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.ebK.getHasNext() && this.mIndex == this.ebK.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(d.k.image_recommend));
                this.ebI.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.ebI.setClickable(true);
        }
    }

    private int aFd() {
        if (this.ebG != null && this.ebG.size() > 0) {
            int size = this.ebG.size();
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
            this.ebP = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.ebQ = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.ebR = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.ebV = intent.getBooleanExtra("isSingle", false);
            if (this.ebR == null) {
                this.ebR = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.ebP == null) {
                this.ebP = "";
            }
            this.ebG = new LinkedHashMap<>();
            this.ebG.put(this.ebR, this.ebP);
            this.ebU = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.ebG = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.ebR = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.ebU = bundle.getInt("chat_mode", 0);
            this.ebV = bundle.getBoolean("isSingle", false);
            if (this.ebR == null) {
                this.ebR = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.ebT = new HashMap<>();
    }

    private void aFe() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.ebV) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.ebP)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.ebR, AbsMsgImageActivity.this.ebP);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.ebQ;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.ebP, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = AbsMsgImageActivity.this.ebR;
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
                    AbsMsgImageActivity.this.axp();
                    AbsMsgImageActivity.this.ebK.setIsFromCDN(true);
                    AbsMsgImageActivity.this.ebK.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.ebK.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.ebK.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.ebK.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.ebG);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.ebR);
        bundle.putInt("chat_mode", this.ebU);
        bundle.putBoolean("isSingle", this.ebV);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.ebK.setCurrentItem(this.mIndex, true);
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
            switch (com.baidu.tbadk.core.util.l.a(this.mUrl, this.mData, AbsMsgImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.l.yc();
                case -1:
                default:
                    return AbsMsgImageActivity.this.getPageContext().getString(d.k.save_fail);
                case 0:
                    return AbsMsgImageActivity.this.getPageContext().getString(d.k.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            AbsMsgImageActivity.this.ebH = null;
            AbsMsgImageActivity.this.ebI.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.ebH = null;
            AbsMsgImageActivity.this.ebI.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bc(int i, int i2) {
        synchronized (this.ebT) {
            if (System.nanoTime() - this.ebS > 300000000 && this.ebG != null && i < this.ebG.size()) {
                this.ebT.put(this.ebG.get("" + i), true);
            }
            this.ebS = System.nanoTime();
        }
    }
}
