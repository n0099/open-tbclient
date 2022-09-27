package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import com.baidu.tieba.z44;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a54 extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public va2 a;
    public tx3 b;
    public String c;

    /* loaded from: classes3.dex */
    public class a implements z44.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a54 a;

        public a(a54 a54Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a54Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a54Var;
        }

        @Override // com.baidu.tieba.z44.a
        public void a(int i, long j, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) == null) && this.a.hasEventListener("progressupdate")) {
                b54 b54Var = new b54();
                b54Var.progress = i;
                b54Var.totalBytesWritten = j;
                b54Var.totalBytesExpectedToWrite = j2;
                JSEvent jSEvent = new JSEvent("progressupdate");
                jSEvent.data = b54Var;
                if (a54.d) {
                    Log.i("LoadSubpackageTask", "progress :" + i + "totalBytesWritten :" + j + "totalBytesExpectedToWrite :" + j2);
                }
                this.a.dispatchEvent(jSEvent);
            }
        }

        @Override // com.baidu.tieba.z44.a
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.a.C(false);
                f44.j(this.a.c, i, "");
            }
        }

        @Override // com.baidu.tieba.z44.a
        public void success() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                a54 a54Var = this.a;
                this.a.C(a54Var.D(a54Var.c));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ a54 b;

        public b(a54 a54Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a54Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a54Var;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a) {
                    if (this.b.b != null) {
                        this.b.b.c();
                        if (a54.d) {
                            Log.i("LoadSubpackageTask", "success call");
                        }
                    }
                } else if (this.b.b != null) {
                    this.b.b.a();
                    if (a54.d) {
                        Log.i("LoadSubpackageTask", "fail call");
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947566153, "Lcom/baidu/tieba/a54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947566153, "Lcom/baidu/tieba/a54;");
                return;
            }
        }
        d = vj1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a54(va2 va2Var) {
        super(va2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {va2Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = va2Var;
    }

    public final void C(boolean z) {
        va2 va2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (va2Var = this.a) == null) {
            return;
        }
        va2Var.runOnJSThread(new b(this, z));
    }

    public final boolean D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.a == null) {
                return false;
            }
            String str2 = yo2.U().z() + y44.b().c(str, 2);
            String c = y44.b().c(str, 3);
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(c)) {
                return false;
            }
            this.a.Z(str2, c);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void E(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            G();
            F(jsObject);
            if (TextUtils.isEmpty(this.c)) {
                if (d) {
                    Log.i("LoadSubpackageTask", IActiveUploadListener.PARAM_ERR_MSG);
                }
                f44.j(this.c, 2111, "");
                return;
            }
            z44.a(this.c, new a(this));
        }
    }

    public final void F(JsObject jsObject) {
        sv1 F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) || jsObject == null || (F = sv1.F(jsObject)) == null) {
            return;
        }
        this.b = tx3.e(F);
        try {
            this.c = F.g("name");
        } catch (JSTypeMismatchException e) {
            if (d) {
                e.printStackTrace();
            }
            x54.d(this.a, e);
            G();
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b = null;
            this.c = null;
        }
    }
}
