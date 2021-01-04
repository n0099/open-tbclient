package com.baidu.tieba.ala.category;

import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveCategoryActivityConfig;
/* loaded from: classes11.dex */
public class AlaLiveCategoryInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(AlaLiveCategoryActivityConfig.class, AlaLiveCategoryActivity.class);
    }
}
