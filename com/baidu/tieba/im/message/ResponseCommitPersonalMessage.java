package com.baidu.tieba.im.message;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tieba.im.util.d;
import com.squareup.wire.Wire;
import protobuf.CommitPersonalMsg.CommitPersonalMsgResIdl;
/* loaded from: classes.dex */
public class ResponseCommitPersonalMessage extends ResponseCommitMessage {
    public static final int CANT_CHAT = 2230303;
    private String toUserId;
    private int toUserType;

    public ResponseCommitPersonalMessage() {
        super(CmdConfigSocket.CMD_COMMIT_PERSONAL_MSG);
        this.toUserId = null;
        this.toUserType = 0;
    }

    public String getToUserId() {
        return this.toUserId;
    }

    public void setToUserId(String str) {
        this.toUserId = str;
    }

    public int getToUserType() {
        return this.toUserType;
    }

    public void setToUserType(int i) {
        this.toUserType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        CommitPersonalMsgResIdl commitPersonalMsgResIdl = (CommitPersonalMsgResIdl) new Wire(new Class[0]).parseFrom(bArr, CommitPersonalMsgResIdl.class);
        setError(commitPersonalMsgResIdl.error.errorno.intValue());
        setErrorString(commitPersonalMsgResIdl.error.usermsg);
        if (commitPersonalMsgResIdl.data == null) {
            BdStatisticsManager.getInstance().error("im", 0L, (String) null, "comment", "personalchat_resdatanull");
            return;
        }
        long longValue = commitPersonalMsgResIdl.data.msgId.longValue();
        setToUserType(commitPersonalMsgResIdl.data.toUserType.intValue());
        setMsgId(d.eN(longValue));
        setRecordId(commitPersonalMsgResIdl.data.recordId.longValue());
        setGroupId(String.valueOf(commitPersonalMsgResIdl.data.groupId));
        setToUserId(String.valueOf(commitPersonalMsgResIdl.data.toUid));
        if (commitPersonalMsgResIdl.data.blockInfo != null && !StringUtils.isNull(commitPersonalMsgResIdl.data.blockInfo.blockErrmsg)) {
            BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
            blockPopInfoData.block_info = commitPersonalMsgResIdl.data.blockInfo.blockErrmsg;
            blockPopInfoData.ahead_info = commitPersonalMsgResIdl.data.blockInfo.blockConfirm;
            blockPopInfoData.ahead_url = commitPersonalMsgResIdl.data.blockInfo.blockDealurl;
            blockPopInfoData.ok_info = commitPersonalMsgResIdl.data.blockInfo.blockCancel;
            setBlockPopInfoData(blockPopInfoData);
        }
    }
}
