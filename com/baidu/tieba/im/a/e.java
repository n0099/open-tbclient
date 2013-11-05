package com.baidu.tieba.im.a;

import com.baidu.tieba.im.codec.n;
import com.baidu.tieba.im.codec.q;
import com.baidu.tieba.im.data.MembersData;
import com.baidu.tieba.im.data.UserData;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseMembersMessage;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class e implements n<com.baidu.tieba.im.codec.a.c> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.LinkedList, java.lang.Object, com.baidu.tieba.im.codec.q, int] */
    @Override // com.baidu.tieba.im.codec.n
    public /* bridge */ /* synthetic */ void a(LinkedList linkedList, com.baidu.tieba.im.codec.a.c cVar, q qVar, int i) {
        a2((LinkedList<Message>) linkedList, cVar, qVar, i);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void a2(LinkedList<Message> linkedList, com.baidu.tieba.im.codec.a.c cVar, q qVar, int i) {
        ResponseMembersMessage responseMembersMessage = new ResponseMembersMessage(103005);
        responseMembersMessage.setErrorInfo(qVar);
        responseMembersMessage.setCmd(i);
        linkedList.add(responseMembersMessage);
        if (cVar != null && !responseMembersMessage.hasError()) {
            MembersData membersData = new MembersData();
            com.baidu.tieba.im.codec.a.a d = cVar.d("userList");
            int a2 = d.a();
            ArrayList arrayList = new ArrayList();
            membersData.setUsers(arrayList);
            for (int i2 = 0; i2 < a2; i2++) {
                UserData userData = new UserData();
                com.baidu.tieba.im.codec.a.c a3 = d.a(i2);
                userData.setUserId(a3.c("userId"));
                userData.setUserName(a3.a("userName"));
                userData.setPortrait(a3.a("portrait"));
                userData.setSex(a3.b("sex"));
                userData.setPosition(a3.a("position"));
                userData.setLng(a3.a("lng"));
                userData.setLat(a3.a("lat"));
                userData.setInTime(a3.c("inTime"));
                userData.setLoginTime(a3.c("loginTime"));
                userData.setLastReplyTime(a3.c("lastReplyTime"));
                com.baidu.tieba.im.codec.a.c e = a3.e("permission");
                UserData.Permission permission = new UserData.Permission();
                permission.setIsGroupManager(e.b("isGroupManager"));
                permission.setIsGroupOwner(e.b("isGroupOwner"));
                userData.setPermission(permission);
                arrayList.add(userData);
            }
            com.baidu.tieba.im.codec.a.c e2 = cVar.e("permission");
            UserData.Permission permission2 = new UserData.Permission();
            permission2.setIsGroupOwner(e2.b("isGroupOwner"));
            permission2.setIsGroupManager(e2.b("isGroupManager"));
            membersData.setPermission(permission2);
            responseMembersMessage.setMembersData(membersData);
        }
    }
}
