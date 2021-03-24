package com.baidu.tieba.barselect;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CandidateSearchActivityConfig;
/* loaded from: classes4.dex */
public class BazhuSelectStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(CandidateSearchActivityConfig.class, CandidateSearchActivity.class);
    }
}
