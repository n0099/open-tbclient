package com.baidu.tieba;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.c69;
import com.baidu.tieba.e69;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.core.ImageLoader;
import java.io.File;
import java.util.List;
import java.util.Vector;
/* loaded from: classes4.dex */
public class g69 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile g69 c;
    public transient /* synthetic */ FieldHolder $fh;
    public e69 a;
    public List<l69> b;

    /* loaded from: classes4.dex */
    public class a implements k69 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g69 a;

        public a(g69 g69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g69Var;
        }

        @Override // com.baidu.tieba.k69
        public void a(c69.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                c69.a().c(bVar);
                if (!rm9.e(this.a.b)) {
                    g69 g69Var = this.a;
                    g69Var.h((l69) rm9.c(g69Var.b, 0));
                    rm9.g(this.a.b, 0);
                }
            }
        }
    }

    public g69() {
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
        this.b = new Vector();
        this.a = new e69.b().d();
    }

    public void i(m69 m69Var, d69 d69Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, m69Var, d69Var) == null) {
            List<l69> c2 = i69.c(m69Var, d69Var);
            if (!rm9.e(c2)) {
                for (l69 l69Var : c2) {
                    h(l69Var);
                }
            }
        }
    }

    public void j(n69 n69Var, d69 d69Var) {
        l69 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, n69Var, d69Var) == null) && (b = i69.b(n69Var, d69Var)) != null) {
            h(b);
        }
    }

    public static g69 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == null) {
                synchronized (g69.class) {
                    if (c == null) {
                        c = new g69();
                    }
                }
            }
            return c;
        }
        return (g69) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a != null) {
            return;
        }
        throw new IllegalStateException(ImageLoader.ERROR_NOT_INIT);
    }

    public j69 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c();
            return this.a.b;
        }
        return (j69) invokeV.objValue;
    }

    public Bitmap d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Bitmap a2 = g().a(str);
            if (a2 != null && !a2.isRecycled()) {
                return a2;
            }
            Bitmap a3 = e().a(str);
            if (a3 == null || a3.isRecycled()) {
                return null;
            }
            return a3;
        }
        return (Bitmap) invokeL.objValue;
    }

    public final void h(l69 l69Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, l69Var) == null) {
            c();
            c69.b b = c69.a().b();
            if (b != null) {
                b.m(this.a.a);
                b.setDataSource(l69Var.a);
                b.h(l69Var, new a(this));
                return;
            }
            this.b.add(l69Var);
        }
    }

    public z59 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c();
            String str = FileHelper.getVideoTmpDir() + File.separator + "shaft_images";
            if (!TextUtils.equals(this.a.c.b(), str)) {
                this.a.c.d(str);
            }
            return this.a.c;
        }
        return (z59) invokeV.objValue;
    }
}
