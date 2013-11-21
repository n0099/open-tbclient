package com.baidu.tieba.chat;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.chat.ChatData;
import com.baidu.tieba.data.chat.ChatMessageData;
import com.baidu.tieba.data.chat.ChatPostData;
import com.baidu.tieba.util.bg;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends BdAsyncTask<Object, Integer, ChatData> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ af f1130a;
    private com.baidu.tieba.a.c b = null;

    public ag(af afVar) {
        this.f1130a = afVar;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ah ahVar;
        ah ahVar2;
        super.b();
        ahVar = this.f1130a.c;
        if (ahVar != null) {
            ahVar2 = this.f1130a.c;
            ahVar2.a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public ChatData a(Object... objArr) {
        ChatPostData chatPostData;
        ChatPostData chatPostData2;
        ChatPostData chatPostData3;
        ChatPostData chatPostData4;
        ChatPostData chatPostData5;
        com.baidu.tieba.data.chat.c cVar;
        this.b = new com.baidu.tieba.a.c();
        com.baidu.tieba.a.c cVar2 = this.b;
        chatPostData = this.f1130a.f1129a;
        String a2 = cVar2.a(chatPostData);
        bg.a(getClass().getName(), "postData", a2);
        ChatData chatData = new ChatData();
        chatPostData2 = this.f1130a.f1129a;
        chatData.setFriendId(chatPostData2.getFriendID());
        chatPostData3 = this.f1130a.f1129a;
        chatData.setUserId(chatPostData3.getUserID());
        try {
            ChatMessageData newMessage = ChatMessageData.newMessage();
            chatPostData4 = this.f1130a.f1129a;
            newMessage.setFriendId(chatPostData4.getFriendID());
            chatPostData5 = this.f1130a.f1129a;
            newMessage.setOwnerId(chatPostData5.getUserID());
            JSONObject jSONObject = new JSONObject(a2);
            newMessage.parserJson(jSONObject.optJSONObject("message"));
            chatData.parserJson(jSONObject.optJSONObject("recent"));
            if (chatData.getChatList().size() > 0) {
                if (!chatData.getHasMore() && chatData.getChatList().getLast().getMsgId() != newMessage.getMsgId()) {
                    chatData.addChatData(newMessage);
                }
            } else {
                chatData.addChatData(newMessage);
            }
            cVar = this.f1130a.d;
            cVar.a(chatData.getChatList());
        } catch (Exception e) {
            bg.b(getClass().getName(), "doInBackground", e.toString());
        }
        return chatData;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.a();
        }
        this.f1130a.b = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ChatData chatData) {
        ah ahVar;
        ah ahVar2;
        ah ahVar3;
        ah ahVar4;
        ah ahVar5;
        ah ahVar6;
        super.a((ag) chatData);
        if (this.b != null) {
            if (!this.b.b()) {
                ahVar = this.f1130a.c;
                if (ahVar != null) {
                    ahVar2 = this.f1130a.c;
                    ahVar2.a(false, this.b.c(), null);
                }
            } else if (this.b.d() == 0) {
                ahVar5 = this.f1130a.c;
                if (ahVar5 != null) {
                    ahVar6 = this.f1130a.c;
                    ahVar6.a(true, null, chatData);
                }
            } else {
                ahVar3 = this.f1130a.c;
                if (ahVar3 != null) {
                    ahVar4 = this.f1130a.c;
                    ahVar4.a(false, this.b.e(), null);
                }
            }
        }
        this.f1130a.b = null;
    }
}
