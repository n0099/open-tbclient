package com.baidu.tieba.frs.HorseRace;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.n0.z0.w;
import tbclient.CommonReq;
import tbclient.GetHorseRaceLampList.DataReq;
import tbclient.GetHorseRaceLampList.GetHorseRaceLampListReqIdl;
/* loaded from: classes4.dex */
public class LiveHorseRaceRequestMessage extends NetMessage {

    /* renamed from: common  reason: collision with root package name */
    public CommonReq f15311common;
    public Long forum_id;

    public LiveHorseRaceRequestMessage() {
        super(CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST, 309667);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.f72777common = this.f15311common;
        builder.forum_id = this.forum_id;
        if (z) {
            w.a(builder, true);
        }
        GetHorseRaceLampListReqIdl.Builder builder2 = new GetHorseRaceLampListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setCommon(CommonReq commonReq) {
        this.f15311common = commonReq;
    }

    public void setForum_id(Long l) {
        this.forum_id = l;
    }
}
