package com.baidu.tieba;

import com.baidu.adp.lib.network.http.IHttpNet;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class db {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean a;
    public int b;
    public int c;
    public String d;
    public String e;
    public String f;
    public String g;
    public Map<String, List<String>> h;
    public byte[] i;
    public int j;

    public db() {
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
        this.a = false;
        this.b = -1;
        this.c = -1;
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "net error";
    }

    public void a(IHttpNet iHttpNet) throws Exception {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, iHttpNet) != null) || iHttpNet == null) {
            return;
        }
        this.b = iHttpNet.getResponseCode();
        this.d = iHttpNet.getContentEncoding();
        this.e = iHttpNet.getContentType();
        this.f = iHttpNet.getContentLength() + "";
        this.h = iHttpNet.b();
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.b == 200) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
