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
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public abstract class AbsMsgImageActivity extends BaseActivity<AbsMsgImageActivity> {
    private FrameLayout eKk;
    private String eKs;
    private boolean eKx;
    private int mCount;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private LinkedHashMap<String, String> eKi = null;
    private int mIndex = 0;
    private a eKj = null;
    private View aNy = null;
    private TextView mTextView = null;
    private NavigationBar eKl = null;
    private MultiImageView eKm = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a eKn = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation eKo = null;
    private boolean eKp = true;
    private boolean eKq = false;
    private String eKr = "";
    private String id = "";
    private String eKt = "";
    private long eKu = 0;
    private HashMap<String, Boolean> eKv = null;
    private int eKw = 0;

    protected abstract void a(String str, com.baidu.tieba.im.sendmessage.c cVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(e.h.image_activity_2);
        initData(bundle);
        initUI();
        aOS();
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
        aOS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.j(this.eKm, e.d.black_alpha100);
        al.j(this.eKl, e.d.common_color_10222);
        getLayoutMode().onModeChanged(this.aNy);
        getLayoutMode().onModeChanged(this.mTextView);
        getLayoutMode().onModeChanged(this.eKk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eKm.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eKm.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.eKm.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        bm(this.mIndex, this.mIndex);
        this.eKm.onDestroy();
        if (this.eKj != null) {
            this.eKj.cancel();
            this.eKj = null;
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
                if (view == AbsMsgImageActivity.this.aNy) {
                    if (AbsMsgImageActivity.this.eKl.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view == AbsMsgImageActivity.this.eKk) {
                    if (AbsMsgImageActivity.this.eKl.getVisibility() != 8) {
                        Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                        if (AbsMsgImageActivity.this.mPermissionJudgement == null) {
                            AbsMsgImageActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                        }
                        AbsMsgImageActivity.this.mPermissionJudgement.EG();
                        AbsMsgImageActivity.this.mPermissionJudgement.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!AbsMsgImageActivity.this.mPermissionJudgement.B(pageActivity)) {
                            try {
                                byte[] currentImageData = AbsMsgImageActivity.this.eKm.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.eKm.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.eKj = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.eKj.execute(new String[0]);
                                    AbsMsgImageActivity.this.eKk.setClickable(false);
                                } else {
                                    AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(e.j.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (AbsMsgImageActivity.this.eKp) {
                    if (AbsMsgImageActivity.this.eKl.getVisibility() != 0) {
                        AbsMsgImageActivity.this.eKl.setVisibility(0);
                        AbsMsgImageActivity.this.eKm.KL();
                        AbsMsgImageActivity.this.eKo = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.eKo = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.eKq = true;
                        AbsMsgImageActivity.this.eKm.KM();
                    }
                    AbsMsgImageActivity.this.eKo.setDuration(300L);
                    AbsMsgImageActivity.this.eKo.setFillAfter(true);
                    AbsMsgImageActivity.this.eKo.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.eKp = true;
                            if (AbsMsgImageActivity.this.eKq) {
                                AbsMsgImageActivity.this.eKq = false;
                                AbsMsgImageActivity.this.eKl.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.eKp = false;
                    AbsMsgImageActivity.this.eKl.startAnimation(AbsMsgImageActivity.this.eKo);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.bm(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.aGx();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.eKu > 300000000 && AbsMsgImageActivity.this.eKi != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.eKi.size()) {
                    AbsMsgImageActivity.this.eKv.put(AbsMsgImageActivity.this.eKi.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.eKn = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void eb(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0158b interfaceC0158b = new b.InterfaceC0158b() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar == AbsMsgImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            try {
                                Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                                if (AbsMsgImageActivity.this.mPermissionJudgement == null) {
                                    AbsMsgImageActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                                }
                                AbsMsgImageActivity.this.mPermissionJudgement.EG();
                                AbsMsgImageActivity.this.mPermissionJudgement.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                                if (!AbsMsgImageActivity.this.mPermissionJudgement.B(pageActivity)) {
                                    byte[] currentImageData = AbsMsgImageActivity.this.eKm.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = AbsMsgImageActivity.this.eKm.getCurrentImageUrl();
                                        AbsMsgImageActivity.this.eKj = new a(currentImageUrl, currentImageData);
                                        AbsMsgImageActivity.this.eKj.execute(new String[0]);
                                        AbsMsgImageActivity.this.eKk.setClickable(false);
                                        break;
                                    } else {
                                        AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(e.j.no_data));
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
                AbsMsgImageActivity.this.createListMenu(new String[]{AbsMsgImageActivity.this.getPageContext().getString(e.j.save)}, interfaceC0158b);
                AbsMsgImageActivity.this.showListMenu();
                return false;
            }
        };
        this.eKl = (NavigationBar) findViewById(e.g.navigation_bar);
        this.eKk = (FrameLayout) this.eKl.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.image_activity_save_button, this.mOnClickListener);
        if (this.eKx) {
            this.eKk.setVisibility(8);
        }
        this.aNy = this.eKl.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        al.c(this.eKl.getBackImageView(), e.f.icon_return_bg);
        this.mTextView = this.eKl.setTitleText("");
        this.eKm = (MultiImageView) findViewById(e.g.viewpager);
        this.eKm.setPageMargin(l.dip2px(getPageContext().getContext(), 8.0f));
        this.eKm.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.eKm.setOnPageChangeListener(this.mOnPageChangeListener);
        this.eKm.setItemOnclickListener(this.mOnClickListener);
        this.eKm.setCurrentItem(aOR(), false);
        this.eKm.setOnScrollOutListener(this.eKn);
        this.eKm.setItemOnLongClickListener(onLongClickListener);
        this.eKm.setHasNext(false);
        this.eKm.setNextTitle("mNextTitle");
        this.eKm.setIsFromCDN(true);
        this.eKm.setAllowLocalUrl(true);
        bm(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGx() {
        if (this.eKi != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.eKm.getHasNext() && this.mIndex == this.eKm.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(e.j.image_recommend));
                this.eKk.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.eKk.setClickable(true);
        }
    }

    private int aOR() {
        if (this.eKi != null && this.eKi.size() > 0) {
            int size = this.eKi.size();
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
            this.eKr = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.eKs = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.eKt = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.eKx = intent.getBooleanExtra("isSingle", false);
            if (this.eKt == null) {
                this.eKt = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.eKr == null) {
                this.eKr = "";
            }
            this.eKi = new LinkedHashMap<>();
            this.eKi.put(this.eKt, this.eKr);
            this.eKw = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.eKi = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.eKt = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.eKw = bundle.getInt("chat_mode", 0);
            this.eKx = bundle.getBoolean("isSingle", false);
            if (this.eKt == null) {
                this.eKt = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.eKv = new HashMap<>();
    }

    private void aOS() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.eKx) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.eKr)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.eKt, AbsMsgImageActivity.this.eKr);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.eKs;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.eKr, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = AbsMsgImageActivity.this.eKt;
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
                    AbsMsgImageActivity.this.aGx();
                    AbsMsgImageActivity.this.eKm.setIsFromCDN(true);
                    AbsMsgImageActivity.this.eKm.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.eKm.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.eKm.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.eKm.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.eKi);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.eKt);
        bundle.putInt("chat_mode", this.eKw);
        bundle.putBoolean("isSingle", this.eKx);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.eKm.setCurrentItem(this.mIndex, true);
    }

    /* loaded from: classes6.dex */
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
        public String doInBackground(String... strArr) {
            switch (com.baidu.tbadk.core.util.l.a(this.mUrl, this.mData, AbsMsgImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.l.CU();
                case -1:
                default:
                    return AbsMsgImageActivity.this.getPageContext().getString(e.j.save_fail);
                case 0:
                    return AbsMsgImageActivity.this.getPageContext().getString(e.j.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            AbsMsgImageActivity.this.eKj = null;
            AbsMsgImageActivity.this.eKk.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.eKj = null;
            AbsMsgImageActivity.this.eKk.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bm(int i, int i2) {
        synchronized (this.eKv) {
            if (System.nanoTime() - this.eKu > 300000000 && this.eKi != null && i < this.eKi.size()) {
                this.eKv.put(this.eKi.get("" + i), true);
            }
            this.eKu = System.nanoTime();
        }
    }
}
