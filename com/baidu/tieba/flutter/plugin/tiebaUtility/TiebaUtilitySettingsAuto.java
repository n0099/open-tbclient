package com.baidu.tieba.flutter.plugin.tiebaUtility;

import java.util.HashMap;
/* loaded from: classes4.dex */
public class TiebaUtilitySettingsAuto {

    /* loaded from: classes4.dex */
    public static class GetPrivateStatParam {
        public Long type;

        public static GetPrivateStatParam fromMap(HashMap hashMap) {
            Long valueOf;
            GetPrivateStatParam getPrivateStatParam = new GetPrivateStatParam();
            Object obj = hashMap.get("type");
            if (obj == null) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            getPrivateStatParam.type = valueOf;
            return getPrivateStatParam;
        }

        public Long getType() {
            return this.type;
        }

        public void setType(Long l) {
            this.type = l;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("type", this.type);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public interface HostUtilitySettings {
        void getMyPrivateStat(GetPrivateStatParam getPrivateStatParam, Result<PrivateStatResult> result);

        void getUserBigPhotoHost(Result<PhotoHostResult> result);

        void getUserSmallPhotoHost(Result<PhotoHostResult> result);

        void setMyPrivateStat(SetPrivateStatParam setPrivateStatParam, Result<PrivateStatResult> result);
    }

    /* loaded from: classes4.dex */
    public static class PhotoHostResult {
        public String result;

        public static PhotoHostResult fromMap(HashMap hashMap) {
            PhotoHostResult photoHostResult = new PhotoHostResult();
            photoHostResult.result = (String) hashMap.get("result");
            return photoHostResult;
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
    public static class PrivateStatResult {
        public Long result;

        public static PrivateStatResult fromMap(HashMap hashMap) {
            Long valueOf;
            PrivateStatResult privateStatResult = new PrivateStatResult();
            Object obj = hashMap.get("result");
            if (obj == null) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            privateStatResult.result = valueOf;
            return privateStatResult;
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
    public interface Result<T> {
        void success(T t);
    }

    /* loaded from: classes4.dex */
    public static class SetPrivateStatParam {
        public Long stat;
        public Long type;

        public static SetPrivateStatParam fromMap(HashMap hashMap) {
            Long valueOf;
            SetPrivateStatParam setPrivateStatParam = new SetPrivateStatParam();
            Object obj = hashMap.get("type");
            Long l = null;
            if (obj == null) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            setPrivateStatParam.type = valueOf;
            Object obj2 = hashMap.get("stat");
            if (obj2 != null) {
                l = Long.valueOf(obj2 instanceof Integer ? ((Integer) obj2).intValue() : ((Long) obj2).longValue());
            }
            setPrivateStatParam.stat = l;
            return setPrivateStatParam;
        }

        public Long getStat() {
            return this.stat;
        }

        public Long getType() {
            return this.type;
        }

        public void setStat(Long l) {
            this.stat = l;
        }

        public void setType(Long l) {
            this.type = l;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("type", this.type);
            hashMap.put("stat", this.stat);
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
