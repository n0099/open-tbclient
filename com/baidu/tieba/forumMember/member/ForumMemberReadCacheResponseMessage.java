package com.baidu.tieba.forumMember.member;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.squareup.wire.Wire;
import d.b.i0.d3.w;
import java.util.List;
import tbclient.Error;
import tbclient.GetMemberInfo.DataRes;
import tbclient.GetMemberInfo.GetMemberInfoResIdl;
import tbclient.GetMemberInfo.ManagerApplyInfo;
import tbclient.GetMemberInfo.MemberGodInfo;
import tbclient.MemberGroupInfo;
import tbclient.PriManagerApplyInfo;
/* loaded from: classes4.dex */
public class ForumMemberReadCacheResponseMessage extends CustomResponsedMessage<Object> {
    public boolean mIsBawuShow;
    public boolean mIsPrivateForum;
    public ManagerApplyInfo mManagerApplyInfo;
    public MemberGodInfo mMemberGodInfo;
    public List<MemberGroupInfo> mMemberGroupInfoList;
    public PriManagerApplyInfo mPrivateMgrApplyInfo;
    public w mUserInfo;

    public ForumMemberReadCacheResponseMessage() {
        super(2003009);
        this.mIsPrivateForum = false;
        this.mIsBawuShow = false;
    }

    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        DataRes dataRes;
        GetMemberInfoResIdl getMemberInfoResIdl = (GetMemberInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetMemberInfoResIdl.class);
        if (getMemberInfoResIdl != null) {
            Error error = getMemberInfoResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(getMemberInfoResIdl.error.usermsg);
            }
            if (getError() == 0 && (dataRes = getMemberInfoResIdl.data) != null) {
                if (dataRes.forum_member_info != null) {
                    w wVar = new w();
                    this.mUserInfo = wVar;
                    wVar.v(getMemberInfoResIdl.data.forum_member_info.is_like.intValue());
                    this.mUserInfo.r(getMemberInfoResIdl.data.forum_member_info.cur_score.intValue());
                    this.mUserInfo.u(getMemberInfoResIdl.data.forum_member_info.levelup_score.intValue());
                    this.mUserInfo.w(getMemberInfoResIdl.data.forum_member_info.user_level.intValue());
                    this.mUserInfo.t(getMemberInfoResIdl.data.forum_member_info.level_name);
                }
                DataRes dataRes2 = getMemberInfoResIdl.data;
                this.mMemberGroupInfoList = dataRes2.member_group_info;
                this.mMemberGodInfo = dataRes2.member_god_info;
                this.mManagerApplyInfo = dataRes2.manager_apply_info;
                this.mIsBawuShow = dataRes2.is_bawuapply_show.intValue() != 0;
                this.mIsPrivateForum = getMemberInfoResIdl.data.is_private_forum.intValue() != 0;
                this.mPrivateMgrApplyInfo = getMemberInfoResIdl.data.primanager_apply_info;
            }
        }
    }

    public ManagerApplyInfo getManagerApplyInfo() {
        return this.mManagerApplyInfo;
    }

    public MemberGodInfo getMemberGodInfo() {
        return this.mMemberGodInfo;
    }

    public List<MemberGroupInfo> getMemberGroupInfoList() {
        return this.mMemberGroupInfoList;
    }

    public PriManagerApplyInfo getPrivateMgrApplyInfo() {
        return this.mPrivateMgrApplyInfo;
    }

    public w getUserInfo() {
        return this.mUserInfo;
    }

    public boolean isBawuShow() {
        return this.mIsBawuShow;
    }

    public boolean isPrivateForum() {
        return this.mIsPrivateForum;
    }

    public void setManagerApplyInfo(ManagerApplyInfo managerApplyInfo) {
        this.mManagerApplyInfo = managerApplyInfo;
    }
}
