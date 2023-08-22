package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.Animatable;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
/* loaded from: classes6.dex */
public final class i72 extends l62<SimpleDraweeView, j72> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h72 i;
    public SwanAppComponentContainerView j;
    public SimpleDraweeView k;

    /* loaded from: classes6.dex */
    public class a extends BaseControllerListener<ImageInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ SimpleDraweeView b;
        public final /* synthetic */ i72 c;

        public a(i72 i72Var, boolean z, SimpleDraweeView simpleDraweeView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i72Var, Boolean.valueOf(z), simpleDraweeView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = i72Var;
            this.a = z;
            this.b = simpleDraweeView;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFailure(String str, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, th) == null) {
                super.onFailure(str, th);
                if (this.a && this.c.i != null) {
                    this.c.i.a(0, this.b, null);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, imageInfo, animatable) == null) {
                super.onFinalImageSet(str, (String) imageInfo, animatable);
                if (this.a && this.c.i != null) {
                    this.c.i.a(1, this.b, null);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i72(@NonNull Context context, @NonNull j72 j72Var) {
        super(context, j72Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, j72Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (m62) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        g(4);
        this.j = new SwanAppComponentContainerView(context);
        this.k = new SimpleDraweeView(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.s62
    @NonNull
    /* renamed from: a0 */
    public SimpleDraweeView v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) {
            return this.k;
        }
        return (SimpleDraweeView) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.s62
    /* renamed from: b0 */
    public void A(@NonNull SimpleDraweeView simpleDraweeView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, simpleDraweeView) == null) {
            super.A(simpleDraweeView);
            simpleDraweeView.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
        }
    }

    public void e0(h72 h72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, h72Var) == null) {
            this.i = h72Var;
        }
    }

    @Override // com.baidu.tieba.s62
    @NonNull
    public SwanAppComponentContainerView u(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, context)) == null) {
            return this.j;
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.l62
    /* renamed from: c0 */
    public void T(@NonNull SimpleDraweeView simpleDraweeView, @NonNull j72 j72Var, @NonNull v72 v72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, simpleDraweeView, j72Var, v72Var) == null) {
            super.O(simpleDraweeView, j72Var, v72Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.l62, com.baidu.tieba.q62, com.baidu.tieba.s62
    @NonNull
    /* renamed from: Y */
    public v72 k(@NonNull j72 j72Var, @NonNull j72 j72Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, j72Var, j72Var2)) == null) {
            v72 k = super.k(j72Var, j72Var2);
            if (j72Var.u != j72Var2.u) {
                k.b(9);
            }
            return k;
        }
        return (v72) invokeLL.objValue;
    }

    public final BaseControllerListener<ImageInfo> Z(@NonNull SimpleDraweeView simpleDraweeView, @NonNull j72 j72Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, simpleDraweeView, j72Var)) == null) {
            return new a(this, j72Var.u, simpleDraweeView);
        }
        return (BaseControllerListener) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.l62
    /* renamed from: d0 */
    public void U(@NonNull SimpleDraweeView simpleDraweeView, @NonNull j72 j72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, simpleDraweeView, j72Var) == null) {
            super.V(simpleDraweeView, j72Var, Z(simpleDraweeView, j72Var));
        }
    }
}
