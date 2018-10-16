package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.GroupData;
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
/* loaded from: classes3.dex */
public class ResponseGroupInfoLocalMessage extends CustomResponsedMessage<a> {
    private QueryGroupDetailResIdl mResData;
    private a selfData;

    public ResponseGroupInfoLocalMessage() {
        super(2001102);
        this.mResData = null;
        this.selfData = null;
    }

    public ResponseGroupInfoLocalMessage(int i) {
        super(i);
        this.mResData = null;
        this.selfData = null;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private boolean dsj;
        private boolean eLQ;
        private GroupData eOc;
        private List<MemberData> eOd;
        private List<PhotoUrlData> eOe;
        private int eOf;
        private int eOg;
        private boolean eOh;
        private boolean eOi;
        private GroupActivityData eOj;
        private boolean isMemGroup;

        public GroupActivityData aRN() {
            return this.eOj;
        }

        public void a(GroupActivityData groupActivityData) {
            this.eOj = groupActivityData;
        }

        public GroupData getGroup() {
            return this.eOc;
        }

        public void setGroup(GroupData groupData) {
            this.eOc = groupData;
        }

        public List<MemberData> aRO() {
            return this.eOd;
        }

        public void cI(List<MemberData> list) {
            this.eOd = list;
        }

        public List<PhotoUrlData> aRP() {
            return this.eOe;
        }

        public void cJ(List<PhotoUrlData> list) {
            this.eOe = list;
        }

        public int aRQ() {
            return this.eOf;
        }

        public void pv(int i) {
            this.eOf = i;
        }

        public int aRR() {
            return this.eOg;
        }

        public void pw(int i) {
            this.eOg = i;
        }

        public boolean aRS() {
            return this.dsj;
        }

        public void iC(boolean z) {
            this.dsj = z;
        }

        public boolean aRT() {
            return this.eLQ;
        }

        public void iD(boolean z) {
            this.eLQ = z;
        }

        public void iE(boolean z) {
            this.eOh = z;
        }

        public boolean isMemGroup() {
            return this.isMemGroup;
        }

        public void setMemGroup(boolean z) {
            this.isMemGroup = z;
        }

        public boolean aRU() {
            return this.eOi;
        }

        public void iF(boolean z) {
            this.eOi = z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.adp.framework.message.CustomResponsedMessage
    public a getData() {
        return this.selfData;
    }

    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Wire wire = new Wire(new Class[0]);
        this.selfData = new a();
        this.mResData = (QueryGroupDetailResIdl) wire.parseFrom(bArr, QueryGroupDetailResIdl.class);
        setError(this.mResData.error.errorno.intValue());
        setErrorString(this.mResData.error.usermsg);
        if (getError() == 0) {
            this.selfData.pw(this.mResData.data.canJoinGroupNum.intValue());
            this.selfData.iD(this.mResData.data.isGroupManager.intValue() != 0);
            this.selfData.iE(this.mResData.data.hideRecommendGroup.intValue() != 0);
            this.selfData.iC(this.mResData.data.isJoin.intValue() != 0);
            this.selfData.pv(this.mResData.data.joinGroupNum.intValue());
            this.selfData.setMemGroup(this.mResData.data.group.isMemberGroup.intValue() == 1);
            this.selfData.iF(this.mResData.data.canCreateMember.intValue() == 1);
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
            this.selfData.cI(linkedList);
            List<Photo> list2 = this.mResData.data.photo;
            LinkedList linkedList2 = new LinkedList();
            if (list2 != null) {
                for (Photo photo : list2) {
                    PhotoUrlData photoUrlData = new PhotoUrlData();
                    Photo2PhotoUrlData(photo, photoUrlData);
                    linkedList2.add(photoUrlData);
                }
            }
            this.selfData.cJ(linkedList2);
            ActivityInfo activityInfo = this.mResData.data.activity;
            if (activityInfo != null) {
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
            groupData.setAuthorNameShow(groupInfo.authorNameShow);
            groupData.setAuthorPortrait(groupInfo.authorPortrait);
            groupData.setCreateTime(groupInfo.createTime.intValue());
            groupData.setFlag(groupInfo.flag.intValue());
            groupData.setForumId(groupInfo.forumId.intValue());
            groupData.setForumName(groupInfo.forumName);
            groupData.setGrade(groupInfo.grade.intValue());
            groupData.setGroupId(groupInfo.groupId.longValue());
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
