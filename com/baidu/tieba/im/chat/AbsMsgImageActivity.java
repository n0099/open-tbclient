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
    private String dlF;
    private boolean dlK;
    private FrameLayout dlx;
    private int mCount;
    private LinkedHashMap<String, String> dlv = null;
    private int mIndex = 0;
    private a dlw = null;
    private View apM = null;
    private TextView abi = null;
    private NavigationBar dly = null;
    private MultiImageView dlz = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a dlA = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation dlB = null;
    private boolean dlC = true;
    private boolean dlD = false;
    private String dlE = "";
    private String id = "";
    private String dlG = "";
    private long dlH = 0;
    private HashMap<String, Boolean> dlI = null;
    private int dlJ = 0;

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
        asl();
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
        asl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.dlz.setBackgroundColor(aj.cO(i));
        } else {
            this.dlz.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        aj.k(this.dly, d.e.common_color_10222);
        getLayoutMode().t(this.apM);
        getLayoutMode().t(this.abi);
        getLayoutMode().t(this.dlx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.dlz.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dlz.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.dlz.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        bg(this.mIndex, this.mIndex);
        this.dlz.onDestroy();
        if (this.dlw != null) {
            this.dlw.cancel();
            this.dlw = null;
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
                if (view == AbsMsgImageActivity.this.apM) {
                    if (AbsMsgImageActivity.this.dly.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view == AbsMsgImageActivity.this.dlx) {
                    if (AbsMsgImageActivity.this.dly.getVisibility() != 8) {
                        try {
                            byte[] currentImageData = AbsMsgImageActivity.this.dlz.getCurrentImageData();
                            if (currentImageData != null) {
                                String currentImageUrl = AbsMsgImageActivity.this.dlz.getCurrentImageUrl();
                                AbsMsgImageActivity.this.dlw = new a(currentImageUrl, currentImageData);
                                AbsMsgImageActivity.this.dlw.execute(new String[0]);
                                AbsMsgImageActivity.this.dlx.setClickable(false);
                            } else {
                                AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(d.l.no_data));
                            }
                        } catch (Exception e) {
                        }
                    }
                } else if (AbsMsgImageActivity.this.dlC) {
                    if (AbsMsgImageActivity.this.dly.getVisibility() != 0) {
                        AbsMsgImageActivity.this.dly.setVisibility(0);
                        AbsMsgImageActivity.this.dlz.AG();
                        AbsMsgImageActivity.this.dlB = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.dlB = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.dlD = true;
                        AbsMsgImageActivity.this.dlz.AH();
                    }
                    AbsMsgImageActivity.this.dlB.setDuration(300L);
                    AbsMsgImageActivity.this.dlB.setFillAfter(true);
                    AbsMsgImageActivity.this.dlB.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.dlC = true;
                            if (AbsMsgImageActivity.this.dlD) {
                                AbsMsgImageActivity.this.dlD = false;
                                AbsMsgImageActivity.this.dly.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.dlC = false;
                    AbsMsgImageActivity.this.dly.startAnimation(AbsMsgImageActivity.this.dlB);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.bg(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.asj();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.dlH > 300000000 && AbsMsgImageActivity.this.dlv != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.dlv.size()) {
                    AbsMsgImageActivity.this.dlI.put(AbsMsgImageActivity.this.dlv.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.dlA = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
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
                                byte[] currentImageData = AbsMsgImageActivity.this.dlz.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.dlz.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.dlw = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.dlw.execute(new String[0]);
                                    AbsMsgImageActivity.this.dlx.setClickable(false);
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
        this.dly = (NavigationBar) findViewById(d.h.navigation_bar);
        this.dlx = (FrameLayout) this.dly.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.image_activity_save_button, this.mOnClickListener);
        if (this.dlK) {
            this.dlx.setVisibility(8);
        }
        this.apM = this.dly.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.abi = this.dly.setTitleText("");
        this.dlz = (MultiImageView) findViewById(d.h.viewpager);
        this.dlz.setPageMargin(l.dip2px(getPageContext().getContext(), 8.0f));
        this.dlz.H(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.dlz.setOnPageChangeListener(this.mOnPageChangeListener);
        this.dlz.setItemOnclickListener(this.mOnClickListener);
        this.dlz.setCurrentItem(ask(), false);
        this.dlz.setOnScrollOutListener(this.dlA);
        this.dlz.setItemOnLongClickListener(onLongClickListener);
        this.dlz.setHasNext(false);
        this.dlz.setNextTitle("mNextTitle");
        this.dlz.setIsFromCDN(true);
        this.dlz.setAllowLocalUrl(true);
        bg(this.mIndex, this.mIndex);
        this.abi.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asj() {
        if (this.dlv != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.dlz.getHasNext() && this.mIndex == this.dlz.getItemNum() - 1) {
                this.abi.setText(getPageContext().getString(d.l.image_recommend));
                this.dlx.setClickable(false);
                return;
            }
            this.abi.setText(valueOf);
            this.dlx.setClickable(true);
        }
    }

    private int ask() {
        if (this.dlv != null && this.dlv.size() > 0) {
            int size = this.dlv.size();
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
            this.dlE = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.dlF = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.dlG = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.dlK = intent.getBooleanExtra("isSingle", false);
            if (this.dlG == null) {
                this.dlG = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.dlE == null) {
                this.dlE = "";
            }
            this.dlv = new LinkedHashMap<>();
            this.dlv.put(this.dlG, this.dlE);
            this.dlJ = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.dlv = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.dlG = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.dlJ = bundle.getInt("chat_mode", 0);
            this.dlK = bundle.getBoolean("isSingle", false);
            if (this.dlG == null) {
                this.dlG = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.dlI = new HashMap<>();
    }

    private void asl() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.dlK) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.dlE)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.dlG, AbsMsgImageActivity.this.dlE);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.dlF;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.dlE, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = AbsMsgImageActivity.this.dlG;
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
                    AbsMsgImageActivity.this.abi.setVisibility(0);
                    AbsMsgImageActivity.this.asj();
                    AbsMsgImageActivity.this.dlz.setIsFromCDN(true);
                    AbsMsgImageActivity.this.dlz.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.dlz.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.dlz.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.dlz.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.dlv);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.dlG);
        bundle.putInt("chat_mode", this.dlJ);
        bundle.putBoolean("isSingle", this.dlK);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.dlz.setCurrentItem(this.mIndex, true);
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
                    return k.ua();
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
            AbsMsgImageActivity.this.dlw = null;
            AbsMsgImageActivity.this.dlx.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.dlw = null;
            AbsMsgImageActivity.this.dlx.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bg(int i, int i2) {
        synchronized (this.dlI) {
            if (System.nanoTime() - this.dlH > 300000000 && this.dlv != null && i < this.dlv.size()) {
                this.dlI.put(this.dlv.get("" + i), true);
            }
            this.dlH = System.nanoTime();
        }
    }
}
