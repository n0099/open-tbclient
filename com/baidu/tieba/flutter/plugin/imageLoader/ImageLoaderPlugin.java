package com.baidu.tieba.flutter.plugin.imageLoader;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.NonNull;
import c.a.d.a.h;
import c.a.d.f.l.c;
import c.a.d.f.l.d;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.d.o.d.a;
import c.a.t0.s0.k;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.flutter.plugin.imageLoader.ImageLoaderAuto;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import java.util.HashMap;
/* loaded from: classes12.dex */
public class ImageLoaderPlugin implements FlutterPlugin, ImageLoaderAuto.HostImageLoader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_LOCAL = 1;
    public static final int TYPE_REMOTE = 2;
    public static int requestId = -1;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes12.dex */
    public static final class ImageLoadingError {
        public static final /* synthetic */ ImageLoadingError[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ImageLoadingError Canceled;
        public static final ImageLoadingError Invalid;
        public static final ImageLoadingError NetworkError;
        public static final ImageLoadingError NoSuchFile;
        public static final ImageLoadingError Succeed;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-79338349, "Lcom/baidu/tieba/flutter/plugin/imageLoader/ImageLoaderPlugin$ImageLoadingError;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-79338349, "Lcom/baidu/tieba/flutter/plugin/imageLoader/ImageLoaderPlugin$ImageLoadingError;");
                    return;
                }
            }
            Invalid = new ImageLoadingError("Invalid", 0);
            Succeed = new ImageLoadingError("Succeed", 1);
            NoSuchFile = new ImageLoadingError("NoSuchFile", 2);
            NetworkError = new ImageLoadingError("NetworkError", 3);
            ImageLoadingError imageLoadingError = new ImageLoadingError("Canceled", 4);
            Canceled = imageLoadingError;
            $VALUES = new ImageLoadingError[]{Invalid, Succeed, NoSuchFile, NetworkError, imageLoadingError};
        }

        public ImageLoadingError(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ImageLoadingError valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ImageLoadingError) Enum.valueOf(ImageLoadingError.class, str) : (ImageLoadingError) invokeL.objValue;
        }

        public static ImageLoadingError[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ImageLoadingError[]) $VALUES.clone() : (ImageLoadingError[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1485608874, "Lcom/baidu/tieba/flutter/plugin/imageLoader/ImageLoaderPlugin;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1485608874, "Lcom/baidu/tieba/flutter/plugin/imageLoader/ImageLoaderPlugin;");
        }
    }

    public ImageLoaderPlugin() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static /* synthetic */ int access$108() {
        int i2 = requestId;
        requestId = i2 + 1;
        return i2;
    }

    private Bitmap getBitMap(Resources resources, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, this, resources, i2)) == null) {
            if (Build.VERSION.SDK_INT > 21) {
                Drawable drawable = resources.getDrawable(i2, null);
                Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                return createBitmap;
            }
            return BitmapFactory.decodeResource(resources, i2);
        }
        return (Bitmap) invokeLI.objValue;
    }

    private int getResIdBySkin(String str, int i2) {
        InterceptResult invokeLI;
        int darkResourceId;
        int nightResouceId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, this, str, i2)) == null) {
            if (m.isEmpty(str)) {
                return 0;
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(str) && (nightResouceId = SkinManager.getNightResouceId(TbadkCoreApplication.getInst().getResources(), i2)) > 0) {
                i2 = nightResouceId;
            }
            return (!SkinManager.SKIN_TYPE_STR_DARK.equals(str) || (darkResourceId = SkinManager.getDarkResourceId(TbadkCoreApplication.getInst().getResources(), i2)) <= 0) ? i2 : darkResourceId;
        }
        return invokeLI.intValue;
    }

    private int getSkinType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, str)) == null) {
            int i2 = 0;
            if (m.isEmpty(str)) {
                return 0;
            }
            if (!"default".equals(str) && SkinManager.SKIN_TYPE_STR_NIGHT.equals(str)) {
                i2 = 1;
            }
            if (SkinManager.SKIN_TYPE_STR_DARK.equals(str)) {
                return 4;
            }
            return i2;
        }
        return invokeL.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onResult(ImageLoadingError imageLoadingError, ImageLoaderAuto.Result<ImageLoaderAuto.ImageResult> result, a aVar, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65544, this, imageLoadingError, result, aVar, hashMap, hashMap2) == null) || hashMap == null) {
            return;
        }
        byte[] bArr = null;
        if (aVar != null && (bArr = aVar.k()) == null && aVar.w()) {
            bArr = aVar.n();
        }
        if (imageLoadingError == ImageLoadingError.Succeed && bArr == null) {
            imageLoadingError = ImageLoadingError.Invalid;
        }
        ImageLoaderAuto.ImageResult imageResult = new ImageLoaderAuto.ImageResult();
        imageResult.setKey((String) hashMap.get("key"));
        imageResult.setErrorType(Long.valueOf(imageLoadingError.ordinal()));
        imageResult.setDevice("android");
        imageResult.setDebugInfo(hashMap);
        ImageLoaderAuto.NativeImageInfo nativeImageInfo = new ImageLoaderAuto.NativeImageInfo();
        if (imageLoadingError == ImageLoadingError.Succeed) {
            if (aVar != null) {
                nativeImageInfo.setHeight(Double.valueOf(aVar.m()));
                nativeImageInfo.setWidth(Double.valueOf(aVar.r()));
            }
            nativeImageInfo.setScale(Double.valueOf(1.0d));
            imageResult.setData(bArr);
            if (hashMap.containsKey("requestId") && shouldMonitorPerformance(((Integer) hashMap.get("requestId")).intValue()) && hashMap2 != null) {
                if (bArr != null) {
                    hashMap2.put("imageDataSize", Integer.valueOf(bArr.length));
                }
                hashMap2.put("sendTime", Long.valueOf(System.currentTimeMillis()));
                imageResult.setPerformance(hashMap2);
            }
        }
        imageResult.setImageInfo(nativeImageInfo);
        if (result != null) {
            result.success(imageResult);
        }
    }

    private boolean shouldMonitorPerformance(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65545, this, i2)) == null) ? k.d().g() && i2 % 100 == 0 : invokeI.booleanValue;
    }

    @Override // com.baidu.tieba.flutter.plugin.imageLoader.ImageLoaderAuto.HostImageLoader
    public void cancel(ImageLoaderAuto.ImageLoaderCancelParam imageLoaderCancelParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, imageLoaderCancelParam) == null) {
            d.h().c(imageLoaderCancelParam.getKey(), 44);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.imageLoader.ImageLoaderAuto.HostImageLoader
    public void loadImage(ImageLoaderAuto.RequestParam requestParam, ImageLoaderAuto.Result<ImageLoaderAuto.ImageResult> result) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, requestParam, result) == null) || m.isEmpty(requestParam.getKey())) {
            return;
        }
        if (requestParam.getType().longValue() == 1) {
            loadLocalImage(requestParam, result);
        } else if (requestParam.getType().longValue() == 2) {
            loadRemoteImage(requestParam, result);
        }
    }

    public void loadLocalImage(ImageLoaderAuto.RequestParam requestParam, ImageLoaderAuto.Result<ImageLoaderAuto.ImageResult> result) {
        Drawable maskDrawable;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, requestParam, result) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            Resources resources = h.a().getResources();
            if (resources == null) {
                return;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("key", requestParam.getKey());
            hashMap.put(FetchLog.START_TIME, Long.valueOf(currentTimeMillis));
            String androidNameFromIos = ResNameTransform.getAndroidNameFromIos(requestParam.getKey());
            int identifier = resources.getIdentifier(androidNameFromIos, "drawable", BdBaseApplication.getInst().getPackageName());
            int i3 = 1;
            int i4 = 0;
            if (!androidNameFromIos.contains("_mask_") && !androidNameFromIos.contains("_pure_")) {
                int resIdBySkin = getResIdBySkin(requestParam.getThemeStr(), identifier);
                i2 = 4;
                if (resIdBySkin != 0) {
                    i2 = 5;
                    Bitmap bitMap = getBitMap(resources, resIdBySkin);
                    if (bitMap != null) {
                        i2 = 6;
                        hashMap.put(ShaderParams.VALUE_TYPE_STEP, String.valueOf(6));
                        onResult(ImageLoadingError.Succeed, result, new a(bitMap, false), hashMap, null);
                    }
                }
                i3 = 0;
            } else {
                if (requestParam.getIsSvg() != null && requestParam.getIsSvg().booleanValue()) {
                    if (requestParam.getPatternColor() != null && requestParam.getPatternColor().longValue() != 0) {
                        maskDrawable = SvgManager.getInstance().getPureDrawableWithColorValue(identifier, requestParam.getPatternColor().intValue(), SvgManager.SvgResourceStateType.NORMAL);
                    } else {
                        maskDrawable = SvgManager.getInstance().getMaskDrawable(identifier, null);
                    }
                } else if (requestParam.getPatternColor() != null && requestParam.getPatternColor().longValue() != 0) {
                    maskDrawable = WebPManager.getPureDrawable(identifier, requestParam.getPatternColor().intValue(), WebPManager.ResourceStateType.NORMAL);
                } else {
                    maskDrawable = WebPManager.getMaskDrawable(identifier, (WebPManager.ResourceStateType) null);
                }
                if (maskDrawable != null) {
                    Bitmap createBitmap = Bitmap.createBitmap(maskDrawable.getIntrinsicWidth(), maskDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(createBitmap);
                    maskDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                    maskDrawable.draw(canvas);
                    if (createBitmap != null) {
                        hashMap.put(ShaderParams.VALUE_TYPE_STEP, String.valueOf(3));
                        onResult(ImageLoadingError.Succeed, result, new a(createBitmap, false), hashMap, null);
                        i4 = 1;
                        i3 = 3;
                    } else {
                        i3 = 2;
                    }
                }
                i2 = i3;
                i3 = i4;
            }
            if (i3 == 0) {
                hashMap.put(ShaderParams.VALUE_TYPE_STEP, String.valueOf(i2));
                onResult(ImageLoadingError.NoSuchFile, result, null, hashMap, null);
                if (BdBaseApplication.getInst().isDebugMode()) {
                    TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                    UtilHelper.showToast(inst, "图片找不到:" + requestParam.getKey());
                }
                BdLog.e("flutter resource in package not found :" + requestParam.getKey());
            }
        }
    }

    public void loadRemoteImage(ImageLoaderAuto.RequestParam requestParam, ImageLoaderAuto.Result<ImageLoaderAuto.ImageResult> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, requestParam, result) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            HashMap hashMap = new HashMap();
            hashMap.put("key", requestParam.getKey());
            hashMap.put(FetchLog.START_TIME, Long.valueOf(currentTimeMillis));
            d.h().k(requestParam.getKey(), 44, new c<a>(this, hashMap, result, currentTimeMillis) { // from class: com.baidu.tieba.flutter.plugin.imageLoader.ImageLoaderPlugin.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ImageLoaderPlugin this$0;
                public final /* synthetic */ HashMap val$reqInfo;
                public final /* synthetic */ ImageLoaderAuto.Result val$result;
                public final /* synthetic */ long val$startLoad;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, hashMap, result, Long.valueOf(currentTimeMillis)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$reqInfo = hashMap;
                    this.val$result = result;
                    this.val$startLoad = currentTimeMillis;
                }

                @Override // c.a.d.f.l.c
                public void onCancelled(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                        super.onCancelled(str);
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("isCancle", "true");
                        this.this$0.onResult(ImageLoadingError.Canceled, this.val$result, null, hashMap2, null);
                    }
                }

                @Override // c.a.d.f.l.c
                public void onProgressUpdate(Object... objArr) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, objArr) == null) {
                        super.onProgressUpdate(objArr);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // c.a.d.f.l.c
                public void onLoaded(a aVar, String str, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i2) == null) {
                        HashMap hashMap2 = this.val$reqInfo;
                        hashMap2.put("resourceFrom", i2 + "");
                        if (aVar != null) {
                            this.val$reqInfo.put("isGif", String.valueOf(aVar.t()));
                        } else {
                            this.val$reqInfo.put("resource", StringUtil.NULL_STRING);
                        }
                        if (aVar == null) {
                            this.this$0.onResult(ImageLoadingError.NetworkError, this.val$result, aVar, this.val$reqInfo, null);
                            return;
                        }
                        HashMap hashMap3 = null;
                        if (i2 == 3) {
                            ImageLoaderPlugin.access$108();
                            this.val$reqInfo.put("requestId", Integer.valueOf(ImageLoaderPlugin.requestId));
                            hashMap3 = new HashMap();
                            hashMap3.put("isBundleFile", Boolean.FALSE);
                            hashMap3.put("netType", l.J());
                            hashMap3.put("contentType", String.valueOf(i2));
                            hashMap3.put("loadingCost", Long.valueOf(System.currentTimeMillis() - this.val$startLoad));
                        }
                        this.this$0.onResult(ImageLoadingError.Succeed, this.val$result, aVar, this.val$reqInfo, hashMap3);
                    }
                }
            }, 0, 0, BdUniqueId.gen(), new Object[0]);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, flutterPluginBinding) == null) {
            c.a.u0.a1.a.c.d.d(flutterPluginBinding.getBinaryMessenger(), this);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, flutterPluginBinding) == null) {
            c.a.u0.a1.a.c.d.d(flutterPluginBinding.getBinaryMessenger(), null);
        }
    }
}
