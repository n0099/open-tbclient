package com.baidu.tieba.im.chat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
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
import com.baidu.tbadk.core.util.o;
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
/* loaded from: classes.dex */
public abstract class AbsMsgImageActivity extends BaseActivity<AbsMsgImageActivity> {
    private boolean kAb;
    private FrameLayout kzP;
    private String kzX;
    private int mCount;
    private PermissionJudgePolicy mPermissionJudgement;
    private LinkedHashMap<String, String> kzN = null;
    private int mIndex = 0;
    private a kzO = null;
    private View mBack = null;
    private TextView mTextView = null;
    private NavigationBar kzQ = null;
    private MultiImageView kzR = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a kzS = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation kzT = null;
    private boolean kzU = true;
    private boolean kzV = false;
    private String kzW = "";
    private String id = "";
    private String uniqueId = "";
    private long kzY = 0;
    private HashMap<String, Boolean> kzZ = null;
    private int kAa = 0;

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
        cUx();
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
        cUx();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.kzR, R.color.black_alpha100);
        ap.setBackgroundColor(this.kzQ, R.color.common_color_10222);
        getLayoutMode().onModeChanged(this.mBack);
        getLayoutMode().onModeChanged(this.mTextView);
        getLayoutMode().onModeChanged(this.kzP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.kzR.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.kzR.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.kzR.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        cQ(this.mIndex, this.mIndex);
        this.kzR.onDestroy();
        if (this.kzO != null) {
            this.kzO.cancel();
            this.kzO = null;
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
                    if (AbsMsgImageActivity.this.kzQ.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view == AbsMsgImageActivity.this.kzP) {
                    if (AbsMsgImageActivity.this.kzQ.getVisibility() != 8) {
                        Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                        if (AbsMsgImageActivity.this.mPermissionJudgement == null) {
                            AbsMsgImageActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        AbsMsgImageActivity.this.mPermissionJudgement.clearRequestPermissionList();
                        AbsMsgImageActivity.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!AbsMsgImageActivity.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                            try {
                                byte[] currentImageData = AbsMsgImageActivity.this.kzR.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.kzR.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.kzO = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.kzO.execute(new String[0]);
                                    AbsMsgImageActivity.this.kzP.setClickable(false);
                                } else {
                                    AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(R.string.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (AbsMsgImageActivity.this.kzU) {
                    if (AbsMsgImageActivity.this.kzQ.getVisibility() != 0) {
                        AbsMsgImageActivity.this.kzQ.setVisibility(0);
                        AbsMsgImageActivity.this.kzR.bzB();
                        AbsMsgImageActivity.this.kzT = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.kzT = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.kzV = true;
                        AbsMsgImageActivity.this.kzR.bzD();
                    }
                    AbsMsgImageActivity.this.kzT.setDuration(300L);
                    AbsMsgImageActivity.this.kzT.setFillAfter(true);
                    AbsMsgImageActivity.this.kzT.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.kzU = true;
                            if (AbsMsgImageActivity.this.kzV) {
                                AbsMsgImageActivity.this.kzV = false;
                                AbsMsgImageActivity.this.kzQ.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.kzU = false;
                    AbsMsgImageActivity.this.kzQ.startAnimation(AbsMsgImageActivity.this.kzT);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.cQ(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.cID();
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.kzY > 300000000 && AbsMsgImageActivity.this.kzN != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.kzN.size()) {
                    AbsMsgImageActivity.this.kzZ.put(AbsMsgImageActivity.this.kzN.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.kzS = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void onScrollOut(int i) {
                if (i == 0) {
                }
            }
        };
        final b.InterfaceC0558b interfaceC0558b = new b.InterfaceC0558b() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0558b
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
                                    byte[] currentImageData = AbsMsgImageActivity.this.kzR.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = AbsMsgImageActivity.this.kzR.getCurrentImageUrl();
                                        AbsMsgImageActivity.this.kzO = new a(currentImageUrl, currentImageData);
                                        AbsMsgImageActivity.this.kzO.execute(new String[0]);
                                        AbsMsgImageActivity.this.kzP.setClickable(false);
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
                AbsMsgImageActivity.this.createListMenu(new String[]{AbsMsgImageActivity.this.getPageContext().getString(R.string.save)}, interfaceC0558b);
                AbsMsgImageActivity.this.showListMenu();
                return false;
            }
        };
        this.kzQ = (NavigationBar) findViewById(R.id.navigation_bar);
        this.kzP = (FrameLayout) this.kzQ.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, this.mOnClickListener);
        if (this.kAb) {
            this.kzP.setVisibility(8);
        }
        this.mBack = this.kzQ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        ap.setImageResource(this.kzQ.getBackImageView(), R.drawable.icon_return_bg);
        this.mTextView = this.kzQ.setTitleText("");
        this.kzR = (MultiImageView) findViewById(R.id.viewpager);
        this.kzR.setPageMargin(l.dip2px(getPageContext().getContext(), 8.0f));
        this.kzR.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.kzR.setOnPageChangeListener(this.mOnPageChangeListener);
        this.kzR.setItemOnclickListener(this.mOnClickListener);
        this.kzR.setCurrentItem(cUw(), false);
        this.kzR.setOnScrollOutListener(this.kzS);
        this.kzR.setItemOnLongClickListener(onLongClickListener);
        this.kzR.setHasNext(false);
        this.kzR.setNextTitle("mNextTitle");
        this.kzR.setIsFromCDN(true);
        this.kzR.setAllowLocalUrl(true);
        cQ(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cID() {
        if (this.kzN != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.kzR.getHasNext() && this.mIndex == this.kzR.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(R.string.image_recommend));
                this.kzP.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.kzP.setClickable(true);
        }
    }

    private int cUw() {
        if (this.kzN != null && this.kzN.size() > 0) {
            int size = this.kzN.size();
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
            this.kzW = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.kzX = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.uniqueId = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.kAb = intent.getBooleanExtra("isSingle", false);
            if (this.uniqueId == null) {
                this.uniqueId = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.kzW == null) {
                this.kzW = "";
            }
            this.kzN = new LinkedHashMap<>();
            this.kzN.put(this.uniqueId, this.kzW);
            this.kAa = intent.getIntExtra(TbEnum.ParamKey.CHAT_MODE, 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.kzN = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.uniqueId = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.kAa = bundle.getInt(TbEnum.ParamKey.CHAT_MODE, 0);
            this.kAb = bundle.getBoolean("isSingle", false);
            if (this.uniqueId == null) {
                this.uniqueId = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.kzZ = new HashMap<>();
    }

    private void cUx() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.kAb) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.kzW)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.uniqueId, AbsMsgImageActivity.this.kzW);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.kzX;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.kzW, imageUrlData);
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
                    AbsMsgImageActivity.this.cID();
                    AbsMsgImageActivity.this.kzR.setIsFromCDN(true);
                    AbsMsgImageActivity.this.kzR.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.kzR.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.kzR.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.kzR.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.kzN);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.uniqueId);
        bundle.putInt(TbEnum.ParamKey.CHAT_MODE, this.kAa);
        bundle.putBoolean("isSingle", this.kAb);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.kzR.setCurrentItem(this.mIndex, true);
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
        public String doInBackground(String... strArr) {
            switch (o.saveImageFileByUser(this.mUrl, this.mData, AbsMsgImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return o.getSdErrorString();
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
            AbsMsgImageActivity.this.kzO = null;
            AbsMsgImageActivity.this.kzP.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.kzO = null;
            AbsMsgImageActivity.this.kzP.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQ(int i, int i2) {
        synchronized (this.kzZ) {
            if (System.nanoTime() - this.kzY > 300000000 && this.kzN != null && i < this.kzN.size()) {
                this.kzZ.put(this.kzN.get("" + i), true);
            }
            this.kzY = System.nanoTime();
        }
    }
}
