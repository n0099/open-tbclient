package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.BawuTeam;
import tbclient.GetBawuInfo.DataRes;
import tbclient.GetBawuInfo.GetBawuInfoResIdl;
import tbclient.GetBawuInfo.ManagerApplyInfo;
/* loaded from: classes4.dex */
public class BawuTeamReadCacheResponseMessage extends CustomResponsedMessage<Object> {
    public BawuTeam mBawuTeamInfo;
    public int mIsPrivateForum;
    public ManagerApplyInfo mManagerApplyInfo;

    public BawuTeamReadCacheResponseMessage() {
        super(2003005);
    }

    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        DataRes dataRes;
        if (bArr == null) {
            return;
        }
        GetBawuInfoResIdl getBawuInfoResIdl = (GetBawuInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBawuInfoResIdl.class);
        setError(getBawuInfoResIdl.error.errorno.intValue());
        setErrorString(getBawuInfoResIdl.error.usermsg);
        if (getError() == 0 && (dataRes = getBawuInfoResIdl.data) != null) {
            this.mBawuTeamInfo = dataRes.bawu_team_info;
            this.mIsPrivateForum = dataRes.is_private_forum.intValue();
            this.mManagerApplyInfo = getBawuInfoResIdl.data.manager_apply_info;
        }
    }

    public BawuTeam getBawuTeamInfo() {
        return this.mBawuTeamInfo;
    }

    public ManagerApplyInfo getManagerApplyInfo() {
        return this.mManagerApplyInfo;
    }

    public int isPrivateForum() {
        return this.mIsPrivateForum;
    }

    public void setBawuTeamInfo(BawuTeam bawuTeam) {
        this.mBawuTeamInfo = bawuTeam;
    }

    public void setManagerApplyInfo(ManagerApplyInfo managerApplyInfo) {
        this.mManagerApplyInfo = managerApplyInfo;
    }
}
