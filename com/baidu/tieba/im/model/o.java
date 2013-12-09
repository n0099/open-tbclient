package com.baidu.tieba.im.model;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.ChatMessage;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatMessage f1824a;
    final /* synthetic */ ChatMessage b;
    final /* synthetic */ MsglistModel c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(MsglistModel msglistModel, ChatMessage chatMessage, ChatMessage chatMessage2) {
        this.c = msglistModel;
        this.f1824a = chatMessage;
        this.b = chatMessage2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        ImMessageCenterPojo imMessageCenterPojo;
        if (concurrentHashMap != null && (imMessageCenterPojo = concurrentHashMap.get(this.f1824a.getGroupId())) != null) {
            if (this.b != null) {
                imMessageCenterPojo.setLast_content_time(this.b.getTime());
                imMessageCenterPojo.setLast_content(this.b.getContent());
                imMessageCenterPojo.setLast_user_name(this.b.getUserInfo().getName());
                return;
            }
            imMessageCenterPojo.setLast_content(" ");
            imMessageCenterPojo.setLast_user_name(" ");
        }
    }
}
