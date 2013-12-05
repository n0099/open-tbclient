package com.baidu.tieba.chat;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.chat.ChatData;
import com.baidu.tieba.data.chat.ChatMessageData;
import com.baidu.tieba.data.chat.ChatPostData;
import com.baidu.tieba.util.bd;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends BdAsyncTask<Object, Integer, ChatData> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ag f1177a;
    private com.baidu.tieba.a.c b = null;

    public ah(ag agVar) {
        this.f1177a = agVar;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ai aiVar;
        ai aiVar2;
        super.b();
        aiVar = this.f1177a.c;
        if (aiVar != null) {
            aiVar2 = this.f1177a.c;
            aiVar2.a();
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
        chatPostData = this.f1177a.f1176a;
        String a2 = cVar2.a(chatPostData);
        bd.a(getClass().getName(), "postData", a2);
        ChatData chatData = new ChatData();
        chatPostData2 = this.f1177a.f1176a;
        chatData.setFriendId(chatPostData2.getFriendID());
        chatPostData3 = this.f1177a.f1176a;
        chatData.setUserId(chatPostData3.getUserID());
        try {
            ChatMessageData newMessage = ChatMessageData.newMessage();
            chatPostData4 = this.f1177a.f1176a;
            newMessage.setFriendId(chatPostData4.getFriendID());
            chatPostData5 = this.f1177a.f1176a;
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
            cVar = this.f1177a.d;
            cVar.a(chatData.getChatList());
        } catch (Exception e) {
            bd.b(getClass().getName(), "doInBackground", e.toString());
        }
        return chatData;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.a();
        }
        this.f1177a.b = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ChatData chatData) {
        ai aiVar;
        ai aiVar2;
        ai aiVar3;
        ai aiVar4;
        ai aiVar5;
        ai aiVar6;
        super.a((ah) chatData);
        if (this.b != null) {
            if (!this.b.b()) {
                aiVar = this.f1177a.c;
                if (aiVar != null) {
                    aiVar2 = this.f1177a.c;
                    aiVar2.a(false, this.b.c(), null);
                }
            } else if (this.b.d() == 0) {
                aiVar5 = this.f1177a.c;
                if (aiVar5 != null) {
                    aiVar6 = this.f1177a.c;
                    aiVar6.a(true, null, chatData);
                }
            } else {
                aiVar3 = this.f1177a.c;
                if (aiVar3 != null) {
                    aiVar4 = this.f1177a.c;
                    aiVar4.a(false, this.b.e(), null);
                }
            }
        }
        this.f1177a.b = null;
    }
}
