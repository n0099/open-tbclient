package com.baidu.tieba.im.a;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.im.b.q;
import com.baidu.tieba.im.data.UpdateGroupInfoData;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseUpdateGroupMessage;
import com.tencent.mm.sdk.conversation.RConversation;
import com.tencent.mm.sdk.message.RMsgInfo;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class n implements com.baidu.tieba.im.b.n<com.baidu.tieba.im.b.a.d> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.LinkedList, java.lang.Object, com.baidu.tieba.im.b.q, int] */
    @Override // com.baidu.tieba.im.b.n
    public /* bridge */ /* synthetic */ void a(LinkedList linkedList, com.baidu.tieba.im.b.a.d dVar, q qVar, int i) {
        a2((LinkedList<Message>) linkedList, dVar, qVar, i);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void a2(LinkedList<Message> linkedList, com.baidu.tieba.im.b.a.d dVar, q qVar, int i) {
        ResponseUpdateGroupMessage responseUpdateGroupMessage = new ResponseUpdateGroupMessage(103102);
        responseUpdateGroupMessage.setErrorInfo(qVar);
        responseUpdateGroupMessage.setCmd(i);
        linkedList.add(responseUpdateGroupMessage);
        if (dVar != null && !responseUpdateGroupMessage.hasError()) {
            UpdateGroupInfoData updateGroupInfoData = new UpdateGroupInfoData();
            com.baidu.tieba.im.b.a.d f = dVar.f("group");
            updateGroupInfoData.setGroupId(f.b("groupId"));
            updateGroupInfoData.setForumId(f.b("forumId"));
            updateGroupInfoData.setName(f.a(SocialConstants.PARAM_MEDIA_UNAME));
            updateGroupInfoData.setIntro(f.a("intro"));
            updateGroupInfoData.setPortrait(f.a("portrait"));
            updateGroupInfoData.setPosition(f.a("position"));
            updateGroupInfoData.setLng(f.a("lng"));
            updateGroupInfoData.setLat(f.a("lat"));
            updateGroupInfoData.setNotice(f.a("notice"));
            updateGroupInfoData.setAlbum(f.a("album"));
            updateGroupInfoData.setStatus(f.b("status"));
            updateGroupInfoData.setAuthorId(f.b("authorId"));
            updateGroupInfoData.setAuthorName(f.a("authorName"));
            updateGroupInfoData.setCreateTime(f.b(RMsgInfo.COL_CREATE_TIME));
            updateGroupInfoData.setMaxMemberNum(f.b("maxMemberNum"));
            updateGroupInfoData.setMemberNum(f.b("memberNum"));
            updateGroupInfoData.setGroupType(f.b("groupType"));
            updateGroupInfoData.setFlag(f.b(RConversation.COL_FLAG));
            responseUpdateGroupMessage.setUpdateGroupInfo(updateGroupInfoData);
        }
    }
}
