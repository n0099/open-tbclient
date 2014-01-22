package com.baidu.tieba.im.model;

import com.baidu.tieba.im.data.UserData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {
    final /* synthetic */ com.baidu.tieba.im.message.b a;
    final /* synthetic */ com.baidu.tieba.im.message.b b;
    final /* synthetic */ MsglistModel c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(MsglistModel msglistModel, com.baidu.tieba.im.message.b bVar, com.baidu.tieba.im.message.b bVar2) {
        this.c = msglistModel;
        this.a = bVar;
        this.b = bVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0011, code lost:
        if (r1 != false) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.im.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        boolean q;
        int i;
        UserData userData;
        UserData userData2;
        boolean r;
        if (concurrentHashMap != null) {
            ImMessageCenterPojo imMessageCenterPojo = null;
            q = this.c.q();
            if (!q) {
                r = this.c.r();
            }
            if (this.a instanceof com.baidu.tieba.im.message.g) {
                imMessageCenterPojo = concurrentHashMap.get(((com.baidu.tieba.im.message.g) this.a).u());
                if (imMessageCenterPojo == null) {
                    if (this.b != null) {
                        imMessageCenterPojo.setLast_content_time(this.b.p() * 1000);
                        imMessageCenterPojo.setLast_content(com.baidu.tieba.im.d.d.h(this.b));
                        imMessageCenterPojo.setLast_user_name(this.b.g().getName());
                        imMessageCenterPojo.setLast_rid(this.b.j());
                        return;
                    }
                    imMessageCenterPojo.setLast_content(" ");
                    imMessageCenterPojo.setLast_user_name(" ");
                    return;
                }
                return;
            }
            i = this.c.e;
            if (i == 1) {
                userData = this.c.g;
                if (userData != null) {
                    userData2 = this.c.g;
                    imMessageCenterPojo = concurrentHashMap.get(String.valueOf(userData2.getUserId()));
                }
            }
            if (imMessageCenterPojo == null) {
            }
        }
    }
}
