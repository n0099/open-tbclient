package com.baidu.tieba;

import android.graphics.Bitmap;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieImageAsset;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.resourceLoaderProc.LocalFileImageLoaderProc;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class c16 implements ImageAssetDelegate {
    public static /* synthetic */ Interceptable $ic;
    public static final String d;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public LocalFileImageLoaderProc b;
    public boolean c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947621953, "Lcom/baidu/tieba/c16;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947621953, "Lcom/baidu/tieba/c16;");
                return;
            }
        }
        d = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();
    }

    public c16() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = false;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return d + "/" + TbConfig.getTempDirName() + "/animation/";
        }
        return (String) invokeV.objValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.c = z;
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.a = a() + str + "/";
        }
    }

    @Override // com.airbnb.lottie.ImageAssetDelegate
    public Bitmap fetchBitmap(LottieImageAsset lottieImageAsset) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, lottieImageAsset)) == null) {
            if (ei.isEmpty(this.a)) {
                return null;
            }
            String str = this.a + lottieImageAsset.getDirName().replace("/", "") + "/" + lottieImageAsset.getFileName();
            BdImage bdImage = (BdImage) BdResourceLoader.getInstance().loadResourceFromMemery(str, 36, new Object[0]);
            if (bdImage == null && b()) {
                if (this.b == null) {
                    this.b = new LocalFileImageLoaderProc();
                }
                bdImage = this.b.getBitmapFromFile(str, 0, 0);
            }
            if (bdImage != null && bdImage.getRawBitmap() != null) {
                Bitmap rawBitmap = bdImage.getRawBitmap();
                try {
                    if (rawBitmap.getConfig() != null) {
                        return rawBitmap.copy(rawBitmap.getConfig(), false);
                    }
                } catch (OutOfMemoryError e) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    BdLog.e(e);
                }
            }
            BdResourceLoader.getInstance().loadResource(str, 36, null, null);
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }
}
