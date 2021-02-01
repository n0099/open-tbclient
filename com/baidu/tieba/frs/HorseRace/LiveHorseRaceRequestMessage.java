package com.baidu.tieba.frs.HorseRace;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.v;
import tbclient.CommonReq;
import tbclient.GetHorseRaceLampList.DataReq;
import tbclient.GetHorseRaceLampList.GetHorseRaceLampListReqIdl;
/* loaded from: classes2.dex */
public class LiveHorseRaceRequestMessage extends NetMessage {

    /* renamed from: common  reason: collision with root package name */
    private CommonReq f5333common;
    private Long forum_id;

    public LiveHorseRaceRequestMessage() {
        super(CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST, 309667);
    }

    public void setCommon(CommonReq commonReq) {
        this.f5333common = commonReq;
    }

    public void setForum_id(Long l) {
        this.forum_id = l;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.f14534common = this.f5333common;
        builder.forum_id = this.forum_id;
        if (z) {
            v.b(builder, true);
        }
        GetHorseRaceLampListReqIdl.Builder builder2 = new GetHorseRaceLampListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
