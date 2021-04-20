package com.baidu.tieba.homepage.tabfeed;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HomePageTabFeedCollegeSecondActivityConfig;
import com.baidu.tieba.homepage.tabfeed.college.HomePageTabFeedCollegeSecondActivity;
/* loaded from: classes4.dex */
public class TabFeedStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(HomePageTabFeedCollegeSecondActivityConfig.class, HomePageTabFeedCollegeSecondActivity.class);
    }
}
