package com.baidu.tbadk.mvc.model;

import android.text.TextUtils;
import c.a.d.f.p.n;
import c.a.q0.k0.b.g;
import c.a.q0.k0.b.h;
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
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import protobuf.Error;
/* loaded from: classes5.dex */
public abstract class NetModel<T extends c.a.q0.k0.b.g, D extends c.a.q0.k0.b.h, ActivityType> extends BdBaseModel<ActivityType> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public l<T, D> f39721e;

    /* renamed from: f  reason: collision with root package name */
    public m<T, D> f39722f;

    /* renamed from: g  reason: collision with root package name */
    public T f39723g;

    /* renamed from: h  reason: collision with root package name */
    public final NetModelType f39724h;

    /* renamed from: i  reason: collision with root package name */
    public j<T, D, ActivityType> f39725i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f39726j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public int o;
    public boolean p;
    public Runnable q;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NetModel f39727e;

        public b(NetModel netModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {netModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39727e = netModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = a.a[this.f39727e.f39724h.ordinal()];
                if (i2 == 1) {
                    this.f39727e.S(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                } else if (i2 == 2) {
                    this.f39727e.T(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                } else if (i2 == 3 || i2 == 4) {
                    this.f39727e.R(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NetModel f39728e;

        public c(NetModel netModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {netModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39728e = netModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f39728e.S(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NetModel f39729e;

        public d(NetModel netModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {netModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39729e = netModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f39729e.R(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NetModel f39730e;

        public e(NetModel netModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {netModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39730e = netModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f39730e.T(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NetModel f39731e;

        public f(NetModel netModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {netModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39731e = netModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f39731e.R(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NetModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(NetModel netModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {netModel, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
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
        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.n = false;
                if (this.a.q != null) {
                    c.a.d.f.m.e.a().removeCallbacks(this.a.q);
                }
                if (responsedMessage instanceof MvcProtobufHttpResponsedMessage) {
                    MvcNetMessage mvcNetMessage = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                    if (this.a.f39721e != null) {
                        this.a.f39721e.p((MvcProtobufHttpResponsedMessage) responsedMessage, null, mvcNetMessage);
                    }
                } else if (responsedMessage instanceof MvcSocketResponsedMessage) {
                    MvcNetMessage mvcNetMessage2 = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                    if (this.a.f39722f != null) {
                        this.a.f39722f.k((MvcSocketResponsedMessage) responsedMessage, null, mvcNetMessage2);
                    }
                } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new RuntimeException("mvc netmodel NetListener responsedMessage error");
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NetModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(NetModel netModel, int i2, boolean z) {
            super(i2, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {netModel, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                this.a.n = false;
                if (this.a.q != null) {
                    c.a.d.f.m.e.a().removeCallbacks(this.a.q);
                }
                if (httpResponsedMessage instanceof MvcJsonHttpResponsedMessage) {
                    if (httpResponsedMessage.getOrginalMessage() instanceof MvcHttpMessage) {
                        if (this.a.f39721e != null) {
                            this.a.f39721e.p((MvcJsonHttpResponsedMessage) httpResponsedMessage, (MvcHttpMessage) httpResponsedMessage.getOrginalMessage(), null);
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

    /* loaded from: classes5.dex */
    public class i extends c.a.d.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NetModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(NetModel netModel, int i2, boolean z) {
            super(i2, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {netModel, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                this.a.n = false;
                if (this.a.q != null) {
                    c.a.d.f.m.e.a().removeCallbacks(this.a.q);
                }
                if (socketResponsedMessage instanceof MvcSocketResponsedMessage) {
                    if (socketResponsedMessage.getOrginalMessage() instanceof MvcSocketMessage) {
                        if (this.a.f39722f != null) {
                            this.a.f39722f.k((MvcSocketResponsedMessage) socketResponsedMessage, (MvcSocketMessage) socketResponsedMessage.getOrginalMessage(), null);
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

    /* loaded from: classes5.dex */
    public static class j<T extends c.a.q0.k0.b.g, D extends c.a.q0.k0.b.h, ActivityType> extends BdAsyncTask<Object, D, D> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetModel<T, D, ActivityType> a;

        /* renamed from: b  reason: collision with root package name */
        public HttpNetContext f39732b;

        public j(NetModel<T, D, ActivityType> netModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {netModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                } catch (ExceptionInInitializerError e2) {
                    e2.printStackTrace();
                    return null;
                } catch (IllegalAccessException e3) {
                    e3.printStackTrace();
                    return null;
                } catch (InstantiationException e4) {
                    e4.printStackTrace();
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
                this.a.n = true;
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + this.a.M());
                for (Map.Entry<String, Object> entry : this.a.f39723g.s().entrySet()) {
                    netWork.addPostData(entry.getKey(), String.valueOf(entry.getValue()));
                }
                String postNetData = netWork.postNetData();
                this.f39732b = netWork.getNetContext();
                D b2 = b(this.a.getResponseDataClass());
                if (postNetData != null) {
                    try {
                        b2.initByJson(new JSONObject(postNetData));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                publishProgress(b2);
                if (this.a.isNeedCache() && (httpNetContext = this.f39732b) != null && httpNetContext.getResponse() != null && this.f39732b.getResponse().isRequestSuccess() && b2 != null) {
                    T t = this.a.f39723g;
                    if (t instanceof c.a.q0.k0.b.d) {
                        c.a.q0.k0.b.d dVar = (c.a.q0.k0.b.d) t;
                        String cacheKey = dVar.getCacheKey();
                        String v = dVar.v();
                        String currentAccount = dVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                        if (cacheKey != null && !TextUtils.isEmpty(v) && b2 != null) {
                            c.a.q0.r.s.a.f();
                            c.a.d.f.d.l<String> h2 = c.a.q0.r.s.a.h(v, currentAccount);
                            if (h2 == null) {
                                return b2;
                            }
                            h2.g(cacheKey, postNetData);
                        }
                    }
                }
                return b2;
            }
            return (D) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(D d2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2) == null) {
                super.onPostExecute(d2);
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
                this.a.n = false;
                if (this.a.q != null) {
                    c.a.d.f.m.e.a().removeCallbacks(this.a.q);
                }
                NetModel<T, D, ActivityType> netModel = this.a;
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(netModel.f39723g, netModel.J());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.a.J());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                HttpNetContext httpNetContext = this.f39732b;
                if (httpNetContext != null && httpNetContext.getResponse() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.f39732b.getResponse().mNetErrorCode, this.f39732b.getResponse().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.f39732b.getResponse().mServerErrorCode);
                    mvcJsonHttpResponsedMessage.setErrorString(this.f39732b.getResponse().mErrorString);
                    if (this.f39732b.getResponse().mException != null) {
                        BdLog.e(this.f39732b.getResponse().mException);
                    }
                }
                this.a.X();
                if (this.a.f39721e != null) {
                    this.a.f39721e.p(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface k<T extends c.a.q0.k0.b.g, D extends c.a.q0.k0.b.h> extends l<T, D>, m<T, D> {
    }

    /* loaded from: classes5.dex */
    public interface l<T extends c.a.q0.k0.b.g, D extends c.a.q0.k0.b.h> {
        void p(MvcHttpResponsedMessage<D> mvcHttpResponsedMessage, MvcHttpMessage<T, D> mvcHttpMessage, MvcNetMessage<T, D> mvcNetMessage);
    }

    /* loaded from: classes5.dex */
    public interface m<T extends c.a.q0.k0.b.g, D extends c.a.q0.k0.b.h> {
        void k(MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage, MvcSocketMessage<T, D> mvcSocketMessage, MvcNetMessage<T, D> mvcNetMessage);
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
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39725i = null;
        this.f39726j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = -1;
        this.p = true;
        this.f39723g = t;
        this.f39724h = netModelType;
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.k && MessageManager.getInstance().findTask(J()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(J(), TbConfig.SERVER_ADDRESS + M());
            tbHttpMessageTask.setResponsedClass(K());
            U(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(J());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.k = true;
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !this.k && MessageManager.getInstance().findTask(J()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(J(), TbConfig.SERVER_ADDRESS + M() + "?cmd=" + N());
            tbHttpMessageTask.setResponsedClass(L());
            V(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(J());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.k = true;
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.m) {
            return;
        }
        int i2 = a.a[this.f39724h.ordinal()];
        if (i2 == 1) {
            g gVar = new g(this, J(), N());
            gVar.getHttpMessageListener().setSelfListener(true);
            gVar.getSocketMessageListener().setSelfListener(true);
            gVar.setTag(getUniqueId());
            registerListener(gVar);
        } else if (i2 == 2) {
            i iVar = new i(this, N(), true);
            iVar.setTag(getUniqueId());
            registerListener(iVar);
        } else if (i2 == 3) {
            h hVar = new h(this, J(), true);
            hVar.setTag(getUniqueId());
            registerListener(hVar);
        }
        this.m = true;
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && !this.l && MessageManager.getInstance().findTask(N()) == null) {
            c.a.q0.z0.b bVar = new c.a.q0.z0.b(N());
            bVar.setResponsedClass(O());
            W(bVar);
            MessageManager.getInstance().unRegisterTask(N());
            MessageManager.getInstance().registerTask(bVar);
            this.l = true;
        }
    }

    public abstract int J();

    public Class<? extends MvcJsonHttpResponsedMessage> K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? MvcJsonHttpResponsedMessage.class : (Class) invokeV.objValue;
    }

    public Class<? extends MvcProtobufHttpResponsedMessage> L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? MvcProtobufHttpResponsedMessage.class : (Class) invokeV.objValue;
    }

    public abstract String M();

    public abstract int N();

    public Class<? extends MvcSocketResponsedMessage> O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? MvcSocketResponsedMessage.class : (Class) invokeV.objValue;
    }

    public Runnable P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.q == null) {
                this.q = new b(this);
            }
            return this.q;
        }
        return (Runnable) invokeV.objValue;
    }

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public final void R(int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048588, this, i2, str) == null) || this.f39721e == null) {
            return;
        }
        MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.f39723g, J());
        MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(J());
        mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
        mvcJsonHttpResponsedMessage.setError(i2);
        mvcJsonHttpResponsedMessage.setErrorString(str);
        this.f39721e.p(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
    }

    public final void S(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048589, this, i2, str) == null) {
            MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.f39723g, J(), N());
            if (this.f39722f != null) {
                MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(this, N()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
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
                this.f39722f.k(mvcSocketResponsedMessage, null, mvcNetMessage);
            } else if (this.f39721e != null) {
                MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(this, J()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
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
                this.f39721e.p(mvcHttpResponsedMessage, null, mvcNetMessage);
            }
        }
    }

    public final void T(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048590, this, i2, str) == null) {
            MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.f39723g, N());
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(this, N()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
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
            this.f39722f.k(mvcSocketResponsedMessage, mvcSocketMessage, null);
        }
    }

    public void U(TbHttpMessageTask tbHttpMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, tbHttpMessageTask) == null) {
        }
    }

    public void V(TbHttpMessageTask tbHttpMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, tbHttpMessageTask) == null) {
        }
    }

    public void W(c.a.q0.z0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
        }
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f39725i = null;
        }
    }

    public void Y(k<T, D> kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, kVar) == null) {
            this.f39721e = kVar;
            this.f39722f = kVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            this.n = false;
            MessageManager.getInstance().removeMessage(N(), this.unique_id);
            MessageManager.getInstance().removeMessage(J(), this.unique_id);
            return true;
        }
        return invokeV.booleanValue;
    }

    public abstract Class<D> getResponseDataClass();

    public boolean isNeedCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f39726j : invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.f39722f == null && this.f39721e == null && TbadkCoreApplication.getInst().isDebugMode()) {
                throw new RuntimeException("NetModel must have callback");
            }
            this.p = n.C();
            if (this.o >= 10) {
                c.a.d.f.m.e.a().postDelayed(P(), this.o * 1000);
            }
            int i2 = a.a[this.f39724h.ordinal()];
            if (i2 == 1) {
                if (!this.p) {
                    c.a.d.f.m.e.a().post(new c(this));
                    return false;
                }
                this.n = true;
                G();
                I();
                H();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.f39723g, J(), N());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                HashMap<String, String> u = this.f39723g.u();
                if (u != null) {
                    for (Map.Entry<String, String> entry : u.entrySet()) {
                        mvcNetMessage.getHttpMessage().addHeader(entry.getKey(), entry.getValue());
                    }
                }
                sendMessage(mvcNetMessage);
                return true;
            } else if (i2 == 2) {
                if (!this.p) {
                    c.a.d.f.m.e.a().post(new e(this));
                    return false;
                }
                this.n = true;
                I();
                H();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.f39723g, N());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            } else if (i2 != 3) {
                if (i2 == 4) {
                    if (!this.p) {
                        c.a.d.f.m.e.a().post(new f(this));
                        return false;
                    } else if (this.f39725i == null) {
                        j<T, D, ActivityType> jVar = new j<>(this);
                        this.f39725i = jVar;
                        jVar.execute(new Object[0]);
                        return true;
                    }
                }
                return false;
            } else if (!this.p) {
                c.a.d.f.m.e.a().post(new d(this));
                return false;
            } else {
                this.n = true;
                F();
                H();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.f39723g, J());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> s = this.f39723g.s();
                if (s != null) {
                    for (Map.Entry<String, Object> entry2 : s.entrySet()) {
                        mvcHttpMessage.addParam(entry2.getKey(), entry2.getValue());
                    }
                }
                HashMap<String, String> u2 = this.f39723g.u();
                if (u2 != null) {
                    for (Map.Entry<String, String> entry3 : u2.entrySet()) {
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
            this.f39726j = z;
        }
    }
}
