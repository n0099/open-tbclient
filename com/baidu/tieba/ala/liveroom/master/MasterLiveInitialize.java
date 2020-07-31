package com.baidu.tieba.ala.liveroom.master;

import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaMasterLiveRoomActivityConfig;
/* loaded from: classes4.dex */
public class MasterLiveInitialize {
    static {
        bKC();
    }

    private static void bKC() {
        TbadkCoreApplication.getInst().RegisterIntent(AlaMasterLiveRoomActivityConfig.class, AlaMasterLiveRoomActivity.class);
    }
}
