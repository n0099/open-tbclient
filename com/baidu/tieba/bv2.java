package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.websocket.IWebSocketListener;
import com.baidu.searchbox.websocket.WebSocketManager;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class bv2 extends j53 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947658347, "Lcom/baidu/tieba/bv2;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947658347, "Lcom/baidu/tieba/bv2;");
        }
    }

    @Override // com.baidu.tieba.j53
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, m33 m33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, m33Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    /* loaded from: classes3.dex */
    public final class a implements IWebSocketListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bv2 a;
        public final /* synthetic */ WeakReference b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;

        public a(bv2 bv2Var, WeakReference weakReference, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bv2Var, weakReference, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bv2Var;
            this.b = weakReference;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = str4;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            int i;
            String str;
            m33 c;
            yu2 m0;
            String optString;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                JSONObject jSONObject2 = new JSONObject();
                if (jSONObject != null) {
                    i = jSONObject.optInt("code");
                } else {
                    i = 0;
                }
                jSONObject2.put("code", i);
                String str2 = "";
                if (jSONObject != null && (optString = jSONObject.optString("reason", "")) != null) {
                    str2 = optString;
                }
                jSONObject2.put("reason", str2);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("status", "0");
                jSONObject3.put("message", "websocket closed");
                jSONObject3.put("data", jSONObject2);
                CallbackHandler callbackHandler = (CallbackHandler) this.b.get();
                if (callbackHandler != null) {
                    callbackHandler.handleSchemeDispatchCallback(this.e, jSONObject3.toString());
                }
                if (jSONObject != null) {
                    str = jSONObject.getString("taskID");
                } else {
                    str = null;
                }
                if (str != null && (c = this.a.c()) != null && (m0 = c.m0()) != null) {
                    m0.c(str);
                }
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onError(Throwable t, JSONObject jSONObject) {
            String str;
            m33 c;
            yu2 m0;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t, jSONObject) == null) {
                Intrinsics.checkNotNullParameter(t, "t");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(StatConstants.KEY_EXT_ERR_MSG, t.getMessage());
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("status", "0");
                jSONObject3.put("message", "error happen");
                jSONObject3.put("data", jSONObject2);
                CallbackHandler callbackHandler = (CallbackHandler) this.b.get();
                if (callbackHandler != null) {
                    callbackHandler.handleSchemeDispatchCallback(this.f, jSONObject3.toString());
                }
                if (jSONObject != null) {
                    str = jSONObject.getString("taskID");
                } else {
                    str = null;
                }
                if (str != null && (c = this.a.c()) != null && (m0 = c.m0()) != null) {
                    m0.c(str);
                }
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
                Intrinsics.checkNotNullParameter(message, "message");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("data", message);
                jSONObject.put("dataType", EMABTest.TYPE_STRING);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("status", "0");
                jSONObject2.put("message", "message received");
                jSONObject2.put("data", jSONObject);
                CallbackHandler callbackHandler = (CallbackHandler) this.b.get();
                if (callbackHandler != null) {
                    callbackHandler.handleSchemeDispatchCallback(this.d, jSONObject2.toString());
                }
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map headers) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, headers) == null) {
                Intrinsics.checkNotNullParameter(headers, "headers");
                JSONObject jSONObject = new JSONObject(headers);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("header", jSONObject);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("status", "0");
                jSONObject3.put("message", "websocket open success");
                jSONObject3.put("data", jSONObject2);
                CallbackHandler callbackHandler = (CallbackHandler) this.b.get();
                if (callbackHandler != null) {
                    callbackHandler.handleSchemeDispatchCallback(this.c, jSONObject3.toString());
                }
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(ByteBuffer message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, message) == null) {
                Intrinsics.checkNotNullParameter(message, "message");
                byte[] bArr = new byte[message.remaining()];
                message.get(bArr);
                String encodeToString = Base64.encodeToString(bArr, 2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("data", encodeToString);
                jSONObject.put("dataType", "arrayBuffer");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("status", "0");
                jSONObject2.put("message", "message received");
                jSONObject2.put("data", jSONObject);
                CallbackHandler callbackHandler = (CallbackHandler) this.b.get();
                if (callbackHandler != null) {
                    callbackHandler.handleSchemeDispatchCallback(this.d, jSONObject2.toString());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bv2(j43 j43Var) {
        super(j43Var, "/swanAPI/webSocket");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j43Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.j53
    public boolean i(Context context, UnitedSchemeEntity entity, CallbackHandler callbackHandler, String str, m33 m33Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, entity, callbackHandler, str, m33Var)) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            if (j53.b) {
                Log.d("websocket", "handleSubAction subAction: " + str);
            }
            if (m33Var == null) {
                m02.c("websocket", "param is null");
                entity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
                if (j53.b) {
                    Log.d("websocket", "websocket --- illegal swanApp");
                }
                return false;
            } else if (TextUtils.isEmpty(m33Var.b)) {
                m02.c("websocket", "aiapp id is invalid");
                entity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none swanApp id");
                if (j53.b) {
                    Log.d("websocket", "websocket --- none swanApp id");
                }
                return false;
            } else {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(entity);
                if (optParamsAsJo == null) {
                    m02.c("websocket", "no params found");
                    entity.result = UnitedSchemeUtility.wrapCallbackParams(202, "no params found");
                    if (j53.b) {
                        Log.d("websocket", "websocket --- none params found");
                    }
                    return false;
                }
                if (str != null) {
                    int hashCode = str.hashCode();
                    if (hashCode != -1597844571) {
                        if (hashCode != -1293540435) {
                            if (hashCode == 1991859579 && str.equals("/swanAPI/webSocket/close")) {
                                return k(context, optParamsAsJo, entity, callbackHandler, m33Var);
                            }
                        } else if (str.equals("/swanAPI/webSocket/connect")) {
                            return l(context, optParamsAsJo, entity, callbackHandler, m33Var);
                        }
                    } else if (str.equals("/swanAPI/webSocket/send")) {
                        return m(context, optParamsAsJo, entity, callbackHandler, m33Var);
                    }
                }
                entity.result = UnitedSchemeUtility.wrapCallbackParams(302);
                return false;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public final IWebSocketListener j(JSONObject jSONObject, CallbackHandler callbackHandler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, callbackHandler)) == null) {
            return new a(this, new WeakReference(callbackHandler), jSONObject.getString("onOpen"), jSONObject.getString("onMessage"), jSONObject.getString("onClose"), jSONObject.getString("onError"));
        }
        return (IWebSocketListener) invokeLL.objValue;
    }

    public final boolean k(Context context, JSONObject jSONObject, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, m33 m33Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, jSONObject, unitedSchemeEntity, callbackHandler, m33Var)) == null) {
            if (!jSONObject.has("taskID")) {
                m02.c("websocket", "taskID lose");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "taskID lose");
                if (j53.b) {
                    Log.d("websocket", "close --- taskID lose");
                }
                return false;
            }
            String taskId = jSONObject.getString("taskID");
            int optInt = jSONObject.optInt("code", 1000);
            String reason = jSONObject.optString("reason", "close normally");
            try {
                try {
                    WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(taskId, "taskId");
                    Intrinsics.checkNotNullExpressionValue(reason, "reason");
                    webSocketManager.close(taskId, optInt, reason);
                    m33Var.m0().c(taskId);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    return true;
                } catch (Exception e) {
                    m02.c("websocket", e.getMessage());
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage());
                    if (j53.b) {
                        Log.d("websocket", "close --- " + e.getMessage());
                    }
                    yu2 m0 = m33Var.m0();
                    Intrinsics.checkNotNullExpressionValue(taskId, "taskId");
                    m0.c(taskId);
                    return false;
                }
            } catch (Throwable th) {
                yu2 m02 = m33Var.m0();
                Intrinsics.checkNotNullExpressionValue(taskId, "taskId");
                m02.c(taskId);
                throw th;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean m(Context context, JSONObject jSONObject, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, m33 m33Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048581, this, context, jSONObject, unitedSchemeEntity, callbackHandler, m33Var)) == null) {
            if (jSONObject.has("taskID") && jSONObject.has("data")) {
                String taskId = jSONObject.getString("taskID");
                String data = jSONObject.getString("data");
                try {
                    if (jSONObject.optString("dataType", EMABTest.TYPE_STRING).equals("arrayBuffer")) {
                        ByteBuffer buffer = ByteBuffer.wrap(Base64.decode(data, 2));
                        WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(taskId, "taskId");
                        Intrinsics.checkNotNullExpressionValue(buffer, "buffer");
                        webSocketManager.send(taskId, buffer);
                    } else {
                        WebSocketManager webSocketManager2 = WebSocketManager.INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(taskId, "taskId");
                        Intrinsics.checkNotNullExpressionValue(data, "data");
                        webSocketManager2.send(taskId, data);
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    return true;
                } catch (Exception e) {
                    m02.c("websocket", e.getMessage());
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage());
                    if (j53.b) {
                        Log.d("websocket", "send --- " + e.getMessage());
                    }
                    return false;
                }
            }
            m02.c("websocket", "taskID or data lose");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "taskID or data lose");
            if (j53.b) {
                Log.d("websocket", "send --- taskID or data lose");
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean l(Context context, JSONObject jSONObject, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, m33 m33Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048580, this, context, jSONObject, unitedSchemeEntity, callbackHandler, m33Var)) == null) {
            if (jSONObject.has("url") && jSONObject.has("cb")) {
                JSONObject cb = jSONObject.getJSONObject("cb");
                if (cb.has("onOpen") && cb.has("onMessage") && cb.has("onClose") && cb.has("onError")) {
                    JSONObject jSONObject2 = new JSONObject();
                    if (!m33Var.m0().a()) {
                        jSONObject2.put("errno", "1");
                    } else {
                        String string = jSONObject.getString("url");
                        String optString = jSONObject.optString("__plugin__");
                        int c = d43.c("socket", string, optString);
                        if (c != 1) {
                            if (c != 2) {
                                WebSocketRequest fromJSON = WebSocketRequest.Companion.fromJSON(jSONObject);
                                if (!TextUtils.isEmpty(optString)) {
                                    nc4 h = kz2.h(optString);
                                    Map headers = fromJSON.getHeaders();
                                    if (headers == null) {
                                        headers = new LinkedHashMap();
                                        fromJSON.setHeaders(headers);
                                    }
                                    String b = jz2.b(h);
                                    Intrinsics.checkNotNullExpressionValue(b, "SwanPluginHostSign.hostSign(pmsPlugin)");
                                    headers.put("X-SWAN-HOSTSIGN", b);
                                }
                                Intrinsics.checkNotNullExpressionValue(cb, "cb");
                                try {
                                    WebSocketTask connect = WebSocketManager.INSTANCE.connect(fromJSON, j(cb, callbackHandler));
                                    jSONObject2.put("errno", "0");
                                    jSONObject2.put("task", connect.toJSON());
                                    m33Var.m0().b(connect);
                                } catch (Exception e) {
                                    m02.c("websocket", e.getMessage());
                                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage());
                                    if (j53.b) {
                                        Log.d("websocket", "connect --- " + e.getMessage());
                                    }
                                    return false;
                                }
                            } else {
                                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "request url header must be https or wss");
                                return false;
                            }
                        } else {
                            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal request");
                            return false;
                        }
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0));
                    return true;
                }
                m02.c("websocket", "websocket callback lose");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "websocket callback lose");
                if (j53.b) {
                    Log.d("websocket", "connect --- websocket callback lose");
                }
                return false;
            }
            m02.c("websocket", "url or cb lose");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "url or cb lose");
            if (j53.b) {
                Log.d("websocket", "connect --- url or cb lose");
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }
}
