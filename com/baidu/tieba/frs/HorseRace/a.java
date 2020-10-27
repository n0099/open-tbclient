package com.baidu.tieba.frs.HorseRace;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetHorseRaceLampList.DataRes;
import tbclient.GetHorseRaceLampList.LiveList;
/* loaded from: classes22.dex */
public class a {
    private LiveHorseRaceData iGd;
    private List<LiveHorseRaceData> iGe = new ArrayList();

    public List<LiveHorseRaceData> cxW() {
        return this.iGe;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iGd = new LiveHorseRaceData();
            List<LiveList> list = dataRes.live_list;
            if (list != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < list.size()) {
                        LiveHorseRaceData liveHorseRaceData = new LiveHorseRaceData();
                        liveHorseRaceData.parserProtobuf(list.get(i2));
                        this.iGe.add(liveHorseRaceData);
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
