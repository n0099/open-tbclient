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
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.R;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.c.e.p.l;
import d.a.m0.r.s.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public abstract class AbsMsgImageActivity extends BaseActivity<AbsMsgImageActivity> {
    public static final String ASSIST_URL = "assist_url";
    public static final String CHAT_MODE = "chat_mode";
    public static final String CURRENT_URL = "current_url";
    public static final String ID = "id";
    public static final String ID_UNIQUE = "uniqueid";
    public static final long INV_TIME = 300000000;
    public static final int PAGE_LIMIT = 2;
    public String assistUrl;
    public boolean isSingleGif;
    public int mCount;
    public PermissionJudgePolicy mPermissionJudgement;
    public FrameLayout mSaveClick;
    public LinkedHashMap<String, String> imageUrls = null;
    public int mIndex = 0;
    public g mSaveImageTask = null;
    public View mBack = null;
    public TextView mTextView = null;
    public NavigationBar mTitle = null;
    public MultiImageView mMultiImageView = null;
    public View.OnClickListener mOnClickListener = null;
    public BaseViewPager.a mOnscOnScrollOutListener = null;
    public ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    public AlphaAnimation mAnim = null;
    public boolean mAnimFinished = true;
    public boolean mTitleGone = false;
    public String curImgUrl = "";
    public String id = "";
    public String uniqueId = "";
    public long pageDoneTime = 0;
    public HashMap<String, Boolean> pvHash = null;
    public int mChatMode = 0;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: com.baidu.tieba.im.chat.AbsMsgImageActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class animation.Animation$AnimationListenerC0181a implements Animation.AnimationListener {
            public animation.Animation$AnimationListenerC0181a() {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AbsMsgImageActivity.this.mAnimFinished = true;
                if (AbsMsgImageActivity.this.mTitleGone) {
                    AbsMsgImageActivity.this.mTitleGone = false;
                    AbsMsgImageActivity.this.mTitle.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == AbsMsgImageActivity.this.mBack) {
                if (AbsMsgImageActivity.this.mTitle.getVisibility() == 8) {
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("index", AbsMsgImageActivity.this.mIndex);
                AbsMsgImageActivity.this.setResult(-1, intent);
                AbsMsgImageActivity.this.finish();
            } else if (view == AbsMsgImageActivity.this.mSaveClick) {
                if (AbsMsgImageActivity.this.mTitle.getVisibility() == 8) {
                    return;
                }
                Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                if (AbsMsgImageActivity.this.mPermissionJudgement == null) {
                    AbsMsgImageActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                }
                AbsMsgImageActivity.this.mPermissionJudgement.clearRequestPermissionList();
                AbsMsgImageActivity.this.mPermissionJudgement.appendRequestPermission(pageActivity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                if (AbsMsgImageActivity.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                    return;
                }
                try {
                    byte[] currentImageData = AbsMsgImageActivity.this.mMultiImageView.getCurrentImageData();
                    if (currentImageData != null) {
                        String currentImageUrl = AbsMsgImageActivity.this.mMultiImageView.getCurrentImageUrl();
                        AbsMsgImageActivity.this.mSaveImageTask = new g(currentImageUrl, currentImageData);
                        AbsMsgImageActivity.this.mSaveImageTask.execute(new String[0]);
                        AbsMsgImageActivity.this.mSaveClick.setClickable(false);
                    } else {
                        AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(R.string.no_data));
                    }
                } catch (Exception unused) {
                }
            } else if (AbsMsgImageActivity.this.mAnimFinished) {
                if (AbsMsgImageActivity.this.mTitle.getVisibility() != 0) {
                    AbsMsgImageActivity.this.mTitle.setVisibility(0);
                    AbsMsgImageActivity.this.mMultiImageView.C();
                    AbsMsgImageActivity.this.mAnim = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    AbsMsgImageActivity.this.mAnim = new AlphaAnimation(1.0f, 0.0f);
                    AbsMsgImageActivity.this.mTitleGone = true;
                    AbsMsgImageActivity.this.mMultiImageView.p();
                }
                AbsMsgImageActivity.this.mAnim.setDuration(300L);
                AbsMsgImageActivity.this.mAnim.setFillAfter(true);
                AbsMsgImageActivity.this.mAnim.setAnimationListener(new animation.Animation$AnimationListenerC0181a());
                AbsMsgImageActivity.this.mAnimFinished = false;
                AbsMsgImageActivity.this.mTitle.startAnimation(AbsMsgImageActivity.this.mAnim);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            if (i2 != 1 || System.nanoTime() - AbsMsgImageActivity.this.pageDoneTime <= AbsMsgImageActivity.INV_TIME || AbsMsgImageActivity.this.imageUrls == null || AbsMsgImageActivity.this.mIndex >= AbsMsgImageActivity.this.imageUrls.size()) {
                return;
            }
            HashMap hashMap = AbsMsgImageActivity.this.pvHash;
            LinkedHashMap linkedHashMap = AbsMsgImageActivity.this.imageUrls;
            hashMap.put(linkedHashMap.get("" + AbsMsgImageActivity.this.mIndex), Boolean.TRUE);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            AbsMsgImageActivity absMsgImageActivity = AbsMsgImageActivity.this;
            absMsgImageActivity.imageChange(absMsgImageActivity.mIndex, i2);
            AbsMsgImageActivity.this.mIndex = i2;
            AbsMsgImageActivity.this.setTitle();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements BaseViewPager.a {
        public c() {
        }

        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void a(int i2) {
        }
    }

    /* loaded from: classes4.dex */
    public class d implements b.c {
        public d() {
        }

        @Override // d.a.m0.r.s.b.c
        public void a(d.a.m0.r.s.b bVar, int i2, View view) {
            if (bVar == AbsMsgImageActivity.this.getListMenu()) {
                if (i2 == 0) {
                    try {
                        Activity pageActivity = AbsMsgImageActivity.this.getPageContext().getPageActivity();
                        if (AbsMsgImageActivity.this.mPermissionJudgement == null) {
                            AbsMsgImageActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        AbsMsgImageActivity.this.mPermissionJudgement.clearRequestPermissionList();
                        AbsMsgImageActivity.this.mPermissionJudgement.appendRequestPermission(pageActivity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                        if (AbsMsgImageActivity.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                            return;
                        }
                        byte[] currentImageData = AbsMsgImageActivity.this.mMultiImageView.getCurrentImageData();
                        if (currentImageData != null) {
                            String currentImageUrl = AbsMsgImageActivity.this.mMultiImageView.getCurrentImageUrl();
                            AbsMsgImageActivity.this.mSaveImageTask = new g(currentImageUrl, currentImageData);
                            AbsMsgImageActivity.this.mSaveImageTask.execute(new String[0]);
                            AbsMsgImageActivity.this.mSaveClick.setClickable(false);
                        } else {
                            AbsMsgImageActivity.this.showToast(AbsMsgImageActivity.this.getPageContext().getString(R.string.no_data));
                        }
                    } catch (Exception unused) {
                    }
                }
                bVar.e();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnLongClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.c f16954e;

        public e(b.c cVar) {
            this.f16954e = cVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            AbsMsgImageActivity.this.createListMenu(new String[]{AbsMsgImageActivity.this.getPageContext().getString(R.string.save)}, this.f16954e);
            AbsMsgImageActivity.this.showListMenu();
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.a.n0.f1.s.c {
        public f() {
        }

        @Override // d.a.n0.f1.s.c
        public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
            boolean z;
            if (linkedHashMap == null || AbsMsgImageActivity.this.isSingleGif) {
                linkedHashMap = new LinkedHashMap<>();
            }
            if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(AbsMsgImageActivity.this.curImgUrl)) {
                linkedHashMap.put(AbsMsgImageActivity.this.uniqueId, AbsMsgImageActivity.this.curImgUrl);
                if (hashMap == null) {
                    hashMap = new HashMap<>();
                }
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.imageUrl = AbsMsgImageActivity.this.assistUrl;
                imageUrlData.urlType = 10;
                hashMap.put(AbsMsgImageActivity.this.curImgUrl, imageUrlData);
            }
            if (linkedHashMap.size() != 0) {
                String str = AbsMsgImageActivity.this.uniqueId;
                Iterator<String> it = linkedHashMap.keySet().iterator();
                int i2 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    String next = it.next();
                    if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(next) && next.equals(str)) {
                        AbsMsgImageActivity.this.mIndex = i2;
                        z = true;
                        break;
                    }
                    i2++;
                }
                AbsMsgImageActivity.this.mCount = linkedHashMap.size();
                if (!z) {
                    AbsMsgImageActivity absMsgImageActivity = AbsMsgImageActivity.this;
                    absMsgImageActivity.mIndex = absMsgImageActivity.mCount - 1;
                }
                AbsMsgImageActivity.this.mTextView.setVisibility(0);
                AbsMsgImageActivity.this.setTitle();
                AbsMsgImageActivity.this.mMultiImageView.setIsFromCDN(true);
                AbsMsgImageActivity.this.mMultiImageView.setAllowLocalUrl(true);
                AbsMsgImageActivity.this.mMultiImageView.setAssistUrls(hashMap);
                AbsMsgImageActivity.this.mMultiImageView.setUrlData(new ArrayList<>(linkedHashMap.values()));
                AbsMsgImageActivity.this.mMultiImageView.setCurrentItem(AbsMsgImageActivity.this.mIndex, false);
                return;
            }
            AbsMsgImageActivity.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class g extends BdAsyncTask<String, Integer, String> {

        /* renamed from: a  reason: collision with root package name */
        public String f16957a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f16958b;

        public g(String str, byte[] bArr) {
            this.f16957a = null;
            this.f16958b = null;
            this.f16957a = str;
            this.f16958b = bArr;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AbsMsgImageActivity.this.mSaveImageTask = null;
            AbsMsgImageActivity.this.mSaveClick.setClickable(true);
            super.cancel(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            int saveImageFileByUser = FileHelper.saveImageFileByUser(this.f16957a, this.f16958b, AbsMsgImageActivity.this.getPageContext().getPageActivity());
            if (saveImageFileByUser != -2) {
                if (saveImageFileByUser != 0) {
                    return AbsMsgImageActivity.this.getPageContext().getString(R.string.save_fail);
                }
                return AbsMsgImageActivity.this.getPageContext().getString(R.string.save_image_to_album);
            }
            return FileHelper.getSdErrorString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((g) str);
            AbsMsgImageActivity.this.mSaveImageTask = null;
            AbsMsgImageActivity.this.mSaveClick.setClickable(true);
            AbsMsgImageActivity.this.showToast(str);
        }
    }

    private int calCurrentIndex() {
        LinkedHashMap<String, String> linkedHashMap = this.imageUrls;
        if (linkedHashMap != null && linkedHashMap.size() > 0) {
            int size = this.imageUrls.size();
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

    private void getImageList() {
        if (TextUtils.isEmpty(this.id)) {
            finish();
        }
        queryAllBigImageUrls(this.id, new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void imageChange(int i2, int i3) {
        synchronized (this.pvHash) {
            if (System.nanoTime() - this.pageDoneTime > INV_TIME && this.imageUrls != null && i2 < this.imageUrls.size()) {
                HashMap<String, Boolean> hashMap = this.pvHash;
                LinkedHashMap<String, String> linkedHashMap = this.imageUrls;
                hashMap.put(linkedHashMap.get("" + i2), Boolean.TRUE);
            }
            this.pageDoneTime = System.nanoTime();
        }
    }

    private void initData(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.curImgUrl = intent.getStringExtra("current_url");
            this.assistUrl = intent.getStringExtra("assist_url");
            this.id = intent.getStringExtra("id");
            this.uniqueId = intent.getStringExtra("uniqueid");
            this.isSingleGif = intent.getBooleanExtra("isSingle", false);
            if (this.uniqueId == null) {
                this.uniqueId = "";
            }
            if (this.id == null) {
                this.id = "";
            }
            if (this.curImgUrl == null) {
                this.curImgUrl = "";
            }
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            this.imageUrls = linkedHashMap;
            linkedHashMap.put(this.uniqueId, this.curImgUrl);
            this.mChatMode = intent.getIntExtra("chat_mode", 0);
            this.mIndex = 0;
        } else if (bundle != null) {
            this.imageUrls = (LinkedHashMap) bundle.getSerializable("url");
            this.mIndex = bundle.getInt("index", -1);
            this.id = bundle.getString("id");
            this.uniqueId = bundle.getString("uniqueid");
            this.mChatMode = bundle.getInt("chat_mode", 0);
            this.isSingleGif = bundle.getBoolean("isSingle", false);
            if (this.uniqueId == null) {
                this.uniqueId = "";
            }
            if (this.id == null) {
                this.id = "";
            }
        }
        this.pvHash = new HashMap<>();
    }

    private void initUI() {
        this.mOnClickListener = new a();
        this.mOnPageChangeListener = new b();
        this.mOnscOnScrollOutListener = new c();
        e eVar = new e(new d());
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mTitle = navigationBar;
        FrameLayout frameLayout = (FrameLayout) navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, this.mOnClickListener);
        this.mSaveClick = frameLayout;
        if (this.isSingleGif) {
            frameLayout.setVisibility(8);
        }
        this.mBack = this.mTitle.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mOnClickListener);
        SkinManager.setImageResource(this.mTitle.getBackImageView(), R.drawable.icon_return_bg);
        this.mTextView = this.mTitle.setTitleText("");
        MultiImageView multiImageView = (MultiImageView) findViewById(R.id.viewpager);
        this.mMultiImageView = multiImageView;
        multiImageView.setPageMargin(l.e(getPageContext().getContext(), 8.0f));
        this.mMultiImageView.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.mMultiImageView.setOnPageChangeListener(this.mOnPageChangeListener);
        this.mMultiImageView.setItemOnclickListener(this.mOnClickListener);
        this.mMultiImageView.setCurrentItem(calCurrentIndex(), false);
        this.mMultiImageView.setOnScrollOutListener(this.mOnscOnScrollOutListener);
        this.mMultiImageView.setItemOnLongClickListener(eVar);
        this.mMultiImageView.setHasNext(false);
        this.mMultiImageView.setNextTitle("mNextTitle");
        this.mMultiImageView.setIsFromCDN(true);
        this.mMultiImageView.setAllowLocalUrl(true);
        int i2 = this.mIndex;
        imageChange(i2, i2);
        this.mTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTitle() {
        if (this.imageUrls != null) {
            String valueOf = String.valueOf(this.mIndex + 1);
            if (this.mCount > 0) {
                valueOf = (valueOf + "/") + this.mCount;
            }
            if (this.mMultiImageView.getHasNext() && this.mIndex == this.mMultiImageView.getItemNum() - 1) {
                this.mTextView.setText(getPageContext().getString(R.string.image_recommend));
                this.mSaveClick.setClickable(false);
                return;
            }
            this.mTextView.setText(valueOf);
            this.mSaveClick.setClickable(true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
    }

    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        SkinManager.setBackgroundColor(this.mMultiImageView, R.color.black_alpha100);
        SkinManager.setBackgroundColor(this.mTitle, R.color.common_color_10222);
        getLayoutMode().j(this.mBack);
        getLayoutMode().j(this.mTextView);
        getLayoutMode().j(this.mSaveClick);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mMultiImageView.setCurrentItem(this.mIndex, true);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(R.layout.image_activity_2);
        initData(bundle);
        initUI();
        getImageList();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            Intent intent = new Intent();
            intent.putExtra("index", this.mIndex);
            setResult(-1, intent);
            finish();
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        getImageList();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mMultiImageView.w();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mMultiImageView.x();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("url", this.imageUrls);
        bundle.putInt("index", this.mIndex);
        bundle.putString("id", this.id);
        bundle.putString("uniqueid", this.uniqueId);
        bundle.putInt("chat_mode", this.mChatMode);
        bundle.putBoolean("isSingle", this.isSingleGif);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        int i2 = this.mIndex;
        imageChange(i2, i2);
        this.mMultiImageView.v();
        g gVar = this.mSaveImageTask;
        if (gVar != null) {
            gVar.cancel();
            this.mSaveImageTask = null;
        }
    }

    public abstract void queryAllBigImageUrls(String str, d.a.n0.f1.s.c cVar);

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.mMultiImageView.v();
    }
}
