package com.baidu.tieba.ala.liveroom.master;

import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaMasterLiveRoomActivityConfig;
/* loaded from: classes3.dex */
public class MasterLiveInitialize {
    static {
        bEn();
    }

    private static void bEn() {
        TbadkCoreApplication.getInst().RegisterIntent(AlaMasterLiveRoomActivityConfig.class, AlaMasterLiveRoomActivity.class);
    }
}
