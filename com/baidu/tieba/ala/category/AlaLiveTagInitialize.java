package com.baidu.tieba.ala.category;

import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveTagActivityConfig;
/* loaded from: classes11.dex */
public class AlaLiveTagInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(AlaLiveTagActivityConfig.class, AlaLiveTagActivity.class);
    }
}
