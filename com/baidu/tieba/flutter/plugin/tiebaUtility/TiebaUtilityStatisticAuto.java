package com.baidu.tieba.flutter.plugin.tiebaUtility;

import java.util.HashMap;
/* loaded from: classes4.dex */
public class TiebaUtilityStatisticAuto {

    /* loaded from: classes4.dex */
    public interface HostUtilityStatistic {
        void debugLog(StatisticParam statisticParam);

        void statLogEvent(StatisticParam statisticParam);
    }

    /* loaded from: classes4.dex */
    public static class StatisticParam {
        public String key;
        public HashMap params;

        public static StatisticParam fromMap(HashMap hashMap) {
            StatisticParam statisticParam = new StatisticParam();
            statisticParam.key = (String) hashMap.get("key");
            statisticParam.params = (HashMap) hashMap.get("params");
            return statisticParam;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap getParams() {
            return this.params;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public void setParams(HashMap hashMap) {
            this.params = hashMap;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("key", this.key);
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
