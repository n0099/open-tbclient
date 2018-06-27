package com.baidu.tieba.im.chat.b;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.b.a;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.j;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    public static boolean nL(String str) {
        return !TextUtils.isEmpty(str) && "group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change".contains(str);
    }

    public static boolean nM(String str) {
        return !TextUtils.isEmpty(str) && str.equals("apply_join_group");
    }

    public static void a(GroupMsgData groupMsgData) {
        GroupNewsPojo groupNewsPojo;
        LinkedList<GroupNewsPojo> n = n(groupMsgData.getListMessage());
        if (n != null && !n.isEmpty()) {
            long j = 0;
            GroupNewsPojo groupNewsPojo2 = null;
            GroupNewsPojo groupNewsPojo3 = null;
            LinkedList<GroupNewsPojo> linkedList = new LinkedList<>();
            Iterator<GroupNewsPojo> it = n.iterator();
            while (it.hasNext()) {
                GroupNewsPojo next = it.next();
                if (!TextUtils.isEmpty(next.getNotice_id())) {
                    long parseLong = Long.parseLong(next.getNotice_id());
                    if (parseLong > j) {
                        j = parseLong;
                    }
                    if (TbadkCoreApplication.getInst().getCustomizedFilter() == null || TbadkCoreApplication.getInst().getCustomizedFilter().a(next)) {
                        if (nL(next.getCmd())) {
                            linkedList.add(next);
                            if (groupNewsPojo2 == null) {
                                GroupNewsPojo groupNewsPojo4 = groupNewsPojo3;
                                groupNewsPojo = next;
                                next = groupNewsPojo4;
                            } else {
                                if (parseLong > Long.parseLong(groupNewsPojo2.getNotice_id())) {
                                    GroupNewsPojo groupNewsPojo5 = groupNewsPojo3;
                                    groupNewsPojo = next;
                                    next = groupNewsPojo5;
                                }
                                next = groupNewsPojo3;
                                groupNewsPojo = groupNewsPojo2;
                            }
                            groupNewsPojo2 = groupNewsPojo;
                            groupNewsPojo3 = next;
                        } else {
                            if (nM(next.getCmd())) {
                                linkedList.add(next);
                                if (groupNewsPojo3 == null) {
                                    groupNewsPojo = groupNewsPojo2;
                                } else if (parseLong > Long.parseLong(groupNewsPojo3.getNotice_id())) {
                                    groupNewsPojo = groupNewsPojo2;
                                }
                                groupNewsPojo2 = groupNewsPojo;
                                groupNewsPojo3 = next;
                            }
                            next = groupNewsPojo3;
                            groupNewsPojo = groupNewsPojo2;
                            groupNewsPojo2 = groupNewsPojo;
                            groupNewsPojo3 = next;
                        }
                    }
                }
            }
            com.baidu.tieba.im.db.d.aIz().p(linkedList);
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid(String.valueOf(groupMsgData.getGroupInfo().getGroupId()));
            imMessageCenterPojo.setIs_hidden(1);
            imMessageCenterPojo.setCustomGroupType(-2);
            imMessageCenterPojo.setPulled_msgId(j);
            j.aII().f(imMessageCenterPojo);
            if (groupNewsPojo2 != null) {
                ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                imMessageCenterPojo2.setGid(String.valueOf("-1002"));
                imMessageCenterPojo2.setCustomGroupType(-3);
                imMessageCenterPojo2.setUnread_count(1);
                imMessageCenterPojo2.setLast_rid(com.baidu.adp.lib.g.b.c(groupNewsPojo2.getNotice_id(), 0L));
                imMessageCenterPojo2.setLast_content_time(groupNewsPojo2.getTime());
                imMessageCenterPojo2.setLast_content(groupNewsPojo2.getContent());
                imMessageCenterPojo2.setIs_hidden(0);
                j.aII().a(imMessageCenterPojo2, 2);
            }
            if (groupNewsPojo3 != null) {
                ImMessageCenterPojo imMessageCenterPojo3 = new ImMessageCenterPojo();
                imMessageCenterPojo3.setGid(String.valueOf("-1003"));
                imMessageCenterPojo3.setCustomGroupType(-4);
                imMessageCenterPojo3.setUnread_count(1);
                imMessageCenterPojo3.setLast_rid(com.baidu.adp.lib.g.b.c(groupNewsPojo3.getNotice_id(), 0L));
                imMessageCenterPojo3.setLast_content_time(groupNewsPojo3.getTime());
                imMessageCenterPojo3.setLast_content(groupNewsPojo3.getContent());
                imMessageCenterPojo3.setIs_hidden(0);
                j.aII().a(imMessageCenterPojo3, 2);
            }
            Iterator<GroupNewsPojo> it2 = n.iterator();
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

    private static LinkedList<GroupNewsPojo> n(LinkedList<ChatMessage> linkedList) {
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
        a.a(groupMsgData, imMessageCenterPojo, bVar, new a.c() { // from class: com.baidu.tieba.im.chat.b.f.1
            @Override // com.baidu.tieba.im.chat.b.a.c
            public boolean nK(String str) {
                return true;
            }
        }, false);
    }

    public static String bn(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString("userMsg");
            JSONObject optJSONObject = jSONObject.optJSONObject("eventParam");
            if (!str.equals("apply_join_group")) {
                return "group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change".contains(str) ? optString : "";
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
            ImMessageCenterPojo ar = com.baidu.tieba.im.memorycache.b.aKX().ar(str3, 1);
            if (ar != null) {
                str5 = ar.getGroup_name();
            }
            if (TextUtils.isEmpty(str5) || TextUtils.isEmpty(str4)) {
                return "";
            }
            return str4 + TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(d.k.validate_im_apply_prefix1) + str5;
        } catch (Exception e) {
            BdLog.detailException(e);
            return "";
        }
    }
}
