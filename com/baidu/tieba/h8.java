package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
/* loaded from: classes4.dex */
public class h8 extends b7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Object[] e;
    public Object[] f;
    public int g;

    public h8() {
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

    @Override // com.baidu.tieba.b7
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            r();
            super.clear();
        }
    }

    @Override // com.baidu.tieba.b7
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            r();
            super.m();
        }
    }

    public Object[] p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            r();
            Object[] objArr = this.a;
            this.e = objArr;
            this.g++;
            return objArr;
        }
        return (Object[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.b7
    public Object pop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            r();
            return super.pop();
        }
        return invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h8(Class cls) {
        super(cls);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Class) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h8(boolean z, int i) {
        super(z, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Boolean) objArr2[0]).booleanValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.b7
    public Object i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            r();
            return super.i(i);
        }
        return invokeI.objValue;
    }

    @Override // com.baidu.tieba.b7
    public void sort(Comparator comparator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, comparator) == null) {
            r();
            super.sort(comparator);
        }
    }

    @Override // com.baidu.tieba.b7
    public void insert(int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, obj) == null) {
            r();
            super.insert(i, obj);
        }
    }

    @Override // com.baidu.tieba.b7
    public boolean j(Object obj, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, obj, z)) == null) {
            r();
            return super.j(obj, z);
        }
        return invokeLZ.booleanValue;
    }

    @Override // com.baidu.tieba.b7
    public void l(int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, obj) == null) {
            r();
            super.l(i, obj);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int max = Math.max(0, this.g - 1);
            this.g = max;
            Object[] objArr = this.e;
            if (objArr == null) {
                return;
            }
            if (objArr != this.a && max == 0) {
                this.f = objArr;
                int length = objArr.length;
                for (int i = 0; i < length; i++) {
                    this.f[i] = null;
                }
            }
            this.e = null;
        }
    }

    public final void r() {
        Object[] objArr;
        Object[] objArr2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (objArr = this.e) != null && objArr == (objArr2 = this.a)) {
            Object[] objArr3 = this.f;
            if (objArr3 != null) {
                int length = objArr3.length;
                int i = this.b;
                if (length >= i) {
                    System.arraycopy(objArr2, 0, objArr3, 0, i);
                    this.a = this.f;
                    this.f = null;
                    return;
                }
            }
            k(this.a.length);
        }
    }
}
