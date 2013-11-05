package com.baidu.tieba.im.a;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.im.codec.n;
import com.baidu.tieba.im.codec.q;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseGroupsByUidMessage;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class f implements n<com.baidu.tieba.im.codec.a.c> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.LinkedList, java.lang.Object, com.baidu.tieba.im.codec.q, int] */
    @Override // com.baidu.tieba.im.codec.n
    public /* bridge */ /* synthetic */ void a(LinkedList linkedList, com.baidu.tieba.im.codec.a.c cVar, q qVar, int i) {
        a2((LinkedList<Message>) linkedList, cVar, qVar, i);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void a2(LinkedList<Message> linkedList, com.baidu.tieba.im.codec.a.c cVar, q qVar, int i) {
        ResponseGroupsByUidMessage responseGroupsByUidMessage = new ResponseGroupsByUidMessage(103003);
        responseGroupsByUidMessage.setErrorInfo(qVar);
        responseGroupsByUidMessage.setCmd(i);
        linkedList.add(responseGroupsByUidMessage);
        if (cVar != null && !responseGroupsByUidMessage.hasError()) {
            com.baidu.tieba.im.codec.a.a d = cVar.d("groups");
            ArrayList arrayList = new ArrayList();
            int a2 = d.a();
            for (int i2 = 0; i2 < a2; i2++) {
                com.baidu.tieba.im.codec.a.c a3 = d.a(i2);
                GroupInfoData groupInfoData = new GroupInfoData();
                groupInfoData.setIsGroupManager(a3.b("isGroupManager"));
                groupInfoData.setForumId(a3.b("forumId"));
                groupInfoData.setGroupId(a3.b("groupId"));
                groupInfoData.setIntro(a3.a("intro"));
                groupInfoData.setMaxMemberNum(a3.b("maxMemberNum"));
                groupInfoData.setMemberNum(a3.b("memberNum"));
                groupInfoData.setName(a3.a(SocialConstants.PARAM_MEDIA_UNAME));
                groupInfoData.setPortrait(a3.a("portrait"));
                groupInfoData.setAuthorId(a3.b("authorId"));
                groupInfoData.setAuthorName(a3.a("authorName"));
                groupInfoData.setGrade(a3.b("grade"));
                arrayList.add(groupInfoData);
            }
            responseGroupsByUidMessage.setGroups(arrayList);
            com.baidu.tieba.im.codec.a.c e = cVar.e("groupPerm");
            GroupPermData groupPermData = new GroupPermData();
            groupPermData.setIsManager(e.b("isForumManager"));
            groupPermData.setCanCreateNormal(e.b("canCreateNormal"));
            groupPermData.setCanCreateOfficial(e.b("canCreateOfficial"));
            groupPermData.setCreateNormalTip(e.a("createNormalTip"));
            groupPermData.setCreateOfficialTip(e.a("createOfficialTip"));
            groupPermData.setCanCreatePersonal(e.b("canCreatePersonal"));
            groupPermData.setCreatePersonalTip(e.a("createPersonalTip"));
            responseGroupsByUidMessage.setGroupPerm(groupPermData);
        }
    }
}
