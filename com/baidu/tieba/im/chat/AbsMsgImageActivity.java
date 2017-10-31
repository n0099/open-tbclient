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
    private boolean dtA;
    private FrameLayout dtn;
    private String dtv;
    private int mCount;
    private LinkedHashMap<String, String> dtl = null;
    private int mIndex = 0;
    private a dtm = null;
    private View aqh = null;
    private TextView abE = null;
    private NavigationBar dto = null;
    private MultiImageView dtp = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a dtq = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation dtr = null;
    private boolean dts = true;
    private boolean dtt = false;
    private String dtu = "";
    private String id = "";
    private String dtw = "";
    private long dtx = 0;
    private HashMap<String, Boolean> dty = null;
    private int dtz = 0;

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
        auG();
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
        auG();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.k(this.dtp, d.C0080d.black_alpha100);
        aj.k(this.dto, d.C0080d.common_color_10222);
        getLayoutMode().t(this.aqh);
        getLayoutMode().t(this.abE);
        getLayoutMode().t(this.dtn);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.dtp.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dtp.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.dtp.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        bh(this.mIndex, this.mIndex);
        this.dtp.onDestroy();
        if (this.dtm != null) {
            this.dtm.cancel();
            this.dtm = null;
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
                if (view == AbsMsgImageActivity.this.aqh) {
                    if (AbsMsgImageActivity.this.dto.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view == AbsMsgImageActivity.this.dtn) {
                    if (AbsMsgImageActivity.this.dto.getVisibility() != 8) {
                        try {
                            byte[] currentImageData = AbsMsgImageActivity.this.dtp.getCurrentImageData();
                            if (currentImageData != null) {
                                String currentImageUrl = AbsMsgImageActivity.this.dtp.getCurrentImageUrl();
                                AbsMsgImageActivity.this.dtm = new a(currentImageUrl, currentImageData);
                                AbsMsgImageActivity.this.dtm.execute(new String[0]);
                                AbsMsgImageActivity.this.dtn.setClickable(false);
                            } else {
                                AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(d.j.no_data));
                            }
                        } catch (Exception e) {
                        }
                    }
                } else if (AbsMsgImageActivity.this.dts) {
                    if (AbsMsgImageActivity.this.dto.getVisibility() != 0) {
                        AbsMsgImageActivity.this.dto.setVisibility(0);
                        AbsMsgImageActivity.this.dtp.AP();
                        AbsMsgImageActivity.this.dtr = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.dtr = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.dtt = true;
                        AbsMsgImageActivity.this.dtp.AQ();
                    }
                    AbsMsgImageActivity.this.dtr.setDuration(300L);
                    AbsMsgImageActivity.this.dtr.setFillAfter(true);
                    AbsMsgImageActivity.this.dtr.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.dts = true;
                            if (AbsMsgImageActivity.this.dtt) {
                                AbsMsgImageActivity.this.dtt = false;
                                AbsMsgImageActivity.this.dto.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.dts = false;
                    AbsMsgImageActivity.this.dto.startAnimation(AbsMsgImageActivity.this.dtr);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.bh(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.amX();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.dtx > 300000000 && AbsMsgImageActivity.this.dtl != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.dtl.size()) {
                    AbsMsgImageActivity.this.dty.put(AbsMsgImageActivity.this.dtl.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.dtq = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
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
                                byte[] currentImageData = AbsMsgImageActivity.this.dtp.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.dtp.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.dtm = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.dtm.execute(new String[0]);
                                    AbsMsgImageActivity.this.dtn.setClickable(false);
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
        this.dto = (NavigationBar) findViewById(d.g.navigation_bar);
        this.dtn = (FrameLayout) this.dto.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.image_activity_save_button, this.mOnClickListener);
        if (this.dtA) {
            this.dtn.setVisibility(8);
        }
        this.aqh = this.dto.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        this.abE = this.dto.setTitleText("");
        this.dtp = (MultiImageView) findViewById(d.g.viewpager);
        this.dtp.setPageMargin(l.dip2px(getPageContext().getContext(), 8.0f));
        this.dtp.H(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.dtp.setOnPageChangeListener(this.mOnPageChangeListener);
        this.dtp.setItemOnclickListener(this.mOnClickListener);
        this.dtp.setCurrentItem(auF(), false);
        this.dtp.setOnScrollOutListener(this.dtq);
        this.dtp.setItemOnLongClickListener(onLongClickListener);
        this.dtp.setHasNext(false);
        this.dtp.setNextTitle("mNextTitle");
        this.dtp.setIsFromCDN(true);
        this.dtp.setAllowLocalUrl(true);
        bh(this.mIndex, this.mIndex);
        this.abE.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amX() {
        if (this.dtl != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.dtp.getHasNext() && this.mIndex == this.dtp.getItemNum() - 1) {
                this.abE.setText(getPageContext().getString(d.j.image_recommend));
                this.dtn.setClickable(false);
                return;
            }
            this.abE.setText(valueOf);
            this.dtn.setClickable(true);
        }
    }

    private int auF() {
        if (this.dtl != null && this.dtl.size() > 0) {
            int size = this.dtl.size();
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
            this.dtu = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.dtv = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.dtw = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.dtA = intent.getBooleanExtra("isSingle", false);
            if (this.dtw == null) {
                this.dtw = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.dtu == null) {
                this.dtu = "";
            }
            this.dtl = new LinkedHashMap<>();
            this.dtl.put(this.dtw, this.dtu);
            this.dtz = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.dtl = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.dtw = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.dtz = bundle.getInt("chat_mode", 0);
            this.dtA = bundle.getBoolean("isSingle", false);
            if (this.dtw == null) {
                this.dtw = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.dty = new HashMap<>();
    }

    private void auG() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.dtA) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.dtu)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.dtw, AbsMsgImageActivity.this.dtu);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.dtv;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.dtu, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = AbsMsgImageActivity.this.dtw;
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
                    AbsMsgImageActivity.this.abE.setVisibility(0);
                    AbsMsgImageActivity.this.amX();
                    AbsMsgImageActivity.this.dtp.setIsFromCDN(true);
                    AbsMsgImageActivity.this.dtp.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.dtp.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.dtp.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.dtp.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.dtl);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.dtw);
        bundle.putInt("chat_mode", this.dtz);
        bundle.putBoolean("isSingle", this.dtA);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.dtp.setCurrentItem(this.mIndex, true);
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
                    return k.uh();
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
            AbsMsgImageActivity.this.dtm = null;
            AbsMsgImageActivity.this.dtn.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.dtm = null;
            AbsMsgImageActivity.this.dtn.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bh(int i, int i2) {
        synchronized (this.dty) {
            if (System.nanoTime() - this.dtx > 300000000 && this.dtl != null && i < this.dtl.size()) {
                this.dty.put(this.dtl.get("" + i), true);
            }
            this.dtx = System.nanoTime();
        }
    }
}
