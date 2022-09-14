package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.LruCache;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sdk.container.filedownloader.MaterialLoader;
import com.baidu.tieba.kf1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class hf1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static volatile hf1 g = null;
    public static int h = 30000000;
    public static int i = 50000000;
    public transient /* synthetic */ FieldHolder $fh;
    public final LruCache<String, jf1<?>> a;
    public final kf1 b;
    public final kf1 c;
    public final Map<String, kf1> d;
    public final String e;
    public final String f;

    /* loaded from: classes4.dex */
    public class a implements d<Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(hf1 hf1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hf1Var};
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
        /* JADX DEBUG: Throwable added to exception handler: 'OutOfMemoryError', keep only Throwable */
        @Override // com.baidu.tieba.hf1.d
        /* renamed from: c */
        public Bitmap b(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr)) == null) {
                if (bArr == null) {
                    return null;
                }
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    options.inPurgeable = true;
                    options.inInputShareable = true;
                    return BitmapFactory.decodeStream(new ByteArrayInputStream(bArr), null, options);
                } catch (Throwable unused) {
                    return null;
                }
            }
            return (Bitmap) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hf1.d
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
    }

    /* loaded from: classes4.dex */
    public class b implements kf1.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ c b;
        public final /* synthetic */ kf1 c;

        public b(hf1 hf1Var, String str, c cVar, kf1 kf1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hf1Var, str, cVar, kf1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = cVar;
            this.c = kf1Var;
        }

        @Override // com.baidu.tieba.kf1.e
        public void a(String str, jf1<File> jf1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, jf1Var) == null) {
            }
        }

        @Override // com.baidu.tieba.kf1.e
        public void b(String str, jf1<File> jf1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jf1Var) == null) && this.a.equals(str)) {
                this.b.a();
                this.c.q(this);
            }
        }

        @Override // com.baidu.tieba.kf1.e
        public void c(String str, jf1<File> jf1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, jf1Var) == null) && this.a.equals(str)) {
                this.b.b();
                this.c.q(this);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a();

        void b();
    }

    /* loaded from: classes4.dex */
    public interface d<T> {
        <D> T a(D d);

        T b(byte[] bArr);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947821686, "Lcom/baidu/tieba/hf1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947821686, "Lcom/baidu/tieba/hf1;");
        }
    }

    public hf1(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new LruCache<>(6);
        String d2 = w21.d(context);
        this.e = d2 + "img_download/";
        this.f = d2 + "video_download/";
        this.b = kf1.o(this.e, h);
        this.c = kf1.o(this.f, i);
        this.d = new ConcurrentHashMap();
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? Pattern.compile("[^a-zA-Z0-9]").matcher(str).replaceAll("").trim() : (String) invokeL.objValue;
    }

    public static hf1 e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (g == null) {
                synchronized (hf1.class) {
                    if (g == null && context != null) {
                        g = new hf1(context.getApplicationContext());
                    }
                }
            }
            return g;
        }
        return (hf1) invokeL.objValue;
    }

    public final String b(String str, kf1 kf1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, kf1Var)) == null) {
            String a2 = a(str);
            return kf1Var.k() + a2;
        }
        return (String) invokeLL.objValue;
    }

    public final kf1 c(MaterialLoader.MaterialCacheType materialCacheType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, materialCacheType)) == null) {
            if (materialCacheType == MaterialLoader.MaterialCacheType.VIDEO) {
                return this.c;
            }
            return this.b;
        }
        return (kf1) invokeL.objValue;
    }

    public String d(String str, MaterialLoader.MaterialCacheType materialCacheType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, materialCacheType)) == null) {
            String a2 = a(str);
            if (f(str, materialCacheType)) {
                return c(materialCacheType).k() + a2;
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public boolean f(String str, MaterialLoader.MaterialCacheType materialCacheType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, materialCacheType)) == null) {
            boolean z = g(a(str), materialCacheType) != null;
            kf1 c2 = c(materialCacheType);
            return (z || c2.e) ? z : new File(b(str, c2)).exists();
        }
        return invokeLL.booleanValue;
    }

    public jf1<?> g(String str, MaterialLoader.MaterialCacheType materialCacheType) {
        InterceptResult invokeLL;
        jf1<?> i2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, materialCacheType)) == null) ? (materialCacheType != MaterialLoader.MaterialCacheType.PICTURE || (i2 = i(str)) == null) ? h(str, materialCacheType) : i2 : (jf1) invokeLL.objValue;
    }

    public final jf1<File> h(String str, MaterialLoader.MaterialCacheType materialCacheType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, materialCacheType)) == null) ? c(materialCacheType).j(str) : (jf1) invokeLL.objValue;
    }

    public final jf1<?> i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? this.a.get(str) : (jf1) invokeL.objValue;
    }

    public Bitmap j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? (Bitmap) k(str, MaterialLoader.MaterialCacheType.PICTURE, new a(this)) : (Bitmap) invokeL.objValue;
    }

    public final <T> T k(String str, MaterialLoader.MaterialCacheType materialCacheType, d<T> dVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, materialCacheType, dVar)) == null) {
            jf1<?> g2 = g(a(str), materialCacheType);
            if (g2 != null) {
                if (File.class.equals(g2.c())) {
                    return dVar.b(g2.b());
                }
                if (Byte.TYPE.equals(g2.c())) {
                    return null;
                }
                return dVar.a(g2.a());
            }
            if (!c(materialCacheType).e) {
                File file = new File(b(str, c(materialCacheType)));
                if (file.exists()) {
                    return dVar.b(new jf1(file).b());
                }
            }
            return null;
        }
        return (T) invokeLLL.objValue;
    }

    public void l(String str, Bitmap bitmap, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048585, this, str, bitmap, z) == null) {
            m(str, new jf1<>(bitmap), this.b, z, null);
        }
    }

    public final void m(String str, jf1<?> jf1Var, kf1 kf1Var, boolean z, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, jf1Var, kf1Var, Boolean.valueOf(z), cVar}) == null) {
            try {
                String a2 = a(str);
                if (z) {
                    this.a.put(a2, jf1Var);
                }
                File file = new File(kf1Var.k() + a2);
                if (cVar != null) {
                    kf1Var.f(new b(this, a2, cVar, kf1Var));
                }
                kf1Var.u(jf1Var.b(), new jf1<>(file));
            } catch (Throwable unused) {
            }
        }
    }

    public void n(String str, byte[] bArr, MaterialLoader.MaterialCacheType materialCacheType, boolean z, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, bArr, materialCacheType, Boolean.valueOf(z), cVar}) == null) {
            jf1<?> jf1Var = new jf1<>(bArr);
            kf1 kf1Var = this.b;
            if (materialCacheType == MaterialLoader.MaterialCacheType.VIDEO) {
                kf1Var = this.c;
            }
            m(str, jf1Var, kf1Var, z, cVar);
        }
    }

    public void o(String str, byte[] bArr, String str2, int i2, boolean z, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, bArr, str2, Integer.valueOf(i2), Boolean.valueOf(z), cVar}) == null) {
            jf1<?> jf1Var = new jf1<>(bArr);
            kf1 kf1Var = this.d.get(str2);
            if (kf1Var == null) {
                kf1Var = kf1.o(str2, i2);
                this.d.put(str2, kf1Var);
            } else if (kf1Var.l() != i2) {
                kf1Var.trimToSize(i2);
            }
            m(str, jf1Var, kf1Var, z, cVar);
        }
    }
}
