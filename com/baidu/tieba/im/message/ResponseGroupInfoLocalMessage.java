package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.data.MemberData;
import java.util.LinkedList;
import java.util.List;
import protobuf.Im;
import protobuf.QueryGroupDetail.QueryGroupDetailRes;
/* loaded from: classes.dex */
public class ResponseGroupInfoLocalMessage extends CustomResponsedMessage<bk> {
    private QueryGroupDetailRes.QueryGroupDetailResIdl a;
    private bk b;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.adp.framework.message.CustomResponsedMessage
    public final /* bridge */ /* synthetic */ bk a() {
        return this.b;
    }

    public ResponseGroupInfoLocalMessage() {
        super(2001102);
        this.a = null;
        this.b = null;
    }

    public ResponseGroupInfoLocalMessage(int i) {
        super(i);
        this.a = null;
        this.b = null;
    }

    public final bk b() {
        return this.b;
    }

    public final void a(byte[] bArr) {
        Im.ActivityInfo activityInfo;
        this.b = new bk();
        this.a = QueryGroupDetailRes.QueryGroupDetailResIdl.parseFrom(bArr);
        a(this.a.getError().getErrorno());
        d(this.a.getError().getUsermsg());
        if (e() == 0) {
            this.b.b(this.a.getData().getCanJoinGroupNum());
            this.b.b(this.a.getData().getIsGroupManager() != 0);
            this.b.c(this.a.getData().getHideRecommendGroup() != 0);
            this.b.a(this.a.getData().getIsJoin() != 0);
            this.b.a(this.a.getData().getJoinGroupNum());
            this.b.d(this.a.getData().getGroup().getIsMemberGroup() == 1);
            this.b.e(this.a.getData().getCanCreateMember() == 1);
            Im.GroupInfo group = this.a.getData().getGroup();
            GroupData groupData = new GroupData();
            if (groupData != null && group != null) {
                groupData.setAlbum(group.getAlbum());
                groupData.setAuthorId(group.getAuthorId());
                groupData.setAuthorName(group.getAuthorName());
                groupData.setAuthorPortrait(group.getAuthorPortrait());
                groupData.setCreateTime(group.getCreateTime());
                groupData.setFlag(group.getFlag());
                groupData.setForumId(group.getForumId());
                groupData.setForumName(group.getForumName());
                groupData.setGrade(group.getGrade());
                groupData.setGroupId(group.getGroupId());
                groupData.setGroupType(group.getGroupType());
                groupData.setIntro(group.getIntro());
                groupData.setIsHidePosition(group.getIsHidePosition());
                groupData.setLat(String.valueOf(group.getLat()));
                groupData.setLng(String.valueOf(group.getLng()));
                groupData.setMaxMemberNum(group.getMaxMemberNum());
                groupData.setMemberNum(group.getMemberNum());
                groupData.setName(group.getName());
                groupData.setNickName(group.getNickName());
                groupData.setNotice(group.getNotice());
                groupData.setPortrait(group.getPortrait());
                groupData.setPosition(group.getPosition());
                groupData.setStatus(group.getStatus());
                groupData.setMeizhi(group.getAuthorIsMeizhi() != 0);
            }
            this.b.a(groupData);
            List<Im.UserInfo> memberList = this.a.getData().getMemberList();
            LinkedList linkedList = new LinkedList();
            for (Im.UserInfo userInfo : memberList) {
                MemberData memberData = new MemberData();
                if (userInfo != null && memberData != null) {
                    memberData.setPortrait(userInfo.getPortrait());
                    memberData.setUserId(userInfo.getUserId());
                    memberData.setUserName(userInfo.getUserName());
                }
                linkedList.add(memberData);
            }
            this.b.a(linkedList);
            List<Im.Photo> photoList = this.a.getData().getPhotoList();
            LinkedList linkedList2 = new LinkedList();
            for (Im.Photo photo : photoList) {
                PhotoUrlData photoUrlData = new PhotoUrlData();
                if (photo != null && photoUrlData != null) {
                    photoUrlData.setBigurl(photo.getBigurl());
                    photoUrlData.setPicId(photo.getPicId());
                    photoUrlData.setSmallurl(photo.getSmallurl());
                }
                linkedList2.add(photoUrlData);
            }
            this.b.b(linkedList2);
            List<Im.ActivityInfo> activityList = this.a.getData().getActivityList();
            if (activityList != null && activityList.size() > 0 && (activityInfo = activityList.get(0)) != null) {
                GroupActivityData groupActivityData = new GroupActivityData();
                this.b.a(groupActivityData);
                groupActivityData.setActivityId(activityInfo.getActivityId());
                groupActivityData.setIsEnd(activityInfo.getIsEnd());
                groupActivityData.setgActivityTitle(activityInfo.getActivityTitle());
            }
        }
    }
}
