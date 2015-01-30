package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.performanceLog.r;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.q;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.s;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.GroupChatMessage;
import com.baidu.tieba.im.message.chat.NotifyChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.message.chat.SnapChatMessage;
import com.baidu.tieba.im.message.chat.SystemMessage;
import com.baidu.tieba.im.message.chat.YYMessage;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import protobuf.GetGroupMsg.GetGroupMsgResIdl;
import protobuf.GetGroupMsg.GroupMsg;
import protobuf.GroupInfo;
import protobuf.MsgInfo;
import protobuf.TshowInfo;
import protobuf.UserInfo;
/* loaded from: classes.dex */
public class ResponsePullMessage extends SocketResponsedMessage {
    private List<GroupMsgData> groupMsg;

    public ResponsePullMessage() {
        super(202003);
    }

    public List<GroupMsgData> getGroupMsg() {
        return this.groupMsg;
    }

    public void setGroupMsg(List<GroupMsgData> list) {
        this.groupMsg = list;
    }

    private boolean hasStranger(GroupMsgData groupMsgData) {
        if (groupMsgData == null || groupMsgData.getListMessage() == null || groupMsgData.getListMessage().size() == 0) {
            return false;
        }
        Iterator<ChatMessage> it = groupMsgData.getListMessage().iterator();
        while (it.hasNext()) {
            if (it.next().getIsFriend() == 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, INVOKE, INVOKE, ARITH, CONSTRUCTOR, INVOKE, CAST, IPUT, IGET]}, finally: {[INVOKE, INVOKE, INVOKE, ARITH, CONSTRUCTOR, INVOKE, CAST, IPUT, IGET, IGET, IGET, IPUT, INVOKE, CAST, IPUT, IPUT, IPUT, IGET, IGET, IPUT, INVOKE, INVOKE, IF] complete} */
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        int i2 = 0;
        List<GroupMsgData> groupMsg = getGroupMsg();
        if (groupMsg != null && groupMsg.size() != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    com.baidu.tieba.im.db.g.MU().MV();
                    ImMessageCenterPojo imMessageCenterPojo = null;
                    ImMessageCenterPojo imMessageCenterPojo2 = null;
                    for (GroupMsgData groupMsgData : groupMsg) {
                        if (groupMsgData != null && groupMsgData.getListMessage() != null) {
                            i2 += groupMsgData.getListMessage().size();
                            String valueOf = String.valueOf(groupMsgData.getGroupInfo().getGroupId());
                            int customType = groupMsgData.getGroupInfo().getCustomType();
                            int userType = groupMsgData.getGroupInfo().getUserType();
                            ImMessageCenterPojo A = com.baidu.tieba.im.db.k.MZ().A(valueOf, customType);
                            if (A != null) {
                                A.setUserType(userType);
                            }
                            if (customType == 4 && imMessageCenterPojo == null && (imMessageCenterPojo = com.baidu.tieba.im.db.k.MZ().A("-1000", -8)) == null) {
                                imMessageCenterPojo = new ImMessageCenterPojo();
                                imMessageCenterPojo.setGid("-1000");
                                imMessageCenterPojo.setCustomGroupType(-8);
                                imMessageCenterPojo.setIs_hidden(1);
                            }
                            if (customType == 2 && imMessageCenterPojo2 == null && hasStranger(groupMsgData) && (imMessageCenterPojo2 = com.baidu.tieba.im.db.k.MZ().A("-1001", -7)) == null) {
                                imMessageCenterPojo2 = new ImMessageCenterPojo();
                                imMessageCenterPojo2.setGid("-1001");
                                imMessageCenterPojo2.setCustomGroupType(-7);
                                imMessageCenterPojo2.setIs_hidden(1);
                            }
                            if (groupMsgData.getCmd() == 2013005) {
                                com.baidu.tieba.im.chat.receiveChatMsgHandler.e.a(groupMsgData, A, new j(this));
                            } else if (groupMsgData.getCmd() == 2013000) {
                                q.a(groupMsgData);
                            } else if (groupMsgData.getCmd() == 2013001) {
                                com.baidu.tieba.im.chat.receiveChatMsgHandler.m.b(groupMsgData, A, new k(this, imMessageCenterPojo2));
                            } else if (groupMsgData.getCmd() == 2013003) {
                                com.baidu.tieba.im.chat.receiveChatMsgHandler.k.b(groupMsgData, A, new l(this, imMessageCenterPojo));
                            } else if (groupMsgData.getCmd() == 2013008) {
                                if (groupMsgData.getListMessage() != null && groupMsgData.getListMessage().size() != 0) {
                                    ImMessageCenterPojo imMessageCenterPojo3 = new ImMessageCenterPojo();
                                    imMessageCenterPojo3.setGid(String.valueOf(com.baidu.tieba.im.c.a.boy));
                                    imMessageCenterPojo3.setCustomGroupType(-1);
                                    imMessageCenterPojo3.setIs_hidden(1);
                                    imMessageCenterPojo3.setPulled_msgId(groupMsgData.getListMessage().get(0).getMsgId());
                                    com.baidu.tieba.im.db.k.MZ().a(imMessageCenterPojo3);
                                }
                            } else if (groupMsgData.getCmd() == 2013004) {
                                com.baidu.tieba.im.chat.receiveChatMsgHandler.i.a(groupMsgData, A, new m(this));
                            } else if (groupMsgData.getCmd() == 2013006) {
                                if (groupMsgData.getGroupInfo().getGroupId() == 10) {
                                    s.a(groupMsgData, A, new n(this));
                                } else {
                                    long[] b = s.Ln().b(groupMsgData);
                                    if (b != null) {
                                        s.Ln().h(String.valueOf(b[0]), com.baidu.tieba.im.util.h.ag(b[1]));
                                    }
                                }
                            } else if (groupMsgData.getCmd() == 2013007) {
                                com.baidu.tieba.im.chat.receiveChatMsgHandler.e.a(groupMsgData, A, new o(this));
                            }
                        }
                    }
                    com.baidu.tieba.im.db.g.MU().endTransaction();
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    r rVar = new r();
                    rVar.agD = getCmd();
                    if (this.performanceData != null) {
                        rVar.ki = this.performanceData.fe;
                        rVar.agE = getDownSize();
                        rVar.agF = currentTimeMillis2;
                        rVar.agG = i2;
                        rVar.vD = this.performanceData.fd;
                        rVar.dX(1002);
                        rVar.zo();
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    com.baidu.tieba.im.db.g.MU().endTransaction();
                    long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                    r rVar2 = new r();
                    rVar2.agD = getCmd();
                    if (this.performanceData != null) {
                        rVar2.ki = this.performanceData.fe;
                        rVar2.agE = getDownSize();
                        rVar2.agF = currentTimeMillis3;
                        rVar2.agG = i2;
                        rVar2.vD = this.performanceData.fd;
                        rVar2.dX(1002);
                        rVar2.zo();
                    }
                }
            } catch (Throwable th) {
                com.baidu.tieba.im.db.g.MU().endTransaction();
                long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                r rVar3 = new r();
                rVar3.agD = getCmd();
                if (this.performanceData != null) {
                    rVar3.ki = this.performanceData.fe;
                    rVar3.agE = getDownSize();
                    rVar3.agF = currentTimeMillis4;
                    rVar3.agG = i2;
                    rVar3.vD = this.performanceData.fd;
                    rVar3.dX(1002);
                    rVar3.zo();
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        int size;
        long longValue;
        long longValue2;
        VoiceMsgData u;
        GetGroupMsgResIdl getGroupMsgResIdl = (GetGroupMsgResIdl) new Wire(new Class[0]).parseFrom(bArr, GetGroupMsgResIdl.class);
        setError(getGroupMsgResIdl.error.errorno.intValue());
        setErrorString(getGroupMsgResIdl.error.usermsg);
        if (getError() == 0 && getGroupMsgResIdl.data != null) {
            setGroupMsg(new LinkedList());
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            int size2 = getGroupMsgResIdl.data.groupMsg == null ? 0 : getGroupMsgResIdl.data.groupMsg.size();
            for (int i2 = 0; i2 < size2; i2++) {
                GroupMsg groupMsg = getGroupMsgResIdl.data.groupMsg.get(i2);
                GroupInfo groupInfo = groupMsg.groupInfo;
                GroupMsgData obtainGroupData = obtainGroupData(groupInfo);
                if (obtainGroupData == null) {
                    BdLog.e("obtainGroupData == null !!!!");
                } else {
                    getGroupMsg().add(obtainGroupData);
                    LinkedList<ChatMessage> linkedList = new LinkedList<>();
                    obtainGroupData.setListMessageData(linkedList);
                    obtainGroupData.setHasMore(groupMsg.hasMore.intValue() != 0);
                    List<MsgInfo> list = groupMsg.msgList;
                    if (list != null && (size = list.size()) > 0) {
                        for (int i3 = 0; i3 < size; i3++) {
                            try {
                                MsgInfo msgInfo = list.get(i3);
                                ChatMessage obtainMessage = obtainMessage(groupInfo, msgInfo);
                                long af = com.baidu.tieba.im.util.h.af(msgInfo.msgId.longValue());
                                obtainMessage.setMsgId(af);
                                obtainMessage.setGroupId(String.valueOf(msgInfo.groupId));
                                obtainMessage.setMsgType(msgInfo.msgType.intValue());
                                long longValue3 = msgInfo.userId.longValue();
                                obtainMessage.setUserId(longValue3);
                                if (TbadkCoreApplication.isLogin() && String.valueOf(longValue3).equals(TbadkCoreApplication.getCurrentAccount())) {
                                    obtainMessage.setRecordId(msgInfo.recordId.longValue());
                                } else {
                                    obtainMessage.setRecordId(af);
                                }
                                UserData userData = new UserData();
                                obtainMessage.setUserInfo(userData);
                                UserInfo userInfo = msgInfo.userInfo;
                                if (userInfo != null) {
                                    List<TshowInfo> list2 = userInfo.tshowIcon;
                                    if (list2 != null) {
                                        ArrayList<IconData> arrayList = new ArrayList<>();
                                        for (int i4 = 0; i4 < list2.size(); i4++) {
                                            TshowInfo tshowInfo = list2.get(i4);
                                            arrayList.add(new IconData(tshowInfo.icon, tshowInfo.name, tshowInfo.url));
                                        }
                                        userData.setTShowInfo(arrayList);
                                    }
                                    obtainMessage.getUserInfo().setUserId(String.valueOf(userInfo.userId));
                                    obtainMessage.getUserInfo().setUserName(userInfo.userName);
                                    obtainMessage.getUserInfo().setPortrait(userInfo.portrait);
                                    obtainMessage.getUserInfo().setSex(userInfo.sex.intValue());
                                    obtainMessage.getUserInfo().setUserType(userInfo.userType.intValue());
                                }
                                obtainMessage.setToUserInfo(new UserData());
                                UserInfo userInfo2 = msgInfo.toUserInfo;
                                if (userInfo2 != null) {
                                    obtainMessage.getToUserInfo().setUserId(String.valueOf(userInfo2.userId));
                                    obtainMessage.getToUserInfo().setUserName(userInfo2.userName);
                                    obtainMessage.getToUserInfo().setPortrait(userInfo2.portrait);
                                    obtainMessage.getToUserInfo().setSex(userInfo2.sex.intValue());
                                    obtainMessage.getToUserInfo().setUserType(userInfo2.userType.intValue());
                                }
                                obtainMessage.setToUserId(msgInfo.toUid.longValue());
                                obtainMessage.setContent(msgInfo.content);
                                if (msgInfo.msgType.intValue() == 3 && (u = com.baidu.tieba.im.util.i.u(obtainMessage)) != null) {
                                    if (com.baidu.tieba.im.util.i.r(obtainMessage)) {
                                        u.setHas_read(1);
                                    } else {
                                        u.setHas_read(0);
                                    }
                                    obtainMessage.setContent("[" + com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(u) + "]");
                                }
                                obtainMessage.setTime(msgInfo.createTime.intValue());
                                obtainMessage.setIsFriend(msgInfo.isFriend.intValue());
                                obtainMessage.setLink(msgInfo.link);
                                obtainMessage.setStat(msgInfo.stat);
                                obtainMessage.setTaskId(msgInfo.taskId.longValue());
                                if (obtainMessage.getMsgType() == 9 && obtainMessage.getContent() != null) {
                                    try {
                                        JSONArray jSONArray = new JSONArray(obtainMessage.getContent());
                                        if (jSONArray != null && jSONArray.length() >= 2) {
                                            String optString = jSONArray.optString(0);
                                            if (1 != jSONArray.optInt(1)) {
                                                obtainMessage.setMsgType(1);
                                                obtainMessage.setContent(optString);
                                            }
                                        }
                                    } catch (Exception e) {
                                        BdLog.e(e);
                                    }
                                }
                                if (obtainMessage instanceof OfficialChatMessage) {
                                    long a = com.baidu.adp.lib.g.c.a(TbadkCoreApplication.getCurrentAccount(), 0L);
                                    if (a != msgInfo.userId.longValue()) {
                                        longValue2 = msgInfo.userId.longValue();
                                    } else {
                                        longValue2 = msgInfo.toUid.longValue();
                                    }
                                    int i5 = 1;
                                    if (msgInfo != null && msgInfo.userInfo != null) {
                                        i5 = a != msgInfo.userId.longValue() ? msgInfo.userInfo.userType.intValue() : msgInfo.toUserInfo.userType.intValue();
                                    }
                                    if (longValue2 != 0) {
                                        if (linkedList.size() == 0) {
                                            linkedList.add(obtainMessage);
                                        } else if (linkedList.get(0).getMsgId() < obtainMessage.getMsgId()) {
                                            linkedList.remove(0);
                                            linkedList.add(obtainMessage);
                                        }
                                        if (hashMap2.get(String.valueOf(longValue2)) == null) {
                                            GroupMsgData groupMsgData = new GroupMsgData(2013003);
                                            groupMsgData.getGroupInfo().setUserType(i5);
                                            groupMsgData.getGroupInfo().setCustomType(4);
                                            groupMsgData.getGroupInfo().setGroupId((int) longValue2);
                                            getGroupMsg().add(groupMsgData);
                                            groupMsgData.setListMessageData(new LinkedList<>());
                                            hashMap2.put(String.valueOf(longValue2), groupMsgData);
                                        }
                                        ((GroupMsgData) hashMap2.get(String.valueOf(longValue2))).getListMessage().add(obtainMessage);
                                    }
                                } else if (obtainMessage instanceof PersonalChatMessage) {
                                    if (com.baidu.adp.lib.g.c.a(TbadkCoreApplication.getCurrentAccount(), 0L) != msgInfo.userId.longValue()) {
                                        longValue = msgInfo.userId.longValue();
                                    } else {
                                        longValue = msgInfo.toUid.longValue();
                                    }
                                    if (longValue != 0) {
                                        if (linkedList.size() == 0) {
                                            linkedList.add(obtainMessage);
                                        } else if (linkedList.get(0).getMsgId() < obtainMessage.getMsgId()) {
                                            linkedList.remove(0);
                                            linkedList.add(obtainMessage);
                                        }
                                        if (hashMap.get(String.valueOf(longValue)) == null) {
                                            GroupMsgData groupMsgData2 = new GroupMsgData(2013001);
                                            groupMsgData2.getGroupInfo().setCustomType(2);
                                            groupMsgData2.getGroupInfo().setGroupId((int) longValue);
                                            getGroupMsg().add(groupMsgData2);
                                            groupMsgData2.setListMessageData(new LinkedList<>());
                                            hashMap.put(String.valueOf(longValue), groupMsgData2);
                                        }
                                        ((GroupMsgData) hashMap.get(String.valueOf(longValue))).getListMessage().add(obtainMessage);
                                    }
                                } else {
                                    linkedList.add(obtainMessage);
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    private GroupMsgData obtainGroupData(GroupInfo groupInfo) {
        GroupMsgData groupMsgData = null;
        switch (groupInfo.groupType.intValue()) {
            case 1:
                groupMsgData = new GroupMsgData(2013000);
                groupMsgData.getGroupInfo().setCustomType(-2);
                break;
            case 2:
            case 3:
            case 4:
            case 5:
                groupMsgData = new GroupMsgData(2013005);
                groupMsgData.getGroupInfo().setCustomType(1);
                break;
            case 6:
                groupMsgData = new GroupMsgData(2013008);
                groupMsgData.getGroupInfo().setCustomType(-1);
                break;
            case 7:
                groupMsgData = new GroupMsgData(2013002);
                groupMsgData.getGroupInfo().setCustomType(3);
                break;
            case 8:
                groupMsgData = new GroupMsgData(2013004);
                groupMsgData.getGroupInfo().setCustomType(5);
                break;
            case 10:
                groupMsgData = new GroupMsgData(2013006);
                groupMsgData.getGroupInfo().setCustomType(6);
                break;
            case 11:
                groupMsgData = new GroupMsgData(2013006);
                groupMsgData.getGroupInfo().setCustomType(7);
                break;
            case 12:
                groupMsgData = new GroupMsgData(2013006);
                groupMsgData.getGroupInfo().setCustomType(8);
                break;
            case 21:
                groupMsgData = new GroupMsgData(2013007);
                groupMsgData.getGroupInfo().setCustomType(9);
                break;
        }
        if (groupMsgData != null) {
            groupMsgData.getGroupInfo().setGroupId(groupInfo.groupId.intValue());
            groupMsgData.getGroupInfo().setGroupType(groupInfo.groupType.intValue());
        }
        return groupMsgData;
    }

    private ChatMessage obtainMessage(GroupInfo groupInfo, MsgInfo msgInfo) {
        int intValue;
        switch (groupInfo.groupType.intValue()) {
            case 1:
                return new SystemMessage();
            case 2:
            case 3:
            case 4:
            case 5:
                return new GroupChatMessage();
            case 6:
                if (com.baidu.adp.lib.g.c.a(TbadkCoreApplication.getCurrentAccount(), 0L) != msgInfo.userId.longValue()) {
                    intValue = msgInfo.userInfo.userType.intValue();
                } else {
                    intValue = msgInfo.toUserInfo.userType.intValue();
                }
                if (intValue == 1 || intValue == 3 || intValue == 4) {
                    return new OfficialChatMessage();
                }
                return new PersonalChatMessage();
            case 7:
                return new SnapChatMessage();
            case 8:
                return new NotifyChatMessage();
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            default:
                return null;
            case 10:
            case 11:
            case 12:
                return new YYMessage();
            case 21:
                return new GroupChatMessage();
        }
    }
}
