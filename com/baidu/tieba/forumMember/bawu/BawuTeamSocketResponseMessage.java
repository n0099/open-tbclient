package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import d.b.j0.o0.a.d;
import tbclient.BawuTeam;
import tbclient.GetBawuInfo.DataRes;
import tbclient.GetBawuInfo.GetBawuInfoResIdl;
import tbclient.GetBawuInfo.ManagerApplyInfo;
/* loaded from: classes4.dex */
public class BawuTeamSocketResponseMessage extends SocketResponsedMessage {
    public String cacheKey;
    public boolean isNeedUpdateCache;
    public BawuTeam mBawuTeamInfo;
    public int mIsPrivateForum;
    public ManagerApplyInfo mManagerApplyInfo;

    public BawuTeamSocketResponseMessage() {
        super(301007);
        this.isNeedUpdateCache = false;
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
            new d().c(this.cacheKey, bArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
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
            this.isNeedUpdateCache = true;
        }
    }
}
