package com.baidu.tieba.ala.live;

import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.PayWalletActivityConfig;
import com.baidu.live.tbadk.core.atomdata.PayWalletActivityOpaqueConfig;
/* loaded from: classes6.dex */
public class AlaSdkWalletInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(PayWalletActivityConfig.class, AlaSdkWalletActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(PayWalletActivityOpaqueConfig.class, AlaSdkWalletOpaqueActivity.class);
    }
}
