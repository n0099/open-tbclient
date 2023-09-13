package com.baidu.tieba;

import android.text.TextUtils;
import android.util.ArrayMap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.multidelmenu.model.MultiDelPostNetModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes6.dex */
public class i16 extends g16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, j16> b;
    public h16 c;
    public String d;
    public String e;

    /* loaded from: classes6.dex */
    public class a extends i9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i16 a;

        public a(i16 i16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i16Var;
        }

        @Override // com.baidu.tieba.i9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof l16)) {
                this.a.j((l16) obj);
            }
        }
    }

    public i16(h16 h16Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h16Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ArrayMap();
        this.c = h16Var;
    }

    @Override // com.baidu.tieba.g16
    public h16 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (h16) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g16
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b.size();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.g16
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MultiDelPostNetModel multiDelPostNetModel = new MultiDelPostNetModel();
            k16 k16Var = new k16();
            for (j16 j16Var : this.b.values()) {
                k16Var.d(j16Var.a());
                k16Var.e(j16Var.c());
                k16Var.b(this.d);
                k16Var.c(this.e);
                k16Var.a(j16Var.b());
            }
            multiDelPostNetModel.T(k16Var);
            multiDelPostNetModel.setLoadDataCallBack(new a(this));
            multiDelPostNetModel.loadData();
        }
    }

    @Override // com.baidu.tieba.g16
    public void f(j16 j16Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, j16Var) == null) && j16Var != null && !TextUtils.isEmpty(j16Var.b())) {
            this.b.put(j16Var.b(), j16Var);
        }
    }

    @Override // com.baidu.tieba.g16
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.d = str;
        }
    }

    @Override // com.baidu.tieba.g16
    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.e = str;
        }
    }

    @Override // com.baidu.tieba.g16
    public void i(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && !TextUtils.isEmpty(str)) {
            this.b.remove(str);
        }
    }

    public void j(l16 l16Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, l16Var) == null) && d() != null) {
            d().h(l16Var);
        }
    }
}
