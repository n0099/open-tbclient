package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsGameCommentActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGameSubPbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tieba.frs.aggregation.VideoAggregationActivity;
import com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity;
import com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity;
import com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageActivity;
/* loaded from: classes3.dex */
public class FRSExtraStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(VideoAggregationActivityConfig.class, VideoAggregationActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(VideoMiddlePageActivityConfig.class, VideoMiddlePageActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(FrsGameCommentActivityConfig.class, FrsGameCommentActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(FrsGameSubPbActivityConfig.class, FrsGameSubPbActivity.class);
        bc.aim.set(true);
        c.diM.set(new aq());
        MessageManager.getInstance().registerListener(new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.FRSExtraStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                    AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                    absDelegateAdapterList.add(new r(null, com.baidu.tbadk.core.data.au.ahE, null));
                    absDelegateAdapterList.add(new com.baidu.tieba.frs.a.a.b(null, bc.aia));
                    absDelegateAdapterList.add(new com.baidu.tieba.frs.a.a.a(null, com.baidu.tieba.card.data.n.czR, true));
                    absDelegateAdapterList.add(new com.baidu.tieba.frs.a.a.d(null, com.baidu.tieba.tbadkCore.v.gMd, null));
                }
            }
        });
        MessageManager.getInstance().registerTask(new CustomMessageTask(2003016, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.frs.FRSExtraStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                return null;
            }
        }));
    }
}
