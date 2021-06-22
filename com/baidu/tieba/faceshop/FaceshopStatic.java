package com.baidu.tieba.faceshop;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CommonEmotionManagerActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionCenterActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionPackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FaceGroupMakeActivityConfig;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FaceShopActivityConfig;
import com.baidu.tbadk.core.atomData.NativeEmotionManagerActivityConfig;
import com.baidu.tbadk.core.atomData.NewFaceShopActivityConfig;
import com.baidu.tbadk.core.atomData.PickFaceTabActivityConfig;
import com.baidu.tbadk.core.atomData.SelectSingleForumActivityConfig;
import com.baidu.tbadk.core.atomData.UserAlbumActivityConfig;
import com.baidu.tbadk.core.atomData.UserCollectManageActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.faceshop.emotioncenter.EmotionCenterActivity;
import com.baidu.tieba.faceshop.emotiondetail.EmotionDetailActivity;
import com.baidu.tieba.newfaceshop.CommonEmotionManagerActivity;
import com.baidu.tieba.newfaceshop.NativeEmotionManagerActivity;
import com.baidu.tieba.newfaceshop.NewFaceShopActivity;
import com.baidu.tieba.newfaceshop.facemake.FaceGroupMakeActivity;
import com.baidu.tieba.newfaceshop.facemake.PickFaceTabActivity;
import com.baidu.tieba.newfaceshop.facemake.SelectSingleForumActivity;
import d.a.n0.a0.d;
import d.a.o0.m0.p;
import d.a.o0.m0.r;
import d.a.o0.m0.u;
import d.a.o0.m0.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class FaceshopStatic {

    /* loaded from: classes4.dex */
    public static class a extends CustomMessageListener {

        /* renamed from: com.baidu.tieba.faceshop.FaceshopStatic$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0173a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f14879e;

            /* renamed from: com.baidu.tieba.faceshop.FaceshopStatic$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class RunnableC0174a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ StringBuilder f14880e;

                public RunnableC0174a(StringBuilder sb) {
                    this.f14880e = sb;
                }

                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(RunnableC0173a.this.f14879e, this.f14880e.toString()));
                }
            }

            public RunnableC0173a(a aVar, int i2) {
                this.f14879e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                List<MyEmotionGroupData> f2 = d.a.o0.z1.c.i().f();
                StringBuilder sb = new StringBuilder();
                if (f2 != null) {
                    int size = f2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        sb.append(f2.get(i2).getGroupId());
                        if (i2 != size - 1) {
                            sb.append("_");
                        }
                    }
                }
                d.a.c.e.m.e.a().post(new RunnableC0174a(sb));
            }
        }

        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                d.a.o0.z1.a.b().a(new RunnableC0173a(this, ((Integer) customResponsedMessage.getData()).intValue()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements CustomMessageTask.CustomRunnable<IntentConfig> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<IntentConfig> customMessage) {
            if (customMessage != null && customMessage.getData() != null) {
                customMessage.getData().startActivity(FacePackageDetailActivity.class);
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            if (tbPageContext != null && strArr != null && strArr.length != 0) {
                String str = strArr[0];
                if (!StringUtils.isNull(str) && str.contains("interact/tbowneremoji")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CommonEmotionManagerActivityConfig(tbPageContext.getPageActivity(), str)));
                    return 0;
                }
            }
            return 3;
        }
    }

    /* loaded from: classes4.dex */
    public static class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                List list = (List) customResponsedMessage.getData();
                list.add(v.e());
                list.add(r.f());
                list.add(p.e());
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class e extends CustomMessageListener {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getData() instanceof String) {
                u.s().g((String) customResponsedMessage.getData(), null);
            } else if (customResponsedMessage.getData() instanceof d.a) {
                d.a aVar = (d.a) customResponsedMessage.getData();
                u.s().g(aVar.f52600a, aVar.f52601b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class f extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || TextUtils.isEmpty(intent.getStringExtra(d.a.n0.a0.d.f52595b)) || !TbadkCoreApplication.getInst().isMainProcess(false)) {
                return;
            }
            u.s().g(intent.getStringExtra(d.a.n0.a0.d.f52595b), intent.getStringExtra(d.a.n0.a0.d.f52596c));
        }
    }

    /* loaded from: classes4.dex */
    public static class g implements CustomMessageTask.CustomRunnable<Object> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            d.a.o0.z1.d.m().v();
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class h implements CustomMessageTask.CustomRunnable<IntentConfig> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<IntentConfig> customMessage) {
            if (customMessage != null && customMessage.getData() != null) {
                customMessage.getData().startActivity(FaceBuyWebViewActivity.class);
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class i implements CustomMessageTask.CustomRunnable<IntentConfig> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<IntentConfig> customMessage) {
            if (customMessage != null && customMessage.getData() != null) {
                customMessage.getData().startActivity(EmotionImageActivity.class);
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class j implements CustomMessageTask.CustomRunnable<IntentConfig> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<IntentConfig> customMessage) {
            if (customMessage != null && customMessage.getData() != null) {
                customMessage.getData().startActivity(EmotionManageActivity.class);
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class k implements CustomMessageTask.CustomRunnable<IntentConfig> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<IntentConfig> customMessage) {
            if (customMessage != null && customMessage.getData() != null) {
                customMessage.getData().startActivity(FacePurchaseRecordsActivity.class);
            }
            return null;
        }
    }

    static {
        TbadkCoreApplication.getInst().RegisterIntent(UserCollectManageActivityConfig.class, UserCollectManageActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(EmotionPackageDetailActivityConfig.class, EmotionPackageDetailActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(EmotionDetailActivityConfig.class, EmotionDetailActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(UserAlbumActivityConfig.class, UserAlbumActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(FaceShopActivityConfig.class, FaceShopActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(NewFaceShopActivityConfig.class, NewFaceShopActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(FaceGroupMakeActivityConfig.class, FaceGroupMakeActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(PickFaceTabActivityConfig.class, PickFaceTabActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(EmotionCenterActivityConfig.class, EmotionCenterActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(SelectSingleForumActivityConfig.class, SelectSingleForumActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(CommonEmotionManagerActivityConfig.class, CommonEmotionManagerActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(NativeEmotionManagerActivityConfig.class, NativeEmotionManagerActivity.class);
        MessageManager.getInstance().registerListener(new a(2004612));
        MessageManager.getInstance().registerListener(new d(2004602));
        MessageManager.getInstance().registerListener(new e(2004610));
        f fVar = new f();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(d.a.n0.a0.d.f52594a);
        TbadkCoreApplication.getInst().registerReceiver(fVar, intentFilter);
        CustomMessageTask customMessageTask = new CustomMessageTask(2004611, new g());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerStickyMode(2001141);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004602, new ArrayList()));
        if (d.a.c.e.p.j.H() && TbadkCoreApplication.getCurrentAccount() != null) {
            d.a.o0.z1.d.m().v();
        }
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2902013, new h());
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2902011, new i());
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
        CustomMessageTask customMessageTask4 = new CustomMessageTask(2902012, new j());
        customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask4);
        CustomMessageTask customMessageTask5 = new CustomMessageTask(2902015, new k());
        customMessageTask5.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask5);
        TbadkCoreApplication.getInst().RegisterIntent(FacePackageDetailActivityConfig.class, FacePackageDetailActivity.class);
        CustomMessageTask customMessageTask6 = new CustomMessageTask(2902014, new b());
        customMessageTask6.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask6);
        UrlManager.getInstance().addListener(new c());
    }
}
