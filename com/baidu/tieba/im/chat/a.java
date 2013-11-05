package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.SystemMsgData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.GroupMsgPojo;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.ChatMessage;
import com.baidu.tieba.im.message.ChatResponsedMessage;
import com.baidu.tieba.im.message.GroupMemberChangeResponsedMessage;
import com.baidu.tieba.im.message.Message;
import com.google.gson.Gson;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f1403a = null;
    private WeakReference<y> b;
    private j c = null;
    private com.baidu.tieba.im.pushNotify.m d = null;

    private a() {
    }

    public void a() {
        this.c = new j(this, null);
        com.baidu.tieba.im.messageCenter.f.a().a(-100, this.c);
        com.baidu.tieba.im.messageCenter.f.a().a(202001, this.c);
        com.baidu.tieba.im.messageCenter.f.a().a(-103, this.c);
        com.baidu.tieba.im.messageCenter.f.a().a(-105, this.c);
        this.d = new b(this);
        com.baidu.tieba.im.pushNotify.n.a().a("kick_out", this.d);
    }

    public static a b() {
        if (f1403a == null) {
            f1403a = new a();
        }
        return f1403a;
    }

    public void a(y yVar) {
        this.b = new WeakReference<>(yVar);
    }

    public void c() {
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo == null) {
            com.baidu.adp.lib.h.d.a("null return");
        } else if (groupNewsPojo.getCmd().equals("kick_out")) {
            try {
                String optString = new JSONObject(groupNewsPojo.getContent()).optJSONObject("eventParam").optString("groupId");
                if (!TextUtils.isEmpty(optString)) {
                    com.baidu.tieba.im.db.x.a().a(new c(this, optString, groupNewsPojo));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(String str, z zVar) {
        com.baidu.tieba.im.db.a.a().a(str, 2, (String) null, LocationClientOption.MIN_SCAN_SPAN, new d(this, zVar));
    }

    public void a(ChatMessage chatMessage) {
        com.baidu.adp.lib.h.d.d("SHNAG chatManager sendMessage, content = " + chatMessage.getContent());
        LinkedList<GroupMsgPojo> linkedList = new LinkedList<>();
        GroupMsgPojo groupMsgPojo = new GroupMsgPojo(chatMessage);
        groupMsgPojo.setRead_flag(0);
        linkedList.add(groupMsgPojo);
        com.baidu.tieba.im.db.a.a().a(chatMessage.getGroupId(), linkedList, false, new e(this, chatMessage));
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
                        VoiceMsgData e = com.baidu.tieba.im.d.c.e(chatMessage);
                        if (e != null) {
                            if (com.baidu.tieba.im.d.c.c(chatMessage)) {
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
                            GroupMemberChangeResponsedMessage groupMemberChangeResponsedMessage = new GroupMemberChangeResponsedMessage();
                            groupMemberChangeResponsedMessage.setGroupId(valueOf);
                            com.baidu.tieba.im.messageCenter.f.a().e(groupMemberChangeResponsedMessage);
                            SystemMsgData h = com.baidu.tieba.im.d.c.h(chatMessage);
                            if (h != null) {
                                if (h.getIsSelf()) {
                                    i++;
                                    groupMsgPojo.setRead_flag(1);
                                } else {
                                    groupMsgPojo.setRead_flag(0);
                                }
                            }
                        } else if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getId() != null && chatMessage.getUserInfo().getId().equals(TiebaApplication.C())) {
                            groupMsgPojo.setRead_flag(0);
                        } else {
                            i++;
                            groupMsgPojo.setRead_flag(1);
                        }
                        linkedList.add(groupMsgPojo);
                        i = i;
                    }
                    com.baidu.tieba.im.db.a.a().a(valueOf, linkedList, true, new f(this, groupMsgData, valueOf, linkedList.getLast(), (MsglistActivity.f1401a && valueOf.equals(MsglistActivity.b)) ? 0 : i));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Message message) {
        if (message instanceof ChatResponsedMessage) {
            ChatResponsedMessage chatResponsedMessage = (ChatResponsedMessage) message;
            com.baidu.adp.lib.h.d.d("SHANG ChatResponsedMessage onAcked");
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
                com.baidu.adp.lib.h.d.a("chatMessage == null");
            } else {
                com.baidu.tieba.im.db.a.a().a(chatMessage.getGroupId(), String.valueOf(chatMessage.getRecordId()), String.valueOf(chatMessage.getMsgId()), 2, new g(this, chatResponsedMessage));
            }
        }
    }

    private void b(ChatResponsedMessage chatResponsedMessage) {
        com.baidu.tieba.im.db.a.a().a(chatResponsedMessage.getGroupId(), String.valueOf(chatResponsedMessage.getRecordId()), String.valueOf(chatResponsedMessage.getMsgId()), 3, new h(this, chatResponsedMessage));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(GroupMsgData groupMsgData, String str, GroupMsgPojo groupMsgPojo, int i) {
        com.baidu.tieba.im.db.aa.a().a(str, i, groupMsgPojo, new i(this, str, groupMsgPojo));
        if (this.b != null && this.b.get() != null) {
            this.b.get().a(groupMsgData);
        }
    }
}
