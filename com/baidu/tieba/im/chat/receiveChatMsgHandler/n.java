package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.r;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {
    public static boolean lz(String str) {
        return !TextUtils.isEmpty(str) && "group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change".contains(str);
    }

    public static boolean lA(String str) {
        return !TextUtils.isEmpty(str) && str.equals("apply_join_group");
    }

    public static boolean lB(String str) {
        return !TextUtils.isEmpty(str) && str.equals("live_v_notify");
    }

    public static boolean lC(String str) {
        return !TextUtils.isEmpty(str) && str.equals("live_notify");
    }

    public static void a(GroupMsgData groupMsgData) {
        LinkedList<GroupNewsPojo> j = j(groupMsgData.getListMessage());
        if (j != null && !j.isEmpty()) {
            LinkedList<GroupNewsPojo> linkedList = new LinkedList<>();
            Iterator<GroupNewsPojo> it = j.iterator();
            GroupNewsPojo groupNewsPojo = null;
            GroupNewsPojo groupNewsPojo2 = null;
            long j2 = 0;
            GroupNewsPojo groupNewsPojo3 = null;
            while (it.hasNext()) {
                GroupNewsPojo next = it.next();
                if (!TextUtils.isEmpty(next.getNotice_id())) {
                    long parseLong = Long.parseLong(next.getNotice_id());
                    if (parseLong > j2) {
                        j2 = parseLong;
                    }
                    if (TbadkCoreApplication.m9getInst().getCustomizedFilter() == null || TbadkCoreApplication.m9getInst().getCustomizedFilter().a(next)) {
                        if (lz(next.getCmd())) {
                            linkedList.add(next);
                            if (groupNewsPojo3 == null) {
                                groupNewsPojo3 = next;
                            } else if (parseLong > Long.parseLong(groupNewsPojo3.getNotice_id())) {
                                groupNewsPojo3 = next;
                            }
                        } else if (lC(next.getCmd())) {
                            linkedList.add(next);
                            if (groupNewsPojo == null) {
                                groupNewsPojo = next;
                            } else if (parseLong > Long.parseLong(groupNewsPojo.getNotice_id())) {
                                groupNewsPojo = next;
                            }
                        } else if (lA(next.getCmd())) {
                            linkedList.add(next);
                            if (groupNewsPojo2 == null) {
                                groupNewsPojo2 = next;
                            } else if (parseLong > Long.parseLong(groupNewsPojo2.getNotice_id())) {
                                groupNewsPojo2 = next;
                            }
                        }
                    }
                }
            }
            com.baidu.tieba.im.db.d.auC().l(linkedList);
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid(String.valueOf(groupMsgData.getGroupInfo().getGroupId()));
            imMessageCenterPojo.setIs_hidden(1);
            imMessageCenterPojo.setCustomGroupType(-2);
            imMessageCenterPojo.setPulled_msgId(j2);
            com.baidu.tieba.im.db.i.auK().c(imMessageCenterPojo);
            if (groupNewsPojo3 != null) {
                ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                imMessageCenterPojo2.setGid(String.valueOf("-1002"));
                imMessageCenterPojo2.setCustomGroupType(-3);
                imMessageCenterPojo2.setUnread_count(1);
                imMessageCenterPojo2.setLast_rid(com.baidu.adp.lib.h.b.c(groupNewsPojo3.getNotice_id(), 0L));
                imMessageCenterPojo2.setLast_content_time(groupNewsPojo3.getTime());
                imMessageCenterPojo2.setLast_content(groupNewsPojo3.getContent());
                imMessageCenterPojo2.setIs_hidden(0);
                com.baidu.tieba.im.db.i.auK().a(imMessageCenterPojo2, 2);
            }
            if (groupNewsPojo2 != null) {
                ImMessageCenterPojo imMessageCenterPojo3 = new ImMessageCenterPojo();
                imMessageCenterPojo3.setGid(String.valueOf("-1003"));
                imMessageCenterPojo3.setCustomGroupType(-4);
                imMessageCenterPojo3.setUnread_count(1);
                imMessageCenterPojo3.setLast_rid(com.baidu.adp.lib.h.b.c(groupNewsPojo2.getNotice_id(), 0L));
                imMessageCenterPojo3.setLast_content_time(groupNewsPojo2.getTime());
                imMessageCenterPojo3.setLast_content(groupNewsPojo2.getContent());
                imMessageCenterPojo3.setIs_hidden(0);
                com.baidu.tieba.im.db.i.auK().a(imMessageCenterPojo3, 2);
            }
            if (groupNewsPojo != null) {
                ImMessageCenterPojo imMessageCenterPojo4 = new ImMessageCenterPojo();
                imMessageCenterPojo4.setGid(String.valueOf("-1004"));
                imMessageCenterPojo4.setCustomGroupType(-5);
                imMessageCenterPojo4.setUnread_count(1);
                imMessageCenterPojo4.setLast_rid(com.baidu.adp.lib.h.b.c(groupNewsPojo.getNotice_id(), 0L));
                imMessageCenterPojo4.setLast_content_time(groupNewsPojo.getTime());
                imMessageCenterPojo4.setLast_content(groupNewsPojo.getContent());
                imMessageCenterPojo4.setIs_hidden(0);
                com.baidu.tieba.im.db.i.auK().a(imMessageCenterPojo4, 2);
            }
            Iterator<GroupNewsPojo> it2 = j.iterator();
            while (it2.hasNext()) {
                GroupNewsPojo next2 = it2.next();
                if (next2 != null && (TbadkCoreApplication.m9getInst().getCustomizedFilter() == null || TbadkCoreApplication.m9getInst().getCustomizedFilter().a(next2))) {
                    PushMessage newInstance = PushMessage.newInstance(next2);
                    if (newInstance != null) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(newInstance);
                    }
                }
            }
        }
    }

    private static LinkedList<GroupNewsPojo> j(LinkedList<ChatMessage> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            return null;
        }
        LinkedList<GroupNewsPojo> linkedList2 = new LinkedList<>();
        Iterator<ChatMessage> it = linkedList.iterator();
        while (it.hasNext()) {
            GroupNewsPojo i = i(it.next());
            if (i != null) {
                linkedList2.add(i);
            }
        }
        return linkedList2;
    }

    private static GroupNewsPojo i(ChatMessage chatMessage) {
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
        a.a(groupMsgData, imMessageCenterPojo, bVar, new o(), false);
    }

    public static String bd(String str, String str2) {
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
            if (jSONObject.isNull("notice_id")) {
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
            ImMessageCenterPojo ah = com.baidu.tieba.im.memorycache.b.axj().ah(str3, 1);
            if (ah != null) {
                str5 = ah.getGroup_name();
            }
            if (TextUtils.isEmpty(str5) || TextUtils.isEmpty(str4)) {
                return "";
            }
            return String.valueOf(str4) + TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getString(r.j.validate_im_apply_prefix1) + str5;
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
                i = optJSONObject.optInt("status");
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
            imMessageCenterPojo.setLast_content(bd(str, groupNewsPojo.getContent()));
            imMessageCenterPojo.setLast_content_time(groupNewsPojo.getTime());
            imMessageCenterPojo.setLast_rid(com.baidu.adp.lib.h.b.c(groupNewsPojo.getNotice_id(), 0L));
            return imMessageCenterPojo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
