package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tieba.b06;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class h06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c06 a;
    public final BitmapRegionDecoder b;
    public jg<b06.a, b06> c;
    public kg<b06> d;
    public final ThreadPoolExecutor e;
    public BdAsyncTask<Void, Void, Void> f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947769947, "Lcom/baidu/tieba/h06;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947769947, "Lcom/baidu/tieba/h06;");
        }
    }

    /* loaded from: classes5.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h06 a;

        public a(h06 h06Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h06Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h06Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void[] voidArr) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                try {
                    this.a.e.shutdownNow();
                    this.a.e.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (this.a.b != null) {
                    this.a.b.recycle();
                    return null;
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements RejectedExecutionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, runnable, threadPoolExecutor) == null) {
            }
        }

        public b(h06 h06Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h06Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends jg<b06.a, b06> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h06 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(h06 h06Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h06Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = h06Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jg
        /* renamed from: p */
        public int m(b06.a aVar, b06 b06Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, aVar, b06Var)) == null) {
                if (b06Var == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(b06Var.b());
            }
            return invokeLL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jg
        /* renamed from: o */
        public void b(boolean z, b06.a aVar, b06 b06Var, b06 b06Var2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), aVar, b06Var, b06Var2}) == null) && z && this.h.d != null && b06Var != null) {
                b06Var.a();
                this.h.d.e(b06Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public int c;
        public c06 d;
        public BitmapRegionDecoder e;
        public jg<b06.a, b06> f;
        public d06 g;
        public h06 h;

        public d(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        public final void b(h06 h06Var, c06 c06Var, BitmapRegionDecoder bitmapRegionDecoder, jg<b06.a, b06> jgVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, h06Var, c06Var, bitmapRegionDecoder, jgVar) == null) {
                this.d = c06Var;
                this.e = bitmapRegionDecoder;
                this.f = jgVar;
                this.h = h06Var;
            }
        }

        public final boolean c(Rect rect) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rect)) == null) {
                if (rect.right > rect.left && rect.bottom > rect.top) {
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public void d(d06 d06Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d06Var) == null) {
                this.g = d06Var;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            b06 c;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.f == null || !this.d.b(this.a, this.b, this.c)) {
                return;
            }
            Rect j = this.d.j(this.a, this.b, this.c);
            this.d.a(j);
            if (c(j)) {
                return;
            }
            try {
                c = this.h.f().b();
                if (c != null) {
                    if (!c.g(j)) {
                        System.currentTimeMillis();
                        c.a();
                    }
                } else {
                    c = this.d.c();
                }
            } catch (Throwable unused) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                jg<b06.a, b06> jgVar = this.f;
                jgVar.k((int) (jgVar.g() * 0.8d));
                System.gc();
                try {
                    c = this.d.c();
                } catch (Throwable unused2) {
                    return;
                }
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = this.c;
            options.inBitmap = c.b();
            options.inMutable = true;
            System.currentTimeMillis();
            Bitmap decodeRegion = this.e.decodeRegion(j, options);
            if (decodeRegion == null) {
                options.inBitmap = null;
                decodeRegion = this.e.decodeRegion(j, options);
                if (decodeRegion == null) {
                    return;
                }
            }
            decodeRegion.prepareToDraw();
            c.h(decodeRegion);
            c.j(this.a, this.b, this.c);
            this.f.h(c.d(), c);
            d06 d06Var = this.g;
            if (d06Var != null) {
                d06Var.onLoadFinished();
            }
        }
    }

    public h06(c06 c06Var, BitmapRegionDecoder bitmapRegionDecoder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c06Var, bitmapRegionDecoder};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = c06Var;
        this.b = bitmapRegionDecoder;
        TbImageMemoryCache.u().L((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.e = new ThreadPoolExecutor(0, 10, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new b(this));
        this.c = new c(this, (int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f));
        kg<b06> E = TbImageMemoryCache.u().E(this.a.e());
        this.d = E;
        E.f(6);
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.e.purge();
            if (z && this.f == null) {
                a aVar = new a(this);
                this.f = aVar;
                aVar.execute(new Void[0]);
            }
        }
    }

    public void h(d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) && dVar != null && this.f == null) {
            dVar.b(this, this.a, this.b, e());
            this.e.submit(dVar);
        }
    }

    public jg<b06.a, b06> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (jg) invokeV.objValue;
    }

    public kg<b06> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (kg) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d(true);
            jg<b06.a, b06> jgVar = this.c;
            if (jgVar != null) {
                jgVar.k(0);
                this.c.a();
                this.c = null;
            }
            this.d = null;
        }
    }
}
