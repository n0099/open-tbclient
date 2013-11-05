package com.baidu.tieba.im.a;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.im.codec.n;
import com.baidu.tieba.im.codec.q;
import com.baidu.tieba.im.data.GroupData;
import com.baidu.tieba.im.data.MemberData;
import com.baidu.tieba.im.data.PhotoUrlData;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseGroupInfoMessage;
import com.tencent.mm.sdk.conversation.RConversation;
import com.tencent.mm.sdk.message.RMsgInfo;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class c implements n<com.baidu.tieba.im.codec.a.c> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.LinkedList, java.lang.Object, com.baidu.tieba.im.codec.q, int] */
    @Override // com.baidu.tieba.im.codec.n
    public /* bridge */ /* synthetic */ void a(LinkedList linkedList, com.baidu.tieba.im.codec.a.c cVar, q qVar, int i) {
        a2((LinkedList<Message>) linkedList, cVar, qVar, i);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void a2(LinkedList<Message> linkedList, com.baidu.tieba.im.codec.a.c cVar, q qVar, int i) {
        ResponseGroupInfoMessage responseGroupInfoMessage = new ResponseGroupInfoMessage(103004);
        responseGroupInfoMessage.setErrorInfo(qVar);
        responseGroupInfoMessage.setCmd(i);
        linkedList.add(responseGroupInfoMessage);
        if (cVar != null && !responseGroupInfoMessage.hasError()) {
            GroupData groupData = new GroupData();
            responseGroupInfoMessage.setGroup(groupData);
            com.baidu.tieba.im.codec.a.c e = cVar.e("group");
            if (e != null) {
                try {
                    groupData.setGroupId(e.b("groupId"));
                    groupData.setName(e.a(SocialConstants.PARAM_MEDIA_UNAME));
                    groupData.setIntro(e.a("intro"));
                    groupData.setPortrait(e.a("portrait"));
                    groupData.setPosition(e.a("position"));
                    groupData.setLng(e.a("lng"));
                    groupData.setLat(e.a("lat"));
                    groupData.setNotice(e.a("notice"));
                    groupData.setAlbum(e.a("album"));
                    groupData.setAuthorId(e.b("authorId"));
                    groupData.setAuthorName(e.a("authorName"));
                    groupData.setAuthorPortrait(e.a("authorPortrait"));
                    groupData.setCreateTime(e.b(RMsgInfo.COL_CREATE_TIME));
                    groupData.setGrade(e.c("grade"));
                    groupData.setMaxMemberNum(e.b("maxMemberNum"));
                    groupData.setMemberNum(e.b("memberNum"));
                    groupData.setGroupType(e.b("groupType"));
                    groupData.setForumId(e.b("forumId"));
                    groupData.setForumName(e.a("forumName"));
                    groupData.setNickName(e.a("nickName"));
                    groupData.setIsHidePosition(e.b("isHidePosition"));
                    groupData.setFlag(e.b(RConversation.COL_FLAG));
                } catch (Exception e2) {
                }
            }
            ArrayList arrayList = new ArrayList();
            responseGroupInfoMessage.setPhotos(arrayList);
            com.baidu.tieba.im.codec.a.a d = cVar.d("photo");
            if (d != null && d.a() > 0) {
                int a2 = d.a();
                for (int i2 = 0; i2 < a2; i2++) {
                    try {
                        PhotoUrlData photoUrlData = new PhotoUrlData();
                        com.baidu.tieba.im.codec.a.c a3 = d.a(i2);
                        photoUrlData.setSmallurl(a3.a("smallurl"));
                        photoUrlData.setBigurl(a3.a("bigurl"));
                        photoUrlData.setPicId(a3.a("picId"));
                        arrayList.add(photoUrlData);
                    } catch (Exception e3) {
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList();
            responseGroupInfoMessage.setMembers(arrayList2);
            com.baidu.tieba.im.codec.a.a d2 = cVar.d("member");
            if (d2 != null && d2.a() > 0) {
                int a4 = d2.a();
                for (int i3 = 0; i3 < a4; i3++) {
                    try {
                        MemberData memberData = new MemberData();
                        com.baidu.tieba.im.codec.a.c a5 = d2.a(i3);
                        memberData.setUserId(a5.c("userId"));
                        memberData.setUserName(a5.a("userName"));
                        memberData.setPortrait(a5.a("portrait"));
                        arrayList2.add(memberData);
                    } catch (Exception e4) {
                    }
                }
            }
            try {
                responseGroupInfoMessage.setJoinGroupNum(cVar.b("joinGroupNum"));
                responseGroupInfoMessage.setCanJoinGroupNum(cVar.b("canJoinGroupNum"));
                responseGroupInfoMessage.setJoin(cVar.b("isJoin") == 1);
                responseGroupInfoMessage.setGroupManager(cVar.b("isGroupManager") == 1);
                responseGroupInfoMessage.setHideRecommendGroup(cVar.b("hideRecommendGroup") == 1);
            } catch (Exception e5) {
            }
        }
    }
}
