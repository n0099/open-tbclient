package com.baidu.tbadk.net;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.others.url.UrlUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWorkErr;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.CookieHelper;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.R;
import com.baidu.tieba.b7;
import com.baidu.tieba.cra;
import com.baidu.tieba.tt5;
import com.baidu.tieba.vj6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class FastRequest extends BdBaseModel<BaseFragmentActivity> implements LifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final TbHttpMessageTask a;
    @NonNull
    public final d b;
    @NonNull
    public final Map<String, String> c;
    @NonNull
    public final Map<String, Object> d;
    @Nullable
    public b e;
    @Nullable
    public e f;
    @Nullable
    public String g;
    @Nullable
    public String h;
    public int i;
    public final String j;
    public boolean k;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public interface e<Result> {
        @Nullable
        @WorkerThread
        Result a(@NonNull String str);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public static class ResponseMessage extends JsonHttpResponsedMessage {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String JSON_ARRAY = "[]";
        public static final String JSON_OBJECT = "{}";
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResponseMessage(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @NonNull
        private String getDefaultDataJson(@NonNull Type type) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, type)) == null) {
                Class<?> rawType = C$Gson$Types.getRawType(type);
                if (List.class.isAssignableFrom(rawType)) {
                    return "[]";
                }
                if (!Unit.class.isAssignableFrom(rawType) && !Void.class.isAssignableFrom(rawType)) {
                    return "";
                }
                return "{}";
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
        public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
                super.decodeLogicInBackGround(i, jSONObject);
                Object extra = getmOrginalMessage().getExtra();
                tt5.d(extra instanceof c);
                c cVar = (c) extra;
                Type type = cVar.a;
                e eVar = cVar.b;
                String str = cVar.c;
                String str2 = cVar.d;
                int i2 = cVar.e;
                tt5.b(type);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                    setError(-1);
                    setErrorString(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f06b4));
                }
                if (GlobalBuildConfig.isDebug()) {
                    if (str != null) {
                        parseServerResponsedData(str);
                        jSONObject = new JSONObject(str);
                    }
                    if (i2 > 0) {
                        TimeUnit.MILLISECONDS.sleep(i2);
                    }
                }
                String optString = jSONObject.optString("data", getDefaultDataJson(type));
                if (str2 != null) {
                    optString = jSONObject.optString(str2, getDefaultDataJson(type));
                }
                Object obj = null;
                if (eVar != null) {
                    obj = eVar.a(optString);
                }
                if (obj == null) {
                    obj = DataExt.GSON.fromJson(optString, type);
                }
                setResultData(obj);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class b<Result> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Type a;
        @NonNull
        public String b;
        @NonNull
        public String c;

        @Deprecated
        public void f(int i, @NonNull String str, @Nullable Result result) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048580, this, i, str, result) == null) {
            }
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            }
        }

        public void i(@NonNull Result result) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, result) == null) {
            }
        }

        public b() {
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
            this.b = "";
            this.c = "";
            this.a = c(getClass());
        }

        @NonNull
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.c;
            }
            return (String) invokeV.objValue;
        }

        @NonNull
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.b;
            }
            return (String) invokeV.objValue;
        }

        public final Type d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.a;
            }
            return (Type) invokeV.objValue;
        }

        public static Type c(Class<?> cls) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cls)) == null) {
                Type genericSuperclass = cls.getGenericSuperclass();
                if (!(genericSuperclass instanceof Class)) {
                    return C$Gson$Types.canonicalize(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
                }
                throw new RuntimeException("Missing type parameter");
            }
            return (Type) invokeL.objValue;
        }

        public void e(int i, @NonNull String str, @Nullable Exception exc, @Nullable Result result) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, exc, result}) == null) {
                f(i, str, result);
            }
        }

        public void j(@Nullable String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) && str != null) {
                this.c = str;
            }
        }

        public void k(@Nullable String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048585, this, str) == null) && str != null) {
                this.b = str;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Type a;
        public e b;
        public String c;
        public String d;
        public int e;

        public c() {
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

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public class d extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FastRequest a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(FastRequest fastRequest, int i, boolean z) {
            super(i, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fastRequest, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fastRequest;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (!(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                    if (this.a.e != null) {
                        this.a.e.e(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage.getDecodeException(), null);
                        this.a.e.g();
                        return;
                    }
                    return;
                }
                JsonHttpResponsedMessage jsonHttpResponsedMessage = (JsonHttpResponsedMessage) httpResponsedMessage;
                if (this.a.e != null) {
                    this.a.e.k(jsonHttpResponsedMessage.getLogId());
                    this.a.e.j(jsonHttpResponsedMessage.getErrorString());
                    Object resultData = jsonHttpResponsedMessage.getResultData();
                    if (jsonHttpResponsedMessage.getError() != 0) {
                        this.a.e.e(jsonHttpResponsedMessage.getError(), jsonHttpResponsedMessage.getErrorString(), jsonHttpResponsedMessage.getDecodeException(), resultData);
                    } else {
                        try {
                            this.a.e.i(resultData);
                        } catch (Exception e) {
                            BdLog.detailException(httpResponsedMessage.getClass().getName(), new IllegalStateException("业务处理网络返回的数据出现异常，请处理！", e), true);
                            this.a.e.e(-21, NetWorkErr.NETWORK_DATA_EXCEPTION_MSG, e, resultData);
                        }
                    }
                    this.a.e.g();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FastRequest(@NonNull TbPageContext<BaseFragmentActivity> tbPageContext, int i, @NonNull String str) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new HashMap();
        this.d = new HashMap();
        this.h = null;
        this.k = false;
        TbHttpMessageTask e2 = cra.e(i, str, ResponseMessage.class, false, true, true, true);
        this.a = e2;
        this.j = e2.getUrl();
        d dVar = new d(this, i, true);
        this.b = dVar;
        registerListener(dVar);
    }

    @NonNull
    public <Result> FastRequest R(@Nullable b<Result> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
            this.e = bVar;
            return this;
        }
        return (FastRequest) invokeL.objValue;
    }

    @NonNull
    public FastRequest S(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            this.a.setConnectTimeOut(new b7(i, i, i));
            return this;
        }
        return (FastRequest) invokeI.objValue;
    }

    @NonNull
    public FastRequest T(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            this.a.setIsNeedDialog(z);
            return this;
        }
        return (FastRequest) invokeZ.objValue;
    }

    @NonNull
    public FastRequest U(@NonNull HttpMessageTask.HTTP_METHOD http_method) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, http_method)) == null) {
            this.a.setMethod(http_method);
            return this;
        }
        return (FastRequest) invokeL.objValue;
    }

    public FastRequest V(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            this.k = z;
            return this;
        }
        return (FastRequest) invokeZ.objValue;
    }

    @NonNull
    public <Result> FastRequest W(@NonNull e<Result> eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, eVar)) == null) {
            this.f = eVar;
            return this;
        }
        return (FastRequest) invokeL.objValue;
    }

    @NonNull
    public FastRequest X(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            this.a.setTimeOut(new b7(i, i, i));
            return this;
        }
        return (FastRequest) invokeI.objValue;
    }

    @NonNull
    public FastRequest Y(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            this.h = str;
            return this;
        }
        return (FastRequest) invokeL.objValue;
    }

    @NonNull
    public FastRequest Z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            this.a.setRetry(i);
            return this;
        }
        return (FastRequest) invokeI.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) {
            super.setUniqueId(bdUniqueId);
            this.b.setTag(bdUniqueId);
        }
    }

    @NonNull
    public FastRequest P(@NonNull String str, @NonNull Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, obj)) == null) {
            this.d.put(str, obj);
            return this;
        }
        return (FastRequest) invokeLL.objValue;
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!this.c.isEmpty()) {
                this.a.setUrl(UrlUtils.appendParams(this.j, this.c));
                this.c.clear();
            }
            HttpMessage httpMessage = new HttpMessage(this.a.getCmd());
            if (!this.d.isEmpty()) {
                for (Map.Entry<String, Object> entry : this.d.entrySet()) {
                    httpMessage.addParam(entry.getKey(), entry.getValue());
                }
                this.d.clear();
            }
            b bVar = this.e;
            if (bVar != null) {
                bVar.h();
                c cVar = new c(null);
                cVar.a = this.e.d();
                cVar.b = this.f;
                cVar.c = this.g;
                cVar.d = this.h;
                cVar.e = this.i;
                httpMessage.setExtra(cVar);
            }
            if (this.k) {
                Map<String, String> b2 = CookieHelper.b();
                if (!vj6.b(b2)) {
                    for (Map.Entry<String, String> entry2 : b2.entrySet()) {
                        httpMessage.addCookie(entry2.getKey(), entry2.getValue());
                    }
                }
            }
            sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            MessageManager.getInstance().removeMessage(this.a.getCmd(), this.unique_id);
            return true;
        }
        return invokeV.booleanValue;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            cancelLoadData();
            MessageManager.getInstance().unRegisterListener(this.b);
        }
    }
}
