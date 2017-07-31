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
    private FrameLayout dfZ;
    private String dgh;
    private boolean dgm;
    private int mCount;
    private LinkedHashMap<String, String> dfX = null;
    private int mIndex = 0;
    private a dfY = null;
    private View arm = null;
    private TextView mTextView = null;
    private NavigationBar dga = null;
    private MultiImageView dgb = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a dgc = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation dgd = null;
    private boolean dge = true;
    private boolean dgf = false;
    private String dgg = "";
    private String id = "";
    private String dgi = "";
    private long dgj = 0;
    private HashMap<String, Boolean> dgk = null;
    private int dgl = 0;

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
        ark();
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
        ark();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.dgb.setBackgroundColor(ai.cQ(i));
        } else {
            this.dgb.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        ai.k(this.dga, d.e.common_color_10222);
        getLayoutMode().t(this.arm);
        getLayoutMode().t(this.mTextView);
        getLayoutMode().t(this.dfZ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.dgb.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dgb.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.dgb.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        aP(this.mIndex, this.mIndex);
        this.dgb.onDestroy();
        if (this.dfY != null) {
            this.dfY.cancel();
            this.dfY = null;
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
                if (view == AbsMsgImageActivity.this.arm) {
                    if (AbsMsgImageActivity.this.dga.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view == AbsMsgImageActivity.this.dfZ) {
                    if (AbsMsgImageActivity.this.dga.getVisibility() != 8) {
                        try {
                            byte[] currentImageData = AbsMsgImageActivity.this.dgb.getCurrentImageData();
                            if (currentImageData != null) {
                                String currentImageUrl = AbsMsgImageActivity.this.dgb.getCurrentImageUrl();
                                AbsMsgImageActivity.this.dfY = new a(currentImageUrl, currentImageData);
                                AbsMsgImageActivity.this.dfY.execute(new String[0]);
                                AbsMsgImageActivity.this.dfZ.setClickable(false);
                            } else {
                                AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(d.l.no_data));
                            }
                        } catch (Exception e) {
                        }
                    }
                } else if (AbsMsgImageActivity.this.dge) {
                    if (AbsMsgImageActivity.this.dga.getVisibility() != 0) {
                        AbsMsgImageActivity.this.dga.setVisibility(0);
                        AbsMsgImageActivity.this.dgb.Bt();
                        AbsMsgImageActivity.this.dgd = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.dgd = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.dgf = true;
                        AbsMsgImageActivity.this.dgb.Bu();
                    }
                    AbsMsgImageActivity.this.dgd.setDuration(300L);
                    AbsMsgImageActivity.this.dgd.setFillAfter(true);
                    AbsMsgImageActivity.this.dgd.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.dge = true;
                            if (AbsMsgImageActivity.this.dgf) {
                                AbsMsgImageActivity.this.dgf = false;
                                AbsMsgImageActivity.this.dga.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.dge = false;
                    AbsMsgImageActivity.this.dga.startAnimation(AbsMsgImageActivity.this.dgd);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.aP(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.ari();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.dgj > 300000000 && AbsMsgImageActivity.this.dfX != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.dfX.size()) {
                    AbsMsgImageActivity.this.dgk.put(AbsMsgImageActivity.this.dfX.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.dgc = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
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
                                byte[] currentImageData = AbsMsgImageActivity.this.dgb.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.dgb.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.dfY = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.dfY.execute(new String[0]);
                                    AbsMsgImageActivity.this.dfZ.setClickable(false);
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
        this.dga = (NavigationBar) findViewById(d.h.navigation_bar);
        this.dfZ = (FrameLayout) this.dga.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.image_activity_save_button, this.mOnClickListener);
        if (this.dgm) {
            this.dfZ.setVisibility(8);
        }
        this.arm = this.dga.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.mTextView = this.dga.setTitleText("");
        this.dgb = (MultiImageView) findViewById(d.h.viewpager);
        this.dgb.setPageMargin(k.dip2px(getPageContext().getContext(), 8.0f));
        this.dgb.J(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.dgb.setOnPageChangeListener(this.mOnPageChangeListener);
        this.dgb.setItemOnclickListener(this.mOnClickListener);
        this.dgb.setCurrentItem(arj(), false);
        this.dgb.setOnScrollOutListener(this.dgc);
        this.dgb.setItemOnLongClickListener(onLongClickListener);
        this.dgb.setHasNext(false);
        this.dgb.setNextTitle("mNextTitle");
        this.dgb.setIsFromCDN(true);
        this.dgb.setAllowLocalUrl(true);
        aP(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ari() {
        if (this.dfX != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.dgb.getHasNext() && this.mIndex == this.dgb.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(d.l.image_recommend));
                this.dfZ.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.dfZ.setClickable(true);
        }
    }

    private int arj() {
        if (this.dfX != null && this.dfX.size() > 0) {
            int size = this.dfX.size();
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
            this.dgg = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.dgh = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.dgi = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.dgm = intent.getBooleanExtra("isSingle", false);
            if (this.dgi == null) {
                this.dgi = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.dgg == null) {
                this.dgg = "";
            }
            this.dfX = new LinkedHashMap<>();
            this.dfX.put(this.dgi, this.dgg);
            this.dgl = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.dfX = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.dgi = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.dgl = bundle.getInt("chat_mode", 0);
            this.dgm = bundle.getBoolean("isSingle", false);
            if (this.dgi == null) {
                this.dgi = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.dgk = new HashMap<>();
    }

    private void ark() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.dgm) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.dgg)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.dgi, AbsMsgImageActivity.this.dgg);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.dgh;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.dgg, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = AbsMsgImageActivity.this.dgi;
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
                    AbsMsgImageActivity.this.ari();
                    AbsMsgImageActivity.this.dgb.setIsFromCDN(true);
                    AbsMsgImageActivity.this.dgb.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.dgb.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.dgb.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.dgb.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.dfX);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.dgi);
        bundle.putInt("chat_mode", this.dgl);
        bundle.putBoolean("isSingle", this.dgm);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.dgb.setCurrentItem(this.mIndex, true);
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<String, Integer, String> {
        String mUrl;
        byte[] ts;

        public a(String str, byte[] bArr) {
            this.mUrl = null;
            this.ts = null;
            this.mUrl = str;
            this.ts = bArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            switch (com.baidu.tbadk.core.util.k.a(this.mUrl, this.ts, AbsMsgImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.k.uI();
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
            AbsMsgImageActivity.this.dfY = null;
            AbsMsgImageActivity.this.dfZ.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.dfY = null;
            AbsMsgImageActivity.this.dfZ.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP(int i, int i2) {
        synchronized (this.dgk) {
            if (System.nanoTime() - this.dgj > 300000000 && this.dfX != null && i < this.dfX.size()) {
                this.dgk.put(this.dfX.get("" + i), true);
            }
            this.dgj = System.nanoTime();
        }
    }
}
