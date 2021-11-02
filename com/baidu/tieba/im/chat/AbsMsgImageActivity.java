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
import b.a.e.e.p.l;
import b.a.q0.s.s.b;
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
/* loaded from: classes9.dex */
public abstract class AbsMsgImageActivity extends BaseActivity<AbsMsgImageActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ASSIST_URL = "assist_url";
    public static final String CHAT_MODE = "chat_mode";
    public static final String CURRENT_URL = "current_url";
    public static final String ID = "id";
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

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsMsgImageActivity f50156e;

        /* renamed from: com.baidu.tieba.im.chat.AbsMsgImageActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class animation.Animation$AnimationListenerC1726a implements Animation.AnimationListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f50157a;

            public animation.Animation$AnimationListenerC1726a(a aVar) {
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
                this.f50157a = aVar;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                    this.f50157a.f50156e.mAnimFinished = true;
                    if (this.f50157a.f50156e.mTitleGone) {
                        this.f50157a.f50156e.mTitleGone = false;
                        this.f50157a.f50156e.mTitle.setVisibility(8);
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
            this.f50156e = absMsgImageActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f50156e.mBack) {
                    if (this.f50156e.mTitle.getVisibility() == 8) {
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("index", this.f50156e.mIndex);
                    this.f50156e.setResult(-1, intent);
                    this.f50156e.finish();
                } else if (view == this.f50156e.mSaveClick) {
                    if (this.f50156e.mTitle.getVisibility() == 8) {
                        return;
                    }
                    Activity pageActivity = this.f50156e.getPageContext().getPageActivity();
                    if (this.f50156e.mPermissionJudgement == null) {
                        this.f50156e.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    this.f50156e.mPermissionJudgement.clearRequestPermissionList();
                    this.f50156e.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.f50156e.mPermissionJudgement.startRequestPermission(pageActivity)) {
                        return;
                    }
                    try {
                        byte[] currentImageData = this.f50156e.mMultiImageView.getCurrentImageData();
                        if (currentImageData != null) {
                            String currentImageUrl = this.f50156e.mMultiImageView.getCurrentImageUrl();
                            this.f50156e.mSaveImageTask = new g(this.f50156e, currentImageUrl, currentImageData);
                            this.f50156e.mSaveImageTask.execute(new String[0]);
                            this.f50156e.mSaveClick.setClickable(false);
                        } else {
                            this.f50156e.showToast(this.f50156e.getPageContext().getString(R.string.no_data));
                        }
                    } catch (Exception unused) {
                    }
                } else if (this.f50156e.mAnimFinished) {
                    if (this.f50156e.mTitle.getVisibility() != 0) {
                        this.f50156e.mTitle.setVisibility(0);
                        this.f50156e.mMultiImageView.showTools();
                        this.f50156e.mAnim = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        this.f50156e.mAnim = new AlphaAnimation(1.0f, 0.0f);
                        this.f50156e.mTitleGone = true;
                        this.f50156e.mMultiImageView.hideTools();
                    }
                    this.f50156e.mAnim.setDuration(300L);
                    this.f50156e.mAnim.setFillAfter(true);
                    this.f50156e.mAnim.setAnimationListener(new animation.Animation$AnimationListenerC1726a(this));
                    this.f50156e.mAnimFinished = false;
                    this.f50156e.mTitle.startAnimation(this.f50156e.mAnim);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsMsgImageActivity f50158e;

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
            this.f50158e = absMsgImageActivity;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || i2 != 1 || System.nanoTime() - this.f50158e.pageDoneTime <= AbsMsgImageActivity.INV_TIME || this.f50158e.imageUrls == null || this.f50158e.mIndex >= this.f50158e.imageUrls.size()) {
                return;
            }
            HashMap hashMap = this.f50158e.pvHash;
            LinkedHashMap linkedHashMap = this.f50158e.imageUrls;
            hashMap.put(linkedHashMap.get("" + this.f50158e.mIndex), Boolean.TRUE);
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
                AbsMsgImageActivity absMsgImageActivity = this.f50158e;
                absMsgImageActivity.imageChange(absMsgImageActivity.mIndex, i2);
                this.f50158e.mIndex = i2;
                this.f50158e.setTitle();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements BaseViewPager.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsMsgImageActivity f50159a;

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
            this.f50159a = absMsgImageActivity;
        }

        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsMsgImageActivity f50160a;

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
            this.f50160a = absMsgImageActivity;
        }

        @Override // b.a.q0.s.s.b.c
        public void a(b.a.q0.s.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) && bVar == this.f50160a.getListMenu()) {
                if (i2 == 0) {
                    try {
                        Activity pageActivity = this.f50160a.getPageContext().getPageActivity();
                        if (this.f50160a.mPermissionJudgement == null) {
                            this.f50160a.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        this.f50160a.mPermissionJudgement.clearRequestPermissionList();
                        this.f50160a.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.f50160a.mPermissionJudgement.startRequestPermission(pageActivity)) {
                            return;
                        }
                        byte[] currentImageData = this.f50160a.mMultiImageView.getCurrentImageData();
                        if (currentImageData != null) {
                            String currentImageUrl = this.f50160a.mMultiImageView.getCurrentImageUrl();
                            this.f50160a.mSaveImageTask = new g(this.f50160a, currentImageUrl, currentImageData);
                            this.f50160a.mSaveImageTask.execute(new String[0]);
                            this.f50160a.mSaveClick.setClickable(false);
                        } else {
                            this.f50160a.showToast(this.f50160a.getPageContext().getString(R.string.no_data));
                        }
                    } catch (Exception unused) {
                    }
                }
                bVar.e();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.c f50161e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AbsMsgImageActivity f50162f;

        public e(AbsMsgImageActivity absMsgImageActivity, b.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absMsgImageActivity, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50162f = absMsgImageActivity;
            this.f50161e = cVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f50162f.createListMenu(new String[]{this.f50162f.getPageContext().getString(R.string.save)}, this.f50161e);
                this.f50162f.showListMenu();
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class f implements b.a.r0.l1.s.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsMsgImageActivity f50163a;

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
            this.f50163a = absMsgImageActivity;
        }

        @Override // b.a.r0.l1.s.c
        public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, linkedHashMap, hashMap) == null) {
                if (linkedHashMap == null || this.f50163a.isSingleGif) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(this.f50163a.curImgUrl)) {
                    linkedHashMap.put(this.f50163a.uniqueId, this.f50163a.curImgUrl);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = this.f50163a.assistUrl;
                    imageUrlData.urlType = 10;
                    hashMap.put(this.f50163a.curImgUrl, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = this.f50163a.uniqueId;
                    Iterator<String> it = linkedHashMap.keySet().iterator();
                    int i2 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        String next = it.next();
                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(next) && next.equals(str)) {
                            this.f50163a.mIndex = i2;
                            z = true;
                            break;
                        }
                        i2++;
                    }
                    this.f50163a.mCount = linkedHashMap.size();
                    if (!z) {
                        AbsMsgImageActivity absMsgImageActivity = this.f50163a;
                        absMsgImageActivity.mIndex = absMsgImageActivity.mCount - 1;
                    }
                    this.f50163a.mTextView.setVisibility(0);
                    this.f50163a.setTitle();
                    this.f50163a.mMultiImageView.setIsFromCDN(true);
                    this.f50163a.mMultiImageView.setAllowLocalUrl(true);
                    this.f50163a.mMultiImageView.setAssistUrls(hashMap);
                    this.f50163a.mMultiImageView.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    this.f50163a.mMultiImageView.setCurrentItem(this.f50163a.mIndex, false);
                    return;
                }
                this.f50163a.finish();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f50164a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f50165b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AbsMsgImageActivity f50166c;

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
            this.f50166c = absMsgImageActivity;
            this.f50164a = null;
            this.f50165b = null;
            this.f50164a = str;
            this.f50165b = bArr;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f50166c.mSaveImageTask = null;
                this.f50166c.mSaveClick.setClickable(true);
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
                int saveImageFileByUser = FileHelper.saveImageFileByUser(this.f50164a, this.f50165b, this.f50166c.getPageContext().getPageActivity());
                if (saveImageFileByUser != -2) {
                    if (saveImageFileByUser != 0) {
                        return this.f50166c.getPageContext().getString(R.string.save_fail);
                    }
                    return this.f50166c.getPageContext().getString(R.string.save_image_to_album);
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
                this.f50166c.mSaveImageTask = null;
                this.f50166c.mSaveClick.setClickable(true);
                this.f50166c.showToast(str);
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

    public abstract void queryAllBigImageUrls(String str, b.a.r0.l1.s.c cVar);

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.mMultiImageView.onDestroy();
        }
    }
}
