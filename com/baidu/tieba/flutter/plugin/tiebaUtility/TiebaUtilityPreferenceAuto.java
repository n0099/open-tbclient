package com.baidu.tieba.flutter.plugin.tiebaUtility;

import androidx.lifecycle.SavedStateHandle;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class TiebaUtilityPreferenceAuto {

    /* loaded from: classes4.dex */
    public static class GetPreferenceParam {
        public ArrayList keys;
        public String nameSpace;

        public static GetPreferenceParam fromMap(HashMap hashMap) {
            GetPreferenceParam getPreferenceParam = new GetPreferenceParam();
            getPreferenceParam.keys = (ArrayList) hashMap.get(SavedStateHandle.KEYS);
            getPreferenceParam.nameSpace = (String) hashMap.get("nameSpace");
            return getPreferenceParam;
        }

        public ArrayList getKeys() {
            return this.keys;
        }

        public String getNameSpace() {
            return this.nameSpace;
        }

        public void setKeys(ArrayList arrayList) {
            this.keys = arrayList;
        }

        public void setNameSpace(String str) {
            this.nameSpace = str;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put(SavedStateHandle.KEYS, this.keys);
            hashMap.put("nameSpace", this.nameSpace);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public interface HostUtilityPreference {
        void preferenceGetValues(GetPreferenceParam getPreferenceParam, Result<KVResult> result);

        void preferenceSetValues(SetPreferenceParam setPreferenceParam, Result<SuccessResult> result);
    }

    /* loaded from: classes4.dex */
    public static class KVResult {
        public HashMap result;

        public static KVResult fromMap(HashMap hashMap) {
            KVResult kVResult = new KVResult();
            kVResult.result = (HashMap) hashMap.get("result");
            return kVResult;
        }

        public HashMap getResult() {
            return this.result;
        }

        public void setResult(HashMap hashMap) {
            this.result = hashMap;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("result", this.result);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public interface Result<T> {
        void success(T t);
    }

    /* loaded from: classes4.dex */
    public static class SetPreferenceParam {
        public HashMap keyValueMap;
        public String nameSpace;

        public static SetPreferenceParam fromMap(HashMap hashMap) {
            SetPreferenceParam setPreferenceParam = new SetPreferenceParam();
            setPreferenceParam.keyValueMap = (HashMap) hashMap.get("keyValueMap");
            setPreferenceParam.nameSpace = (String) hashMap.get("nameSpace");
            return setPreferenceParam;
        }

        public HashMap getKeyValueMap() {
            return this.keyValueMap;
        }

        public String getNameSpace() {
            return this.nameSpace;
        }

        public void setKeyValueMap(HashMap hashMap) {
            this.keyValueMap = hashMap;
        }

        public void setNameSpace(String str) {
            this.nameSpace = str;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("keyValueMap", this.keyValueMap);
            hashMap.put("nameSpace", this.nameSpace);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public static class SuccessResult {
        public Boolean result;

        public static SuccessResult fromMap(HashMap hashMap) {
            SuccessResult successResult = new SuccessResult();
            successResult.result = (Boolean) hashMap.get("result");
            return successResult;
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

    public static HashMap wrapError(Exception exc) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", exc.toString());
        hashMap.put("code", exc.getClass().getSimpleName());
        hashMap.put("details", null);
        return hashMap;
    }
}
