package com.baidu.tieba.flutter.plugin.tiebaUtility;

import java.util.HashMap;
/* loaded from: classes4.dex */
public class TiebaUtilityVideoAuto {

    /* loaded from: classes4.dex */
    public static class CachePosition {
        public Long result;

        public static CachePosition fromMap(HashMap hashMap) {
            Long valueOf;
            CachePosition cachePosition = new CachePosition();
            Object obj = hashMap.get("result");
            if (obj == null) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            cachePosition.result = valueOf;
            return cachePosition;
        }

        public Long getResult() {
            return this.result;
        }

        public void setResult(Long l) {
            this.result = l;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("result", this.result);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public interface HostUtilityVideo {
        void getResumeTimeForVideo(VideoStringParam videoStringParam, Result<ResumeTimeResult> result);

        void getVideoMute(Result<VideoBoolValue> result);

        void isVideoCardMute(Result<VideoBoolValue> result);

        void setVideoCardMute(VideoBoolValue videoBoolValue);

        void setVideoMute(VideoBoolValue videoBoolValue, Result<VideoBoolValue> result);

        void updateTime(VideoTimeParam videoTimeParam);

        void videoPositionCacheManagerGetCachePosition(VideoStringParam videoStringParam, Result<CachePosition> result);

        void videoPositionCacheManagerRemove(VideoStringParam videoStringParam);

        void videoPositionCacheManagerUpdate(VideoTimeParam videoTimeParam);
    }

    /* loaded from: classes4.dex */
    public interface Result<T> {
        void success(T t);
    }

    /* loaded from: classes4.dex */
    public static class ResumeTimeResult {
        public Double result;

        public static ResumeTimeResult fromMap(HashMap hashMap) {
            ResumeTimeResult resumeTimeResult = new ResumeTimeResult();
            resumeTimeResult.result = (Double) hashMap.get("result");
            return resumeTimeResult;
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
    public static class VideoBoolValue {
        public Boolean result;

        public static VideoBoolValue fromMap(HashMap hashMap) {
            VideoBoolValue videoBoolValue = new VideoBoolValue();
            videoBoolValue.result = (Boolean) hashMap.get("result");
            return videoBoolValue;
        }

        public Boolean getResult() {
            return this.result;
        }

        public void setResult(Boolean bool) {
            this.result = bool;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("result", this.result);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public static class VideoStringParam {
        public String result;

        public static VideoStringParam fromMap(HashMap hashMap) {
            VideoStringParam videoStringParam = new VideoStringParam();
            videoStringParam.result = (String) hashMap.get("result");
            return videoStringParam;
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
    public static class VideoTimeParam {
        public Double durtion;
        public String videoUrl;

        public static VideoTimeParam fromMap(HashMap hashMap) {
            VideoTimeParam videoTimeParam = new VideoTimeParam();
            videoTimeParam.videoUrl = (String) hashMap.get("videoUrl");
            videoTimeParam.durtion = (Double) hashMap.get("durtion");
            return videoTimeParam;
        }

        public Double getDurtion() {
            return this.durtion;
        }

        public String getVideoUrl() {
            return this.videoUrl;
        }

        public void setDurtion(Double d2) {
            this.durtion = d2;
        }

        public void setVideoUrl(String str) {
            this.videoUrl = str;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("videoUrl", this.videoUrl);
            hashMap.put("durtion", this.durtion);
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
