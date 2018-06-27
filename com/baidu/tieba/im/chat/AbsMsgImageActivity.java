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
import com.baidu.tbadk.core.util.am;
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
    private com.baidu.tbadk.core.util.b.a bkp;
    private FrameLayout efC;
    private String efK;
    private boolean efP;
    private int mCount;
    private LinkedHashMap<String, String> efA = null;
    private int mIndex = 0;
    private a efB = null;
    private View aBf = null;
    private TextView mTextView = null;
    private NavigationBar efD = null;
    private MultiImageView efE = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a efF = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation efG = null;
    private boolean efH = true;
    private boolean efI = false;
    private String efJ = "";
    private String id = "";
    private String efL = "";
    private long efM = 0;
    private HashMap<String, Boolean> efN = null;
    private int efO = 0;

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
        aFM();
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
        aFM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.j(this.efE, d.C0142d.black_alpha100);
        am.j(this.efD, d.C0142d.common_color_10222);
        getLayoutMode().onModeChanged(this.aBf);
        getLayoutMode().onModeChanged(this.mTextView);
        getLayoutMode().onModeChanged(this.efC);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.efE.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.efE.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.efE.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        bb(this.mIndex, this.mIndex);
        this.efE.onDestroy();
        if (this.efB != null) {
            this.efB.cancel();
            this.efB = null;
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
                if (view == AbsMsgImageActivity.this.aBf) {
                    if (AbsMsgImageActivity.this.efD.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view == AbsMsgImageActivity.this.efC) {
                    if (AbsMsgImageActivity.this.efD.getVisibility() != 8) {
                        Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                        if (AbsMsgImageActivity.this.bkp == null) {
                            AbsMsgImageActivity.this.bkp = new com.baidu.tbadk.core.util.b.a();
                        }
                        AbsMsgImageActivity.this.bkp.Aj();
                        AbsMsgImageActivity.this.bkp.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!AbsMsgImageActivity.this.bkp.u(pageActivity)) {
                            try {
                                byte[] currentImageData = AbsMsgImageActivity.this.efE.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.efE.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.efB = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.efB.execute(new String[0]);
                                    AbsMsgImageActivity.this.efC.setClickable(false);
                                } else {
                                    AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(d.k.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (AbsMsgImageActivity.this.efH) {
                    if (AbsMsgImageActivity.this.efD.getVisibility() != 0) {
                        AbsMsgImageActivity.this.efD.setVisibility(0);
                        AbsMsgImageActivity.this.efE.FS();
                        AbsMsgImageActivity.this.efG = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.efG = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.efI = true;
                        AbsMsgImageActivity.this.efE.FT();
                    }
                    AbsMsgImageActivity.this.efG.setDuration(300L);
                    AbsMsgImageActivity.this.efG.setFillAfter(true);
                    AbsMsgImageActivity.this.efG.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.efH = true;
                            if (AbsMsgImageActivity.this.efI) {
                                AbsMsgImageActivity.this.efI = false;
                                AbsMsgImageActivity.this.efD.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.efH = false;
                    AbsMsgImageActivity.this.efD.startAnimation(AbsMsgImageActivity.this.efG);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.bb(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.axT();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.efM > 300000000 && AbsMsgImageActivity.this.efA != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.efA.size()) {
                    AbsMsgImageActivity.this.efN.put(AbsMsgImageActivity.this.efA.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.efF = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void dc(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0104b interfaceC0104b = new b.InterfaceC0104b() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0104b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar == AbsMsgImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            try {
                                Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                                if (AbsMsgImageActivity.this.bkp == null) {
                                    AbsMsgImageActivity.this.bkp = new com.baidu.tbadk.core.util.b.a();
                                }
                                AbsMsgImageActivity.this.bkp.Aj();
                                AbsMsgImageActivity.this.bkp.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                                if (!AbsMsgImageActivity.this.bkp.u(pageActivity)) {
                                    byte[] currentImageData = AbsMsgImageActivity.this.efE.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = AbsMsgImageActivity.this.efE.getCurrentImageUrl();
                                        AbsMsgImageActivity.this.efB = new a(currentImageUrl, currentImageData);
                                        AbsMsgImageActivity.this.efB.execute(new String[0]);
                                        AbsMsgImageActivity.this.efC.setClickable(false);
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
                AbsMsgImageActivity.this.createListMenu(new String[]{AbsMsgImageActivity.this.getPageContext().getString(d.k.save)}, interfaceC0104b);
                AbsMsgImageActivity.this.showListMenu();
                return false;
            }
        };
        this.efD = (NavigationBar) findViewById(d.g.navigation_bar);
        this.efC = (FrameLayout) this.efD.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.image_activity_save_button, this.mOnClickListener);
        if (this.efP) {
            this.efC.setVisibility(8);
        }
        this.aBf = this.efD.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        am.c(this.efD.getBackImageView(), d.f.icon_return_bg);
        this.mTextView = this.efD.setTitleText("");
        this.efE = (MultiImageView) findViewById(d.g.viewpager);
        this.efE.setPageMargin(l.dip2px(getPageContext().getContext(), 8.0f));
        this.efE.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.efE.setOnPageChangeListener(this.mOnPageChangeListener);
        this.efE.setItemOnclickListener(this.mOnClickListener);
        this.efE.setCurrentItem(aFL(), false);
        this.efE.setOnScrollOutListener(this.efF);
        this.efE.setItemOnLongClickListener(onLongClickListener);
        this.efE.setHasNext(false);
        this.efE.setNextTitle("mNextTitle");
        this.efE.setIsFromCDN(true);
        this.efE.setAllowLocalUrl(true);
        bb(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axT() {
        if (this.efA != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.efE.getHasNext() && this.mIndex == this.efE.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(d.k.image_recommend));
                this.efC.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.efC.setClickable(true);
        }
    }

    private int aFL() {
        if (this.efA != null && this.efA.size() > 0) {
            int size = this.efA.size();
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
            this.efJ = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.efK = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.efL = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.efP = intent.getBooleanExtra("isSingle", false);
            if (this.efL == null) {
                this.efL = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.efJ == null) {
                this.efJ = "";
            }
            this.efA = new LinkedHashMap<>();
            this.efA.put(this.efL, this.efJ);
            this.efO = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.efA = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.efL = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.efO = bundle.getInt("chat_mode", 0);
            this.efP = bundle.getBoolean("isSingle", false);
            if (this.efL == null) {
                this.efL = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.efN = new HashMap<>();
    }

    private void aFM() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.efP) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.efJ)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.efL, AbsMsgImageActivity.this.efJ);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.efK;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.efJ, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = AbsMsgImageActivity.this.efL;
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
                    AbsMsgImageActivity.this.axT();
                    AbsMsgImageActivity.this.efE.setIsFromCDN(true);
                    AbsMsgImageActivity.this.efE.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.efE.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.efE.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.efE.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.efA);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.efL);
        bundle.putInt("chat_mode", this.efO);
        bundle.putBoolean("isSingle", this.efP);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.efE.setCurrentItem(this.mIndex, true);
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
                    return com.baidu.tbadk.core.util.l.yq();
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
            AbsMsgImageActivity.this.efB = null;
            AbsMsgImageActivity.this.efC.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.efB = null;
            AbsMsgImageActivity.this.efC.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb(int i, int i2) {
        synchronized (this.efN) {
            if (System.nanoTime() - this.efM > 300000000 && this.efA != null && i < this.efA.size()) {
                this.efN.put(this.efA.get("" + i), true);
            }
            this.efM = System.nanoTime();
        }
    }
}
