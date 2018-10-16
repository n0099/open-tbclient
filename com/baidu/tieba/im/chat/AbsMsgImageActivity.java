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
    private com.baidu.tbadk.core.util.b.a buX;
    private String eyG;
    private boolean eyL;
    private FrameLayout eyy;
    private int mCount;
    private LinkedHashMap<String, String> eyw = null;
    private int mIndex = 0;
    private a eyx = null;
    private View aIE = null;
    private TextView mTextView = null;
    private NavigationBar eyz = null;
    private MultiImageView eyA = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a eyB = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation eyC = null;
    private boolean eyD = true;
    private boolean eyE = false;
    private String eyF = "";
    private String id = "";
    private String eyH = "";
    private long eyI = 0;
    private HashMap<String, Boolean> eyJ = null;
    private int eyK = 0;

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
        aMp();
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
        aMp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.j(this.eyA, e.d.black_alpha100);
        al.j(this.eyz, e.d.common_color_10222);
        getLayoutMode().onModeChanged(this.aIE);
        getLayoutMode().onModeChanged(this.mTextView);
        getLayoutMode().onModeChanged(this.eyy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eyA.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eyA.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.eyA.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        bl(this.mIndex, this.mIndex);
        this.eyA.onDestroy();
        if (this.eyx != null) {
            this.eyx.cancel();
            this.eyx = null;
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
                if (view == AbsMsgImageActivity.this.aIE) {
                    if (AbsMsgImageActivity.this.eyz.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view == AbsMsgImageActivity.this.eyy) {
                    if (AbsMsgImageActivity.this.eyz.getVisibility() != 8) {
                        Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                        if (AbsMsgImageActivity.this.buX == null) {
                            AbsMsgImageActivity.this.buX = new com.baidu.tbadk.core.util.b.a();
                        }
                        AbsMsgImageActivity.this.buX.Di();
                        AbsMsgImageActivity.this.buX.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!AbsMsgImageActivity.this.buX.z(pageActivity)) {
                            try {
                                byte[] currentImageData = AbsMsgImageActivity.this.eyA.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.eyA.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.eyx = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.eyx.execute(new String[0]);
                                    AbsMsgImageActivity.this.eyy.setClickable(false);
                                } else {
                                    AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(e.j.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (AbsMsgImageActivity.this.eyD) {
                    if (AbsMsgImageActivity.this.eyz.getVisibility() != 0) {
                        AbsMsgImageActivity.this.eyz.setVisibility(0);
                        AbsMsgImageActivity.this.eyA.Jf();
                        AbsMsgImageActivity.this.eyC = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.eyC = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.eyE = true;
                        AbsMsgImageActivity.this.eyA.Jg();
                    }
                    AbsMsgImageActivity.this.eyC.setDuration(300L);
                    AbsMsgImageActivity.this.eyC.setFillAfter(true);
                    AbsMsgImageActivity.this.eyC.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.eyD = true;
                            if (AbsMsgImageActivity.this.eyE) {
                                AbsMsgImageActivity.this.eyE = false;
                                AbsMsgImageActivity.this.eyz.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.eyD = false;
                    AbsMsgImageActivity.this.eyz.startAnimation(AbsMsgImageActivity.this.eyC);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.bl(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.aEe();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.eyI > 300000000 && AbsMsgImageActivity.this.eyw != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.eyw.size()) {
                    AbsMsgImageActivity.this.eyJ.put(AbsMsgImageActivity.this.eyw.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.eyB = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void dz(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0124b interfaceC0124b = new b.InterfaceC0124b() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar == AbsMsgImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            try {
                                Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                                if (AbsMsgImageActivity.this.buX == null) {
                                    AbsMsgImageActivity.this.buX = new com.baidu.tbadk.core.util.b.a();
                                }
                                AbsMsgImageActivity.this.buX.Di();
                                AbsMsgImageActivity.this.buX.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                                if (!AbsMsgImageActivity.this.buX.z(pageActivity)) {
                                    byte[] currentImageData = AbsMsgImageActivity.this.eyA.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = AbsMsgImageActivity.this.eyA.getCurrentImageUrl();
                                        AbsMsgImageActivity.this.eyx = new a(currentImageUrl, currentImageData);
                                        AbsMsgImageActivity.this.eyx.execute(new String[0]);
                                        AbsMsgImageActivity.this.eyy.setClickable(false);
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
                AbsMsgImageActivity.this.createListMenu(new String[]{AbsMsgImageActivity.this.getPageContext().getString(e.j.save)}, interfaceC0124b);
                AbsMsgImageActivity.this.showListMenu();
                return false;
            }
        };
        this.eyz = (NavigationBar) findViewById(e.g.navigation_bar);
        this.eyy = (FrameLayout) this.eyz.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.image_activity_save_button, this.mOnClickListener);
        if (this.eyL) {
            this.eyy.setVisibility(8);
        }
        this.aIE = this.eyz.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        al.c(this.eyz.getBackImageView(), e.f.icon_return_bg);
        this.mTextView = this.eyz.setTitleText("");
        this.eyA = (MultiImageView) findViewById(e.g.viewpager);
        this.eyA.setPageMargin(l.dip2px(getPageContext().getContext(), 8.0f));
        this.eyA.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.eyA.setOnPageChangeListener(this.mOnPageChangeListener);
        this.eyA.setItemOnclickListener(this.mOnClickListener);
        this.eyA.setCurrentItem(aMo(), false);
        this.eyA.setOnScrollOutListener(this.eyB);
        this.eyA.setItemOnLongClickListener(onLongClickListener);
        this.eyA.setHasNext(false);
        this.eyA.setNextTitle("mNextTitle");
        this.eyA.setIsFromCDN(true);
        this.eyA.setAllowLocalUrl(true);
        bl(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEe() {
        if (this.eyw != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.eyA.getHasNext() && this.mIndex == this.eyA.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(e.j.image_recommend));
                this.eyy.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.eyy.setClickable(true);
        }
    }

    private int aMo() {
        if (this.eyw != null && this.eyw.size() > 0) {
            int size = this.eyw.size();
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
            this.eyF = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.eyG = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.eyH = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.eyL = intent.getBooleanExtra("isSingle", false);
            if (this.eyH == null) {
                this.eyH = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.eyF == null) {
                this.eyF = "";
            }
            this.eyw = new LinkedHashMap<>();
            this.eyw.put(this.eyH, this.eyF);
            this.eyK = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.eyw = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.eyH = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.eyK = bundle.getInt("chat_mode", 0);
            this.eyL = bundle.getBoolean("isSingle", false);
            if (this.eyH == null) {
                this.eyH = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.eyJ = new HashMap<>();
    }

    private void aMp() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.eyL) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.eyF)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.eyH, AbsMsgImageActivity.this.eyF);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.eyG;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.eyF, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = AbsMsgImageActivity.this.eyH;
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
                    AbsMsgImageActivity.this.aEe();
                    AbsMsgImageActivity.this.eyA.setIsFromCDN(true);
                    AbsMsgImageActivity.this.eyA.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.eyA.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.eyA.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.eyA.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.eyw);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.eyH);
        bundle.putInt("chat_mode", this.eyK);
        bundle.putBoolean("isSingle", this.eyL);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.eyA.setCurrentItem(this.mIndex, true);
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
                    return com.baidu.tbadk.core.util.l.Bw();
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
            AbsMsgImageActivity.this.eyx = null;
            AbsMsgImageActivity.this.eyy.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.eyx = null;
            AbsMsgImageActivity.this.eyy.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bl(int i, int i2) {
        synchronized (this.eyJ) {
            if (System.nanoTime() - this.eyI > 300000000 && this.eyw != null && i < this.eyw.size()) {
                this.eyJ.put(this.eyw.get("" + i), true);
            }
            this.eyI = System.nanoTime();
        }
    }
}
