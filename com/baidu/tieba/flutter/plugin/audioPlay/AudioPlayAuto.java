package com.baidu.tieba.flutter.plugin.audioPlay;

import java.util.HashMap;
/* loaded from: classes4.dex */
public class AudioPlayAuto {

    /* loaded from: classes4.dex */
    public static class AudioResult {
        public Boolean result;

        public static AudioResult fromMap(HashMap hashMap) {
            AudioResult audioResult = new AudioResult();
            audioResult.result = (Boolean) hashMap.get("result");
            return audioResult;
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
    public static class CreateParam {
        public String pageName;

        public static CreateParam fromMap(HashMap hashMap) {
            CreateParam createParam = new CreateParam();
            createParam.pageName = (String) hashMap.get("pageName");
            return createParam;
        }

        public String getPageName() {
            return this.pageName;
        }

        public void setPageName(String str) {
            this.pageName = str;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("pageName", this.pageName);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public static class DisposeParam {
        public String pageName;

        public static DisposeParam fromMap(HashMap hashMap) {
            DisposeParam disposeParam = new DisposeParam();
            disposeParam.pageName = (String) hashMap.get("pageName");
            return disposeParam;
        }

        public String getPageName() {
            return this.pageName;
        }

        public void setPageName(String str) {
            this.pageName = str;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("pageName", this.pageName);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public interface HostAudioPlay {
        void create(CreateParam createParam, Result<AudioResult> result);

        void dispose(DisposeParam disposeParam, Result<AudioResult> result);

        void play(PlayParam playParam, Result<AudioResult> result);

        void stop(StopParam stopParam, Result<AudioResult> result);
    }

    /* loaded from: classes4.dex */
    public static class PlayParam {
        public String duration;
        public String identifier;
        public String url;

        public static PlayParam fromMap(HashMap hashMap) {
            PlayParam playParam = new PlayParam();
            playParam.url = (String) hashMap.get("url");
            playParam.identifier = (String) hashMap.get("identifier");
            playParam.duration = (String) hashMap.get("duration");
            return playParam;
        }

        public String getDuration() {
            return this.duration;
        }

        public String getIdentifier() {
            return this.identifier;
        }

        public String getUrl() {
            return this.url;
        }

        public void setDuration(String str) {
            this.duration = str;
        }

        public void setIdentifier(String str) {
            this.identifier = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("url", this.url);
            hashMap.put("identifier", this.identifier);
            hashMap.put("duration", this.duration);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public interface Result<T> {
        void success(T t);
    }

    /* loaded from: classes4.dex */
    public static class StopParam {
        public String url;

        public static StopParam fromMap(HashMap hashMap) {
            StopParam stopParam = new StopParam();
            stopParam.url = (String) hashMap.get("url");
            return stopParam;
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("url", this.url);
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
