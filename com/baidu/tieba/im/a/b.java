package com.baidu.tieba.im.a;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.im.codec.n;
import com.baidu.tieba.im.codec.q;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseFrsGroupsMessage;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b implements n<com.baidu.tieba.im.codec.a.c> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.LinkedList, java.lang.Object, com.baidu.tieba.im.codec.q, int] */
    @Override // com.baidu.tieba.im.codec.n
    public /* bridge */ /* synthetic */ void a(LinkedList linkedList, com.baidu.tieba.im.codec.a.c cVar, q qVar, int i) {
        a2((LinkedList<Message>) linkedList, cVar, qVar, i);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void a2(LinkedList<Message> linkedList, com.baidu.tieba.im.codec.a.c cVar, q qVar, int i) {
        ResponseFrsGroupsMessage responseFrsGroupsMessage = new ResponseFrsGroupsMessage(103002);
        responseFrsGroupsMessage.setErrorInfo(qVar);
        responseFrsGroupsMessage.setCmd(i);
        linkedList.add(responseFrsGroupsMessage);
        if (cVar != null && !responseFrsGroupsMessage.hasError()) {
            com.baidu.tieba.im.codec.a.a d = cVar.d("groups");
            int a2 = d.a();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < a2; i2++) {
                com.baidu.tieba.im.codec.a.c a3 = d.a(i2);
                GroupInfoData groupInfoData = new GroupInfoData();
                groupInfoData.setForumId(a3.b("forumId"));
                groupInfoData.setGroupId(a3.b("groupId"));
                groupInfoData.setIntro(a3.a("intro"));
                groupInfoData.setMaxMemberNum(a3.b("maxMemberNum"));
                groupInfoData.setMemberNum(a3.b("memberNum"));
                groupInfoData.setName(a3.a(SocialConstants.PARAM_MEDIA_UNAME));
                groupInfoData.setPortrait(a3.a("portrait"));
                groupInfoData.setGrade(a3.b("grade"));
                arrayList.add(groupInfoData);
            }
            responseFrsGroupsMessage.setGroups(arrayList);
            com.baidu.tieba.im.codec.a.c e = cVar.e("groupPerm");
            GroupPermData groupPermData = new GroupPermData();
            if (e != null) {
                groupPermData.setIsManager(e.b("isForumManager"));
                groupPermData.setCanCreateNormal(e.b("canCreateNormal"));
                groupPermData.setCanCreateOfficial(e.b("canCreateOfficial"));
                groupPermData.setCreateNormalTip(e.a("createNormalTip"));
                groupPermData.setCreateOfficialTip(e.a("createOfficialTip"));
            }
            responseFrsGroupsMessage.setGroupPerm(groupPermData);
        }
    }
}
