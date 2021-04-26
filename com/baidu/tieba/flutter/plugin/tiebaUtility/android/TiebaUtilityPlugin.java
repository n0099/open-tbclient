package com.baidu.tieba.flutter.plugin.tiebaUtility.android;

import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityNotificationAuto;
import d.a.j0.m0.a.j.a3;
import d.a.j0.m0.a.j.b3;
import d.a.j0.m0.a.j.c3;
import d.a.j0.m0.a.j.q2;
import d.a.j0.m0.a.j.r2;
import d.a.j0.m0.a.j.s2;
import d.a.j0.m0.a.j.t2;
import d.a.j0.m0.a.j.u2;
import d.a.j0.m0.a.j.v2;
import d.a.j0.m0.a.j.w2;
import d.a.j0.m0.a.j.x2;
import d.a.j0.m0.a.j.y2;
import d.a.j0.m0.a.j.z2;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class TiebaUtilityPlugin implements FlutterPlugin {
    public TiebaUtilityNotificationAuto.FlutterUtilityNotification mFlutterNotification;
    public UtilityNotification mNotification;
    public final CustomMessageListener sendNotifyToFlutter = new CustomMessageListener(2921542) { // from class: com.baidu.tieba.flutter.plugin.tiebaUtility.android.TiebaUtilityPlugin.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof HashMap)) {
                return;
            }
            TiebaUtilityPlugin.this.mNotification.notifyFlutter((String) ((HashMap) customResponsedMessage.getData()).get("uniqueKey"), (HashMap) ((HashMap) customResponsedMessage.getData()).get("object"), (HashMap) ((HashMap) customResponsedMessage.getData()).get("data"));
        }
    };

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.mFlutterNotification = new TiebaUtilityNotificationAuto.FlutterUtilityNotification(flutterPluginBinding.getBinaryMessenger());
        this.mNotification = new UtilityNotification(this.mFlutterNotification);
        MessageManager.getInstance().registerListener(this.sendNotifyToFlutter);
        z2.e(flutterPluginBinding.getBinaryMessenger(), new UtilityPreference());
        s2.g(flutterPluginBinding.getBinaryMessenger(), new UtilityAppInfo());
        r2.g(flutterPluginBinding.getBinaryMessenger(), new UtilityAccount());
        a3.i(flutterPluginBinding.getBinaryMessenger(), new UtilitySettings());
        x2.d(flutterPluginBinding.getBinaryMessenger(), this.mNotification);
        b3.c(flutterPluginBinding.getBinaryMessenger(), new UtilityStatistic());
        y2.p(flutterPluginBinding.getBinaryMessenger(), new UtilityOpenPage());
        w2.k(flutterPluginBinding.getBinaryMessenger(), new UtilityMessage());
        t2.r(flutterPluginBinding.getBinaryMessenger(), new UtilityComponents());
        u2.c(flutterPluginBinding.getBinaryMessenger(), new UtilityData());
        v2.e(flutterPluginBinding.getBinaryMessenger(), new UtilityLocation());
        q2.c(flutterPluginBinding.getBinaryMessenger(), new UtilityABTest());
        c3.o(flutterPluginBinding.getBinaryMessenger(), new UtilityVideo());
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MessageManager.getInstance().unRegisterListener(this.sendNotifyToFlutter);
        this.mFlutterNotification = null;
        this.mNotification = null;
        z2.e(flutterPluginBinding.getBinaryMessenger(), null);
        s2.g(flutterPluginBinding.getBinaryMessenger(), null);
        r2.g(flutterPluginBinding.getBinaryMessenger(), null);
        a3.i(flutterPluginBinding.getBinaryMessenger(), null);
        x2.d(flutterPluginBinding.getBinaryMessenger(), null);
        b3.c(flutterPluginBinding.getBinaryMessenger(), null);
        y2.p(flutterPluginBinding.getBinaryMessenger(), null);
        w2.k(flutterPluginBinding.getBinaryMessenger(), null);
        t2.r(flutterPluginBinding.getBinaryMessenger(), null);
        u2.c(flutterPluginBinding.getBinaryMessenger(), null);
        v2.e(flutterPluginBinding.getBinaryMessenger(), null);
        q2.c(flutterPluginBinding.getBinaryMessenger(), null);
        c3.o(flutterPluginBinding.getBinaryMessenger(), null);
    }
}
