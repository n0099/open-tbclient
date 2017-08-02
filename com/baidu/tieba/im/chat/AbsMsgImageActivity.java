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
import com.baidu.tbadk.core.util.ai;
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
    private FrameLayout deH;
    private String deP;
    private boolean deU;
    private int mCount;
    private LinkedHashMap<String, String> deF = null;
    private int mIndex = 0;
    private a deG = null;
    private View apT = null;
    private TextView mTextView = null;
    private NavigationBar deI = null;
    private MultiImageView deJ = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a deK = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation deL = null;
    private boolean deM = true;
    private boolean deN = false;
    private String deO = "";
    private String id = "";
    private String deQ = "";
    private long deR = 0;
    private HashMap<String, Boolean> deS = null;
    private int deT = 0;

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
        aqY();
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
        aqY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.deJ.setBackgroundColor(ai.cO(i));
        } else {
            this.deJ.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        ai.k(this.deI, d.e.common_color_10222);
        getLayoutMode().t(this.apT);
        getLayoutMode().t(this.mTextView);
        getLayoutMode().t(this.deH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.deJ.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.deJ.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.deJ.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        aO(this.mIndex, this.mIndex);
        this.deJ.onDestroy();
        if (this.deG != null) {
            this.deG.cancel();
            this.deG = null;
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
                if (view == AbsMsgImageActivity.this.apT) {
                    if (AbsMsgImageActivity.this.deI.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view == AbsMsgImageActivity.this.deH) {
                    if (AbsMsgImageActivity.this.deI.getVisibility() != 8) {
                        try {
                            byte[] currentImageData = AbsMsgImageActivity.this.deJ.getCurrentImageData();
                            if (currentImageData != null) {
                                String currentImageUrl = AbsMsgImageActivity.this.deJ.getCurrentImageUrl();
                                AbsMsgImageActivity.this.deG = new a(currentImageUrl, currentImageData);
                                AbsMsgImageActivity.this.deG.execute(new String[0]);
                                AbsMsgImageActivity.this.deH.setClickable(false);
                            } else {
                                AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(d.l.no_data));
                            }
                        } catch (Exception e) {
                        }
                    }
                } else if (AbsMsgImageActivity.this.deM) {
                    if (AbsMsgImageActivity.this.deI.getVisibility() != 0) {
                        AbsMsgImageActivity.this.deI.setVisibility(0);
                        AbsMsgImageActivity.this.deJ.Bl();
                        AbsMsgImageActivity.this.deL = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.deL = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.deN = true;
                        AbsMsgImageActivity.this.deJ.Bm();
                    }
                    AbsMsgImageActivity.this.deL.setDuration(300L);
                    AbsMsgImageActivity.this.deL.setFillAfter(true);
                    AbsMsgImageActivity.this.deL.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.deM = true;
                            if (AbsMsgImageActivity.this.deN) {
                                AbsMsgImageActivity.this.deN = false;
                                AbsMsgImageActivity.this.deI.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.deM = false;
                    AbsMsgImageActivity.this.deI.startAnimation(AbsMsgImageActivity.this.deL);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.aO(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.aqW();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.deR > 300000000 && AbsMsgImageActivity.this.deF != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.deF.size()) {
                    AbsMsgImageActivity.this.deS.put(AbsMsgImageActivity.this.deF.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.deK = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void cZ(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0043b interfaceC0043b = new b.InterfaceC0043b() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
            public void a(b bVar, int i, View view) {
                if (bVar == AbsMsgImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            try {
                                byte[] currentImageData = AbsMsgImageActivity.this.deJ.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.deJ.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.deG = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.deG.execute(new String[0]);
                                    AbsMsgImageActivity.this.deH.setClickable(false);
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
                AbsMsgImageActivity.this.createListMenu(new String[]{AbsMsgImageActivity.this.getPageContext().getString(d.l.save)}, interfaceC0043b);
                AbsMsgImageActivity.this.showListMenu();
                return false;
            }
        };
        this.deI = (NavigationBar) findViewById(d.h.navigation_bar);
        this.deH = (FrameLayout) this.deI.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.image_activity_save_button, this.mOnClickListener);
        if (this.deU) {
            this.deH.setVisibility(8);
        }
        this.apT = this.deI.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.mTextView = this.deI.setTitleText("");
        this.deJ = (MultiImageView) findViewById(d.h.viewpager);
        this.deJ.setPageMargin(k.dip2px(getPageContext().getContext(), 8.0f));
        this.deJ.I(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.deJ.setOnPageChangeListener(this.mOnPageChangeListener);
        this.deJ.setItemOnclickListener(this.mOnClickListener);
        this.deJ.setCurrentItem(aqX(), false);
        this.deJ.setOnScrollOutListener(this.deK);
        this.deJ.setItemOnLongClickListener(onLongClickListener);
        this.deJ.setHasNext(false);
        this.deJ.setNextTitle("mNextTitle");
        this.deJ.setIsFromCDN(true);
        this.deJ.setAllowLocalUrl(true);
        aO(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqW() {
        if (this.deF != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.deJ.getHasNext() && this.mIndex == this.deJ.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(d.l.image_recommend));
                this.deH.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.deH.setClickable(true);
        }
    }

    private int aqX() {
        if (this.deF != null && this.deF.size() > 0) {
            int size = this.deF.size();
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
            this.deO = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.deP = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.deQ = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.deU = intent.getBooleanExtra("isSingle", false);
            if (this.deQ == null) {
                this.deQ = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.deO == null) {
                this.deO = "";
            }
            this.deF = new LinkedHashMap<>();
            this.deF.put(this.deQ, this.deO);
            this.deT = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.deF = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.deQ = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.deT = bundle.getInt("chat_mode", 0);
            this.deU = bundle.getBoolean("isSingle", false);
            if (this.deQ == null) {
                this.deQ = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.deS = new HashMap<>();
    }

    private void aqY() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.deU) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.deO)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.deQ, AbsMsgImageActivity.this.deO);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.deP;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.deO, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = AbsMsgImageActivity.this.deQ;
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
                    AbsMsgImageActivity.this.aqW();
                    AbsMsgImageActivity.this.deJ.setIsFromCDN(true);
                    AbsMsgImageActivity.this.deJ.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.deJ.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.deJ.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.deJ.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.deF);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.deQ);
        bundle.putInt("chat_mode", this.deT);
        bundle.putBoolean("isSingle", this.deU);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.deJ.setCurrentItem(this.mIndex, true);
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<String, Integer, String> {
        String mUrl;
        byte[] rK;

        public a(String str, byte[] bArr) {
            this.mUrl = null;
            this.rK = null;
            this.mUrl = str;
            this.rK = bArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            switch (com.baidu.tbadk.core.util.k.a(this.mUrl, this.rK, AbsMsgImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.k.uy();
                case -1:
                default:
                    return AbsMsgImageActivity.this.getPageContext().getString(d.l.save_error);
                case 0:
                    return AbsMsgImageActivity.this.getPageContext().getString(d.l.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            AbsMsgImageActivity.this.deG = null;
            AbsMsgImageActivity.this.deH.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.deG = null;
            AbsMsgImageActivity.this.deH.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO(int i, int i2) {
        synchronized (this.deS) {
            if (System.nanoTime() - this.deR > 300000000 && this.deF != null && i < this.deF.size()) {
                this.deS.put(this.deF.get("" + i), true);
            }
            this.deR = System.nanoTime();
        }
    }
}
