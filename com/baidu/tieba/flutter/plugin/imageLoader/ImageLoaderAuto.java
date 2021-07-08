package com.baidu.tieba.flutter.plugin.imageLoader;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class ImageLoaderAuto {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public interface HostImageLoader {
        void cancel(ImageLoaderCancelParam imageLoaderCancelParam);

        void loadImage(RequestParam requestParam, Result<ImageResult> result);
    }

    /* loaded from: classes4.dex */
    public static class ImageLoaderCancelParam {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String key;

        public ImageLoaderCancelParam() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static ImageLoaderCancelParam fromMap(HashMap hashMap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
                ImageLoaderCancelParam imageLoaderCancelParam = new ImageLoaderCancelParam();
                imageLoaderCancelParam.key = (String) hashMap.get("key");
                return imageLoaderCancelParam;
            }
            return (ImageLoaderCancelParam) invokeL.objValue;
        }

        public String getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.key : (String) invokeV.objValue;
        }

        public void setKey(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.key = str;
            }
        }

        public HashMap toMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("key", this.key);
                return hashMap;
            }
            return (HashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class ImageResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public byte[] data;
        public HashMap debugInfo;
        public String device;
        public Long errorType;
        public String expToLog;
        public NativeImageInfo imageInfo;
        public String key;
        public HashMap performance;

        public ImageResult() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static ImageResult fromMap(HashMap hashMap) {
            InterceptResult invokeL;
            Long valueOf;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
                ImageResult imageResult = new ImageResult();
                imageResult.key = (String) hashMap.get("key");
                imageResult.device = (String) hashMap.get("device");
                imageResult.expToLog = (String) hashMap.get("expToLog");
                imageResult.imageInfo = NativeImageInfo.fromMap((HashMap) hashMap.get("imageInfo"));
                imageResult.data = (byte[]) hashMap.get("data");
                Object obj = hashMap.get("errorType");
                if (obj == null) {
                    valueOf = null;
                } else {
                    valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
                }
                imageResult.errorType = valueOf;
                imageResult.debugInfo = (HashMap) hashMap.get("debugInfo");
                imageResult.performance = (HashMap) hashMap.get("performance");
                return imageResult;
            }
            return (ImageResult) invokeL.objValue;
        }

        public byte[] getData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.data : (byte[]) invokeV.objValue;
        }

        public HashMap getDebugInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.debugInfo : (HashMap) invokeV.objValue;
        }

        public String getDevice() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.device : (String) invokeV.objValue;
        }

        public Long getErrorType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.errorType : (Long) invokeV.objValue;
        }

        public String getExpToLog() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.expToLog : (String) invokeV.objValue;
        }

        public NativeImageInfo getImageInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.imageInfo : (NativeImageInfo) invokeV.objValue;
        }

        public String getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.key : (String) invokeV.objValue;
        }

        public HashMap getPerformance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.performance : (HashMap) invokeV.objValue;
        }

        public void setData(byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr) == null) {
                this.data = bArr;
            }
        }

        public void setDebugInfo(HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, hashMap) == null) {
                this.debugInfo = hashMap;
            }
        }

        public void setDevice(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
                this.device = str;
            }
        }

        public void setErrorType(Long l) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, l) == null) {
                this.errorType = l;
            }
        }

        public void setExpToLog(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
                this.expToLog = str;
            }
        }

        public void setImageInfo(NativeImageInfo nativeImageInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, nativeImageInfo) == null) {
                this.imageInfo = nativeImageInfo;
            }
        }

        public void setKey(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
                this.key = str;
            }
        }

        public void setPerformance(HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, hashMap) == null) {
                this.performance = hashMap;
            }
        }

        public HashMap toMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("key", this.key);
                hashMap.put("device", this.device);
                hashMap.put("expToLog", this.expToLog);
                hashMap.put("imageInfo", this.imageInfo.toMap());
                hashMap.put("data", this.data);
                hashMap.put("errorType", this.errorType);
                hashMap.put("debugInfo", this.debugInfo);
                hashMap.put("performance", this.performance);
                return hashMap;
            }
            return (HashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class NativeImageInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Double height;
        public Double scale;
        public Double width;

        public NativeImageInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static NativeImageInfo fromMap(HashMap hashMap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
                NativeImageInfo nativeImageInfo = new NativeImageInfo();
                nativeImageInfo.width = (Double) hashMap.get("width");
                nativeImageInfo.height = (Double) hashMap.get("height");
                nativeImageInfo.scale = (Double) hashMap.get("scale");
                return nativeImageInfo;
            }
            return (NativeImageInfo) invokeL.objValue;
        }

        public Double getHeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.height : (Double) invokeV.objValue;
        }

        public Double getScale() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.scale : (Double) invokeV.objValue;
        }

        public Double getWidth() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.width : (Double) invokeV.objValue;
        }

        public void setHeight(Double d2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, d2) == null) {
                this.height = d2;
            }
        }

        public void setScale(Double d2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, d2) == null) {
                this.scale = d2;
            }
        }

        public void setWidth(Double d2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, d2) == null) {
                this.width = d2;
            }
        }

        public HashMap toMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("width", this.width);
                hashMap.put("height", this.height);
                hashMap.put("scale", this.scale);
                return hashMap;
            }
            return (HashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class RequestParam {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Boolean isSvg;
        public String key;
        public Boolean needCache;
        public Long patternColor;
        public Boolean preload;
        public String themeStr;
        public Long type;

        public RequestParam() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static RequestParam fromMap(HashMap hashMap) {
            InterceptResult invokeL;
            Long valueOf;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
                RequestParam requestParam = new RequestParam();
                Object obj = hashMap.get("type");
                Long l = null;
                if (obj == null) {
                    valueOf = null;
                } else {
                    valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
                }
                requestParam.type = valueOf;
                requestParam.key = (String) hashMap.get("key");
                requestParam.themeStr = (String) hashMap.get("themeStr");
                requestParam.needCache = (Boolean) hashMap.get("needCache");
                Object obj2 = hashMap.get("patternColor");
                if (obj2 != null) {
                    l = Long.valueOf(obj2 instanceof Integer ? ((Integer) obj2).intValue() : ((Long) obj2).longValue());
                }
                requestParam.patternColor = l;
                requestParam.isSvg = (Boolean) hashMap.get("isSvg");
                requestParam.preload = (Boolean) hashMap.get("preload");
                return requestParam;
            }
            return (RequestParam) invokeL.objValue;
        }

        public Boolean getIsSvg() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.isSvg : (Boolean) invokeV.objValue;
        }

        public String getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.key : (String) invokeV.objValue;
        }

        public Boolean getNeedCache() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.needCache : (Boolean) invokeV.objValue;
        }

        public Long getPatternColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.patternColor : (Long) invokeV.objValue;
        }

        public Boolean getPreload() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.preload : (Boolean) invokeV.objValue;
        }

        public String getThemeStr() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.themeStr : (String) invokeV.objValue;
        }

        public Long getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.type : (Long) invokeV.objValue;
        }

        public void setIsSvg(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, bool) == null) {
                this.isSvg = bool;
            }
        }

        public void setKey(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                this.key = str;
            }
        }

        public void setNeedCache(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, bool) == null) {
                this.needCache = bool;
            }
        }

        public void setPatternColor(Long l) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, l) == null) {
                this.patternColor = l;
            }
        }

        public void setPreload(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, bool) == null) {
                this.preload = bool;
            }
        }

        public void setThemeStr(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
                this.themeStr = str;
            }
        }

        public void setType(Long l) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, l) == null) {
                this.type = l;
            }
        }

        public HashMap toMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("type", this.type);
                hashMap.put("key", this.key);
                hashMap.put("themeStr", this.themeStr);
                hashMap.put("needCache", this.needCache);
                hashMap.put("patternColor", this.patternColor);
                hashMap.put("isSvg", this.isSvg);
                hashMap.put("preload", this.preload);
                return hashMap;
            }
            return (HashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public interface Result<T> {
        void success(T t);
    }

    public ImageLoaderAuto() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static HashMap wrapError(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, exc)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("message", exc.toString());
            hashMap.put("code", exc.getClass().getSimpleName());
            hashMap.put("details", null);
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
