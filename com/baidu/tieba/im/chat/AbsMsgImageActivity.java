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
    private FrameLayout dhW;
    private String die;
    private boolean dij;
    private int mCount;
    private LinkedHashMap<String, String> dhU = null;
    private int mIndex = 0;
    private a dhV = null;
    private View arn = null;
    private TextView mTextView = null;
    private NavigationBar dhX = null;
    private MultiImageView dhY = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a dhZ = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation dia = null;
    private boolean dib = true;
    private boolean dic = false;
    private String did = "";
    private String id = "";
    private String dif = "";
    private long dig = 0;
    private HashMap<String, Boolean> dih = null;
    private int dii = 0;

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
        arK();
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
        arK();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.dhY.setBackgroundColor(ai.cQ(i));
        } else {
            this.dhY.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        ai.k(this.dhX, d.e.common_color_10222);
        getLayoutMode().t(this.arn);
        getLayoutMode().t(this.mTextView);
        getLayoutMode().t(this.dhW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.dhY.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dhY.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.dhY.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        aX(this.mIndex, this.mIndex);
        this.dhY.onDestroy();
        if (this.dhV != null) {
            this.dhV.cancel();
            this.dhV = null;
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
                if (view == AbsMsgImageActivity.this.arn) {
                    if (AbsMsgImageActivity.this.dhX.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view == AbsMsgImageActivity.this.dhW) {
                    if (AbsMsgImageActivity.this.dhX.getVisibility() != 8) {
                        try {
                            byte[] currentImageData = AbsMsgImageActivity.this.dhY.getCurrentImageData();
                            if (currentImageData != null) {
                                String currentImageUrl = AbsMsgImageActivity.this.dhY.getCurrentImageUrl();
                                AbsMsgImageActivity.this.dhV = new a(currentImageUrl, currentImageData);
                                AbsMsgImageActivity.this.dhV.execute(new String[0]);
                                AbsMsgImageActivity.this.dhW.setClickable(false);
                            } else {
                                AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(d.l.no_data));
                            }
                        } catch (Exception e) {
                        }
                    }
                } else if (AbsMsgImageActivity.this.dib) {
                    if (AbsMsgImageActivity.this.dhX.getVisibility() != 0) {
                        AbsMsgImageActivity.this.dhX.setVisibility(0);
                        AbsMsgImageActivity.this.dhY.Bt();
                        AbsMsgImageActivity.this.dia = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.dia = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.dic = true;
                        AbsMsgImageActivity.this.dhY.Bu();
                    }
                    AbsMsgImageActivity.this.dia.setDuration(300L);
                    AbsMsgImageActivity.this.dia.setFillAfter(true);
                    AbsMsgImageActivity.this.dia.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.dib = true;
                            if (AbsMsgImageActivity.this.dic) {
                                AbsMsgImageActivity.this.dic = false;
                                AbsMsgImageActivity.this.dhX.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.dib = false;
                    AbsMsgImageActivity.this.dhX.startAnimation(AbsMsgImageActivity.this.dia);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.aX(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.arI();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.dig > 300000000 && AbsMsgImageActivity.this.dhU != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.dhU.size()) {
                    AbsMsgImageActivity.this.dih.put(AbsMsgImageActivity.this.dhU.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.dhZ = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void db(int i) {
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
                                byte[] currentImageData = AbsMsgImageActivity.this.dhY.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.dhY.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.dhV = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.dhV.execute(new String[0]);
                                    AbsMsgImageActivity.this.dhW.setClickable(false);
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
        this.dhX = (NavigationBar) findViewById(d.h.navigation_bar);
        this.dhW = (FrameLayout) this.dhX.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.image_activity_save_button, this.mOnClickListener);
        if (this.dij) {
            this.dhW.setVisibility(8);
        }
        this.arn = this.dhX.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.mTextView = this.dhX.setTitleText("");
        this.dhY = (MultiImageView) findViewById(d.h.viewpager);
        this.dhY.setPageMargin(k.dip2px(getPageContext().getContext(), 8.0f));
        this.dhY.J(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.dhY.setOnPageChangeListener(this.mOnPageChangeListener);
        this.dhY.setItemOnclickListener(this.mOnClickListener);
        this.dhY.setCurrentItem(arJ(), false);
        this.dhY.setOnScrollOutListener(this.dhZ);
        this.dhY.setItemOnLongClickListener(onLongClickListener);
        this.dhY.setHasNext(false);
        this.dhY.setNextTitle("mNextTitle");
        this.dhY.setIsFromCDN(true);
        this.dhY.setAllowLocalUrl(true);
        aX(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arI() {
        if (this.dhU != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.dhY.getHasNext() && this.mIndex == this.dhY.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(d.l.image_recommend));
                this.dhW.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.dhW.setClickable(true);
        }
    }

    private int arJ() {
        if (this.dhU != null && this.dhU.size() > 0) {
            int size = this.dhU.size();
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
            this.did = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.die = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.dif = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.dij = intent.getBooleanExtra("isSingle", false);
            if (this.dif == null) {
                this.dif = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.did == null) {
                this.did = "";
            }
            this.dhU = new LinkedHashMap<>();
            this.dhU.put(this.dif, this.did);
            this.dii = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.dhU = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.dif = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.dii = bundle.getInt("chat_mode", 0);
            this.dij = bundle.getBoolean("isSingle", false);
            if (this.dif == null) {
                this.dif = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.dih = new HashMap<>();
    }

    private void arK() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.dij) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.did)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.dif, AbsMsgImageActivity.this.did);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.die;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.did, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = AbsMsgImageActivity.this.dif;
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
                    AbsMsgImageActivity.this.arI();
                    AbsMsgImageActivity.this.dhY.setIsFromCDN(true);
                    AbsMsgImageActivity.this.dhY.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.dhY.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.dhY.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.dhY.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.dhU);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.dif);
        bundle.putInt("chat_mode", this.dii);
        bundle.putBoolean("isSingle", this.dij);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.dhY.setCurrentItem(this.mIndex, true);
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
            switch (com.baidu.tbadk.core.util.k.a(this.mUrl, this.mData, AbsMsgImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.k.uJ();
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
            AbsMsgImageActivity.this.dhV = null;
            AbsMsgImageActivity.this.dhW.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.dhV = null;
            AbsMsgImageActivity.this.dhW.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(int i, int i2) {
        synchronized (this.dih) {
            if (System.nanoTime() - this.dig > 300000000 && this.dhU != null && i < this.dhU.size()) {
                this.dih.put(this.dhU.get("" + i), true);
            }
            this.dig = System.nanoTime();
        }
    }
}
