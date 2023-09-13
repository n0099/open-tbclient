package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.tieba.sz1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
@Service
/* loaded from: classes5.dex */
public class ae4 extends sz1 implements ts1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<sz1.a> a;

    public ae4() {
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
        this.a = new ArrayList<>();
    }

    @Nullable
    public static ae4 c() {
        InterceptResult invokeV;
        e74 e74Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            qa2 U = uw2.T().U();
            if (U == null || (e74Var = (e74) U.n(e74.class)) == null) {
                return null;
            }
            return e74Var.w3();
        }
        return (ae4) invokeV.objValue;
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                Iterator<sz1.a> it = this.a.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
                this.a.clear();
            }
        }
    }

    @Override // com.baidu.tieba.ts1
    public sz1 getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return c();
        }
        return (sz1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sz1
    public synchronized void a(sz1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            synchronized (this) {
                if (!this.a.contains(aVar)) {
                    this.a.add(aVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.sz1
    public synchronized void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            synchronized (this) {
                Iterator<sz1.a> it = this.a.iterator();
                while (it.hasNext()) {
                    it.next().b(i);
                }
            }
        }
    }
}
