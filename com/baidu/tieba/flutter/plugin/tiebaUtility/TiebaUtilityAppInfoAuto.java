package com.baidu.tieba.flutter.plugin.tiebaUtility;

import java.util.HashMap;
/* loaded from: classes4.dex */
public class TiebaUtilityAppInfoAuto {

    /* loaded from: classes4.dex */
    public static class AppInfoStringResult {
        public String result;

        public static AppInfoStringResult fromMap(HashMap hashMap) {
            AppInfoStringResult appInfoStringResult = new AppInfoStringResult();
            appInfoStringResult.result = (String) hashMap.get("result");
            return appInfoStringResult;
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
    public static class ChannelTab {
        public String tabCode;
        public String tabType;
        public String tid;

        public static ChannelTab fromMap(HashMap hashMap) {
            ChannelTab channelTab = new ChannelTab();
            channelTab.tid = (String) hashMap.get("tid");
            channelTab.tabCode = (String) hashMap.get("tabCode");
            channelTab.tabType = (String) hashMap.get("tabType");
            return channelTab;
        }

        public String getTabCode() {
            return this.tabCode;
        }

        public String getTabType() {
            return this.tabType;
        }

        public String getTid() {
            return this.tid;
        }

        public void setTabCode(String str) {
            this.tabCode = str;
        }

        public void setTabType(String str) {
            this.tabType = str;
        }

        public void setTid(String str) {
            this.tid = str;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("tid", this.tid);
            hashMap.put("tabCode", this.tabCode);
            hashMap.put("tabType", this.tabType);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public interface HostUtilityAppInfo {
        void getAppVersion(Result<AppInfoStringResult> result);

        void getChannelTabInfo(Result<ChannelTab> result);

        void getWebViewUserAgent(Result<AppInfoStringResult> result);
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
