package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class fe8 {
    public static /* synthetic */ Interceptable $ic;
    public static fe8 b;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, String> a;

    /* loaded from: classes4.dex */
    public class a extends jf5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fe8 a;

        public a(fe8 fe8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fe8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fe8Var;
        }

        @Override // com.baidu.tieba.jf5
        public Object doInBackground() {
            InterceptResult invokeV;
            Reader reader;
            Throwable th;
            InputStream inputStream;
            BufferedReader bufferedReader;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    try {
                        inputStream = TbadkCoreApplication.getInst().getAssets().open("schema_map.txt");
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                String[] split = readLine.split(",");
                                if (split.length == 2 && split[0] != null && split[1] != null) {
                                    this.a.a.put(split[0], split[1]);
                                }
                            } catch (Exception e) {
                                e = e;
                                e.printStackTrace();
                                og.c(inputStream);
                                og.e(bufferedReader);
                                return null;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        bufferedReader = null;
                    } catch (Throwable th3) {
                        reader = null;
                        th = th3;
                        og.c(inputStream);
                        og.e(reader);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    inputStream = null;
                    bufferedReader = null;
                } catch (Throwable th4) {
                    reader = null;
                    th = th4;
                    inputStream = null;
                }
                og.c(inputStream);
                og.e(bufferedReader);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements qe5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;
        public final /* synthetic */ fe8 b;

        public b(fe8 fe8Var, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fe8Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fe8Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.qe5
        public void onReturnDataInUI(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.a.a(this.b.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(HashMap<String, String> hashMap);
    }

    public fe8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
    }

    public static fe8 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (fe8.class) {
                    if (b == null) {
                        b = new fe8();
                    }
                }
            }
            return b;
        }
        return (fe8) invokeV.objValue;
    }

    public void b(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            if (!this.a.isEmpty()) {
                cVar.a(this.a);
            } else {
                nf5.b(new a(this), new b(this, cVar));
            }
        }
    }
}
