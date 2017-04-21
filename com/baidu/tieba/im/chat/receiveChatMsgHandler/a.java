package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.SystemMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.db.pojo.OldUserData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: com.baidu.tieba.im.chat.receiveChatMsgHandler.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0063a {
        boolean a(ChatMessage chatMessage, ImMessageCenterPojo imMessageCenterPojo);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z);

        void h(String str, List<CommonMsgPojo> list);
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean jX(String str);
    }

    public static boolean a(ChatMessage chatMessage, int i) {
        if (chatMessage.getMsgType() == 11) {
            SystemMsgData z = com.baidu.tieba.im.util.h.z(chatMessage);
            return (z == null || z.getIsSelf()) ? false : true;
        } else if (i == 4) {
            return com.baidu.tieba.im.util.h.A(chatMessage);
        } else {
            return (chatMessage.getUserInfo() == null || chatMessage.getUserInfo().getUserId() == null || !chatMessage.getUserInfo().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        }
    }

    public static void jW(String str) {
        if (!TextUtils.isEmpty(str)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("replyme");
                int optInt2 = jSONObject.optInt(FeedData.TYPE_ZAN);
                int optInt3 = jSONObject.optInt("fans");
                int optInt4 = jSONObject.optInt("gift");
                int optInt5 = jSONObject.optInt("godfeed");
                if (optInt2 > 0) {
                    optInt += optInt2;
                }
                int optInt6 = jSONObject.optInt("atme");
                if (jSONObject.optInt("feed") > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.FRIEND_FEED_NEW));
                }
                if (optInt5 > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GOD_FEED_MSG_RECIEVED, Integer.valueOf(optInt5)));
                }
                if (optInt >= 0 && optInt3 >= 0 && optInt6 >= 0 && optInt4 >= 0) {
                    if (com.baidu.tbadk.coreExtra.messageCenter.c.zG().zJ() <= 0) {
                        optInt6 = 0;
                        optInt4 = 0;
                        optInt3 = 0;
                        optInt = 0;
                    }
                    if (!com.baidu.tbadk.coreExtra.messageCenter.c.zG().zW()) {
                        optInt -= optInt2;
                    }
                    if (!com.baidu.tbadk.coreExtra.messageCenter.c.zG().zN()) {
                        optInt = 0;
                    }
                    if (!com.baidu.tbadk.coreExtra.messageCenter.c.zG().zL()) {
                        optInt6 = 0;
                    }
                    int i = com.baidu.tbadk.coreExtra.messageCenter.c.zG().zM() ? optInt3 : 0;
                    if (currentAccount != null && currentAccount.length() > 0) {
                        int msgChat = com.baidu.tbadk.coreExtra.messageCenter.a.zj().getMsgChat();
                        int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.zj().getMsgBookmark();
                        com.baidu.tbadk.coreExtra.messageCenter.a.zj().k(jSONObject);
                        com.baidu.tbadk.coreExtra.messageCenter.a.zj().c(optInt, optInt6, msgChat, i, msgBookmark, optInt4);
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public static void a(GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo, b bVar, c cVar, boolean z) {
        a(groupMsgData, imMessageCenterPojo, bVar, cVar, z, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo, b bVar, c cVar, boolean z, InterfaceC0063a interfaceC0063a) {
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
                if (interfaceC0063a == null || !interfaceC0063a.a(chatMessage, imMessageCenterPojo)) {
                    chatMessage.setLocalData(new MsgLocalData());
                    chatMessage.getLocalData().setStatus((short) 3);
                    CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(chatMessage);
                    commonMsgPojo2.setCustomGroupType(customType);
                    if (a(chatMessage, customType)) {
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
            if (cVar != null && cVar.jX(valueOf)) {
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
                UserData userData = (UserData) OrmObject.objectWithJsonStr(commonMsgPojo.getUser_info(), UserData.class);
                String str = "";
                if (userData != null) {
                    if (com.baidu.adp.lib.util.j.isEmpty(userData.getUserId()) && (oldUserData = (OldUserData) OrmObject.objectWithJsonStr(commonMsgPojo.getUser_info(), OldUserData.class)) != null) {
                        oldUserData.setToUserData(userData);
                    }
                    str = userData.getUserName();
                    if (TbadkCoreApplication.isLogin()) {
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (!TextUtils.isEmpty(currentAccount) && currentAccount.equals(String.valueOf(userData.getUserId()))) {
                            z3 = true;
                            String C = com.baidu.tieba.im.util.h.C(commonMsgPojo.getMsg_type(), commonMsgPojo.getContent());
                            imMessageCenterPojo.setLastContentRawData(commonMsgPojo.getContent());
                            imMessageCenterPojo.setLast_rid(commonMsgPojo.getRid());
                            imMessageCenterPojo.setSid(commonMsgPojo.getSid());
                            MessageUtils.makeNewTaskId(imMessageCenterPojo, linkedList);
                            imMessageCenterPojo.setLast_content(C);
                            imMessageCenterPojo.setLast_content_time(commonMsgPojo.getCreate_time() * 1000);
                            imMessageCenterPojo.setLast_user_name(str);
                            imMessageCenterPojo.setPushIds(commonMsgPojo.getPushIds());
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
                String C2 = com.baidu.tieba.im.util.h.C(commonMsgPojo.getMsg_type(), commonMsgPojo.getContent());
                imMessageCenterPojo.setLastContentRawData(commonMsgPojo.getContent());
                imMessageCenterPojo.setLast_rid(commonMsgPojo.getRid());
                imMessageCenterPojo.setSid(commonMsgPojo.getSid());
                MessageUtils.makeNewTaskId(imMessageCenterPojo, linkedList);
                imMessageCenterPojo.setLast_content(C2);
                imMessageCenterPojo.setLast_content_time(commonMsgPojo.getCreate_time() * 1000);
                imMessageCenterPojo.setLast_user_name(str);
                imMessageCenterPojo.setPushIds(commonMsgPojo.getPushIds());
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
            if (bVar != null) {
                bVar.h(valueOf, linkedList);
                bVar.a(imMessageCenterPojo, i, z5);
            }
        }
    }
}
