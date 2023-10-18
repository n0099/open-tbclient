package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.tieba.bu1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
@Service
/* loaded from: classes6.dex */
public class i84 extends bu1 implements cn1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<bu1.a> a;

    public i84() {
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
    public static i84 c() {
        InterceptResult invokeV;
        m14 m14Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            y42 W = cr2.V().W();
            if (W == null || (m14Var = (m14) W.n(m14.class)) == null) {
                return null;
            }
            return m14Var.B3();
        }
        return (i84) invokeV.objValue;
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                Iterator<bu1.a> it = this.a.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
                this.a.clear();
            }
        }
    }

    @Override // com.baidu.tieba.cn1
    public bu1 getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return c();
        }
        return (bu1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bu1
    public synchronized void a(bu1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            synchronized (this) {
                if (!this.a.contains(aVar)) {
                    this.a.add(aVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.bu1
    public synchronized void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            synchronized (this) {
                Iterator<bu1.a> it = this.a.iterator();
                while (it.hasNext()) {
                    it.next().b(i);
                }
            }
        }
    }
}
