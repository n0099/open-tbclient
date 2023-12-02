package com.baidu.tieba.im.biz.aibot.backgroundslice;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager2.widget.ViewPager2;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.module.imaibot.AibotArgs;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.br8;
import com.baidu.tieba.fr8;
import com.baidu.tieba.i5b;
import com.baidu.tieba.im.base.core.slice.Slice;
import com.baidu.tieba.im.biz.aibot.backgroundslice.BackgroundSlice;
import com.baidu.tieba.im.biz.aibot.data.AibotChatDetail;
import com.baidu.tieba.impersonal.databinding.AibotBgListBinding;
import com.baidu.tieba.kr8;
import com.baidu.tieba.yq8;
import com.baidu.tieba.zq8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.transition.Transition;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 N2\u00020\u00012\u00020\u0002:\u0002NOB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0014\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&J\"\u0010(\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010\u001a2\b\u0010*\u001a\u0004\u0018\u00010\u001a2\u0006\u0010+\u001a\u00020\u0011J\u0006\u0010,\u001a\u00020$J\u000e\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020/J\u0006\u00100\u001a\u00020$J\b\u00101\u001a\u0004\u0018\u000102J\b\u00103\u001a\u00020\u0011H\u0002J\u0010\u00104\u001a\u00020$2\u0006\u00105\u001a\u00020\u0014H\u0002J\u0016\u00104\u001a\u00020$2\u0006\u00106\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u0014J \u00104\u001a\u00020$2\u0006\u00106\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u00142\u0006\u00107\u001a\u00020\u0011H\u0002J\u000e\u00108\u001a\u00020$2\u0006\u00109\u001a\u00020\u001aJ\u000e\u0010:\u001a\u00020$2\u0006\u00109\u001a\u00020\u001aJ\u0010\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u00020=H\u0016J\"\u0010>\u001a\u00020\u00142\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\b\u0010E\u001a\u00020$H\u0016J\b\u0010F\u001a\u00020$H\u0016J\u0010\u0010G\u001a\u00020$2\u0006\u0010H\u001a\u00020IH\u0016J\u0018\u0010J\u001a\u00020$2\u0006\u0010K\u001a\u00020\t2\u0006\u0010L\u001a\u00020\u0011H\u0016J\u0006\u0010M\u001a\u00020$R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u0014X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/backgroundslice/BackgroundSlice;", "Lcom/baidu/tieba/im/base/core/slice/Slice;", "Lcom/baidu/tieba/im/biz/aibot/IPageChangeNotify;", "wrapper", "Lcom/baidu/tieba/im/biz/aibot/AibotChatPageWrapper;", WebChromeClient.KEY_ARG_ARRAY, "Lcom/baidu/tbadk/module/imaibot/AibotArgs;", "(Lcom/baidu/tieba/im/biz/aibot/AibotChatPageWrapper;Lcom/baidu/tbadk/module/imaibot/AibotArgs;)V", "DEFAULT_BG", "", "getDEFAULT_BG", "()I", "bgAdapter", "Lcom/baidu/tieba/im/biz/aibot/backgroundslice/AibotBgAdapter;", "botsBgViewBinding", "Lcom/baidu/tieba/impersonal/databinding/AibotBgListBinding;", "canLoadDefaultBg", "", "canStatPersonPageExp", "chatBgView", "Landroid/view/View;", "getChatBgView", "()Landroid/view/View;", "setChatBgView", "(Landroid/view/View;)V", "mChatBgUrl", "", "mPageState", "mPersonBgColor", "mPicBgLoaded", "personBgView", "getPersonBgView", "setPersonBgView", "scrollHelper", "Lcom/baidu/tieba/im/biz/aibot/backgroundslice/ViewPager2SlowScrollHelper;", "bindBotData", "", "bots", "", "Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail$BotList;", "bindData", "chatBgUrl", "personBgColor", "needDelayed", "changePageState", "dragScroll", "offset", "", "endDragScroll", "getBgCurrentViewBitmap", "Landroid/graphics/Bitmap;", "isPersonPageState", "loadPicUrl", "targetView", "backgroundUrl", "fromNet", "location", "uk", "locationWithoutAnim", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", MissionEvent.MESSAGE_PAUSE, "onResume", "onSetChatDetail", "chatDetail", "Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail;", "onSetPageState", "state", "refreshPage", "startDragScroll", "Companion", "FitTopTransformation", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BackgroundSlice extends Slice implements br8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final yq8 j;
    public final AibotArgs k;
    public View l;
    public View m;
    public String n;
    public String o;
    public int p;
    public boolean q;
    public boolean r;
    public boolean s;
    public final int t;
    public AibotBgListBinding u;
    public AibotBgAdapter v;
    public fr8 w;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2138821643, "Lcom/baidu/tieba/im/biz/aibot/backgroundslice/BackgroundSlice;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2138821643, "Lcom/baidu/tieba/im/biz/aibot/backgroundslice/BackgroundSlice;");
        }
    }

    /* loaded from: classes6.dex */
    public static final class a extends BitmapTransformation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final byte[] b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = "com.baidu.tieba.im.biz.aibot.backgroundslice.BackgroundSlice.FitTopTransformation";
            Charset forName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(forName, "forName(\"UTF-8\")");
            byte[] bytes = "com.baidu.tieba.im.biz.aibot.backgroundslice.BackgroundSlice.FitTopTransformation".getBytes(forName);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            this.b = bytes;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
        public Bitmap transform(BitmapPool pool, Bitmap toTransform, int i, int i2) {
            InterceptResult invokeLLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048576, this, pool, toTransform, i, i2)) == null) {
                Intrinsics.checkNotNullParameter(pool, "pool");
                Intrinsics.checkNotNullParameter(toTransform, "toTransform");
                Bitmap createBitmap = Bitmap.createBitmap(toTransform, 0, 0, i, i2);
                Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(toTransform…, 0, outWidth, outHeight)");
                return createBitmap;
            }
            return (Bitmap) invokeLLII.objValue;
        }

        @Override // com.bumptech.glide.load.Key
        public void updateDiskCacheKey(MessageDigest messageDigest) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, messageDigest) == null) {
                Intrinsics.checkNotNullParameter(messageDigest, "messageDigest");
                messageDigest.update(this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends CustomViewTarget<View, Drawable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ BackgroundSlice b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view2, BackgroundSlice backgroundSlice) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, backgroundSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
            this.b = backgroundSlice;
        }

        public static final void a(BackgroundSlice this$0, View targetView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, this$0, targetView) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(targetView, "$targetView");
                this$0.u0(targetView);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bumptech.glide.request.target.Target
        /* renamed from: b */
        public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, resource, transition) == null) {
                Intrinsics.checkNotNullParameter(resource, "resource");
                this.a.setBackground(resource);
            }
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable) == null) {
                BdLog.e("图片加载失败");
                if (this.b.s) {
                    this.b.s = false;
                    SafeHandler inst = SafeHandler.getInst();
                    final BackgroundSlice backgroundSlice = this.b;
                    final View view2 = this.a;
                    inst.post(new Runnable() { // from class: com.baidu.tieba.dr8
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                BackgroundSlice.b.a(BackgroundSlice.this, view2);
                            }
                        }
                    });
                }
            }
        }

        @Override // com.bumptech.glide.request.target.CustomViewTarget
        public void onResourceCleared(Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, drawable) == null) {
                this.a.setBackground(null);
            }
        }
    }

    public BackgroundSlice(yq8 wrapper, AibotArgs aibotArgs) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wrapper, aibotArgs};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(wrapper, "wrapper");
        this.j = wrapper;
        this.k = aibotArgs;
        this.p = 2;
        this.s = true;
        this.t = R.drawable.obfuscated_res_0x7f0802de;
    }

    public final void A0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            Intrinsics.checkNotNullParameter(view2, "<set-?>");
            this.m = view2;
        }
    }

    @Override // com.baidu.tieba.br8
    public void O(AibotChatDetail chatDetail) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatDetail) == null) {
            Intrinsics.checkNotNullParameter(chatDetail, "chatDetail");
            k0(chatDetail.getConfigData().getChatBackground(), chatDetail.getConfigData().getThemeColor(), false);
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    public void T(Configuration newConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, newConfig) == null) {
            Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            super.T(newConfig);
            this.q = false;
            this.s = true;
            k0(this.n, this.o, true);
        }
    }

    public final void j0(List<AibotChatDetail.BotList> bots) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bots) == null) {
            Intrinsics.checkNotNullParameter(bots, "bots");
            AibotBgAdapter aibotBgAdapter = this.v;
            if (aibotBgAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bgAdapter");
                aibotBgAdapter = null;
            }
            aibotBgAdapter.setData(bots);
        }
    }

    public final void o0(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f) == null) {
            AibotBgListBinding aibotBgListBinding = this.u;
            if (aibotBgListBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("botsBgViewBinding");
                aibotBgListBinding = null;
            }
            aibotBgListBinding.b.fakeDragBy(f);
        }
    }

    public final void u0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, view2) == null) {
            w0("", view2, false);
        }
    }

    public final void z0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, view2) == null) {
            Intrinsics.checkNotNullParameter(view2, "<set-?>");
            this.l = view2;
        }
    }

    public static final void m0(String str, BackgroundSlice this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (str != null) {
                this$0.v0(str, this$0.r0());
            }
        }
    }

    @Override // com.baidu.tieba.br8
    public void e2(int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) != null) || this.p == i) {
            return;
        }
        this.p = i;
        if (z) {
            n0();
        }
    }

    public final void v0(String backgroundUrl, View targetView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, backgroundUrl, targetView) == null) {
            Intrinsics.checkNotNullParameter(backgroundUrl, "backgroundUrl");
            Intrinsics.checkNotNullParameter(targetView, "targetView");
            w0(backgroundUrl, targetView, true);
        }
    }

    public static final void l0(String str, BackgroundSlice this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (str != null) {
                try {
                    this$0.s0().setBackgroundColor(Color.parseColor(str));
                } catch (Exception e) {
                    if (!TbadkCoreApplication.getInst().isDebugMode()) {
                        zq8 zq8Var = zq8.a;
                        zq8Var.a("BackgroundSlice 色值解析异常" + e.getMessage());
                        return;
                    }
                    throw new IllegalArgumentException("颜色解析异常");
                }
            }
        }
    }

    public final void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            AibotBgListBinding aibotBgListBinding = this.u;
            if (aibotBgListBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("botsBgViewBinding");
                aibotBgListBinding = null;
            }
            aibotBgListBinding.b.beginFakeDrag();
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice, com.baidu.tieba.im.base.core.slice.ability.LifecycleAbility
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onPause();
            this.r = true;
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice, com.baidu.tieba.im.base.core.slice.ability.LifecycleAbility
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            if (this.r && t0()) {
                kr8.a.c(1);
            }
        }
    }

    public final View r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            View view2 = this.l;
            if (view2 != null) {
                return view2;
            }
            Intrinsics.throwUninitializedPropertyAccessException("chatBgView");
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final View s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            View view2 = this.m;
            if (view2 != null) {
                return view2;
            }
            Intrinsics.throwUninitializedPropertyAccessException("personBgView");
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.p == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    public View U(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        InterceptResult invokeLLL;
        Integer pageSource;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, inflater, container, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            Intrinsics.checkNotNullParameter(container, "container");
            View view2 = new View(container.getContext());
            view2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            A0(view2);
            View view3 = new View(container.getContext());
            view3.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            z0(view3);
            boolean z = false;
            AibotBgListBinding c = AibotBgListBinding.c(inflater, container, false);
            Intrinsics.checkNotNullExpressionValue(c, "inflate(inflater, container, false)");
            this.u = c;
            AibotBgListBinding aibotBgListBinding = null;
            try {
                AibotBgListBinding aibotBgListBinding2 = this.u;
                if (aibotBgListBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("botsBgViewBinding");
                    aibotBgListBinding2 = null;
                }
                ViewPager2 viewPager2 = aibotBgListBinding2.b;
                Intrinsics.checkNotNullExpressionValue(viewPager2, "botsBgViewBinding.aibotBgPager");
                this.w = new fr8(viewPager2);
            } catch (Exception unused) {
                zq8.a.a("ViewPager2SlowScrollHelper 初始化异常");
            }
            this.v = new AibotBgAdapter(this);
            AibotBgListBinding aibotBgListBinding3 = this.u;
            if (aibotBgListBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("botsBgViewBinding");
                aibotBgListBinding3 = null;
            }
            ViewPager2 viewPager22 = aibotBgListBinding3.b;
            AibotBgAdapter aibotBgAdapter = this.v;
            if (aibotBgAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bgAdapter");
                aibotBgAdapter = null;
            }
            viewPager22.setAdapter(aibotBgAdapter);
            AibotBgListBinding aibotBgListBinding4 = this.u;
            if (aibotBgListBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("botsBgViewBinding");
                aibotBgListBinding4 = null;
            }
            aibotBgListBinding4.b.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback(this) { // from class: com.baidu.tieba.im.biz.aibot.backgroundslice.BackgroundSlice$onCreateView$3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BackgroundSlice a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                public void onPageScrollStateChanged(int i) {
                    AibotBgListBinding aibotBgListBinding5;
                    AibotBgAdapter aibotBgAdapter2;
                    yq8 yq8Var;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                        super.onPageScrollStateChanged(i);
                        if (i == 0) {
                            aibotBgListBinding5 = this.a.u;
                            AibotBgAdapter aibotBgAdapter3 = null;
                            if (aibotBgListBinding5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("botsBgViewBinding");
                                aibotBgListBinding5 = null;
                            }
                            int currentItem = aibotBgListBinding5.b.getCurrentItem();
                            aibotBgAdapter2 = this.a.v;
                            if (aibotBgAdapter2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("bgAdapter");
                            } else {
                                aibotBgAdapter3 = aibotBgAdapter2;
                            }
                            AibotChatDetail.BotList botList = (AibotChatDetail.BotList) ListUtils.getItem(aibotBgAdapter3.l(), currentItem);
                            if (botList != null) {
                                yq8Var = this.a.j;
                                yq8Var.v0(botList.getUk());
                            }
                        }
                    }
                }

                @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                public void onPageScrolled(int i, float f, int i2) {
                    yq8 yq8Var;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
                        super.onPageScrolled(i, f, i2);
                        yq8Var = this.a.j;
                        yq8Var.R();
                    }
                }
            });
            RelativeLayout relativeLayout = new RelativeLayout(container.getContext());
            relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            AibotArgs aibotArgs = this.k;
            if (aibotArgs != null && (pageSource = aibotArgs.getPageSource()) != null && pageSource.intValue() == 1) {
                z = true;
            }
            if (z) {
                AibotBgListBinding aibotBgListBinding5 = this.u;
                if (aibotBgListBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("botsBgViewBinding");
                } else {
                    aibotBgListBinding = aibotBgListBinding5;
                }
                relativeLayout.addView(aibotBgListBinding.getRoot());
            } else {
                relativeLayout.addView(r0());
                relativeLayout.addView(s0());
            }
            return relativeLayout;
        }
        return (View) invokeLLL.objValue;
    }

    public final void k0(final String str, final String str2, boolean z) {
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(1048583, this, str, str2, z) != null) || this.q) {
            return;
        }
        if (t0()) {
            if (str2 != null && str2.length() != 0) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                return;
            }
        }
        if (!t0()) {
            if (str != null && str.length() != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                return;
            }
        }
        this.q = true;
        this.n = str;
        this.o = str2;
        long j = 0;
        if (z) {
            j = 25;
        }
        if (t0()) {
            r0().setVisibility(4);
            s0().setVisibility(0);
            s0().postDelayed(new Runnable() { // from class: com.baidu.tieba.cr8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        BackgroundSlice.l0(str2, this);
                    }
                }
            }, j);
            kr8.a.c(1);
        } else {
            s0().setVisibility(4);
            r0().setVisibility(0);
        }
        r0().postDelayed(new Runnable() { // from class: com.baidu.tieba.er8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    BackgroundSlice.m0(str, this);
                }
            }
        }, j);
    }

    public final void w0(String str, View view2, boolean z) {
        RequestBuilder requestBuilder;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(1048595, this, str, view2, z) != null) || K() == null) {
            return;
        }
        RequestBuilder<Drawable> load = Glide.with(K()).load(Integer.valueOf(this.t));
        Intrinsics.checkNotNullExpressionValue(load, "with(this.host).load(DEFAULT_BG)");
        if (z) {
            if (str.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                return;
            }
            load = Glide.with(K()).load(str);
            Intrinsics.checkNotNullExpressionValue(load, "with(this.host).load(backgroundUrl)");
        }
        if (!UtilHelper.isFoldScreen() && !UtilHelper.isLargeScreen(TbadkCoreApplication.getInst())) {
            RequestBuilder centerCrop = load.centerCrop();
            Intrinsics.checkNotNullExpressionValue(centerCrop, "{\n            builder.centerCrop()\n        }");
            requestBuilder = centerCrop;
        } else {
            RequestBuilder transform = load.transform(new a());
            Intrinsics.checkNotNullExpressionValue(transform, "{\n            builder.tr…ansformation())\n        }");
            requestBuilder = transform;
        }
        requestBuilder.into((RequestBuilder) new b(view2, this));
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (t0()) {
                i5b.b(r0(), 240);
                i5b.d(s0(), 240);
                return;
            }
            i5b.b(s0(), 240);
            i5b.d(r0(), 240);
        }
    }

    public final Bitmap q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            AibotBgListBinding aibotBgListBinding = this.u;
            AibotBgListBinding aibotBgListBinding2 = null;
            if (aibotBgListBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("botsBgViewBinding");
                aibotBgListBinding = null;
            }
            aibotBgListBinding.b.buildDrawingCache();
            AibotBgListBinding aibotBgListBinding3 = this.u;
            if (aibotBgListBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("botsBgViewBinding");
            } else {
                aibotBgListBinding2 = aibotBgListBinding3;
            }
            return aibotBgListBinding2.b.getDrawingCache();
        }
        return (Bitmap) invokeV.objValue;
    }

    public final void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            AibotBgListBinding aibotBgListBinding = null;
            try {
                if (this.w == null) {
                    AibotBgListBinding aibotBgListBinding2 = this.u;
                    if (aibotBgListBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("botsBgViewBinding");
                        aibotBgListBinding2 = null;
                    }
                    aibotBgListBinding2.b.endFakeDrag();
                } else {
                    fr8 fr8Var = this.w;
                    Intrinsics.checkNotNull(fr8Var);
                    fr8Var.a();
                }
            } catch (Exception unused) {
                zq8.a.a("ViewPager2SlowScrollHelper", "endFakeDrag() 执行异常");
                AibotBgListBinding aibotBgListBinding3 = this.u;
                if (aibotBgListBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("botsBgViewBinding");
                    aibotBgListBinding3 = null;
                }
                aibotBgListBinding3.b.endFakeDrag();
            }
            AibotBgListBinding aibotBgListBinding4 = this.u;
            if (aibotBgListBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("botsBgViewBinding");
            } else {
                aibotBgListBinding = aibotBgListBinding4;
            }
            if (aibotBgListBinding.b.isFakeDragging()) {
                p0();
            }
        }
    }

    public final void x0(String uk) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, uk) == null) {
            Intrinsics.checkNotNullParameter(uk, "uk");
            AibotBgAdapter aibotBgAdapter = this.v;
            AibotBgListBinding aibotBgListBinding = null;
            if (aibotBgAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bgAdapter");
                aibotBgAdapter = null;
            }
            int n = aibotBgAdapter.n(uk);
            try {
                AibotBgListBinding aibotBgListBinding2 = this.u;
                if (aibotBgListBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("botsBgViewBinding");
                } else {
                    aibotBgListBinding = aibotBgListBinding2;
                }
                aibotBgListBinding.b.setCurrentItem(n, true);
            } catch (Exception unused) {
                zq8.a.a("BackgroundSlice", "location() 执行，drag状态异常");
            }
        }
    }

    public final void y0(String uk) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, uk) == null) {
            Intrinsics.checkNotNullParameter(uk, "uk");
            AibotBgAdapter aibotBgAdapter = this.v;
            AibotBgListBinding aibotBgListBinding = null;
            if (aibotBgAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bgAdapter");
                aibotBgAdapter = null;
            }
            int n = aibotBgAdapter.n(uk);
            AibotBgListBinding aibotBgListBinding2 = this.u;
            if (aibotBgListBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("botsBgViewBinding");
            } else {
                aibotBgListBinding = aibotBgListBinding2;
            }
            aibotBgListBinding.b.setCurrentItem(n, false);
        }
    }
}
