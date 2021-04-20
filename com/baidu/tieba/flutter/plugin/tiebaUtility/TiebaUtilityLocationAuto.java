package com.baidu.tieba.flutter.plugin.tiebaUtility;

import java.util.HashMap;
/* loaded from: classes4.dex */
public class TiebaUtilityLocationAuto {

    /* loaded from: classes4.dex */
    public static class AppPosInfoResult {
        public String result;

        public static AppPosInfoResult fromMap(HashMap hashMap) {
            AppPosInfoResult appPosInfoResult = new AppPosInfoResult();
            appPosInfoResult.result = (String) hashMap.get("result");
            return appPosInfoResult;
        }

        public String getResult() {
            return this.result;
        }

        public void setResult(String str) {
            this.result = str;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("result", this.result);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public static class DistanceResult {
        public Double result;

        public static DistanceResult fromMap(HashMap hashMap) {
            DistanceResult distanceResult = new DistanceResult();
            distanceResult.result = (Double) hashMap.get("result");
            return distanceResult;
        }

        public Double getResult() {
            return this.result;
        }

        public void setResult(Double d2) {
            this.result = d2;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("result", this.result);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public interface HostUtilityLocation {
        void getAppPosInfo(Result<AppPosInfoResult> result);

        void requestDistance(LocationParam locationParam, Result<DistanceResult> result);
    }

    /* loaded from: classes4.dex */
    public static class LocationParam {
        public Double latitude;
        public Double longitude;

        public static LocationParam fromMap(HashMap hashMap) {
            LocationParam locationParam = new LocationParam();
            locationParam.latitude = (Double) hashMap.get("latitude");
            locationParam.longitude = (Double) hashMap.get("longitude");
            return locationParam;
        }

        public Double getLatitude() {
            return this.latitude;
        }

        public Double getLongitude() {
            return this.longitude;
        }

        public void setLatitude(Double d2) {
            this.latitude = d2;
        }

        public void setLongitude(Double d2) {
            this.longitude = d2;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("latitude", this.latitude);
            hashMap.put("longitude", this.longitude);
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
