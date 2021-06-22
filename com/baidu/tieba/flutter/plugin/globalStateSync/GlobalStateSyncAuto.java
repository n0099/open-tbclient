package com.baidu.tieba.flutter.plugin.globalStateSync;

import com.baidu.tieba.flutter.plugin.globalStateSync.GlobalStateSyncAuto;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class GlobalStateSyncAuto {

    /* loaded from: classes4.dex */
    public static class AllStateData {
        public HashMap commonStates;
        public HashMap loginUserInfo;
        public HashMap netStates;
        public HashMap syncData;
        public HashMap themeData;

        public static AllStateData fromMap(HashMap hashMap) {
            AllStateData allStateData = new AllStateData();
            allStateData.themeData = (HashMap) hashMap.get("themeData");
            allStateData.loginUserInfo = (HashMap) hashMap.get("loginUserInfo");
            allStateData.syncData = (HashMap) hashMap.get("syncData");
            allStateData.commonStates = (HashMap) hashMap.get("commonStates");
            allStateData.netStates = (HashMap) hashMap.get("netStates");
            return allStateData;
        }

        public HashMap getCommonStates() {
            return this.commonStates;
        }

        public HashMap getLoginUserInfo() {
            return this.loginUserInfo;
        }

        public HashMap getNetStates() {
            return this.netStates;
        }

        public HashMap getSyncData() {
            return this.syncData;
        }

        public HashMap getThemeData() {
            return this.themeData;
        }

        public void setCommonStates(HashMap hashMap) {
            this.commonStates = hashMap;
        }

        public void setLoginUserInfo(HashMap hashMap) {
            this.loginUserInfo = hashMap;
        }

        public void setNetStates(HashMap hashMap) {
            this.netStates = hashMap;
        }

        public void setSyncData(HashMap hashMap) {
            this.syncData = hashMap;
        }

        public void setThemeData(HashMap hashMap) {
            this.themeData = hashMap;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("themeData", this.themeData);
            hashMap.put("loginUserInfo", this.loginUserInfo);
            hashMap.put("syncData", this.syncData);
            hashMap.put("commonStates", this.commonStates);
            hashMap.put("netStates", this.netStates);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public static class FlutterGlobalStateSync {
        public final BinaryMessenger binaryMessenger;

        /* loaded from: classes4.dex */
        public interface Reply<T> {
            void reply(T t);
        }

        public FlutterGlobalStateSync(BinaryMessenger binaryMessenger) {
            this.binaryMessenger = binaryMessenger;
        }

        public void writeToFlutter(SingleTypeStateData singleTypeStateData, final Reply<WriteResult> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.FlutterGlobalStateSync.writeToFlutter", new StandardMessageCodec()).send(singleTypeStateData.toMap(), new BasicMessageChannel.Reply() { // from class: d.a.o0.n0.a.b.a
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    GlobalStateSyncAuto.FlutterGlobalStateSync.Reply.this.reply(GlobalStateSyncAuto.WriteResult.fromMap((HashMap) obj));
                }
            });
        }
    }

    /* loaded from: classes4.dex */
    public interface HostGlobalStateSync {
        void readAllState(Result<AllStateData> result);

        void readStateForType(readParam readparam, Result<SingleTypeStateData> result);

        void write(SingleTypeStateData singleTypeStateData);
    }

    /* loaded from: classes4.dex */
    public interface Result<T> {
        void success(T t);
    }

    /* loaded from: classes4.dex */
    public static class SingleTypeStateData {
        public HashMap data;
        public Long subType;
        public Long type;

        public static SingleTypeStateData fromMap(HashMap hashMap) {
            Long valueOf;
            SingleTypeStateData singleTypeStateData = new SingleTypeStateData();
            Object obj = hashMap.get("type");
            Long l = null;
            if (obj == null) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            singleTypeStateData.type = valueOf;
            Object obj2 = hashMap.get("subType");
            if (obj2 != null) {
                l = Long.valueOf(obj2 instanceof Integer ? ((Integer) obj2).intValue() : ((Long) obj2).longValue());
            }
            singleTypeStateData.subType = l;
            singleTypeStateData.data = (HashMap) hashMap.get("data");
            return singleTypeStateData;
        }

        public HashMap getData() {
            return this.data;
        }

        public Long getSubType() {
            return this.subType;
        }

        public Long getType() {
            return this.type;
        }

        public void setData(HashMap hashMap) {
            this.data = hashMap;
        }

        public void setSubType(Long l) {
            this.subType = l;
        }

        public void setType(Long l) {
            this.type = l;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("type", this.type);
            hashMap.put("subType", this.subType);
            hashMap.put("data", this.data);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public static class WriteResult {
        public Boolean result;

        public static WriteResult fromMap(HashMap hashMap) {
            WriteResult writeResult = new WriteResult();
            writeResult.result = (Boolean) hashMap.get("result");
            return writeResult;
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
    public static class readParam {
        public Long type;

        public static readParam fromMap(HashMap hashMap) {
            Long valueOf;
            readParam readparam = new readParam();
            Object obj = hashMap.get("type");
            if (obj == null) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            readparam.type = valueOf;
            return readparam;
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

    public static HashMap wrapError(Exception exc) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", exc.toString());
        hashMap.put("code", exc.getClass().getSimpleName());
        hashMap.put("details", null);
        return hashMap;
    }
}
