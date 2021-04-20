package com.baidu.tieba.flutter.plugin.performanceMonitor;

import java.util.HashMap;
/* loaded from: classes4.dex */
public class PerformanceMonitorAuto {

    /* loaded from: classes4.dex */
    public static class FpsParam {
        public HashMap cont;
        public HashMap fatal;
        public Double fps;
        public String page;

        public static FpsParam fromMap(HashMap hashMap) {
            FpsParam fpsParam = new FpsParam();
            fpsParam.page = (String) hashMap.get("page");
            fpsParam.fps = (Double) hashMap.get("fps");
            fpsParam.cont = (HashMap) hashMap.get("cont");
            fpsParam.fatal = (HashMap) hashMap.get("fatal");
            return fpsParam;
        }

        public HashMap getCont() {
            return this.cont;
        }

        public HashMap getFatal() {
            return this.fatal;
        }

        public Double getFps() {
            return this.fps;
        }

        public String getPage() {
            return this.page;
        }

        public void setCont(HashMap hashMap) {
            this.cont = hashMap;
        }

        public void setFatal(HashMap hashMap) {
            this.fatal = hashMap;
        }

        public void setFps(Double d2) {
            this.fps = d2;
        }

        public void setPage(String str) {
            this.page = str;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("page", this.page);
            hashMap.put("fps", this.fps);
            hashMap.put("cont", this.cont);
            hashMap.put("fatal", this.fatal);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public interface HostPerformanceMonitor {
        void reportEnginePerformance(MapParam mapParam);

        void reportFPSPerformance(FpsParam fpsParam);

        void reportImageLoadPerformance(MapParam mapParam);

        void reportPageLoadPerformance(MapParam mapParam);
    }

    /* loaded from: classes4.dex */
    public static class MapParam {
        public HashMap params;

        public static MapParam fromMap(HashMap hashMap) {
            MapParam mapParam = new MapParam();
            mapParam.params = (HashMap) hashMap.get("params");
            return mapParam;
        }

        public HashMap getParams() {
            return this.params;
        }

        public void setParams(HashMap hashMap) {
            this.params = hashMap;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("params", this.params);
            return hashMap;
        }
    }

    public static HashMap wrapError(Exception exc) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", exc.toString());
        hashMap.put("code", exc.getClass().getSimpleName());
        hashMap.put("details", null);
        return hashMap;
    }
}
