package com.baidu.tieba.chat;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.chat.ChatData;
import com.baidu.tieba.data.chat.ChatMessageData;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends BdAsyncTask<Object, Integer, ChatData> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ac f1174a;
    private com.baidu.tieba.a.d b = null;
    private int c;

    public ad(ac acVar, int i) {
        this.f1174a = acVar;
        this.c = 0;
        this.c = i;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ae aeVar;
        ae aeVar2;
        super.b();
        aeVar = this.f1174a.k;
        if (aeVar != null) {
            aeVar2 = this.f1174a.k;
            aeVar2.a();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.a();
        }
        this.f1174a.i = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public ChatData a(Object... objArr) {
        com.baidu.tieba.data.chat.c cVar;
        String str;
        String str2;
        ChatData chatData;
        ChatData chatData2;
        String str3;
        String str4;
        String str5;
        String str6;
        com.baidu.tieba.data.chat.c cVar2;
        long j = 0;
        switch (this.c) {
            case 0:
                chatData = this.f1174a.h;
                ChatMessageData lastMsg = chatData.getLastMsg();
                if (lastMsg != null) {
                    j = lastMsg.getMsgId();
                    break;
                }
                break;
            case 1:
                chatData2 = this.f1174a.h;
                ChatMessageData msg = chatData2.getMsg(0);
                if (msg != null) {
                    j = msg.getMsgId();
                    break;
                }
                break;
            case 2:
                ChatData chatData3 = new ChatData();
                cVar = this.f1174a.l;
                str = this.f1174a.b;
                str2 = this.f1174a.d;
                chatData3.setChatList((LinkedList) cVar.a(str, str2));
                return chatData3;
        }
        this.b = new com.baidu.tieba.a.d();
        com.baidu.tieba.a.d dVar = this.b;
        int i = this.c;
        str3 = this.f1174a.b;
        str4 = this.f1174a.d;
        String a2 = dVar.a(i, str3, str4, j);
        ChatData chatData4 = new ChatData();
        str5 = this.f1174a.d;
        chatData4.setFriendId(str5);
        str6 = this.f1174a.b;
        chatData4.setUserId(str6);
        chatData4.parserJson(a2);
        if (this.b.b() && this.b.d() == 0 && this.c == 0) {
            cVar2 = this.f1174a.l;
            cVar2.a(chatData4.getChatList());
            return chatData4;
        }
        return chatData4;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ChatData chatData) {
        ae aeVar;
        ae aeVar2;
        ae aeVar3;
        ChatData chatData2;
        ChatData chatData3;
        ae aeVar4;
        ChatData chatData4;
        ae aeVar5;
        ChatData chatData5;
        ChatData chatData6;
        ChatData chatData7;
        ae aeVar6;
        ae aeVar7;
        ChatData chatData8;
        ChatData chatData9;
        ae aeVar8;
        ChatData chatData10;
        super.a((ad) chatData);
        this.f1174a.i = null;
        if (this.c == 2) {
            if (chatData == null) {
                aeVar6 = this.f1174a.k;
                aeVar6.a(false, null, false, 0, null, true);
                return;
            }
            int size = chatData.getChatList().size();
            aeVar7 = this.f1174a.k;
            aeVar7.b();
            chatData8 = this.f1174a.h;
            chatData8.mergeData(chatData);
            chatData9 = this.f1174a.h;
            chatData9.setHasMore(chatData.getHasMore());
            aeVar8 = this.f1174a.k;
            chatData10 = this.f1174a.h;
            aeVar8.a(true, null, false, size, chatData10, true);
        } else if (this.b != null && chatData != null) {
            if (!this.b.b()) {
                aeVar = this.f1174a.k;
                aeVar.a(false, this.b.c(), false, 0, null, false);
            } else if (this.b.d() != 0) {
                aeVar2 = this.f1174a.k;
                aeVar2.a(false, this.b.e(), false, 0, null, false);
            } else {
                int size2 = chatData.getChatList().size();
                aeVar3 = this.f1174a.k;
                aeVar3.b();
                chatData2 = this.f1174a.h;
                chatData2.mergeData(chatData);
                chatData3 = this.f1174a.h;
                chatData3.setHasMore(chatData.getHasMore());
                if (chatData.getFriendPortrait() != null && chatData.getFriendPortrait().length() > 0) {
                    chatData7 = this.f1174a.h;
                    chatData7.setFriendPortrait(chatData.getFriendPortrait());
                }
                if (chatData.getUserPortrait() != null && chatData.getUserPortrait().length() > 0) {
                    chatData6 = this.f1174a.h;
                    chatData6.setUserPortrait(chatData.getUserPortrait());
                }
                switch (this.c) {
                    case 0:
                        aeVar5 = this.f1174a.k;
                        chatData5 = this.f1174a.h;
                        aeVar5.a(true, null, true, size2, chatData5, false);
                        return;
                    case 1:
                        aeVar4 = this.f1174a.k;
                        chatData4 = this.f1174a.h;
                        aeVar4.a(true, null, false, size2, chatData4, false);
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
