package com.baidu.tieba.im.message;

import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.data.GroupIdTypeData;
import java.util.LinkedList;
import java.util.List;
import protobuf.GetGroupMsg.GetGroupMsgRes;
import protobuf.Im;
/* loaded from: classes.dex */
public class cj extends da implements com.baidu.tieba.im.coder.f {
    private List<com.baidu.tieba.im.data.c> a;
    private int b;

    public cj() {
        super(202003);
    }

    public List<com.baidu.tieba.im.data.c> a() {
        return this.a;
    }

    public void a(List<com.baidu.tieba.im.data.c> list) {
        this.a = list;
    }

    public int b() {
        return this.b;
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<s> linkedList, byte[] bArr, int i) {
        int size;
        GetGroupMsgRes.GetGroupMsgResIdl parseFrom = GetGroupMsgRes.GetGroupMsgResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!l()) {
            this.b = parseFrom.getData().getAllowEggs();
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
                    com.baidu.adp.lib.util.f.d("----transform list size:" + size);
                    for (int i3 = 0; i3 < size; i3++) {
                        try {
                            Im.MsgInfo msgInfo = msgListList.get(i3);
                            g gVar = new g();
                            long b = com.baidu.tieba.im.chat.be.b(msgInfo.getMsgId());
                            gVar.d(b);
                            gVar.b(String.valueOf(msgInfo.getGroupId()));
                            gVar.b(msgInfo.getMsgType());
                            com.baidu.adp.lib.util.f.e("msgType:" + gVar.i());
                            long userId = msgInfo.getUserId();
                            gVar.e(userId);
                            if (TiebaApplication.B() && String.valueOf(userId).equals(TiebaApplication.A())) {
                                gVar.c(msgInfo.getRecordId());
                            } else {
                                gVar.c(b);
                            }
                            UserData userData = new UserData();
                            gVar.a(userData);
                            Im.UserInfo userInfo = msgInfo.getUserInfo();
                            List<Im.TshowInfo> tshowIconList = userInfo.getTshowIconList();
                            if (tshowIconList != null) {
                                LinkedList<IconData> linkedList2 = new LinkedList<>();
                                int i4 = 0;
                                while (true) {
                                    int i5 = i4;
                                    if (i5 >= tshowIconList.size()) {
                                        break;
                                    }
                                    Im.TshowInfo tshowInfo = tshowIconList.get(i5);
                                    linkedList2.add(new IconData(tshowInfo.getIcon(), tshowInfo.getName(), tshowInfo.getUrl()));
                                    i4 = i5 + 1;
                                }
                                userData.setTShowInfo(linkedList2);
                            }
                            gVar.g().setUserId(String.valueOf(userInfo.getUserId()));
                            gVar.g().setUserName(userInfo.getUserName());
                            gVar.g().setPortrait(userInfo.getPortrait());
                            gVar.g().setSex(userInfo.getSex());
                            gVar.b(new UserData());
                            Im.UserInfo toUserInfo = msgInfo.getToUserInfo();
                            gVar.h().setUserId(String.valueOf(toUserInfo.getUserId()));
                            gVar.h().setUserName(toUserInfo.getUserName());
                            gVar.h().setPortrait(toUserInfo.getPortrait());
                            gVar.h().setSex(toUserInfo.getSex());
                            gVar.b(msgInfo.getToUid());
                            gVar.a(msgInfo.getContent());
                            gVar.f(msgInfo.getCreateTime());
                            fVar.a().add(gVar);
                            com.baidu.tieba.im.util.l.g(gVar);
                        } catch (Exception e) {
                            e.printStackTrace();
                            com.baidu.adp.lib.util.f.d("----transform error!");
                        }
                    }
                }
            }
        }
    }
}
