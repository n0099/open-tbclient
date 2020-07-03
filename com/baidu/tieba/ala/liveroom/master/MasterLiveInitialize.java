package com.baidu.tieba.ala.liveroom.master;

import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaMasterLiveRoomActivityConfig;
/* loaded from: classes3.dex */
public class MasterLiveInitialize {
    static {
        bHv();
    }

    private static void bHv() {
        TbadkCoreApplication.getInst().RegisterIntent(AlaMasterLiveRoomActivityConfig.class, AlaMasterLiveRoomActivity.class);
    }
}
