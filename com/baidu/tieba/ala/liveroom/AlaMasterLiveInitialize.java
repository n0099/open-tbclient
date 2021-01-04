package com.baidu.tieba.ala.liveroom;

import com.baidu.live.liveroom.e.i;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaMasterLiveRoomActivityConfig;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity;
/* loaded from: classes11.dex */
public class AlaMasterLiveInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(AlaMasterLiveRoomActivityConfig.class, AlaMasterLiveRoomActivity.class);
        i.Pq().b(new com.baidu.tieba.ala.liveroom.s.a());
    }
}
