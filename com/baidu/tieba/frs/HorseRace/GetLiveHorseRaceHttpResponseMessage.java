package com.baidu.tieba.frs.HorseRace;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import d.a.o0.r0.l0.a;
import tbclient.Error;
import tbclient.GetHorseRaceLampList.GetHorseRaceLampListResIdl;
/* loaded from: classes4.dex */
public class GetLiveHorseRaceHttpResponseMessage extends TbHttpResponsedMessage {
    public a mData;

    public GetLiveHorseRaceHttpResponseMessage() {
        super(CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST);
        this.mData = new a();
    }

    public a getData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetHorseRaceLampListResIdl getHorseRaceLampListResIdl;
        Error error;
        super.decodeInBackGround(i2, bArr);
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
