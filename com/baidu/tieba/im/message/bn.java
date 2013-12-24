package com.baidu.tieba.im.message;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.data.GroupIdTypeData;
import java.util.LinkedList;
import java.util.List;
import protobuf.GetGroupMsg.GetGroupMsgRes;
import protobuf.Im;
/* loaded from: classes.dex */
public class bn extends bz implements com.baidu.tieba.im.coder.f {
    private List<com.baidu.tieba.im.data.c> a;

    public bn() {
        super(202003);
    }

    public List<com.baidu.tieba.im.data.c> a() {
        return this.a;
    }

    public void a(List<com.baidu.tieba.im.data.c> list) {
        this.a = list;
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<n> linkedList, byte[] bArr, int i) {
        int size;
        GetGroupMsgRes.GetGroupMsgResIdl parseFrom = GetGroupMsgRes.GetGroupMsgResIdl.parseFrom(bArr);
        c(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!i()) {
            a(new LinkedList());
            int groupMsgCount = parseFrom.getData().getGroupMsgCount();
            for (int i2 = 0; i2 < groupMsgCount; i2++) {
                com.baidu.tieba.im.data.c cVar = new com.baidu.tieba.im.data.c(-100);
                linkedList.add(cVar);
                a().add(cVar);
                com.baidu.tieba.im.data.f fVar = new com.baidu.tieba.im.data.f();
                fVar.a(new LinkedList());
                cVar.a(fVar);
                GetGroupMsgRes.GroupMsg groupMsg = parseFrom.getData().getGroupMsg(i2);
                Im.GroupInfo groupInfo = groupMsg.getGroupInfo();
                GroupIdTypeData groupIdTypeData = new GroupIdTypeData();
                cVar.a(groupIdTypeData);
                groupIdTypeData.setGroupId(groupInfo.getGroupId());
                groupIdTypeData.setGroupType(groupInfo.getGroupType());
                List<Im.MsgInfo> msgListList = groupMsg.getMsgListList();
                if (msgListList != null && (size = msgListList.size()) > 0) {
                    com.baidu.adp.lib.h.e.c("----transform list size:" + size);
                    for (int i3 = 0; i3 < size; i3++) {
                        try {
                            Im.MsgInfo msgInfo = msgListList.get(i3);
                            d dVar = new d();
                            long b = com.baidu.tieba.im.chat.ai.b(msgInfo.getMsgId());
                            dVar.c(b);
                            dVar.b(String.valueOf(msgInfo.getGroupId()));
                            dVar.b(msgInfo.getMsgType());
                            com.baidu.adp.lib.h.e.d("msgType:" + dVar.h());
                            long userId = msgInfo.getUserId();
                            dVar.d(userId);
                            if (TiebaApplication.C() && String.valueOf(userId).equals(TiebaApplication.B())) {
                                dVar.b(msgInfo.getRecordId());
                            } else {
                                dVar.b(b);
                            }
                            dVar.a(new UserData());
                            Im.UserInfo userInfo = msgInfo.getUserInfo();
                            dVar.f().setId(String.valueOf(userInfo.getUserId()));
                            dVar.f().setName(userInfo.getUserName());
                            dVar.f().setPortrait(userInfo.getPortrait());
                            dVar.f().setSex(userInfo.getSex());
                            dVar.b(new UserData());
                            Im.UserInfo toUserInfo = msgInfo.getToUserInfo();
                            dVar.g().setId(String.valueOf(toUserInfo.getUserId()));
                            dVar.g().setName(toUserInfo.getUserName());
                            dVar.g().setPortrait(toUserInfo.getPortrait());
                            dVar.g().setSex(toUserInfo.getSex());
                            dVar.a(msgInfo.getToUid());
                            dVar.a(msgInfo.getContent());
                            dVar.e(msgInfo.getCreateTime());
                            fVar.a().add(dVar);
                            com.baidu.tieba.im.d.d.e(dVar);
                        } catch (Exception e) {
                            e.printStackTrace();
                            com.baidu.adp.lib.h.e.c("----transform error!");
                        }
                    }
                }
            }
        }
    }
}
