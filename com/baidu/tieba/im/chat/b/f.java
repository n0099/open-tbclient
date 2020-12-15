package com.baidu.tieba.im.chat.b;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
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
    public static boolean MT(String str) {
        return !TextUtils.isEmpty(str) && "group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change".contains(str);
    }

    public static boolean MU(String str) {
        return !TextUtils.isEmpty(str) && str.equals("apply_join_group");
    }

    public static void a(GroupMsgData groupMsgData) {
        GroupNewsPojo groupNewsPojo;
        LinkedList<GroupNewsPojo> k = k(groupMsgData.getListMessage());
        if (k != null && !k.isEmpty()) {
            long j = 0;
            GroupNewsPojo groupNewsPojo2 = null;
            GroupNewsPojo groupNewsPojo3 = null;
            LinkedList<GroupNewsPojo> linkedList = new LinkedList<>();
            Iterator<GroupNewsPojo> it = k.iterator();
            while (it.hasNext()) {
                GroupNewsPojo next = it.next();
                if (!TextUtils.isEmpty(next.getNotice_id())) {
                    long parseLong = Long.parseLong(next.getNotice_id());
                    if (parseLong > j) {
                        j = parseLong;
                    }
                    if (TbadkCoreApplication.getInst().getCustomizedFilter() == null || TbadkCoreApplication.getInst().getCustomizedFilter().a(next)) {
                        if (MT(next.getCmd())) {
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
                            if (MU(next.getCmd())) {
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
            com.baidu.tieba.im.db.d.cVQ().m(linkedList);
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid(String.valueOf(groupMsgData.getGroupInfo().getGroupId()));
            imMessageCenterPojo.setIs_hidden(1);
            imMessageCenterPojo.setCustomGroupType(-2);
            imMessageCenterPojo.setPulled_msgId(j);
            j.cWa().d(imMessageCenterPojo);
            if (groupNewsPojo2 != null) {
                ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                imMessageCenterPojo2.setGid(String.valueOf(TbEnum.CustomGroupId.GROUP_UPDATE));
                imMessageCenterPojo2.setCustomGroupType(-3);
                imMessageCenterPojo2.setUnread_count(1);
                imMessageCenterPojo2.setLast_rid(com.baidu.adp.lib.f.b.toLong(groupNewsPojo2.getNotice_id(), 0L));
                imMessageCenterPojo2.setLast_content_time(groupNewsPojo2.getTime());
                imMessageCenterPojo2.setLast_content(groupNewsPojo2.getContent());
                imMessageCenterPojo2.setIs_hidden(0);
                j.cWa().a(imMessageCenterPojo2, 2);
            }
            if (groupNewsPojo3 != null) {
                ImMessageCenterPojo imMessageCenterPojo3 = new ImMessageCenterPojo();
                imMessageCenterPojo3.setGid(String.valueOf(TbEnum.CustomGroupId.GROUP_VALIDATION));
                imMessageCenterPojo3.setCustomGroupType(-4);
                imMessageCenterPojo3.setUnread_count(1);
                imMessageCenterPojo3.setLast_rid(com.baidu.adp.lib.f.b.toLong(groupNewsPojo3.getNotice_id(), 0L));
                imMessageCenterPojo3.setLast_content_time(groupNewsPojo3.getTime());
                imMessageCenterPojo3.setLast_content(groupNewsPojo3.getContent());
                imMessageCenterPojo3.setIs_hidden(0);
                j.cWa().a(imMessageCenterPojo3, 2);
            }
            Iterator<GroupNewsPojo> it2 = k.iterator();
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

    private static LinkedList<GroupNewsPojo> k(LinkedList<ChatMessage> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            return null;
        }
        LinkedList<GroupNewsPojo> linkedList2 = new LinkedList<>();
        Iterator<ChatMessage> it = linkedList.iterator();
        while (it.hasNext()) {
            GroupNewsPojo g = g(it.next());
            if (g != null) {
                linkedList2.add(g);
            }
        }
        return linkedList2;
    }

    private static GroupNewsPojo g(ChatMessage chatMessage) {
        String content = chatMessage.getContent();
        if (TextUtils.isEmpty(content)) {
            return null;
        }
        try {
            if (content.startsWith("[")) {
                return null;
            }
            String optString = new JSONObject(content).optString(TbEnum.SystemMessage.KEY_EVENT_ID);
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
            public boolean MS(String str) {
                return true;
            }
        }, false);
    }

    public static String fr(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString(TbEnum.SystemMessage.KEY_USER_MSG);
            JSONObject optJSONObject = jSONObject.optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
            if (!str.equals("apply_join_group")) {
                return "group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change".contains(str) ? optString : "";
            }
            String str3 = "";
            String str4 = "";
            String str5 = "";
            if (true == jSONObject.isNull("notice_id")) {
                if (optJSONObject != null) {
                    str3 = optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_ID);
                    str4 = optJSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME);
                    str5 = optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_NAME);
                }
            } else {
                str3 = jSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_ID);
                str4 = jSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME);
                str5 = jSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_NAME);
            }
            ImMessageCenterPojo bl = com.baidu.tieba.im.memorycache.b.cYD().bl(str3, 1);
            if (bl != null) {
                str5 = bl.getGroup_name();
            }
            if (TextUtils.isEmpty(str5) || TextUtils.isEmpty(str4)) {
                return "";
            }
            return str4 + TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.validate_im_apply_prefix1) + str5;
        } catch (Exception e) {
            BdLog.detailException(e);
            return "";
        }
    }
}
