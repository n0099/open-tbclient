package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.client.HttpClient;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class i90 {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<Integer, ResponsedMessage<?>> a;
    public static final ConcurrentHashMap<Integer, b> b;
    public static final ConcurrentHashMap<Integer, Integer> c;
    public static final BdUniqueId d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface b {
        void a(ResponsedMessage<?> responsedMessage);

        void b();
    }

    /* loaded from: classes6.dex */
    public static class a extends HttpClient.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int e;
        public final /* synthetic */ HttpMessage f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask, int i, HttpMessage httpMessage2) {
            super(httpMessage, httpMessageTask);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {httpMessage, httpMessageTask, Integer.valueOf(i), httpMessage2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((HttpMessage) objArr2[0], (HttpMessageTask) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = i;
            this.f = httpMessage2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public void publishProgress(ResponsedMessage<?>... responsedMessageArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessageArr) == null) {
                synchronized (i90.class) {
                    i90.c.remove(Integer.valueOf(this.e));
                    if (responsedMessageArr != null && responsedMessageArr.length > 0) {
                        b bVar = (b) i90.b.remove(Integer.valueOf(this.e));
                        if (bVar != null) {
                            bVar.a(responsedMessageArr[0]);
                        } else {
                            i90.a.put(Integer.valueOf(this.f.getCmd()), responsedMessageArr[0]);
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947808201, "Lcom/baidu/tieba/i90;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947808201, "Lcom/baidu/tieba/i90;");
                return;
            }
        }
        a = new ConcurrentHashMap<>();
        b = new ConcurrentHashMap<>();
        c = new ConcurrentHashMap<>();
        d = BdUniqueId.gen();
    }

    public i90() {
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

    public static synchronized void d(int i, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65541, null, i, bVar) == null) {
            synchronized (i90.class) {
                if (c.containsKey(Integer.valueOf(i))) {
                    b.put(Integer.valueOf(i), bVar);
                    return;
                }
                if (a.containsKey(Integer.valueOf(i))) {
                    bVar.a(a.remove(Integer.valueOf(i)));
                } else {
                    bVar.b();
                }
            }
        }
    }

    public static synchronized void e(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, httpMessage, httpMessageTask) == null) {
            synchronized (i90.class) {
                if (httpMessage != null && httpMessageTask != null) {
                    int cmd = httpMessage.getCmd();
                    c.put(Integer.valueOf(cmd), 0);
                    new a(httpMessage, httpMessageTask, cmd, httpMessage).execute(new HttpMessage[0]);
                }
            }
        }
    }
}
