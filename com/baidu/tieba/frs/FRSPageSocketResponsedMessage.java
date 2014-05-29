package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import tbclient.FrsPage.FrsPageResIdl;
/* loaded from: classes.dex */
public class FRSPageSocketResponsedMessage extends SocketResponsedMessage {
    private g forumModel;
    private boolean hasNetworkError;
    private boolean needCache;
    private int updateType;

    public boolean hasNetworkError() {
        return this.hasNetworkError;
    }

    public FRSPageSocketResponsedMessage() {
        super(MessageTypes.CMD_FRS_PAGE);
    }

    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void setOrginalMessage(Message<?> message) {
        super.setOrginalMessage(message);
        if (message.getExtra() instanceof FRSPageRequestMessage) {
            FRSPageRequestMessage fRSPageRequestMessage = (FRSPageRequestMessage) getOrginalMessage().getExtra();
            this.updateType = fRSPageRequestMessage.getUpdateType();
            this.forumModel = fRSPageRequestMessage.getForumModel();
            this.needCache = fRSPageRequestMessage.isNeedCache();
            this.hasNetworkError = hasError();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        FrsPageResIdl a = this.forumModel.a(bArr);
        setError(a.error.errorno.intValue());
        setErrorString(a.error.usermsg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void processInBackGround(int i, byte[] bArr) {
        if (!hasError() && this.needCache && this.forumModel != null && this.forumModel.g() != null) {
            f.a().a(this.forumModel.g().getName(), bArr);
        }
    }

    public g getForumModel() {
        return this.forumModel;
    }

    public void setForumModel(g gVar) {
        this.forumModel = gVar;
    }

    public int getUpdateType() {
        return this.updateType;
    }

    public void setUpdateType(int i) {
        this.updateType = i;
    }
}
