package com.baidu.tieba.im.a;

import com.baidu.tieba.im.b.q;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseUserPermissionMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class o implements com.baidu.tieba.im.b.n<com.baidu.tieba.im.b.a.d> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.LinkedList, java.lang.Object, com.baidu.tieba.im.b.q, int] */
    @Override // com.baidu.tieba.im.b.n
    public /* bridge */ /* synthetic */ void a(LinkedList linkedList, com.baidu.tieba.im.b.a.d dVar, q qVar, int i) {
        a2((LinkedList<Message>) linkedList, dVar, qVar, i);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void a2(LinkedList<Message> linkedList, com.baidu.tieba.im.b.a.d dVar, q qVar, int i) {
        ResponseUserPermissionMessage responseUserPermissionMessage = new ResponseUserPermissionMessage(103002);
        responseUserPermissionMessage.setErrorInfo(qVar);
        responseUserPermissionMessage.setCmd(i);
        linkedList.add(responseUserPermissionMessage);
        if (dVar != null && !responseUserPermissionMessage.hasError()) {
            com.baidu.tieba.im.b.a.d f = dVar.f("groupPerm");
            GroupPermData groupPermData = new GroupPermData();
            if (f != null) {
                groupPermData.setIsManager(f.b("isForumManager"));
                groupPermData.setCanCreateNormal(f.b("canCreateNormal"));
                groupPermData.setCanCreateOfficial(f.b("canCreateOfficial"));
                groupPermData.setCanCreatePersonal(f.b("canCreatePersonal"));
                groupPermData.setCreateNormalTip(f.a("createNormalTip"));
                groupPermData.setCreateOfficialTip(f.a("createOfficialTip"));
                groupPermData.setCreatePersonalTip(f.a("createPersonalTip"));
            }
            responseUserPermissionMessage.setGroupPermData(groupPermData);
        }
    }
}
