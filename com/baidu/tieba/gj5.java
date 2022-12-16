package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class gj5 {
    public static /* synthetic */ Interceptable $ic;
    public static gj5 c;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;
    public b b;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public interface b {
        void onResult(boolean z);
    }

    /* loaded from: classes4.dex */
    public class c extends BdAsyncTask<String, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gj5 a;

        public c(gj5 gj5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gj5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gj5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                return Boolean.valueOf(this.a.d());
            }
            return (Boolean) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bool) == null) && this.a.b != null && bool != null) {
                this.a.b.onResult(bool.booleanValue());
            }
        }

        public /* synthetic */ c(gj5 gj5Var, a aVar) {
            this(gj5Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947795863, "Lcom/baidu/tieba/gj5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947795863, "Lcom/baidu/tieba/gj5;");
                return;
            }
        }
        c = new gj5();
    }

    public gj5() {
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

    public static gj5 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return c;
        }
        return (gj5) invokeV.objValue;
    }

    public void c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.b = bVar;
            c cVar = this.a;
            if (cVar != null) {
                cVar.cancel();
            }
            c cVar2 = new c(this, null);
            this.a = cVar2;
            cVar2.setPriority(4);
            this.a.execute(new String[0]);
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        String str;
        String[] split;
        int e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            byte[] GetFileData = FileHelper.GetFileData(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/crash_hour_record.log");
            if (GetFileData != null) {
                str = new String(GetFileData);
            } else {
                str = null;
            }
            long j = StringUtils.getyyyyMMddHHTimeForNow();
            long j2 = 0;
            if (TextUtils.isEmpty(str) || (split = str.split(":")) == null || split.length != 2) {
                e = 0;
            } else {
                e = xg.e(split[0], 0);
                j2 = xg.g(split[1], j);
            }
            if (j2 == j && e > 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
