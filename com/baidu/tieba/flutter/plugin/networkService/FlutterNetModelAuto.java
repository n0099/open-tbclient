package com.baidu.tieba.flutter.plugin.networkService;

import androidx.core.view.InputDeviceCompat;
import b.a.e.c.g.a;
import b.a.e.c.g.c;
import b.a.e.f.m.e;
import b.a.e.f.p.l;
import b.a.q0.k0.b.g;
import b.a.q0.k0.b.h;
import b.a.q0.y0.b;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcJsonHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.flutter.plugin.networkService.NetworkServicePlugin;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import protobuf.Error;
/* loaded from: classes9.dex */
public class FlutterNetModelAuto<T extends g, D extends h> implements NetworkServicePlugin.NetModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TIMOUT_MIN = 10;
    public transient /* synthetic */ FieldHolder $fh;
    public T data;
    public boolean hadCheckHttpTask;
    public boolean hadCheckListener;
    public boolean hadCheckSocketTask;
    public NetModelHttpCallback<T, D> httpCallback;
    public String identifier;
    public boolean isLoading;
    public boolean isNeedCache;
    public boolean isNeedParallel;
    public boolean isNetOk;
    public int mHttpCmd;
    public String mHttpUrl;
    public boolean mNeedCompress;
    public int mSocketCmd;
    public Class<T> requestDataClass;
    public Class<D> responseDataClass;
    public NetModelSocketCallback<T, D> socketCallback;
    public TbSocketMessage socketMsg;
    public int timeout;
    public Runnable timeoutRunnable;
    public final NetModelType type;
    public BdUniqueId unique_id;

    /* renamed from: com.baidu.tieba.flutter.plugin.networkService.FlutterNetModelAuto$11  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass11 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$tieba$flutter$plugin$networkService$FlutterNetModelAuto$NetModelType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1503711071, "Lcom/baidu/tieba/flutter/plugin/networkService/FlutterNetModelAuto$11;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1503711071, "Lcom/baidu/tieba/flutter/plugin/networkService/FlutterNetModelAuto$11;");
                    return;
                }
            }
            int[] iArr = new int[NetModelType.values().length];
            $SwitchMap$com$baidu$tieba$flutter$plugin$networkService$FlutterNetModelAuto$NetModelType = iArr;
            try {
                iArr[NetModelType.TYPE_AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$tieba$flutter$plugin$networkService$FlutterNetModelAuto$NetModelType[NetModelType.TYPE_SOCKET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$tieba$flutter$plugin$networkService$FlutterNetModelAuto$NetModelType[NetModelType.TYPE_HTTP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface NetModelCallback<T extends g, D extends h> extends NetModelHttpCallback<T, D>, NetModelSocketCallback<T, D> {
    }

    /* loaded from: classes9.dex */
    public interface NetModelHttpCallback<T extends g, D extends h> {
        void onHttpResponseMessage(String str, HashMap<String, String> hashMap, MvcHttpResponsedMessage<D> mvcHttpResponsedMessage, MvcHttpMessage<T, D> mvcHttpMessage, MvcNetMessage<T, D> mvcNetMessage);
    }

    /* loaded from: classes9.dex */
    public interface NetModelSocketCallback<T extends g, D extends h> {
        void onSocketResponseMessage(String str, HashMap<String, String> hashMap, SocketResponsedMessage socketResponsedMessage, SocketMessage socketMessage, NetMessage netMessage);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class NetModelType {
        public static final /* synthetic */ NetModelType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final NetModelType TYPE_AUTO;
        public static final NetModelType TYPE_HTTP;
        public static final NetModelType TYPE_SOCKET;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1333618949, "Lcom/baidu/tieba/flutter/plugin/networkService/FlutterNetModelAuto$NetModelType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1333618949, "Lcom/baidu/tieba/flutter/plugin/networkService/FlutterNetModelAuto$NetModelType;");
                    return;
                }
            }
            TYPE_HTTP = new NetModelType("TYPE_HTTP", 0);
            TYPE_SOCKET = new NetModelType("TYPE_SOCKET", 1);
            NetModelType netModelType = new NetModelType("TYPE_AUTO", 2);
            TYPE_AUTO = netModelType;
            $VALUES = new NetModelType[]{TYPE_HTTP, TYPE_SOCKET, netModelType};
        }

        public NetModelType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static NetModelType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (NetModelType) Enum.valueOf(NetModelType.class, str) : (NetModelType) invokeL.objValue;
        }

        public static NetModelType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (NetModelType[]) $VALUES.clone() : (NetModelType[]) invokeV.objValue;
        }
    }

    public FlutterNetModelAuto(String str, NetModelType netModelType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, netModelType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mNeedCompress = false;
        this.isNeedParallel = false;
        this.unique_id = null;
        this.isNeedCache = false;
        this.hadCheckHttpTask = false;
        this.hadCheckSocketTask = false;
        this.hadCheckListener = false;
        this.isLoading = false;
        this.timeout = -1;
        this.isNetOk = true;
        this.identifier = str;
        this.type = netModelType;
    }

    private void checkHttpJsonTask() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, this) == null) && !this.hadCheckHttpTask && MessageManager.getInstance().findTask(getHttpCmd()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(getHttpCmd(), getHttpUrl());
            tbHttpMessageTask.setResponsedClass(getHttpJsonTaskMessageClass());
            onRegisterHttpJsonTask(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(getHttpCmd());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.hadCheckHttpTask = true;
        }
    }

    private void checkHttpProtobufTask() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65547, this) == null) && !this.hadCheckHttpTask && MessageManager.getInstance().findTask(getHttpCmd()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(getHttpCmd(), getHttpUrl() + "?cmd=" + getSocketCmd());
            tbHttpMessageTask.setResponsedClass(getHttpProtobufTaskMessageClass());
            onRegisterHttpProtobufTask(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(getHttpCmd());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.hadCheckHttpTask = true;
        }
    }

    private void checkListener() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || this.hadCheckListener) {
            return;
        }
        int i2 = AnonymousClass11.$SwitchMap$com$baidu$tieba$flutter$plugin$networkService$FlutterNetModelAuto$NetModelType[this.type.ordinal()];
        if (i2 == 1) {
            a aVar = new a(this, getHttpCmd(), getSocketCmd()) { // from class: com.baidu.tieba.flutter.plugin.networkService.FlutterNetModelAuto.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FlutterNetModelAuto this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(r9), Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // b.a.e.c.g.a
                public void onMessage(ResponsedMessage<?> responsedMessage) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, responsedMessage) == null) {
                        this.this$0.isLoading = false;
                        if (this.this$0.timeoutRunnable != null) {
                            e.a().removeCallbacks(this.this$0.timeoutRunnable);
                        }
                        if (responsedMessage instanceof MvcProtobufHttpResponsedMessage) {
                            MvcNetMessage<T, D> mvcNetMessage = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                            if (this.this$0.httpCallback != null) {
                                HashMap<String, String> hashMap = new HashMap<>();
                                hashMap.put("server", this.this$0.getHttpUrl());
                                hashMap.put(RetrieveTaskManager.KEY, this.this$0.getHttpCmd() + "");
                                hashMap.put("state", responsedMessage.getError() + "_" + responsedMessage.getErrorString());
                                this.this$0.httpCallback.onHttpResponseMessage(this.this$0.identifier, hashMap, (MvcProtobufHttpResponsedMessage) responsedMessage, null, mvcNetMessage);
                            }
                        } else if (responsedMessage instanceof SocketResponsedMessage) {
                            MvcNetMessage<T, D> mvcNetMessage2 = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                            if (this.this$0.socketCallback != null) {
                                HashMap<String, String> hashMap2 = new HashMap<>();
                                hashMap2.put(RetrieveTaskManager.KEY, this.this$0.getSocketCmd() + "");
                                hashMap2.put("state", responsedMessage.getError() + "_" + responsedMessage.getErrorString());
                                this.this$0.socketCallback.onSocketResponseMessage(this.this$0.identifier, hashMap2, (SocketResponsedMessage) responsedMessage, null, mvcNetMessage2);
                            }
                        } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                            throw new RuntimeException("mvc netmodel NetListener responsedMessage error");
                        }
                    }
                }
            };
            aVar.getHttpMessageListener().setSelfListener(true);
            aVar.getSocketMessageListener().setSelfListener(true);
            aVar.setTag(getUniqueId());
            MessageManager.getInstance().registerListener(aVar);
        } else if (i2 == 2) {
            c cVar = new c(this, getSocketCmd()) { // from class: com.baidu.tieba.flutter.plugin.networkService.FlutterNetModelAuto.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FlutterNetModelAuto this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(r8)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                        this.this$0.isLoading = false;
                        if (this.this$0.timeoutRunnable != null) {
                            e.a().removeCallbacks(this.this$0.timeoutRunnable);
                        }
                        if (socketResponsedMessage instanceof MvcSocketResponsedMessage) {
                            if (socketResponsedMessage.getOrginalMessage() instanceof MvcSocketMessage) {
                                if (this.this$0.socketCallback != null) {
                                    HashMap<String, String> hashMap = new HashMap<>();
                                    hashMap.put(RetrieveTaskManager.KEY, this.this$0.getSocketCmd() + "");
                                    hashMap.put("state", socketResponsedMessage.getError() + "_" + socketResponsedMessage.getErrorString());
                                    this.this$0.socketCallback.onSocketResponseMessage(this.this$0.identifier, hashMap, socketResponsedMessage, (SocketMessage) socketResponsedMessage.getOrginalMessage(), null);
                                }
                            } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                                throw new RuntimeException("mvc netmodel SocketListener socketResponsedMessage originaMessage error");
                            }
                        } else if (!(socketResponsedMessage instanceof SocketResponsedMessage) || this.this$0.socketCallback == null) {
                        } else {
                            HashMap<String, String> hashMap2 = new HashMap<>();
                            hashMap2.put(RetrieveTaskManager.KEY, this.this$0.getSocketCmd() + "");
                            hashMap2.put("state", socketResponsedMessage.getError() + "_" + socketResponsedMessage.getErrorString());
                            this.this$0.socketCallback.onSocketResponseMessage(this.this$0.identifier, hashMap2, socketResponsedMessage, (SocketMessage) socketResponsedMessage.getOrginalMessage(), null);
                        }
                    }
                }
            };
            cVar.setTag(getUniqueId());
            MessageManager.getInstance().registerListener(cVar);
        } else if (i2 == 3) {
            HttpMessageListener httpMessageListener = new HttpMessageListener(this, getHttpCmd(), true) { // from class: com.baidu.tieba.flutter.plugin.networkService.FlutterNetModelAuto.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FlutterNetModelAuto this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(r9), Boolean.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, httpResponsedMessage) == null) {
                        this.this$0.isLoading = false;
                        if (this.this$0.timeoutRunnable != null) {
                            e.a().removeCallbacks(this.this$0.timeoutRunnable);
                        }
                        if (httpResponsedMessage instanceof MvcJsonHttpResponsedMessage) {
                            if (httpResponsedMessage.getOrginalMessage() instanceof MvcHttpMessage) {
                                if (this.this$0.httpCallback != null) {
                                    HashMap<String, String> hashMap = new HashMap<>();
                                    hashMap.put("server", this.this$0.getHttpUrl());
                                    hashMap.put(RetrieveTaskManager.KEY, this.this$0.getHttpCmd() + "");
                                    hashMap.put("state", httpResponsedMessage.getError() + "_" + httpResponsedMessage.getErrorString());
                                    this.this$0.httpCallback.onHttpResponseMessage(this.this$0.identifier, hashMap, (MvcJsonHttpResponsedMessage) httpResponsedMessage, (MvcHttpMessage) httpResponsedMessage.getOrginalMessage(), null);
                                }
                            } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                                throw new RuntimeException("mvc netmodel HttpListener jsonHttpResponsedMessage originaMessage error");
                            }
                        } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                            throw new RuntimeException("mvc netmodel HttpListener jsonHttpResponsedMessage error");
                        }
                    }
                }
            };
            httpMessageListener.setTag(getUniqueId());
            MessageManager.getInstance().registerListener(httpMessageListener);
        }
        this.hadCheckListener = true;
    }

    private void checkSocketTask() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65549, this) == null) && !this.hadCheckSocketTask && MessageManager.getInstance().findTask(getSocketCmd()) == null) {
            b bVar = new b(getSocketCmd());
            bVar.setResponsedClass(getSocketTaskMessageClass());
            bVar.h(getNeedCompress());
            if (getNeedParallel()) {
                bVar.setParallel(TiebaIMConfig.getParallel());
            }
            onRegisterSocketTask(bVar);
            MessageManager.getInstance().unRegisterTask(getSocketCmd());
            MessageManager.getInstance().registerTask(bVar);
            this.hadCheckSocketTask = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyHttpCallback(int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65550, this, i2, str) == null) || this.httpCallback == null) {
            return;
        }
        MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.data, getHttpCmd());
        MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(getHttpCmd());
        mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
        mvcJsonHttpResponsedMessage.setError(i2);
        mvcJsonHttpResponsedMessage.setErrorString(str);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(RetrieveTaskManager.KEY, getHttpCmd() + "");
        this.httpCallback.onHttpResponseMessage(this.identifier, hashMap, mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyNetCallback(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65551, this, i2, str) == null) {
            MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.data, getHttpCmd(), getSocketCmd());
            if (this.socketCallback != null) {
                MvcSocketResponsedMessage mvcSocketResponsedMessage = new MvcSocketResponsedMessage(this, getSocketCmd()) { // from class: com.baidu.tieba.flutter.plugin.networkService.FlutterNetModelAuto.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FlutterNetModelAuto this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r8);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(r8)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                    public Class getProtobufResponseIdlClass() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            return null;
                        }
                        return (Class) invokeV.objValue;
                    }
                };
                mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
                mvcSocketResponsedMessage.setError(i2);
                mvcSocketResponsedMessage.setErrorString(str);
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(RetrieveTaskManager.KEY, getSocketCmd() + "");
                this.socketCallback.onSocketResponseMessage(this.identifier, hashMap, mvcSocketResponsedMessage, null, mvcNetMessage);
            } else if (this.httpCallback != null) {
                MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(this, getHttpCmd()) { // from class: com.baidu.tieba.flutter.plugin.networkService.FlutterNetModelAuto.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FlutterNetModelAuto this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r8);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(r8)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                    public Class<Error> getProtobufResponseIdlClass() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Error.class : (Class) invokeV.objValue;
                    }
                };
                mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
                mvcHttpResponsedMessage.setError(i2);
                mvcHttpResponsedMessage.setErrorString(str);
                HashMap<String, String> hashMap2 = new HashMap<>();
                hashMap2.put(RetrieveTaskManager.KEY, getHttpCmd() + "");
                this.httpCallback.onHttpResponseMessage(this.identifier, hashMap2, mvcHttpResponsedMessage, null, mvcNetMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifySocketCallback(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65552, this, i2, str) == null) {
            MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.data, getSocketCmd());
            MvcSocketResponsedMessage mvcSocketResponsedMessage = new MvcSocketResponsedMessage(this, getSocketCmd()) { // from class: com.baidu.tieba.flutter.plugin.networkService.FlutterNetModelAuto.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FlutterNetModelAuto this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(r8)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                public Class getProtobufResponseIdlClass() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        return null;
                    }
                    return (Class) invokeV.objValue;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
            mvcSocketResponsedMessage.setError(i2);
            mvcSocketResponsedMessage.setErrorString(str);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(RetrieveTaskManager.KEY, getSocketCmd() + "");
            this.socketCallback.onSocketResponseMessage(this.identifier, hashMap, mvcSocketResponsedMessage, mvcSocketMessage, null);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.networkService.NetworkServicePlugin.NetModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.isLoading = false;
            MessageManager.getInstance().removeMessage(getSocketCmd(), this.unique_id);
            MessageManager.getInstance().removeMessage(getHttpCmd(), this.unique_id);
            return true;
        }
        return invokeV.booleanValue;
    }

    public int getHttpCmd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mHttpCmd : invokeV.intValue;
    }

    public Class<? extends MvcJsonHttpResponsedMessage> getHttpJsonTaskMessageClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? MvcJsonHttpResponsedMessage.class : (Class) invokeV.objValue;
    }

    public Class<? extends MvcProtobufHttpResponsedMessage> getHttpProtobufTaskMessageClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? MvcProtobufHttpResponsedMessage.class : (Class) invokeV.objValue;
    }

    public String getHttpUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mHttpUrl : (String) invokeV.objValue;
    }

    public boolean getNeedCompress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mNeedCompress : invokeV.booleanValue;
    }

    public boolean getNeedParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.isNeedParallel : invokeV.booleanValue;
    }

    public T getRequestData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.data : (T) invokeV.objValue;
    }

    public Class<T> getRequestDataClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.requestDataClass : (Class) invokeV.objValue;
    }

    public Class<D> getResponseDataClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.responseDataClass : (Class) invokeV.objValue;
    }

    public int getSocketCmd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mSocketCmd : invokeV.intValue;
    }

    public TbSocketMessage getSocketRequestMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.socketMsg : (TbSocketMessage) invokeV.objValue;
    }

    public Class<? extends MvcSocketResponsedMessage> getSocketTaskMessageClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? MvcSocketResponsedMessage.class : (Class) invokeV.objValue;
    }

    public Runnable getTimeoutRunnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.timeoutRunnable == null) {
                this.timeoutRunnable = new Runnable(this) { // from class: com.baidu.tieba.flutter.plugin.networkService.FlutterNetModelAuto.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FlutterNetModelAuto this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            int i2 = AnonymousClass11.$SwitchMap$com$baidu$tieba$flutter$plugin$networkService$FlutterNetModelAuto$NetModelType[this.this$0.type.ordinal()];
                            if (i2 == 1) {
                                this.this$0.notifyNetCallback(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                            } else if (i2 == 2) {
                                this.this$0.notifySocketCallback(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                            } else if (i2 != 3) {
                            } else {
                                this.this$0.notifyHttpCallback(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                            }
                        }
                    }
                };
            }
            return this.timeoutRunnable;
        }
        return (Runnable) invokeV.objValue;
    }

    public BdUniqueId getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.unique_id : (BdUniqueId) invokeV.objValue;
    }

    public boolean isLoading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.isLoading : invokeV.booleanValue;
    }

    public boolean isNeedCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.isNeedCache : invokeV.booleanValue;
    }

    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.socketCallback == null && this.httpCallback == null && TbadkCoreApplication.getInst().isDebugMode()) {
                throw new RuntimeException("NetModel must have callback");
            }
            this.isNetOk = l.D();
            if (this.timeout >= 10) {
                e.a().postDelayed(getTimeoutRunnable(), this.timeout * 1000);
            }
            int i2 = AnonymousClass11.$SwitchMap$com$baidu$tieba$flutter$plugin$networkService$FlutterNetModelAuto$NetModelType[this.type.ordinal()];
            if (i2 == 1) {
                if (!this.isNetOk) {
                    e.a().post(new Runnable(this) { // from class: com.baidu.tieba.flutter.plugin.networkService.FlutterNetModelAuto.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ FlutterNetModelAuto this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.this$0.notifyNetCallback(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                            }
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                checkHttpProtobufTask();
                checkSocketTask();
                checkListener();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.data, getHttpCmd(), getSocketCmd());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                HashMap<String, String> u = this.data.u();
                if (u != null) {
                    for (Map.Entry<String, String> entry : u.entrySet()) {
                        mvcNetMessage.getHttpMessage().addHeader(entry.getKey(), entry.getValue());
                    }
                }
                MessageManager.getInstance().sendMessage(mvcNetMessage);
                return true;
            } else if (i2 == 2) {
                if (!this.isNetOk) {
                    e.a().post(new Runnable(this) { // from class: com.baidu.tieba.flutter.plugin.networkService.FlutterNetModelAuto.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ FlutterNetModelAuto this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.this$0.notifySocketCallback(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                            }
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                checkSocketTask();
                checkListener();
                if (this.data != null) {
                    MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.data, getSocketCmd());
                    mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                    mvcSocketMessage.setNeedCache(isNeedCache());
                    mvcSocketMessage.setTag(this.unique_id);
                    MessageManager.getInstance().sendMessage(mvcSocketMessage);
                }
                if (this.socketMsg != null) {
                    MessageManager.getInstance().sendMessage(this.socketMsg);
                }
                return true;
            } else if (i2 != 3) {
                return false;
            } else {
                if (!this.isNetOk) {
                    e.a().post(new Runnable(this) { // from class: com.baidu.tieba.flutter.plugin.networkService.FlutterNetModelAuto.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ FlutterNetModelAuto this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.this$0.notifyHttpCallback(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                            }
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                checkHttpJsonTask();
                checkListener();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.data, getHttpCmd());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> s = this.data.s();
                if (s != null) {
                    for (Map.Entry<String, Object> entry2 : s.entrySet()) {
                        mvcHttpMessage.addParam(entry2.getKey(), entry2.getValue());
                    }
                }
                HashMap<String, String> u2 = this.data.u();
                if (u2 != null) {
                    for (Map.Entry<String, String> entry3 : u2.entrySet()) {
                        mvcHttpMessage.addHeader(entry3.getKey(), entry3.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                MessageManager.getInstance().sendMessage(mvcHttpMessage);
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public boolean loadNextPageData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public boolean loadPrevPageData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onRegisterHttpJsonTask(TbHttpMessageTask tbHttpMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, tbHttpMessageTask) == null) {
        }
    }

    public void onRegisterHttpProtobufTask(TbHttpMessageTask tbHttpMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, tbHttpMessageTask) == null) {
        }
    }

    public void onRegisterSocketTask(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bVar) == null) {
        }
    }

    public void setCallback(NetModelCallback<T, D> netModelCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, netModelCallback) == null) {
            this.httpCallback = netModelCallback;
            this.socketCallback = netModelCallback;
        }
    }

    public void setHttpCallback(NetModelHttpCallback<T, D> netModelHttpCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, netModelHttpCallback) == null) {
            this.httpCallback = netModelHttpCallback;
        }
    }

    public void setHttpCmd(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.mHttpCmd = i2;
        }
    }

    public void setHttpUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.mHttpUrl = str;
        }
    }

    public void setNeedCache(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.isNeedCache = z;
        }
    }

    public void setNeedCompress(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.mNeedCompress = z;
        }
    }

    public void setNeedParallel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.isNeedParallel = z;
        }
    }

    public void setRequestData(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, t) == null) {
            this.data = t;
        }
    }

    public void setRequestDataClass(Class<T> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, cls) == null) {
            this.requestDataClass = cls;
        }
    }

    public void setResponseDataClass(Class<D> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, cls) == null) {
            this.responseDataClass = cls;
        }
    }

    public void setSocketCallback(NetModelSocketCallback<T, D> netModelSocketCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, netModelSocketCallback) == null) {
            this.socketCallback = netModelSocketCallback;
        }
    }

    public void setSocketCmd(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            this.mSocketCmd = i2;
        }
    }

    public void setSocketRequestMsg(TbSocketMessage tbSocketMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, tbSocketMessage) == null) {
            this.socketMsg = tbSocketMessage;
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, bdUniqueId) == null) {
            this.unique_id = bdUniqueId;
        }
    }
}
