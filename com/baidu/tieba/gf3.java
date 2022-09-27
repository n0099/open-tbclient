package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes4.dex */
public final class gf3<ValueT> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public ValueT b;
    public a<ValueT> c;

    /* loaded from: classes4.dex */
    public interface a<ValueT> {
        ValueT update() throws IllegalStateException;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v1, resolved type: com.baidu.tieba.if3 */
    /* JADX WARN: Multi-variable type inference failed */
    public gf3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        if3.a().h(this);
    }

    public CharSequence a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ValueT valuet = this.b;
            return valuet == null ? "" : valuet.toString();
        }
        return (CharSequence) invokeV.objValue;
    }

    public gf3<ValueT> b(a<ValueT> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            this.c = aVar;
            update();
            return this;
        }
        return (gf3) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? String.format(Locale.getDefault(), "%s :: %s(%s)", super.toString(), this.a, a()) : (String) invokeV.objValue;
    }

    public boolean update() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? update((a) this.c) : invokeV.booleanValue;
    }

    public boolean update(a<ValueT> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) {
            if (aVar != null) {
                try {
                    return update((gf3<ValueT>) aVar.update());
                } catch (IllegalStateException e) {
                    l02.o("Tracer", "index update IllegalStateException " + e.getMessage());
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: com.baidu.tieba.if3 */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean update(ValueT valuet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, valuet)) == null) {
            this.b = valuet;
            if3.a().e(this);
            return true;
        }
        return invokeL.booleanValue;
    }
}
