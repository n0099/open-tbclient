package com.baidu.tieba.ala.liveroom;

import com.baidu.live.liveroom.e.h;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaMasterLiveRoomActivityConfig;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity;
/* loaded from: classes7.dex */
public class AlaMasterLiveInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(AlaMasterLiveRoomActivityConfig.class, AlaMasterLiveRoomActivity.class);
        h.Lr().b(new com.baidu.tieba.ala.liveroom.s.a());
    }
}
