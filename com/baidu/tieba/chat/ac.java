package com.baidu.tieba.chat;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.chat.ChatData;
import com.baidu.tieba.data.chat.ChatMessageData;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends BdAsyncTask<Object, Integer, ChatData> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ab f1127a;
    private com.baidu.tieba.a.d b = null;
    private int c;

    public ac(ab abVar, int i) {
        this.f1127a = abVar;
        this.c = 0;
        this.c = i;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ad adVar;
        ad adVar2;
        super.b();
        adVar = this.f1127a.k;
        if (adVar != null) {
            adVar2 = this.f1127a.k;
            adVar2.a();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.a();
        }
        this.f1127a.i = null;
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
                chatData = this.f1127a.h;
                ChatMessageData lastMsg = chatData.getLastMsg();
                if (lastMsg != null) {
                    j = lastMsg.getMsgId();
                    break;
                }
                break;
            case 1:
                chatData2 = this.f1127a.h;
                ChatMessageData msg = chatData2.getMsg(0);
                if (msg != null) {
                    j = msg.getMsgId();
                    break;
                }
                break;
            case 2:
                ChatData chatData3 = new ChatData();
                cVar = this.f1127a.l;
                str = this.f1127a.b;
                str2 = this.f1127a.d;
                chatData3.setChatList((LinkedList) cVar.a(str, str2));
                return chatData3;
        }
        this.b = new com.baidu.tieba.a.d();
        com.baidu.tieba.a.d dVar = this.b;
        int i = this.c;
        str3 = this.f1127a.b;
        str4 = this.f1127a.d;
        String a2 = dVar.a(i, str3, str4, j);
        ChatData chatData4 = new ChatData();
        str5 = this.f1127a.d;
        chatData4.setFriendId(str5);
        str6 = this.f1127a.b;
        chatData4.setUserId(str6);
        chatData4.parserJson(a2);
        if (this.b.b() && this.b.d() == 0 && this.c == 0) {
            cVar2 = this.f1127a.l;
            cVar2.a(chatData4.getChatList());
            return chatData4;
        }
        return chatData4;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ChatData chatData) {
        ad adVar;
        ad adVar2;
        ad adVar3;
        ChatData chatData2;
        ChatData chatData3;
        ad adVar4;
        ChatData chatData4;
        ad adVar5;
        ChatData chatData5;
        ChatData chatData6;
        ChatData chatData7;
        ad adVar6;
        ad adVar7;
        ChatData chatData8;
        ChatData chatData9;
        ad adVar8;
        ChatData chatData10;
        super.a((ac) chatData);
        this.f1127a.i = null;
        if (this.c == 2) {
            if (chatData == null) {
                adVar6 = this.f1127a.k;
                adVar6.a(false, null, false, 0, null, true);
                return;
            }
            int size = chatData.getChatList().size();
            adVar7 = this.f1127a.k;
            adVar7.b();
            chatData8 = this.f1127a.h;
            chatData8.mergeData(chatData);
            chatData9 = this.f1127a.h;
            chatData9.setHasMore(chatData.getHasMore());
            adVar8 = this.f1127a.k;
            chatData10 = this.f1127a.h;
            adVar8.a(true, null, false, size, chatData10, true);
        } else if (this.b != null && chatData != null) {
            if (!this.b.b()) {
                adVar = this.f1127a.k;
                adVar.a(false, this.b.c(), false, 0, null, false);
            } else if (this.b.d() != 0) {
                adVar2 = this.f1127a.k;
                adVar2.a(false, this.b.e(), false, 0, null, false);
            } else {
                int size2 = chatData.getChatList().size();
                adVar3 = this.f1127a.k;
                adVar3.b();
                chatData2 = this.f1127a.h;
                chatData2.mergeData(chatData);
                chatData3 = this.f1127a.h;
                chatData3.setHasMore(chatData.getHasMore());
                if (chatData.getFriendPortrait() != null && chatData.getFriendPortrait().length() > 0) {
                    chatData7 = this.f1127a.h;
                    chatData7.setFriendPortrait(chatData.getFriendPortrait());
                }
                if (chatData.getUserPortrait() != null && chatData.getUserPortrait().length() > 0) {
                    chatData6 = this.f1127a.h;
                    chatData6.setUserPortrait(chatData.getUserPortrait());
                }
                switch (this.c) {
                    case 0:
                        adVar5 = this.f1127a.k;
                        chatData5 = this.f1127a.h;
                        adVar5.a(true, null, true, size2, chatData5, false);
                        return;
                    case 1:
                        adVar4 = this.f1127a.k;
                        chatData4 = this.f1127a.h;
                        adVar4.a(true, null, false, size2, chatData4, false);
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
