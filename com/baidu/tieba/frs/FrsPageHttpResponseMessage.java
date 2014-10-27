package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import tbclient.FrsPage.FrsPageResIdl;
/* loaded from: classes.dex */
public class FrsPageHttpResponseMessage extends TbHttpResponsedMessage {
    private b forumModel;
    private boolean hasNetworkError;
    private boolean needCache;
    private int updateType;

    public boolean hasNetworkError() {
        return this.hasNetworkError;
    }

    public FrsPageHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void setOrginalMessage(Message<?> message) {
        super.setOrginalMessage(message);
        if (message.getExtra() instanceof FRSPageRequestMessage) {
            FRSPageRequestMessage fRSPageRequestMessage = (FRSPageRequestMessage) message.getExtra();
            this.updateType = fRSPageRequestMessage.getUpdateType();
            this.forumModel = fRSPageRequestMessage.getForumModel();
            this.needCache = fRSPageRequestMessage.isNeedCache();
            this.hasNetworkError = hasError();
        }
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        FrsPageResIdl A = this.forumModel.A(bArr);
        if (A != null && A.error != null) {
            if (A.error.errorno != null) {
                setError(A.error.errorno.intValue());
            }
            setErrorString(A.error.usermsg);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        if (!hasError() && this.needCache && this.forumModel != null && this.forumModel.zJ() != null) {
            a.EV().a(this.forumModel.zJ().getName(), bArr, true);
        }
    }

    public b getForumModel() {
        return this.forumModel;
    }

    public void setForumModel(b bVar) {
        this.forumModel = bVar;
    }

    public int getUpdateType() {
        return this.updateType;
    }

    public void setUpdateType(int i) {
        this.updateType = i;
    }
}
