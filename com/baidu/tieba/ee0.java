package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.LruCache;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ge0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class ee0 {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern d;
    public static volatile ee0 e;
    public transient /* synthetic */ FieldHolder $fh;
    public final LruCache<String, fe0<?>> a;
    public final ge0 b;
    public final String c;

    /* loaded from: classes5.dex */
    public interface c {
        void a();

        void b();
    }

    /* loaded from: classes5.dex */
    public interface d<T> {
        <D> T a(D d);

        T b(byte[] bArr);
    }

    /* loaded from: classes5.dex */
    public class a implements d<Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(ee0 ee0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ee0.d
        /* renamed from: d */
        public <D> Bitmap a(D d) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, d)) == null) {
                if (d instanceof Bitmap) {
                    return (Bitmap) d;
                }
                return null;
            }
            return (Bitmap) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Throwable added to exception handler: 'OutOfMemoryError', keep only Throwable */
        @Override // com.baidu.tieba.ee0.d
        /* renamed from: c */
        public Bitmap b(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr)) == null) {
                if (bArr != null) {
                    try {
                        if (bArr.length != 0) {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                            options.inPurgeable = true;
                            options.inInputShareable = true;
                            return BitmapFactory.decodeStream(new ByteArrayInputStream(bArr), null, options);
                        }
                    } catch (Throwable unused) {
                    }
                }
                return null;
            }
            return (Bitmap) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ge0.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ c b;
        public final /* synthetic */ ee0 c;

        @Override // com.baidu.tieba.ge0.e
        public void b(String str, fe0<File> fe0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, fe0Var) == null) {
            }
        }

        public b(ee0 ee0Var, String str, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee0Var, str, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ee0Var;
            this.a = str;
            this.b = cVar;
        }

        @Override // com.baidu.tieba.ge0.e
        public void a(String str, fe0<File> fe0Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, str, fe0Var) == null) && this.a.equals(str)) {
                this.b.a();
                this.c.b.n(this);
            }
        }

        @Override // com.baidu.tieba.ge0.e
        public void c(String str, fe0<File> fe0Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, fe0Var) == null) && this.a.equals(str)) {
                this.b.b();
                this.c.b.n(this);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947731321, "Lcom/baidu/tieba/ee0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947731321, "Lcom/baidu/tieba/ee0;");
                return;
            }
        }
        d = Pattern.compile("[^a-zA-Z0-9]");
    }

    public ee0(Context context, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        File cacheDir = context.getCacheDir();
        this.c = (cacheDir.getPath() + "/nad/") + "nad_image_cache/";
        this.a = new LruCache<>(i);
        this.b = ge0.l(this.c, i2);
    }

    public String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String b2 = b(str);
            return this.c + b2;
        }
        return (String) invokeL.objValue;
    }

    public fe0<?> e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            fe0<?> g = g(str);
            if (g != null) {
                return g;
            }
            return f(str);
        }
        return (fe0) invokeL.objValue;
    }

    public final fe0<File> f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return this.b.i(str);
        }
        return (fe0) invokeL.objValue;
    }

    public final fe0<?> g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return this.a.get(str);
        }
        return (fe0) invokeL.objValue;
    }

    @Nullable
    public Bitmap h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return (Bitmap) i(str, new a(this));
        }
        return (Bitmap) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str.length() >= 160) {
                return y11.b(str, false);
            }
            return d.matcher(str).replaceAll("").trim();
        }
        return (String) invokeL.objValue;
    }

    public static ee0 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (e == null) {
                synchronized (ee0.class) {
                    if (e == null) {
                        e = new ee0(gf0.b(), 6, 50000000);
                    }
                }
            }
            return e;
        }
        return (ee0) invokeV.objValue;
    }

    public final <T> T i(String str, d<T> dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, dVar)) == null) {
            fe0<?> e2 = e(b(str));
            if (e2 != null) {
                if (File.class.equals(e2.c())) {
                    return dVar.b(e2.b());
                }
                if (Byte.TYPE.equals(e2.c())) {
                    return null;
                }
                return dVar.a(e2.a());
            }
            if (!this.b.e) {
                File file = new File(c(str));
                if (file.exists()) {
                    return dVar.b(new fe0(file).b());
                }
            }
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public void j(String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, bitmap) == null) {
            k(str, new fe0<>(bitmap), true, null);
        }
    }

    public final void k(String str, fe0<?> fe0Var, boolean z, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, fe0Var, Boolean.valueOf(z), cVar}) == null) {
            try {
                String b2 = b(str);
                if (z) {
                    this.a.put(b2, fe0Var);
                }
                File file = new File(this.b.j() + b2);
                if (cVar != null) {
                    this.b.e(new b(this, b2, cVar));
                }
                this.b.q(fe0Var.b(), new fe0<>(file));
            } catch (Throwable unused) {
            }
        }
    }
}
