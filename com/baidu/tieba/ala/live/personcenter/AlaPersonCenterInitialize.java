package com.baidu.tieba.ala.live.personcenter;

import com.baidu.live.b.c;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.live.personcenter.admin.AlaAdminListActivity;
import com.baidu.tieba.ala.live.personcenter.exp.AlaPersonCenterExpActivity;
import com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity;
import com.baidu.tieba.ala.live.personcenter.fans.e;
import com.baidu.tieba.ala.live.personcenter.forbidden.AlaForbiddenListActivity;
import com.baidu.tieba.ala.live.personcenter.guardian.AlaGuardianListActivity;
import com.baidu.tieba.ala.live.personcenter.guardian.b;
/* loaded from: classes6.dex */
public class AlaPersonCenterInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(com.baidu.live.b.a.class, AlaAdminListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(com.baidu.tieba.ala.live.personcenter.exp.a.class, AlaPersonCenterExpActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(c.class, AlaForbiddenListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(b.class, AlaGuardianListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(com.baidu.tieba.ala.live.personcenter.exp.a.class, AlaPersonCenterExpActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(e.class, PersonListActivity.class);
    }
}
