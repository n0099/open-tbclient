package com.baidu.tieba.im.message;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.squareup.wire.Wire;
import d.a.o0.f1.w.b;
import protobuf.BlockInfo;
import protobuf.CommitPersonalMsg.CommitPersonalMsgResIdl;
import protobuf.CommitPersonalMsg.DataRes;
/* loaded from: classes4.dex */
public class ResponseCommitPersonalMessage extends ResponseCommitMessage {
    public static final int CANT_CHAT = 2230303;
    public String toUserId;
    public int toUserType;

    public ResponseCommitPersonalMessage() {
        super(205001);
        this.toUserId = null;
        this.toUserType = 0;
    }

    public String getToUserId() {
        return this.toUserId;
    }

    public int getToUserType() {
        return this.toUserType;
    }

    public void setToUserId(String str) {
        this.toUserId = str;
    }

    public void setToUserType(int i2) {
        this.toUserType = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.message.ResponseCommitMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        CommitPersonalMsgResIdl commitPersonalMsgResIdl = (CommitPersonalMsgResIdl) new Wire(new Class[0]).parseFrom(bArr, CommitPersonalMsgResIdl.class);
        setError(commitPersonalMsgResIdl.error.errorno.intValue());
        setErrorString(commitPersonalMsgResIdl.error.usermsg);
        DataRes dataRes = commitPersonalMsgResIdl.data;
        if (dataRes == null) {
            BdStatisticsManager.getInstance().error("im", 0L, (String) null, "comment", "personalchat_resdatanull");
            return;
        }
        long longValue = dataRes.msgId.longValue();
        setToUserType(commitPersonalMsgResIdl.data.toUserType.intValue());
        setMsgId(b.a(longValue));
        setRecordId(commitPersonalMsgResIdl.data.recordId.longValue());
        setGroupId(String.valueOf(commitPersonalMsgResIdl.data.groupId));
        setToUserId(String.valueOf(commitPersonalMsgResIdl.data.toUid));
        BlockInfo blockInfo = commitPersonalMsgResIdl.data.blockInfo;
        if (blockInfo == null || StringUtils.isNull(blockInfo.blockErrmsg)) {
            return;
        }
        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
        BlockInfo blockInfo2 = commitPersonalMsgResIdl.data.blockInfo;
        blockPopInfoData.block_info = blockInfo2.blockErrmsg;
        blockPopInfoData.ahead_info = blockInfo2.blockConfirm;
        blockPopInfoData.ahead_url = blockInfo2.blockDealurl;
        blockPopInfoData.ok_info = blockInfo2.blockCancel;
        setBlockPopInfoData(blockPopInfoData);
    }
}
