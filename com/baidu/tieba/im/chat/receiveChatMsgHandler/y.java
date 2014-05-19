package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class y extends CustomMessageListener {
    public y() {
        super(2015000);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        GroupMsgData groupMsgData = (GroupMsgData) customResponsedMessage;
        com.baidu.tieba.im.pushNotify.p.a().a(String.valueOf(groupMsgData.getGroupInfo().getGroupId()));
        com.baidu.tieba.im.i.a(new z(this, groupMsgData), new aa(this, groupMsgData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LinkedList<GroupNewsPojo> linkedList) {
        if (linkedList != null) {
            Iterator<GroupNewsPojo> it = linkedList.iterator();
            while (it.hasNext()) {
                GroupNewsPojo next = it.next();
                if (next != null && !TextUtils.isEmpty(next.getCmd()) && next.getCmd().equals("group_head_change")) {
                    a(next);
                }
            }
        }
    }

    private void a(GroupNewsPojo groupNewsPojo) {
        ImMessageCenterPojo a;
        UpdatesItemData a2 = com.baidu.tieba.im.groupUpdates.p.a(groupNewsPojo);
        if (a2 != null) {
            String groupId = a2.getGroupId();
            if (!TextUtils.isEmpty(groupId) && (a = com.baidu.tieba.im.b.e.a(groupId)) != null) {
                a.setGroup_head(a2.getGroupHeadUrl());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LinkedList<GroupNewsPojo> a(GroupMsgData groupMsgData) {
        long j;
        GroupNewsPojo groupNewsPojo;
        try {
            LinkedList<GroupNewsPojo> c = c(groupMsgData.getListMessage());
            if (c == null || c.isEmpty()) {
                return null;
            }
            LinkedList<GroupNewsPojo> a = com.baidu.tieba.im.db.d.a().a(0L, 1, 0, null);
            if (a == null || a.size() <= 0 || (groupNewsPojo = a.get(0)) == null || TextUtils.isEmpty(groupNewsPojo.getNotice_id())) {
                j = -1;
            } else {
                j = Long.parseLong(groupNewsPojo.getNotice_id());
            }
            LinkedList<GroupNewsPojo> linkedList = new LinkedList<>();
            Iterator<GroupNewsPojo> it = c.iterator();
            while (it.hasNext()) {
                GroupNewsPojo next = it.next();
                if (!TextUtils.isEmpty(next.getNotice_id()) && Long.parseLong(next.getNotice_id()) > j) {
                    linkedList.add(next);
                }
            }
            com.baidu.tieba.im.db.d.a().a(linkedList);
            Iterator<GroupNewsPojo> it2 = linkedList.iterator();
            while (it2.hasNext()) {
                GroupNewsPojo next2 = it2.next();
                if (next2 != null) {
                    if (next2.getCmd().equals("apply_join_group")) {
                        com.baidu.tieba.im.pushNotify.a.e();
                    } else if (next2.getCmd().equals("live_notify")) {
                        com.baidu.tieba.im.pushNotify.a.a(next2.getCmd());
                    } else if ("group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change".contains(next2.getCmd())) {
                        com.baidu.tieba.im.pushNotify.a.a(next2.getCmd(), true);
                    } else if (next2.getCmd().equals("apply_join_success")) {
                        com.baidu.tieba.im.pushNotify.a.b();
                    }
                }
            }
            return linkedList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(LinkedList<GroupNewsPojo> linkedList) {
        PushMessage newInstance;
        if (linkedList != null) {
            Iterator<GroupNewsPojo> it = linkedList.iterator();
            while (it.hasNext()) {
                GroupNewsPojo next = it.next();
                if (next != null && (newInstance = PushMessage.newInstance(next)) != null) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(newInstance);
                    BdLog.d("dispatch system cmd:" + next.getCmd());
                }
            }
        }
    }

    private static LinkedList<GroupNewsPojo> c(LinkedList<ChatMessage> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            return null;
        }
        LinkedList<GroupNewsPojo> linkedList2 = new LinkedList<>();
        Iterator<ChatMessage> it = linkedList.iterator();
        while (it.hasNext()) {
            GroupNewsPojo a = a(it.next());
            if (a != null) {
                linkedList2.add(a);
            }
        }
        return linkedList2;
    }

    private static GroupNewsPojo a(ChatMessage chatMessage) {
        UpdatesItemData a;
        String content = chatMessage.getContent();
        if (TextUtils.isEmpty(content)) {
            BdLog.d(" system message content is null or empty");
            return null;
        }
        try {
            BdLog.d("system msg:" + chatMessage.getContent());
            if (content.startsWith("[")) {
                BdLog.d("system msg content is no json");
                return null;
            }
            String optString = new JSONObject(content).optString("eventId");
            if (TextUtils.isEmpty(optString)) {
                BdLog.d(" system message content no eventId");
                return null;
            }
            BdLog.d("system message content eventID is " + optString);
            GroupNewsPojo groupNewsPojo = new GroupNewsPojo(chatMessage, optString);
            groupNewsPojo.setOriginalPushMsg(chatMessage);
            String cmd = groupNewsPojo.getCmd();
            if (!TextUtils.isEmpty(cmd) && cmd.equals("group_name_change")) {
                UpdatesItemData a2 = com.baidu.tieba.im.groupUpdates.p.a(groupNewsPojo);
                if (a2 != null && !TextUtils.isEmpty(a2.getGroupName())) {
                    String groupId = a2.getGroupId();
                    if (!TextUtils.isEmpty(groupId)) {
                        BdLog.d("update msg group name" + a2.getGroupName());
                        com.baidu.tieba.im.f.i.a(groupId, a2.getGroupName());
                    }
                }
            } else if (!TextUtils.isEmpty(cmd) && cmd.equals("group_head_change") && (a = com.baidu.tieba.im.groupUpdates.p.a(groupNewsPojo)) != null) {
                String groupId2 = a.getGroupId();
                if (!TextUtils.isEmpty(groupId2) && !TextUtils.isEmpty(a.getGroupHeadUrl())) {
                    BdLog.d("update msg group head" + a.getGroupHeadUrl());
                    com.baidu.tieba.im.f.i.b(groupId2, a.getGroupHeadUrl());
                }
            }
            return groupNewsPojo;
        } catch (JSONException e) {
            e.printStackTrace();
            BdLog.d("system message convert json error happen");
            return null;
        }
    }
}
