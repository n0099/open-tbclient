package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
/* loaded from: classes17.dex */
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

    /* loaded from: classes17.dex */
    public static class a {
        private boolean isMemGroup;
        private boolean jeP;
        private boolean jeQ;
        private GroupData jhc;
        private List<MemberData> jhd;
        private List<PhotoUrlData> jhe;
        private int jhf;
        private int jhg;
        private boolean jhh;
        private boolean jhi;
        private GroupActivityData jhj;

        public GroupActivityData cwk() {
            return this.jhj;
        }

        public void a(GroupActivityData groupActivityData) {
            this.jhj = groupActivityData;
        }

        public GroupData getGroup() {
            return this.jhc;
        }

        public void setGroup(GroupData groupData) {
            this.jhc = groupData;
        }

        public List<MemberData> cwl() {
            return this.jhd;
        }

        public void dH(List<MemberData> list) {
            this.jhd = list;
        }

        public List<PhotoUrlData> cwm() {
            return this.jhe;
        }

        public void dI(List<PhotoUrlData> list) {
            this.jhe = list;
        }

        public int cwn() {
            return this.jhf;
        }

        public void ze(int i) {
            this.jhf = i;
        }

        public int cwo() {
            return this.jhg;
        }

        public void zf(int i) {
            this.jhg = i;
        }

        public boolean cwp() {
            return this.jeP;
        }

        public void qk(boolean z) {
            this.jeP = z;
        }

        public boolean cwq() {
            return this.jeQ;
        }

        public void ql(boolean z) {
            this.jeQ = z;
        }

        public void qm(boolean z) {
            this.jhh = z;
        }

        public boolean isMemGroup() {
            return this.isMemGroup;
        }

        public void setMemGroup(boolean z) {
            this.isMemGroup = z;
        }

        public boolean cwr() {
            return this.jhi;
        }

        public void qn(boolean z) {
            this.jhi = z;
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
            this.selfData.zf(this.mResData.data.canJoinGroupNum.intValue());
            this.selfData.ql(this.mResData.data.isGroupManager.intValue() != 0);
            this.selfData.qm(this.mResData.data.hideRecommendGroup.intValue() != 0);
            this.selfData.qk(this.mResData.data.isJoin.intValue() != 0);
            this.selfData.ze(this.mResData.data.joinGroupNum.intValue());
            this.selfData.setMemGroup(this.mResData.data.group.isMemberGroup.intValue() == 1);
            this.selfData.qn(this.mResData.data.canCreateMember.intValue() == 1);
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
            this.selfData.dH(linkedList);
            List<Photo> list2 = this.mResData.data.photo;
            LinkedList linkedList2 = new LinkedList();
            if (list2 != null) {
                for (Photo photo : list2) {
                    PhotoUrlData photoUrlData = new PhotoUrlData();
                    Photo2PhotoUrlData(photo, photoUrlData);
                    linkedList2.add(photoUrlData);
                }
            }
            this.selfData.dI(linkedList2);
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
