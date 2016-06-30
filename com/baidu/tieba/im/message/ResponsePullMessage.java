package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.b;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.j;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.n;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.p;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.i;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.GroupChatMessage;
import com.baidu.tieba.im.message.chat.NotifyChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.message.chat.SnapChatMessage;
import com.baidu.tieba.im.message.chat.SystemMessage;
import com.baidu.tieba.im.message.chat.YYMessage;
import com.baidu.tieba.im.push.a;
import com.baidu.tieba.im.util.MessageUtils;
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

    public ResponsePullMessage(int i) {
        super(i);
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

    protected boolean isPulledMessage() {
        return true;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:171:0x002b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:172:0x002b */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.baidu.tieba.im.message.ResponsePullMessage] */
    /* JADX WARN: Type inference failed for: r1v59, types: [com.baidu.tieba.im.chat.receiveChatMsgHandler.p] */
    /* JADX WARN: Type inference failed for: r2v11, types: [com.baidu.tieba.im.data.GroupMsgData] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v17, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v20, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v22, types: [com.baidu.tieba.im.chat.receiveChatMsgHandler.p] */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        int i2;
        LinkedList<ChatMessage> listMessage;
        List<GroupMsgData> groupMsg = getGroupMsg();
        if (groupMsg != null && groupMsg.size() != 0) {
            for (GroupMsgData groupMsgData : groupMsg) {
                if (groupMsgData.getGroupInfo() != null && groupMsgData.getGroupInfo().getCustomType() == 4 && (listMessage = groupMsgData.getListMessage()) != null && listMessage.size() != 0 && listMessage.get(0).getSid() > 0) {
                    a.aqj().a(groupMsgData, isPulledMessage());
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i3 = 0;
            try {
                try {
                    com.baidu.tieba.im.db.g.amK().amL();
                    ImMessageCenterPojo imMessageCenterPojo = null;
                    Iterator<GroupMsgData> it = groupMsg.iterator();
                    ImMessageCenterPojo imMessageCenterPojo2 = null;
                    i2 = 0;
                    while (it.hasNext()) {
                        try {
                            i3 = it.next();
                            if (i3 != 0 && i3.getListMessage() != null) {
                                i2 += i3.getListMessage().size();
                                String valueOf = String.valueOf(i3.getGroupInfo().getGroupId());
                                int customType = i3.getGroupInfo().getCustomType();
                                int userType = i3.getGroupInfo().getUserType();
                                ImMessageCenterPojo ad = i.amO().ad(valueOf, customType);
                                if (ad != null) {
                                    ad.setUserType(userType);
                                }
                                if (customType == 4 && imMessageCenterPojo == null) {
                                    ImMessageCenterPojo ad2 = i.amO().ad("-1000", -8);
                                    if (ad2 == null) {
                                        ImMessageCenterPojo imMessageCenterPojo3 = new ImMessageCenterPojo();
                                        imMessageCenterPojo3.setGid("-1000");
                                        imMessageCenterPojo3.setCustomGroupType(-8);
                                        imMessageCenterPojo3.setIs_hidden(1);
                                        imMessageCenterPojo = imMessageCenterPojo3;
                                    } else {
                                        imMessageCenterPojo = ad2;
                                    }
                                }
                                if (customType == 2 && imMessageCenterPojo2 == null && hasStranger(i3) && (imMessageCenterPojo2 = i.amO().ad("-1001", -7)) == null) {
                                    imMessageCenterPojo2 = new ImMessageCenterPojo();
                                    imMessageCenterPojo2.setGid("-1001");
                                    imMessageCenterPojo2.setCustomGroupType(-7);
                                    imMessageCenterPojo2.setIs_hidden(1);
                                }
                                if (i3.getCmd() == 2013006) {
                                    b.a(i3, ad, new c(this));
                                } else if (i3.getCmd() == 2013001) {
                                    n.a(i3);
                                } else if (i3.getCmd() == 2013002) {
                                    j.b(i3, ad, new d(this, imMessageCenterPojo2));
                                } else if (i3.getCmd() == 2013004) {
                                    com.baidu.tieba.im.chat.receiveChatMsgHandler.h.b(i3, ad, new e(this, imMessageCenterPojo));
                                } else if (i3.getCmd() == 2013009) {
                                    if (i3.getListMessage() != null && i3.getListMessage().size() != 0) {
                                        ChatMessage chatMessage = i3.getListMessage().get(0);
                                        ImMessageCenterPojo imMessageCenterPojo4 = new ImMessageCenterPojo();
                                        imMessageCenterPojo4.setGid(String.valueOf(com.baidu.tieba.im.c.a.cVO));
                                        imMessageCenterPojo4.setCustomGroupType(-1);
                                        imMessageCenterPojo4.setIs_hidden(1);
                                        imMessageCenterPojo4.setPulled_msgId(chatMessage.getMsgId());
                                        i.amO().c(imMessageCenterPojo4);
                                        i3 = new StringBuilder("pullMessage insertMessagecent personal_Group gid = ").append(com.baidu.tieba.im.c.a.cVO).append(" msgid = ");
                                        BdLog.i(i3.append(chatMessage.getMsgId()).toString());
                                    }
                                } else if (i3.getCmd() == 2013010) {
                                    if (i3.getListMessage() != null && i3.getListMessage().size() != 0) {
                                        ChatMessage chatMessage2 = i3.getListMessage().get(0);
                                        ImMessageCenterPojo imMessageCenterPojo5 = new ImMessageCenterPojo();
                                        imMessageCenterPojo5.setGid(String.valueOf(i3.getGroupInfo().getGroupId()));
                                        imMessageCenterPojo5.setCustomGroupType(-9);
                                        imMessageCenterPojo5.setIs_hidden(1);
                                        imMessageCenterPojo5.setPulled_msgId(chatMessage2.getMsgId());
                                        if (chatMessage2.getSid() <= 0) {
                                            if (isPulledMessage()) {
                                                imMessageCenterPojo5.setPushIds("");
                                                com.baidu.tieba.im.push.f.aql().aqo();
                                            } else if (chatMessage2.getUserInfo() != null && chatMessage2.getUserInfo().getUserType() == 4) {
                                                Long aqm = com.baidu.tieba.im.push.f.aql().aqm();
                                                if (aqm != null && aqm.longValue() != 0) {
                                                    imMessageCenterPojo5.setPulled_msgId(0L);
                                                    imMessageCenterPojo5.setPushIds(com.baidu.tieba.im.push.f.aql().aqq());
                                                } else {
                                                    imMessageCenterPojo5.setPushIds("");
                                                }
                                            }
                                            i.amO().a(imMessageCenterPojo5, 1, 2);
                                        }
                                        i3 = new StringBuilder("pullMessage insertMessagecent offical_Group gid = ").append(i3.getGroupInfo().getGroupId()).append(" msgid = ");
                                        BdLog.i(i3.append(chatMessage2.getMsgId()).toString());
                                    }
                                } else if (i3.getCmd() == 2013005) {
                                    com.baidu.tieba.im.chat.receiveChatMsgHandler.f.a(i3, ad, new f(this));
                                } else if (i3.getCmd() == 2013007) {
                                    if (i3.getGroupInfo().getGroupId() == 10) {
                                        p.a(i3, ad, new g(this));
                                    } else {
                                        long[] b = p.alc().b(i3);
                                        if (b != null) {
                                            long bN = com.baidu.tieba.im.util.g.bN(b[1]);
                                            i3 = p.alc();
                                            i3.l(String.valueOf(b[0]), bN);
                                        }
                                    }
                                } else if (i3.getCmd() == 2013008) {
                                    b.a(i3, ad, new h(this));
                                }
                            }
                        } catch (Exception e) {
                            e = e;
                            i3 = i2;
                            BdLog.e(e.getMessage());
                            com.baidu.tieba.im.db.g.amK().endTransaction();
                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.tbadk.performanceLog.p pVar = new com.baidu.tbadk.performanceLog.p();
                            pVar.aya = getCmd();
                            if (this.performanceData != null) {
                                pVar.kW = this.performanceData.gz;
                                pVar.wh = getDownSize();
                                pVar.ayb = currentTimeMillis2;
                                pVar.ayc = i3;
                                pVar.xM = this.performanceData.gw;
                                i3 = 1002;
                                pVar.eQ(1002);
                                pVar.EN();
                            }
                        } catch (Throwable th) {
                            th = th;
                            com.baidu.tieba.im.db.g.amK().endTransaction();
                            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.tbadk.performanceLog.p pVar2 = new com.baidu.tbadk.performanceLog.p();
                            pVar2.aya = getCmd();
                            if (this.performanceData != null) {
                                pVar2.kW = this.performanceData.gz;
                                pVar2.wh = getDownSize();
                                pVar2.ayb = currentTimeMillis3;
                                pVar2.ayc = i2;
                                pVar2.xM = this.performanceData.gw;
                                pVar2.eQ(1002);
                                pVar2.EN();
                            }
                            throw th;
                        }
                    }
                    com.baidu.tieba.im.db.g.amK().endTransaction();
                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.tbadk.performanceLog.p pVar3 = new com.baidu.tbadk.performanceLog.p();
                    pVar3.aya = getCmd();
                    if (this.performanceData != null) {
                        pVar3.kW = this.performanceData.gz;
                        pVar3.wh = getDownSize();
                        pVar3.ayb = currentTimeMillis4;
                        pVar3.ayc = i2;
                        pVar3.xM = this.performanceData.gw;
                        pVar3.eQ(1002);
                        pVar3.EN();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    i2 = i3;
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        GroupInfo groupInfo;
        int size;
        ChatMessage obtainMessage;
        long longValue;
        long longValue2;
        VoiceMsgData w;
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
                if (groupMsg != null && (groupInfo = groupMsg.groupInfo) != null) {
                    GroupMsgData obtainGroupData = obtainGroupData(groupInfo);
                    if (obtainGroupData == null) {
                        BdLog.e("obtainGroupData == null !!!!");
                    } else if (TbadkCoreApplication.m9getInst().getCustomizedFilter() == null || TbadkCoreApplication.m9getInst().getCustomizedFilter().bj(obtainGroupData.getGroupInfo().getCustomType())) {
                        getGroupMsg().add(obtainGroupData);
                        LinkedList<ChatMessage> linkedList = new LinkedList<>();
                        obtainGroupData.setListMessageData(linkedList);
                        obtainGroupData.setHasMore(groupMsg.hasMore.intValue() != 0);
                        List<MsgInfo> list = groupMsg.msgList;
                        if (list != null && (size = list.size()) > 0) {
                            for (int i3 = 0; i3 < size; i3++) {
                                try {
                                    MsgInfo msgInfo = list.get(i3);
                                    if (msgInfo != null && (obtainMessage = obtainMessage(groupInfo, msgInfo)) != null) {
                                        long bM = com.baidu.tieba.im.util.g.bM(msgInfo.msgId.longValue());
                                        obtainMessage.setMsgId(bM);
                                        obtainMessage.setGroupId(String.valueOf(msgInfo.groupId));
                                        obtainMessage.setMsgType(msgInfo.msgType.intValue());
                                        long longValue3 = msgInfo.userId.longValue();
                                        obtainMessage.setUserId(longValue3);
                                        if (TbadkCoreApplication.isLogin() && String.valueOf(longValue3).equals(TbadkCoreApplication.getCurrentAccount())) {
                                            obtainMessage.setRecordId(msgInfo.recordId.longValue());
                                        } else {
                                            obtainMessage.setRecordId(bM);
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
                                        BdLog.i("pullMessage content" + msgInfo.content);
                                        if (msgInfo.msgType.intValue() == 3 && (w = com.baidu.tieba.im.util.h.w(obtainMessage)) != null) {
                                            if (com.baidu.tieba.im.util.h.t(obtainMessage)) {
                                                w.setHas_read(1);
                                            } else {
                                                w.setHas_read(0);
                                            }
                                            obtainMessage.setContent("[" + com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(w) + "]");
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
                                                    int optInt = jSONArray.optInt(1);
                                                    if (1 != optInt && 4 != optInt) {
                                                        obtainMessage.setMsgType(1);
                                                        obtainMessage.setContent(optString);
                                                    }
                                                }
                                            } catch (Exception e) {
                                                BdLog.e(e);
                                            }
                                        }
                                        if (obtainMessage instanceof OfficialChatMessage) {
                                            long c = com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                                            if (c != msgInfo.userId.longValue()) {
                                                longValue2 = msgInfo.userId.longValue();
                                            } else {
                                                longValue2 = msgInfo.toUid.longValue();
                                            }
                                            int i5 = 1;
                                            if (msgInfo != null && msgInfo.userInfo != null) {
                                                i5 = c != msgInfo.userId.longValue() ? msgInfo.userInfo.userType.intValue() : msgInfo.toUserInfo.userType.intValue();
                                            }
                                            if (longValue2 != 0) {
                                                if (linkedList.size() == 0) {
                                                    linkedList.add(obtainMessage);
                                                } else if (linkedList.get(0).getMsgId() < obtainMessage.getMsgId()) {
                                                    linkedList.remove(0);
                                                    linkedList.add(obtainMessage);
                                                }
                                                if (i5 == 4 && com.baidu.tieba.im.push.f.aql().bJ(obtainMessage.getMsgId())) {
                                                    BdLog.i("msg is contained in PushIdsCacheManager");
                                                } else if (obtainMessage.getMsgType() == 99) {
                                                    BdLog.i("msg is MSG_UNSHOW_OPERATER_ACCOUNT");
                                                } else if (TbadkCoreApplication.m9getInst().getCustomizedFilter() == null || TbadkCoreApplication.m9getInst().getCustomizedFilter().bj(4)) {
                                                    if (hashMap2.get(String.valueOf(longValue2)) == null) {
                                                        GroupMsgData groupMsgData = new GroupMsgData(CmdConfigCustom.MESSAGE_LIST_OFFICIAL_CMD);
                                                        groupMsgData.getGroupInfo().setUserType(i5);
                                                        groupMsgData.getGroupInfo().setCustomType(4);
                                                        groupMsgData.getGroupInfo().setGroupId(longValue2);
                                                        getGroupMsg().add(groupMsgData);
                                                        groupMsgData.setListMessageData(new LinkedList<>());
                                                        hashMap2.put(String.valueOf(longValue2), groupMsgData);
                                                    }
                                                    ((GroupMsgData) hashMap2.get(String.valueOf(longValue2))).getListMessage().add(obtainMessage);
                                                }
                                            }
                                        } else if (obtainMessage instanceof PersonalChatMessage) {
                                            if (com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L) != msgInfo.userId.longValue()) {
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
                                                if (TbadkCoreApplication.m9getInst().getCustomizedFilter() == null || TbadkCoreApplication.m9getInst().getCustomizedFilter().bj(2)) {
                                                    if (hashMap.get(String.valueOf(longValue)) == null) {
                                                        GroupMsgData groupMsgData2 = new GroupMsgData(CmdConfigCustom.MESSAGE_LIST_PERSONAL_CMD);
                                                        groupMsgData2.getGroupInfo().setCustomType(2);
                                                        groupMsgData2.getGroupInfo().setGroupId(longValue);
                                                        getGroupMsg().add(groupMsgData2);
                                                        groupMsgData2.setListMessageData(new LinkedList<>());
                                                        hashMap.put(String.valueOf(longValue), groupMsgData2);
                                                    }
                                                    ((GroupMsgData) hashMap.get(String.valueOf(longValue))).getListMessage().add(obtainMessage);
                                                }
                                            }
                                        } else {
                                            linkedList.add(obtainMessage);
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
            if (getGroupMsgResIdl.data.userMsg != null) {
                MessageUtils.generatePushData(getGroupMsg(), 30, getGroupMsgResIdl.data.userMsg.msgs, null);
            }
        }
    }

    private GroupMsgData obtainGroupData(GroupInfo groupInfo) {
        GroupMsgData groupMsgData = null;
        switch (groupInfo.groupType.intValue()) {
            case 1:
                groupMsgData = new GroupMsgData(CmdConfigCustom.MESSAGE_LIST_SYSTEM_CMD);
                groupMsgData.getGroupInfo().setCustomType(-2);
                break;
            case 2:
            case 3:
            case 4:
            case 5:
                groupMsgData = new GroupMsgData(CmdConfigCustom.MESSAGE_LIST_GROUP_CMD);
                groupMsgData.getGroupInfo().setCustomType(1);
                break;
            case 6:
                BdLog.i("pullMessage groupType = 6");
                groupMsgData = new GroupMsgData(CmdConfigCustom.MESSAGE_LIST_PERSONAL_GROUP_CMD);
                groupMsgData.getGroupInfo().setCustomType(-1);
                break;
            case 7:
                groupMsgData = new GroupMsgData(CmdConfigCustom.MESSAGE_LIST_SNAP_CMD);
                groupMsgData.getGroupInfo().setCustomType(3);
                break;
            case 8:
                groupMsgData = new GroupMsgData(CmdConfigCustom.MESSAGE_LIST_NOTIFY_CMD);
                groupMsgData.getGroupInfo().setCustomType(5);
                break;
            case 10:
                groupMsgData = new GroupMsgData(CmdConfigCustom.MESSAGE_LIST_YY_CMD);
                groupMsgData.getGroupInfo().setCustomType(6);
                break;
            case 11:
                groupMsgData = new GroupMsgData(CmdConfigCustom.MESSAGE_LIST_YY_CMD);
                groupMsgData.getGroupInfo().setCustomType(7);
                break;
            case 12:
                groupMsgData = new GroupMsgData(CmdConfigCustom.MESSAGE_LIST_YY_CMD);
                groupMsgData.getGroupInfo().setCustomType(8);
                break;
            case 21:
                groupMsgData = new GroupMsgData(CmdConfigCustom.MESSAGE_LIST_LIVE_CMD);
                groupMsgData.getGroupInfo().setCustomType(9);
                break;
            case 30:
                BdLog.i("pullMessage groupType = 30");
                groupMsgData = new GroupMsgData(CmdConfigCustom.MESSAGE_LIST_OFFICIAL_GROUP_CMD);
                groupMsgData.getGroupInfo().setCustomType(-9);
                break;
        }
        if (groupMsgData != null) {
            groupMsgData.getGroupInfo().setGroupId(groupInfo.groupId.intValue());
            groupMsgData.getGroupInfo().setGroupType(groupInfo.groupType.intValue());
            BdLog.i("pullMessage groupid" + groupInfo.groupId);
        }
        return groupMsgData;
    }

    private ChatMessage obtainMessage(GroupInfo groupInfo, MsgInfo msgInfo) {
        switch (groupInfo.groupType.intValue()) {
            case 1:
                return new SystemMessage();
            case 2:
            case 3:
            case 4:
            case 5:
                return new GroupChatMessage();
            case 6:
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
            case 22:
            case 23:
            case 24:
            case 25:
            case TbConfig.NOTIFY_FANS_NEW_ID /* 26 */:
            case 27:
            case 28:
            case 29:
            default:
                return null;
            case 10:
            case 11:
            case 12:
                return new YYMessage();
            case 21:
                return new GroupChatMessage();
            case 30:
                return new OfficialChatMessage();
        }
    }
}
