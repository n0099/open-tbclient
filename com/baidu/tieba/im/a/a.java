package com.baidu.tieba.im.a;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.im.b.q;
import com.baidu.tieba.im.data.AddGroupInfoData;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseAddGroupMessage;
import com.tencent.mm.sdk.message.RMsgInfo;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.im.b.n<com.baidu.tieba.im.b.a.d> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.LinkedList, java.lang.Object, com.baidu.tieba.im.b.q, int] */
    @Override // com.baidu.tieba.im.b.n
    public /* bridge */ /* synthetic */ void a(LinkedList linkedList, com.baidu.tieba.im.b.a.d dVar, q qVar, int i) {
        a2((LinkedList<Message>) linkedList, dVar, qVar, i);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void a2(LinkedList<Message> linkedList, com.baidu.tieba.im.b.a.d dVar, q qVar, int i) {
        ResponseAddGroupMessage responseAddGroupMessage = new ResponseAddGroupMessage(103101);
        responseAddGroupMessage.setErrorInfo(qVar);
        responseAddGroupMessage.setCmd(i);
        linkedList.add(responseAddGroupMessage);
        if (dVar != null && !responseAddGroupMessage.hasError()) {
            AddGroupInfoData addGroupInfoData = new AddGroupInfoData();
            com.baidu.tieba.im.b.a.d f = dVar.f("group");
            addGroupInfoData.setGroupId(f.b("groupId"));
            addGroupInfoData.setForumId(f.b("forumId"));
            addGroupInfoData.setName(f.a(SocialConstants.PARAM_MEDIA_UNAME));
            addGroupInfoData.setIntro(f.a("intro"));
            addGroupInfoData.setPortrait(f.a("portrait"));
            addGroupInfoData.setPosition(f.a("position"));
            addGroupInfoData.setLng(f.a("lng"));
            addGroupInfoData.setLat(f.a("lat"));
            addGroupInfoData.setNotice(f.a("notice"));
            addGroupInfoData.setAlbum(f.a("album"));
            addGroupInfoData.setStatus(f.b("status"));
            addGroupInfoData.setAuthorId(f.b("authorId"));
            addGroupInfoData.setAuthorName(f.a("authorName"));
            addGroupInfoData.setCreateTime(f.b(RMsgInfo.COL_CREATE_TIME));
            addGroupInfoData.setMaxMemberNum(f.b("maxMemberNum"));
            addGroupInfoData.setMemberNum(f.b("memberNum"));
            addGroupInfoData.setGroupType(f.b("groupType"));
            responseAddGroupMessage.setAddGroupInfo(addGroupInfoData);
        }
    }
}
