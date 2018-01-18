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
    private FrameLayout eqc;
    private String eqk;
    private boolean eqp;
    private int mCount;
    private LinkedHashMap<String, String> eqa = null;
    private int mIndex = 0;
    private a eqb = null;
    private View beJ = null;
    private TextView rz = null;
    private NavigationBar eqd = null;
    private MultiImageView eqe = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a eqf = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation eqg = null;
    private boolean eqh = true;
    private boolean eqi = false;
    private String eqj = "";
    private String id = "";
    private String eql = "";
    private long eqm = 0;
    private HashMap<String, Boolean> eqn = null;
    private int eqo = 0;

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
        aDM();
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
        aDM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.t(this.eqe, d.C0107d.black_alpha100);
        aj.t(this.eqd, d.C0107d.common_color_10222);
        getLayoutMode().aM(this.beJ);
        getLayoutMode().aM(this.rz);
        getLayoutMode().aM(this.eqc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eqe.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eqe.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.eqe.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        cb(this.mIndex, this.mIndex);
        this.eqe.onDestroy();
        if (this.eqb != null) {
            this.eqb.cancel();
            this.eqb = null;
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
                if (view == AbsMsgImageActivity.this.beJ) {
                    if (AbsMsgImageActivity.this.eqd.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view == AbsMsgImageActivity.this.eqc) {
                    if (AbsMsgImageActivity.this.eqd.getVisibility() != 8) {
                        try {
                            byte[] currentImageData = AbsMsgImageActivity.this.eqe.getCurrentImageData();
                            if (currentImageData != null) {
                                String currentImageUrl = AbsMsgImageActivity.this.eqe.getCurrentImageUrl();
                                AbsMsgImageActivity.this.eqb = new a(currentImageUrl, currentImageData);
                                AbsMsgImageActivity.this.eqb.execute(new String[0]);
                                AbsMsgImageActivity.this.eqc.setClickable(false);
                            } else {
                                AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(d.j.no_data));
                            }
                        } catch (Exception e) {
                        }
                    }
                } else if (AbsMsgImageActivity.this.eqh) {
                    if (AbsMsgImageActivity.this.eqd.getVisibility() != 0) {
                        AbsMsgImageActivity.this.eqd.setVisibility(0);
                        AbsMsgImageActivity.this.eqe.ID();
                        AbsMsgImageActivity.this.eqg = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.eqg = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.eqi = true;
                        AbsMsgImageActivity.this.eqe.IE();
                    }
                    AbsMsgImageActivity.this.eqg.setDuration(300L);
                    AbsMsgImageActivity.this.eqg.setFillAfter(true);
                    AbsMsgImageActivity.this.eqg.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.eqh = true;
                            if (AbsMsgImageActivity.this.eqi) {
                                AbsMsgImageActivity.this.eqi = false;
                                AbsMsgImageActivity.this.eqd.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.eqh = false;
                    AbsMsgImageActivity.this.eqd.startAnimation(AbsMsgImageActivity.this.eqg);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.cb(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.axr();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.eqm > 300000000 && AbsMsgImageActivity.this.eqa != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.eqa.size()) {
                    AbsMsgImageActivity.this.eqn.put(AbsMsgImageActivity.this.eqa.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.eqf = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void fX(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0073b interfaceC0073b = new b.InterfaceC0073b() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0073b
            public void a(b bVar, int i, View view) {
                if (bVar == AbsMsgImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            try {
                                byte[] currentImageData = AbsMsgImageActivity.this.eqe.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.eqe.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.eqb = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.eqb.execute(new String[0]);
                                    AbsMsgImageActivity.this.eqc.setClickable(false);
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
                AbsMsgImageActivity.this.createListMenu(new String[]{AbsMsgImageActivity.this.getPageContext().getString(d.j.save)}, interfaceC0073b);
                AbsMsgImageActivity.this.showListMenu();
                return false;
            }
        };
        this.eqd = (NavigationBar) findViewById(d.g.navigation_bar);
        this.eqc = (FrameLayout) this.eqd.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.image_activity_save_button, this.mOnClickListener);
        if (this.eqp) {
            this.eqc.setVisibility(8);
        }
        this.beJ = this.eqd.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.rz = this.eqd.setTitleText("");
        this.eqe = (MultiImageView) findViewById(d.g.viewpager);
        this.eqe.setPageMargin(l.dip2px(getPageContext().getContext(), 8.0f));
        this.eqe.aF(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.eqe.setOnPageChangeListener(this.mOnPageChangeListener);
        this.eqe.setItemOnclickListener(this.mOnClickListener);
        this.eqe.setCurrentItem(aDL(), false);
        this.eqe.setOnScrollOutListener(this.eqf);
        this.eqe.setItemOnLongClickListener(onLongClickListener);
        this.eqe.setHasNext(false);
        this.eqe.setNextTitle("mNextTitle");
        this.eqe.setIsFromCDN(true);
        this.eqe.setAllowLocalUrl(true);
        cb(this.mIndex, this.mIndex);
        this.rz.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axr() {
        if (this.eqa != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.eqe.getHasNext() && this.mIndex == this.eqe.getItemNum() - 1) {
                this.rz.setText(getPageContext().getString(d.j.image_recommend));
                this.eqc.setClickable(false);
                return;
            }
            this.rz.setText(valueOf);
            this.eqc.setClickable(true);
        }
    }

    private int aDL() {
        if (this.eqa != null && this.eqa.size() > 0) {
            int size = this.eqa.size();
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
            this.eqj = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.eqk = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.eql = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.eqp = intent.getBooleanExtra("isSingle", false);
            if (this.eql == null) {
                this.eql = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.eqj == null) {
                this.eqj = "";
            }
            this.eqa = new LinkedHashMap<>();
            this.eqa.put(this.eql, this.eqj);
            this.eqo = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.eqa = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.eql = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.eqo = bundle.getInt("chat_mode", 0);
            this.eqp = bundle.getBoolean("isSingle", false);
            if (this.eql == null) {
                this.eql = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.eqn = new HashMap<>();
    }

    private void aDM() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.eqp) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.eqj)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.eql, AbsMsgImageActivity.this.eqj);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.eqk;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.eqj, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = AbsMsgImageActivity.this.eql;
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
                    AbsMsgImageActivity.this.rz.setVisibility(0);
                    AbsMsgImageActivity.this.axr();
                    AbsMsgImageActivity.this.eqe.setIsFromCDN(true);
                    AbsMsgImageActivity.this.eqe.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.eqe.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.eqe.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.eqe.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.eqa);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.eql);
        bundle.putInt("chat_mode", this.eqo);
        bundle.putBoolean("isSingle", this.eqp);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.eqe.setCurrentItem(this.mIndex, true);
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
                    return k.Bz();
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
            AbsMsgImageActivity.this.eqb = null;
            AbsMsgImageActivity.this.eqc.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.eqb = null;
            AbsMsgImageActivity.this.eqc.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb(int i, int i2) {
        synchronized (this.eqn) {
            if (System.nanoTime() - this.eqm > 300000000 && this.eqa != null && i < this.eqa.size()) {
                this.eqn.put(this.eqa.get("" + i), true);
            }
            this.eqm = System.nanoTime();
        }
    }
}
