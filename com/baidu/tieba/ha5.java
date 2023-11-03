package com.baidu.tieba;

import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.data.TopNotifyData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class ha5 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final ha5 a;
    public static String b = "";
    public static boolean c;
    public static b d;
    public static a e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface a {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947817005, "Lcom/baidu/tieba/ha5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947817005, "Lcom/baidu/tieba/ha5;");
                return;
            }
        }
        a = new ha5();
    }

    /* loaded from: classes6.dex */
    public static final class b extends BdAsyncTask<Object, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile NetWork a;

        public b(String urlPath) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {urlPath};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(urlPath, "urlPath");
            this.a = new NetWork(TbConfig.SERVER_ADDRESS + urlPath);
            NetWork netWork = this.a;
            Intrinsics.checkNotNull(netWork);
            netWork.addPostData(IntentConfig.CALL_FROM, ha5.a.f(ha5.b));
            NetWork netWork2 = this.a;
            Intrinsics.checkNotNull(netWork2);
            netWork2.addPostData("chatroom_at_msg_id", ha5.a.g(ha5.b));
            NetWork netWork3 = this.a;
            Intrinsics.checkNotNull(netWork3);
            netWork3.setNeedBdussForGet(true);
            NetWork netWork4 = this.a;
            Intrinsics.checkNotNull(netWork4);
            netWork4.getNetContext().getRequest().mIsNeedTbs = true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Object... params) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, params)) == null) {
                Intrinsics.checkNotNullParameter(params, "params");
                try {
                    NetWork netWork = this.a;
                    Intrinsics.checkNotNull(netWork);
                    String postNetData = netWork.postNetData();
                    NetWork netWork2 = this.a;
                    Intrinsics.checkNotNull(netWork2);
                    if (netWork2.getNetContext().getResponse().isRequestSuccess() && postNetData != null) {
                        return postNetData;
                    }
                    return "";
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    return "";
                }
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a != null) {
                    NetWork netWork = this.a;
                    Intrinsics.checkNotNull(netWork);
                    netWork.cancelNetConnect();
                    this.a = null;
                }
                super.cancel(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                ha5.a.i(str);
                a aVar = ha5.e;
                if (aVar != null) {
                    aVar.a();
                }
            }
        }
    }

    public ha5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return f(b);
        }
        return (String) invokeV.objValue;
    }

    public final String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String queryParameter = Uri.parse(str).getQueryParameter(IntentConfig.CALL_FROM);
            if (queryParameter == null) {
                return "";
            }
            return queryParameter;
        }
        return (String) invokeL.objValue;
    }

    public final String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            String queryParameter = Uri.parse(str).getQueryParameter("chatroom_at_msg_id");
            if (queryParameter == null) {
                return "";
            }
            return queryParameter;
        }
        return (String) invokeL.objValue;
    }

    public final void i(String str) {
        TopNotifyData a2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        Intrinsics.checkNotNull(str);
        String optString = new JSONObject(str).optString("data");
        if (!StringUtils.isNull(optString) && StringHelper.isJSONObject(optString)) {
            JSONObject jSONObject = new JSONObject(optString);
            if (jSONObject.length() == 0) {
                return;
            }
            String optString2 = jSONObject.optString(f(b));
            if (!StringUtils.isNull(optString2) && (a2 = TopNotifyData.Companion.a()) != null) {
                a2.parsJson(new JSONObject(optString2));
            }
        }
    }

    public final void j(String urlPath, a callBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, urlPath, callBack) == null) {
            Intrinsics.checkNotNullParameter(urlPath, "urlPath");
            Intrinsics.checkNotNullParameter(callBack, "callBack");
            if (!c && !StringUtils.isNull(f(urlPath)) && !StringUtils.isNull(g(urlPath))) {
                b = urlPath;
                e = callBack;
                b bVar = new b(urlPath);
                d = bVar;
                if (bVar != null) {
                    bVar.execute(new Object[0]);
                }
                c = false;
            }
        }
    }
}
