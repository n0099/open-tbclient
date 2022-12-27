package com.baidu.tbadk.net;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.common.others.url.UrlUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWorkErr;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.R;
import com.baidu.tieba.bk5;
import com.baidu.tieba.r9;
import com.baidu.tieba.ur8;
import com.baidu.tieba.vq4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes3.dex */
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
    public int h;
    public String i;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public interface e<Result> {
        @Nullable
        @WorkerThread
        Result a(@NonNull String str);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes3.dex */
    public static class ResponseMessage extends JsonHttpResponsedMessage {
        public static /* synthetic */ Interceptable $ic;
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

        @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
        public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
                super.decodeLogicInBackGround(i, jSONObject);
                Object extra = getmOrginalMessage().getExtra();
                bk5.d(extra instanceof c);
                c cVar = (c) extra;
                Type type = cVar.a;
                e eVar = cVar.b;
                String str = cVar.c;
                int i2 = cVar.d;
                bk5.b(type);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                    setError(-1);
                    setErrorString(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f05d4));
                }
                if (vq4.e()) {
                    if (str != null) {
                        parseServerResponsedData(str);
                        jSONObject = new JSONObject(str);
                    }
                    if (i2 > 0) {
                        TimeUnit.MILLISECONDS.sleep(i2);
                    }
                }
                String optString = jSONObject.optString("data");
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

    /* loaded from: classes3.dex */
    public static abstract class b<Result> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Type a;

        public void b(int i, @NonNull String str, @Nullable Result result) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, result) == null) {
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        public void e(@NonNull Result result) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, result) == null) {
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
            this.a = a(getClass());
        }

        public final Type getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a;
            }
            return (Type) invokeV.objValue;
        }

        public static Type a(Class<?> cls) {
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
    }

    /* loaded from: classes3.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Type a;
        public e b;
        public String c;
        public int d;

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

    /* loaded from: classes3.dex */
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
                        this.a.e.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), null);
                        this.a.e.c();
                        return;
                    }
                    return;
                }
                JsonHttpResponsedMessage jsonHttpResponsedMessage = (JsonHttpResponsedMessage) httpResponsedMessage;
                if (this.a.e != null) {
                    Object resultData = jsonHttpResponsedMessage.getResultData();
                    if (jsonHttpResponsedMessage.getError() != 0) {
                        this.a.e.b(jsonHttpResponsedMessage.getError(), jsonHttpResponsedMessage.getErrorString(), resultData);
                    } else {
                        try {
                            this.a.e.e(resultData);
                        } catch (Exception e) {
                            if (!vq4.e()) {
                                this.a.e.b(-21, NetWorkErr.NETWORK_DATA_EXCEPTION_MSG, resultData);
                            } else {
                                throw new IllegalStateException("业务处理网络返回的数据出现异常，请处理！", e);
                            }
                        }
                    }
                    this.a.e.c();
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
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new HashMap();
        this.d = new HashMap();
        TbHttpMessageTask e2 = ur8.e(i, str, ResponseMessage.class, false, true, true, true);
        this.a = e2;
        this.i = e2.getUrl();
        d dVar = new d(this, i, true);
        this.b = dVar;
        registerListener(dVar);
    }

    @NonNull
    public <Result> FastRequest J(@Nullable b<Result> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
            this.e = bVar;
            return this;
        }
        return (FastRequest) invokeL.objValue;
    }

    @NonNull
    public FastRequest K(@NonNull HttpMessageTask.HTTP_METHOD http_method) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, http_method)) == null) {
            this.a.setMethod(http_method);
            return this;
        }
        return (FastRequest) invokeL.objValue;
    }

    @NonNull
    public <Result> FastRequest L(@NonNull e<Result> eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, eVar)) == null) {
            this.f = eVar;
            return this;
        }
        return (FastRequest) invokeL.objValue;
    }

    @NonNull
    public FastRequest H(@NonNull String str, @NonNull Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, obj)) == null) {
            this.d.put(str, obj);
            return this;
        }
        return (FastRequest) invokeLL.objValue;
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!this.c.isEmpty()) {
                this.a.setUrl(UrlUtils.appendParams(this.i, this.c));
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
                bVar.d();
                c cVar = new c(null);
                cVar.a = this.e.getType();
                cVar.b = this.f;
                cVar.c = this.g;
                cVar.d = this.h;
                httpMessage.setExtra(cVar);
            }
            sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            cancelMessage();
            return true;
        }
        return invokeV.booleanValue;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            cancelLoadData();
            MessageManager.getInstance().unRegisterListener(this.b);
        }
    }
}
