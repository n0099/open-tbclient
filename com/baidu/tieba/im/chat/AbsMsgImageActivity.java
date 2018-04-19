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
    private com.baidu.tbadk.core.util.b.a baD;
    private String dPA;
    private boolean dPF;
    private FrameLayout dPs;
    private int mCount;
    private LinkedHashMap<String, String> dPq = null;
    private int mIndex = 0;
    private a dPr = null;
    private View asg = null;
    private TextView mTextView = null;
    private NavigationBar dPt = null;
    private MultiImageView dPu = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a dPv = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation dPw = null;
    private boolean dPx = true;
    private boolean dPy = false;
    private String dPz = "";
    private String id = "";
    private String dPB = "";
    private long dPC = 0;
    private HashMap<String, Boolean> dPD = null;
    private int dPE = 0;

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
        aAl();
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
        aAl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ak.j(this.dPu, d.C0126d.black_alpha100);
        ak.j(this.dPt, d.C0126d.common_color_10222);
        getLayoutMode().u(this.asg);
        getLayoutMode().u(this.mTextView);
        getLayoutMode().u(this.dPs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.dPu.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dPu.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.dPu.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        bb(this.mIndex, this.mIndex);
        this.dPu.onDestroy();
        if (this.dPr != null) {
            this.dPr.cancel();
            this.dPr = null;
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
                    if (AbsMsgImageActivity.this.dPt.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view2 == AbsMsgImageActivity.this.dPs) {
                    if (AbsMsgImageActivity.this.dPt.getVisibility() != 8) {
                        Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                        if (AbsMsgImageActivity.this.baD == null) {
                            AbsMsgImageActivity.this.baD = new com.baidu.tbadk.core.util.b.a();
                        }
                        AbsMsgImageActivity.this.baD.wu();
                        AbsMsgImageActivity.this.baD.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!AbsMsgImageActivity.this.baD.v(pageActivity)) {
                            try {
                                byte[] currentImageData = AbsMsgImageActivity.this.dPu.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.dPu.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.dPr = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.dPr.execute(new String[0]);
                                    AbsMsgImageActivity.this.dPs.setClickable(false);
                                } else {
                                    AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(d.k.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (AbsMsgImageActivity.this.dPx) {
                    if (AbsMsgImageActivity.this.dPt.getVisibility() != 0) {
                        AbsMsgImageActivity.this.dPt.setVisibility(0);
                        AbsMsgImageActivity.this.dPu.BZ();
                        AbsMsgImageActivity.this.dPw = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.dPw = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.dPy = true;
                        AbsMsgImageActivity.this.dPu.Ca();
                    }
                    AbsMsgImageActivity.this.dPw.setDuration(300L);
                    AbsMsgImageActivity.this.dPw.setFillAfter(true);
                    AbsMsgImageActivity.this.dPw.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.dPx = true;
                            if (AbsMsgImageActivity.this.dPy) {
                                AbsMsgImageActivity.this.dPy = false;
                                AbsMsgImageActivity.this.dPt.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.dPx = false;
                    AbsMsgImageActivity.this.dPt.startAnimation(AbsMsgImageActivity.this.dPw);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.bb(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.atk();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.dPC > 300000000 && AbsMsgImageActivity.this.dPq != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.dPq.size()) {
                    AbsMsgImageActivity.this.dPD.put(AbsMsgImageActivity.this.dPq.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.dPv = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void cY(int i) {
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
                                if (AbsMsgImageActivity.this.baD == null) {
                                    AbsMsgImageActivity.this.baD = new com.baidu.tbadk.core.util.b.a();
                                }
                                AbsMsgImageActivity.this.baD.wu();
                                AbsMsgImageActivity.this.baD.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                                if (!AbsMsgImageActivity.this.baD.v(pageActivity)) {
                                    byte[] currentImageData = AbsMsgImageActivity.this.dPu.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = AbsMsgImageActivity.this.dPu.getCurrentImageUrl();
                                        AbsMsgImageActivity.this.dPr = new a(currentImageUrl, currentImageData);
                                        AbsMsgImageActivity.this.dPr.execute(new String[0]);
                                        AbsMsgImageActivity.this.dPs.setClickable(false);
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
        this.dPt = (NavigationBar) findViewById(d.g.navigation_bar);
        this.dPs = (FrameLayout) this.dPt.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.image_activity_save_button, this.mOnClickListener);
        if (this.dPF) {
            this.dPs.setVisibility(8);
        }
        this.asg = this.dPt.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.mTextView = this.dPt.setTitleText("");
        this.dPu = (MultiImageView) findViewById(d.g.viewpager);
        this.dPu.setPageMargin(l.dip2px(getPageContext().getContext(), 8.0f));
        this.dPu.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.dPu.setOnPageChangeListener(this.mOnPageChangeListener);
        this.dPu.setItemOnclickListener(this.mOnClickListener);
        this.dPu.setCurrentItem(aAk(), false);
        this.dPu.setOnScrollOutListener(this.dPv);
        this.dPu.setItemOnLongClickListener(onLongClickListener);
        this.dPu.setHasNext(false);
        this.dPu.setNextTitle("mNextTitle");
        this.dPu.setIsFromCDN(true);
        this.dPu.setAllowLocalUrl(true);
        bb(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atk() {
        if (this.dPq != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.dPu.getHasNext() && this.mIndex == this.dPu.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(d.k.image_recommend));
                this.dPs.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.dPs.setClickable(true);
        }
    }

    private int aAk() {
        if (this.dPq != null && this.dPq.size() > 0) {
            int size = this.dPq.size();
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
            this.dPz = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.dPA = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.dPB = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.dPF = intent.getBooleanExtra("isSingle", false);
            if (this.dPB == null) {
                this.dPB = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.dPz == null) {
                this.dPz = "";
            }
            this.dPq = new LinkedHashMap<>();
            this.dPq.put(this.dPB, this.dPz);
            this.dPE = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.dPq = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.dPB = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.dPE = bundle.getInt("chat_mode", 0);
            this.dPF = bundle.getBoolean("isSingle", false);
            if (this.dPB == null) {
                this.dPB = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.dPD = new HashMap<>();
    }

    private void aAl() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.dPF) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.dPz)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.dPB, AbsMsgImageActivity.this.dPz);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.dPA;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.dPz, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = AbsMsgImageActivity.this.dPB;
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
                    AbsMsgImageActivity.this.atk();
                    AbsMsgImageActivity.this.dPu.setIsFromCDN(true);
                    AbsMsgImageActivity.this.dPu.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.dPu.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.dPu.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.dPu.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.dPq);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.dPB);
        bundle.putInt("chat_mode", this.dPE);
        bundle.putBoolean("isSingle", this.dPF);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.dPu.setCurrentItem(this.mIndex, true);
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
                    return k.uD();
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
            AbsMsgImageActivity.this.dPr = null;
            AbsMsgImageActivity.this.dPs.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.dPr = null;
            AbsMsgImageActivity.this.dPs.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb(int i, int i2) {
        synchronized (this.dPD) {
            if (System.nanoTime() - this.dPC > 300000000 && this.dPq != null && i < this.dPq.size()) {
                this.dPD.put(this.dPq.get("" + i), true);
            }
            this.dPC = System.nanoTime();
        }
    }
}
