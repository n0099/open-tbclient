package com.baidu.tieba.im.base.core.slice;

import android.content.Intent;
import android.view.KeyEvent;
import androidx.annotation.CallSuper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0017J\"\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0015J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0004H\u0015J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0017J+\u0010\u0013\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0017¢\u0006\u0002\u0010\u0019J \u0010\u001a\u001a\u00020\u0006*\u00020\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00060\u001dH\u0002J \u0010\u001f\u001a\u00020\u000f*\u00020\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u000f0\u001dH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/baidu/tieba/im/base/core/slice/SliceActivity;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "()V", "lastSkinType", "", "finish", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "recursiveEachFragment", "Landroidx/fragment/app/FragmentManager;", "action", "Lkotlin/Function1;", "Landroidx/fragment/app/Fragment;", "recursiveEachFragmentWithStop", "im-base-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class SliceActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    public SliceActivity() {
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
        this.a = -1;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    @CallSuper
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.finish();
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            o1(supportFragmentManager, SliceActivity$finish$1.INSTANCE);
        }
    }

    public final void o1(FragmentManager fragmentManager, Function1<? super Fragment, Unit> function1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragmentManager, function1) == null) {
            for (Fragment it : fragmentManager.getFragments()) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                function1.invoke(it);
                FragmentManager childFragmentManager = it.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "it.childFragmentManager");
                o1(childFragmentManager, function1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    @CallSuper
    public void onActivityResult(final int i, final int i2, final Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            o1(supportFragmentManager, new Function1<Fragment, Unit>(i, i2, intent) { // from class: com.baidu.tieba.im.base.core.slice.SliceActivity$onActivityResult$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ Intent $data;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int $requestCode;
                public final /* synthetic */ int $resultCode;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), intent};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$requestCode = i;
                    this.$resultCode = i2;
                    this.$data = intent;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Fragment fragment) {
                    invoke2(fragment);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Fragment it) {
                    BaseFragment baseFragment;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, it) == null) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        if (it instanceof BaseFragment) {
                            baseFragment = (BaseFragment) it;
                        } else {
                            baseFragment = null;
                        }
                        if (baseFragment != null) {
                            baseFragment.onActivityResult(this.$requestCode, this.$resultCode, this.$data);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    @CallSuper
    public void onRequestPermissionsResult(final int i, final String[] permissions, final int[] grantResults) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i, permissions, grantResults) == null) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Intrinsics.checkNotNullParameter(grantResults, "grantResults");
            super.onRequestPermissionsResult(i, permissions, grantResults);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            o1(supportFragmentManager, new Function1<Fragment, Unit>(i, permissions, grantResults) { // from class: com.baidu.tieba.im.base.core.slice.SliceActivity$onRequestPermissionsResult$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int[] $grantResults;
                public final /* synthetic */ String[] $permissions;
                public final /* synthetic */ int $requestCode;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Integer.valueOf(i), permissions, grantResults};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$requestCode = i;
                    this.$permissions = permissions;
                    this.$grantResults = grantResults;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Fragment fragment) {
                    invoke2(fragment);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Fragment it) {
                    BaseFragment baseFragment;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, it) == null) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        if (it instanceof BaseFragment) {
                            baseFragment = (BaseFragment) it;
                        } else {
                            baseFragment = null;
                        }
                        if (baseFragment != null) {
                            baseFragment.onRequestPermissionsResult(this.$requestCode, this.$permissions, this.$grantResults);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    @CallSuper
    public void onChangeSkinType(final int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || this.a == i) {
            return;
        }
        this.a = i;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        o1(supportFragmentManager, new Function1<Fragment, Unit>(i) { // from class: com.baidu.tieba.im.base.core.slice.SliceActivity$onChangeSkinType$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int $skinType;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Integer.valueOf(i)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super(((Integer) newInitContext.callArgs[0]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.$skinType = i;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Fragment fragment) {
                invoke2(fragment);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Fragment it) {
                BaseFragment baseFragment;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, it) == null) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (it instanceof BaseFragment) {
                        baseFragment = (BaseFragment) it;
                    } else {
                        baseFragment = null;
                    }
                    if (baseFragment != null) {
                        baseFragment.onChangeSkinType(this.$skinType);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    @CallSuper
    public boolean onKeyDown(final int i, final KeyEvent event) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048580, this, i, event)) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            if (q1(supportFragmentManager, new Function1<Fragment, Boolean>(i, event) { // from class: com.baidu.tieba.im.base.core.slice.SliceActivity$onKeyDown$isConsumed$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ KeyEvent $event;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int $keyCode;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Integer.valueOf(i), event};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$keyCode = i;
                    this.$event = event;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Fragment it) {
                    InterceptResult invokeL;
                    boolean z;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, it)) == null) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        if ((it instanceof BaseFragment) && ((BaseFragment) it).onKeyDown(this.$keyCode, this.$event)) {
                            z = true;
                        } else {
                            z = false;
                        }
                        return Boolean.valueOf(z);
                    }
                    return (Boolean) invokeL.objValue;
                }
            })) {
                return true;
            }
            return super.onKeyDown(i, event);
        }
        return invokeIL.booleanValue;
    }

    public final boolean q1(FragmentManager fragmentManager, Function1<? super Fragment, Boolean> function1) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, fragmentManager, function1)) == null) {
            for (Fragment it : fragmentManager.getFragments()) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (function1.invoke(it).booleanValue()) {
                    return true;
                }
                FragmentManager childFragmentManager = it.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "it.childFragmentManager");
                if (q1(childFragmentManager, function1)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
