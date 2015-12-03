package com.baidu.tieba.gift.giftTab;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetUserFreeChance.GetUserFreeChanceResIdl;
/* loaded from: classes.dex */
public class FreeGiftChanceHttpResponseMessage extends TbHttpResponsedMessage {
    private int freeChance;
    private long sceneId;

    public FreeGiftChanceHttpResponseMessage(int i) {
        super(i);
        this.freeChance = 0;
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        GetUserFreeChanceResIdl getUserFreeChanceResIdl = (GetUserFreeChanceResIdl) new Wire(new Class[0]).parseFrom(bArr, GetUserFreeChanceResIdl.class);
        if (getUserFreeChanceResIdl != null) {
            if (getUserFreeChanceResIdl.error != null) {
                setError(getUserFreeChanceResIdl.error.errorno.intValue());
                setErrorString(getUserFreeChanceResIdl.error.usermsg);
            }
            if (getUserFreeChanceResIdl.data != null) {
                this.freeChance = getUserFreeChanceResIdl.data.free_chance.intValue();
                this.sceneId = getUserFreeChanceResIdl.data.scene_id.intValue();
            }
        }
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
}
