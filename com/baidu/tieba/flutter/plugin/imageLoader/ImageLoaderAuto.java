package com.baidu.tieba.flutter.plugin.imageLoader;

import java.util.HashMap;
/* loaded from: classes4.dex */
public class ImageLoaderAuto {

    /* loaded from: classes4.dex */
    public interface HostImageLoader {
        void cancel(ImageLoaderCancelParam imageLoaderCancelParam);

        void loadImage(RequestParam requestParam, Result<ImageResult> result);
    }

    /* loaded from: classes4.dex */
    public static class ImageLoaderCancelParam {
        public String key;

        public static ImageLoaderCancelParam fromMap(HashMap hashMap) {
            ImageLoaderCancelParam imageLoaderCancelParam = new ImageLoaderCancelParam();
            imageLoaderCancelParam.key = (String) hashMap.get("key");
            return imageLoaderCancelParam;
        }

        public String getKey() {
            return this.key;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("key", this.key);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public static class ImageResult {
        public byte[] data;
        public HashMap debugInfo;
        public String device;
        public Long errorType;
        public String expToLog;
        public NativeImageInfo imageInfo;
        public String key;
        public HashMap performance;

        public static ImageResult fromMap(HashMap hashMap) {
            Long valueOf;
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

        public byte[] getData() {
            return this.data;
        }

        public HashMap getDebugInfo() {
            return this.debugInfo;
        }

        public String getDevice() {
            return this.device;
        }

        public Long getErrorType() {
            return this.errorType;
        }

        public String getExpToLog() {
            return this.expToLog;
        }

        public NativeImageInfo getImageInfo() {
            return this.imageInfo;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap getPerformance() {
            return this.performance;
        }

        public void setData(byte[] bArr) {
            this.data = bArr;
        }

        public void setDebugInfo(HashMap hashMap) {
            this.debugInfo = hashMap;
        }

        public void setDevice(String str) {
            this.device = str;
        }

        public void setErrorType(Long l) {
            this.errorType = l;
        }

        public void setExpToLog(String str) {
            this.expToLog = str;
        }

        public void setImageInfo(NativeImageInfo nativeImageInfo) {
            this.imageInfo = nativeImageInfo;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public void setPerformance(HashMap hashMap) {
            this.performance = hashMap;
        }

        public HashMap toMap() {
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
    }

    /* loaded from: classes4.dex */
    public static class NativeImageInfo {
        public Double height;
        public Double scale;
        public Double width;

        public static NativeImageInfo fromMap(HashMap hashMap) {
            NativeImageInfo nativeImageInfo = new NativeImageInfo();
            nativeImageInfo.width = (Double) hashMap.get("width");
            nativeImageInfo.height = (Double) hashMap.get("height");
            nativeImageInfo.scale = (Double) hashMap.get("scale");
            return nativeImageInfo;
        }

        public Double getHeight() {
            return this.height;
        }

        public Double getScale() {
            return this.scale;
        }

        public Double getWidth() {
            return this.width;
        }

        public void setHeight(Double d2) {
            this.height = d2;
        }

        public void setScale(Double d2) {
            this.scale = d2;
        }

        public void setWidth(Double d2) {
            this.width = d2;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("width", this.width);
            hashMap.put("height", this.height);
            hashMap.put("scale", this.scale);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public static class RequestParam {
        public Boolean isSvg;
        public String key;
        public Boolean needCache;
        public Long patternColor;
        public Boolean preload;
        public String themeStr;
        public Long type;

        public static RequestParam fromMap(HashMap hashMap) {
            Long valueOf;
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

        public Boolean getIsSvg() {
            return this.isSvg;
        }

        public String getKey() {
            return this.key;
        }

        public Boolean getNeedCache() {
            return this.needCache;
        }

        public Long getPatternColor() {
            return this.patternColor;
        }

        public Boolean getPreload() {
            return this.preload;
        }

        public String getThemeStr() {
            return this.themeStr;
        }

        public Long getType() {
            return this.type;
        }

        public void setIsSvg(Boolean bool) {
            this.isSvg = bool;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public void setNeedCache(Boolean bool) {
            this.needCache = bool;
        }

        public void setPatternColor(Long l) {
            this.patternColor = l;
        }

        public void setPreload(Boolean bool) {
            this.preload = bool;
        }

        public void setThemeStr(String str) {
            this.themeStr = str;
        }

        public void setType(Long l) {
            this.type = l;
        }

        public HashMap toMap() {
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
    }

    /* loaded from: classes4.dex */
    public interface Result<T> {
        void success(T t);
    }

    public static HashMap wrapError(Exception exc) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", exc.toString());
        hashMap.put("code", exc.getClass().getSimpleName());
        hashMap.put("details", null);
        return hashMap;
    }
}
