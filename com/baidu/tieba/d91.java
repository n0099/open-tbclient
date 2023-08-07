package com.baidu.tieba;

import android.app.Activity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
import com.baidu.tieba.ga1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public abstract class d91 implements x91 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract boolean c(@NonNull f91 f91Var, @NonNull String str);

    public abstract void d(@NonNull f91 f91Var, @NonNull String str);

    /* loaded from: classes5.dex */
    public static class a implements f91 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final w91 a;

        public a(w91 w91Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w91Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w91Var;
        }

        @Override // com.baidu.tieba.w91
        public boolean a(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                return this.a.a(str);
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.w91
        @Nullable
        public Activity b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a.b();
            }
            return (Activity) invokeV.objValue;
        }

        @Override // com.baidu.tieba.w91
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.a.c();
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.w91
        @Nullable
        public LinearLayout g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.a.g();
            }
            return (LinearLayout) invokeV.objValue;
        }

        @Override // com.baidu.tieba.w91
        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.h();
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.w91
        @Nullable
        public FrameLayout j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.a.j();
            }
            return (FrameLayout) invokeV.objValue;
        }

        @Override // com.baidu.tieba.w91
        @Nullable
        public ga1.d l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.a.l();
            }
            return (ga1.d) invokeV.objValue;
        }

        @Override // com.baidu.tieba.w91
        @Nullable
        public AbsNadBrowserView m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.a.m();
            }
            return (AbsNadBrowserView) invokeV.objValue;
        }
    }

    public d91() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.x91
    public final boolean a(@NonNull w91 w91Var, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, w91Var, str)) == null) {
            return c(new a(w91Var), str);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.x91
    public final void b(@NonNull w91 w91Var, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, w91Var, str) == null) {
            d(new a(w91Var), str);
        }
    }
}
