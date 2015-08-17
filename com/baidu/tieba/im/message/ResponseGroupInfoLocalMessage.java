package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.data.MemberData;
import com.squareup.wire.Wire;
import java.util.LinkedList;
import java.util.List;
import protobuf.ActivityInfo;
import protobuf.GroupInfo;
import protobuf.Photo;
import protobuf.QueryGroupDetail.QueryGroupDetailResIdl;
import protobuf.UserInfo;
/* loaded from: classes.dex */
public class ResponseGroupInfoLocalMessage extends CustomResponsedMessage<a> {
    private QueryGroupDetailResIdl mResData;
    private a selfData;

    public ResponseGroupInfoLocalMessage() {
        super(CmdConfigCustom.CMD_REQUEST_GROUP_INFO_BY_ID_LOCAL);
        this.mResData = null;
        this.selfData = null;
    }

    public ResponseGroupInfoLocalMessage(int i) {
        super(i);
        this.mResData = null;
        this.selfData = null;
    }

    /* loaded from: classes.dex */
    public static class a {
        private GroupData bBe;
        private List<MemberData> bBf;
        private List<PhotoUrlData> bBg;
        private int bBh;
        private int bBi;
        private boolean bBj;
        private boolean bBk;
        private boolean bBl;
        private boolean bBm;
        private GroupActivityData bBn;
        private boolean isMemGroup;

        public GroupActivityData Vy() {
            return this.bBn;
        }

        public void a(GroupActivityData groupActivityData) {
            this.bBn = groupActivityData;
        }

        public GroupData getGroup() {
            return this.bBe;
        }

        public void setGroup(GroupData groupData) {
            this.bBe = groupData;
        }

        public List<MemberData> Vz() {
            return this.bBf;
        }

        public void aJ(List<MemberData> list) {
            this.bBf = list;
        }

        public List<PhotoUrlData> VA() {
            return this.bBg;
        }

        public void aK(List<PhotoUrlData> list) {
            this.bBg = list;
        }

        public int VB() {
            return this.bBh;
        }

        public void gX(int i) {
            this.bBh = i;
        }

        public int VC() {
            return this.bBi;
        }

        public void gY(int i) {
            this.bBi = i;
        }

        public boolean VD() {
            return this.bBj;
        }

        public void dd(boolean z) {
            this.bBj = z;
        }

        public boolean VE() {
            return this.bBk;
        }

        public void de(boolean z) {
            this.bBk = z;
        }

        public void df(boolean z) {
            this.bBl = z;
        }

        public boolean isMemGroup() {
            return this.isMemGroup;
        }

        public void setMemGroup(boolean z) {
            this.isMemGroup = z;
        }

        public boolean VF() {
            return this.bBm;
        }

        public void dg(boolean z) {
            this.bBm = z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.adp.framework.message.CustomResponsedMessage
    public a getData() {
        return this.selfData;
    }

    public void decodeInBackGround(int i, byte[] bArr) {
        ActivityInfo activityInfo;
        Wire wire = new Wire(new Class[0]);
        this.selfData = new a();
        this.mResData = (QueryGroupDetailResIdl) wire.parseFrom(bArr, QueryGroupDetailResIdl.class);
        setError(this.mResData.error.errorno.intValue());
        setErrorString(this.mResData.error.usermsg);
        if (getError() == 0) {
            this.selfData.gY(this.mResData.data.canJoinGroupNum.intValue());
            this.selfData.de(this.mResData.data.isGroupManager.intValue() != 0);
            this.selfData.df(this.mResData.data.hideRecommendGroup.intValue() != 0);
            this.selfData.dd(this.mResData.data.isJoin.intValue() != 0);
            this.selfData.gX(this.mResData.data.joinGroupNum.intValue());
            this.selfData.setMemGroup(this.mResData.data.group.isMemberGroup.intValue() == 1);
            this.selfData.dg(this.mResData.data.canCreateMember.intValue() == 1);
            GroupInfo groupInfo = this.mResData.data.group;
            GroupData groupData = new GroupData();
            GroupInfo2GroupData(groupInfo, groupData);
            this.selfData.setGroup(groupData);
            LinkedList linkedList = new LinkedList();
            List<UserInfo> list = this.mResData.data.member;
            if (list != null) {
                for (UserInfo userInfo : list) {
                    MemberData memberData = new MemberData();
                    UserInfo2MemberData(userInfo, memberData);
                    linkedList.add(memberData);
                }
            }
            this.selfData.aJ(linkedList);
            List<Photo> list2 = this.mResData.data.photo;
            LinkedList linkedList2 = new LinkedList();
            if (list2 != null) {
                for (Photo photo : list2) {
                    PhotoUrlData photoUrlData = new PhotoUrlData();
                    Photo2PhotoUrlData(photo, photoUrlData);
                    linkedList2.add(photoUrlData);
                }
            }
            this.selfData.aK(linkedList2);
            List<ActivityInfo> list3 = this.mResData.data.activity;
            if (list3 != null && list3.size() > 0 && (activityInfo = list3.get(0)) != null) {
                GroupActivityData groupActivityData = new GroupActivityData();
                this.selfData.a(groupActivityData);
                groupActivityData.setActivityId(activityInfo.activityId.intValue());
                groupActivityData.setIsEnd(activityInfo.isEnd.intValue());
                groupActivityData.setgActivityTitle(activityInfo.activityTitle);
            }
        }
    }

    public static void GroupInfo2GroupData(GroupInfo groupInfo, GroupData groupData) {
        if (groupData != null && groupInfo != null) {
            groupData.setAlbum(groupInfo.album);
            groupData.setAuthorId(groupInfo.authorId.longValue());
            groupData.setAuthorName(groupInfo.authorName);
            groupData.setAuthorPortrait(groupInfo.authorPortrait);
            groupData.setCreateTime(groupInfo.createTime.intValue());
            groupData.setFlag(groupInfo.flag.intValue());
            groupData.setForumId(groupInfo.forumId.intValue());
            groupData.setForumName(groupInfo.forumName);
            groupData.setGrade(groupInfo.grade.intValue());
            groupData.setGroupId(groupInfo.groupId.intValue());
            groupData.setGroupType(groupInfo.groupType.intValue());
            groupData.setIntro(groupInfo.intro);
            groupData.setIsHidePosition(groupInfo.isHidePosition.intValue());
            groupData.setLat(String.valueOf(groupInfo.lat));
            groupData.setLng(String.valueOf(groupInfo.lng));
            groupData.setMaxMemberNum(groupInfo.maxMemberNum.intValue());
            groupData.setMemberNum(groupInfo.memberNum.intValue());
            groupData.setName(groupInfo.name);
            groupData.setNickName(groupInfo.nickName);
            groupData.setNotice(groupInfo.notice);
            groupData.setPortrait(groupInfo.portrait);
            groupData.setPosition(groupInfo.position);
            groupData.setBusiness(groupInfo.business);
            groupData.setStatus(groupInfo.status.intValue());
            groupData.setMeizhi(groupInfo.authorIsMeizhi.intValue() != 0);
        }
    }

    public static void Photo2PhotoUrlData(Photo photo, PhotoUrlData photoUrlData) {
        if (photo != null && photoUrlData != null) {
            photoUrlData.setBigurl(photo.bigurl);
            photoUrlData.setPicId(photo.picId);
            photoUrlData.setSmallurl(photo.smallurl);
        }
    }

    public static void UserInfo2MemberData(UserInfo userInfo, MemberData memberData) {
        if (userInfo != null && memberData != null) {
            memberData.setPortrait(userInfo.portrait);
            memberData.setUserId(userInfo.userId.longValue());
            memberData.setUserName(userInfo.userName);
        }
    }
}
