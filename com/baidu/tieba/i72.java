package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallbacks;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class i72 implements b72, h72 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public j72 b;

    /* loaded from: classes4.dex */
    public class a implements l72 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c72 a;

        public a(i72 i72Var, c72 c72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i72Var, c72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c72Var;
        }

        @Override // com.baidu.tieba.l72
        public void a(ImageRequest imageRequest) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, imageRequest) == null) {
            }
        }

        @Override // com.baidu.tieba.l72
        public void b(ImageRequest imageRequest) {
            c72 c72Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageRequest) == null) || (c72Var = this.a) == null) {
                return;
            }
            c72Var.a();
        }

        @Override // com.baidu.tieba.l72
        public void c(ImageRequest imageRequest, Throwable th) {
            c72 c72Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, imageRequest, th) == null) || (c72Var = this.a) == null) {
                return;
            }
            c72Var.a();
        }

        @Override // com.baidu.tieba.l72
        public void onCancel(String str) {
            c72 c72Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (c72Var = this.a) == null) {
                return;
            }
            c72Var.a();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements j72 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(i72 i72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.j72
        public CacheKey a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return DefaultCacheKeyFactory.getInstance().getEncodedCacheKey(ImageRequest.fromUri(Uri.parse(str)), null);
            }
            return (CacheKey) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static i72 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-763866330, "Lcom/baidu/tieba/i72$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-763866330, "Lcom/baidu/tieba/i72$c;");
                    return;
                }
            }
            a = new i72(null);
        }
    }

    public /* synthetic */ i72(a aVar) {
        this();
    }

    public static i72 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.a : (i72) invokeV.objValue;
    }

    @Override // com.baidu.tieba.b72
    public void a(String str, File file, c72 c72Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, str, file, c72Var) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = false;
        if (file != null && file.exists()) {
            z = b(str, file);
        }
        if (z) {
            c72Var.a();
        } else {
            e(str, new a(this, c72Var));
        }
    }

    public final boolean b(String str, File file) {
        InterceptResult invokeLL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, file)) == null) {
            CacheKey a2 = this.b.a(str);
            boolean z = false;
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (IOException e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                BinaryResource insert = Fresco.getImagePipelineFactory().getMainFileCache().insert(a2, WriterCallbacks.from(fileInputStream));
                if (insert != null) {
                    if (insert.size() > 0) {
                        z = true;
                    }
                }
                cj4.d(fileInputStream);
                return z;
            } catch (IOException e2) {
                e = e2;
                fileInputStream2 = fileInputStream;
                if (h72.a) {
                    Log.e("HybridIntercept", Log.getStackTraceString(e));
                }
                cj4.d(fileInputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                cj4.d(fileInputStream2);
                throw th;
            }
        }
        return invokeLL.booleanValue;
    }

    public final File c(String str) {
        InterceptResult invokeL;
        BinaryResource resource;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            CacheKey a2 = this.b.a(str);
            if (a2 == null) {
                return null;
            }
            if (ImagePipelineFactory.getInstance().getMainFileCache().hasKey(a2)) {
                BinaryResource resource2 = ImagePipelineFactory.getInstance().getMainFileCache().getResource(a2);
                if (resource2 != null) {
                    return ((FileBinaryResource) resource2).getFile();
                }
                return null;
            } else if (!ImagePipelineFactory.getInstance().getSmallImageFileCache().hasKey(a2) || (resource = ImagePipelineFactory.getInstance().getSmallImageFileCache().getResource(a2)) == null) {
                return null;
            } else {
                return ((FileBinaryResource) resource).getFile();
            }
        }
        return (File) invokeL.objValue;
    }

    public final DataSource<Void> e(String str, l72 l72Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, l72Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                if (l72Var != null) {
                    l72Var.c(null, new Exception("url is empty"));
                }
                return null;
            }
            ImagePipeline imagePipeline = Fresco.getImagePipeline();
            ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(Uri.parse(str));
            if (l72Var != null) {
                newBuilderWithSource.setRequestListener(fm2.B().a(l72Var));
            }
            return imagePipeline.prefetchToDiskCache(newBuilderWithSource.build(), null);
        }
        return (DataSource) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.b72
    public InputStream get(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            File c2 = c(str);
            if (c2 == null || !c2.exists()) {
                return null;
            }
            try {
                return new FileInputStream(c2);
            } catch (IOException e) {
                if (h72.a) {
                    Log.e("HybridIntercept", Log.getStackTraceString(e));
                    return null;
                }
                return null;
            }
        }
        return (InputStream) invokeL.objValue;
    }

    @Override // com.baidu.tieba.b72
    public boolean isClosed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public i72() {
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
        this.b = new b(this);
    }
}
