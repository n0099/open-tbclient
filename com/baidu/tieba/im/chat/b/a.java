package com.baidu.tieba.im.chat.b;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.SystemMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: com.baidu.tieba.im.chat.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0167a {
        boolean a(ChatMessage chatMessage, ImMessageCenterPojo imMessageCenterPojo);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z);

        void i(String str, List<CommonMsgPojo> list);
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean nO(String str);
    }

    public static boolean a(ChatMessage chatMessage, int i) {
        if (chatMessage.getMsgType() == 11) {
            SystemMsgData C = com.baidu.tieba.im.util.e.C(chatMessage);
            return (C == null || C.getIsSelf()) ? false : true;
        } else if (i == 4) {
            return com.baidu.tieba.im.util.e.D(chatMessage);
        } else {
            return (chatMessage.getUserInfo() == null || chatMessage.getUserInfo().getUserId() == null || !chatMessage.getUserInfo().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        }
    }

    public static void nN(String str) {
        if (!TextUtils.isEmpty(str)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("agree");
                int optInt2 = jSONObject.optInt("replyme");
                jSONObject.optInt(FeedData.TYPE_ZAN);
                int optInt3 = jSONObject.optInt("fans");
                int optInt4 = jSONObject.optInt("gift");
                int optInt5 = jSONObject.optInt("godfeed");
                int optInt6 = jSONObject.optInt("atme");
                if (jSONObject.optInt("feed") > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2012118));
                }
                if (optInt5 > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016324, Integer.valueOf(optInt5)));
                }
                if (optInt >= 0 && optInt2 >= 0 && optInt3 >= 0 && optInt6 >= 0 && optInt4 >= 0) {
                    if (com.baidu.tbadk.coreExtra.messageCenter.c.DS().DV() <= 0) {
                        optInt4 = 0;
                        optInt3 = 0;
                    }
                    int i = com.baidu.tbadk.coreExtra.messageCenter.c.DS().DY() ? optInt3 : 0;
                    if (currentAccount != null && currentAccount.length() > 0) {
                        int msgChat = com.baidu.tbadk.coreExtra.messageCenter.a.Dl().getMsgChat();
                        int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.Dl().getMsgBookmark();
                        com.baidu.tbadk.coreExtra.messageCenter.a.Dl().r(jSONObject);
                        com.baidu.tbadk.coreExtra.messageCenter.a.Dl().a(optInt, optInt2, optInt6, msgChat, i, msgBookmark, optInt4);
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public static void a(GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo, b bVar, c cVar, boolean z) {
        a(groupMsgData, imMessageCenterPojo, bVar, cVar, z, null);
    }

    public static void a(GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo, b bVar, c cVar, boolean z, InterfaceC0167a interfaceC0167a) {
        int i;
        boolean z2;
        boolean z3;
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
            boolean z4 = false;
            int i3 = unread_count;
            CommonMsgPojo commonMsgPojo = null;
            long j = pulled_msgId;
            for (ChatMessage chatMessage : listMessage) {
                long msgId = j < chatMessage.getMsgId() ? chatMessage.getMsgId() : j;
                if (interfaceC0167a == null || !interfaceC0167a.a(chatMessage, imMessageCenterPojo)) {
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
                    i3 = i2;
                    commonMsgPojo = (commonMsgPojo == null || commonMsgPojo.getRid() < commonMsgPojo2.getRid()) ? commonMsgPojo2 : commonMsgPojo;
                    j = msgId;
                } else {
                    j = msgId;
                }
            }
            if (commonMsgPojo != null) {
                commonMsgPojo.checkRidAndSelf();
            }
            if (cVar != null && cVar.nO(valueOf)) {
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
                imMessageCenterPojo.setNameShow(commonMsgPojo.getPrivateOtherUser_infoObj().getName_show());
            }
            if (commonMsgPojo != null && commonMsgPojo.getRid() >= last_rid) {
                if (commonMsgPojo.getRid() <= last_rid) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                UserData user_infoObj = commonMsgPojo.getUser_infoObj();
                String str = "";
                boolean z5 = false;
                if (user_infoObj != null) {
                    str = user_infoObj.getName_show();
                    if (TbadkCoreApplication.isLogin()) {
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (!TextUtils.isEmpty(currentAccount) && currentAccount.equals(String.valueOf(user_infoObj.getUserId()))) {
                            z5 = true;
                        }
                    }
                }
                String W = com.baidu.tieba.im.util.e.W(commonMsgPojo.getMsg_type(), commonMsgPojo.getContent());
                imMessageCenterPojo.setLastContentRawData(commonMsgPojo.getContent());
                imMessageCenterPojo.setLast_rid(commonMsgPojo.getRid());
                imMessageCenterPojo.setSid(commonMsgPojo.getSid());
                imMessageCenterPojo.setLastTaskId(commonMsgPojo.getTaskId());
                MessageUtils.makeNewTaskId(imMessageCenterPojo, linkedList);
                imMessageCenterPojo.setLast_content(W);
                imMessageCenterPojo.setLast_content_time(commonMsgPojo.getCreate_time() * 1000);
                imMessageCenterPojo.setLast_user_name(str);
                imMessageCenterPojo.setPushIds(commonMsgPojo.getPushIds());
                if (imMessageCenterPojo.getUnread_count() > 0) {
                    z3 = true;
                } else if (z5) {
                    z3 = true;
                } else if (!z2) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (z3) {
                    imMessageCenterPojo.setIs_hidden(0);
                }
                imMessageCenterPojo.setIsFriend(commonMsgPojo.getIsFriend());
                imMessageCenterPojo.setFollowStatus(commonMsgPojo.getFollowStatus());
                imMessageCenterPojo.setSend_status(3);
                BdLog.i("send message status 3");
                z4 = z2;
            }
            if (z) {
                i = 0;
            } else if (i3 > 0) {
                i = 1;
            } else {
                i = 2;
            }
            if (bVar != null) {
                bVar.i(valueOf, linkedList);
                bVar.a(imMessageCenterPojo, i, z4);
            }
        }
    }
}
