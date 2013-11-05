package com.baidu.tieba.im.a;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.im.codec.n;
import com.baidu.tieba.im.codec.q;
import com.baidu.tieba.im.data.BaseGroupData;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseSearchGroupMessage;
import com.tencent.mm.sdk.message.RMsgInfo;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class h implements n<com.baidu.tieba.im.codec.a.c> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.LinkedList, java.lang.Object, com.baidu.tieba.im.codec.q, int] */
    @Override // com.baidu.tieba.im.codec.n
    public /* bridge */ /* synthetic */ void a(LinkedList linkedList, com.baidu.tieba.im.codec.a.c cVar, q qVar, int i) {
        a2((LinkedList<Message>) linkedList, cVar, qVar, i);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void a2(LinkedList<Message> linkedList, com.baidu.tieba.im.codec.a.c cVar, q qVar, int i) {
        ResponseSearchGroupMessage responseSearchGroupMessage = new ResponseSearchGroupMessage(103007);
        responseSearchGroupMessage.setErrorInfo(qVar);
        responseSearchGroupMessage.setCmd(i);
        linkedList.add(responseSearchGroupMessage);
        if (cVar != null && !responseSearchGroupMessage.hasError()) {
            LinkedList linkedList2 = new LinkedList();
            BaseGroupData baseGroupData = new BaseGroupData();
            com.baidu.tieba.im.codec.a.c e = cVar.e("group");
            if (e != null) {
                try {
                    baseGroupData.setGroupId(e.b("groupId"));
                    baseGroupData.setName(e.a(SocialConstants.PARAM_MEDIA_UNAME));
                    baseGroupData.setIntro(e.a("intro"));
                    baseGroupData.setPortrait(e.a("portrait"));
                    baseGroupData.setPosition(e.a("position"));
                    baseGroupData.setLng(e.a("lng"));
                    baseGroupData.setLat(e.a("lat"));
                    baseGroupData.setNotice(e.a("notice"));
                    baseGroupData.setAlbum(e.a("album"));
                    baseGroupData.setStatus(e.b("status"));
                    baseGroupData.setAuthorId(e.b("authorId"));
                    baseGroupData.setAuthorName(e.a("authorName"));
                    baseGroupData.setCreateTime(e.b(RMsgInfo.COL_CREATE_TIME));
                    baseGroupData.setMaxMemberNum(e.b("maxMemberNum"));
                    baseGroupData.setMemberNum(e.b("memberNum"));
                    baseGroupData.setGroupType(e.b("groupType"));
                    baseGroupData.setForumId(e.b("forumId"));
                    linkedList2.add(baseGroupData);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            responseSearchGroupMessage.setSearchResult(linkedList2);
        }
    }
}
