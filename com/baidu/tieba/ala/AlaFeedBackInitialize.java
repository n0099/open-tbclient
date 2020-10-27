package com.baidu.tieba.ala;

import com.baidu.live.b.h;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class AlaFeedBackInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(com.baidu.live.b.g.class, AlaFeedBackReasonActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(h.class, AlaFeedBackEditActivity.class);
    }
}
