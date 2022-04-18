package com.baidu.tbadk.mvc.model;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.httpNet.HttpNetContext;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcJsonHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b9;
import com.repackage.br4;
import com.repackage.l65;
import com.repackage.l95;
import com.repackage.o65;
import com.repackage.oi;
import com.repackage.p65;
import com.repackage.pg;
import com.repackage.qe;
import com.repackage.wa;
import com.repackage.ya;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import protobuf.Error;
/* loaded from: classes3.dex */
public abstract class NetModel<T extends o65, D extends p65, ActivityType> extends BdBaseModel<ActivityType> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public l<T, D> a;
    public m<T, D> b;
    public T c;
    public final NetModelType d;
    public j<T, D, ActivityType> e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public int k;
    public boolean l;
    public Runnable m;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class NetModelType {
        public static final /* synthetic */ NetModelType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final NetModelType TYPE_AUTO;
        public static final NetModelType TYPE_HTTP;
        public static final NetModelType TYPE_NETWORK;
        public static final NetModelType TYPE_SOCKET;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(638797115, "Lcom/baidu/tbadk/mvc/model/NetModel$NetModelType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(638797115, "Lcom/baidu/tbadk/mvc/model/NetModel$NetModelType;");
                    return;
                }
            }
            TYPE_HTTP = new NetModelType("TYPE_HTTP", 0);
            TYPE_SOCKET = new NetModelType("TYPE_SOCKET", 1);
            TYPE_AUTO = new NetModelType("TYPE_AUTO", 2);
            NetModelType netModelType = new NetModelType("TYPE_NETWORK", 3);
            TYPE_NETWORK = netModelType;
            $VALUES = new NetModelType[]{TYPE_HTTP, TYPE_SOCKET, TYPE_AUTO, netModelType};
        }

        public NetModelType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2087971444, "Lcom/baidu/tbadk/mvc/model/NetModel$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2087971444, "Lcom/baidu/tbadk/mvc/model/NetModel$a;");
                    return;
                }
            }
            int[] iArr = new int[NetModelType.values().length];
            a = iArr;
            try {
                iArr[NetModelType.TYPE_AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[NetModelType.TYPE_SOCKET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[NetModelType.TYPE_HTTP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[NetModelType.TYPE_NETWORK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NetModel a;

        public b(NetModel netModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {netModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = netModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = a.a[this.a.d.ordinal()];
                if (i == 1) {
                    this.a.U(-1, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c17));
                } else if (i == 2) {
                    this.a.V(-1, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c17));
                } else if (i == 3 || i == 4) {
                    this.a.T(-1, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c17));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NetModel a;

        public c(NetModel netModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {netModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = netModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.U(-1, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c17));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NetModel a;

        public d(NetModel netModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {netModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = netModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.T(-1, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c17));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NetModel a;

        public e(NetModel netModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {netModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = netModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.V(-1, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c17));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NetModel a;

        public f(NetModel netModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {netModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = netModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.T(-1, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c17));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NetModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(NetModel netModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {netModel, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = netModel;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.baidu.tbadk.mvc.model.NetModel$m */
        /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: com.baidu.tbadk.mvc.model.NetModel$l */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.j = false;
                if (this.a.m != null) {
                    pg.a().removeCallbacks(this.a.m);
                }
                if (responsedMessage instanceof MvcProtobufHttpResponsedMessage) {
                    MvcNetMessage mvcNetMessage = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                    if (this.a.a != null) {
                        this.a.a.r((MvcProtobufHttpResponsedMessage) responsedMessage, null, mvcNetMessage);
                    }
                } else if (responsedMessage instanceof MvcSocketResponsedMessage) {
                    MvcNetMessage mvcNetMessage2 = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                    if (this.a.b != null) {
                        this.a.b.m((MvcSocketResponsedMessage) responsedMessage, null, mvcNetMessage2);
                    }
                } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new RuntimeException("mvc netmodel NetListener responsedMessage error");
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NetModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(NetModel netModel, int i, boolean z) {
            super(i, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {netModel, Integer.valueOf(i), Boolean.valueOf(z)};
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
            this.a = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                this.a.j = false;
                if (this.a.m != null) {
                    pg.a().removeCallbacks(this.a.m);
                }
                if (httpResponsedMessage instanceof MvcJsonHttpResponsedMessage) {
                    if (httpResponsedMessage.getOrginalMessage() instanceof MvcHttpMessage) {
                        if (this.a.a != null) {
                            this.a.a.r((MvcJsonHttpResponsedMessage) httpResponsedMessage, (MvcHttpMessage) httpResponsedMessage.getOrginalMessage(), null);
                        }
                    } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                        throw new RuntimeException("mvc netmodel HttpListener jsonHttpResponsedMessage originaMessage error");
                    }
                } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new RuntimeException("mvc netmodel HttpListener jsonHttpResponsedMessage error");
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends ya {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NetModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(NetModel netModel, int i, boolean z) {
            super(i, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {netModel, Integer.valueOf(i), Boolean.valueOf(z)};
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
            this.a = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                this.a.j = false;
                if (this.a.m != null) {
                    pg.a().removeCallbacks(this.a.m);
                }
                if (socketResponsedMessage instanceof MvcSocketResponsedMessage) {
                    if (socketResponsedMessage.getOrginalMessage() instanceof MvcSocketMessage) {
                        if (this.a.b != null) {
                            this.a.b.m((MvcSocketResponsedMessage) socketResponsedMessage, (MvcSocketMessage) socketResponsedMessage.getOrginalMessage(), null);
                        }
                    } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                        throw new RuntimeException("mvc netmodel SocketListener socketResponsedMessage originaMessage error");
                    }
                } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new RuntimeException("mvc netmodel SocketListener socketResponsedMessage error");
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class j<T extends o65, D extends p65, ActivityType> extends BdAsyncTask<Object, D, D> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetModel<T, D, ActivityType> a;
        public HttpNetContext b;

        public j(NetModel<T, D, ActivityType> netModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {netModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = netModel;
        }

        public D b(Class<D> cls) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
                try {
                    return cls.newInstance();
                } catch (ExceptionInInitializerError e) {
                    e.printStackTrace();
                    return null;
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                    return null;
                } catch (InstantiationException e3) {
                    e3.printStackTrace();
                    return null;
                }
            }
            return (D) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public D doInBackground(Object... objArr) {
            InterceptResult invokeL;
            HttpNetContext httpNetContext;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr)) == null) {
                this.a.j = true;
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + this.a.O());
                for (Map.Entry<String, Object> entry : this.a.c.u().entrySet()) {
                    netWork.addPostData(entry.getKey(), String.valueOf(entry.getValue()));
                }
                String postNetData = netWork.postNetData();
                this.b = netWork.getNetContext();
                D b = b(this.a.getResponseDataClass());
                if (postNetData != null) {
                    try {
                        b.initByJson(new JSONObject(postNetData));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                publishProgress(b);
                if (this.a.isNeedCache() && (httpNetContext = this.b) != null && httpNetContext.getResponse() != null && this.b.getResponse().isRequestSuccess() && b != null) {
                    T t = this.a.c;
                    if (t instanceof l65) {
                        l65 l65Var = (l65) t;
                        String cacheKey = l65Var.getCacheKey();
                        String x = l65Var.x();
                        String currentAccount = l65Var.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                        if (cacheKey != null && !TextUtils.isEmpty(x) && b != null) {
                            br4.f();
                            qe<String> h = br4.h(x, currentAccount);
                            if (h == null) {
                                return b;
                            }
                            h.g(cacheKey, postNetData);
                        }
                    }
                }
                return b;
            }
            return (D) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(D d) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d) == null) {
                super.onPostExecute(d);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public void onProgressUpdate(D... dArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, dArr) == null) {
                super.onProgressUpdate(dArr);
                if (dArr == null || dArr.length <= 0) {
                    return;
                }
                this.a.j = false;
                if (this.a.m != null) {
                    pg.a().removeCallbacks(this.a.m);
                }
                NetModel<T, D, ActivityType> netModel = this.a;
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(netModel.c, netModel.L());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.a.L());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                HttpNetContext httpNetContext = this.b;
                if (httpNetContext != null && httpNetContext.getResponse() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.b.getResponse().mNetErrorCode, this.b.getResponse().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.b.getResponse().mServerErrorCode);
                    mvcJsonHttpResponsedMessage.setErrorString(this.b.getResponse().mErrorString);
                    if (this.b.getResponse().mException != null) {
                        BdLog.e(this.b.getResponse().mException);
                    }
                }
                this.a.Z();
                if (this.a.a != null) {
                    this.a.a.r(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface k<T extends o65, D extends p65> extends l<T, D>, m<T, D> {
    }

    /* loaded from: classes3.dex */
    public interface l<T extends o65, D extends p65> {
        void r(MvcHttpResponsedMessage<D> mvcHttpResponsedMessage, MvcHttpMessage<T, D> mvcHttpMessage, MvcNetMessage<T, D> mvcNetMessage);
    }

    /* loaded from: classes3.dex */
    public interface m<T extends o65, D extends p65> {
        void m(MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage, MvcSocketMessage<T, D> mvcSocketMessage, MvcNetMessage<T, D> mvcNetMessage);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, t, netModelType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = null;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = -1;
        this.l = true;
        this.c = t;
        this.d = netModelType;
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.g && MessageManager.getInstance().findTask(L()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(L(), TbConfig.SERVER_ADDRESS + O());
            tbHttpMessageTask.setResponsedClass(M());
            W(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(L());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.g = true;
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !this.g && MessageManager.getInstance().findTask(L()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(L(), TbConfig.SERVER_ADDRESS + O() + "?cmd=" + P());
            tbHttpMessageTask.setResponsedClass(N());
            X(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(L());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.g = true;
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.i) {
            return;
        }
        int i2 = a.a[this.d.ordinal()];
        if (i2 == 1) {
            g gVar = new g(this, L(), P());
            gVar.getHttpMessageListener().setSelfListener(true);
            gVar.getSocketMessageListener().setSelfListener(true);
            gVar.setTag(getUniqueId());
            registerListener(gVar);
        } else if (i2 == 2) {
            i iVar = new i(this, P(), true);
            iVar.setTag(getUniqueId());
            registerListener(iVar);
        } else if (i2 == 3) {
            h hVar = new h(this, L(), true);
            hVar.setTag(getUniqueId());
            registerListener(hVar);
        }
        this.i = true;
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && !this.h && MessageManager.getInstance().findTask(P()) == null) {
            l95 l95Var = new l95(P());
            l95Var.setResponsedClass(Q());
            Y(l95Var);
            MessageManager.getInstance().unRegisterTask(P());
            MessageManager.getInstance().registerTask(l95Var);
            this.h = true;
        }
    }

    public abstract int L();

    public Class<? extends MvcJsonHttpResponsedMessage> M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? MvcJsonHttpResponsedMessage.class : (Class) invokeV.objValue;
    }

    public Class<? extends MvcProtobufHttpResponsedMessage> N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? MvcProtobufHttpResponsedMessage.class : (Class) invokeV.objValue;
    }

    public abstract String O();

    public abstract int P();

    public Class<? extends MvcSocketResponsedMessage> Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? MvcSocketResponsedMessage.class : (Class) invokeV.objValue;
    }

    public Runnable R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.m == null) {
                this.m = new b(this);
            }
            return this.m;
        }
        return (Runnable) invokeV.objValue;
    }

    public boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public final void T(int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048588, this, i2, str) == null) || this.a == null) {
            return;
        }
        MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.c, L());
        MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(L());
        mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
        mvcJsonHttpResponsedMessage.setError(i2);
        mvcJsonHttpResponsedMessage.setErrorString(str);
        this.a.r(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
    }

    public final void U(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048589, this, i2, str) == null) {
            MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.c, L(), P());
            if (this.b != null) {
                MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(this, P()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ NetModel this$0;

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
                this.b.m(mvcSocketResponsedMessage, null, mvcNetMessage);
            } else if (this.a != null) {
                MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(this, L()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ NetModel this$0;

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
                this.a.r(mvcHttpResponsedMessage, null, mvcNetMessage);
            }
        }
    }

    public final void V(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048590, this, i2, str) == null) {
            MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.c, P());
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(this, P()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NetModel this$0;

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
            this.b.m(mvcSocketResponsedMessage, mvcSocketMessage, null);
        }
    }

    public void W(TbHttpMessageTask tbHttpMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, tbHttpMessageTask) == null) {
        }
    }

    public void X(TbHttpMessageTask tbHttpMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, tbHttpMessageTask) == null) {
        }
    }

    public void Y(l95 l95Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, l95Var) == null) {
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.e = null;
        }
    }

    public void a0(k<T, D> kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, kVar) == null) {
            this.a = kVar;
            this.b = kVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            this.j = false;
            MessageManager.getInstance().removeMessage(P(), this.unique_id);
            MessageManager.getInstance().removeMessage(L(), this.unique_id);
            return true;
        }
        return invokeV.booleanValue;
    }

    public abstract Class<D> getResponseDataClass();

    public boolean isNeedCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f : invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.b == null && this.a == null && TbadkCoreApplication.getInst().isDebugMode()) {
                throw new RuntimeException("NetModel must have callback");
            }
            this.l = oi.C();
            if (this.k >= 10) {
                pg.a().postDelayed(R(), this.k * 1000);
            }
            int i2 = a.a[this.d.ordinal()];
            if (i2 == 1) {
                if (!this.l) {
                    pg.a().post(new c(this));
                    return false;
                }
                this.j = true;
                I();
                K();
                J();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.c, L(), P());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                HashMap<String, String> w = this.c.w();
                if (w != null) {
                    for (Map.Entry<String, String> entry : w.entrySet()) {
                        mvcNetMessage.getHttpMessage().addHeader(entry.getKey(), entry.getValue());
                    }
                }
                sendMessage(mvcNetMessage);
                return true;
            } else if (i2 == 2) {
                if (!this.l) {
                    pg.a().post(new e(this));
                    return false;
                }
                this.j = true;
                K();
                J();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.c, P());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            } else if (i2 != 3) {
                if (i2 == 4) {
                    if (!this.l) {
                        pg.a().post(new f(this));
                        return false;
                    } else if (this.e == null) {
                        j<T, D, ActivityType> jVar = new j<>(this);
                        this.e = jVar;
                        jVar.execute(new Object[0]);
                        return true;
                    }
                }
                return false;
            } else if (!this.l) {
                pg.a().post(new d(this));
                return false;
            } else {
                this.j = true;
                H();
                J();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.c, L());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> u = this.c.u();
                if (u != null) {
                    for (Map.Entry<String, Object> entry2 : u.entrySet()) {
                        mvcHttpMessage.addParam(entry2.getKey(), entry2.getValue());
                    }
                }
                HashMap<String, String> w2 = this.c.w();
                if (w2 != null) {
                    for (Map.Entry<String, String> entry3 : w2.entrySet()) {
                        mvcHttpMessage.addHeader(entry3.getKey(), entry3.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public void setNeedCache(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.f = z;
        }
    }
}
