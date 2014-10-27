package com.baidu.tieba.game;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.squareup.wire.Wire;
import java.io.IOException;
import tbclient.GetMutilGameList.GetMutilGameListResIdl;
/* loaded from: classes.dex */
public class ResponseRecommendGameLocalMessage extends CustomResponsedMessage<byte[]> {
    private an mGameData;

    public ResponseRecommendGameLocalMessage() {
        super(2001240);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.CustomResponsedMessage, com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        GetMutilGameListResIdl getMutilGameListResIdl;
        if (bArr != null) {
            try {
                getMutilGameListResIdl = (GetMutilGameListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetMutilGameListResIdl.class);
            } catch (IOException e) {
                e.printStackTrace();
                getMutilGameListResIdl = null;
            }
            if (getMutilGameListResIdl != null) {
                this.mGameData = new an();
                this.mGameData.a(getMutilGameListResIdl.data);
            }
        }
    }

    public an getGameData() {
        return this.mGameData;
    }
}
