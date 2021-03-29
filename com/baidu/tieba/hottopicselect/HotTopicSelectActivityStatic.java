package com.baidu.tieba.hottopicselect;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
/* loaded from: classes3.dex */
public class HotTopicSelectActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(HotSelectActivityConfig.class, HotTopicSelectActivity.class);
    }
}
