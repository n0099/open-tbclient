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
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.db8;
import com.baidu.tieba.im.base.core.slice.Slice;
import com.baidu.tieba.im.biz.aibot.backgroundslice.BackgroundSlice;
import com.baidu.tieba.im.biz.aibot.data.AibotChatDetail;
import com.baidu.tieba.mna;
import com.baidu.tieba.ta8;
import com.baidu.tieba.va8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.transition.Transition;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 62\u00020\u00012\u00020\u0002:\u000267B\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001d\u001a\u00020\tJ\u0006\u0010\u001e\u001a\u00020\u001aJ\b\u0010\u001f\u001a\u00020\tH\u0002J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\fH\u0002J\u0018\u0010 \u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\fH\u0002J \u0010 \u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\f2\u0006\u0010#\u001a\u00020\tH\u0002J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020&H\u0016J\"\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010.\u001a\u00020\u001aH\u0016J\b\u0010/\u001a\u00020\u001aH\u0016J\u0010\u00100\u001a\u00020\u001a2\u0006\u00101\u001a\u000202H\u0016J\u0018\u00103\u001a\u00020\u001a2\u0006\u00104\u001a\u00020\u00052\u0006\u00105\u001a\u00020\tH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010¨\u00068"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/backgroundslice/BackgroundSlice;", "Lcom/baidu/tieba/im/base/core/slice/Slice;", "Lcom/baidu/tieba/im/biz/aibot/IPageChangeNotify;", "()V", "DEFAULT_BG", "", "getDEFAULT_BG", "()I", "canLoadDefaultBg", "", "canStatPersonPageExp", "chatBgView", "Landroid/view/View;", "getChatBgView", "()Landroid/view/View;", "setChatBgView", "(Landroid/view/View;)V", "mChatBgUrl", "", "mPageState", "mPersonBgColor", "mPicBgLoaded", "personBgView", "getPersonBgView", "setPersonBgView", "bindData", "", "chatBgUrl", "personBgColor", "needDelayed", "changePageState", "isPersonPageState", "loadPicUrl", "targetView", "backgroundUrl", "fromNet", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", MissionEvent.MESSAGE_PAUSE, "onResume", "onSetChatDetail", "chatDetail", "Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail;", "onSetPageState", "state", "refreshPage", "Companion", "FitTopTransformation", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BackgroundSlice extends Slice implements va8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View j;
    public View k;
    public String l;
    public String m;
    public int n;
    public boolean o;
    public boolean p;
    public boolean q;
    public final int r;

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
                this$0.n0(targetView);
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
                if (this.b.q) {
                    this.b.q = false;
                    SafeHandler inst = SafeHandler.getInst();
                    final BackgroundSlice backgroundSlice = this.b;
                    final View view2 = this.a;
                    inst.post(new Runnable() { // from class: com.baidu.tieba.xa8
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

    public BackgroundSlice() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = 2;
        this.q = true;
        this.r = R.drawable.obfuscated_res_0x7f0802d7;
    }

    public final View k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            View view2 = this.j;
            if (view2 != null) {
                return view2;
            }
            Intrinsics.throwUninitializedPropertyAccessException("chatBgView");
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final View l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            View view2 = this.k;
            if (view2 != null) {
                return view2;
            }
            Intrinsics.throwUninitializedPropertyAccessException("personBgView");
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.n == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice, com.baidu.tieba.im.base.core.slice.ability.LifecycleAbility
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onPause();
            this.p = true;
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice, com.baidu.tieba.im.base.core.slice.ability.LifecycleAbility
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onResume();
            if (this.p && m0()) {
                db8.a.b(1);
            }
        }
    }

    @Override // com.baidu.tieba.va8
    public void J(AibotChatDetail chatDetail) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chatDetail) == null) {
            Intrinsics.checkNotNullParameter(chatDetail, "chatDetail");
            g0(chatDetail.getConfigData().getChatBackground(), chatDetail.getConfigData().getThemeColor(), false);
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    public void T(Configuration newConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, newConfig) == null) {
            Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            super.T(newConfig);
            this.o = false;
            this.q = true;
            g0(this.l, this.m, true);
        }
    }

    public final void n0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            p0("", view2, false);
        }
    }

    public final void q0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view2) == null) {
            Intrinsics.checkNotNullParameter(view2, "<set-?>");
            this.j = view2;
        }
    }

    public final void r0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view2) == null) {
            Intrinsics.checkNotNullParameter(view2, "<set-?>");
            this.k = view2;
        }
    }

    public static final void i0(String str, BackgroundSlice this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (str != null) {
                this$0.o0(str, this$0.k0());
            }
        }
    }

    @Override // com.baidu.tieba.va8
    public void D1(int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) != null) || this.n == i) {
            return;
        }
        this.n = i;
        if (z) {
            j0();
        }
    }

    public final void o0(String str, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, view2) == null) {
            p0(str, view2, true);
        }
    }

    public static final void h0(String str, BackgroundSlice this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, str, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (str != null) {
                try {
                    this$0.l0().setBackgroundColor(Color.parseColor(str));
                } catch (Exception e) {
                    if (!TbadkCoreApplication.getInst().isDebugMode()) {
                        ta8 ta8Var = ta8.a;
                        ta8Var.a("BackgroundSlice 色值解析异常" + e.getMessage());
                        return;
                    }
                    throw new IllegalArgumentException("颜色解析异常");
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    public View U(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, inflater, container, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            Intrinsics.checkNotNullParameter(container, "container");
            View view2 = new View(container.getContext());
            view2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            r0(view2);
            View view3 = new View(container.getContext());
            view3.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            q0(view3);
            RelativeLayout relativeLayout = new RelativeLayout(container.getContext());
            relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            relativeLayout.addView(k0());
            relativeLayout.addView(l0());
            return relativeLayout;
        }
        return (View) invokeLLL.objValue;
    }

    public final void g0(final String str, final String str2, boolean z) {
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(1048580, this, str, str2, z) != null) || this.o) {
            return;
        }
        if (m0()) {
            if (str2 != null && str2.length() != 0) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                return;
            }
        }
        if (!m0()) {
            if (str != null && str.length() != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                return;
            }
        }
        this.o = true;
        this.l = str;
        this.m = str2;
        long j = 0;
        if (z) {
            j = 25;
        }
        if (m0()) {
            k0().setVisibility(4);
            l0().setVisibility(0);
            l0().postDelayed(new Runnable() { // from class: com.baidu.tieba.wa8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        BackgroundSlice.h0(str2, this);
                    }
                }
            }, j);
            db8.a.b(1);
        } else {
            l0().setVisibility(4);
            k0().setVisibility(0);
        }
        k0().postDelayed(new Runnable() { // from class: com.baidu.tieba.ya8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    BackgroundSlice.i0(str, this);
                }
            }
        }, j);
    }

    public final void p0(String str, View view2, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048589, this, str, view2, z) == null) {
            RequestBuilder<Drawable> load = Glide.with(M()).load(Integer.valueOf(this.r));
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
                load = Glide.with(M()).load(str);
                Intrinsics.checkNotNullExpressionValue(load, "with(this.host).load(backgroundUrl)");
            }
            if (UtilHelper.isFoldScreen() || UtilHelper.isLargeScreen(TbadkCoreApplication.getInst())) {
                Cloneable transform = load.transform(new a());
                Intrinsics.checkNotNullExpressionValue(transform, "builder.transform(FitTopTransformation())");
                load = (RequestBuilder) transform;
            }
            load.into((RequestBuilder<Drawable>) new b(view2, this));
        }
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (m0()) {
                mna.b(k0(), 240);
                mna.d(l0(), 240);
                return;
            }
            mna.b(l0(), 240);
            mna.d(k0(), 240);
        }
    }
}
