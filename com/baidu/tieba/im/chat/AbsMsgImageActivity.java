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
/* loaded from: classes2.dex */
public abstract class AbsMsgImageActivity extends BaseActivity<AbsMsgImageActivity> {
    private com.baidu.tbadk.core.util.b.a bkU;
    private String ejA;
    private boolean ejF;
    private FrameLayout ejs;
    private int mCount;
    private LinkedHashMap<String, String> ejq = null;
    private int mIndex = 0;
    private a ejr = null;
    private View aAZ = null;
    private TextView mTextView = null;
    private NavigationBar ejt = null;
    private MultiImageView eju = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a ejv = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation ejw = null;
    private boolean ejx = true;
    private boolean ejy = false;
    private String ejz = "";
    private String id = "";
    private String ejB = "";
    private long ejC = 0;
    private HashMap<String, Boolean> ejD = null;
    private int ejE = 0;

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
        aGM();
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
        aGM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.j(this.eju, d.C0140d.black_alpha100);
        am.j(this.ejt, d.C0140d.common_color_10222);
        getLayoutMode().onModeChanged(this.aAZ);
        getLayoutMode().onModeChanged(this.mTextView);
        getLayoutMode().onModeChanged(this.ejs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eju.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eju.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.eju.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        be(this.mIndex, this.mIndex);
        this.eju.onDestroy();
        if (this.ejr != null) {
            this.ejr.cancel();
            this.ejr = null;
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
                if (view == AbsMsgImageActivity.this.aAZ) {
                    if (AbsMsgImageActivity.this.ejt.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view == AbsMsgImageActivity.this.ejs) {
                    if (AbsMsgImageActivity.this.ejt.getVisibility() != 8) {
                        Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                        if (AbsMsgImageActivity.this.bkU == null) {
                            AbsMsgImageActivity.this.bkU = new com.baidu.tbadk.core.util.b.a();
                        }
                        AbsMsgImageActivity.this.bkU.zY();
                        AbsMsgImageActivity.this.bkU.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!AbsMsgImageActivity.this.bkU.u(pageActivity)) {
                            try {
                                byte[] currentImageData = AbsMsgImageActivity.this.eju.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.eju.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.ejr = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.ejr.execute(new String[0]);
                                    AbsMsgImageActivity.this.ejs.setClickable(false);
                                } else {
                                    AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(d.j.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (AbsMsgImageActivity.this.ejx) {
                    if (AbsMsgImageActivity.this.ejt.getVisibility() != 0) {
                        AbsMsgImageActivity.this.ejt.setVisibility(0);
                        AbsMsgImageActivity.this.eju.FO();
                        AbsMsgImageActivity.this.ejw = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.ejw = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.ejy = true;
                        AbsMsgImageActivity.this.eju.FP();
                    }
                    AbsMsgImageActivity.this.ejw.setDuration(300L);
                    AbsMsgImageActivity.this.ejw.setFillAfter(true);
                    AbsMsgImageActivity.this.ejw.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.ejx = true;
                            if (AbsMsgImageActivity.this.ejy) {
                                AbsMsgImageActivity.this.ejy = false;
                                AbsMsgImageActivity.this.ejt.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.ejx = false;
                    AbsMsgImageActivity.this.ejt.startAnimation(AbsMsgImageActivity.this.ejw);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.be(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.ayy();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.ejC > 300000000 && AbsMsgImageActivity.this.ejq != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.ejq.size()) {
                    AbsMsgImageActivity.this.ejD.put(AbsMsgImageActivity.this.ejq.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.ejv = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void de(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0101b interfaceC0101b = new b.InterfaceC0101b() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar == AbsMsgImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            try {
                                Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                                if (AbsMsgImageActivity.this.bkU == null) {
                                    AbsMsgImageActivity.this.bkU = new com.baidu.tbadk.core.util.b.a();
                                }
                                AbsMsgImageActivity.this.bkU.zY();
                                AbsMsgImageActivity.this.bkU.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                                if (!AbsMsgImageActivity.this.bkU.u(pageActivity)) {
                                    byte[] currentImageData = AbsMsgImageActivity.this.eju.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = AbsMsgImageActivity.this.eju.getCurrentImageUrl();
                                        AbsMsgImageActivity.this.ejr = new a(currentImageUrl, currentImageData);
                                        AbsMsgImageActivity.this.ejr.execute(new String[0]);
                                        AbsMsgImageActivity.this.ejs.setClickable(false);
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
                AbsMsgImageActivity.this.createListMenu(new String[]{AbsMsgImageActivity.this.getPageContext().getString(d.j.save)}, interfaceC0101b);
                AbsMsgImageActivity.this.showListMenu();
                return false;
            }
        };
        this.ejt = (NavigationBar) findViewById(d.g.navigation_bar);
        this.ejs = (FrameLayout) this.ejt.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.image_activity_save_button, this.mOnClickListener);
        if (this.ejF) {
            this.ejs.setVisibility(8);
        }
        this.aAZ = this.ejt.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        am.c(this.ejt.getBackImageView(), d.f.icon_return_bg);
        this.mTextView = this.ejt.setTitleText("");
        this.eju = (MultiImageView) findViewById(d.g.viewpager);
        this.eju.setPageMargin(l.dip2px(getPageContext().getContext(), 8.0f));
        this.eju.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.eju.setOnPageChangeListener(this.mOnPageChangeListener);
        this.eju.setItemOnclickListener(this.mOnClickListener);
        this.eju.setCurrentItem(aGL(), false);
        this.eju.setOnScrollOutListener(this.ejv);
        this.eju.setItemOnLongClickListener(onLongClickListener);
        this.eju.setHasNext(false);
        this.eju.setNextTitle("mNextTitle");
        this.eju.setIsFromCDN(true);
        this.eju.setAllowLocalUrl(true);
        be(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayy() {
        if (this.ejq != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.eju.getHasNext() && this.mIndex == this.eju.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(d.j.image_recommend));
                this.ejs.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.ejs.setClickable(true);
        }
    }

    private int aGL() {
        if (this.ejq != null && this.ejq.size() > 0) {
            int size = this.ejq.size();
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
            this.ejz = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.ejA = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.ejB = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.ejF = intent.getBooleanExtra("isSingle", false);
            if (this.ejB == null) {
                this.ejB = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.ejz == null) {
                this.ejz = "";
            }
            this.ejq = new LinkedHashMap<>();
            this.ejq.put(this.ejB, this.ejz);
            this.ejE = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.ejq = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.ejB = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.ejE = bundle.getInt("chat_mode", 0);
            this.ejF = bundle.getBoolean("isSingle", false);
            if (this.ejB == null) {
                this.ejB = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.ejD = new HashMap<>();
    }

    private void aGM() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.ejF) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.ejz)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.ejB, AbsMsgImageActivity.this.ejz);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.ejA;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.ejz, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = AbsMsgImageActivity.this.ejB;
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
                    AbsMsgImageActivity.this.ayy();
                    AbsMsgImageActivity.this.eju.setIsFromCDN(true);
                    AbsMsgImageActivity.this.eju.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.eju.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.eju.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.eju.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.ejq);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.ejB);
        bundle.putInt("chat_mode", this.ejE);
        bundle.putBoolean("isSingle", this.ejF);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.eju.setCurrentItem(this.mIndex, true);
    }

    /* loaded from: classes2.dex */
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
                    return com.baidu.tbadk.core.util.l.yi();
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
            AbsMsgImageActivity.this.ejr = null;
            AbsMsgImageActivity.this.ejs.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.ejr = null;
            AbsMsgImageActivity.this.ejs.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(int i, int i2) {
        synchronized (this.ejD) {
            if (System.nanoTime() - this.ejC > 300000000 && this.ejq != null && i < this.ejq.size()) {
                this.ejD.put(this.ejq.get("" + i), true);
            }
            this.ejC = System.nanoTime();
        }
    }
}
