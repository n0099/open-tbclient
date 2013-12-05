package com.baidu.tieba.im.a;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.im.b.q;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseFrsGroupsMessage;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.im.b.n<com.baidu.tieba.im.b.a.d> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.LinkedList, java.lang.Object, com.baidu.tieba.im.b.q, int] */
    @Override // com.baidu.tieba.im.b.n
    public /* bridge */ /* synthetic */ void a(LinkedList linkedList, com.baidu.tieba.im.b.a.d dVar, q qVar, int i) {
        a2((LinkedList<Message>) linkedList, dVar, qVar, i);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void a2(LinkedList<Message> linkedList, com.baidu.tieba.im.b.a.d dVar, q qVar, int i) {
        ResponseFrsGroupsMessage responseFrsGroupsMessage = new ResponseFrsGroupsMessage(103002);
        responseFrsGroupsMessage.setErrorInfo(qVar);
        responseFrsGroupsMessage.setCmd(i);
        linkedList.add(responseFrsGroupsMessage);
        if (dVar != null && !responseFrsGroupsMessage.hasError()) {
            com.baidu.tieba.im.b.a.a e = dVar.e("groups");
            int a2 = e.a();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < a2; i2++) {
                com.baidu.tieba.im.b.a.d a3 = e.a(i2);
                GroupInfoData groupInfoData = new GroupInfoData();
                groupInfoData.setForumId(a3.b("forumId"));
                groupInfoData.setGroupId(a3.b("groupId"));
                groupInfoData.setIntro(a3.a("intro"));
                groupInfoData.setMaxMemberNum(a3.b("maxMemberNum"));
                groupInfoData.setMemberNum(a3.b("memberNum"));
                groupInfoData.setName(a3.a(SocialConstants.PARAM_MEDIA_UNAME));
                groupInfoData.setAuthorIsMeizhi(a3.b("authorIsMeizhi"));
                groupInfoData.setPortrait(a3.a("portrait"));
                groupInfoData.setGrade(a3.b("grade"));
                arrayList.add(groupInfoData);
            }
            responseFrsGroupsMessage.setGroups(arrayList);
            com.baidu.tieba.im.b.a.d f = dVar.f("groupPerm");
            GroupPermData groupPermData = new GroupPermData();
            if (f != null) {
                groupPermData.setIsManager(f.b("isForumManager"));
                groupPermData.setCanCreateNormal(f.b("canCreateNormal"));
                groupPermData.setCanCreateOfficial(f.b("canCreateOfficial"));
                groupPermData.setCreateNormalTip(f.a("createNormalTip"));
                groupPermData.setCreateOfficialTip(f.a("createOfficialTip"));
            }
            responseFrsGroupsMessage.setGroupPerm(groupPermData);
        }
    }
}
