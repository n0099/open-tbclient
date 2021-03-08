package com.baidu.tieba.ala;

import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes10.dex */
public class AlaFeedBackInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(com.baidu.live.d.g.class, AlaFeedBackReasonActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(com.baidu.live.d.h.class, AlaFeedBackEditActivity.class);
    }
}
