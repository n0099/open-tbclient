package com.baidu.tieba.im.chat;

import com.baidu.gson.Gson;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.SystemMsgData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.GroupMsgPojo;
import com.baidu.tieba.im.message.ChatMessage;
import com.baidu.tieba.im.message.ChatResponsedMessage;
import com.baidu.tieba.im.message.GroupMemberChangeResponsedMessage;
import com.baidu.tieba.im.message.Message;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f1536a = null;
    private WeakReference<aa> b;
    private h c = null;

    private a() {
    }

    public void a() {
        this.c = new h(this, null);
        com.baidu.tieba.im.messageCenter.e.a().a(-100, this.c);
        com.baidu.tieba.im.messageCenter.e.a().a(202001, this.c);
        com.baidu.tieba.im.messageCenter.e.a().a(-103, this.c);
        com.baidu.tieba.im.messageCenter.e.a().a(-105, this.c);
    }

    public static a b() {
        if (f1536a == null) {
            f1536a = new a();
        }
        return f1536a;
    }

    public void a(aa aaVar) {
        this.b = new WeakReference<>(aaVar);
    }

    public void c() {
        this.b = null;
    }

    public void a(String str, ab abVar) {
        com.baidu.tieba.im.db.d.a().a(str, 2, (String) null, LocationClientOption.MIN_SCAN_SPAN, new b(this, abVar));
    }

    public void a(ChatMessage chatMessage) {
        com.baidu.adp.lib.h.e.d("SHNAG chatManager sendMessage, content = " + chatMessage.getContent());
        LinkedList<GroupMsgPojo> linkedList = new LinkedList<>();
        GroupMsgPojo groupMsgPojo = new GroupMsgPojo(chatMessage);
        groupMsgPojo.setRead_flag(0);
        linkedList.add(groupMsgPojo);
        com.baidu.tieba.im.db.d.a().a(chatMessage.getGroupId(), linkedList, false, (com.baidu.tieba.im.a<Boolean>) new c(this, chatMessage));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        List<ChatMessage> a2;
        if (message instanceof GroupMsgData) {
            GroupMsgData groupMsgData = (GroupMsgData) message;
            if (groupMsgData.getGroupInfo() != null) {
                String valueOf = String.valueOf(groupMsgData.getGroupInfo().getGroupId());
                com.baidu.tieba.im.data.b listMessage = groupMsgData.getListMessage();
                if (listMessage != null && (a2 = listMessage.a()) != null && a2.size() > 0) {
                    LinkedList<GroupMsgPojo> linkedList = new LinkedList<>();
                    int i = 0;
                    for (ChatMessage chatMessage : a2) {
                        VoiceMsgData e = com.baidu.tieba.im.e.d.e(chatMessage);
                        if (e != null) {
                            if (com.baidu.tieba.im.e.d.c(chatMessage)) {
                                e.setHas_read(1);
                            } else {
                                e.setHas_read(0);
                            }
                            chatMessage.setContent("[" + new Gson().toJson(e) + "]");
                        }
                        chatMessage.setLocalData(new MsgLocalData());
                        chatMessage.getLocalData().setStatus((short) 3);
                        GroupMsgPojo groupMsgPojo = new GroupMsgPojo(chatMessage);
                        if (chatMessage.getMsgType() == 11) {
                            try {
                                String optString = new JSONObject(chatMessage.getContent()).optString("eventId");
                                if ("105".equals(optString) || "106".equals(optString)) {
                                    GroupMemberChangeResponsedMessage groupMemberChangeResponsedMessage = new GroupMemberChangeResponsedMessage();
                                    groupMemberChangeResponsedMessage.setGroupId(valueOf);
                                    com.baidu.tieba.im.messageCenter.e.a().e(groupMemberChangeResponsedMessage);
                                }
                                SystemMsgData h = com.baidu.tieba.im.e.d.h(chatMessage);
                                if (h != null) {
                                    if (h.getIsSelf()) {
                                        i++;
                                        groupMsgPojo.setRead_flag(1);
                                    } else {
                                        groupMsgPojo.setRead_flag(0);
                                    }
                                }
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        } else if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getId() != null && chatMessage.getUserInfo().getId().equals(TiebaApplication.B())) {
                            groupMsgPojo.setRead_flag(0);
                        } else {
                            i++;
                            groupMsgPojo.setRead_flag(1);
                        }
                        linkedList.add(groupMsgPojo);
                        i = i;
                    }
                    int i2 = (MsglistActivity.f1534a && valueOf.equals(MsglistActivity.b)) ? 0 : i;
                    GroupMsgPojo last = linkedList.getLast();
                    last.checkRidAndSelf();
                    com.baidu.tieba.im.db.d.a().a(valueOf, linkedList, true, (com.baidu.tieba.im.a<Boolean>) new d(this, groupMsgData, valueOf, last, i2));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Message message) {
        if (message instanceof ChatResponsedMessage) {
            ChatResponsedMessage chatResponsedMessage = (ChatResponsedMessage) message;
            com.baidu.adp.lib.h.e.d("SHANG ChatResponsedMessage onAcked");
            if (chatResponsedMessage.hasError()) {
                a(chatResponsedMessage);
            } else {
                b(chatResponsedMessage);
            }
        }
    }

    private void a(ChatResponsedMessage chatResponsedMessage) {
        if (chatResponsedMessage != null && chatResponsedMessage.getOrginalMessage() != null) {
            ChatMessage chatMessage = (ChatMessage) chatResponsedMessage.getOrginalMessage();
            if (chatMessage == null) {
                com.baidu.adp.lib.h.e.a("chatMessage == null");
            } else {
                com.baidu.tieba.im.db.d.a().a(chatMessage.getGroupId(), String.valueOf(chatMessage.getRecordId()), String.valueOf(chatMessage.getMsgId()), 2, new e(this, chatResponsedMessage));
            }
        }
    }

    private void b(ChatResponsedMessage chatResponsedMessage) {
        com.baidu.tieba.im.db.d.a().a(chatResponsedMessage.getGroupId(), String.valueOf(chatResponsedMessage.getRecordId()), String.valueOf(chatResponsedMessage.getMsgId()), 3, new f(this, chatResponsedMessage));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(GroupMsgData groupMsgData, String str, GroupMsgPojo groupMsgPojo, int i) {
        com.baidu.tieba.im.db.ag.a().a(str, i, groupMsgPojo, new g(this, str, groupMsgPojo));
        if (this.b != null && this.b.get() != null) {
            this.b.get().a(groupMsgData);
        }
    }
}
