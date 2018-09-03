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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public abstract class AbsMsgImageActivity extends BaseActivity<AbsMsgImageActivity> {
    private com.baidu.tbadk.core.util.b.a bkZ;
    private boolean ejB;
    private FrameLayout ejo;
    private String ejw;
    private int mCount;
    private LinkedHashMap<String, String> ejm = null;
    private int mIndex = 0;
    private a ejn = null;
    private View aAW = null;
    private TextView mTextView = null;
    private NavigationBar ejp = null;
    private MultiImageView ejq = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a ejr = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation ejs = null;
    private boolean ejt = true;
    private boolean eju = false;
    private String ejv = "";
    private String id = "";
    private String ejx = "";
    private long ejy = 0;
    private HashMap<String, Boolean> ejz = null;
    private int ejA = 0;

    protected abstract void a(String str, com.baidu.tieba.im.sendmessage.c cVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(f.h.image_activity_2);
        initData(bundle);
        initUI();
        aGJ();
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
        aGJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.j(this.ejq, f.d.black_alpha100);
        am.j(this.ejp, f.d.common_color_10222);
        getLayoutMode().onModeChanged(this.aAW);
        getLayoutMode().onModeChanged(this.mTextView);
        getLayoutMode().onModeChanged(this.ejo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.ejq.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.ejq.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.ejq.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        be(this.mIndex, this.mIndex);
        this.ejq.onDestroy();
        if (this.ejn != null) {
            this.ejn.cancel();
            this.ejn = null;
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
                if (view == AbsMsgImageActivity.this.aAW) {
                    if (AbsMsgImageActivity.this.ejp.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view == AbsMsgImageActivity.this.ejo) {
                    if (AbsMsgImageActivity.this.ejp.getVisibility() != 8) {
                        Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                        if (AbsMsgImageActivity.this.bkZ == null) {
                            AbsMsgImageActivity.this.bkZ = new com.baidu.tbadk.core.util.b.a();
                        }
                        AbsMsgImageActivity.this.bkZ.zW();
                        AbsMsgImageActivity.this.bkZ.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!AbsMsgImageActivity.this.bkZ.u(pageActivity)) {
                            try {
                                byte[] currentImageData = AbsMsgImageActivity.this.ejq.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.ejq.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.ejn = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.ejn.execute(new String[0]);
                                    AbsMsgImageActivity.this.ejo.setClickable(false);
                                } else {
                                    AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(f.j.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (AbsMsgImageActivity.this.ejt) {
                    if (AbsMsgImageActivity.this.ejp.getVisibility() != 0) {
                        AbsMsgImageActivity.this.ejp.setVisibility(0);
                        AbsMsgImageActivity.this.ejq.FO();
                        AbsMsgImageActivity.this.ejs = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.ejs = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.eju = true;
                        AbsMsgImageActivity.this.ejq.FP();
                    }
                    AbsMsgImageActivity.this.ejs.setDuration(300L);
                    AbsMsgImageActivity.this.ejs.setFillAfter(true);
                    AbsMsgImageActivity.this.ejs.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.ejt = true;
                            if (AbsMsgImageActivity.this.eju) {
                                AbsMsgImageActivity.this.eju = false;
                                AbsMsgImageActivity.this.ejp.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.ejt = false;
                    AbsMsgImageActivity.this.ejp.startAnimation(AbsMsgImageActivity.this.ejs);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.be(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.ayw();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.ejy > 300000000 && AbsMsgImageActivity.this.ejm != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.ejm.size()) {
                    AbsMsgImageActivity.this.ejz.put(AbsMsgImageActivity.this.ejm.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.ejr = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void de(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0101b interfaceC0101b = new b.InterfaceC0101b() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar == AbsMsgImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            try {
                                Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                                if (AbsMsgImageActivity.this.bkZ == null) {
                                    AbsMsgImageActivity.this.bkZ = new com.baidu.tbadk.core.util.b.a();
                                }
                                AbsMsgImageActivity.this.bkZ.zW();
                                AbsMsgImageActivity.this.bkZ.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                                if (!AbsMsgImageActivity.this.bkZ.u(pageActivity)) {
                                    byte[] currentImageData = AbsMsgImageActivity.this.ejq.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = AbsMsgImageActivity.this.ejq.getCurrentImageUrl();
                                        AbsMsgImageActivity.this.ejn = new a(currentImageUrl, currentImageData);
                                        AbsMsgImageActivity.this.ejn.execute(new String[0]);
                                        AbsMsgImageActivity.this.ejo.setClickable(false);
                                        break;
                                    } else {
                                        AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(f.j.no_data));
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
                AbsMsgImageActivity.this.createListMenu(new String[]{AbsMsgImageActivity.this.getPageContext().getString(f.j.save)}, interfaceC0101b);
                AbsMsgImageActivity.this.showListMenu();
                return false;
            }
        };
        this.ejp = (NavigationBar) findViewById(f.g.navigation_bar);
        this.ejo = (FrameLayout) this.ejp.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, f.h.image_activity_save_button, this.mOnClickListener);
        if (this.ejB) {
            this.ejo.setVisibility(8);
        }
        this.aAW = this.ejp.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        am.c(this.ejp.getBackImageView(), f.C0146f.icon_return_bg);
        this.mTextView = this.ejp.setTitleText("");
        this.ejq = (MultiImageView) findViewById(f.g.viewpager);
        this.ejq.setPageMargin(l.dip2px(getPageContext().getContext(), 8.0f));
        this.ejq.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.ejq.setOnPageChangeListener(this.mOnPageChangeListener);
        this.ejq.setItemOnclickListener(this.mOnClickListener);
        this.ejq.setCurrentItem(aGI(), false);
        this.ejq.setOnScrollOutListener(this.ejr);
        this.ejq.setItemOnLongClickListener(onLongClickListener);
        this.ejq.setHasNext(false);
        this.ejq.setNextTitle("mNextTitle");
        this.ejq.setIsFromCDN(true);
        this.ejq.setAllowLocalUrl(true);
        be(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayw() {
        if (this.ejm != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.ejq.getHasNext() && this.mIndex == this.ejq.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(f.j.image_recommend));
                this.ejo.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.ejo.setClickable(true);
        }
    }

    private int aGI() {
        if (this.ejm != null && this.ejm.size() > 0) {
            int size = this.ejm.size();
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
            this.ejv = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.ejw = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.ejx = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.ejB = intent.getBooleanExtra("isSingle", false);
            if (this.ejx == null) {
                this.ejx = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.ejv == null) {
                this.ejv = "";
            }
            this.ejm = new LinkedHashMap<>();
            this.ejm.put(this.ejx, this.ejv);
            this.ejA = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.ejm = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.ejx = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.ejA = bundle.getInt("chat_mode", 0);
            this.ejB = bundle.getBoolean("isSingle", false);
            if (this.ejx == null) {
                this.ejx = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.ejz = new HashMap<>();
    }

    private void aGJ() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.ejB) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.ejv)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.ejx, AbsMsgImageActivity.this.ejv);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.ejw;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.ejv, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = AbsMsgImageActivity.this.ejx;
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
                    AbsMsgImageActivity.this.ayw();
                    AbsMsgImageActivity.this.ejq.setIsFromCDN(true);
                    AbsMsgImageActivity.this.ejq.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.ejq.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.ejq.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.ejq.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.ejm);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.ejx);
        bundle.putInt("chat_mode", this.ejA);
        bundle.putBoolean("isSingle", this.ejB);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.ejq.setCurrentItem(this.mIndex, true);
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
                    return com.baidu.tbadk.core.util.l.yh();
                case -1:
                default:
                    return AbsMsgImageActivity.this.getPageContext().getString(f.j.save_fail);
                case 0:
                    return AbsMsgImageActivity.this.getPageContext().getString(f.j.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            AbsMsgImageActivity.this.ejn = null;
            AbsMsgImageActivity.this.ejo.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.ejn = null;
            AbsMsgImageActivity.this.ejo.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(int i, int i2) {
        synchronized (this.ejz) {
            if (System.nanoTime() - this.ejy > 300000000 && this.ejm != null && i < this.ejm.size()) {
                this.ejz.put(this.ejm.get("" + i), true);
            }
            this.ejy = System.nanoTime();
        }
    }
}
