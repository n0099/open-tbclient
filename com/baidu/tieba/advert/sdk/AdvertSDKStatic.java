package com.baidu.tieba.advert.sdk;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import d.b.i0.r.a.e;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AdvertSDKStatic {

    /* loaded from: classes4.dex */
    public static class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (TbadkCoreApplication.getInst().isMainProcess(false)) {
                e.h();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements CustomMessageTask.CustomRunnable<d.b.h0.k.c> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<d.b.h0.k.c> customMessage) {
            if (customMessage == null) {
                return null;
            }
            d.b.i0.r.a.h.a.c().f(customMessage.getData());
            if (d.b.i0.r.a.h.a.c().e()) {
                return new CustomResponsedMessage<>(2016555, 1400L);
            }
            return new CustomResponsedMessage<>(2016555, 1000L);
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements CustomMessageTask.CustomRunnable<JSONObject> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<JSONObject> customMessage) {
            if (customMessage == null) {
                return null;
            }
            d.b.i0.r.a.h.a.c().j(customMessage.getData());
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class d implements CustomMessageTask.CustomRunnable<d.b.h0.k.c> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<d.b.h0.k.c> customMessage) {
            if (customMessage != null && customMessage.getData() != null) {
                d.b.i0.r.a.h.a.c().h(customMessage.getData().a(), false);
            }
            return null;
        }
    }

    static {
        new d.b.i0.r.a.a().g();
        MobadsPermissionSettings.setPermissionReadDeviceID(true);
        MobadsPermissionSettings.setPermissionAppList(true);
        if (PermissionUtil.isAgreePrivacyPolicy() && TbadkCoreApplication.getInst().isMainProcess(false)) {
            e.h();
        }
        MessageManager.getInstance().registerListener(new a(2921544));
        CustomMessageTask customMessageTask = new CustomMessageTask(2016555, new b());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerTask(new CustomMessageTask(2016552, new c()));
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2921536, new d());
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }
}
