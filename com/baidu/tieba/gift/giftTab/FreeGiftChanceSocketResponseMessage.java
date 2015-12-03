package com.baidu.tieba.gift.giftTab;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetUserFreeChance.GetUserFreeChanceResIdl;
/* loaded from: classes.dex */
public class FreeGiftChanceSocketResponseMessage extends SocketResponsedMessage {
    private int freeChance;
    private long sceneId;

    public FreeGiftChanceSocketResponseMessage() {
        super(309060);
        this.freeChance = 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
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
