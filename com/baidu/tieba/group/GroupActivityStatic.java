package com.baidu.tieba.group;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ApplyJoinGroupActivityConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.CreateGroupMainActivityConfig;
import com.baidu.tbadk.core.atomData.CreateGroupStepActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGroupActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.GroupAddressEditActivityConfig;
import com.baidu.tbadk.core.atomData.GroupAddressLocateActivityConfig;
import com.baidu.tbadk.core.atomData.GroupCardActivityConfig;
import com.baidu.tbadk.core.atomData.GroupImageActivityConfig;
import com.baidu.tbadk.core.atomData.GroupLevelActivityConfig;
import com.baidu.tbadk.core.atomData.GroupSettingActivityConfig;
import com.baidu.tbadk.core.atomData.UpdateGroupActivityConfig;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.ac;
import com.baidu.tieba.frs.ad;
import com.baidu.tieba.im.chat.GroupSettingActivity;
import com.baidu.tieba.im.creategroup.CreateGroupMainActivity;
import com.baidu.tieba.im.creategroup.CreateGroupStepActivity;
import com.baidu.tieba.im.creategroup.GroupAddressEditActivity;
import com.baidu.tieba.im.creategroup.GroupAddressLocateActivity;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.frsgroup.GroupLevelActivity;
import com.baidu.tieba.im.frsgroup.d;
import com.baidu.tieba.im.frsgroup.e;
import com.baidu.tieba.im.frsgroup.g;
import com.baidu.tieba.im.frsgroup.h;
import com.baidu.tieba.im.frsgroup.view.FrsGroupActivity;
import com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity;
import com.baidu.tieba.im.groupActivity.GroupActivityActivity;
import com.baidu.tieba.im.groupCard.GroupCardActivity;
import com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity;
import com.baidu.tieba.im.groupInfo.GroupImageActivity;
import com.baidu.tieba.im.updategroup.UpdateGroupActivity;
/* loaded from: classes3.dex */
public class GroupActivityStatic {
    public static final BdUniqueId eeJ = BdUniqueId.gen();

    static {
        TbadkApplication.getInst().RegisterIntent(GroupSettingActivityConfig.class, GroupSettingActivity.class);
        TbadkApplication.getInst().RegisterIntent(CreateGroupMainActivityConfig.class, CreateGroupMainActivity.class);
        TbadkApplication.getInst().RegisterIntent(CreateGroupStepActivityConfig.class, CreateGroupStepActivity.class);
        TbadkApplication.getInst().RegisterIntent(GroupAddressEditActivityConfig.class, GroupAddressEditActivity.class);
        TbadkApplication.getInst().RegisterIntent(GroupAddressLocateActivityConfig.class, GroupAddressLocateActivity.class);
        TbadkApplication.getInst().RegisterIntent(GroupLevelActivityConfig.class, GroupLevelActivity.class);
        TbadkApplication.getInst().RegisterIntent(CreateGroupActivityActivityConfig.class, CreateGroupActivityActivity.class);
        TbadkApplication.getInst().RegisterIntent(GroupActivityActivityConfig.class, GroupActivityActivity.class);
        TbadkApplication.getInst().RegisterIntent(GroupCardActivityConfig.class, GroupCardActivity.class);
        TbadkApplication.getInst().RegisterIntent(GroupImageActivityConfig.class, GroupImageActivity.class);
        TbadkApplication.getInst().RegisterIntent(UpdateGroupActivityConfig.class, UpdateGroupActivity.class);
        TbadkApplication.getInst().RegisterIntent(FrsGroupActivityConfig.class, FrsGroupActivity.class);
        aBQ();
        aBR();
    }

    private static void aBQ() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008014, new CustomMessageTask.CustomRunnable<ApplyJoinGroupActivityConfig>() { // from class: com.baidu.tieba.group.GroupActivityStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<ApplyJoinGroupActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(ApplyJoinGroupActivity.class);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aBR() {
        ad.awn().mZ(4);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2003008) { // from class: com.baidu.tieba.group.GroupActivityStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                    AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                    absDelegateAdapterList.add(new e(null, GroupInfoData.TYPE_FRS_GROUP));
                    absDelegateAdapterList.add(new com.baidu.tieba.im.frsgroup.a(null, GroupPermData.TYPE_FRS_CREATE_GROUP));
                    absDelegateAdapterList.add(new g(null, h.eDL));
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2003011) { // from class: com.baidu.tieba.group.GroupActivityStatic.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003011 && (customResponsedMessage.getData() instanceof ac)) {
                    d dVar = new d();
                    dVar.setTag(GroupActivityStatic.eeJ);
                    ((ac) customResponsedMessage.getData()).a(4, dVar);
                }
            }
        });
    }
}
