package com.baidu.tieba.godRecommends;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetRecommendGod.GetRecommendGodResIdl;
/* loaded from: classes3.dex */
public class GodRecommendSocketMessage extends TbSocketReponsedMessage {
    private c godRecommendData;

    public GodRecommendSocketMessage() {
        super(309471);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetRecommendGodResIdl getRecommendGodResIdl = (GetRecommendGodResIdl) new Wire(new Class[0]).parseFrom(bArr, GetRecommendGodResIdl.class);
        if (getRecommendGodResIdl.error != null) {
            setError(getRecommendGodResIdl.error.errorno.intValue());
            setErrorString(getRecommendGodResIdl.error.errmsg);
        }
        if (getRecommendGodResIdl.data != null) {
            this.godRecommendData = new c();
            this.godRecommendData.a(getRecommendGodResIdl.data);
        }
    }

    public c getGodRecommendData() {
        return this.godRecommendData;
    }
}
