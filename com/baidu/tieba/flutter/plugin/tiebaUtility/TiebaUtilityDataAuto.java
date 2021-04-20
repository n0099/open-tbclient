package com.baidu.tieba.flutter.plugin.tiebaUtility;

import java.util.HashMap;
/* loaded from: classes4.dex */
public class TiebaUtilityDataAuto {

    /* loaded from: classes4.dex */
    public static class GetLottieParam {
        public String name;
        public String themeStr;

        public static GetLottieParam fromMap(HashMap hashMap) {
            GetLottieParam getLottieParam = new GetLottieParam();
            getLottieParam.name = (String) hashMap.get("name");
            getLottieParam.themeStr = (String) hashMap.get("themeStr");
            return getLottieParam;
        }

        public String getName() {
            return this.name;
        }

        public String getThemeStr() {
            return this.themeStr;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setThemeStr(String str) {
            this.themeStr = str;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("name", this.name);
            hashMap.put("themeStr", this.themeStr);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public interface HostUtilityData {
        void getLottieBytes(GetLottieParam getLottieParam, Result<LottieResult> result);
    }

    /* loaded from: classes4.dex */
    public static class LottieResult {
        public byte[] lottie;

        public static LottieResult fromMap(HashMap hashMap) {
            LottieResult lottieResult = new LottieResult();
            lottieResult.lottie = (byte[]) hashMap.get("lottie");
            return lottieResult;
        }

        public byte[] getLottie() {
            return this.lottie;
        }

        public void setLottie(byte[] bArr) {
            this.lottie = bArr;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("lottie", this.lottie);
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
