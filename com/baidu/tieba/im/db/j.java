package com.baidu.tieba.im.db;

import android.text.TextUtils;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.data.AddGroupInfoData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.RequestAddGroupMessage;
import com.baidu.tieba.im.message.RequestRemoveMembersMessage;
import com.baidu.tieba.im.message.ResponseAddGroupMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ i a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(i iVar, int i) {
        super(i);
        this.a = iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        Message<?> orginalMessage;
        String[] split;
        if (socketResponsedMessage != null) {
            if (socketResponsedMessage.getCmd() == 103112) {
                if (socketResponsedMessage instanceof ResponseRemoveMembersMessage) {
                    ResponseRemoveMembersMessage responseRemoveMembersMessage = (ResponseRemoveMembersMessage) socketResponsedMessage;
                    if (responseRemoveMembersMessage.getError() == 0 && (orginalMessage = responseRemoveMembersMessage.getOrginalMessage()) != null && (orginalMessage instanceof RequestRemoveMembersMessage)) {
                        String userIds = ((RequestRemoveMembersMessage) orginalMessage).getUserIds();
                        if (!TextUtils.isEmpty(userIds) && (split = userIds.split(",")) != null && split.length != 0) {
                            String id = TbadkApplication.getCurrentAccountObj().getID();
                            if (!TextUtils.isEmpty(id)) {
                                for (String str : split) {
                                    if (id.equals(str)) {
                                        this.a.a(responseRemoveMembersMessage.getGroupId());
                                        com.baidu.tieba.im.i.a(new k(this, responseRemoveMembersMessage), null);
                                        i.a().a(responseRemoveMembersMessage.getGroupId());
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (socketResponsedMessage.getCmd() == 103101 && (socketResponsedMessage instanceof ResponseAddGroupMessage)) {
                ResponseAddGroupMessage responseAddGroupMessage = (ResponseAddGroupMessage) socketResponsedMessage;
                if (responseAddGroupMessage.getError() == 0) {
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    RequestAddGroupMessage requestAddGroupMessage = (RequestAddGroupMessage) responseAddGroupMessage.getOrginalMessage();
                    imMessageCenterPojo.setGroup_name(requestAddGroupMessage.getName());
                    imMessageCenterPojo.setCustomGroupType(com.baidu.tieba.im.c.a.a(requestAddGroupMessage.getGroupType()));
                    AddGroupInfoData addGroupInfo = responseAddGroupMessage.getAddGroupInfo();
                    if (addGroupInfo != null) {
                        imMessageCenterPojo.setGroup_head(addGroupInfo.getPortrait());
                        imMessageCenterPojo.setGid(String.valueOf(addGroupInfo.getGroupId()));
                        com.baidu.tieba.im.f.i.a(imMessageCenterPojo);
                    }
                }
            }
        }
    }
}
