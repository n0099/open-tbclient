package com.baidu.tieba.im.a;

import com.baidu.tieba.im.codec.n;
import com.baidu.tieba.im.codec.q;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseUserPermissionMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class k implements n<com.baidu.tieba.im.codec.a.c> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.LinkedList, java.lang.Object, com.baidu.tieba.im.codec.q, int] */
    @Override // com.baidu.tieba.im.codec.n
    public /* bridge */ /* synthetic */ void a(LinkedList linkedList, com.baidu.tieba.im.codec.a.c cVar, q qVar, int i) {
        a2((LinkedList<Message>) linkedList, cVar, qVar, i);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void a2(LinkedList<Message> linkedList, com.baidu.tieba.im.codec.a.c cVar, q qVar, int i) {
        ResponseUserPermissionMessage responseUserPermissionMessage = new ResponseUserPermissionMessage(103002);
        responseUserPermissionMessage.setErrorInfo(qVar);
        responseUserPermissionMessage.setCmd(i);
        linkedList.add(responseUserPermissionMessage);
        if (cVar != null && !responseUserPermissionMessage.hasError()) {
            com.baidu.tieba.im.codec.a.c e = cVar.e("groupPerm");
            GroupPermData groupPermData = new GroupPermData();
            if (e != null) {
                groupPermData.setIsManager(e.b("isForumManager"));
                groupPermData.setCanCreateNormal(e.b("canCreateNormal"));
                groupPermData.setCanCreateOfficial(e.b("canCreateOfficial"));
                groupPermData.setCreateNormalTip(e.a("createNormalTip"));
                groupPermData.setCreateOfficialTip(e.a("createOfficialTip"));
            }
            responseUserPermissionMessage.setGroupPermData(groupPermData);
        }
    }
}
