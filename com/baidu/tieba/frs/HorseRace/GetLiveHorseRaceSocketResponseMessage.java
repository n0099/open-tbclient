package com.baidu.tieba.frs.HorseRace;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import d.a.n0.r0.l0.a;
import tbclient.Error;
import tbclient.GetHorseRaceLampList.GetHorseRaceLampListResIdl;
/* loaded from: classes4.dex */
public class GetLiveHorseRaceSocketResponseMessage extends TbSocketReponsedMessage {
    public a mData;

    public GetLiveHorseRaceSocketResponseMessage() {
        super(309667);
        this.mData = new a();
    }

    public a getData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetHorseRaceLampListResIdl getHorseRaceLampListResIdl;
        Error error;
        if (bArr == null || (error = (getHorseRaceLampListResIdl = (GetHorseRaceLampListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetHorseRaceLampListResIdl.class)).error) == null) {
            return;
        }
        setError(error.errorno.intValue());
        setErrorString(getHorseRaceLampListResIdl.error.usermsg);
        if (getError() != 0) {
            return;
        }
        this.mData.b(getHorseRaceLampListResIdl.data);
    }
}
