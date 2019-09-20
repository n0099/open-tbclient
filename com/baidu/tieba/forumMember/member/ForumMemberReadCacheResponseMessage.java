package com.baidu.tieba.forumMember.member;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.GetMemberInfo.GetMemberInfoResIdl;
import tbclient.GetMemberInfo.ManagerApplyInfo;
import tbclient.GetMemberInfo.MemberGodInfo;
import tbclient.MemberGroupInfo;
import tbclient.PriManagerApplyInfo;
/* loaded from: classes5.dex */
public class ForumMemberReadCacheResponseMessage extends CustomResponsedMessage<Object> {
    private boolean mIsBawuShow;
    private boolean mIsPrivateForum;
    private ManagerApplyInfo mManagerApplyInfo;
    private MemberGodInfo mMemberGodInfo;
    private List<MemberGroupInfo> mMemberGroupInfoList;
    private PriManagerApplyInfo mPrivateMgrApplyInfo;
    private com.baidu.tieba.tbadkCore.t mUserInfo;

    public ForumMemberReadCacheResponseMessage() {
        super(2003009);
        this.mIsPrivateForum = false;
        this.mIsBawuShow = false;
    }

    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetMemberInfoResIdl getMemberInfoResIdl = (GetMemberInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetMemberInfoResIdl.class);
        if (getMemberInfoResIdl != null) {
            if (getMemberInfoResIdl.error != null) {
                setError(getMemberInfoResIdl.error.errorno.intValue());
                setErrorString(getMemberInfoResIdl.error.usermsg);
            }
            if (getError() == 0 && getMemberInfoResIdl.data != null) {
                if (getMemberInfoResIdl.data.forum_member_info != null) {
                    this.mUserInfo = new com.baidu.tieba.tbadkCore.t();
                    this.mUserInfo.setLike(getMemberInfoResIdl.data.forum_member_info.is_like.intValue());
                    this.mUserInfo.setCurScore(getMemberInfoResIdl.data.forum_member_info.cur_score.intValue());
                    this.mUserInfo.setLevelupScore(getMemberInfoResIdl.data.forum_member_info.levelup_score.intValue());
                    this.mUserInfo.AR(getMemberInfoResIdl.data.forum_member_info.user_level.intValue());
                    this.mUserInfo.setLevelName(getMemberInfoResIdl.data.forum_member_info.level_name);
                }
                this.mMemberGroupInfoList = getMemberInfoResIdl.data.member_group_info;
                this.mMemberGodInfo = getMemberInfoResIdl.data.member_god_info;
                this.mManagerApplyInfo = getMemberInfoResIdl.data.manager_apply_info;
                this.mIsBawuShow = getMemberInfoResIdl.data.is_bawuapply_show.intValue() != 0;
                this.mIsPrivateForum = getMemberInfoResIdl.data.is_private_forum.intValue() != 0;
                this.mPrivateMgrApplyInfo = getMemberInfoResIdl.data.primanager_apply_info;
            }
        }
    }

    public com.baidu.tieba.tbadkCore.t getUserInfo() {
        return this.mUserInfo;
    }

    public List<MemberGroupInfo> getMemberGroupInfoList() {
        return this.mMemberGroupInfoList;
    }

    public MemberGodInfo getMemberGodInfo() {
        return this.mMemberGodInfo;
    }

    public ManagerApplyInfo getManagerApplyInfo() {
        return this.mManagerApplyInfo;
    }

    public void setManagerApplyInfo(ManagerApplyInfo managerApplyInfo) {
        this.mManagerApplyInfo = managerApplyInfo;
    }

    public PriManagerApplyInfo getPrivateMgrApplyInfo() {
        return this.mPrivateMgrApplyInfo;
    }

    public boolean isPrivateForum() {
        return this.mIsPrivateForum;
    }

    public boolean isBawuShow() {
        return this.mIsBawuShow;
    }
}
