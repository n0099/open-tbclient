package com.baidu.tieba.frs.gameshare;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GameShareActivityConfig;
/* loaded from: classes3.dex */
public class Static {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(GameShareActivityConfig.class, GameShareCardActivity.class);
    }
}
