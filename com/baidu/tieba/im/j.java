package com.baidu.tieba.im;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.data.AddGroupInfoData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.RequestAddGroupMessage;
import com.baidu.tieba.im.message.ResponseAddGroupMessage;
/* loaded from: classes.dex */
class j extends com.baidu.adp.framework.listener.e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public j(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseAddGroupMessage) && socketResponsedMessage.getError() == 0) {
            ResponseAddGroupMessage responseAddGroupMessage = (ResponseAddGroupMessage) socketResponsedMessage;
            RequestAddGroupMessage requestAddGroupMessage = (RequestAddGroupMessage) responseAddGroupMessage.getOrginalMessage();
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGroup_name(requestAddGroupMessage.getName());
            imMessageCenterPojo.setCustomGroupType(com.baidu.tieba.im.b.a.lH(requestAddGroupMessage.getGroupType()));
            AddGroupInfoData addGroupInfo = responseAddGroupMessage.getAddGroupInfo();
            if (addGroupInfo != null) {
                imMessageCenterPojo.setGroup_head(addGroupInfo.getPortrait());
                imMessageCenterPojo.setGid(String.valueOf(addGroupInfo.getGroupId()));
                imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.util.g.cd(1L));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_UPDATE_ITEM_CREATE_GROUP, imMessageCenterPojo));
            }
        }
    }
}
