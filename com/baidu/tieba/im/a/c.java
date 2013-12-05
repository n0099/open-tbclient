package com.baidu.tieba.im.a;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.im.b.q;
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
public class c implements com.baidu.tieba.im.b.n<com.baidu.tieba.im.b.a.d> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.LinkedList, java.lang.Object, com.baidu.tieba.im.b.q, int] */
    @Override // com.baidu.tieba.im.b.n
    public /* bridge */ /* synthetic */ void a(LinkedList linkedList, com.baidu.tieba.im.b.a.d dVar, q qVar, int i) {
        a2((LinkedList<Message>) linkedList, dVar, qVar, i);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void a2(LinkedList<Message> linkedList, com.baidu.tieba.im.b.a.d dVar, q qVar, int i) {
        ResponseGroupInfoMessage responseGroupInfoMessage = new ResponseGroupInfoMessage(103004);
        responseGroupInfoMessage.setErrorInfo(qVar);
        responseGroupInfoMessage.setCmd(i);
        linkedList.add(responseGroupInfoMessage);
        if (dVar != null && !responseGroupInfoMessage.hasError()) {
            GroupData groupData = new GroupData();
            responseGroupInfoMessage.setGroup(groupData);
            com.baidu.tieba.im.b.a.d f = dVar.f("group");
            if (f != null) {
                try {
                    groupData.setGroupId(f.b("groupId"));
                    groupData.setName(f.a(SocialConstants.PARAM_MEDIA_UNAME));
                    groupData.setIntro(f.a("intro"));
                    groupData.setPortrait(f.a("portrait"));
                    groupData.setPosition(f.a("position"));
                    groupData.setBusiness(f.a("business"));
                    groupData.setLng(f.a("lng"));
                    groupData.setLat(f.a("lat"));
                    groupData.setNotice(f.a("notice"));
                    groupData.setAlbum(f.a("album"));
                    groupData.setAuthorId(f.b("authorId"));
                    groupData.setAuthorName(f.a("authorName"));
                    groupData.setAuthorPortrait(f.a("authorPortrait"));
                    groupData.setCreateTime(f.b(RMsgInfo.COL_CREATE_TIME));
                    groupData.setGrade(f.b("grade"));
                    groupData.setMaxMemberNum(f.b("maxMemberNum"));
                    groupData.setMemberNum(f.b("memberNum"));
                    groupData.setGroupType(f.b("groupType"));
                    groupData.setForumId(f.b("forumId"));
                    groupData.setForumName(f.a("forumName"));
                    groupData.setNickName(f.a("nickName"));
                    groupData.setIsHidePosition(f.b("isHidePosition"));
                    groupData.setFlag(f.b(RConversation.COL_FLAG));
                } catch (Exception e) {
                }
            }
            ArrayList arrayList = new ArrayList();
            responseGroupInfoMessage.setPhotos(arrayList);
            com.baidu.tieba.im.b.a.a e2 = dVar.e("photo");
            if (e2 != null && e2.a() > 0) {
                int a2 = e2.a();
                for (int i2 = 0; i2 < a2; i2++) {
                    try {
                        PhotoUrlData photoUrlData = new PhotoUrlData();
                        com.baidu.tieba.im.b.a.d a3 = e2.a(i2);
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
            com.baidu.tieba.im.b.a.a e4 = dVar.e("member");
            if (e4 != null && e4.a() > 0) {
                int a4 = e4.a();
                for (int i3 = 0; i3 < a4; i3++) {
                    try {
                        MemberData memberData = new MemberData();
                        com.baidu.tieba.im.b.a.d a5 = e4.a(i3);
                        memberData.setUserId(a5.c("userId"));
                        memberData.setUserName(a5.a("userName"));
                        memberData.setPortrait(a5.a("portrait"));
                        arrayList2.add(memberData);
                    } catch (Exception e5) {
                    }
                }
            }
            try {
                responseGroupInfoMessage.setJoinGroupNum(dVar.b("joinGroupNum"));
                responseGroupInfoMessage.setCanJoinGroupNum(dVar.b("canJoinGroupNum"));
                responseGroupInfoMessage.setJoin(dVar.b("isJoin") == 1);
                responseGroupInfoMessage.setGroupManager(dVar.b("isGroupManager") == 1);
                responseGroupInfoMessage.setHideRecommendGroup(dVar.b("hideRecommendGroup") == 1);
            } catch (Exception e6) {
            }
        }
    }
}
