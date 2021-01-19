package com.baidu.tieba.im.message;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.im.chat.b.a;
import com.baidu.tieba.im.chat.b.d;
import com.baidu.tieba.im.chat.b.e;
import com.baidu.tieba.im.chat.b.f;
import com.baidu.tieba.im.chat.b.g;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.c;
import com.baidu.tieba.im.db.h;
import com.baidu.tieba.im.db.j;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.db.m;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.GroupChatMessage;
import com.baidu.tieba.im.message.chat.NotifyChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.message.chat.SystemMessage;
import com.baidu.tieba.im.message.chat.YYMessage;
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
        super(CmdConfigSocket.CMD_MESSAGE_SYNC);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [378=4] */
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        int i2;
        LinkedList<ChatMessage> listMessage;
        List<GroupMsgData> groupMsg = getGroupMsg();
        if (groupMsg == null || groupMsg.size() == 0) {
            return;
        }
        for (GroupMsgData groupMsgData : groupMsg) {
            if (groupMsgData.getGroupInfo() != null && groupMsgData.getGroupInfo().getCustomType() == 4 && (listMessage = groupMsgData.getListMessage()) != null && listMessage.size() != 0 && listMessage.get(0).getSid() > 0) {
                com.baidu.tieba.im.push.a.cVs().a(groupMsgData, isPulledMessage());
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        int i3 = 0;
        try {
            try {
                h.cTB().cTC();
                final ImMessageCenterPojo imMessageCenterPojo = null;
                final ImMessageCenterPojo imMessageCenterPojo2 = null;
                for (GroupMsgData groupMsgData2 : groupMsg) {
                    if (groupMsgData2 != null && groupMsgData2.getListMessage() != null) {
                        i2 = groupMsgData2.getListMessage().size() + i3;
                        try {
                            String valueOf = String.valueOf(groupMsgData2.getGroupInfo().getGroupId());
                            int customType = groupMsgData2.getGroupInfo().getCustomType();
                            int userType = groupMsgData2.getGroupInfo().getUserType();
                            ImMessageCenterPojo bp = j.cTF().bp(valueOf, customType);
                            if (bp != null) {
                                bp.setUserType(userType);
                            }
                            if (customType == 4 && imMessageCenterPojo == null) {
                                ImMessageCenterPojo bp2 = j.cTF().bp(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8);
                                if (bp2 == null) {
                                    ImMessageCenterPojo imMessageCenterPojo3 = new ImMessageCenterPojo();
                                    imMessageCenterPojo3.setGid(TbEnum.CustomGroupId.OFFICIAL_MERGE);
                                    imMessageCenterPojo3.setCustomGroupType(-8);
                                    imMessageCenterPojo3.setIs_hidden(1);
                                    imMessageCenterPojo = imMessageCenterPojo3;
                                } else {
                                    imMessageCenterPojo = bp2;
                                }
                            }
                            if (customType == 2 && imMessageCenterPojo2 == null && hasStranger(groupMsgData2) && (imMessageCenterPojo2 = j.cTF().bp(TbEnum.CustomGroupId.STRANGE_MERGE, -7)) == null) {
                                imMessageCenterPojo2 = new ImMessageCenterPojo();
                                imMessageCenterPojo2.setGid(TbEnum.CustomGroupId.STRANGE_MERGE);
                                imMessageCenterPojo2.setCustomGroupType(-7);
                                imMessageCenterPojo2.setIs_hidden(1);
                            }
                            if (groupMsgData2.getCmd() == 2012125) {
                                com.baidu.tieba.im.chat.b.b.a(groupMsgData2, bp, new a.b() { // from class: com.baidu.tieba.im.message.ResponsePullMessage.1
                                    @Override // com.baidu.tieba.im.chat.b.a.b
                                    public void a(ImMessageCenterPojo imMessageCenterPojo4, int i4, boolean z) {
                                        if (imMessageCenterPojo4 != null) {
                                            j.cTF().a(imMessageCenterPojo4, 2);
                                        }
                                    }

                                    @Override // com.baidu.tieba.im.chat.b.a.b
                                    public void k(String str, List<CommonMsgPojo> list) {
                                        c.cTu().c(str, list, true);
                                    }
                                });
                            } else if (groupMsgData2.getCmd() == 2012120) {
                                f.a(groupMsgData2);
                            } else if (groupMsgData2.getCmd() == 2012121) {
                                e.b(groupMsgData2, bp, new a.b() { // from class: com.baidu.tieba.im.message.ResponsePullMessage.2
                                    @Override // com.baidu.tieba.im.chat.b.a.b
                                    public void a(ImMessageCenterPojo imMessageCenterPojo4, int i4, boolean z) {
                                        int i5 = 2;
                                        if (imMessageCenterPojo4 != null) {
                                            j.cTF().a(imMessageCenterPojo4, 2);
                                            if (imMessageCenterPojo4.getIsFriend() == 0 && imMessageCenterPojo2 != null) {
                                                imMessageCenterPojo2.setGid(String.valueOf(TbEnum.CustomGroupId.STRANGE_MERGE));
                                                imMessageCenterPojo2.setCustomGroupType(-7);
                                                if (i4 == 0) {
                                                    imMessageCenterPojo2.setUnread_count(0);
                                                } else if (i4 == 1) {
                                                    imMessageCenterPojo2.setUnread_count(1);
                                                } else {
                                                    i5 = 1;
                                                }
                                                if (z) {
                                                    imMessageCenterPojo2.setIs_hidden(0);
                                                }
                                                j.cTF().a(imMessageCenterPojo2, i5);
                                            }
                                        }
                                    }

                                    @Override // com.baidu.tieba.im.chat.b.a.b
                                    public void k(String str, List<CommonMsgPojo> list) {
                                        m.cTO().a(com.baidu.adp.lib.f.b.toLong(str, 0L), list, true);
                                    }
                                });
                            } else if (groupMsgData2.getCmd() == 2012123) {
                                d.b(groupMsgData2, bp, new a.b() { // from class: com.baidu.tieba.im.message.ResponsePullMessage.3
                                    @Override // com.baidu.tieba.im.chat.b.a.b
                                    public void a(ImMessageCenterPojo imMessageCenterPojo4, int i4, boolean z) {
                                        int i5 = 2;
                                        if (imMessageCenterPojo4 != null) {
                                            j.cTF().a(imMessageCenterPojo4, 2);
                                            int userType2 = imMessageCenterPojo4.getUserType();
                                            if (imMessageCenterPojo != null) {
                                                if (userType2 == 1 || userType2 == 3) {
                                                    imMessageCenterPojo.setGid(String.valueOf(TbEnum.CustomGroupId.OFFICIAL_MERGE));
                                                    imMessageCenterPojo.setCustomGroupType(-8);
                                                    if (i4 == 0) {
                                                        imMessageCenterPojo.setUnread_count(0);
                                                    } else if (i4 == 1) {
                                                        imMessageCenterPojo.setUnread_count(1);
                                                    } else {
                                                        i5 = 1;
                                                    }
                                                    if (z) {
                                                        imMessageCenterPojo.setIs_hidden(0);
                                                    }
                                                    j.cTF().a(imMessageCenterPojo, i5);
                                                }
                                            }
                                        }
                                    }

                                    @Override // com.baidu.tieba.im.chat.b.a.b
                                    public void k(String str, List<CommonMsgPojo> list) {
                                        l.cTL().a(com.baidu.adp.lib.f.b.toLong(str, 0L), list, true);
                                    }
                                });
                            } else if (groupMsgData2.getCmd() == 2012128) {
                                if (groupMsgData2.getListMessage() == null) {
                                    i3 = i2;
                                } else if (groupMsgData2.getListMessage().size() == 0) {
                                    i3 = i2;
                                } else {
                                    ChatMessage chatMessage = groupMsgData2.getListMessage().get(0);
                                    ImMessageCenterPojo imMessageCenterPojo4 = new ImMessageCenterPojo();
                                    imMessageCenterPojo4.setGid(String.valueOf(com.baidu.tieba.im.sendmessage.a.kDv));
                                    imMessageCenterPojo4.setCustomGroupType(-1);
                                    imMessageCenterPojo4.setIs_hidden(1);
                                    imMessageCenterPojo4.setPulled_msgId(chatMessage.getMsgId());
                                    j.cTF().d(imMessageCenterPojo4);
                                    BdLog.i("pullMessage insertMessagecent personal_Group gid = " + com.baidu.tieba.im.sendmessage.a.kDv + " msgid = " + chatMessage.getMsgId());
                                }
                            } else if (groupMsgData2.getCmd() == 2012129) {
                                if (groupMsgData2.getListMessage() == null) {
                                    i3 = i2;
                                } else if (groupMsgData2.getListMessage().size() == 0) {
                                    i3 = i2;
                                } else {
                                    ChatMessage chatMessage2 = groupMsgData2.getListMessage().get(0);
                                    ImMessageCenterPojo imMessageCenterPojo5 = new ImMessageCenterPojo();
                                    imMessageCenterPojo5.setGid(String.valueOf(groupMsgData2.getGroupInfo().getGroupId()));
                                    imMessageCenterPojo5.setCustomGroupType(-9);
                                    imMessageCenterPojo5.setIs_hidden(1);
                                    imMessageCenterPojo5.setPulled_msgId(chatMessage2.getMsgId());
                                    if (chatMessage2.getSid() <= 0) {
                                        if (isPulledMessage()) {
                                            imMessageCenterPojo5.setPushIds("");
                                            com.baidu.tieba.im.push.c.cVu().cVx();
                                        } else if (chatMessage2.getUserInfo() != null && chatMessage2.getUserInfo().getUserType() == 4) {
                                            Long cVv = com.baidu.tieba.im.push.c.cVu().cVv();
                                            if (cVv == null || cVv.longValue() == 0) {
                                                imMessageCenterPojo5.setPushIds("");
                                            } else {
                                                imMessageCenterPojo5.setPulled_msgId(0L);
                                                imMessageCenterPojo5.setPushIds(com.baidu.tieba.im.push.c.cVu().cVz());
                                            }
                                        }
                                        j.cTF().a(imMessageCenterPojo5, 1, 2);
                                    }
                                    BdLog.i("pullMessage insertMessagecent offical_Group gid = " + groupMsgData2.getGroupInfo().getGroupId() + " msgid = " + chatMessage2.getMsgId());
                                }
                            } else if (groupMsgData2.getCmd() == 2012124) {
                                com.baidu.tieba.im.chat.b.c.a(groupMsgData2, bp, new a.b() { // from class: com.baidu.tieba.im.message.ResponsePullMessage.4
                                    @Override // com.baidu.tieba.im.chat.b.a.b
                                    public void a(ImMessageCenterPojo imMessageCenterPojo6, int i4, boolean z) {
                                        if (imMessageCenterPojo6 != null) {
                                            imMessageCenterPojo6.setIs_hidden(1);
                                            j.cTF().d(imMessageCenterPojo6);
                                        }
                                    }

                                    @Override // com.baidu.tieba.im.chat.b.a.b
                                    public void k(String str, List<CommonMsgPojo> list) {
                                    }
                                });
                            } else if (groupMsgData2.getCmd() == 2012126) {
                                if (groupMsgData2.getGroupInfo().getGroupId() == 10) {
                                    g.a(groupMsgData2, bp, new a.b() { // from class: com.baidu.tieba.im.message.ResponsePullMessage.5
                                        @Override // com.baidu.tieba.im.chat.b.a.b
                                        public void a(ImMessageCenterPojo imMessageCenterPojo6, int i4, boolean z) {
                                            if (imMessageCenterPojo6 != null) {
                                                imMessageCenterPojo6.setIs_hidden(1);
                                                j.cTF().d(imMessageCenterPojo6);
                                            }
                                        }

                                        @Override // com.baidu.tieba.im.chat.b.a.b
                                        public void k(String str, List<CommonMsgPojo> list) {
                                        }
                                    });
                                } else {
                                    long[] b2 = g.cTj().b(groupMsgData2);
                                    if (b2 != null) {
                                        g.cTj().L(String.valueOf(b2[0]), com.baidu.tieba.im.util.b.gZ(b2[1]));
                                    }
                                }
                            }
                            i3 = i2;
                        } catch (Exception e) {
                            e = e;
                            i3 = i2;
                            BdLog.e(e.getMessage());
                            h.cTB().cTD();
                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.tbadk.n.f fVar = new com.baidu.tbadk.n.f();
                            fVar.fGS = getCmd();
                            if (this.performanceData != null) {
                                fVar.LN = this.performanceData.mCompressTime;
                                fVar.fGT = getDownSize();
                                fVar.fGU = currentTimeMillis2;
                                fVar.fGV = i3;
                                fVar.costTime = this.performanceData.mNetRWTime;
                                fVar.setSubType(1002);
                                fVar.bDJ();
                                return;
                            }
                            return;
                        } catch (Throwable th) {
                            th = th;
                            h.cTB().cTD();
                            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.tbadk.n.f fVar2 = new com.baidu.tbadk.n.f();
                            fVar2.fGS = getCmd();
                            if (this.performanceData != null) {
                                fVar2.LN = this.performanceData.mCompressTime;
                                fVar2.fGT = getDownSize();
                                fVar2.fGU = currentTimeMillis3;
                                fVar2.fGV = i2;
                                fVar2.costTime = this.performanceData.mNetRWTime;
                                fVar2.setSubType(1002);
                                fVar2.bDJ();
                            }
                            throw th;
                        }
                    }
                }
                h.cTB().cTD();
                long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.tbadk.n.f fVar3 = new com.baidu.tbadk.n.f();
                fVar3.fGS = getCmd();
                if (this.performanceData != null) {
                    fVar3.LN = this.performanceData.mCompressTime;
                    fVar3.fGT = getDownSize();
                    fVar3.fGU = currentTimeMillis4;
                    fVar3.fGV = i3;
                    fVar3.costTime = this.performanceData.mNetRWTime;
                    fVar3.setSubType(1002);
                    fVar3.bDJ();
                }
            } catch (Throwable th2) {
                th = th2;
                i2 = 0;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GroupInfo groupInfo;
        int size;
        ChatMessage obtainMessage;
        long longValue;
        long longValue2;
        int i2;
        VoiceMsgData u;
        GetGroupMsgResIdl getGroupMsgResIdl = (GetGroupMsgResIdl) new Wire(new Class[0]).parseFrom(bArr, GetGroupMsgResIdl.class);
        setError(getGroupMsgResIdl.error.errorno.intValue());
        setErrorString(getGroupMsgResIdl.error.usermsg);
        if (getError() == 0 && getGroupMsgResIdl.data != null) {
            parseMsgConfig(getGroupMsgResIdl.data.config);
            setGroupMsg(new LinkedList());
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            int size2 = getGroupMsgResIdl.data.groupMsg == null ? 0 : getGroupMsgResIdl.data.groupMsg.size();
            for (int i3 = 0; i3 < size2; i3++) {
                GroupMsg groupMsg = getGroupMsgResIdl.data.groupMsg.get(i3);
                if (groupMsg != null && (groupInfo = groupMsg.groupInfo) != null) {
                    GroupMsgData obtainGroupData = obtainGroupData(groupInfo);
                    if (obtainGroupData == null) {
                        BdLog.e("obtainGroupData == null !!!!");
                    } else if (TbadkCoreApplication.getInst().getCustomizedFilter() == null || TbadkCoreApplication.getInst().getCustomizedFilter().mK(obtainGroupData.getGroupInfo().getCustomType())) {
                        getGroupMsg().add(obtainGroupData);
                        LinkedList<ChatMessage> linkedList = new LinkedList<>();
                        obtainGroupData.setListMessageData(linkedList);
                        obtainGroupData.setHasMore(groupMsg.hasMore.intValue() != 0);
                        List<MsgInfo> list = groupMsg.msgList;
                        if (list != null && (size = list.size()) > 0) {
                            for (int i4 = 0; i4 < size; i4++) {
                                try {
                                    MsgInfo msgInfo = list.get(i4);
                                    if (msgInfo != null && (obtainMessage = obtainMessage(groupInfo, msgInfo)) != null) {
                                        long gY = com.baidu.tieba.im.util.b.gY(msgInfo.msgId.longValue());
                                        obtainMessage.setMsgId(gY);
                                        obtainMessage.setGroupId(String.valueOf(msgInfo.groupId));
                                        obtainMessage.setMsgType(msgInfo.msgType.intValue());
                                        long longValue3 = msgInfo.userId.longValue();
                                        obtainMessage.setUserId(longValue3);
                                        if (TbadkCoreApplication.isLogin() && String.valueOf(longValue3).equals(TbadkCoreApplication.getCurrentAccount())) {
                                            obtainMessage.setRecordId(msgInfo.recordId.longValue());
                                        } else {
                                            obtainMessage.setRecordId(gY);
                                        }
                                        UserData userData = new UserData();
                                        obtainMessage.setUserInfo(userData);
                                        UserInfo userInfo = msgInfo.userInfo;
                                        if (userInfo != null) {
                                            List<TshowInfo> list2 = userInfo.tshowIcon;
                                            if (list2 != null) {
                                                ArrayList<IconData> arrayList = new ArrayList<>();
                                                for (int i5 = 0; i5 < list2.size(); i5++) {
                                                    TshowInfo tshowInfo = list2.get(i5);
                                                    arrayList.add(new IconData(tshowInfo.icon, tshowInfo.name, tshowInfo.url));
                                                }
                                                userData.setTShowInfo(arrayList);
                                            }
                                            obtainMessage.getUserInfo().setUserId(String.valueOf(userInfo.userId));
                                            obtainMessage.getUserInfo().setUserName(userInfo.userName);
                                            obtainMessage.getUserInfo().setName_show(userInfo.userNameShow);
                                            obtainMessage.getUserInfo().setPortrait(userInfo.portrait);
                                            obtainMessage.getUserInfo().setImBjhAvatar(userInfo.bjhAvatar);
                                            obtainMessage.getUserInfo().setSex(userInfo.sex.intValue());
                                            obtainMessage.getUserInfo().setUserType(userInfo.userType.intValue());
                                        }
                                        obtainMessage.setToUserInfo(new UserData());
                                        UserInfo userInfo2 = msgInfo.toUserInfo;
                                        if (userInfo2 != null) {
                                            obtainMessage.getToUserInfo().setUserId(String.valueOf(userInfo2.userId));
                                            obtainMessage.getToUserInfo().setUserName(userInfo2.userName);
                                            obtainMessage.getToUserInfo().setName_show(userInfo2.userNameShow);
                                            obtainMessage.getToUserInfo().setPortrait(userInfo2.portrait);
                                            obtainMessage.getToUserInfo().setImBjhAvatar(userInfo2.bjhAvatar);
                                            obtainMessage.getToUserInfo().setSex(userInfo2.sex.intValue());
                                            obtainMessage.getToUserInfo().setUserType(userInfo2.userType.intValue());
                                        }
                                        obtainMessage.setToUserId(msgInfo.toUid.longValue());
                                        obtainMessage.setContent(msgInfo.content);
                                        BdLog.i("pullMessage content" + msgInfo.content);
                                        if (msgInfo.msgType.intValue() == 3 && (u = com.baidu.tieba.im.util.c.u(obtainMessage)) != null) {
                                            if (com.baidu.tieba.im.util.c.r(obtainMessage)) {
                                                u.setHas_read(1);
                                            } else {
                                                u.setHas_read(0);
                                            }
                                            obtainMessage.setContent("[" + OrmObject.jsonStrWithObject(u) + "]");
                                        }
                                        obtainMessage.setTime(msgInfo.createTime.intValue());
                                        obtainMessage.setIsFriend(msgInfo.isFriend.intValue());
                                        obtainMessage.setFollowStatus(msgInfo.isFriend.intValue());
                                        obtainMessage.setLink(msgInfo.link);
                                        obtainMessage.setStat(msgInfo.stat);
                                        obtainMessage.setTaskId(msgInfo.taskId.longValue());
                                        obtainMessage.setServiceId(msgInfo.serviceId.longValue());
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
                                            long j = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                                            if (j != msgInfo.userId.longValue()) {
                                                longValue2 = msgInfo.userId.longValue();
                                            } else {
                                                longValue2 = msgInfo.toUid.longValue();
                                            }
                                            if (msgInfo == null || msgInfo.userInfo == null) {
                                                i2 = 1;
                                            } else if (j != msgInfo.userId.longValue()) {
                                                i2 = msgInfo.userInfo.userType.intValue();
                                            } else {
                                                i2 = msgInfo.toUserInfo.userType.intValue();
                                            }
                                            if (longValue2 != 0) {
                                                if (linkedList.size() == 0) {
                                                    linkedList.add(obtainMessage);
                                                } else if (linkedList.get(0).getMsgId() < obtainMessage.getMsgId()) {
                                                    linkedList.remove(0);
                                                    linkedList.add(obtainMessage);
                                                }
                                                if (i2 == 4 && com.baidu.tieba.im.push.c.cVu().gU(obtainMessage.getMsgId())) {
                                                    BdLog.i("msg is contained in PushIdsCacheManager");
                                                } else if (obtainMessage.getMsgType() == 99) {
                                                    BdLog.i("msg is MSG_UNSHOW_OPERATER_ACCOUNT");
                                                } else if (TbadkCoreApplication.getInst().getCustomizedFilter() == null || TbadkCoreApplication.getInst().getCustomizedFilter().mK(4)) {
                                                    if (hashMap2.get(String.valueOf(longValue2)) == null) {
                                                        GroupMsgData groupMsgData = new GroupMsgData(CmdConfigCustom.MESSAGE_LIST_OFFICIAL_CMD);
                                                        groupMsgData.getGroupInfo().setUserType(i2);
                                                        groupMsgData.getGroupInfo().setCustomType(4);
                                                        groupMsgData.getGroupInfo().setGroupId(longValue2);
                                                        getGroupMsg().add(groupMsgData);
                                                        groupMsgData.setListMessageData(new LinkedList<>());
                                                        hashMap2.put(String.valueOf(longValue2), groupMsgData);
                                                        aq aqVar = new aq("official_message_receive");
                                                        aqVar.w("msg_id", msgInfo.msgId.longValue());
                                                        aqVar.w("official_id", msgInfo.userId.longValue());
                                                        if (msgInfo.userInfo != null) {
                                                            aqVar.an("official_type", msgInfo.userInfo.userType.intValue());
                                                        }
                                                        aqVar.w("operate_time", System.currentTimeMillis() / 1000);
                                                        aqVar.w("task_id", getTaskId(msgInfo));
                                                        TiebaStatic.log(aqVar);
                                                    }
                                                    ((GroupMsgData) hashMap2.get(String.valueOf(longValue2))).getListMessage().add(obtainMessage);
                                                }
                                            }
                                        } else if (obtainMessage instanceof PersonalChatMessage) {
                                            if (com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L) != msgInfo.userId.longValue()) {
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
                                                if (TbadkCoreApplication.getInst().getCustomizedFilter() == null || TbadkCoreApplication.getInst().getCustomizedFilter().mK(2)) {
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

    public static long getTaskId(MsgInfo msgInfo) {
        if (msgInfo == null) {
            return 0L;
        }
        if (!TextUtils.isEmpty(msgInfo.content)) {
            try {
                JSONArray jSONArray = new JSONArray(msgInfo.content);
                if (jSONArray.length() > 0) {
                    long j = com.baidu.adp.lib.f.b.toLong(jSONArray.optJSONObject(0).optString("task_id"), 0L);
                    if (j > 0) {
                        return j;
                    }
                }
            } catch (Exception e) {
            }
        }
        return msgInfo.taskId.longValue();
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
            case 30:
                BdLog.i("pullMessage groupType = 30");
                groupMsgData = new GroupMsgData(CmdConfigCustom.MESSAGE_LIST_OFFICIAL_GROUP_CMD);
                groupMsgData.getGroupInfo().setCustomType(-9);
                break;
        }
        if (groupMsgData != null) {
            groupMsgData.getGroupInfo().setGroupId(groupInfo.groupId.longValue());
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
            case 8:
                return new NotifyChatMessage();
            case 10:
            case 11:
            case 12:
                return new YYMessage();
            case 30:
                return new OfficialChatMessage();
            default:
                return null;
        }
    }

    private void parseMsgConfig(String str) {
        if (at.isEmpty(str)) {
        }
    }
}
