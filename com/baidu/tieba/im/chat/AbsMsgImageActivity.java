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
    private FrameLayout dlK;
    private String dlS;
    private boolean dlX;
    private int mCount;
    private LinkedHashMap<String, String> dlI = null;
    private int mIndex = 0;
    private a dlJ = null;
    private View apY = null;
    private TextView abv = null;
    private NavigationBar dlL = null;
    private MultiImageView dlM = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a dlN = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation dlO = null;
    private boolean dlP = true;
    private boolean dlQ = false;
    private String dlR = "";
    private String id = "";
    private String dlT = "";
    private long dlU = 0;
    private HashMap<String, Boolean> dlV = null;
    private int dlW = 0;

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
        asq();
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
        asq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.dlM.setBackgroundColor(aj.cP(i));
        } else {
            this.dlM.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        aj.k(this.dlL, d.e.common_color_10222);
        getLayoutMode().t(this.apY);
        getLayoutMode().t(this.abv);
        getLayoutMode().t(this.dlK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.dlM.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dlM.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.dlM.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        bg(this.mIndex, this.mIndex);
        this.dlM.onDestroy();
        if (this.dlJ != null) {
            this.dlJ.cancel();
            this.dlJ = null;
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
                if (view == AbsMsgImageActivity.this.apY) {
                    if (AbsMsgImageActivity.this.dlL.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view == AbsMsgImageActivity.this.dlK) {
                    if (AbsMsgImageActivity.this.dlL.getVisibility() != 8) {
                        try {
                            byte[] currentImageData = AbsMsgImageActivity.this.dlM.getCurrentImageData();
                            if (currentImageData != null) {
                                String currentImageUrl = AbsMsgImageActivity.this.dlM.getCurrentImageUrl();
                                AbsMsgImageActivity.this.dlJ = new a(currentImageUrl, currentImageData);
                                AbsMsgImageActivity.this.dlJ.execute(new String[0]);
                                AbsMsgImageActivity.this.dlK.setClickable(false);
                            } else {
                                AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(d.l.no_data));
                            }
                        } catch (Exception e) {
                        }
                    }
                } else if (AbsMsgImageActivity.this.dlP) {
                    if (AbsMsgImageActivity.this.dlL.getVisibility() != 0) {
                        AbsMsgImageActivity.this.dlL.setVisibility(0);
                        AbsMsgImageActivity.this.dlM.AM();
                        AbsMsgImageActivity.this.dlO = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.dlO = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.dlQ = true;
                        AbsMsgImageActivity.this.dlM.AN();
                    }
                    AbsMsgImageActivity.this.dlO.setDuration(300L);
                    AbsMsgImageActivity.this.dlO.setFillAfter(true);
                    AbsMsgImageActivity.this.dlO.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.dlP = true;
                            if (AbsMsgImageActivity.this.dlQ) {
                                AbsMsgImageActivity.this.dlQ = false;
                                AbsMsgImageActivity.this.dlL.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.dlP = false;
                    AbsMsgImageActivity.this.dlL.startAnimation(AbsMsgImageActivity.this.dlO);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.bg(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.aso();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.dlU > 300000000 && AbsMsgImageActivity.this.dlI != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.dlI.size()) {
                    AbsMsgImageActivity.this.dlV.put(AbsMsgImageActivity.this.dlI.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.dlN = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void da(int i) {
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
                                byte[] currentImageData = AbsMsgImageActivity.this.dlM.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.dlM.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.dlJ = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.dlJ.execute(new String[0]);
                                    AbsMsgImageActivity.this.dlK.setClickable(false);
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
                AbsMsgImageActivity.this.createListMenu(new String[]{AbsMsgImageActivity.this.getPageContext().getString(d.l.save)}, interfaceC0047b);
                AbsMsgImageActivity.this.showListMenu();
                return false;
            }
        };
        this.dlL = (NavigationBar) findViewById(d.h.navigation_bar);
        this.dlK = (FrameLayout) this.dlL.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.image_activity_save_button, this.mOnClickListener);
        if (this.dlX) {
            this.dlK.setVisibility(8);
        }
        this.apY = this.dlL.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.abv = this.dlL.setTitleText("");
        this.dlM = (MultiImageView) findViewById(d.h.viewpager);
        this.dlM.setPageMargin(l.dip2px(getPageContext().getContext(), 8.0f));
        this.dlM.H(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.dlM.setOnPageChangeListener(this.mOnPageChangeListener);
        this.dlM.setItemOnclickListener(this.mOnClickListener);
        this.dlM.setCurrentItem(asp(), false);
        this.dlM.setOnScrollOutListener(this.dlN);
        this.dlM.setItemOnLongClickListener(onLongClickListener);
        this.dlM.setHasNext(false);
        this.dlM.setNextTitle("mNextTitle");
        this.dlM.setIsFromCDN(true);
        this.dlM.setAllowLocalUrl(true);
        bg(this.mIndex, this.mIndex);
        this.abv.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aso() {
        if (this.dlI != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.dlM.getHasNext() && this.mIndex == this.dlM.getItemNum() - 1) {
                this.abv.setText(getPageContext().getString(d.l.image_recommend));
                this.dlK.setClickable(false);
                return;
            }
            this.abv.setText(valueOf);
            this.dlK.setClickable(true);
        }
    }

    private int asp() {
        if (this.dlI != null && this.dlI.size() > 0) {
            int size = this.dlI.size();
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
            this.dlR = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.dlS = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.dlT = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.dlX = intent.getBooleanExtra("isSingle", false);
            if (this.dlT == null) {
                this.dlT = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.dlR == null) {
                this.dlR = "";
            }
            this.dlI = new LinkedHashMap<>();
            this.dlI.put(this.dlT, this.dlR);
            this.dlW = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.dlI = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.dlT = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.dlW = bundle.getInt("chat_mode", 0);
            this.dlX = bundle.getBoolean("isSingle", false);
            if (this.dlT == null) {
                this.dlT = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.dlV = new HashMap<>();
    }

    private void asq() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.dlX) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.dlR)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.dlT, AbsMsgImageActivity.this.dlR);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.dlS;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.dlR, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = AbsMsgImageActivity.this.dlT;
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
                    AbsMsgImageActivity.this.abv.setVisibility(0);
                    AbsMsgImageActivity.this.aso();
                    AbsMsgImageActivity.this.dlM.setIsFromCDN(true);
                    AbsMsgImageActivity.this.dlM.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.dlM.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.dlM.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.dlM.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.dlI);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.dlT);
        bundle.putInt("chat_mode", this.dlW);
        bundle.putBoolean("isSingle", this.dlX);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.dlM.setCurrentItem(this.mIndex, true);
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
            AbsMsgImageActivity.this.dlJ = null;
            AbsMsgImageActivity.this.dlK.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.dlJ = null;
            AbsMsgImageActivity.this.dlK.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bg(int i, int i2) {
        synchronized (this.dlV) {
            if (System.nanoTime() - this.dlU > 300000000 && this.dlI != null && i < this.dlI.size()) {
                this.dlV.put(this.dlI.get("" + i), true);
            }
            this.dlU = System.nanoTime();
        }
    }
}
