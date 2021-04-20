package com.baidu.tieba.flutter.plugin.tiebaUtility;

import java.util.HashMap;
/* loaded from: classes4.dex */
public class TiebaUtilityAbtestAuto {

    /* loaded from: classes4.dex */
    public static class ExperimentType {
        public Long result;

        public static ExperimentType fromMap(HashMap hashMap) {
            Long valueOf;
            ExperimentType experimentType = new ExperimentType();
            Object obj = hashMap.get("result");
            if (obj == null) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            experimentType.result = valueOf;
            return experimentType;
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
    public interface HostUtilityABTest {
        void experimentTypeForBarEntry(Result<ExperimentType> result);
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
