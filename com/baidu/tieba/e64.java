package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.tieba.wr1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
@Service
/* loaded from: classes3.dex */
public class e64 extends wr1 implements xk1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<wr1.a> a;

    public e64() {
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
    public static e64 c() {
        InterceptResult invokeV;
        iz3 iz3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            u22 V = yo2.U().V();
            if (V == null || (iz3Var = (iz3) V.n(iz3.class)) == null) {
                return null;
            }
            return iz3Var.u3();
        }
        return (e64) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wr1
    public synchronized void a(wr1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            synchronized (this) {
                if (!this.a.contains(aVar)) {
                    this.a.add(aVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.wr1
    public synchronized void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            synchronized (this) {
                Iterator<wr1.a> it = this.a.iterator();
                while (it.hasNext()) {
                    it.next().b(i);
                }
            }
        }
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                Iterator<wr1.a> it = this.a.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
                this.a.clear();
            }
        }
    }

    @Override // com.baidu.tieba.xk1
    public wr1 getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? c() : (wr1) invokeV.objValue;
    }
}
