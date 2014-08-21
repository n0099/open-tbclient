package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.gson.Gson;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.im.chat.bu;
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        List<GroupMsgData> groupMsg = getGroupMsg();
        if (groupMsg != null) {
            try {
                if (groupMsg.size() != 0) {
                    com.baidu.tieba.im.db.g.a().b();
                    ImMessageCenterPojo imMessageCenterPojo = null;
                    ImMessageCenterPojo imMessageCenterPojo2 = null;
                    for (GroupMsgData groupMsgData : groupMsg) {
                        if (groupMsgData != null && groupMsgData.getListMessage() != null) {
                            String valueOf = String.valueOf(groupMsgData.getGroupInfo().getGroupId());
                            int customType = groupMsgData.getGroupInfo().getCustomType();
                            ImMessageCenterPojo b = com.baidu.tieba.im.db.k.a().b(valueOf, customType);
                            if (customType == 4 && imMessageCenterPojo2 == null && (imMessageCenterPojo2 = com.baidu.tieba.im.db.k.a().b("-1000", -8)) == null) {
                                imMessageCenterPojo2 = new ImMessageCenterPojo();
                                imMessageCenterPojo2.setGid("-1000");
                                imMessageCenterPojo2.setCustomGroupType(-8);
                                imMessageCenterPojo2.setIs_hidden(1);
                            }
                            if (customType == 2 && imMessageCenterPojo == null && hasStranger(groupMsgData) && (imMessageCenterPojo = com.baidu.tieba.im.db.k.a().b("-1001", -7)) == null) {
                                imMessageCenterPojo = new ImMessageCenterPojo();
                                imMessageCenterPojo.setGid("-1001");
                                imMessageCenterPojo.setCustomGroupType(-7);
                                imMessageCenterPojo.setIs_hidden(1);
                            }
                            if (groupMsgData.getCmd() == 2013005) {
                                com.baidu.tieba.im.chat.receiveChatMsgHandler.d.a(groupMsgData, b, new k(this));
                            } else if (groupMsgData.getCmd() == 2013000) {
                                com.baidu.tieba.im.chat.receiveChatMsgHandler.o.a(groupMsgData);
                            } else if (groupMsgData.getCmd() == 2013001) {
                                com.baidu.tieba.im.chat.receiveChatMsgHandler.l.a(groupMsgData, b, new l(this, imMessageCenterPojo));
                            } else if (groupMsgData.getCmd() == 2013003) {
                                com.baidu.tieba.im.chat.receiveChatMsgHandler.j.a(groupMsgData, b, new m(this, imMessageCenterPojo2));
                            } else if (groupMsgData.getCmd() == 2013004) {
                                com.baidu.tieba.im.chat.receiveChatMsgHandler.h.a(groupMsgData, b, new n(this));
                            } else if (groupMsgData.getCmd() == 2013006) {
                                if (groupMsgData.getGroupInfo().getGroupId() == 10) {
                                    com.baidu.tieba.im.chat.receiveChatMsgHandler.q.a(groupMsgData, b, new o(this));
                                } else {
                                    long[] a = com.baidu.tieba.im.chat.receiveChatMsgHandler.q.a().a(groupMsgData);
                                    if (a != null) {
                                        com.baidu.tieba.im.chat.receiveChatMsgHandler.q.a().a(String.valueOf(a[0]), bu.c(a[1]));
                                    }
                                }
                            } else if (groupMsgData.getCmd() == 2013007) {
                                com.baidu.tieba.im.chat.receiveChatMsgHandler.d.a(groupMsgData, b, new p(this));
                            }
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.a().c();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        int size;
        long longValue;
        long longValue2;
        VoiceMsgData h;
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
                if (obtainGroupData.getCmd() != 2013001) {
                    getGroupMsg().add(obtainGroupData);
                }
                LinkedList<ChatMessage> linkedList = new LinkedList<>();
                obtainGroupData.setListMessageData(linkedList);
                List<MsgInfo> list = groupMsg.msgList;
                if (list != null && (size = list.size()) > 0) {
                    for (int i3 = 0; i3 < size; i3++) {
                        try {
                            MsgInfo msgInfo = list.get(i3);
                            ChatMessage obtainMessage = obtainMessage(groupInfo, msgInfo);
                            long b = bu.b(msgInfo.msgId.longValue());
                            obtainMessage.setMsgId(b);
                            obtainMessage.setGroupId(String.valueOf(msgInfo.groupId));
                            obtainMessage.setMsgType(msgInfo.msgType.intValue());
                            long longValue3 = msgInfo.userId.longValue();
                            obtainMessage.setUserId(longValue3);
                            if (TbadkApplication.isLogin() && String.valueOf(longValue3).equals(TbadkApplication.getCurrentAccount())) {
                                obtainMessage.setRecordId(msgInfo.recordId.longValue());
                            } else {
                                obtainMessage.setRecordId(b);
                            }
                            UserData userData = new UserData();
                            obtainMessage.setUserInfo(userData);
                            UserInfo userInfo = msgInfo.userInfo;
                            if (userInfo != null) {
                                List<TshowInfo> list2 = userInfo.tshowIcon;
                                if (list2 != null) {
                                    LinkedList<IconData> linkedList2 = new LinkedList<>();
                                    for (int i4 = 0; i4 < list2.size(); i4++) {
                                        TshowInfo tshowInfo = list2.get(i4);
                                        linkedList2.add(new IconData(tshowInfo.icon, tshowInfo.name, tshowInfo.url));
                                    }
                                    userData.setTShowInfo(linkedList2);
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
                            if (msgInfo.msgType.intValue() == 3 && (h = com.baidu.tieba.im.d.j.h(obtainMessage)) != null) {
                                if (com.baidu.tieba.im.d.j.e(obtainMessage)) {
                                    h.setHas_read(1);
                                } else {
                                    h.setHas_read(0);
                                }
                                obtainMessage.setContent("[" + new Gson().toJson(h) + "]");
                            }
                            obtainMessage.setTime(msgInfo.createTime.intValue());
                            obtainMessage.setIsFriend(msgInfo.isFriend.intValue());
                            obtainMessage.setLink(msgInfo.link);
                            obtainMessage.setStat(msgInfo.stat);
                            obtainMessage.setTaskId(msgInfo.taskId.longValue());
                            linkedList.add(obtainMessage);
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
                                if (com.baidu.adp.lib.e.c.a(TbadkApplication.getCurrentAccount(), 0L) != msgInfo.userId.longValue()) {
                                    longValue2 = msgInfo.userId.longValue();
                                } else {
                                    longValue2 = msgInfo.toUid.longValue();
                                }
                                if (longValue2 != 0) {
                                    if (hashMap2.get(String.valueOf(longValue2)) == null) {
                                        GroupMsgData groupMsgData = new GroupMsgData(2013003);
                                        groupMsgData.getGroupInfo().setCustomType(4);
                                        groupMsgData.getGroupInfo().setGroupId((int) longValue2);
                                        getGroupMsg().add(groupMsgData);
                                        groupMsgData.setListMessageData(new LinkedList<>());
                                        hashMap2.put(String.valueOf(longValue2), groupMsgData);
                                    }
                                    ((GroupMsgData) hashMap2.get(String.valueOf(longValue2))).getListMessage().add(obtainMessage);
                                }
                            } else if (obtainMessage instanceof PersonalChatMessage) {
                                if (com.baidu.adp.lib.e.c.a(TbadkApplication.getCurrentAccount(), 0L) != msgInfo.userId.longValue()) {
                                    longValue = msgInfo.userId.longValue();
                                } else {
                                    longValue = msgInfo.toUid.longValue();
                                }
                                if (longValue != 0) {
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
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
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
                groupMsgData = new GroupMsgData(2013001);
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
                if (com.baidu.adp.lib.e.c.a(TbadkApplication.getCurrentAccount(), 0L) != msgInfo.userId.longValue()) {
                    intValue = msgInfo.userInfo.userType.intValue();
                } else {
                    intValue = msgInfo.toUserInfo.userType.intValue();
                }
                if (intValue == 1) {
                    return new OfficialChatMessage();
                }
                return new PersonalChatMessage();
            case 7:
                return new SnapChatMessage();
            case 8:
                return new NotifyChatMessage();
            case 9:
            case 13:
            case DealIntentService.CLASS_TYPE_GROUP_EVENT /* 14 */:
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
