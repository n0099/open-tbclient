package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
/* loaded from: classes6.dex */
public class g56 extends fg1<mf0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements mf0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g56 c;

        /* renamed from: com.baidu.tieba.g56$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0295a implements of0 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a f;

            @Override // com.baidu.tieba.of0
            public String B() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "Tieba" : (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.of0
            public boolean C() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }

            @Override // com.baidu.tieba.of0
            public String q() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? "" : (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.of0
            public String s() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? "tieba" : (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.of0
            public String t() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? "2" : (String) invokeV.objValue;
            }

            public C0295a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f = aVar;
            }

            @Override // com.baidu.tieba.of0
            public String a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return h56.h().a();
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.of0
            public String b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                    return h56.h().l();
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.of0
            public String c() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                    return this.f.c.c();
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.of0
            public String d() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                    return h56.h().j();
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.of0
            public String e() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                    return h56.h().g();
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.of0
            public String f() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    return h56.h().i();
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.of0
            public String g() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                    return h56.h().d();
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.of0
            public String h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                    return h56.h().q();
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.of0
            public String i() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                    return h56.h().o();
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.of0
            public String k() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                    return h56.h().m();
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.of0
            public String m() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                    return h56.h().f();
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.of0
            public boolean o() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                    return PermissionUtil.isAgreePrivacyPolicy();
                }
                return invokeV.booleanValue;
            }

            @Override // com.baidu.tieba.of0
            public String p() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                    return h56.h().b();
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.of0
            public String r() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                    return h56.h().n();
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.of0
            public String u() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                    return h56.h().p();
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.of0
            @NonNull
            public String w() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                    return h56.h().e();
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.of0
            public String x() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                    return h56.h().c();
                }
                return (String) invokeV.objValue;
            }
        }

        public a(g56 g56Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g56Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = g56Var;
        }

        @Override // com.baidu.tieba.mf0
        @NonNull
        public of0 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new C0295a(this);
            }
            return (of0) invokeV.objValue;
        }
    }

    public g56() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.fg1
    /* renamed from: b */
    public mf0 createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (mf0) invokeV.objValue;
    }

    public final String c() {
        InterceptResult invokeV;
        byte[] b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String str = "";
            String string = SharedPrefHelper.getInstance().getString("key_last_cached_real_oid", "");
            if (!StringUtils.isNull(string)) {
                return string;
            }
            String k = h56.h().k();
            if (StringUtils.isNull(k)) {
                return "";
            }
            String[] split = k.split("-");
            if (split != null && split.length > 1) {
                String str2 = split[1];
                if (StringUtils.isNull(str2) || (b = new n00("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(str2)) == null) {
                    return "";
                }
                try {
                    str = new String(b, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                if (!StringUtils.isNull(str)) {
                    SharedPrefHelper.getInstance().putString("key_last_cached_real_oid", str);
                }
            }
            return str;
        }
        return (String) invokeV.objValue;
    }
}
