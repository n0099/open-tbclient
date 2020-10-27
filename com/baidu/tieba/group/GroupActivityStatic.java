package com.baidu.tieba.group;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.f.b;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
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
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.aj;
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
/* loaded from: classes23.dex */
public class GroupActivityStatic {
    public static final BdUniqueId jnN = BdUniqueId.gen();

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
        c.b(CmdConfigSocket.CMD_JOIN_GROUP, ResponseJoinGroupMessage.class, false);
        c.b(CmdConfigSocket.CMD_REPORT_GROUP, ResponseReportGroupMessage.class, false);
        c.b(CmdConfigSocket.CMD_REQUEST_MEMBERS_BY_ID, ResponseMembersMessage.class, false);
        c.b(CmdConfigSocket.CMD_REQUEST_GROUPLEVEL_BY_ID, ResponseGroupLevelMessage.class, false);
        c.b(CmdConfigSocket.CMD_QUERY_GROUPLOC, ResponseRequestGroupLocMessage.class, false);
        c.b(CmdConfigSocket.CMD_CREATE_GROUP_ACTIVITY, ResponseCreateGroupActivityMessage.class, false);
        c.b(CmdConfigSocket.CMD_GET_GROUP_ACTIVITY, ResponseGetGroupActivityMessage.class, false);
        c.b(CmdConfigSocket.CMD_DEL_GROUP_ACTIVITY, ResponseDelGroupActivityMessage.class, false);
        c.b(CmdConfigSocket.CMD_REQUEST_GROUP_INFO_BY_ID, ResponseGroupInfoMessage.class, false);
        c.b(CmdConfigCustom.CMD_REQUEST_GROUP_INFO_BY_ID_LOCAL, h.class);
        c.b(CmdConfigCustom.CMD_REQUEST_GROUP_ACTIVITY_BY_ID_LOCAL, d.class);
        cFH();
        cFI();
        cFJ();
        cFK();
        MessageManager.getInstance().registerListener(CmdConfigSocket.CMD_REQUEST_GROUP_INFO_BY_ID, new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.group.GroupActivityStatic.1
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
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_GET_GROUP_INFO) { // from class: com.baidu.tieba.group.GroupActivityStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (longValue != 0) {
                        RequestGroupInfoMessage requestGroupInfoMessage = new RequestGroupInfoMessage();
                        LocalViewSize.ImageSize bol = LocalViewSize.bok().bol();
                        LocalViewSize.ImageSize bom = LocalViewSize.bok().bom();
                        requestGroupInfoMessage.setBigHeight(bom.height);
                        requestGroupInfoMessage.setBigWidth(bom.width);
                        requestGroupInfoMessage.setSmallHeight(bol.height);
                        requestGroupInfoMessage.setSmallWidth(bol.width);
                        requestGroupInfoMessage.setGroupId(longValue);
                        MessageManager.getInstance().sendMessage(requestGroupInfoMessage);
                    }
                }
            }
        });
    }

    private static void cFH() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.IM_APPLE_JOIN_GROUP_ACTIVITY_START, new CustomMessageTask.CustomRunnable<ApplyJoinGroupActivityConfig>() { // from class: com.baidu.tieba.group.GroupActivityStatic.3
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

    private static void cFI() {
        aj.cxO().yT(4);
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.group.GroupActivityStatic.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                    AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                    absDelegateAdapterList.add(new e(null, GroupInfoData.TYPE_FRS_GROUP));
                    absDelegateAdapterList.add(new com.baidu.tieba.im.frsgroup.a(null, GroupPermData.TYPE_FRS_CREATE_GROUP));
                    absDelegateAdapterList.add(new g(null, com.baidu.tieba.im.frsgroup.h.jZw));
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_MODEL) { // from class: com.baidu.tieba.group.GroupActivityStatic.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003011 && (customResponsedMessage.getData() instanceof ai)) {
                    com.baidu.tieba.im.frsgroup.d dVar = new com.baidu.tieba.im.frsgroup.d();
                    dVar.setTag(GroupActivityStatic.jnN);
                    ((ai) customResponsedMessage.getData()).a(4, dVar);
                }
            }
        });
    }

    private static void cFJ() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, new CustomMessageTask.CustomRunnable<GroupInfoActivityConfig>() { // from class: com.baidu.tieba.group.GroupActivityStatic.6
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

    private static void cFK() {
        be.boR().a(new be.a() { // from class: com.baidu.tieba.group.GroupActivityStatic.7
            @Override // com.baidu.tbadk.core.util.be.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
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
                    long j = b.toLong(str.substring(indexOf, lastIndexOf), 0L);
                    if (j <= 0) {
                        return 3;
                    }
                    GroupInfoActivityConfig groupInfoActivityConfig = new GroupInfoActivityConfig(tbPageContext.getPageActivity(), j, 0);
                    if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                        tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, groupInfoActivityConfig));
                        return 1;
                    } else if (tbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                        tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, groupInfoActivityConfig));
                        return 1;
                    }
                }
                return 3;
            }
        });
    }
}
