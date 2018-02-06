package com.baidu.tieba.forumMember.bawu;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class BawuTeamInfoStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(BawuTeamInfoActivityConfig.class, BawuTeamInfoActivity.class);
    }
}
