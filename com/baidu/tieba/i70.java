package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.IMManager;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.MessageFactory;
import com.baidu.android.imsdk.internal.NotifyMessageHandler;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.ubc.CaseUbc;
import com.baidu.android.imsdk.ubc.UBCConstants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.tieba.v70;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i70 {
    public static /* synthetic */ Interceptable $ic;
    public static Handler c;
    public static final HandlerThread d;
    public static volatile LinkedHashMap<Long, Message> e;
    public static volatile i70 f;
    public static Context g;
    public transient /* synthetic */ FieldHolder $fh;
    public AtomicInteger a;
    public v70 b;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Intent a;
        public final /* synthetic */ i70 b;

        public a(i70 i70Var, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i70Var, intent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i70Var;
            this.a = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.g(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements v70 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.x70
        public void onResponse(int i, String str, long j, long j2, long j3, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), bArr}) == null) {
            }
        }

        public b(i70 i70Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i70Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.v70
        public void onResponse(int i, String str, @NonNull v70.a aVar) {
            Message message;
            JSONArray optJSONArray;
            Message message2;
            Message message3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, aVar) == null) {
                LogUtils.i("IMServiceImpl", "IMService err :" + i + ", methodId :" + aVar.a + ", data :" + aVar.c.length + ", Response :" + new String(aVar.c));
                long j = aVar.b;
                long j2 = aVar.a;
                String str2 = "";
                JSONArray jSONArray = new JSONArray();
                try {
                    for (u70 u70Var : aVar.d) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("event", u70Var.a);
                        jSONObject.put("timestamp_ms", u70Var.b);
                        jSONArray.put(jSONObject);
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("event_list", jSONArray);
                    str2 = jSONObject2.toString();
                } catch (JSONException e) {
                    LogUtils.i("IMServiceImpl", "event_list JSONException:" + e.getMessage());
                }
                if (i == 0) {
                    try {
                        JSONObject jSONObject3 = new JSONObject(new String(aVar.c));
                        int optInt = jSONObject3.optInt(PmsConstant.Statistic.STATISTIC_ERRCODE, -1);
                        String optString = jSONObject3.optString("msg", "server msg is null");
                        if (optInt == 4001) {
                            LoginManager.getInstance(i70.g).triggleLogoutListener(4001, Constants.ERROR_LOGIN_STATE_ERROR);
                        }
                        if (jSONObject3.has(Constants.EXTRA_NOTIFY_ID)) {
                            try {
                                if (jSONObject3.has("event_list") && (optJSONArray = jSONObject3.optJSONArray("event_list")) != null) {
                                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                        jSONArray.put(optJSONArray.get(i2));
                                    }
                                }
                                JSONObject jSONObject4 = new JSONObject();
                                jSONObject4.put("event", "CIMNotify");
                                jSONObject4.put("timestamp_ms", System.currentTimeMillis());
                                jSONArray.put(jSONObject4);
                                JSONObject jSONObject5 = new JSONObject();
                                jSONObject5.put("event_list", jSONArray);
                                str2 = jSONObject5.toString();
                                LogUtils.d("IMServiceImpl", "Notify eventList :" + str2);
                            } catch (JSONException e2) {
                                LogUtils.i("IMServiceImpl", "event_list JSONException:" + e2.getMessage());
                            }
                        }
                        if (j2 == 96) {
                            NotifyMessageHandler.handleDeliverMessage(i70.g.getApplicationContext(), jSONObject3, str2);
                            return;
                        } else if (j2 == 196) {
                            NotifyMessageHandler.handleMcastMessage(i70.g.getApplicationContext(), jSONObject3, str2);
                            return;
                        } else if (j2 == 197) {
                            NotifyMessageHandler.handleConfigMessage(i70.g.getApplicationContext(), jSONObject3);
                            return;
                        } else if (j2 == 226) {
                            NotifyMessageHandler.handleMediaNotifyMessage(i70.g.getApplicationContext(), jSONObject3);
                            return;
                        } else if (j2 == 231) {
                            NotifyMessageHandler.handleRtcNotifyMessage(i70.g, jSONObject3);
                            return;
                        } else {
                            if (j2 != 236 && j2 != 238) {
                                LogUtils.d("IMServiceImpl", "key :" + j + "，response :" + jSONObject3.toString() + ", eventList :" + str2);
                                synchronized (i70.e) {
                                    if (i70.e.containsKey(Long.valueOf(j)) && (message2 = (Message) i70.e.remove(Long.valueOf(j))) != null) {
                                        message2.setEventList(str2);
                                        message2.handleMessageResult(i70.g, jSONObject3, optInt, optString);
                                    }
                                }
                                return;
                            }
                            NotifyMessageHandler.handleBusinessCustomizeNotify(i70.g.getApplicationContext(), (int) j2, jSONObject3);
                            return;
                        }
                    } catch (Throwable th) {
                        LogUtils.e("IMServiceImpl", "handle response e :", th);
                        synchronized (i70.e) {
                            if (i70.e.containsKey(Long.valueOf(j)) && (message = (Message) i70.e.remove(Long.valueOf(j))) != null) {
                                message.setEventList(str2);
                                message.handleMessageResult(i70.g, null, 1010, th.getMessage());
                            }
                            return;
                        }
                    }
                }
                synchronized (i70.e) {
                    if (i70.e.containsKey(Long.valueOf(j)) && (message3 = (Message) i70.e.remove(Long.valueOf(j))) != null) {
                        message3.setEventList(str2);
                        Context context = i70.g;
                        if (TextUtils.isEmpty(str)) {
                            str = "lcp error";
                        }
                        message3.handleMessageResult(context, null, i, str);
                    }
                }
                LoginManager.getInstance(i70.g).setCurrentState(LoginManager.LoginState.NOT_LOGIN);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947806279, "Lcom/baidu/tieba/i70;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947806279, "Lcom/baidu/tieba/i70;");
                return;
            }
        }
        HandlerThread handlerThread = new HandlerThread("IMServiceImpl HandlerThread");
        d = handlerThread;
        handlerThread.start();
        c = new Handler(d.getLooper());
        e = new LinkedHashMap<>();
    }

    public i70() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new AtomicInteger();
        this.b = new b(this);
        f();
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int[] iArr = {96, Constants.METHOD_MEDIA_NOTIFY, 196, Constants.METHOD_IM_DELIVER_CONFIG_MSG, 231, Constants.METHOD_IM_CONSULT_NOTIFY_MSG, 238};
            for (int i = 0; i < 7; i++) {
                i(2, Integer.valueOf(iArr[i]).intValue());
            }
            i(3, 196);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            IMManager.init(g.getApplicationContext(), IMConfigInternal.getInstance().getProductLine(g.getApplicationContext()));
            h();
        }
    }

    public static void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            synchronized (e) {
                for (Message message : e.values()) {
                    if (message != null) {
                        message.handleMessageResult(context, null, -1, "");
                    }
                }
                e.clear();
            }
        }
    }

    public static i70 e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (f == null) {
                synchronized (i70.class) {
                    if (f == null) {
                        g = context.getApplicationContext();
                        f = new i70();
                    }
                }
            }
            return f;
        }
        return (i70) invokeL.objValue;
    }

    public void d(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
            LogUtils.e("IMServiceImpl", "IMServiceImpl.getInstance(context).enqueueWork");
            TaskManager.getInstance(context).submitForNetWork(new a(this, intent));
        }
    }

    public final void i(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            w70 w70Var = new w70();
            w70Var.a = i;
            w70Var.b = i2;
            r70.c(w70Var, this.b);
        }
    }

    public void g(@NonNull Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent) == null) {
            LogUtils.d("IMServiceImpl", "-- onHandleWork -- " + intent);
            try {
                int intExtra = intent.getIntExtra("method", -1);
                int intExtra2 = intent.getIntExtra("service_id", -1);
                LogUtils.d("IMServiceImpl", "-- onHandleWork methodId : " + intExtra);
                if (intExtra != -1 && intExtra2 != -1) {
                    if (intExtra == 50 || intExtra == 201) {
                        h();
                    }
                    Message createNewMessage = MessageFactory.getInstance().createNewMessage(g, intExtra, intent);
                    if (createNewMessage != null) {
                        LogUtils.d("IMServiceImpl", "IMLoginState = " + LoginManager.getInstance(g).getCurrentState() + ", methodId :" + intExtra);
                        createNewMessage.isSending(true);
                        BLCPRequest bLCPRequest = new BLCPRequest();
                        bLCPRequest.a = (long) intExtra2;
                        long type = (long) createNewMessage.getType();
                        bLCPRequest.b = type;
                        if (intExtra2 == 3 && type == 55) {
                            bLCPRequest.b = 185L;
                        }
                        bLCPRequest.c = createNewMessage.getBody().getBytes();
                        bLCPRequest.e = BLCPRequest.SendTimeoutSecond.TIMEOUT_30s;
                        String str = System.currentTimeMillis() + "";
                        long j = (bLCPRequest.a * 1000000000000000L) + bLCPRequest.b;
                        StringBuilder sb = new StringBuilder();
                        sb.append((System.currentTimeMillis() + "").substring(str.length() - 6));
                        sb.append(this.a.incrementAndGet());
                        bLCPRequest.d = j + (Long.parseLong(sb.toString()) * 1000);
                        synchronized (e) {
                            if (intExtra == 50) {
                                if (BIMManager.isIMLogined(g)) {
                                    LogUtils.d("IMServiceImpl", "cur state is loggined, abandon other 50");
                                    CaseUbc.DebugInfo debugInfo = new CaseUbc.DebugInfo();
                                    debugInfo.curClassName = "onHandleWork IM logined";
                                    debugInfo.extInfo = e.keySet().toString();
                                    CaseUbc.caseType = "imcase_login";
                                    w60.d().f(CaseUbc.generateUBCData(g, "-1", "", debugInfo), UBCConstants.IS_REAL, UBCConstants.IS_SAVE_DB, UBCConstants.IS_ASYNC);
                                    return;
                                }
                                e.clear();
                                e.put(Long.valueOf(bLCPRequest.d), createNewMessage);
                                e.putAll((LinkedHashMap) e.clone());
                                LogUtils.d("IMServiceImpl", "cur method :50, cur msgList :" + e.keySet());
                            } else {
                                e.put(Long.valueOf(bLCPRequest.d), createNewMessage);
                            }
                            LogUtils.d("IMServiceImpl", "requestTaskManager msg Id:" + bLCPRequest.d + ". msg :" + e.keySet().toString());
                            r70.c(bLCPRequest, this.b);
                        }
                    }
                }
            } catch (Exception e2) {
                LogUtils.e("IMServiceImpl", "onStartCommand isSmallFlow Exception", e2);
            }
        }
    }
}
