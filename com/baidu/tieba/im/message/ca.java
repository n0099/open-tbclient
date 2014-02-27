package com.baidu.tieba.im.message;

import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.data.GroupData;
import com.baidu.tieba.im.data.MemberData;
import com.baidu.tieba.im.data.PhotoUrlData;
import java.util.LinkedList;
import java.util.List;
import protobuf.Im;
import protobuf.QueryGroupDetail.QueryGroupDetailRes;
/* loaded from: classes.dex */
public class ca extends da implements com.baidu.tieba.im.coder.f {
    private QueryGroupDetailRes.QueryGroupDetailResIdl a = null;
    private GroupData b;
    private List<MemberData> c;
    private List<PhotoUrlData> d;
    private int e;
    private int f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private GroupActivityData l;

    public ca() {
        e(103004);
    }

    public final GroupActivityData a() {
        return this.l;
    }

    public final GroupData b() {
        return this.b;
    }

    public final List<MemberData> c() {
        return this.c;
    }

    public final List<PhotoUrlData> d() {
        return this.d;
    }

    public final void a(List<PhotoUrlData> list) {
        this.d = list;
    }

    public final int e() {
        return this.e;
    }

    public final int f() {
        return this.f;
    }

    public final boolean g() {
        return this.g;
    }

    public final void a(boolean z) {
        this.g = z;
    }

    public final boolean h() {
        return this.h;
    }

    public final boolean i() {
        return this.i;
    }

    public final boolean j() {
        return this.j;
    }

    public final boolean k() {
        return this.k;
    }

    @Override // com.baidu.tieba.im.coder.f
    public final void a(LinkedList<s> linkedList, byte[] bArr, int i) {
        Im.ActivityInfo activityInfo;
        this.a = QueryGroupDetailRes.QueryGroupDetailResIdl.parseFrom(bArr);
        g(this.a.getError().getErrorno());
        c(this.a.getError().getUsermsg());
        linkedList.add(this);
        if (!l()) {
            this.f = this.a.getData().getCanJoinGroupNum();
            this.h = this.a.getData().getIsGroupManager() != 0;
            this.i = this.a.getData().getHideRecommendGroup() != 0;
            this.g = this.a.getData().getIsJoin() != 0;
            this.e = this.a.getData().getJoinGroupNum();
            this.j = this.a.getData().getGroup().getIsMemberGroup() == 1;
            this.k = this.a.getData().getCanCreateMember() == 1;
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
                groupData.setBusiness(group.getBusiness());
                groupData.setStatus(group.getStatus());
                groupData.setMeizhi(group.getAuthorIsMeizhi() != 0);
            }
            this.b = groupData;
            List<Im.UserInfo> memberList = this.a.getData().getMemberList();
            LinkedList linkedList2 = new LinkedList();
            for (Im.UserInfo userInfo : memberList) {
                MemberData memberData = new MemberData();
                if (userInfo != null && memberData != null) {
                    memberData.setPortrait(userInfo.getPortrait());
                    memberData.setUserId(userInfo.getUserId());
                    memberData.setUserName(userInfo.getUserName());
                }
                linkedList2.add(memberData);
            }
            this.c = linkedList2;
            List<Im.Photo> photoList = this.a.getData().getPhotoList();
            LinkedList linkedList3 = new LinkedList();
            for (Im.Photo photo : photoList) {
                PhotoUrlData photoUrlData = new PhotoUrlData();
                if (photo != null && photoUrlData != null) {
                    photoUrlData.setBigurl(photo.getBigurl());
                    photoUrlData.setPicId(photo.getPicId());
                    photoUrlData.setSmallurl(photo.getSmallurl());
                }
                linkedList3.add(photoUrlData);
            }
            this.d = linkedList3;
            List<Im.ActivityInfo> activityList = this.a.getData().getActivityList();
            if (activityList != null && activityList.size() > 0 && (activityInfo = activityList.get(0)) != null) {
                GroupActivityData groupActivityData = new GroupActivityData();
                this.l = groupActivityData;
                groupActivityData.setActivityId(activityInfo.getActivityId());
                groupActivityData.setIsEnd(activityInfo.getIsEnd());
                groupActivityData.setgActivityTitle(activityInfo.getActivityTitle());
            }
        }
    }
}
