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
    private com.baidu.tbadk.core.util.b.a bzi;
    private String eJG;
    private boolean eJL;
    private FrameLayout eJy;
    private int mCount;
    private LinkedHashMap<String, String> eJw = null;
    private int mIndex = 0;
    private a eJx = null;
    private View aMW = null;
    private TextView mTextView = null;
    private NavigationBar eJz = null;
    private MultiImageView eJA = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a eJB = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation eJC = null;
    private boolean eJD = true;
    private boolean eJE = false;
    private String eJF = "";
    private String id = "";
    private String eJH = "";
    private long eJI = 0;
    private HashMap<String, Boolean> eJJ = null;
    private int eJK = 0;

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
        aOs();
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
        aOs();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.j(this.eJA, e.d.black_alpha100);
        al.j(this.eJz, e.d.common_color_10222);
        getLayoutMode().onModeChanged(this.aMW);
        getLayoutMode().onModeChanged(this.mTextView);
        getLayoutMode().onModeChanged(this.eJy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eJA.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eJA.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.eJA.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        bm(this.mIndex, this.mIndex);
        this.eJA.onDestroy();
        if (this.eJx != null) {
            this.eJx.cancel();
            this.eJx = null;
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
                if (view == AbsMsgImageActivity.this.aMW) {
                    if (AbsMsgImageActivity.this.eJz.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view == AbsMsgImageActivity.this.eJy) {
                    if (AbsMsgImageActivity.this.eJz.getVisibility() != 8) {
                        Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                        if (AbsMsgImageActivity.this.bzi == null) {
                            AbsMsgImageActivity.this.bzi = new com.baidu.tbadk.core.util.b.a();
                        }
                        AbsMsgImageActivity.this.bzi.Et();
                        AbsMsgImageActivity.this.bzi.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!AbsMsgImageActivity.this.bzi.A(pageActivity)) {
                            try {
                                byte[] currentImageData = AbsMsgImageActivity.this.eJA.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.eJA.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.eJx = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.eJx.execute(new String[0]);
                                    AbsMsgImageActivity.this.eJy.setClickable(false);
                                } else {
                                    AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(e.j.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (AbsMsgImageActivity.this.eJD) {
                    if (AbsMsgImageActivity.this.eJz.getVisibility() != 0) {
                        AbsMsgImageActivity.this.eJz.setVisibility(0);
                        AbsMsgImageActivity.this.eJA.Kw();
                        AbsMsgImageActivity.this.eJC = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.eJC = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.eJE = true;
                        AbsMsgImageActivity.this.eJA.Kx();
                    }
                    AbsMsgImageActivity.this.eJC.setDuration(300L);
                    AbsMsgImageActivity.this.eJC.setFillAfter(true);
                    AbsMsgImageActivity.this.eJC.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.eJD = true;
                            if (AbsMsgImageActivity.this.eJE) {
                                AbsMsgImageActivity.this.eJE = false;
                                AbsMsgImageActivity.this.eJz.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.eJD = false;
                    AbsMsgImageActivity.this.eJz.startAnimation(AbsMsgImageActivity.this.eJC);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.bm(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.aGa();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.eJI > 300000000 && AbsMsgImageActivity.this.eJw != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.eJw.size()) {
                    AbsMsgImageActivity.this.eJJ.put(AbsMsgImageActivity.this.eJw.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.eJB = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
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
                                if (AbsMsgImageActivity.this.bzi == null) {
                                    AbsMsgImageActivity.this.bzi = new com.baidu.tbadk.core.util.b.a();
                                }
                                AbsMsgImageActivity.this.bzi.Et();
                                AbsMsgImageActivity.this.bzi.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                                if (!AbsMsgImageActivity.this.bzi.A(pageActivity)) {
                                    byte[] currentImageData = AbsMsgImageActivity.this.eJA.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = AbsMsgImageActivity.this.eJA.getCurrentImageUrl();
                                        AbsMsgImageActivity.this.eJx = new a(currentImageUrl, currentImageData);
                                        AbsMsgImageActivity.this.eJx.execute(new String[0]);
                                        AbsMsgImageActivity.this.eJy.setClickable(false);
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
        this.eJz = (NavigationBar) findViewById(e.g.navigation_bar);
        this.eJy = (FrameLayout) this.eJz.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.image_activity_save_button, this.mOnClickListener);
        if (this.eJL) {
            this.eJy.setVisibility(8);
        }
        this.aMW = this.eJz.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        al.c(this.eJz.getBackImageView(), e.f.icon_return_bg);
        this.mTextView = this.eJz.setTitleText("");
        this.eJA = (MultiImageView) findViewById(e.g.viewpager);
        this.eJA.setPageMargin(l.dip2px(getPageContext().getContext(), 8.0f));
        this.eJA.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.eJA.setOnPageChangeListener(this.mOnPageChangeListener);
        this.eJA.setItemOnclickListener(this.mOnClickListener);
        this.eJA.setCurrentItem(aOr(), false);
        this.eJA.setOnScrollOutListener(this.eJB);
        this.eJA.setItemOnLongClickListener(onLongClickListener);
        this.eJA.setHasNext(false);
        this.eJA.setNextTitle("mNextTitle");
        this.eJA.setIsFromCDN(true);
        this.eJA.setAllowLocalUrl(true);
        bm(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGa() {
        if (this.eJw != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.eJA.getHasNext() && this.mIndex == this.eJA.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(e.j.image_recommend));
                this.eJy.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.eJy.setClickable(true);
        }
    }

    private int aOr() {
        if (this.eJw != null && this.eJw.size() > 0) {
            int size = this.eJw.size();
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
            this.eJF = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.eJG = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.eJH = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.eJL = intent.getBooleanExtra("isSingle", false);
            if (this.eJH == null) {
                this.eJH = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.eJF == null) {
                this.eJF = "";
            }
            this.eJw = new LinkedHashMap<>();
            this.eJw.put(this.eJH, this.eJF);
            this.eJK = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.eJw = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.eJH = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.eJK = bundle.getInt("chat_mode", 0);
            this.eJL = bundle.getBoolean("isSingle", false);
            if (this.eJH == null) {
                this.eJH = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.eJJ = new HashMap<>();
    }

    private void aOs() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.eJL) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.eJF)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.eJH, AbsMsgImageActivity.this.eJF);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.eJG;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.eJF, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = AbsMsgImageActivity.this.eJH;
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
                    AbsMsgImageActivity.this.aGa();
                    AbsMsgImageActivity.this.eJA.setIsFromCDN(true);
                    AbsMsgImageActivity.this.eJA.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.eJA.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.eJA.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.eJA.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.eJw);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.eJH);
        bundle.putInt("chat_mode", this.eJK);
        bundle.putBoolean("isSingle", this.eJL);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.eJA.setCurrentItem(this.mIndex, true);
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
                    return com.baidu.tbadk.core.util.l.CH();
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
            AbsMsgImageActivity.this.eJx = null;
            AbsMsgImageActivity.this.eJy.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.eJx = null;
            AbsMsgImageActivity.this.eJy.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bm(int i, int i2) {
        synchronized (this.eJJ) {
            if (System.nanoTime() - this.eJI > 300000000 && this.eJw != null && i < this.eJw.size()) {
                this.eJJ.put(this.eJw.get("" + i), true);
            }
            this.eJI = System.nanoTime();
        }
    }
}
