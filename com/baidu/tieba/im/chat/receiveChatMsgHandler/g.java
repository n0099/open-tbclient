package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.i;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    public static boolean mx(String str) {
        return !TextUtils.isEmpty(str) && "group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change".contains(str);
    }

    public static boolean my(String str) {
        return !TextUtils.isEmpty(str) && str.equals("apply_join_group");
    }

    public static boolean mz(String str) {
        return !TextUtils.isEmpty(str) && str.equals("live_v_notify");
    }

    public static boolean mA(String str) {
        return !TextUtils.isEmpty(str) && str.equals("live_notify");
    }

    public static void a(GroupMsgData groupMsgData) {
        GroupNewsPojo groupNewsPojo;
        GroupNewsPojo groupNewsPojo2;
        LinkedList<GroupNewsPojo> l = l(groupMsgData.getListMessage());
        if (l != null && !l.isEmpty()) {
            long j = 0;
            GroupNewsPojo groupNewsPojo3 = null;
            GroupNewsPojo groupNewsPojo4 = null;
            GroupNewsPojo groupNewsPojo5 = null;
            LinkedList<GroupNewsPojo> linkedList = new LinkedList<>();
            Iterator<GroupNewsPojo> it = l.iterator();
            while (it.hasNext()) {
                GroupNewsPojo next = it.next();
                if (!TextUtils.isEmpty(next.getNotice_id())) {
                    long parseLong = Long.parseLong(next.getNotice_id());
                    if (parseLong > j) {
                        j = parseLong;
                    }
                    if (TbadkCoreApplication.getInst().getCustomizedFilter() == null || TbadkCoreApplication.getInst().getCustomizedFilter().a(next)) {
                        if (mx(next.getCmd())) {
                            linkedList.add(next);
                            if (groupNewsPojo3 == null) {
                                GroupNewsPojo groupNewsPojo6 = groupNewsPojo5;
                                groupNewsPojo2 = groupNewsPojo4;
                                groupNewsPojo = next;
                                next = groupNewsPojo6;
                            } else {
                                if (parseLong > Long.parseLong(groupNewsPojo3.getNotice_id())) {
                                    GroupNewsPojo groupNewsPojo7 = groupNewsPojo5;
                                    groupNewsPojo2 = groupNewsPojo4;
                                    groupNewsPojo = next;
                                    next = groupNewsPojo7;
                                }
                                next = groupNewsPojo5;
                                groupNewsPojo2 = groupNewsPojo4;
                                groupNewsPojo = groupNewsPojo3;
                            }
                            groupNewsPojo3 = groupNewsPojo;
                            groupNewsPojo4 = groupNewsPojo2;
                            groupNewsPojo5 = next;
                        } else if (mA(next.getCmd())) {
                            linkedList.add(next);
                            if (groupNewsPojo5 == null) {
                                groupNewsPojo2 = groupNewsPojo4;
                                groupNewsPojo = groupNewsPojo3;
                            } else {
                                if (parseLong > Long.parseLong(groupNewsPojo5.getNotice_id())) {
                                    groupNewsPojo2 = groupNewsPojo4;
                                    groupNewsPojo = groupNewsPojo3;
                                }
                                next = groupNewsPojo5;
                                groupNewsPojo2 = groupNewsPojo4;
                                groupNewsPojo = groupNewsPojo3;
                            }
                            groupNewsPojo3 = groupNewsPojo;
                            groupNewsPojo4 = groupNewsPojo2;
                            groupNewsPojo5 = next;
                        } else {
                            if (my(next.getCmd())) {
                                linkedList.add(next);
                                if (groupNewsPojo4 == null) {
                                    groupNewsPojo = groupNewsPojo3;
                                    next = groupNewsPojo5;
                                    groupNewsPojo2 = next;
                                } else if (parseLong > Long.parseLong(groupNewsPojo4.getNotice_id())) {
                                    groupNewsPojo = groupNewsPojo3;
                                    next = groupNewsPojo5;
                                    groupNewsPojo2 = next;
                                }
                                groupNewsPojo3 = groupNewsPojo;
                                groupNewsPojo4 = groupNewsPojo2;
                                groupNewsPojo5 = next;
                            }
                            next = groupNewsPojo5;
                            groupNewsPojo2 = groupNewsPojo4;
                            groupNewsPojo = groupNewsPojo3;
                            groupNewsPojo3 = groupNewsPojo;
                            groupNewsPojo4 = groupNewsPojo2;
                            groupNewsPojo5 = next;
                        }
                    }
                }
            }
            com.baidu.tieba.im.db.d.aGt().n(linkedList);
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid(String.valueOf(groupMsgData.getGroupInfo().getGroupId()));
            imMessageCenterPojo.setIs_hidden(1);
            imMessageCenterPojo.setCustomGroupType(-2);
            imMessageCenterPojo.setPulled_msgId(j);
            i.aGA().c(imMessageCenterPojo);
            if (groupNewsPojo3 != null) {
                ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                imMessageCenterPojo2.setGid(String.valueOf("-1002"));
                imMessageCenterPojo2.setCustomGroupType(-3);
                imMessageCenterPojo2.setUnread_count(1);
                imMessageCenterPojo2.setLast_rid(com.baidu.adp.lib.g.b.c(groupNewsPojo3.getNotice_id(), 0L));
                imMessageCenterPojo2.setLast_content_time(groupNewsPojo3.getTime());
                imMessageCenterPojo2.setLast_content(groupNewsPojo3.getContent());
                imMessageCenterPojo2.setIs_hidden(0);
                i.aGA().a(imMessageCenterPojo2, 2);
            }
            if (groupNewsPojo4 != null) {
                ImMessageCenterPojo imMessageCenterPojo3 = new ImMessageCenterPojo();
                imMessageCenterPojo3.setGid(String.valueOf("-1003"));
                imMessageCenterPojo3.setCustomGroupType(-4);
                imMessageCenterPojo3.setUnread_count(1);
                imMessageCenterPojo3.setLast_rid(com.baidu.adp.lib.g.b.c(groupNewsPojo4.getNotice_id(), 0L));
                imMessageCenterPojo3.setLast_content_time(groupNewsPojo4.getTime());
                imMessageCenterPojo3.setLast_content(groupNewsPojo4.getContent());
                imMessageCenterPojo3.setIs_hidden(0);
                i.aGA().a(imMessageCenterPojo3, 2);
            }
            if (groupNewsPojo5 != null) {
                ImMessageCenterPojo imMessageCenterPojo4 = new ImMessageCenterPojo();
                imMessageCenterPojo4.setGid(String.valueOf("-1004"));
                imMessageCenterPojo4.setCustomGroupType(-5);
                imMessageCenterPojo4.setUnread_count(1);
                imMessageCenterPojo4.setLast_rid(com.baidu.adp.lib.g.b.c(groupNewsPojo5.getNotice_id(), 0L));
                imMessageCenterPojo4.setLast_content_time(groupNewsPojo5.getTime());
                imMessageCenterPojo4.setLast_content(groupNewsPojo5.getContent());
                imMessageCenterPojo4.setIs_hidden(0);
                i.aGA().a(imMessageCenterPojo4, 2);
            }
            Iterator<GroupNewsPojo> it2 = l.iterator();
            while (it2.hasNext()) {
                GroupNewsPojo next2 = it2.next();
                if (next2 != null && (TbadkCoreApplication.getInst().getCustomizedFilter() == null || TbadkCoreApplication.getInst().getCustomizedFilter().a(next2))) {
                    PushMessage newInstance = PushMessage.newInstance(next2);
                    if (newInstance != null) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(newInstance);
                    }
                }
            }
        }
    }

    private static LinkedList<GroupNewsPojo> l(LinkedList<ChatMessage> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            return null;
        }
        LinkedList<GroupNewsPojo> linkedList2 = new LinkedList<>();
        Iterator<ChatMessage> it = linkedList.iterator();
        while (it.hasNext()) {
            GroupNewsPojo l = l(it.next());
            if (l != null) {
                linkedList2.add(l);
            }
        }
        return linkedList2;
    }

    private static GroupNewsPojo l(ChatMessage chatMessage) {
        String content = chatMessage.getContent();
        if (TextUtils.isEmpty(content)) {
            return null;
        }
        try {
            if (content.startsWith("[")) {
                return null;
            }
            String optString = new JSONObject(content).optString("eventId");
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            GroupNewsPojo groupNewsPojo = new GroupNewsPojo(chatMessage, optString);
            groupNewsPojo.setOriginalPushMsg(chatMessage);
            return groupNewsPojo;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void a(GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo, a.b bVar) {
        a.a(groupMsgData, imMessageCenterPojo, bVar, new a.c() { // from class: com.baidu.tieba.im.chat.receiveChatMsgHandler.g.1
            @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.c
            public boolean mw(String str) {
                return true;
            }
        }, false);
    }

    public static String bc(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString("userMsg");
            JSONObject optJSONObject = jSONObject.optJSONObject("eventParam");
            if (!str.equals("apply_join_group")) {
                return (str.equals("live_notify") || "group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change".contains(str) || "live_v_notify".contains(str)) ? optString : "";
            }
            String str3 = "";
            String str4 = "";
            String str5 = "";
            if (true == jSONObject.isNull("notice_id")) {
                if (optJSONObject != null) {
                    str3 = optJSONObject.optString("groupId");
                    str4 = optJSONObject.optString("userName");
                    str5 = optJSONObject.optString("groupName");
                }
            } else {
                str3 = jSONObject.optString("groupId");
                str4 = jSONObject.optString("userName");
                str5 = jSONObject.optString("groupName");
            }
            ImMessageCenterPojo ak = com.baidu.tieba.im.memorycache.b.aIQ().ak(str3, 1);
            if (ak != null) {
                str5 = ak.getGroup_name();
            }
            if (TextUtils.isEmpty(str5) || TextUtils.isEmpty(str4)) {
                return "";
            }
            return str4 + TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(d.j.validate_im_apply_prefix1) + str5;
        } catch (Exception e) {
            BdLog.detailException(e);
            return "";
        }
    }

    public static ImMessageCenterPojo a(GroupNewsPojo groupNewsPojo, String str) {
        String str2;
        String str3;
        String content = groupNewsPojo.getContent();
        if (TextUtils.isEmpty(content)) {
            return null;
        }
        int i = -1;
        try {
            JSONObject optJSONObject = new JSONObject(content).optJSONObject("eventParam");
            if (optJSONObject != null) {
                str3 = optJSONObject.optString("groupId");
                str2 = optJSONObject.optString("groupName");
                i = optJSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
            } else {
                str2 = null;
                str3 = null;
            }
            if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2) || i != 3) {
                return null;
            }
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid(str3);
            imMessageCenterPojo.setGroup_name(str2);
            imMessageCenterPojo.setCustomGroupType(-10);
            imMessageCenterPojo.setLast_content(bc(str, groupNewsPojo.getContent()));
            imMessageCenterPojo.setLast_content_time(groupNewsPojo.getTime());
            imMessageCenterPojo.setLast_rid(com.baidu.adp.lib.g.b.c(groupNewsPojo.getNotice_id(), 0L));
            return imMessageCenterPojo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
