package com.baidu.tieba.im.message;

import com.baidu.tieba.im.data.GroupData;
import com.baidu.tieba.im.data.MemberData;
import com.baidu.tieba.im.data.PhotoUrlData;
import java.util.LinkedList;
import java.util.List;
import protobuf.Im;
import protobuf.QueryGroupDetail.QueryGroupDetailRes;
/* loaded from: classes.dex */
public class be extends bz implements com.baidu.tieba.im.coder.f {
    private QueryGroupDetailRes.QueryGroupDetailResIdl a = null;
    private GroupData b;
    private List<MemberData> c;
    private List<PhotoUrlData> d;
    private int e;
    private int f;
    private boolean g;
    private boolean h;
    private boolean i;

    public be() {
        e(103004);
    }

    public GroupData a() {
        return this.b;
    }

    public void a(GroupData groupData) {
        this.b = groupData;
    }

    public List<MemberData> b() {
        return this.c;
    }

    public void a(List<MemberData> list) {
        this.c = list;
    }

    public List<PhotoUrlData> c() {
        return this.d;
    }

    public void b(List<PhotoUrlData> list) {
        this.d = list;
    }

    public int d() {
        return this.e;
    }

    public void a(int i) {
        this.e = i;
    }

    public int e() {
        return this.f;
    }

    public void b(int i) {
        this.f = i;
    }

    public boolean f() {
        return this.g;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public boolean g() {
        return this.h;
    }

    public void b(boolean z) {
        this.h = z;
    }

    public boolean h() {
        return this.i;
    }

    public void c(boolean z) {
        this.i = z;
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<n> linkedList, byte[] bArr, int i) {
        this.a = QueryGroupDetailRes.QueryGroupDetailResIdl.parseFrom(bArr);
        c(this.a.getError().getErrorno());
        c(this.a.getError().getUsermsg());
        linkedList.add(this);
        if (!i()) {
            b(this.a.getData().getCanJoinGroupNum());
            b(this.a.getData().getIsGroupManager() != 0);
            c(this.a.getData().getHideRecommendGroup() != 0);
            a(this.a.getData().getIsJoin() != 0);
            a(this.a.getData().getJoinGroupNum());
            Im.GroupInfo group = this.a.getData().getGroup();
            GroupData groupData = new GroupData();
            a(group, groupData);
            a(groupData);
            List<Im.UserInfo> memberList = this.a.getData().getMemberList();
            LinkedList linkedList2 = new LinkedList();
            for (Im.UserInfo userInfo : memberList) {
                MemberData memberData = new MemberData();
                a(userInfo, memberData);
                linkedList2.add(memberData);
            }
            a(linkedList2);
            List<Im.Photo> photoList = this.a.getData().getPhotoList();
            LinkedList linkedList3 = new LinkedList();
            for (Im.Photo photo : photoList) {
                PhotoUrlData photoUrlData = new PhotoUrlData();
                a(photo, photoUrlData);
                linkedList3.add(photoUrlData);
            }
            b(linkedList3);
        }
    }

    public static void a(Im.GroupInfo groupInfo, GroupData groupData) {
        if (groupData != null && groupInfo != null) {
            groupData.setAlbum(groupInfo.getAlbum());
            groupData.setAuthorId(groupInfo.getAuthorId());
            groupData.setAuthorName(groupInfo.getAuthorName());
            groupData.setAuthorPortrait(groupInfo.getAuthorPortrait());
            groupData.setCreateTime(groupInfo.getCreateTime());
            groupData.setFlag(groupInfo.getFlag());
            groupData.setForumId(groupInfo.getForumId());
            groupData.setForumName(groupInfo.getForumName());
            groupData.setGrade(groupInfo.getGrade());
            groupData.setGroupId(groupInfo.getGroupId());
            groupData.setGroupType(groupInfo.getGroupType());
            groupData.setIntro(groupInfo.getIntro());
            groupData.setIsHidePosition(groupInfo.getIsHidePosition());
            groupData.setLat(String.valueOf(groupInfo.getLat()));
            groupData.setLng(String.valueOf(groupInfo.getLng()));
            groupData.setMaxMemberNum(groupInfo.getMaxMemberNum());
            groupData.setMemberNum(groupInfo.getMemberNum());
            groupData.setName(groupInfo.getName());
            groupData.setNickName(groupInfo.getNickName());
            groupData.setNotice(groupInfo.getNotice());
            groupData.setPortrait(groupInfo.getPortrait());
            groupData.setPosition(groupInfo.getPosition());
            groupData.setStatus(groupInfo.getStatus());
        }
    }

    public static void a(Im.Photo photo, PhotoUrlData photoUrlData) {
        if (photo != null && photoUrlData != null) {
            photoUrlData.setBigurl(photo.getBigurl());
            photoUrlData.setPicId(photo.getPicId());
            photoUrlData.setSmallurl(photo.getSmallurl());
        }
    }

    public static void a(Im.UserInfo userInfo, MemberData memberData) {
        if (userInfo != null && memberData != null) {
            memberData.setPortrait(userInfo.getPortrait());
            memberData.setUserId(userInfo.getUserId());
            memberData.setUserName(userInfo.getUserName());
        }
    }
}
