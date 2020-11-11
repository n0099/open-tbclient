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
/* loaded from: classes21.dex */
public abstract class AbsMsgImageActivity extends BaseActivity<AbsMsgImageActivity> {
    private String jUG;
    private boolean jUK;
    private FrameLayout jUy;
    private int mCount;
    private PermissionJudgePolicy mPermissionJudgement;
    private LinkedHashMap<String, String> jUw = null;
    private int mIndex = 0;
    private a jUx = null;
    private View mBack = null;
    private TextView mTextView = null;
    private NavigationBar jUz = null;
    private MultiImageView jUA = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a jUB = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation jUC = null;
    private boolean jUD = true;
    private boolean jUE = false;
    private String jUF = "";
    private String id = "";
    private String uniqueId = "";
    private long jUH = 0;
    private HashMap<String, Boolean> jUI = null;
    private int jUJ = 0;

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
        cOh();
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
        cOh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.jUA, R.color.black_alpha100);
        ap.setBackgroundColor(this.jUz, R.color.common_color_10222);
        getLayoutMode().onModeChanged(this.mBack);
        getLayoutMode().onModeChanged(this.mTextView);
        getLayoutMode().onModeChanged(this.jUy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.jUA.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.jUA.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.jUA.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        cP(this.mIndex, this.mIndex);
        this.jUA.onDestroy();
        if (this.jUx != null) {
            this.jUx.cancel();
            this.jUx = null;
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
                    if (AbsMsgImageActivity.this.jUz.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view == AbsMsgImageActivity.this.jUy) {
                    if (AbsMsgImageActivity.this.jUz.getVisibility() != 8) {
                        Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                        if (AbsMsgImageActivity.this.mPermissionJudgement == null) {
                            AbsMsgImageActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        AbsMsgImageActivity.this.mPermissionJudgement.clearRequestPermissionList();
                        AbsMsgImageActivity.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!AbsMsgImageActivity.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                            try {
                                byte[] currentImageData = AbsMsgImageActivity.this.jUA.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.jUA.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.jUx = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.jUx.execute(new String[0]);
                                    AbsMsgImageActivity.this.jUy.setClickable(false);
                                } else {
                                    AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(R.string.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (AbsMsgImageActivity.this.jUD) {
                    if (AbsMsgImageActivity.this.jUz.getVisibility() != 0) {
                        AbsMsgImageActivity.this.jUz.setVisibility(0);
                        AbsMsgImageActivity.this.jUA.bxS();
                        AbsMsgImageActivity.this.jUC = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.jUC = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.jUE = true;
                        AbsMsgImageActivity.this.jUA.bxU();
                    }
                    AbsMsgImageActivity.this.jUC.setDuration(300L);
                    AbsMsgImageActivity.this.jUC.setFillAfter(true);
                    AbsMsgImageActivity.this.jUC.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.jUD = true;
                            if (AbsMsgImageActivity.this.jUE) {
                                AbsMsgImageActivity.this.jUE = false;
                                AbsMsgImageActivity.this.jUz.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.jUD = false;
                    AbsMsgImageActivity.this.jUz.startAnimation(AbsMsgImageActivity.this.jUC);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.cP(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.cDk();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.jUH > 300000000 && AbsMsgImageActivity.this.jUw != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.jUw.size()) {
                    AbsMsgImageActivity.this.jUI.put(AbsMsgImageActivity.this.jUw.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.jUB = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void onScrollOut(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0576b interfaceC0576b = new b.InterfaceC0576b() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0576b
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
                                    byte[] currentImageData = AbsMsgImageActivity.this.jUA.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = AbsMsgImageActivity.this.jUA.getCurrentImageUrl();
                                        AbsMsgImageActivity.this.jUx = new a(currentImageUrl, currentImageData);
                                        AbsMsgImageActivity.this.jUx.execute(new String[0]);
                                        AbsMsgImageActivity.this.jUy.setClickable(false);
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
                AbsMsgImageActivity.this.createListMenu(new String[]{AbsMsgImageActivity.this.getPageContext().getString(R.string.save)}, interfaceC0576b);
                AbsMsgImageActivity.this.showListMenu();
                return false;
            }
        };
        this.jUz = (NavigationBar) findViewById(R.id.navigation_bar);
        this.jUy = (FrameLayout) this.jUz.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, this.mOnClickListener);
        if (this.jUK) {
            this.jUy.setVisibility(8);
        }
        this.mBack = this.jUz.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        ap.setImageResource(this.jUz.getBackImageView(), R.drawable.icon_return_bg);
        this.mTextView = this.jUz.setTitleText("");
        this.jUA = (MultiImageView) findViewById(R.id.viewpager);
        this.jUA.setPageMargin(l.dip2px(getPageContext().getContext(), 8.0f));
        this.jUA.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.jUA.setOnPageChangeListener(this.mOnPageChangeListener);
        this.jUA.setItemOnclickListener(this.mOnClickListener);
        this.jUA.setCurrentItem(cOg(), false);
        this.jUA.setOnScrollOutListener(this.jUB);
        this.jUA.setItemOnLongClickListener(onLongClickListener);
        this.jUA.setHasNext(false);
        this.jUA.setNextTitle("mNextTitle");
        this.jUA.setIsFromCDN(true);
        this.jUA.setAllowLocalUrl(true);
        cP(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDk() {
        if (this.jUw != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.jUA.getHasNext() && this.mIndex == this.jUA.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(R.string.image_recommend));
                this.jUy.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.jUy.setClickable(true);
        }
    }

    private int cOg() {
        if (this.jUw != null && this.jUw.size() > 0) {
            int size = this.jUw.size();
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
            this.jUF = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.jUG = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.uniqueId = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.jUK = intent.getBooleanExtra("isSingle", false);
            if (this.uniqueId == null) {
                this.uniqueId = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.jUF == null) {
                this.jUF = "";
            }
            this.jUw = new LinkedHashMap<>();
            this.jUw.put(this.uniqueId, this.jUF);
            this.jUJ = intent.getIntExtra(TbEnum.ParamKey.CHAT_MODE, 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.jUw = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.uniqueId = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.jUJ = bundle.getInt(TbEnum.ParamKey.CHAT_MODE, 0);
            this.jUK = bundle.getBoolean("isSingle", false);
            if (this.uniqueId == null) {
                this.uniqueId = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.jUI = new HashMap<>();
    }

    private void cOh() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.jUK) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.jUF)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.uniqueId, AbsMsgImageActivity.this.jUF);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.jUG;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.jUF, imageUrlData);
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
                    AbsMsgImageActivity.this.cDk();
                    AbsMsgImageActivity.this.jUA.setIsFromCDN(true);
                    AbsMsgImageActivity.this.jUA.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.jUA.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.jUA.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.jUA.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.jUw);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.uniqueId);
        bundle.putInt(TbEnum.ParamKey.CHAT_MODE, this.jUJ);
        bundle.putBoolean("isSingle", this.jUK);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.jUA.setCurrentItem(this.mIndex, true);
    }

    /* loaded from: classes21.dex */
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
            AbsMsgImageActivity.this.jUx = null;
            AbsMsgImageActivity.this.jUy.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.jUx = null;
            AbsMsgImageActivity.this.jUy.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cP(int i, int i2) {
        synchronized (this.jUI) {
            if (System.nanoTime() - this.jUH > 300000000 && this.jUw != null && i < this.jUw.size()) {
                this.jUI.put(this.jUw.get("" + i), true);
            }
            this.jUH = System.nanoTime();
        }
    }
}
