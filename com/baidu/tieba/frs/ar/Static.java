package com.baidu.tieba.frs.ar;

import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsArActivityConfig;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ar.view.FrsAREntryView;
import tbclient.ForumArIno;
/* loaded from: classes3.dex */
public class Static {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(FrsArActivityConfig.class, ARActivity.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(2921326, new CustomMessageTask.CustomRunnable<FrsFragment>() { // from class: com.baidu.tieba.frs.ar.Static.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<FrsFragment> customMessage) {
                if (customMessage == null || customMessage.getData() == null || customMessage.getData() == null || customMessage.getData().awv() == null || customMessage.getData().awv().dyj == null) {
                    return null;
                }
                ForumArIno forumArIno = customMessage.getData().awv().dyj;
                if (forumArIno._switch.intValue() == 0) {
                    return null;
                }
                FrsAREntryView frsAREntryView = new FrsAREntryView(customMessage.getData().getPageContext().getPageActivity());
                frsAREntryView.setForumArIno(forumArIno);
                if (customMessage.getData().awv().bbH() != null) {
                    frsAREntryView.setForumName(customMessage.getData().awv().bbH().getName());
                }
                frsAREntryView.ayE();
                RelativeLayout axn = customMessage.getData().awe().axn();
                if (axn instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(11);
                    layoutParams.addRule(12);
                    layoutParams.bottomMargin = 100;
                    layoutParams.rightMargin = 30;
                    axn.addView(frsAREntryView, layoutParams);
                } else if (axn instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 85;
                    layoutParams2.bottomMargin = 100;
                    layoutParams2.rightMargin = 30;
                    ((FrameLayout) axn).addView(frsAREntryView, layoutParams2);
                }
                CustomResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(2921326);
                customResponsedMessage.setOrginalMessage(customMessage);
                return customResponsedMessage;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
