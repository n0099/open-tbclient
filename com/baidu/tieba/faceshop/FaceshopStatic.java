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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
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
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.imageManager.d;
import com.baidu.tieba.faceshop.emotioncenter.EmotionCenterActivity;
import com.baidu.tieba.faceshop.emotiondetail.EmotionDetailActivity;
import com.baidu.tieba.newfaceshop.CommonEmotionManagerActivity;
import com.baidu.tieba.newfaceshop.NativeEmotionManagerActivity;
import com.baidu.tieba.newfaceshop.NewFaceShopActivity;
import com.baidu.tieba.newfaceshop.facemake.FaceGroupMakeActivity;
import com.baidu.tieba.newfaceshop.facemake.PickFaceTabActivity;
import com.baidu.tieba.newfaceshop.facemake.SelectSingleForumActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class FaceshopStatic {
    public static String Tag = "tag";

    static {
        TbadkCoreApplication.getInst().RegisterIntent(UserCollectManageActivityConfig.class, aa.class);
        TbadkCoreApplication.getInst().RegisterIntent(EmotionPackageDetailActivityConfig.class, EmotionPackageDetailActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(EmotionDetailActivityConfig.class, EmotionDetailActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(UserAlbumActivityConfig.class, UserAlbumActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(FaceShopActivityConfig.class, r.class);
        TbadkCoreApplication.getInst().RegisterIntent(NewFaceShopActivityConfig.class, NewFaceShopActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(FaceGroupMakeActivityConfig.class, FaceGroupMakeActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(PickFaceTabActivityConfig.class, PickFaceTabActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(EmotionCenterActivityConfig.class, EmotionCenterActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(SelectSingleForumActivityConfig.class, SelectSingleForumActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(CommonEmotionManagerActivityConfig.class, CommonEmotionManagerActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(NativeEmotionManagerActivityConfig.class, NativeEmotionManagerActivity.class);
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.EMOTION_SEND_LOCAL_EMOTIONS) { // from class: com.baidu.tieba.faceshop.FaceshopStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                    final int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    com.baidu.tieba.newfaceshop.a.diz().execute(new Runnable() { // from class: com.baidu.tieba.faceshop.FaceshopStatic.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            List<MyEmotionGroupData> diC = com.baidu.tieba.newfaceshop.c.diB().diC();
                            final StringBuilder sb = new StringBuilder();
                            if (diC != null) {
                                int size = diC.size();
                                for (int i = 0; i < size; i++) {
                                    sb.append(diC.get(i).getGroupId());
                                    if (i != size - 1) {
                                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                                    }
                                }
                            }
                            com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.faceshop.FaceshopStatic.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(intValue, sb.toString()));
                                }
                            });
                        }
                    });
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.EMOTION_COLLECT_GROUPS) { // from class: com.baidu.tieba.faceshop.FaceshopStatic.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    List list = (List) customResponsedMessage.getData();
                    list.add(ac.czW());
                    list.add(x.czM());
                    list.add(v.czL());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.EMOTION_USER_COLLECT) { // from class: com.baidu.tieba.faceshop.FaceshopStatic.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (customResponsedMessage.getData() instanceof String) {
                        ab.czT().eU((String) customResponsedMessage.getData(), null);
                    } else if (customResponsedMessage.getData() instanceof d.a) {
                        d.a aVar = (d.a) customResponsedMessage.getData();
                        ab.czT().eU(aVar.url, aVar.pkgId);
                    }
                }
            }
        });
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.baidu.tieba.faceshop.FaceshopStatic.6
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent != null && !TextUtils.isEmpty(intent.getStringExtra(com.baidu.tbadk.imageManager.d.IMAGE_URL)) && TbadkCoreApplication.getInst().isMainProcess(false)) {
                    ab.czT().eU(intent.getStringExtra(com.baidu.tbadk.imageManager.d.IMAGE_URL), intent.getStringExtra(com.baidu.tbadk.imageManager.d.PACKAGE_ID));
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(com.baidu.tbadk.imageManager.d.ADD_USER_COLLECT_EMOTION_ACTION);
        TbadkCoreApplication.getInst().registerReceiver(broadcastReceiver, intentFilter);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.EMOTION_SYNC_DOWNLOAD, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.faceshop.FaceshopStatic.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                com.baidu.tieba.newfaceshop.d.diF().diH();
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_ADS_EMOTION);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.EMOTION_COLLECT_GROUPS, new ArrayList()));
        if (com.baidu.adp.lib.util.j.isWifiNet() && TbadkApplication.getCurrentAccount() != null) {
            com.baidu.tieba.newfaceshop.d.diF().diH();
        }
        CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.CMD_FACESHOP_FACEBUYWEBVIEW, new CustomMessageTask.CustomRunnable<IntentConfig>() { // from class: com.baidu.tieba.faceshop.FaceshopStatic.8
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<IntentConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(k.class);
                }
                return null;
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(CmdConfigCustom.CMD_FACESHOP_EMOTIONIMAGE, new CustomMessageTask.CustomRunnable<IntentConfig>() { // from class: com.baidu.tieba.faceshop.FaceshopStatic.9
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<IntentConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(g.class);
                }
                return null;
            }
        });
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
        CustomMessageTask customMessageTask4 = new CustomMessageTask(CmdConfigCustom.CMD_FACESHOP_EMOTIONMANAGE, new CustomMessageTask.CustomRunnable<IntentConfig>() { // from class: com.baidu.tieba.faceshop.FaceshopStatic.10
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<IntentConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(h.class);
                }
                return null;
            }
        });
        customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask4);
        CustomMessageTask customMessageTask5 = new CustomMessageTask(CmdConfigCustom.CMD_FACESHOP_FACEPURCHASERECORDS, new CustomMessageTask.CustomRunnable<IntentConfig>() { // from class: com.baidu.tieba.faceshop.FaceshopStatic.11
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<IntentConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(o.class);
                }
                return null;
            }
        });
        customMessageTask5.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask5);
        TbadkCoreApplication.getInst().RegisterIntent(FacePackageDetailActivityConfig.class, l.class);
        CustomMessageTask customMessageTask6 = new CustomMessageTask(CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new CustomMessageTask.CustomRunnable<IntentConfig>() { // from class: com.baidu.tieba.faceshop.FaceshopStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<IntentConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(l.class);
                }
                return null;
            }
        });
        customMessageTask6.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask6);
        bf.bsY().a(new bf.a() { // from class: com.baidu.tieba.faceshop.FaceshopStatic.3
            @Override // com.baidu.tbadk.core.util.bf.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (StringUtils.isNull(str) || !str.contains("interact/tbowneremoji")) {
                    return 3;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonEmotionManagerActivityConfig(tbPageContext.getPageActivity(), str)));
                return 0;
            }
        });
    }
}
