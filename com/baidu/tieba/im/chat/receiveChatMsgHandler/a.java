package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
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
    public interface InterfaceC0095a {
        boolean a(ChatMessage chatMessage, ImMessageCenterPojo imMessageCenterPojo);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z);

        void i(String str, List<CommonMsgPojo> list);
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean mb(String str);
    }

    public static boolean a(ChatMessage chatMessage, int i) {
        if (chatMessage.getMsgType() == 11) {
            SystemMsgData A = com.baidu.tieba.im.util.e.A(chatMessage);
            return (A == null || A.getIsSelf()) ? false : true;
        } else if (i == 4) {
            return com.baidu.tieba.im.util.e.B(chatMessage);
        } else {
            return (chatMessage.getUserInfo() == null || chatMessage.getUserInfo().getUserId() == null || !chatMessage.getUserInfo().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        }
    }

    public static void ma(String str) {
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
                    if (com.baidu.tbadk.coreExtra.messageCenter.b.zA().zD() <= 0) {
                        optInt6 = 0;
                        optInt4 = 0;
                        optInt3 = 0;
                        optInt = 0;
                    }
                    if (!com.baidu.tbadk.coreExtra.messageCenter.b.zA().zQ()) {
                        optInt -= optInt2;
                    }
                    if (!com.baidu.tbadk.coreExtra.messageCenter.b.zA().zH()) {
                        optInt = 0;
                    }
                    if (!com.baidu.tbadk.coreExtra.messageCenter.b.zA().zF()) {
                        optInt6 = 0;
                    }
                    int i = com.baidu.tbadk.coreExtra.messageCenter.b.zA().zG() ? optInt3 : 0;
                    if (currentAccount != null && currentAccount.length() > 0) {
                        int msgChat = com.baidu.tbadk.coreExtra.messageCenter.a.zd().getMsgChat();
                        int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.zd().getMsgBookmark();
                        com.baidu.tbadk.coreExtra.messageCenter.a.zd().f(jSONObject);
                        com.baidu.tbadk.coreExtra.messageCenter.a.zd().c(optInt, optInt6, msgChat, i, msgBookmark, optInt4);
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public static void a(GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo, b bVar, c cVar, boolean z) {
        a(groupMsgData, imMessageCenterPojo, bVar, cVar, z, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo, b bVar, c cVar, boolean z, InterfaceC0095a interfaceC0095a) {
        int i;
        boolean z2;
        boolean z3;
        boolean z4;
        OldUserData oldUserData;
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
            long j = pulled_msgId;
            CommonMsgPojo commonMsgPojo = null;
            int i2 = unread_count;
            for (ChatMessage chatMessage : listMessage) {
                if (j < chatMessage.getMsgId()) {
                    j = chatMessage.getMsgId();
                }
                if (interfaceC0095a == null || !interfaceC0095a.a(chatMessage, imMessageCenterPojo)) {
                    chatMessage.setLocalData(new MsgLocalData());
                    chatMessage.getLocalData().setStatus((short) 3);
                    CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(chatMessage);
                    commonMsgPojo2.setCustomGroupType(customType);
                    if (a(chatMessage, customType)) {
                        commonMsgPojo2.setRead_flag(0);
                    } else {
                        if (commonMsgPojo2.getRid() > last_rid) {
                            i2++;
                        }
                        commonMsgPojo2.setRead_flag(1);
                    }
                    linkedList.add(commonMsgPojo2);
                    commonMsgPojo = (commonMsgPojo == null || commonMsgPojo.getRid() < commonMsgPojo2.getRid()) ? commonMsgPojo2 : commonMsgPojo;
                }
            }
            if (commonMsgPojo != null) {
                commonMsgPojo.checkRidAndSelf();
            }
            if (cVar != null && cVar.mb(valueOf)) {
                i2 = 0;
            }
            imMessageCenterPojo.setUnread_count(i2);
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
                    if (j.isEmpty(userData.getUserId()) && (oldUserData = (OldUserData) OrmObject.objectWithJsonStr(commonMsgPojo.getUser_info(), OldUserData.class)) != null) {
                        oldUserData.setToUserData(userData);
                    }
                    str = userData.getUserName();
                    if (TbadkCoreApplication.isLogin()) {
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (!TextUtils.isEmpty(currentAccount) && currentAccount.equals(String.valueOf(userData.getUserId()))) {
                            z3 = true;
                            String G = com.baidu.tieba.im.util.e.G(commonMsgPojo.getMsg_type(), commonMsgPojo.getContent());
                            imMessageCenterPojo.setLastContentRawData(commonMsgPojo.getContent());
                            imMessageCenterPojo.setLast_rid(commonMsgPojo.getRid());
                            imMessageCenterPojo.setSid(commonMsgPojo.getSid());
                            MessageUtils.makeNewTaskId(imMessageCenterPojo, linkedList);
                            imMessageCenterPojo.setLast_content(G);
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
                String G2 = com.baidu.tieba.im.util.e.G(commonMsgPojo.getMsg_type(), commonMsgPojo.getContent());
                imMessageCenterPojo.setLastContentRawData(commonMsgPojo.getContent());
                imMessageCenterPojo.setLast_rid(commonMsgPojo.getRid());
                imMessageCenterPojo.setSid(commonMsgPojo.getSid());
                MessageUtils.makeNewTaskId(imMessageCenterPojo, linkedList);
                imMessageCenterPojo.setLast_content(G2);
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
            } else if (i2 > 0) {
                i = 1;
            } else {
                i = 2;
            }
            if (bVar != null) {
                bVar.i(valueOf, linkedList);
                bVar.a(imMessageCenterPojo, i, z5);
            }
        }
    }
}
