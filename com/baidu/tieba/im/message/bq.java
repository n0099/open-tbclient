package com.baidu.tieba.im.message;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.IconData;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.data.GroupIdTypeData;
import java.util.LinkedList;
import java.util.List;
import protobuf.GetGroupMsg.GetGroupMsgRes;
import protobuf.Im;
/* loaded from: classes.dex */
public class bq extends cc implements com.baidu.tieba.im.coder.f {
    private List<com.baidu.tieba.im.data.b> a;

    public bq() {
        super(202003);
    }

    public List<com.baidu.tieba.im.data.b> a() {
        return this.a;
    }

    public void a(List<com.baidu.tieba.im.data.b> list) {
        this.a = list;
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<o> linkedList, byte[] bArr, int i) {
        int size;
        GetGroupMsgRes.GetGroupMsgResIdl parseFrom = GetGroupMsgRes.GetGroupMsgResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!i()) {
            a(new LinkedList());
            int groupMsgCount = parseFrom.getData().getGroupMsgCount();
            for (int i2 = 0; i2 < groupMsgCount; i2++) {
                com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b(-100);
                linkedList.add(bVar);
                a().add(bVar);
                com.baidu.tieba.im.data.e eVar = new com.baidu.tieba.im.data.e();
                eVar.a(new LinkedList());
                bVar.a(eVar);
                GetGroupMsgRes.GroupMsg groupMsg = parseFrom.getData().getGroupMsg(i2);
                Im.GroupInfo groupInfo = groupMsg.getGroupInfo();
                GroupIdTypeData groupIdTypeData = new GroupIdTypeData();
                bVar.a(groupIdTypeData);
                groupIdTypeData.setGroupId(groupInfo.getGroupId());
                groupIdTypeData.setGroupType(groupInfo.getGroupType());
                List<Im.MsgInfo> msgListList = groupMsg.getMsgListList();
                if (msgListList != null && (size = msgListList.size()) > 0) {
                    com.baidu.adp.lib.h.e.c("----transform list size:" + size);
                    for (int i3 = 0; i3 < size; i3++) {
                        try {
                            Im.MsgInfo msgInfo = msgListList.get(i3);
                            e eVar2 = new e();
                            long b = com.baidu.tieba.im.chat.ah.b(msgInfo.getMsgId());
                            eVar2.c(b);
                            eVar2.b(String.valueOf(msgInfo.getGroupId()));
                            eVar2.b(msgInfo.getMsgType());
                            com.baidu.adp.lib.h.e.d("msgType:" + eVar2.h());
                            long userId = msgInfo.getUserId();
                            eVar2.d(userId);
                            if (TiebaApplication.B() && String.valueOf(userId).equals(TiebaApplication.A())) {
                                eVar2.b(msgInfo.getRecordId());
                            } else {
                                eVar2.b(b);
                            }
                            UserData userData = new UserData();
                            eVar2.a(userData);
                            Im.UserInfo userInfo = msgInfo.getUserInfo();
                            List<Im.TshowInfo> tshowIconList = userInfo.getTshowIconList();
                            if (tshowIconList != null) {
                                LinkedList<IconData> linkedList2 = new LinkedList<>();
                                for (int i4 = 0; i4 < tshowIconList.size(); i4++) {
                                    Im.TshowInfo tshowInfo = tshowIconList.get(i4);
                                    linkedList2.add(new IconData(tshowInfo.getIcon(), tshowInfo.getName(), tshowInfo.getUrl()));
                                }
                                userData.setTShowInfo(linkedList2);
                            }
                            eVar2.f().setId(String.valueOf(userInfo.getUserId()));
                            eVar2.f().setName(userInfo.getUserName());
                            eVar2.f().setPortrait(userInfo.getPortrait());
                            eVar2.f().setSex(userInfo.getSex());
                            eVar2.b(new UserData());
                            Im.UserInfo toUserInfo = msgInfo.getToUserInfo();
                            eVar2.g().setId(String.valueOf(toUserInfo.getUserId()));
                            eVar2.g().setName(toUserInfo.getUserName());
                            eVar2.g().setPortrait(toUserInfo.getPortrait());
                            eVar2.g().setSex(toUserInfo.getSex());
                            eVar2.a(msgInfo.getToUid());
                            eVar2.a(msgInfo.getContent());
                            eVar2.e(msgInfo.getCreateTime());
                            eVar.a().add(eVar2);
                            com.baidu.tieba.im.d.d.f(eVar2);
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
