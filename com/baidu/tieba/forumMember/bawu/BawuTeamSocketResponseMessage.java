package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.BawuTeam;
import tbclient.GetBawuInfo.GetBawuInfoResIdl;
import tbclient.GetBawuInfo.ManagerApplyInfo;
/* loaded from: classes3.dex */
public class BawuTeamSocketResponseMessage extends SocketResponsedMessage {
    private String cacheKey;
    private boolean isNeedUpdateCache;
    private BawuTeam mBawuTeamInfo;
    private ManagerApplyInfo mManagerApplyInfo;

    public BawuTeamSocketResponseMessage() {
        super(301007);
        this.isNeedUpdateCache = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        if (bArr != null) {
            GetBawuInfoResIdl getBawuInfoResIdl = (GetBawuInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBawuInfoResIdl.class);
            setError(getBawuInfoResIdl.error.errorno.intValue());
            setErrorString(getBawuInfoResIdl.error.usermsg);
            if (getError() == 0 && getBawuInfoResIdl.data != null) {
                this.mBawuTeamInfo = getBawuInfoResIdl.data.bawu_team_info;
                this.mManagerApplyInfo = getBawuInfoResIdl.data.manager_apply_info;
                this.isNeedUpdateCache = true;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        if (this.isNeedUpdateCache) {
            BawuTeamRequestMessage bawuTeamRequestMessage = null;
            if (getOrginalMessage() != null && getOrginalMessage().getExtra() != null) {
                bawuTeamRequestMessage = (BawuTeamRequestMessage) getOrginalMessage().getExtra();
            }
            if (bawuTeamRequestMessage != null) {
                this.cacheKey = "" + bawuTeamRequestMessage.getForumId();
            }
            new d().l(this.cacheKey, bArr);
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
