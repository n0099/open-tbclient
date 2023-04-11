package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class ab5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;
    public c b;
    public b c;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(boolean z);
    }

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<String, Void, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Process a;
        public final /* synthetic */ ab5 b;

        public b(ab5 ab5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ab5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ab5Var;
            this.a = null;
        }

        public /* synthetic */ b(ab5 ab5Var, a aVar) {
            this(ab5Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                boolean z = false;
                if (strArr != null && strArr.length >= 1) {
                    try {
                        try {
                            try {
                                Process exec = Runtime.getRuntime().exec(strArr[0]);
                                this.a = exec;
                                if (exec.waitFor() == 0) {
                                    z = true;
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    } finally {
                        this.a.destroy();
                    }
                }
                return Boolean.valueOf(z);
            }
            return (Boolean) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.onCancelled();
                Process process = this.a;
                if (process != null) {
                    try {
                        process.destroy();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                if (this.b.b != null) {
                    this.b.b.a(false);
                }
                if (this.b.a != null) {
                    this.b.a.removeMessages(0);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            boolean booleanValue;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bool) == null) {
                if (this.b.b != null) {
                    c cVar = this.b.b;
                    if (bool == null) {
                        booleanValue = false;
                    } else {
                        booleanValue = bool.booleanValue();
                    }
                    cVar.a(booleanValue);
                }
                if (this.b.a != null) {
                    this.b.a.removeMessages(0);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<ab5> a;

        public d(ab5 ab5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ab5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(ab5Var);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ab5 ab5Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what == 0 && (ab5Var = this.a.get()) != null) {
                    ab5Var.e();
                }
            }
        }
    }

    public ab5(String str, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        d dVar = new d(this);
        this.a = dVar;
        this.b = cVar;
        dVar.sendEmptyMessageDelayed(0, 50000L);
        b bVar = new b(this, null);
        this.c = bVar;
        bVar.setSelfExecute(true);
        b bVar2 = this.c;
        bVar2.execute(d() + str);
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int netType = BdNetTypeUtil.netType();
            if (netType != 1) {
                if (netType != 2) {
                    return "ping -c 3 -w 5000 ";
                }
                return "ping -c 3 -w 10000 ";
            }
            return "ping -c 3 -w 3000 ";
        }
        return (String) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b bVar = this.c;
            if (bVar != null) {
                bVar.cancel(true);
            }
            d dVar = this.a;
            if (dVar != null) {
                dVar.removeMessages(0);
            }
        }
    }
}
