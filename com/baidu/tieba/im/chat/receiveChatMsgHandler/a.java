package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.gson.Gson;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.data.FeedData;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.SystemMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.db.pojo.OldUserData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.LinkedList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a {
    public static boolean a(ChatMessage chatMessage) {
        if (chatMessage.getMsgType() != 11) {
            return (chatMessage.getUserInfo() == null || chatMessage.getUserInfo().getUserId() == null || !chatMessage.getUserInfo().getUserId().equals(TbadkApplication.getCurrentAccount())) ? false : true;
        }
        SystemMsgData k = com.baidu.tieba.im.d.j.k(chatMessage);
        return (k == null || k.getIsSelf()) ? false : true;
    }

    public static void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String currentAccount = TbadkApplication.getCurrentAccount();
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("replyme");
                int optInt2 = jSONObject.optInt(FeedData.TYPE_ZAN);
                int optInt3 = jSONObject.optInt("fans");
                if (optInt2 > 0) {
                    optInt += optInt2;
                }
                int optInt4 = jSONObject.optInt("atme");
                if (jSONObject.optInt("feed") > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2012118));
                }
                if (optInt >= 0 && optInt3 >= 0 && optInt4 >= 0) {
                    if (TbadkApplication.m252getInst().getMsgFrequency() <= 0) {
                        optInt4 = 0;
                        optInt3 = 0;
                        optInt = 0;
                    }
                    if (!TbadkApplication.m252getInst().isMsgZanOn()) {
                        optInt -= optInt2;
                    }
                    if (!TbadkApplication.m252getInst().isMsgReplymeOn()) {
                        optInt = 0;
                    }
                    if (!TbadkApplication.m252getInst().isMsgAtmeOn()) {
                        optInt4 = 0;
                    }
                    int i = TbadkApplication.m252getInst().isMsgNewFansOn() ? optInt3 : 0;
                    if (currentAccount != null && currentAccount.length() > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.a().a(optInt, optInt4, com.baidu.tbadk.coreExtra.messageCenter.a.a().o(), i, com.baidu.tbadk.coreExtra.messageCenter.a.a().r());
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo, b bVar, c cVar, boolean z) {
        int i;
        boolean z2;
        boolean z3;
        boolean z4;
        OldUserData oldUserData;
        String valueOf = String.valueOf(groupMsgData.getGroupInfo().getGroupId());
        int customType = groupMsgData.getGroupInfo().getCustomType();
        LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
        if (listMessage != null && listMessage.size() > 0) {
            LinkedList linkedList = new LinkedList();
            if (imMessageCenterPojo == null) {
                imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setCustomGroupType(customType);
                imMessageCenterPojo.setGid(valueOf);
            }
            int unread_count = imMessageCenterPojo.getUnread_count();
            long pulled_msgId = imMessageCenterPojo.getPulled_msgId();
            long last_rid = imMessageCenterPojo.getLast_rid();
            boolean z5 = false;
            int i2 = unread_count;
            CommonMsgPojo commonMsgPojo = null;
            long j = pulled_msgId;
            for (ChatMessage chatMessage : listMessage) {
                chatMessage.setLocalData(new MsgLocalData());
                chatMessage.getLocalData().setStatus((short) 3);
                CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(chatMessage);
                commonMsgPojo2.setCustomGroupType(customType);
                if (a(chatMessage)) {
                    commonMsgPojo2.setRead_flag(0);
                } else {
                    if (commonMsgPojo2.getRid() > last_rid) {
                        i2++;
                    }
                    commonMsgPojo2.setRead_flag(1);
                }
                linkedList.add(commonMsgPojo2);
                if (commonMsgPojo != null && commonMsgPojo.getRid() >= commonMsgPojo2.getRid()) {
                    commonMsgPojo2 = commonMsgPojo;
                }
                if (j < chatMessage.getMsgId()) {
                    j = chatMessage.getMsgId();
                    commonMsgPojo = commonMsgPojo2;
                } else {
                    commonMsgPojo = commonMsgPojo2;
                }
            }
            commonMsgPojo.checkRidAndSelf();
            if (cVar != null && cVar.a(valueOf)) {
                i2 = 0;
            }
            imMessageCenterPojo.setUnread_count(i2);
            imMessageCenterPojo.setPulled_msgId(j);
            if ((customType == 2 || customType == 4) && commonMsgPojo.getPrivateOtherUser_infoObj() != null) {
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
                UserData userData = (UserData) new Gson().fromJson(commonMsgPojo.getUser_info(), (Class<Object>) UserData.class);
                String str = "";
                if (userData != null) {
                    if (com.baidu.adp.lib.util.i.c(userData.getUserId()) && (oldUserData = (OldUserData) new Gson().fromJson(commonMsgPojo.getUser_info(), (Class<Object>) OldUserData.class)) != null) {
                        oldUserData.setToUserData(userData);
                    }
                    str = userData.getUserName();
                    if (TbadkApplication.isLogin()) {
                        String currentAccount = TbadkApplication.getCurrentAccount();
                        if (!TextUtils.isEmpty(currentAccount) && currentAccount.equals(String.valueOf(userData.getUserId()))) {
                            z3 = true;
                            String a = com.baidu.tieba.im.d.j.a(commonMsgPojo.getMsg_type(), commonMsgPojo.getContent());
                            imMessageCenterPojo.setLast_rid(commonMsgPojo.getRid());
                            imMessageCenterPojo.setLast_content(a);
                            imMessageCenterPojo.setLast_content_time(commonMsgPojo.getCreate_time() * 1000);
                            imMessageCenterPojo.setLast_user_name(str);
                            if (imMessageCenterPojo.getUnread_count() <= 0) {
                                z4 = true;
                            } else if (!z3) {
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
                String a2 = com.baidu.tieba.im.d.j.a(commonMsgPojo.getMsg_type(), commonMsgPojo.getContent());
                imMessageCenterPojo.setLast_rid(commonMsgPojo.getRid());
                imMessageCenterPojo.setLast_content(a2);
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
            } else if (i2 > 0) {
                i = 1;
            } else {
                i = 2;
            }
            if (bVar != null) {
                bVar.a(valueOf, linkedList);
                bVar.a(imMessageCenterPojo, i, z5);
            }
        }
    }
}
