package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import protobuf.ForumOwnerManageLivegroup.ForumOwnerManageLivegroupResIdl;
/* loaded from: classes.dex */
public class ResponseOperateFrsLiveListMessage extends TbSocketReponsedMessage {
    private int groupId;

    public ResponseOperateFrsLiveListMessage() {
        super(107110);
    }

    public int getGroupId() {
        return this.groupId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        ForumOwnerManageLivegroupResIdl forumOwnerManageLivegroupResIdl = (ForumOwnerManageLivegroupResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumOwnerManageLivegroupResIdl.class);
        setError(forumOwnerManageLivegroupResIdl.error.errorno.intValue());
        setErrorString(forumOwnerManageLivegroupResIdl.error.usermsg);
        if (getError() == 0 && forumOwnerManageLivegroupResIdl.data != null && forumOwnerManageLivegroupResIdl.data.group != null) {
            this.groupId = forumOwnerManageLivegroupResIdl.data.group.groupId.intValue();
        }
    }
}
