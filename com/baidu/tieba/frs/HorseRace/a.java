package com.baidu.tieba.frs.HorseRace;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetHorseRaceLampList.DataRes;
import tbclient.GetHorseRaceLampList.LiveList;
/* loaded from: classes21.dex */
public class a {
    private LiveHorseRaceData ieK;
    private List<LiveHorseRaceData> ieL = new ArrayList();

    public List<LiveHorseRaceData> crr() {
        return this.ieL;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.ieK = new LiveHorseRaceData();
            List<LiveList> list = dataRes.live_list;
            if (list != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < list.size()) {
                        LiveHorseRaceData liveHorseRaceData = new LiveHorseRaceData();
                        liveHorseRaceData.parserProtobuf(list.get(i2));
                        this.ieL.add(liveHorseRaceData);
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
