package com.baidu.tbadk.mvc.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.network.http.IHttpNet;
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
import com.baidu.tieba.b55;
import com.baidu.tieba.jb;
import com.baidu.tieba.k9;
import com.baidu.tieba.lb;
import com.baidu.tieba.mt5;
import com.baidu.tieba.nq5;
import com.baidu.tieba.qq5;
import com.baidu.tieba.rq5;
import com.baidu.tieba.vi;
import com.baidu.tieba.we;
import com.baidu.tieba.wg;
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
/* loaded from: classes4.dex */
public abstract class NetModel<T extends qq5, D extends rq5, ActivityType> extends BdBaseModel<ActivityType> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public l<T, D> a;
    public m<T, D> b;
    public T c;
    public final NetModelType d;
    public boolean e;
    public j<T, D, ActivityType> f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public int l;
    public boolean m;
    public Runnable n;

    /* loaded from: classes4.dex */
    public interface k<T extends qq5, D extends rq5> extends l<T, D>, m<T, D> {
    }

    /* loaded from: classes4.dex */
    public interface l<T extends qq5, D extends rq5> {
        void L(MvcHttpResponsedMessage<D> mvcHttpResponsedMessage, MvcHttpMessage<T, D> mvcHttpMessage, MvcNetMessage<T, D> mvcNetMessage);
    }

    /* loaded from: classes4.dex */
    public interface m<T extends qq5, D extends rq5> {
        void z(MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage, MvcSocketMessage<T, D> mvcSocketMessage, MvcNetMessage<T, D> mvcNetMessage);
    }

    public abstract Class<D> getResponseDataClass();

    public abstract int h0();

    public abstract String k0();

    public abstract int l0();

    public void s0(TbHttpMessageTask tbHttpMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, tbHttpMessageTask) == null) {
        }
    }

    public void t0(TbHttpMessageTask tbHttpMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, tbHttpMessageTask) == null) {
        }
    }

    public void u0(mt5 mt5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, mt5Var) == null) {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (NetModelType) Enum.valueOf(NetModelType.class, str);
            }
            return (NetModelType) invokeL.objValue;
        }

        public static NetModelType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (NetModelType[]) $VALUES.clone();
            }
            return (NetModelType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3 && i != 4) {
                            return;
                        }
                        this.a.p0(-1, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0def));
                        return;
                    }
                    this.a.r0(-1, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0def));
                    return;
                }
                this.a.q0(-1, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0def));
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.q0(-1, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0def));
        }
    }

    /* loaded from: classes4.dex */
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
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.p0(-1, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0def));
        }
    }

    /* loaded from: classes4.dex */
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
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.r0(-1, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0def));
        }
    }

    /* loaded from: classes4.dex */
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
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.p0(-1, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0def));
        }
    }

    /* loaded from: classes4.dex */
    public class g extends jb {
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
        @Override // com.baidu.tieba.jb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            MvcNetMessage mvcNetMessage;
            MvcNetMessage mvcNetMessage2;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) {
                return;
            }
            this.a.k = false;
            if (this.a.n != null) {
                wg.a().removeCallbacks(this.a.n);
            }
            if (responsedMessage instanceof MvcProtobufHttpResponsedMessage) {
                if (responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage) {
                    mvcNetMessage2 = (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra();
                } else {
                    mvcNetMessage2 = null;
                }
                if (this.a.a != null) {
                    this.a.a.L((MvcProtobufHttpResponsedMessage) responsedMessage, null, mvcNetMessage2);
                }
            } else if (responsedMessage instanceof MvcSocketResponsedMessage) {
                if (responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage) {
                    mvcNetMessage = (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra();
                } else {
                    mvcNetMessage = null;
                }
                if (this.a.b != null) {
                    this.a.b.z((MvcSocketResponsedMessage) responsedMessage, null, mvcNetMessage);
                }
            } else if (!TbadkCoreApplication.getInst().isDebugMode()) {
            } else {
                throw new RuntimeException("mvc netmodel NetListener responsedMessage error");
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if (interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) {
                return;
            }
            this.a.k = false;
            if (this.a.n != null) {
                wg.a().removeCallbacks(this.a.n);
            }
            if (httpResponsedMessage instanceof MvcJsonHttpResponsedMessage) {
                if (httpResponsedMessage.getOrginalMessage() instanceof MvcHttpMessage) {
                    if (this.a.a != null) {
                        this.a.a.L((MvcJsonHttpResponsedMessage) httpResponsedMessage, (MvcHttpMessage) httpResponsedMessage.getOrginalMessage(), null);
                    }
                } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new RuntimeException("mvc netmodel HttpListener jsonHttpResponsedMessage originaMessage error");
                }
            } else if (!TbadkCoreApplication.getInst().isDebugMode()) {
            } else {
                throw new RuntimeException("mvc netmodel HttpListener jsonHttpResponsedMessage error");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends lb {
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
        /* renamed from: a */
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, socketResponsedMessage) != null) {
                return;
            }
            this.a.k = false;
            if (this.a.n != null) {
                wg.a().removeCallbacks(this.a.n);
            }
            if (socketResponsedMessage instanceof MvcSocketResponsedMessage) {
                if (socketResponsedMessage.getOrginalMessage() instanceof MvcSocketMessage) {
                    if (this.a.b != null) {
                        this.a.b.z((MvcSocketResponsedMessage) socketResponsedMessage, (MvcSocketMessage) socketResponsedMessage.getOrginalMessage(), null);
                    }
                } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new RuntimeException("mvc netmodel SocketListener socketResponsedMessage originaMessage error");
                }
            } else if (!TbadkCoreApplication.getInst().isDebugMode()) {
            } else {
                throw new RuntimeException("mvc netmodel SocketListener socketResponsedMessage error");
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class j<T extends qq5, D extends rq5, ActivityType> extends BdAsyncTask<Object, D, D> {
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
        /* renamed from: d */
        public void onPostExecute(D d) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d) == null) {
                super.onPostExecute(d);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public D doInBackground(Object... objArr) {
            InterceptResult invokeL;
            HttpNetContext httpNetContext;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr)) != null) {
                return (D) invokeL.objValue;
            }
            this.a.k = true;
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + this.a.k0());
            for (Map.Entry<String, Object> entry : this.a.c.O().entrySet()) {
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
                if (t instanceof nq5) {
                    nq5 nq5Var = (nq5) t;
                    String cacheKey = nq5Var.getCacheKey();
                    String T2 = nq5Var.T();
                    if (nq5Var.isNeedUid()) {
                        str = TbadkCoreApplication.getCurrentAccount();
                    } else {
                        str = null;
                    }
                    if (cacheKey != null && !TextUtils.isEmpty(T2) && b != null) {
                        b55.d();
                        we<String> f = b55.f(T2, str);
                        if (f == null) {
                            return b;
                        }
                        f.g(cacheKey, postNetData);
                    }
                }
            }
            return b;
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
                this.a.k = false;
                if (this.a.n != null) {
                    wg.a().removeCallbacks(this.a.n);
                }
                NetModel<T, D, ActivityType> netModel = this.a;
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(netModel.c, netModel.h0());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.a.h0());
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
                this.a.v0();
                if (this.a.a != null) {
                    this.a.a.L(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
                }
            }
        }
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
                super((k9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = null;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = -1;
        this.m = true;
        this.c = t;
        this.d = netModelType;
    }

    public void setNeedCache(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.g = z;
        }
    }

    public void w0(k<T, D> kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, kVar) == null) {
            this.a = kVar;
            this.b = kVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.k = false;
            MessageManager.getInstance().removeMessage(l0(), this.unique_id);
            MessageManager.getInstance().removeMessage(h0(), this.unique_id);
            return true;
        }
        return invokeV.booleanValue;
    }

    public Class<? extends MvcJsonHttpResponsedMessage> i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return MvcJsonHttpResponsedMessage.class;
        }
        return (Class) invokeV.objValue;
    }

    public boolean isNeedCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public Class<? extends MvcProtobufHttpResponsedMessage> j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return MvcProtobufHttpResponsedMessage.class;
        }
        return (Class) invokeV.objValue;
    }

    public Class<? extends MvcSocketResponsedMessage> m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return MvcSocketResponsedMessage.class;
        }
        return (Class) invokeV.objValue;
    }

    public Runnable n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.n == null) {
                this.n = new b(this);
            }
            return this.n;
        }
        return (Runnable) invokeV.objValue;
    }

    public boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.k;
        }
        return invokeV.booleanValue;
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.f = null;
        }
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !this.h && MessageManager.getInstance().findTask(h0()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(h0(), TbConfig.SERVER_ADDRESS + k0());
            tbHttpMessageTask.setResponsedClass(i0());
            s0(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(h0());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.h = true;
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && !this.i && MessageManager.getInstance().findTask(l0()) == null) {
            mt5 mt5Var = new mt5(l0());
            mt5Var.setResponsedClass(m0());
            u0(mt5Var);
            MessageManager.getInstance().unRegisterTask(l0());
            MessageManager.getInstance().registerTask(mt5Var);
            this.i = true;
        }
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && !this.h && MessageManager.getInstance().findTask(h0()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(h0(), TbConfig.SERVER_ADDRESS + k0() + "?cmd=" + l0());
            tbHttpMessageTask.setResponsedClass(j0());
            t0(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(h0());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.h = true;
        }
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && !this.j) {
            int i2 = a.a[this.d.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        h hVar = new h(this, h0(), true);
                        hVar.setTag(getUniqueId());
                        registerListener(hVar);
                    }
                } else {
                    i iVar = new i(this, l0(), true);
                    iVar.setTag(getUniqueId());
                    registerListener(iVar);
                }
            } else {
                g gVar = new g(this, h0(), l0());
                gVar.getHttpMessageListener().setSelfListener(true);
                gVar.getSocketMessageListener().setSelfListener(true);
                gVar.setTag(getUniqueId());
                registerListener(gVar);
            }
            this.j = true;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.b == null && this.a == null && TbadkCoreApplication.getInst().isDebugMode()) {
                throw new RuntimeException("NetModel must have callback");
            }
            this.m = vi.F();
            if (this.l >= 10) {
                wg.a().postDelayed(n0(), this.l * 1000);
            }
            int i2 = a.a[this.d.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 4) {
                            if (!this.m) {
                                wg.a().post(new f(this));
                                return false;
                            } else if (this.f == null) {
                                j<T, D, ActivityType> jVar = new j<>(this);
                                this.f = jVar;
                                jVar.execute(new Object[0]);
                                return true;
                            }
                        }
                        return false;
                    } else if (!this.m) {
                        wg.a().post(new d(this));
                        return false;
                    } else {
                        this.k = true;
                        d0();
                        f0();
                        MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.c, h0());
                        mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                        HashMap<String, Object> O = this.c.O();
                        if (O != null) {
                            for (Map.Entry<String, Object> entry : O.entrySet()) {
                                mvcHttpMessage.addParam(entry.getKey(), entry.getValue());
                            }
                        }
                        HashMap<String, String> S = this.c.S();
                        if (S != null) {
                            for (Map.Entry<String, String> entry2 : S.entrySet()) {
                                mvcHttpMessage.addHeader(entry2.getKey(), entry2.getValue());
                            }
                        }
                        mvcHttpMessage.setNeedCache(isNeedCache());
                        mvcHttpMessage.setTag(this.unique_id);
                        sendMessage(mvcHttpMessage);
                        return true;
                    }
                } else if (!this.m) {
                    wg.a().post(new e(this));
                    return false;
                } else {
                    this.k = true;
                    g0();
                    f0();
                    MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.c, l0());
                    mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                    mvcSocketMessage.setNeedCache(isNeedCache());
                    mvcSocketMessage.setTag(this.unique_id);
                    sendMessage(mvcSocketMessage);
                    return true;
                }
            } else if (!this.m) {
                wg.a().post(new c(this));
                return false;
            } else {
                this.k = true;
                e0();
                g0();
                f0();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.c, h0(), l0());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                HashMap<String, String> S2 = this.c.S();
                if (S2 != null) {
                    for (Map.Entry<String, String> entry3 : S2.entrySet()) {
                        mvcNetMessage.getHttpMessage().addHeader(entry3.getKey(), entry3.getValue());
                    }
                }
                if (this.e) {
                    mvcNetMessage.setNetType(NetMessage.NetType.HTTP);
                    mvcNetMessage.setHttpEngineType(IHttpNet.EngineType.SHOUBAI);
                }
                sendMessage(mvcNetMessage);
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public final void p0(int i2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048592, this, i2, str) == null) && this.a != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.c, h0());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(h0());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i2);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.a.L(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    public final void r0(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048594, this, i2, str) == null) {
            MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.c, l0());
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(this, l0()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NetModel this$0;

                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                public Class getProtobufResponseIdlClass() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        return null;
                    }
                    return (Class) invokeV.objValue;
                }

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
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
            mvcSocketResponsedMessage.setError(i2);
            mvcSocketResponsedMessage.setErrorString(str);
            this.b.z(mvcSocketResponsedMessage, mvcSocketMessage, null);
        }
    }

    public final void q0(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048593, this, i2, str) == null) {
            MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.c, h0(), l0());
            if (this.b != null) {
                MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(this, l0()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ NetModel this$0;

                    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                    public Class getProtobufResponseIdlClass() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            return null;
                        }
                        return (Class) invokeV.objValue;
                    }

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
                };
                mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
                mvcSocketResponsedMessage.setError(i2);
                mvcSocketResponsedMessage.setErrorString(str);
                this.b.z(mvcSocketResponsedMessage, null, mvcNetMessage);
            } else if (this.a != null) {
                MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(this, h0()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
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
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            return Error.class;
                        }
                        return (Class) invokeV.objValue;
                    }
                };
                mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
                mvcHttpResponsedMessage.setError(i2);
                mvcHttpResponsedMessage.setErrorString(str);
                this.a.L(mvcHttpResponsedMessage, null, mvcNetMessage);
            }
        }
    }
}
