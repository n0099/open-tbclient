package com.baidu.tbadk.util;

import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.iq5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import java.util.HashMap;
@Keep
/* loaded from: classes3.dex */
public class AdExtParam {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_AD_CONTEXT_LIST = "ad_context_list";
    public static final String KEY_FLOOR_INFO = "floor_info";
    public static final String KEY_FORUM_NAME = "forum_name";
    public static final String KEY_IADEX = "iadex";
    public static final String KEY_NAD_CORE_VERSION = "nad_core_version";
    public static final String KEY_REQUEST_TYPE = "requestType";
    public static final String KEY_SHOUBAI_CUID = "shoubai_cuid";
    public static final String KEY_THREAD_COUNT = "pre_ad_thread_count";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HashMap a;

        public a() {
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

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    return new Gson().toJson(this.a);
                } catch (Exception unused) {
                    return "";
                }
            }
            return (String) invokeV.objValue;
        }

        public static a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                a aVar = new a();
                HashMap hashMap = new HashMap();
                aVar.a = hashMap;
                hashMap.put(AdExtParam.KEY_IADEX, iq5.e());
                aVar.a.put(AdExtParam.KEY_NAD_CORE_VERSION, "5.11.0.5");
                return aVar;
            }
            return (a) invokeV.objValue;
        }

        public a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.a.put(AdExtParam.KEY_AD_CONTEXT_LIST, str);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.a.put("shoubai_cuid", str);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.a.put(AdExtParam.KEY_FLOOR_INFO, str);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.a.put("forum_name", str);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a g(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                this.a.put(AdExtParam.KEY_THREAD_COUNT, Integer.valueOf(i));
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a h(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
                this.a.put(AdExtParam.KEY_REQUEST_TYPE, Integer.valueOf(i));
                return this;
            }
            return (a) invokeI.objValue;
        }
    }

    public AdExtParam() {
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
}
