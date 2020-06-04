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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.m;
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
/* loaded from: classes8.dex */
public abstract class AbsMsgImageActivity extends BaseActivity<AbsMsgImageActivity> {
    private FrameLayout isj;
    private String isr;
    private boolean isv;
    private int mCount;
    private PermissionJudgePolicy mPermissionJudgement;
    private LinkedHashMap<String, String> ish = null;
    private int mIndex = 0;
    private a isi = null;
    private View mBack = null;
    private TextView mTextView = null;
    private NavigationBar isk = null;
    private MultiImageView isl = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.a ism = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation isn = null;
    private boolean iso = true;
    private boolean isp = false;
    private String isq = "";
    private String id = "";
    private String uniqueId = "";
    private long iss = 0;
    private HashMap<String, Boolean> ist = null;
    private int isu = 0;

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
        cja();
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
        cja();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundColor(this.isl, R.color.black_alpha100);
        am.setBackgroundColor(this.isk, R.color.common_color_10222);
        getLayoutMode().onModeChanged(this.mBack);
        getLayoutMode().onModeChanged(this.mTextView);
        getLayoutMode().onModeChanged(this.isj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.isl.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.isl.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.isl.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        cr(this.mIndex, this.mIndex);
        this.isl.onDestroy();
        if (this.isi != null) {
            this.isi.cancel();
            this.isi = null;
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
                    if (AbsMsgImageActivity.this.isk.getVisibility() != 8) {
                        Intent intent = new Intent();
                        intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                        AbsMsgImageActivity.this.setResult(-1, intent);
                        AbsMsgImageActivity.this.finish();
                    }
                } else if (view == AbsMsgImageActivity.this.isj) {
                    if (AbsMsgImageActivity.this.isk.getVisibility() != 8) {
                        Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                        if (AbsMsgImageActivity.this.mPermissionJudgement == null) {
                            AbsMsgImageActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        AbsMsgImageActivity.this.mPermissionJudgement.clearRequestPermissionList();
                        AbsMsgImageActivity.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!AbsMsgImageActivity.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                            try {
                                byte[] currentImageData = AbsMsgImageActivity.this.isl.getCurrentImageData();
                                if (currentImageData != null) {
                                    String currentImageUrl = AbsMsgImageActivity.this.isl.getCurrentImageUrl();
                                    AbsMsgImageActivity.this.isi = new a(currentImageUrl, currentImageData);
                                    AbsMsgImageActivity.this.isi.execute(new String[0]);
                                    AbsMsgImageActivity.this.isj.setClickable(false);
                                } else {
                                    AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(R.string.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else if (AbsMsgImageActivity.this.iso) {
                    if (AbsMsgImageActivity.this.isk.getVisibility() != 0) {
                        AbsMsgImageActivity.this.isk.setVisibility(0);
                        AbsMsgImageActivity.this.isl.bby();
                        AbsMsgImageActivity.this.isn = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        AbsMsgImageActivity.this.isn = new AlphaAnimation(1.0f, 0.0f);
                        AbsMsgImageActivity.this.isp = true;
                        AbsMsgImageActivity.this.isl.bbA();
                    }
                    AbsMsgImageActivity.this.isn.setDuration(300L);
                    AbsMsgImageActivity.this.isn.setFillAfter(true);
                    AbsMsgImageActivity.this.isn.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AbsMsgImageActivity.this.iso = true;
                            if (AbsMsgImageActivity.this.isp) {
                                AbsMsgImageActivity.this.isp = false;
                                AbsMsgImageActivity.this.isk.setVisibility(8);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    AbsMsgImageActivity.this.iso = false;
                    AbsMsgImageActivity.this.isk.startAnimation(AbsMsgImageActivity.this.isn);
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AbsMsgImageActivity.this.cr(AbsMsgImageActivity.this.mIndex, i);
                AbsMsgImageActivity.this.mIndex = i;
                AbsMsgImageActivity.this.bZA();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1 && System.nanoTime() - AbsMsgImageActivity.this.iss > 300000000 && AbsMsgImageActivity.this.ish != null && AbsMsgImageActivity.this.mIndex < AbsMsgImageActivity.this.ish.size()) {
                    AbsMsgImageActivity.this.ist.put(AbsMsgImageActivity.this.ish.get("" + AbsMsgImageActivity.this.mIndex), true);
                }
            }
        };
        this.ism = new BaseViewPager.a() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.3
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void onScrollOut(int i) {
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
                                    AbsMsgImageActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                                }
                                AbsMsgImageActivity.this.mPermissionJudgement.clearRequestPermissionList();
                                AbsMsgImageActivity.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                                if (!AbsMsgImageActivity.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                                    byte[] currentImageData = AbsMsgImageActivity.this.isl.getCurrentImageData();
                                    if (currentImageData != null) {
                                        String currentImageUrl = AbsMsgImageActivity.this.isl.getCurrentImageUrl();
                                        AbsMsgImageActivity.this.isi = new a(currentImageUrl, currentImageData);
                                        AbsMsgImageActivity.this.isi.execute(new String[0]);
                                        AbsMsgImageActivity.this.isj.setClickable(false);
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
        this.isk = (NavigationBar) findViewById(R.id.navigation_bar);
        this.isj = (FrameLayout) this.isk.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, this.mOnClickListener);
        if (this.isv) {
            this.isj.setVisibility(8);
        }
        this.mBack = this.isk.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        am.setImageResource(this.isk.getBackImageView(), R.drawable.icon_return_bg);
        this.mTextView = this.isk.setTitleText("");
        this.isl = (MultiImageView) findViewById(R.id.viewpager);
        this.isl.setPageMargin(l.dip2px(getPageContext().getContext(), 8.0f));
        this.isl.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.isl.setOnPageChangeListener(this.mOnPageChangeListener);
        this.isl.setItemOnclickListener(this.mOnClickListener);
        this.isl.setCurrentItem(ciZ(), false);
        this.isl.setOnScrollOutListener(this.ism);
        this.isl.setItemOnLongClickListener(onLongClickListener);
        this.isl.setHasNext(false);
        this.isl.setNextTitle("mNextTitle");
        this.isl.setIsFromCDN(true);
        this.isl.setAllowLocalUrl(true);
        cr(this.mIndex, this.mIndex);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZA() {
        if (this.ish != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.isl.getHasNext() && this.mIndex == this.isl.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(R.string.image_recommend));
                this.isj.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.isj.setClickable(true);
        }
    }

    private int ciZ() {
        if (this.ish != null && this.ish.size() > 0) {
            int size = this.ish.size();
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
            this.isq = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
            this.isr = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
            this.id = intent.getStringExtra("id");
            this.uniqueId = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.isv = intent.getBooleanExtra("isSingle", false);
            if (this.uniqueId == null) {
                this.uniqueId = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.isq == null) {
                this.isq = "";
            }
            this.ish = new LinkedHashMap<>();
            this.ish.put(this.uniqueId, this.isq);
            this.isu = intent.getIntExtra(TbEnum.ParamKey.CHAT_MODE, 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.ish = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.uniqueId = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
            this.isu = bundle.getInt(TbEnum.ParamKey.CHAT_MODE, 0);
            this.isv = bundle.getBoolean("isSingle", false);
            if (this.uniqueId == null) {
                this.uniqueId = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.ist = new HashMap<>();
    }

    private void cja() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        a(this.id, new com.baidu.tieba.im.sendmessage.c() { // from class: com.baidu.tieba.im.chat.AbsMsgImageActivity.6
            @Override // com.baidu.tieba.im.sendmessage.c
            public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
                boolean z;
                if (linkedHashMap == null || AbsMsgImageActivity.this.isv) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.isq)) {
                    linkedHashMap.put(AbsMsgImageActivity.this.uniqueId, AbsMsgImageActivity.this.isq);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = AbsMsgImageActivity.this.isr;
                    imageUrlData.urlType = 10;
                    hashMap.put(AbsMsgImageActivity.this.isq, imageUrlData);
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
                    AbsMsgImageActivity.this.bZA();
                    AbsMsgImageActivity.this.isl.setIsFromCDN(true);
                    AbsMsgImageActivity.this.isl.setAllowLocalUrl(true);
                    AbsMsgImageActivity.this.isl.setAssistUrls(hashMap);
                    AbsMsgImageActivity.this.isl.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    AbsMsgImageActivity.this.isl.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                    return;
                }
                AbsMsgImageActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.ish);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.uniqueId);
        bundle.putInt(TbEnum.ParamKey.CHAT_MODE, this.isu);
        bundle.putBoolean("isSingle", this.isv);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.isl.setCurrentItem(this.mIndex, true);
    }

    /* loaded from: classes8.dex */
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
            switch (m.saveImageFileByUser(this.mUrl, this.mData, AbsMsgImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return m.getSdErrorString();
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
            AbsMsgImageActivity.this.isi = null;
            AbsMsgImageActivity.this.isj.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.isi = null;
            AbsMsgImageActivity.this.isj.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cr(int i, int i2) {
        synchronized (this.ist) {
            if (System.nanoTime() - this.iss > 300000000 && this.ish != null && i < this.ish.size()) {
                this.ist.put(this.ish.get("" + i), true);
            }
            this.iss = System.nanoTime();
        }
    }
}
