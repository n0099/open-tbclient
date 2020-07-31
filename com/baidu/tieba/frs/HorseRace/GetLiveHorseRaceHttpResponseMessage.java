package com.baidu.tieba.frs.HorseRace;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetHorseRaceLampList.GetHorseRaceLampListResIdl;
/* loaded from: classes16.dex */
public class GetLiveHorseRaceHttpResponseMessage extends TbHttpResponsedMessage {
    private a mData;

    public GetLiveHorseRaceHttpResponseMessage() {
        super(CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST);
        this.mData = new a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        super.decodeInBackGround(i, bArr);
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

    public a getData() {
        return this.mData;
    }
}
