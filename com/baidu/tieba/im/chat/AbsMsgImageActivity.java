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
    private com.baidu.tbadk.core.util.b.a bQG;
    private FrameLayout euM;
    private String euU;
    private boolean euZ;
    private int mCount;
    private LinkedHashMap<String, String> euK = null;
    private int mIndex = 0;
    private a euL = null;
    private View bgB = null;
    private TextView ry = null;
    private NavigationBar euN = null;
    private MultiImageView euO = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a euP = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation euQ = null;
    private boolean euR = true;
    private boolean euS = false;
    private String euT = "";
    private String id = "";
    private String euV = "";
    private long euW = 0;
    private HashMap<String, Boolean> euX = null;
    private int euY = 0;

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
        aFl();
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
        aFl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.t(this.euO, d.C0141d.black_alpha100);
        aj.t(this.euN, d.C0141d.common_color_10222);
        getLayoutMode().aM(this.bgB);
        getLayoutMode().aM(this.ry);
        getLayoutMode().aM(this.euM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.euO.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.euO.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.euO.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        bZ(this.mIndex, this.mIndex);
        this.euO.onDestroy();
        if (this.euL != null) {
            this.euL.cancel();
            this.euL = null;
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
                if (view == AbsMsgImageActivity.this.bgB) {
                    if (AbsMsgImageActivity.this.euN.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view == AbsMsgImageActivity.this.euM) {
                    if (AbsMsgImageActivity.this.euN.getVisibility() != 8) {
                        Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                        if (AbsMsgImageActivity.this.bQG == null) {
                            AbsMsgImageActivity.this.bQG = new com.baidu.tbadk.core.util.b.a();
                        }
                        AbsMsgImageActivity.this.bQG.DI();
                        AbsMsgImageActivity.this.bQG.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!AbsMsgImageActivity.this.bQG.v(pageActivity)) {
                            try {
                                byte[] currentImageData = AbsMsgImageActivity.this.euO.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.euO.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.euL = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.euL.execute(new String[0]);
                                    AbsMsgImageActivity.this.euM.setClickable(false);
                                } else {
                                    AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(d.j.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (AbsMsgImageActivity.this.euR) {
                    if (AbsMsgImageActivity.this.euN.getVisibility() != 0) {
                        AbsMsgImageActivity.this.euN.setVisibility(0);
                        AbsMsgImageActivity.this.euO.Jl();
                        AbsMsgImageActivity.this.euQ = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.euQ = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.euS = true;
                        AbsMsgImageActivity.this.euO.Jm();
                    }
                    AbsMsgImageActivity.this.euQ.setDuration(300L);
                    AbsMsgImageActivity.this.euQ.setFillAfter(true);
                    AbsMsgImageActivity.this.euQ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.euR = true;
                            if (AbsMsgImageActivity.this.euS) {
                                AbsMsgImageActivity.this.euS = false;
                                AbsMsgImageActivity.this.euN.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.euR = false;
                    AbsMsgImageActivity.this.euN.startAnimation(AbsMsgImageActivity.this.euQ);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.bZ(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.ayv();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.euW > 300000000 && AbsMsgImageActivity.this.euK != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.euK.size()) {
                    AbsMsgImageActivity.this.euX.put(AbsMsgImageActivity.this.euK.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.euP = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void fZ(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0097b interfaceC0097b = new b.InterfaceC0097b() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar == AbsMsgImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            try {
                                Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                                if (AbsMsgImageActivity.this.bQG == null) {
                                    AbsMsgImageActivity.this.bQG = new com.baidu.tbadk.core.util.b.a();
                                }
                                AbsMsgImageActivity.this.bQG.DI();
                                AbsMsgImageActivity.this.bQG.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                                if (!AbsMsgImageActivity.this.bQG.v(pageActivity)) {
                                    byte[] currentImageData = AbsMsgImageActivity.this.euO.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = AbsMsgImageActivity.this.euO.getCurrentImageUrl();
                                        AbsMsgImageActivity.this.euL = new a(currentImageUrl, currentImageData);
                                        AbsMsgImageActivity.this.euL.execute(new String[0]);
                                        AbsMsgImageActivity.this.euM.setClickable(false);
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
                AbsMsgImageActivity.this.createListMenu(new String[]{AbsMsgImageActivity.this.getPageContext().getString(d.j.save)}, interfaceC0097b);
                AbsMsgImageActivity.this.showListMenu();
                return false;
            }
        };
        this.euN = (NavigationBar) findViewById(d.g.navigation_bar);
        this.euM = (FrameLayout) this.euN.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.image_activity_save_button, this.mOnClickListener);
        if (this.euZ) {
            this.euM.setVisibility(8);
        }
        this.bgB = this.euN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.ry = this.euN.setTitleText("");
        this.euO = (MultiImageView) findViewById(d.g.viewpager);
        this.euO.setPageMargin(l.dip2px(getPageContext().getContext(), 8.0f));
        this.euO.aF(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.euO.setOnPageChangeListener(this.mOnPageChangeListener);
        this.euO.setItemOnclickListener(this.mOnClickListener);
        this.euO.setCurrentItem(aFk(), false);
        this.euO.setOnScrollOutListener(this.euP);
        this.euO.setItemOnLongClickListener(onLongClickListener);
        this.euO.setHasNext(false);
        this.euO.setNextTitle("mNextTitle");
        this.euO.setIsFromCDN(true);
        this.euO.setAllowLocalUrl(true);
        bZ(this.mIndex, this.mIndex);
        this.ry.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayv() {
        if (this.euK != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.euO.getHasNext() && this.mIndex == this.euO.getItemNum() - 1) {
                this.ry.setText(getPageContext().getString(d.j.image_recommend));
                this.euM.setClickable(false);
                return;
            }
            this.ry.setText(valueOf);
            this.euM.setClickable(true);
        }
    }

    private int aFk() {
        if (this.euK != null && this.euK.size() > 0) {
            int size = this.euK.size();
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
            this.euT = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.euU = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.euV = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.euZ = intent.getBooleanExtra("isSingle", false);
            if (this.euV == null) {
                this.euV = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.euT == null) {
                this.euT = "";
            }
            this.euK = new LinkedHashMap<>();
            this.euK.put(this.euV, this.euT);
            this.euY = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.euK = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.euV = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.euY = bundle.getInt("chat_mode", 0);
            this.euZ = bundle.getBoolean("isSingle", false);
            if (this.euV == null) {
                this.euV = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.euX = new HashMap<>();
    }

    private void aFl() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.euZ) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.euT)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.euV, AbsMsgImageActivity.this.euT);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.euU;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.euT, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = AbsMsgImageActivity.this.euV;
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
                    AbsMsgImageActivity.this.ry.setVisibility(0);
                    AbsMsgImageActivity.this.ayv();
                    AbsMsgImageActivity.this.euO.setIsFromCDN(true);
                    AbsMsgImageActivity.this.euO.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.euO.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.euO.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.euO.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.euK);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.euV);
        bundle.putInt("chat_mode", this.euY);
        bundle.putBoolean("isSingle", this.euZ);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.euO.setCurrentItem(this.mIndex, true);
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
                    return k.BT();
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
            AbsMsgImageActivity.this.euL = null;
            AbsMsgImageActivity.this.euM.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.euL = null;
            AbsMsgImageActivity.this.euM.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZ(int i, int i2) {
        synchronized (this.euX) {
            if (System.nanoTime() - this.euW > 300000000 && this.euK != null && i < this.euK.size()) {
                this.euX.put(this.euK.get("" + i), true);
            }
            this.euW = System.nanoTime();
        }
    }
}
