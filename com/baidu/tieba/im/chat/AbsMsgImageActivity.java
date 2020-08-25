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
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AbsMsgImageActivityConfig;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
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
/* loaded from: classes15.dex */
public abstract class AbsMsgImageActivity extends BaseActivity<AbsMsgImageActivity> {
    private String jeB;
    private boolean jeF;
    private FrameLayout jet;
    private int mCount;
    private PermissionJudgePolicy mPermissionJudgement;
    private LinkedHashMap<String, String> jer = null;
    private int mIndex = 0;
    private a jes = null;
    private View mBack = null;
    private TextView mTextView = null;
    private NavigationBar jeu = null;
    private MultiImageView jev = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a jew = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation jex = null;
    private boolean jey = true;
    private boolean jez = false;
    private String jeA = "";
    private String id = "";
    private String uniqueId = "";
    private long jeC = 0;
    private HashMap<String, Boolean> jeD = null;
    private int jeE = 0;

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
        cBi();
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
        cBi();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.jev, R.color.black_alpha100);
        ap.setBackgroundColor(this.jeu, R.color.common_color_10222);
        getLayoutMode().onModeChanged(this.mBack);
        getLayoutMode().onModeChanged(this.mTextView);
        getLayoutMode().onModeChanged(this.jet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.jev.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.jev.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.jev.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        cI(this.mIndex, this.mIndex);
        this.jev.onDestroy();
        if (this.jes != null) {
            this.jes.cancel();
            this.jes = null;
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
                if (view == AbsMsgImageActivity.this.mBack) {
                    if (AbsMsgImageActivity.this.jeu.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view == AbsMsgImageActivity.this.jet) {
                    if (AbsMsgImageActivity.this.jeu.getVisibility() != 8) {
                        Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                        if (AbsMsgImageActivity.this.mPermissionJudgement == null) {
                            AbsMsgImageActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        AbsMsgImageActivity.this.mPermissionJudgement.clearRequestPermissionList();
                        AbsMsgImageActivity.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!AbsMsgImageActivity.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                            try {
                                byte[] currentImageData = AbsMsgImageActivity.this.jev.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.jev.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.jes = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.jes.execute(new String[0]);
                                    AbsMsgImageActivity.this.jet.setClickable(false);
                                } else {
                                    AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(R.string.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (AbsMsgImageActivity.this.jey) {
                    if (AbsMsgImageActivity.this.jeu.getVisibility() != 0) {
                        AbsMsgImageActivity.this.jeu.setVisibility(0);
                        AbsMsgImageActivity.this.jev.bpV();
                        AbsMsgImageActivity.this.jex = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.jex = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.jez = true;
                        AbsMsgImageActivity.this.jev.bpX();
                    }
                    AbsMsgImageActivity.this.jex.setDuration(300L);
                    AbsMsgImageActivity.this.jex.setFillAfter(true);
                    AbsMsgImageActivity.this.jex.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.jey = true;
                            if (AbsMsgImageActivity.this.jez) {
                                AbsMsgImageActivity.this.jez = false;
                                AbsMsgImageActivity.this.jeu.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.jey = false;
                    AbsMsgImageActivity.this.jeu.startAnimation(AbsMsgImageActivity.this.jex);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.cI(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.cqR();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.jeC > 300000000 && AbsMsgImageActivity.this.jer != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.jer.size()) {
                    AbsMsgImageActivity.this.jeD.put(AbsMsgImageActivity.this.jer.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.jew = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void onScrollOut(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0538b interfaceC0538b = new b.InterfaceC0538b() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0538b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar == AbsMsgImageActivity.this.getListMenu()) {
                    switch (i) {
                        case 0:
                            try {
                                Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                                if (AbsMsgImageActivity.this.mPermissionJudgement == null) {
                                    AbsMsgImageActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                                }
                                AbsMsgImageActivity.this.mPermissionJudgement.clearRequestPermissionList();
                                AbsMsgImageActivity.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                                if (!AbsMsgImageActivity.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                                    byte[] currentImageData = AbsMsgImageActivity.this.jev.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = AbsMsgImageActivity.this.jev.getCurrentImageUrl();
                                        AbsMsgImageActivity.this.jes = new a(currentImageUrl, currentImageData);
                                        AbsMsgImageActivity.this.jes.execute(new String[0]);
                                        AbsMsgImageActivity.this.jet.setClickable(false);
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
                AbsMsgImageActivity.this.createListMenu(new String[]{AbsMsgImageActivity.this.getPageContext().getString(R.string.save)}, interfaceC0538b);
                AbsMsgImageActivity.this.showListMenu();
                return false;
            }
        };
        this.jeu = (NavigationBar) findViewById(R.id.navigation_bar);
        this.jet = (FrameLayout) this.jeu.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, this.mOnClickListener);
        if (this.jeF) {
            this.jet.setVisibility(8);
        }
        this.mBack = this.jeu.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        ap.setImageResource(this.jeu.getBackImageView(), R.drawable.icon_return_bg);
        this.mTextView = this.jeu.setTitleText("");
        this.jev = (MultiImageView) findViewById(R.id.viewpager);
        this.jev.setPageMargin(l.dip2px(getPageContext().getContext(), 8.0f));
        this.jev.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.jev.setOnPageChangeListener(this.mOnPageChangeListener);
        this.jev.setItemOnclickListener(this.mOnClickListener);
        this.jev.setCurrentItem(cBh(), false);
        this.jev.setOnScrollOutListener(this.jew);
        this.jev.setItemOnLongClickListener(onLongClickListener);
        this.jev.setHasNext(false);
        this.jev.setNextTitle("mNextTitle");
        this.jev.setIsFromCDN(true);
        this.jev.setAllowLocalUrl(true);
        cI(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqR() {
        if (this.jer != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.jev.getHasNext() && this.mIndex == this.jev.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(R.string.image_recommend));
                this.jet.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.jet.setClickable(true);
        }
    }

    private int cBh() {
        if (this.jer != null && this.jer.size() > 0) {
            int size = this.jer.size();
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
            this.jeA = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.jeB = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.uniqueId = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.jeF = intent.getBooleanExtra("isSingle", false);
            if (this.uniqueId == null) {
                this.uniqueId = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.jeA == null) {
                this.jeA = "";
            }
            this.jer = new LinkedHashMap<>();
            this.jer.put(this.uniqueId, this.jeA);
            this.jeE = intent.getIntExtra(TbEnum.ParamKey.CHAT_MODE, 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.jer = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.uniqueId = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.jeE = bundle.getInt(TbEnum.ParamKey.CHAT_MODE, 0);
            this.jeF = bundle.getBoolean("isSingle", false);
            if (this.uniqueId == null) {
                this.uniqueId = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.jeD = new HashMap<>();
    }

    private void cBi() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.jeF) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.jeA)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.uniqueId, AbsMsgImageActivity.this.jeA);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.jeB;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.jeA, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = AbsMsgImageActivity.this.uniqueId;
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
                    AbsMsgImageActivity.this.cqR();
                    AbsMsgImageActivity.this.jev.setIsFromCDN(true);
                    AbsMsgImageActivity.this.jev.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.jev.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.jev.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.jev.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.jer);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.uniqueId);
        bundle.putInt(TbEnum.ParamKey.CHAT_MODE, this.jeE);
        bundle.putBoolean("isSingle", this.jeF);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.jev.setCurrentItem(this.mIndex, true);
    }

    /* loaded from: classes15.dex */
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
            switch (n.saveImageFileByUser(this.mUrl, this.mData, AbsMsgImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return n.getSdErrorString();
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
            AbsMsgImageActivity.this.jes = null;
            AbsMsgImageActivity.this.jet.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.jes = null;
            AbsMsgImageActivity.this.jet.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cI(int i, int i2) {
        synchronized (this.jeD) {
            if (System.nanoTime() - this.jeC > 300000000 && this.jer != null && i < this.jer.size()) {
                this.jeD.put(this.jer.get("" + i), true);
            }
            this.jeC = System.nanoTime();
        }
    }
}
