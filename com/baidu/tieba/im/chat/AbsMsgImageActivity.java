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
/* loaded from: classes2.dex */
public abstract class AbsMsgImageActivity extends BaseActivity<AbsMsgImageActivity> {
    private com.baidu.tbadk.core.util.b.a bqO;
    private FrameLayout eqH;
    private String eqP;
    private boolean eqU;
    private int mCount;
    private LinkedHashMap<String, String> eqF = null;
    private int mIndex = 0;
    private a eqG = null;
    private View aEa = null;
    private TextView mTextView = null;
    private NavigationBar eqI = null;
    private MultiImageView eqJ = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a eqK = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation eqL = null;
    private boolean eqM = true;
    private boolean eqN = false;
    private String eqO = "";
    private String id = "";
    private String eqQ = "";
    private long eqR = 0;
    private HashMap<String, Boolean> eqS = null;
    private int eqT = 0;

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
        aIY();
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
        aIY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.j(this.eqJ, e.d.black_alpha100);
        al.j(this.eqI, e.d.common_color_10222);
        getLayoutMode().onModeChanged(this.aEa);
        getLayoutMode().onModeChanged(this.mTextView);
        getLayoutMode().onModeChanged(this.eqH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eqJ.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eqJ.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.eqJ.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        bi(this.mIndex, this.mIndex);
        this.eqJ.onDestroy();
        if (this.eqG != null) {
            this.eqG.cancel();
            this.eqG = null;
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
                if (view == AbsMsgImageActivity.this.aEa) {
                    if (AbsMsgImageActivity.this.eqI.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view == AbsMsgImageActivity.this.eqH) {
                    if (AbsMsgImageActivity.this.eqI.getVisibility() != 8) {
                        Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                        if (AbsMsgImageActivity.this.bqO == null) {
                            AbsMsgImageActivity.this.bqO = new com.baidu.tbadk.core.util.b.a();
                        }
                        AbsMsgImageActivity.this.bqO.Bb();
                        AbsMsgImageActivity.this.bqO.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!AbsMsgImageActivity.this.bqO.x(pageActivity)) {
                            try {
                                byte[] currentImageData = AbsMsgImageActivity.this.eqJ.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.eqJ.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.eqG = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.eqG.execute(new String[0]);
                                    AbsMsgImageActivity.this.eqH.setClickable(false);
                                } else {
                                    AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(e.j.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (AbsMsgImageActivity.this.eqM) {
                    if (AbsMsgImageActivity.this.eqI.getVisibility() != 0) {
                        AbsMsgImageActivity.this.eqI.setVisibility(0);
                        AbsMsgImageActivity.this.eqJ.He();
                        AbsMsgImageActivity.this.eqL = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.eqL = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.eqN = true;
                        AbsMsgImageActivity.this.eqJ.Hf();
                    }
                    AbsMsgImageActivity.this.eqL.setDuration(300L);
                    AbsMsgImageActivity.this.eqL.setFillAfter(true);
                    AbsMsgImageActivity.this.eqL.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.eqM = true;
                            if (AbsMsgImageActivity.this.eqN) {
                                AbsMsgImageActivity.this.eqN = false;
                                AbsMsgImageActivity.this.eqI.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.eqM = false;
                    AbsMsgImageActivity.this.eqI.startAnimation(AbsMsgImageActivity.this.eqL);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.bi(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.aAL();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.eqR > 300000000 && AbsMsgImageActivity.this.eqF != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.eqF.size()) {
                    AbsMsgImageActivity.this.eqS.put(AbsMsgImageActivity.this.eqF.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.eqK = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void dp(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0100b interfaceC0100b = new b.InterfaceC0100b() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0100b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar == AbsMsgImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            try {
                                Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                                if (AbsMsgImageActivity.this.bqO == null) {
                                    AbsMsgImageActivity.this.bqO = new com.baidu.tbadk.core.util.b.a();
                                }
                                AbsMsgImageActivity.this.bqO.Bb();
                                AbsMsgImageActivity.this.bqO.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                                if (!AbsMsgImageActivity.this.bqO.x(pageActivity)) {
                                    byte[] currentImageData = AbsMsgImageActivity.this.eqJ.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = AbsMsgImageActivity.this.eqJ.getCurrentImageUrl();
                                        AbsMsgImageActivity.this.eqG = new a(currentImageUrl, currentImageData);
                                        AbsMsgImageActivity.this.eqG.execute(new String[0]);
                                        AbsMsgImageActivity.this.eqH.setClickable(false);
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
                AbsMsgImageActivity.this.createListMenu(new String[]{AbsMsgImageActivity.this.getPageContext().getString(e.j.save)}, interfaceC0100b);
                AbsMsgImageActivity.this.showListMenu();
                return false;
            }
        };
        this.eqI = (NavigationBar) findViewById(e.g.navigation_bar);
        this.eqH = (FrameLayout) this.eqI.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.image_activity_save_button, this.mOnClickListener);
        if (this.eqU) {
            this.eqH.setVisibility(8);
        }
        this.aEa = this.eqI.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        al.c(this.eqI.getBackImageView(), e.f.icon_return_bg);
        this.mTextView = this.eqI.setTitleText("");
        this.eqJ = (MultiImageView) findViewById(e.g.viewpager);
        this.eqJ.setPageMargin(l.dip2px(getPageContext().getContext(), 8.0f));
        this.eqJ.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.eqJ.setOnPageChangeListener(this.mOnPageChangeListener);
        this.eqJ.setItemOnclickListener(this.mOnClickListener);
        this.eqJ.setCurrentItem(aIX(), false);
        this.eqJ.setOnScrollOutListener(this.eqK);
        this.eqJ.setItemOnLongClickListener(onLongClickListener);
        this.eqJ.setHasNext(false);
        this.eqJ.setNextTitle("mNextTitle");
        this.eqJ.setIsFromCDN(true);
        this.eqJ.setAllowLocalUrl(true);
        bi(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAL() {
        if (this.eqF != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.eqJ.getHasNext() && this.mIndex == this.eqJ.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(e.j.image_recommend));
                this.eqH.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.eqH.setClickable(true);
        }
    }

    private int aIX() {
        if (this.eqF != null && this.eqF.size() > 0) {
            int size = this.eqF.size();
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
            this.eqO = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.eqP = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.eqQ = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.eqU = intent.getBooleanExtra("isSingle", false);
            if (this.eqQ == null) {
                this.eqQ = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.eqO == null) {
                this.eqO = "";
            }
            this.eqF = new LinkedHashMap<>();
            this.eqF.put(this.eqQ, this.eqO);
            this.eqT = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.eqF = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.eqQ = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.eqT = bundle.getInt("chat_mode", 0);
            this.eqU = bundle.getBoolean("isSingle", false);
            if (this.eqQ == null) {
                this.eqQ = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.eqS = new HashMap<>();
    }

    private void aIY() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.eqU) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.eqO)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.eqQ, AbsMsgImageActivity.this.eqO);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.eqP;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.eqO, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = AbsMsgImageActivity.this.eqQ;
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
                    AbsMsgImageActivity.this.aAL();
                    AbsMsgImageActivity.this.eqJ.setIsFromCDN(true);
                    AbsMsgImageActivity.this.eqJ.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.eqJ.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.eqJ.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.eqJ.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.eqF);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.eqQ);
        bundle.putInt("chat_mode", this.eqT);
        bundle.putBoolean("isSingle", this.eqU);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.eqJ.setCurrentItem(this.mIndex, true);
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
        public String doInBackground(String... strArr) {
            switch (com.baidu.tbadk.core.util.l.a(this.mUrl, this.mData, AbsMsgImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.l.zo();
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
            AbsMsgImageActivity.this.eqG = null;
            AbsMsgImageActivity.this.eqH.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.eqG = null;
            AbsMsgImageActivity.this.eqH.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bi(int i, int i2) {
        synchronized (this.eqS) {
            if (System.nanoTime() - this.eqR > 300000000 && this.eqF != null && i < this.eqF.size()) {
                this.eqS.put(this.eqF.get("" + i), true);
            }
            this.eqR = System.nanoTime();
        }
    }
}
