package com.baidu.tieba.im.db;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.AddGroupInfoData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.RequestAddGroupMessage;
import com.baidu.tieba.im.message.RequestRemoveMembersMessage;
import com.baidu.tieba.im.message.ResponseAddGroupMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
class ag implements com.baidu.tieba.im.messageCenter.h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aa f1599a;

    private ag(aa aaVar) {
        this.f1599a = aaVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ag(aa aaVar, ab abVar) {
        this(aaVar);
    }

    @Override // com.baidu.tieba.im.messageCenter.h
    public void a(Message message) {
        Message orginalMessage;
        String[] split;
        if (message != null) {
            if (message.getCmd() == 103112) {
                if (message instanceof ResponseRemoveMembersMessage) {
                    ResponseRemoveMembersMessage responseRemoveMembersMessage = (ResponseRemoveMembersMessage) message;
                    if (!responseRemoveMembersMessage.hasError() && (orginalMessage = responseRemoveMembersMessage.getOrginalMessage()) != null && (orginalMessage instanceof RequestRemoveMembersMessage)) {
                        String userIds = ((RequestRemoveMembersMessage) orginalMessage).getUserIds();
                        if (!TextUtils.isEmpty(userIds) && (split = userIds.split(",")) != null && split.length != 0) {
                            String id = TiebaApplication.E().getID();
                            if (!TextUtils.isEmpty(id)) {
                                for (String str : split) {
                                    if (id.equals(str)) {
                                        this.f1599a.a(responseRemoveMembersMessage.getGroupId());
                                        com.baidu.tieba.im.m.a(new ah(this, responseRemoveMembersMessage), null);
                                        aa.a().a(responseRemoveMembersMessage.getGroupId());
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (message.getCmd() == 103101 && (message instanceof ResponseAddGroupMessage)) {
                ResponseAddGroupMessage responseAddGroupMessage = (ResponseAddGroupMessage) message;
                if (!responseAddGroupMessage.hasError()) {
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    RequestAddGroupMessage requestAddGroupMessage = (RequestAddGroupMessage) responseAddGroupMessage.getOrginalMessage();
                    imMessageCenterPojo.setGroup_name(requestAddGroupMessage.getName());
                    imMessageCenterPojo.setGroup_type(requestAddGroupMessage.getGroupType());
                    imMessageCenterPojo.setGroup_head(requestAddGroupMessage.getPortrait());
                    AddGroupInfoData addGroupInfo = responseAddGroupMessage.getAddGroupInfo();
                    if (addGroupInfo != null) {
                        imMessageCenterPojo.setGid(String.valueOf(addGroupInfo.getGroupId()));
                        LinkedList<String> linkedList = new LinkedList<>();
                        linkedList.add(imMessageCenterPojo.getGid());
                        a.a().a(linkedList, (com.baidu.tieba.im.a<Void>) null);
                        n.a().a(imMessageCenterPojo, (com.baidu.tieba.im.a<Boolean>) null);
                        aa.a().b(imMessageCenterPojo);
                    }
                }
            }
        }
    }
}
