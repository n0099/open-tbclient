package com.baidu.tieba.flutter.plugin.tiebaUtility;

import com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityNotificationAuto;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class TiebaUtilityNotificationAuto {

    /* loaded from: classes4.dex */
    public static class FlutterUtilityNotification {
        public final BinaryMessenger binaryMessenger;

        /* loaded from: classes4.dex */
        public interface Reply<T> {
            void reply(T t);
        }

        public FlutterUtilityNotification(BinaryMessenger binaryMessenger) {
            this.binaryMessenger = binaryMessenger;
        }

        public void onNotification(OnNotifyData onNotifyData, final Reply<NotifyResult> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.FlutterUtilityNotification.onNotification", new StandardMessageCodec()).send(onNotifyData.toMap(), new BasicMessageChannel.Reply() { // from class: d.a.o0.n0.a.j.v0
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    TiebaUtilityNotificationAuto.FlutterUtilityNotification.Reply.this.reply(TiebaUtilityNotificationAuto.NotifyResult.fromMap((HashMap) obj));
                }
            });
        }
    }

    /* loaded from: classes4.dex */
    public interface HostUtilityNotification {
        void addNotificationObserver(ObserverName observerName);

        void postNotification(PostNotifyParam postNotifyParam);

        void removeNotificationObserver(ObserverName observerName);
    }

    /* loaded from: classes4.dex */
    public static class NotifyResult {
        public Boolean result;

        public static NotifyResult fromMap(HashMap hashMap) {
            NotifyResult notifyResult = new NotifyResult();
            notifyResult.result = (Boolean) hashMap.get("result");
            return notifyResult;
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
    public static class ObserverName {
        public String result;

        public static ObserverName fromMap(HashMap hashMap) {
            ObserverName observerName = new ObserverName();
            observerName.result = (String) hashMap.get("result");
            return observerName;
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
    public static class OnNotifyData {
        public HashMap data;
        public HashMap object;
        public String uniqueKey;

        public static OnNotifyData fromMap(HashMap hashMap) {
            OnNotifyData onNotifyData = new OnNotifyData();
            onNotifyData.uniqueKey = (String) hashMap.get("uniqueKey");
            onNotifyData.object = (HashMap) hashMap.get("object");
            onNotifyData.data = (HashMap) hashMap.get("data");
            return onNotifyData;
        }

        public HashMap getData() {
            return this.data;
        }

        public HashMap getObject() {
            return this.object;
        }

        public String getUniqueKey() {
            return this.uniqueKey;
        }

        public void setData(HashMap hashMap) {
            this.data = hashMap;
        }

        public void setObject(HashMap hashMap) {
            this.object = hashMap;
        }

        public void setUniqueKey(String str) {
            this.uniqueKey = str;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("uniqueKey", this.uniqueKey);
            hashMap.put("object", this.object);
            hashMap.put("data", this.data);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public static class PostNotifyParam {
        public String notificationName;
        public HashMap payload;

        public static PostNotifyParam fromMap(HashMap hashMap) {
            PostNotifyParam postNotifyParam = new PostNotifyParam();
            postNotifyParam.notificationName = (String) hashMap.get("notificationName");
            postNotifyParam.payload = (HashMap) hashMap.get("payload");
            return postNotifyParam;
        }

        public String getNotificationName() {
            return this.notificationName;
        }

        public HashMap getPayload() {
            return this.payload;
        }

        public void setNotificationName(String str) {
            this.notificationName = str;
        }

        public void setPayload(HashMap hashMap) {
            this.payload = hashMap;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("notificationName", this.notificationName);
            hashMap.put("payload", this.payload);
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
