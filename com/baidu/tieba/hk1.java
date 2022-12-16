package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.identifier.IdentifierIdClient;
/* loaded from: classes4.dex */
public class hk1 implements yj1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gk1 a;
    public String b;
    public Context c;
    public fk1 d;

    public hk1() {
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

    @Override // com.baidu.tieba.yj1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.b)) {
                this.b = this.a.a(0, null);
            }
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yj1
    public void a(Context context, zj1 zj1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, zj1Var) == null) {
            this.a = new gk1(context);
            this.c = context;
            if (b()) {
                this.d = new fk1(this);
                context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, this.d);
            }
            if (zj1Var != null) {
                zj1Var.a();
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                str = (String) cls.getMethod("get", String.class, String.class).invoke(cls, IdentifierIdClient.SYS_IDENTIFIERID_SUPPORTED, "0");
            } catch (Throwable unused) {
                str = null;
            }
            if ("1".equals(str)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
