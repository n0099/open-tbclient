package com.baidu.tieba.group;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.g.b;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
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
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.atomData.GroupLevelActivityConfig;
import com.baidu.tbadk.core.atomData.GroupSettingActivityConfig;
import com.baidu.tbadk.core.atomData.UpdateGroupActivityConfig;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.y;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.im.c;
import com.baidu.tieba.im.c.a.d;
import com.baidu.tieba.im.c.a.h;
import com.baidu.tieba.im.chat.GroupSettingActivity;
import com.baidu.tieba.im.creategroup.CreateGroupMainActivity;
import com.baidu.tieba.im.creategroup.CreateGroupStepActivity;
import com.baidu.tieba.im.creategroup.GroupAddressEditActivity;
import com.baidu.tieba.im.creategroup.GroupAddressLocateActivity;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.frsgroup.GroupLevelActivity;
import com.baidu.tieba.im.frsgroup.e;
import com.baidu.tieba.im.frsgroup.g;
import com.baidu.tieba.im.frsgroup.view.FrsGroupActivity;
import com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity;
import com.baidu.tieba.im.groupActivity.GroupActivityActivity;
import com.baidu.tieba.im.groupCard.GroupCardActivity;
import com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity;
import com.baidu.tieba.im.groupInfo.GroupImageActivity;
import com.baidu.tieba.im.groupInfo.GroupInfoActivity;
import com.baidu.tieba.im.groupInfo.ResponseJoinGroupMessage;
import com.baidu.tieba.im.message.MemoryUpdateHeadNameMessage;
import com.baidu.tieba.im.message.RequestGroupInfoMessage;
import com.baidu.tieba.im.message.ResponseCreateGroupActivityMessage;
import com.baidu.tieba.im.message.ResponseDelGroupActivityMessage;
import com.baidu.tieba.im.message.ResponseGetGroupActivityMessage;
import com.baidu.tieba.im.message.ResponseGroupInfoLocalMessage;
import com.baidu.tieba.im.message.ResponseGroupInfoMessage;
import com.baidu.tieba.im.message.ResponseGroupLevelMessage;
import com.baidu.tieba.im.message.ResponseMembersMessage;
import com.baidu.tieba.im.message.ResponseReportGroupMessage;
import com.baidu.tieba.im.message.ResponseRequestGroupLocMessage;
import com.baidu.tieba.im.updategroup.UpdateGroupActivity;
/* loaded from: classes5.dex */
public class GroupActivityStatic {
    public static final BdUniqueId gdo = BdUniqueId.gen();

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
        c.b(103110, ResponseJoinGroupMessage.class, false);
        c.b(103103, ResponseReportGroupMessage.class, false);
        c.b(103005, ResponseMembersMessage.class, false);
        c.b(103006, ResponseGroupLevelMessage.class, false);
        c.b(103010, ResponseRequestGroupLocMessage.class, false);
        c.b(103120, ResponseCreateGroupActivityMessage.class, false);
        c.b(103015, ResponseGetGroupActivityMessage.class, false);
        c.b(103121, ResponseDelGroupActivityMessage.class, false);
        c.b(103004, ResponseGroupInfoMessage.class, false);
        c.b(2001102, h.class);
        c.b(2001123, d.class);
        bvz();
        bvA();
        bvB();
        bvC();
        MessageManager.getInstance().registerListener(103004, new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.group.GroupActivityStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                ResponseGroupInfoMessage responseGroupInfoMessage;
                if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 103004 && (responseGroupInfoMessage = (ResponseGroupInfoMessage) socketResponsedMessage) != null && responseGroupInfoMessage.getData() != null) {
                    ResponseGroupInfoLocalMessage.a data = responseGroupInfoMessage.getData();
                    if (data.getGroup() != null) {
                        MemoryUpdateHeadNameMessage.a aVar = new MemoryUpdateHeadNameMessage.a();
                        aVar.customGroupType = 1;
                        aVar.id = String.valueOf(data.getGroup().getGroupId());
                        aVar.name = data.getGroup().getName();
                        aVar.head = data.getGroup().getPortrait();
                        MessageManager.getInstance().dispatchResponsedMessage(new MemoryUpdateHeadNameMessage(aVar));
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001280) { // from class: com.baidu.tieba.group.GroupActivityStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (longValue != 0) {
                        RequestGroupInfoMessage requestGroupInfoMessage = new RequestGroupInfoMessage();
                        LocalViewSize.ImageSize aiF = LocalViewSize.aiD().aiF();
                        LocalViewSize.ImageSize aiG = LocalViewSize.aiD().aiG();
                        requestGroupInfoMessage.setBigHeight(aiG.height);
                        requestGroupInfoMessage.setBigWidth(aiG.width);
                        requestGroupInfoMessage.setSmallHeight(aiF.height);
                        requestGroupInfoMessage.setSmallWidth(aiF.width);
                        requestGroupInfoMessage.setGroupId(longValue);
                        MessageManager.getInstance().sendMessage(requestGroupInfoMessage);
                    }
                }
            }
        });
    }

    private static void bvz() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008014, new CustomMessageTask.CustomRunnable<ApplyJoinGroupActivityConfig>() { // from class: com.baidu.tieba.group.GroupActivityStatic.3
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

    private static void bvA() {
        z.boz().rR(4);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2003008) { // from class: com.baidu.tieba.group.GroupActivityStatic.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                    AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                    absDelegateAdapterList.add(new e(null, GroupInfoData.TYPE_FRS_GROUP));
                    absDelegateAdapterList.add(new com.baidu.tieba.im.frsgroup.a(null, GroupPermData.TYPE_FRS_CREATE_GROUP));
                    absDelegateAdapterList.add(new g(null, com.baidu.tieba.im.frsgroup.h.gJl));
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2003011) { // from class: com.baidu.tieba.group.GroupActivityStatic.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003011 && (customResponsedMessage.getData() instanceof y)) {
                    com.baidu.tieba.im.frsgroup.d dVar = new com.baidu.tieba.im.frsgroup.d();
                    dVar.setTag(GroupActivityStatic.gdo);
                    ((y) customResponsedMessage.getData()).a(4, dVar);
                }
            }
        });
    }

    private static void bvB() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008011, new CustomMessageTask.CustomRunnable<GroupInfoActivityConfig>() { // from class: com.baidu.tieba.group.GroupActivityStatic.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<GroupInfoActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    int intExtra = customMessage.getData().getIntent().getIntExtra(GroupInfoActivityConfig.REQUEST_CODE, -1);
                    if (intExtra != -1) {
                        customMessage.getData().startActivityForResult(intExtra, GroupInfoActivity.class);
                    } else {
                        customMessage.getData().startActivity(GroupInfoActivity.class);
                    }
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bvC() {
        ba.ajK().a(new ba.a() { // from class: com.baidu.tieba.group.GroupActivityStatic.7
            @Override // com.baidu.tbadk.core.util.ba.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (str.contains("tieba.baidu.com/group/index?id=")) {
                    int indexOf = str.indexOf("tieba.baidu.com/group/index?id=") + "tieba.baidu.com/group/index?id=".length();
                    int lastIndexOf = str.lastIndexOf(38);
                    if (lastIndexOf == -1 || lastIndexOf < indexOf) {
                        lastIndexOf = str.length();
                    }
                    long e = b.e(str.substring(indexOf, lastIndexOf), 0L);
                    if (e <= 0) {
                        return 3;
                    }
                    GroupInfoActivityConfig groupInfoActivityConfig = new GroupInfoActivityConfig(tbPageContext.getPageActivity(), e, 0);
                    if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                        tbPageContext.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
                        return 1;
                    } else if (tbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                        tbPageContext.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
                        return 1;
                    }
                }
                return 3;
            }
        });
    }
}
