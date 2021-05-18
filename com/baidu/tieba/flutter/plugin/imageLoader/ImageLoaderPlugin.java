package com.baidu.tieba.flutter.plugin.imageLoader;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.flutter.plugin.imageLoader.ImageLoaderAuto;
import d.a.c.a.h;
import d.a.c.e.l.c;
import d.a.c.e.l.d;
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import d.a.c.j.d.a;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class ImageLoaderPlugin implements FlutterPlugin, ImageLoaderAuto.HostImageLoader {
    public static final int TYPE_LOCAL = 1;
    public static final int TYPE_REMOTE = 2;
    public static int requestId = -1;

    /* loaded from: classes4.dex */
    public enum ImageLoadingError {
        Invalid,
        Succeed,
        NoSuchFile,
        NetworkError,
        Canceled
    }

    public static /* synthetic */ int access$108() {
        int i2 = requestId;
        requestId = i2 + 1;
        return i2;
    }

    private Bitmap getBitMap(Resources resources, int i2) {
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

    private int getResIdBySkin(String str, int i2) {
        int darkResourceId;
        int nightResouceId;
        if (k.isEmpty(str)) {
            return 0;
        }
        if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(str) && (nightResouceId = SkinManager.getNightResouceId(TbadkCoreApplication.getInst().getResources(), i2)) > 0) {
            i2 = nightResouceId;
        }
        return (!SkinManager.SKIN_TYPE_STR_DARK.equals(str) || (darkResourceId = SkinManager.getDarkResourceId(TbadkCoreApplication.getInst().getResources(), i2)) <= 0) ? i2 : darkResourceId;
    }

    private int getSkinType(String str) {
        int i2 = 0;
        if (k.isEmpty(str)) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void onResult(ImageLoadingError imageLoadingError, ImageLoaderAuto.Result<ImageLoaderAuto.ImageResult> result, a aVar, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2) {
        if (hashMap == null) {
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
        return d.a.j0.m0.k.d().g() && i2 % 100 == 0;
    }

    @Override // com.baidu.tieba.flutter.plugin.imageLoader.ImageLoaderAuto.HostImageLoader
    public void cancel(ImageLoaderAuto.ImageLoaderCancelParam imageLoaderCancelParam) {
        d.h().c(imageLoaderCancelParam.getKey(), 44);
    }

    @Override // com.baidu.tieba.flutter.plugin.imageLoader.ImageLoaderAuto.HostImageLoader
    public void loadImage(ImageLoaderAuto.RequestParam requestParam, ImageLoaderAuto.Result<ImageLoaderAuto.ImageResult> result) {
        if (k.isEmpty(requestParam.getKey())) {
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
        long currentTimeMillis = System.currentTimeMillis();
        Resources b2 = h.a().b();
        if (b2 == null) {
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("key", requestParam.getKey());
        hashMap.put("startTime", Long.valueOf(currentTimeMillis));
        String androidNameFromIos = ResNameTransform.getAndroidNameFromIos(requestParam.getKey());
        int identifier = b2.getIdentifier(androidNameFromIos, "drawable", BdBaseApplication.getInst().getPackageName());
        int i3 = 1;
        int i4 = 0;
        if (!androidNameFromIos.contains("_mask_") && !androidNameFromIos.contains("_pure_")) {
            int resIdBySkin = getResIdBySkin(requestParam.getThemeStr(), identifier);
            i2 = 4;
            if (resIdBySkin != 0) {
                i2 = 5;
                Bitmap bitMap = getBitMap(b2, resIdBySkin);
                if (bitMap != null) {
                    i2 = 6;
                    hashMap.put("step", String.valueOf(6));
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
                    hashMap.put("step", String.valueOf(3));
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
            hashMap.put("step", String.valueOf(i2));
            onResult(ImageLoadingError.NoSuchFile, result, null, hashMap, null);
            if (BdBaseApplication.getInst().isDebugMode()) {
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                UtilHelper.showToast(inst, "图片找不到:" + requestParam.getKey());
            }
            BdLog.e("flutter resource in package not found :" + requestParam.getKey());
        }
    }

    public void loadRemoteImage(ImageLoaderAuto.RequestParam requestParam, final ImageLoaderAuto.Result<ImageLoaderAuto.ImageResult> result) {
        final long currentTimeMillis = System.currentTimeMillis();
        final HashMap hashMap = new HashMap();
        hashMap.put("key", requestParam.getKey());
        hashMap.put("startTime", Long.valueOf(currentTimeMillis));
        d.h().k(requestParam.getKey(), 44, new c<a>() { // from class: com.baidu.tieba.flutter.plugin.imageLoader.ImageLoaderPlugin.1
            @Override // d.a.c.e.l.c
            public void onCancelled(String str) {
                super.onCancelled(str);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("isCancle", "true");
                ImageLoaderPlugin.this.onResult(ImageLoadingError.Canceled, result, null, hashMap2, null);
            }

            @Override // d.a.c.e.l.c
            public void onProgressUpdate(Object... objArr) {
                super.onProgressUpdate(objArr);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.c.e.l.c
            public void onLoaded(a aVar, String str, int i2) {
                HashMap hashMap2 = hashMap;
                hashMap2.put("resourceFrom", i2 + "");
                if (aVar != null) {
                    hashMap.put("isGif", String.valueOf(aVar.t()));
                } else {
                    hashMap.put("resource", StringUtil.NULL_STRING);
                }
                if (aVar == null) {
                    ImageLoaderPlugin.this.onResult(ImageLoadingError.NetworkError, result, aVar, hashMap, null);
                    return;
                }
                HashMap hashMap3 = null;
                if (i2 == 3) {
                    ImageLoaderPlugin.access$108();
                    hashMap.put("requestId", Integer.valueOf(ImageLoaderPlugin.requestId));
                    hashMap3 = new HashMap();
                    hashMap3.put("isBundleFile", Boolean.FALSE);
                    hashMap3.put("netType", j.J());
                    hashMap3.put("contentType", String.valueOf(i2));
                    hashMap3.put("loadingCost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
                ImageLoaderPlugin.this.onResult(ImageLoadingError.Succeed, result, aVar, hashMap, hashMap3);
            }
        }, 0, 0, BdUniqueId.gen(), new Object[0]);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        d.a.k0.m0.a.c.d.d(flutterPluginBinding.getBinaryMessenger(), this);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        d.a.k0.m0.a.c.d.d(flutterPluginBinding.getBinaryMessenger(), null);
    }
}
