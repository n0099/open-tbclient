package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class aq5 {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId a;
    public static final BdAsyncTaskParallel b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public wp5<T> a;
        public zo5<T> b;

        public a(wp5<T> wp5Var, zo5<T> zo5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wp5Var, zo5Var};
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
            this.a = wp5Var;
            this.b = zo5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public T doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                try {
                    if (this.a == null) {
                        return null;
                    }
                    return this.a.doInBackground();
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    return null;
                }
            }
            return (T) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            zo5<T> zo5Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) && (zo5Var = this.b) != null) {
                zo5Var.onReturnDataInUI(t);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947623844, "Lcom/baidu/tieba/aq5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947623844, "Lcom/baidu/tieba/aq5;");
                return;
            }
        }
        a = BdUniqueId.gen();
        b = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, a);
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            BdAsyncTask.removeAllTask(a);
        }
    }

    public static <T> void b(wp5<T> wp5Var, zo5<T> zo5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, wp5Var, zo5Var) == null) && wp5Var != null) {
            a aVar = new a(wp5Var, zo5Var);
            aVar.setParallel(b);
            aVar.setTag(a);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void c(wp5<T> wp5Var, zo5<T> zo5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, wp5Var, zo5Var) == null) && wp5Var != null) {
            a aVar = new a(wp5Var, zo5Var);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(a);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }
}
