package com.baidu.tieba.gift.giftTab;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetUserFreeChance.DataRes;
import tbclient.GetUserFreeChance.GetUserFreeChanceResIdl;
/* loaded from: classes4.dex */
public class FreeGiftChanceHttpResponseMessage extends TbHttpResponsedMessage {
    public int freeChance;
    public long sceneId;

    public FreeGiftChanceHttpResponseMessage(int i) {
        super(i);
        this.freeChance = 0;
    }

    public int getFreeChance() {
        return this.freeChance;
    }

    public long getSceneId() {
        return this.sceneId;
    }

    public void setSceneId(long j) {
        this.sceneId = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetUserFreeChanceResIdl getUserFreeChanceResIdl = (GetUserFreeChanceResIdl) new Wire(new Class[0]).parseFrom(bArr, GetUserFreeChanceResIdl.class);
        if (getUserFreeChanceResIdl == null) {
            return;
        }
        Error error = getUserFreeChanceResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getUserFreeChanceResIdl.error.usermsg);
        }
        DataRes dataRes = getUserFreeChanceResIdl.data;
        if (dataRes != null) {
            this.freeChance = dataRes.free_chance.intValue();
            this.sceneId = getUserFreeChanceResIdl.data.scene_id.intValue();
        }
    }
}
