package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.im.data.GroupIdTypeData;
import com.baidu.tieba.im.data.GroupMsgData;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import protobuf.GetGroupMsg.GetGroupMsgRes;
import protobuf.Im;
/* loaded from: classes.dex */
public class ResponsePullMessage extends SocketResponsedMessage {
    private List<GroupMsgData> a;
    private int b;

    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        int size;
        com.baidu.tieba.im.message.a.h iVar;
        GetGroupMsgRes.GetGroupMsgResIdl parseFrom = GetGroupMsgRes.GetGroupMsgResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        e(parseFrom.getError().getUsermsg());
        if (e() == 0) {
            this.b = parseFrom.getData().getAllowEggs();
            this.a = new LinkedList();
            int groupMsgCount = parseFrom.getData().getGroupMsgCount();
            for (int i2 = 0; i2 < groupMsgCount; i2++) {
                GetGroupMsgRes.GroupMsg groupMsg = parseFrom.getData().getGroupMsg(i2);
                Im.GroupInfo groupInfo = groupMsg.getGroupInfo();
                GroupMsgData groupMsgData = null;
                switch (groupInfo.getGroupType()) {
                    case 1:
                        groupMsgData = new GroupMsgData(2013000);
                        break;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        groupMsgData = new GroupMsgData(2013005);
                        break;
                    case 6:
                        groupMsgData = new GroupMsgData(2013001);
                        break;
                    case 7:
                        groupMsgData = new GroupMsgData(2013002);
                        break;
                    case 8:
                        groupMsgData = new GroupMsgData(2013004);
                        break;
                    case 10:
                    case 11:
                    case 12:
                        groupMsgData = new GroupMsgData(2013006);
                        break;
                }
                this.a.add(groupMsgData);
                LinkedList<com.baidu.tieba.im.message.a.a> linkedList = new LinkedList<>();
                groupMsgData.a(linkedList);
                GroupIdTypeData groupIdTypeData = new GroupIdTypeData();
                groupMsgData.a(groupIdTypeData);
                groupIdTypeData.setGroupId(groupInfo.getGroupId());
                groupIdTypeData.setGroupType(groupInfo.getGroupType());
                List<Im.MsgInfo> msgListList = groupMsg.getMsgListList();
                if (msgListList != null && (size = msgListList.size()) > 0) {
                    com.baidu.adp.lib.util.f.d("----transform list size:" + size);
                    for (int i3 = 0; i3 < size; i3++) {
                        try {
                            Im.MsgInfo msgInfo = msgListList.get(i3);
                            switch (groupInfo.getGroupType()) {
                                case 1:
                                    iVar = new com.baidu.tieba.im.message.a.h();
                                    break;
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                    iVar = new com.baidu.tieba.im.message.a.c();
                                    break;
                                case 6:
                                    if ((com.baidu.adp.lib.f.b.a(TbadkApplication.E(), 0L) != msgInfo.getUserId() ? msgInfo.getUserInfo().getUserType() : msgInfo.getToUserInfo().getUserType()) == 1) {
                                        iVar = new com.baidu.tieba.im.message.a.e();
                                        break;
                                    } else {
                                        iVar = new com.baidu.tieba.im.message.a.f();
                                        break;
                                    }
                                case 7:
                                    iVar = new com.baidu.tieba.im.message.a.g();
                                    break;
                                case 8:
                                    iVar = new com.baidu.tieba.im.message.a.d();
                                    break;
                                case 9:
                                default:
                                    iVar = null;
                                    break;
                                case 10:
                                case 11:
                                case 12:
                                    iVar = new com.baidu.tieba.im.message.a.i();
                                    break;
                            }
                            long msgId = msgInfo.getMsgId() * 100;
                            iVar.f(msgId);
                            iVar.a(String.valueOf(msgInfo.getGroupId()));
                            iVar.e(msgInfo.getMsgType());
                            com.baidu.adp.lib.util.f.e("msgType:" + iVar.t());
                            long userId = msgInfo.getUserId();
                            iVar.g(userId);
                            if (TbadkApplication.F() && String.valueOf(userId).equals(TbadkApplication.E())) {
                                iVar.e(msgInfo.getRecordId());
                            } else {
                                iVar.e(msgId);
                            }
                            UserData userData = new UserData();
                            iVar.a(userData);
                            Im.UserInfo userInfo = msgInfo.getUserInfo();
                            List<Im.TshowInfo> tshowIconList = userInfo.getTshowIconList();
                            if (tshowIconList != null) {
                                LinkedList<IconData> linkedList2 = new LinkedList<>();
                                int i4 = 0;
                                while (true) {
                                    int i5 = i4;
                                    if (i5 >= tshowIconList.size()) {
                                        userData.setTShowInfo(linkedList2);
                                    } else {
                                        Im.TshowInfo tshowInfo = tshowIconList.get(i5);
                                        linkedList2.add(new IconData(tshowInfo.getIcon(), tshowInfo.getName(), tshowInfo.getUrl()));
                                        i4 = i5 + 1;
                                    }
                                }
                            }
                            iVar.r().setUserId(String.valueOf(userInfo.getUserId()));
                            iVar.r().setUserName(userInfo.getUserName());
                            iVar.r().setPortrait(userInfo.getPortrait());
                            iVar.r().setSex(userInfo.getSex());
                            iVar.r().setUserType(userInfo.getUserType());
                            iVar.b(new UserData());
                            Im.UserInfo toUserInfo = msgInfo.getToUserInfo();
                            iVar.s().setUserId(String.valueOf(toUserInfo.getUserId()));
                            iVar.s().setUserName(toUserInfo.getUserName());
                            iVar.s().setPortrait(toUserInfo.getPortrait());
                            iVar.s().setSex(toUserInfo.getSex());
                            iVar.s().setUserType(toUserInfo.getUserType());
                            iVar.c(msgInfo.getToUid());
                            iVar.d(msgInfo.getContent());
                            iVar.h(msgInfo.getCreateTime());
                            iVar.b(msgInfo.getLink());
                            iVar.c(msgInfo.getStat());
                            iVar.d(msgInfo.getTaskId());
                            linkedList.add(iVar);
                            com.baidu.tieba.im.f.q.f(iVar);
                        } catch (Exception e) {
                            e.printStackTrace();
                            com.baidu.adp.lib.util.f.d("----transform error!");
                        }
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // com.baidu.adp.framework.message.f
    public final /* synthetic */ void b(int i, byte[] bArr) {
        for (GroupMsgData groupMsgData : this.a) {
            Iterator<com.baidu.tieba.im.message.a.a> it = groupMsgData.c().iterator();
            while (it.hasNext()) {
                it.next().j();
            }
        }
    }

    public ResponsePullMessage() {
        super(202003);
    }

    public final List<GroupMsgData> d() {
        return this.a;
    }

    public final int i() {
        return this.b;
    }
}
