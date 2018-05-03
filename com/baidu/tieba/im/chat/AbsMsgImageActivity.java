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
    private boolean dPC;
    private FrameLayout dPp;
    private String dPx;
    private int mCount;
    private LinkedHashMap<String, String> dPn = null;
    private int mIndex = 0;
    private a dPo = null;
    private View asg = null;
    private TextView mTextView = null;
    private NavigationBar dPq = null;
    private MultiImageView dPr = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a dPs = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation dPt = null;
    private boolean dPu = true;
    private boolean dPv = false;
    private String dPw = "";
    private String id = "";
    private String dPy = "";
    private long dPz = 0;
    private HashMap<String, Boolean> dPA = null;
    private int dPB = 0;

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
        ak.j(this.dPr, d.C0126d.black_alpha100);
        ak.j(this.dPq, d.C0126d.common_color_10222);
        getLayoutMode().u(this.asg);
        getLayoutMode().u(this.mTextView);
        getLayoutMode().u(this.dPp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.dPr.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dPr.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.dPr.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        ba(this.mIndex, this.mIndex);
        this.dPr.onDestroy();
        if (this.dPo != null) {
            this.dPo.cancel();
            this.dPo = null;
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
                    if (AbsMsgImageActivity.this.dPq.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view2 == AbsMsgImageActivity.this.dPp) {
                    if (AbsMsgImageActivity.this.dPq.getVisibility() != 8) {
                        Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                        if (AbsMsgImageActivity.this.baD == null) {
                            AbsMsgImageActivity.this.baD = new com.baidu.tbadk.core.util.b.a();
                        }
                        AbsMsgImageActivity.this.baD.wu();
                        AbsMsgImageActivity.this.baD.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!AbsMsgImageActivity.this.baD.v(pageActivity)) {
                            try {
                                byte[] currentImageData = AbsMsgImageActivity.this.dPr.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.dPr.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.dPo = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.dPo.execute(new String[0]);
                                    AbsMsgImageActivity.this.dPp.setClickable(false);
                                } else {
                                    AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(d.k.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (AbsMsgImageActivity.this.dPu) {
                    if (AbsMsgImageActivity.this.dPq.getVisibility() != 0) {
                        AbsMsgImageActivity.this.dPq.setVisibility(0);
                        AbsMsgImageActivity.this.dPr.BZ();
                        AbsMsgImageActivity.this.dPt = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.dPt = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.dPv = true;
                        AbsMsgImageActivity.this.dPr.Ca();
                    }
                    AbsMsgImageActivity.this.dPt.setDuration(300L);
                    AbsMsgImageActivity.this.dPt.setFillAfter(true);
                    AbsMsgImageActivity.this.dPt.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.dPu = true;
                            if (AbsMsgImageActivity.this.dPv) {
                                AbsMsgImageActivity.this.dPv = false;
                                AbsMsgImageActivity.this.dPq.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.dPu = false;
                    AbsMsgImageActivity.this.dPq.startAnimation(AbsMsgImageActivity.this.dPt);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.ba(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.atk();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.dPz > 300000000 && AbsMsgImageActivity.this.dPn != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.dPn.size()) {
                    AbsMsgImageActivity.this.dPA.put(AbsMsgImageActivity.this.dPn.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.dPs = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
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
                                    byte[] currentImageData = AbsMsgImageActivity.this.dPr.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = AbsMsgImageActivity.this.dPr.getCurrentImageUrl();
                                        AbsMsgImageActivity.this.dPo = new a(currentImageUrl, currentImageData);
                                        AbsMsgImageActivity.this.dPo.execute(new String[0]);
                                        AbsMsgImageActivity.this.dPp.setClickable(false);
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
        this.dPq = (NavigationBar) findViewById(d.g.navigation_bar);
        this.dPp = (FrameLayout) this.dPq.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.image_activity_save_button, this.mOnClickListener);
        if (this.dPC) {
            this.dPp.setVisibility(8);
        }
        this.asg = this.dPq.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.mTextView = this.dPq.setTitleText("");
        this.dPr = (MultiImageView) findViewById(d.g.viewpager);
        this.dPr.setPageMargin(l.dip2px(getPageContext().getContext(), 8.0f));
        this.dPr.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.dPr.setOnPageChangeListener(this.mOnPageChangeListener);
        this.dPr.setItemOnclickListener(this.mOnClickListener);
        this.dPr.setCurrentItem(aAk(), false);
        this.dPr.setOnScrollOutListener(this.dPs);
        this.dPr.setItemOnLongClickListener(onLongClickListener);
        this.dPr.setHasNext(false);
        this.dPr.setNextTitle("mNextTitle");
        this.dPr.setIsFromCDN(true);
        this.dPr.setAllowLocalUrl(true);
        ba(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atk() {
        if (this.dPn != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.dPr.getHasNext() && this.mIndex == this.dPr.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(d.k.image_recommend));
                this.dPp.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.dPp.setClickable(true);
        }
    }

    private int aAk() {
        if (this.dPn != null && this.dPn.size() > 0) {
            int size = this.dPn.size();
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
            this.dPw = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.dPx = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.dPy = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.dPC = intent.getBooleanExtra("isSingle", false);
            if (this.dPy == null) {
                this.dPy = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.dPw == null) {
                this.dPw = "";
            }
            this.dPn = new LinkedHashMap<>();
            this.dPn.put(this.dPy, this.dPw);
            this.dPB = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.dPn = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.dPy = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.dPB = bundle.getInt("chat_mode", 0);
            this.dPC = bundle.getBoolean("isSingle", false);
            if (this.dPy == null) {
                this.dPy = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.dPA = new HashMap<>();
    }

    private void aAl() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.dPC) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.dPw)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.dPy, AbsMsgImageActivity.this.dPw);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.dPx;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.dPw, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = AbsMsgImageActivity.this.dPy;
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
                    AbsMsgImageActivity.this.dPr.setIsFromCDN(true);
                    AbsMsgImageActivity.this.dPr.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.dPr.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.dPr.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.dPr.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.dPn);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.dPy);
        bundle.putInt("chat_mode", this.dPB);
        bundle.putBoolean("isSingle", this.dPC);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.dPr.setCurrentItem(this.mIndex, true);
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
            AbsMsgImageActivity.this.dPo = null;
            AbsMsgImageActivity.this.dPp.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.dPo = null;
            AbsMsgImageActivity.this.dPp.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba(int i, int i2) {
        synchronized (this.dPA) {
            if (System.nanoTime() - this.dPz > 300000000 && this.dPn != null && i < this.dPn.size()) {
                this.dPA.put(this.dPn.get("" + i), true);
            }
            this.dPz = System.nanoTime();
        }
    }
}
