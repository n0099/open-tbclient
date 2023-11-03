package com.baidu.tieba.im.base.core.slice;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.download.util.LocalFilesFilterKt;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.im.base.core.slice.ability.LifecycleAbility;
import com.baidu.tieba.km8;
import com.baidu.tieba.lm8;
import com.baidu.tieba.mm8;
import com.baidu.tieba.nm8;
import com.baidu.tieba.om8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u0005¢\u0006\u0002\u0010\u0007J\u0018\u00102\u001a\u0002032\u0006\u00104\u001a\u00020!2\u0006\u00105\u001a\u00020\u0000H\u0016J1\u00106\u001a\u0002032\u0006\u0010\b\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00002\u0006\u00104\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0000¢\u0006\u0002\b7J\u0010\u00108\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u0000H\u0016J#\u00109\u001a\u0002H:\"\n\b\u0000\u0010:*\u0004\u0018\u00010'2\b\b\u0001\u0010;\u001a\u00020\u0016H\u0016¢\u0006\u0002\u0010<J\b\u0010=\u001a\u00020>H\u0016J\u0010\u0010?\u001a\u0002032\u0006\u00105\u001a\u00020\u0000H\u0016J\u0010\u0010@\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u0000H\u0016J\u0011\u0010A\u001a\u0002032\u0006\u0010B\u001a\u00020CH\u0096\u0001J\u0011\u0010D\u001a\u0002032\u0006\u0010B\u001a\u00020CH\u0096\u0001J\u0011\u0010D\u001a\u0002032\u0006\u0010E\u001a\u00020FH\u0096\u0001J\b\u0010G\u001a\u000203H\u0016J\"\u0010H\u001a\u0002032\u0006\u0010I\u001a\u00020\u00162\u0006\u0010J\u001a\u00020\u00162\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\u0010\u0010M\u001a\u0002032\u0006\u0010N\u001a\u00020\u000fH\u0016J\u0010\u0010O\u001a\u0002032\u0006\u0010P\u001a\u00020\u0016H\u0016J\u0010\u0010Q\u001a\u0002032\u0006\u0010R\u001a\u00020SH\u0016J\b\u0010T\u001a\u000203H\u0016J$\u0010U\u001a\u0004\u0018\u00010'2\u0006\u0010V\u001a\u00020W2\u0006\u00104\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010X\u001a\u000203H\u0016J\b\u0010Y\u001a\u000203H\u0016J\u0018\u0010Z\u001a\u00020\u000f2\u0006\u0010[\u001a\u00020\u00162\u0006\u0010\\\u001a\u00020]H\u0016J\u0010\u0010^\u001a\u0002032\u0006\u0010_\u001a\u00020\u000fH\u0016J\b\u0010`\u001a\u000203H\u0016J\u0018\u0010a\u001a\u0002032\u0006\u0010b\u001a\u00020\u00022\u0006\u0010\\\u001a\u00020cH\u0016J\b\u0010d\u001a\u000203H\u0016J\b\u0010e\u001a\u000203H\u0016J\b\u0010f\u001a\u000203H\u0016J\b\u0010g\u001a\u000203H\u0016J+\u0010h\u001a\u0002032\u0006\u0010I\u001a\u00020\u00162\f\u0010i\u001a\b\u0012\u0004\u0012\u00020C0j2\u0006\u0010k\u001a\u00020lH\u0016¢\u0006\u0002\u0010mJ\b\u0010n\u001a\u000203H\u0016J\u0010\u0010o\u001a\u0002032\u0006\u0010p\u001a\u00020#H\u0016J\u0010\u0010q\u001a\u0002032\u0006\u0010r\u001a\u00020\u000fH\u0016J\b\u0010s\u001a\u000203H\u0016J\b\u0010t\u001a\u000203H\u0016J\u001c\u0010u\u001a\u0002032\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010v\u001a\u0002032\u0006\u00105\u001a\u00020\u0000H\u0016J!\u0010w\u001a\u0002H:\"\b\b\u0000\u0010:*\u00020'2\b\b\u0001\u0010;\u001a\u00020\u0016H\u0016¢\u0006\u0002\u0010<J\u0011\u0010x\u001a\u0002032\u0006\u0010y\u001a\u00020CH\u0096\u0001J\u0010\u0010z\u001a\u0002032\u0006\u00105\u001a\u00020\u0000H\u0016R\u001a\u0010\b\u001a\u00020\tX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0000X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b.\u0010/¨\u0006{"}, d2 = {"Lcom/baidu/tieba/im/base/core/slice/Slice;", "Lcom/baidu/tieba/im/base/core/slice/ability/LifecycleAbility;", "Landroidx/lifecycle/LifecycleOwner;", "Lcom/baidu/tieba/im/base/core/slice/ability/LogAbility;", "Lcom/baidu/tieba/im/base/core/slice/ability/ViewAbility;", "Lcom/baidu/tieba/im/base/core/slice/ability/SysEventAbility;", "Lcom/baidu/tieba/im/base/core/slice/ability/OpAbility;", "()V", "host", "Lcom/baidu/tieba/im/base/core/slice/SliceFragment;", "getHost", "()Lcom/baidu/tieba/im/base/core/slice/SliceFragment;", "setHost", "(Lcom/baidu/tieba/im/base/core/slice/SliceFragment;)V", "isBackground", "", "()Z", "setBackground", "(Z)V", "isScreenLocked", "setScreenLocked", "lastSkinType", "", "getLastSkinType", "()I", "setLastSkinType", "(I)V", "parent", "getParent", "()Lcom/baidu/tieba/im/base/core/slice/Slice;", "setParent", "(Lcom/baidu/tieba/im/base/core/slice/Slice;)V", "parentContainer", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "sliceManager", "Lcom/baidu/tieba/im/base/core/slice/SliceManager;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "viewAbility", "Lcom/baidu/tieba/im/base/core/slice/ability/ViewAbility$Impl;", "getViewAbility", "()Lcom/baidu/tieba/im/base/core/slice/ability/ViewAbility$Impl;", "viewAbility$delegate", "Lkotlin/Lazy;", "addChild", "", "container", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "attach", "attach$im_base_core_release", "contains", "findViewById", ExifInterface.GPS_DIRECTION_TRUE, "id", "(I)Landroid/view/View;", "getLifecycle", "Landroidx/lifecycle/LifecycleRegistry;", "hideChild", "isShowing", "logD", LocalFilesFilterKt.FILTER_NAME_LOG, "", "logE", "throwable", "", "onActivityFinish", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackgroundSwitched", NotificationCompat.WearableExtender.KEY_BACKGROUND, "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", MissionEvent.MESSAGE_DESTROY, "onDestroyView", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyboardVisibilityChanged", MapBundleKey.MapObjKey.OBJ_SL_VISI, MissionEvent.MESSAGE_PAUSE, "onPostAny", "owner", "Landroidx/lifecycle/Lifecycle$Event;", "onPostCreate", "onPostDestroy", "onPreCreate", "onPreDestroy", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onSaveInstanceState", "outState", "onScreenLocked", "locked", "onStart", MissionEvent.MESSAGE_STOP, "onViewCreated", "removeChild", "requireViewById", "setTag", "tag", "showChild", "im-base-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public class Slice extends LifecycleAbility implements LifecycleOwner, mm8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ lm8 a;
    public SliceFragment b;
    public Slice c;
    public ViewGroup d;
    public Bundle e;
    public View f;
    public final km8 g;
    public int h;
    public boolean i;

    public void P(String log) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, log) == null) {
            Intrinsics.checkNotNullParameter(log, "log");
            this.a.a(log);
        }
    }

    public Slice() {
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
        this.a = new lm8(null, 1, null);
        LazyKt__LazyJVMKt.lazy(new Function0<nm8>(this) { // from class: com.baidu.tieba.im.base.core.slice.Slice$viewAbility$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Slice this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final nm8 invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    if (this.this$0.M() != null) {
                        View M = this.this$0.M();
                        Intrinsics.checkNotNull(M);
                        return new nm8(M);
                    }
                    throw new IllegalArgumentException("视图为空，不能进行相关操作".toString());
                }
                return (nm8) invokeV.objValue;
            }
        });
        this.g = new km8(this);
        this.h = -1;
    }

    @Override // com.baidu.tieba.im.base.core.slice.ability.LifecycleAbility
    public void B(LifecycleOwner owner, Lifecycle.Event event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, owner, event) == null) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            Intrinsics.checkNotNullParameter(event, "event");
            super.B(owner, event);
            this.g.c(event);
        }
    }

    public void I(ViewGroup container, Slice child) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, container, child) == null) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(child, "child");
            child.J(K(), this, container, this.e);
            this.g.a(container, child);
        }
    }

    public void a0(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, view2, bundle) == null) {
            P("onViewCreated:" + getClass().getSimpleName());
        }
    }

    public boolean onKeyDown(int i, KeyEvent event) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048604, this, i, event)) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            mm8.a.e(this, i, event);
            return this.g.i(i, event);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tieba.im.base.core.slice.ability.LifecycleAbility
    public void C() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.C();
            P("onPostCreate:" + getClass().getSimpleName());
            LayoutInflater layoutInflater = K().getLayoutInflater();
            Intrinsics.checkNotNullExpressionValue(layoutInflater, "host.layoutInflater");
            ViewGroup viewGroup = this.d;
            ViewGroup viewGroup2 = null;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("parentContainer");
                viewGroup = null;
            }
            View U = U(layoutInflater, viewGroup, this.e);
            this.f = U;
            ViewGroup viewGroup3 = this.d;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("parentContainer");
                viewGroup3 = null;
            }
            if (!Intrinsics.areEqual(U, viewGroup3) && this.f != null) {
                ViewGroup viewGroup4 = this.d;
                if (viewGroup4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("parentContainer");
                } else {
                    viewGroup2 = viewGroup4;
                }
                viewGroup2.addView(this.f);
            }
            a0(this.f, this.e);
            Slice slice = this.c;
            if (slice != null && (i = slice.h) != -1 && this.h == -1) {
                onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.ability.LifecycleAbility
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.D();
            P("onPostDestroy:" + getClass().getSimpleName());
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.ability.LifecycleAbility
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.F();
            P("onPreCreate:" + getClass().getSimpleName());
        }
    }

    public final SliceFragment K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            SliceFragment sliceFragment = this.b;
            if (sliceFragment != null) {
                return sliceFragment;
            }
            Intrinsics.throwUninitializedPropertyAccessException("host");
            return null;
        }
        return (SliceFragment) invokeV.objValue;
    }

    public final View M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    public final boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            mm8.a.a(this);
            this.g.h();
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            P("onDestroyView:" + getClass().getSimpleName());
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.ability.LifecycleAbility
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onDestroy();
            P("onDestroy:" + getClass().getSimpleName());
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.ability.LifecycleAbility
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onPause();
            P("onPause:" + getClass().getSimpleName());
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.ability.LifecycleAbility
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onResume();
            P("onResume:" + getClass().getSimpleName());
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.ability.LifecycleAbility
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.onStart();
            P("onStart:" + getClass().getSimpleName());
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.ability.LifecycleAbility
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            super.onStop();
            P("onStop:" + getClass().getSimpleName());
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.ability.LifecycleAbility
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.w();
            P("onCreate:" + getClass().getSimpleName());
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.ability.LifecycleAbility
    public void G() {
        ViewParent viewParent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.G();
            P("onPreDestroy:" + getClass().getSimpleName());
            V();
            View view2 = this.f;
            ViewGroup viewGroup = null;
            if (view2 != null) {
                viewParent = view2.getParent();
            } else {
                viewParent = null;
            }
            if (viewParent instanceof ViewGroup) {
                viewGroup = (ViewGroup) viewParent;
            }
            if (viewGroup != null) {
                viewGroup.removeView(this.f);
            }
        }
    }

    public final void J(SliceFragment host, Slice slice, ViewGroup container, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, host, slice, container, bundle) == null) {
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(container, "container");
            om8.a.a();
            b0(host);
            this.c = slice;
            this.d = container;
            this.e = bundle;
            if (slice == null) {
                host.getLifecycle().addObserver(this);
            }
        }
    }

    public void R(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048588, this, i, i2, intent) == null) {
            mm8.a.b(this, i, i2, intent);
            this.g.d(i, i2, intent);
        }
    }

    public void X(int i, String[] permissions, int[] grantResults) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048594, this, i, permissions, grantResults) == null) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Intrinsics.checkNotNullParameter(grantResults, "grantResults");
            mm8.a.g(this, i, permissions, grantResults);
            this.g.k(i, permissions, grantResults);
        }
    }

    public void S(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            mm8.a.c(this, z);
            this.g.e(z);
        }
    }

    public void T(Configuration newConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, newConfig) == null) {
            Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            this.g.g(newConfig);
        }
    }

    public void W(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            mm8.a.f(this, z);
            this.g.j(z);
        }
    }

    public void Y(Bundle outState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, outState) == null) {
            Intrinsics.checkNotNullParameter(outState, "outState");
            mm8.a.h(this, outState);
            this.g.l(outState);
        }
    }

    public void Z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            mm8.a.i(this, z);
            this.i = z;
            this.g.m(z);
        }
    }

    public final void b0(SliceFragment sliceFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, sliceFragment) == null) {
            Intrinsics.checkNotNullParameter(sliceFragment, "<set-?>");
            this.b = sliceFragment;
        }
    }

    public final void c0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, view2) == null) {
            this.f = view2;
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048602, this, i) != null) || this.h == i) {
            return;
        }
        this.h = i;
        mm8.a.d(this, i);
        this.g.f(i);
    }

    public View U(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, inflater, container, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            Intrinsics.checkNotNullParameter(container, "container");
            P("onCreateView:" + getClass().getSimpleName());
            return null;
        }
        return (View) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.lifecycle.LifecycleOwner
    public LifecycleRegistry getLifecycle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.g.b();
        }
        return (LifecycleRegistry) invokeV.objValue;
    }
}
