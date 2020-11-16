package com.baidu.tieba.hottopicselect;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
/* loaded from: classes20.dex */
public class HotTopicSelectActivityStatic {
    public static String Tag = "tag";

    static {
        TbadkCoreApplication.getInst().RegisterIntent(HotSelectActivityConfig.class, HotTopicSelectActivity.class);
    }
}
