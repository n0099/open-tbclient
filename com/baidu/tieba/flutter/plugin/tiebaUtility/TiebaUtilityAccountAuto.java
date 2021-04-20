package com.baidu.tieba.flutter.plugin.tiebaUtility;

import java.util.HashMap;
/* loaded from: classes4.dex */
public class TiebaUtilityAccountAuto {

    /* loaded from: classes4.dex */
    public static class AccountBoolResult {
        public Boolean result;

        public static AccountBoolResult fromMap(HashMap hashMap) {
            AccountBoolResult accountBoolResult = new AccountBoolResult();
            accountBoolResult.result = (Boolean) hashMap.get("result");
            return accountBoolResult;
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
    public interface HostUtilityAccount {
        void goToLogin();

        void isLogin(Result<AccountBoolResult> result);

        void jumpRealNameAuthWebActivity();

        void showLoginAwardCell(Result<AccountBoolResult> result);
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
