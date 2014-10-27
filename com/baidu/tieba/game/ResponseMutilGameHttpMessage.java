package com.baidu.tieba.game;

import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetMutilGameList.GetMutilGameListResIdl;
/* loaded from: classes.dex */
public class ResponseMutilGameHttpMessage extends TbHttpResponsedMessage {
    private an mData;
    private int mPage;

    public ResponseMutilGameHttpMessage(int i) {
        super(i);
    }

    public an getData() {
        return this.mData;
    }

    public int getPage() {
        return this.mPage;
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        if (bArr != null) {
            GetMutilGameListResIdl getMutilGameListResIdl = (GetMutilGameListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetMutilGameListResIdl.class);
            if (getMutilGameListResIdl.error != null) {
                setError(getMutilGameListResIdl.error.errorno.intValue());
                setErrorString(getMutilGameListResIdl.error.usermsg);
                if (getError() == 0) {
                    this.mData = new an();
                    this.mData.a(getMutilGameListResIdl.data);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        Message<?> orginalMessage = getOrginalMessage();
        if (orginalMessage != null && (orginalMessage.getExtra() instanceof RequestMutilGameNetMessage) && getError() == 0) {
            RequestMutilGameNetMessage requestMutilGameNetMessage = (RequestMutilGameNetMessage) orginalMessage.getExtra();
            this.mPage = requestMutilGameNetMessage.getPageNum();
            if (requestMutilGameNetMessage.getType() == 1) {
                if (this.mPage <= 1) {
                    com.baidu.tieba.game.a.a.Ij().a(bArr, "key_recommend_game_list");
                }
                com.baidu.tieba.game.a.a.Ij().d(this.mData);
            } else if (requestMutilGameNetMessage.getType() == 2) {
                if (this.mPage <= 1) {
                    com.baidu.tieba.game.a.a.Ij().a(bArr, "key_game_new");
                }
                if (this.mData != null) {
                    com.baidu.tieba.game.a.a.Ij().M(this.mData.getGameList());
                }
            }
        }
    }
}
