package com.baidu.tieba.im.chat;

import android.annotation.SuppressLint;
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
    private String dBC;
    private boolean dBH;
    private FrameLayout dBu;
    private int mCount;
    private LinkedHashMap<String, String> dBs = null;
    private int mIndex = 0;
    private a dBt = null;
    private View aqy = null;
    private TextView abZ = null;
    private NavigationBar dBv = null;
    private MultiImageView dBw = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a dBx = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation dBy = null;
    private boolean dBz = true;
    private boolean dBA = false;
    private String dBB = "";
    private String id = "";
    private String dBD = "";
    private long dBE = 0;
    private HashMap<String, Boolean> dBF = null;
    private int dBG = 0;

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
        awx();
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
        awx();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.k(this.dBw, d.C0082d.black_alpha100);
        aj.k(this.dBv, d.C0082d.common_color_10222);
        getLayoutMode().t(this.aqy);
        getLayoutMode().t(this.abZ);
        getLayoutMode().t(this.dBu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.dBw.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dBw.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.dBw.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        bc(this.mIndex, this.mIndex);
        this.dBw.onDestroy();
        if (this.dBt != null) {
            this.dBt.cancel();
            this.dBt = null;
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
                if (view == AbsMsgImageActivity.this.aqy) {
                    if (AbsMsgImageActivity.this.dBv.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view == AbsMsgImageActivity.this.dBu) {
                    if (AbsMsgImageActivity.this.dBv.getVisibility() != 8) {
                        try {
                            byte[] currentImageData = AbsMsgImageActivity.this.dBw.getCurrentImageData();
                            if (currentImageData != null) {
                                String currentImageUrl = AbsMsgImageActivity.this.dBw.getCurrentImageUrl();
                                AbsMsgImageActivity.this.dBt = new a(currentImageUrl, currentImageData);
                                AbsMsgImageActivity.this.dBt.execute(new String[0]);
                                AbsMsgImageActivity.this.dBu.setClickable(false);
                            } else {
                                AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(d.j.no_data));
                            }
                        } catch (Exception e) {
                        }
                    }
                } else if (AbsMsgImageActivity.this.dBz) {
                    if (AbsMsgImageActivity.this.dBv.getVisibility() != 0) {
                        AbsMsgImageActivity.this.dBv.setVisibility(0);
                        AbsMsgImageActivity.this.dBw.Bl();
                        AbsMsgImageActivity.this.dBy = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.dBy = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.dBA = true;
                        AbsMsgImageActivity.this.dBw.Bm();
                    }
                    AbsMsgImageActivity.this.dBy.setDuration(300L);
                    AbsMsgImageActivity.this.dBy.setFillAfter(true);
                    AbsMsgImageActivity.this.dBy.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.dBz = true;
                            if (AbsMsgImageActivity.this.dBA) {
                                AbsMsgImageActivity.this.dBA = false;
                                AbsMsgImageActivity.this.dBv.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.dBz = false;
                    AbsMsgImageActivity.this.dBv.startAnimation(AbsMsgImageActivity.this.dBy);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.bc(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.apf();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.dBE > 300000000 && AbsMsgImageActivity.this.dBs != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.dBs.size()) {
                    AbsMsgImageActivity.this.dBF.put(AbsMsgImageActivity.this.dBs.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.dBx = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
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
                                byte[] currentImageData = AbsMsgImageActivity.this.dBw.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.dBw.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.dBt = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.dBt.execute(new String[0]);
                                    AbsMsgImageActivity.this.dBu.setClickable(false);
                                } else {
                                    AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(d.j.no_data));
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
                AbsMsgImageActivity.this.createListMenu(new String[]{AbsMsgImageActivity.this.getPageContext().getString(d.j.save)}, interfaceC0047b);
                AbsMsgImageActivity.this.showListMenu();
                return false;
            }
        };
        this.dBv = (NavigationBar) findViewById(d.g.navigation_bar);
        this.dBu = (FrameLayout) this.dBv.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.image_activity_save_button, this.mOnClickListener);
        if (this.dBH) {
            this.dBu.setVisibility(8);
        }
        this.aqy = this.dBv.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.abZ = this.dBv.setTitleText("");
        this.dBw = (MultiImageView) findViewById(d.g.viewpager);
        this.dBw.setPageMargin(l.dip2px(getPageContext().getContext(), 8.0f));
        this.dBw.F(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.dBw.setOnPageChangeListener(this.mOnPageChangeListener);
        this.dBw.setItemOnclickListener(this.mOnClickListener);
        this.dBw.setCurrentItem(aww(), false);
        this.dBw.setOnScrollOutListener(this.dBx);
        this.dBw.setItemOnLongClickListener(onLongClickListener);
        this.dBw.setHasNext(false);
        this.dBw.setNextTitle("mNextTitle");
        this.dBw.setIsFromCDN(true);
        this.dBw.setAllowLocalUrl(true);
        bc(this.mIndex, this.mIndex);
        this.abZ.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apf() {
        if (this.dBs != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.dBw.getHasNext() && this.mIndex == this.dBw.getItemNum() - 1) {
                this.abZ.setText(getPageContext().getString(d.j.image_recommend));
                this.dBu.setClickable(false);
                return;
            }
            this.abZ.setText(valueOf);
            this.dBu.setClickable(true);
        }
    }

    private int aww() {
        if (this.dBs != null && this.dBs.size() > 0) {
            int size = this.dBs.size();
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
            this.dBB = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.dBC = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.dBD = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.dBH = intent.getBooleanExtra("isSingle", false);
            if (this.dBD == null) {
                this.dBD = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.dBB == null) {
                this.dBB = "";
            }
            this.dBs = new LinkedHashMap<>();
            this.dBs.put(this.dBD, this.dBB);
            this.dBG = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.dBs = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.dBD = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.dBG = bundle.getInt("chat_mode", 0);
            this.dBH = bundle.getBoolean("isSingle", false);
            if (this.dBD == null) {
                this.dBD = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.dBF = new HashMap<>();
    }

    private void awx() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.dBH) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.dBB)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.dBD, AbsMsgImageActivity.this.dBB);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.dBC;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.dBB, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = AbsMsgImageActivity.this.dBD;
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
                    AbsMsgImageActivity.this.abZ.setVisibility(0);
                    AbsMsgImageActivity.this.apf();
                    AbsMsgImageActivity.this.dBw.setIsFromCDN(true);
                    AbsMsgImageActivity.this.dBw.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.dBw.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.dBw.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.dBw.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.dBs);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.dBD);
        bundle.putInt("chat_mode", this.dBG);
        bundle.putBoolean("isSingle", this.dBH);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.dBw.setCurrentItem(this.mIndex, true);
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
                    return k.uk();
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
            AbsMsgImageActivity.this.dBt = null;
            AbsMsgImageActivity.this.dBu.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.dBt = null;
            AbsMsgImageActivity.this.dBu.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bc(int i, int i2) {
        synchronized (this.dBF) {
            if (System.nanoTime() - this.dBE > 300000000 && this.dBs != null && i < this.dBs.size()) {
                this.dBF.put(this.dBs.get("" + i), true);
            }
            this.dBE = System.nanoTime();
        }
    }
}
