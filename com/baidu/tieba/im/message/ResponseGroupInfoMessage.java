package com.baidu.tieba.im.message;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
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
public class ResponseGroupInfoMessage extends TbSocketReponsedMessage {
    private static final String CACHE_KEY_PREFIX = "group_info";
    private QueryGroupDetailResIdl mResData;
    private i selfData;

    public ResponseGroupInfoMessage() {
        super(103004);
        this.mResData = null;
    }

    public ResponseGroupInfoMessage(int i) {
        super(i);
        this.mResData = null;
    }

    public i getData() {
        return this.selfData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        ActivityInfo activityInfo;
        Wire wire = new Wire(new Class[0]);
        this.selfData = new i();
        this.mResData = (QueryGroupDetailResIdl) wire.parseFrom(bArr, QueryGroupDetailResIdl.class);
        setError(this.mResData.error.errorno.intValue());
        setErrorString(this.mResData.error.usermsg);
        if (getError() == 0) {
            this.selfData.gf(this.mResData.data.canJoinGroupNum.intValue());
            this.selfData.cZ(this.mResData.data.isGroupManager.intValue() != 0);
            this.selfData.da(this.mResData.data.hideRecommendGroup.intValue() != 0);
            this.selfData.cY(this.mResData.data.isJoin.intValue() != 0);
            this.selfData.ge(this.mResData.data.joinGroupNum.intValue());
            this.selfData.setMemGroup(this.mResData.data.group.isMemberGroup.intValue() == 1);
            this.selfData.db(this.mResData.data.canCreateMember.intValue() == 1);
            GroupInfo groupInfo = this.mResData.data.group;
            GroupData groupData = new GroupData();
            GroupInfo2GroupData(groupInfo, groupData);
            this.selfData.setGroup(groupData);
            List<UserInfo> list = this.mResData.data.member;
            LinkedList linkedList = new LinkedList();
            if (list != null) {
                for (UserInfo userInfo : list) {
                    MemberData memberData = new MemberData();
                    UserInfo2MemberData(userInfo, memberData);
                    linkedList.add(memberData);
                }
            }
            this.selfData.av(linkedList);
            List<Photo> list2 = this.mResData.data.photo;
            LinkedList linkedList2 = new LinkedList();
            if (list2 != null) {
                for (Photo photo : list2) {
                    PhotoUrlData photoUrlData = new PhotoUrlData();
                    Photo2PhotoUrlData(photo, photoUrlData);
                    linkedList2.add(photoUrlData);
                }
            }
            this.selfData.aw(linkedList2);
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
            groupData.setAuthorId(groupInfo.authorId.intValue());
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
            memberData.setUserId(userInfo.userId.intValue());
            memberData.setUserName(userInfo.userName);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        if (this.selfData != null) {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = TbadkCoreApplication.getCurrentAccountObj().getID();
            }
            saveProtocolBufferDataToCache(com.baidu.tbadk.core.a.a.nS().bU("tb.im_groupactivity"), CACHE_KEY_PREFIX + str + this.selfData.getGroup().getGroupId(), bArr);
        }
    }
}
