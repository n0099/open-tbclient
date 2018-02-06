package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.BawuTeam;
import tbclient.GetBawuInfo.GetBawuInfoResIdl;
import tbclient.GetBawuInfo.ManagerApplyInfo;
/* loaded from: classes3.dex */
public class BawuTeamReadCacheResponseMessage extends CustomResponsedMessage<Object> {
    private BawuTeam mBawuTeamInfo;
    private ManagerApplyInfo mManagerApplyInfo;

    public BawuTeamReadCacheResponseMessage() {
        super(2003005);
    }

    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        if (bArr != null) {
            GetBawuInfoResIdl getBawuInfoResIdl = (GetBawuInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBawuInfoResIdl.class);
            setError(getBawuInfoResIdl.error.errorno.intValue());
            setErrorString(getBawuInfoResIdl.error.usermsg);
            if (getError() == 0 && getBawuInfoResIdl.data != null) {
                this.mBawuTeamInfo = getBawuInfoResIdl.data.bawu_team_info;
                this.mManagerApplyInfo = getBawuInfoResIdl.data.manager_apply_info;
            }
        }
    }

    public BawuTeam getBawuTeamInfo() {
        return this.mBawuTeamInfo;
    }

    public void setBawuTeamInfo(BawuTeam bawuTeam) {
        this.mBawuTeamInfo = bawuTeam;
    }

    public ManagerApplyInfo getManagerApplyInfo() {
        return this.mManagerApplyInfo;
    }

    public void setManagerApplyInfo(ManagerApplyInfo managerApplyInfo) {
        this.mManagerApplyInfo = managerApplyInfo;
    }
}
