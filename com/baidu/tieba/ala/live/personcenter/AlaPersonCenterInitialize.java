package com.baidu.tieba.ala.live.personcenter;

import com.baidu.live.c.e;
import com.baidu.live.c.i;
import com.baidu.live.c.m;
import com.baidu.live.c.s;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.live.personcenter.admin.AlaAdminListActivity;
import com.baidu.tieba.ala.live.personcenter.exp.AlaPersonCenterExpActivity;
import com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity;
import com.baidu.tieba.ala.live.personcenter.forbidden.AlaForbiddenListActivity;
import com.baidu.tieba.ala.live.personcenter.guardian.AlaGuardianListActivity;
/* loaded from: classes2.dex */
public class AlaPersonCenterInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(com.baidu.live.c.a.class, AlaAdminListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(m.class, AlaPersonCenterExpActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(e.class, AlaForbiddenListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(i.class, AlaGuardianListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(s.class, PersonListActivity.class);
    }
}
