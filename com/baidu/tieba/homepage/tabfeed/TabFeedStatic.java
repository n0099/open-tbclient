package com.baidu.tieba.homepage.tabfeed;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HomePageTabFeedCollegeSecondActivityConfig;
import com.baidu.tieba.homepage.tabfeed.college.HomePageTabFeedCollegeSecondActivity;
/* loaded from: classes16.dex */
public class TabFeedStatic {
    public static String Tag = "tag";

    static {
        TbadkCoreApplication.getInst().RegisterIntent(HomePageTabFeedCollegeSecondActivityConfig.class, HomePageTabFeedCollegeSecondActivity.class);
    }
}
