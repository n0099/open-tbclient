package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.write.editor.EditorInfoContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bfa extends gi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bfa(Context context, String str) {
        super(context, (String) null, 15);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = false;
        this.t = context;
        this.n = 3;
        this.m = new EditorInfoContainer(context, str);
        this.p = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54, 57, 65};
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            hi5 hi5Var = this.m;
            if (hi5Var instanceof EditorInfoContainer) {
                ((EditorInfoContainer) hi5Var).m();
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            hi5 hi5Var = this.m;
            if (hi5Var instanceof EditorInfoContainer) {
                ((EditorInfoContainer) hi5Var).n();
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            hi5 hi5Var = this.m;
            if (hi5Var instanceof EditorInfoContainer) {
                ((EditorInfoContainer) hi5Var).o();
            }
        }
    }

    public void j(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, str, i) == null) {
            hi5 hi5Var = this.m;
            if (hi5Var instanceof EditorInfoContainer) {
                ((EditorInfoContainer) hi5Var).t(str, i);
            }
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            hi5 hi5Var = this.m;
            if (hi5Var instanceof EditorInfoContainer) {
                ((EditorInfoContainer) hi5Var).u(i);
            }
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            hi5 hi5Var = this.m;
            if (hi5Var instanceof EditorInfoContainer) {
                ((EditorInfoContainer) hi5Var).w(z);
            }
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            hi5 hi5Var = this.m;
            if (hi5Var instanceof EditorInfoContainer) {
                ((EditorInfoContainer) hi5Var).setFrom(str);
            }
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            hi5 hi5Var = this.m;
            if (hi5Var instanceof EditorInfoContainer) {
                ((EditorInfoContainer) hi5Var).A(z);
            }
        }
    }
}
