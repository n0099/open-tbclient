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
import com.baidu.tbadk.core.util.ak;
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
    private com.baidu.tbadk.core.util.b.a baE;
    private String dQE;
    private boolean dQJ;
    private FrameLayout dQw;
    private int mCount;
    private LinkedHashMap<String, String> dQu = null;
    private int mIndex = 0;
    private a dQv = null;
    private View asg = null;
    private TextView mTextView = null;
    private NavigationBar dQx = null;
    private MultiImageView dQy = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a dQz = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation dQA = null;
    private boolean dQB = true;
    private boolean dQC = false;
    private String dQD = "";
    private String id = "";
    private String dQF = "";
    private long dQG = 0;
    private HashMap<String, Boolean> dQH = null;
    private int dQI = 0;

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
        aAj();
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
        aAj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ak.j(this.dQy, d.C0126d.black_alpha100);
        ak.j(this.dQx, d.C0126d.common_color_10222);
        getLayoutMode().u(this.asg);
        getLayoutMode().u(this.mTextView);
        getLayoutMode().u(this.dQw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.dQy.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dQy.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.dQy.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        ba(this.mIndex, this.mIndex);
        this.dQy.onDestroy();
        if (this.dQv != null) {
            this.dQv.cancel();
            this.dQv = null;
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
            public void onClick(View view2) {
                if (view2 == AbsMsgImageActivity.this.asg) {
                    if (AbsMsgImageActivity.this.dQx.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view2 == AbsMsgImageActivity.this.dQw) {
                    if (AbsMsgImageActivity.this.dQx.getVisibility() != 8) {
                        Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                        if (AbsMsgImageActivity.this.baE == null) {
                            AbsMsgImageActivity.this.baE = new com.baidu.tbadk.core.util.b.a();
                        }
                        AbsMsgImageActivity.this.baE.wt();
                        AbsMsgImageActivity.this.baE.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!AbsMsgImageActivity.this.baE.v(pageActivity)) {
                            try {
                                byte[] currentImageData = AbsMsgImageActivity.this.dQy.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.dQy.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.dQv = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.dQv.execute(new String[0]);
                                    AbsMsgImageActivity.this.dQw.setClickable(false);
                                } else {
                                    AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(d.k.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (AbsMsgImageActivity.this.dQB) {
                    if (AbsMsgImageActivity.this.dQx.getVisibility() != 0) {
                        AbsMsgImageActivity.this.dQx.setVisibility(0);
                        AbsMsgImageActivity.this.dQy.BX();
                        AbsMsgImageActivity.this.dQA = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.dQA = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.dQC = true;
                        AbsMsgImageActivity.this.dQy.BY();
                    }
                    AbsMsgImageActivity.this.dQA.setDuration(300L);
                    AbsMsgImageActivity.this.dQA.setFillAfter(true);
                    AbsMsgImageActivity.this.dQA.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.dQB = true;
                            if (AbsMsgImageActivity.this.dQC) {
                                AbsMsgImageActivity.this.dQC = false;
                                AbsMsgImageActivity.this.dQx.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.dQB = false;
                    AbsMsgImageActivity.this.dQx.startAnimation(AbsMsgImageActivity.this.dQA);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.ba(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.atj();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.dQG > 300000000 && AbsMsgImageActivity.this.dQu != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.dQu.size()) {
                    AbsMsgImageActivity.this.dQH.put(AbsMsgImageActivity.this.dQu.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.dQz = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void cZ(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0086b interfaceC0086b = new b.InterfaceC0086b() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                if (bVar == AbsMsgImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            try {
                                Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                                if (AbsMsgImageActivity.this.baE == null) {
                                    AbsMsgImageActivity.this.baE = new com.baidu.tbadk.core.util.b.a();
                                }
                                AbsMsgImageActivity.this.baE.wt();
                                AbsMsgImageActivity.this.baE.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                                if (!AbsMsgImageActivity.this.baE.v(pageActivity)) {
                                    byte[] currentImageData = AbsMsgImageActivity.this.dQy.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = AbsMsgImageActivity.this.dQy.getCurrentImageUrl();
                                        AbsMsgImageActivity.this.dQv = new a(currentImageUrl, currentImageData);
                                        AbsMsgImageActivity.this.dQv.execute(new String[0]);
                                        AbsMsgImageActivity.this.dQw.setClickable(false);
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
            public boolean onLongClick(View view2) {
                AbsMsgImageActivity.this.createListMenu(new String[]{AbsMsgImageActivity.this.getPageContext().getString(d.k.save)}, interfaceC0086b);
                AbsMsgImageActivity.this.showListMenu();
                return false;
            }
        };
        this.dQx = (NavigationBar) findViewById(d.g.navigation_bar);
        this.dQw = (FrameLayout) this.dQx.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.image_activity_save_button, this.mOnClickListener);
        if (this.dQJ) {
            this.dQw.setVisibility(8);
        }
        this.asg = this.dQx.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.mTextView = this.dQx.setTitleText("");
        this.dQy = (MultiImageView) findViewById(d.g.viewpager);
        this.dQy.setPageMargin(l.dip2px(getPageContext().getContext(), 8.0f));
        this.dQy.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.dQy.setOnPageChangeListener(this.mOnPageChangeListener);
        this.dQy.setItemOnclickListener(this.mOnClickListener);
        this.dQy.setCurrentItem(aAi(), false);
        this.dQy.setOnScrollOutListener(this.dQz);
        this.dQy.setItemOnLongClickListener(onLongClickListener);
        this.dQy.setHasNext(false);
        this.dQy.setNextTitle("mNextTitle");
        this.dQy.setIsFromCDN(true);
        this.dQy.setAllowLocalUrl(true);
        ba(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atj() {
        if (this.dQu != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.dQy.getHasNext() && this.mIndex == this.dQy.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(d.k.image_recommend));
                this.dQw.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.dQw.setClickable(true);
        }
    }

    private int aAi() {
        if (this.dQu != null && this.dQu.size() > 0) {
            int size = this.dQu.size();
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
            this.dQD = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.dQE = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.dQF = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.dQJ = intent.getBooleanExtra("isSingle", false);
            if (this.dQF == null) {
                this.dQF = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.dQD == null) {
                this.dQD = "";
            }
            this.dQu = new LinkedHashMap<>();
            this.dQu.put(this.dQF, this.dQD);
            this.dQI = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.dQu = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.dQF = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.dQI = bundle.getInt("chat_mode", 0);
            this.dQJ = bundle.getBoolean("isSingle", false);
            if (this.dQF == null) {
                this.dQF = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.dQH = new HashMap<>();
    }

    private void aAj() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.dQJ) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.dQD)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.dQF, AbsMsgImageActivity.this.dQD);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.dQE;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.dQD, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = AbsMsgImageActivity.this.dQF;
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
                    AbsMsgImageActivity.this.atj();
                    AbsMsgImageActivity.this.dQy.setIsFromCDN(true);
                    AbsMsgImageActivity.this.dQy.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.dQy.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.dQy.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.dQy.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.dQu);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.dQF);
        bundle.putInt("chat_mode", this.dQI);
        bundle.putBoolean("isSingle", this.dQJ);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.dQy.setCurrentItem(this.mIndex, true);
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
                    return k.uC();
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
            AbsMsgImageActivity.this.dQv = null;
            AbsMsgImageActivity.this.dQw.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.dQv = null;
            AbsMsgImageActivity.this.dQw.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba(int i, int i2) {
        synchronized (this.dQH) {
            if (System.nanoTime() - this.dQG > 300000000 && this.dQu != null && i < this.dQu.size()) {
                this.dQH.put(this.dQu.get("" + i), true);
            }
            this.dQG = System.nanoTime();
        }
    }
}
