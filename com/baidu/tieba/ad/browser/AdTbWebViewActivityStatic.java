package com.baidu.tieba.ad.browser;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AdTbWebViewActivityConfig;
/* loaded from: classes3.dex */
public class AdTbWebViewActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(AdTbWebViewActivityConfig.class, AdTbWebViewActivity.class);
    }
}
