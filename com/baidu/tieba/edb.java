package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
/* loaded from: classes4.dex */
public class edb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ProductInfo a;
    public int b;
    public boolean c;
    public boolean d;
    public int e;
    public String f;

    public edb(ProductInfo productInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {productInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = Integer.MIN_VALUE;
        this.e = -1;
        this.a = productInfo;
    }

    public edb(ProductInfo productInfo, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {productInfo, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = Integer.MIN_VALUE;
        this.e = -1;
        this.a = productInfo;
        this.b = i;
    }

    public edb(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.b = Integer.MIN_VALUE;
        this.e = -1;
        this.c = z;
    }

    public double a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ProductInfo productInfo = this.a;
            if (productInfo != null) {
                return productInfo.destAmount / 100.0d;
            }
            return 0.0d;
        }
        return invokeV.doubleValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public double c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ProductInfo productInfo = this.a;
            if (productInfo != null) {
                return productInfo.srcAmount;
            }
            return 0.0d;
        }
        return invokeV.doubleValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        double d;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("PayAmount{currencyType=");
            sb.append(this.b);
            sb.append("splitDetailId=");
            sb.append(this.f);
            sb.append(", srcAmount=");
            ProductInfo productInfo = this.a;
            if (productInfo != null) {
                d = productInfo.srcAmount;
            } else {
                d = 0.0d;
            }
            sb.append(d);
            sb.append(", dstAmount=");
            ProductInfo productInfo2 = this.a;
            if (productInfo2 != null) {
                j = productInfo2.destAmount;
            } else {
                j = 0;
            }
            sb.append(j);
            sb.append('}');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
