package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class d54 implements c54 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, e54> a;
    public HashMap<String, ArrayList<c54>> b;
    public String c;
    public k94 d;
    public final Object e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947655526, "Lcom/baidu/tieba/d54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947655526, "Lcom/baidu/tieba/d54;");
                return;
            }
        }
        f = nr1.a;
    }

    public d54(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
        this.b = new HashMap<>();
        this.e = new Object();
        this.c = str;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (f) {
                Log.d("AudioDownloadManager", "AudioDownloader SwanGamePreloadManager url:" + str);
            }
            if (this.d == null) {
                this.d = k94.b();
            }
            e54 e54Var = new e54(this.d, this.c, str, this);
            this.a.put(str, e54Var);
            e54Var.e();
        }
    }

    @Override // com.baidu.tieba.c54
    public void a(String str, String str2) {
        ArrayList<c54> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            synchronized (this.e) {
                if (d(str) && (arrayList = this.b.get(str)) != null) {
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        arrayList.get(i).a(str, str2);
                        if (f) {
                            Log.e("AudioDownloadManager", i + " load success url = " + str + " path = " + str2);
                        }
                    }
                    this.a.remove(str);
                }
            }
        }
    }

    public void e(String str, c54 c54Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, c54Var) == null) {
            synchronized (this.e) {
                if (!d(str)) {
                    if (f) {
                        Log.e("AudioDownloadManager", "start load url = " + str);
                    }
                    c(str);
                } else if (f) {
                    Log.e("AudioDownloadManager", "re load url = " + str);
                }
                b(str, c54Var);
            }
        }
    }

    public final void b(String str, c54 c54Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, c54Var) == null) {
            if (this.b.containsKey(str)) {
                this.b.get(str).add(c54Var);
                return;
            }
            ArrayList<c54> arrayList = new ArrayList<>();
            arrayList.add(c54Var);
            this.b.put(str, arrayList);
        }
    }

    public final boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return this.a.containsKey(str);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.c54
    public void fail(int i, String str) {
        ArrayList<c54> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) {
            synchronized (this.e) {
                if (d(str) && (arrayList = this.b.get(str)) != null) {
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.get(i2).fail(i, str);
                    }
                    this.a.remove(str);
                }
            }
        }
    }
}
