package com.baidu.tieba.ala;

import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class AlaFeedBackInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(com.baidu.live.b.f.class, AlaFeedBackReasonActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(com.baidu.live.b.g.class, AlaFeedBackEditActivity.class);
    }
}
