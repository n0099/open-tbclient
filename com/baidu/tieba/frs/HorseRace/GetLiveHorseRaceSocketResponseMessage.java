package com.baidu.tieba.frs.HorseRace;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetHorseRaceLampList.GetHorseRaceLampListResIdl;
/* loaded from: classes21.dex */
public class GetLiveHorseRaceSocketResponseMessage extends TbSocketReponsedMessage {
    private a mData;

    public GetLiveHorseRaceSocketResponseMessage() {
        super(309667);
        this.mData = new a();
    }

    public a getData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        if (bArr != null) {
            GetHorseRaceLampListResIdl getHorseRaceLampListResIdl = (GetHorseRaceLampListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetHorseRaceLampListResIdl.class);
            if (getHorseRaceLampListResIdl.error != null) {
                setError(getHorseRaceLampListResIdl.error.errorno.intValue());
                setErrorString(getHorseRaceLampListResIdl.error.usermsg);
                if (getError() == 0) {
                    this.mData.a(getHorseRaceLampListResIdl.data);
                }
            }
        }
    }
}
