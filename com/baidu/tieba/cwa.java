package com.baidu.tieba;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.awa;
import com.baidu.tieba.yva;
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
public class cwa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cwa c;
    public transient /* synthetic */ FieldHolder $fh;
    public awa a;
    public List<hwa> b;

    /* loaded from: classes5.dex */
    public class a implements gwa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cwa a;

        public a(cwa cwaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cwaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cwaVar;
        }

        @Override // com.baidu.tieba.gwa
        public void a(yva.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                yva.a().c(bVar);
                if (!dgb.e(this.a.b)) {
                    cwa cwaVar = this.a;
                    cwaVar.h((hwa) dgb.c(cwaVar.b, 0));
                    dgb.g(this.a.b, 0);
                }
            }
        }
    }

    public cwa() {
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
        this.a = new awa.b().d();
    }

    public void i(iwa iwaVar, zva zvaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, iwaVar, zvaVar) == null) {
            List<hwa> c2 = ewa.c(iwaVar, zvaVar);
            if (!dgb.e(c2)) {
                for (hwa hwaVar : c2) {
                    h(hwaVar);
                }
            }
        }
    }

    public void j(jwa jwaVar, zva zvaVar) {
        hwa b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, jwaVar, zvaVar) == null) && (b = ewa.b(jwaVar, zvaVar)) != null) {
            h(b);
        }
    }

    public static cwa f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == null) {
                synchronized (cwa.class) {
                    if (c == null) {
                        c = new cwa();
                    }
                }
            }
            return c;
        }
        return (cwa) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a != null) {
            return;
        }
        throw new IllegalStateException(ImageLoader.ERROR_NOT_INIT);
    }

    public fwa g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c();
            return this.a.b;
        }
        return (fwa) invokeV.objValue;
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

    public final void h(hwa hwaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, hwaVar) == null) {
            c();
            yva.b b = yva.a().b();
            if (b != null) {
                b.m(this.a.a);
                b.setDataSource(hwaVar.a);
                b.h(hwaVar, new a(this));
                return;
            }
            this.b.add(hwaVar);
        }
    }

    public vva e() {
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
        return (vva) invokeV.objValue;
    }
}
