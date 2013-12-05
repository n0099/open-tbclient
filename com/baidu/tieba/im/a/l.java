package com.baidu.tieba.im.a;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.im.b.q;
import com.baidu.tieba.im.data.BaseGroupData;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseSearchGroupMessage;
import com.tencent.mm.sdk.message.RMsgInfo;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class l implements com.baidu.tieba.im.b.n<com.baidu.tieba.im.b.a.d> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.LinkedList, java.lang.Object, com.baidu.tieba.im.b.q, int] */
    @Override // com.baidu.tieba.im.b.n
    public /* bridge */ /* synthetic */ void a(LinkedList linkedList, com.baidu.tieba.im.b.a.d dVar, q qVar, int i) {
        a2((LinkedList<Message>) linkedList, dVar, qVar, i);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void a2(LinkedList<Message> linkedList, com.baidu.tieba.im.b.a.d dVar, q qVar, int i) {
        ResponseSearchGroupMessage responseSearchGroupMessage = new ResponseSearchGroupMessage(103007);
        responseSearchGroupMessage.setErrorInfo(qVar);
        responseSearchGroupMessage.setCmd(i);
        linkedList.add(responseSearchGroupMessage);
        if (dVar != null && !responseSearchGroupMessage.hasError()) {
            LinkedList linkedList2 = new LinkedList();
            BaseGroupData baseGroupData = new BaseGroupData();
            com.baidu.tieba.im.b.a.d f = dVar.f("group");
            if (f != null) {
                try {
                    baseGroupData.setGroupId(f.b("groupId"));
                    baseGroupData.setName(f.a(SocialConstants.PARAM_MEDIA_UNAME));
                    baseGroupData.setIntro(f.a("intro"));
                    baseGroupData.setPortrait(f.a("portrait"));
                    baseGroupData.setPosition(f.a("position"));
                    baseGroupData.setLng(f.a("lng"));
                    baseGroupData.setLat(f.a("lat"));
                    baseGroupData.setNotice(f.a("notice"));
                    baseGroupData.setAlbum(f.a("album"));
                    baseGroupData.setStatus(f.b("status"));
                    baseGroupData.setAuthorId(f.b("authorId"));
                    baseGroupData.setAuthorName(f.a("authorName"));
                    baseGroupData.setCreateTime(f.b(RMsgInfo.COL_CREATE_TIME));
                    baseGroupData.setMaxMemberNum(f.b("maxMemberNum"));
                    baseGroupData.setMemberNum(f.b("memberNum"));
                    baseGroupData.setGroupType(f.b("groupType"));
                    baseGroupData.setForumId(f.b("forumId"));
                    linkedList2.add(baseGroupData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            responseSearchGroupMessage.setSearchResult(linkedList2);
        }
    }
}
