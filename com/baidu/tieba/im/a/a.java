package com.baidu.tieba.im.a;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.im.codec.n;
import com.baidu.tieba.im.codec.q;
import com.baidu.tieba.im.data.AddGroupInfoData;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseAddGroupMessage;
import com.tencent.mm.sdk.message.RMsgInfo;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class a implements n<com.baidu.tieba.im.codec.a.c> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.LinkedList, java.lang.Object, com.baidu.tieba.im.codec.q, int] */
    @Override // com.baidu.tieba.im.codec.n
    public /* bridge */ /* synthetic */ void a(LinkedList linkedList, com.baidu.tieba.im.codec.a.c cVar, q qVar, int i) {
        a2((LinkedList<Message>) linkedList, cVar, qVar, i);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void a2(LinkedList<Message> linkedList, com.baidu.tieba.im.codec.a.c cVar, q qVar, int i) {
        ResponseAddGroupMessage responseAddGroupMessage = new ResponseAddGroupMessage(103101);
        responseAddGroupMessage.setErrorInfo(qVar);
        responseAddGroupMessage.setCmd(i);
        linkedList.add(responseAddGroupMessage);
        if (cVar != null && !responseAddGroupMessage.hasError()) {
            AddGroupInfoData addGroupInfoData = new AddGroupInfoData();
            com.baidu.tieba.im.codec.a.c e = cVar.e("group");
            addGroupInfoData.setGroupId(e.b("groupId"));
            addGroupInfoData.setForumId(e.b("forumId"));
            addGroupInfoData.setName(e.a(SocialConstants.PARAM_MEDIA_UNAME));
            addGroupInfoData.setIntro(e.a("intro"));
            addGroupInfoData.setPortrait(e.a("portrait"));
            addGroupInfoData.setPosition(e.a("position"));
            addGroupInfoData.setLng(e.a("lng"));
            addGroupInfoData.setLat(e.a("lat"));
            addGroupInfoData.setNotice(e.a("notice"));
            addGroupInfoData.setAlbum(e.a("album"));
            addGroupInfoData.setStatus(e.b("status"));
            addGroupInfoData.setAuthorId(e.b("authorId"));
            addGroupInfoData.setAuthorName(e.a("authorName"));
            addGroupInfoData.setCreateTime(e.b(RMsgInfo.COL_CREATE_TIME));
            addGroupInfoData.setMaxMemberNum(e.b("maxMemberNum"));
            addGroupInfoData.setMemberNum(e.b("memberNum"));
            addGroupInfoData.setGroupType(e.b("groupType"));
            responseAddGroupMessage.setAddGroupInfo(addGroupInfoData);
        }
    }
}
