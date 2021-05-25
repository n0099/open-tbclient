package com.baidu.tieba.advert.sdk;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import d.a.d0.b.g.g;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AdvertSDKStatic {

    /* loaded from: classes4.dex */
    public static class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (TbadkCoreApplication.getInst().isMainProcess(false)) {
                d.a.n0.t.a.e.h();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements CustomMessageTask.CustomRunnable<d.a.m0.k.d> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<d.a.m0.k.d> customMessage) {
            if (customMessage != null && PermissionUtil.isAgreePrivacyPolicy()) {
                d.a.n0.t.a.h.a.c().f(customMessage.getData());
                return new CustomResponsedMessage<>(2016555, Long.valueOf(d.a.n0.t.a.j.a.e()));
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements CustomMessageTask.CustomRunnable<JSONObject> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<JSONObject> customMessage) {
            if (customMessage == null) {
                return null;
            }
            d.a.n0.t.a.h.a.c().j(customMessage.getData());
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class d implements CustomMessageTask.CustomRunnable<d.a.m0.k.d> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<d.a.m0.k.d> customMessage) {
            if (customMessage != null && customMessage.getData() != null) {
                d.a.n0.t.a.h.a.c().h(customMessage.getData().a(), false);
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class e implements CustomMessageTask.CustomRunnable<d.a.m0.k.c> {

        /* loaded from: classes4.dex */
        public class a implements d.a.m0.k.c {
            public a(e eVar) {
            }

            @Override // d.a.m0.k.c
            public float a() {
                return g.b();
            }

            @Override // d.a.m0.k.c
            public int b() {
                return g.a();
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<d.a.m0.k.c> customMessage) {
            return new CustomResponsedMessage<>(2921564, new a(this));
        }
    }

    /* loaded from: classes4.dex */
    public static class f implements CustomMessageTask.CustomRunnable<d.a.m0.k.d> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<d.a.m0.k.d> customMessage) {
            d.a.n0.t.a.h.a.c().a();
            return null;
        }
    }

    static {
        new d.a.n0.t.a.a().g();
        MobadsPermissionSettings.setPermissionReadDeviceID(true);
        MobadsPermissionSettings.setPermissionAppList(true);
        if (PermissionUtil.isAgreePrivacyPolicy() && TbadkCoreApplication.getInst().isMainProcess(false)) {
            d.a.n0.t.a.e.h();
        }
        MessageManager.getInstance().registerListener(new a(2921554));
        CustomMessageTask customMessageTask = new CustomMessageTask(2016555, new b());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerTask(new CustomMessageTask(2016552, new c()));
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2921536, new d());
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2921564, new e());
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
        CustomMessageTask customMessageTask4 = new CustomMessageTask(2921555, new f());
        customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask4);
    }
}
