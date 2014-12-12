package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.SystemMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.db.pojo.OldUserData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.mention.FeedData;
import java.util.LinkedList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a {
    public static boolean e(ChatMessage chatMessage) {
        if (chatMessage.getMsgType() != 11) {
            return (chatMessage.getUserInfo() == null || chatMessage.getUserInfo().getUserId() == null || !chatMessage.getUserInfo().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        }
        SystemMsgData x = com.baidu.tieba.im.util.i.x(chatMessage);
        return (x == null || x.getIsSelf()) ? false : true;
    }

    public static void fV(String str) {
        if (!TextUtils.isEmpty(str)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("replyme");
                int optInt2 = jSONObject.optInt(FeedData.TYPE_ZAN);
                int optInt3 = jSONObject.optInt("fans");
                int optInt4 = jSONObject.optInt("gift");
                if (optInt2 > 0) {
                    optInt += optInt2;
                }
                int optInt5 = jSONObject.optInt("atme");
                if (jSONObject.optInt("feed") > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2012118));
                }
                if (optInt >= 0 && optInt3 >= 0 && optInt5 >= 0 && optInt4 >= 0) {
                    if (TbadkCoreApplication.m255getInst().getMsgFrequency() <= 0) {
                        optInt5 = 0;
                        optInt4 = 0;
                        optInt3 = 0;
                        optInt = 0;
                    }
                    if (!TbadkCoreApplication.m255getInst().isMsgZanOn()) {
                        optInt -= optInt2;
                    }
                    if (!TbadkCoreApplication.m255getInst().isMsgReplymeOn()) {
                        optInt = 0;
                    }
                    if (!TbadkCoreApplication.m255getInst().isMsgAtmeOn()) {
                        optInt5 = 0;
                    }
                    int i = TbadkCoreApplication.m255getInst().isMsgNewFansOn() ? optInt3 : 0;
                    if (currentAccount != null && currentAccount.length() > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.rI().a(optInt, optInt5, com.baidu.tbadk.coreExtra.messageCenter.a.rI().getMsgChat(), i, com.baidu.tbadk.coreExtra.messageCenter.a.rI().getMsgBookmark(), optInt4);
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public static void a(GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo, c cVar, d dVar, boolean z) {
        a(groupMsgData, imMessageCenterPojo, cVar, dVar, z, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo, c cVar, d dVar, boolean z, b bVar) {
        int i;
        boolean z2;
        boolean z3;
        boolean z4;
        OldUserData oldUserData;
        int i2;
        String valueOf = String.valueOf(groupMsgData.getGroupInfo().getGroupId());
        int customType = groupMsgData.getGroupInfo().getCustomType();
        int userType = groupMsgData.getGroupInfo().getUserType();
        LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
        if (listMessage != null && listMessage.size() > 0) {
            LinkedList linkedList = new LinkedList();
            if (imMessageCenterPojo == null) {
                imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setCustomGroupType(customType);
                imMessageCenterPojo.setGid(valueOf);
            }
            imMessageCenterPojo.setUserType(userType);
            int unread_count = imMessageCenterPojo.getUnread_count();
            long pulled_msgId = imMessageCenterPojo.getPulled_msgId();
            long last_rid = imMessageCenterPojo.getLast_rid();
            boolean z5 = false;
            CommonMsgPojo commonMsgPojo = null;
            int i3 = unread_count;
            long j = pulled_msgId;
            for (ChatMessage chatMessage : listMessage) {
                if (j < chatMessage.getMsgId()) {
                    j = chatMessage.getMsgId();
                }
                if (bVar == null || !bVar.a(chatMessage, imMessageCenterPojo)) {
                    chatMessage.setLocalData(new MsgLocalData());
                    chatMessage.getLocalData().setStatus((short) 3);
                    CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(chatMessage);
                    commonMsgPojo2.setCustomGroupType(customType);
                    if (e(chatMessage)) {
                        commonMsgPojo2.setRead_flag(0);
                        i2 = i3;
                    } else {
                        if (commonMsgPojo2.getRid() > last_rid) {
                            i3++;
                        }
                        commonMsgPojo2.setRead_flag(1);
                        i2 = i3;
                    }
                    linkedList.add(commonMsgPojo2);
                    if (commonMsgPojo == null || commonMsgPojo.getRid() < commonMsgPojo2.getRid()) {
                        i3 = i2;
                        commonMsgPojo = commonMsgPojo2;
                    } else {
                        i3 = i2;
                    }
                }
            }
            if (commonMsgPojo != null) {
                commonMsgPojo.checkRidAndSelf();
            }
            if (dVar != null && dVar.fW(valueOf)) {
                i3 = 0;
            }
            imMessageCenterPojo.setUnread_count(i3);
            imMessageCenterPojo.setPulled_msgId(j);
            if ((customType == 2 || customType == 4) && commonMsgPojo != null && commonMsgPojo.getPrivateOtherUser_infoObj() != null) {
                String portrait = commonMsgPojo.getPrivateOtherUser_infoObj().getPortrait();
                String userName = commonMsgPojo.getPrivateOtherUser_infoObj().getUserName();
                if (!TextUtils.isEmpty(portrait)) {
                    imMessageCenterPojo.setGroup_head(portrait);
                }
                if (!TextUtils.isEmpty(userName)) {
                    imMessageCenterPojo.setGroup_name(userName);
                }
            }
            if (commonMsgPojo != null && commonMsgPojo.getRid() >= last_rid) {
                if (commonMsgPojo.getRid() <= last_rid) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                UserData userData = (UserData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(commonMsgPojo.getUser_info(), UserData.class);
                String str = "";
                if (userData != null) {
                    if (com.baidu.adp.lib.util.k.isEmpty(userData.getUserId()) && (oldUserData = (OldUserData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(commonMsgPojo.getUser_info(), OldUserData.class)) != null) {
                        oldUserData.setToUserData(userData);
                    }
                    str = userData.getUserName();
                    if (TbadkCoreApplication.isLogin()) {
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (!TextUtils.isEmpty(currentAccount) && currentAccount.equals(String.valueOf(userData.getUserId()))) {
                            z3 = true;
                            String w = com.baidu.tieba.im.util.i.w(commonMsgPojo.getMsg_type(), commonMsgPojo.getContent());
                            imMessageCenterPojo.setLast_rid(commonMsgPojo.getRid());
                            imMessageCenterPojo.setLast_content(w);
                            imMessageCenterPojo.setLast_content_time(commonMsgPojo.getCreate_time() * 1000);
                            imMessageCenterPojo.setLast_user_name(str);
                            if (imMessageCenterPojo.getUnread_count() <= 0) {
                                z4 = true;
                            } else if (z3) {
                                z4 = true;
                            } else if (!z2) {
                                z4 = false;
                            } else {
                                z4 = true;
                            }
                            if (z4) {
                                imMessageCenterPojo.setIs_hidden(0);
                            }
                            imMessageCenterPojo.setIsFriend(commonMsgPojo.getIsFriend());
                            imMessageCenterPojo.setSend_status(3);
                            BdLog.i("send message status 3");
                            z5 = z2;
                        }
                    }
                }
                z3 = false;
                String w2 = com.baidu.tieba.im.util.i.w(commonMsgPojo.getMsg_type(), commonMsgPojo.getContent());
                imMessageCenterPojo.setLast_rid(commonMsgPojo.getRid());
                imMessageCenterPojo.setLast_content(w2);
                imMessageCenterPojo.setLast_content_time(commonMsgPojo.getCreate_time() * 1000);
                imMessageCenterPojo.setLast_user_name(str);
                if (imMessageCenterPojo.getUnread_count() <= 0) {
                }
                if (z4) {
                }
                imMessageCenterPojo.setIsFriend(commonMsgPojo.getIsFriend());
                imMessageCenterPojo.setSend_status(3);
                BdLog.i("send message status 3");
                z5 = z2;
            }
            if (z) {
                i = 0;
            } else if (i3 > 0) {
                i = 1;
            } else {
                i = 2;
            }
            if (cVar != null) {
                cVar.c(valueOf, linkedList);
                cVar.a(imMessageCenterPojo, i, z5);
            }
        }
    }
}
