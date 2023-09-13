package com.baidu.tieba;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.wxa;
import com.baidu.tieba.yxa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.core.ImageLoader;
import java.io.File;
import java.util.List;
import java.util.Vector;
/* loaded from: classes5.dex */
public class aya {
    public static /* synthetic */ Interceptable $ic;
    public static volatile aya c;
    public transient /* synthetic */ FieldHolder $fh;
    public yxa a;
    public List<fya> b;

    /* loaded from: classes5.dex */
    public class a implements eya {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aya a;

        public a(aya ayaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ayaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ayaVar;
        }

        @Override // com.baidu.tieba.eya
        public void a(wxa.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                wxa.a().c(bVar);
                if (!nib.e(this.a.b)) {
                    aya ayaVar = this.a;
                    ayaVar.h((fya) nib.c(ayaVar.b, 0));
                    nib.g(this.a.b, 0);
                }
            }
        }
    }

    public aya() {
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
        this.a = new yxa.b().d();
    }

    public void i(gya gyaVar, xxa xxaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, gyaVar, xxaVar) == null) {
            List<fya> c2 = cya.c(gyaVar, xxaVar);
            if (!nib.e(c2)) {
                for (fya fyaVar : c2) {
                    h(fyaVar);
                }
            }
        }
    }

    public void j(hya hyaVar, xxa xxaVar) {
        fya b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, hyaVar, xxaVar) == null) && (b = cya.b(hyaVar, xxaVar)) != null) {
            h(b);
        }
    }

    public static aya f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == null) {
                synchronized (aya.class) {
                    if (c == null) {
                        c = new aya();
                    }
                }
            }
            return c;
        }
        return (aya) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a != null) {
            return;
        }
        throw new IllegalStateException(ImageLoader.ERROR_NOT_INIT);
    }

    public dya g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c();
            return this.a.b;
        }
        return (dya) invokeV.objValue;
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

    public final void h(fya fyaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fyaVar) == null) {
            c();
            wxa.b b = wxa.a().b();
            if (b != null) {
                b.n(this.a.a);
                b.setDataSource(fyaVar.a);
                b.h(fyaVar, new a(this));
                return;
            }
            this.b.add(fyaVar);
        }
    }

    public txa e() {
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
        return (txa) invokeV.objValue;
    }
}
