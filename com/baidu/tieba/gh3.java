package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
/* loaded from: classes4.dex */
public class gh3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public interface b {
        void a(String str, Bitmap bitmap);
    }

    /* loaded from: classes4.dex */
    public static class a extends BaseBitmapDataSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;
        public final /* synthetic */ String b;

        public a(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
            this.b = str;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber, com.facebook.datasource.DataSubscriber
        public void onCancellation(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataSource) == null) {
                super.onCancellation(dataSource);
                this.a.a(this.b, null);
            }
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataSource) == null) {
                this.a.a(this.b, null);
            }
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(Bitmap bitmap) {
            Bitmap copy;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    try {
                        if (bitmap.getConfig() == null) {
                            copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                        } else {
                            copy = bitmap.copy(bitmap.getConfig(), true);
                        }
                        this.a.a(this.b, copy);
                        return;
                    } catch (Exception e) {
                        if (gh3.a) {
                            Log.e("SwanAppFrescoImageUtils", e.getMessage());
                        }
                        this.a.a(this.b, null);
                        return;
                    }
                }
                this.a.a(this.b, null);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947793879, "Lcom/baidu/tieba/gh3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947793879, "Lcom/baidu/tieba/gh3;");
                return;
            }
        }
        a = tk1.a;
    }

    public static Bitmap b(DataSource<CloseableReference<CloseableImage>> dataSource) {
        InterceptResult invokeL;
        CloseableReference<CloseableImage> closeableReference;
        Throwable th;
        Bitmap underlyingBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, dataSource)) == null) {
            if (dataSource == null) {
                return null;
            }
            try {
                closeableReference = dataSource.getResult();
                if (closeableReference != null) {
                    try {
                        CloseableImage closeableImage = closeableReference.get();
                        if (closeableImage != null && (closeableImage instanceof CloseableBitmap) && (underlyingBitmap = ((CloseableBitmap) closeableImage).getUnderlyingBitmap()) != null && !underlyingBitmap.isRecycled()) {
                            try {
                                Bitmap createBitmap = Bitmap.createBitmap(underlyingBitmap);
                                dataSource.close();
                                CloseableReference.closeSafely(closeableReference);
                                return createBitmap;
                            } catch (OutOfMemoryError unused) {
                                System.gc();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        dataSource.close();
                        CloseableReference.closeSafely(closeableReference);
                        throw th;
                    }
                }
                dataSource.close();
                CloseableReference.closeSafely(closeableReference);
                return null;
            } catch (Throwable th3) {
                closeableReference = null;
                th = th3;
            }
        } else {
            return (Bitmap) invokeL.objValue;
        }
    }

    public static Bitmap c(Uri uri, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, uri, context)) == null) {
            if (uri != null && context != null) {
                if (d(uri)) {
                    if (a) {
                        Log.i("SwanAppFrescoImageUtils", "start get Bitmap from memory, uri : " + uri.toString());
                    }
                    return b(Fresco.getImagePipeline().fetchImageFromBitmapCache(ImageRequest.fromUri(uri), context.getApplicationContext()));
                }
                if (a) {
                    Log.i("SwanAppFrescoImageUtils", "start get Bitmap from sdcard, uri : " + uri.toString());
                }
                DataSource<Boolean> isInDiskCache = Fresco.getImagePipeline().isInDiskCache(uri);
                if (isInDiskCache != null && isInDiskCache.hasResult() && isInDiskCache.getResult() != null && isInDiskCache.getResult().booleanValue()) {
                    try {
                        return b(Fresco.getImagePipeline().fetchDecodedImage(ImageRequest.fromUri(uri), context));
                    } finally {
                        isInDiskCache.close();
                    }
                }
            }
            return null;
        }
        return (Bitmap) invokeLL.objValue;
    }

    public static boolean d(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, uri)) == null) {
            if (uri != null && Fresco.getImagePipeline().isInBitmapMemoryCache(uri)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void e(String str, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, str, bVar) == null) {
            Uri C = di3.C(str);
            if (C == null) {
                bVar.a(str, null);
                return;
            }
            Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(C).build(), AppRuntime.getAppContext()).subscribe(new a(bVar, str), UiThreadImmediateExecutorService.getInstance());
        }
    }

    public static void f(Uri uri, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65542, null, uri, str) != null) || uri == null) {
            return;
        }
        if (a) {
            Log.i("SwanAppFrescoImageUtils", "start preFetch into memory, uri : " + uri.toString());
        }
        Fresco.getImagePipeline().prefetchToBitmapCache(ImageRequestBuilder.newBuilderWithSource(uri).build(), str);
    }

    public static Bitmap g(Bitmap bitmap, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65543, null, bitmap, i, i2)) == null) {
            if (bitmap == null || i <= 0 || i2 <= 0) {
                return null;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width == 0 || height == 0) {
                return null;
            }
            Matrix matrix = new Matrix();
            matrix.postScale(i / width, i2 / height);
            try {
                return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            } catch (Exception | OutOfMemoryError unused) {
                return null;
            }
        }
        return (Bitmap) invokeLII.objValue;
    }
}
