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
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import c.a.d.f.p.n;
import c.a.q0.r.t.c;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public abstract class AbsMsgImageActivity extends BaseActivity<AbsMsgImageActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ASSIST_URL = "assist_url";
    public static final String CHAT_MODE = "chat_mode";
    public static final String CURRENT_URL = "current_url";
    public static final String ID_KEY = "id";
    public static final String ID_UNIQUE = "uniqueid";
    public static final long INV_TIME = 300000000;
    public static final int PAGE_LIMIT = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public String assistUrl;
    public String curImgUrl;
    public String id;
    public LinkedHashMap<String, String> imageUrls;
    public boolean isSingleGif;
    public AlphaAnimation mAnim;
    public boolean mAnimFinished;
    public View mBack;
    public int mChatMode;
    public int mCount;
    public int mIndex;
    public MultiImageView mMultiImageView;
    public View.OnClickListener mOnClickListener;
    public ViewPager.OnPageChangeListener mOnPageChangeListener;
    public BaseViewPager.a mOnscOnScrollOutListener;
    public PermissionJudgePolicy mPermissionJudgement;
    public FrameLayout mSaveClick;
    public g mSaveImageTask;
    public TextView mTextView;
    public NavigationBar mTitle;
    public boolean mTitleGone;
    public long pageDoneTime;
    public HashMap<String, Boolean> pvHash;
    public String uniqueId;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsMsgImageActivity f43363e;

        /* renamed from: com.baidu.tieba.im.chat.AbsMsgImageActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class animation.Animation$AnimationListenerC1911a implements Animation.AnimationListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public animation.Animation$AnimationListenerC1911a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                    this.a.f43363e.mAnimFinished = true;
                    if (this.a.f43363e.mTitleGone) {
                        this.a.f43363e.mTitleGone = false;
                        this.a.f43363e.mTitle.setVisibility(8);
                    }
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                }
            }
        }

        public a(AbsMsgImageActivity absMsgImageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absMsgImageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43363e = absMsgImageActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f43363e.mBack) {
                    if (this.f43363e.mTitle.getVisibility() == 8) {
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("index", this.f43363e.mIndex);
                    this.f43363e.setResult(-1, intent);
                    this.f43363e.finish();
                } else if (view == this.f43363e.mSaveClick) {
                    if (this.f43363e.mTitle.getVisibility() == 8) {
                        return;
                    }
                    Activity pageActivity = this.f43363e.getPageContext().getPageActivity();
                    if (this.f43363e.mPermissionJudgement == null) {
                        this.f43363e.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    this.f43363e.mPermissionJudgement.clearRequestPermissionList();
                    this.f43363e.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.f43363e.mPermissionJudgement.startRequestPermission(pageActivity)) {
                        return;
                    }
                    try {
                        byte[] currentImageData = this.f43363e.mMultiImageView.getCurrentImageData();
                        if (currentImageData != null) {
                            String currentImageUrl = this.f43363e.mMultiImageView.getCurrentImageUrl();
                            this.f43363e.mSaveImageTask = new g(this.f43363e, currentImageUrl, currentImageData);
                            this.f43363e.mSaveImageTask.execute(new String[0]);
                            this.f43363e.mSaveClick.setClickable(false);
                        } else {
                            this.f43363e.showToast(this.f43363e.getPageContext().getString(R.string.no_data));
                        }
                    } catch (Exception unused) {
                    }
                } else if (this.f43363e.mAnimFinished) {
                    if (this.f43363e.mTitle.getVisibility() != 0) {
                        this.f43363e.mTitle.setVisibility(0);
                        this.f43363e.mMultiImageView.showTools();
                        this.f43363e.mAnim = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        this.f43363e.mAnim = new AlphaAnimation(1.0f, 0.0f);
                        this.f43363e.mTitleGone = true;
                        this.f43363e.mMultiImageView.hideTools();
                    }
                    this.f43363e.mAnim.setDuration(300L);
                    this.f43363e.mAnim.setFillAfter(true);
                    this.f43363e.mAnim.setAnimationListener(new animation.Animation$AnimationListenerC1911a(this));
                    this.f43363e.mAnimFinished = false;
                    this.f43363e.mTitle.startAnimation(this.f43363e.mAnim);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsMsgImageActivity f43364e;

        public b(AbsMsgImageActivity absMsgImageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absMsgImageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43364e = absMsgImageActivity;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || i2 != 1 || System.nanoTime() - this.f43364e.pageDoneTime <= AbsMsgImageActivity.INV_TIME || this.f43364e.imageUrls == null || this.f43364e.mIndex >= this.f43364e.imageUrls.size()) {
                return;
            }
            HashMap hashMap = this.f43364e.pvHash;
            LinkedHashMap linkedHashMap = this.f43364e.imageUrls;
            hashMap.put(linkedHashMap.get("" + this.f43364e.mIndex), Boolean.TRUE);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                AbsMsgImageActivity absMsgImageActivity = this.f43364e;
                absMsgImageActivity.imageChange(absMsgImageActivity.mIndex, i2);
                this.f43364e.mIndex = i2;
                this.f43364e.setTitle();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements BaseViewPager.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsMsgImageActivity a;

        public c(AbsMsgImageActivity absMsgImageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absMsgImageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absMsgImageActivity;
        }

        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements c.InterfaceC0876c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsMsgImageActivity a;

        public d(AbsMsgImageActivity absMsgImageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absMsgImageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absMsgImageActivity;
        }

        @Override // c.a.q0.r.t.c.InterfaceC0876c
        public void a(c.a.q0.r.t.c cVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, cVar, i2, view) == null) && cVar == this.a.getListMenu()) {
                if (i2 == 0) {
                    try {
                        Activity pageActivity = this.a.getPageContext().getPageActivity();
                        if (this.a.mPermissionJudgement == null) {
                            this.a.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        this.a.mPermissionJudgement.clearRequestPermissionList();
                        this.a.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.a.mPermissionJudgement.startRequestPermission(pageActivity)) {
                            return;
                        }
                        byte[] currentImageData = this.a.mMultiImageView.getCurrentImageData();
                        if (currentImageData != null) {
                            String currentImageUrl = this.a.mMultiImageView.getCurrentImageUrl();
                            this.a.mSaveImageTask = new g(this.a, currentImageUrl, currentImageData);
                            this.a.mSaveImageTask.execute(new String[0]);
                            this.a.mSaveClick.setClickable(false);
                        } else {
                            this.a.showToast(this.a.getPageContext().getString(R.string.no_data));
                        }
                    } catch (Exception unused) {
                    }
                }
                cVar.e();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.InterfaceC0876c f43365e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AbsMsgImageActivity f43366f;

        public e(AbsMsgImageActivity absMsgImageActivity, c.InterfaceC0876c interfaceC0876c) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absMsgImageActivity, interfaceC0876c};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43366f = absMsgImageActivity;
            this.f43365e = interfaceC0876c;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f43366f.createListMenu(new String[]{this.f43366f.getPageContext().getString(R.string.save)}, this.f43365e);
                this.f43366f.showListMenu();
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements c.a.r0.s1.s.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsMsgImageActivity a;

        public f(AbsMsgImageActivity absMsgImageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absMsgImageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absMsgImageActivity;
        }

        @Override // c.a.r0.s1.s.c
        public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, linkedHashMap, hashMap) == null) {
                if (linkedHashMap == null || this.a.isSingleGif) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(this.a.curImgUrl)) {
                    linkedHashMap.put(this.a.uniqueId, this.a.curImgUrl);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = this.a.assistUrl;
                    imageUrlData.urlType = 10;
                    hashMap.put(this.a.curImgUrl, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = this.a.uniqueId;
                    Iterator<String> it = linkedHashMap.keySet().iterator();
                    int i2 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        String next = it.next();
                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(next) && next.equals(str)) {
                            this.a.mIndex = i2;
                            z = true;
                            break;
                        }
                        i2++;
                    }
                    this.a.mCount = linkedHashMap.size();
                    if (!z) {
                        AbsMsgImageActivity absMsgImageActivity = this.a;
                        absMsgImageActivity.mIndex = absMsgImageActivity.mCount - 1;
                    }
                    this.a.mTextView.setVisibility(0);
                    this.a.setTitle();
                    this.a.mMultiImageView.setIsFromCDN(true);
                    this.a.mMultiImageView.setAllowLocalUrl(true);
                    this.a.mMultiImageView.setAssistUrls(hashMap);
                    this.a.mMultiImageView.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    this.a.mMultiImageView.setCurrentItem(this.a.mIndex, false);
                    return;
                }
                this.a.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f43367b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AbsMsgImageActivity f43368c;

        public g(AbsMsgImageActivity absMsgImageActivity, String str, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absMsgImageActivity, str, bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43368c = absMsgImageActivity;
            this.a = null;
            this.f43367b = null;
            this.a = str;
            this.f43367b = bArr;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f43368c.mSaveImageTask = null;
                this.f43368c.mSaveClick.setClickable(true);
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                super.onCancelled();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
                int saveImageFileByUser = FileHelper.saveImageFileByUser(this.a, this.f43367b, this.f43368c.getPageContext().getPageActivity());
                if (saveImageFileByUser != -2) {
                    if (saveImageFileByUser != 0) {
                        return this.f43368c.getPageContext().getString(R.string.save_fail);
                    }
                    return this.f43368c.getPageContext().getString(R.string.save_image_to_album);
                }
                return FileHelper.getSdErrorString();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                super.onPostExecute((g) str);
                this.f43368c.mSaveImageTask = null;
                this.f43368c.mSaveClick.setClickable(true);
                this.f43368c.showToast(str);
            }
        }
    }

    public AbsMsgImageActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.imageUrls = null;
        this.mIndex = 0;
        this.mSaveImageTask = null;
        this.mBack = null;
        this.mTextView = null;
        this.mTitle = null;
        this.mMultiImageView = null;
        this.mOnClickListener = null;
        this.mOnscOnScrollOutListener = null;
        this.mOnPageChangeListener = null;
        this.mAnim = null;
        this.mAnimFinished = true;
        this.mTitleGone = false;
        this.curImgUrl = "";
        this.id = "";
        this.uniqueId = "";
        this.pageDoneTime = 0L;
        this.pvHash = null;
        this.mChatMode = 0;
    }

    private int calCurrentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, this)) == null) {
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
        return invokeV.intValue;
    }

    private void getImageList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            if (TextUtils.isEmpty(this.id)) {
                finish();
            }
            queryAllBigImageUrls(this.id, new f(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void imageChange(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65570, this, i2, i3) == null) {
            synchronized (this.pvHash) {
                if (System.nanoTime() - this.pageDoneTime > INV_TIME && this.imageUrls != null && i2 < this.imageUrls.size()) {
                    HashMap<String, Boolean> hashMap = this.pvHash;
                    LinkedHashMap<String, String> linkedHashMap = this.imageUrls;
                    hashMap.put(linkedHashMap.get("" + i2), Boolean.TRUE);
                }
                this.pageDoneTime = System.nanoTime();
            }
        }
    }

    private void initData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65571, this, bundle) == null) {
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
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
            this.mOnClickListener = new a(this);
            this.mOnPageChangeListener = new b(this);
            this.mOnscOnScrollOutListener = new c(this);
            e eVar = new e(this, new d(this));
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
            multiImageView.setPageMargin(n.d(getPageContext().getContext(), 8.0f));
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTitle() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65573, this) == null) || this.imageUrls == null) {
            return;
        }
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

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            super.onChangeSkinType(i2);
            SkinManager.setBackgroundColor(this.mMultiImageView, R.color.black_alpha100);
            SkinManager.setBackgroundColor(this.mTitle, R.color.common_color_10222);
            getLayoutMode().j(this.mBack);
            getLayoutMode().j(this.mTextView);
            getLayoutMode().j(this.mSaveClick);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            this.mMultiImageView.setCurrentItem(this.mIndex, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            TbadkCoreApplication.getInst().addRemoteActivity(this);
            setContentView(R.layout.image_activity_2);
            initData(bundle);
            initUI();
            getImageList();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            TbadkCoreApplication.getInst().delRemoteActivity(this);
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                Intent intent = new Intent();
                intent.putExtra("index", this.mIndex);
                setResult(-1, intent);
                finish();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, intent) == null) {
            super.onNewIntent(intent);
            setIntent(intent);
            getImageList();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onPause();
            this.mMultiImageView.onPause();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onResume();
            this.mMultiImageView.onResume();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putSerializable("url", this.imageUrls);
            bundle.putInt("index", this.mIndex);
            bundle.putString("id", this.id);
            bundle.putString("uniqueid", this.uniqueId);
            bundle.putInt("chat_mode", this.mChatMode);
            bundle.putBoolean("isSingle", this.isSingleGif);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onStop();
            int i2 = this.mIndex;
            imageChange(i2, i2);
            this.mMultiImageView.onDestroy();
            g gVar = this.mSaveImageTask;
            if (gVar != null) {
                gVar.cancel();
                this.mSaveImageTask = null;
            }
        }
    }

    public abstract void queryAllBigImageUrls(String str, c.a.r0.s1.s.c cVar);

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.mMultiImageView.onDestroy();
        }
    }
}
