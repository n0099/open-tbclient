package com.baidu.tieba.flutter.plugin.tiebaUtility.android;

import com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityNotificationAuto;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class UtilityNotification implements TiebaUtilityNotificationAuto.HostUtilityNotification {
    public static NativeListeners mNativeListeners = new NativeListeners();

    public UtilityNotification(TiebaUtilityNotificationAuto.FlutterUtilityNotification flutterUtilityNotification) {
        mNativeListeners.addFlutterNotification(flutterUtilityNotification);
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityNotificationAuto.HostUtilityNotification
    public void addNotificationObserver(TiebaUtilityNotificationAuto.ObserverName observerName) {
        mNativeListeners.addNotificationObserver(observerName.getResult());
    }

    public void notifyFlutter(String str, HashMap hashMap, HashMap hashMap2) {
        mNativeListeners.notifyFlutter(str, hashMap, hashMap2);
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityNotificationAuto.HostUtilityNotification
    public void postNotification(TiebaUtilityNotificationAuto.PostNotifyParam postNotifyParam) {
        mNativeListeners.postNotification(postNotifyParam.getNotificationName(), postNotifyParam.getPayload());
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityNotificationAuto.HostUtilityNotification
    public void removeNotificationObserver(TiebaUtilityNotificationAuto.ObserverName observerName) {
        mNativeListeners.removeNotificationObserver(observerName.getResult());
    }
}
