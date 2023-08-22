package com.baidu.tieba;

import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class b5a implements nb7, z77, lb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    @Override // com.baidu.tieba.lb7
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "position_from_1" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nb7
    public String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public static final class a implements q87 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b5a a;

        public a(b5a b5aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b5aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b5aVar;
        }

        @Override // com.baidu.tieba.q87
        public void a(Map<String, String> map) {
            String str;
            String str2;
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
                Intrinsics.checkNotNullParameter(map, "map");
                String str4 = map.get("thread_id");
                if (str4 == null) {
                    str4 = "";
                }
                String str5 = map.get("weight");
                if (str5 == null) {
                    str = "";
                } else {
                    str = str5;
                }
                String str6 = map.get("source");
                if (str6 == null) {
                    str2 = "";
                } else {
                    str2 = str6;
                }
                String str7 = map.get("position_from_1");
                if (str7 == null) {
                    str7 = "0";
                }
                String str8 = map.get("abtest_tag");
                if (str8 == null) {
                    str3 = "";
                } else {
                    str3 = str8;
                }
                dt6.b().b(new w3a(JavaTypesHelper.toLong(str4, 0L), str, str2, JavaTypesHelper.toInt(str7, 0), str3, JavaTypesHelper.toInt(this.a.a, 0)));
            }
        }
    }

    public b5a() {
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
        this.a = "";
    }

    @Override // com.baidu.tieba.z77
    public q87 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new a(this);
        }
        return (q87) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nb7
    public Map<String, String> a(a77 businessInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, businessInfo)) == null) {
            Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
            HashMap hashMap = new HashMap();
            hashMap.putAll(businessInfo.a());
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public final b5a f(String type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, type)) == null) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.a = type;
            return this;
        }
        return (b5a) invokeL.objValue;
    }
}
