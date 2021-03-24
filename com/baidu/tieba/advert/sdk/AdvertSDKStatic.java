package com.baidu.tieba.advert.sdk;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.mobads.AdSettings;
import com.baidu.mobads.MobadsPermissionSettings;
import com.baidu.mobads.SplashAd;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AdvertSDKStatic {

    /* loaded from: classes4.dex */
    public static class a implements CustomMessageTask.CustomRunnable<d.b.h0.k.c> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<d.b.h0.k.c> customMessage) {
            if (customMessage == null) {
                return null;
            }
            d.b.i0.r.a.g.a.c().f(customMessage.getData());
            if (d.b.i0.r.a.g.a.c().e()) {
                return new CustomResponsedMessage<>(2016555, 1400L);
            }
            return new CustomResponsedMessage<>(2016555, 1000L);
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements CustomMessageTask.CustomRunnable<JSONObject> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<JSONObject> customMessage) {
            if (customMessage == null) {
                return null;
            }
            d.b.i0.r.a.g.a.c().j(customMessage.getData());
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements CustomMessageTask.CustomRunnable<d.b.h0.k.c> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<d.b.h0.k.c> customMessage) {
            if (customMessage != null && customMessage.getData() != null) {
                d.b.i0.r.a.g.a.c().h(customMessage.getData().a(), false);
            }
            return null;
        }
    }

    static {
        new d.b.i0.r.a.a().g();
        AdSettings.setSupportHttps(true);
        SplashAd.setMaxVideoCacheCapacityMb(30);
        MobadsPermissionSettings.setPermissionReadDeviceID(true);
        MobadsPermissionSettings.setPermissionAppList(true);
        CustomMessageTask customMessageTask = new CustomMessageTask(2016555, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerTask(new CustomMessageTask(2016552, new b()));
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2921536, new c());
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }
}
