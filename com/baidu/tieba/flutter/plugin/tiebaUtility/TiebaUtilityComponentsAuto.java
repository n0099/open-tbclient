package com.baidu.tieba.flutter.plugin.tiebaUtility;

import java.util.HashMap;
/* loaded from: classes4.dex */
public class TiebaUtilityComponentsAuto {

    /* loaded from: classes4.dex */
    public static class AgreeThreadParam {
        public HashMap result;

        public static AgreeThreadParam fromMap(HashMap hashMap) {
            AgreeThreadParam agreeThreadParam = new AgreeThreadParam();
            agreeThreadParam.result = (HashMap) hashMap.get("result");
            return agreeThreadParam;
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
    public static class ComponentsBoolResult {
        public Boolean result;

        public static ComponentsBoolResult fromMap(HashMap hashMap) {
            ComponentsBoolResult componentsBoolResult = new ComponentsBoolResult();
            componentsBoolResult.result = (Boolean) hashMap.get("result");
            return componentsBoolResult;
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
    public static class ComponentsStringValue {
        public String result;

        public static ComponentsStringValue fromMap(HashMap hashMap) {
            ComponentsStringValue componentsStringValue = new ComponentsStringValue();
            componentsStringValue.result = (String) hashMap.get("result");
            return componentsStringValue;
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
    public interface HostUtilityComponents {
        void agreeThread(AgreeThreadParam agreeThreadParam);

        void delLikeForum(ComponentsStringValue componentsStringValue);

        void deleteRecentlyVisitedForumHistory(ComponentsStringValue componentsStringValue);

        void disagreeThread(AgreeThreadParam agreeThreadParam);

        void getHistoryCount(Result<ComponentsStringValue> result);

        void getHistoryForumStr(Result<ComponentsStringValue> result);

        void getRecnbarShow(Result<ComponentsBoolResult> result);

        void hasOfficialChat(Result<ComponentsBoolResult> result);

        void negativeFeedBack(AgreeThreadParam agreeThreadParam, Result<ComponentsBoolResult> result);

        void selectForumCategory(ComponentsStringValue componentsStringValue);

        void showRedDotForMyTab(Result<ComponentsBoolResult> result);
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
