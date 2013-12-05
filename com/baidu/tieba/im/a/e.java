package com.baidu.tieba.im.a;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.im.b.q;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseHotGroupsMessage;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.im.b.n<com.baidu.tieba.im.b.a.d> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.LinkedList, java.lang.Object, com.baidu.tieba.im.b.q, int] */
    @Override // com.baidu.tieba.im.b.n
    public /* bridge */ /* synthetic */ void a(LinkedList linkedList, com.baidu.tieba.im.b.a.d dVar, q qVar, int i) {
        a2((LinkedList<Message>) linkedList, dVar, qVar, i);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void a2(LinkedList<Message> linkedList, com.baidu.tieba.im.b.a.d dVar, q qVar, int i) {
        ResponseHotGroupsMessage responseHotGroupsMessage = new ResponseHotGroupsMessage();
        responseHotGroupsMessage.setErrorInfo(qVar);
        responseHotGroupsMessage.setCmd(i);
        linkedList.add(responseHotGroupsMessage);
        if (dVar != null && !responseHotGroupsMessage.hasError()) {
            com.baidu.tieba.im.b.a.a e = dVar.e("groups");
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < e.a(); i2++) {
                com.baidu.tieba.im.b.a.d a2 = e.a(i2);
                GroupInfoData groupInfoData = new GroupInfoData();
                groupInfoData.setGroupId(a2.b("groupId"));
                groupInfoData.setForumId(a2.b("forumId"));
                groupInfoData.setForumName(a2.a("forumName"));
                groupInfoData.setForumShowName(a2.a("forumShowName"));
                groupInfoData.setName(a2.a(SocialConstants.PARAM_MEDIA_UNAME));
                groupInfoData.setIntro(a2.a("intro"));
                groupInfoData.setPortrait(a2.a("portrait"));
                groupInfoData.setMaxMemberNum(a2.b("maxMemberNum"));
                groupInfoData.setMemberNum(a2.b("memberNum"));
                groupInfoData.setAuthorId(a2.b("authorId"));
                groupInfoData.setAuthorName(a2.a("authorName"));
                groupInfoData.setGrade(a2.b("grade"));
                arrayList.add(groupInfoData);
            }
            responseHotGroupsMessage.setGroups(arrayList);
            if (dVar.b("hasMore") == 1) {
                responseHotGroupsMessage.setHasMore(true);
            } else {
                responseHotGroupsMessage.setHasMore(false);
            }
        }
    }
}
