package com.baidu.tieba.im.a;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.im.codec.n;
import com.baidu.tieba.im.codec.q;
import com.baidu.tieba.im.data.UpdateGroupInfoData;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseUpdateGroupMessage;
import com.tencent.mm.sdk.conversation.RConversation;
import com.tencent.mm.sdk.message.RMsgInfo;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class j implements n<com.baidu.tieba.im.codec.a.c> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.LinkedList, java.lang.Object, com.baidu.tieba.im.codec.q, int] */
    @Override // com.baidu.tieba.im.codec.n
    public /* bridge */ /* synthetic */ void a(LinkedList linkedList, com.baidu.tieba.im.codec.a.c cVar, q qVar, int i) {
        a2((LinkedList<Message>) linkedList, cVar, qVar, i);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void a2(LinkedList<Message> linkedList, com.baidu.tieba.im.codec.a.c cVar, q qVar, int i) {
        ResponseUpdateGroupMessage responseUpdateGroupMessage = new ResponseUpdateGroupMessage(103102);
        responseUpdateGroupMessage.setErrorInfo(qVar);
        responseUpdateGroupMessage.setCmd(i);
        linkedList.add(responseUpdateGroupMessage);
        if (cVar != null && !responseUpdateGroupMessage.hasError()) {
            UpdateGroupInfoData updateGroupInfoData = new UpdateGroupInfoData();
            com.baidu.tieba.im.codec.a.c e = cVar.e("group");
            updateGroupInfoData.setGroupId(e.b("groupId"));
            updateGroupInfoData.setForumId(e.b("forumId"));
            updateGroupInfoData.setName(e.a(SocialConstants.PARAM_MEDIA_UNAME));
            updateGroupInfoData.setIntro(e.a("intro"));
            updateGroupInfoData.setPortrait(e.a("portrait"));
            updateGroupInfoData.setPosition(e.a("position"));
            updateGroupInfoData.setLng(e.a("lng"));
            updateGroupInfoData.setLat(e.a("lat"));
            updateGroupInfoData.setNotice(e.a("notice"));
            updateGroupInfoData.setAlbum(e.a("album"));
            updateGroupInfoData.setStatus(e.b("status"));
            updateGroupInfoData.setAuthorId(e.b("authorId"));
            updateGroupInfoData.setAuthorName(e.a("authorName"));
            updateGroupInfoData.setCreateTime(e.b(RMsgInfo.COL_CREATE_TIME));
            updateGroupInfoData.setMaxMemberNum(e.b("maxMemberNum"));
            updateGroupInfoData.setMemberNum(e.b("memberNum"));
            updateGroupInfoData.setGroupType(e.b("groupType"));
            updateGroupInfoData.setFlag(e.b(RConversation.COL_FLAG));
            responseUpdateGroupMessage.setUpdateGroupInfo(updateGroupInfoData);
        }
    }
}
