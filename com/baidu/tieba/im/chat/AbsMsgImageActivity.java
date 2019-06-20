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
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public abstract class AbsMsgImageActivity extends BaseActivity<AbsMsgImageActivity> {
    private String grB;
    private boolean grG;
    private FrameLayout grt;
    private int mCount;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private LinkedHashMap<String, String> grr = null;
    private int mIndex = 0;
    private a grs = null;
    private View cdY = null;
    private TextView mTextView = null;
    private NavigationBar gru = null;
    private MultiImageView grv = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a grw = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation grx = null;
    private boolean gry = true;
    private boolean grz = false;
    private String grA = "";
    private String id = "";
    private String grC = "";
    private long grD = 0;
    private HashMap<String, Boolean> grE = null;
    private int grF = 0;

    protected abstract void a(String str, com.baidu.tieba.im.sendmessage.c cVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(R.layout.image_activity_2);
        initData(bundle);
        initUI();
        bxk();
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
        bxk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.l(this.grv, R.color.black_alpha100);
        al.l(this.gru, R.color.common_color_10222);
        getLayoutMode().onModeChanged(this.cdY);
        getLayoutMode().onModeChanged(this.mTextView);
        getLayoutMode().onModeChanged(this.grt);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.grv.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.grv.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.grv.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        bP(this.mIndex, this.mIndex);
        this.grv.onDestroy();
        if (this.grs != null) {
            this.grs.cancel();
            this.grs = null;
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
                if (view == AbsMsgImageActivity.this.cdY) {
                    if (AbsMsgImageActivity.this.gru.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view == AbsMsgImageActivity.this.grt) {
                    if (AbsMsgImageActivity.this.gru.getVisibility() != 8) {
                        Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                        if (AbsMsgImageActivity.this.mPermissionJudgement == null) {
                            AbsMsgImageActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                        }
                        AbsMsgImageActivity.this.mPermissionJudgement.aiM();
                        AbsMsgImageActivity.this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!AbsMsgImageActivity.this.mPermissionJudgement.aa(pageActivity)) {
                            try {
                                byte[] currentImageData = AbsMsgImageActivity.this.grv.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.grv.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.grs = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.grs.execute(new String[0]);
                                    AbsMsgImageActivity.this.grt.setClickable(false);
                                } else {
                                    AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(R.string.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (AbsMsgImageActivity.this.gry) {
                    if (AbsMsgImageActivity.this.gru.getVisibility() != 0) {
                        AbsMsgImageActivity.this.gru.setVisibility(0);
                        AbsMsgImageActivity.this.grv.apn();
                        AbsMsgImageActivity.this.grx = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.grx = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.grz = true;
                        AbsMsgImageActivity.this.grv.app();
                    }
                    AbsMsgImageActivity.this.grx.setDuration(300L);
                    AbsMsgImageActivity.this.grx.setFillAfter(true);
                    AbsMsgImageActivity.this.grx.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.gry = true;
                            if (AbsMsgImageActivity.this.grz) {
                                AbsMsgImageActivity.this.grz = false;
                                AbsMsgImageActivity.this.gru.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.gry = false;
                    AbsMsgImageActivity.this.gru.startAnimation(AbsMsgImageActivity.this.grx);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.bP(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.boh();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.grD > 300000000 && AbsMsgImageActivity.this.grr != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.grr.size()) {
                    AbsMsgImageActivity.this.grE.put(AbsMsgImageActivity.this.grr.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.grw = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void is(int i) {
                if (i == 0) {
                }
            }
        };
        final b.a aVar = new b.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.a
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar == AbsMsgImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            try {
                                Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                                if (AbsMsgImageActivity.this.mPermissionJudgement == null) {
                                    AbsMsgImageActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                                }
                                AbsMsgImageActivity.this.mPermissionJudgement.aiM();
                                AbsMsgImageActivity.this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                                if (!AbsMsgImageActivity.this.mPermissionJudgement.aa(pageActivity)) {
                                    byte[] currentImageData = AbsMsgImageActivity.this.grv.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = AbsMsgImageActivity.this.grv.getCurrentImageUrl();
                                        AbsMsgImageActivity.this.grs = new a(currentImageUrl, currentImageData);
                                        AbsMsgImageActivity.this.grs.execute(new String[0]);
                                        AbsMsgImageActivity.this.grt.setClickable(false);
                                        break;
                                    } else {
                                        AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(R.string.no_data));
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
                AbsMsgImageActivity.this.createListMenu(new String[]{AbsMsgImageActivity.this.getPageContext().getString(R.string.save)}, aVar);
                AbsMsgImageActivity.this.showListMenu();
                return false;
            }
        };
        this.gru = (NavigationBar) findViewById(R.id.navigation_bar);
        this.grt = (FrameLayout) this.gru.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, this.mOnClickListener);
        if (this.grG) {
            this.grt.setVisibility(8);
        }
        this.cdY = this.gru.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        al.c(this.gru.getBackImageView(), (int) R.drawable.icon_return_bg);
        this.mTextView = this.gru.setTitleText("");
        this.grv = (MultiImageView) findViewById(R.id.viewpager);
        this.grv.setPageMargin(l.dip2px(getPageContext().getContext(), 8.0f));
        this.grv.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.grv.setOnPageChangeListener(this.mOnPageChangeListener);
        this.grv.setItemOnclickListener(this.mOnClickListener);
        this.grv.setCurrentItem(bxj(), false);
        this.grv.setOnScrollOutListener(this.grw);
        this.grv.setItemOnLongClickListener(onLongClickListener);
        this.grv.setHasNext(false);
        this.grv.setNextTitle("mNextTitle");
        this.grv.setIsFromCDN(true);
        this.grv.setAllowLocalUrl(true);
        bP(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boh() {
        if (this.grr != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.grv.getHasNext() && this.mIndex == this.grv.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(R.string.image_recommend));
                this.grt.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.grt.setClickable(true);
        }
    }

    private int bxj() {
        if (this.grr != null && this.grr.size() > 0) {
            int size = this.grr.size();
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
            this.grA = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.grB = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.grC = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.grG = intent.getBooleanExtra("isSingle", false);
            if (this.grC == null) {
                this.grC = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.grA == null) {
                this.grA = "";
            }
            this.grr = new LinkedHashMap<>();
            this.grr.put(this.grC, this.grA);
            this.grF = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.grr = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.grC = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.grF = bundle.getInt("chat_mode", 0);
            this.grG = bundle.getBoolean("isSingle", false);
            if (this.grC == null) {
                this.grC = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.grE = new HashMap<>();
    }

    private void bxk() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.grG) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.grA)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.grC, AbsMsgImageActivity.this.grA);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.grB;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.grA, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = AbsMsgImageActivity.this.grC;
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
                    AbsMsgImageActivity.this.boh();
                    AbsMsgImageActivity.this.grv.setIsFromCDN(true);
                    AbsMsgImageActivity.this.grv.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.grv.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.grv.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.grv.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.grr);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.grC);
        bundle.putInt("chat_mode", this.grF);
        bundle.putBoolean("isSingle", this.grG);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.grv.setCurrentItem(this.mIndex, true);
    }

    /* loaded from: classes3.dex */
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
            switch (m.a(this.mUrl, this.mData, AbsMsgImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return m.agZ();
                case -1:
                default:
                    return AbsMsgImageActivity.this.getPageContext().getString(R.string.save_fail);
                case 0:
                    return AbsMsgImageActivity.this.getPageContext().getString(R.string.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            AbsMsgImageActivity.this.grs = null;
            AbsMsgImageActivity.this.grt.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.grs = null;
            AbsMsgImageActivity.this.grt.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bP(int i, int i2) {
        synchronized (this.grE) {
            if (System.nanoTime() - this.grD > 300000000 && this.grr != null && i < this.grr.size()) {
                this.grE.put(this.grr.get("" + i), true);
            }
            this.grD = System.nanoTime();
        }
    }
}
