package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.im.chat.bw;
import com.baidu.tieba.im.data.GroupIdTypeData;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.e.r;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.GroupChatMessage;
import com.baidu.tieba.im.message.chat.NotifyChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.message.chat.SnapChatMessage;
import com.baidu.tieba.im.message.chat.SystemMessage;
import com.baidu.tieba.im.message.chat.YYMessage;
import com.squareup.wire.Wire;
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
    private int allowEggs;
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

    public int getAllowEggs() {
        return this.allowEggs;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        List<GroupMsgData> groupMsg = getGroupMsg();
        if (groupMsg != null) {
            for (GroupMsgData groupMsgData : groupMsg) {
                if (groupMsgData.getListMessage() != null) {
                    Iterator<ChatMessage> it = groupMsgData.getListMessage().iterator();
                    while (it.hasNext()) {
                        it.next().getBornTime();
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        int size;
        GetGroupMsgResIdl getGroupMsgResIdl = (GetGroupMsgResIdl) new Wire(new Class[0]).parseFrom(bArr, GetGroupMsgResIdl.class);
        setError(getGroupMsgResIdl.error.errorno.intValue());
        setErrorString(getGroupMsgResIdl.error.usermsg);
        if (getError() == 0 && getGroupMsgResIdl.data != null) {
            this.allowEggs = getGroupMsgResIdl.data.allowEggs.intValue();
            setGroupMsg(new LinkedList());
            int size2 = getGroupMsgResIdl.data.groupMsg == null ? 0 : getGroupMsgResIdl.data.groupMsg.size();
            for (int i2 = 0; i2 < size2; i2++) {
                GroupMsg groupMsg = getGroupMsgResIdl.data.groupMsg.get(i2);
                GroupInfo groupInfo = groupMsg.groupInfo;
                GroupMsgData obtainGroupData = obtainGroupData(groupInfo);
                getGroupMsg().add(obtainGroupData);
                LinkedList<ChatMessage> linkedList = new LinkedList<>();
                obtainGroupData.setListMessageData(linkedList);
                GroupIdTypeData groupIdTypeData = new GroupIdTypeData();
                obtainGroupData.setGroupInfo(groupIdTypeData);
                groupIdTypeData.setGroupId(groupInfo.groupId.intValue());
                groupIdTypeData.setGroupType(groupInfo.groupType.intValue());
                List<MsgInfo> list = groupMsg.msgList;
                if (list != null && (size = list.size()) > 0) {
                    for (int i3 = 0; i3 < size; i3++) {
                        try {
                            MsgInfo msgInfo = list.get(i3);
                            ChatMessage obtainMessage = obtainMessage(groupInfo, msgInfo);
                            long b = bw.b(msgInfo.msgId.longValue());
                            obtainMessage.setMsgId(b);
                            obtainMessage.setGroupId(String.valueOf(msgInfo.groupId));
                            obtainMessage.setMsgType(msgInfo.msgType.intValue());
                            long longValue = msgInfo.userId.longValue();
                            obtainMessage.setUserId(longValue);
                            if (TbadkApplication.isLogin() && String.valueOf(longValue).equals(TbadkApplication.getCurrentAccount())) {
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
                                    int i4 = 0;
                                    while (true) {
                                        int i5 = i4;
                                        if (i5 >= list2.size()) {
                                            break;
                                        }
                                        TshowInfo tshowInfo = list2.get(i5);
                                        linkedList2.add(new IconData(tshowInfo.icon, tshowInfo.name, tshowInfo.url));
                                        i4 = i5 + 1;
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
                            obtainMessage.setTime(msgInfo.createTime.intValue());
                            obtainMessage.setIsFriend(msgInfo.isFriend.intValue());
                            obtainMessage.setLink(msgInfo.link);
                            obtainMessage.setStat(msgInfo.stat);
                            obtainMessage.setTaskId(msgInfo.taskId.longValue());
                            linkedList.add(obtainMessage);
                            r.g(obtainMessage);
                            if (obtainMessage.getMsgType() == 9 && obtainMessage.getContent() != null) {
                                JSONArray jSONArray = new JSONArray(obtainMessage.getContent());
                                if (jSONArray.length() >= 2) {
                                    String optString = jSONArray.optString(0);
                                    if (1 != jSONArray.optInt(1)) {
                                        obtainMessage.setMsgType(1);
                                        obtainMessage.setContent(optString);
                                    }
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private GroupMsgData obtainGroupData(GroupInfo groupInfo) {
        switch (groupInfo.groupType.intValue()) {
            case 1:
                return new GroupMsgData(2013000);
            case 2:
            case 3:
            case 4:
            case 5:
                return new GroupMsgData(2013005);
            case 6:
                return new GroupMsgData(2013001);
            case 7:
                return new GroupMsgData(2013002);
            case 8:
                return new GroupMsgData(2013004);
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
                return new GroupMsgData(2013006);
            case 21:
                return new GroupMsgData(2013007);
        }
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
                if (com.baidu.adp.lib.f.b.a(TbadkApplication.getCurrentAccount(), 0L) != msgInfo.userId.longValue()) {
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
